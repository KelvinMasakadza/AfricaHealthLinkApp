package com.africahealthlinkapp.e_treat.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.africahealthlinkapp.e_treat.MainActivity;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorInfoBinding;
import com.africahealthlinkapp.e_treat.models.Doctor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class DoctorInfoActivity extends AppCompatActivity {

    private static final int UPLOAD_CV = 1;
    private static final int UPLOAD_DOCS = 2;
    EditText department, qualification, specialization, education, cV, nationalId, academicDocs;
    Button createAccountBtn;
    ProgressBar progressBar;
    ActivityDoctorInfoBinding bindingUtil;

    final HashMap<String, String> urls = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_doctor_info);
        bindingUtil.setActivity(this);


        cV = findViewById(R.id.cv_file);
        academicDocs = findViewById(R.id.academic_file);
        
        createAccountBtn = findViewById(R.id.create_account_button);
        progressBar = findViewById(R.id.account_progress);


        cV.setOnTouchListener((view, motionEvent) -> {
                openFileChooser("Upload CV (Format in PDF)", UPLOAD_CV);
                return true;
        });

        academicDocs.setOnTouchListener((view, motionEvent) -> {
            openFileChooser("Upload Academic Document (Format in PDF)", UPLOAD_DOCS);
            return true;
        });

    }

    private void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
        createAccountBtn.setVisibility(View.INVISIBLE);
    }
    private void hideDialog() {
        progressBar.setVisibility(View.INVISIBLE);
        createAccountBtn.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == UPLOAD_CV && resultCode == RESULT_OK && data.getData() != null){
            uploadPDF("CV", data.getData());
        }
        else if(requestCode == UPLOAD_DOCS && resultCode == RESULT_OK && data.getData() != null){
            uploadPDF("DOCS", data.getData());
        }
    }

    private void uploadPDF(String type, Uri data) {

        final ProgressDialog dialog =  new ProgressDialog(this);
        dialog.setTitle("File Uploading");
        dialog.show();

        String userId = FirebaseAuth.getInstance().getUid();

        StorageReference reference = FirebaseStorage.getInstance().getReference("uploads");
        reference.child(type+"_"+userId+"_"+System.currentTimeMillis()+".pdf")
                .putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                        while(!task.isComplete());
                        Uri uri = task.getResult();

                        urls.put(type, uri.toString());
                        dialog.dismiss();
                        if(type.equals("CV")){
                            cV.setText(type + " document has been uploaded");
                        }
                        else if(type.equals("DOCS")){
                            academicDocs.setText(type + " document has been uploaded");
                        }


                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                double progress = (100.0 * snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                dialog.setMessage("File uploading..."+(int) progress+"%");
            }
        });


    }


    private void openFileChooser(String message, int requestCode){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, message), requestCode);


    }

    public void createDoctorAccount(String department, String qualification, String specialization, String education, String nationalId) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(auth.getUid() == null){
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        }
        else if( department.isEmpty()  && qualification.isEmpty()
                && specialization.isEmpty()
                && isEmpty(cV.getText().toString())
                && education.isEmpty()
                && nationalId.isEmpty()
                && isEmpty(academicDocs.getText().toString())
        ){
            Snackbar.make(getWindow().getDecorView(), "Please make sure you have filled all the inputs correctly!", Snackbar.LENGTH_SHORT).show();
        }
        else{
            showDialog();
            Doctor doctor = new Doctor(department, qualification, specialization, education, urls.get("CV"), nationalId, urls.get("DOCS"));
            FirebaseDatabase.getInstance().getReference()
                    .child(getString(R.string.doctor_node))
                    .child(FirebaseAuth.getInstance().getUid())
                    .setValue(doctor)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(DoctorInfoActivity.this, "Account was successfully created!", Toast.LENGTH_SHORT).show();
                            hideDialog();
                            openMainActivity();
                            //clearFields();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(DoctorInfoActivity.this, "Something went wrong. Try again!", Toast.LENGTH_SHORT).show();
                    hideDialog();
                }
            });
        }
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private boolean isEmpty(String string){
        return string.equals("");
    }


}
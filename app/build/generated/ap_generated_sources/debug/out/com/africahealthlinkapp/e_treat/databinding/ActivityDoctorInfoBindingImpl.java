package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDoctorInfoBindingImpl extends ActivityDoctorInfoBinding implements com.africahealthlinkapp.e_treat.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.dept_text, 2);
        sViewsWithIds.put(R.id.specialization_text, 3);
        sViewsWithIds.put(R.id.education_text, 4);
        sViewsWithIds.put(R.id.cv_file, 5);
        sViewsWithIds.put(R.id.academic_file, 6);
        sViewsWithIds.put(R.id.imageView, 7);
        sViewsWithIds.put(R.id.national_id_text, 8);
        sViewsWithIds.put(R.id.qualification_text, 9);
        sViewsWithIds.put(R.id.guideline, 10);
        sViewsWithIds.put(R.id.imageView3, 11);
        sViewsWithIds.put(R.id.imageView4, 12);
        sViewsWithIds.put(R.id.imageView5, 13);
        sViewsWithIds.put(R.id.imageView6, 14);
        sViewsWithIds.put(R.id.imageView1, 15);
        sViewsWithIds.put(R.id.imageView8, 16);
        sViewsWithIds.put(R.id.account_progress, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDoctorInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityDoctorInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[6]
            , (android.widget.ProgressBar) bindings[17]
            , (android.widget.Button) bindings[1]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[3]
            );
        this.createAccountButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.activity == variableId) {
            setActivity((com.africahealthlinkapp.e_treat.ui.DoctorInfoActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.africahealthlinkapp.e_treat.ui.DoctorInfoActivity Activity) {
        this.mActivity = Activity;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.activity);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.africahealthlinkapp.e_treat.ui.DoctorInfoActivity activity = mActivity;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.createAccountButton.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // activity != null
        boolean activityJavaLangObjectNull = false;
        // nationalIdText.getText().toString
        java.lang.String nationalIdTextGetTextToString = null;
        // activity
        com.africahealthlinkapp.e_treat.ui.DoctorInfoActivity activity = mActivity;



        activityJavaLangObjectNull = (activity) != (null);
        if (activityJavaLangObjectNull) {


            if ((deptText) != (null)) {


                deptText.getText();
                if ((deptText.getText()) != (null)) {


                    deptText.getText().toString();

                    if ((qualificationText) != (null)) {


                        qualificationText.getText();
                        if ((qualificationText.getText()) != (null)) {


                            qualificationText.getText().toString();

                            if ((specializationText) != (null)) {


                                specializationText.getText();
                                if ((specializationText.getText()) != (null)) {


                                    specializationText.getText().toString();

                                    if ((educationText) != (null)) {


                                        educationText.getText();
                                        if ((educationText.getText()) != (null)) {


                                            educationText.getText().toString();

                                            if ((nationalIdText) != (null)) {


                                                nationalIdText.getText();
                                                if ((nationalIdText.getText()) != (null)) {


                                                    nationalIdTextGetTextToString = nationalIdText.getText().toString();

                                                    activity.createDoctorAccount(deptText.getText().toString(), qualificationText.getText().toString(), specializationText.getText().toString(), educationText.getText().toString(), nationalIdTextGetTextToString);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): activity
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
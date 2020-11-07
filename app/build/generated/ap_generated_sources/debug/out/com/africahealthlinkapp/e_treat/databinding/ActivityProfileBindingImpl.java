package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileBindingImpl extends ActivityProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.docs_name, 5);
        sViewsWithIds.put(R.id.docs_phone, 6);
        sViewsWithIds.put(R.id.docs_email, 7);
        sViewsWithIds.put(R.id.nameLayout, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.RelativeLayout) bindings[6]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.docsProfilePic.setTag(null);
        this.emailTv.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nameTv.setTag(null);
        this.phoneTv.setTag(null);
        setRootTag(root);
        // listeners
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
        if (BR.patient == variableId) {
            setPatient((com.africahealthlinkapp.e_treat.models.Patients) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPatient(@Nullable com.africahealthlinkapp.e_treat.models.Patients Patient) {
        this.mPatient = Patient;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.patient);
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
        java.lang.String patientEmail = null;
        java.lang.String patientPhone = null;
        java.lang.String patientName = null;
        java.lang.String patientProfilePics = null;
        com.africahealthlinkapp.e_treat.models.Patients patient = mPatient;

        if ((dirtyFlags & 0x3L) != 0) {



                if (patient != null) {
                    // read patient.email
                    patientEmail = patient.getEmail();
                    // read patient.phone
                    patientPhone = patient.getPhone();
                    // read patient.name
                    patientName = patient.getName();
                    // read patient.profile_pics
                    patientProfilePics = patient.getProfile_pics();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.africahealthlinkapp.e_treat.models.Doctors.loadImage(this.docsProfilePic, patientProfilePics);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.emailTv, patientEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameTv, patientName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.phoneTv, patientPhone);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): patient
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
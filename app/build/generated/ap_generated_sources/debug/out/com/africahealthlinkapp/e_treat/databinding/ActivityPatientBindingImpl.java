package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPatientBindingImpl extends ActivityPatientBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.card_job, 3);
        sViewsWithIds.put(R.id.patient_name, 4);
        sViewsWithIds.put(R.id.patient_phone, 5);
        sViewsWithIds.put(R.id.decline, 6);
        sViewsWithIds.put(R.id.accept, 7);
        sViewsWithIds.put(R.id.bottomNav, 8);
        sViewsWithIds.put(R.id.bottom_navigation, 9);
        sViewsWithIds.put(R.id.historyRecycler, 10);
        sViewsWithIds.put(R.id.historyPB, 11);
        sViewsWithIds.put(R.id.noHistory, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPatientBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityPatientBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[8]
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ProgressBar) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.patientImage.setTag(null);
        this.patientLocation.setTag(null);
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
        if (BR.patients == variableId) {
            setPatients((com.africahealthlinkapp.e_treat.models.Patients) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPatients(@Nullable com.africahealthlinkapp.e_treat.models.Patients Patients) {
        this.mPatients = Patients;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.patients);
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
        java.lang.String patientsLocation = null;
        com.africahealthlinkapp.e_treat.models.Patients patients = mPatients;
        java.lang.String patientsProfilePics = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (patients != null) {
                    // read patients.location
                    patientsLocation = patients.getLocation();
                    // read patients.profile_pics
                    patientsProfilePics = patients.getProfile_pics();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.africahealthlinkapp.e_treat.models.Doctors.loadImage(this.patientImage, patientsProfilePics);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.patientLocation, patientsLocation);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): patients
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
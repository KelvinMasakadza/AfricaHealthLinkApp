package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDoctorProfileBindingImpl extends ActivityDoctorProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar, 8);
        sViewsWithIds.put(R.id.toolbar_layout, 9);
        sViewsWithIds.put(R.id.coverImage, 10);
        sViewsWithIds.put(R.id.button, 11);
        sViewsWithIds.put(R.id.docCourse, 12);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDoctorProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityDoctorProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[5]
            , (com.google.android.material.appbar.AppBarLayout) bindings[8]
            , (android.widget.Button) bindings[11]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[9]
            );
        this.aboutDoctor.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.profileCourseYear.setTag(null);
        this.profileDocCourse.setTag(null);
        this.profileDocHospital.setTag(null);
        this.profileDocImage.setTag(null);
        this.profileDocName.setTag(null);
        this.profileUniversity.setTag(null);
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
        if (BR.doctors == variableId) {
            setDoctors((com.africahealthlinkapp.e_treat.models.Doctors) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDoctors(@Nullable com.africahealthlinkapp.e_treat.models.Doctors Doctors) {
        this.mDoctors = Doctors;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.doctors);
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
        java.lang.String doctorsDepartment = null;
        java.lang.String doctorsProfilePics = null;
        com.africahealthlinkapp.e_treat.models.Doctors doctors = mDoctors;
        java.lang.String doctorsName = null;
        java.lang.String doctorsHospital = null;
        java.lang.String doctorsUniversity = null;
        java.lang.String doctorsAbout = null;
        java.lang.String doctorsYear = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (doctors != null) {
                    // read doctors.department
                    doctorsDepartment = doctors.getDepartment();
                    // read doctors.profile_pics
                    doctorsProfilePics = doctors.getProfile_pics();
                    // read doctors.name
                    doctorsName = doctors.getName();
                    // read doctors.hospital
                    doctorsHospital = doctors.getHospital();
                    // read doctors.university
                    doctorsUniversity = doctors.getUniversity();
                    // read doctors.about
                    doctorsAbout = doctors.getAbout();
                    // read doctors.year
                    doctorsYear = doctors.getYear();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.aboutDoctor, doctorsAbout);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileCourseYear, doctorsYear);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileDocCourse, doctorsDepartment);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileDocHospital, doctorsHospital);
            com.africahealthlinkapp.e_treat.models.Patients.loadImage(this.profileDocImage, doctorsProfilePics);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileDocName, doctorsName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileUniversity, doctorsUniversity);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): doctors
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
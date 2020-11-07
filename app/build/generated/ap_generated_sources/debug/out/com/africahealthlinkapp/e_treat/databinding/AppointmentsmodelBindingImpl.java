package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AppointmentsmodelBindingImpl extends AppointmentsmodelBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AppointmentsmodelBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private AppointmentsmodelBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
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
        if (BR.appointment == variableId) {
            setAppointment((com.africahealthlinkapp.e_treat.models.Appointment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAppointment(@Nullable com.africahealthlinkapp.e_treat.models.Appointment Appointment) {
        this.mAppointment = Appointment;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.appointment);
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
        com.africahealthlinkapp.e_treat.models.Appointment appointment = mAppointment;
        java.lang.String appointmentPatientPhone = null;
        java.lang.String appointmentProfilePics = null;
        java.lang.String appointmentPatientName = null;
        java.lang.String appointmentPatientLocation = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (appointment != null) {
                    // read appointment.patientPhone
                    appointmentPatientPhone = appointment.getPatientPhone();
                    // read appointment.profile_pics
                    appointmentProfilePics = appointment.getProfile_pics();
                    // read appointment.patientName
                    appointmentPatientName = appointment.getPatientName();
                    // read appointment.patientLocation
                    appointmentPatientLocation = appointment.getPatientLocation();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.africahealthlinkapp.e_treat.models.Patients.loadImage(this.mboundView1, appointmentProfilePics);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, appointmentPatientName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, appointmentPatientPhone);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, appointmentPatientLocation);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): appointment
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
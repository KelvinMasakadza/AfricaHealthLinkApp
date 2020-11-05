package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignUpBindingImpl extends ActivitySignUpBinding implements com.africahealthlinkapp.e_treat.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView2, 5);
        sViewsWithIds.put(R.id.first_name_text, 6);
        sViewsWithIds.put(R.id.email_text, 7);
        sViewsWithIds.put(R.id.password_text, 8);
        sViewsWithIds.put(R.id.confirm_password_text, 9);
        sViewsWithIds.put(R.id.last_name_text, 10);
        sViewsWithIds.put(R.id.guideline, 11);
        sViewsWithIds.put(R.id.imageView3, 12);
        sViewsWithIds.put(R.id.imageView4, 13);
        sViewsWithIds.put(R.id.imageView5, 14);
        sViewsWithIds.put(R.id.imageView6, 15);
        sViewsWithIds.put(R.id.imageView1, 16);
        sViewsWithIds.put(R.id.textView3, 17);
        sViewsWithIds.put(R.id.linkedIn_button, 18);
        sViewsWithIds.put(R.id.progress_bar, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivitySignUpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[7]
            , (android.widget.ImageButton) bindings[3]
            , (android.widget.EditText) bindings[6]
            , (android.widget.ImageButton) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[11]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.EditText) bindings[10]
            , (android.widget.ImageButton) bindings[18]
            , (android.widget.EditText) bindings[8]
            , (android.widget.ProgressBar) bindings[19]
            , (android.widget.TextView) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.TextView) bindings[17]
            );
        this.facebookButton.setTag(null);
        this.googleButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.signInView.setTag(null);
        this.signUpButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 3);
        mCallback2 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 1);
        mCallback5 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 4);
        mCallback3 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 2);
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
            setActivity((com.africahealthlinkapp.e_treat.ui.SignUpActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.africahealthlinkapp.e_treat.ui.SignUpActivity Activity) {
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
        com.africahealthlinkapp.e_treat.ui.SignUpActivity activity = mActivity;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.facebookButton.setOnClickListener(mCallback4);
            this.googleButton.setOnClickListener(mCallback5);
            this.signInView.setOnClickListener(mCallback2);
            this.signUpButton.setOnClickListener(mCallback3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.africahealthlinkapp.e_treat.ui.SignUpActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.startFacebookSignUp();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.africahealthlinkapp.e_treat.ui.SignUpActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openLoginScreen();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.africahealthlinkapp.e_treat.ui.SignUpActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.startGoogleSignUp();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.africahealthlinkapp.e_treat.ui.SignUpActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    if ((firstNameText) != (null)) {


                        firstNameText.getText();
                        if ((firstNameText.getText()) != (null)) {


                            firstNameText.getText().toString();

                            if ((lastNameText) != (null)) {


                                lastNameText.getText();
                                if ((lastNameText.getText()) != (null)) {


                                    lastNameText.getText().toString();

                                    if ((emailText) != (null)) {


                                        emailText.getText();
                                        if ((emailText.getText()) != (null)) {


                                            emailText.getText().toString();

                                            if ((passwordText) != (null)) {


                                                passwordText.getText();
                                                if ((passwordText.getText()) != (null)) {


                                                    passwordText.getText().toString();

                                                    if ((confirmPasswordText) != (null)) {


                                                        confirmPasswordText.getText();
                                                        if ((confirmPasswordText.getText()) != (null)) {


                                                            confirmPasswordText.getText().toString();

                                                            activity.registerNewUserAccount(firstNameText.getText().toString(), lastNameText.getText().toString(), emailText.getText().toString(), passwordText.getText().toString(), confirmPasswordText.getText().toString());
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
                break;
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
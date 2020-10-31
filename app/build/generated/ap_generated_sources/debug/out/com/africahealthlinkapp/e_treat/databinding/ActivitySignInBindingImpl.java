package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import com.africahealthlinkapp.e_treat.ui.SignInActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignInBindingImpl extends ActivitySignInBinding implements com.africahealthlinkapp.e_treat.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView10, 5);
        sViewsWithIds.put(R.id.guideline3, 6);
        sViewsWithIds.put(R.id.user_email_text, 7);
        sViewsWithIds.put(R.id.imageView11, 8);
        sViewsWithIds.put(R.id.user_password_text, 9);
        sViewsWithIds.put(R.id.checkBox, 10);
        sViewsWithIds.put(R.id.textView2, 11);
        sViewsWithIds.put(R.id.imageButton2, 12);
        sViewsWithIds.put(R.id.textView, 13);
        sViewsWithIds.put(R.id.load_progress_bar, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignInBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivitySignInBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.CheckBox) bindings[10]
            , (android.widget.ImageButton) bindings[3]
            , (android.widget.ImageButton) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (android.widget.ImageButton) bindings[12]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ProgressBar) bindings[14]
            , (android.widget.Button) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[11]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[9]
            );
        this.facebookSignIn.setTag(null);
        this.googleSignIn.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.signInButton.setTag(null);
        this.signUpView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 4);
        mCallback3 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 2);
        mCallback4 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 3);
        mCallback2 = new com.africahealthlinkapp.e_treat.generated.callback.OnClickListener(this, 1);
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
            setActivity((SignInActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable SignInActivity Activity) {
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
        SignInActivity activity = mActivity;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.facebookSignIn.setOnClickListener(mCallback4);
            this.googleSignIn.setOnClickListener(mCallback5);
            this.signInButton.setOnClickListener(mCallback2);
            this.signUpView.setOnClickListener(mCallback3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                SignInActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.startGoogleSignIn();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                SignInActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openSignUpScreen();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                SignInActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.startFacebookSignIn();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                SignInActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    if ((userEmailText) != (null)) {


                        userEmailText.getText();
                        if ((userEmailText.getText()) != (null)) {


                            userEmailText.getText().toString();

                            if ((userPasswordText) != (null)) {


                                userPasswordText.getText();
                                if ((userPasswordText.getText()) != (null)) {


                                    userPasswordText.getText().toString();

                                    activity.authenticateUser(userEmailText.getText().toString(), userPasswordText.getText().toString());
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
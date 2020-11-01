// Generated by data binding compiler. Do not edit!
package com.africahealthlinkapp.e_treat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.ui.SignUpActivity;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySignUpBinding extends ViewDataBinding {
  @NonNull
  public final EditText confirmPasswordText;

  @NonNull
  public final EditText emailText;

  @NonNull
  public final ImageButton facebookButton;

  @NonNull
  public final EditText firstNameText;

  @NonNull
  public final ImageButton googleButton;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ImageView imageView1;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final EditText lastNameText;

  @NonNull
  public final ImageButton linkedInButton;

  @NonNull
  public final EditText passwordText;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView signInView;

  @NonNull
  public final Button signUpButton;

  @NonNull
  public final TextView textView3;

  @Bindable
  protected SignUpActivity mActivity;

  protected ActivitySignUpBinding(Object _bindingComponent, View _root, int _localFieldCount,
      EditText confirmPasswordText, EditText emailText, ImageButton facebookButton,
      EditText firstNameText, ImageButton googleButton, Guideline guideline, ImageView imageView1,
      ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5,
      ImageView imageView6, EditText lastNameText, ImageButton linkedInButton,
      EditText passwordText, ProgressBar progressBar, TextView signInView, Button signUpButton,
      TextView textView3) {
    super(_bindingComponent, _root, _localFieldCount);
    this.confirmPasswordText = confirmPasswordText;
    this.emailText = emailText;
    this.facebookButton = facebookButton;
    this.firstNameText = firstNameText;
    this.googleButton = googleButton;
    this.guideline = guideline;
    this.imageView1 = imageView1;
    this.imageView2 = imageView2;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
    this.imageView5 = imageView5;
    this.imageView6 = imageView6;
    this.lastNameText = lastNameText;
    this.linkedInButton = linkedInButton;
    this.passwordText = passwordText;
    this.progressBar = progressBar;
    this.signInView = signInView;
    this.signUpButton = signUpButton;
    this.textView3 = textView3;
  }

  public abstract void setActivity(@Nullable SignUpActivity activity);

  @Nullable
  public SignUpActivity getActivity() {
    return mActivity;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sign_up, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySignUpBinding>inflateInternal(inflater, R.layout.activity_sign_up, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sign_up, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySignUpBinding>inflateInternal(inflater, R.layout.activity_sign_up, null, false, component);
  }

  public static ActivitySignUpBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivitySignUpBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySignUpBinding)bind(component, view, R.layout.activity_sign_up);
  }
}

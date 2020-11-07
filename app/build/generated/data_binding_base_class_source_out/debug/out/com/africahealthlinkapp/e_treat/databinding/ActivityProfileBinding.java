// Generated by data binding compiler. Do not edit!
package com.africahealthlinkapp.e_treat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.models.Patients;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityProfileBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout docsEmail;

  @NonNull
  public final RelativeLayout docsName;

  @NonNull
  public final RelativeLayout docsPhone;

  @NonNull
  public final CircleImageView docsProfilePic;

  @NonNull
  public final TextView emailTv;

  @NonNull
  public final LinearLayout nameLayout;

  @NonNull
  public final TextView nameTv;

  @NonNull
  public final TextView phoneTv;

  @Bindable
  protected Patients mPatient;

  protected ActivityProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout docsEmail, RelativeLayout docsName, RelativeLayout docsPhone,
      CircleImageView docsProfilePic, TextView emailTv, LinearLayout nameLayout, TextView nameTv,
      TextView phoneTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.docsEmail = docsEmail;
    this.docsName = docsName;
    this.docsPhone = docsPhone;
    this.docsProfilePic = docsProfilePic;
    this.emailTv = emailTv;
    this.nameLayout = nameLayout;
    this.nameTv = nameTv;
    this.phoneTv = phoneTv;
  }

  public abstract void setPatient(@Nullable Patients patient);

  @Nullable
  public Patients getPatient() {
    return mPatient;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityProfileBinding>inflateInternal(inflater, R.layout.activity_profile, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityProfileBinding>inflateInternal(inflater, R.layout.activity_profile, null, false, component);
  }

  public static ActivityProfileBinding bind(@NonNull View view) {
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
  public static ActivityProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityProfileBinding)bind(component, view, R.layout.activity_profile);
  }
}

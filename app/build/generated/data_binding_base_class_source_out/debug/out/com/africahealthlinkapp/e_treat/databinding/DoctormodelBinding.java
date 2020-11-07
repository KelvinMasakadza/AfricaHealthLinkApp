// Generated by data binding compiler. Do not edit!
package com.africahealthlinkapp.e_treat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.models.Doctors;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DoctormodelBinding extends ViewDataBinding {
  @Bindable
  protected Doctors mDoctors;

  protected DoctormodelBinding(Object _bindingComponent, View _root, int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setDoctors(@Nullable Doctors doctors);

  @Nullable
  public Doctors getDoctors() {
    return mDoctors;
  }

  @NonNull
  public static DoctormodelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.doctormodel, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DoctormodelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DoctormodelBinding>inflateInternal(inflater, R.layout.doctormodel, root, attachToRoot, component);
  }

  @NonNull
  public static DoctormodelBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.doctormodel, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DoctormodelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DoctormodelBinding>inflateInternal(inflater, R.layout.doctormodel, null, false, component);
  }

  public static DoctormodelBinding bind(@NonNull View view) {
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
  public static DoctormodelBinding bind(@NonNull View view, @Nullable Object component) {
    return (DoctormodelBinding)bind(component, view, R.layout.doctormodel);
  }
}

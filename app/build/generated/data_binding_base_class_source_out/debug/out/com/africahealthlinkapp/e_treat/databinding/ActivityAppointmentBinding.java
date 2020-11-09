// Generated by data binding compiler. Do not edit!
package com.africahealthlinkapp.e_treat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.africahealthlinkapp.e_treat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAppointmentBinding extends ViewDataBinding {
  @NonNull
  public final Button button2;

  @NonNull
  public final CalendarView calenda;

  @NonNull
  public final TextView confirmDate;

  @NonNull
  public final TextView date;

  @NonNull
  public final LinearLayout datelay;

  @NonNull
  public final TextView selecteTime;

  @NonNull
  public final TextView selectedDated;

  @NonNull
  public final TextView time;

  protected ActivityAppointmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button button2, CalendarView calenda, TextView confirmDate, TextView date,
      LinearLayout datelay, TextView selecteTime, TextView selectedDated, TextView time) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button2 = button2;
    this.calenda = calenda;
    this.confirmDate = confirmDate;
    this.date = date;
    this.datelay = datelay;
    this.selecteTime = selecteTime;
    this.selectedDated = selectedDated;
    this.time = time;
  }

  @NonNull
  public static ActivityAppointmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_appointment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAppointmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAppointmentBinding>inflateInternal(inflater, R.layout.activity_appointment, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAppointmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_appointment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAppointmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAppointmentBinding>inflateInternal(inflater, R.layout.activity_appointment, null, false, component);
  }

  public static ActivityAppointmentBinding bind(@NonNull View view) {
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
  public static ActivityAppointmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAppointmentBinding)bind(component, view, R.layout.activity_appointment);
  }
}
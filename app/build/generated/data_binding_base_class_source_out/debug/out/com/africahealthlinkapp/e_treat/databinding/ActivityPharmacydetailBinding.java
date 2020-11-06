// Generated by data binding compiler. Do not edit!
package com.africahealthlinkapp.e_treat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.africahealthlinkapp.e_treat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPharmacydetailBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardCardview;

  @NonNull
  public final Button countbtn;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final CardView mainPropertyPost;

  @NonNull
  public final TextView pharmarcyName;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textviewHours;

  protected ActivityPharmacydetailBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CardView cardCardview, Button countbtn, ImageView imageView,
      LinearLayout linearLayout, CardView mainPropertyPost, TextView pharmarcyName,
      RecyclerView recycler, TextView textView, TextView textviewHours) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardCardview = cardCardview;
    this.countbtn = countbtn;
    this.imageView = imageView;
    this.linearLayout = linearLayout;
    this.mainPropertyPost = mainPropertyPost;
    this.pharmarcyName = pharmarcyName;
    this.recycler = recycler;
    this.textView = textView;
    this.textviewHours = textviewHours;
  }

  @NonNull
  public static ActivityPharmacydetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_pharmacydetail, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPharmacydetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPharmacydetailBinding>inflateInternal(inflater, R.layout.activity_pharmacydetail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPharmacydetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_pharmacydetail, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPharmacydetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPharmacydetailBinding>inflateInternal(inflater, R.layout.activity_pharmacydetail, null, false, component);
  }

  public static ActivityPharmacydetailBinding bind(@NonNull View view) {
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
  public static ActivityPharmacydetailBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPharmacydetailBinding)bind(component, view, R.layout.activity_pharmacydetail);
  }
}
package com.africahealthlinkapp.e_treat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorInfoBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignInBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignUpBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYDOCTORINFO = 1;

  private static final int LAYOUT_ACTIVITYSIGNIN = 2;

  private static final int LAYOUT_ACTIVITYSIGNUP = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_doctor_info, LAYOUT_ACTIVITYDOCTORINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_sign_in, LAYOUT_ACTIVITYSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYDOCTORINFO: {
          if ("layout/activity_doctor_info_0".equals(tag)) {
            return new ActivityDoctorInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_doctor_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNIN: {
          if ("layout/activity_sign_in_0".equals(tag)) {
            return new ActivitySignInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_in is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_sign_up_0".equals(tag)) {
            return new ActivitySignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_up is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "activity");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_doctor_info_0", com.africahealthlinkapp.e_treat.R.layout.activity_doctor_info);
      sKeys.put("layout/activity_sign_in_0", com.africahealthlinkapp.e_treat.R.layout.activity_sign_in);
      sKeys.put("layout/activity_sign_up_0", com.africahealthlinkapp.e_treat.R.layout.activity_sign_up);
    }
  }
}

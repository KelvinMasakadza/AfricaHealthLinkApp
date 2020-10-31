package com.africahealthlinkapp.e_treat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
<<<<<<< HEAD
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorProfileBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityHomeBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySearchDoctorBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.DoctormodelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.DoctorsModelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.InfoModelBindingImpl;
=======
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorInfoBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignInBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignUpBindingImpl;
>>>>>>> f54e5b377284e194248d2785dc6a83a06025e86d
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
<<<<<<< HEAD
  private static final int LAYOUT_ACTIVITYDOCTOR = 1;

  private static final int LAYOUT_ACTIVITYDOCTORPROFILE = 2;

  private static final int LAYOUT_ACTIVITYHOME = 3;

  private static final int LAYOUT_ACTIVITYSEARCHDOCTOR = 4;

  private static final int LAYOUT_DOCTORMODEL = 5;

  private static final int LAYOUT_DOCTORSMODEL = 6;

  private static final int LAYOUT_INFOMODEL = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_doctor, LAYOUT_ACTIVITYDOCTOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_doctor_profile, LAYOUT_ACTIVITYDOCTORPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_search_doctor, LAYOUT_ACTIVITYSEARCHDOCTOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.doctormodel, LAYOUT_DOCTORMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.doctors_model, LAYOUT_DOCTORSMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.info_model, LAYOUT_INFOMODEL);
=======
  private static final int LAYOUT_ACTIVITYDOCTORINFO = 1;

  private static final int LAYOUT_ACTIVITYSIGNIN = 2;

  private static final int LAYOUT_ACTIVITYSIGNUP = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_doctor_info, LAYOUT_ACTIVITYDOCTORINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_sign_in, LAYOUT_ACTIVITYSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
>>>>>>> f54e5b377284e194248d2785dc6a83a06025e86d
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
<<<<<<< HEAD
        case  LAYOUT_ACTIVITYDOCTOR: {
          if ("layout/activity_doctor_0".equals(tag)) {
            return new ActivityDoctorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_doctor is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDOCTORPROFILE: {
          if ("layout/activity_doctor_profile_0".equals(tag)) {
            return new ActivityDoctorProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_doctor_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCHDOCTOR: {
          if ("layout/activity_search_doctor_0".equals(tag)) {
            return new ActivitySearchDoctorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search_doctor is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORMODEL: {
          if ("layout/doctormodel_0".equals(tag)) {
            return new DoctormodelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctormodel is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORSMODEL: {
          if ("layout/doctors_model_0".equals(tag)) {
            return new DoctorsModelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctors_model is invalid. Received: " + tag);
        }
        case  LAYOUT_INFOMODEL: {
          if ("layout/info_model_0".equals(tag)) {
            return new InfoModelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for info_model is invalid. Received: " + tag);
=======
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
>>>>>>> f54e5b377284e194248d2785dc6a83a06025e86d
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
<<<<<<< HEAD
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(1, "Doctors");
      sKeys.put(0, "_all");
      sKeys.put(2, "doctors");
      sKeys.put(3, "info");
=======
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "activity");
>>>>>>> f54e5b377284e194248d2785dc6a83a06025e86d
    }
  }

  private static class InnerLayoutIdLookup {
<<<<<<< HEAD
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_doctor_0", com.africahealthlinkapp.e_treat.R.layout.activity_doctor);
      sKeys.put("layout/activity_doctor_profile_0", com.africahealthlinkapp.e_treat.R.layout.activity_doctor_profile);
      sKeys.put("layout/activity_home_0", com.africahealthlinkapp.e_treat.R.layout.activity_home);
      sKeys.put("layout/activity_search_doctor_0", com.africahealthlinkapp.e_treat.R.layout.activity_search_doctor);
      sKeys.put("layout/doctormodel_0", com.africahealthlinkapp.e_treat.R.layout.doctormodel);
      sKeys.put("layout/doctors_model_0", com.africahealthlinkapp.e_treat.R.layout.doctors_model);
      sKeys.put("layout/info_model_0", com.africahealthlinkapp.e_treat.R.layout.info_model);
=======
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_doctor_info_0", com.africahealthlinkapp.e_treat.R.layout.activity_doctor_info);
      sKeys.put("layout/activity_sign_in_0", com.africahealthlinkapp.e_treat.R.layout.activity_sign_in);
      sKeys.put("layout/activity_sign_up_0", com.africahealthlinkapp.e_treat.R.layout.activity_sign_up);
>>>>>>> f54e5b377284e194248d2785dc6a83a06025e86d
    }
  }
}

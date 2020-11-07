package com.africahealthlinkapp.e_treat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.africahealthlinkapp.e_treat.databinding.ActivityAppointmentBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityCartBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorInfoBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorProfileBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityHistoryBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityHomeBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityPatientBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityPharmacydetailBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivityProfileBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySearchDoctorBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignInBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignUpBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.AppointmentsmodelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.CartBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.DoctormodelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.DoctorsModelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.DrugListItemBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.HistorymodelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.InfoModelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.PatientmodelBindingImpl;
import com.africahealthlinkapp.e_treat.databinding.ReachoutBindingImpl;
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
  private static final int LAYOUT_ACTIVITYAPPOINTMENT = 1;

  private static final int LAYOUT_ACTIVITYCART = 2;

  private static final int LAYOUT_ACTIVITYDOCTORINFO = 3;

  private static final int LAYOUT_ACTIVITYDOCTORPROFILE = 4;

  private static final int LAYOUT_ACTIVITYHISTORY = 5;

  private static final int LAYOUT_ACTIVITYHOME = 6;

  private static final int LAYOUT_ACTIVITYPATIENT = 7;

  private static final int LAYOUT_ACTIVITYPHARMACYDETAIL = 8;

  private static final int LAYOUT_ACTIVITYPROFILE = 9;

  private static final int LAYOUT_ACTIVITYSEARCHDOCTOR = 10;

  private static final int LAYOUT_ACTIVITYSIGNIN = 11;

  private static final int LAYOUT_ACTIVITYSIGNUP = 12;

  private static final int LAYOUT_APPOINTMENTSMODEL = 13;

  private static final int LAYOUT_CART = 14;

  private static final int LAYOUT_DOCTORMODEL = 15;

  private static final int LAYOUT_DOCTORSMODEL = 16;

  private static final int LAYOUT_DRUGLISTITEM = 17;

  private static final int LAYOUT_HISTORYMODEL = 18;

  private static final int LAYOUT_INFOMODEL = 19;

  private static final int LAYOUT_PATIENTMODEL = 20;

  private static final int LAYOUT_REACHOUT = 21;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(21);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_appointment, LAYOUT_ACTIVITYAPPOINTMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_cart, LAYOUT_ACTIVITYCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_doctor_info, LAYOUT_ACTIVITYDOCTORINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_doctor_profile, LAYOUT_ACTIVITYDOCTORPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_history, LAYOUT_ACTIVITYHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_patient, LAYOUT_ACTIVITYPATIENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_pharmacydetail, LAYOUT_ACTIVITYPHARMACYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_profile, LAYOUT_ACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_search_doctor, LAYOUT_ACTIVITYSEARCHDOCTOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_sign_in, LAYOUT_ACTIVITYSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.appointmentsmodel, LAYOUT_APPOINTMENTSMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.cart, LAYOUT_CART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.doctormodel, LAYOUT_DOCTORMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.doctors_model, LAYOUT_DOCTORSMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.drug_list_item, LAYOUT_DRUGLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.historymodel, LAYOUT_HISTORYMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.info_model, LAYOUT_INFOMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.patientmodel, LAYOUT_PATIENTMODEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.africahealthlinkapp.e_treat.R.layout.reachout, LAYOUT_REACHOUT);
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
        case  LAYOUT_ACTIVITYAPPOINTMENT: {
          if ("layout/activity_appointment_0".equals(tag)) {
            return new ActivityAppointmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_appointment is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCART: {
          if ("layout/activity_cart_0".equals(tag)) {
            return new ActivityCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDOCTORINFO: {
          if ("layout/activity_doctor_info_0".equals(tag)) {
            return new ActivityDoctorInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_doctor_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDOCTORPROFILE: {
          if ("layout/activity_doctor_profile_0".equals(tag)) {
            return new ActivityDoctorProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_doctor_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHISTORY: {
          if ("layout/activity_history_0".equals(tag)) {
            return new ActivityHistoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_history is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPATIENT: {
          if ("layout/activity_patient_0".equals(tag)) {
            return new ActivityPatientBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_patient is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPHARMACYDETAIL: {
          if ("layout/activity_pharmacydetail_0".equals(tag)) {
            return new ActivityPharmacydetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_pharmacydetail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPROFILE: {
          if ("layout/activity_profile_0".equals(tag)) {
            return new ActivityProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCHDOCTOR: {
          if ("layout/activity_search_doctor_0".equals(tag)) {
            return new ActivitySearchDoctorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search_doctor is invalid. Received: " + tag);
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
        case  LAYOUT_APPOINTMENTSMODEL: {
          if ("layout/appointmentsmodel_0".equals(tag)) {
            return new AppointmentsmodelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for appointmentsmodel is invalid. Received: " + tag);
        }
        case  LAYOUT_CART: {
          if ("layout/cart_0".equals(tag)) {
            return new CartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cart is invalid. Received: " + tag);
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
        case  LAYOUT_DRUGLISTITEM: {
          if ("layout/drug_list_item_0".equals(tag)) {
            return new DrugListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for drug_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_HISTORYMODEL: {
          if ("layout/historymodel_0".equals(tag)) {
            return new HistorymodelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for historymodel is invalid. Received: " + tag);
        }
        case  LAYOUT_INFOMODEL: {
          if ("layout/info_model_0".equals(tag)) {
            return new InfoModelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for info_model is invalid. Received: " + tag);
        }
        case  LAYOUT_PATIENTMODEL: {
          if ("layout/patientmodel_0".equals(tag)) {
            return new PatientmodelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for patientmodel is invalid. Received: " + tag);
        }
        case  LAYOUT_REACHOUT: {
          if ("layout/reachout_0".equals(tag)) {
            return new ReachoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for reachout is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(1, "Doctors");
      sKeys.put(0, "_all");
      sKeys.put(2, "activity");
      sKeys.put(3, "appointment");
      sKeys.put(4, "doctors");
      sKeys.put(5, "drugs");
      sKeys.put(6, "info");
      sKeys.put(7, "patient");
      sKeys.put(8, "patients");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(21);

    static {
      sKeys.put("layout/activity_appointment_0", com.africahealthlinkapp.e_treat.R.layout.activity_appointment);
      sKeys.put("layout/activity_cart_0", com.africahealthlinkapp.e_treat.R.layout.activity_cart);
      sKeys.put("layout/activity_doctor_info_0", com.africahealthlinkapp.e_treat.R.layout.activity_doctor_info);
      sKeys.put("layout/activity_doctor_profile_0", com.africahealthlinkapp.e_treat.R.layout.activity_doctor_profile);
      sKeys.put("layout/activity_history_0", com.africahealthlinkapp.e_treat.R.layout.activity_history);
      sKeys.put("layout/activity_home_0", com.africahealthlinkapp.e_treat.R.layout.activity_home);
      sKeys.put("layout/activity_patient_0", com.africahealthlinkapp.e_treat.R.layout.activity_patient);
      sKeys.put("layout/activity_pharmacydetail_0", com.africahealthlinkapp.e_treat.R.layout.activity_pharmacydetail);
      sKeys.put("layout/activity_profile_0", com.africahealthlinkapp.e_treat.R.layout.activity_profile);
      sKeys.put("layout/activity_search_doctor_0", com.africahealthlinkapp.e_treat.R.layout.activity_search_doctor);
      sKeys.put("layout/activity_sign_in_0", com.africahealthlinkapp.e_treat.R.layout.activity_sign_in);
      sKeys.put("layout/activity_sign_up_0", com.africahealthlinkapp.e_treat.R.layout.activity_sign_up);
      sKeys.put("layout/appointmentsmodel_0", com.africahealthlinkapp.e_treat.R.layout.appointmentsmodel);
      sKeys.put("layout/cart_0", com.africahealthlinkapp.e_treat.R.layout.cart);
      sKeys.put("layout/doctormodel_0", com.africahealthlinkapp.e_treat.R.layout.doctormodel);
      sKeys.put("layout/doctors_model_0", com.africahealthlinkapp.e_treat.R.layout.doctors_model);
      sKeys.put("layout/drug_list_item_0", com.africahealthlinkapp.e_treat.R.layout.drug_list_item);
      sKeys.put("layout/historymodel_0", com.africahealthlinkapp.e_treat.R.layout.historymodel);
      sKeys.put("layout/info_model_0", com.africahealthlinkapp.e_treat.R.layout.info_model);
      sKeys.put("layout/patientmodel_0", com.africahealthlinkapp.e_treat.R.layout.patientmodel);
      sKeys.put("layout/reachout_0", com.africahealthlinkapp.e_treat.R.layout.reachout);
    }
  }
}

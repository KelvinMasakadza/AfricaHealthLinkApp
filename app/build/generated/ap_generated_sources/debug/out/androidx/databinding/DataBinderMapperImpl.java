package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.africahealthlinkapp.e_treat.DataBinderMapperImpl());
  }
}

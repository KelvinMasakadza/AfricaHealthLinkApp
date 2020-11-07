package com.africahealthlinkapp.e_treat.databinding;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySearchDoctorBindingImpl extends ActivitySearchDoctorBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.card_doc, 1);
        sViewsWithIds.put(R.id.doc_pic, 2);
        sViewsWithIds.put(R.id.doc_name, 3);
        sViewsWithIds.put(R.id.docs_phone, 4);
        sViewsWithIds.put(R.id.closeInfo, 5);
        sViewsWithIds.put(R.id.call_doc, 6);
        sViewsWithIds.put(R.id.orderdocBtn, 7);
        sViewsWithIds.put(R.id.layoutDoctors, 8);
        sViewsWithIds.put(R.id.doctorSearch, 9);
        sViewsWithIds.put(R.id.doctorsList, 10);
        sViewsWithIds.put(R.id.docLoadingProgress, 11);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySearchDoctorBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivitySearchDoctorBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (android.widget.Button) bindings[5]
            , (android.widget.ProgressBar) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (androidx.appcompat.widget.SearchView) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (android.widget.LinearLayout) bindings[8]
            , (com.google.android.material.button.MaterialButton) bindings[7]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}
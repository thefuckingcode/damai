package com.taobao.weex.devtools.common.android;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.taobao.weex.devtools.common.android.FragmentCompat;
import javax.annotation.Nullable;

/* compiled from: Taobao */
final class FragmentCompatSupportLib extends FragmentCompat<Fragment, DialogFragment, FragmentManager, FragmentActivity> {
    private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib();
    private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib();
    private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib();
    private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<>();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class DialogFragmentAccessorSupportLib extends FragmentAccessorSupportLib implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
        private DialogFragmentAccessorSupportLib() {
            super();
        }

        public Dialog getDialog(DialogFragment dialogFragment) {
            return dialogFragment.getDialog();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class FragmentAccessorSupportLib implements FragmentAccessor<Fragment, FragmentManager> {
        private FragmentAccessorSupportLib() {
        }

        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return fragment.getChildFragmentManager();
        }

        @Nullable
        public FragmentManager getFragmentManager(Fragment fragment) {
            return fragment.getFragmentManager();
        }

        public int getId(Fragment fragment) {
            return fragment.getId();
        }

        public Resources getResources(Fragment fragment) {
            return fragment.getResources();
        }

        @Nullable
        public String getTag(Fragment fragment) {
            return fragment.getTag();
        }

        @Nullable
        public View getView(Fragment fragment) {
            return fragment.getView();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class FragmentActivityAccessorSupportLib implements FragmentActivityAccessor<FragmentActivity, FragmentManager> {
        private FragmentActivityAccessorSupportLib() {
        }

        @Nullable
        public FragmentManager getFragmentManager(FragmentActivity fragmentActivity) {
            return fragmentActivity.getSupportFragmentManager();
        }
    }

    FragmentCompatSupportLib() {
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager() {
        return sFragmentManagerAccessor;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<DialogFragment> getDialogFragmentClass() {
        return DialogFragment.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<FragmentActivity> getFragmentActivityClass() {
        return FragmentActivity.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<Fragment> getFragmentClass() {
        return Fragment.class;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompatSupportLib$DialogFragmentAccessorSupportLib' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompatSupportLib$FragmentAccessorSupportLib' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentAccessor<Fragment, FragmentManager> forFragment() {
        return sFragmentAccessor;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompatSupportLib$FragmentActivityAccessorSupportLib' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentActivityAccessor<FragmentActivity, FragmentManager> forFragmentActivity() {
        return sFragmentActivityAccessor;
    }
}

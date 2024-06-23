package com.taobao.weex.devtools.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import com.taobao.weex.devtools.common.android.FragmentCompat;
import javax.annotation.Nullable;

@TargetApi(11)
/* compiled from: Taobao */
final class FragmentCompatFramework extends FragmentCompat<Fragment, DialogFragment, FragmentManager, Activity> {
    private static final DialogFragmentAccessorFramework sDialogFragmentAccessor = new DialogFragmentAccessorFramework(sFragmentAccessor);
    private static final FragmentAccessorFrameworkHoneycomb sFragmentAccessor;
    private static final FragmentActivityAccessorFramework sFragmentActivityAccessor = new FragmentActivityAccessorFramework();
    private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<>();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class DialogFragmentAccessorFramework implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
        private final FragmentAccessor<Fragment, FragmentManager> mFragmentAccessor;

        public DialogFragmentAccessorFramework(FragmentAccessor<Fragment, FragmentManager> fragmentAccessor) {
            this.mFragmentAccessor = fragmentAccessor;
        }

        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return this.mFragmentAccessor.getChildFragmentManager(fragment);
        }

        public Dialog getDialog(DialogFragment dialogFragment) {
            return dialogFragment.getDialog();
        }

        @Nullable
        public FragmentManager getFragmentManager(Fragment fragment) {
            return this.mFragmentAccessor.getFragmentManager(fragment);
        }

        public int getId(Fragment fragment) {
            return this.mFragmentAccessor.getId(fragment);
        }

        public Resources getResources(Fragment fragment) {
            return this.mFragmentAccessor.getResources(fragment);
        }

        @Nullable
        public String getTag(Fragment fragment) {
            return this.mFragmentAccessor.getTag(fragment);
        }

        @Nullable
        public View getView(Fragment fragment) {
            return this.mFragmentAccessor.getView(fragment);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class FragmentAccessorFrameworkHoneycomb implements FragmentAccessor<Fragment, FragmentManager> {
        private FragmentAccessorFrameworkHoneycomb() {
        }

        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return null;
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

    @TargetApi(17)
    /* compiled from: Taobao */
    private static class FragmentAccessorFrameworkJellyBean extends FragmentAccessorFrameworkHoneycomb {
        private FragmentAccessorFrameworkJellyBean() {
            super();
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentCompatFramework.FragmentAccessorFrameworkHoneycomb
        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return fragment.getChildFragmentManager();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class FragmentActivityAccessorFramework implements FragmentActivityAccessor<Activity, FragmentManager> {
        private FragmentActivityAccessorFramework() {
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentActivityAccessor
        @Nullable
        public FragmentManager getFragmentManager(Activity activity) {
            return activity.getFragmentManager();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            sFragmentAccessor = new FragmentAccessorFrameworkJellyBean();
        } else {
            sFragmentAccessor = new FragmentAccessorFrameworkHoneycomb();
        }
    }

    FragmentCompatFramework() {
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<DialogFragment> getDialogFragmentClass() {
        return DialogFragment.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<Activity> getFragmentActivityClass() {
        return Activity.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<Fragment> getFragmentClass() {
        return Fragment.class;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompatFramework$DialogFragmentAccessorFramework' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompatFramework$FragmentAccessorFrameworkHoneycomb' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentAccessor<Fragment, FragmentManager> forFragment() {
        return sFragmentAccessor;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompatFramework$FragmentActivityAccessorFramework' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentActivityAccessor<Activity, FragmentManager> forFragmentActivity() {
        return sFragmentActivityAccessor;
    }

    /* Return type fixed from 'com.taobao.weex.devtools.common.android.FragmentCompat$FragmentManagerAccessorViaReflection<android.app.FragmentManager, android.app.Fragment>' to match base method */
    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager() {
        return sFragmentManagerAccessor;
    }
}

package com.alibaba.responsive.page;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import tb.v02;

/* compiled from: Taobao */
public class ResponsiveFragment extends Fragment implements IResponsivePage {
    private v02 mResponsiveFragmentStateManager;

    @Override // com.alibaba.responsive.page.IResponsivePage
    public Activity getPageActivity() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        v02 v02 = this.mResponsiveFragmentStateManager;
        if (v02 != null) {
            v02.a(configuration);
        }
        super.onConfigurationChanged(configuration);
        v02 v022 = this.mResponsiveFragmentStateManager;
        if (v022 != null) {
            v022.b(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mResponsiveFragmentStateManager = new v02(this);
    }

    @Override // com.alibaba.responsive.page.IResponsivePage
    public void onResponsiveLayout(Configuration configuration, int i, boolean z) {
    }
}

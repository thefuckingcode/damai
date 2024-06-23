package com.alibaba.responsive.page;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import tb.t02;

/* compiled from: Taobao */
public class ResponsiveActivity extends AppCompatActivity implements IResponsivePage {
    private t02 mResponsiveActivityStateManager;

    @Override // com.alibaba.responsive.page.IResponsivePage
    public Activity getPageActivity() {
        return this;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        t02 t02 = this.mResponsiveActivityStateManager;
        if (t02 != null) {
            t02.e(configuration);
        }
        super.onConfigurationChanged(configuration);
        t02 t022 = this.mResponsiveActivityStateManager;
        if (t022 != null) {
            t022.g(configuration);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mResponsiveActivityStateManager = new t02(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        t02 t02 = this.mResponsiveActivityStateManager;
        if (t02 != null) {
            t02.f();
        }
    }

    @Override // com.alibaba.responsive.page.IResponsivePage
    public void onResponsiveLayout(Configuration configuration, int i, boolean z) {
    }
}

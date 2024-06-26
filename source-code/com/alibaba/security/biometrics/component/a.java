package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: Taobao */
public abstract class a implements d {
    protected static final String a = "AlBiometricsPageComponent";
    protected ALBiometricsParams b;
    protected Activity c;

    @Override // com.alibaba.security.biometrics.component.d
    public void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
    }

    @Override // com.alibaba.security.biometrics.component.d
    public boolean a() {
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.d
    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // com.alibaba.security.biometrics.component.d
    public boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        this.b = aLBiometricsParams;
        this.c = activity;
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.d
    public boolean b() {
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.d
    public boolean c() {
        return false;
    }
}

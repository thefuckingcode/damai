package com.alibaba.security.biometrics.component;

import android.app.Activity;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.c.a.b;
import com.alibaba.security.biometrics.logic.a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

@f(a = 8)
/* compiled from: Taobao */
public class c extends a {
    protected b d;

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.d = new com.alibaba.security.biometrics.c.a.c(activity);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a() {
        if (this.d.a(this.b.supportX86)) {
            return false;
        }
        ((a) e.a(a.class)).a(this.d.a(), "EnvironmentComponent", null);
        return true;
    }
}

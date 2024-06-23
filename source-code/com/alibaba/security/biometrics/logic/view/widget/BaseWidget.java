package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.skin.model.ButtonSkinData;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.biometrics.skin.model.ImageViewSkinData;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;

/* compiled from: Taobao */
public abstract class BaseWidget extends RelativeLayout implements c {
    protected ALBiometricsActivityParentView.a a;
    private RPSkinManager b = RPSkinManager.getInstance();

    public BaseWidget(Context context) {
        super(context);
    }

    private ControlSkinData f(String str) {
        return (ControlSkinData) this.b.getNativeSkinData(getSkinParentKey(), str, ControlSkinData.class);
    }

    private void g() {
        this.b = RPSkinManager.getInstance();
    }

    /* access modifiers changed from: protected */
    public final ImageViewSkinData a(String str) {
        return (ImageViewSkinData) this.b.getNativeSkinData(getSkinParentKey(), str, ImageViewSkinData.class);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public final NavigatorSkinData b(String str) {
        return (NavigatorSkinData) this.b.getNativeSkinData(getSkinParentKey(), str, NavigatorSkinData.class);
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public final ButtonSkinData c(String str) {
        return (ButtonSkinData) this.b.getNativeSkinData(getSkinParentKey(), str, ButtonSkinData.class);
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public final TextViewSkinData d(String str) {
        return (TextViewSkinData) this.b.getNativeSkinData(getSkinParentKey(), str, TextViewSkinData.class);
    }

    public void d() {
    }

    /* access modifiers changed from: protected */
    public final DetectAnimSkinData e(String str) {
        return (DetectAnimSkinData) this.b.getNativeSkinData(getSkinParentKey(), str, DetectAnimSkinData.class);
    }

    /* access modifiers changed from: protected */
    public abstract String getSkinParentKey();

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
        b();
    }

    public void setOnBioMainHandlerListener(ALBiometricsActivityParentView.a aVar) {
        this.a = aVar;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.c
    public void a(String... strArr) {
        b();
        setVisibility(0);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.c
    public final void e() {
        c();
        setVisibility(8);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.c
    public final boolean f() {
        return getVisibility() == 0;
    }

    public BaseWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

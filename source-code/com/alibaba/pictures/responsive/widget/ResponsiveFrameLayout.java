package com.alibaba.pictures.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b12;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 B\u001d\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001f\u0010!J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/alibaba/pictures/responsive/widget/ResponsiveFrameLayout;", "Landroid/widget/FrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Ltb/ur2;", "onMeasure", "layoutRatio", "setLayoutRatio", "", "ratio", "setRatio", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "onResponsiveListener", "setOnResponsiveListener", Constants.Name.MARGIN, "setMargin", com.youku.arch.v3.data.Constants.H_GAP, "setHGap", "Ltb/b12;", "responsiveSizeManager", "Ltb/b12;", "getResponsiveSizeManager", "()Ltb/b12;", "setResponsiveSizeManager", "(Ltb/b12;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ResponsiveFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private b12 responsiveSizeManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveFrameLayout(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponsiveFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b12 b12 = new b12(this);
        this.responsiveSizeManager = b12;
        b12.d(context, attributeSet);
    }

    @NotNull
    public final b12 getResponsiveSizeManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1242919028")) {
            return this.responsiveSizeManager;
        }
        return (b12) ipChange.ipc$dispatch("-1242919028", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596980828")) {
            ipChange.ipc$dispatch("596980828", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        a12 e = this.responsiveSizeManager.e(i, i2);
        if (e.d() > 0) {
            i = View.MeasureSpec.makeMeasureSpec(e.d(), 1073741824);
        }
        if (e.c() > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(e.c(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271494184")) {
            ipChange.ipc$dispatch("-271494184", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.f(i);
        requestLayout();
    }

    public final void setLayoutRatio(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-543824429")) {
            ipChange.ipc$dispatch("-543824429", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.g(i);
        requestLayout();
    }

    public final void setMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879186120")) {
            ipChange.ipc$dispatch("-1879186120", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.h(i);
        requestLayout();
    }

    public final void setOnResponsiveListener(@Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078496964")) {
            ipChange.ipc$dispatch("-2078496964", new Object[]{this, onResponsiveListener});
            return;
        }
        this.responsiveSizeManager.i(onResponsiveListener);
    }

    public final void setRatio(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "558944048")) {
            ipChange.ipc$dispatch("558944048", new Object[]{this, str});
            return;
        }
        this.responsiveSizeManager.j(str);
        requestLayout();
    }

    public final void setResponsiveSizeManager(@NotNull b12 b12) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465156804")) {
            ipChange.ipc$dispatch("-465156804", new Object[]{this, b12});
            return;
        }
        k21.i(b12, "<set-?>");
        this.responsiveSizeManager = b12;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponsiveFrameLayout(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}

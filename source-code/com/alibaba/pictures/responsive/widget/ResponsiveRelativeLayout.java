package com.alibaba.pictures.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b12;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/alibaba/pictures/responsive/widget/ResponsiveRelativeLayout;", "Landroid/widget/RelativeLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Ltb/ur2;", "onMeasure", "layoutRatio", "setLayoutRatio", "", "ratio", "setRatio", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "onResponsiveListener", "setOnResponsiveListener", Constants.Name.MARGIN, "setMargin", com.youku.arch.v3.data.Constants.H_GAP, "setHGap", "Ltb/b12;", "responsiveSizeManager", "Ltb/b12;", "getResponsiveSizeManager", "()Ltb/b12;", "setResponsiveSizeManager", "(Ltb/b12;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ResponsiveRelativeLayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private b12 responsiveSizeManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRelativeLayout(@NonNull @NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRelativeLayout(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponsiveRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @NotNull
    public final b12 getResponsiveSizeManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1945038091")) {
            return this.responsiveSizeManager;
        }
        return (b12) ipChange.ipc$dispatch("1945038091", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1171650779")) {
            ipChange.ipc$dispatch("1171650779", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
        if (AndroidInstantRuntime.support(ipChange, "-11536455")) {
            ipChange.ipc$dispatch("-11536455", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.f(i);
        requestLayout();
    }

    public final void setLayoutRatio(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294839086")) {
            ipChange.ipc$dispatch("-1294839086", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.g(i);
        requestLayout();
    }

    public final void setMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167911719")) {
            ipChange.ipc$dispatch("-1167911719", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.h(i);
        requestLayout();
    }

    public final void setOnResponsiveListener(@org.jetbrains.annotations.Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "795287005")) {
            ipChange.ipc$dispatch("795287005", new Object[]{this, onResponsiveListener});
            return;
        }
        this.responsiveSizeManager.i(onResponsiveListener);
    }

    public final void setRatio(@org.jetbrains.annotations.Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867394351")) {
            ipChange.ipc$dispatch("-867394351", new Object[]{this, str});
            return;
        }
        this.responsiveSizeManager.j(str);
        requestLayout();
    }

    public final void setResponsiveSizeManager(@NotNull b12 b12) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422733923")) {
            ipChange.ipc$dispatch("-422733923", new Object[]{this, b12});
            return;
        }
        k21.i(b12, "<set-?>");
        this.responsiveSizeManager = b12;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRelativeLayout(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b12 b12 = new b12(this);
        this.responsiveSizeManager = b12;
        b12.d(context, attributeSet);
    }
}

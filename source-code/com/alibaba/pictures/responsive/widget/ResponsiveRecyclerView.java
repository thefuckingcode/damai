package com.alibaba.pictures.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.g12;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/alibaba/pictures/responsive/widget/ResponsiveRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "widthSpec", "heightSpec", "Ltb/ur2;", "onMeasure", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "onResponsiveListener", "setOnResponsiveListener", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ResponsiveRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnResponsiveListener onResponsiveListener;
    @Nullable
    private a12 responsiveSize;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRecyclerView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponsiveRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onMeasure(int i, int i2) {
        OnResponsiveListener onResponsiveListener2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-573293587")) {
            ipChange.ipc$dispatch("-573293587", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int defaultSize = ViewGroup.getDefaultSize(0, i);
        int defaultSize2 = ViewGroup.getDefaultSize(0, i2);
        if (!(defaultSize == getMeasuredWidth() || (onResponsiveListener2 = this.onResponsiveListener) == null)) {
            if (this.responsiveSize == null) {
                this.responsiveSize = new a12();
            }
            a12 a12 = this.responsiveSize;
            if (a12 != null) {
                a12.h(defaultSize);
                a12.g(defaultSize2);
                a12.f(g12.e(getContext()));
                a12.e(g12.d(getContext()));
                onResponsiveListener2.onResponsive(a12);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setOnResponsiveListener(@Nullable OnResponsiveListener onResponsiveListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465554805")) {
            ipChange.ipc$dispatch("-465554805", new Object[]{this, onResponsiveListener2});
            return;
        }
        this.onResponsiveListener = onResponsiveListener2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponsiveRecyclerView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}

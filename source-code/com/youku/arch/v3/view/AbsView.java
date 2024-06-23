package com.youku.arch.v3.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 '*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u0014\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u00020\b:\u0001'B\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b%\u0010&JM\u0010\u000e\u001a\u00020\r\"\u000e\b\u0003\u0010\t*\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u000e\b\u0004\u0010\n*\b\u0012\u0004\u0012\u00028\u00030\u0004\"\u0014\b\u0005\u0010\u000b*\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00062\u0006\u0010\f\u001a\u00028\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\f\u001a\u00028\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u000f¨\u0006("}, d2 = {"Lcom/youku/arch/v3/view/AbsView;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/IContract$Model;", "MODEL", "Lcom/youku/arch/v3/view/IContract$Presenter;", "PRESENTER", "Lcom/youku/arch/v3/view/IContract$View;", "_DATA", "_MODEL", "_PRESENTER", "presenter", "Ltb/ur2;", "bindPresenter", "(Lcom/youku/arch/v3/view/IContract$Presenter;)V", "", "elevation", "setElevation", "left", "top", "right", "bottom", "setPadding", BQCCameraParam.FOCUS_AREA_RADIUS, "", "alpha", "setRadiusCorner", "Landroid/view/View;", "renderView", "Landroid/view/View;", "getRenderView", "()Landroid/view/View;", "Lcom/youku/arch/v3/view/IContract$Presenter;", "getPresenter", "()Lcom/youku/arch/v3/view/IContract$Presenter;", "setPresenter", "<init>", "(Landroid/view/View;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class AbsView<DATA extends IItem<ItemValue>, MODEL extends IContract.Model<DATA>, PRESENTER extends IContract.Presenter<DATA, MODEL>> implements IContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public PRESENTER presenter;
    @Nullable
    private final View renderView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/view/AbsView$Companion;", "", "Landroid/view/View;", "view", "", BQCCameraParam.FOCUS_AREA_RADIUS, "", "alpha", "Ltb/ur2;", "setViewRoundedCorner", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @TargetApi(21)
        public final void setViewRoundedCorner(@Nullable View view, int i, float f) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-137495597")) {
                ipChange.ipc$dispatch("-137495597", new Object[]{this, view, Integer.valueOf(i), Float.valueOf(f)});
            } else if (Build.VERSION.SDK_INT >= 21 && view != null && i >= 0) {
                if (i <= 0) {
                    z = false;
                }
                view.setClipToOutline(z);
                view.setOutlineProvider(new AbsView$Companion$setViewRoundedCorner$1(f, i));
            }
        }
    }

    public AbsView(@Nullable View view) {
        this.renderView = view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: _PRESENTER extends com.youku.arch.v3.view.IContract$Presenter<_DATA, _MODEL> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.arch.v3.view.IContract.View
    public <_DATA extends IItem<ItemValue>, _MODEL extends IContract.Model<_DATA>, _PRESENTER extends IContract.Presenter<_DATA, _MODEL>> void bindPresenter(@NotNull _PRESENTER _presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "220623485")) {
            ipChange.ipc$dispatch("220623485", new Object[]{this, _presenter});
            return;
        }
        k21.i(_presenter, "presenter");
        setPresenter(_presenter);
    }

    @NotNull
    public final PRESENTER getPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126506502")) {
            return (PRESENTER) ((IContract.Presenter) ipChange.ipc$dispatch("2126506502", new Object[]{this}));
        }
        PRESENTER presenter2 = this.presenter;
        if (presenter2 != null) {
            return presenter2;
        }
        k21.A("presenter");
        return null;
    }

    @Override // com.youku.arch.v3.view.IContract.View
    @Nullable
    public View getRenderView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1599295668")) {
            return this.renderView;
        }
        return (View) ipChange.ipc$dispatch("-1599295668", new Object[]{this});
    }

    @Override // com.youku.arch.v3.view.IContract.View
    public void setElevation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908171825")) {
            ipChange.ipc$dispatch("-908171825", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View renderView2 = getRenderView();
        if (renderView2 != null) {
            float f = (float) i;
            if (f >= 0.0f) {
                ViewCompat.setElevation(renderView2, f);
            }
        }
    }

    @Override // com.youku.arch.v3.view.IContract.View
    public void setPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690958016")) {
            ipChange.ipc$dispatch("-690958016", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        View renderView2 = getRenderView();
        if (renderView2 != null) {
            renderView2.setPadding(i, i2, i3, i4);
        }
    }

    public final void setPresenter(@NotNull PRESENTER presenter2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686694186")) {
            ipChange.ipc$dispatch("-1686694186", new Object[]{this, presenter2});
            return;
        }
        k21.i(presenter2, "<set-?>");
        this.presenter = presenter2;
    }

    @Override // com.youku.arch.v3.view.IContract.View
    public void setRadiusCorner(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465684975")) {
            ipChange.ipc$dispatch("1465684975", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
            return;
        }
        View renderView2 = getRenderView();
        if (renderView2 != null) {
            Companion.setViewRoundedCorner(renderView2, i, f);
        }
    }
}

package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.alient.onearch.adapter.component.grid.GenericGridPresenter;
import com.alient.onearch.adapter.component.grid.GenericGridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f8;
import tb.g8;
import tb.k21;
import tb.vc;

/* compiled from: Taobao */
public final class GenericGridPresent extends GenericGridPresenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericGridPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.component.grid.GenericGridPresenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        boolean z;
        boolean z2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1360257835")) {
            ipChange.ipc$dispatch("1360257835", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        Bundle bundle = genericItem.getComponent().getPageContext().getBundle();
        if (bundle != null) {
            z = bundle.getBoolean(f8.KEY_IS_HAS_ATMOSPHERE, false);
            z2 = bundle.getBoolean(f8.KEY_IS_HAS_CLICK_AREA_HEIGHT, false);
        } else {
            z2 = false;
            z = false;
        }
        Activity activity = genericItem.getPageContext().getActivity();
        if (activity != null) {
            g8 a = f8.INSTANCE.a(activity);
            if (z) {
                if (z2) {
                    i = -a.b();
                } else {
                    i = -(a.c() + a.b());
                }
            }
            View renderView = ((GenericGridView) getView()).getRenderView();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            ViewGroup.LayoutParams layoutParams = renderView != null ? renderView.getLayoutParams() : null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (!(marginLayoutParams == null || marginLayoutParams.topMargin == i)) {
                marginLayoutParams.topMargin = i;
                View renderView2 = ((GenericGridView) getView()).getRenderView();
                if (renderView2 != null) {
                    renderView2.requestLayout();
                }
            }
        }
        vc vcVar = vc.INSTANCE;
        vcVar.a("isHasAtmosphere=" + z + " isHasClickArea=" + z2, f8.TAG);
        super.init(genericItem);
    }
}

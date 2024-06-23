package com.alibaba.pictures.bricks.component.home.welfare;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.render.GenericGaiaxPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import java.util.HashMap;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jk1;
import tb.k21;
import tb.u50;

/* compiled from: Taobao */
public final class WelfareGaiaxPresenter extends GenericGaiaxPresenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WelfareGaiaxPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603599016")) {
            return ((Boolean) ipChange.ipc$dispatch("603599016", new Object[]{this})).booleanValue();
        } else if (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0127, code lost:
        if (r0 > 0) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012a, code lost:
        if (r0 > 0) goto L_0x012e;
     */
    @Override // com.alient.gaiax.container.render.GenericGaiaxPresenter
    public int measureWidth(@NotNull IItem<ItemValue> iItem) {
        ComponentConfigBean.ComponentBean componentConfig;
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        HashMap<String, Object> params;
        ComponentValue property;
        JSONObject data;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2076640441")) {
            return ((Integer) ipChange.ipc$dispatch("-2076640441", new Object[]{this, iItem})).intValue();
        }
        k21.i(iItem, "item");
        if (isLargeScreenMode()) {
            return super.measureWidth(iItem);
        }
        IComponent<ComponentValue> component = iItem.getComponent();
        int intValue = (component == null || (property = component.getProperty()) == null || (data = property.getData()) == null) ? 0 : data.getIntValue("childWidth");
        Activity activity = iItem.getPageContext().getActivity();
        Integer num = null;
        if (!(activity != null)) {
            activity = null;
        }
        if (activity == null || (componentConfig = getComponentConfig()) == null || (layout = componentConfig.getLayout()) == null || (params = layout.getParams()) == null) {
            return 0;
        }
        k21.h(params, "params");
        if (params.containsKey("itemWidth")) {
            String str = (String) params.get("itemWidth");
            if ((str == null || (o.y(str))) || !jk1.b(str)) {
                Integer num2 = (Integer) params.get("itemWidth");
                if (num2 != null) {
                    i = num2.intValue();
                }
            } else {
                int c = u50.INSTANCE.c(activity, params, "itemWidth");
                if (c != 0) {
                    i = activity.getResources().getDimensionPixelSize(c);
                }
            }
        }
        u50 u50 = u50.INSTANCE;
        int c2 = u50.c(activity, params, Constants.GAP);
        Object obj = params.get("span");
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        int intValue2 = num != null ? num.intValue() : 1;
        if (c2 != 0 && intValue2 > 1) {
            int dimensionPixelSize = activity.getResources().getDimensionPixelSize(c2);
            int c3 = u50.c(activity, params, "listMarginLeft");
            if (c3 != 0) {
                intValue -= activity.getResources().getDimensionPixelSize(c3);
            }
            int c4 = u50.c(activity, params, "listMarginRight");
            if (c4 != 0) {
                intValue -= activity.getResources().getDimensionPixelSize(c4);
            }
            int c5 = u50.c(activity, params, Constants.Name.MARGIN_LEFT);
            if (c5 != 0) {
                intValue -= activity.getResources().getDimensionPixelSize(c5);
            }
            int c6 = u50.c(activity, params, Constants.Name.MARGIN_RIGHT);
            if (c6 != 0) {
                intValue -= activity.getResources().getDimensionPixelSize(c6);
            }
            intValue = (intValue - (((intValue2 - 1) * dimensionPixelSize) / 2)) / intValue2;
        }
        intValue = i;
        if (intValue == 0) {
            intValue = super.measureWidth(iItem);
        }
        return intValue;
    }
}

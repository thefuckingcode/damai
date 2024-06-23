package com.alibaba.pictures.bricks.component.home.horizonrawcontract;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.horizonrawcontract.HorizontalRawContract;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.component.raw.RawView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import java.util.Map;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.u50;

/* compiled from: Taobao */
public class HorizontalRawView extends RawView<HorizontalRawModel, HorizontalRawPresenter> implements HorizontalRawContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int gapW;
    private int heightRaw;
    @NotNull
    private final LinearLayout horizontalRaw;
    private int marginW;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalRawView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        View findViewById = view.findViewById(R$id.bricks_horizontalraw_layout);
        k21.h(findViewById, "view.findViewById<Linear…cks_horizontalraw_layout)");
        this.horizontalRaw = (LinearLayout) findViewById;
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033532044")) {
            return ((Integer) ipChange.ipc$dispatch("-1033532044", new Object[]{this, context, map, str})).intValue();
        } else if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), Constants.DIMEN);
        } else {
            return 0;
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.horizonrawcontract.HorizontalRawContract.View
    @NotNull
    public LinearLayout getHorizontalRaw() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1624106009")) {
            return this.horizontalRaw;
        }
        return (LinearLayout) ipChange.ipc$dispatch("1624106009", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.home.horizonrawcontract.HorizontalRawContract.View
    public void initHorizontalRawSettings(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2031207454")) {
            ipChange.ipc$dispatch("-2031207454", new Object[]{this, map});
            return;
        }
        LinearLayout horizontalRaw2 = getHorizontalRaw();
        if (map != null) {
            int dimenId = getDimenId(horizontalRaw2.getContext(), map, Constants.GAP);
            if (dimenId != 0) {
                this.gapW = horizontalRaw2.getContext().getResources().getDimensionPixelSize(dimenId);
            }
            int dimenId2 = getDimenId(horizontalRaw2.getContext(), map, Constants.Name.MARGIN_LEFT);
            int dimensionPixelSize = dimenId2 != 0 ? horizontalRaw2.getContext().getResources().getDimensionPixelSize(dimenId2) : 0;
            int dimenId3 = getDimenId(horizontalRaw2.getContext(), map, Constants.Name.MARGIN_RIGHT);
            if (dimenId3 != 0) {
                i = horizontalRaw2.getContext().getResources().getDimensionPixelSize(dimenId3);
            }
            this.marginW = dimensionPixelSize + i;
            int dimenId4 = getDimenId(horizontalRaw2.getContext(), map, "height");
            if (dimenId4 != 0) {
                this.heightRaw = horizontalRaw2.getContext().getResources().getDimensionPixelSize(dimenId4);
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.horizonrawcontract.HorizontalRawContract.View
    public void showComponents(@NotNull List<? extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> list) {
        ItemValue property;
        JSONObject data;
        ItemValue property2;
        JSONObject data2;
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-714786546")) {
            ipChange.ipc$dispatch("-714786546", new Object[]{this, list});
            return;
        }
        k21.i(list, "viewHolderList");
        getHorizontalRaw().removeAllViews();
        u50 u50 = u50.INSTANCE;
        Context context = getHorizontalRaw().getContext();
        k21.h(context, "horizontalRaw.context");
        int size = ((DisplayMetrics.getwidthPixels(u50.f(context)) - this.marginW) - ((list.size() - 1) * this.gapW)) / list.size();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            T t2 = t;
            IItem data3 = t2.getData();
            if (!(data3 == null || (property2 = data3.getProperty()) == null || (data2 = property2.getData()) == null || (string = data2.getString("nodeId")) == null)) {
                k21.h(string, "getString(\"nodeId\")");
            }
            IItem data4 = t2.getData();
            if (!(data4 == null || (property = data4.getProperty()) == null || (data = property.getData()) == null)) {
                data.put("childWidth", (Object) String.valueOf(size));
            }
            int i3 = this.heightRaw;
            if (i3 == 0) {
                i3 = -2;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i3);
            layoutParams.weight = 1.0f;
            if (getHorizontalRaw().getChildCount() > 0) {
                layoutParams.leftMargin = this.gapW;
            }
            getHorizontalRaw().addView(t2.itemView, layoutParams);
            i = i2;
        }
    }
}

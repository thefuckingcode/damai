package com.alibaba.pictures.bricks.component.instructions.more;

import com.alibaba.pictures.bricks.component.instructions.more.SeeMoreContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.alient.oneservice.nav.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class SeeMoreModel extends AbsModel<GenericItem<ItemValue>, Object> implements SeeMoreContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    public void parseTrackInfo(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-567170310")) {
            ipChange.ipc$dispatch("-567170310", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.parseTrackInfo((IItem) genericItem);
        Map<String, Action> actions = getActions();
        if (actions != null) {
            Action action = actions.get(WXBasicComponentType.FOOTER);
            if (action != null) {
                actions.put("item", action);
            }
            actions.remove(WXBasicComponentType.FOOTER);
        }
    }
}

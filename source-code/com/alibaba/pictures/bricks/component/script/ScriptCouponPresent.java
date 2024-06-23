package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import com.alibaba.pictures.bricks.bean.SearchScriptCouponBean;
import com.alibaba.pictures.bricks.component.script.ScriptCouponContract;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.x52;

/* compiled from: Taobao */
public final class ScriptCouponPresent extends AbsPresenter<GenericItem<ItemValue>, ScriptCouponModel, ScriptCouponView> implements ScriptCouponContract.Present, OnItemListener<SearchScriptCouponBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptCouponPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.onearch.AbsPresenter
    @NotNull
    public Map<String, String> getTrackArgs() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023072332")) {
            return (Map) ipChange.ipc$dispatch("-1023072332", new Object[]{this});
        }
        Map<String, String> trackArgs = super.getTrackArgs();
        k21.h(trackArgs, "trackInfo");
        SearchScriptCouponBean data = ((ScriptCouponModel) getModel()).getData();
        if (data == null || (str = data.getProjectId()) == null) {
            str = "";
        }
        trackArgs.put("biz_id", str);
        trackArgs.put("biz_type", "团购券");
        return trackArgs;
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612268753")) {
            ipChange.ipc$dispatch("-1612268753", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        ((ScriptCouponView) getView()).bindData((SearchScriptCouponBean) ((ScriptCouponModel) getModel()).getValue());
        if (genericItem.getComponent().getChildCount() - 1 == genericItem.getIndex()) {
            ((ScriptCouponView) getView()).getDivline().setVisibility(8);
        } else {
            ((ScriptCouponView) getView()).getDivline().setVisibility(0);
        }
        x52.a(this, ((ScriptCouponView) getView()).getRenderView());
    }

    public void onItemClick(@NotNull SearchScriptCouponBean searchScriptCouponBean, int i) {
        String str;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "943196297")) {
            ipChange.ipc$dispatch("943196297", new Object[]{this, searchScriptCouponBean, Integer.valueOf(i)});
            return;
        }
        k21.i(searchScriptCouponBean, "bean");
        String schema = searchScriptCouponBean.getSchema();
        if (schema == null || schema.length() == 0) {
            z = true;
        }
        if (z) {
            str = "damai://V1/ScriptCouponDetail?couponId=" + searchScriptCouponBean.getProjectId();
        } else {
            str = searchScriptCouponBean.getSchema();
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(str);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
        userTrackClick(getTrackArgs(), true);
    }

    public void onItemExpose(@NotNull View view, @NotNull SearchScriptCouponBean searchScriptCouponBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1112885347")) {
            ipChange.ipc$dispatch("-1112885347", new Object[]{this, view, searchScriptCouponBean, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(searchScriptCouponBean, "bean");
        userTrackExpose(((ScriptCouponView) getView()).getRenderView(), getTrackArgs());
    }
}

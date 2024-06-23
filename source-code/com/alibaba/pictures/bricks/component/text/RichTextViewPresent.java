package com.alibaba.pictures.bricks.component.text;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.text.RichTextViewContract;
import com.alibaba.pictures.bricks.coupon.view.DetailInfoViewHolder;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class RichTextViewPresent extends AbsPresenter<GenericItem<ItemValue>, RichTextViewModel, RichTextViewView> implements RichTextViewContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String lastStr;

    /* compiled from: Taobao */
    public static final class a implements DetailInfoViewHolder.OnChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RichTextViewPresent a;
        final /* synthetic */ GenericItem<ItemValue> b;

        a(RichTextViewPresent richTextViewPresent, GenericItem<ItemValue> genericItem) {
            this.a = richTextViewPresent;
            this.b = genericItem;
        }

        @Override // com.alibaba.pictures.bricks.coupon.view.DetailInfoViewHolder.OnChangeListener
        public void onChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1016275995")) {
                ipChange.ipc$dispatch("-1016275995", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.trackClick(i);
            if (i == DetailInfoViewHolder.Companion.a()) {
                HashMap hashMap = new HashMap();
                EventDispatcher eventDispatcher = this.b.getPageContext().getEventDispatcher();
                if (eventDispatcher != null) {
                    eventDispatcher.dispatchEvent("EventBus://business/notification/msg_scroll_to_top", hashMap);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichTextViewPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1878042798")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1878042798", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1901841851")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1901841851", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "911700419")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("911700419", new Object[]{this})).booleanValue();
    }

    @Nullable
    public final String getLastStr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1929515695")) {
            return this.lastStr;
        }
        return (String) ipChange.ipc$dispatch("1929515695", new Object[]{this});
    }

    public final void setLastStr(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930809177")) {
            ipChange.ipc$dispatch("-1930809177", new Object[]{this, str});
            return;
        }
        this.lastStr = str;
    }

    public final void trackClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002951030")) {
            ipChange.ipc$dispatch("-1002951030", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        JSONObject data = ((GenericItem) getItem()).getComponent().getProperty().getData();
        Object obj = data != null ? data.get("action") : null;
        k21.g(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        Object obj2 = ((JSONObject) obj).get(WXBasicComponentType.FOOTER);
        k21.g(obj2, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        Object obj3 = ((JSONObject) obj2).get("trackInfo");
        k21.g(obj3, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        JSONObject jSONObject = (JSONObject) obj3;
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma(jSONObject.getString("spma"));
        trackInfo.setSpmb(jSONObject.getString("spmb"));
        trackInfo.setSpmc(jSONObject.getString("spmc"));
        trackInfo.setSpmd(jSONObject.getString("spmd"));
        trackInfo.setArgs(new LinkedHashMap());
        HashMap<String, String> args = trackInfo.getArgs();
        k21.h(args, "trackInfo.args");
        args.put("state", String.valueOf(i));
        UserTrackProviderProxy.click(null, trackInfo, false);
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724179306")) {
            ipChange.ipc$dispatch("1724179306", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        if (!TextUtils.isEmpty(((RichTextViewModel) getModel()).getDesc())) {
            if (TextUtils.isEmpty(this.lastStr)) {
                this.lastStr = ((RichTextViewModel) getModel()).getDesc();
            } else if (o.x(this.lastStr, ((RichTextViewModel) getModel()).getDesc(), false, 2, null)) {
                return;
            }
            String desc = ((RichTextViewModel) getModel()).getDesc();
            DetailInfoViewHolder detailInfoViewHolder = new DetailInfoViewHolder();
            Activity activity = genericItem.getPageContext().getActivity();
            if (activity != null) {
                View findViewById = ((RichTextViewView) getView()).getItemView().findViewById(R$id.bricks_richtext_recycleview);
                k21.h(findViewById, "view.itemView.findViewBy…cks_richtext_recycleview)");
                RecyclerView recyclerView = (RecyclerView) findViewById;
                View findViewById2 = ((RichTextViewView) getView()).getItemView().findViewById(R$id.bricks_richtext_click_more);
                k21.h(findViewById2, "view.itemView.findViewBy…icks_richtext_click_more)");
                detailInfoViewHolder.d(desc, activity, recyclerView, (TextView) findViewById2, new a(this, genericItem));
            }
        }
    }
}

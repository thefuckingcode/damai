package com.alient.onearch.adapter.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.util.MediaBrowserUtil;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.alimovie.popcorn.Popcorn;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0016\u0010(\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u0006."}, d2 = {"Lcom/alient/onearch/adapter/view/GenericViewCard;", "Lcom/alient/onearch/adapter/view/ViewCard;", "Ltb/ur2;", "bindAutoExposeTrack", "initTrackInfo", "Landroid/view/View;", "view", "onItemClick", "onItemLongClick", "", "isDegrade", "enableRankInAll", "enableAutoExposeTrack", "enableAutoClickTrack", "enableAutoAction", "", "key", "Lcom/alient/oneservice/nav/Action;", "getAction", "viewCard", "Lcom/alient/onearch/adapter/view/ViewCard;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "item", "Lcom/youku/arch/v3/IItem;", "", "actions", "Ljava/util/Map;", "Landroid/view/View;", "getItemAction", "()Lcom/alient/oneservice/nav/Action;", "itemAction", "", "getModuleRank", "()I", "moduleRank", "getRankInModule", "rankInModule", "getRankInAll", "rankInAll", "isOnlyChild", "()Z", "isFirstChild", "isLastChild", "<init>", "(Lcom/alient/onearch/adapter/view/ViewCard;Lcom/youku/arch/v3/IItem;Ljava/util/Map;Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericViewCard implements ViewCard {
    private final Map<String, Action> actions;
    private final IItem<ItemValue> item;
    private final View view;
    private final ViewCard viewCard;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, ? extends com.alient.oneservice.nav.Action> */
    /* JADX WARN: Multi-variable type inference failed */
    public GenericViewCard(@NotNull ViewCard viewCard2, @NotNull IItem<ItemValue> iItem, @Nullable Map<String, ? extends Action> map, @Nullable View view2) {
        k21.i(viewCard2, "viewCard");
        k21.i(iItem, "item");
        this.viewCard = viewCard2;
        this.item = iItem;
        this.actions = map;
        this.view = view2;
        initTrackInfo();
        bindAutoExposeTrack();
    }

    private final void bindAutoExposeTrack() {
        Action itemAction;
        TrackInfo trackInfo;
        if (enableAutoExposeTrack() && (itemAction = getItemAction()) != null && (trackInfo = itemAction.getTrackInfo()) != null) {
            UserTrackProviderProxy.expose(this.view, trackInfo);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104 A[Catch:{ Exception -> 0x02af }] */
    private final void initTrackInfo() {
        boolean z;
        boolean z2;
        String string;
        JSONObject data;
        JSONObject jSONObject;
        String string2;
        Map<String, Action> map = this.actions;
        if (map != null) {
            for (Map.Entry<String, Action> entry : map.entrySet()) {
                String valueOf = String.valueOf(getRankInModule());
                String valueOf2 = String.valueOf(getModuleRank());
                String str = enableRankInAll() ? "null" : null;
                ModelValue property = this.item.getComponent().getModule().getContainer().getProperty();
                JSONObject data2 = property.getData();
                JSONObject jSONObject2 = (data2 == null || (string2 = data2.getString("pabBucket")) == null) ? null : (JSONObject) JSON.parseObject(string2, JSONObject.class);
                if ((jSONObject2 == null || jSONObject2.isEmpty()) && (data = property.getData()) != null && (jSONObject = data.getJSONObject("globalConfig")) != null && !TextUtils.isEmpty(jSONObject.getString("pabBucket"))) {
                    jSONObject2 = (JSONObject) JSON.parseObject(jSONObject.getString("pabBucket"), JSONObject.class);
                }
                JSONObject data3 = this.item.getComponent().getProperty().getData();
                JSONObject jSONObject3 = (data3 == null || (string = data3.getString("abBucket")) == null) ? null : (JSONObject) JSON.parseObject(string, JSONObject.class);
                Action value = entry.getValue();
                if (value.getTrackInfo() == null) {
                    value.setTrackInfo(new TrackInfo());
                }
                TrackInfo trackInfo = value.getTrackInfo();
                k21.h(trackInfo, "action.trackInfo");
                if (trackInfo.getArgs() == null) {
                    TrackInfo trackInfo2 = value.getTrackInfo();
                    k21.h(trackInfo2, "action.trackInfo");
                    trackInfo2.setArgs(new HashMap<>());
                }
                try {
                    JSONObject data4 = property.getData();
                    if (data4 != null) {
                        String string3 = data4.getString(GenericPagerLoader.UT_SPM_AB);
                        if (string3 != null) {
                            if (string3.length() != 0) {
                                z = false;
                                if (!z) {
                                    List list = StringsKt__StringsKt.z0(string3, new String[]{"."}, false, 0, 6, null);
                                    if (list != null) {
                                        if (!list.isEmpty()) {
                                            z2 = false;
                                            if (!z2 && list.size() > 1) {
                                                TrackInfo trackInfo3 = value.getTrackInfo();
                                                k21.h(trackInfo3, "action.trackInfo");
                                                trackInfo3.setSpma((String) list.get(0));
                                                TrackInfo trackInfo4 = value.getTrackInfo();
                                                k21.h(trackInfo4, "action.trackInfo");
                                                trackInfo4.setSpmb((String) list.get(1));
                                            }
                                        }
                                    }
                                    z2 = true;
                                    TrackInfo trackInfo32 = value.getTrackInfo();
                                    k21.h(trackInfo32, "action.trackInfo");
                                    trackInfo32.setSpma((String) list.get(0));
                                    TrackInfo trackInfo42 = value.getTrackInfo();
                                    k21.h(trackInfo42, "action.trackInfo");
                                    trackInfo42.setSpmb((String) list.get(1));
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                    TrackInfo trackInfo5 = value.getTrackInfo();
                    k21.h(trackInfo5, "action.trackInfo");
                    trackInfo5.setPabBucket(jSONObject2);
                    TrackInfo trackInfo6 = value.getTrackInfo();
                    k21.h(trackInfo6, "action.trackInfo");
                    trackInfo6.setAbBucket(jSONObject3);
                    TrackInfo trackInfo7 = value.getTrackInfo();
                    k21.h(trackInfo7, "action.trackInfo");
                    if (trackInfo7.getArgs() == null) {
                        TrackInfo trackInfo8 = value.getTrackInfo();
                        k21.h(trackInfo8, "action.trackInfo");
                        trackInfo8.setArgs(new HashMap<>());
                    }
                    if (jSONObject3 != null) {
                        TrackInfo trackInfo9 = value.getTrackInfo();
                        k21.h(trackInfo9, "action.trackInfo");
                        HashMap<String, String> args = trackInfo9.getArgs();
                        k21.h(args, "action.trackInfo.args");
                        args.put("ABTrackInfo", jSONObject3.toJSONString());
                    }
                    GenericFragment fragment = this.item.getPageContext().getFragment();
                    if (!(fragment instanceof BaseFragment)) {
                        fragment = null;
                    }
                    BaseFragment baseFragment = (BaseFragment) fragment;
                    if (baseFragment != null) {
                        TrackInfo trackInfo10 = value.getTrackInfo();
                        k21.h(trackInfo10, "action.trackInfo");
                        trackInfo10.getArgs().putAll(baseFragment.getTrackInfo().getArgs());
                    }
                    TrackInfo trackInfo11 = value.getTrackInfo();
                    k21.h(trackInfo11, "action.trackInfo");
                    HashMap<String, String> args2 = trackInfo11.getArgs();
                    k21.h(args2, "action.trackInfo.args");
                    args2.put("rank_in_module", valueOf);
                    TrackInfo trackInfo12 = value.getTrackInfo();
                    k21.h(trackInfo12, "action.trackInfo");
                    HashMap<String, String> args3 = trackInfo12.getArgs();
                    k21.h(args3, "action.trackInfo.args");
                    args3.put("module_rank", valueOf2);
                    if (enableRankInAll()) {
                        TrackInfo trackInfo13 = value.getTrackInfo();
                        k21.h(trackInfo13, "action.trackInfo");
                        HashMap<String, String> args4 = trackInfo13.getArgs();
                        k21.h(args4, "action.trackInfo.args");
                        args4.put("rank_in_all", str);
                    }
                    TrackInfo trackInfo14 = value.getTrackInfo();
                    k21.h(trackInfo14, "action.trackInfo");
                    TrackInfo trackInfo15 = value.getTrackInfo();
                    k21.h(trackInfo15, "action.trackInfo");
                    trackInfo14.setOriginSpmd(trackInfo15.getSpmd());
                    TrackInfo trackInfo16 = value.getTrackInfo();
                    k21.h(trackInfo16, "action.trackInfo");
                    if (!TextUtils.isEmpty(trackInfo16.getSpmd())) {
                        TrackInfo trackInfo17 = value.getTrackInfo();
                        k21.h(trackInfo17, "action.trackInfo");
                        String spmd = trackInfo17.getSpmd();
                        k21.h(spmd, "action.trackInfo.spmd");
                        if (o.v(spmd, JSMethod.NOT_SET, false, 2, null)) {
                            TrackInfo trackInfo18 = value.getTrackInfo();
                            k21.h(trackInfo18, "action.trackInfo");
                            StringBuilder sb = new StringBuilder();
                            TrackInfo trackInfo19 = value.getTrackInfo();
                            k21.h(trackInfo19, "action.trackInfo");
                            sb.append(trackInfo19.getSpmd());
                            TrackInfo trackInfo20 = value.getTrackInfo();
                            k21.h(trackInfo20, "action.trackInfo");
                            sb.append(trackInfo20.getArgs().get("rank_in_module"));
                            trackInfo18.setSpmd(sb.toString());
                        } else {
                            TrackInfo trackInfo21 = value.getTrackInfo();
                            k21.h(trackInfo21, "action.trackInfo");
                            TrackInfo trackInfo22 = value.getTrackInfo();
                            k21.h(trackInfo22, "action.trackInfo");
                            String spmd2 = trackInfo22.getSpmd();
                            k21.h(spmd2, "action.trackInfo.spmd");
                            trackInfo21.setSpmd(o.F(o.F(spmd2, "$module_rank", valueOf2, false, 4, null), "$rank_in_module", valueOf, false, 4, null));
                        }
                        TrackInfo trackInfo23 = value.getTrackInfo();
                        k21.h(trackInfo23, "action.trackInfo");
                        HashMap<String, String> args5 = trackInfo23.getArgs();
                        k21.h(args5, "action.trackInfo.args");
                        args5.put("index", valueOf);
                    }
                } catch (Exception e) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw e;
                    }
                }
            }
        }
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        return this.viewCard.enableAutoAction();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        return this.viewCard.enableAutoClickTrack();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        return this.viewCard.enableAutoExposeTrack();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableRankInAll() {
        return this.viewCard.enableRankInAll();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getAction(@Nullable String str) {
        Map<String, Action> map = this.actions;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getItemAction() {
        Map<String, Action> map = this.actions;
        if (map != null) {
            return map.get("item");
        }
        return null;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getModuleRank() {
        int i = 0;
        for (IComponent<ComponentValue> iComponent : this.item.getComponent().getModule().getComponents()) {
            if (iComponent.getType() == this.item.getComponent().getType()) {
                return i;
            }
            if (iComponent.getProperty().getData() != null) {
                JSONObject data = iComponent.getProperty().getData();
                k21.f(data);
                if (!data.isEmpty()) {
                    i++;
                }
            }
        }
        return -1;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInAll() {
        int index = this.item.getIndex();
        for (IModule<ModuleValue> iModule : this.item.getComponent().getModule().getContainer().getCurrentModules()) {
            Iterator<IComponent<ComponentValue>> it = iModule.getComponents().iterator();
            while (true) {
                if (it.hasNext()) {
                    IComponent<ComponentValue> next = it.next();
                    index += next.getChildCount();
                    if (next.getType() == this.item.getComponent().getType()) {
                        return index;
                    }
                }
            }
        }
        return -1;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInModule() {
        return this.item.getIndex();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isDegrade() {
        return this.viewCard.isDegrade();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isFirstChild() {
        return this.item.getIndex() == 0;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isLastChild() {
        return !this.item.getComponent().hasNext() && this.item.getComponent().getChildCount() - 1 == this.item.getIndex();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isOnlyChild() {
        return !this.item.getComponent().hasNext() && this.item.getComponent().getChildCount() == 1;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view2) {
        TrackInfo trackInfo;
        k21.i(view2, "view");
        this.viewCard.onItemClick(view2);
        Action itemAction = getItemAction();
        if (itemAction != null) {
            if (enableAutoAction()) {
                if (itemAction.getActionType() == 4) {
                    MediaBrowserUtil.INSTANCE.processMediaBrowserParams(this.item, itemAction);
                }
                NavProviderProxy.toUri(view2.getContext(), itemAction);
            }
            if (enableAutoClickTrack() && (trackInfo = itemAction.getTrackInfo()) != null) {
                if (itemAction.getActionType() == 1 || itemAction.getActionType() == 2) {
                    UserTrackProviderProxy.click(view2, trackInfo, true);
                } else if (itemAction.getActionType() == 0 || itemAction.getActionType() == 3) {
                    UserTrackProviderProxy.click(view2, trackInfo, false);
                }
            }
        }
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemLongClick(@NotNull View view2) {
        Activity activity;
        SharedPreferences sharedPreferences;
        k21.i(view2, "view");
        this.viewCard.onItemLongClick(view2);
        if (AppInfoProviderProxy.isDebuggable() && (activity = this.item.getPageContext().getActivity()) != null && (sharedPreferences = activity.getSharedPreferences("mock_popcorn", 0)) != null && sharedPreferences.getBoolean("enableItemJSON", false)) {
            Context context = view2.getContext();
            JSONObject rawJson = this.item.getProperty().getRawJson();
            Popcorn.showJsonView(context, rawJson != null ? rawJson.toJSONString() : null);
        }
    }
}

package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.NoteBean;
import com.alibaba.pictures.bricks.component.home.feed.NoteContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.k70;
import tb.ta;
import tb.um2;

/* compiled from: Taobao */
public final class NotePresent extends AbsPresenter<GenericItem<ItemValue>, NoteModel, NoteView> implements NoteContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.NoteContract.Present
    public void dnaClick(@NotNull NoteBean noteBean) {
        TrackInfo trackInfo;
        TrackInfo trackInfo2;
        TrackInfo trackInfo3;
        TrackInfo trackInfo4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196647962")) {
            ipChange.ipc$dispatch("-1196647962", new Object[]{this, noteBean});
            return;
        }
        k21.i(noteBean, "noteBean");
        TrackInfo trackInfo5 = new TrackInfo();
        Action itemAction = getItemAction();
        JSONObject jSONObject = null;
        trackInfo5.setSpma((itemAction == null || (trackInfo4 = itemAction.getTrackInfo()) == null) ? null : trackInfo4.getSpma());
        Action itemAction2 = getItemAction();
        trackInfo5.setSpmb((itemAction2 == null || (trackInfo3 = itemAction2.getTrackInfo()) == null) ? null : trackInfo3.getSpma());
        trackInfo5.setSpmc("card");
        trackInfo5.setSpmd("DNAshow");
        Action itemAction3 = getItemAction();
        trackInfo5.setPabBucket((itemAction3 == null || (trackInfo2 = itemAction3.getTrackInfo()) == null) ? null : trackInfo2.getPabBucket());
        Action itemAction4 = getItemAction();
        if (!(itemAction4 == null || (trackInfo = itemAction4.getTrackInfo()) == null)) {
            jSONObject = trackInfo.getAbBucket();
        }
        trackInfo5.setAbBucket(jSONObject);
        UserTrackProviderProxy.click(trackInfo5, false);
        if (TextUtils.isEmpty(noteBean.goDnaUrl)) {
            k70.a(((NoteView) getView()).getItemView().getContext()).show();
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(noteBean.goDnaUrl);
        NavProviderProxy.getProxy().toUri(((NoteView) getView()).getItemView().getContext(), action);
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.NoteContract.Present
    public void exposeDna(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709576138")) {
            ipChange.ipc$dispatch("1709576138", new Object[]{this, view});
            return;
        }
        k21.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.NoteContract.Present
    public void itemClick(@NotNull NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302152226")) {
            ipChange.ipc$dispatch("-302152226", new Object[]{this, noteBean});
            return;
        }
        k21.i(noteBean, "noteBean");
        Action itemAction = getItemAction();
        String str = null;
        UserTrackProviderProxy.click(itemAction != null ? itemAction.getTrackInfo() : null, true);
        if (noteBean.isHasVideoUnderReviewStatus()) {
            um2 um2 = um2.INSTANCE;
            Context appContext = AppInfoProviderProxy.getAppContext();
            k21.h(appContext, "getAppContext()");
            um2.i(appContext, "该视频还在处理中哦~");
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        Action itemAction2 = getItemAction();
        if (itemAction2 != null) {
            str = itemAction2.getActionUrl();
        }
        action.setActionUrl(str);
        NavProviderProxy.getProxy().toUri(((NoteView) getView()).getItemView().getContext(), action);
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.NoteContract.Present
    public void projectClick(@NotNull NoteBean noteBean) {
        TrackInfo trackInfo;
        HashMap<String, String> args;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751743068")) {
            ipChange.ipc$dispatch("-1751743068", new Object[]{this, noteBean});
            return;
        }
        k21.i(noteBean, "noteBean");
        Map<String, Action> actions = getActions();
        String str = null;
        Action action = actions != null ? actions.get(ta.PROJECT_PAGE) : null;
        Action itemAction = getItemAction();
        if (!(itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null || (args = trackInfo.getArgs()) == null)) {
            str = args.get("titlelabel");
        }
        if (action != null) {
            HashMap<String, String> args2 = action.getTrackInfo().getArgs();
            k21.h(args2, "action.trackInfo.args");
            args2.put("titlelabel", str);
            UserTrackProviderProxy.click(action.getTrackInfo(), true);
            Action action2 = new Action();
            action2.setActionType(1);
            action2.setActionUrl(action.getActionUrl());
            NavProviderProxy.getProxy().toUri(((NoteView) getView()).getItemView().getContext(), action2);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.NoteContract.Present
    public void projectExpose(@NotNull NoteBean noteBean, @NotNull View view) {
        TrackInfo trackInfo;
        HashMap<String, String> args;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104701484")) {
            ipChange.ipc$dispatch("2104701484", new Object[]{this, noteBean, view});
            return;
        }
        k21.i(noteBean, "noteBean");
        k21.i(view, "view");
        Map<String, Action> actions = getActions();
        String str = null;
        Action action = actions != null ? actions.get(ta.PROJECT_PAGE) : null;
        Action itemAction = getItemAction();
        if (!(itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null || (args = trackInfo.getArgs()) == null)) {
            str = args.get("titlelabel");
        }
        if (action != null) {
            HashMap<String, String> args2 = action.getTrackInfo().getArgs();
            k21.h(args2, "action.trackInfo.args");
            args2.put("titlelabel", str);
            UserTrackProviderProxy.expose(view, action.getTrackInfo());
        }
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444175759")) {
            ipChange.ipc$dispatch("-1444175759", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        Object value = ((NoteModel) getModel()).getValue();
        k21.h(value, "model.value");
        ((NoteView) getView()).bindView((NoteBean) value);
    }
}

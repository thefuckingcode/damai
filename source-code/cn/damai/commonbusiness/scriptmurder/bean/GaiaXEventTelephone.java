package cn.damai.commonbusiness.scriptmurder.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.alient.gaiax.container.event.EventDelegate;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.wm2;

/* compiled from: Taobao */
public final class GaiaXEventTelephone implements EventDelegate {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String GAIAX_MAP_EVENT = "map";
    @NotNull
    public static final String GAIAX_TELEPHONES_EVENT = "telephones";
    @NotNull
    public static final String GAIAX_TELEPHONE_EVENT = "telephone";
    @Nullable
    private Activity activity;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public GaiaXEventTelephone(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    private final void openDialActivity(View view, String str, JSONObject jSONObject, Map<String, ? extends Action> map, Map<String, ? extends Object> map2) {
        ArrayList<BottomAction> arrayList;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1138253229")) {
            ipChange.ipc$dispatch("1138253229", new Object[]{this, view, str, jSONObject, map, map2});
            return;
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Action action = null;
            Action action2 = map != null ? (Action) map.get(str) : null;
            if (action2 == null) {
                action2 = map != null ? (Action) map.get("telephone") : null;
            }
            if (action2 != null) {
                action = action2;
                arrayList = wm2.INSTANCE.a(action2.getActionUrl());
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    if (!(action == null || (trackInfo = action.getTrackInfo()) == null)) {
                        k21.h(trackInfo, "trackInfo");
                        if (view != null) {
                            UserTrackProviderProxy.click(view, trackInfo, true);
                        }
                    }
                    new BottomActionDialog(activity2, arrayList, new GaiaXEventTelephone$openDialActivity$1$2$2(activity2), 0, 8, null).show();
                }
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-374688635")) {
            return this.activity;
        }
        return (Activity) ipChange.ipc$dispatch("-374688635", new Object[]{this});
    }

    @Override // com.alient.gaiax.container.event.EventDelegate
    public void onEvent(@Nullable View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, @Nullable Map<String, ? extends Action> map, @Nullable Map<String, ? extends Object> map2) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710815325")) {
            ipChange.ipc$dispatch("-1710815325", new Object[]{this, view, context, str, jSONObject, map, map2});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "eventName");
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing()) {
            if (k21.d(GAIAX_TELEPHONES_EVENT, str) || k21.d("telephone", str)) {
                openDialActivity(view, str, jSONObject, map, map2);
            } else if (k21.d("map", str) && map != null && (action = (Action) map.get(str)) != null) {
                TrackInfo trackInfo = action.getTrackInfo();
                if (trackInfo != null) {
                    k21.h(trackInfo, "trackInfo");
                    if (view != null) {
                        UserTrackProviderProxy.click(view, trackInfo, true);
                    }
                }
                NavProviderProxy.getProxy().toUri(activity2, action);
            }
        }
    }

    public final void setActivity(@Nullable Activity activity2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170768503")) {
            ipChange.ipc$dispatch("-1170768503", new Object[]{this, activity2});
            return;
        }
        this.activity = activity2;
    }
}

package tb;

import android.app.Activity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class sq2 implements UTHelperPopupCallback {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String UT_CLOSE_KEY = "close";
    @NotNull
    public static final String UT_CONFIRM_KEY = "confirm";
    @NotNull
    public static final String UT_ITEM_KEY = "item";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public sq2(@NotNull Activity activity) {
        k21.i(activity, "activity");
    }

    private final void a(HashMap<String, String> hashMap, TrackInfo trackInfo) {
        HashMap<String, String> args;
        if (hashMap != null) {
            ur2 ur2 = null;
            if (!(trackInfo.getArgs() == null || (args = trackInfo.getArgs()) == null)) {
                args.putAll(hashMap);
                ur2 = ur2.INSTANCE;
            }
            if (ur2 == null) {
                trackInfo.setArgs(hashMap);
            }
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    public void closeUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map) {
        Action action;
        TrackInfo trackInfo;
        if (map != null && map.containsKey("close") && (action = (Action) bh0.INSTANCE.f((JSON) map.get("close"), Action.class)) != null && (trackInfo = action.getTrackInfo()) != null && trackInfo.getClickEventName() != null) {
            a(hashMap, trackInfo);
            UserTrackProviderProxy.click(trackInfo, false);
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    public void confirmUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map) {
        Action action;
        TrackInfo trackInfo;
        if (map != null && map.containsKey("confirm") && (action = (Action) bh0.INSTANCE.f((JSON) map.get("confirm"), Action.class)) != null && (trackInfo = action.getTrackInfo()) != null && trackInfo.getClickEventName() != null) {
            a(hashMap, trackInfo);
            UserTrackProviderProxy.click(trackInfo, true);
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    public void exposureUt(long j, @Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map) {
        Action action;
        TrackInfo trackInfo;
        if (map != null && map.containsKey("item") && (action = (Action) bh0.INSTANCE.f((JSON) map.get("item"), Action.class)) != null && (trackInfo = action.getTrackInfo()) != null && trackInfo.getExposeEventName() != null) {
            a(hashMap, trackInfo);
            UserTrackProviderProxy.reportOriginalCustomEvent("2201", trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), String.valueOf(j), trackInfo.getArgs());
        }
    }
}

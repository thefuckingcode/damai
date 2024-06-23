package tb;

import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.text.o;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.br1;

/* compiled from: Taobao */
public final class or1 {
    @Nullable
    public static final ArrayList<String> a(@Nullable String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    i++;
                    if (!(str == null || (o.y(str)))) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static final <T> T b(@Nullable WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static final boolean c(@NotNull String str) {
        k21.i(str, "sceneName");
        ArrayList<String> g = kr1.Companion.a().g();
        if (g == null) {
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            String arrayList = g.toString();
            k21.h(arrayList, "it?.toString()");
            hashMap.put("localPopupPages", arrayList);
            if (!(!g.isEmpty()) || g.size() <= 0) {
                return false;
            }
            Iterator<String> it = g.iterator();
            while (it.hasNext()) {
                String next = it.next();
                k21.h(next, AdvanceSetting.NETWORK_TYPE);
                if (k21.d(str, next)) {
                    h(str, "localPopupPages_container", hashMap);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static final boolean d(ArrayList<String> arrayList, String str, String str2) {
        if (arrayList == null) {
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            String arrayList2 = arrayList.toString();
            k21.h(arrayList2, "sceneTypes?.toString()");
            hashMap.put("sceneTypes", arrayList2);
            hashMap.put("from", str2);
            if (!(!arrayList.isEmpty()) || arrayList.size() <= 0) {
                return false;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                k21.h(next, AdvanceSetting.NETWORK_TYPE);
                if (k21.d(str, next)) {
                    h(str, "sceneType_container", hashMap);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean e(@Nullable PopupResponseBean popupResponseBean) {
        ArrayList<PopupDetailBean> arrayList;
        PopupDetailBean popupDetailBean;
        PopupDetailBean.PopupItem popupItem;
        if (popupResponseBean == null || (arrayList = popupResponseBean.show) == null || arrayList.size() <= 0 || (popupDetailBean = arrayList.get(0)) == null || (popupItem = popupDetailBean.item) == null || popupItem.templateUrl == null) {
            return false;
        }
        return true;
    }

    public static final boolean f(@NotNull String str) {
        k21.i(str, "sceneName");
        br1.a aVar = br1.Companion;
        if (!d(aVar.a().i(), str, "net_sceneType") && !d(aVar.a().h(), str, "orange_sceneType")) {
            return d(kr1.Companion.a().h(), str, "local_sceneType");
        }
        return true;
    }

    public static final void g(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable HashMap<String, String> hashMap) {
        k21.i(str, "spmb");
        k21.i(str2, "spmc");
        k21.i(str3, "spmd");
        TrackInfo trackInfo = new TrackInfo();
        if (o.y(str)) {
            str = AgooConstants.MESSAGE_POPUP;
        }
        trackInfo.setSpmb(str);
        trackInfo.setSpmc(str2);
        trackInfo.setSpmd(str3);
        trackInfo.setArgs(hashMap);
        UserTrackProviderProxy.click(trackInfo, false);
    }

    public static final void h(@NotNull String str, @NotNull String str2, @Nullable HashMap<String, String> hashMap) {
        k21.i(str, "spmc");
        k21.i(str2, "spmd");
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpmb(AgooConstants.MESSAGE_POPUP);
        trackInfo.setSpmc(str);
        trackInfo.setSpmd(str2);
        trackInfo.setArgs(hashMap);
        UserTrackProviderProxy.click(trackInfo, false);
    }
}

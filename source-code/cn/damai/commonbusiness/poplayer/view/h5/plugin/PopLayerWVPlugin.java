package cn.damai.commonbusiness.poplayer.view.h5.plugin;

import android.media.AudioManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVRenderPolicy;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView;
import com.alibaba.poplayer.PopLayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.cr1;
import tb.dz0;
import tb.g70;

/* compiled from: Taobao */
public class PopLayerWVPlugin extends WVApiPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private final WeakReference<PopLayerWebView> mPopLayerWebView;

    public PopLayerWVPlugin(PopLayerWebView popLayerWebView) {
        this.mPopLayerWebView = new WeakReference<>(popLayerWebView);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e5  */
    private boolean jsUpdateMetaConfig(WVCallBackContext wVCallBackContext, String str, PopLayerWebView popLayerWebView) throws JSONException {
        int i;
        String optString;
        String optString2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025219221")) {
            return ((Boolean) ipChange.ipc$dispatch("-1025219221", new Object[]{this, wVCallBackContext, str, popLayerWebView})).booleanValue();
        }
        cr1.b("PopLayerWVPlugin.jsUpdateMetaConfig.params{%s}", str);
        JSONObject jSONObject = new JSONObject(str);
        IWVWebView webView = popLayerWebView.getWebView();
        String optString3 = jSONObject.optString("modalThreshold");
        if (!TextUtils.isEmpty(optString3)) {
            try {
                double parseDouble = Double.parseDouble(optString3);
                popLayerWebView.setPenetrateAlpha((int) (255.0d * parseDouble));
                webView.fireEvent("PopLayer.Configure.modalThresholdChange", new JSONObject().put("modalThreshold", parseDouble).toString());
                i = 1;
            } catch (Throwable th) {
                cr1.c("PopLayerWVPlugin.jsUpdateMetaConfig{modalThreshold}.error", th);
            }
            String str2 = WXBasicComponentType.EMBED;
            optString = jSONObject.optString(str2);
            if (!TextUtils.isEmpty(optString)) {
                boolean z = !"false".equalsIgnoreCase(optString) && !"0".equals(optString);
                ((dz0) popLayerWebView.getPopRequest()).r().embed = z;
                if (!z) {
                    str2 = "unembed";
                }
                webView.fireEvent(String.format("PopLayer.Configure.%s", str2), "");
                i++;
            }
            optString2 = jSONObject.optString("showCloseBtn");
            if (!TextUtils.isEmpty(optString2)) {
                boolean z2 = !"false".equalsIgnoreCase(optString2) && !"0".equals(optString2);
                popLayerWebView.showCloseButton(z2);
                webView.fireEvent(String.format("PopLayer.Configure.%s", z2 ? "closeBtnShow" : "closeBtnRemove"), "");
                i++;
            }
            if (i <= 0) {
                wVCallBackContext.success();
            } else {
                try {
                    webView.fireEvent("PopLayer.Configure.Error", new JSONObject().put("name", "unknownKey").put("message", "Unsupported configure name !").put("code", -1).toString());
                } catch (Throwable th2) {
                    cr1.c("PopLayerWVPlugin.jsUpdateMetaConfig.error", th2);
                }
                wVCallBackContext.error();
            }
            return true;
        }
        i = 0;
        String str22 = WXBasicComponentType.EMBED;
        optString = jSONObject.optString(str22);
        if (!TextUtils.isEmpty(optString)) {
        }
        optString2 = jSONObject.optString("showCloseBtn");
        if (!TextUtils.isEmpty(optString2)) {
        }
        if (i <= 0) {
        }
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128551109")) {
            return ((Boolean) ipChange.ipc$dispatch("1128551109", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        try {
            PopLayerWebView popLayerWebView = this.mPopLayerWebView.get();
            if (popLayerWebView == null || popLayerWebView.getWebView() == null) {
                return false;
            }
            if ("close".equals(str)) {
                popLayerWebView.close();
                cr1.b("PopLayerWVPlugin.jsClose.success", new Object[0]);
                wVCallBackContext.success();
                return true;
            } else if ("navToUrl".equals(str)) {
                cr1.b("PopLayerWVPlugin.jsNavToUrl?params=%s", str2);
                popLayerWebView.navToUrl(((JSONObject) new JSONTokener(str2).nextValue()).getString("url"));
                wVCallBackContext.success();
                return true;
            } else if ("setHardwareAccelerationEnable".equals(str)) {
                boolean optBoolean = ((JSONObject) new JSONTokener(str2).nextValue()).optBoolean("enable", false);
                boolean z2 = !WVRenderPolicy.shouldDisableHardwareRenderInLayer();
                cr1.b("PopLayerWVPlugin.jsSetHardwareAccelerationEnable?(三星4.x系列不能开启硬件加速)isWindvaneEnable=%s", Boolean.valueOf(z2));
                popLayerWebView.setHardwareAccleration(optBoolean && z2);
                wVCallBackContext.success();
                cr1.b("PopLayerWVPlugin.jsSetHardwareAccelerationEnable?enable=%s", Boolean.valueOf(optBoolean));
                return true;
            } else if ("increaseReadTimes".equals(str)) {
                dz0 dz0 = (dz0) popLayerWebView.getPopRequest();
                if (dz0 == null) {
                    wVCallBackContext.error("request is null");
                    return false;
                }
                popLayerWebView.increaseReadTimes(dz0.r().uuid);
                cr1.b("PopLayerWVPlugin.jsIncreaseReadTimes.success", new Object[0]);
                wVCallBackContext.success();
                return true;
            } else if ("setModalThreshold".equals(str)) {
                popLayerWebView.setPenetrateAlpha((int) (((JSONObject) new JSONTokener(str2).nextValue()).getDouble("modalThreshold") * 255.0d));
                cr1.b("PopLayerWVPlugin.jsSetModalThreshold?params=%s", str2);
                wVCallBackContext.success();
                return true;
            } else if ("display".equals(str)) {
                popLayerWebView.displayMe();
                cr1.b("PopLayerWVPlugin.jsDisplay.success", new Object[0]);
                wVCallBackContext.success();
                return true;
            } else if ("info".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", g70.b());
                String jSONObject2 = jSONObject.toString();
                cr1.b("PopLayerWVPlugin.jsInfo?jsonObj=%s", jSONObject2);
                wVCallBackContext.success(jSONObject2);
                return true;
            } else if ("selectAndOperate".equals(str)) {
                cr1.b("PopLayerWVPlugin.jsSelectAndOperate.params{%s}", str2);
                popLayerWebView.selectAndOperate((JSONObject) new JSONTokener(str2).nextValue());
                wVCallBackContext.success();
                return true;
            } else if ("setAlphaMode".equals(str)) {
                wVCallBackContext.success();
                return true;
            } else if ("isSoundOff".equals(str)) {
                AudioManager audioManager = (AudioManager) popLayerWebView.getContext().getSystemService("audio");
                int streamVolume = audioManager.getStreamVolume(0);
                int streamVolume2 = audioManager.getStreamVolume(1);
                int streamVolume3 = audioManager.getStreamVolume(2);
                int streamVolume4 = audioManager.getStreamVolume(3);
                int streamVolume5 = audioManager.getStreamVolume(4);
                JSONObject jSONObject3 = new JSONObject();
                if (!(streamVolume2 == 0 || streamVolume3 == 0)) {
                    if (streamVolume4 != 0) {
                        z = false;
                        jSONObject3.put("predictiveSoundOff", z).put("voice", streamVolume).put("system", streamVolume2).put("ring", streamVolume3).put("music", streamVolume4).put(NotificationCompat.CATEGORY_ALARM, streamVolume5);
                        wVCallBackContext.success(jSONObject3.toString());
                        return true;
                    }
                }
                z = true;
                jSONObject3.put("predictiveSoundOff", z).put("voice", streamVolume).put("system", streamVolume2).put("ring", streamVolume3).put("music", streamVolume4).put(NotificationCompat.CATEGORY_ALARM, streamVolume5);
                wVCallBackContext.success(jSONObject3.toString());
                return true;
            } else if ("updateMetaConfig".equals(str)) {
                return jsUpdateMetaConfig(wVCallBackContext, str2, popLayerWebView);
            } else {
                if ("operateTrackingView".equals(str)) {
                    cr1.b("PopLayerWVPlugin.jsOperateTrackingView.params{%s}", str2);
                    JSONObject jSONObject4 = new JSONObject(str2);
                    String optString = jSONObject4.optString("groupId", null);
                    String optString2 = jSONObject4.optString(PopLayer.ACTION_TRACK_INFO_KEY_OPERATION_NAME, null);
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                        wVCallBackContext.error();
                        return true;
                    }
                    popLayerWebView.fireEventToTracks(optString, optString2, jSONObject4.optString("params", null));
                    wVCallBackContext.success();
                    return true;
                } else if (WXBridgeManager.METHOD_FIRE_EVENT.equals(str)) {
                    cr1.b("PopLayerWVPlugin.jsOperateMasterView.params{%s}", str2);
                    JSONObject jSONObject5 = new JSONObject(str2);
                    String optString3 = jSONObject5.optString(PopLayer.ACTION_TRACK_INFO_KEY_OPERATION_NAME, null);
                    if (TextUtils.isEmpty(optString3)) {
                        wVCallBackContext.error();
                        return true;
                    }
                    popLayerWebView.fireEventToMasterIfExist(optString3, jSONObject5.optString("params", null));
                    wVCallBackContext.success();
                    return true;
                } else if ("getTriggerEventInfo".equals(str)) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("uri", ((dz0) popLayerWebView.getPopRequest()).s().uri);
                    jSONObject6.put("param", ((dz0) popLayerWebView.getPopRequest()).s().param);
                    String jSONObject7 = jSONObject6.toString();
                    cr1.b("PopLayerWVPlugin.jsGetTriggerEventInfo?nativeInfo=%s", jSONObject7);
                    wVCallBackContext.success(jSONObject7);
                    return true;
                } else if ("getPopLayerVersion".equals(str)) {
                    String format = String.format("\"PopLayer/%s\"", PopLayer.getReference().getVersion());
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("version", format);
                    String jSONObject9 = jSONObject8.toString();
                    cr1.b("PopLayerWVPlugin.jsPopLayerVersion?version=%s", format);
                    wVCallBackContext.success(jSONObject9);
                    return true;
                } else if ("enableRealTimeTouchMode".equals(str)) {
                    boolean optBoolean2 = ((JSONObject) new JSONTokener(str2).nextValue()).optBoolean("realTimeTouchMode", true);
                    cr1.b("PopLayerWVPlugin.enableRealTimeTouchMode=%s", Boolean.valueOf(optBoolean2));
                    popLayerWebView.setUseCacheMark(!optBoolean2);
                    wVCallBackContext.success();
                    return true;
                } else {
                    wVCallBackContext.error();
                    return false;
                }
            }
        } catch (Throwable th) {
            cr1.c(th.toString(), th);
            wVCallBackContext.error();
            return false;
        }
    }
}

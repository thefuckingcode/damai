package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.ACCSManager;
import com.uc.webview.export.extension.UCCore;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Keep
/* compiled from: Taobao */
public class WVWebPushService implements WVEventListener {
    private static final String TAG = "WVWebPushService";
    public static final /* synthetic */ int a = 0;
    private static WVWebPushService mInstance = null;
    private static final String serviceClassName = "android.taobao.windvane.extra.jsbridge.WVACCSService";
    private static final String swServiceId = "sw-push";
    private Context mContext = null;
    private Handler mMessageHandler = null;
    private List<String> mResultDataList = null;

    WVWebPushService(Context context) {
        this.mContext = context;
        try {
            ACCSManager.registerSerivce(context.getApplicationContext(), swServiceId, serviceClassName);
            if (TaoLog.getLogStatus()) {
                TaoLog.i(TAG, "ACCSManager.registerSerivce");
            }
        } catch (Exception e) {
            TaoLog.e(TAG, e.getStackTrace().toString());
        }
    }

    @Keep
    public static WVWebPushService getInstance(Context context) {
        if (mInstance == null) {
            WVWebPushService wVWebPushService = new WVWebPushService(context);
            mInstance = wVWebPushService;
            wVWebPushService.init();
        }
        return mInstance;
    }

    private void init() {
        WVEventService.getInstance().addEventListener(this);
        this.mResultDataList = new ArrayList();
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "WVEventService.getInstance().addEventListener");
        }
    }

    private void sendServiceWorkderPushMessage() {
        if (this.mResultDataList.size() > 0) {
            if (this.mMessageHandler == null) {
                this.mMessageHandler = new Handler();
            }
            this.mMessageHandler.postDelayed(new Runnable() {
                /* class android.taobao.windvane.extra.uc.WVWebPushService.AnonymousClass1 */

                public void run() {
                    WVWebPushService.this.doSendServiceWorkderPushMessage();
                }
            }, 2000);
        }
    }

    public void doSendServiceWorkderPushMessage() {
        String remove;
        try {
            if (this.mResultDataList.size() <= 0 || (remove = this.mResultDataList.remove(0)) == null) {
                return;
            }
            if (remove.length() > 0) {
                WVUCWebView wVUCWebView = new WVUCWebView(this.mContext);
                if (wVUCWebView.getCurrentViewCoreType() == 3) {
                    JSONObject jSONObject = new JSONObject(remove);
                    String optString = jSONObject.optString("workerId");
                    String optString2 = jSONObject.optString("data");
                    Bundle bundle = new Bundle();
                    bundle.putString(ALBiometricsKeys.KEY_APP_ID, optString);
                    bundle.putString("message", optString2);
                    bundle.putString("messageId", System.currentTimeMillis() + "");
                    if (TaoLog.getLogStatus()) {
                        TaoLog.i(TAG, "WVWebPushService, send message to uc core: " + bundle + ", uc core type: " + wVUCWebView.getCurrentViewCoreType());
                    }
                    UCCore.notifyCoreEvent(2, bundle, new ValueCallback<Object>() {
                        /* class android.taobao.windvane.extra.uc.WVWebPushService.AnonymousClass2 */

                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Object obj) {
                            if (obj != null) {
                                Bundle bundle = (Bundle) obj;
                                String string = bundle.getString(ALBiometricsKeys.KEY_APP_ID);
                                String string2 = bundle.getString("messageId");
                                String string3 = bundle.getString("result");
                                TaoLog.i(WVWebPushService.TAG, "sendServiceWorkerPushMessage onReceiveValue appid=" + string + ", messageId=" + string2 + ", result=" + string3);
                            }
                        }
                    });
                }
                wVUCWebView.destroy();
            }
        } catch (Throwable th) {
            TaoLog.e(TAG, "WVWebPushService,  onEvent: " + th.getMessage());
        }
    }

    public String getUtdidBySdk() {
        try {
            Method declaredMethod = UTDevice.class.getDeclaredMethod("getUtdid", Context.class);
            declaredMethod.setAccessible(true);
            String str = (String) declaredMethod.invoke(null, this.mContext);
            TaoLog.i(TAG, "getUtdidBySdk utdid: " + str);
            return str;
        } catch (Throwable th) {
            TaoLog.e(TAG, "getUtdidBySdk cd exception : " + th);
            return null;
        }
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        switch (i) {
            case 5001:
                String str = (String) objArr[0];
                String str2 = new String((byte[]) objArr[1]);
                try {
                    TaoLog.i(TAG, "WVWebPushService, " + str + ": " + str2);
                    if (!swServiceId.equalsIgnoreCase(str)) {
                        return null;
                    }
                    this.mResultDataList.add(str2);
                    sendServiceWorkderPushMessage();
                    return null;
                } catch (Throwable th) {
                    TaoLog.e(TAG, "WVWebPushService,  onEvent: " + th.getMessage());
                    return null;
                }
            case 5002:
                if (!TaoLog.getLogStatus()) {
                    return null;
                }
                TaoLog.i(TAG, "ACCS connect");
                return null;
            case 5003:
                if (!TaoLog.getLogStatus()) {
                    return null;
                }
                TaoLog.i(TAG, "ACCS disconnect");
                return null;
            default:
                return null;
        }
    }
}

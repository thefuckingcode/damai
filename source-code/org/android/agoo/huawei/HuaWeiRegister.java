package org.android.agoo.huawei;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.NotifManager;

@Deprecated
/* compiled from: Taobao */
public class HuaWeiRegister {
    private static final String TAG = "HuaWeiRegister";
    public static boolean isChannelRegister;

    private static boolean checkDevice() {
        String brand = Build.getBRAND();
        return brand.equalsIgnoreCase("huawei") || brand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR);
    }

    /* access modifiers changed from: private */
    public static void getToken(final Context context) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class org.android.agoo.huawei.HuaWeiRegister.AnonymousClass2 */

            public void run() {
                String str;
                try {
                    String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.huawei.hms.client.appid");
                    String str2 = "";
                    if (!TextUtils.isEmpty(string)) {
                        str2 = string.replace("appid=", str2);
                    }
                    ALog.i(HuaWeiRegister.TAG, "onToken", ALBiometricsKeys.KEY_APP_ID, str2);
                    if (TextUtils.isEmpty(str2)) {
                        str = HmsInstanceId.getInstance(context).getToken();
                    } else {
                        str = HmsInstanceId.getInstance(context).getToken(str2, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ALog.i(HuaWeiRegister.TAG, "onToken", "token", str);
                        NotifManager notifManager = new NotifManager();
                        notifManager.init(context);
                        notifManager.reportThirdPushToken(str, AssistConstant.TOKEN_TYPE_HW);
                    }
                } catch (Exception e) {
                    Log.e(HuaWeiRegister.TAG, "getToken failed.", e);
                }
            }
        });
    }

    public static void register(Context context) {
        registerBundle(context, false);
    }

    public static void registerBundle(final Context context, boolean z) {
        try {
            isChannelRegister = z;
            if (!z && !UtilityImpl.isMainProcess(context)) {
                ALog.e(TAG, "register not in main process, return", new Object[0]);
            } else if (!checkDevice() || Build.VERSION.SDK_INT < 17) {
                ALog.e(TAG, "register checkDevice false", new Object[0]);
            } else {
                BaseNotifyClickActivity.addNotifyListener(new HuaweiMsgParseImpl());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    /* class org.android.agoo.huawei.HuaWeiRegister.AnonymousClass1 */

                    public void run() {
                        ALog.i(HuaWeiRegister.TAG, "register begin", "isChannel", Boolean.valueOf(HuaWeiRegister.isChannelRegister));
                        HuaWeiRegister.getToken(context.getApplicationContext());
                    }
                }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "register", th, new Object[0]);
        }
    }
}

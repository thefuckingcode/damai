package com.youku.live.livesdk.wkit.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.toast.IToast;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class YKLToastUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String FIELD_NAME_HANDLER = "mHandler";
    private static final String FIELD_NAME_TN = "mTN";
    private static final String TAG = "YKLToastUtil";
    private static Toast mToast;
    private static Field sField_TN;
    private static Field sField_TN_Handler;
    private static boolean sIsHookFieldInit;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SafelyHandlerWarpper extends Handler {
        private Handler originHandler;

        public SafelyHandlerWarpper(Handler handler) {
            this.originHandler = handler;
        }

        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                Log.e(YKLToastUtil.TAG, "Catch system toast exception:" + e);
            }
        }

        public void handleMessage(Message message) {
            Handler handler = this.originHandler;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    /* compiled from: Taobao */
    public static class ToastRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context context;
        private int duration;
        private CharSequence text;

        public ToastRunnable(Context context2, CharSequence charSequence, int i) {
            this.context = context2;
            this.text = charSequence;
            this.duration = i;
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1103184797")) {
                ipChange.ipc$dispatch("1103184797", new Object[]{this});
                return;
            }
            ((IToast) Dsl.getService(IToast.class)).showCenterToast(this.context, String.valueOf(this.text));
        }
    }

    public static void cancelToast() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203776773")) {
            ipChange.ipc$dispatch("-203776773", new Object[0]);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper.getThread() == Thread.currentThread()) {
            Toast toast = mToast;
            if (toast != null) {
                toast.cancel();
                return;
            }
            return;
        }
        new Handler(mainLooper).post(new Runnable() {
            /* class com.youku.live.livesdk.wkit.utils.YKLToastUtil.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1495290672")) {
                    ipChange.ipc$dispatch("-1495290672", new Object[]{this});
                } else if (YKLToastUtil.mToast != null) {
                    YKLToastUtil.mToast.cancel();
                }
            }
        });
    }

    public static void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882665682")) {
            ipChange.ipc$dispatch("-882665682", new Object[0]);
            return;
        }
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
            mToast = null;
        }
    }

    private static void hookToast(Toast toast) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262094391")) {
            ipChange.ipc$dispatch("1262094391", new Object[]{toast});
        } else if (isNeedHook()) {
            try {
                if (!sIsHookFieldInit) {
                    Field declaredField = Toast.class.getDeclaredField(FIELD_NAME_TN);
                    sField_TN = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = sField_TN.getType().getDeclaredField(FIELD_NAME_HANDLER);
                    sField_TN_Handler = declaredField2;
                    declaredField2.setAccessible(true);
                    sIsHookFieldInit = true;
                }
                Object obj = sField_TN.get(toast);
                sField_TN_Handler.set(obj, new SafelyHandlerWarpper((Handler) sField_TN_Handler.get(obj)));
            } catch (Exception e) {
                Log.e(TAG, "Hook toast exception=" + e);
            }
        }
    }

    private static boolean isNeedHook() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943024035")) {
            return ((Boolean) ipChange.ipc$dispatch("943024035", new Object[0])).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        return i == 25 || i == 24;
    }

    public static void show(Toast toast) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726779816")) {
            ipChange.ipc$dispatch("-726779816", new Object[]{toast});
        } else if (toast != null) {
            hookToast(toast);
            toast.show();
        }
    }

    public static void showToast(Context context, CharSequence charSequence, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391653845")) {
            ipChange.ipc$dispatch("1391653845", new Object[]{context, charSequence, Integer.valueOf(i)});
            return;
        }
        ToastRunnable toastRunnable = new ToastRunnable(context, charSequence, i);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity != null && !activity.isFinishing()) {
                activity.runOnUiThread(toastRunnable);
                return;
            }
            return;
        }
        new Handler(context.getMainLooper()).post(toastRunnable);
    }

    public static void showToast(Context context, CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321985774")) {
            ipChange.ipc$dispatch("321985774", new Object[]{context, charSequence});
            return;
        }
        showToast(context, charSequence, 0);
    }
}

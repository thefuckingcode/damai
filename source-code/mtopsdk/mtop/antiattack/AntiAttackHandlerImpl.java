package mtopsdk.mtop.antiattack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.ali.user.mobile.utils.UTConstans;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
public class AntiAttackHandlerImpl implements AntiAttackHandler {
    private static final int DEFAULT_WAIT_RESULT_TIME_OUT = 20000;
    private static final String MTOPSDK_ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String MTOPSDK_ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    private static final String TAG = "mtopsdk.AntiAttackHandlerImpl";
    final BroadcastReceiver antiAttackReceiver = new BroadcastReceiver() {
        /* class mtopsdk.mtop.antiattack.AntiAttackHandlerImpl.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            Context context2;
            BroadcastReceiver broadcastReceiver;
            try {
                String stringExtra = intent.getStringExtra(UTConstans.CustomEvent.UT_REG_RESULT);
                TBSdkLog.i(AntiAttackHandlerImpl.TAG, "[onReceive]AntiAttack result: " + stringExtra);
                if ("success".equals(stringExtra)) {
                    RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).retryAllRequest(Mtop.instance(Mtop.Id.INNER, AntiAttackHandlerImpl.this.mContext), "");
                } else {
                    RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).failAllRequest(Mtop.instance(Mtop.Id.INNER, AntiAttackHandlerImpl.this.mContext), "", ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK, ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
                }
                AntiAttackHandlerImpl.this.handler.removeCallbacks(AntiAttackHandlerImpl.this.timeoutRunnable);
                AntiAttackHandlerImpl.this.isHandling.set(false);
                try {
                    AntiAttackHandlerImpl antiAttackHandlerImpl = AntiAttackHandlerImpl.this;
                    context2 = antiAttackHandlerImpl.mContext;
                    broadcastReceiver = antiAttackHandlerImpl.antiAttackReceiver;
                    context2.unregisterReceiver(broadcastReceiver);
                } catch (Exception unused) {
                    TBSdkLog.e(AntiAttackHandlerImpl.TAG, "waiting antiattack exception");
                }
            } catch (Exception unused2) {
                TBSdkLog.e(AntiAttackHandlerImpl.TAG, "[onReceive]AntiAttack exception");
                RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).failAllRequest(Mtop.instance(Mtop.Id.INNER, AntiAttackHandlerImpl.this.mContext), "", ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK, ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
                AntiAttackHandlerImpl.this.handler.removeCallbacks(AntiAttackHandlerImpl.this.timeoutRunnable);
                AntiAttackHandlerImpl.this.isHandling.set(false);
                AntiAttackHandlerImpl antiAttackHandlerImpl2 = AntiAttackHandlerImpl.this;
                context2 = antiAttackHandlerImpl2.mContext;
                broadcastReceiver = antiAttackHandlerImpl2.antiAttackReceiver;
            } catch (Throwable th) {
                AntiAttackHandlerImpl.this.handler.removeCallbacks(AntiAttackHandlerImpl.this.timeoutRunnable);
                AntiAttackHandlerImpl.this.isHandling.set(false);
                try {
                    AntiAttackHandlerImpl antiAttackHandlerImpl3 = AntiAttackHandlerImpl.this;
                    antiAttackHandlerImpl3.mContext.unregisterReceiver(antiAttackHandlerImpl3.antiAttackReceiver);
                } catch (Exception unused3) {
                    TBSdkLog.e(AntiAttackHandlerImpl.TAG, "waiting antiattack exception");
                }
                throw th;
            }
        }
    };
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final IntentFilter intentFilter = new IntentFilter(MTOPSDK_ANTI_ATTACK_RESULT_ACTION);
    final AtomicBoolean isHandling = new AtomicBoolean(false);
    final Context mContext;
    private final Runnable timeoutRunnable = new Runnable() {
        /* class mtopsdk.mtop.antiattack.AntiAttackHandlerImpl.AnonymousClass1 */

        public void run() {
            AntiAttackHandlerImpl.this.isHandling.set(false);
            RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).failAllRequest(Mtop.instance(Mtop.Id.INNER, AntiAttackHandlerImpl.this.mContext), "", ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK, ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
        }
    };

    public AntiAttackHandlerImpl(Context context) {
        this.mContext = context;
    }

    @Override // mtopsdk.mtop.antiattack.AntiAttackHandler
    public void handle(String str, String str2) {
        String sb = new StringBuilder(str).toString();
        boolean isAppBackground = XState.isAppBackground();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[handle]execute new 419 Strategy," + "location=" + sb + ", isBackground=" + isAppBackground);
        }
        if (!this.isHandling.compareAndSet(false, true)) {
            TBSdkLog.i(TAG, "isHandling");
            return;
        }
        try {
            long globalAttackAttackWaitInterval = SwitchConfig.getInstance().getGlobalAttackAttackWaitInterval();
            this.handler.postDelayed(this.timeoutRunnable, globalAttackAttackWaitInterval > 0 ? globalAttackAttackWaitInterval * 1000 : 20000);
            Intent intent = new Intent();
            intent.setAction(MTOPSDK_ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("Location", sb);
            this.mContext.startActivity(intent);
            this.mContext.registerReceiver(this.antiAttackReceiver, this.intentFilter);
        } catch (Exception e) {
            this.isHandling.set(false);
            this.handler.removeCallbacks(this.timeoutRunnable);
            RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).failAllRequest(Mtop.instance(Mtop.Id.INNER, this.mContext), "", ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK, ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
            TBSdkLog.w(TAG, "[handle] execute new 419 Strategy error.", e);
        }
    }
}

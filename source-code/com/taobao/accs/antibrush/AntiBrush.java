package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ali.user.mobile.utils.UTConstans;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.MsgDistribute;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost;
    private static volatile boolean mIsInCheckCodeActivity;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver = null;
    private Context mContext;

    /* compiled from: Taobao */
    public static class AntiReceiver extends BroadcastReceiver {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        public void onReceive(Context context, Intent intent) {
            int i = 0;
            try {
                String stringExtra = intent.getStringExtra(UTConstans.CustomEvent.UT_REG_RESULT);
                ALog.e(AntiBrush.TAG, "anti onReceive result: " + stringExtra, new Object[i]);
                i = stringExtra.equalsIgnoreCase("success");
            } catch (Exception e) {
                ALog.e(AntiBrush.TAG, "anti onReceive", e, new Object[i]);
            } finally {
                AntiBrush.onResult(GlobalClientInfo.getContext(), i);
            }
        }
    }

    public AntiBrush(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void handleantiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.e(TAG, "handleantiBrush return", "mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("Location", str);
            ALog.e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
        } catch (Throwable th) {
            ALog.e(TAG, "handleantiBrush", th, new Object[0]);
        }
    }

    public static void onResult(Context context, boolean z) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", 104);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z);
        MsgDistribute.getInstance().distribute(context, intent);
        ScheduledFuture<?> scheduledFuture = mTimeoutTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            mTimeoutTask = null;
        }
        String str = mHost;
        if (str != null) {
            UtilityImpl.storeCookie(context, CookieMgr.getCookieSec(str));
        }
    }

    public boolean checkAntiBrush(URL url, Map<Integer, String> map) {
        Throwable th;
        boolean z = true;
        if (map != null) {
            try {
                if (UtilityImpl.isForeground(this.mContext)) {
                    String str = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_STATUS.ordinal()));
                    if ((TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue()) == 419) {
                        String str2 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_LOCATION.ordinal()));
                        if (!TextUtils.isEmpty(str2)) {
                            ALog.e(TAG, "start anti bursh location:" + str2, new Object[0]);
                            handleantiBrush(str2);
                            ScheduledFuture<?> scheduledFuture = mTimeoutTask;
                            String str3 = null;
                            if (scheduledFuture != null) {
                                scheduledFuture.cancel(true);
                                mTimeoutTask = null;
                            }
                            mTimeoutTask = ThreadPoolExecutorFactory.schedule(new Runnable() {
                                /* class com.taobao.accs.antibrush.AntiBrush.AnonymousClass1 */

                                public void run() {
                                    ALog.e(AntiBrush.TAG, "anti bursh timeout", new Object[0]);
                                    AntiBrush.onResult(AntiBrush.this.mContext, false);
                                }
                            }, DateUtils.MILLIS_PER_MINUTE, TimeUnit.MILLISECONDS);
                            if (url != null) {
                                str3 = url.getHost();
                            }
                            mHost = str3;
                            if (!TextUtils.isEmpty(GlobalClientInfo.mCookieSec) && TextUtils.isEmpty(CookieMgr.getCookieSec(mHost))) {
                                ALog.e(TAG, "cookie invalid, clear", new Object[0]);
                                UtilityImpl.clearCookie(this.mContext);
                            }
                            return z;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
                ALog.e(TAG, "checkAntiBrush error", th, new Object[0]);
                return z;
            }
        }
        z = false;
        try {
            ALog.e(TAG, "cookie invalid, clear", new Object[0]);
            UtilityImpl.clearCookie(this.mContext);
        } catch (Throwable th3) {
            th = th3;
            ALog.e(TAG, "checkAntiBrush error", th, new Object[0]);
            return z;
        }
        return z;
    }
}

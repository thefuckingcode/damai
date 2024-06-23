package com.alibaba.security.rp;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.alibaba.security.rp.scanface.AuditResultCallback;

@Deprecated
/* compiled from: Taobao */
public class RPSDK {
    private static Context mCtx;

    @Deprecated
    /* compiled from: Taobao */
    public enum AUDIT {
        AUDIT_EXCEPTION(-2),
        AUDIT_NOT(-1),
        AUDIT_IN_AUDIT(0),
        AUDIT_PASS(1),
        AUDIT_FAIL(2);
        
        private int audit;

        private AUDIT(int i) {
            this.audit = i;
        }

        public final int getAudit() {
            return this.audit;
        }
    }

    @Deprecated
    /* compiled from: Taobao */
    public interface RPCompletedListener {
        void onAuditResult(AUDIT audit);
    }

    @Deprecated
    /* compiled from: Taobao */
    public enum RPSDKEnv {
        RPSDKEnv_ONLINE(0),
        RPSDKEnv_PRE(1),
        RPSDKEnv_DAILY(2);
        
        private int env;

        private RPSDKEnv(int i) {
            this.env = i;
        }
    }

    /* access modifiers changed from: private */
    public static AUDIT changeToAudit(RPResult rPResult) {
        if (rPResult == RPResult.AUDIT_FAIL) {
            return AUDIT.AUDIT_FAIL;
        }
        if (rPResult == RPResult.AUDIT_PASS) {
            return AUDIT.AUDIT_PASS;
        }
        if (rPResult == RPResult.AUDIT_IN_AUDIT) {
            return AUDIT.AUDIT_IN_AUDIT;
        }
        if (rPResult == RPResult.AUDIT_NOT) {
            return AUDIT.AUDIT_NOT;
        }
        if (rPResult == RPResult.AUDIT_EXCEPTION) {
            return AUDIT.AUDIT_EXCEPTION;
        }
        return AUDIT.AUDIT_NOT;
    }

    @Deprecated
    public static Context getContext() {
        return mCtx;
    }

    @Deprecated
    public static String getDeviceInfo() {
        return RPVerify.getDeviceInfo();
    }

    @Deprecated
    public static void initialize(RPSDKEnv rPSDKEnv, Context context) {
        mCtx = context.getApplicationContext();
        RPEnv rPEnv = RPEnv.ONLINE;
        if (rPSDKEnv == RPSDKEnv.RPSDKEnv_DAILY) {
            rPEnv = RPEnv.DAILY;
        } else if (rPSDKEnv == RPSDKEnv.RPSDKEnv_PRE) {
            rPEnv = RPEnv.PRE;
        } else {
            RPSDKEnv rPSDKEnv2 = RPSDKEnv.RPSDKEnv_ONLINE;
        }
        RPVerify.init(context, rPEnv);
    }

    @Deprecated
    public static void setContext(Context context) {
        mCtx = context;
    }

    @Deprecated
    public static void start(String str, Context context, final RPCompletedListener rPCompletedListener) {
        RPVerify.start(context, str, new RPEventListener() {
            /* class com.alibaba.security.rp.RPSDK.AnonymousClass1 */

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str, String str2) {
                RPCompletedListener rPCompletedListener = rPCompletedListener;
                if (rPCompletedListener != null) {
                    rPCompletedListener.onAuditResult(RPSDK.changeToAudit(rPResult));
                }
            }
        });
    }

    @Deprecated
    public static void startVerifyByNative(String str, final AuditResultCallback auditResultCallback) {
        Context context = mCtx;
        if (context != null) {
            RPVerify.startByNative(context, str, new RPEventListener() {
                /* class com.alibaba.security.rp.RPSDK.AnonymousClass3 */

                @Override // com.alibaba.security.realidentity.RPEventListener
                public final void onFinish(RPResult rPResult, String str, String str2) {
                    AuditResultCallback auditResultCallback = auditResultCallback;
                    if (auditResultCallback != null) {
                        auditResultCallback.onAuditStatus(rPResult.code);
                    }
                }
            });
        }
    }

    @Deprecated
    public static void startVerifyByUrl(String str, Context context, final RPCompletedListener rPCompletedListener) {
        if (!TextUtils.isEmpty(str)) {
            RPVerify.startWithUrl(context, str, new RPEventListener() {
                /* class com.alibaba.security.rp.RPSDK.AnonymousClass2 */

                @Override // com.alibaba.security.realidentity.RPEventListener
                public final void onFinish(RPResult rPResult, String str, String str2) {
                    RPCompletedListener rPCompletedListener = rPCompletedListener;
                    if (rPCompletedListener != null) {
                        rPCompletedListener.onAuditResult(RPSDK.changeToAudit(rPResult));
                    }
                }
            });
        }
    }

    @Deprecated
    public static void initialize(RPSDKEnv rPSDKEnv, Context context, String str) {
        mCtx = context.getApplicationContext();
        RPEnv rPEnv = RPEnv.ONLINE;
        if (rPSDKEnv == RPSDKEnv.RPSDKEnv_DAILY) {
            rPEnv = RPEnv.DAILY;
        } else if (rPSDKEnv == RPSDKEnv.RPSDKEnv_PRE) {
            rPEnv = RPEnv.PRE;
        } else {
            RPSDKEnv rPSDKEnv2 = RPSDKEnv.RPSDKEnv_ONLINE;
        }
        RPVerify.init(context, rPEnv, str);
    }
}

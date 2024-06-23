package com.taobao.android.sns4android.wc;

import android.app.Activity;
import android.text.TextUtils;
import cn.wh.auth.OnCallBack;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import tb.ax2;
import tb.j12;
import tb.zw2;

/* compiled from: Taobao */
public class WCSignInHelper extends SNSSignInAbstractHelper {
    public static String TAG = "login.Huawei";
    private static String mAppId;
    private static String mOrgID;
    public String SNS_TYPE = "ctid";

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements OnCallBack {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;

        a(SNSSignInListener sNSSignInListener, Activity activity) {
            this.a = sNSSignInListener;
            this.b = activity;
        }

        @Override // cn.wh.auth.OnCallBack
        public void onResult(j12 j12) {
            if (j12 == null || TextUtils.isEmpty(j12.a())) {
                WCSignInHelper.this.error(this.a, this.b);
                return;
            }
            String a2 = j12.a();
            if (com.alibaba.security.realidentity.a.q.equals(a2)) {
                String b2 = j12.b().b();
                j12.b().a();
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.snsType = WCSignInHelper.this.SNS_TYPE;
                sNSSignInAccount.token = b2;
                this.a.onSucceed(this.b, sNSSignInAccount);
            } else if (com.alibaba.security.realidentity.a.s.equals(a2)) {
                this.a.onCancel(this.b, WCSignInHelper.this.SNS_TYPE);
            } else {
                WCSignInHelper.this.error(this.a, this.b, j12.a());
            }
        }
    }

    public static WCSignInHelper create(String str, String str2) {
        mOrgID = str;
        mAppId = str2;
        return new WCSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        if (sNSSignInListener == null) {
            TLogAdapter.e(TAG, "empty listener");
            return;
        }
        try {
            new zw2(activity, new ax2(mOrgID, mAppId, "00520211229094537128225673984632", 0)).getAuthResult(new a(sNSSignInListener, activity));
        } catch (Throwable th) {
            th.printStackTrace();
            error(sNSSignInListener, activity);
        }
    }

    /* access modifiers changed from: protected */
    public void error(SNSSignInListener sNSSignInListener, Activity activity) {
        error(sNSSignInListener, activity, null);
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        auth(activity, this.snsSignInListener);
    }

    /* access modifiers changed from: protected */
    public void error(SNSSignInListener sNSSignInListener, Activity activity, String str) {
        String str2;
        if (sNSSignInListener != null) {
            if (TextUtils.isEmpty(str)) {
                str2 = "授权失败，请稍后重试";
            } else {
                str2 = "授权失败，请稍后重试:" + str;
            }
            sNSSignInListener.onError(activity, this.SNS_TYPE, 702, str2);
        }
    }
}

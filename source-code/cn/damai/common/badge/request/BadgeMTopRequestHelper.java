package cn.damai.common.badge.request;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.badge.bean.BadgeMarkResponse;
import cn.damai.common.badge.bean.BadgeQueryResponse;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ts0;
import tb.v91;
import tb.xs0;
import tb.yp;

/* compiled from: Taobao */
public class BadgeMTopRequestHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(Context context, String str, final BadgeMTopCallback badgeMTopCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482633524")) {
            ipChange.ipc$dispatch("-1482633524", new Object[]{this, context, str, badgeMTopCallback});
            return;
        }
        BadgeMarkRequest badgeMarkRequest = new BadgeMarkRequest();
        badgeMarkRequest.markString = str;
        badgeMarkRequest.request(new DMMtopRequestListener<BadgeMarkResponse>(BadgeMarkResponse.class) {
            /* class cn.damai.common.badge.request.BadgeMTopRequestHelper.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-377735197")) {
                    ipChange.ipc$dispatch("-377735197", new Object[]{this, str, str2});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback = badgeMTopCallback;
                if (badgeMTopCallback != null) {
                    badgeMTopCallback.failed(str, str2);
                }
            }

            public void onSuccess(BadgeMarkResponse badgeMarkResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1928879198")) {
                    ipChange.ipc$dispatch("-1928879198", new Object[]{this, badgeMarkResponse});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback = badgeMTopCallback;
                if (badgeMTopCallback != null) {
                    badgeMTopCallback.success(badgeMarkResponse);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(Context context, String str, final BadgeMTopCallback badgeMTopCallback) {
        JSONArray parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198405707")) {
            ipChange.ipc$dispatch("-1198405707", new Object[]{this, context, str, badgeMTopCallback});
            return;
        }
        BadgeQueryRequest badgeQueryRequest = new BadgeQueryRequest();
        badgeQueryRequest.showLoginUI(true);
        badgeQueryRequest.eCode = true;
        if (!TextUtils.isEmpty(str) && str.contains(yp.f)) {
            try {
                if ((JSON.parse(str) instanceof JSONArray) && (parseArray = JSON.parseArray(str)) != null) {
                    parseArray.remove(yp.f);
                    str = JSON.toJSONString(parseArray);
                    badgeQueryRequest.showLoginUI(false);
                    badgeQueryRequest.eCode = false;
                }
            } catch (Exception unused) {
            }
        }
        badgeQueryRequest.queryString = str;
        badgeQueryRequest.request(new DMMtopRequestListener<BadgeQueryResponse>(BadgeQueryResponse.class) {
            /* class cn.damai.common.badge.request.BadgeMTopRequestHelper.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-362216479")) {
                    ipChange.ipc$dispatch("-362216479", new Object[]{this, str, str2});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback = badgeMTopCallback;
                if (badgeMTopCallback != null) {
                    badgeMTopCallback.failed(str, str2);
                }
            }

            public void onSuccess(BadgeQueryResponse badgeQueryResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-628927563")) {
                    ipChange.ipc$dispatch("-628927563", new Object[]{this, badgeQueryResponse});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback = badgeMTopCallback;
                if (badgeMTopCallback != null) {
                    badgeMTopCallback.success(badgeQueryResponse);
                }
            }
        });
    }

    public void c(final String str, final BadgeMTopCallback badgeMTopCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944808339")) {
            ipChange.ipc$dispatch("-1944808339", new Object[]{this, str, badgeMTopCallback});
            return;
        }
        ts0.b().a(new Runnable() {
            /* class cn.damai.common.badge.request.BadgeMTopRequestHelper.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2019530316")) {
                    ipChange.ipc$dispatch("-2019530316", new Object[]{this});
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(str) && badgeMTopCallback != null) {
                        BadgeMTopRequestHelper.this.d(xs0.a().getApplicationContext(), str, badgeMTopCallback);
                    }
                } catch (Throwable th) {
                    v91.b("BadgeMTopRequestHelper", th);
                }
            }
        });
    }

    public void e(final String str, final BadgeMTopCallback badgeMTopCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539501802")) {
            ipChange.ipc$dispatch("-539501802", new Object[]{this, str, badgeMTopCallback});
            return;
        }
        ts0.b().a(new Runnable() {
            /* class cn.damai.common.badge.request.BadgeMTopRequestHelper.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1626503306")) {
                    ipChange.ipc$dispatch("-1626503306", new Object[]{this});
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(str) && badgeMTopCallback != null) {
                        BadgeMTopRequestHelper.this.f(xs0.a().getApplicationContext(), str, badgeMTopCallback);
                    }
                } catch (Throwable th) {
                    v91.b("BadgeMTopRequestHelper", th);
                }
            }
        });
    }
}

package com.huawei.hms.aaid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";
    public Context a;
    public PushPreferences b;
    public HuaweiApi<Api.ApiOptions.NoOptions> c;

    public HmsInstanceId(Context context) {
        this.a = context.getApplicationContext();
        this.b = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions.NoOptions) null, new PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300304);
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        c.c(context);
        return new HmsInstanceId(context);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (p.e(this.a)) {
                String string = i.a(this.a).getString("subjectId");
                if (TextUtils.isEmpty(string)) {
                    i.a(this.a).saveString("subjectId", str);
                } else if (!string.contains(str)) {
                    i a2 = i.a(this.a);
                    a2.saveString("subjectId", string + "," + str);
                }
            } else {
                i.a(this.a).removeKey("subjectId");
            }
        }
    }

    public final void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.b.containsKey("aaid")) {
                this.b.removeKey("aaid");
                this.b.removeKey("creationTime");
                if (o.e(this.a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.a);
                        return;
                    }
                    DeleteTokenReq b2 = o.b(this.a);
                    b2.setDeleteType(1);
                    b2.setMultiSender(false);
                    a(b2, 1);
                    BaseUtils.deleteAllTokenCache(this.a);
                }
            }
        } catch (ApiException e) {
            throw e;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a2 = o.a(this.a, str, str2);
        a2.setMultiSender(false);
        a(a2, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new j(this.a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.b.containsKey("creationTime")) {
                getAAID();
            }
            return this.b.getLong("creationTime");
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getId() {
        return o.c(this.a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b2 = o.b(this.a, null, str2);
        b2.setAaid(getId());
        b2.setMultiSender(false);
        i.a(this.a).saveString(this.a.getPackageName(), "1");
        return a(b2, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d = o.d(this.a);
            if (TextUtils.isEmpty(d)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(d)) {
                deleteToken(null, null);
            } else {
                DeleteTokenReq a2 = o.a(this.a, str);
                a2.setMultiSender(true);
                a(a2, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d = o.d(this.a);
            if (TextUtils.isEmpty(d)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(d)) {
                return getToken(null, null);
            } else {
                TokenReq b2 = o.b(this.a, str);
                b2.setAaid(getId());
                b2.setMultiSender(true);
                return a(b2, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public final String a(TokenReq tokenReq, int i) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a2 = q.a(this.a, "push.gettoken");
        try {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getToken req :");
            sb.append(tokenReq.toString());
            HMSLog.d(str, sb.toString());
            l lVar = new l("push.gettoken", tokenReq, this.a, a2);
            lVar.setApiLevel(i);
            return ((TokenResult) Tasks.await(this.c.doWrite(lVar))).getToken();
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                q.a(this.a, "push.gettoken", a2, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.gettoken", a2, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a(DeleteTokenReq deleteTokenReq, int i) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.a, subjectId, null);
            return;
        }
        String a2 = q.a(this.a, "push.deletetoken");
        try {
            String b2 = i.a(this.a).b(subjectId);
            if (!deleteTokenReq.isMultiSender() || (!TextUtils.isEmpty(b2) && !b2.equals(i.a(this.a).b(null)))) {
                deleteTokenReq.setToken(b2);
                k kVar = new k("push.deletetoken", deleteTokenReq, a2);
                kVar.setApiLevel(i);
                Tasks.await(this.c.doWrite(kVar));
                i.a(this.a).c(subjectId);
                return;
            }
            i.a(this.a).removeKey(subjectId);
            HMSLog.i(TAG, "The local subject token is null");
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                q.a(this.a, "push.deletetoken", a2, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.deletetoken", a2, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}

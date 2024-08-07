package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {
    private static final String TAG = "TaskApiCall";
    private int apiLevel = 1;
    private final String mRequestJson;
    private final String mUri;
    private Parcelable parcelable;
    private CancellationToken token;
    private String transactionId;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = null;
    }

    /* access modifiers changed from: protected */
    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.apiLevel;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getRequestJson() {
        return this.mRequestJson;
    }

    public CancellationToken getToken() {
        return this.token;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getUri() {
        return this.mUri;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.token;
        if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
            HMSLog.i(TAG, "doExecute, uri:" + this.mUri + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.transactionId);
            doExecute(clientt, responseErrorCode, str, taskCompletionSource);
            return;
        }
        HMSLog.i(TAG, "This Task has been canceled, uri:" + this.mUri + ", transactionId:" + this.transactionId);
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setParcelable(Parcelable parcelable2) {
        this.parcelable = parcelable2;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.token = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i) {
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = str3;
        this.apiLevel = i;
    }
}

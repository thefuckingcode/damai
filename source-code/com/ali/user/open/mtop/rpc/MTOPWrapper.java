package com.ali.user.open.mtop.rpc;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.exception.RpcException;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.JSONUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class MTOPWrapper {
    private static MTOPWrapper INSTANCE = null;
    private static final int MTOP_BIZ_CODE = 94;
    private static final String TAG = "login.MTOPWrapperImpl";

    private MtopRequest buildMtopRequest(RpcRequest rpcRequest) throws JSONException {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(rpcRequest.target);
        mtopRequest.setVersion(rpcRequest.version);
        mtopRequest.setNeedEcode(rpcRequest.NEED_ECODE);
        mtopRequest.setNeedSession(rpcRequest.NEED_SESSION);
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < rpcRequest.paramNames.size(); i++) {
            if (rpcRequest.paramNames.get(i) != null) {
                jSONObject.put(rpcRequest.paramNames.get(i), rpcRequest.paramValues.get(i).toString());
            }
        }
        mtopRequest.setData(jSONObject.toString());
        return mtopRequest;
    }

    private <V> RpcResponse<V> getBizRpcResponse(MtopResponse mtopResponse, Class<V> cls) {
        try {
            return getRpcResponse(mtopResponse, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized MTOPWrapper getInstance() {
        MTOPWrapper mTOPWrapper;
        synchronized (MTOPWrapper.class) {
            if (INSTANCE == null) {
                INSTANCE = new MTOPWrapper();
            }
            mTOPWrapper = INSTANCE;
        }
        return mTOPWrapper;
    }

    private <V> RpcResponse<V> getRpcResponse(MtopResponse mtopResponse, Class<V> cls) throws JSONException {
        JSONObject optJSONObject;
        RpcResponse<V> rpcResponse = new RpcResponse<>();
        byte[] bytedata = mtopResponse.getBytedata();
        if (!(bytedata == null || (optJSONObject = new JSONObject(new String(bytedata)).optJSONObject("data")) == null)) {
            rpcResponse.code = optJSONObject.optInt("code");
            rpcResponse.codeGroup = optJSONObject.optString("codeGroup");
            rpcResponse.message = optJSONObject.optString("message");
            rpcResponse.actionType = optJSONObject.optString("actionType");
            rpcResponse.success = optJSONObject.optBoolean("success");
            if (!TextUtils.isEmpty(optJSONObject.optString("returnValue"))) {
                rpcResponse.returnValue = (T) JSONUtils.parseStringValue(optJSONObject.optString("returnValue"), cls);
            }
        }
        return rpcResponse;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private <V> RpcResponse<V> processMtopResponse(MtopResponse mtopResponse, Class<V> cls) {
        if (mtopResponse != null && mtopResponse.isApiSuccess()) {
            return getBizRpcResponse(mtopResponse, cls);
        }
        if (mtopResponse == null) {
            return null;
        }
        if (mtopResponse.isNetworkError()) {
            throw new RpcException((Integer) 7, mtopResponse.getRetMsg());
        } else if (mtopResponse.isApiLockedResult()) {
            throw new RpcException((Integer) 400, mtopResponse.getRetMsg());
        } else if (mtopResponse.is41XResult()) {
            throw new RpcException((Integer) 401, mtopResponse.getRetMsg());
        } else if (mtopResponse.isExpiredRequest()) {
            throw new RpcException((Integer) 402, mtopResponse.getRetMsg());
        } else if (mtopResponse.isIllegelSign()) {
            throw new RpcException((Integer) 403, mtopResponse.getRetMsg());
        } else if (mtopResponse.isSystemError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        } else if (mtopResponse.isSessionInvalid()) {
            throw new RpcException((Integer) 407, mtopResponse.getRetMsg());
        } else if (mtopResponse.isMtopServerError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        } else if (!mtopResponse.isMtopSdkError()) {
            return getBizRpcResponse(mtopResponse, cls);
        } else {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        }
    }

    public String post(RpcRequest rpcRequest) {
        return post(rpcRequest, LoginReturnData.class).toString();
    }

    public <T> void remoteBusiness(RpcRequest rpcRequest, final Class<T> cls, final RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        if (rpcRequest != null && rpcRequestCallbackWithCode != null) {
            try {
                MtopBusiness build = MtopBusiness.build(Mtop.instance(Mtop.Id.INNER, KernelContext.applicationContext), buildMtopRequest(rpcRequest), AliMemberSDK.ttid);
                String str = "acs.waptest.taobao.com";
                String str2 = "acs.wapa.taobao.com";
                String str3 = "acs.m.taobao.com";
                if (rpcRequest.NEED_ECODE) {
                    if (!TextUtils.isEmpty(ConfigManager.getInstance().sessionOnlineDomain)) {
                        str3 = ConfigManager.getInstance().sessionOnlineDomain;
                    }
                    if (!TextUtils.isEmpty(ConfigManager.getInstance().sessionPreDomain)) {
                        str2 = ConfigManager.getInstance().sessionPreDomain;
                    }
                    if (!TextUtils.isEmpty(ConfigManager.getInstance().sessionDailyDomain)) {
                        str = ConfigManager.getInstance().sessionPreDomain;
                    }
                    build.setCustomDomain(str3, str2, str);
                } else {
                    if (!TextUtils.isEmpty(ConfigManager.getInstance().onlineDomain)) {
                        str3 = ConfigManager.getInstance().onlineDomain;
                    }
                    if (!TextUtils.isEmpty(ConfigManager.getInstance().preDomain)) {
                        str2 = ConfigManager.getInstance().preDomain;
                    }
                    if (!TextUtils.isEmpty(ConfigManager.getInstance().dailyDomain)) {
                        str = ConfigManager.getInstance().dailyDomain;
                    }
                    build.setCustomDomain(str3, str2, str);
                    build.reqMethod(MethodEnum.POST);
                }
                build.showLoginUI(rpcRequest.SHOW_LOGIN_UI);
                build.addListener((MtopListener) new IRemoteBaseListener() {
                    /* class com.ali.user.open.mtop.rpc.MTOPWrapper.AnonymousClass1 */

                    @Override // com.taobao.tao.remotebusiness.IRemoteListener
                    public void onError(int i, MtopResponse mtopResponse, Object obj) {
                        String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                        try {
                            rpcRequestCallbackWithCode.onError(retCode, MTOPWrapper.this.processMtopResponse(mtopResponse, cls));
                        } catch (RpcException e) {
                            RpcResponse rpcResponse = new RpcResponse();
                            rpcResponse.code = e.getCode();
                            rpcResponse.message = "亲，您的手机网络不太顺畅哦~";
                            rpcRequestCallbackWithCode.onError(retCode, rpcResponse);
                        }
                    }

                    @Override // com.taobao.tao.remotebusiness.IRemoteListener
                    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                        rpcRequestCallbackWithCode.onSuccess(MTOPWrapper.this.processMtopResponse(mtopResponse, cls));
                    }

                    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                        String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                        try {
                            rpcRequestCallbackWithCode.onSystemError(retCode, MTOPWrapper.this.processMtopResponse(mtopResponse, cls));
                        } catch (RpcException e) {
                            RpcResponse rpcResponse = new RpcResponse();
                            rpcResponse.code = e.getCode();
                            rpcResponse.message = "亲，您的手机网络不太顺畅哦~";
                            rpcRequestCallbackWithCode.onSystemError(retCode, rpcResponse);
                        }
                    }
                });
                build.startRequest();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public <V> RpcResponse<V> post(RpcRequest rpcRequest, Class<V> cls) {
        return post(rpcRequest, cls, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    public <V> RpcResponse<V> post(RpcRequest rpcRequest, Class<V> cls, String str) {
        MtopResponse mtopResponse;
        MtopResponse mtopResponse2;
        Exception e;
        try {
            MtopBuilder connectionTimeoutMilliSecond = Mtop.instance(Mtop.Id.INNER, KernelContext.applicationContext).build(buildMtopRequest(rpcRequest), AliMemberSDK.ttid).reqMethod(MethodEnum.POST).setBizId(94).setConnectionTimeoutMilliSecond(10000);
            if (!TextUtils.isEmpty(str)) {
                connectionTimeoutMilliSecond.setReqUserId(str);
            }
            connectionTimeoutMilliSecond.retryTime(1);
            connectionTimeoutMilliSecond.setCustomDomain(TextUtils.isEmpty(ConfigManager.getInstance().onlineDomain) ? "acs.m.taobao.com" : ConfigManager.getInstance().onlineDomain, TextUtils.isEmpty(ConfigManager.getInstance().preDomain) ? "acs.wapa.taobao.com" : ConfigManager.getInstance().preDomain, TextUtils.isEmpty(ConfigManager.getInstance().dailyDomain) ? "acs.waptest.taobao.com" : ConfigManager.getInstance().dailyDomain);
            mtopResponse = connectionTimeoutMilliSecond.syncRequest();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("receive MtopResponse = ");
                sb.append(mtopResponse);
                SDKLogger.d(TAG, sb.toString() == null ? "  null" : mtopResponse.toString());
            } catch (Exception e2) {
                mtopResponse2 = mtopResponse;
                e = e2;
                SDKLogger.e(TAG, "MtopResponse error", e);
                e.printStackTrace();
                mtopResponse = mtopResponse2;
                if (mtopResponse != null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            mtopResponse2 = null;
            SDKLogger.e(TAG, "MtopResponse error", e);
            e.printStackTrace();
            mtopResponse = mtopResponse2;
            if (mtopResponse != null) {
            }
        }
        if (mtopResponse != null) {
            return processMtopResponse(mtopResponse, cls);
        }
        SDKLogger.e(TAG, "MtopResponse response=null");
        return null;
    }
}

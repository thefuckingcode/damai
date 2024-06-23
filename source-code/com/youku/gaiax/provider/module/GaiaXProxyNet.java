package com.youku.gaiax.provider.module;

import androidx.annotation.Keep;
import cn.damai.common.net.mtop.netfit.ERROR;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.api.proxy.IProxyNet;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.provider.module.net.YYBaseMtopRequest;
import com.youku.gaiax.provider.module.util.PicXflushMonitorPoint;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import mtopsdk.mtop.domain.MtopResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u0013\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¨\u0006$"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyNet;", "Lcom/youku/gaiax/api/proxy/IProxyNet;", "", "templatesId", "Lcom/youku/gaiax/provider/module/TemplateApiModel;", "createModel", "Lcom/youku/gaiax/provider/module/net/YYBaseMtopRequest;", "requestData", "Lkotlin/Pair;", "Lmtopsdk/mtop/domain/MtopResponse;", "Lcom/alibaba/fastjson/JSONObject;", "request", "bizSceneStr", "arg", "errorCode", "errorMsg", "", "isExpect", "Ltb/ur2;", "sunfireMonitorReport", "", "throwable", "getStackTrace", "response", "getTraceId", "Lcom/youku/gaiax/api/proxy/IProxyNet$NetResponse;", "requestTemplates", "", "pageNum", Constants.Name.PAGE_SIZE, "", "timestamp", "requestTemplateWithPage", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXProxyNet implements IProxyNet {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "[GaiaX]";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyNet$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    private final TemplateApiModel createModel(String str) {
        TemplateApiModel templateApiModel = new TemplateApiModel();
        templateApiModel.setTemplateIds(str);
        return templateApiModel;
    }

    private final String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }

    private final String getTraceId(MtopResponse mtopResponse) {
        return (mtopResponse == null || mtopResponse.getHeaderFields() == null || !mtopResponse.getHeaderFields().containsKey("x-eagleeye-id") || mtopResponse.getHeaderFields().get("x-eagleeye-id") == null) ? "trace null" : String.valueOf(mtopResponse.getHeaderFields().get("x-eagleeye-id"));
    }

    private final Pair<MtopResponse, JSONObject> request(YYBaseMtopRequest yYBaseMtopRequest) {
        String stackTrace;
        yYBaseMtopRequest.showLoginUI(false);
        MtopResponse syncRequest = yYBaseMtopRequest.call().syncRequest();
        if (syncRequest == null) {
            return new Pair<>(null, null);
        }
        if (!syncRequest.isApiSuccess() || syncRequest.getDataJsonObject() == null) {
            try {
                stackTrace = JSON.toJSONString(syncRequest);
            } catch (Exception e) {
                stackTrace = getStackTrace(e);
            }
            sunfireMonitorReport(syncRequest.getApi(), stackTrace, syncRequest.getRetCode(), syncRequest.getRetMsg(), false);
            return new Pair<>(syncRequest, null);
        }
        try {
            String jSONObject = syncRequest.getDataJsonObject().toString();
            k21.h(jSONObject, "response.dataJsonObject.toString()");
            sunfireMonitorReport(syncRequest.getApi(), getTraceId(syncRequest), ERROR.MTOP_XFLUSH_SUCCESS_CODE, "", true);
            return new Pair<>(syncRequest, JSON.parseObject(jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
            sunfireMonitorReport(syncRequest.getApi(), getStackTrace(e2), syncRequest.getRetCode(), syncRequest.getRetMsg(), false);
            return new Pair<>(syncRequest, null);
        }
    }

    private final void sunfireMonitorReport(String str, String str2, String str3, String str4, boolean z) {
        try {
            PicXflushMonitorPoint picXflushMonitorPoint = new PicXflushMonitorPoint();
            if (str2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("arg", str2);
                ur2 ur2 = ur2.INSTANCE;
                picXflushMonitorPoint.setExtral(hashMap);
            }
            picXflushMonitorPoint.setBizCode(str3);
            picXflushMonitorPoint.setBizMsg(str4);
            picXflushMonitorPoint.setBizScene(str);
            picXflushMonitorPoint.setMPointName("mtop");
            picXflushMonitorPoint.setResultExpected(z);
            picXflushMonitorPoint.release();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println((Object) String.valueOf(ur2.INSTANCE));
        }
    }

    @Override // com.youku.gaiax.api.proxy.IProxyNet
    @Nullable
    public IProxyNet.NetResponse requestTemplateWithPage(int i, int i2, long j) {
        TemplateApiModel templateApiModel = new TemplateApiModel();
        templateApiModel.setPageNum(i);
        templateApiModel.setPageSize(i2);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("网络 - 请求远程模板列表 - ", JSON.toJSONString(templateApiModel)));
        }
        templateApiModel.setTimestamp(j);
        Pair<MtopResponse, JSONObject> request = request(templateApiModel);
        MtopResponse first = request.getFirst();
        if (first == null) {
            return null;
        }
        JSONObject second = request.getSecond();
        if (!first.isApiSuccess() || second == null) {
            IProxyNet.NetResponse netResponse = new IProxyNet.NetResponse();
            netResponse.setStatus("ERROR");
            netResponse.setMessage("code = " + ((Object) first.getRetCode()) + " msg = " + ((Object) first.getRetMsg()));
            if (log.isLog()) {
                log.d("[GaiaX]", k21.r("网络 - 请求远程模板列表 - 失败 - ", netResponse.getMessage()));
            }
            return netResponse;
        }
        IProxyNet.NetResponse netResponse2 = new IProxyNet.NetResponse();
        netResponse2.setStatus("SUCCESS");
        netResponse2.setData(second);
        if (!log.isLog()) {
            return netResponse2;
        }
        log.d("[GaiaX]", k21.r("网络 - 请求远程模板列表 - 成功 ", netResponse2.getData()));
        return netResponse2;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyNet
    @Nullable
    public IProxyNet.NetResponse requestTemplates(@NotNull String str) {
        IProxyNet.NetResponse netResponse;
        k21.i(str, "templatesId");
        TemplateApiModel createModel = createModel(str);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("网络 - 请求指定的模板 - ", JSON.toJSONString(createModel)));
        }
        Pair<MtopResponse, JSONObject> request = request(createModel);
        MtopResponse first = request.getFirst();
        if (first == null) {
            return null;
        }
        JSONObject second = request.getSecond();
        if (!first.isApiSuccess() || second == null) {
            netResponse = new IProxyNet.NetResponse();
            netResponse.setStatus("ERROR");
            if (log.isLog()) {
                log.d("[GaiaX]", k21.r("网络 - 请求指定的模板 - 失败 - ", netResponse.getMessage()));
            }
        } else {
            netResponse = new IProxyNet.NetResponse();
            netResponse.setStatus("SUCCESS");
            netResponse.setData(second);
            if (log.isLog()) {
                log.d("[GaiaX]", k21.r("网络 - 请求指定的模板 - 成功 ", netResponse.getData()));
            }
        }
        return netResponse;
    }
}

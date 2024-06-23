package com.alibaba.security.realidentity.http;

import android.content.Context;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.a;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.http.base.Request;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.ReflectUtil;

/* compiled from: Taobao */
public class RpcInvoker extends AbsRPCInvoker {
    private static String MTOP_INSTANCE_ID = null;
    private static final String TAG = "RpcInvoker";

    public static void callMtopAsync(Context context, String str, String str2, boolean z, String str3, MtopCallback.MtopFinishListener mtopFinishListener) {
        Mtop mtopInstance = getMtopInstance(context);
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(str);
        mtopRequest.setVersion(str2);
        mtopRequest.setData(str3);
        MtopBuilder build = mtopInstance.build(mtopRequest, a.I);
        if (z) {
            build.useWua();
        }
        build.addListener(mtopFinishListener);
        build.reqMethod(MethodEnum.POST).asyncRequest();
    }

    public static MtopResponse callMtopSync(Context context, String str, String str2, boolean z, String str3) {
        Mtop mtopInstance = getMtopInstance(context);
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(str);
        mtopRequest.setVersion(str2);
        mtopRequest.setData(str3);
        MtopBuilder build = mtopInstance.build(mtopRequest, a.I);
        if (z) {
            build.useWua();
        }
        return build.reqMethod(MethodEnum.POST).syncRequest();
    }

    private static Mtop getMtopInstance(Context context) {
        String str = MTOP_INSTANCE_ID;
        if (str == null) {
            return Mtop.instance(context.getApplicationContext());
        }
        return Mtop.instance(str, context.getApplicationContext());
    }

    public static boolean isWhite(String str) {
        if (str == null) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("mtop.verifycenter.rp.getwirelessconf");
        arrayList.add("mtop.verifycenter.rp.start");
        arrayList.add("mtop.verifycenter.rp.upload");
        arrayList.add("mtop.verifycenter.rp.submit");
        for (String str2 : arrayList) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void setMtopInstanceId(String str) {
        MTOP_INSTANCE_ID = str;
    }

    @Override // com.alibaba.security.realidentity.http.AbsRPCInvoker
    public void enqueue(Request request, final RetrofitHttpCallback retrofitHttpCallback) {
        final String path = request.path();
        String body = request.body();
        final long currentTimeMillis = System.currentTimeMillis();
        if (g.a.a.c != null) {
            callMtopAsync(g.a.a.c, path, "1.0", true, body, new MtopCallback.MtopFinishListener() {
                /* class com.alibaba.security.realidentity.http.RpcInvoker.AnonymousClass1 */

                @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
                public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                    MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    com.alibaba.security.common.c.a.a(RpcInvoker.TAG, "api:" + path + "\tcost time:" + currentTimeMillis);
                    if (RpcInvoker.isWhite(path)) {
                        g.a.a.a(TrackLog.createNetWorkCostMonitor(path, currentTimeMillis, mtopResponse == null ? "" : mtopResponse.getRetCode()));
                    }
                    if (mtopResponse == null) {
                        retrofitHttpCallback.onFailure(new IOException("response is null"));
                    } else if (!mtopResponse.isApiSuccess() || mtopResponse.getDataJsonObject() == null) {
                        RetrofitHttpCallback retrofitHttpCallback = retrofitHttpCallback;
                        retrofitHttpCallback.onFailure(new IOException(mtopResponse.getRetCode() + ":" + mtopResponse.getRetMsg()));
                    } else {
                        retrofitHttpCallback.onResponse(RpHttpResponse.create(true, mtopResponse.getDataJsonObject().toString()));
                    }
                }
            });
        } else {
            retrofitHttpCallback.onFailure(new IOException("System Application is null"));
        }
    }

    public static MtopResponse callMtopSync(Context context, String str, String str2, boolean z, Map<String, String> map) {
        Mtop mtopInstance = getMtopInstance(context);
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(str);
        mtopRequest.setVersion(str2);
        mtopRequest.setData(ReflectUtil.converMapToDataStr(map));
        MtopBuilder build = mtopInstance.build(mtopRequest, a.I);
        if (z) {
            build.useWua();
        }
        return build.reqMethod(MethodEnum.POST).syncRequest();
    }

    public static void callMtopAsync(Context context, String str, String str2, boolean z, Map<String, String> map) {
        Mtop mtopInstance = getMtopInstance(context);
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(str);
        mtopRequest.setVersion(str2);
        mtopRequest.setData(ReflectUtil.converMapToDataStr(map));
        MtopBuilder build = mtopInstance.build(mtopRequest, a.I);
        if (z) {
            build.useWua();
        }
        build.reqMethod(MethodEnum.POST).asyncRequest();
    }
}

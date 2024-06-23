package com.alibaba.emas.publish.channel.accs;

import android.util.Log;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.k.b;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.aranger.exception.IPCException;
import java.util.ArrayList;
import tb.pm;

/* compiled from: Taobao */
public class PublishAccsService extends TaoBaseService {
    private PublishAccsResponse a(String str, String str2, JSONObject jSONObject) throws Exception {
        PublishAccsResponse publishAccsResponse = new PublishAccsResponse();
        publishAccsResponse.dataId = str;
        publishAccsResponse.serviceId = str2;
        if (jSONObject != null && jSONObject.containsKey("hasUpdate")) {
            publishAccsResponse.hasUpdate = jSONObject.getBoolean("hasUpdate").booleanValue();
        }
        if (jSONObject != null && jSONObject.containsKey("updateInfo")) {
            JSONArray jSONArray = jSONObject.getJSONArray("updateInfo");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                PublishMtopUpdateInfo publishMtopUpdateInfo = new PublishMtopUpdateInfo();
                if (jSONObject2.containsKey("productId")) {
                    publishMtopUpdateInfo.productId = jSONObject2.getLongValue("productId");
                }
                if (jSONObject2.containsKey("applicationId")) {
                    publishMtopUpdateInfo.applicationId = jSONObject2.getLongValue("applicationId");
                }
                if (jSONObject2.containsKey("batchId")) {
                    publishMtopUpdateInfo.batchId = jSONObject2.getLongValue("batchId");
                }
                if (jSONObject2.containsKey(b.l)) {
                    publishMtopUpdateInfo.biz = jSONObject2.getString(b.l);
                }
                if (jSONObject2.containsKey("payload")) {
                    publishMtopUpdateInfo.payload = jSONObject2.getJSONObject("payload");
                }
                arrayList.add(publishMtopUpdateInfo);
            }
            if (arrayList.size() > 0) {
                publishAccsResponse.success = Boolean.TRUE;
                publishAccsResponse.hasUpdate = true;
                publishAccsResponse.updateInfo = arrayList;
                return publishAccsResponse;
            }
        }
        throw new RuntimeException("parse data error");
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) throws IPCException {
        Log.d("EPublish.Accs", "on bind " + i);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) throws IPCException {
        Log.d("EPublish.Accs", "on data, userId=" + str2 + " dataId=" + str3);
        PublishAccsResponse publishAccsResponse = new PublishAccsResponse();
        publishAccsResponse.dataId = str3;
        publishAccsResponse.serviceId = str;
        publishAccsResponse.source = pm.p;
        if (bArr == null || bArr.length <= 0) {
            publishAccsResponse.success = Boolean.FALSE;
            publishAccsResponse.hasUpdate = false;
            publishAccsResponse.clientRetCode = pm.h;
            publishAccsResponse.clientRetMsg = pm.i;
            EmasPublishService.getInstance().accsUpdateChannel(publishAccsResponse);
            return;
        }
        String str4 = new String(bArr);
        Log.e("EPublish.Accs", str4);
        try {
            PublishAccsResponse a = a(str3, str, JSON.parseObject(str4));
            a.source = pm.p;
            EmasPublishService.getInstance().accsUpdateChannel(a);
            Log.d("EPublish.Accs", JSON.toJSONString(a));
            PublishUtRequest publishUtRequest = new PublishUtRequest();
            publishUtRequest.dimSourceValue = pm.p;
            publishUtRequest.dimStageValue = pm.w;
            publishUtRequest.dimSuccessValue = "true";
            publishUtRequest.dimErrorCodeValue = str;
            publishUtRequest.dimErrorMsgValue = str3;
            EmasPublishService.getInstance().commitAppmonitor(publishUtRequest);
        } catch (Exception e) {
            Log.e("EPublish.Accs", "parse error", e);
            publishAccsResponse.success = Boolean.FALSE;
            publishAccsResponse.hasUpdate = false;
            publishAccsResponse.clientRetCode = pm.f;
            publishAccsResponse.clientRetMsg = pm.g;
            EmasPublishService.getInstance().accsUpdateChannel(publishAccsResponse);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) throws IPCException {
        Log.d("EPublish.Accs", "on response, dataId=" + str2);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) throws IPCException {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) throws IPCException {
        Log.d("EPublish.Accs", "on unBind " + i);
    }
}

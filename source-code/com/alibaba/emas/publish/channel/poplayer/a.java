package com.alibaba.emas.publish.channel.poplayer;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.emas.publish.EmasPublishCallback;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.ChannelService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.poplayer.PopLayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.pm;

/* compiled from: Taobao */
public class a {
    private List<PublishPopInfo> a = new ArrayList();
    private ChannelService b;
    private Boolean c;
    private Boolean d;

    private boolean b() {
        if (this.d == null) {
            try {
                Class.forName(PopLayer.class.getName());
                this.d = Boolean.TRUE;
            } catch (Throwable unused) {
                this.d = Boolean.FALSE;
            }
        }
        return this.d.booleanValue();
    }

    private boolean c() {
        if (this.c == null) {
            try {
                Class.forName(WVPluginManager.class.getName());
                this.c = Boolean.TRUE;
            } catch (Throwable unused) {
                this.c = Boolean.FALSE;
            }
        }
        return this.c.booleanValue();
    }

    public void a(String str, Boolean bool) throws Exception {
        PublishPopInfo publishPopInfo;
        Iterator<PublishPopInfo> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                publishPopInfo = null;
                break;
            }
            publishPopInfo = it.next();
            if (publishPopInfo.uri.equalsIgnoreCase(str)) {
                break;
            }
        }
        if (publishPopInfo != null) {
            PublishMtopUpdateInfo publishMtopUpdateInfo = publishPopInfo.updateInfo;
            if (publishMtopUpdateInfo == null) {
                Log.e("EPublish.Poplayer", "update info is null");
                return;
            }
            PublishUtRequest publishUtRequest = new PublishUtRequest();
            publishUtRequest.dimProductIdValue = String.valueOf(publishMtopUpdateInfo.productId);
            publishUtRequest.dimApplicationIdValue = String.valueOf(publishMtopUpdateInfo.applicationId);
            publishUtRequest.dimBatchIdValue = String.valueOf(publishMtopUpdateInfo.batchId);
            publishUtRequest.dimBizValue = publishMtopUpdateInfo.biz;
            publishUtRequest.dimStageValue = pm.u;
            publishUtRequest.dimNoticeTypeValue = pm.l;
            publishUtRequest.dimSuccessValue = "true";
            if (!bool.booleanValue()) {
                publishUtRequest.dimActionValue = pm.z;
                this.b.sendUtData(publishUtRequest);
                return;
            }
            publishUtRequest.dimActionValue = pm.y;
            this.b.sendUtData(publishUtRequest);
            EmasPublishCallback bizCallback = EmasPublishService.getInstance().getBizCallback(publishMtopUpdateInfo.biz);
            if (bizCallback != null) {
                bizCallback.updateCallback(publishMtopUpdateInfo);
                return;
            }
            Log.e("EPublish.Poplayer", "not regist callback: " + publishMtopUpdateInfo.biz);
            return;
        }
        PublishUtRequest publishUtRequest2 = new PublishUtRequest();
        publishUtRequest2.dimStageValue = pm.u;
        publishUtRequest2.dimSuccessValue = "false";
        publishUtRequest2.dimErrorCodeValue = pm.j;
        publishUtRequest2.dimErrorMsgValue = pm.k;
        this.b.sendUtData(publishUtRequest2);
        throw new RuntimeException("cannot find pop info");
    }

    public void d(ChannelService channelService) {
        try {
            this.b = channelService;
            if (c()) {
                WVPluginManager.registerPlugin("PublishPopJSBridge", (Class<? extends WVApiPlugin>) PublishPopJSBridge.class);
            }
        } catch (Exception e) {
            Log.e("EPublish.Poplayer", "init error", e);
        }
    }

    public void e(Context context, String str, JSONObject jSONObject, PublishMtopUpdateInfo publishMtopUpdateInfo) throws Exception {
        if (b()) {
            String str2 = null;
            if (jSONObject.containsKey("arg")) {
                str2 = jSONObject.getString("arg");
            }
            Intent intent = new Intent(PopLayer.ACTION_POP);
            intent.putExtra("event", str);
            if (str2 != null) {
                intent.putExtra("param", str2);
            }
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            PublishPopInfo publishPopInfo = new PublishPopInfo();
            publishPopInfo.arg = str2;
            publishPopInfo.updateInfo = publishMtopUpdateInfo;
            publishPopInfo.uri = str;
            this.a.add(publishPopInfo);
        }
    }
}

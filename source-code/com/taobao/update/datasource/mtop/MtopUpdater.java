package com.taobao.update.datasource.mtop;

import android.app.Application;
import com.alibaba.emas.publish.EmasPublishRequest;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.datasource.IUpdater;
import com.taobao.update.datasource.data.UpdateDataListener;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.datasource.mtop.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.js2;
import tb.ns2;
import tb.uo;
import tb.y91;

/* compiled from: Taobao */
public class MtopUpdater implements IUpdater {
    public static final String DEGRADE = "degrade";
    private a a;
    private List<UpdateDataListener> b = new ArrayList();
    private DegradeListener c;
    private MtopDataListener d;
    private Log e = y91.getLog(MtopUpdater.class, (Log) null);

    /* compiled from: Taobao */
    public interface DegradeListener {
        void onDegrade();
    }

    /* compiled from: Taobao */
    public interface MtopDataListener {
        void hasUpdate(String str);

        void noUpdate();
    }

    public MtopUpdater(Application application, String str, String str2, boolean z) {
        this.a = a.b.newBuilder(application).setTtid(str).setGroup(str2).setOutApk(z).setFrom(from()).build();
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void dispatchUpdate(String str, boolean z, String str2, String... strArr) {
        for (UpdateDataListener updateDataListener : new ArrayList(this.b)) {
            updateDataListener.onUpdate(str, null, z, str2, strArr);
        }
    }

    @Override // com.taobao.update.datasource.IUpdater
    public String from() {
        return js2.MTOP_SOURCE;
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void registerDataListener(UpdateDataListener updateDataListener) {
        synchronized (this.b) {
            this.b.add(updateDataListener);
        }
    }

    public MtopUpdater setDegradeListener(DegradeListener degradeListener) {
        this.c = degradeListener;
        return this;
    }

    public MtopUpdater setMtopDataListener(MtopDataListener mtopDataListener) {
        this.d = mtopDataListener;
        return this;
    }

    public void startEmasUpdate(boolean z, boolean z2) throws Exception {
        List<PublishMtopUpdateInfo> list;
        EmasPublishRequest emasPublishRequest = new EmasPublishRequest();
        emasPublishRequest.bizName = js2.MAIN;
        emasPublishRequest.currentVersion = ns2.getVersionName();
        HashMap hashMap = new HashMap();
        hashMap.put("cpuArch", String.valueOf(uo.getCpuArch()));
        if (z2) {
            hashMap.put("noticeType", "NOTICE");
        }
        emasPublishRequest.args = hashMap;
        PublishMtopResponse sendActiveMtop = EmasPublishService.getInstance().sendActiveMtop(emasPublishRequest);
        if (sendActiveMtop == null || !sendActiveMtop.hasUpdate || (list = sendActiveMtop.updateInfo) == null) {
            MtopDataListener mtopDataListener = this.d;
            if (mtopDataListener != null) {
                mtopDataListener.noUpdate();
                return;
            }
            return;
        }
        for (PublishMtopUpdateInfo publishMtopUpdateInfo : list) {
            Log log = this.e;
            log.e("dispatch mtop response:" + JSON.toJSONString(publishMtopUpdateInfo));
            MtopDataListener mtopDataListener2 = this.d;
            if (mtopDataListener2 != null) {
                mtopDataListener2.hasUpdate(JSON.toJSONString(publishMtopUpdateInfo));
            }
            dispatchUpdate(js2.EMAS_PUBLISH, z, JSON.toJSONString(publishMtopUpdateInfo), new String[0]);
        }
    }

    public void startUpdate(boolean z) {
        this.e.e("UpdateSDK use old mtop update");
        JSONObject queryUpdateInfo = this.a.queryUpdateInfo();
        if (queryUpdateInfo != null && queryUpdateInfo.containsKey("hasUpdate") && queryUpdateInfo.getBooleanValue("hasUpdate")) {
            Log log = this.e;
            log.e("dispatch mtop response:" + queryUpdateInfo.toJSONString());
            MtopDataListener mtopDataListener = this.d;
            if (mtopDataListener != null) {
                mtopDataListener.hasUpdate(queryUpdateInfo.toJSONString());
            }
            dispatchUpdate(from(), z, queryUpdateInfo.toJSONString(), new String[0]);
        } else if (queryUpdateInfo == null || !queryUpdateInfo.containsKey(DEGRADE)) {
            MtopDataListener mtopDataListener2 = this.d;
            if (mtopDataListener2 != null) {
                mtopDataListener2.noUpdate();
            }
        } else {
            DegradeListener degradeListener = this.c;
            if (degradeListener != null) {
                degradeListener.onDegrade();
            }
        }
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void unRegisterDataListener(UpdateDataListener updateDataListener) {
        synchronized (this.b) {
            this.b.remove(updateDataListener);
        }
    }
}

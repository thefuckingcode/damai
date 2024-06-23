package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import cn.damai.common.net.mtop.netfit.ERROR;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.theadpool.PriorityRunnable;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetError;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.dsl.threadpool.IThreadPool;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class MedalLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String LF_GET_ALL_MEDAL = "mtop.youku.live.paltform.medal.get";
    private static final String TAG = "MedalsConfig";
    private INetCallback mINetCallback = new INetCallback() {
        /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.MedalLoader.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dsl.network.INetCallback
        public void onFinish(INetResponse iNetResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "383256458")) {
                ipChange.ipc$dispatch("383256458", new Object[]{this, iNetResponse});
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).i(MedalLoader.TAG, "mINetCallback: " + iNetResponse.getSource());
            if (iNetResponse.isSuccess()) {
                try {
                    JSONObject optJSONObject = new JSONObject(iNetResponse.getSource()).optJSONObject("data");
                    ((ILog) Dsl.getService(ILog.class)).i(MedalLoader.TAG, "medalData= " + optJSONObject.toString());
                    if (optJSONObject.length() == 0) {
                        MedalsConfig.getInstance().updateAllMedals();
                    } else {
                        MedalLoader.this.updateAllMedal(optJSONObject);
                    }
                } catch (Exception unused) {
                    MedalsConfig.getInstance().updateAllMedals();
                }
            } else {
                MedalsConfig.getInstance().updateAllMedals();
            }
        }
    };
    private INetError mINetError = new INetError() {
        /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.MedalLoader.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dsl.network.INetError
        public void onError(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "30997368")) {
                ipChange.ipc$dispatch("30997368", new Object[]{this, str});
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).i(MedalLoader.TAG, "mINetError: " + str);
            MedalsConfig.getInstance().updateAllMedals();
        }
    };

    private void requestAllMasterMedal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724840381")) {
            ipChange.ipc$dispatch("-724840381", new Object[]{this});
            return;
        }
        String medalSignDataFromSd = LFFilePathUtils.getMedalSignDataFromSd(3);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "requestAllMasterMedal: " + medalSignDataFromSd);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("sign", medalSignDataFromSd);
            hashMap.put(ALBiometricsKeys.KEY_APP_ID, ERROR.MTOP_XFLUSH_SUCCESS_CODE);
            INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop(LF_GET_ALL_MEDAL, "1.0", hashMap, false, false);
            if (createRequestWithMTop != null) {
                createRequestWithMTop.async(this.mINetCallback, this.mINetError);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateAllMedal(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790780967")) {
            ipChange.ipc$dispatch("-1790780967", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            final String optString = jSONObject.optString("sign");
            final JSONArray optJSONArray = jSONObject.optJSONArray("medalList");
            if (optString != null || optJSONArray != null) {
                ((IThreadPool) Dsl.getService(IThreadPool.class)).excute(new PriorityRunnable() {
                    /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.MedalLoader.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "5263758")) {
                            ipChange.ipc$dispatch("5263758", new Object[]{this});
                            return;
                        }
                        String str = optString;
                        if (str != null) {
                            LFFilePathUtils.saveMedalSignDataToSd(str, 3);
                        }
                        if (optJSONArray != null) {
                            MedalsConfig.getInstance().updateAllMedals(optJSONArray);
                            LFFilePathUtils.saveAllMedalJsonDataToSd(optJSONArray.toString());
                        }
                    }
                });
            }
        }
    }

    public void startLoadMedal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643077291")) {
            ipChange.ipc$dispatch("-1643077291", new Object[]{this});
            return;
        }
        requestAllMasterMedal();
    }
}

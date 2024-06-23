package com.youku.live.dago.widgetlib.ailproom.adapter.mclient;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.powermsg.common.IPowerMsgCallback;
import com.taobao.tao.powermsg.common.IPowerMsgDispatcher;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientConfig;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.wr1;
import tb.xr1;

/* compiled from: Taobao */
public class AILPMClientPmAdapter implements AILPMClientProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG = "YKLMClientPmAdapter";
    private int mBizCode = 13;
    private AILPMClientConfig mConfig = new AILPMClientConfig.Builder().build();
    private IPowerMsgDispatcher mPowerMsgDispatcher = new IPowerMsgDispatcher() {
        /* class com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
        public void onDispatch(wr1 wr1) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "58629985")) {
                ipChange.ipc$dispatch("58629985", new Object[]{this, wr1});
            } else if (AILPMClientPmAdapter.this.mReceiverMap.get(String.valueOf(wr1.a)) != null) {
                String str = new String(wr1.f);
                Map map = AILPMClientPmAdapter.this.mReceiverMap;
                if (map.containsKey(wr1.a + "")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", str);
                    List list = (List) AILPMClientPmAdapter.this.mReceiverMap.get(String.valueOf(wr1.a));
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            ((AILPMClientProtocol.MsgReceiver) list.get(i)).onReceive(hashMap);
                        }
                    }
                }
            }
        }

        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
        public void onError(int i, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "3461284")) {
                ipChange.ipc$dispatch("3461284", new Object[]{this, Integer.valueOf(i), obj});
            }
        }
    };
    private Map<String, List<AILPMClientProtocol.MsgReceiver>> mReceiverMap = new HashMap();
    private String mTopicId;

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void connect(@Nullable Map<String, Object> map, @Nullable final AILPMClientProtocol.ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1151129139")) {
            ipChange.ipc$dispatch("1151129139", new Object[]{this, map, resultCallback});
            return;
        }
        if (map != null) {
            this.mTopicId = (String) map.get("topicId");
            int intValue = ((Integer) map.get("bizCode")).intValue();
            if (intValue > 0) {
                this.mBizCode = intValue;
            }
        }
        xr1.b(this.mBizCode, this.mPowerMsgDispatcher);
        xr1.e(this.mBizCode, this.mTopicId, 3);
        xr1.f(this.mBizCode, this.mTopicId, "youku-android", new IPowerMsgCallback() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1008613635")) {
                    ipChange.ipc$dispatch("1008613635", new Object[]{this, Integer.valueOf(i), map, objArr});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("code", Integer.valueOf(i));
                if (i == 1000) {
                    hashMap.put("msg", "success");
                    resultCallback.onSuccess(hashMap);
                    return;
                }
                map.put("msg", "failed, and check the error code");
                resultCallback.onFail(hashMap);
            }
        }, new Object[0]);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void disconnect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230671933")) {
            ipChange.ipc$dispatch("1230671933", new Object[]{this});
            return;
        }
        xr1.h(this.mBizCode, this.mTopicId, "youku-android", new IPowerMsgCallback() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "768073506")) {
                    ipChange.ipc$dispatch("768073506", new Object[]{this, Integer.valueOf(i), map, objArr});
                }
            }
        }, new Object[0]);
        this.mTopicId = null;
        this.mConfig = null;
        this.mReceiverMap.clear();
        this.mReceiverMap = null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void register(@NonNull String str, @Nullable Map<String, Object> map, @Nullable AILPMClientProtocol.MsgReceiver msgReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625428636")) {
            ipChange.ipc$dispatch("-1625428636", new Object[]{this, str, map, msgReceiver});
            return;
        }
        Map<String, List<AILPMClientProtocol.MsgReceiver>> map2 = this.mReceiverMap;
        if (map2 == null) {
            return;
        }
        if (!map2.containsKey(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(msgReceiver);
            this.mReceiverMap.put(str, arrayList);
        } else if (this.mReceiverMap.get(str) != null) {
            this.mReceiverMap.get(str).add(msgReceiver);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void sendMessage(@NonNull Map<String, Object> map, @Nullable final AILPMClientProtocol.Dispatcher dispatcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1665129123")) {
            ipChange.ipc$dispatch("1665129123", new Object[]{this, map, dispatcher});
            return;
        }
        wr1 wr1 = new wr1();
        if (map != null) {
            String str = (String) map.get("subType");
            String str2 = (String) map.get("bizCode");
            String str3 = (String) map.get("bizCode");
            String str4 = (String) map.get("data");
            String str5 = (String) map.get("userId");
            if (TextUtils.isEmpty(str3)) {
                wr1.d = this.mTopicId;
            } else {
                wr1.d = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                wr1.f = str4.getBytes();
            }
            TextUtils.isEmpty(str5);
            if (!TextUtils.isEmpty(str)) {
                wr1.a = ParseUtils.parse2Int(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                wr1.c = ParseUtils.parse2Int(str2);
            } else {
                wr1.c = this.mBizCode;
            }
            xr1.d(this.mBizCode, wr1, new IPowerMsgCallback() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
                public void onResult(int i, Map<String, Object> map, Object... objArr) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1249153764")) {
                        ipChange.ipc$dispatch("1249153764", new Object[]{this, Integer.valueOf(i), map, objArr});
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", Integer.valueOf(i));
                    if (i == 1000) {
                        hashMap.put("msg", "success");
                        dispatcher.onSucess(hashMap);
                        return;
                    }
                    hashMap.put("msg", "ailed, and check the error code");
                    dispatcher.onFail(hashMap);
                }
            }, new Object[0]);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void setConfig(@Nullable AILPMClientConfig aILPMClientConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403763644")) {
            ipChange.ipc$dispatch("-403763644", new Object[]{this, aILPMClientConfig});
            return;
        }
        this.mConfig = aILPMClientConfig;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void unregister(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302691033")) {
            ipChange.ipc$dispatch("-302691033", new Object[]{this, str});
            return;
        }
        this.mReceiverMap.remove(str);
    }
}

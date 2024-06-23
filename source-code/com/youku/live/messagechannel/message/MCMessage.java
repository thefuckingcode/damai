package com.youku.live.messagechannel.message;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.youku.live.messagechannel.connection.MCConnectionFlag;
import io.reactivex.d;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class MCMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = ALBiometricsKeys.KEY_APP_ID)
    public long appId;
    @JSONField(name = RemoteMessageConst.Notification.CHANNEL_ID)
    public String channelId;
    @JSONField(name = "connectionSource")
    public MCConnectionFlag connectionSource;
    @JSONField(name = "data")
    public byte[] data;
    @JSONField(name = "expireTime")
    public int expireTime;
    @JSONField(name = RemoteMessageConst.MSGID)
    public String msgId;
    @JSONField(name = "msgType")
    public String msgType;
    @JSONField(name = "qos")
    public String qos;
    @JSONField(name = RemoteMessageConst.SEND_TIME)
    public long sendTime;
    @JSONField(name = "statMark")
    public boolean statMark = false;

    public static List<MCMessage> parseMsgJsonToMCMessages(final MCConnectionFlag mCConnectionFlag, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150222076")) {
            return (List) ipChange.ipc$dispatch("150222076", new Object[]{mCConnectionFlag, jSONObject});
        }
        if (jSONObject != null && jSONObject.size() > 0) {
            final Long l = jSONObject.getLong(ALBiometricsKeys.KEY_APP_ID);
            final String string = jSONObject.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            JSONArray jSONArray = jSONObject.getJSONArray("datas");
            if (l != null && !TextUtils.isEmpty(string) && !jSONArray.isEmpty()) {
                return (List) d.fromIterable(jSONArray).map(new Function<Object, MCMessage>() {
                    /* class com.youku.live.messagechannel.message.MCMessage.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // io.reactivex.functions.Function
                    public MCMessage apply(Object obj) throws Exception {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "353249716")) {
                            return (MCMessage) ipChange.ipc$dispatch("353249716", new Object[]{this, obj});
                        } else if (obj == null || !(obj instanceof JSONObject)) {
                            return null;
                        } else {
                            JSONObject jSONObject = (JSONObject) obj;
                            String string = jSONObject.getString(RemoteMessageConst.MSGID);
                            String string2 = jSONObject.getString("msgType");
                            byte[] bytes = jSONObject.getBytes("data");
                            Long l = jSONObject.getLong(RemoteMessageConst.SEND_TIME);
                            String string3 = jSONObject.getString("qos");
                            Integer integer = jSONObject.getInteger("expireTime");
                            Boolean bool = jSONObject.getBoolean("statMark");
                            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || bytes == null || l == null) {
                                return null;
                            }
                            MCMessage mCMessage = new MCMessage();
                            mCMessage.connectionSource = mCConnectionFlag;
                            mCMessage.appId = l.longValue();
                            mCMessage.channelId = string;
                            mCMessage.msgId = string;
                            mCMessage.msgType = string2;
                            mCMessage.data = bytes;
                            mCMessage.sendTime = l.longValue();
                            if (TextUtils.isEmpty(string3)) {
                                string3 = QoS.DISCARD_HIGH.name();
                            }
                            mCMessage.qos = string3;
                            mCMessage.expireTime = integer != null ? integer.intValue() : -1;
                            if (bool != null) {
                                mCMessage.statMark = bool.booleanValue();
                            }
                            return mCMessage;
                        }
                    }
                }).filter(new Predicate<MCMessage>() {
                    /* class com.youku.live.messagechannel.message.MCMessage.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public boolean test(MCMessage mCMessage) throws Exception {
                        IpChange ipChange = $ipChange;
                        if (!AndroidInstantRuntime.support(ipChange, "-1840901693")) {
                            return mCMessage != null;
                        }
                        return ((Boolean) ipChange.ipc$dispatch("-1840901693", new Object[]{this, mCMessage})).booleanValue();
                    }
                }).toList().blockingGet();
            }
        }
        return new ArrayList();
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640845494")) {
            return (String) ipChange.ipc$dispatch("-1640845494", new Object[]{this});
        }
        return "MCMessage{connectionSource=" + this.connectionSource + ", appId=" + this.appId + ", channelId='" + this.channelId + '\'' + ", msgId='" + this.msgId + '\'' + ", msgType='" + this.msgType + '\'' + ", qos='" + this.qos + '\'' + ", data=" + Arrays.toString(this.data) + ", sendTime=" + this.sendTime + ", expireTime=" + this.expireTime + ", statMark=" + this.statMark + '}';
    }
}

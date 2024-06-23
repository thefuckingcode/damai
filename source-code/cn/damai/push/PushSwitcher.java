package cn.damai.push;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.user.c;
import cn.damai.push.model.PushMessageBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.accs.AgooMessage;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Random;
import tb.bh0;
import tb.c4;
import tb.g70;
import tb.g91;
import tb.jt2;
import tb.yj1;

/* compiled from: Taobao */
public class PushSwitcher {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int e;
    private Context a;
    public String b = null;
    public String c = null;
    public PushChannel d;

    /* compiled from: Taobao */
    public enum PushChannel {
        AGOO,
        XIAOMI,
        TSYNC,
        HUAWEI,
        MEIZHU,
        WANGXIN,
        MPASS,
        CMNS
    }

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        Context a;
        private String b = null;
        private String c = null;
        private PushChannel d = PushChannel.AGOO;

        public a(Context context) {
            this.a = context;
        }

        public PushSwitcher a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "165106274")) {
                return (PushSwitcher) ipChange.ipc$dispatch("165106274", new Object[]{this});
            }
            PushSwitcher pushSwitcher = new PushSwitcher(this.a);
            pushSwitcher.c = this.c;
            pushSwitcher.b = this.b;
            pushSwitcher.d = this.d;
            return pushSwitcher;
        }

        public a b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2119137043")) {
                return (a) ipChange.ipc$dispatch("-2119137043", new Object[]{this, str});
            }
            this.c = str;
            return this;
        }

        public a c(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2125433752")) {
                return (a) ipChange.ipc$dispatch("-2125433752", new Object[]{this, str});
            }
            this.b = str;
            return this;
        }

        public a d(PushChannel pushChannel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2078624522")) {
                return (a) ipChange.ipc$dispatch("2078624522", new Object[]{this, pushChannel});
            }
            this.d = pushChannel;
            return this;
        }
    }

    public PushSwitcher(Context context) {
        this.a = context;
    }

    private String a(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007891801")) {
            return (String) ipChange.ipc$dispatch("1007891801", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
            return null;
        } else {
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject.put("id", (Object) this.b);
            }
            jSONObject.put("channel", (Object) this.d.name());
            jSONObject.put("brand", (Object) Build.getBRAND());
            jSONObject.put("model", (Object) g70.b());
            jSONObject.put("android", (Object) g70.e());
            jSONObject.put("version", (Object) AppConfig.q());
            return jSONObject.toJSONString();
        }
    }

    private void b(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943300923")) {
            ipChange.ipc$dispatch("-943300923", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            HashMap hashMap = new HashMap(jt2.a(jSONObject));
            if (!TextUtils.isEmpty(this.b)) {
                hashMap.put("id", this.b);
            }
            c.e().A(hashMap, "agoo_damai_info", "push");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    private void c(Context context, String str) {
        PushMessageBean pushMessageBean;
        Exception e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661167503")) {
            ipChange.ipc$dispatch("-661167503", new Object[]{this, context, str});
            return;
        }
        AgooMessage agooMessage = new AgooMessage();
        try {
            pushMessageBean = (PushMessageBean) bh0.INSTANCE.c(str, PushMessageBean.class);
            try {
                g91.b("PushSwitcher", "agoo onMessage ,msg= " + pushMessageBean);
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            pushMessageBean = null;
            e2 = e4;
            g91.c("StackTrace", e2.toString());
            if (pushMessageBean == null) {
            }
        }
        if (pushMessageBean == null) {
            e = new Random().nextInt();
            agooMessage.setMsgId(this.b);
            agooMessage.setMsgId(this.c);
            agooMessage.setTitle(pushMessageBean.title);
            agooMessage.setText(pushMessageBean.text);
            agooMessage.setSound(1);
            agooMessage.setTag(pushMessageBean.exts.tag);
            agooMessage.setUrl(pushMessageBean.exts.url);
            agooMessage.setMsgBody(str);
            agooMessage.setNotifyId(Integer.valueOf(e));
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                agooMessage.setNotifyImportance(4);
                agooMessage.setNotifyChannelId(yj1.DEFAULT_CHANNEL_ID);
                agooMessage.setNotifyChannelName(yj1.CHANNEL_NAME);
            }
            agooMessage.setExtObj(pushMessageBean.exts);
            c4.e(context, agooMessage);
            if (i >= 16) {
                e(context, pushMessageBean);
            }
        }
    }

    private void e(Context context, PushMessageBean pushMessageBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957390557")) {
            ipChange.ipc$dispatch("-1957390557", new Object[]{this, context, pushMessageBean});
            return;
        }
        Intent intent = new Intent();
        intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
        intent.setPackage("cn.damai");
        intent.putExtra("msb", pushMessageBean);
        intent.putExtra("type", 7);
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965469615")) {
            ipChange.ipc$dispatch("-965469615", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.c)) {
            Log.e("PushSwitcher", "process 中 " + this.c);
            if (!TextUtils.isEmpty(this.c)) {
                try {
                    JSONObject parseObject = JSON.parseObject(this.c);
                    if (parseObject.containsKey("channel") && "agoo".equals(parseObject.getString("channel"))) {
                        this.d = PushChannel.AGOO;
                    }
                    a(parseObject);
                    b(parseObject);
                } catch (Exception e2) {
                    Log.e("PushSwitcher", "catch 中 " + e2);
                    Log.w("StackTrace", e2);
                }
                c(this.a, this.c);
            }
        }
    }
}

package tb;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Bundle;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.push.model.PushMessageBean;
import com.alibaba.pictures.accs.AgooMessage;
import com.alibaba.pictures.accs.DecodeOverListener;
import com.alibaba.pictures.accs.INotifyActionHandler;
import com.alibaba.pictures.accs.PushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yj1 implements INotifyActionHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String CHANNEL_NAME = "大麦应用通知";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String DEFAULT_CHANNEL_ID = "default_channel";
    @NotNull
    public static final String KEY_DMNAV_PUSH_FLAT = "KEY_DMNAV_PUSH_FLAT";
    @NotNull
    public static final String TYPE = "typestatus";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public boolean onInterceptAlarmMsg(@NotNull AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388362462")) {
            return ((Boolean) ipChange.ipc$dispatch("-388362462", new Object[]{this, agooMessage})).booleanValue();
        }
        k21.i(agooMessage, "agooMsg");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0112, code lost:
        if (tb.k21.d((r3 == null || (r3 = r3.topActivity) == null) ? null : r3.getPackageName(), tb.xs0.a().getPackageName()) == false) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0152  */
    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public void onNotifyCLick(@NotNull AgooMessage agooMessage) {
        String str;
        String str2;
        String str3;
        String url;
        Exception e;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1950001621")) {
            ipChange.ipc$dispatch("-1950001621", new Object[]{this, agooMessage});
            return;
        }
        k21.i(agooMessage, "agooMsg");
        Integer notifyId = agooMessage.getNotifyId();
        if (notifyId != null) {
            int intValue = notifyId.intValue();
            NotificationManager g = PushAgent.INSTANCE.g();
            if (g != null) {
                g.cancel(intValue);
            }
        }
        Uri uri = null;
        try {
            Object extObj = agooMessage.getExtObj();
            PushMessageBean.Exts exts = extObj instanceof PushMessageBean.Exts ? (PushMessageBean.Exts) extObj : null;
            if (exts != null) {
                str2 = exts.type;
                try {
                    str = exts.value;
                    try {
                        str3 = exts.tag;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                    g91.d(e);
                    str3 = null;
                    url = agooMessage.getUrl();
                    if (!(url != null || url.length() == 0)) {
                    }
                }
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
        } catch (Exception e4) {
            e = e4;
            str2 = null;
            str = null;
            g91.d(e);
            str3 = null;
            url = agooMessage.getUrl();
            if (!(url != null || url.length() == 0)) {
            }
        }
        url = agooMessage.getUrl();
        if (!(url != null || url.length() == 0)) {
            Bundle bundle = new Bundle();
            Integer notifyId2 = agooMessage.getNotifyId();
            if (notifyId2 != null) {
                bundle.putInt(TYPE, notifyId2.intValue());
            }
            String msgId = agooMessage.getMsgId();
            if (msgId != null) {
                bundle.putString(DamaiConstants.PUSH_MSG_ID, msgId);
            }
            String msgBody = agooMessage.getMsgBody();
            if (msgBody != null) {
                bundle.putString("data", msgBody);
            }
            String url2 = agooMessage.getUrl();
            if (url2 != null) {
                bundle.putString("url", url2);
            }
            bundle.putString("type", str2 == null ? "0" : str2);
            if (str != null) {
                bundle.putString("value", str);
            }
            if (str3 != null) {
                bundle.putString("tag", str3);
            }
            bundle.putString("AliAgooMsgID", agooMessage.getMsgId());
            bundle.putString("from", "push");
            pu2.a(agooMessage.getUrl());
            Object systemService = xs0.a().getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(1) : null;
            if (runningTasks != null && !runningTasks.isEmpty()) {
                z = false;
            }
            if (!z) {
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
            }
            bundle.putString(KEY_DMNAV_PUSH_FLAT, "true");
            uri = Uri.parse("damai://home");
            DMNav.from(xs0.a()).withExtras(bundle).stack(uri).withFlags(268435456).toUri(agooMessage.getUrl());
            c.e().A(tk.g().h(str3, str2, str), "recitem", ax0.PUSH_PAGE);
            return;
        }
        g91.c("PushMessageActivity", " push url is null");
    }

    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public void onNotifyDelete(@NotNull AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997281210")) {
            ipChange.ipc$dispatch("-997281210", new Object[]{this, agooMessage});
            return;
        }
        k21.i(agooMessage, "agooMsg");
        try {
            Object extObj = agooMessage.getExtObj();
            PushMessageBean.Exts exts = extObj instanceof PushMessageBean.Exts ? (PushMessageBean.Exts) extObj : null;
            if (exts != null) {
                c.e().A(tk.g().h(exts.tag, exts.type, exts.value), "recitem", ax0.PUSH_PAGE);
            }
        } catch (Exception e) {
            g91.d(e);
        }
    }

    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public void onNotifyImgResDecode(@Nullable String[] strArr, @NotNull DecodeOverListener decodeOverListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203504682")) {
            ipChange.ipc$dispatch("-1203504682", new Object[]{this, strArr, decodeOverListener});
            return;
        }
        k21.i(decodeOverListener, "decodeOverListener");
    }
}

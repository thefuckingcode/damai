package cn.damai.push;

import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.push.model.PushMessageBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.agoo.BaseNotifyClickActivity;
import java.util.List;
import tb.ax0;
import tb.g91;
import tb.pu2;
import tb.tk;
import tb.xf2;
import tb.yj1;

/* compiled from: Taobao */
public class PushMessageActivity extends BaseNotifyClickActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-300152336")) {
            ipChange.ipc$dispatch("-300152336", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    @Override // com.taobao.agoo.BaseNotifyClickActivity
    public void onMessage(Intent intent) {
        String stringExtra;
        PushMessageBean pushMessageBean;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662618496")) {
            ipChange.ipc$dispatch("662618496", new Object[]{this, intent});
        } else if (intent != null && (stringExtra = intent.getStringExtra("body")) != null) {
            Uri uri = null;
            try {
                pushMessageBean = (PushMessageBean) JSON.parseObject(stringExtra, PushMessageBean.class);
                try {
                    g91.c("PushSwitcher", "agoo onMessage ,msg= " + pushMessageBean);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                pushMessageBean = null;
                Log.w("StackTrace", e);
                if (pushMessageBean == null) {
                }
            }
            if (pushMessageBean == null) {
                Log.e("PushMessageActivity", "PushMessageActivity_onMessage= " + stringExtra);
                if (pushMessageBean.exts != null) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456);
                    intent2.putExtra(DamaiConstants.PUSH_MSG_ID, intent.getStringExtra("id"));
                    PushMessageBean.Exts exts = pushMessageBean.exts;
                    if (exts.type == null) {
                        exts.type = "0";
                    }
                    intent2.putExtra(DamaiConstants.PUSH_MSG_TYPE, Integer.parseInt(pushMessageBean.exts.type) + "");
                    intent2.putExtra(DamaiConstants.PUSH_MSG_SUMMARY, pushMessageBean.exts.value + "");
                    intent2.putExtra(DamaiConstants.PUSH_MSG_MESSAGE, "");
                    if (!xf2.j(pushMessageBean.exts.url)) {
                        pu2.a(pushMessageBean.exts.url);
                        Bundle bundle = new Bundle();
                        bundle.putString("from", "push");
                        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getApplicationContext().getSystemService("activity")).getRunningTasks(1);
                        if (runningTasks == null || runningTasks.size() == 0 || !(runningTasks.get(0) == null || runningTasks.get(0).topActivity == null || runningTasks.get(0).baseActivity == null || !getClass().getName().equals(runningTasks.get(0).topActivity.getClassName()) || !getClass().getName().equals(runningTasks.get(0).baseActivity.getClassName()))) {
                            bundle.putString(yj1.KEY_DMNAV_PUSH_FLAT, "true");
                            uri = Uri.parse("damai://home");
                        }
                        DMNav.from(this).stack(uri).withFlags(268435456).withExtras(bundle).toUri(pushMessageBean.exts.url);
                    } else {
                        Log.e("PushMessageActivity", " push url is null");
                    }
                    c e4 = c.e();
                    tk g = tk.g();
                    PushMessageBean.Exts exts2 = pushMessageBean.exts;
                    e4.A(g.h(exts2.tag, exts2.type, exts2.value), "recitem", ax0.PUSH_PAGE);
                    finish();
                }
            }
        }
    }
}

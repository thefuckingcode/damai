package cn.damai.ticklet.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.login.LoginManager;
import cn.damai.push.DaMaiPushAgent;
import cn.damai.push.model.AckMessageDO;
import cn.damai.push.model.PushMessageBean;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.manager.DataHelper;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.activity.TicketDetailAcceptTransferActivity;
import cn.damai.ticklet.ui.activity.TicketPerformanceNoticeActivity;
import cn.damai.ticklet.ui.activity.TicketSouvenirActivity;
import cn.damai.ticklet.ui.activity.TickletAttendanceActivity;
import cn.damai.ticklet.ui.activity.TickletFaceSettingActivity;
import cn.damai.ticklet.ui.activity.TickletListActivity;
import cn.damai.ticklet.ui.activity.TickletTransferManageActivity;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import tb.b30;
import tb.d20;
import tb.fl2;
import tb.g91;
import tb.gl2;
import tb.hl2;
import tb.hp;
import tb.i3;
import tb.i30;
import tb.pl2;
import tb.ql2;
import tb.rc1;
import tb.s41;
import tb.sl2;
import tb.vl2;
import tb.xs0;
import tb.yf2;

/* compiled from: Taobao */
public class TickletExternalCallBrodcast extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ PushMessageBean b;

        a(Activity activity, PushMessageBean pushMessageBean) {
            this.a = activity;
            this.b = pushMessageBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "342679940")) {
                ipChange.ipc$dispatch("342679940", new Object[]{this, view});
                return;
            }
            TickletExternalCallBrodcast.this.g(this.a, this.b);
        }
    }

    private void b(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116396514")) {
            ipChange.ipc$dispatch("-116396514", new Object[]{this, str, str2, str3});
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        AckMessageDO ackMessageDO = new AckMessageDO();
        ackMessageDO.setBizType(str3);
        ackMessageDO.setDataId(str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                TicketDeatilResult ticketDeatilResult = (TicketDeatilResult) s41.a(str, TicketDeatilResult.class);
                if (ticketDeatilResult != null) {
                    DataHelper.getInstance().saveOrUpdateTicketDetailResult(ticketDeatilResult, gl2.b);
                }
            } catch (Exception unused) {
                ackMessageDO.setResultCode("0");
                ackMessageDO.setProcessTime(String.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                DaMaiPushAgent.i(str2, JSON.toJSONBytes(ackMessageDO, new SerializerFeature[0]));
            }
        } else {
            i("", "accs解析json为null");
        }
    }

    private void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1882222507")) {
            ipChange.ipc$dispatch("1882222507", new Object[]{this, str});
            return;
        }
        c.e().A(sl2.j().i(str), sl2.CUSTOM_ACCS_TICKLET, sl2.TICKLET_DETAIL_PAGE);
        UserTicketTable userTicketTable = (UserTicketTable) s41.a(str, UserTicketTable.class);
        if (userTicketTable != null) {
            if (hl2.a().booleanValue()) {
                DataHelper.getInstance().updataTicketState(userTicketTable);
            }
            pl2.a().b(userTicketTable);
            new rc1(2).b("update_ticklet", userTicketTable.getPerformId());
        }
    }

    private void d(Messenger messenger) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011412126")) {
            ipChange.ipc$dispatch("1011412126", new Object[]{this, messenger});
            return;
        }
        List<PerformTable> performNoStartListFilterByEndTime = DataHelper.getInstance().getPerformNoStartListFilterByEndTime(1, 5, 5, b30.a());
        g91.b("ExternalCallBrodcast", "获取未使用场次列表成功" + performNoStartListFilterByEndTime.size());
        Message obtain = Message.obtain();
        if (performNoStartListFilterByEndTime.size() > 0) {
            PerformTable performTable = performNoStartListFilterByEndTime.get(0);
            UserTicketTable aboutToBeginFirstTicket = DataHelper.getInstance().getAboutToBeginFirstTicket(performTable.getPerformId());
            String B = d20.B(performTable.productSystemId + performTable.getPerformId());
            if (!TextUtils.isEmpty(B) && B.equals("true")) {
                if (messenger != null) {
                    try {
                        obtain.what = 5;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                obtain.obj = null;
                messenger.send(obtain);
                g91.b("ExternalCallBrodcast", "本场次不提醒");
                return;
            } else if (aboutToBeginFirstTicket != null && !TextUtils.isEmpty(aboutToBeginFirstTicket.getVoucherType())) {
                HashMap hashMap = new HashMap();
                hashMap.put("projectName", performTable.getProjectName());
                hashMap.put("projectType", aboutToBeginFirstTicket.getVoucherType());
                hashMap.put("projectBeginTime", String.valueOf(performTable.getStartTimeByLong()));
                hashMap.put(TicketDetailExtFragment.PERFORM_ID, performTable.getPerformId());
                hashMap.put(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, performTable.getProductSystemId());
                obtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", hashMap);
                obtain.setData(bundle);
                if (messenger != null) {
                    try {
                        messenger.send(obtain);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                g91.b("ExternalCallBrodcast", "发送获取未使用场次列表成功" + performNoStartListFilterByEndTime.size());
                return;
            }
        }
        if (messenger != null) {
            try {
                obtain.what = 5;
            } catch (RemoteException e3) {
                e3.printStackTrace();
                return;
            }
        }
        obtain.obj = null;
        messenger.send(obtain);
        g91.b("ExternalCallBrodcast", "表中无数据");
    }

    private boolean e(PushMessageBean pushMessageBean) {
        PushMessageBean.Exts exts;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388792714")) {
            return ((Boolean) ipChange.ipc$dispatch("-1388792714", new Object[]{this, pushMessageBean})).booleanValue();
        }
        if (!f() && pushMessageBean != null && (exts = pushMessageBean.exts) != null && !TextUtils.isEmpty(exts.url)) {
            String str = exts.url;
            if (str.contains("TicketReceivePage") || str.contains("TicketDetailPage")) {
                return true;
            }
        }
        return false;
    }

    private boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1280054580")) {
            return ((Boolean) ipChange.ipc$dispatch("1280054580", new Object[]{this})).booleanValue();
        }
        Activity c = i3.b().c();
        if (c != null) {
            String[] split = c.getLocalClassName().split("\\.");
            String str = split.length > 0 ? split[split.length - 1] : "";
            if (str.equals(TickletListActivity.class.getSimpleName()) || str.equals(TickletVenueActivity.class.getSimpleName()) || str.equals(TickletTransferManageActivity.class.getSimpleName()) || str.equals(TickletAttendanceActivity.class.getSimpleName()) || str.equals(TicketPerformanceNoticeActivity.class.getSimpleName()) || str.equals(TicketDetailAcceptTransferActivity.class.getSimpleName()) || str.equals(TicketDeatilActivity.class.getSimpleName()) || str.equals(TicketSouvenirActivity.class.getSimpleName()) || str.equals(TickletFaceSettingActivity.class.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(Activity activity, PushMessageBean pushMessageBean) {
        PushMessageBean.Exts exts;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214589284")) {
            ipChange.ipc$dispatch("-1214589284", new Object[]{this, activity, pushMessageBean});
        } else if (pushMessageBean != null && (exts = pushMessageBean.exts) != null && exts != null && !TextUtils.isEmpty(exts.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", exts.url);
            c.e().A(hashMap, "transferconfim_push_click", sl2.TICKLET_TRANSFER_CONDIRM_PAGE);
            Bundle bundle = new Bundle();
            bundle.putString("from", "push");
            DMNav.from(activity).withExtras(bundle).toUri(exts.url);
        }
    }

    private void h(PushMessageBean pushMessageBean) {
        Activity c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920719046")) {
            ipChange.ipc$dispatch("1920719046", new Object[]{this, pushMessageBean});
        } else if (e(pushMessageBean) && (c = i3.b().c()) != null) {
            PushMessageBean.Exts exts = pushMessageBean.exts;
            HashMap hashMap = new HashMap();
            if (exts != null && !TextUtils.isEmpty(exts.type) && !TextUtils.isEmpty(exts.value)) {
                hashMap.put("url", exts.url);
            }
            c.e().A(hashMap, "transferconfim_push", sl2.TICKLET_TRANSFER_CONDIRM_PAGE);
            View inflate = LayoutInflater.from(xs0.a().getApplicationContext()).inflate(R$layout.common_ticklet_toast_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.push_bar_title);
            TextView textView2 = (TextView) inflate.findViewById(R$id.push_bar_text);
            if (!TextUtils.isEmpty(pushMessageBean.title)) {
                textView.setText(pushMessageBean.title);
            }
            if (!TextUtils.isEmpty(pushMessageBean.text)) {
                textView2.setText(pushMessageBean.text);
            }
            inflate.setOnClickListener(new a(c, pushMessageBean));
            hp.v(c, inflate).y();
        }
    }

    private void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399056087")) {
            ipChange.ipc$dispatch("-1399056087", new Object[]{this, str, str2});
            return;
        }
        vl2.d(vl2.f(str2, "mtop.damai.wireless.ticklet2.performs.preload", str, str2, null), vl2.TICKLET_PRELOAD_ACCS_DB_ERROR_CODE, str, vl2.TICKLET_PRELOAD_ACCS_DB_ERROR_MSG);
    }

    public void onReceive(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940036485")) {
            ipChange.ipc$dispatch("940036485", new Object[]{this, context, intent});
            return;
        }
        fl2.a();
        if (intent != null && !TextUtils.isEmpty(intent.getAction()) && DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION.equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("type", -1);
            if (intExtra == 7) {
                Serializable serializableExtra = intent.getSerializableExtra("msb");
                if (serializableExtra != null && (serializableExtra instanceof PushMessageBean)) {
                    h((PushMessageBean) serializableExtra);
                }
            } else if (intExtra == 3 && hl2.a().booleanValue() && LoginManager.k().q()) {
                TicketSyncHelper.f(Boolean.valueOf(intent.getBooleanExtra("downTime", false)), intent.getStringExtra("from"));
            } else if (intExtra == 6 && hl2.a().booleanValue() && LoginManager.k().q()) {
                b(intent.getStringExtra("performJson"), intent.getStringExtra(Constants.KEY_DATA_ID), intent.getStringExtra("bizType"));
            } else if (intExtra == 4) {
                i30.e().a(xs0.a());
            } else if (intExtra == 2) {
                if (intent.getExtras() == null || !LoginManager.k().q() || !hl2.a().booleanValue()) {
                    Messenger messenger = (Messenger) intent.getExtras().get("messenger");
                    Message obtain = Message.obtain();
                    if (messenger != null) {
                        try {
                            obtain.what = 5;
                            obtain.obj = null;
                            messenger.send(obtain);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    g91.b("ExternalCallBrodcast", "表中无数据");
                } else {
                    d((Messenger) intent.getExtras().get("messenger"));
                }
            } else if (intExtra == 8 && LoginManager.k().q()) {
                String stringExtra = intent.getStringExtra("updateticket");
                g91.b("ExternalCallBrodcast", stringExtra);
                if (!yf2.c(stringExtra)) {
                    c(stringExtra);
                } else {
                    return;
                }
            } else if (intExtra == 9) {
                ql2.a(context);
            }
            g91.b("ExternalCallBrodcast", "type= " + intExtra);
        }
    }
}

package cn.damai.commonbusiness.coupondialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.coupondialog.net.CouponClearRequest;
import cn.damai.commonbusiness.coupondialog.net.CouponClearResponse;
import cn.damai.commonbusiness.coupondialog.net.CouponListRequest;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.br;
import tb.co;
import tb.d20;
import tb.g91;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class CouponDialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static CouponDialogHelper l;
    private CouponListResponse a;
    private boolean b;
    private boolean c;
    private Context d;
    private boolean e;
    private CouponDialog f;
    private boolean g;
    private String h;
    private String i;
    private long j;
    private int k;

    /* compiled from: Taobao */
    public class a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        a(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "34967213")) {
                ipChange.ipc$dispatch("34967213", new Object[]{this});
                return;
            }
            g91.b("CouponDialogHelper", "TimeCountDown finished.");
            if (!CouponDialogHelper.this.g && CouponDialogHelper.this.e) {
                ToastUtil.a().e(xs0.a(), "仅限新用户领取");
                CouponDialogHelper.this.c = true;
            }
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-437741823")) {
                ipChange.ipc$dispatch("-437741823", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1947047672")) {
                ipChange.ipc$dispatch("-1947047672", new Object[]{this, dialogInterface});
            } else if (CouponDialogHelper.this.f != null) {
                if (CouponDialogHelper.this.f.j()) {
                    CouponDialogHelper couponDialogHelper = CouponDialogHelper.this;
                    couponDialogHelper.u(couponDialogHelper.f.g(), CouponDialogHelper.this.f.h());
                }
                CouponDialogHelper couponDialogHelper2 = CouponDialogHelper.this;
                couponDialogHelper2.s(couponDialogHelper2.f);
                CouponDialogHelper.this.f = null;
                CouponDialogHelper.this.z(true);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DialogInterface.OnShowListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onShow(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-286145312")) {
                ipChange.ipc$dispatch("-286145312", new Object[]{this, dialogInterface});
                return;
            }
            CouponDialogHelper.this.t();
            CouponDialogHelper.this.q();
        }
    }

    private CouponDialogHelper() {
    }

    public static synchronized CouponDialogHelper l(Context context) {
        synchronized (CouponDialogHelper.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2101615689")) {
                return (CouponDialogHelper) ipChange.ipc$dispatch("-2101615689", new Object[]{context});
            }
            if (l == null) {
                l = new CouponDialogHelper();
            }
            CouponDialogHelper couponDialogHelper = l;
            couponDialogHelper.d = context;
            return couponDialogHelper;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783196252")) {
            ipChange.ipc$dispatch("-783196252", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().A(new HashMap(), "damai_redpacket_layer_event", "redpacket_layer");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085588076")) {
            ipChange.ipc$dispatch("-2085588076", new Object[]{this});
            return;
        }
        int z = d20.z();
        if (z == 1) {
            g91.b("CouponDialogHelper", "requestRedPacketRequest()");
            CouponListRequest couponListRequest = new CouponListRequest();
            couponListRequest.type = String.valueOf(z);
            couponListRequest.request(new DMMtopRequestListener<CouponListResponse>(CouponListResponse.class) {
                /* class cn.damai.commonbusiness.coupondialog.CouponDialogHelper.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-649963241")) {
                        ipChange.ipc$dispatch("-649963241", new Object[]{this, str, str2});
                        return;
                    }
                    if (CouponDialogHelper.this.g && CouponDialogHelper.this.b) {
                        CouponDialogHelper.this.D("请在“我的优惠券”查看领取结果");
                    }
                    CouponDialogHelper.this.x(0);
                }

                public void onSuccess(CouponListResponse couponListResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1515753132")) {
                        ipChange.ipc$dispatch("1515753132", new Object[]{this, couponListResponse});
                        return;
                    }
                    CouponDialogHelper.this.a = couponListResponse;
                    CouponDialogHelper.this.C();
                }
            });
        }
    }

    public void A(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31245384")) {
            ipChange.ipc$dispatch("31245384", new Object[]{this, str});
            return;
        }
        B(str, "");
    }

    public void B(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872466926")) {
            ipChange.ipc$dispatch("-1872466926", new Object[]{this, str, str2});
            return;
        }
        this.h = str;
        this.i = str2;
    }

    public void C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591093414")) {
            ipChange.ipc$dispatch("1591093414", new Object[]{this});
        } else if (this.a != null && this.e) {
            if (this.f == null) {
                this.f = new CouponDialog(this.d);
            }
            if (!this.f.isShowing()) {
                this.f.o(this.h, this.i);
                this.f.n(this.a.model);
                g91.b("CouponDialogHelper", "to show dialog.");
                this.f.setOnDismissListener(new b());
                this.f.setOnShowListener(new c());
                Context context = this.d;
                if (context != null && (context instanceof Activity) && !((BaseActivity) context).isActivityFinsihed()) {
                    if (this.f.isShowing()) {
                        this.f.dismiss();
                    }
                    this.f.p();
                }
            }
        }
    }

    public void D(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603950631")) {
            ipChange.ipc$dispatch("-1603950631", new Object[]{this, str});
        } else if (this.e && this.d != null && !this.c) {
            ToastUtil.a().e(xs0.a(), str);
            y(false);
        }
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2111303750")) {
            return this.b;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2111303750", new Object[]{this})).booleanValue();
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623914882")) {
            ipChange.ipc$dispatch("623914882", new Object[]{this});
            return;
        }
        this.e = false;
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-485688635")) {
            ipChange.ipc$dispatch("-485688635", new Object[]{this});
            return;
        }
        this.e = true;
        C();
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266019553")) {
            ipChange.ipc$dispatch("-1266019553", new Object[]{this});
        } else if (this.b) {
            new a(3000, 1000).start();
            g91.b("CouponDialogHelper", "openTimeCountDown");
        }
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007012776")) {
            ipChange.ipc$dispatch("-2007012776", new Object[]{this});
            return;
        }
        this.j = System.currentTimeMillis();
    }

    public void r(br brVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48165560")) {
            ipChange.ipc$dispatch("-48165560", new Object[]{this, brVar});
            return;
        }
        brVar.b(DamaiConstants.RED_PACKET, new Action<Object>() {
            /* class cn.damai.commonbusiness.coupondialog.CouponDialogHelper.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.message.observer.Action
            public void call(Object obj) {
                IpChange ipChange = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-543201732")) {
                    ipChange.ipc$dispatch("-543201732", new Object[]{this, obj});
                    return;
                }
                g91.b("CouponDialogHelper", "message on call()");
                if (obj != null && (obj instanceof Integer)) {
                    i = ((Integer) obj).intValue();
                }
                g91.b("CouponDialogHelper", "curType = " + i + ", type = " + CouponDialogHelper.this.k);
                CouponDialogHelper.this.g = true;
                if (CouponDialogHelper.this.k != i) {
                    CouponDialogHelper.this.x(i);
                    new Handler().postDelayed(new Runnable() {
                        /* class cn.damai.commonbusiness.coupondialog.CouponDialogHelper.AnonymousClass1.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1890974412")) {
                                ipChange.ipc$dispatch("-1890974412", new Object[]{this});
                                return;
                            }
                            CouponDialogHelper.this.w();
                        }
                    }, 1000);
                }
            }
        });
        g91.b("CouponDialogHelper", "registerRedPacketReceiver");
    }

    public void s(CouponDialog couponDialog) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211415679")) {
            ipChange.ipc$dispatch("-1211415679", new Object[]{this, couponDialog});
        } else if (couponDialog != null) {
            try {
                List<View> i2 = couponDialog.i();
                int e2 = xf2.e(i2);
                for (int i3 = 0; i3 < e2; i3++) {
                    CouponListResponse.Coupon coupon = (CouponListResponse.Coupon) i2.get(i3).getTag();
                    co.f().g(coupon.startShowTimeMillis, this.h, coupon.eventTrack, i3);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void u(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751313622")) {
            ipChange.ipc$dispatch("-1751313622", new Object[]{this, str, str2});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(this.i)) {
                hashMap.put("city", d20.d() + "市");
                hashMap.put("usercode", d20.E());
            } else {
                hashMap.put("item_id", this.i);
                hashMap.put("usercode", d20.E());
            }
            hashMap.put("eventTrack", str2);
            cn.damai.common.user.c.e().C("use", "redpaper", this.h, "1.0", System.currentTimeMillis() - this.j, hashMap, 2201);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void v() {
        List<CouponListResponse.Model> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914325038")) {
            ipChange.ipc$dispatch("914325038", new Object[]{this});
            return;
        }
        CouponClearRequest couponClearRequest = new CouponClearRequest();
        CouponListResponse couponListResponse = this.a;
        if (!(couponListResponse == null || (list = couponListResponse.model) == null || list.size() <= 0 || this.a.model.get(0).contentList == null || this.a.model.get(0).contentList.size() <= 0)) {
            couponClearRequest.id = this.a.model.get(0).contentList.get(0).id;
            couponClearRequest.type = this.a.model.get(0).type;
        }
        couponClearRequest.request(new DMMtopRequestListener<CouponClearResponse>(CouponClearResponse.class) {
            /* class cn.damai.commonbusiness.coupondialog.CouponDialogHelper.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-673241318")) {
                    ipChange.ipc$dispatch("-673241318", new Object[]{this, str, str2});
                    return;
                }
                g91.b("ClearCouponFalse", "ClearCoupon onFail");
            }

            public void onSuccess(CouponClearResponse couponClearResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "745569364")) {
                    ipChange.ipc$dispatch("745569364", new Object[]{this, couponClearResponse});
                    return;
                }
                g91.b("ClearCouponSuccess", "ClearCoupon onSuccess");
            }
        });
    }

    public void x(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459734568")) {
            ipChange.ipc$dispatch("-1459734568", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.k = i2;
    }

    public void y(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180117006")) {
            ipChange.ipc$dispatch("1180117006", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.b = z;
        g91.b("CouponDialogHelper", "setClickRedPacket = " + z);
    }

    public void z(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201776017")) {
            ipChange.ipc$dispatch("1201776017", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            d20.S(0);
            this.a = null;
            y(false);
            x(0);
        }
    }
}

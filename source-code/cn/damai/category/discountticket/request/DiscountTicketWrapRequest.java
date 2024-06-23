package cn.damai.category.discountticket.request;

import cn.damai.category.discountticket.bean.CouponListRes;
import cn.damai.category.discountticket.bean.DiscountResData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DiscountTicketWrapRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private OnWrapListener b;
    private DiscountResData c;
    private CouponListRes d;
    private boolean e = false;

    /* compiled from: Taobao */
    public interface OnWrapListener {
        void onFail(String str, String str2);

        void onRes(DiscountResData discountResData, CouponListRes couponListRes);
    }

    public DiscountTicketWrapRequest(String str, OnWrapListener onWrapListener) {
        this.b = onWrapListener;
        this.a = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374427450")) {
            ipChange.ipc$dispatch("-1374427450", new Object[]{this, str, str2});
        } else if (!this.e) {
            this.e = true;
            OnWrapListener onWrapListener = this.b;
            if (onWrapListener != null) {
                onWrapListener.onFail(str, str2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        CouponListRes couponListRes;
        OnWrapListener onWrapListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "926692049")) {
            ipChange.ipc$dispatch("926692049", new Object[]{this});
            return;
        }
        DiscountResData discountResData = this.c;
        if (discountResData != null && (couponListRes = this.d) != null && (onWrapListener = this.b) != null) {
            onWrapListener.onRes(discountResData, couponListRes);
        }
    }

    private MtopBusiness h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2020415842")) {
            return new CouponListQueryRequest().request(new DMMtopRequestListener<CouponListRes>(CouponListRes.class) {
                /* class cn.damai.category.discountticket.request.DiscountTicketWrapRequest.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1514178298")) {
                        ipChange.ipc$dispatch("-1514178298", new Object[]{this, str, str2});
                        return;
                    }
                    DiscountTicketWrapRequest.this.e(str, str2);
                }

                public void onSuccess(CouponListRes couponListRes) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1364626177")) {
                        ipChange.ipc$dispatch("1364626177", new Object[]{this, couponListRes});
                    } else if (couponListRes != null) {
                        DiscountTicketWrapRequest.this.d = couponListRes;
                        DiscountTicketWrapRequest.this.f();
                    } else {
                        onFail("", "");
                    }
                }
            });
        }
        return (MtopBusiness) ipChange.ipc$dispatch("-2020415842", new Object[]{this});
    }

    private MtopBusiness i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2094725315")) {
            return new DiscountFirstPageRequest(this.a).request(new DMMtopRequestListener<DiscountResData>(DiscountResData.class) {
                /* class cn.damai.category.discountticket.request.DiscountTicketWrapRequest.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1506418939")) {
                        ipChange.ipc$dispatch("-1506418939", new Object[]{this, str, str2});
                        return;
                    }
                    DiscountTicketWrapRequest.this.e(str, str2);
                }

                public void onSuccess(DiscountResData discountResData) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "979869587")) {
                        ipChange.ipc$dispatch("979869587", new Object[]{this, discountResData});
                    } else if (discountResData != null) {
                        DiscountTicketWrapRequest.this.c = discountResData;
                        DiscountTicketWrapRequest.this.f();
                    } else {
                        onFail("", "");
                    }
                }
            });
        }
        return (MtopBusiness) ipChange.ipc$dispatch("2094725315", new Object[]{this});
    }

    public List<MtopBusiness> g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144640941")) {
            return (List) ipChange.ipc$dispatch("1144640941", new Object[]{this});
        }
        MtopBusiness i = i();
        MtopBusiness h = h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(i);
        arrayList.add(h);
        return arrayList;
    }
}

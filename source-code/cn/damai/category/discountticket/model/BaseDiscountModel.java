package cn.damai.category.discountticket.model;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.CouponApplyBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.ApplyResult;
import cn.damai.category.discountticket.contract.DiscountTicketContract;
import cn.damai.category.discountticket.request.CouponApplyRequest;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.List;
import mtopsdk.mtop.util.ErrorConstant;
import tb.n42;
import tb.q80;
import tb.tz0;
import tb.xs0;

/* compiled from: Taobao */
public abstract class BaseDiscountModel implements DiscountTicketContract.DtModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private RequestHolder mRequestHolder = new RequestHolder();

    public void addBusiness(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382772115")) {
            ipChange.ipc$dispatch("-382772115", new Object[]{this, mtopBusiness});
            return;
        }
        this.mRequestHolder.a(mtopBusiness);
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void applyCoupon(HeaderCouponBean headerCouponBean, final CouponActivityBean couponActivityBean, final OnApplyCouponListener onApplyCouponListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148132764")) {
            ipChange.ipc$dispatch("-148132764", new Object[]{this, headerCouponBean, couponActivityBean, onApplyCouponListener});
            return;
        }
        addBusiness(new CouponApplyRequest(couponActivityBean.couponActSpreadId).request(new DMMtopRequestListener<CouponApplyBean>(CouponApplyBean.class) {
            /* class cn.damai.category.discountticket.model.BaseDiscountModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "94453504")) {
                    ipChange.ipc$dispatch("94453504", new Object[]{this, str, str2});
                } else if (!TextUtils.equals(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, str)) {
                    if (TextUtils.equals(CouponActivityBean.COUPON_ALREADY_GOT, str)) {
                        ApplyResult applySuccessResult = CouponApplyBean.getApplySuccessResult(str2);
                        couponActivityBean.updateCouponAfterApply(applySuccessResult);
                        onApplyCouponListener.onApplyResultFinish(applySuccessResult.toastMsg);
                        return;
                    }
                    onApplyCouponListener.onApplyFail(str, str2);
                }
            }

            public void onSuccess(CouponApplyBean couponApplyBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2027628513")) {
                    ipChange.ipc$dispatch("-2027628513", new Object[]{this, couponApplyBean});
                } else if (couponApplyBean != null) {
                    ApplyResult computeApplyResult = couponApplyBean.computeApplyResult();
                    if (computeApplyResult != null) {
                        couponActivityBean.updateCouponAfterApply(computeApplyResult);
                        onApplyCouponListener.onApplyResultFinish(computeApplyResult.toastMsg);
                        return;
                    }
                    onFail("", "领取失败");
                } else {
                    onFail("", "领取失败");
                }
            }
        }));
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718599050")) {
            ipChange.ipc$dispatch("-718599050", new Object[]{this});
            return;
        }
        this.mRequestHolder.c();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void share(final OnShareListener onShareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281787426")) {
            ipChange.ipc$dispatch("-1281787426", new Object[]{this, onShareListener});
            return;
        }
        final HeaderData headerData = getHeaderData();
        if (headerData != null && headerData.isSupportShare()) {
            onShareListener.showLoading(true);
            final String str = headerData.sharePic;
            Application a = xs0.a();
            a.b().f(str, n42.a(a, 111.0f), n42.a(a, 148.0f)).n(new DMImageCreator.DMImageSuccListener() {
                /* class cn.damai.category.discountticket.model.BaseDiscountModel.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    Bitmap bitmap;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-495626785")) {
                        ipChange.ipc$dispatch("-495626785", new Object[]{this, eVar});
                        return;
                    }
                    onShareListener.showLoading(false);
                    if (eVar != null && (bitmap = eVar.b) != null) {
                        try {
                            String d = tz0.d(str, bitmap, xs0.a());
                            HeaderData headerData = headerData;
                            String str = headerData.title;
                            String str2 = headerData.subtitle;
                            String str3 = headerData.sharePic;
                            String str4 = headerData.h5Url;
                            Bundle bundle = new Bundle();
                            bundle.putString("title", str);
                            bundle.putString("projectName", str);
                            bundle.putString("message", str2);
                            if (!TextUtils.isEmpty(str3)) {
                                bundle.putString("imageurl", str3);
                                bundle.putString("projectImage", str3);
                            }
                            if (!TextUtils.isEmpty(d)) {
                                bundle.putString("sinaSharePath", d);
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                bundle.putString("producturl", str4);
                            }
                            bundle.putBoolean("showGenerateImage", true);
                            bundle.putString("shareType", "chat_h5");
                            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_DISCOUNT_TICKET);
                            onShareListener.onShare(bundle);
                        } catch (Exception unused) {
                            onShareListener.toast("分享失败");
                        }
                    }
                }
            }).e(new DMImageCreator.DMImageFailListener() {
                /* class cn.damai.category.discountticket.model.BaseDiscountModel.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.d dVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1289952310")) {
                        ipChange.ipc$dispatch("-1289952310", new Object[]{this, dVar});
                        return;
                    }
                    onShareListener.showLoading(false);
                    onShareListener.toast("分享失败");
                }
            }).f();
        }
    }

    public void addBusiness(List<MtopBusiness> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375535872")) {
            ipChange.ipc$dispatch("375535872", new Object[]{this, list});
        } else if (!q80.b(list)) {
            for (MtopBusiness mtopBusiness : list) {
                addBusiness(mtopBusiness);
            }
        }
    }
}

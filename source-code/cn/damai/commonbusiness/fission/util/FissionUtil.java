package cn.damai.commonbusiness.fission.util;

import android.content.Context;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.fission.bean.FissionDataRequest;
import cn.damai.commonbusiness.fission.bean.FissionInfoBean;
import cn.damai.commonbusiness.fission.bean.FissionParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FissionUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FISSION_CHANNEL_TYPE_LIVE = "4";
    public static final String FISSION_HIDE_PROGRESS = "0";
    public static final String FISSION_SCENE_TYPE_LIVE = "3";
    public static final String FISSION_SHOW_PROGRESS = "1";
    private FissionViewInterface a;

    /* compiled from: Taobao */
    public interface FissionViewInterface {
        void showEmptyPage();

        void showErrorView(String str, String str2);

        void showView(FissionInfoBean fissionInfoBean);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(Context context, FissionInfoBean fissionInfoBean, FissionParam fissionParam) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471179064")) {
            ipChange.ipc$dispatch("-1471179064", new Object[]{this, context, fissionInfoBean, fissionParam});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("fissionParam", fissionParam);
        bundle.putSerializable("fissionResult", fissionInfoBean);
        DMNav.from(context).withExtras(bundle).toUri(NavUri.b("fission_beautify_share"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "432145276")) {
            return "1".equals(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("432145276", new Object[]{this, str})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(boolean z, boolean z2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880994640")) {
            ipChange.ipc$dispatch("880994640", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
        } else if (z) {
            FissionViewInterface fissionViewInterface = this.a;
            if (fissionViewInterface == null) {
                k();
            } else if (z2) {
                fissionViewInterface.showEmptyPage();
            } else {
                fissionViewInterface.showErrorView(str, str2);
            }
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025328270")) {
            ipChange.ipc$dispatch("1025328270", new Object[]{this});
            return;
        }
        ToastUtil.i("网络不太顺畅哦～");
    }

    public FissionParam f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162290892")) {
            return (FissionParam) ipChange.ipc$dispatch("162290892", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10});
        }
        FissionParam fissionParam = new FissionParam();
        fissionParam.projectName = str3;
        fissionParam.subMessage = str5;
        fissionParam.imageUrl = str;
        fissionParam.uniqueIdent = str2;
        fissionParam.mainMessage = str4;
        fissionParam.sceneTip = str6;
        fissionParam.shareUrl = str7;
        fissionParam.channelType = str8;
        fissionParam.sceneType = str9;
        fissionParam.loadingState = str10;
        return fissionParam;
    }

    public void h(final Context context, final FissionParam fissionParam) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539934284")) {
            ipChange.ipc$dispatch("-1539934284", new Object[]{this, context, fissionParam});
        } else if (fissionParam != null) {
            if (context != null && g(fissionParam.loadingState) && (context instanceof DamaiBaseActivity)) {
                ((DamaiBaseActivity) context).startProgressDialog();
            }
            FissionDataRequest fissionDataRequest = new FissionDataRequest();
            fissionDataRequest.channelType = fissionParam.channelType;
            fissionDataRequest.sceneType = fissionParam.sceneType;
            fissionDataRequest.request(new DMMtopRequestListener<FissionInfoBean>(FissionInfoBean.class) {
                /* class cn.damai.commonbusiness.fission.util.FissionUtil.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2082620774")) {
                        ipChange.ipc$dispatch("2082620774", new Object[]{this, str, str2});
                    } else if (context != null && FissionUtil.this.g(fissionParam.loadingState)) {
                        Context context = context;
                        if (context instanceof DamaiBaseActivity) {
                            ((DamaiBaseActivity) context).stopProgressDialog();
                            FissionUtil fissionUtil = FissionUtil.this;
                            fissionUtil.j(fissionUtil.g(fissionParam.loadingState), false, str, str2);
                        }
                    }
                }

                public void onSuccess(FissionInfoBean fissionInfoBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1887293807")) {
                        ipChange.ipc$dispatch("1887293807", new Object[]{this, fissionInfoBean});
                        return;
                    }
                    if (context != null && FissionUtil.this.g(fissionParam.loadingState)) {
                        Context context = context;
                        if (context instanceof DamaiBaseActivity) {
                            ((DamaiBaseActivity) context).stopProgressDialog();
                        }
                    }
                    if (fissionInfoBean == null) {
                        FissionUtil fissionUtil = FissionUtil.this;
                        fissionUtil.j(fissionUtil.g(fissionParam.loadingState), true, "", "");
                    } else if (fissionInfoBean.shareInfo == null && fissionInfoBean.userInfo == null) {
                        FissionUtil fissionUtil2 = FissionUtil.this;
                        fissionUtil2.j(fissionUtil2.g(fissionParam.loadingState), true, "", "");
                    } else if (FissionUtil.this.a != null) {
                        FissionUtil.this.a.showView(fissionInfoBean);
                    } else {
                        FissionUtil.this.e(context, fissionInfoBean, fissionParam);
                    }
                }
            });
        }
    }

    public void i(FissionViewInterface fissionViewInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1467183330")) {
            ipChange.ipc$dispatch("-1467183330", new Object[]{this, fissionViewInterface});
            return;
        }
        this.a = fissionViewInterface;
    }
}

package cn.damai.ultron.net;

import android.app.Activity;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.message.observer.Action;
import cn.damai.ultron.utils.DmBuildRequestCallBackImp;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.utils.DmUltronRequestErrorUtils;
import cn.damai.ultron.view.activity.DmOrderActivity;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.presenter.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.aw1;
import tb.br;
import tb.d20;
import tb.f1;
import tb.ia0;
import tb.ln2;
import tb.ma0;
import tb.oa0;
import tb.pa0;
import tb.u90;
import tb.vu2;
import tb.w90;
import tb.wt;
import tb.y90;

/* compiled from: Taobao */
public class UltronPresenter extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    private DmBuildRequestCallBackImp mBuildRequestCallBackImp;
    private UltronDataManager mDataManager;
    private UltronViewManager mViewManager = new UltronViewManager(this);

    public UltronPresenter(Activity activity, DmBuildRequestCallBackImp dmBuildRequestCallBackImp) {
        super(activity);
        UltronDataManager ultronDataManager = new UltronDataManager(this);
        this.mDataManager = ultronDataManager;
        init(ultronDataManager, this.mViewManager);
        registerHolderCreator();
        registCustonView();
        setMarkType();
        this.mBuildRequestCallBackImp = dmBuildRequestCallBackImp;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void utCustom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575595353")) {
            ipChange.ipc$dispatch("1575595353", new Object[]{this, str});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", "false");
            hashMap.put("contentlabel", str);
            hashMap.put("discount_type", w90.c(getContext()));
            hashMap.put("discount_type_id", w90.d(getContext()));
            hashMap.put("item_id", w90.b(getContext()) + "");
            hashMap.put("usercode", d20.E());
            c.e().A(hashMap, ln2.CUSTOM_ORDER, ln2.PROJRCT_CONFIRM_PAY);
        } catch (Exception unused) {
        }
    }

    public void buildPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527499090")) {
            ipChange.ipc$dispatch("-1527499090", new Object[]{this});
            return;
        }
        showLoading();
        this.mDataManager.buildPage(new f1() {
            /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1244708485")) {
                    ipChange.ipc$dispatch("1244708485", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                if (mtopResponse != null) {
                    String retCode = mtopResponse.getRetCode();
                    String errorMsg = Util.getErrorMsg(mtopResponse);
                    String api = mtopResponse.getApi();
                    int responseCode = mtopResponse.getResponseCode();
                    if (UltronPresenter.this.mBuildRequestCallBackImp != null) {
                        UltronPresenter.this.mBuildRequestCallBackImp.onError(retCode, errorMsg, responseCode, api);
                    }
                    oa0.i(mtopResponse);
                }
            }

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "606477660")) {
                    ipChange.ipc$dispatch("606477660", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                if (UltronPresenter.this.mBuildRequestCallBackImp != null) {
                    UltronPresenter.this.mBuildRequestCallBackImp.onSuccess();
                }
                UltronPresenter ultronPresenter = UltronPresenter.this;
                ultronPresenter.rebuild(ultronPresenter.mDataManager.getDataSource());
                UltronPresenter.this.mDataManager.setDataContext(iDMContext);
                oa0.j(mtopResponse);
            }
        });
    }

    public void createOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847679353")) {
            ipChange.ipc$dispatch("847679353", new Object[]{this});
            return;
        }
        c.e().x(ma0.u().n(this.mContext));
        vu2 vu2 = null;
        UltronDataManager ultronDataManager = this.mDataManager;
        if (!(ultronDataManager == null || ultronDataManager.getDataContext() == null)) {
            vu2 = this.mDataManager.getDataContext().validate();
        }
        if (vu2 != null) {
            if (vu2.c()) {
                this.mTradeEventHandler.h(this.mTradeEventHandler.d().l(ia0.requestSubmitEvent).i(vu2.a()));
                return;
            }
            ToastUtil.i(vu2.b());
        }
    }

    public void createOrderValidateSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513444324")) {
            ipChange.ipc$dispatch("513444324", new Object[]{this});
            return;
        }
        com.alibaba.android.ultron.trade.data.request.a createRequester = this.mDataManager.getCreateRequester();
        showLoading();
        createRequester.sendRequest(new f1() {
            /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-240347066")) {
                    ipChange.ipc$dispatch("-240347066", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                if (mtopResponse != null) {
                    String retCode = mtopResponse.getRetCode();
                    String retMsg = mtopResponse.getRetMsg();
                    String api = mtopResponse.getApi();
                    if (mtopResponse.getResponseCode() == 420) {
                        retMsg = "前方拥挤，亲稍等再试试";
                    }
                    if (UltronPresenter.this.getContext() != null) {
                        DmUltronRequestErrorUtils.d().h(DmUltronRequestErrorUtils.NetError.NO_NETWORK_TOAST).g(DmUltronRequestErrorUtils.DefaultError.DIALOG).f(DmUltronRequestErrorUtils.BizType.CREATE).a((DmOrderActivity) UltronPresenter.this.getContext(), retCode, retMsg, api);
                    }
                    UltronPresenter.this.utCustom(retMsg);
                    oa0.i(mtopResponse);
                }
            }

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "750887355")) {
                    ipChange.ipc$dispatch("750887355", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                ((a) UltronPresenter.this).mTradeEventHandler.h(((a) UltronPresenter.this).mTradeEventHandler.d().l(ia0.submitSuccessEvent).k(mtopResponse));
                oa0.j(mtopResponse);
            }
        }, this.mDataManager.getDataContext(), null);
    }

    public void dismissLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026751955")) {
            ipChange.ipc$dispatch("-1026751955", new Object[]{this});
            return;
        }
        this.mViewManager.dismissLoading();
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public String getModuleName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1655743394")) {
            return aw1.KEY_MODULE_NAME;
        }
        return (String) ipChange.ipc$dispatch("1655743394", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.ultron.trade.presenter.a
    public void initEventSubscriber() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554472519")) {
            ipChange.ipc$dispatch("-1554472519", new Object[]{this});
            return;
        }
        super.initEventSubscriber();
        Map<String, Class<? extends ISubscriber>> b = ia0.b();
        if (b != null && !b.isEmpty()) {
            try {
                for (Map.Entry<String, Class<? extends ISubscriber>> entry : b.entrySet()) {
                    this.mTradeEventHandler.a(entry.getKey(), (ISubscriber) entry.getValue().newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map<String, Class<? extends ISubscriber>> a = ia0.a();
        if (a != null && !a.isEmpty()) {
            try {
                for (Map.Entry<String, Class<? extends ISubscriber>> entry2 : a.entrySet()) {
                    this.mTradeEventHandler.l(entry2.getKey(), (ISubscriber) entry2.getValue().newInstance());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void listenerNotify(br brVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1139063082")) {
            ipChange.ipc$dispatch("-1139063082", new Object[]{this, brVar});
        } else if (brVar != null) {
            brVar.b(DmUltronConstants.REFRESH_CONTACT_COMPONENT_DATA, new Action<DMComponent>() {
                /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void call(DMComponent dMComponent) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "999852954")) {
                        ipChange.ipc$dispatch("999852954", new Object[]{this, dMComponent});
                        return;
                    }
                    UltronPresenter.this.getTradeEventHandler().h(UltronPresenter.this.getTradeEventHandler().d().l(ia0.selectContactEvent).m("data", dMComponent));
                }
            });
            brVar.b(DmUltronConstants.UPDATE_CONTACT_COMPONENT_DATA, new Action<DMComponent>() {
                /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void call(DMComponent dMComponent) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1174827143")) {
                        ipChange.ipc$dispatch("-1174827143", new Object[]{this, dMComponent});
                        return;
                    }
                    com.taobao.android.ultron.datamodel.imp.a aVar = (com.taobao.android.ultron.datamodel.imp.a) UltronPresenter.this.mDataManager.getDataContext();
                    if (aVar != null) {
                        Map<String, DMComponent> c = aVar.c();
                        c.put(dMComponent.getTag() + JSMethod.NOT_SET + dMComponent.getId(), dMComponent);
                    }
                }
            });
            brVar.b(DmUltronConstants.REFRESH_PAYTYPE_COMPONENT_DATA, new Action<DMComponent>() {
                /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void call(DMComponent dMComponent) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "945460056")) {
                        ipChange.ipc$dispatch("945460056", new Object[]{this, dMComponent});
                        return;
                    }
                    UltronPresenter.this.mDataManager.respondToLinkage(dMComponent);
                }
            });
            brVar.b(DmUltronConstants.SHOW_LOADING_STATE, new Action<Boolean>() {
                /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void call(Boolean bool) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1786651772")) {
                        ipChange.ipc$dispatch("1786651772", new Object[]{this, bool});
                    } else if (bool.booleanValue()) {
                        UltronPresenter.this.showLoading();
                    } else {
                        UltronPresenter.this.dismissLoading();
                    }
                }
            });
            brVar.b(DmUltronConstants.TRUST_YOUKU_LOGIN, new Action<DMComponent>() {
                /* class cn.damai.ultron.net.UltronPresenter.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void call(DMComponent dMComponent) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "891067158")) {
                        ipChange.ipc$dispatch("891067158", new Object[]{this, dMComponent});
                        return;
                    }
                    UltronPresenter.this.mDataManager.respondToLinkage(dMComponent);
                }
            });
        }
    }

    public void registCustonView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-161304622")) {
            ipChange.ipc$dispatch("-161304622", new Object[]{this});
            return;
        }
        UltronViewManager ultronViewManager = this.mViewManager;
        if (ultronViewManager != null) {
            ultronViewManager.v3RegisterDinamicXView(wt.DXDMINPUT_DMINPUT, new wt.a());
        }
    }

    public void registerHolderCreator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806374606")) {
            ipChange.ipc$dispatch("806374606", new Object[]{this});
            return;
        }
        registerViewHolderCreator("bundleLine", u90.CREATOR);
        registerViewHolderCreator(UltronConstants.COMPONENT_VIEWER_TYPE, pa0.CREATOR);
        registerViewHolderCreator(UltronConstants.COMPONENT_PAYTYPE_TYPE, y90.CREATOR);
    }

    public void setMarkType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185046110")) {
            ipChange.ipc$dispatch("-1185046110", new Object[]{this});
        } else if (AppConfig.v()) {
            this.mViewManager.setMarkType(1001);
        }
    }

    public void showLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693066892")) {
            ipChange.ipc$dispatch("693066892", new Object[]{this});
            return;
        }
        this.mViewManager.showLoading();
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter, com.alibaba.android.ultron.trade.presenter.a
    public UltronDataManager getDataManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-83729722")) {
            return this.mDataManager;
        }
        return (UltronDataManager) ipChange.ipc$dispatch("-83729722", new Object[]{this});
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter, com.alibaba.android.ultron.trade.presenter.a
    public UltronViewManager getViewManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1129329732")) {
            return this.mViewManager;
        }
        return (UltronViewManager) ipChange.ipc$dispatch("-1129329732", new Object[]{this});
    }
}

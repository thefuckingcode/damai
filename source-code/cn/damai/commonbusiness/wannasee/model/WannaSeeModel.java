package cn.damai.commonbusiness.wannasee.model;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.commonbusiness.wannasee.Wanna2SeeRequest;
import cn.damai.commonbusiness.wannasee.bean.PageData;
import cn.damai.commonbusiness.wannasee.bean.PageType;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnWannaBeanListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.dr;
import tb.gt2;
import tb.yd1;

/* compiled from: Taobao */
public class WannaSeeModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isNeedLogin;
    private WannaBean mFirstPageWannaBean;
    private OnWannaBeanListener mListener;
    private final PageType mType;
    private String mUserId;
    private int pageNo = 1;
    private String utPageName;

    public WannaSeeModel(PageType pageType, String str, OnWannaBeanListener onWannaBeanListener, boolean z) {
        this.mType = pageType;
        this.mUserId = str;
        this.mListener = onWannaBeanListener;
        this.isNeedLogin = z;
    }

    static /* synthetic */ int access$208(WannaSeeModel wannaSeeModel) {
        int i = wannaSeeModel.pageNo;
        wannaSeeModel.pageNo = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void alarm(Wanna2SeeRequest wanna2SeeRequest, String str, String str2) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141282547")) {
            ipChange.ipc$dispatch("-1141282547", new Object[]{this, wanna2SeeRequest, str, str2});
        } else if (wanna2SeeRequest != null) {
            if ("live".equals(this.utPageName)) {
                str3 = "现场主页想看";
            } else if (yd1.MY_PAGE.equals(this.utPageName)) {
                str3 = "我的页面想看";
            } else if (gt2.USER_HOME_PAGE.equals(this.utPageName)) {
                str3 = "个人主页想看";
            } else {
                str3 = this.utPageName;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.mType.requestType);
            hashMap.put("tabName", this.mType.tabName);
            hashMap.put("subType", this.mType.subType + "");
            hashMap.put("targetHavanaId", this.mUserId);
            hashMap.put("usercode", d20.i());
            dr.INSTANCE.a().a(wanna2SeeRequest.getApiName()).c(str).d(str2).e(hashMap).g(str3).j(this.utPageName).f(false).b();
        }
    }

    public void cancelFollowData(String str, String str2, final DMMtopRequestListener<FollowDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148002643")) {
            ipChange.ipc$dispatch("-148002643", new Object[]{this, str, str2, dMMtopRequestListener});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = "0";
        followRequest.targetId = str;
        followRequest.targetType = str2;
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.commonbusiness.wannasee.model.WannaSeeModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1191131831")) {
                    ipChange.ipc$dispatch("1191131831", new Object[]{this, str, str2});
                    return;
                }
                DMMtopRequestListener dMMtopRequestListener = dMMtopRequestListener;
                if (dMMtopRequestListener != null) {
                    dMMtopRequestListener.onFail(str, str2);
                }
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1743457993")) {
                    ipChange.ipc$dispatch("1743457993", new Object[]{this, followDataBean});
                    return;
                }
                if (WannaSeeModel.this.mFirstPageWannaBean != null) {
                    if (WannaSeeModel.this.mType == PageType.SHOW) {
                        WannaBean wannaBean = WannaSeeModel.this.mFirstPageWannaBean;
                        WannaSeeModel wannaSeeModel = WannaSeeModel.this;
                        wannaBean.totalItem = wannaSeeModel.setTotalSub(wannaSeeModel.mFirstPageWannaBean.totalItem);
                    } else if (WannaSeeModel.this.mType == PageType.RECORD) {
                        WannaBean wannaBean2 = WannaSeeModel.this.mFirstPageWannaBean;
                        WannaSeeModel wannaSeeModel2 = WannaSeeModel.this;
                        wannaBean2.totalCard = wannaSeeModel2.setTotalSub(wannaSeeModel2.mFirstPageWannaBean.totalCard);
                    } else if (WannaSeeModel.this.mType == PageType.COMPILATION) {
                        WannaBean wannaBean3 = WannaSeeModel.this.mFirstPageWannaBean;
                        WannaSeeModel wannaSeeModel3 = WannaSeeModel.this;
                        wannaBean3.totalRanking = wannaSeeModel3.setTotalSub(wannaSeeModel3.mFirstPageWannaBean.totalRanking);
                    }
                    if (WannaSeeModel.this.mListener != null) {
                        WannaSeeModel.this.mListener.onWannaBean(WannaSeeModel.this.mFirstPageWannaBean);
                    }
                }
                DMMtopRequestListener dMMtopRequestListener = dMMtopRequestListener;
                if (dMMtopRequestListener != null) {
                    dMMtopRequestListener.onSuccess(followDataBean);
                }
            }
        });
    }

    public void load(final boolean z, final OnBizListener<PageData<List>> onBizListener) {
        final Wanna2SeeRequest wanna2SeeRequest;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034250526")) {
            ipChange.ipc$dispatch("-2034250526", new Object[]{this, Boolean.valueOf(z), onBizListener});
            return;
        }
        if (z) {
            this.pageNo = 1;
        }
        PageType pageType = this.mType;
        int i = pageType.subType;
        if (i >= 0) {
            wanna2SeeRequest = new Wanna2SeeRequest(pageType.requestType, this.pageNo, this.isNeedLogin, i);
        } else {
            wanna2SeeRequest = new Wanna2SeeRequest(pageType.requestType, this.pageNo, this.isNeedLogin);
        }
        if (!TextUtils.isEmpty(this.mUserId)) {
            wanna2SeeRequest.targetHavanaId = this.mUserId;
        } else {
            wanna2SeeRequest.targetHavanaId = null;
        }
        this.mHolder.a(wanna2SeeRequest.request(new DMMtopRequestListener<WannaBean>(WannaBean.class) {
            /* class cn.damai.commonbusiness.wannasee.model.WannaSeeModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1198891190")) {
                    ipChange.ipc$dispatch("1198891190", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
                if (z) {
                    WannaSeeModel.this.alarm(wanna2SeeRequest, str, str2);
                }
            }

            public void onSuccess(WannaBean wannaBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1483462520")) {
                    ipChange.ipc$dispatch("-1483462520", new Object[]{this, wannaBean});
                } else if (wannaBean != null) {
                    if (z && WannaSeeModel.this.mListener != null) {
                        WannaSeeModel.this.mFirstPageWannaBean = wannaBean;
                        WannaSeeModel.this.mListener.onWannaBean(wannaBean);
                    }
                    WannaSeeModel.access$208(WannaSeeModel.this);
                    onBizListener.onBizSuccess(PageData.success(z, wannaBean.hasNext, WannaSeeModel.this.mType.getListByType(wannaBean)));
                } else {
                    onFail("", "");
                }
            }
        }));
    }

    public String setTotalSub(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1722678524")) {
            return (String) ipChange.ipc$dispatch("1722678524", new Object[]{this, str});
        }
        try {
            return String.valueOf(Long.parseLong(str) - 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public void setUtPageName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528061721")) {
            ipChange.ipc$dispatch("-528061721", new Object[]{this, str});
            return;
        }
        this.utPageName = str;
    }
}

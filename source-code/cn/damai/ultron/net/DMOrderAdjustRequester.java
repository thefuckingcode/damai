package cn.damai.ultron.net;

import android.content.Context;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.android.ultron.trade.data.request.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.f1;
import tb.j20;
import tb.mr;

/* compiled from: Taobao */
public class DMOrderAdjustRequester extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected UltronDataManager mDataManager;
    private IDMComponent mTrigger;

    public DMOrderAdjustRequester(UltronDataManager ultronDataManager, Context context, Request request) {
        super(ultronDataManager, context, request);
        this.mDataManager = ultronDataManager;
    }

    @Override // com.alibaba.android.ultron.trade.data.request.a
    public void sendRequest(final f1 f1Var, IDMContext iDMContext, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822800353")) {
            ipChange.ipc$dispatch("-822800353", new Object[]{this, f1Var, iDMContext, obj});
        } else if (this.mTrigger != null) {
            new mr(this.mContext).h(this.mRequest.getDomain()).a(this.mRequest.getApiName()).I(this.mRequest.getApiVersion()).B(this.mRequest.isNeedEcode()).C(this.mRequest.isNeedSession()).G(this.mRequest.getUnitStrategy()).E(this.mRequest.isPostMethod()).H(this.mRequest.isUseWua()).b(this.mRequest.getBizId()).F(this.mRequest.getHeaders()).d(this.mTrigger, iDMContext).execute(obj, new f1() {
                /* class cn.damai.ultron.net.DMOrderAdjustRequester.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.android.ultron.datamodel.IRequestCallback
                public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1456898512")) {
                        ipChange.ipc$dispatch("-1456898512", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
                        return;
                    }
                    f1 f1Var = f1Var;
                    if (f1Var != null) {
                        f1Var.onError(i, mtopResponse, obj, z, map);
                    }
                }

                @Override // com.taobao.android.ultron.datamodel.IRequestCallback
                public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1936798993")) {
                        ipChange.ipc$dispatch("1936798993", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                        return;
                    }
                    if (map != null && (map.get("reload") instanceof Boolean) && ((Boolean) map.get("reload")).booleanValue()) {
                        j20.b(iDMContext, ((a) DMOrderAdjustRequester.this).mContext);
                    }
                    DMOrderAdjustRequester dMOrderAdjustRequester = DMOrderAdjustRequester.this;
                    dMOrderAdjustRequester.composeComponents(dMOrderAdjustRequester.mDataManager, iDMContext);
                    f1 f1Var = f1Var;
                    if (f1Var != null) {
                        f1Var.onSuccess(i, mtopResponse, obj, DMOrderAdjustRequester.this.mDataManager.getDataContext(), map);
                    }
                }
            });
        } else {
            throw new IllegalStateException("we find you not call setTrigger() method first before you call AdjustOrderRequester's sendRequest() method");
        }
    }

    public void setTrigger(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1835558779")) {
            ipChange.ipc$dispatch("1835558779", new Object[]{this, iDMComponent});
            return;
        }
        this.mTrigger = iDMComponent;
    }
}

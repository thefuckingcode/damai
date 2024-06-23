package cn.damai.ultron.net;

import android.content.Context;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.android.ultron.trade.data.request.a;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.IDMRequester;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.f1;
import tb.j20;
import tb.mr;

/* compiled from: Taobao */
public class DMOrderBuildRequest extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMOrderBuildRequest(BaseDataManager baseDataManager, Context context, Request request) {
        super(baseDataManager, context, request);
    }

    private void useMtopData(final f1 f1Var, IDMContext iDMContext, Object obj) {
        IDMRequester iDMRequester;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588314357")) {
            ipChange.ipc$dispatch("-1588314357", new Object[]{this, f1Var, iDMContext, obj});
            return;
        }
        mr F = new mr(this.mContext).h(this.mRequest.getDomain()).a(this.mRequest.getApiName()).I(this.mRequest.getApiVersion()).B(this.mRequest.isNeedEcode()).C(this.mRequest.isNeedSession()).D(this.mRequest.getParams()).G(this.mRequest.getUnitStrategy()).E(this.mRequest.isPostMethod()).H(this.mRequest.isUseWua()).b(this.mRequest.getBizId()).F(this.mRequest.getHeaders());
        if (iDMContext == null) {
            iDMRequester = F.c();
        } else {
            iDMRequester = F.e(iDMContext);
        }
        iDMRequester.execute(obj, new f1() {
            /* class cn.damai.ultron.net.DMOrderBuildRequest.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1573289998")) {
                    ipChange.ipc$dispatch("-1573289998", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
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
                if (AndroidInstantRuntime.support(ipChange, "-929613937")) {
                    ipChange.ipc$dispatch("-929613937", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                    return;
                }
                j20.b(iDMContext, ((a) DMOrderBuildRequest.this).mContext);
                DMOrderBuildRequest dMOrderBuildRequest = DMOrderBuildRequest.this;
                dMOrderBuildRequest.composeComponents(((a) dMOrderBuildRequest).mDataManager, iDMContext);
                f1 f1Var = f1Var;
                if (f1Var != null) {
                    f1Var.onSuccess(i, mtopResponse, obj, ((a) DMOrderBuildRequest.this).mDataManager.getDataContext(), map);
                }
            }
        });
    }

    @Override // com.alibaba.android.ultron.trade.data.request.a
    public void sendRequest(f1 f1Var, IDMContext iDMContext, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90356765")) {
            ipChange.ipc$dispatch("90356765", new Object[]{this, f1Var, iDMContext, obj});
            return;
        }
        useMtopData(f1Var, iDMContext, obj);
    }
}

package cn.damai.discover.main.ui.model;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.model.AbsModel;
import cn.damai.discover.main.bean.PublishStateBean;
import cn.damai.discover.main.request.PublishCheckRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PublishModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private PublishStateBean mStateBean;

    public PublishStateBean getStateBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2101549915")) {
            return this.mStateBean;
        }
        return (PublishStateBean) ipChange.ipc$dispatch("-2101549915", new Object[]{this});
    }

    public void loadPublish(final OnBizListener<PublishStateBean> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637258194")) {
            ipChange.ipc$dispatch("-1637258194", new Object[]{this, onBizListener});
            return;
        }
        this.mStateBean = null;
        this.mHolder.a(new PublishCheckRequest().request(new DMMtopRequestListener<PublishStateBean>(PublishStateBean.class) {
            /* class cn.damai.discover.main.ui.model.PublishModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-60432759")) {
                    ipChange.ipc$dispatch("-60432759", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
            }

            public void onSuccess(PublishStateBean publishStateBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1945467485")) {
                    ipChange.ipc$dispatch("1945467485", new Object[]{this, publishStateBean});
                } else if (publishStateBean != null) {
                    PublishModel.this.mStateBean = publishStateBean;
                    onBizListener.onBizSuccess(publishStateBean);
                } else {
                    onBizListener.onBizFail("", "");
                }
            }
        }));
    }
}

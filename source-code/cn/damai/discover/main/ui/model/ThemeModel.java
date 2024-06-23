package cn.damai.discover.main.ui.model;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.model.AbsModel;
import cn.damai.discover.main.bean.PublishStateBean;
import cn.damai.discover.main.bean.ThemeInfo;
import cn.damai.discover.main.bean.ThemePageBean;
import cn.damai.discover.main.bean.ThemeShare;
import cn.damai.discover.main.request.ThemeRequest;
import cn.damai.discover.main.ui.listener.OnShareListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.u80;

/* compiled from: Taobao */
public class ThemeModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private ThemePageBean firstPageBean;
    private PublishModel mPublishModel = new PublishModel();
    public int newPageNo = 1;
    public int recommendPageNo = 1;
    private final String themeId;

    public ThemeModel(String str) {
        this.themeId = str;
    }

    @Nullable
    private ThemeShare getShareBean() {
        ThemeInfo themeInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "128129961")) {
            return (ThemeShare) ipChange.ipc$dispatch("128129961", new Object[]{this});
        }
        ThemePageBean themePageBean = this.firstPageBean;
        if (themePageBean == null || (themeInfo = themePageBean.themeInfo) == null) {
            return null;
        }
        return themeInfo.share;
    }

    private void realRequest(String str, int i, final int i2, final boolean z, final OnBizListener<ThemePageBean> onBizListener) {
        IpChange ipChange = $ipChange;
        int i3 = 4;
        if (AndroidInstantRuntime.support(ipChange, "-605090386")) {
            ipChange.ipc$dispatch("-605090386", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), onBizListener});
            return;
        }
        if (i2 == 1) {
            i3 = i2;
        }
        this.mHolder.a(new ThemeRequest(str, i, i3).request(new DMMtopRequestListener<ThemePageBean>(ThemePageBean.class) {
            /* class cn.damai.discover.main.ui.model.ThemeModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1446013681")) {
                    ipChange.ipc$dispatch("-1446013681", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
            }

            public void onSuccess(ThemePageBean themePageBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1127342591")) {
                    ipChange.ipc$dispatch("1127342591", new Object[]{this, themePageBean});
                } else if (themePageBean != null) {
                    if (z) {
                        ThemeModel.this.firstPageBean = themePageBean;
                    }
                    if (i2 == 0) {
                        ThemeModel.this.recommendPageNo++;
                    } else {
                        ThemeModel.this.newPageNo++;
                    }
                    onBizListener.onBizSuccess(themePageBean);
                } else {
                    onFail("", "");
                }
            }
        }));
    }

    @Override // cn.damai.commonbusiness.wannasee.model.AbsModel
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374074821")) {
            ipChange.ipc$dispatch("1374074821", new Object[]{this});
            return;
        }
        super.destroy();
        this.mPublishModel.destroy();
    }

    @Nullable
    public PublishStateBean getStateBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1889372193")) {
            return this.mPublishModel.getStateBean();
        }
        return (PublishStateBean) ipChange.ipc$dispatch("-1889372193", new Object[]{this});
    }

    public String getUserHeadUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265574723")) {
            return (String) ipChange.ipc$dispatch("1265574723", new Object[]{this});
        }
        PublishStateBean stateBean = getStateBean();
        if (stateBean != null) {
            return stateBean.headerImage;
        }
        return null;
    }

    public void load(boolean z, int i, OnBizListener<ThemePageBean> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1791266410")) {
            ipChange.ipc$dispatch("-1791266410", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), onBizListener});
            return;
        }
        if (z) {
            this.recommendPageNo = 1;
            this.newPageNo = 1;
        }
        realRequest(this.themeId, i == 0 ? this.recommendPageNo : this.newPageNo, i, z, onBizListener);
    }

    public void loadPublish(OnBizListener<PublishStateBean> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759080628")) {
            ipChange.ipc$dispatch("1759080628", new Object[]{this, onBizListener});
            return;
        }
        this.mPublishModel.loadPublish(onBizListener);
    }

    public void share(OnShareListener onShareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "21216326")) {
            ipChange.ipc$dispatch("21216326", new Object[]{this, onShareListener});
            return;
        }
        ThemeShare shareBean = getShareBean();
        if (shareBean != null && shareBean.isValid()) {
            u80.q(onShareListener, shareBean);
        }
    }
}

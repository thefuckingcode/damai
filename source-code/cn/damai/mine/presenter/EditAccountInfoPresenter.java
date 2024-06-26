package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.ProfileInfoBean;
import cn.damai.mine.contract.EditAccountInfoContract;
import cn.damai.mine.param.SaveUserRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class EditAccountInfoPresenter extends EditAccountInfoContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.EditAccountInfoContract.Presenter
    public void saveProfileInfo(SaveUserRequest saveUserRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69067007")) {
            ipChange.ipc$dispatch("-69067007", new Object[]{this, saveUserRequest});
            return;
        }
        saveUserRequest.request(new DMMtopRequestListener<ProfileInfoBean>(ProfileInfoBean.class) {
            /* class cn.damai.mine.presenter.EditAccountInfoPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1358795592")) {
                    ipChange.ipc$dispatch("-1358795592", new Object[]{this, str, str2});
                    return;
                }
                EditAccountInfoPresenter.this.mView.returnSaveUserProfileFalse(str, str2);
            }

            public void onSuccess(ProfileInfoBean profileInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1702312619")) {
                    ipChange.ipc$dispatch("1702312619", new Object[]{this, profileInfoBean});
                    return;
                }
                EditAccountInfoPresenter.this.mView.returnSaveUserProfile(profileInfoBean.profileInfo);
            }
        });
    }
}

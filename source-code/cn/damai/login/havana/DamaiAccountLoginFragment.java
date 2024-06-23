package cn.damai.login.havana;

import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.ali.user.mobile.login.ui.AliUserLoginFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.ht0;

/* compiled from: Taobao */
public class DamaiAccountLoginFragment extends AliUserLoginFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795331595")) {
            ipChange.ipc$dispatch("-1795331595", new Object[]{this});
            return;
        }
        if (this.mUserLoginActivity.getToolbar() != null) {
            this.mUserLoginActivity.getToolbar().setTitle("");
        }
        if (this.mUserLoginActivity.getToolbar() != null) {
            this.mUserLoginActivity.getToolbar().setNavigationIcon(R$drawable.icon_back_black_normal);
        }
        if (this.isHistoryMode) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mForgetPasswordTV.getLayoutParams();
            layoutParams.addRule(11);
            this.mForgetPasswordTV.setGravity(5);
            this.mForgetPasswordTV.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mForgetPasswordTV.getLayoutParams();
        layoutParams2.addRule(0, R$id.aliuser_reg_tv);
        layoutParams2.addRule(1, R$id.aliuser_login_switch_smslogin);
        this.mForgetPasswordTV.setGravity(17);
        this.mForgetPasswordTV.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.AliUserLoginFragment
    public int getLayoutContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-87139324")) {
            return R$layout.dm_aliuser_fragment_user_login;
        }
        return ((Integer) ipChange.ipc$dispatch("-87139324", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185846702")) {
            ipChange.ipc$dispatch("1185846702", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        initView();
        ht0.g(getActivity(), (getActivity() == null || getActivity().getWindow() == null) ? this.mLoginLL : getActivity().getWindow().getDecorView());
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void updateAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331195278")) {
            ipChange.ipc$dispatch("-331195278", new Object[]{this, str});
            return;
        }
        DMImageCreator c = a.b().c(d20.B(str));
        int i = R$drawable.uikit_user_default_icon;
        c.i(i).c(i).g(this.mAvatarIV);
    }
}

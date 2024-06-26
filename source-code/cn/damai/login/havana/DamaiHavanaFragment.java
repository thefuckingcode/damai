package cn.damai.login.havana;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.ui.AliUserMobileLoginFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.ht0;
import tb.ru0;
import tb.v50;

/* compiled from: Taobao */
public class DamaiHavanaFragment extends AliUserMobileLoginFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282130676")) {
                ipChange.ipc$dispatch("1282130676", new Object[]{this, editable});
                return;
            }
            DamaiHavanaFragment.this.changeSmsBtnBackGround(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1204924879")) {
                ipChange.ipc$dispatch("1204924879", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2126685679")) {
                ipChange.ipc$dispatch("2126685679", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "962678827")) {
                ipChange.ipc$dispatch("962678827", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mSMSCodeET.setText("");
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mSendSMSCodeBtn.cancelCountDown();
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mSendSMSCodeBtn.setText(DamaiHavanaFragment.this.getContext().getString(R$string.aliuser_signup_verification_getCode));
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mSendSMSCodeBtn.setEnabled(true);
        }
    }

    /* compiled from: Taobao */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1932259850")) {
                ipChange.ipc$dispatch("1932259850", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mMobileLoginPresenter.directRegister(null, this.a, null);
        }
    }

    /* compiled from: Taobao */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605337129")) {
                ipChange.ipc$dispatch("605337129", new Object[]{this});
                return;
            }
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mRegionTV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mMobileET.setPadding(v50.a(DamaiHavanaFragment.this.getActivity(), 60.0f), ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mMobileET.getPaddingTop(), ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mMobileClearBtn.getWidth() + 30, ((AliUserMobileLoginFragment) DamaiHavanaFragment.this).mMobileET.getPaddingBottom());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeSmsBtnBackGround(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451379630")) {
            ipChange.ipc$dispatch("451379630", new Object[]{this, str});
        } else if (!isAdded()) {
        } else {
            if (!TextUtils.isEmpty(str)) {
                this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color));
            } else {
                this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color_disable_state));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public int getLayoutContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1264477023")) {
            return R$layout.dm_aliuser_fragment_mobile_login;
        }
        return ((Integer) ipChange.ipc$dispatch("1264477023", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481925001")) {
            ipChange.ipc$dispatch("1481925001", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        ht0.g(getActivity(), (getActivity() == null || getActivity().getWindow() == null) ? this.mRootView : getActivity().getWindow().getDecorView());
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442845018")) {
            return (View) ipChange.ipc$dispatch("442845018", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (TextUtils.isEmpty(AlipayInfo.getInstance().getApdidToken())) {
            UserTrackAdapter.sendUT("Event_EmptyApdidToken");
        } else {
            UserTrackAdapter.sendUT("Event_NonEmptyApdidToken");
        }
        if (this.mUserLoginActivity.getToolbar() != null) {
            this.mUserLoginActivity.getToolbar().setNavigationIcon(R$drawable.icon_back_black_normal);
        }
        if (this.mUserLoginActivity.getToolbar() != null) {
            this.mUserLoginActivity.getToolbar().setTitle("");
        }
        if (this.isHistoryMode) {
            this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color));
        } else {
            this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color_disable_state));
            this.mMobileET.addTextChangedListener(new a());
        }
        return onCreateView;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413914458")) {
            ipChange.ipc$dispatch("1413914458", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        cn.damai.common.user.c.e().o(this, ru0.f().g());
    }

    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onNeedReg(Login2RegParam login2RegParam) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "762998742")) {
            ipChange.ipc$dispatch("762998742", new Object[]{this, login2RegParam});
            return;
        }
        String str = login2RegParam.tips;
        String str2 = login2RegParam.token;
        if (isActive()) {
            DMDialog dMDialog = new DMDialog(this.mAttachedActivity);
            dMDialog.setCancelable(true);
            if (DataProviderFactory.getDataProvider().getSite() == 18) {
                dMDialog.i("再考虑下", new b());
            }
            dMDialog.n(getString(R$string.aliuser_agree_and_reg), new c(str2));
            dMDialog.v("温馨提示");
            DamaiProtocolView damaiProtocolView = new DamaiProtocolView(this.mAttachedActivity);
            damaiProtocolView.setRegTip(str);
            dMDialog.A(damaiProtocolView);
            ht0.g(getActivity(), dMDialog.c());
            dMDialog.show();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "535297497")) {
            ipChange.ipc$dispatch("535297497", new Object[]{this});
            return;
        }
        super.onResume();
        HavanaProxy.v().N();
        cn.damai.common.user.c.e().o(this, ru0.f().g());
        HavanaProxy.v().O(100);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment
    public void resizeMobileETPadding() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150536313")) {
            ipChange.ipc$dispatch("1150536313", new Object[]{this});
            return;
        }
        this.mRegionTV.getViewTreeObserver().addOnGlobalLayoutListener(new d());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853789765")) {
            ipChange.ipc$dispatch("-1853789765", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        cn.damai.common.user.c.e().o(this, ru0.f().g());
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void updateAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239540083")) {
            ipChange.ipc$dispatch("-239540083", new Object[]{this, str});
            return;
        }
        DMImageCreator c2 = cn.damai.common.image.a.b().c(d20.B(str));
        int i = R$drawable.uikit_user_default_icon;
        c2.i(i).c(i).g(this.mAvatarIV);
    }
}

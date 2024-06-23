package cn.damai.login.havana;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ht0;
import tb.ru0;

/* compiled from: Taobao */
public class DamaiRegisterFragment extends AliUserMobileRegisterFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private CheckBox mProtocolCb;
    private View mRegBtn;
    private LinearLayout rootView;

    /* compiled from: Taobao */
    public class a implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-117866968")) {
                ipChange.ipc$dispatch("-117866968", new Object[]{this, editable});
                return;
            }
            DamaiRegisterFragment.this.changeSmsBtnBackGround(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-564340965")) {
                ipChange.ipc$dispatch("-564340965", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1676431675")) {
                ipChange.ipc$dispatch("1676431675", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-590417904")) {
                ipChange.ipc$dispatch("-590417904", new Object[]{this, view});
            } else if (!DamaiRegisterFragment.this.mProtocolCb.isChecked()) {
                DamaiRegisterFragment.this.toast("请阅读并同意相关协议", 1);
            } else {
                DamaiRegisterFragment.super.onClick(view);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeSmsBtnBackGround(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394896902")) {
            ipChange.ipc$dispatch("-1394896902", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color));
        } else {
            this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color_disable_state));
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850489500")) {
            ipChange.ipc$dispatch("1850489500", new Object[]{this});
            return;
        }
        if (this.mAttachedActivity.getToolbar() != null) {
            this.mAttachedActivity.getToolbar().setTitle("新用户注册");
        }
        if (this.mAttachedActivity.getToolbar() != null) {
            this.mAttachedActivity.getToolbar().setNavigationIcon(R$drawable.icon_back_black_normal);
        }
        this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color_disable_state));
        this.mMobileET.addTextChangedListener(new a());
        this.mRegBtn.setOnClickListener(new b());
        this.mProtocolCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class cn.damai.login.havana.DamaiRegisterFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2051926801")) {
                    ipChange.ipc$dispatch("-2051926801", new Object[]{this, compoundButton, Boolean.valueOf(z)});
                } else if (z) {
                    ru0.f().k("agree", DamaiRegisterFragment.class.getSimpleName(), "0");
                } else {
                    ru0.f().k("disagree", DamaiRegisterFragment.class.getSimpleName(), "0");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.base.ui.BaseFragment
    public int getLayoutContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-118385237")) {
            return R$layout.dm_aliuser_fragment_mobile_register;
        }
        return ((Integer) ipChange.ipc$dispatch("-118385237", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public ProtocolModel getProtocolModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648574110")) {
            return (ProtocolModel) ipChange.ipc$dispatch("-1648574110", new Object[]{this});
        }
        ProtocolModel protocolModel = new ProtocolModel();
        protocolModel.protocolTitle = getString(R$string.aliuser_damai_protocol_text);
        HashMap hashMap = new HashMap();
        hashMap.put(getString(R$string.aliuser_damai_protocal), getString(R$string.aliuser_damai_protocol_url_new));
        hashMap.put(getString(R$string.aliuser_damai_policy_protocal), getString(R$string.aliuser_damai_policy_protocol_url_new));
        hashMap.put(getString(R$string.aliuser_damai_book_protocal), getString(R$string.aliuser_damai_book_policy_protocol_url));
        protocolModel.protocolItems = hashMap;
        protocolModel.protocolItemColor = R$color.aliuser_damai_protocol_color;
        return protocolModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465794517")) {
            ipChange.ipc$dispatch("465794517", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        initView();
        ht0.g(getActivity(), (getActivity() == null || getActivity().getWindow() == null) ? this.rootView : getActivity().getWindow().getDecorView());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389798199")) {
            ipChange.ipc$dispatch("389798199", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.mProtocolCb = (CheckBox) view.findViewById(R$id.dm_cb_register_pro);
        this.mRegBtn = view.findViewById(R$id.aliuser_register_reg_btn);
        this.rootView = (LinearLayout) view.findViewById(R$id.dm_aliuser_root_region);
    }
}

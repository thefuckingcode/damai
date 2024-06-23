package cn.damai.ticklet.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.fs1;
import tb.gr;
import tb.i30;
import tb.xs0;

/* compiled from: Taobao */
public class TickletBaseActivity<T extends a, E extends BaseModel> extends DamaiBaseActivity<T, E> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382513206")) {
            ipChange.ipc$dispatch("-382513206", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1886589984")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1886589984", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216746085")) {
            ipChange.ipc$dispatch("-216746085", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053300240")) {
            ipChange.ipc$dispatch("-1053300240", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61888851")) {
            ipChange.ipc$dispatch("-61888851", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504019053")) {
            ipChange.ipc$dispatch("504019053", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        LoginManager.k().c(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579280147")) {
            ipChange.ipc$dispatch("-579280147", new Object[]{this});
            return;
        }
        super.onDestroy();
        LoginManager.k().C(this);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025804490")) {
            ipChange.ipc$dispatch("1025804490", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330758667")) {
            ipChange.ipc$dispatch("1330758667", new Object[]{this});
        }
    }

    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310069252")) {
            ipChange.ipc$dispatch("1310069252", new Object[]{this});
        }
    }

    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631532320")) {
            ipChange.ipc$dispatch("1631532320", new Object[]{this});
        }
    }

    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663506327")) {
            ipChange.ipc$dispatch("-663506327", new Object[]{this});
        } else if (TextUtils.isEmpty(d20.i()) || d20.i().equals(fs1.c())) {
            onLoginSuccessBus();
        } else {
            DMNav.from(this).toUri(NavUri.b(gr.n));
            i30.e().a(xs0.a());
        }
    }

    public void onLoginSuccessBus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262042207")) {
            ipChange.ipc$dispatch("-262042207", new Object[]{this});
        }
    }

    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887914937")) {
            ipChange.ipc$dispatch("887914937", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1513846188")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1513846188", new Object[]{this});
    }
}

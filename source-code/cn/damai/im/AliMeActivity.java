package cn.damai.im;

import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import com.alibaba.security.common.track.model.a;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wk;

/* compiled from: Taobao */
public class AliMeActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879966266")) {
            ipChange.ipc$dispatch("1879966266", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1636332400")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1636332400", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619665419")) {
            ipChange.ipc$dispatch("1619665419", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40881536")) {
            ipChange.ipc$dispatch("40881536", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054932765")) {
            ipChange.ipc$dispatch("2054932765", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918558211")) {
            ipChange.ipc$dispatch("-1918558211", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(wk.j().k());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extras.putBoolean("refreshable", false);
            extras.putBoolean(MonitorType.SKIP, true);
            DMNav.from(this).withExtras(extras).toUri(NavUri.b(a.c.d));
        }
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "619943396")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("619943396", new Object[]{this});
    }
}

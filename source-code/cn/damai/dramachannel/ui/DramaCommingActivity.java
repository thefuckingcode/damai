package cn.damai.dramachannel.ui;

import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.dramachannel.fragment.DramaCommingFragment;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m30;

/* compiled from: Taobao */
public class DramaCommingActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1487495357")) {
                ipChange.ipc$dispatch("1487495357", new Object[]{this});
                return;
            }
            DramaCommingActivity.this.finish();
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "65954115")) {
                ipChange.ipc$dispatch("65954115", new Object[]{this});
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375336442")) {
            ipChange.ipc$dispatch("-375336442", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1653470244")) {
            return R$layout.activity_drama_comming;
        }
        return ((Integer) ipChange.ipc$dispatch("1653470244", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144028713")) {
            ipChange.ipc$dispatch("-2144028713", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669519564")) {
            ipChange.ipc$dispatch("-669519564", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552524567")) {
            ipChange.ipc$dispatch("-552524567", new Object[]{this});
            return;
        }
        setDamaiUTKeyBuilder(m30.f().g());
        c.e().K(this);
        hideBaseLayout();
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.theme_title_bar);
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.setTitle("大戏将售");
        simpleTitleLayout.showShareBtn(false);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.enableDivider(false);
        simpleTitleLayout.setListener(new a());
        getSupportFragmentManager().beginTransaction().add(R$id.drama_activity_root, new DramaCommingFragment()).commitAllowingStateLoss();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1553976216")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1553976216", new Object[]{this});
    }
}

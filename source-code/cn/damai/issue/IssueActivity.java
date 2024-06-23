package cn.damai.issue;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.comment.R$color;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ne2;

/* compiled from: Taobao */
public class IssueActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    IssueFragment issueFragment;

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504849314")) {
            ipChange.ipc$dispatch("-504849314", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null && !TextUtils.isEmpty(intent.getData().getPath()) && intent.getData().getPath().contains("activity/savecomment/index.html") && !LoginManager.k().q()) {
            LoginManager.k().w(this, new Intent());
            finish();
        }
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565573354")) {
            ipChange.ipc$dispatch("-565573354", new Object[]{this});
            return;
        }
        hideBaseLayout();
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = ne2.a(this);
            findViewById.setVisibility(0);
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-88915530")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-88915530", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794981186")) {
            ipChange.ipc$dispatch("-1794981186", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        IssueFragment issueFragment2 = this.issueFragment;
        if (issueFragment2 != null) {
            issueFragment2.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292536674")) {
            ipChange.ipc$dispatch("292536674", new Object[]{this});
            return;
        }
        IssueFragment issueFragment2 = this.issueFragment;
        if (issueFragment2 == null || !isCurrentFragment(issueFragment2)) {
            super.onBackPressed();
        } else {
            this.issueFragment.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374069315")) {
            ipChange.ipc$dispatch("1374069315", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_issue_wrapper);
        initTitle();
        initExtra();
        int i = R$id.publish_fragment;
        findViewById(i).setVisibility(0);
        this.issueFragment = new IssueFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.issueFragment.setArguments(getIntent().getExtras());
        beginTransaction.replace(i, this.issueFragment);
        beginTransaction.commitAllowingStateLoss();
        c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1910705750")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1910705750", new Object[]{this});
    }
}

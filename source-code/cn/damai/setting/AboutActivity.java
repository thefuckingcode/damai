package cn.damai.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.j92;
import tb.n6;

/* compiled from: Taobao */
public class AboutActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private long[] mHints = new long[5];
    private ImageView mIcon;
    private long mLastTimeMillis;
    private int mTimes = 1;
    private TextView version;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1899508597")) {
                ipChange.ipc$dispatch("1899508597", new Object[]{this, view});
            } else if (AboutActivity.this.isFastDoubleClick()) {
                ToastUtil a2 = ToastUtil.a();
                AboutActivity aboutActivity = AboutActivity.this;
                a2.j(aboutActivity, aboutActivity.LogMetaData());
            }
        }
    }

    public String LogMetaData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1859663200")) {
            return n6.a(this);
        }
        return (String) ipChange.ipc$dispatch("1859663200", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37285151")) {
            ipChange.ipc$dispatch("37285151", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1057649301")) {
            return R$layout.about_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("-1057649301", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289388688")) {
            ipChange.ipc$dispatch("-289388688", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989746363")) {
            ipChange.ipc$dispatch("989746363", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209611010")) {
            ipChange.ipc$dispatch("209611010", new Object[]{this});
            return;
        }
        setClearDoubleClick();
        this.version = (TextView) findViewById(R$id.version);
        this.mIcon = (ImageView) findViewById(R$id.iv);
        this.version.setOnClickListener(new a());
        TextView textView = this.version;
        textView.setText(getResources().getString(R$string.damai_about_shoujiban) + AppConfig.q() + "");
    }

    public boolean isFastDoubleClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1473288934")) {
            return ((Boolean) ipChange.ipc$dispatch("1473288934", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mLastTimeMillis;
        if (0 > j || j >= 1000) {
            this.mTimes = 1;
            this.mLastTimeMillis = currentTimeMillis;
        } else {
            int i = this.mTimes + 1;
            this.mTimes = i;
            if (i == 5) {
                this.mTimes = 1;
                return true;
            }
            this.mLastTimeMillis = currentTimeMillis;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541910008")) {
            ipChange.ipc$dispatch("541910008", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(j92.g().f());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953161887")) {
            ipChange.ipc$dispatch("953161887", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135267946")) {
            ipChange.ipc$dispatch("-2135267946", new Object[]{this});
        }
    }

    public void setClearDoubleClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662475015")) {
            ipChange.ipc$dispatch("662475015", new Object[]{this});
            return;
        }
        this.mLastTimeMillis = 0;
        this.mTimes = 0;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "153230495")) {
            return getResources().getString(R$string.damai_about);
        }
        return (String) ipChange.ipc$dispatch("153230495", new Object[]{this});
    }
}

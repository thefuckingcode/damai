package cn.damai.commonbusiness.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import cn.damai.commonbusiness.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import tb.ne2;

/* compiled from: Taobao */
public abstract class SimpleBaseActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-869424222")) {
                ipChange.ipc$dispatch("-869424222", new Object[]{this, view});
                return;
            }
            SimpleBaseActivity.this.finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1293646028")) {
            ipChange.ipc$dispatch("1293646028", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public int getInt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594114312")) {
            return ((Integer) ipChange.ipc$dispatch("594114312", new Object[]{this, str})).intValue();
        }
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey(str)) {
                return extras.getInt(str);
            }
        }
        return 0;
    }

    public long getLong(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808289266")) {
            return ((Long) ipChange.ipc$dispatch("808289266", new Object[]{this, str})).longValue();
        } else if (getIntent() == null || getIntent().getExtras() == null) {
            return 0;
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey(str)) {
                return extras.getLong(str);
            }
            return 0;
        }
    }

    public String getString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108926729")) {
            return (String) ipChange.ipc$dispatch("-108926729", new Object[]{this, str});
        } else if (getIntent() == null || getIntent().getExtras() == null) {
            return "";
        } else {
            Bundle extras = getIntent().getExtras();
            return extras.containsKey(str) ? extras.getString(str) : "";
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074941539")) {
            ipChange.ipc$dispatch("-1074941539", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887555538")) {
            ipChange.ipc$dispatch("-1887555538", new Object[]{this});
        }
    }

    public void initTransStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "398895131")) {
            ipChange.ipc$dispatch("398895131", new Object[]{this});
            return;
        }
        Window window = getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523977809")) {
            ipChange.ipc$dispatch("-1523977809", new Object[]{this});
            return;
        }
        this.base_header_left.setOnClickListener(new a());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167609036")) {
            ipChange.ipc$dispatch("167609036", new Object[]{this});
            return;
        }
        stopProgressDialog();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498040375")) {
            ipChange.ipc$dispatch("-498040375", new Object[]{this});
            return;
        }
        startProgressDialog();
    }

    public void setDarkStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985625388")) {
            ipChange.ipc$dispatch("1985625388", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(9216);
    }

    public void setImmersionsStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104073117")) {
            ipChange.ipc$dispatch("104073117", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
            }
            initTransStatusBar();
            setDarkStatusBarColor();
        } else if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void setLightStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084124274")) {
            ipChange.ipc$dispatch("-1084124274", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(1024);
    }
}

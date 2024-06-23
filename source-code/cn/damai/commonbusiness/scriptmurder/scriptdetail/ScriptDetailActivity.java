package cn.damai.commonbusiness.scriptmurder.scriptdetail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import com.alibaba.pictures.bricks.fragment.ScriptDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.ne2;
import tb.ur2;
import tb.v50;

/* compiled from: Taobao */
public final class ScriptDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ScriptDetailFragment mFragment;

    private final void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716188281")) {
            ipChange.ipc$dispatch("-1716188281", new Object[]{this});
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

    private final void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44697528")) {
            ipChange.ipc$dispatch("44697528", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(1024);
    }

    public final void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347203546")) {
            ipChange.ipc$dispatch("347203546", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        String str = null;
        String stringExtra = intent != null ? intent.getStringExtra("scriptId") : null;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("storeId");
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.container;
        ScriptDetailFragment scriptDetailFragment = new ScriptDetailFragment();
        this.mFragment = scriptDetailFragment;
        Bundle bundle = new Bundle();
        if (stringExtra != null) {
            bundle.putString("scriptId", stringExtra);
        }
        if (str != null) {
            bundle.putString("storeId", str);
        }
        scriptDetailFragment.setArguments(bundle);
        ur2 ur2 = ur2.INSTANCE;
        beginTransaction.add(i, scriptDetailFragment);
        beginTransaction.commit();
    }

    public final void addUtPage() {
        String stringExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1994087644")) {
            ipChange.ipc$dispatch("1994087644", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra = intent.getStringExtra("scriptId")) == null)) {
            hashMap.put("scriptkillid", stringExtra);
        }
        setDamaiUTKeyBuilder(new a.b().i("scriptkill").a(d20.d()).j(hashMap));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-232039869")) {
            return R$layout.activity_scriptkill_layout_root;
        }
        return ((Integer) ipChange.ipc$dispatch("-232039869", new Object[]{this})).intValue();
    }

    @Nullable
    public final ScriptDetailFragment getMFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1045428958")) {
            return this.mFragment;
        }
        return (ScriptDetailFragment) ipChange.ipc$dispatch("-1045428958", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        ScriptDetailFragment scriptDetailFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924506257")) {
            ipChange.ipc$dispatch("924506257", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 26504) {
            ScriptDetailFragment scriptDetailFragment2 = this.mFragment;
            if (scriptDetailFragment2 != null && scriptDetailFragment2.isAdded() && scriptDetailFragment2.isFragmentVisible()) {
                scriptDetailFragment2.autoRefresh();
            }
        } else if (i == 26505 && (scriptDetailFragment = this.mFragment) != null && scriptDetailFragment.isAdded() && scriptDetailFragment.isFragmentVisible()) {
            scriptDetailFragment.autoRefresh();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279393584")) {
            ipChange.ipc$dispatch("-1279393584", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        addUtPage();
        c.e().K(this);
    }

    public final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938431107")) {
            ipChange.ipc$dispatch("938431107", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = ne2.a(this);
            findViewById.setVisibility(0);
        }
        View findViewById2 = findViewById(R$id.nav_bar);
        ViewGroup.LayoutParams layoutParams = findViewById2 != null ? findViewById2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = findViewById.getLayoutParams().height + v50.a(this, 43.0f);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
    }

    public final void setMFragment(@Nullable ScriptDetailFragment scriptDetailFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024764918")) {
            ipChange.ipc$dispatch("2024764918", new Object[]{this, scriptDetailFragment});
            return;
        }
        this.mFragment = scriptDetailFragment;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "593792887")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("593792887", new Object[]{this});
    }
}

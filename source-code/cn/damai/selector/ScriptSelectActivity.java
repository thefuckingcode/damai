package cn.damai.selector;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.comment.R$color;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j52;
import tb.k21;
import tb.ne2;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptSelectActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    private final void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451109858")) {
            ipChange.ipc$dispatch("1451109858", new Object[]{this});
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
        if (!AndroidInstantRuntime.support(ipChange, "913400706")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("913400706", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115497035")) {
            ipChange.ipc$dispatch("1115497035", new Object[]{this});
            return;
        }
        super.initView();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        Integer num;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2124393487")) {
            ipChange.ipc$dispatch("2124393487", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_script_selector);
        initTitle();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        k21.h(beginTransaction, "supportFragmentManager.beginTransaction()");
        int i2 = R$id.fragment;
        ScriptSelectFragment scriptSelectFragment = new ScriptSelectFragment();
        Intent intent = getIntent();
        scriptSelectFragment.setArguments(intent != null ? intent.getExtras() : null);
        ur2 ur2 = ur2.INSTANCE;
        beginTransaction.replace(i2, scriptSelectFragment);
        beginTransaction.commitAllowingStateLoss();
        Bundle extras = getIntent().getExtras();
        if (!(extras == null || (string = extras.getString("pageType")) == null || (num = n.k(string)) == null)) {
            i = num.intValue();
        }
        setDamaiUTKeyBuilder(new a.b().i(i == 1 ? j52.PAGE_SCRIPT : j52.PAGE_SHOP));
        c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1223032438")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("1223032438", new Object[]{this});
    }
}

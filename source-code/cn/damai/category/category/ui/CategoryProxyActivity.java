package cn.damai.category.category.ui;

import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gr;

/* compiled from: Taobao */
public class CategoryProxyActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1641080922")) {
            return R$layout.activity_category_proxy;
        }
        return ((Integer) ipChange.ipc$dispatch("-1641080922", new Object[]{this})).intValue();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r0.equals("1") != false) goto L_0x004d;
     */
    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-599490393")) {
            ipChange.ipc$dispatch("-599490393", new Object[]{this});
            return;
        }
        super.initView();
        String stringExtra = getIntent().getStringExtra("option");
        if (stringExtra == null) {
            stringExtra = "";
        }
        switch (stringExtra.hashCode()) {
            case 48:
                if (stringExtra.equals("0")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 49:
                break;
            case 50:
                if (stringExtra.equals("2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            DMNav.from(this).toHost(gr.r);
        } else if (c == 1) {
            DMNav.from(this).toHost(gr.s);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-881613926")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-881613926", new Object[]{this});
    }
}

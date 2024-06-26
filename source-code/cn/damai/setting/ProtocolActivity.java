package cn.damai.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gr;
import tb.ls0;

/* compiled from: Taobao */
public class ProtocolActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-449782116")) {
                ipChange.ipc$dispatch("-449782116", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://help.damai.cn/helpPageH5Context.htm?pageId=38");
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1661508253")) {
                ipChange.ipc$dispatch("1661508253", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://help.damai.cn/helpPageH5Context.htm?pageId=40");
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-522168674")) {
                ipChange.ipc$dispatch("-522168674", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://help.damai.cn/helpPageH5Context.htm?pageId=112");
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1589121695")) {
                ipChange.ipc$dispatch("1589121695", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            String a2 = ls0.a("accountPerformServiceConfig");
            if (TextUtils.isEmpty(a2)) {
                a2 = "https://m.piao.com.cn/tickets/dianying/pages/alfheim/content.html?id=2204793&displayType=plain&hidetitle=yes&hsb=yes&interact=no&hideAuthorInfo=yes";
            }
            bundle.putString("url", a2);
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025052870")) {
            ipChange.ipc$dispatch("2025052870", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1872202908")) {
            return R$layout.activity_protocol;
        }
        return ((Integer) ipChange.ipc$dispatch("-1872202908", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229253271")) {
            ipChange.ipc$dispatch("229253271", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112222092")) {
            ipChange.ipc$dispatch("-112222092", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155994199")) {
            ipChange.ipc$dispatch("-1155994199", new Object[]{this});
            return;
        }
        findViewById(R$id.rl_protocol).setOnClickListener(new a());
        findViewById(R$id.rl_terms).setOnClickListener(new b());
        findViewById(R$id.rl_community).setOnClickListener(new c());
        findViewById(R$id.rl_perform_service).setOnClickListener(new d());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471803846")) {
            ipChange.ipc$dispatch("1471803846", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345145743")) {
            ipChange.ipc$dispatch("1345145743", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1786078504")) {
            return "协议规则";
        }
        return (String) ipChange.ipc$dispatch("-1786078504", new Object[]{this});
    }
}

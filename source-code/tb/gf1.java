package tb;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.tetris.component.star.bean.ModuleTitleModel;
import cn.damai.tetris.core.BasePresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gf1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private TextView b;
    private LinearLayout c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    BasePresenter g;

    /* compiled from: Taobao */
    public class a implements HavanaProxy.UccTrustLoginListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ModuleTitleModel.OperationBean a;

        a(ModuleTitleModel.OperationBean operationBean) {
            this.a = operationBean;
        }

        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
        public void onFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1070505461")) {
                ipChange.ipc$dispatch("-1070505461", new Object[]{this});
            }
        }

        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-793978466")) {
                ipChange.ipc$dispatch("-793978466", new Object[]{this});
                return;
            }
            DMNav.from(gf1.this.a).toUri(this.a.opUrl);
        }
    }

    public gf1(View view, Activity activity, BasePresenter basePresenter) {
        this.a = activity;
        this.f = (TextView) view.findViewById(R$id.module_title_more_text_2);
        this.e = (LinearLayout) view.findViewById(R$id.module_title_more_layout_2);
        this.d = (TextView) view.findViewById(R$id.module_title_more_text_1);
        this.c = (LinearLayout) view.findViewById(R$id.module_title_more_layout_1);
        this.b = (TextView) view.findViewById(R$id.module_title_label_x);
        this.g = basePresenter;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(ModuleTitleModel.OperationBean operationBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527213738")) {
            ipChange.ipc$dispatch("1527213738", new Object[]{this, operationBean, view});
            return;
        }
        String str = operationBean.opName;
        if (str == null || !"我的订单".equals(str)) {
            DMNav.from(this.a).toUri(operationBean.opUrl);
            this.g.userTrackClick("more", true);
        } else if (LoginManager.k().q() || this.a == null) {
            this.g.userTrackClick("myorder", true);
            HavanaProxy.v().P(this.a, new a(operationBean));
        } else {
            LoginManager.k().x(this.a, new Intent(), 1000);
        }
    }

    public void d(ModuleTitleModel moduleTitleModel) {
        LinearLayout linearLayout;
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522349648")) {
            ipChange.ipc$dispatch("-1522349648", new Object[]{this, moduleTitleModel});
        } else if (moduleTitleModel != null) {
            this.b.setText(moduleTitleModel.title);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.g.userTrackExpose(this.c, "myorder");
            this.g.userTrackExpose(this.e, "more");
            if (moduleTitleModel.opList != null) {
                for (int i = 0; i < Math.min(moduleTitleModel.opList.size(), 2); i++) {
                    ModuleTitleModel.OperationBean operationBean = moduleTitleModel.opList.get(i);
                    if (operationBean != null) {
                        if (i == 0) {
                            textView = this.d;
                            linearLayout = this.c;
                        } else {
                            textView = this.f;
                            linearLayout = this.e;
                        }
                        textView.setText(operationBean.opName);
                        linearLayout.setVisibility(0);
                        linearLayout.setOnClickListener(new ff1(this, operationBean));
                    }
                }
            }
        }
    }
}

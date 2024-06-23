package cn.damai.ticklet.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketAlipayCardBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gl2;
import tb.lw2;
import tb.ne2;

/* compiled from: Taobao */
public class TicketAlipayCardGuideActivity extends TickletBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private TicketAlipayCardBean ecertTipsInfo;
    private View mViewStatusBarSpace;
    private TextView tvCardGoto;
    private TextView tvCardRoute;
    private TextView tvCardTip;
    private TextView tvRule;
    private TextView tvTitle;
    private DMIconFontTextView tvTitleBack;

    private void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278523661")) {
            ipChange.ipc$dispatch("-1278523661", new Object[]{this});
            return;
        }
        finish();
    }

    private void returnAlipayData(TicketAlipayCardBean ticketAlipayCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21578101")) {
            ipChange.ipc$dispatch("-21578101", new Object[]{this, ticketAlipayCardBean});
            return;
        }
        lw2.E(this.tvCardRoute, ticketAlipayCardBean.mainTip);
        lw2.E(this.tvCardTip, ticketAlipayCardBean.subTips);
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612478617")) {
            ipChange.ipc$dispatch("1612478617", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1952205017")) {
            return R$layout.ticklet_alipay_card_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1952205017", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79238228")) {
            ipChange.ipc$dispatch("79238228", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.ticklet_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        this.tvCardRoute = (TextView) findViewById(R$id.ticklet_alipay_card_route);
        this.tvCardTip = (TextView) findViewById(R$id.ticklet_alipay_card_tip);
        this.tvCardGoto = (TextView) findViewById(R$id.ticklet_alipay_card_goto);
        setImmersionStyle();
        this.tvTitleBack.setOnClickListener(this);
        this.tvCardGoto.setOnClickListener(this);
        this.tvRule.setVisibility(8);
        this.tvTitle.setText("使用实人认证服务");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827712710")) {
            ipChange.ipc$dispatch("-1827712710", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.ticklet_rule_text_url) {
            lw2.f().n(this, gl2.DAMAI_TRANSFER_RULE_URL);
        } else if (view.getId() == R$id.ticklet_alipay_card_goto && !TextUtils.isEmpty(this.ecertTipsInfo.alipayOpenUrl)) {
            DMNav.from(this).toUri(this.ecertTipsInfo.alipayOpenUrl);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98239334")) {
            ipChange.ipc$dispatch("98239334", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            TicketAlipayCardBean ticketAlipayCardBean = (TicketAlipayCardBean) getIntent().getSerializableExtra("ecertTipsInfo");
            this.ecertTipsInfo = ticketAlipayCardBean;
            if (ticketAlipayCardBean != null) {
                returnAlipayData(ticketAlipayCardBean);
            } else {
                return;
            }
        }
        hideBaseLayout();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61228668")) {
            return ((Boolean) ipChange.ipc$dispatch("61228668", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }
}

package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.view.AutoHideTextView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.ne2;
import tb.nt1;
import tb.s50;

/* compiled from: Taobao */
public class ProjectCertDetailActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<String> approvalUrlList;
    private String cpName;
    private String entAddress;
    private String entType;
    private DMIconFontTextView ivBack;
    private String legalPerson;
    private LinearLayout llCertLayout;
    private String opFrom;
    private String opTo;
    private String regCapStr;
    private String socialCreditCode;
    private AutoHideTextView tvAddress;
    private AutoHideTextView tvCapital;
    private AutoHideTextView tvCpName;
    private AutoHideTextView tvCpType;
    private AutoHideTextView tvCreditCode;
    private AutoHideTextView tvLegalPersonName;
    private TextView tvPicListTitle;
    private AutoHideTextView tvTerm;

    private void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125330734")) {
            ipChange.ipc$dispatch("125330734", new Object[]{this});
            return;
        }
        this.llCertLayout = (LinearLayout) findViewById(R$id.ll_cert_layout);
        this.tvCpName = (AutoHideTextView) findViewById(R$id.tv_company_name);
        this.tvCreditCode = (AutoHideTextView) findViewById(R$id.tv_credit_code);
        this.tvCpType = (AutoHideTextView) findViewById(R$id.tv_company_type);
        this.tvLegalPersonName = (AutoHideTextView) findViewById(R$id.tv_legal_person_name);
        this.tvAddress = (AutoHideTextView) findViewById(R$id.tv_detail_address);
        this.tvCapital = (AutoHideTextView) findViewById(R$id.tv_legal_detail_capital);
        this.tvTerm = (AutoHideTextView) findViewById(R$id.tv_legal_term);
        this.tvPicListTitle = (TextView) findViewById(R$id.tv_pic_list_title);
    }

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927932892")) {
            ipChange.ipc$dispatch("1927932892", new Object[]{this});
        } else if (getIntent() == null) {
            finish();
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            this.approvalUrlList = extras.getStringArrayList("approvalUrlList");
            this.cpName = extras.getString("cpName");
            this.socialCreditCode = extras.getString("socialCreditCode");
            this.legalPerson = extras.getString("legalPerson");
            this.regCapStr = extras.getString("regCapStr");
            this.opFrom = extras.getString("opFrom");
            this.opTo = extras.getString("opTo");
            this.entType = extras.getString("entType");
            this.entAddress = extras.getString("entAddress");
        }
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508879093")) {
            ipChange.ipc$dispatch("1508879093", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583099857")) {
            ipChange.ipc$dispatch("-1583099857", new Object[]{this});
            return;
        }
        this.bese_head_view.setVisibility(8);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.title_left_icon);
        this.ivBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        initTitleStatusBar();
    }

    private void initViewData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-179710129")) {
            ipChange.ipc$dispatch("-179710129", new Object[]{this});
            return;
        }
        this.tvCpName.setContent(this.cpName);
        this.tvCreditCode.setContent(this.socialCreditCode);
        this.tvCpType.setContent(this.entType);
        this.tvLegalPersonName.setContent(this.legalPerson);
        this.tvAddress.setContent(this.entAddress);
        this.tvCapital.setContent(this.regCapStr);
        this.tvTerm.setContent((TextUtils.isEmpty(this.opFrom) || TextUtils.isEmpty(this.opTo)) ? "" : this.opFrom + "-" + this.opTo);
        int a = DisplayMetrics.getwidthPixels(s50.b(this)) - s50.a(this, 24.0f);
        for (int i = 0; i < this.approvalUrlList.size(); i++) {
            if (this.approvalUrlList.get(i) != null && !this.approvalUrlList.get(i).isEmpty()) {
                if (this.tvPicListTitle.getVisibility() == 8) {
                    this.tvPicListTitle.setVisibility(0);
                }
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, (a * 3) / 4);
                layoutParams.setMargins(0, s50.a(this, 12.0f), 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#f5f5f5"));
                this.llCertLayout.addView(imageView);
                a.b().c(this.approvalUrlList.get(i)).n(new nt1(this, a, imageView)).f();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewData$0(int i, ImageView imageView, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587556716")) {
            ipChange.ipc$dispatch("-1587556716", new Object[]{this, Integer.valueOf(i), imageView, eVar});
            return;
        }
        Bitmap bitmap = eVar.b;
        if (bitmap != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, (bitmap.getHeight() * i) / eVar.b.getWidth());
            layoutParams.setMargins(0, s50.a(this, 12.0f), 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageBitmap(eVar.b);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410195574")) {
            ipChange.ipc$dispatch("410195574", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1352575412")) {
            return R$layout.activity_project_cert_detail_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1352575412", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413133383")) {
            ipChange.ipc$dispatch("1413133383", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066644284")) {
            ipChange.ipc$dispatch("-2066644284", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226385063")) {
            ipChange.ipc$dispatch("-1226385063", new Object[]{this});
            return;
        }
        initExtra();
        initTitleView();
        initContentView();
        initViewData();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361348863")) {
            ipChange.ipc$dispatch("361348863", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.title_left_icon) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760328639")) {
            ipChange.ipc$dispatch("-760328639", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new a.b().i(IRequestConst.LICENSE));
        c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "473662760")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("473662760", new Object[]{this});
    }
}

package cn.damai.commonbusiness.fission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$dimen;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.fission.bean.FissionInfoBean;
import cn.damai.commonbusiness.fission.bean.FissionParam;
import cn.damai.commonbusiness.fission.view.FissionUpgradeContentView;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.wxapi.ShareUtil;
import com.ali.user.open.core.Site;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ne2;
import tb.q92;
import tb.ui0;
import tb.v50;
import tb.yt2;

/* compiled from: Taobao */
public class FissionUpgradeActivity extends DamaiBaseActivity implements FissionUpgradeContentView.ViewInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String SHARE_SAVE_IMAGE = "save_image";
    private final String SHARE_WEIBO = Site.WEIBO;
    private final String SHARE_WEIXIN_FRIEND = "weixin_friend";
    private ImageView contentImage;
    private FissionUpgradeContentView contentView;
    private ImageView copy_url;
    private FissionParam fissionParam = new FissionParam();
    private TextView fission_upgrade_main_title;
    private TextView fission_upgrade_tip;
    private String fromWhere = "fissionShare";
    int height = 0;
    private ImageView icon_friend;
    private ImageView icon_weibo;
    private ImageView icon_wx;
    private FissionInfoBean infoBean = new FissionInfoBean();
    private ConstraintLayout root;
    private ImageView savePic;
    private ScrollView scrollView;
    private View shareView;
    private Bitmap showBitmap = null;
    private View title_bar_space;
    private DMIconFontTextView tvTitleBack;
    int width = 0;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1019243284")) {
                ipChange.ipc$dispatch("-1019243284", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ui0.h().l(0, "weixin", false));
            FissionUpgradeActivity fissionUpgradeActivity = FissionUpgradeActivity.this;
            fissionUpgradeActivity.toShare(0, fissionUpgradeActivity.getShareUrl(), FissionUpgradeActivity.this.fissionParam.subMessage, FissionUpgradeActivity.this.fissionParam.getUniqueIdent());
            FissionUpgradeActivity.this.onBackPresss();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1092047085")) {
                ipChange.ipc$dispatch("1092047085", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ui0.h().l(1, "pengyouquan", false));
            FissionUpgradeActivity fissionUpgradeActivity = FissionUpgradeActivity.this;
            fissionUpgradeActivity.createPic("weixin_friend", view, fissionUpgradeActivity, fissionUpgradeActivity.getShareUrl(), FissionUpgradeActivity.this.fissionParam.imageUrl, FissionUpgradeActivity.this.fissionParam.projectName, FissionUpgradeActivity.this.fissionParam.subMessage, FissionUpgradeActivity.this.fissionParam.getUniqueIdent(), FissionUpgradeActivity.this.getImageUrl());
            FissionUpgradeActivity.this.onBackPresss();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1091629842")) {
                ipChange.ipc$dispatch("-1091629842", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ui0.h().l(2, Site.WEIBO, false));
            FissionUpgradeActivity fissionUpgradeActivity = FissionUpgradeActivity.this;
            fissionUpgradeActivity.createPic(Site.WEIBO, view, fissionUpgradeActivity, fissionUpgradeActivity.getShareUrl(), FissionUpgradeActivity.this.fissionParam.imageUrl, FissionUpgradeActivity.this.fissionParam.projectName, FissionUpgradeActivity.this.fissionParam.subMessage, FissionUpgradeActivity.this.fissionParam.getUniqueIdent(), FissionUpgradeActivity.this.getImageUrl());
            FissionUpgradeActivity.this.onBackPresss();
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1019660527")) {
                ipChange.ipc$dispatch("1019660527", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ui0.h().l(3, "savepic", false));
            FissionUpgradeActivity fissionUpgradeActivity = FissionUpgradeActivity.this;
            fissionUpgradeActivity.createPic("save_image", view, fissionUpgradeActivity, fissionUpgradeActivity.getShareUrl(), FissionUpgradeActivity.this.fissionParam.imageUrl, FissionUpgradeActivity.this.fissionParam.projectName, FissionUpgradeActivity.this.fissionParam.subMessage, FissionUpgradeActivity.this.fissionParam.getUniqueIdent(), FissionUpgradeActivity.this.getImageUrl());
        }
    }

    /* compiled from: Taobao */
    public class e implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ String b;

        e(View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-407814112")) {
                ipChange.ipc$dispatch("-407814112", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2116842247")) {
                ipChange.ipc$dispatch("2116842247", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            if ("weixin_friend".equals(this.b)) {
                ShareManager.E().m0(FissionUpgradeActivity.this);
            } else if (Site.WEIBO.equals(this.b)) {
                ShareManager.E().p0(FissionUpgradeActivity.this);
            } else if ("save_image".equals(this.b)) {
                ShareManager.E().o0(FissionUpgradeActivity.this);
            }
            ShareManager.E().C();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createPic(String str, View view, Activity activity, String str2, String str3, String str4, String str5, String str6, String str7) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "267959848")) {
            ipChange.ipc$dispatch("267959848", new Object[]{this, str, view, activity, str2, str3, str4, str5, str6, str7});
        } else if (activity != null) {
            view.setClickable(false);
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_NEW_SHARE_UPGRADE;
            if (getViewPagerBmp(1.0f) != null) {
                dMShareMessage.businessBitmap = getViewPagerBmp(1.0f);
                dMShareMessage.fromWhere = this.fromWhere;
                dMShareMessage.shareLink = getShareUrl();
                if (!"weixin_friend".equals(str) && !Site.WEIBO.equals(str) && !"save_image".equals(str)) {
                    z = false;
                }
                GenerateImageUtil.q(activity, dMShareMessage, z);
                GenerateImageUtil.G(new e(view, str));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getImageUrl() {
        FissionInfoBean.ActivityInfo activityInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073494962")) {
            return (String) ipChange.ipc$dispatch("-2073494962", new Object[]{this});
        }
        FissionInfoBean fissionInfoBean = this.infoBean;
        if (fissionInfoBean == null || (activityInfo = fissionInfoBean.shareInfo) == null) {
            return null;
        }
        return activityInfo.bgImageUrl;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getShareUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2081505098")) {
            return this.fissionParam.shareUrl;
        }
        return (String) ipChange.ipc$dispatch("2081505098", new Object[]{this});
    }

    private Bitmap getViewPagerBmp(float f) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949669697")) {
            return (Bitmap) ipChange.ipc$dispatch("-1949669697", new Object[]{this, Float.valueOf(f)});
        }
        Bitmap bitmap = this.showBitmap;
        if (bitmap != null && (i = this.width) > 0 && (i2 = this.height) > 0) {
            return yt2.j(bitmap, (double) (((float) i) * f), (double) (f * ((float) i2)));
        }
        layoutView(this, this.shareView);
        this.width = this.contentView.getMeasuredWidth();
        int measuredHeight = this.contentView.getMeasuredHeight();
        this.height = measuredHeight;
        int i3 = this.width;
        if (i3 <= 0 || measuredHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, measuredHeight, Bitmap.Config.ARGB_8888);
        this.contentView.draw(new Canvas(createBitmap));
        this.showBitmap = createBitmap;
        return yt2.j(createBitmap, (double) (((float) this.width) * f), (double) (f * ((float) this.height)));
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783834324")) {
            ipChange.ipc$dispatch("783834324", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R$layout.fission_upgrade_bitmap_image, (ViewGroup) null);
        this.shareView = inflate;
        FissionUpgradeContentView fissionUpgradeContentView = (FissionUpgradeContentView) inflate.findViewById(R$id.fission_upgrade_gen_view);
        this.contentView = fissionUpgradeContentView;
        fissionUpgradeContentView.setViewImp(this);
        this.contentView.update(this.infoBean, this.fissionParam, getShareUrl());
        if (!TextUtils.isEmpty(this.fissionParam.sceneTip)) {
            this.fission_upgrade_tip.setText(this.fissionParam.sceneTip);
        } else {
            this.fission_upgrade_tip.setVisibility(4);
        }
        FissionInfoBean.ActivityInfo activityInfo = this.infoBean.shareInfo;
        if (activityInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(activityInfo.mainTitle)) {
            this.fission_upgrade_main_title.setText(this.infoBean.shareInfo.mainTitle);
        } else {
            this.fission_upgrade_main_title.setVisibility(8);
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2061917666")) {
            ipChange.ipc$dispatch("-2061917666", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.scrollView = (ScrollView) findViewById(R$id.cb_fission_scrollview);
        this.title_bar_space = findViewById(R$id.cb_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.fission_upgrade_close);
        this.contentImage = (ImageView) findViewById(R$id.fission_upgrade_view);
        this.fission_upgrade_tip = (TextView) findViewById(R$id.fission_upgrade_tip);
        this.fission_upgrade_main_title = (TextView) findViewById(R$id.fission_upgrade_main_title);
        this.icon_wx = (ImageView) findViewById(R$id.icon_wx);
        this.icon_friend = (ImageView) findViewById(R$id.icon_friend);
        this.icon_weibo = (ImageView) findViewById(R$id.icon_weibo);
        this.copy_url = (ImageView) findViewById(R$id.icon_copy);
        this.savePic = (ImageView) findViewById(R$id.icon_save);
        setStatusBar();
        setListiner();
        setShareListener();
    }

    private static void layoutView(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591108289")) {
            ipChange.ipc$dispatch("591108289", new Object[]{activity, view});
            return;
        }
        DisplayMetrics b2 = v50.b(activity);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b2);
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private void setListiner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054632554")) {
            ipChange.ipc$dispatch("1054632554", new Object[]{this});
            return;
        }
        this.copy_url.setOnClickListener(this);
        this.tvTitleBack.setOnClickListener(this);
        setShareListener();
    }

    private void setShareListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065749725")) {
            ipChange.ipc$dispatch("1065749725", new Object[]{this});
            return;
        }
        this.icon_wx.setOnClickListener(new a());
        this.icon_friend.setOnClickListener(new b());
        this.icon_weibo.setOnClickListener(new c());
        this.savePic.setOnClickListener(new d());
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245982065")) {
            ipChange.ipc$dispatch("-1245982065", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (this.title_bar_space != null) {
                this.title_bar_space.setLayoutParams(new LinearLayout.LayoutParams(-1, ne2.a(this)));
                this.title_bar_space.setVisibility(0);
            }
            ne2.f(this, true, R$color.white);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.white);
            View view = this.title_bar_space;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void toShare(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807154793")) {
            ipChange.ipc$dispatch("1807154793", new Object[]{this, Integer.valueOf(i), str, str2, str3});
            return;
        }
        ShareUtil shareUtil = new ShareUtil(this, this.fromWhere);
        shareUtil.initShareData(!TextUtils.isEmpty(this.infoBean.shareInfo.chickenSoup) ? this.infoBean.shareInfo.chickenSoup : this.fissionParam.projectName, str2, this.fissionParam.imageUrl, str, null, "", Long.parseLong(str3));
        shareUtil.shareByWchart(i);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132440810")) {
            ipChange.ipc$dispatch("-2132440810", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-69790956")) {
            return R$layout.commonbusiness_fission_upgrade_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-69790956", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269448935")) {
            ipChange.ipc$dispatch("269448935", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133843492")) {
            ipChange.ipc$dispatch("1133843492", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205132807")) {
            ipChange.ipc$dispatch("-205132807", new Object[]{this});
            return;
        }
        initViews();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789114976")) {
            ipChange.ipc$dispatch("-1789114976", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    public void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "464110616")) {
            ipChange.ipc$dispatch("464110616", new Object[]{this});
            return;
        }
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33199713")) {
            ipChange.ipc$dispatch("-33199713", new Object[]{this, view});
        } else if (view.getId() == R$id.icon_copy) {
            if (this.infoBean != null && this.mContext != null) {
                cn.damai.common.user.c.e().x(ui0.h().l(4, "copy_url", false));
                Context context = this.mContext;
                q92.a(context, getShareUrl());
            }
        } else if (view.getId() == R$id.fission_upgrade_close) {
            onBackPresss();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106432607")) {
            ipChange.ipc$dispatch("-106432607", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(ui0.h().f(ui0.SHARE_PAGE, "平行麦现场"));
        if (getIntent() != null) {
            this.infoBean = (FissionInfoBean) getIntent().getSerializableExtra("fissionResult");
            this.fissionParam = (FissionParam) getIntent().getSerializableExtra("fissionParam");
        }
        if (this.infoBean != null && this.fissionParam != null) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724875487")) {
            ipChange.ipc$dispatch("-724875487", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879317897")) {
            return ((Boolean) ipChange.ipc$dispatch("-1879317897", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511999510")) {
            ipChange.ipc$dispatch("1511999510", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147409601")) {
            ipChange.ipc$dispatch("-1147409601", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465694082")) {
            ipChange.ipc$dispatch("465694082", new Object[]{this});
            return;
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1984956040")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1984956040", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.fission.view.FissionUpgradeContentView.ViewInterface
    public void showView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1137024660")) {
            ipChange.ipc$dispatch("-1137024660", new Object[]{this});
            return;
        }
        float f = (float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(v50.b(this));
        this.contentImage.setImageBitmap(getViewPagerBmp((f - (getResources().getDimension(R$dimen.margin_fission_width) * 2.0f)) / f));
    }
}

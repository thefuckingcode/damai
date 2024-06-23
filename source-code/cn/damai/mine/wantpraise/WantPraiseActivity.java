package cn.damai.mine.wantpraise;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.mycollect.ui.adapter.MyCollectTitleAdapter;
import cn.damai.mine.wantpraise.fragment.WantPraiseBaseFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.jl1;
import tb.ne2;
import tb.yd1;

/* compiled from: Taobao */
public class WantPraiseActivity extends DamaiBaseActivity implements WantPriseCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private MyCollectTitleAdapter mPagerAdapter;
    private EqualLinearView mTitleScroll;
    private String[] mTitles;
    private TextView mTvTitle;
    private DMIconFontTextView mTvTitleBack;
    private TextView mTvTitleRight;
    private ViewPager mViewPager;
    private View mViewStatusBarSpace;
    private WantPraiseBaseFragment praiseFragment;
    private String preSuffix;
    private String priseNum = "";
    private boolean self = false;
    private String targetIdStr = "";
    private WantPraiseBaseFragment wantFragment;
    private String wantNum = "";

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1821288120")) {
                ipChange.ipc$dispatch("1821288120", new Object[]{this, view});
                return;
            }
            WantPraiseActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-362388807")) {
                ipChange.ipc$dispatch("-362388807", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null && WantPraiseActivity.this.mViewPager != null) {
                WantPraiseActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290882208")) {
            ipChange.ipc$dispatch("1290882208", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.targetIdStr = intent.getStringExtra("targetIdStr");
            this.self = intent.getBooleanExtra("self", false);
        }
        setDamaiUTKeyBuilder(new a.b().i(yd1.WANT_PRAISE_PAGE));
    }

    private void initPageHeadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326500534")) {
            ipChange.ipc$dispatch("1326500534", new Object[]{this});
            return;
        }
        this.mTitleScroll = (EqualLinearView) findViewById(R$id.scroll_title);
        String[] strArr = new String[2];
        this.mTitles = strArr;
        strArr[0] = "赞";
        strArr[1] = "想看";
        initTitleData();
        this.mTitleScroll.selectTitle(1);
    }

    private void initTitleData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-763698658")) {
            ipChange.ipc$dispatch("-763698658", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        int length = this.mTitles.length;
        for (int i = 0; i < length; i++) {
            ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
            scrollTitleBean.index = i;
            scrollTitleBean.name = this.mTitles[i];
            arrayList.add(scrollTitleBean);
        }
        this.mTitleScroll.setFontColor(R$color.color_000000, R$color.color_333333).setFontSize(16, 16).setTitle(arrayList).setHeight(46).setOnTitleClickListener(new b()).commit();
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752665789")) {
            ipChange.ipc$dispatch("-1752665789", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        View findViewById = findViewById(R$id.mine_relation_ship_title);
        this.mViewStatusBarSpace = findViewById.findViewById(R$id.title_bar_space);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById.findViewById(R$id.mine_title_left_icon_font_tv);
        this.mTvTitleBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new a());
        TextView textView = (TextView) findViewById.findViewById(R$id.mine_title_tv);
        this.mTvTitle = textView;
        this.preSuffix = "我";
        if (!this.self) {
            this.preSuffix = "TA";
        }
        textView.setText(this.preSuffix + "的获赞与想看");
        TextView textView2 = (TextView) findViewById.findViewById(R$id.mine_title_right_tv);
        this.mTvTitleRight = textView2;
        textView2.setVisibility(8);
        setTitleImmersiveStyle();
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921959586")) {
            ipChange.ipc$dispatch("1921959586", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.relation_pager);
        ArrayList arrayList = new ArrayList();
        this.wantFragment = WantPraiseBaseFragment.getInstance("1", this.targetIdStr, this.self);
        this.praiseFragment = WantPraiseBaseFragment.getInstance("0", this.targetIdStr, this.self);
        this.wantFragment.setCallback(this);
        this.praiseFragment.setCallback(this);
        arrayList.add(this.praiseFragment);
        arrayList.add(this.wantFragment);
        MyCollectTitleAdapter myCollectTitleAdapter = new MyCollectTitleAdapter(getSupportFragmentManager(), arrayList);
        this.mPagerAdapter = myCollectTitleAdapter;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setAdapter(myCollectTitleAdapter);
            this.mTitleScroll.selectTitle(0);
            this.mViewPager.setCurrentItem(1);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                /* class cn.damai.mine.wantpraise.WantPraiseActivity.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-944140968")) {
                        ipChange.ipc$dispatch("-944140968", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1675555319")) {
                        ipChange.ipc$dispatch("1675555319", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1160660317")) {
                        ipChange.ipc$dispatch("-1160660317", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    WantPraiseActivity.this.mTitleScroll.selectTitle(i);
                    if (i == 0) {
                        c.e().x(yd1.x().f0(0, "0"));
                    } else {
                        c.e().x(yd1.x().f0(1, "1"));
                    }
                }
            });
            this.mViewPager.setOffscreenPageLimit(2);
        }
    }

    private void setTitleImmersiveStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976675058")) {
            ipChange.ipc$dispatch("-976675058", new Object[]{this});
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

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246944542")) {
            ipChange.ipc$dispatch("-246944542", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-6258744")) {
            return R$layout.want_prise_info_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-6258744", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2056019789")) {
            ipChange.ipc$dispatch("-2056019789", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381227330")) {
            ipChange.ipc$dispatch("381227330", new Object[]{this});
            return;
        }
        initPageHeadView();
        initViewPager();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058757080")) {
            ipChange.ipc$dispatch("2058757080", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301915077")) {
            ipChange.ipc$dispatch("301915077", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400275883")) {
            ipChange.ipc$dispatch("-1400275883", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initData();
        initTitleView();
        initContentView();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813469214")) {
            ipChange.ipc$dispatch("-813469214", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083877389")) {
            ipChange.ipc$dispatch("-1083877389", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1702045756")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("1702045756", new Object[]{this});
    }

    @Override // cn.damai.mine.wantpraise.WantPriseCallback
    public void titleRefresh(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-703186293")) {
            ipChange.ipc$dispatch("-703186293", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        if (!this.wantNum.equals(str) || !this.priseNum.equals(str2)) {
            this.wantNum = str;
            this.priseNum = str2;
            String[] strArr = this.mTitles;
            strArr[0] = "赞(" + str2 + jl1.BRACKET_END_STR;
            String[] strArr2 = this.mTitles;
            strArr2[1] = "想看(" + str + jl1.BRACKET_END_STR;
            initTitleData();
        }
    }
}

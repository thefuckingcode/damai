package cn.damai.ultron.secondpage.notice.view;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.servicenotice.ProjectTicketNoticeAdapter;
import cn.damai.commonbusiness.servicenotice.TicketNoteList;
import cn.damai.ultron.R$anim;
import cn.damai.ultron.R$color;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.secondpage.notice.bean.DmNoteListBean;
import cn.damai.ultron.secondpage.notice.bean.DmNoticeTitleBean;
import cn.damai.ultron.secondpage.notice.net.DmPurchaseNoticeViewModel;
import cn.damai.ultron.secondpage.notice.view.DmPurchaseIndicatorView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ln2;
import tb.ma0;
import tb.n42;
import tb.ne2;
import tb.xf2;

/* compiled from: Taobao */
public class DmPurchaseNoticeActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean fromConform;
    private LinearLayout layout_bottom;
    View mAnimView;
    private LinearLayout mEmptyPageView;
    private DmPurchaseIndicatorView mPagerIndicator;
    private TextView mTvEmptyContent;
    private DmPurchaseNoticeViewModel mViewModel;
    private ViewPager mViewPager;
    private View statusBar;
    private List<DmNoticeTitleBean> titleListBeans = new ArrayList();
    private View v_outside;

    /* compiled from: Taobao */
    public class a implements DmPurchaseIndicatorView.OnAnchorItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.ultron.secondpage.notice.view.DmPurchaseIndicatorView.OnAnchorItemClickListener
        public void onAnchorItemClick(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1169938209")) {
                ipChange.ipc$dispatch("-1169938209", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            DmPurchaseNoticeActivity.this.mViewPager.setCurrentItem(i);
            c.e().x(ma0.u().h(DmPurchaseNoticeActivity.this.fromConform, DmPurchaseNoticeActivity.this.mViewModel != null ? DmPurchaseNoticeActivity.this.mViewModel.getItemId() : "0", str));
        }
    }

    /* compiled from: Taobao */
    public class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "352042503")) {
                ipChange.ipc$dispatch("352042503", new Object[]{this, animation});
                return;
            }
            DmPurchaseNoticeActivity.this.finish();
            DmPurchaseNoticeActivity.this.overridePendingTransition(0, 0);
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1124536307")) {
                ipChange.ipc$dispatch("-1124536307", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1800596384")) {
                ipChange.ipc$dispatch("1800596384", new Object[]{this, animation});
            }
        }
    }

    private void initListenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1097033101")) {
            ipChange.ipc$dispatch("-1097033101", new Object[]{this});
            return;
        }
        this.mPagerIndicator.setOnAnchorItemClickListener(new a());
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ultron.secondpage.notice.view.DmPurchaseNoticeActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1724084421")) {
                    ipChange.ipc$dispatch("1724084421", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "40211044")) {
                    ipChange.ipc$dispatch("40211044", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1989176752")) {
                    ipChange.ipc$dispatch("-1989176752", new Object[]{this, Integer.valueOf(i)});
                } else if (DmPurchaseNoticeActivity.this.mPagerIndicator != null) {
                    DmPurchaseNoticeActivity.this.mPagerIndicator.setSelectAnchor(i);
                }
            }
        });
    }

    private void initStateBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1795553595")) {
            ipChange.ipc$dispatch("1795553595", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar);
        this.statusBar = findViewById;
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                this.statusBar.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            ne2.e(this);
            return;
        }
        ne2.f(this, false, R$color.black);
        View view = this.statusBar;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadData(List<TicketNoteList> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-524196690")) {
            ipChange.ipc$dispatch("-524196690", new Object[]{this, list});
            return;
        }
        this.mViewPager.setVisibility(0);
        this.mEmptyPageView.setVisibility(8);
        this.titleListBeans.clear();
        int e = xf2.e(list);
        if (e <= 0) {
            loadFailPage(null);
            return;
        }
        this.mViewPager.setAdapter(new ProjectTicketNoticeAdapter(this, list));
        for (int i2 = 0; i2 < e; i2++) {
            DmNoticeTitleBean dmNoticeTitleBean = new DmNoticeTitleBean();
            dmNoticeTitleBean.index = i2;
            dmNoticeTitleBean.name = list.get(i2).getNoteTitle();
            this.titleListBeans.add(dmNoticeTitleBean);
        }
        this.mPagerIndicator.setAnchorList(this.titleListBeans);
        initListenter();
        DmPurchaseNoticeViewModel dmPurchaseNoticeViewModel = this.mViewModel;
        int currentIndex = dmPurchaseNoticeViewModel != null ? dmPurchaseNoticeViewModel.getCurrentIndex() : 0;
        if (currentIndex < e) {
            i = currentIndex;
        }
        this.mPagerIndicator.setSelectAnchor(i);
        this.mViewPager.setCurrentItem(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadFailPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582041084")) {
            ipChange.ipc$dispatch("-582041084", new Object[]{this, str});
            return;
        }
        this.mEmptyPageView.setVisibility(0);
        this.mViewPager.setVisibility(8);
        TextView textView = this.mTvEmptyContent;
        if (str == null) {
            str = "网络异常";
        }
        textView.setText(str);
    }

    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501773461")) {
            ipChange.ipc$dispatch("-501773461", new Object[]{this});
        } else if (this.mAnimView == null) {
            finish();
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.activity_item_animexit);
            this.mAnimView.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new b());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1330586315")) {
            return R$layout.dm_purchase_notice;
        }
        return ((Integer) ipChange.ipc$dispatch("-1330586315", new Object[]{this})).intValue();
    }

    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638575699")) {
            ipChange.ipc$dispatch("1638575699", new Object[]{this});
            return;
        }
        DmPurchaseNoticeViewModel dmPurchaseNoticeViewModel = (DmPurchaseNoticeViewModel) ViewModelProviders.of(this).get(DmPurchaseNoticeViewModel.class);
        this.mViewModel = dmPurchaseNoticeViewModel;
        if (TextUtils.isEmpty(dmPurchaseNoticeViewModel.getItemId(getIntent()))) {
            ToastUtil.i("项目Id不能为空");
            finish();
        }
        this.fromConform = this.mViewModel.isConform();
        this.mViewModel.getNoticeLiveData().observe(this, new Observer<DmNoteListBean>() {
            /* class cn.damai.ultron.secondpage.notice.view.DmPurchaseNoticeActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable DmNoteListBean dmNoteListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-429615863")) {
                    ipChange.ipc$dispatch("-429615863", new Object[]{this, dmNoteListBean});
                } else if (dmNoteListBean == null) {
                    DmPurchaseNoticeActivity.this.loadFailPage(null);
                } else if (!dmNoteListBean.requestSuccess) {
                    DmPurchaseNoticeActivity.this.loadFailPage(dmNoteListBean.requestFailMsg);
                } else if (xf2.e(dmNoteListBean.noticeList) > 0) {
                    DmPurchaseNoticeActivity.this.loadData(dmNoteListBean.noticeList);
                } else {
                    DmPurchaseNoticeActivity.this.loadFailPage(null);
                }
            }
        });
        this.mViewModel.queryNoticeData();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649608568")) {
            ipChange.ipc$dispatch("649608568", new Object[]{this});
            return;
        }
        super.initView();
        hideBaseLayout();
        findViewById(R$id.ok).setOnClickListener(this);
        this.v_outside = findViewById(R$id.v_outside);
        DmPurchaseIndicatorView dmPurchaseIndicatorView = (DmPurchaseIndicatorView) findViewById(R$id.indicator);
        this.mPagerIndicator = dmPurchaseIndicatorView;
        dmPurchaseIndicatorView.setAnchorFontColor(getResources().getColor(R$color.color_000000), getResources().getColor(R$color.color_9C9CA5));
        this.mViewPager = (ViewPager) findViewById(R$id.view_pager);
        this.layout_bottom = (LinearLayout) findViewById(R$id.layout_bottom);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.rl_empty_view);
        this.mEmptyPageView = linearLayout;
        this.mTvEmptyContent = (TextView) linearLayout.findViewById(R$id.tv_empty_content);
        this.mEmptyPageView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.layout_bottom.getLayoutParams();
        layoutParams.height = (int) (((double) DisplayMetrics.getheightPixels(n42.b(this))) * 0.75d);
        this.layout_bottom.setLayoutParams(layoutParams);
        this.layout_bottom.startAnimation(AnimationUtils.loadAnimation(this, R$anim.activity_item_animshow));
        this.layout_bottom.setOnClickListener(this);
        setAnimationView(this.layout_bottom);
        this.v_outside.setOnClickListener(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149682526")) {
            ipChange.ipc$dispatch("149682526", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.v_outside || R$id.ok == id) {
            finishActivity();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267949506")) {
            ipChange.ipc$dispatch("1267949506", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initStateBar();
        initData();
        if (this.fromConform) {
            setDamaiUTKeyBuilder(ma0.u().o(this));
        } else {
            setDamaiUTKeyBuilder(new a.b().i(ln2.ORDER_DETAL_PAGE));
        }
    }

    public void setAnimationView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366378508")) {
            ipChange.ipc$dispatch("366378508", new Object[]{this, view});
            return;
        }
        this.mAnimView = view;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-225901847")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-225901847", new Object[]{this});
    }
}

package cn.damai.ticklet.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.EvaluateListFragment;
import cn.damai.evaluate.ui.TickletToCommentFragment;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.ui.adapter.TickletMyCommentAdapter;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.gl2;
import tb.ne2;
import tb.sl2;

/* compiled from: Taobao */
public class TicketMyCommentActivity extends DamaiBaseActivity implements EvaluateItemDataBinder.EvaluateItemUTReportListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletMyCommentAdapter mAdapter;
    private HorScrollView mScrollView;
    private ViewPager mViewPager;
    private int selectedTab;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-580903879")) {
                ipChange.ipc$dispatch("-580903879", new Object[]{this, view});
                return;
            }
            TicketMyCommentActivity.this.mViewPager.setCurrentItem(((ScrollTitleBean) view.getTag()).index);
        }
    }

    private List<Fragment> getFragments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712258170")) {
            return (List) ipChange.ipc$dispatch("1712258170", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(TickletToCommentFragment.getInstance("", ""));
        EvaluateListFragment evaluateListFragment = new EvaluateListFragment();
        evaluateListFragment.setEvalutateItemClickUTData(this);
        Bundle bundle = new Bundle();
        bundle.putInt("fromWhere", EvaluateListFragment.EVALUATELIST_ALLREADY);
        evaluateListFragment.setArguments(bundle);
        arrayList.add(evaluateListFragment);
        return arrayList;
    }

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225710736")) {
            ipChange.ipc$dispatch("-225710736", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.selectedTab = intent.getIntExtra("tab", 0);
        }
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252259242")) {
            ipChange.ipc$dispatch("-1252259242", new Object[]{this});
            return;
        }
        findViewById(R$id.icon_left_icon).setOnClickListener(this);
    }

    private void initScrollTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259976235")) {
            ipChange.ipc$dispatch("-259976235", new Object[]{this});
            return;
        }
        this.mScrollView = (HorScrollView) findViewById(R$id.scroll_title);
        ArrayList arrayList = new ArrayList();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
        scrollTitleBean.id = "0";
        scrollTitleBean.index = 0;
        scrollTitleBean.name = gl2.TO_COMMENT;
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean();
        scrollTitleBean2.id = "1";
        scrollTitleBean2.index = 1;
        scrollTitleBean2.name = gl2.FINISH_COMMENT;
        arrayList.add(scrollTitleBean);
        arrayList.add(scrollTitleBean2);
        this.mScrollView.setTitle(arrayList);
        this.mScrollView.setFontColor(R$color.black, R$color.color_9C9CA5);
        this.mScrollView.setFontSize(16, 20);
        this.mScrollView.setSpace(36);
        this.mScrollView.setOnTitleClickListener(new a());
        this.mScrollView.commit();
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286434776")) {
            ipChange.ipc$dispatch("-286434776", new Object[]{this});
            return;
        }
        hideBaseLayout();
        ((TextView) findViewById(R$id.tv_header_title)).setText("我的评价");
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

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904819490")) {
            ipChange.ipc$dispatch("1904819490", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.ticklet_mycomment_viewpager);
        TickletMyCommentAdapter tickletMyCommentAdapter = new TickletMyCommentAdapter(getSupportFragmentManager(), getFragments());
        this.mAdapter = tickletMyCommentAdapter;
        this.mViewPager.setAdapter(tickletMyCommentAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.ui.activity.TicketMyCommentActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "159523866")) {
                    ipChange.ipc$dispatch("159523866", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1505979065")) {
                    ipChange.ipc$dispatch("1505979065", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "631340005")) {
                    ipChange.ipc$dispatch("631340005", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TicketMyCommentActivity.this.mScrollView.selectTitle(i);
                c.e().x(sl2.j().v(i, i == 0 ? gl2.TO_COMMENT : gl2.FINISH_COMMENT));
            }
        });
        this.mViewPager.setCurrentItem(this.selectedTab);
        this.mScrollView.selectTitle(this.selectedTab);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233563746")) {
            ipChange.ipc$dispatch("233563746", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1875285576")) {
            return R$layout.ticklet_mycomment_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1875285576", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437279283")) {
            ipChange.ipc$dispatch("437279283", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041616984")) {
            ipChange.ipc$dispatch("2041616984", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2029278533")) {
            ipChange.ipc$dispatch("2029278533", new Object[]{this});
            return;
        }
        initTitle();
        initExtra();
        initScrollTitle();
        initViewPager();
        initListener();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000302613")) {
            ipChange.ipc$dispatch("-1000302613", new Object[]{this, view});
            return;
        }
        if (view.getId() == R$id.icon_left_icon) {
            finish();
        }
        super.onClick(view);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21851435")) {
            ipChange.ipc$dispatch("-21851435", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(sl2.j().l(sl2.TICKLET_MYCOMMENT_LIST_PAGE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084885680")) {
            ipChange.ipc$dispatch("-2084885680", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (commentsItemBean != null) {
            String videoId = (i2 != 0 || commentsItemBean.getVideoDO() == null) ? "" : commentsItemBean.getVideoDO().getVideoId();
            Map<String, String> S = sl2.j().S(gl2.FINISH_COMMENT);
            S.put("video_id", videoId);
            c.e().x(sl2.j().z(sl2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + i, "pic_" + i2, S, Boolean.TRUE));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145317683")) {
            ipChange.ipc$dispatch("-1145317683", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null) {
            c e = c.e();
            sl2 j = sl2.j();
            e.x(j.z(sl2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "card", sl2.j().S(gl2.FINISH_COMMENT), Boolean.TRUE));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248914115")) {
            ipChange.ipc$dispatch("-1248914115", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        c e = c.e();
        sl2 j = sl2.j();
        e.x(j.z(sl2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "share", sl2.j().S(gl2.FINISH_COMMENT), Boolean.FALSE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438334047")) {
            ipChange.ipc$dispatch("438334047", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        c e = c.e();
        sl2 j = sl2.j();
        e.x(j.z(sl2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "likes", sl2.j().S(gl2.FINISH_COMMENT), Boolean.FALSE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060996530")) {
            ipChange.ipc$dispatch("1060996530", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        c e = c.e();
        sl2 j = sl2.j();
        e.x(j.z(sl2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "reply_btn", sl2.j().S(gl2.FINISH_COMMENT), Boolean.TRUE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160929259")) {
            ipChange.ipc$dispatch("-160929259", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604196341")) {
            ipChange.ipc$dispatch("604196341", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        c e = c.e();
        sl2 j = sl2.j();
        e.x(j.z(sl2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "item", sl2.j().S(gl2.FINISH_COMMENT), Boolean.TRUE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034049799")) {
            ipChange.ipc$dispatch("2034049799", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1676664508")) {
            return "我的评价";
        }
        return (String) ipChange.ipc$dispatch("1676664508", new Object[]{this});
    }
}

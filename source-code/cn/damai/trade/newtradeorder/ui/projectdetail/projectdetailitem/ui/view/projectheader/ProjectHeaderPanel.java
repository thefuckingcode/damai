package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.comment.view.DMHotDiscussView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.notice.bean.NoticeListBean;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.im.UserInfoUtil;
import cn.damai.trade.R$dimen;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.MarketingStallBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectPicAndVideo;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingUserBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.HeaderScoreTagAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.ProjectPicAndVideoAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.AvatarRecyclerView;
import cn.damai.uikit.view.DMRatingBar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cq;
import tb.f92;
import tb.gb;
import tb.ln2;
import tb.mg2;
import tb.n42;
import tb.ne2;
import tb.og2;
import tb.wu1;
import tb.xf2;

/* compiled from: Taobao */
public class ProjectHeaderPanel extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int A;
    private boolean B = true;
    private boolean C = false;
    private DmViewPager D;
    private ProjectPicAndVideoAdapter E;
    private TextView F;
    private LinearLayout G;
    private ImageView H;
    private List<ProjectPicAndVideo> I = new ArrayList();
    private ViewFlipper e;
    private View f;
    private FrameLayout g;
    private RecyclerView h;
    private View i;
    private View j;
    private View k;
    private View l;
    private ViewFlipper m;
    private View n;
    private View o;
    private View p;
    private b q;
    private og2 r;
    private mg2 s;
    private DMHotDiscussView t;
    boolean u = false;
    boolean v = false;
    private int w;
    private int x;
    private int y;
    private int z;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectRatingBean a;

        a(ProjectRatingBean projectRatingBean) {
            this.a = projectRatingBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-396152303")) {
                ipChange.ipc$dispatch("-396152303", new Object[]{this, view});
                return;
            }
            OnHeadClickListener onHeadClickListener = ProjectHeaderPanel.this.d;
            if (onHeadClickListener != null) {
                String str = this.a.commentUrl;
                onHeadClickListener.onScoreHeadTipClick(str, this.a.rating + "");
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectRatingBean a;

        b(ProjectRatingBean projectRatingBean) {
            this.a = projectRatingBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1715138066")) {
                ipChange.ipc$dispatch("1715138066", new Object[]{this, view});
                return;
            }
            ProjectHeaderPanel.this.v(this.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectRatingBean a;

        c(ProjectRatingBean projectRatingBean) {
            this.a = projectRatingBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-468538861")) {
                ipChange.ipc$dispatch("-468538861", new Object[]{this, view});
                return;
            }
            ProjectHeaderPanel.this.v(this.a);
        }
    }

    public ProjectHeaderPanel(Activity activity, long j2, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j2, view, onHeadClickListener);
        this.e = (ViewFlipper) view.findViewById(R$id.header_notice_ui_flipper);
        this.f = view.findViewById(R$id.header_notice_ui_root);
        this.g = (FrameLayout) view.findViewById(R$id.project_header_video);
        t();
        this.p = view.findViewById(R$id.header_base_info_ui);
        this.h = (RecyclerView) view.findViewById(R$id.irc_tour);
        this.i = view.findViewById(R$id.header_show_time_ui);
        this.j = view.findViewById(R$id.header_rank_rating_ui);
        this.l = view.findViewById(R$id.header_socre_ui);
        this.t = (DMHotDiscussView) view.findViewById(R$id.header_comment_ui);
        this.k = this.j.findViewById(R$id.header_rank_ui);
        this.n = view.findViewById(R$id.header_market_ui);
        this.o = view.findViewById(R$id.header_want_see_ui);
        this.q = new b(activity, j2, view, onHeadClickListener);
        this.r = new og2(activity, j2, view, onHeadClickListener);
        this.s = new mg2(activity, j2, view, onHeadClickListener);
        this.w = n42.a(activity, 30.0f);
        this.x = n42.a(activity, 36.0f);
        h();
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397841849")) {
            ipChange.ipc$dispatch("-1397841849", new Object[]{this});
            return;
        }
        try {
            this.y = this.a.getResources().getDimensionPixelSize(R$dimen.main_title_height);
            if (Build.VERSION.SDK_INT >= 23) {
                int a2 = ne2.a(this.a);
                this.A = a2;
                this.y += a2;
            }
            this.z = this.c.getPaddingTop();
            y(this.y);
            z();
        } catch (Exception unused) {
        }
    }

    private void i(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403424926")) {
            ipChange.ipc$dispatch("1403424926", new Object[]{this, projectItemDataBean});
            return;
        }
        MarketingStallBean d = gb.d(projectItemDataBean);
        if (d == null) {
            this.n.setVisibility(8);
        } else if (d.stallStyle == 1) {
            String str = d.mainText;
            if (!TextUtils.isEmpty(str)) {
                ImageView imageView = (ImageView) this.n.findViewById(R$id.market_icon);
                ((TextView) this.n.findViewById(R$id.market_tv)).setText(str);
                c((TextView) this.n.findViewById(R$id.market_tip), d.btnText);
                String str2 = d.iconUrl;
                if (TextUtils.isEmpty(str2)) {
                    imageView.setImageResource(R$drawable.icon_project_marketing);
                } else {
                    DMImageCreator c2 = cn.damai.common.image.a.b().c(str2);
                    int i2 = R$drawable.icon_project_marketing;
                    c2.i(i2).c(i2).g(imageView);
                }
                this.n.setOnClickListener(this);
                this.n.setVisibility(0);
                ln2.r().r2(this.n, this.b, d.utd);
                return;
            }
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(8);
        }
    }

    private void j(ProjectDetailDataBean projectDetailDataBean) {
        ProjectStaticDataBean staticData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405803404")) {
            ipChange.ipc$dispatch("405803404", new Object[]{this, projectDetailDataBean});
        } else if (projectDetailDataBean != null && (staticData = projectDetailDataBean.getStaticData()) != null) {
            ProjectNotice projectNotice = staticData.announcementMsg;
            this.e.removeAllViews();
            this.e.stopFlipping();
            this.f.setVisibility(8);
            NoticeListBean noticeListBean = staticData.announcementVO;
            if (noticeListBean != null && !f92.d(noticeListBean.getNoticeList())) {
                this.f.setVisibility(0);
                this.e.setOnClickListener(this);
                this.e.removeAllViews();
                for (int i2 = 0; i2 < staticData.announcementVO.getNoticeList().size(); i2++) {
                    View inflate = this.a.getLayoutInflater().inflate(R$layout.header_project_notice, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R$id.project_header_notice_content)).setText(staticData.announcementVO.getNoticeList().get(i2));
                    this.e.addView(inflate);
                }
                if (staticData.announcementVO.getNoticeList().size() > 1) {
                    this.e.setFlipInterval(3000);
                    this.e.startFlipping();
                }
                ln2.r().C1(this.e, String.valueOf(this.b));
            } else if (projectNotice == null || !projectNotice.isValid()) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.e.setOnClickListener(this);
                View inflate2 = this.a.getLayoutInflater().inflate(R$layout.header_project_notice, (ViewGroup) null);
                TextView textView = (TextView) inflate2.findViewById(R$id.project_header_notice_content);
                if (!TextUtils.isEmpty(projectNotice.name)) {
                    textView.setText(projectNotice.name + "：" + projectNotice.content);
                } else {
                    textView.setText(projectNotice.content);
                }
                this.e.addView(inflate2);
                this.e.showNext();
                ln2.r().C1(this.e, String.valueOf(this.b));
            }
        }
    }

    private void k(RankInfo rankInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681221900")) {
            ipChange.ipc$dispatch("-681221900", new Object[]{this, rankInfo});
            return;
        }
        this.j.setVisibility(8);
        if (rankInfo == null || TextUtils.isEmpty(rankInfo.getName()) || TextUtils.isEmpty(rankInfo.getOrder())) {
            this.k.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
        ((TextView) this.k.findViewById(R$id.rank_tv)).setText(rankInfo.getName());
        ((DMDigitTextView) this.k.findViewById(R$id.rank_num_tv)).setText("NO." + rankInfo.getOrder());
        ln2.r().q2(this.k, String.valueOf(this.b));
        if (this.v || this.u) {
            this.j.findViewById(R$id.rank_line).setVisibility(8);
            this.j.findViewById(R$id.rank_line_1dp).setVisibility(0);
            this.k.getLayoutParams().height = this.w;
            return;
        }
        this.j.findViewById(R$id.rank_line).setVisibility(0);
        this.j.findViewById(R$id.rank_line_1dp).setVisibility(8);
        this.k.getLayoutParams().height = this.x;
    }

    private void l(ProjectRatingBean projectRatingBean, ProjectDetailDataBean projectDetailDataBean) {
        boolean z2;
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        ProjectWantSeeBean projectWantSeeBean;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1078929721")) {
            ipChange.ipc$dispatch("-1078929721", new Object[]{this, projectRatingBean, projectDetailDataBean});
        } else if (projectRatingBean == null || xf2.e(projectRatingBean.userRatingVOS) == 0) {
            this.l.setVisibility(8);
            this.u = false;
        } else {
            this.l.setVisibility(0);
            this.u = true;
            ln2.r().a2(this.l, String.valueOf(this.b), String.valueOf(projectRatingBean.rating));
            View findViewById = this.l.findViewById(R$id.layout_score_tip);
            View findViewById2 = this.l.findViewById(R$id.tv_score_icon_tip);
            if (!TextUtils.isEmpty(projectRatingBean.commentUrl)) {
                findViewById2.setVisibility(0);
                findViewById.setOnClickListener(new a(projectRatingBean));
            } else {
                findViewById2.setVisibility(8);
            }
            this.l.findViewById(R$id.header_score_devide_line).setVisibility(0);
            if (projectRatingBean.rating >= 0.0d) {
                DMDigitTextView dMDigitTextView = (DMDigitTextView) this.l.findViewById(R$id.tv_score);
                dMDigitTextView.setVisibility(0);
                dMDigitTextView.setText(projectRatingBean.rating + "");
            }
            if (projectRatingBean.star >= 0) {
                DMRatingBar dMRatingBar = (DMRatingBar) this.l.findViewById(R$id.prj_score_star_view);
                dMRatingBar.setVisibility(0);
                dMRatingBar.setStarMark(((float) projectRatingBean.star) / 2.0f);
            }
            if (!TextUtils.isEmpty(projectRatingBean.starDesc)) {
                TextView textView = (TextView) this.l.findViewById(R$id.tv_socre_desc);
                textView.setVisibility(0);
                textView.setText(projectRatingBean.starDesc);
            }
            TextView textView2 = (TextView) this.l.findViewById(R$id.tv_rating_num_desc);
            if (!TextUtils.isEmpty(projectRatingBean.ratingNumDesc)) {
                textView2.setText(projectRatingBean.ratingNumDesc);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            View findViewById3 = this.l.findViewById(R$id.tv_score_to_comment);
            this.m = (ViewFlipper) this.l.findViewById(R$id.header_project_right_view_flipper);
            findViewById3.setVisibility(8);
            List<ProjectRatingUserBean> list = projectRatingBean.userRatingVOS;
            if (list != null && list.size() > 0) {
                this.m.removeAllViews();
                findViewById3.setVisibility(0);
                findViewById3.setOnClickListener(new b(projectRatingBean));
                for (int i3 = 0; i3 < projectRatingBean.userRatingVOS.size(); i3++) {
                    View inflate = this.a.getLayoutInflater().inflate(R$layout.header_project_socre_right_flipper_item, (ViewGroup) null);
                    ProjectRatingUserBean projectRatingUserBean = projectRatingBean.userRatingVOS.get(i3);
                    TextView textView3 = (TextView) inflate.findViewById(R$id.tv_people_comment);
                    if (!TextUtils.isEmpty(projectRatingUserBean.content)) {
                        textView3.setVisibility(0);
                        textView3.setText(projectRatingUserBean.content);
                    }
                    ImageView imageView = (ImageView) inflate.findViewById(R$id.user_icon_iv);
                    int i4 = R$drawable.uikit_user_default_icon_trans_white;
                    imageView.setImageResource(i4);
                    if (!TextUtils.isEmpty(projectRatingUserBean.userImg)) {
                        imageView.setVisibility(0);
                        cn.damai.common.image.a.b().h(this.a).f(projectRatingUserBean.userImg, n42.a(this.a, 30.0f), n42.a(this.a, 30.0f)).i(i4).c(i4).k(new cq()).g(imageView);
                    }
                    TextView textView4 = (TextView) inflate.findViewById(R$id.tv_user_name);
                    if (!TextUtils.isEmpty(projectRatingUserBean.userNick)) {
                        textView4.setText(projectRatingUserBean.userNick);
                        textView4.setVisibility(0);
                    }
                    ((DMRatingBar) inflate.findViewById(R$id.user_scoreStar_view)).setVisibility(8);
                    this.m.addView(inflate);
                }
                if (projectRatingBean.userRatingVOS.size() > 1) {
                    this.m.setFlipInterval(3000);
                    this.m.startFlipping();
                }
            }
            View findViewById4 = this.l.findViewById(R$id.header_project_right_view_flipper);
            List<ProjectRatingUserBean> list2 = projectRatingBean.userRatingVOS;
            if (list2 == null || list2.size() == 0) {
                findViewById4.setVisibility(8);
            } else {
                findViewById4.setVisibility(0);
            }
            findViewById4.setOnClickListener(new c(projectRatingBean));
            View findViewById5 = this.l.findViewById(R$id.view_line);
            View findViewById6 = this.l.findViewById(R$id.view_bottom);
            RecyclerView recyclerView = (RecyclerView) this.l.findViewById(R$id.tag_layout);
            List<ProjectRatingContentLabelBean> list3 = projectRatingBean.contentLabelDOS;
            if (list3 == null || list3.size() <= 0) {
                if (findViewById5 != null) {
                    findViewById5.setVisibility(8);
                }
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
            } else {
                HeaderScoreTagAdapter headerScoreTagAdapter = new HeaderScoreTagAdapter(this.a, projectRatingBean.contentLabelDOS, this.b, this.d);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(linearLayoutManager);
                linearLayoutManager.setOrientation(0);
                recyclerView.setAdapter(headerScoreTagAdapter);
            }
            View findViewById7 = this.l.findViewById(R$id.score_bottom_ui);
            View findViewById8 = this.l.findViewById(R$id.score_bottom_wanna_see_ui);
            if (projectDetailDataBean == null || (projectDynamicExtDataBean = projectDetailDataBean.dynamicExtData) == null || (projectWantSeeBean = projectDynamicExtDataBean.wantVO) == null || projectWantSeeBean.getWantNum() <= 0) {
                z2 = false;
            } else {
                x(projectWantSeeBean);
                z2 = true;
            }
            findViewById8.setVisibility(z2 ? 0 : 8);
            boolean z4 = recyclerView.getVisibility() == 0;
            if (!z2 && !z4) {
                z3 = false;
            }
            findViewById7.setVisibility(z3 ? 0 : 8);
            ((TextView) this.l.findViewById(R$id.tv_score_extra_tip)).setText(projectRatingBean.ratingSource);
            if (findViewById6 != null) {
                if (z3) {
                    i2 = 8;
                }
                findViewById6.setVisibility(i2);
            }
        }
    }

    private void m(ProjectStaticItemBaseBean projectStaticItemBaseBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70704105")) {
            ipChange.ipc$dispatch("-70704105", new Object[]{this, projectStaticItemBaseBean});
            return;
        }
        int i2 = 8;
        if (projectStaticItemBaseBean == null) {
            this.i.setVisibility(8);
            return;
        }
        boolean isHasSkuPopup = projectStaticItemBaseBean.isHasSkuPopup();
        View findViewById = this.i.findViewById(R$id.show_time_arrow);
        TextView textView = (TextView) this.i.findViewById(R$id.project_detail_perform_time_tv);
        TextView textView2 = (TextView) this.i.findViewById(R$id.project_detail_perform_duration_tv);
        if (isHasSkuPopup) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        textView.setText(projectStaticItemBaseBean.getShowTime());
        textView2.setText(projectStaticItemBaseBean.getShowDuration());
        this.i.setOnClickListener(isHasSkuPopup ? this : null);
        this.i.setVisibility(0);
        ln2.r().J1(this.i, String.valueOf(this.b));
    }

    private void n(ProjectStaticDataBean projectStaticDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1563059249")) {
            ipChange.ipc$dispatch("-1563059249", new Object[]{this, projectStaticDataBean});
        } else if (projectStaticDataBean != null) {
            List<ProjectTour> list = projectStaticDataBean.tourProjects;
            if (xf2.e(list) <= 1) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(0);
            new wu1(this.a, this.h).a(this.a, list, this.b);
        }
    }

    private void p(ProjectDetailDataBean projectDetailDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-971545846")) {
            ipChange.ipc$dispatch("-971545846", new Object[]{this, projectDetailDataBean});
        } else if (projectDetailDataBean != null) {
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.clear();
            this.I.addAll(gb.g(projectDetailDataBean.getDynamicExtData()));
            int e2 = xf2.e(this.I);
            if (e2 <= 0) {
                this.g.setVisibility(8);
                this.C = false;
                y(this.y);
                return;
            }
            this.g.setVisibility(0);
            y(0);
            this.C = true;
            ProjectPicAndVideoAdapter projectPicAndVideoAdapter = this.E;
            if (projectPicAndVideoAdapter == null) {
                ProjectPicAndVideoAdapter projectPicAndVideoAdapter2 = new ProjectPicAndVideoAdapter(this.a, this.I, this.d);
                this.E = projectPicAndVideoAdapter2;
                this.D.setAdapter(projectPicAndVideoAdapter2);
                this.D.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectHeaderPanel.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-111611070")) {
                            ipChange.ipc$dispatch("-111611070", new Object[]{this, Integer.valueOf(i)});
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i, float f, int i2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1689263647")) {
                            ipChange.ipc$dispatch("-1689263647", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1790024973")) {
                            ipChange.ipc$dispatch("1790024973", new Object[]{this, Integer.valueOf(i)});
                            return;
                        }
                        TextView textView = ProjectHeaderPanel.this.F;
                        textView.setText((i + 1) + "/" + xf2.e(ProjectHeaderPanel.this.I));
                        if (((ProjectPicAndVideo) ProjectHeaderPanel.this.I.get(i)).videoInfo != null) {
                            ProjectHeaderPanel.this.H.setVisibility(0);
                        } else {
                            ProjectHeaderPanel.this.H.setVisibility(8);
                        }
                    }
                });
            } else {
                projectPicAndVideoAdapter.notifyDataSetChanged();
            }
            TextView textView = this.F;
            textView.setText("1/" + e2);
            if (this.I.get(0).videoInfo != null) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
            }
            if (e2 > 1) {
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
            this.D.setCurrentItem(0);
        }
    }

    private void q(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996836148")) {
            ipChange.ipc$dispatch("-996836148", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        View findViewById = this.o.findViewById(R$id.wanna_see_btn);
        TextView textView = (TextView) findViewById.findViewById(R$id.wanna_see_tag_2);
        TextView textView2 = (TextView) findViewById.findViewById(R$id.wanna_see_text);
        findViewById.setSelected(z2);
        if (z2) {
            textView2.setText("已想看");
            textView.setText(R$string.iconfont_xiangkanmian_);
        } else {
            textView2.setText("想看");
            textView.setText(R$string.iconfont_xiangkan24);
        }
        findViewById.setOnClickListener(this);
    }

    private void r(ProjectDetailDataBean projectDetailDataBean) {
        ProjectDynamicExtDataBean dynamicExtData;
        ProjectWantSeeBean projectWantSeeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514643553")) {
            ipChange.ipc$dispatch("1514643553", new Object[]{this, projectDetailDataBean});
        } else if (projectDetailDataBean != null && (dynamicExtData = projectDetailDataBean.getDynamicExtData()) != null && (projectWantSeeBean = dynamicExtData.wantVO) != null && projectWantSeeBean.isShowWant() && !TextUtils.isEmpty(projectWantSeeBean.getWantNumStr())) {
            this.o.setVisibility(0);
            this.v = true;
            ln2.r().m2(this.o, String.valueOf(this.b), projectWantSeeBean.getWantNum());
            TextView textView = (TextView) this.o.findViewById(R$id.want_see_desc_tv);
            CharSequence a2 = gb.a(projectWantSeeBean.getWantDesc());
            if (TextUtils.isEmpty(a2) || a2.charAt(0) != 20154) {
                textView.setTextColor(-16777216);
            } else {
                textView.setTextColor(Color.parseColor("#999999"));
            }
            textView.setText(a2);
            DMDigitTextView dMDigitTextView = (DMDigitTextView) this.o.findViewById(R$id.want_see_number_dtv);
            Pair<String, String> wantNumPair = projectWantSeeBean.getWantNumPair();
            if (this.B) {
                WantSeeHelper.e(dMDigitTextView, wantNumPair.first);
            } else {
                dMDigitTextView.setText(wantNumPair.first);
            }
            ((DMDigitTextView) this.o.findViewById(R$id.want_see_number_suffix_dtv)).setText(wantNumPair.second);
            ((AvatarRecyclerView) this.o.findViewById(R$id.want_see_avatar_view)).getAdapter().e(gb.o(projectWantSeeBean.getUserImgs(), 3));
            q(dynamicExtData.isSubFlag());
        }
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496260203")) {
            ipChange.ipc$dispatch("-496260203", new Object[]{this});
            return;
        }
        this.F = (TextView) this.g.findViewById(R$id.content_detail_banner_count);
        this.G = (LinearLayout) this.g.findViewById(R$id.ll_banner_count);
        this.H = (ImageView) this.g.findViewById(R$id.discover_video_icon);
        DmViewPager dmViewPager = (DmViewPager) this.g.findViewById(R$id.content_detail_banner);
        this.D = dmViewPager;
        dmViewPager.setOffscreenPageLimit(1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v(ProjectRatingBean projectRatingBean) {
        ViewFlipper viewFlipper;
        int displayedChild;
        ProjectRatingUserBean projectRatingUserBean;
        OnHeadClickListener onHeadClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599958293")) {
            ipChange.ipc$dispatch("1599958293", new Object[]{this, projectRatingBean});
        } else if (projectRatingBean != null && !f92.d(projectRatingBean.userRatingVOS) && (viewFlipper = this.m) != null && (projectRatingUserBean = projectRatingBean.userRatingVOS.get((displayedChild = viewFlipper.getDisplayedChild()))) != null && (onHeadClickListener = this.d) != null) {
            onHeadClickListener.onScoreCommentClick(projectRatingUserBean.content, projectRatingUserBean.userId, projectRatingUserBean.contentId);
            cn.damai.common.user.c.e().x(ln2.r().V0(Long.toString(this.b), displayedChild));
        }
    }

    private void x(ProjectWantSeeBean projectWantSeeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207505376")) {
            ipChange.ipc$dispatch("1207505376", new Object[]{this, projectWantSeeBean});
            return;
        }
        TextView textView = (TextView) this.l.findViewById(R$id.score_bottom_wanna_see_count);
        if (projectWantSeeBean == null || projectWantSeeBean.getWantNum() <= 0) {
            textView.setText("");
            return;
        }
        Pair<String, String> wantNumPair = projectWantSeeBean.getWantNumPair();
        textView.setText(((String) wantNumPair.first) + ((String) wantNumPair.second) + "想看");
    }

    private void y(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570904542")) {
            ipChange.ipc$dispatch("1570904542", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        View view = this.c;
        view.setPadding(view.getPaddingLeft(), this.z + i2, this.c.getPaddingRight(), this.c.getPaddingBottom());
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494077729")) {
            ipChange.ipc$dispatch("-494077729", new Object[]{this});
            return;
        }
        Activity activity = this.a;
        if (activity != null && !activity.isFinishing()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.height = n42.a(this.a, 178.0f) + this.A;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public void A(boolean z2, ProjectWantSeeBean projectWantSeeBean) {
        View view;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "1814766409")) {
            ipChange.ipc$dispatch("1814766409", new Object[]{this, Boolean.valueOf(z2), projectWantSeeBean});
        } else if (projectWantSeeBean != null && this.o != null) {
            if (this.u && (view = this.l) != null && view.findViewById(R$id.score_bottom_wanna_see_ui).getVisibility() == 0) {
                x(projectWantSeeBean);
            }
            if (WantSeeHelper.b().c(projectWantSeeBean)) {
                Pair<String, String> wantNumPair = projectWantSeeBean.getWantNumPair();
                ((DMDigitTextView) this.o.findViewById(R$id.want_see_number_dtv)).setText(wantNumPair.first);
                ((DMDigitTextView) this.o.findViewById(R$id.want_see_number_suffix_dtv)).setText(wantNumPair.second);
                AvatarRecyclerView avatarRecyclerView = (AvatarRecyclerView) this.o.findViewById(R$id.want_see_avatar_view);
                if (!(UserInfoUtil.a() == null || UserInfoUtil.a().getUserBaseInfo() == null)) {
                    String headImg = UserInfoUtil.a().getUserBaseInfo().getHeadImg();
                    try {
                        AvatarRecyclerView.AvatarAdapter adapter = avatarRecyclerView.getAdapter();
                        if (z2) {
                            if (adapter.getItemCount() < 3) {
                                z3 = false;
                            }
                            adapter.a(new AvatarRecyclerView.b(headImg), z3);
                        } else {
                            adapter.d(new AvatarRecyclerView.b(headImg));
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                q(z2);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-975434792")) {
            return R$id.project_header;
        }
        return ((Integer) ipChange.ipc$dispatch("-975434792", new Object[]{this})).intValue();
    }

    public void o(ProjectDetailDataBean projectDetailDataBean, RankInfo rankInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007151575")) {
            ipChange.ipc$dispatch("-1007151575", new Object[]{this, projectDetailDataBean, rankInfo});
        } else if (projectDetailDataBean != null) {
            ProjectStaticDataBean staticData = projectDetailDataBean.getStaticData();
            ProjectItemDataBean item = projectDetailDataBean.getItem();
            ProjectStaticItemBaseBean c2 = gb.c(staticData);
            p(projectDetailDataBean);
            j(projectDetailDataBean);
            this.q.f(projectDetailDataBean, this.C);
            n(staticData);
            this.s.d(item, staticData);
            m(c2);
            this.r.d(staticData, c2);
            ProjectRatingBean projectRatingBean = null;
            if (staticData != null) {
                projectRatingBean = staticData.rating;
            }
            l(projectRatingBean, projectDetailDataBean);
            i(item);
            r(projectDetailDataBean);
            if (rankInfo == null && staticData != null) {
                rankInfo = staticData.getRankListVO();
            }
            k(rankInfo);
            if (projectDetailDataBean.getDynamicExtData() == null || projectDetailDataBean.getDynamicExtData().topicHotComment == null) {
                ((View) this.t.getParent()).setVisibility(8);
                return;
            }
            ((View) this.t.getParent()).setVisibility(0);
            this.t.bindData(projectDetailDataBean.getDynamicExtData().topicHotComment);
            DMHotDiscussView dMHotDiscussView = this.t;
            dMHotDiscussView.setItemId(this.b + "");
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731954237")) {
            ipChange.ipc$dispatch("-731954237", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == this.e.getId()) {
            this.d.onNoticeClick();
        } else if (id == this.i.getId()) {
            this.d.onShowTimeClick();
        } else if (id == this.k.getId()) {
            this.d.onRankListClick();
        } else if (id == this.n.getId()) {
            this.d.onMarketStallClick();
        } else if (id == R$id.wanna_see_btn) {
            this.d.onWannaSeeActionClick();
        }
    }

    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443405410")) {
            ipChange.ipc$dispatch("443405410", new Object[]{this});
            return;
        }
        this.n.setVisibility(8);
    }

    public void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1991085347")) {
            ipChange.ipc$dispatch("1991085347", new Object[]{this});
            return;
        }
        b bVar = this.q;
        if (bVar != null) {
            bVar.k();
        }
        ViewFlipper viewFlipper = this.e;
        if (viewFlipper != null) {
            viewFlipper.stopFlipping();
        }
    }

    public void w(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495652227")) {
            ipChange.ipc$dispatch("495652227", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        this.B = z2;
    }
}

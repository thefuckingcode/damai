package cn.damai.tetris.component.discover.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.view.UserAvatarOverlayListLayout;
import cn.damai.discover.main.ui.adapter.CircleRankPanel;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.discover.main.ui.view.DMThemeProjectItemView;
import cn.damai.tetris.component.discover.mvp.CircleHeadContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.NewSimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class CircleHeadView extends AbsView<CircleHeadContract.Presenter> implements CircleHeadContract.View<CircleHeadContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    ImageView bgImage;
    RoundRadiusImageView circleHeadImage;
    DMIconFontTextView joinIcon;
    private ImageView mBannerImg;
    private View mBannerUi;
    private Context mContext;
    DMThemeProjectItemView mProjectRevUi;
    CircleRankPanel mRankPanel;
    ViewStub mRankStub;
    TextView themeDesc;
    TextView themeJoinBtn;
    TextView themeJoinNum;
    TextView themeName;
    NewSimpleTitleLayout titleLayout;
    UserAvatarOverlayListLayout userOverlay;

    /* compiled from: Taobao */
    public class a implements DMUpMarqueeView.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView.OnItemClickListener
        public void onItemClick(int i, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-880786173")) {
                ipChange.ipc$dispatch("-880786173", new Object[]{this, Integer.valueOf(i), view});
                return;
            }
            ((CircleHeadContract.Presenter) CircleHeadView.this.getPresenter()).clickPoj((ProjectItemBean) view.getTag(), i);
        }
    }

    /* compiled from: Taobao */
    public class b implements DMThemeProjectItemView.ProjectLabelClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.discover.main.ui.view.DMThemeProjectItemView.ProjectLabelClickListener
        public void onClick(int i, ProjectItemBean projectItemBean, List<ProjectItemBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1478085908")) {
                ipChange.ipc$dispatch("1478085908", new Object[]{this, Integer.valueOf(i), projectItemBean, list});
            } else if (1 == i) {
                ((CircleHeadContract.Presenter) CircleHeadView.this.getPresenter()).clickPoj(projectItemBean, i);
            } else {
                ((CircleHeadContract.Presenter) CircleHeadView.this.getPresenter()).clickPojMore((ArrayList) list);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMThemeProjectItemView.ExposureCallBack {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.discover.main.ui.view.DMThemeProjectItemView.ExposureCallBack
        public void exposure(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-780703444")) {
                ipChange.ipc$dispatch("-780703444", new Object[]{this, view, Integer.valueOf(i)});
                return;
            }
            ((CircleHeadContract.Presenter) CircleHeadView.this.getPresenter()).exposePoj(view, (ProjectItemBean) view.getTag(), i);
        }
    }

    /* compiled from: Taobao */
    public class d implements OnItemBindListener<RankUserBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        /* renamed from: a */
        public void exposeItem(View view, RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1396224574")) {
                ipChange.ipc$dispatch("1396224574", new Object[]{this, view, rankUserBean, Integer.valueOf(i)});
                return;
            }
            ((CircleHeadContract.Presenter) CircleHeadView.this.getPresenter()).exposeVote(view, i);
        }

        /* renamed from: b */
        public void onItemClick(RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1144802089")) {
                ipChange.ipc$dispatch("1144802089", new Object[]{this, rankUserBean, Integer.valueOf(i)});
                return;
            }
            ((CircleHeadContract.Presenter) CircleHeadView.this.getPresenter()).clickVote(rankUserBean, i);
        }
    }

    public CircleHeadView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.titleLayout = (NewSimpleTitleLayout) view.findViewById(R$id.theme_circle_title_cms_bar);
        this.bgImage = (ImageView) view.findViewById(R$id.theme_circle_bg_image);
        this.circleHeadImage = (RoundRadiusImageView) view.findViewById(R$id.iv_circle_head);
        this.themeName = (TextView) view.findViewById(R$id.theme_circle_name);
        this.userOverlay = (UserAvatarOverlayListLayout) view.findViewById(R$id.circle_avatar_list_layout);
        this.themeJoinNum = (TextView) view.findViewById(R$id.theme_circle_person_info);
        this.themeDesc = (TextView) view.findViewById(R$id.theme_circle_desc_v2);
        this.themeJoinBtn = (TextView) view.findViewById(R$id.theme_circle_join);
        this.joinIcon = (DMIconFontTextView) view.findViewById(R$id.theme_circle_join_icon);
        DMThemeProjectItemView dMThemeProjectItemView = (DMThemeProjectItemView) view.findViewById(R$id.theme_project_ui);
        this.mProjectRevUi = dMThemeProjectItemView;
        dMThemeProjectItemView.setProjectOnClick(new a());
        this.mProjectRevUi.setProjectLabelOnClick(new b());
        this.mProjectRevUi.setExposureCallBack(new c());
        ViewStub viewStub = (ViewStub) view.findViewById(R$id.theme_rank_view_stub);
        this.mRankStub = viewStub;
        this.mRankPanel = new CircleRankPanel(this.mContext, viewStub, new d());
        this.mBannerUi = view.findViewById(R$id.theme_image_ui);
        this.mBannerImg = (ImageView) view.findViewById(R$id.theme_banner_img);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public ImageView getBannerImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-370242082")) {
            return this.mBannerImg;
        }
        return (ImageView) ipChange.ipc$dispatch("-370242082", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public View getBannerUi() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1326431555")) {
            return this.mBannerUi;
        }
        return (View) ipChange.ipc$dispatch("1326431555", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public ImageView getBgImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1064960893")) {
            return this.bgImage;
        }
        return (ImageView) ipChange.ipc$dispatch("1064960893", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public RoundRadiusImageView getCircleHeadImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-114485699")) {
            return this.circleHeadImage;
        }
        return (RoundRadiusImageView) ipChange.ipc$dispatch("-114485699", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public DMIconFontTextView getJoinIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "960722629")) {
            return this.joinIcon;
        }
        return (DMIconFontTextView) ipChange.ipc$dispatch("960722629", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public DMThemeProjectItemView getProjectUi() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "691629378")) {
            return this.mProjectRevUi;
        }
        return (DMThemeProjectItemView) ipChange.ipc$dispatch("691629378", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public ViewStub getRankStub() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1899191461")) {
            return this.mRankStub;
        }
        return (ViewStub) ipChange.ipc$dispatch("-1899191461", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public CircleRankPanel getRankView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-661569079")) {
            return this.mRankPanel;
        }
        return (CircleRankPanel) ipChange.ipc$dispatch("-661569079", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-887737469")) {
            return this.themeDesc;
        }
        return (TextView) ipChange.ipc$dispatch("-887737469", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeJoinBtn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-459736788")) {
            return this.themeJoinBtn;
        }
        return (TextView) ipChange.ipc$dispatch("-459736788", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeJoinNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "623894978")) {
            return this.themeJoinNum;
        }
        return (TextView) ipChange.ipc$dispatch("623894978", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2093085879")) {
            return this.themeName;
        }
        return (TextView) ipChange.ipc$dispatch("-2093085879", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public NewSimpleTitleLayout getTitleLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-524515412")) {
            return this.titleLayout;
        }
        return (NewSimpleTitleLayout) ipChange.ipc$dispatch("-524515412", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public UserAvatarOverlayListLayout getUserOverlay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-689160658")) {
            return this.userOverlay;
        }
        return (UserAvatarOverlayListLayout) ipChange.ipc$dispatch("-689160658", new Object[]{this});
    }
}

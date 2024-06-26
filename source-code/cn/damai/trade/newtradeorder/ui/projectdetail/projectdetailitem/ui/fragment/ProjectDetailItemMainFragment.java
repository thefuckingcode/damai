package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.bean.FocusEvent;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.commonbusiness.coupondialog.CouponDialogHelper;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.notice.NoticeDetailFragment;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.notice.bean.NoticeListBean;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionGroupBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.ItemBuyBtnBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuActivity;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.commonbusiness.servicenotice.ProjectSupportServiceFragment;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.skeleton.SkeletonScreen;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.h5container.CaptureActivity;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeeGuideTips;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.trade.R$anim;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$raw;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnEvaluateMineListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.anchor.AnchorManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.MarketingStallBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectFreeTicketBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticExtendInfoBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionItemBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnCommonProblemsListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnDiscussionClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.ProjectDialogShowListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.ProjectItemDetailAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.AnchorIndicatorView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectHeaderPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.SplitImageSizeCache;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.PrivilegeCodeVerifyFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView;
import cn.damai.trade.newtradeorder.ui.projectdetail.util.ProjectIntentExtraParser;
import cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.xflush.ProjectDetailXFlushUtil;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.uikit.view.SeeAnimateView;
import cn.damai.wantsee.GuideUtProvider;
import cn.damai.wantsee.StartConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.badge.BadgeDrawable;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import com.real.android.nativehtml.android.HtmlView;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.a5;
import tb.br;
import tb.cr;
import tb.cy2;
import tb.d20;
import tb.el2;
import tb.ep1;
import tb.f92;
import tb.fu1;
import tb.g70;
import tb.gb;
import tb.gr;
import tb.gu1;
import tb.hp1;
import tb.hu1;
import tb.jl1;
import tb.jy2;
import tb.l8;
import tb.ln2;
import tb.lp1;
import tb.lz1;
import tb.mi1;
import tb.n42;
import tb.n72;
import tb.ne2;
import tb.ni1;
import tb.oz0;
import tb.p42;
import tb.pt1;
import tb.qt1;
import tb.rb2;
import tb.rt1;
import tb.s71;
import tb.s72;
import tb.st0;
import tb.st1;
import tb.ta;
import tb.tt1;
import tb.vv2;
import tb.wj1;
import tb.wt1;
import tb.xf2;
import tb.xl2;
import tb.xs0;

/* compiled from: Taobao */
public class ProjectDetailItemMainFragment extends DamaiBaseMvpFragment<ProjectItemPresenter, ProjectItemContract.Model> implements ProjectItemContract.View, PullToRefreshView.OnRefreshListener, AnchorIndicatorView.OnAnchorItemClickListener, PrivilegeCodeVerifyFragment.OnPrivilegeCodeVerifyResultListener, OnCompleteListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRAND_STATE_CHANGED = "brand_state_changed";
    private static final int MAX_NUM_RECOMMEND = 10;
    private static final int MSG_REMOVE_BUY_RIGHT_NOW_FRAGMENT = 103;
    private static final int MSG_REMOVE_PERFORM_LIST_FRAGMENT = 102;
    public static final int TIME_INTERVAL_ADD_CALENDAR = 10;
    private static final int TYPE_BUY_AFTER_COUNT_DOWN = 4;
    private static final int TYPE_BUY_CHOOSE_SEAT = 2;
    private static final int TYPE_BUY_RIGHT_NOW = 1;
    private static final int TYPE_BUY_SALE_REMIND = 3;
    private static final int TYPE_BUY_UN_CLICKABLE = -1;
    private static final HashMap<Long, Integer> projectEnterCountMap = new HashMap<>();
    private Action action;
    private String atomSplit;
    private CalendarsResolver.RemindMeListener calendRemindMeListener = new h0();
    NoticeDetailFragment detailFragment;
    ProjectDialogShowListener dialogShowListener = new u0();
    private List<View> exposureViewList = new ArrayList();
    ScreenShotDetector.IScreenShotExtraListener extraListener = new v0();
    private View footer;
    private ViewGroup.LayoutParams footerParam;
    View header;
    private boolean isFixedAnchorVisible;
    private boolean isFlowByBottomBar;
    private boolean isShowAnchor;
    private boolean isShowFixAnchorIndicator;
    private String mAliMeFrom = "";
    private AnchorIndicatorView mAnchorIndicator;
    private AnchorIndicatorView mAnchorIndicatorFixed;
    private AnchorManager mAnchorManager;
    private int mBackType;
    private View mBottomLineView;
    public String mButtomText = "";
    private String mClickedProblem;
    private FrameLayout mContentRootLayout;
    private int mCurAnchorPosition;
    private int mDefaultRVMarginBottom;
    private ProjectDialogHelper mDialogPanel;
    private FrameLayout mFlMoreRecommendFloatLayer;
    private FrameLayout mFlNotExistPageContainer;
    private FrameLayout mFlProjectContentContainer;
    private FrameLayout mFlPurchaseStatusBarContainer;
    private FrameLayout mFlvPopupLayer;
    private GuideUtProvider mGuideUtProvider = new j0();
    private Handler mHandler;
    private boolean mHasClosedMoreRecommend;
    private boolean mHasCountDownFinished;
    private boolean mHasDisplayedLimitedDialog;
    private boolean mHasRegisterRedPacketMsg;
    private View mHeadDividerLine;
    private ProjectHeaderPanel mHeadPanel;
    private boolean mIsFirstEnter;
    private boolean mIsFromPush;
    private boolean mIsLoading;
    private boolean mIsScrolled;
    private ImageView mIvCloseMoreRecommend;
    private ImageView mIvProjectPosterMask;
    private WrapLinearLayoutManager mLinearLayoutManager;
    private PullToRefreshView mLinearPullToRefreshView;
    private View mLvBottomBar;
    private FrameLayout mLvCustomerService;
    private LinearLayout mLvProjectDetailHeader;
    private int mMaskColor;
    private OnTimeCountDownListener mMemberPromptOnTimeCountDownListener;
    private ITimeCountDownManager mMemberPromptTimeCountDownManager;
    private OnTimeCountDownListener mMemberSpecilBuyTimeCountDownListener;
    private mi1 mNewSkuData;
    private ni1 mNewSkuDataManager;
    private View.OnClickListener mOnCloseMoreRecommendClickListener;
    private OnDiscussionClickListener mOnDiscussionClickListener;
    private OnEvaluateMineListener mOnEvaluateMineListener;
    private OnItemExtendInfoItemClickListener mOnExtendInfoImageItemClickListener;
    private View.OnClickListener mOnMoreRecommendClickListener;
    private View.OnClickListener mOnPerformInfoClickListener;
    private View.OnClickListener mOnPerformSeatImgIconClickListener;
    private OnCommonProblemsListener mOnProjectCommonProblemListener;
    private View.OnClickListener mOnProjectFollowClickListener;
    private View.OnClickListener mOnProjectPosterClickListener;
    private View.OnClickListener mOnPromotionDetailClickListener;
    private OnRecommendItemClickListener mOnRecommendItemClickListener;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1067239650")) {
                ipChange.ipc$dispatch("1067239650", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            if (i == 0) {
                z = false;
            }
            projectDetailItemMainFragment.mIsScrolled = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-298432259")) {
                ipChange.ipc$dispatch("-298432259", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            ProjectDetailItemMainFragment.this.updateTitleBarStyle();
            if (ProjectDetailItemMainFragment.this.mIsScrolled) {
                if (i2 <= 0) {
                    z = false;
                }
                ProjectDetailItemMainFragment.this.updateTitleBgAndAnchorIndicator();
                ProjectDetailItemMainFragment.this.fixAnchorSelection(z);
            }
        }
    };
    private OnSectionMoreClickListener mOnSectionMoreClickListener;
    private OnTimeCountDownListener mOnTimeCountDownListener;
    private st0 mPerformDataConfigure;
    private ep1 mPerformDataManager;
    private Fragment mPopLayerFragment;
    private PrivilegeCodeVerifyFragment mPrivilegeCodeVerifyFragment;
    private String mPrivilegeId;
    private pt1 mProjectDataHolderManager;
    public ProjectDetailActivity mProjectDetailActivity;
    private ProjectDetailDataBean mProjectDetailDataBean;
    private ProjectDetailCommentBean mProjectDetailDiscussionBean;
    private ProjectDetailCommentBean mProjectDetailEvaluateBean;
    private ProjectDynamicExtDataBean mProjectDynamicExtDataBean;
    private ProjectIntentExtraParser.ProjectDetailExtrasData mProjectExtraData;
    public long mProjectId;
    private ProjectItemDataBean mProjectItemDataBean;
    private ProjectItemDetailAdapter mProjectItemDetailAdapter;
    private ProjectItemStatusHelper mProjectItemStatusHelper;
    private ProjectStaticDataBean mProjectStaticDataBean;
    private int mPurchaseType;
    private RankInfo mRankInfo;
    private List<ProjectRecommendBean> mRecommendItems;
    private DamaiRootRecyclerView mRecyclerView;
    private lz1 mRegionManager;
    private RelativeLayout mRvProjectDetailContent;
    private View mRvPromptFloatingLayerView;
    private SeatPreloadExtra mSeatPreloadExtra;
    ShareManagerImpl mShareManagerImpl = new q0();
    private String mSinaSharePath = "";
    private int mSingleStagoryMargin;
    SkuBean mSkuBean;
    private ITimeCountDownManager mTimeCountDownManager;
    private int mTimerRVMarginBottom;
    private ProjectTitleBarPanel mTitleBarPanel;
    private TextView mTvProjectFollowText;
    private TextView mTvPromptContent;
    private SeeAnimateView mViewProjectFollow;
    private long mWantSeeNum = 0;
    private FrameLayout mWantTipsContainer;
    PopupWindow popupWindow;
    private SkeletonScreen skeletonScreen;
    private ProjectSpecialBuyPromptView specialBuyPromptView;
    private ProjectTimerAndStagoryView timerAndStagoryView;
    private ProjectTimerAndStrategyTmPromptView timerAndStrategyTmPromptView;
    private int titleBar2DarkHeight = n42.a(xs0.a(), 18.0f);
    private vv2 viewCreater;
    private WantSeeGuideTips wantSeeGuideTips;
    private CountDownTimer wantSeeGuideTipsTimer;
    private WantSeePosterTips wantSeePosterTips;
    private WantSeeTips wantSeeTips;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-360766002")) {
                ipChange.ipc$dispatch("-360766002", new Object[]{this, view});
                return;
            }
            ArrayList posterPicInfoList = ProjectDetailItemMainFragment.this.getPosterPicInfoList();
            if (posterPicInfoList != null && !posterPicInfoList.isEmpty()) {
                cn.damai.common.user.c.e().x(ln2.r().D0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tt1.l(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, posterPicInfoList, 0);
            }
        }
    }

    /* compiled from: Taobao */
    public class a0 implements NcovPromotionFragment.OnConfirmClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a0() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.OnConfirmClickListener
        public void onCloseClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-202474671")) {
                ipChange.ipc$dispatch("-202474671", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    public class a1 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a1() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-98581155")) {
                ipChange.ipc$dispatch("-98581155", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasClosedMoreRecommend = true;
            ProjectDetailItemMainFragment.this.mFlMoreRecommendFloatLayer.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1750524367")) {
                ipChange.ipc$dispatch("1750524367", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                cn.damai.common.user.c.e().x(ln2.r().B0(ProjectDetailItemMainFragment.this.mProjectId));
                List<String> itemPromotionTag = ProjectDetailItemMainFragment.this.mProjectItemDataBean.getItemPromotionTag();
                if (ProjectDetailItemMainFragment.this.mProjectItemDataBean.promotionList != null && !f92.d(ProjectDetailItemMainFragment.this.mProjectItemDataBean.promotionList)) {
                    Iterator<PromotionItemBean> it = ProjectDetailItemMainFragment.this.mProjectItemDataBean.promotionList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().hasCoupon()) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (ProjectDetailItemMainFragment.this.isLogin() || !z) {
                        ProjectDetailItemMainFragment.this.showCouponPromotionFragment();
                    } else {
                        ProjectDetailItemMainFragment.this.startLoginActivityForResult(4098);
                    }
                } else if (itemPromotionTag != null && !itemPromotionTag.isEmpty()) {
                    ProjectDetailItemMainFragment.this.showCouponPromotionFragment();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b0() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1473058322")) {
                ipChange.ipc$dispatch("1473058322", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    public class b1 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b1() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2012709214")) {
                ipChange.ipc$dispatch("2012709214", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.hasRecommendProject()) {
                cn.damai.common.user.c.e().x(ln2.r().y0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.mHasClosedMoreRecommend = true;
                ProjectDetailItemMainFragment.this.mFlMoreRecommendFloatLayer.setVisibility(8);
                ProjectDetailItemMainFragment.this.scrollToRecommend();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ProjectTimerAndStrategyTmPromptView.ProjectPromptListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView.ProjectPromptListener
        public void onVipRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-621244158")) {
                ipChange.ipc$dispatch("-621244158", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.onRefresh();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView.ProjectPromptListener
        public void showVIPCreditExchange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1474614513")) {
                ipChange.ipc$dispatch("-1474614513", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.showVIPCreditExchangeFragment();
        }
    }

    /* compiled from: Taobao */
    public class c0 implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c0() {
        }

        @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "426091625")) {
                ipChange.ipc$dispatch("426091625", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (ProjectDetailItemMainFragment.this.mNewSkuData != null) {
                ProjectDetailItemMainFragment.this.mNewSkuData.a = i;
            }
            ProjectDetailItemMainFragment.this.mIvProjectPosterMask.setBackgroundColor(i);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1678137809")) {
                ipChange.ipc$dispatch("1678137809", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.processCalendarRemind();
        }
    }

    /* compiled from: Taobao */
    public class d0 implements AliMeUtil.OnAliMeTokenListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d0() {
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-175530821")) {
                ipChange.ipc$dispatch("-175530821", new Object[]{this, str, str2});
                return;
            }
            ProjectDetailItemMainFragment.this.stopProgressDialog();
            AliMeUtil.p(str, str2);
            ProjectDetailItemMainFragment.this.resetAliMeClickData();
            ProjectDetailXFlushUtil.i(String.valueOf(ProjectDetailItemMainFragment.this.mProjectId), str, str);
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-93936531")) {
                ipChange.ipc$dispatch("-93936531", new Object[]{this, str});
                return;
            }
            ProjectDetailItemMainFragment.this.stopProgressDialog();
            if (!xf2.j(str)) {
                ProjectDetailItemMainFragment.this.launchAliMe(str);
                return;
            }
            AliMeUtil.o();
            ProjectDetailItemMainFragment.this.resetAliMeClickData();
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-505539118")) {
                ipChange.ipc$dispatch("-505539118", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.timerAndStagoryView.hideResetAttendees();
            ProjectDetailItemMainFragment.this.strategyClick();
        }
    }

    /* compiled from: Taobao */
    public class e0 implements ProjectItemStatusHelper.OnBottomViewClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onBuyRightNow(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1452566846")) {
                ipChange.ipc$dispatch("1452566846", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment.this.showPerformListFragment(false);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onNeedPrivilege(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "908644025")) {
                ipChange.ipc$dispatch("908644025", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.mSkuBean = null;
            projectDetailItemMainFragment.showPrivilegeCodeVerifyFragment(i);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onRegister(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-93089279")) {
                ipChange.ipc$dispatch("-93089279", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment.this.showPerformListFragment(false);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onSelectSeat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1248072196")) {
                ipChange.ipc$dispatch("1248072196", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.handleChooseSeatPage();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onSoldOut() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "68748811")) {
                ipChange.ipc$dispatch("68748811", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.showPerformListFragment(false);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onTimingCountDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-926618722")) {
                ipChange.ipc$dispatch("-926618722", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.processTimeCountDownClick();
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1605751251")) {
                ipChange.ipc$dispatch("1605751251", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.timerAndStrategyTmPromptView.hideResetAttendees();
            ProjectDetailItemMainFragment.this.strategyClick();
        }
    }

    /* compiled from: Taobao */
    public class f0 implements ProjectTitleBarPanel.OnUiClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onActivityShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-415926288")) {
                ipChange.ipc$dispatch("-415926288", new Object[]{this});
                return;
            }
            ProjectDetailActivity projectDetailActivity = ProjectDetailItemMainFragment.this.mProjectDetailActivity;
            gu1.c(projectDetailActivity, ProjectDetailItemMainFragment.this.mProjectId + "", ProjectDetailItemMainFragment.this.mProjectStaticDataBean);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1575630017")) {
                ipChange.ipc$dispatch("1575630017", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().c1(ProjectDetailItemMainFragment.this.mProjectId, true));
            if (ProjectDetailItemMainFragment.this.mIsFromPush && ProjectDetailItemMainFragment.this.mBackType != 1) {
                DMNav.from(ProjectDetailItemMainFragment.this.mProjectDetailActivity).toUri(NavUri.b(gr.n));
            }
            ProjectDetailItemMainFragment.this.mProjectDetailActivity.onBackPressed();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onCertInfoClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-699599028")) {
                ipChange.ipc$dispatch("-699599028", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().d1(ProjectDetailItemMainFragment.this.mProjectId, true));
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tt1.b(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.mProjectStaticDataBean);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onTitleBarClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1081397259")) {
                ipChange.ipc$dispatch("-1081397259", new Object[]{this});
            } else if (ProjectDetailItemMainFragment.this.mAnchorManager != null) {
                ProjectDetailItemMainFragment.this.mTitleBarPanel.d(false);
                ProjectDetailItemMainFragment.this.isFixedAnchorVisible = false;
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                projectDetailItemMainFragment.scrollToPosition(1, projectDetailItemMainFragment.getOffset());
                ProjectDetailItemMainFragment.this.hideFixedAnchorIndicator();
                ProjectDetailItemMainFragment.this.setCurAnchorPosition(0);
                ProjectDetailItemMainFragment.this.mLinearPullToRefreshView.setPullToRefreshEnabled(true);
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements ProjectSpecialBuyPromptView.SpecialBuyPromptListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView.SpecialBuyPromptListener
        public void onVipRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "295835654")) {
                ipChange.ipc$dispatch("295835654", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.onRefresh();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView.SpecialBuyPromptListener
        public void showVIPCreditExchange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1801406603")) {
                ipChange.ipc$dispatch("1801406603", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.showVIPCreditExchangeFragment();
        }
    }

    /* compiled from: Taobao */
    public class g0 implements ProjectItemStatusHelper.OnProjectNotExistsListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnProjectNotExistsListener
        public void onProjectNotExists() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1272758491")) {
                ipChange.ipc$dispatch("-1272758491", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.reportProjectNotExitsFromHome();
        }
    }

    /* compiled from: Taobao */
    public class h implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-625943198")) {
                ipChange.ipc$dispatch("-625943198", new Object[]{this, Long.valueOf(j)});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = true;
            ProjectDetailItemMainFragment.this.timeCountDownFinished();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1678681212")) {
                ipChange.ipc$dispatch("1678681212", new Object[]{this, str, str2, str3, str4});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = false;
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "321248145")) {
                ipChange.ipc$dispatch("321248145", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
            } else if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                ProjectDetailItemMainFragment.this.mProjectItemDataBean.setCountDown(j);
            }
        }
    }

    /* compiled from: Taobao */
    public class h0 implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h0() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1051736854")) {
                ipChange.ipc$dispatch("1051736854", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().k(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.timerAndStagoryView.updateRemindMeBtnText(true);
            qt1.f(ProjectDetailItemMainFragment.this.mProjectDetailActivity, "添加日历提醒成功", "开抢前10分钟将收到手机日历提醒，可在系统日历中更改提醒时间");
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-390678812")) {
                ipChange.ipc$dispatch("-390678812", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().m(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.timerAndStagoryView.updateRemindMeBtnText(false);
            ToastUtil.i("取消提醒成功");
        }
    }

    /* compiled from: Taobao */
    public class i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-650312234")) {
                ipChange.ipc$dispatch("-650312234", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.specialBuyPromptView.hideResetAttendees();
            ProjectDetailItemMainFragment.this.strategyClick();
        }
    }

    /* compiled from: Taobao */
    public class i0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i0() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1651643859")) {
                ipChange.ipc$dispatch("-1651643859", new Object[]{this, view});
                return;
            }
            g70.f(ProjectDetailItemMainFragment.this.mProjectDetailActivity);
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPrivilegeCodeVerifyFragment);
        }
    }

    /* compiled from: Taobao */
    public class j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1460978135")) {
                ipChange.ipc$dispatch("1460978135", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.mProjectStaticDataBean != null && ProjectDetailItemMainFragment.this.mProjectStaticDataBean.getItemBase() != null && "true".equals(ProjectDetailItemMainFragment.this.mProjectStaticDataBean.getItemBase().getHasSkuPopup())) {
                cn.damai.common.user.c.e().x(ln2.r().C0(ProjectDetailItemMainFragment.this.mProjectId));
                if (ProjectDetailItemMainFragment.this.isLogin()) {
                    ProjectDetailItemMainFragment.this.popupSkuByPerformInfo();
                    hu1.f(false);
                    return;
                }
                ProjectDetailItemMainFragment.this.startLoginActivityForResult(4117);
            }
        }
    }

    /* compiled from: Taobao */
    public class j0 implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;

        j0() {
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-268061374")) {
                return getGuideExposeArgMap();
            }
            return (Map) ipChange.ipc$dispatch("-268061374", new Object[]{this});
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677338814")) {
                return (Map) ipChange.ipc$dispatch("-1677338814", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", ProjectDetailItemMainFragment.this.mProjectId + "");
            return hashMap;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2134719969")) {
                return getGuideExposeArgMap();
            }
            return (Map) ipChange.ipc$dispatch("2134719969", new Object[]{this});
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "691341723")) {
                return ta.PROJECT_PAGE;
            }
            return (String) ipChange.ipc$dispatch("691341723", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public class k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        public void onClick(View view) {
            ProjectStaticItemBaseBean itemBase;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "664725997")) {
                ipChange.ipc$dispatch("664725997", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.mProjectStaticDataBean != null && (itemBase = ProjectDetailItemMainFragment.this.mProjectStaticDataBean.getItemBase()) != null) {
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tt1.p(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, itemBase.getListSeatImg(), itemBase.getListPerformSeatImg(), itemBase.isHasNoneSeatImg());
            }
        }
    }

    /* compiled from: Taobao */
    public class k0 implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k0() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1488337504")) {
                ipChange.ipc$dispatch("1488337504", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (ProjectDetailItemMainFragment.this.getContext() != null) {
                ProjectDetailItemMainFragment.this.getContext().startActivity(wj1.a(ProjectDetailItemMainFragment.this.getContext()));
                cn.damai.common.user.c.e().x(ln2.r().t(ProjectDetailItemMainFragment.this.mProjectId));
            }
        }
    }

    /* compiled from: Taobao */
    public class l implements OnRecommendItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener
        public void onRecommendItemClick(int i) {
            ProjectRecommendBean projectRecommendBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "93982142")) {
                ipChange.ipc$dispatch("93982142", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int e = xf2.e(ProjectDetailItemMainFragment.this.mRecommendItems);
            if (e > 0 && i >= 0 && i < e && (projectRecommendBean = (ProjectRecommendBean) ProjectDetailItemMainFragment.this.mRecommendItems.get(i)) != null) {
                ProjectItemBean projectItemBean = projectRecommendBean.project;
                if (projectItemBean != null) {
                    ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                    tt1.i(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, i, projectItemBean);
                    return;
                }
                ProjectFreeTicketBean projectFreeTicketBean = projectRecommendBean.freeTicket;
                if (projectFreeTicketBean != null) {
                    tt1.h(ProjectDetailItemMainFragment.this.mProjectDetailActivity, projectFreeTicketBean.url);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class l0 implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;

        l0(long j) {
            this.a = j;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "61027462")) {
                ipChange.ipc$dispatch("61027462", new Object[]{this, dialogInterface});
                return;
            }
            ln2.r().S1(String.valueOf(ProjectDetailItemMainFragment.this.mProjectId), this.a);
        }
    }

    /* compiled from: Taobao */
    public class m implements OnItemExtendInfoItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener
        public IRichTextManager getRichTextManager(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "866863311")) {
                return ProjectDetailItemMainFragment.this.mProjectDataHolderManager.r(i);
            }
            return (IRichTextManager) ipChange.ipc$dispatch("866863311", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener
        public void onExtendInfoImageItemClick(View view, int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "667593026")) {
                ipChange.ipc$dispatch("667593026", new Object[]{this, view, Integer.valueOf(i), str, str2});
                return;
            }
            ProjectDetailItemMainFragment.this.onExtendInfoItemClick(view, i, str, str2);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener
        public void onExtendInfoMoreBtnClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "234516301")) {
                ipChange.ipc$dispatch("234516301", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment.this.onMoreExtendInfoBtnClickListener(i, -1);
            ProjectDetailItemMainFragment.this.startWantSeeGuideTimer(WantSeeGuideTips.b.c.INSTANCE);
        }
    }

    /* compiled from: Taobao */
    public class m0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m0(ProjectDetailItemMainFragment projectDetailItemMainFragment) {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1796416975")) {
                ipChange.ipc$dispatch("-1796416975", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    public class n implements OnCommonProblemsListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener
        public void onMoreClick(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-24221780")) {
                ipChange.ipc$dispatch("-24221780", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().j0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.setAliMeParams(AliMeUtil.FROM_PROJECT_DETAIL, "");
            ProjectDetailItemMainFragment.this.getAliMeTokenAndEnter();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnCommonProblemsListener
        public void onProblemItemClick(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1775344195")) {
                ipChange.ipc$dispatch("1775344195", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().i0(ProjectDetailItemMainFragment.this.mProjectId, i));
            ProjectDetailItemMainFragment.this.setAliMeParams(AliMeUtil.FROM_PROJECT_COMMON_PROBLEM, str);
            ProjectDetailItemMainFragment.this.getAliMeTokenAndEnter();
        }
    }

    /* compiled from: Taobao */
    public class n0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n0() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "314873394")) {
                ipChange.ipc$dispatch("314873394", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.mWantTipsContainer.removeAllViews();
            ProjectDetailItemMainFragment.this.mWantTipsContainer.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class o implements OnEvaluateMineListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnEvaluateMineListener
        public void onClick(View view, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "942058117")) {
                ipChange.ipc$dispatch("942058117", new Object[]{this, view, str, str2});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tt1.m(projectDetailItemMainFragment.mProjectDetailActivity, str, projectDetailItemMainFragment.mProjectId);
        }
    }

    /* compiled from: Taobao */
    public class o0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o0() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "242486836")) {
                ipChange.ipc$dispatch("242486836", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    public class p implements OnDiscussionClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        p(ProjectDetailItemMainFragment projectDetailItemMainFragment) {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnDiscussionClickListener
        public void onDiscussionClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1668605846")) {
                ipChange.ipc$dispatch("-1668605846", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    public class p0 implements ProjectDialogHelper.ProjectDialogListener {
        private static transient /* synthetic */ IpChange $ipChange;

        p0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper.ProjectDialogListener
        public void excuteNATRequest(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-84585202")) {
                ipChange.ipc$dispatch("-84585202", new Object[]{this, str});
                return;
            }
            ((ProjectItemPresenter) ProjectDetailItemMainFragment.this.mPresenter).getProjectNATData(str);
        }
    }

    /* compiled from: Taobao */
    public class q implements OnSectionMoreClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        q() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener
        public void onMoreClick(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "609830959")) {
                ipChange.ipc$dispatch("609830959", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            } else if (i == 2) {
                cn.damai.common.user.c.e().x(ln2.r().k0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tt1.n(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.getIpId(), ProjectDetailItemMainFragment.this.getTourId(), "");
            } else if (i == 3) {
                cn.damai.common.user.c.e().x(ln2.r().A0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.showNoticeFragment(0);
            } else if (i == 4) {
                cn.damai.common.user.c.e().x(ln2.r().R0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.showNoticeFragment(1);
            } else if (i == 0) {
                ProjectDetailItemMainFragment.this.onMoreExtendInfoBtnClickListener(i2, i3);
            }
        }
    }

    /* compiled from: Taobao */
    public class q0 implements ShareManagerImpl {
        private static transient /* synthetic */ IpChange $ipChange;

        q0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl
        public void createPic() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "887785571")) {
                ipChange.ipc$dispatch("887785571", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            gu1.a(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectStaticDataBean, ProjectDetailItemMainFragment.this.mProjectId);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl
        public void shareFriend() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1002386796")) {
                ipChange.ipc$dispatch("-1002386796", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            ProjectDetailActivity projectDetailActivity = projectDetailItemMainFragment.mProjectDetailActivity;
            ProjectStaticDataBean projectStaticDataBean = projectDetailItemMainFragment.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment2 = ProjectDetailItemMainFragment.this;
            gu1.e(1, projectDetailActivity, projectStaticDataBean, projectDetailItemMainFragment2.mProjectId, projectDetailItemMainFragment2.mSinaSharePath);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl
        public void shareWX() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "907081233")) {
                ipChange.ipc$dispatch("907081233", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            ProjectDetailActivity projectDetailActivity = projectDetailItemMainFragment.mProjectDetailActivity;
            ProjectStaticDataBean projectStaticDataBean = projectDetailItemMainFragment.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment2 = ProjectDetailItemMainFragment.this;
            gu1.e(0, projectDetailActivity, projectStaticDataBean, projectDetailItemMainFragment2.mProjectId, projectDetailItemMainFragment2.mSinaSharePath);
        }
    }

    /* compiled from: Taobao */
    public class r implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        r() {
        }

        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736110604")) {
                ipChange.ipc$dispatch("-1736110604", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.requestFavorite(true);
        }
    }

    /* compiled from: Taobao */
    public class r0 implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        r0() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1428164924")) {
                ipChange.ipc$dispatch("-1428164924", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment.this.getProjectDetailData(1);
        }
    }

    /* compiled from: Taobao */
    public class s implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        s() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "375179765")) {
                ipChange.ipc$dispatch("375179765", new Object[]{this, view});
                return;
            }
            InFieldCommentsBean inFieldCommentsBean = null;
            try {
                inFieldCommentsBean = (InFieldCommentsBean) view.getTag();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (inFieldCommentsBean != null) {
                if (inFieldCommentsBean.isTypeStrategy() || inFieldCommentsBean.isCanDowngradeToStrategy()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("contentId", inFieldCommentsBean.id);
                    NavProxy.from(ProjectDetailItemMainFragment.this.mActivity).withExtras(bundle).toUri(INavUri.page(gr.DISCOVER_CONTENT_DETAIL));
                    cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
                    ln2 r = ln2.r();
                    e2.x(r.u2(ProjectDetailItemMainFragment.this.mProjectId + "", inFieldCommentsBean, inFieldCommentsBean.index));
                } else if (inFieldCommentsBean.isTypeGROUP() && !TextUtils.isEmpty(inFieldCommentsBean.groupJumpUrl)) {
                    cn.damai.common.user.c e3 = cn.damai.common.user.c.e();
                    ln2 r2 = ln2.r();
                    e3.x(r2.u2(ProjectDetailItemMainFragment.this.mProjectId + "", inFieldCommentsBean, inFieldCommentsBean.index));
                    NavProxy.from(ProjectDetailItemMainFragment.this.mActivity).toUri(inFieldCommentsBean.groupJumpUrl);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class s0 implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        s0() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-458583901")) {
                ipChange.ipc$dispatch("-458583901", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment.this.scrollToRecommend();
        }
    }

    /* compiled from: Taobao */
    public class t implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        t() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1808497162")) {
                ipChange.ipc$dispatch("-1808497162", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.detailFragment);
        }
    }

    /* compiled from: Taobao */
    public class t0 implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        t0() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-48567078")) {
                ipChange.ipc$dispatch("-48567078", new Object[]{this, obj});
                return;
            }
            ProjectDetailItemMainFragment.this.onPraiseViewOnClick((CommentsItemBean) obj);
        }
    }

    /* compiled from: Taobao */
    public class u extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        u() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-969311336")) {
                ipChange.ipc$dispatch("-969311336", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            int i = message.what;
            if ((i == 102 || i == 103) && ProjectDetailItemMainFragment.this.mFlvPopupLayer != null && ProjectDetailItemMainFragment.this.mFlvPopupLayer.getVisibility() == 0) {
                ProjectDetailItemMainFragment.this.mFlvPopupLayer.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    public class u0 implements ProjectDialogShowListener {
        private static transient /* synthetic */ IpChange $ipChange;

        u0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.ProjectDialogShowListener
        public void dialogShowBack() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1630630385")) {
                ipChange.ipc$dispatch("1630630385", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.dismissScreenShotShare();
        }
    }

    /* compiled from: Taobao */
    public class v implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        v() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1690217996")) {
                ipChange.ipc$dispatch("1690217996", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.detailFragment);
        }
    }

    /* compiled from: Taobao */
    public class v0 implements ScreenShotDetector.IScreenShotExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;

        v0() {
        }

        @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
        public void onDetected(String str, Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1196456409")) {
                ipChange.ipc$dispatch("1196456409", new Object[]{this, str, activity});
            } else if (ProjectDetailItemMainFragment.this.mIsLoading) {
                ProjectDetailItemMainFragment.this.startSreenShotPage();
            } else if (ProjectDetailItemMainFragment.this.mProjectDetailDataBean == null) {
                ProjectDetailItemMainFragment.this.startSreenShotPage();
            } else if (ProjectDetailItemMainFragment.this.isHotProject()) {
                ProjectDetailItemMainFragment.this.startSreenShotPage();
            } else {
                if (ProjectDetailItemMainFragment.this.mDialogPanel != null) {
                    if (ProjectDetailItemMainFragment.this.mDialogPanel.t()) {
                        ProjectDetailItemMainFragment.this.startSreenShotPage();
                        return;
                    } else if (ProjectDetailItemMainFragment.this.mDialogPanel.r()) {
                        ProjectDetailItemMainFragment.this.startSreenShotPage();
                        return;
                    }
                }
                ProjectDetailItemMainFragment.this.showSreenSharePage();
            }
        }
    }

    /* compiled from: Taobao */
    public class w implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        w() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493458931")) {
                ipChange.ipc$dispatch("-493458931", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    public class w0 extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeGuideTips.b a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w0(long j, long j2, WantSeeGuideTips.b bVar) {
            super(j, j2);
            this.a = bVar;
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1080117683")) {
                ipChange.ipc$dispatch("-1080117683", new Object[]{this});
                return;
            }
            if (ProjectDetailItemMainFragment.this.wantSeeTips != null) {
                ProjectDetailItemMainFragment.this.wantSeeTips.cancel();
            }
            if (!ProjectDetailItemMainFragment.this.isBottomTimerAndStrategyShowing()) {
                ((FrameLayout.LayoutParams) ProjectDetailItemMainFragment.this.wantSeeGuideTips.getLayoutParams()).gravity = BadgeDrawable.BOTTOM_START;
                ProjectDetailItemMainFragment.this.wantSeeGuideTips.setScenesSource(this.a);
                ProjectDetailItemMainFragment.this.wantSeeGuideTips.setProjectId(Long.valueOf(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.wantSeeGuideTips.showAnim();
                WantSeeGuideTips.Companion.b(true);
            }
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "80477025")) {
                ipChange.ipc$dispatch("80477025", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    public class x implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        x() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1648519077")) {
                ipChange.ipc$dispatch("-1648519077", new Object[]{this, Long.valueOf(j)});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = true;
            ProjectDetailItemMainFragment.this.timeCountDownFinished();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1538454261")) {
                ipChange.ipc$dispatch("1538454261", new Object[]{this, str, str2, str3, str4});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = false;
            ProjectDetailItemMainFragment.this.timerAndStrategyTmPromptView.setCountDownTime(str, str2, str3, str4);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1425103352")) {
                ipChange.ipc$dispatch("1425103352", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
                return;
            }
            if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                ProjectDetailItemMainFragment.this.mProjectItemDataBean.setCountDown(j);
            }
            ProjectDetailItemMainFragment.this.timerAndStrategyTmPromptView.setCountDownTime(str, str2, str3, str4);
        }
    }

    /* compiled from: Taobao */
    public class x0 implements OnHeadClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        x0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onLoadedPosterPic(String str, Bitmap bitmap, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-754777224")) {
                ipChange.ipc$dispatch("-754777224", new Object[]{this, str, bitmap, Boolean.valueOf(z)});
                return;
            }
            ProjectDetailItemMainFragment.this.setProjectDetailMaskLayerImage(str, bitmap, z);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onMarketStallClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-474956442")) {
                ipChange.ipc$dispatch("-474956442", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.toMarketStall();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onNoticeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1106490160")) {
                ipChange.ipc$dispatch("1106490160", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().z0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.showProjectNoticeFragment();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPosterClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-740436827")) {
                ipChange.ipc$dispatch("-740436827", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.mOnProjectPosterClickListener.onClick(null);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPromotionTagsClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1353962818")) {
                ipChange.ipc$dispatch("-1353962818", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.mOnPromotionDetailClickListener.onClick(null);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onRankListClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1158856322")) {
                ipChange.ipc$dispatch("1158856322", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.toRankListPage();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreBottomTagClick(ProjectRatingContentLabelBean projectRatingContentLabelBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-479409253")) {
                ipChange.ipc$dispatch("-479409253", new Object[]{this, projectRatingContentLabelBean});
            } else if (projectRatingContentLabelBean != null) {
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tt1.o(projectDetailItemMainFragment.mActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.getIpId(), ProjectDetailItemMainFragment.this.getTourId(), projectRatingContentLabelBean.labelName, projectRatingContentLabelBean.labelType, projectRatingContentLabelBean.labelId);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreCommentClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-141853021")) {
                ipChange.ipc$dispatch("-141853021", new Object[]{this, str, str2, str3});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tt1.n(projectDetailItemMainFragment.mActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.getIpId(), ProjectDetailItemMainFragment.this.getTourId(), str3);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreHeadTipClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2147360939")) {
                ipChange.ipc$dispatch("-2147360939", new Object[]{this, str, str2});
                return;
            }
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            ln2 r = ln2.r();
            e.x(r.A1(ProjectDetailItemMainFragment.this.mProjectId + "", ProjectDetailItemMainFragment.this.getIpId(), str2));
            DMNav.from(ProjectDetailItemMainFragment.this.mActivity).toUri(str);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onSeatIconClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1724333130")) {
                ipChange.ipc$dispatch("-1724333130", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.mOnPerformSeatImgIconClickListener.onClick(null);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onServiceEtcClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-286614921")) {
                ipChange.ipc$dispatch("-286614921", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().M0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.showSupportServicePopLayer();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onShowTimeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2138611458")) {
                ipChange.ipc$dispatch("2138611458", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.mOnPerformInfoClickListener.onClick(null);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueMapIconClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-956672866")) {
                ipChange.ipc$dispatch("-956672866", new Object[]{this});
                return;
            }
            ProjectStaticDataBean projectStaticDataBean = ProjectDetailItemMainFragment.this.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tt1.f(projectStaticDataBean, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.mProjectDetailActivity);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueNameClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "75132284")) {
                ipChange.ipc$dispatch("75132284", new Object[]{this});
                return;
            }
            ProjectStaticDataBean projectStaticDataBean = ProjectDetailItemMainFragment.this.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tt1.e(projectStaticDataBean, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.mProjectDetailActivity);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVideoClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477413690")) {
                ipChange.ipc$dispatch("-1477413690", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tt1.g(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectDynamicExtDataBean, ProjectDetailItemMainFragment.this.mProjectId, i);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onWannaSeeActionClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-426267158")) {
                ipChange.ipc$dispatch("-426267158", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment.this.requestFavorite(false);
        }
    }

    /* compiled from: Taobao */
    public class y implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        y() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-686905060")) {
                ipChange.ipc$dispatch("-686905060", new Object[]{this, Long.valueOf(j)});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = true;
            ProjectDetailItemMainFragment.this.timeCountDownFinished();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2080820426")) {
                ipChange.ipc$dispatch("-2080820426", new Object[]{this, str, str2, str3, str4});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = false;
            ProjectDetailItemMainFragment.this.timerAndStagoryView.setCountDownTime(str, str2, str3, str4);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "615615895")) {
                ipChange.ipc$dispatch("615615895", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
                return;
            }
            if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                ProjectDetailItemMainFragment.this.mProjectItemDataBean.setCountDown(j);
            }
            ProjectDetailItemMainFragment.this.timerAndStagoryView.setCountDownTime(str, str2, str3, str4);
        }
    }

    /* compiled from: Taobao */
    public class y0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        y0() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-26194597")) {
                ipChange.ipc$dispatch("-26194597", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().L0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.setAliMeParams(AliMeUtil.FROM_PROJECT_DETAIL, "");
            ProjectDetailItemMainFragment.this.getAliMeTokenAndEnter();
        }
    }

    /* compiled from: Taobao */
    public class z implements VIPCreditExchangePopFragment.IExchangeResult {
        private static transient /* synthetic */ IpChange $ipChange;

        z() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment.IExchangeResult
        public void exchangeResult(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "206325685")) {
                ipChange.ipc$dispatch("206325685", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            ProjectDetailItemMainFragment.this.onRefresh();
        }
    }

    /* compiled from: Taobao */
    public class z0 implements Action<Bundle> {
        private static transient /* synthetic */ IpChange $ipChange;

        z0() {
        }

        /* renamed from: a */
        public void call(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1479105255")) {
                ipChange.ipc$dispatch("1479105255", new Object[]{this, bundle});
            } else if (ProjectDetailItemMainFragment.this.viewCreater != null) {
                br.c(ProjectDetailItemMainFragment.this.viewCreater.a().a(), new cn.damai.tetris.core.msg.Message(10241, bundle));
            }
        }
    }

    private void autoCancelCalendarRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215223436")) {
            ipChange.ipc$dispatch("215223436", new Object[]{this});
        } else if (this.mProjectStaticDataBean.getItemBase() != null && this.mProjectStaticDataBean.getItemBase().isProjectCancel()) {
            qt1.b(this.mProjectDetailActivity, getCalendarRemindTitle(), getCalendSellTime(), this.mProjectId);
        }
    }

    private void autoShowSkuLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363252408")) {
            ipChange.ipc$dispatch("363252408", new Object[]{this});
            return;
        }
        int i2 = this.mPurchaseType;
        if (i2 == 1) {
            this.mPurchaseType = -1;
            showPerformListFragment(false);
        } else if (i2 == 2) {
            this.mPurchaseType = -1;
            handleChooseSeatPage();
        } else if (i2 == 3) {
            this.mPurchaseType = -1;
            processClickSaleRemindStatus();
        }
    }

    private void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529802277")) {
            ipChange.ipc$dispatch("-529802277", new Object[]{this});
            return;
        }
        ITimeCountDownManager iTimeCountDownManager = this.mTimeCountDownManager;
        if (iTimeCountDownManager != null) {
            iTimeCountDownManager.cancelCountDown();
        }
        ITimeCountDownManager iTimeCountDownManager2 = this.mMemberPromptTimeCountDownManager;
        if (iTimeCountDownManager2 != null) {
            iTimeCountDownManager2.cancelCountDown();
        }
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView = this.timerAndStrategyTmPromptView;
        if (projectTimerAndStrategyTmPromptView != null) {
            projectTimerAndStrategyTmPromptView.cancelDownAnim();
        }
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView = this.specialBuyPromptView;
        if (projectSpecialBuyPromptView != null) {
            projectSpecialBuyPromptView.cancelDownAnim();
            if (this.specialBuyPromptView.getTimerCountDownManager() != null) {
                this.specialBuyPromptView.getTimerCountDownManager().cancelCountDown();
            }
        }
    }

    private void checkDisplayFixedAnchorIndicator(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608064555")) {
            ipChange.ipc$dispatch("608064555", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 >= (this.mLvProjectDetailHeader.getHeight() - this.mTitleBarPanel.e()) - this.mAnchorIndicator.getHeight()) {
            this.isFixedAnchorVisible = true;
            showFixedAnchorIndicator();
        } else {
            this.isFixedAnchorVisible = false;
            hideFixedAnchorIndicator();
        }
    }

    private void clickedAnchorItem(int i2, a5 a5Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922975081")) {
            ipChange.ipc$dispatch("922975081", new Object[]{this, Integer.valueOf(i2), a5Var});
            return;
        }
        this.mLinearPullToRefreshView.setPullToRefreshEnabled(false);
        setCurAnchorPosition(i2);
        scrollToPosition(a5Var.c().b().intValue(), getOffset());
        this.isFixedAnchorVisible = true;
        updateTitleAndFixAnchorVisibility(false);
    }

    private void closeSkuActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233223076")) {
            ipChange.ipc$dispatch("233223076", new Object[]{this});
            return;
        }
        br.c(NcovSkuActivity.MESSAGE_CLOSE, "");
    }

    private void confirmPromptContentPriority() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118485281")) {
            ipChange.ipc$dispatch("-2118485281", new Object[]{this});
            return;
        }
        String unpaidNotice = getUnpaidNotice();
        if (!TextUtils.isEmpty(unpaidNotice)) {
            this.mTvPromptContent.setText(unpaidNotice);
            this.mTvPromptContent.setMaxLines(2);
            this.mRvPromptFloatingLayerView.setVisibility(0);
            return;
        }
        this.mRvPromptFloatingLayerView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissPopLayerFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099375280")) {
            ipChange.ipc$dispatch("-2099375280", new Object[]{this, fragment});
        } else if (fragment != null && fragment.getActivity() != null) {
            if (!fragment.getActivity().isFinishing()) {
                FragmentTransaction fragmentTransaction = getFragmentTransaction();
                fragmentTransaction.remove(fragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
            sendHandlerMessage(102, 400);
            if (fragment instanceof NcovPromotionFragment) {
                novBackUtHandle();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissScreenShotShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710696361")) {
            ipChange.ipc$dispatch("1710696361", new Object[]{this});
            return;
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    private void displayErrorPage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199217215")) {
            ipChange.ipc$dispatch("-1199217215", new Object[]{this, str, str2, str3});
            return;
        }
        this.mFlPurchaseStatusBarContainer.setVisibility(8);
        this.mLvBottomBar.setVisibility(8);
        this.mRvPromptFloatingLayerView.setVisibility(8);
        updateTitleAndFixAnchorVisibility(true);
        this.mFlProjectContentContainer.setVisibility(0);
        if (isFlowLimitedErrorCode(str)) {
            onResponseError(2, "抱歉，当前排队的人数太多啦，请稍后再试哦", str, str3, this.mFlProjectContentContainer, true);
            this.mErrorPage.updateRefreshBtn(true, "努力刷新");
            this.mErrorPage.updateReportBtn(false, "");
            return;
        }
        onResponseError(str2, str, str3, this.mFlProjectContentContainer, true);
    }

    private void displayProjectNotExistPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529262638")) {
            ipChange.ipc$dispatch("529262638", new Object[]{this});
            return;
        }
        if (this.mFlNotExistPageContainer == null) {
            this.mFlNotExistPageContainer = (FrameLayout) ((ViewStub) this.mContentRootLayout.findViewById(R$id.project_item_not_exist_view_stub)).inflate().findViewById(R$id.trade_project_detail_not_exist_page_fl);
        }
        updateTitleAndFixAnchorVisibility(true);
        this.mRvProjectDetailContent.setVisibility(8);
        this.mRvPromptFloatingLayerView.setVisibility(8);
        this.mFlNotExistPageContainer.setVisibility(0);
    }

    private boolean enableCalenderRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154146778")) {
            return ((Boolean) ipChange.ipc$dispatch("154146778", new Object[]{this})).booleanValue();
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        return projectItemDataBean != null && projectItemDataBean.getSellStartTime() > 0 && this.mProjectItemDataBean.getCountDown() > 600;
    }

    private void enterShowWantSeeGuideTips(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081558632")) {
            ipChange.ipc$dispatch("-1081558632", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        HashMap<Long, Integer> hashMap = projectEnterCountMap;
        if (hashMap.containsKey(Long.valueOf(j2))) {
            for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
                if (entry.getKey().longValue() == j2 && entry.getValue().intValue() >= 3) {
                    startWantSeeGuideTimer(WantSeeGuideTips.b.a.INSTANCE);
                }
            }
        }
    }

    private void executeEvaluatesAndDiscussionRequest() {
        ProjectStaticItemBaseBean itemBase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934532067")) {
            ipChange.ipc$dispatch("934532067", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && (itemBase = projectStaticDataBean.getItemBase()) != null) {
            long categoryId = itemBase.getCategoryId();
            ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
            String ipId = (projectDynamicExtDataBean == null || projectDynamicExtDataBean.getIpCard() == null) ? "" : this.mProjectDynamicExtDataBean.getIpCard().getIpId();
            ((ProjectItemPresenter) this.mPresenter).getProjectDetailEvaluates(this.mProjectId, categoryId, ipId, 9, 32, 1, 3, true, getTourId());
            ((ProjectItemPresenter) this.mPresenter).getProjectDetailDiscussion(this.mProjectId, categoryId, ipId);
        }
    }

    private void executeProjectDetailDataRequest(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-461896703")) {
            ipChange.ipc$dispatch("-461896703", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        ((ProjectItemPresenter) this.mPresenter).getProjectDetailData(i2, String.valueOf(this.mProjectId));
    }

    private void executeRecommendedProjectRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047629404")) {
            ipChange.ipc$dispatch("2047629404", new Object[]{this});
        } else if (d20.K()) {
            ((ProjectItemPresenter) this.mPresenter).getRecommendProjectList(d20.E(), d20.c(), d20.o(), d20.n(), 1, 10, jl1.ARRAY_START_STR + this.mProjectId + jl1.ARRAY_END_STR, true, 1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fixAnchorSelection(boolean z2) {
        AnchorManager anchorManager;
        a5 e2;
        View findViewByPosition;
        a5 h2;
        View findViewByPosition2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738675390")) {
            ipChange.ipc$dispatch("1738675390", new Object[]{this, Boolean.valueOf(z2)});
        } else if (!this.isShowAnchor || (anchorManager = this.mAnchorManager) == null) {
        } else {
            if (z2) {
                if (anchorManager.j() && (h2 = this.mAnchorManager.h()) != null && (findViewByPosition2 = this.mLinearLayoutManager.findViewByPosition(h2.c().b().intValue())) != null && Math.abs(findViewByPosition2.getTop()) <= getOffset() && this.mAnchorManager.f() != h2.b()) {
                    int b2 = h2.b();
                    this.mCurAnchorPosition = b2;
                    setCurAnchorPosition(b2);
                }
            } else if (anchorManager.k() && (e2 = this.mAnchorManager.e()) != null && (findViewByPosition = this.mLinearLayoutManager.findViewByPosition(e2.c().b().intValue())) != null && Math.abs(findViewByPosition.getTop()) > getOffset()) {
                int b3 = this.mAnchorManager.i().b();
                this.mCurAnchorPosition = b3;
                setCurAnchorPosition(b3);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getAliMeTokenAndEnter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662590488")) {
            ipChange.ipc$dispatch("1662590488", new Object[]{this});
            return;
        }
        String E = d20.E();
        if (!isLogin() || TextUtils.isEmpty(E)) {
            startLoginActivityForResult(CaptureActivity.LOCK_SUCCESS);
            return;
        }
        int k2 = xf2.k(E);
        startProgressDialog();
        AliMeUtil.d(k2, this.mAliMeFrom, new d0());
    }

    private long getCalendSellTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035744252")) {
            return ((Long) ipChange.ipc$dispatch("-2035744252", new Object[]{this})).longValue();
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            return projectItemDataBean.getSellStartTime();
        }
        return 0;
    }

    private String getCalendarRemindTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217383161")) {
            return (String) ipChange.ipc$dispatch("-1217383161", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) ? "" : this.mProjectStaticDataBean.getItemBase().getItemName();
    }

    private FragmentTransaction getFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955636886")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("-955636886", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i2 = R$anim.pop_layer_slide_in_from_bottom;
        int i3 = R$anim.pop_layer_slide_out_to_bottom;
        beginTransaction.setCustomAnimations(i2, i3, i2, i3);
        return beginTransaction;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getIpId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719103802")) {
            return (String) ipChange.ipc$dispatch("-1719103802", new Object[]{this});
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        return (projectDynamicExtDataBean == null || projectDynamicExtDataBean.getIpCard() == null) ? "" : this.mProjectDynamicExtDataBean.getIpCard().getIpId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1823839812")) {
            return this.mTitleBarPanel.e() + this.mAnchorIndicator.getHeight();
        }
        return ((Integer) ipChange.ipc$dispatch("-1823839812", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ArrayList<PicInfo> getPosterPicInfoList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907353217")) {
            return (ArrayList) ipChange.ipc$dispatch("-1907353217", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || this.mProjectStaticDataBean.getItemBase().getItemPics() == null) {
            return null;
        }
        return this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getProjectDetailData(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007447799")) {
            ipChange.ipc$dispatch("-1007447799", new Object[]{this, Integer.valueOf(i2)});
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.mSkuBean = null;
            this.mPerformDataConfigure.a();
            this.mNewSkuData.a();
            this.mProjectDataHolderManager.T();
            executeProjectDetailDataRequest(i2);
            if (i2 == 0 || i2 == 1) {
                executeRecommendedProjectRequest();
            }
        }
    }

    private String getProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1066824298")) {
            return (String) ipChange.ipc$dispatch("-1066824298", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) ? "" : this.mProjectStaticDataBean.getItemBase().getItemName();
    }

    private String getProjectPosterUrl() {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643004141")) {
            return (String) ipChange.ipc$dispatch("1643004141", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || this.mProjectStaticDataBean.getItemBase().getItemPics() == null || this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList() == null || this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList().isEmpty() || (picInfo = this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList().get(0)) == null) {
            return "";
        }
        return picInfo.getPicUrl();
    }

    private void getResetAttendeesOrangeSwitch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1884548016")) {
            ipChange.ipc$dispatch("1884548016", new Object[]{this});
        } else if (!StartConfig.isResetAttendeesOpen()) {
            this.mProjectItemDataBean.setPurchaseLimitation(0);
        }
    }

    private FragmentTransaction getRightFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184366444")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("-1184366444", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i2 = R$anim.pop_layer_slide_left_from_right;
        int i3 = R$anim.pop_layer_slide_right_to_left;
        beginTransaction.setCustomAnimations(i2, i3, i2, i3);
        return beginTransaction;
    }

    private void getSubProjectDectailCheckData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804752221")) {
            ipChange.ipc$dispatch("-1804752221", new Object[]{this});
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            ((ProjectItemPresenter) this.mPresenter).getSubProjectDetailCheckData(String.valueOf(this.mProjectId), this.mPrivilegeId);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getTourId() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210093303")) {
            return (String) ipChange.ipc$dispatch("1210093303", new Object[]{this});
        }
        String str2 = null;
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && !s71.a(projectStaticDataBean.tourProjects)) {
            for (int i2 = 0; i2 < this.mProjectStaticDataBean.tourProjects.size(); i2++) {
                ProjectTour projectTour = this.mProjectStaticDataBean.tourProjects.get(i2);
                if (!(projectTour == null || (str = projectTour.itemId) == null)) {
                    if (str.equals(this.mProjectId + "")) {
                        str2 = projectTour.tourId;
                    }
                }
            }
        }
        return str2;
    }

    private String getUnpaidNotice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740216383")) {
            return (String) ipChange.ipc$dispatch("-740216383", new Object[]{this});
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        return projectItemDataBean != null ? projectItemDataBean.getUnpaidNotice() : "";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleChooseSeatPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465807941")) {
            ipChange.ipc$dispatch("465807941", new Object[]{this});
        } else if (!isLogin()) {
            startLoginActivityForResult(MessageConstant$MessageType.MESSAGE_DATA);
        } else {
            showPerformListFragment(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean hasRecommendProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2082480351")) {
            return xf2.e(this.mRecommendItems) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("2082480351", new Object[]{this})).booleanValue();
    }

    private boolean hasShowStrategy() {
        ProjectStaticItemBaseBean itemBase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175677268")) {
            return ((Boolean) ipChange.ipc$dispatch("-1175677268", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || (itemBase = projectStaticDataBean.getItemBase()) == null || !"true".equalsIgnoreCase(itemBase.getIsShowHotProjectModel())) ? false : true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideFixedAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304143056")) {
            ipChange.ipc$dispatch("-304143056", new Object[]{this});
            return;
        }
        this.isShowFixAnchorIndicator = false;
        this.mAnchorIndicatorFixed.setVisibility(8);
        this.mHeadDividerLine.setVisibility(8);
    }

    private void hideSkeleton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487877175")) {
            ipChange.ipc$dispatch("-487877175", new Object[]{this});
            return;
        }
        SkeletonScreen skeletonScreen2 = this.skeletonScreen;
        if (skeletonScreen2 != null) {
            skeletonScreen2.hide();
        }
    }

    private void initAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022808520")) {
            ipChange.ipc$dispatch("1022808520", new Object[]{this});
            return;
        }
        AnchorIndicatorView anchorIndicatorView = (AnchorIndicatorView) this.mLvProjectDetailHeader.findViewById(R$id.project_item_anchor_indicator);
        this.mAnchorIndicator = anchorIndicatorView;
        Resources resources = getResources();
        int i2 = R$color.color_000000;
        int color = resources.getColor(i2);
        Resources resources2 = getResources();
        int i3 = R$color.color_9C9CA5;
        anchorIndicatorView.setAnchorFontColor(color, resources2.getColor(i3));
        this.mAnchorIndicator.setOnAnchorItemClickListener(this);
        AnchorIndicatorView anchorIndicatorView2 = (AnchorIndicatorView) this.rootView.findViewById(R$id.project_item_anchor_indicator_fixed);
        this.mAnchorIndicatorFixed = anchorIndicatorView2;
        anchorIndicatorView2.setAnchorFontColor(getResources().getColor(i2), getResources().getColor(i3));
        this.mAnchorIndicatorFixed.setOnAnchorItemClickListener(this);
        this.mAnchorIndicatorFixed.setVisibility(8);
        View findViewById = this.rootView.findViewById(R$id.header_line_divider);
        this.mHeadDividerLine = findViewById;
        findViewById.setVisibility(8);
    }

    private void initBottomButtonView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-226794266")) {
            ipChange.ipc$dispatch("-226794266", new Object[]{this});
            return;
        }
        this.mBottomLineView = this.rootView.findViewById(R$id.line);
        this.mLvBottomBar = this.rootView.findViewById(R$id.project_item_bottom_bar_lv);
        this.mLvCustomerService = (FrameLayout) this.rootView.findViewById(R$id.project_item_bottom_customer_service_lv);
        SeeAnimateView seeAnimateView = (SeeAnimateView) this.rootView.findViewById(R$id.project_bottom_want_to_see_view);
        this.mViewProjectFollow = seeAnimateView;
        seeAnimateView.setCancelImage();
        this.mTvProjectFollowText = (TextView) this.rootView.findViewById(R$id.project_item_bottom_follow_text_tv);
        this.mFlPurchaseStatusBarContainer = (FrameLayout) this.rootView.findViewById(R$id.trade_project_detail_purchase_status_bar_container_fl);
        this.mLvCustomerService.setOnClickListener(new y0());
        this.wantSeeGuideTips = (WantSeeGuideTips) this.rootView.findViewById(R$id.want_see_guide_tips);
        this.wantSeePosterTips = (WantSeePosterTips) this.rootView.findViewById(R$id.want_see_poster_tips);
    }

    private void initBottomProjectStatusBarView(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411872049")) {
            ipChange.ipc$dispatch("411872049", new Object[]{this, projectItemDataBean});
            return;
        }
        if (this.mProjectItemStatusHelper == null) {
            ProjectItemStatusHelper projectItemStatusHelper = new ProjectItemStatusHelper(this.mProjectDetailActivity, this.mProjectItemDataBean, this.mProjectId, this.mFlPurchaseStatusBarContainer);
            this.mProjectItemStatusHelper = projectItemStatusHelper;
            if (projectItemStatusHelper.l()) {
                this.mFlPurchaseStatusBarContainer.addView(this.mProjectItemStatusHelper.h());
                initStatusBarViewListeners();
                this.mFlPurchaseStatusBarContainer.setVisibility(0);
            }
        } else {
            this.mFlPurchaseStatusBarContainer.setVisibility(0);
            this.mProjectItemStatusHelper.u(this.mProjectItemDataBean);
        }
        updatePageUT();
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871534968")) {
            ipChange.ipc$dispatch("-871534968", new Object[]{this});
            return;
        }
        updateProjectName();
        this.mProjectItemDetailAdapter.a(this.mProjectDataHolderManager.n());
    }

    private void initExtraParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950221332")) {
            ipChange.ipc$dispatch("-1950221332", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData = (ProjectIntentExtraParser.ProjectDetailExtrasData) arguments.getParcelable("projectExtraData");
            this.mProjectExtraData = projectDetailExtrasData;
            if (projectDetailExtrasData != null) {
                long j2 = projectDetailExtrasData.projectId;
                if (j2 > 0) {
                    this.mProjectId = j2;
                    this.mIsFromPush = projectDetailExtrasData.isFromPush;
                    this.mBackType = projectDetailExtrasData.backType;
                    this.mRankInfo = projectDetailExtrasData.rankInfo;
                    this.mMaskColor = Color.parseColor("#9D9D9D");
                    this.mProjectDetailActivity = (ProjectDetailActivity) getActivity();
                    this.mPerformDataConfigure = this.mPerformDataManager.c(this.mProjectId);
                    this.mNewSkuData = this.mNewSkuDataManager.b(this.mProjectId);
                    recordProjectEnterCount(this.mProjectId);
                    return;
                }
            }
            getActivity().finish();
            return;
        }
        getActivity().finish();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791955965")) {
            ipChange.ipc$dispatch("-791955965", new Object[]{this});
            return;
        }
        this.action = new z0();
        cr.c().e("brand_state_changed", this.action);
        this.mOnCloseMoreRecommendClickListener = new a1();
        this.mOnMoreRecommendClickListener = new b1();
        this.mOnProjectPosterClickListener = new a();
        this.mOnPromotionDetailClickListener = new b();
        this.timerAndStagoryView = (ProjectTimerAndStagoryView) this.rootView.findViewById(R$id.project_item_bottom_time_stagory);
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView = (ProjectTimerAndStrategyTmPromptView) this.rootView.findViewById(R$id.rl_member_timer_strategy);
        this.timerAndStrategyTmPromptView = projectTimerAndStrategyTmPromptView;
        projectTimerAndStrategyTmPromptView.setPromptParam(this.mProjectDetailActivity, new c());
        this.timerAndStagoryView.setOnRemindMeClickListener(new d());
        this.timerAndStagoryView.setStrategoryClickListener(new e());
        this.timerAndStrategyTmPromptView.setOnStrategyClickListener(new f());
        this.timerAndStagoryView.setProjectId(String.valueOf(this.mProjectId));
        this.timerAndStrategyTmPromptView.setProjectId(String.valueOf(this.mProjectId));
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView = (ProjectSpecialBuyPromptView) this.rootView.findViewById(R$id.member_special_buy_layout);
        this.specialBuyPromptView = projectSpecialBuyPromptView;
        projectSpecialBuyPromptView.setProjectId(this.mPrivilegeId);
        this.specialBuyPromptView.setPromptListener(new g());
        this.specialBuyPromptView.setCountDownListener(new h());
        this.specialBuyPromptView.setOnStrategyClickListener(new i());
        this.mOnPerformInfoClickListener = new j();
        this.mOnPerformSeatImgIconClickListener = new k();
        this.mOnRecommendItemClickListener = new l();
        this.mOnExtendInfoImageItemClickListener = new m();
        this.mOnProjectCommonProblemListener = new n();
        this.mOnEvaluateMineListener = new o();
        this.mOnDiscussionClickListener = new p(this);
        this.mOnSectionMoreClickListener = new q();
        this.mOnProjectFollowClickListener = new r();
    }

    private void initPopFragmentHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434646527")) {
            ipChange.ipc$dispatch("1434646527", new Object[]{this});
            return;
        }
        this.mHandler = new u();
    }

    private void initProjectDataHolderManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581024982")) {
            ipChange.ipc$dispatch("-581024982", new Object[]{this});
            return;
        }
        pt1 pt1 = new pt1(this.mProjectDetailActivity);
        this.mProjectDataHolderManager = pt1;
        this.mAnchorManager = pt1.i();
    }

    private void initProjectDetailHeaderInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649839208")) {
            ipChange.ipc$dispatch("-649839208", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mProjectDetailActivity).inflate(R$layout.project_detail_header_wrap, (ViewGroup) this.mRecyclerView.getHeaderContainer(), false);
        this.mLvProjectDetailHeader = linearLayout;
        View findViewById = linearLayout.findViewById(R$id.project_header);
        this.header = findViewById;
        ProjectDialogHelper projectDialogHelper = new ProjectDialogHelper(this.mProjectDetailActivity, findViewById.findViewById(R$id.header_service_etc_ui), new p0());
        this.mDialogPanel = projectDialogHelper;
        projectDialogHelper.u(this.dialogShowListener);
        this.mHeadPanel = new ProjectHeaderPanel(this.mProjectDetailActivity, this.mProjectId, this.header, new x0());
        this.mRecyclerView.addHeaderView(this.mLvProjectDetailHeader);
    }

    private void initProjectDetailView() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-390048077")) {
            ipChange.ipc$dispatch("-390048077", new Object[]{this});
            return;
        }
        initProjectDetailHeaderInfoView();
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R$id.project_item_detail_error_page_container);
        this.mFlProjectContentContainer = frameLayout;
        frameLayout.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.mFlProjectContentContainer.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int a2 = n42.a(this.mProjectDetailActivity, 44.0f);
            if (supportImmersionStyle()) {
                i2 = ne2.a(this.mProjectDetailActivity);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a2 + i2;
        }
        this.mIvProjectPosterMask = (ImageView) this.rootView.findViewById(R$id.project_poster_mask_iv);
        this.mRvPromptFloatingLayerView = this.rootView.findViewById(R$id.project_item_bottom_prompt_rv);
        this.mTvPromptContent = (TextView) this.rootView.findViewById(R$id.project_bottom_prompt_content_tv);
        this.mRvPromptFloatingLayerView.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) this.rootView.findViewById(R$id.project_item_bottom_want_tips_fl);
        this.mWantTipsContainer = frameLayout2;
        frameLayout2.setVisibility(8);
        this.wantSeeTips = (WantSeeTips) this.rootView.findViewById(R$id.want_see_tips_project_detail);
        this.mFlMoreRecommendFloatLayer = (FrameLayout) this.rootView.findViewById(R$id.project_more_recommend_flv);
        this.mIvCloseMoreRecommend = (ImageView) this.rootView.findViewById(R$id.close_more_recommend);
        this.mFlMoreRecommendFloatLayer.setVisibility(8);
        this.mFlvPopupLayer = (FrameLayout) this.rootView.findViewById(R$id.trade_project_detail_popup_layer_container_flv);
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35770076")) {
            ipChange.ipc$dispatch("-35770076", new Object[]{this});
            return;
        }
        PullToRefreshView pullToRefreshView = (PullToRefreshView) this.rootView.findViewById(R$id.project_item_pull_to_refresh_view);
        this.mLinearPullToRefreshView = pullToRefreshView;
        pullToRefreshView.setPullToRefreshEnabled(true);
        this.mLinearPullToRefreshView.setOnRefreshListener(this);
        this.viewCreater = new vv2(getActivity());
        this.mRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.project_item_detail_recycler_view);
        ProjectItemDetailAdapter projectItemDetailAdapter = new ProjectItemDetailAdapter(this.mProjectDetailActivity, this.mProjectId);
        this.mProjectItemDetailAdapter = projectItemDetailAdapter;
        projectItemDetailAdapter.m(this.viewCreater);
        WrapLinearLayoutManager wrapLinearLayoutManager = new WrapLinearLayoutManager(this.mProjectDetailActivity);
        this.mLinearLayoutManager = wrapLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(wrapLinearLayoutManager);
        this.mRecyclerView.setAdapter(this.mProjectItemDetailAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        View inflate = LayoutInflater.from(this.mProjectDetailActivity).inflate(R$layout.project_irc_load_footer, (ViewGroup) this.mRecyclerView.getFooterContainer(), false);
        this.footer = inflate;
        this.mRecyclerView.addFooterView(inflate);
        ViewGroup.LayoutParams layoutParams = this.footer.getLayoutParams();
        this.footerParam = layoutParams;
        layoutParams.height = 0;
    }

    private void initStatusBarViewListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991554799")) {
            ipChange.ipc$dispatch("991554799", new Object[]{this});
            return;
        }
        this.mProjectItemStatusHelper.r(new e0());
        this.mProjectItemStatusHelper.s(ProjectItemStatusHelper.a.a(this.mProjectId));
        this.mProjectItemStatusHelper.t(new g0());
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896304229")) {
            ipChange.ipc$dispatch("1896304229", new Object[]{this});
            return;
        }
        this.mTitleBarPanel = new ProjectTitleBarPanel(this.mProjectDetailActivity, this.rootView.findViewById(R$id.project_new_title), new f0());
        this.mContentRootLayout = (FrameLayout) this.rootView.findViewById(R$id.project_details_root_layout);
        this.mRvProjectDetailContent = (RelativeLayout) this.rootView.findViewById(R$id.project_item_bottom_content_rv);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isBottomTimerAndStrategyShowing() {
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView;
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15102997")) {
            return ((Boolean) ipChange.ipc$dispatch("-15102997", new Object[]{this})).booleanValue();
        }
        ProjectTimerAndStagoryView projectTimerAndStagoryView = this.timerAndStagoryView;
        if ((projectTimerAndStagoryView == null || !projectTimerAndStagoryView.isShowing()) && (((projectTimerAndStrategyTmPromptView = this.timerAndStrategyTmPromptView) == null || projectTimerAndStrategyTmPromptView.getVisibility() != 0) && ((projectSpecialBuyPromptView = this.specialBuyPromptView) == null || projectSpecialBuyPromptView.getVisibility() != 0))) {
            return false;
        }
        return true;
    }

    private boolean isChangeAttendees(int i2, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437208424")) {
            return ((Boolean) ipChange.ipc$dispatch("437208424", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z2)})).booleanValue();
        } else if (!StartConfig.isResetAttendeesOpen() || i2 == 0) {
            return false;
        } else {
            l8.a aVar = l8.Companion;
            if (aVar.b(String.valueOf(this.mProjectId), this.mActivity).length <= i2) {
                return false;
            }
            if (z2) {
                aVar.a(String.valueOf(this.mProjectId), this.mActivity);
            }
            return true;
        }
    }

    private boolean isFlowLimitedErrorCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782575763")) {
            return ((Boolean) ipChange.ipc$dispatch("782575763", new Object[]{this, str})).booleanValue();
        } else if (oz0.FAIL_SYS_TRAFFIC_LIMIT.equalsIgnoreCase(str) || "ANDROID_SYS_API_FLOW_LIMIT_LOCKED".equalsIgnoreCase(str)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFromHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493273018")) {
            return ((Boolean) ipChange.ipc$dispatch("493273018", new Object[]{this})).booleanValue();
        }
        ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData = this.mProjectExtraData;
        if (projectDetailExtrasData != null) {
            return "homepage".equals(projectDetailExtrasData.fromWhere);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isHotProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629879622")) {
            return ((Boolean) ipChange.ipc$dispatch("1629879622", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) {
            return false;
        }
        return "true".equalsIgnoreCase(this.mProjectStaticDataBean.getItemBase().getIsHotProject());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isLogin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1242994807")) {
            return LoginManager.k().q();
        }
        return ((Boolean) ipChange.ipc$dispatch("1242994807", new Object[]{this})).booleanValue();
    }

    private boolean isSoldOutAndNoUnpaid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257725999")) {
            return ((Boolean) ipChange.ipc$dispatch("1257725999", new Object[]{this})).booleanValue();
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            return "true".equalsIgnoreCase(projectItemDataBean.getIsSoldOutAndNoUnpaid());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showVIPCreditExchangeFragment$0(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965561863")) {
            ipChange.ipc$dispatch("965561863", new Object[]{this, vIPCreditExchangePopFragment, view});
            return;
        }
        dismissPopLayerFragment(vIPCreditExchangePopFragment);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showVIPCreditExchangeFragment$1(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141880392")) {
            ipChange.ipc$dispatch("141880392", new Object[]{this, vIPCreditExchangePopFragment, view});
            return;
        }
        dismissPopLayerFragment(vIPCreditExchangePopFragment);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void launchAliMe(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095891975")) {
            ipChange.ipc$dispatch("-1095891975", new Object[]{this, str});
            return;
        }
        String f2 = AliMeUtil.f(this.mAliMeFrom, str, String.valueOf(this.mProjectId), this.mClickedProblem);
        if (!xf2.j(f2)) {
            AliMeUtil.b(this.mActivity, f2);
        }
        resetAliMeClickData();
    }

    public static ProjectDetailItemMainFragment newInstance(ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119627317")) {
            return (ProjectDetailItemMainFragment) ipChange.ipc$dispatch("1119627317", new Object[]{projectDetailExtrasData});
        }
        ProjectDetailItemMainFragment projectDetailItemMainFragment = new ProjectDetailItemMainFragment();
        if (projectDetailExtrasData != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("projectExtraData", projectDetailExtrasData);
            projectDetailItemMainFragment.setArguments(bundle);
        }
        return projectDetailItemMainFragment;
    }

    private void novBackUtHandle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1273975343")) {
            ipChange.ipc$dispatch("1273975343", new Object[]{this});
            return;
        }
        viewIgnoreTagForExposure(this.mPopLayerFragment.getView());
        cn.damai.common.user.c.e().q(getActivity());
        cn.damai.common.user.c.e().p(this, getDamaiUTKeyBuilder());
        cn.damai.common.user.c.e().b(this.exposureViewList);
        this.exposureViewList.clear();
    }

    private void openSkuActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816110000")) {
            ipChange.ipc$dispatch("-816110000", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(NcovSkuActivity.KEY_SKUBEAN, this.mSkuBean);
        bundle.putString("itemId", this.mProjectId + "");
        bundle.putSerializable(NcovSkuActivity.KEY_PRIVILEGEID, this.mPrivilegeId);
        bundle.putString(NcovSkuActivity.KEY_ATOMSPLIT, this.atomSplit);
        bundle.putString(NcovSkuActivity.KEY_REMIND_TITLE, getCalendarRemindTitle());
        bundle.putLong(NcovSkuActivity.KEY_REMIND_SALE_TIME, getCalendSellTime());
        bundle.putLong(NcovSkuActivity.KEY_REMIND_COUNTDOWN, this.mProjectItemDataBean.getCountDown());
        SeatPreloadExtra.putPreloadExtraIfNeed(this.mSeatPreloadExtra, bundle);
        DMNav.from(this.mActivity).forResult(4129).withExtras(bundle).toUri(NavUri.b("sku"));
    }

    private void pauseRedPacket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482527467")) {
            ipChange.ipc$dispatch("-1482527467", new Object[]{this});
        } else if (this.mHasRegisterRedPacketMsg && !isHotProject() && !this.mProjectDetailActivity.isActivityFinsihed()) {
            CouponDialogHelper.l(this.mProjectDetailActivity).n();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void popupSkuByPerformInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1288980597")) {
            ipChange.ipc$dispatch("-1288980597", new Object[]{this});
            return;
        }
        ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
        if (projectItemStatusHelper != null && projectItemStatusHelper.h() != null) {
            this.mProjectItemStatusHelper.o(true);
            this.mProjectItemStatusHelper.h().performClick();
            this.mProjectItemStatusHelper.o(false);
        }
    }

    private void preloadRegionData() {
        ProjectItemDataBean projectItemDataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331805205")) {
            ipChange.ipc$dispatch("-1331805205", new Object[]{this});
            return;
        }
        if (!(OrangeConfigCenter.c().a("damai_seat_data_preload_switch", "damai_seat_data_preload", 1) == 1)) {
            this.mSeatPreloadExtra = null;
            return;
        }
        this.mSeatPreloadExtra = n72.a(this.mProjectId, this.mProjectStaticDataBean, this.mProjectItemDataBean);
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && projectStaticDataBean.getItemBase() != null && (projectItemDataBean = this.mProjectItemDataBean) != null && projectItemDataBean.getPerformBases() != null && this.mProjectItemDataBean.getPerformBases().size() != 0 && this.mProjectItemDataBean.getPerformBases().get(0).getPerforms() != null && this.mProjectItemDataBean.getPerformBases().get(0).getPerforms().size() != 0 && this.mProjectItemDataBean.getPerformBases().get(0).getPerforms().get(0).chooseSeatType == 1) {
            this.mProjectStaticDataBean.getItemBase().getNationalStandardCityId();
        }
    }

    private void processAutoShowSku(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919691510")) {
            ipChange.ipc$dispatch("1919691510", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (i2 != i3 && this.mPurchaseType == 4) {
            this.mPurchaseType = -1;
            popupSkuByPerformInfo();
        } else if (i2 == i3) {
            autoShowSkuLayer();
        } else {
            this.mPurchaseType = -1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processCalendarRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551539456")) {
            ipChange.ipc$dispatch("551539456", new Object[]{this});
        } else if (enableCalenderRemind()) {
            qt1.e(this.mProjectDetailActivity, getCalendarRemindTitle(), getCalendSellTime(), this.calendRemindMeListener);
        } else {
            qt1.f(this.mProjectDetailActivity, "抱歉，不能添加日历提醒", "距开抢前10分钟不能添加日历提醒，请实时关注商品动态");
        }
    }

    private void processClickNotRefreshAfterCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474726110")) {
            ipChange.ipc$dispatch("-1474726110", new Object[]{this});
        } else if (isLogin()) {
            getSubProjectDectailCheckData();
        } else {
            startLoginActivityForResult(4119);
        }
    }

    private void processClickSaleRemindStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818844479")) {
            ipChange.ipc$dispatch("-818844479", new Object[]{this});
        } else if (isLogin()) {
            showPerformListFragment(true);
        } else {
            startLoginActivityForResult(4120);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processTimeCountDownClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110544991")) {
            ipChange.ipc$dispatch("110544991", new Object[]{this});
        } else if (this.mHasCountDownFinished) {
            processClickNotRefreshAfterCountDown();
        } else {
            processClickSaleRemindStatus();
        }
    }

    private void recordProjectEnterCount(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419077871")) {
            ipChange.ipc$dispatch("-1419077871", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        HashMap<Long, Integer> hashMap = projectEnterCountMap;
        if (hashMap.containsKey(Long.valueOf(j2))) {
            for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
                if (entry.getKey().longValue() == j2) {
                    projectEnterCountMap.put(Long.valueOf(j2), Integer.valueOf(entry.getValue().intValue() + 1));
                }
            }
            return;
        }
        hashMap.put(Long.valueOf(j2), 1);
    }

    private void registerMessageObserver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525544472")) {
            ipChange.ipc$dispatch("1525544472", new Object[]{this});
            return;
        }
        this.mDMMessage.b("evaluate_praise", new t0());
    }

    private void registerRedPacketMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640164775")) {
            ipChange.ipc$dispatch("640164775", new Object[]{this});
            return;
        }
        if (!this.mHasRegisterRedPacketMsg && !isHotProject() && !this.mProjectDetailActivity.isActivityFinsihed()) {
            this.mHasRegisterRedPacketMsg = true;
            CouponDialogHelper.l(this.mProjectDetailActivity).r(this.mDMMessage);
        }
        resumeRedPacket();
    }

    private void removeShotListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413275162")) {
            ipChange.ipc$dispatch("-413275162", new Object[]{this});
            return;
        }
        ScreenShotDetector.k().x(null);
    }

    private void reportProjectCouponPromotionUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-714485759")) {
            ipChange.ipc$dispatch("-714485759", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && projectStaticDataBean.getItemBase() != null && this.mProjectItemDataBean != null) {
            long itemId = this.mProjectStaticDataBean.getItemBase().getItemId();
            String itemCouponIds = this.mProjectItemDataBean.getItemCouponIds();
            String itemPromotionIds = this.mProjectItemDataBean.getItemPromotionIds();
            String privilegeActivityIds = this.mProjectItemDataBean.getPrivilegeActivityIds();
            if (!TextUtils.isEmpty(itemCouponIds) || !TextUtils.isEmpty(itemPromotionIds) || !TextUtils.isEmpty(privilegeActivityIds)) {
                ln2.r().T1(itemId, itemPromotionIds, itemCouponIds, privilegeActivityIds);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportProjectNotExitsFromHome() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355580994")) {
            ipChange.ipc$dispatch("355580994", new Object[]{this});
        } else if (isFromHomePage()) {
            ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
            if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) {
                str = "";
            } else {
                str = this.mProjectStaticDataBean.getItemBase().getItemName();
            }
            ProjectDetailXFlushUtil.o(String.valueOf(this.mProjectId), str, "mtop.alibaba.damai.detail.getdetail", "", "");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @RequiresApi(api = 11)
    private void requestFavorite(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902743213")) {
            ipChange.ipc$dispatch("902743213", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        this.isFlowByBottomBar = z2;
        if (isLogin()) {
            ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
            if (projectDynamicExtDataBean != null ? projectDynamicExtDataBean.isSubFlag() : false) {
                this.mViewProjectFollow.cancelAnimate();
                cn.damai.common.user.c.e().x(ln2.r().h0(this.mProjectId, false));
                updateProjectFollowRelation(0);
                return;
            }
            this.mViewProjectFollow.clickAnimate();
            cn.damai.common.user.c.e().x(ln2.r().h0(this.mProjectId, true));
            updateProjectFollowRelation(1);
            return;
        }
        cn.damai.common.user.c.e().x(ln2.r().h0(this.mProjectId, false));
        startLoginActivityForResult(4097);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetAliMeClickData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050856313")) {
            ipChange.ipc$dispatch("-1050856313", new Object[]{this});
            return;
        }
        this.mClickedProblem = "";
        this.mAliMeFrom = "";
    }

    private void resetProjectPerformData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123578863")) {
            ipChange.ipc$dispatch("-123578863", new Object[]{this});
            return;
        }
        this.mPerformDataConfigure.d(this.mProjectId);
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            this.mPerformDataConfigure.g(projectItemDataBean.getPerformBases());
        }
        this.mPerformDataConfigure.e(null);
        this.mPerformDataConfigure.f(null);
    }

    private void resumeRedPacket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641006618")) {
            ipChange.ipc$dispatch("-1641006618", new Object[]{this});
        } else if (this.mHasRegisterRedPacketMsg && !isHotProject() && !this.mProjectDetailActivity.isActivityFinsihed()) {
            CouponDialogHelper.l(this.mProjectDetailActivity).B(ta.PROJECT_PAGE, String.valueOf(this.mProjectId));
            CouponDialogHelper.l(this.mProjectDetailActivity).o();
        }
    }

    private void saveHotSellStartTime() {
        ProjectItemDataBean projectItemDataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734967371")) {
            ipChange.ipc$dispatch("734967371", new Object[]{this});
        } else if (isHotProject() && (projectItemDataBean = this.mProjectItemDataBean) != null) {
            d20.V(projectItemDataBean.getSellStartTime());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollToPosition(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2047428633")) {
            ipChange.ipc$dispatch("-2047428633", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.mRecyclerView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        this.mLinearLayoutManager.scrollToPositionWithOffset(i2, i3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollToRecommend() {
        AnchorManager anchorManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141454590")) {
            ipChange.ipc$dispatch("141454590", new Object[]{this});
        } else if (hasRecommendProject() && (anchorManager = this.mAnchorManager) != null) {
            AnchorManager.AnchorType anchorType = AnchorManager.AnchorType.RECOMMEND;
            if (anchorManager.c(anchorType) != null) {
                a5 c2 = this.mAnchorManager.c(anchorType);
                clickedAnchorItem(c2.b(), c2);
            }
        }
    }

    private void sendHandlerMessage(int i2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902429652")) {
            ipChange.ipc$dispatch("902429652", new Object[]{this, Integer.valueOf(i2), Long.valueOf(j2)});
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = i2;
        this.mHandler.sendMessageDelayed(obtainMessage, j2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAliMeParams(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610412978")) {
            ipChange.ipc$dispatch("1610412978", new Object[]{this, str, str2});
            return;
        }
        this.mAliMeFrom = str;
        this.mClickedProblem = str2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCurAnchorPosition(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "949100615")) {
            ipChange.ipc$dispatch("949100615", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.mAnchorManager.n(i2);
        this.mAnchorIndicator.setSelectAnchor(i2);
        this.mAnchorIndicatorFixed.setSelectAnchor(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProjectDetailMaskLayerImage(String str, Bitmap bitmap, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240320202")) {
            ipChange.ipc$dispatch("1240320202", new Object[]{this, str, bitmap, Boolean.valueOf(z2)});
            return;
        }
        if (z2) {
            this.mIvProjectPosterMask.setBackgroundColor(Color.parseColor("#000000"));
        } else if (str != null) {
            try {
                DMRGBUtil.g(1.0f, bitmap, str, new c0());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mSinaSharePath = wt1.b(str, bitmap, this.mProjectDetailActivity);
        }
    }

    private void setProjectFollowStatus(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000319562")) {
            ipChange.ipc$dispatch("-1000319562", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null) {
            projectDynamicExtDataBean.setSubFlag(z2);
        }
    }

    private void setRemindTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845235330")) {
            ipChange.ipc$dispatch("-845235330", new Object[]{this});
        } else if (enableCalenderRemind()) {
            el2.b().k(this.mProjectItemDataBean.getCountDown());
        } else {
            el2.b().a();
        }
    }

    private void setSeatImageAndAtomSplit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091471054")) {
            ipChange.ipc$dispatch("-2091471054", new Object[]{this});
            return;
        }
        ProjectStaticItemBaseBean itemBase = this.mProjectStaticDataBean.getItemBase();
        if (itemBase != null) {
            this.atomSplit = itemBase.getAtomSplit() + "";
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190709866")) {
            ipChange.ipc$dispatch("-190709866", new Object[]{this});
            return;
        }
        this.mFlMoreRecommendFloatLayer.setOnClickListener(this.mOnMoreRecommendClickListener);
        this.mIvCloseMoreRecommend.setOnClickListener(this.mOnCloseMoreRecommendClickListener);
        this.mViewProjectFollow.setOnClickListener(this.mOnProjectFollowClickListener);
        this.mProjectItemDetailAdapter.h(this.mOnExtendInfoImageItemClickListener);
        this.mProjectItemDetailAdapter.j(this.mOnRecommendItemClickListener);
        this.mProjectItemDetailAdapter.i(this.mOnProjectCommonProblemListener);
        this.mProjectItemDetailAdapter.f(this.mOnEvaluateMineListener);
        this.mProjectItemDetailAdapter.e(this.mOnDiscussionClickListener);
        this.mProjectItemDetailAdapter.g(this.mOnSectionMoreClickListener);
        this.mProjectItemDetailAdapter.k(this.mShareManagerImpl);
        this.mProjectItemDetailAdapter.d(new s());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showCouponPromotionFragment() {
        String str;
        List<PromotionGroupBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069038622")) {
            ipChange.ipc$dispatch("-2069038622", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            PromotionBean promotionBean = projectItemDataBean.promotionDetail;
            if (promotionBean != null) {
                List<PromotionGroupBean> list2 = promotionBean.promotionGroupList;
                str = promotionBean.promotionRemark;
                list = list2;
            } else {
                list = null;
                str = null;
            }
            this.mPopLayerFragment = NcovPromotionFragment.instance(new PromotionDataBean("preferentialexplain", this.mProjectId, list, str, null, null), new a0());
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setVisibility(0);
            Log.e("xxxxx_fragment_ut", "detail pageDisAppear before");
            cn.damai.common.user.c.e().q(getActivity());
            this.exposureViewList = viewIgnoreTagForExposure(getActivity().getWindow().getDecorView());
            Log.e("xxxxx_fragment_ut", "detail pageDisAppear after");
        }
    }

    private void showFixedAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927931115")) {
            ipChange.ipc$dispatch("-927931115", new Object[]{this});
            return;
        }
        this.isShowFixAnchorIndicator = true;
        this.mAnchorIndicatorFixed.setVisibility(0);
        this.mHeadDividerLine.setVisibility(0);
    }

    private void showFlowLimitedDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663233435")) {
            ipChange.ipc$dispatch("663233435", new Object[]{this});
            return;
        }
        DMDialog dMDialog = new DMDialog(getActivity());
        dMDialog.setCanceledOnTouchOutside(false);
        dMDialog.setCancelable(true);
        dMDialog.v("排队的人数太多啦").q("抱歉，当前排队人数太多啦，实在挤不进去了，请稍后再进行尝试").i(hasRecommendProject() ? "看看别的" : "", new s0()).n("努力刷新", new r0()).j(true).show();
    }

    private void showNewScreenShotShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028661314")) {
            ipChange.ipc$dispatch("2028661314", new Object[]{this});
            return;
        }
        this.popupWindow = new ScreenShotImgShare().j(this.mProjectId, this.mProjectDetailDataBean, this.mRankInfo, this.mContentRootLayout, this.mProjectItemDetailAdapter, this.viewCreater, getActivity());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showNoticeFragment(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106614672")) {
            ipChange.ipc$dispatch("106614672", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && projectStaticDataBean.getNoticeMatter() != null && this.mProjectStaticDataBean.getNoticeMatter().getNoticeList() != null) {
            this.mPopLayerFragment = ProjectNoticeMatterFragment.newInstance(this.mProjectId, i2, this.mProjectStaticDataBean.getNoticeMatter());
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setVisibility(0);
            this.mFlvPopupLayer.setOnClickListener(new o0());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPerformListFragment(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-540137036")) {
            ipChange.ipc$dispatch("-540137036", new Object[]{this, Boolean.valueOf(z2)});
        } else if (isLogin()) {
            openSkuActivity();
        } else {
            startLoginActivityForResult(4101);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPrivilegeCodeVerifyFragment(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115321189")) {
            ipChange.ipc$dispatch("-2115321189", new Object[]{this, Integer.valueOf(i2)});
        } else if (isLogin()) {
            ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
            if (projectItemDataBean != null) {
                this.mPrivilegeCodeVerifyFragment = PrivilegeCodeVerifyFragment.newInstance(this.mProjectId, projectItemDataBean.getPrivilegeId(), i2);
                FragmentTransaction fragmentTransaction = getFragmentTransaction();
                fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPrivilegeCodeVerifyFragment);
                fragmentTransaction.commitAllowingStateLoss();
                this.mFlvPopupLayer.setOnClickListener(new i0());
                this.mFlvPopupLayer.setVisibility(0);
            }
        } else {
            startLoginActivityForResult(4102);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showProjectNoticeFragment() {
        ProjectNotice projectNotice;
        NoticeListBean noticeListBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1373636526")) {
            ipChange.ipc$dispatch("1373636526", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && (noticeListBean = projectStaticDataBean.announcementVO) != null) {
            ArrayList<ItemContent> subItemContentList = noticeListBean.subItemContentList();
            NoticeDetailFragment instance = NoticeDetailFragment.instance(subItemContentList, this.mProjectId + "");
            this.detailFragment = instance;
            instance.setClose(new t());
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.detailFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setOnClickListener(new v());
            this.mFlvPopupLayer.setVisibility(0);
        } else if (projectStaticDataBean != null && (projectNotice = projectStaticDataBean.announcementMsg) != null) {
            StatusNotice statusNotice = new StatusNotice();
            statusNotice.setPopupTitle(projectNotice.name);
            statusNotice.setPopupContent(projectNotice.content);
            statusNotice.imageUrl = projectNotice.imageUrl;
            this.mPopLayerFragment = ProjectNotificationFragment.newInstance(statusNotice);
            FragmentTransaction fragmentTransaction2 = getFragmentTransaction();
            fragmentTransaction2.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
            fragmentTransaction2.commitAllowingStateLoss();
            this.mFlvPopupLayer.setOnClickListener(new w());
            this.mFlvPopupLayer.setVisibility(0);
        }
    }

    private void showSkeleton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483061970")) {
            ipChange.ipc$dispatch("-1483061970", new Object[]{this});
            return;
        }
        this.skeletonScreen = rb2.a(this.rootView).j(R$layout.activity_project_skeleton).i(1500).h(R$color.color_mater_66).g(10).k();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSreenSharePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "648037628")) {
            ipChange.ipc$dispatch("648037628", new Object[]{this});
        } else if (getActivity() != null && !getActivity().isFinishing()) {
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 == null || !popupWindow2.isShowing()) {
                p42.f().j();
                showNewScreenShotShare();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSupportServicePopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827072213")) {
            ipChange.ipc$dispatch("1827072213", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        StatusNotice j2 = gb.j(this.mProjectItemDataBean);
        if (j2 != null && j2.isHasPopup()) {
            ServiceNote serviceNote = new ServiceNote();
            serviceNote.isSupport = "false";
            String prefixText = j2.getPrefixText();
            if (TextUtils.isEmpty(prefixText)) {
                prefixText = PurchaseConstants.NORMAL_WARNING_TITLE;
            }
            serviceNote.tagName = prefixText;
            serviceNote.tagDesc = j2.getPopupContent();
            arrayList.add(serviceNote);
        }
        List<ServiceNote> i2 = gb.i(this.mProjectStaticDataBean);
        if (!f92.d(i2)) {
            arrayList.addAll(i2);
        }
        if (!f92.d(arrayList)) {
            this.mPopLayerFragment = ProjectSupportServiceFragment.newInstance(arrayList, gb.b(this.mProjectStaticDataBean));
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setOnClickListener(new b0());
            this.mFlvPopupLayer.setVisibility(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    private void showTipsOnWantSeeClick() {
        String str;
        String str2;
        NullPointerException e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13185121")) {
            ipChange.ipc$dispatch("-13185121", new Object[]{this});
            return;
        }
        try {
            str2 = this.mProjectDynamicExtDataBean.wantVO.getTips();
            try {
                str = this.mProjectDynamicExtDataBean.wantVO.tipsTitle;
            } catch (NullPointerException e3) {
                e2 = e3;
            }
        } catch (NullPointerException e4) {
            e2 = e4;
            str2 = null;
            e2.printStackTrace();
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            showWantTips();
        } else if (xf2.j(str2)) {
            ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
            if (projectItemStatusHelper != null && projectItemStatusHelper.j(this.mProjectItemDataBean) && !wj1.b(getContext()) && this.mActivity != null) {
                DMThemeDialog dMThemeDialog = new DMThemeDialog(this.mActivity);
                long currentTimeMillis = System.currentTimeMillis();
                dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION);
                dMThemeDialog.k("我们将第一时间为您送上独家消息提醒～");
                dMThemeDialog.n(R$string.damai_detail_wantsee_click_message);
                dMThemeDialog.g(true, null);
                dMThemeDialog.i("开启提醒", new k0());
                dMThemeDialog.setOnDismissListener(new l0(currentTimeMillis));
                dMThemeDialog.show();
            } else if (!cy2.INSTANCE.e(this.mActivity, this.mGuideUtProvider)) {
                ToastUtil.k("想看成功", getString(R$string.damai_detail_wantsee_click_message), R$raw.toast_lottie_peach_heart);
            }
        } else if (this.isFlowByBottomBar) {
            showWantTips(str2);
        } else if (!cy2.INSTANCE.e(this.mActivity, this.mGuideUtProvider)) {
            ToastUtil.k("想看成功", getString(R$string.damai_detail_wantsee_click_message), R$raw.toast_lottie_peach_heart);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showVIPCreditExchangeFragment() {
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822461254")) {
            ipChange.ipc$dispatch("822461254", new Object[]{this});
            return;
        }
        ProjectDetailDataBean projectDetailDataBean = this.mProjectDetailDataBean;
        if (projectDetailDataBean != null && (projectDynamicExtDataBean = projectDetailDataBean.dynamicExtData) != null && (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) != null) {
            VIPCreditExchangePopFragment a2 = VIPCreditExchangePopFragment.Companion.a(projectMemberPrompt, new z());
            a2.setCloseListener(new rt1(this, a2));
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, a2);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setVisibility(0);
            this.mFlvPopupLayer.setOnClickListener(new st1(this, a2));
        }
    }

    private void showWantTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206438595")) {
            ipChange.ipc$dispatch("-1206438595", new Object[]{this, str});
        } else if (!cy2.INSTANCE.e(this.mActivity, this.mGuideUtProvider)) {
            WantSeeGuideTips wantSeeGuideTips2 = this.wantSeeGuideTips;
            if (wantSeeGuideTips2 != null && wantSeeGuideTips2.getVisibility() == 0) {
                this.wantSeeGuideTips.cancel();
            }
            View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.layout_want_see_bottombar_tip, (ViewGroup) null);
            HtmlView htmlView = (HtmlView) inflate.findViewById(R$id.want_see_bottom_bar_tips_html_view_below);
            htmlView.init();
            HtmlView.setTextOneLine(true);
            htmlView.loadHtml(str);
            if (this.mProjectItemStatusHelper.j(this.mProjectItemDataBean)) {
                inflate.findViewById(R$id.ic_wantsee_tips_arrow).setVisibility(4);
            }
            this.mWantTipsContainer.addView(inflate);
            this.mWantTipsContainer.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
            translateAnimation.setDuration(300);
            inflate.startAnimation(translateAnimation);
            View findViewById = inflate.findViewById(R$id.want_see_bottombar_tip_close);
            inflate.findViewById(R$id.want_see_bottombar_tip_bg).setOnClickListener(new m0(this));
            findViewById.setOnClickListener(new n0());
            inflate.postDelayed(new Runnable() {
                /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment.AnonymousClass48 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1915130147")) {
                        ipChange.ipc$dispatch("-1915130147", new Object[]{this});
                        return;
                    }
                    ProjectDetailItemMainFragment.this.mWantTipsContainer.removeAllViews();
                    ProjectDetailItemMainFragment.this.mWantTipsContainer.setVisibility(8);
                }
            }, 10000);
            ln2.r().V1(inflate, String.valueOf(this.mProjectId), this.mButtomText);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startLoginActivityForResult(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897776417")) {
            ipChange.ipc$dispatch("897776417", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        LoginManager.k().y(this, new Intent(), i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startSreenShotPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818893758")) {
            ipChange.ipc$dispatch("-818893758", new Object[]{this});
        } else if (getActivity() != null && !getActivity().isFinishing()) {
            p42.f().i();
            Bundle bundle = new Bundle();
            bundle.putSerializable("screen_shot_info", ScreenShotDetector.k().l());
            DMNav.from(getActivity()).withExtras(bundle).toUri(NavUri.b("screen_float"));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startWantSeeGuideTimer(WantSeeGuideTips.b bVar) {
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        ProjectWantSeeBean projectWantSeeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052910826")) {
            ipChange.ipc$dispatch("1052910826", new Object[]{this, bVar});
        } else if (jy2.INSTANCE.c() && (projectDynamicExtDataBean = this.mProjectDynamicExtDataBean) != null && (projectWantSeeBean = projectDynamicExtDataBean.wantVO) != null && !projectWantSeeBean.isSubFlag() && !WantSeeGuideTips.Companion.a()) {
            CountDownTimer countDownTimer = this.wantSeeGuideTipsTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            w0 w0Var = new w0(3000, 1000, bVar);
            this.wantSeeGuideTipsTimer = w0Var;
            w0Var.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void strategyClick() {
        ProjectTicketGuideBean projectTicketGuideBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454120829")) {
            ipChange.ipc$dispatch("454120829", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && (projectTicketGuideBean = projectStaticDataBean.ticketPurchasesGuidePage) != null && !TextUtils.isEmpty(projectTicketGuideBean.purchaseGuideUrl)) {
            VenueBean venue = this.mProjectStaticDataBean.getVenue();
            if (venue != null) {
                venue.notMainLandProject();
            }
            setRemindTime();
            DMNav.from(this.mProjectDetailActivity).toUri(this.mProjectStaticDataBean.ticketPurchasesGuidePage.purchaseGuideUrl);
        }
    }

    private boolean supportImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1619843617")) {
            return Build.VERSION.SDK_INT >= 23;
        }
        return ((Boolean) ipChange.ipc$dispatch("1619843617", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void timeCountDownFinished() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710139364")) {
            ipChange.ipc$dispatch("-1710139364", new Object[]{this});
        } else if (this.mProjectDynamicExtDataBean.memberPrompt != null) {
            startProgressDialog();
            onRefresh();
        } else {
            if (!(this.mProjectItemDataBean == null || this.mProjectItemStatusHelper == null)) {
                updateCountDownVisibility(false, true);
                String buyBtnTextAfterCountDown = this.mProjectItemDataBean.getBuyBtnTextAfterCountDown();
                if (!TextUtils.isEmpty(buyBtnTextAfterCountDown)) {
                    this.mProjectItemDataBean.setBuyBtnText(buyBtnTextAfterCountDown);
                } else {
                    this.mProjectItemDataBean.setBuyBtnText("立即购买");
                }
                ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
                projectItemDataBean.setBuyBtnTip(projectItemDataBean.getBuyBtnTipAfterCountDown());
                try {
                    int parseInt = Integer.parseInt(this.mProjectItemDataBean.getBuyBtnStatusAfterCountDown());
                    if (parseInt == 224 || parseInt == 223 || parseInt == 88 || parseInt == 87) {
                        this.mProjectItemDataBean.setBuyBtnStatus(parseInt);
                    }
                } catch (Exception unused) {
                }
                this.mProjectItemStatusHelper.u(this.mProjectItemDataBean);
                updatePageUT();
            }
            closeSkuActivity();
        }
    }

    private boolean toDisplayErrorPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-469120788")) {
            return this.mProjectStaticDataBean == null && this.mProjectDynamicExtDataBean == null && this.mProjectItemDataBean == null;
        }
        return ((Boolean) ipChange.ipc$dispatch("-469120788", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void toMarketStall() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316552585")) {
            ipChange.ipc$dispatch("1316552585", new Object[]{this});
            return;
        }
        MarketingStallBean d2 = gb.d(this.mProjectItemDataBean);
        if (d2 != null) {
            int i2 = d2.interactiveMode;
            if (i2 == 2) {
                if (!isLogin()) {
                    cn.damai.common.user.c.e().x(ln2.r().U0(this.mProjectId, d2.utd));
                    startLoginActivityForResult(4118);
                }
            } else if (i2 == 3) {
                cn.damai.common.user.c.e().x(ln2.r().U0(this.mProjectId, d2.utd));
                tt1.d(this.mProjectDetailActivity, d2.forwardUrl);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void toRankListPage() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891268580")) {
            ipChange.ipc$dispatch("1891268580", new Object[]{this});
            return;
        }
        RankInfo rankInfo = this.mRankInfo;
        if (rankInfo != null) {
            str = rankInfo.getId();
        } else {
            ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
            str = (projectStaticDataBean == null || projectStaticDataBean.getRankListVO() == null) ? "" : this.mProjectStaticDataBean.getRankListVO().getId();
        }
        tt1.c(this.mProjectDetailActivity, this.mProjectId, xf2.m(str, 0));
    }

    private void updateAnchorData() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-76684368")) {
            ipChange.ipc$dispatch("-76684368", new Object[]{this});
            return;
        }
        AnchorManager anchorManager = this.mAnchorManager;
        if (anchorManager == null || xf2.e(anchorManager.d()) <= 1) {
            this.isShowAnchor = false;
            this.mAnchorIndicator.setVisibility(8);
            hideFixedAnchorIndicator();
            return;
        }
        this.isShowAnchor = true;
        this.mAnchorIndicator.setVisibility(0);
        this.mAnchorIndicatorFixed.setVisibility(this.isShowFixAnchorIndicator ? 0 : 8);
        View view = this.mHeadDividerLine;
        if (!this.isShowFixAnchorIndicator) {
            i2 = 8;
        }
        view.setVisibility(i2);
        List<a5> d2 = this.mAnchorManager.d();
        this.mAnchorIndicator.setAnchorList(d2);
        this.mAnchorIndicatorFixed.setAnchorList(d2);
        setCurAnchorPosition(this.mAnchorManager.f());
        this.mAnchorManager.m(d2, this.mAnchorIndicator, String.valueOf(this.mProjectId));
    }

    private void updateCalendRemindText(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101370716")) {
            ipChange.ipc$dispatch("-1101370716", new Object[]{this, Boolean.valueOf(z2)});
        } else if (z2) {
            if (!hp1.i(lp1.CALENDAR)) {
                this.timerAndStagoryView.updateRemindMeBtnText(false);
                return;
            }
            this.timerAndStagoryView.updateRemindMeBtnText(qt1.d(this.mProjectDetailActivity, getCalendarRemindTitle(), getCalendSellTime()));
        }
    }

    private void updateCountDownVisibility(boolean z2, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062796936")) {
            ipChange.ipc$dispatch("-1062796936", new Object[]{this, Boolean.valueOf(z2), Boolean.valueOf(z3)});
        } else if (this.timerAndStagoryView != null) {
            updateCalendRemindText(z2);
            updateRecyclerMargin(this.timerAndStagoryView.setCountDownVisibility(z2, z3, this.mDialogPanel.o(), isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), z2)));
        }
    }

    private void updateDetailDataHoldersAndTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1160125265")) {
            ipChange.ipc$dispatch("1160125265", new Object[]{this});
            return;
        }
        List<ProjectDataHolder> p2 = this.mProjectDataHolderManager.p(this.mProjectStaticDataBean, this.mProjectDynamicExtDataBean, this.mProjectDetailEvaluateBean, this.mProjectDetailDiscussionBean, this.mRecommendItems, this.mProjectItemDataBean, String.valueOf(this.mProjectId));
        if (xf2.e(p2) > 0) {
            this.mProjectItemDetailAdapter.c(p2);
        }
        updateAnchorData();
    }

    private void updateMemberPromptCountDownVisibility(boolean z2, boolean z3) {
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286517450")) {
            ipChange.ipc$dispatch("-286517450", new Object[]{this, Boolean.valueOf(z2), Boolean.valueOf(z3)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean == null || (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) == null || !projectMemberPrompt.isSpecialBuy()) {
            ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView = this.timerAndStrategyTmPromptView;
            if (projectTimerAndStrategyTmPromptView != null) {
                updateRecyclerMargin(projectTimerAndStrategyTmPromptView.setCountDownVisibility(z2, z3, this.mProjectDynamicExtDataBean.memberPrompt, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), z2)));
                return;
            }
            return;
        }
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView = this.specialBuyPromptView;
        if (projectSpecialBuyPromptView != null) {
            updateRecyclerMargin(projectSpecialBuyPromptView.setCountDownVisibility(z2, z3, this.mProjectDynamicExtDataBean.memberPrompt, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), false)));
        }
    }

    private void updateMemberPromptTimeCountDownStatus() {
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128784253")) {
            ipChange.ipc$dispatch("-1128784253", new Object[]{this});
        } else if (this.mProjectItemDataBean == null || (projectDynamicExtDataBean = this.mProjectDynamicExtDataBean) == null || projectDynamicExtDataBean.memberPrompt == null) {
            updateMemberPromptCountDownVisibility(false, false);
        } else {
            long a2 = (long) xl2.a();
            if (this.mProjectDynamicExtDataBean.memberPrompt.isSpecialBuy()) {
                this.specialBuyPromptView.setItemName(getCalendarRemindTitle());
                long scd = this.mProjectDynamicExtDataBean.memberPrompt.getScd();
                if (scd <= 0) {
                    updateMemberPromptCountDownVisibility(true, false);
                } else if (scd > a2) {
                    updateMemberPromptCountDownVisibility(true, false);
                } else {
                    this.mHasCountDownFinished = true;
                    timeCountDownFinished();
                }
            } else {
                this.timerAndStrategyTmPromptView.setItemName(getCalendarRemindTitle());
                if (this.mProjectDynamicExtDataBean.memberPrompt.isPromptBeforeSale()) {
                    j2 = this.mProjectDynamicExtDataBean.memberPrompt.getScd();
                } else {
                    j2 = this.mProjectDynamicExtDataBean.memberPrompt.getLaunchScd();
                }
                if (j2 <= 0) {
                    updateMemberPromptCountDownVisibility(false, false);
                } else if (j2 > a2) {
                    long j3 = j2 - a2;
                    if (this.mMemberPromptOnTimeCountDownListener == null) {
                        this.mMemberPromptOnTimeCountDownListener = new x();
                    }
                    if (this.mMemberPromptTimeCountDownManager == null) {
                        this.mMemberPromptTimeCountDownManager = TimeCountDownManagerImpl.c(this.mMemberPromptOnTimeCountDownListener);
                    }
                    updateMemberPromptCountDownVisibility(true, false);
                    this.mMemberPromptTimeCountDownManager.setCountDown(j3);
                    this.mMemberPromptTimeCountDownManager.startCountDown();
                } else {
                    this.mHasCountDownFinished = true;
                    timeCountDownFinished();
                }
            }
        }
    }

    private void updateMoreRecommendVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436898594")) {
            ipChange.ipc$dispatch("436898594", new Object[]{this});
        } else if (!isSoldOutAndNoUnpaid() || !hasRecommendProject() || this.mHasClosedMoreRecommend) {
            this.mFlMoreRecommendFloatLayer.setVisibility(8);
        } else {
            this.mFlMoreRecommendFloatLayer.setVisibility(0);
        }
    }

    private void updatePageUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484008223")) {
            ipChange.ipc$dispatch("-1484008223", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            String buyBtnText = projectItemDataBean.getBuyBtnText();
            if (TextUtils.isEmpty(this.mButtomText)) {
                this.mButtomText = buyBtnText;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("project_post_status", buyBtnText);
            hashMap.put("project_pre_status", this.mButtomText);
            a.b bVar = new a.b();
            bVar.d(String.valueOf(this.mProjectId)).i(ta.PROJECT_PAGE).j(hashMap);
            cn.damai.common.user.c.e().l(getActivity(), bVar);
        }
    }

    private void updateProjectBasicInfo() {
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1866167604")) {
            ipChange.ipc$dispatch("-1866167604", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null) {
            ProjectStaticItemBaseBean itemBase = projectStaticDataBean.getItemBase();
            if (itemBase != null) {
                String projectPosterUrl = getProjectPosterUrl();
                String itemName = itemBase.getItemName();
                String subTitle = itemBase.getSubTitle();
                ProjectItemDetailAdapter projectItemDetailAdapter = this.mProjectItemDetailAdapter;
                if (!TextUtils.isEmpty(subTitle)) {
                    itemName = subTitle;
                }
                projectItemDetailAdapter.l(itemName, projectPosterUrl);
                updateProjectName();
            }
            if (this.mTitleBarPanel != null) {
                int e2 = xf2.e(gb.l(this.mProjectDynamicExtDataBean));
                ProjectTitleBarPanel projectTitleBarPanel = this.mTitleBarPanel;
                if (e2 > 0) {
                    z2 = true;
                }
                projectTitleBarPanel.g(z2);
            }
        }
    }

    private void updateProjectFollowRelation(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622121714")) {
            ipChange.ipc$dispatch("-622121714", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        ((ProjectItemPresenter) this.mPresenter).updateProjectFollowRelation(i2, this.mProjectId, 7);
    }

    private void updateProjectFollowStatus(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895987038")) {
            ipChange.ipc$dispatch("-1895987038", new Object[]{this, followDataBean});
        } else if (followDataBean.getStatus() >= 1) {
            showTipsOnWantSeeClick();
            setProjectFollowStatus(true);
            updateWantSeeByFollow(true);
        } else {
            setProjectFollowStatus(false);
            updateWantSeeByFollow(false);
        }
    }

    private void updateProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "554725975")) {
            ipChange.ipc$dispatch("554725975", new Object[]{this});
            return;
        }
        this.mTitleBarPanel.k("商品详情");
    }

    private void updateProjectPurchaseBtnStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662553925")) {
            ipChange.ipc$dispatch("-662553925", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            this.mPerformDataConfigure.g(projectItemDataBean.getPerformBases());
            this.mPerformDataConfigure.d(this.mProjectId);
        }
        initBottomProjectStatusBarView(this.mProjectItemDataBean);
        this.mLvBottomBar.setVisibility(0);
    }

    private void updateProjectStaticData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213094090")) {
            ipChange.ipc$dispatch("1213094090", new Object[]{this});
        } else if (this.mProjectStaticDataBean != null) {
            updateProjectBasicInfo();
            setSeatImageAndAtomSplit();
            updateStrategyVisibility();
        }
    }

    private void updateRecyclerMargin(ProjectTimerAndStagoryView.StateEnum stateEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-992210588")) {
            ipChange.ipc$dispatch("-992210588", new Object[]{this, stateEnum});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) damaiRootRecyclerView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.footerParam;
            layoutParams2.height = 0;
            if (stateEnum == ProjectTimerAndStagoryView.StateEnum.TIMER) {
                if (this.mProjectDynamicExtDataBean.memberPrompt != null) {
                    layoutParams.bottomMargin = this.mDefaultRVMarginBottom;
                    layoutParams2.height = n42.a(getContext(), 68.0f);
                    this.mBottomLineView.setVisibility(0);
                } else {
                    layoutParams.bottomMargin = this.mTimerRVMarginBottom;
                    this.mBottomLineView.setVisibility(8);
                }
            } else if (stateEnum == ProjectTimerAndStagoryView.StateEnum.STAGORY) {
                layoutParams.bottomMargin = this.mSingleStagoryMargin;
                this.mBottomLineView.setVisibility(8);
            } else {
                layoutParams.bottomMargin = this.mDefaultRVMarginBottom;
                this.mBottomLineView.setVisibility(0);
            }
            this.mRecyclerView.setLayoutParams(layoutParams);
        }
    }

    private void updateRefreshable() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122412870")) {
            ipChange.ipc$dispatch("2122412870", new Object[]{this});
            return;
        }
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition == null) {
                i2 = 0;
            } else {
                i2 = Math.abs(findViewByPosition.getTop());
            }
            if (i2 == 0) {
                this.mLinearPullToRefreshView.setPullToRefreshEnabled(true);
            } else {
                this.mLinearPullToRefreshView.setPullToRefreshEnabled(false);
            }
        } else {
            this.mLinearPullToRefreshView.setPullToRefreshEnabled(false);
        }
    }

    private void updateScreenShot() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59567305")) {
            ipChange.ipc$dispatch("59567305", new Object[]{this});
            return;
        }
        ScreenShotDetector.k().x(null);
        ScreenShotDetector.k().x(this.extraListener);
    }

    private void updateStrategyVisibility() {
        ProjectTimerAndStagoryView.StateEnum stateEnum;
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "53300490")) {
            ipChange.ipc$dispatch("53300490", new Object[]{this});
            return;
        }
        boolean hasShowStrategy = hasShowStrategy();
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean == null || (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) == null) {
            stateEnum = this.timerAndStagoryView.setStrategyVisibility(hasShowStrategy, this.mDialogPanel.o(), isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), hasShowStrategy));
        } else if (projectMemberPrompt.isSpecialBuy()) {
            if (hasShowStrategy && this.mProjectDynamicExtDataBean.memberPrompt.isPromptBeforeSale()) {
                z2 = true;
            }
            stateEnum = this.specialBuyPromptView.setTmLottieStrategy(z2, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), z2));
        } else {
            stateEnum = this.timerAndStrategyTmPromptView.setTmLottieStrategy(hasShowStrategy, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), hasShowStrategy));
        }
        updateRecyclerMargin(stateEnum);
    }

    private void updateTimeCountDownFunction() {
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86508319")) {
            ipChange.ipc$dispatch("86508319", new Object[]{this});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean == null || (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) == null) {
            this.timerAndStrategyTmPromptView.setVisibility(8);
            this.specialBuyPromptView.setVisibility(8);
            this.timerAndStagoryView.setVisibility(0);
            updateTimeCountDownStatus();
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null) {
            projectMemberPrompt.setAlipayDetailUrl(projectStaticDataBean.alipayDetailUrl);
        }
        if (this.mProjectDynamicExtDataBean.memberPrompt.isSpecialBuy()) {
            this.specialBuyPromptView.setVisibility(0);
            this.timerAndStrategyTmPromptView.setVisibility(8);
        } else {
            this.timerAndStrategyTmPromptView.setVisibility(0);
            this.specialBuyPromptView.setVisibility(8);
        }
        this.timerAndStagoryView.setVisibility(8);
        updateMemberPromptTimeCountDownStatus();
    }

    private void updateTimeCountDownStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632416069")) {
            ipChange.ipc$dispatch("1632416069", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            int buyBtnStatus = projectItemDataBean.getBuyBtnStatus();
            String sellStartTimeStr = this.mProjectItemDataBean.getSellStartTimeStr();
            long countDown = this.mProjectItemDataBean.getCountDown();
            long a2 = (long) xl2.a();
            if ((buyBtnStatus != 105 && buyBtnStatus != 106) || TextUtils.isEmpty(sellStartTimeStr) || countDown <= 0) {
                updateCountDownVisibility(false, false);
            } else if (countDown > a2) {
                long j2 = countDown - a2;
                this.timerAndStagoryView.updateCountDownRemindText(sellStartTimeStr + "开抢");
                if (this.mOnTimeCountDownListener == null) {
                    this.mOnTimeCountDownListener = new y();
                }
                if (this.mTimeCountDownManager == null) {
                    this.mTimeCountDownManager = TimeCountDownManagerImpl.c(this.mOnTimeCountDownListener);
                }
                this.mTimeCountDownManager.setCountDown(j2);
                this.mTimeCountDownManager.startCountDown();
                updateCountDownVisibility(true, false);
            } else {
                this.mHasCountDownFinished = true;
                timeCountDownFinished();
            }
        } else {
            updateCountDownVisibility(false, false);
        }
    }

    private void updateTitleAndFixAnchorVisibility(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235080042")) {
            ipChange.ipc$dispatch("-1235080042", new Object[]{this, Boolean.valueOf(z2)});
        } else if (z2) {
            hideFixedAnchorIndicator();
            this.mTitleBarPanel.l(false);
        } else {
            if (this.isFixedAnchorVisible) {
                showFixedAnchorIndicator();
            } else {
                hideFixedAnchorIndicator();
            }
            this.mTitleBarPanel.l(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTitleBarStyle() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860819717")) {
            ipChange.ipc$dispatch("860819717", new Object[]{this});
            return;
        }
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition == null) {
                i2 = 0;
            } else {
                i2 = Math.abs(findViewByPosition.getTop());
            }
            if (i2 >= this.titleBar2DarkHeight) {
                this.mTitleBarPanel.d(true);
            } else {
                this.mTitleBarPanel.d(false);
            }
        } else {
            this.mTitleBarPanel.d(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTitleBgAndAnchorIndicator() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-59717637")) {
            ipChange.ipc$dispatch("-59717637", new Object[]{this});
            return;
        }
        updateRefreshable();
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                i2 = Math.abs(findViewByPosition.getTop());
            }
            checkDisplayFixedAnchorIndicator(i2);
        } else if (this.isShowAnchor) {
            showFixedAnchorIndicator();
        } else {
            hideFixedAnchorIndicator();
        }
    }

    private void updateWantSeeButtonStatus(boolean z2) {
        ProjectWantSeeBean projectWantSeeBean;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921247200")) {
            ipChange.ipc$dispatch("-1921247200", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && (projectWantSeeBean = projectDynamicExtDataBean.wantVO) != null) {
            boolean isSubFlag = projectWantSeeBean.isSubFlag();
            this.mWantSeeNum = projectWantSeeBean.getWantNum();
            if (isSubFlag) {
                str = xs0.a().getResources().getString(R$string.i_want_to_see);
            } else {
                str = xs0.a().getResources().getString(R$string.want_to_see);
            }
            this.mTvProjectFollowText.setText(str);
            if (isSubFlag) {
                this.mViewProjectFollow.setFollowImage();
                if (z2) {
                    this.mViewProjectFollow.clickAnimate();
                }
            } else {
                this.mViewProjectFollow.setCancelImage();
                if (z2) {
                    this.mViewProjectFollow.cancelAnimate();
                } else if (fu1.a()) {
                    this.mViewProjectFollow.guideAnimate();
                    fu1.b();
                }
            }
            ln2.r().n2(this.mViewProjectFollow, String.valueOf(this.mProjectId), isSubFlag);
        }
    }

    private void updateWantSeeByFollow(boolean z2) {
        ProjectWantSeeBean projectWantSeeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104671684")) {
            ipChange.ipc$dispatch("2104671684", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && (projectWantSeeBean = projectDynamicExtDataBean.wantVO) != null) {
            if (z2) {
                this.mWantSeeNum = projectWantSeeBean.getWantNum() + 1;
            } else {
                this.mWantSeeNum = Math.max(projectWantSeeBean.getWantNum() - 1, 0L);
            }
            this.mProjectDynamicExtDataBean.wantVO.setWantNum(this.mWantSeeNum);
            String a2 = WantSeeHelper.b().a(this.mWantSeeNum);
            this.mProjectDynamicExtDataBean.wantVO.setSubFlag(z2);
            if (!TextUtils.isEmpty(this.mProjectDynamicExtDataBean.wantVO.getWantNumStr())) {
                this.mProjectDynamicExtDataBean.wantVO.setWantNumStr(a2);
            }
            ProjectWantSeeBean projectWantSeeBean2 = this.mProjectDynamicExtDataBean.wantVO;
            updateWantSeeButtonStatus(true);
            ProjectHeaderPanel projectHeaderPanel = this.mHeadPanel;
            if (projectHeaderPanel != null) {
                projectHeaderPanel.A(z2, projectWantSeeBean2);
            }
        }
    }

    private List<View> viewIgnoreTagForExposure(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340967680")) {
            return (List) ipChange.ipc$dispatch("1340967680", new Object[]{this, view});
        }
        new ArrayList();
        return cn.damai.common.user.c.e().I(cn.damai.common.user.c.e().d(view));
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1362742231")) {
            return R$layout.project_item_detail_main_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1362742231", new Object[]{this})).intValue();
    }

    public pt1 getProjectDataHolderManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2046609609")) {
            return this.mProjectDataHolderManager;
        }
        return (pt1) ipChange.ipc$dispatch("-2046609609", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079561553")) {
            ipChange.ipc$dispatch("2079561553", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        hideSkeleton();
        getProjectDetailData(0);
    }

    public boolean handlerBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144024005")) {
            return ((Boolean) ipChange.ipc$dispatch("2144024005", new Object[]{this})).booleanValue();
        }
        PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment = this.mPrivilegeCodeVerifyFragment;
        if (privilegeCodeVerifyFragment == null || !privilegeCodeVerifyFragment.isVisible() || this.mFlvPopupLayer.getVisibility() != 0) {
            Fragment fragment = this.mPopLayerFragment;
            if (fragment == null || !fragment.isVisible() || this.mFlvPopupLayer.getVisibility() != 0) {
                NoticeDetailFragment noticeDetailFragment = this.detailFragment;
                if (noticeDetailFragment == null || !noticeDetailFragment.isVisible() || this.mFlvPopupLayer.getVisibility() != 0) {
                    cn.damai.common.user.c.e().x(ln2.r().c1(this.mProjectId, true));
                    return false;
                }
                dismissPopLayerFragment(this.detailFragment);
                return true;
            }
            dismissPopLayerFragment(this.mPopLayerFragment);
            return true;
        }
        dismissPopLayerFragment(this.mPrivilegeCodeVerifyFragment);
        return true;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412759802")) {
            ipChange.ipc$dispatch("1412759802", new Object[]{this});
            return;
        }
        ((ProjectItemPresenter) this.mPresenter).setVM(this, (ProjectItemContract.Model) this.mModel);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100375197")) {
            ipChange.ipc$dispatch("-2100375197", new Object[]{this});
            return;
        }
        this.mDefaultRVMarginBottom = n42.a(getContext(), 60.0f);
        this.mTimerRVMarginBottom = n42.a(getContext(), 121.0f);
        this.mSingleStagoryMargin = n42.a(getContext(), 104.0f);
        registerMessageObserver();
        initExtraParams();
        initPopFragmentHandler();
        initProjectDataHolderManager();
        initTitleView();
        initRecyclerView();
        initProjectDetailView();
        initBottomButtonView();
        initAnchorIndicator();
        initListeners();
        setupListeners();
        initExtraData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641969180")) {
            ipChange.ipc$dispatch("641969180", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setDamaiUTKeyBuilder(ln2.r().f0(this.mProjectId));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609529718")) {
            ipChange.ipc$dispatch("-609529718", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        ShareManager.E().r0(i2, i3, intent);
        if (i2 == 2000 && i3 == 1000) {
            this.mProjectDetailActivity.finish();
        } else if (i2 == 4097 && i3 == -1) {
            updateProjectFollowRelation(1);
        } else if (i2 == 4101 && i3 == -1) {
            this.mPurchaseType = 1;
        } else if (i2 == 4103 && i3 == -1) {
            this.mPurchaseType = 2;
        } else if (i2 == 4119 && i3 == -1) {
            this.mPurchaseType = 4;
        } else if (i2 == 4120 && i3 == -1) {
            this.mPurchaseType = 3;
        } else if (i2 == 4115 && i3 == -1) {
            getAliMeTokenAndEnter();
        } else if (i2 == 4117 && i3 == -1) {
            popupSkuByPerformInfo();
        } else if (i2 == 4118 && i3 == -1) {
            this.mHeadPanel.s();
            if (!this.mProjectDetailActivity.isActivityFinsihed()) {
                CouponDialogHelper.l(this.mProjectDetailActivity).y(true);
                CouponDialogHelper.l(this.mProjectDetailActivity).p();
            }
        } else if (i2 == 4130) {
            onRefresh();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.AnchorIndicatorView.OnAnchorItemClickListener
    public void onAnchorItemClick(int i2, a5 a5Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119833353")) {
            ipChange.ipc$dispatch("-1119833353", new Object[]{this, Integer.valueOf(i2), a5Var});
            return;
        }
        clickedAnchorItem(i2, a5Var);
        ln2.r().Y(a5Var.d(), this.mProjectId);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829472393")) {
            ipChange.ipc$dispatch("1829472393", new Object[]{this, view});
        }
    }

    @Override // cn.damai.commonbusiness.servicenotice.OnCompleteListener
    public void onComplete(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609714595")) {
            ipChange.ipc$dispatch("609714595", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 1) {
            dismissPopLayerFragment(this.mPopLayerFragment);
        } else if (i2 == 2) {
            dismissPopLayerFragment(this.mPopLayerFragment);
        } else if (i2 == 3) {
            dismissPopLayerFragment(this.mPopLayerFragment);
        } else if (i2 == 4) {
            dismissPopLayerFragment(this.mPrivilegeCodeVerifyFragment);
        } else {
            dismissPopLayerFragment(this.mPopLayerFragment);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801827831")) {
            ipChange.ipc$dispatch("1801827831", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mIsFirstEnter = true;
        this.mPurchaseType = -1;
        s72.e(true);
        OrangeConfigCenter.c().e("damai_seat_data_preload_switch");
        this.mRegionManager = new lz1();
        this.mPerformDataManager = ep1.d();
        this.mNewSkuDataManager = ni1.a();
        updateScreenShot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652152567")) {
            ipChange.ipc$dispatch("652152567", new Object[]{this});
            return;
        }
        SplitImageSizeCache.b();
        cr.c().a("brand_state_changed", this.action);
        super.onDestroy();
        removeShotListener();
        cancelCountDown();
        SkuPerform c2 = this.mPerformDataConfigure.c();
        if (c2 != null) {
            this.mRegionManager.d(ep1.b(c2));
        }
        ep1 ep1 = this.mPerformDataManager;
        if (ep1 != null) {
            ep1.e(this.mProjectId);
        }
        ni1 ni1 = this.mNewSkuDataManager;
        if (ni1 != null) {
            ni1.c(this.mProjectId);
        }
        ProjectHeaderPanel projectHeaderPanel = this.mHeadPanel;
        if (projectHeaderPanel != null) {
            projectHeaderPanel.u();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589214778")) {
            ipChange.ipc$dispatch("-1589214778", new Object[]{this});
            return;
        }
        super.onDetach();
        s72.e(false);
        OrangeConfigCenter.c().g("damai_seat_data_preload_switch");
    }

    public void onExtendInfoItemClick(View view, int i2, String str, String str2) {
        LinkedHashMap<String, Integer> q2;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "83481833")) {
            ipChange.ipc$dispatch("83481833", new Object[]{this, view, Integer.valueOf(i2), str, str2});
        } else if (!TextUtils.isEmpty(str2) && (q2 = this.mProjectDataHolderManager.q(i2)) != null) {
            try {
                Integer num = q2.get(str2);
                if (num != null) {
                    i3 = num.intValue();
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                cn.damai.common.user.c.e().x(ln2.r().u0(this.mProjectId, i3));
                DMNav.from(this.mActivity).toUri(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Integer> entry : q2.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(key);
                    arrayList.add(picInfo);
                }
            }
            cn.damai.common.user.c.e().x(ln2.r().u0(this.mProjectId, i3));
            tt1.l(this.mProjectDetailActivity, this.mProjectId, arrayList, i3);
        }
    }

    public void onMoreExtendInfoBtnClickListener(int i2, int i3) {
        IRichTextManager r2;
        AnchorManager anchorManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758583076")) {
            ipChange.ipc$dispatch("-1758583076", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (!isRemoving() && !isDetached() && this.mProjectItemDetailAdapter != null && (r2 = this.mProjectDataHolderManager.r(i2)) != null) {
            boolean hasExpanded = r2.hasExpanded();
            r2.expandShrinkRichText();
            this.mProjectItemDetailAdapter.c(this.mProjectDataHolderManager.o());
            this.mProjectItemDetailAdapter.notifyDataSetChanged();
            if (!(!hasExpanded || (anchorManager = this.mAnchorManager) == null || anchorManager.e() == null || this.mAnchorManager.e().c() == null)) {
                setCurAnchorPosition(0);
                scrollToPosition(r2.getStartIndex(), getOffset());
                this.isFixedAnchorVisible = true;
                updateTitleAndFixAnchorVisibility(false);
            }
            cn.damai.common.user.c.e().x(ln2.r().v0(this.mProjectId));
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647382452")) {
            ipChange.ipc$dispatch("-647382452", new Object[]{this, str, str2, str3});
            return;
        }
        hideSkeleton();
        stopProgressDialog();
        this.mLinearPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        ProjectDetailXFlushUtil.m("mtop.alibaba.damai.detail.getdetail", String.valueOf(this.mProjectId), str, str2, getProjectName());
        if (toDisplayErrorPage()) {
            displayErrorPage(str, str2, str3);
            this.mTitleBarPanel.l(false);
            ProjectDetailXFlushUtil.h("mtop.alibaba.damai.detail.getdetail", String.valueOf(this.mProjectId), str, str2, getProjectName());
        } else if (!isFlowLimitedErrorCode(str) || this.mHasDisplayedLimitedDialog) {
            ToastUtil.a().j(this.mProjectDetailActivity, str2);
        } else {
            showFlowLimitedDialog();
            this.mHasDisplayedLimitedDialog = true;
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496832301")) {
            ipChange.ipc$dispatch("-1496832301", new Object[]{this});
            return;
        }
        hideSkeleton();
        stopProgressDialog();
        onResponseSuccess(this.mContentRootLayout);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237816197")) {
            ipChange.ipc$dispatch("-237816197", new Object[]{this});
            return;
        }
        super.onPause();
        pauseRedPacket();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onPraiseViewOnClick(CommentsItemBean commentsItemBean) {
        ProjectDetailCommentBean projectDetailCommentBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99704301")) {
            ipChange.ipc$dispatch("99704301", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean != null && (projectDetailCommentBean = this.mProjectDetailEvaluateBean) != null) {
            List<CommentsItemBean> moduleComments = projectDetailCommentBean.getModuleComments();
            int e2 = xf2.e(moduleComments);
            for (int i2 = 0; i2 < e2; i2++) {
                CommentsItemBean commentsItemBean2 = moduleComments.get(i2);
                if (commentsItemBean2 != null && commentsItemBean.getCommentId().equals(commentsItemBean2.getCommentId())) {
                    CommentPraiseInfoBean praiseInfo = commentsItemBean.getPraiseInfo();
                    CommentPraiseInfoBean praiseInfo2 = commentsItemBean2.getPraiseInfo();
                    if (praiseInfo.isHasPraised() != praiseInfo2.isHasPraised()) {
                        praiseInfo2.setHasPraised(praiseInfo.isHasPraised());
                        praiseInfo2.setPraiseCount(praiseInfo.getPraiseCount());
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.PrivilegeCodeVerifyFragment.OnPrivilegeCodeVerifyResultListener
    public void onPrivilegeCodeVerifySuccess(int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286357024")) {
            ipChange.ipc$dispatch("-286357024", new Object[]{this, Integer.valueOf(i2), str});
            return;
        }
        if (this.mProjectItemDataBean != null) {
            if (TextUtils.isEmpty(str)) {
                str = this.mProjectItemDataBean.getPrivilegeId();
            }
            this.mPrivilegeId = str;
        }
        if (i2 == 300) {
            showPerformListFragment(false);
        } else if (i2 == 200) {
            handleChooseSeatPage();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1129765770")) {
            ipChange.ipc$dispatch("-1129765770", new Object[]{this});
        } else if (!this.mIsLoading) {
            this.mProjectDataHolderManager.T();
            getProjectDetailData(1);
        } else {
            stopProgressDialog();
            this.mLinearPullToRefreshView.onRefreshComplete();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1429548308")) {
            ipChange.ipc$dispatch("-1429548308", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().y(false);
        resumeRedPacket();
        if (!this.mIsFirstEnter) {
            resetProjectPerformData();
            getProjectDetailData(2);
        } else {
            this.mIsFirstEnter = false;
            showSkeleton();
            getProjectDetailData(0);
        }
        dismissScreenShotShare();
        Log.e("xxxxx_fragment_ut", "detail onresume");
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onRetrieveDiscussionError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940450913")) {
            ipChange.ipc$dispatch("1940450913", new Object[]{this, str, str2});
            return;
        }
        ProjectDetailXFlushUtil.j(String.valueOf(this.mProjectId), str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onRetrieveDiscussionSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135475040")) {
            ipChange.ipc$dispatch("135475040", new Object[]{this, projectDetailCommentBean});
            return;
        }
        this.mProjectDetailDiscussionBean = projectDetailCommentBean;
        updateDetailDataHoldersAndTab();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectDetailCommentError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975126754")) {
            ipChange.ipc$dispatch("1975126754", new Object[]{this, str, str2});
            return;
        }
        ProjectDetailXFlushUtil.k(String.valueOf(this.mProjectId), str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectDetailCommentSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636900289")) {
            ipChange.ipc$dispatch("-636900289", new Object[]{this, projectDetailCommentBean});
            return;
        }
        this.mProjectDetailEvaluateBean = projectDetailCommentBean;
        updateDetailDataHoldersAndTab();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectDetailDataSuccess(int i2, ProjectDetailDataBean projectDetailDataBean) {
        String str;
        ProjectWantSeeBean.GuideVO guideVO;
        ProjectStaticDataBean projectStaticDataBean;
        ProjectStaticExtendInfoBean projectStaticExtendInfoBean;
        ProjectTicketGuideBean projectTicketGuideBean;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1072918516")) {
            ipChange.ipc$dispatch("-1072918516", new Object[]{this, Integer.valueOf(i2), projectDetailDataBean});
            return;
        }
        this.mLinearPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        if (projectDetailDataBean != null) {
            ProjectStaticDataBean staticData = projectDetailDataBean.getStaticData();
            if (staticData != null) {
                String str2 = staticData.track;
                if (!TextUtils.isEmpty(str2)) {
                    ln2.r().D2(this.mProjectId, this.mActivity, str2);
                }
            }
            this.mHeadPanel.o(projectDetailDataBean, this.mRankInfo);
            ProjectDialogHelper projectDialogHelper = this.mDialogPanel;
            if (projectDialogHelper != null) {
                projectDialogHelper.j(staticData, this.mProjectId);
            }
            this.mProjectDetailDataBean = projectDetailDataBean;
            this.mProjectStaticDataBean = projectDetailDataBean.getStaticData();
            this.mProjectDynamicExtDataBean = projectDetailDataBean.getDynamicExtData();
            ProjectItemDataBean item = projectDetailDataBean.getItem();
            this.mProjectItemDataBean = item;
            if (item == null) {
                str = "";
            } else {
                str = item.getPrivilegeId();
            }
            this.mPrivilegeId = str;
            ProjectStaticDataBean projectStaticDataBean2 = this.mProjectStaticDataBean;
            if (!(projectStaticDataBean2 == null || (projectTicketGuideBean = projectStaticDataBean2.ticketPurchasesGuidePage) == null || TextUtils.isEmpty(projectTicketGuideBean.purchaseGuideUrl))) {
                StringBuilder sb = new StringBuilder(this.mProjectStaticDataBean.ticketPurchasesGuidePage.purchaseGuideUrl);
                getResetAttendeesOrangeSwitch();
                if (this.mProjectItemDataBean.getPurchaseLimitation() != 0) {
                    sb.append("&isSupportMultiple=YES");
                }
                if (isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), false)) {
                    sb.append("&highLightSection=needRealName");
                }
                this.mProjectStaticDataBean.ticketPurchasesGuidePage.purchaseGuideUrl = sb.toString();
            }
            updateRefreshable();
            updateTitleAndFixAnchorVisibility(false);
            updateProjectStaticData();
            updateWantSeeButtonStatus(false);
            ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
            int i3 = -1;
            int buyBtnStatus = projectItemDataBean == null ? -1 : projectItemDataBean.getBuyBtnStatus();
            autoCancelCalendarRemind();
            updateTimeCountDownFunction();
            registerRedPacketMessage();
            preloadRegionData();
            updateProjectPurchaseBtnStatus();
            ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
            if (projectItemStatusHelper == null || projectItemStatusHelper.l()) {
                ProjectItemDataBean projectItemDataBean2 = this.mProjectItemDataBean;
                if (projectItemDataBean2 != null) {
                    i3 = projectItemDataBean2.getBuyBtnStatus();
                }
                processAutoShowSku(buyBtnStatus, i3);
                confirmPromptContentPriority();
                reportProjectCouponPromotionUT();
                executeEvaluatesAndDiscussionRequest();
                updateDetailDataHoldersAndTab();
                updateMoreRecommendVisibility();
                saveHotSellStartTime();
                if (this.mProjectStaticDataBean != null) {
                    this.mTitleBarPanel.j(this.mProjectId);
                    this.mTitleBarPanel.m(this.mProjectStaticDataBean.getShareIconPicUrl());
                }
                ProjectDetailDataBean projectDetailDataBean2 = this.mProjectDetailDataBean;
                if (!(projectDetailDataBean2 == null || (projectStaticDataBean = projectDetailDataBean2.staticData) == null || (projectStaticExtendInfoBean = projectStaticDataBean.itemExtendInfo) == null)) {
                    ProjectTitleBarPanel projectTitleBarPanel = this.mTitleBarPanel;
                    if (projectStaticExtendInfoBean.approvalVO != null) {
                        z2 = true;
                    }
                    projectTitleBarPanel.i(z2);
                }
                WantSeePosterTips.a aVar = WantSeePosterTips.Companion;
                if (!aVar.a()) {
                    ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
                    if (!(projectDynamicExtDataBean == null || projectDynamicExtDataBean.wantVO == null || isBottomTimerAndStrategyShowing() || (guideVO = this.mProjectDynamicExtDataBean.wantVO.guideVO) == null)) {
                        WantSeePosterTips.b.d dVar = WantSeePosterTips.b.d.INSTANCE;
                        dVar.u(guideVO.title);
                        dVar.v(guideVO.titleSuffix);
                        dVar.t(guideVO.subTitle);
                        dVar.r(guideVO.posterUrl);
                        dVar.q(Integer.valueOf(guideVO.titleType));
                        this.wantSeePosterTips.setProjectId(Long.valueOf(this.mProjectId));
                        this.wantSeePosterTips.setPageSource(dVar);
                        this.wantSeePosterTips.showAnim();
                        this.wantSeePosterTips.mark(Long.valueOf(this.mProjectId));
                        aVar.b(true);
                    }
                    enterShowWantSeeGuideTips(this.mProjectId);
                    return;
                }
                return;
            }
            cancelCountDown();
            displayProjectNotExistPage();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectNATDataFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920813267")) {
            ipChange.ipc$dispatch("-1920813267", new Object[]{this, str, str2});
            return;
        }
        ProjectDialogHelper projectDialogHelper = this.mDialogPanel;
        if (projectDialogHelper != null) {
            projectDialogHelper.s();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectNATDataSuccess(ProjectInformationBean projectInformationBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156807754")) {
            ipChange.ipc$dispatch("-1156807754", new Object[]{this, projectInformationBean});
            return;
        }
        ProjectDialogHelper projectDialogHelper = this.mDialogPanel;
        if (projectDialogHelper != null) {
            projectDialogHelper.q(projectInformationBean);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectRecommendError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768589648")) {
            ipChange.ipc$dispatch("768589648", new Object[]{this, str, str2});
            return;
        }
        ProjectDetailXFlushUtil.p(String.valueOf(this.mProjectId), str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectRecommendSuccess(ProjectRecommendListBean projectRecommendListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551394121")) {
            ipChange.ipc$dispatch("-1551394121", new Object[]{this, projectRecommendListBean});
        } else if (projectRecommendListBean != null) {
            this.mRecommendItems = projectRecommendListBean.recommends;
            updateDetailDataHoldersAndTab();
            updateMoreRecommendVisibility();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnSkuBeanDataFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585674496")) {
            ipChange.ipc$dispatch("-585674496", new Object[]{this, str, str2});
            return;
        }
        this.mIsLoading = false;
        if (toDisplayErrorPage()) {
            displayErrorPage(str, str2, "mtop.alibaba.detail.subpage.getdetail");
            this.mTitleBarPanel.l(false);
        } else if (!isFlowLimitedErrorCode(str) || this.mHasDisplayedLimitedDialog) {
            if (!TextUtils.isEmpty(str2) && str2.contains("result")) {
                str2 = "项目太火爆了，请稍后再试";
            }
            ToastUtil.a().j(this.mProjectDetailActivity, str2);
        } else {
            showFlowLimitedDialog();
            this.mHasDisplayedLimitedDialog = true;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnSkuBeanDataSuccess(SkuBean skuBean) {
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223338604")) {
            ipChange.ipc$dispatch("1223338604", new Object[]{this, skuBean});
            return;
        }
        this.mIsLoading = false;
        if (skuBean != null) {
            ItemBuyBtnBean itemBuyBtnBean = skuBean.itemBuyBtn;
            if (itemBuyBtnBean == null) {
                ToastUtil.i("麦麦开小差了，请稍后重试");
                return;
            }
            int i2 = itemBuyBtnBean.btnStatus;
            if (i2 == 230 || i2 == 231) {
                this.mSkuBean = null;
            } else {
                this.mSkuBean = skuBean;
            }
            ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
            if (projectItemDataBean != null) {
                projectItemDataBean.setBuyBtnText(itemBuyBtnBean.btnText);
                this.mProjectItemDataBean.setBuyBtnTip(itemBuyBtnBean.btnTips);
                this.mProjectItemDataBean.setBuyBtnStatus(itemBuyBtnBean.btnStatus);
            }
            if (itemBuyBtnBean.btnStatus == 106) {
                try {
                    j2 = Long.parseLong(itemBuyBtnBean.scd);
                } catch (Exception unused) {
                    j2 = 0;
                }
                if (j2 > 60) {
                    this.mPurchaseType = 4;
                    getProjectDetailData(1);
                } else if (j2 > 0) {
                    this.mProjectItemDataBean.setCountDown(j2);
                    updateTimeCountDownFunction();
                    ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
                    if (projectItemStatusHelper != null) {
                        projectItemStatusHelper.u(this.mProjectItemDataBean);
                        updatePageUT();
                        if (!this.mProjectItemStatusHelper.l()) {
                            cancelCountDown();
                            displayProjectNotExistPage();
                            return;
                        }
                    }
                    autoShowSkuLayer();
                }
            } else {
                updateCountDownVisibility(false, false);
                updateMemberPromptCountDownVisibility(false, false);
                ProjectItemStatusHelper projectItemStatusHelper2 = this.mProjectItemStatusHelper;
                if (projectItemStatusHelper2 != null) {
                    projectItemStatusHelper2.u(this.mProjectItemDataBean);
                    updatePageUT();
                    if (!this.mProjectItemStatusHelper.l()) {
                        cancelCountDown();
                        displayProjectNotExistPage();
                        return;
                    }
                    this.mPurchaseType = -1;
                    popupSkuByPerformInfo();
                }
            }
        }
    }

    public void onSelfActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076110946")) {
            ipChange.ipc$dispatch("-2076110946", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
        } else if (i2 == 4128) {
            startWantSeeGuideTimer(WantSeeGuideTips.b.C0036b.INSTANCE);
        } else if (i2 == 4129) {
            startWantSeeGuideTimer(WantSeeGuideTips.b.d.INSTANCE);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onUpdateProjectFollowStatusError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1860681576")) {
            ipChange.ipc$dispatch("-1860681576", new Object[]{this, str, str2});
            return;
        }
        ToastUtil.a().j(this.mActivity, str2);
        ProjectDetailXFlushUtil.l(String.valueOf(this.mProjectId), str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onUpdateProjectFollowStatusSuccess(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "431810988")) {
            ipChange.ipc$dispatch("431810988", new Object[]{this, followDataBean});
        } else if (followDataBean != null) {
            br.c(FocusEvent.EVENT_NAME_PROJECT_FOCUS_CHANGED, FocusEvent.projectFocusChanged());
            updateProjectFollowStatus(followDataBean);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185636925")) {
            ipChange.ipc$dispatch("185636925", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479669319")) {
            ipChange.ipc$dispatch("-1479669319", new Object[]{this, str});
            return;
        }
        FragmentActivity activity = getActivity();
        if (!TextUtils.isEmpty(str) && activity != null && !activity.isFinishing()) {
            ToastUtil.a().e(activity, str);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531119581")) {
            ipChange.ipc$dispatch("531119581", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523871128")) {
            ipChange.ipc$dispatch("1523871128", new Object[]{this});
        }
    }

    private void showWantTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1338053171")) {
            ipChange.ipc$dispatch("1338053171", new Object[]{this});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && projectDynamicExtDataBean.wantVO != null && this.mProjectItemDataBean != null && !isBottomTimerAndStrategyShowing() && !cy2.INSTANCE.e(this.mActivity, this.mGuideUtProvider)) {
            ProjectWantSeeBean projectWantSeeBean = this.mProjectDynamicExtDataBean.wantVO;
            if (this.mProjectItemDataBean.showWantSeeGuideTips()) {
                CountDownTimer countDownTimer = this.wantSeeGuideTipsTimer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                WantSeeGuideTips.b.e eVar = WantSeeGuideTips.b.e.INSTANCE;
                eVar.j(projectWantSeeBean.tipsTitle);
                eVar.i(projectWantSeeBean.tipsSubTitle);
                this.wantSeeGuideTips.setScenesSource(eVar);
                ((FrameLayout.LayoutParams) this.wantSeeGuideTips.getLayoutParams()).gravity = BadgeDrawable.BOTTOM_END;
                this.wantSeeGuideTips.showAnim();
            } else {
                CountDownTimer countDownTimer2 = this.wantSeeGuideTipsTimer;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                }
                WantSeeGuideTips wantSeeGuideTips2 = this.wantSeeGuideTips;
                if (wantSeeGuideTips2 != null) {
                    wantSeeGuideTips2.cancel();
                }
                WantSeeTips.a.e eVar2 = WantSeeTips.a.e.INSTANCE;
                eVar2.p(projectWantSeeBean.tipsTitle);
                eVar2.o(projectWantSeeBean.tipsSubTitle);
                this.wantSeeTips.setPageSource(eVar2);
                this.wantSeeTips.showAnim();
            }
            ln2.r().V1(this.wantSeeTips, String.valueOf(this.mProjectId), this.mButtomText);
        }
    }
}

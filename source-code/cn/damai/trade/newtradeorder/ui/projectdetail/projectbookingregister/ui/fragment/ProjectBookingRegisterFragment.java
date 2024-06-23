package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.h5container.CaptureActivity;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.DynamicExtData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ItemData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.model.ProjectBookingRegisterModel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter.ProjectBookingRegisterPresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.adapter.ProjectBookingRegisterAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.view.BuyButtonStatusHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView;
import cn.damai.trade.newtradeorder.ui.projectdetail.util.ProjectIntentExtraParser;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import cn.damai.uikit.view.SeeAnimateView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.bk2;
import tb.d20;
import tb.gr;
import tb.it1;
import tb.jt1;
import tb.kt1;
import tb.ln2;
import tb.n42;
import tb.wt1;
import tb.xf2;
import tb.xs0;
import tb.yt1;

/* compiled from: Taobao */
public class ProjectBookingRegisterFragment extends DamaiBaseMvpFragment<ProjectBookingRegisterPresenter, ProjectBookingRegisterModel> implements ProjectBookingRegisterContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    OnHeadClickListener headClickListener = new d();
    private BuyButtonStatusHelper mBuyButtonStatusHelper;
    private DynamicExtData mDynamicExtData;
    private FrameLayout mFlProjectContentContainer;
    private FrameLayout mFlPurchaseStatusBarContainer;
    private it1 mHeadPanel;
    private boolean mIsFirstEnter;
    private boolean mIsLoading;
    private boolean mIsScrolled;
    private ItemData mItemData;
    private ImageView mIvProjectPosterMask;
    private WrapLinearLayoutManager mLinearLayoutManager;
    private View mLvBottomBar;
    private FrameLayout mLvCustomerService;
    private LinearLayout mLvProjectDetailHeader;
    private View.OnClickListener mOnCustomerServiceClickListener;
    private OnExtendInfoImageItemClickListener mOnExtendInfoImageItemClickListener;
    private View.OnClickListener mOnProjectFollowClickListener;
    private PullToRefreshView.OnRefreshListener mOnRefreshListener;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1177269067")) {
                ipChange.ipc$dispatch("-1177269067", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            ProjectBookingRegisterFragment projectBookingRegisterFragment = ProjectBookingRegisterFragment.this;
            if (i == 0) {
                z = false;
            }
            projectBookingRegisterFragment.mIsScrolled = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-678782006")) {
                ipChange.ipc$dispatch("-678782006", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            ProjectBookingRegisterFragment.this.updateTitleStyle();
            if (ProjectBookingRegisterFragment.this.mIsScrolled) {
                ProjectBookingRegisterFragment.this.updateRefreshable();
            }
        }
    };
    private ProjectBookingRegisterAdapter mProjectBookingRegisterAdapter;
    private jt1 mProjectBookingRegisterDataManager;
    private ProjectDetailActivity mProjectDetailActivity;
    private ProjectIntentExtraParser.ProjectDetailExtrasData mProjectExtraData;
    private long mProjectId;
    private PullToRefreshView mPullToRefreshView;
    private DamaiRootRecyclerView mRecyclerView;
    private StaticData mStaticData;
    private ProjectTitleBarPanel mTitleBarPanel;
    private TextView mTvProjectFollowText;
    private SeeAnimateView mViewProjectFollow;
    private View mViewPurchaseStatusContent;
    private int titleBar2DarkHeight = n42.a(xs0.a(), 18.0f);

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-689239820")) {
                ipChange.ipc$dispatch("-689239820", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().A(ln2.r().i("pdt_dtl", "1"), "selectsuggestmessage", "message");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ProjectBookingRegisterFragment.this.mActivity.getPackageName()));
            ProjectBookingRegisterFragment.this.startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(ProjectBookingRegisterFragment projectBookingRegisterFragment) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "280341203")) {
                ipChange.ipc$dispatch("280341203", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().A(ln2.r().i("pdt_dtl", "0"), "selectsuggestmessage", "message");
        }
    }

    /* compiled from: Taobao */
    public class c implements AliMeUtil.OnAliMeTokenListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1602204804")) {
                ipChange.ipc$dispatch("1602204804", new Object[]{this, str, str2});
                return;
            }
            ProjectBookingRegisterFragment.this.stopProgressDialog();
            AliMeUtil.p(str, str2);
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "359202180")) {
                ipChange.ipc$dispatch("359202180", new Object[]{this, str});
                return;
            }
            ProjectBookingRegisterFragment.this.stopProgressDialog();
            if (!xf2.j(str)) {
                String f = AliMeUtil.f(AliMeUtil.FROM_PROJECT_DETAIL, str, String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "");
                if (!xf2.j(f)) {
                    AliMeUtil.b(ProjectBookingRegisterFragment.this.mActivity, f);
                    return;
                }
                return;
            }
            AliMeUtil.o();
        }
    }

    /* compiled from: Taobao */
    public class d implements OnHeadClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onLoadedPosterPic(String str, Bitmap bitmap, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1285205144")) {
                ipChange.ipc$dispatch("-1285205144", new Object[]{this, str, bitmap, Boolean.valueOf(z)});
                return;
            }
            ProjectBookingRegisterFragment.this.setProjectDetailMaskLayerImage(str, bitmap);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onMarketStallClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "566051702")) {
                ipChange.ipc$dispatch("566051702", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onNoticeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-594566368")) {
                ipChange.ipc$dispatch("-594566368", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPosterClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1853473941")) {
                ipChange.ipc$dispatch("1853473941", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(kt1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "top", "poster", false));
            ArrayList<PicInfo> arrayList = null;
            if (ProjectBookingRegisterFragment.this.mStaticData != null && ProjectBookingRegisterFragment.this.mStaticData.getItemBase() != null && ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics() != null && ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics().getItemPicList() != null && !ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics().getItemPicList().isEmpty()) {
                arrayList = ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics().getItemPicList();
            } else if (ProjectBookingRegisterFragment.this.mProjectExtraData != null && TextUtils.isEmpty(ProjectBookingRegisterFragment.this.mProjectExtraData.projectImage)) {
                arrayList = new ArrayList<>();
                PicInfo picInfo = new PicInfo();
                picInfo.setPicUrl(ProjectBookingRegisterFragment.this.mProjectExtraData.projectImage);
                arrayList.add(picInfo);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                ProjectBookingRegisterFragment.this.startBrowseImageWithTextActivity(arrayList, 0);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPromotionTagsClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1672516402")) {
                ipChange.ipc$dispatch("-1672516402", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onRankListClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1468894606")) {
                ipChange.ipc$dispatch("-1468894606", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreBottomTagClick(ProjectRatingContentLabelBean projectRatingContentLabelBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1335694219")) {
                ipChange.ipc$dispatch("1335694219", new Object[]{this, projectRatingContentLabelBean});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreCommentClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1589995155")) {
                ipChange.ipc$dispatch("1589995155", new Object[]{this, str, str2, str3});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreHeadTipClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1399135419")) {
                ipChange.ipc$dispatch("-1399135419", new Object[]{this, str, str2});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onSeatIconClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-57116762")) {
                ipChange.ipc$dispatch("-57116762", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onServiceEtcClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-114486681")) {
                ipChange.ipc$dispatch("-114486681", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onShowTimeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-489139470")) {
                ipChange.ipc$dispatch("-489139470", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueMapIconClick() {
            VenueBean venue;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1249808526")) {
                ipChange.ipc$dispatch("1249808526", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(kt1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), ILocatable.ADDRESS, "item", true));
            if (ProjectBookingRegisterFragment.this.mStaticData != null && (venue = ProjectBookingRegisterFragment.this.mStaticData.getVenue()) != null && !TextUtils.isEmpty(venue.getVenueName()) && !venue.getVenueName().contains(bk2.b(ProjectBookingRegisterFragment.this.mProjectDetailActivity, R$string.damai_projectdetail_tbd))) {
                Bundle bundle = new Bundle();
                bundle.putString("name", venue.getVenueName());
                bundle.putLong("venueid", xf2.m(venue.getVenueId(), 0));
                bundle.putLong("projectId", ProjectBookingRegisterFragment.this.mProjectId);
                DMNav.from(ProjectBookingRegisterFragment.this.mProjectDetailActivity).withExtras(bundle).toUri(NavUri.b("venuemap"));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueNameClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "219232140")) {
                ipChange.ipc$dispatch("219232140", new Object[]{this});
            } else if (ProjectBookingRegisterFragment.this.mStaticData != null) {
                cn.damai.common.user.c.e().x(kt1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "center", "venuenamebtn", true));
                VenueBean venue = ProjectBookingRegisterFragment.this.mStaticData.getVenue();
                if (venue != null && !TextUtils.isEmpty(venue.getVenueName()) && !venue.getVenueName().contains(bk2.b(ProjectBookingRegisterFragment.this.mProjectDetailActivity, R$string.damai_projectdetail_tbd))) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ILocatable.ADDRESS, venue.getVenueAddr());
                    bundle.putString(FeedsViewModel.ARG_USERID, venue.getVenueId());
                    bundle.putString("usertype", "3");
                    DMNav.from(ProjectBookingRegisterFragment.this.mProjectDetailActivity).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                }
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVideoClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1116497078")) {
                ipChange.ipc$dispatch("1116497078", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onWannaSeeActionClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1711493670")) {
                ipChange.ipc$dispatch("-1711493670", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements ProjectTitleBarPanel.OnUiClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onActivityShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2144605117")) {
                ipChange.ipc$dispatch("-2144605117", new Object[]{this});
                return;
            }
            ProjectBookingRegisterFragment.this.shareProjectInfo();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1465321230")) {
                ipChange.ipc$dispatch("1465321230", new Object[]{this});
            } else if (ProjectBookingRegisterFragment.this.getActivity() != null && !ProjectBookingRegisterFragment.this.getActivity().isFinishing()) {
                ProjectBookingRegisterFragment.this.getActivity().finish();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onCertInfoClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-851584231")) {
                ipChange.ipc$dispatch("-851584231", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onTitleBarClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1233382462")) {
                ipChange.ipc$dispatch("-1233382462", new Object[]{this});
                return;
            }
            ProjectBookingRegisterFragment.this.mTitleBarPanel.d(false);
            ProjectBookingRegisterFragment projectBookingRegisterFragment = ProjectBookingRegisterFragment.this;
            projectBookingRegisterFragment.scrollToPosition(1, projectBookingRegisterFragment.getOffset());
            ProjectBookingRegisterFragment.this.updateRefreshable();
        }
    }

    /* compiled from: Taobao */
    public class f implements PullToRefreshView.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-124887245")) {
                ipChange.ipc$dispatch("-124887245", new Object[]{this});
            } else if (!ProjectBookingRegisterFragment.this.mIsLoading) {
                ProjectBookingRegisterFragment.this.mProjectBookingRegisterDataManager.i();
                ProjectBookingRegisterFragment.this.getProjectBookingRegisterData(1);
            } else {
                ProjectBookingRegisterFragment.this.mPullToRefreshView.onRefreshComplete();
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2104673427")) {
                ipChange.ipc$dispatch("-2104673427", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(kt1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "bottom", "service", true));
            ProjectBookingRegisterFragment.this.getAliMeTokenAndEnter();
        }
    }

    /* compiled from: Taobao */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "6616942")) {
                ipChange.ipc$dispatch("6616942", new Object[]{this, view});
                return;
            }
            ProjectBookingRegisterFragment.this.updateProjectFollowRelation();
        }
    }

    /* compiled from: Taobao */
    public class i implements OnExtendInfoImageItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener
        public yt1 getProjectExtendInfoManager() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-60840945")) {
                return ProjectBookingRegisterFragment.this.mProjectBookingRegisterDataManager.e();
            }
            return (yt1) ipChange.ipc$dispatch("-60840945", new Object[]{this});
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener
        public void onExtendInfoImageItemClick(View view, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1897321591")) {
                ipChange.ipc$dispatch("-1897321591", new Object[]{this, view, str, str2});
                return;
            }
            ProjectBookingRegisterFragment.this.onExtendInfoItemClick(view, str, str2);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener
        public void onExtendInfoMoreBtnClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-781909002")) {
                ipChange.ipc$dispatch("-781909002", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class j implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1727042540")) {
                ipChange.ipc$dispatch("1727042540", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectBookingRegisterFragment.this.mIvProjectPosterMask.setBackgroundColor(i);
        }
    }

    /* compiled from: Taobao */
    public class k implements BuyButtonStatusHelper.OnBuyBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.view.BuyButtonStatusHelper.OnBuyBtnClickListener
        public void onRemindBookingRegister() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-303774574")) {
                ipChange.ipc$dispatch("-303774574", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(kt1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "bottom", "book_checkin", false));
            ProjectBookingRegisterFragment.this.executeBookingRegisterReq();
        }
    }

    private void displayErrorPage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132752364")) {
            ipChange.ipc$dispatch("-2132752364", new Object[]{this, str, str2, str3});
            return;
        }
        this.mFlPurchaseStatusBarContainer.setVisibility(8);
        this.mLvBottomBar.setVisibility(8);
        this.mFlProjectContentContainer.setVisibility(0);
        this.mTitleBarPanel.l(false);
        onResponseError(str2, str, str3, this.mFlProjectContentContainer, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void executeBookingRegisterReq() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849191976")) {
            ipChange.ipc$dispatch("1849191976", new Object[]{this});
        } else if (isLogin()) {
            startProgressDialog();
            ((ProjectBookingRegisterPresenter) this.mPresenter).bookingRegisterProject(1, this.mProjectId, 11);
        } else {
            startLoginActivityForResult(4116);
        }
    }

    private void executeProjectFollowRequest(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812536254")) {
            ipChange.ipc$dispatch("1812536254", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        ((ProjectBookingRegisterPresenter) this.mPresenter).updateProjectFollowRelation(i2, this.mProjectId, 12);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getAliMeTokenAndEnter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332835995")) {
            ipChange.ipc$dispatch("-332835995", new Object[]{this});
            return;
        }
        String E = d20.E();
        if (!isLogin() || TextUtils.isEmpty(E)) {
            startLoginActivityForResult(CaptureActivity.LOCK_SUCCESS);
            return;
        }
        int k2 = xf2.k(E);
        startProgressDialog();
        AliMeUtil.d(k2, AliMeUtil.FROM_PROJECT_DETAIL, new c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "862874249")) {
            return this.mTitleBarPanel.e();
        }
        return ((Integer) ipChange.ipc$dispatch("862874249", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getProjectBookingRegisterData(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787482201")) {
            ipChange.ipc$dispatch("-1787482201", new Object[]{this, Integer.valueOf(i2)});
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.mProjectBookingRegisterDataManager.i();
            ((ProjectBookingRegisterPresenter) this.mPresenter).retrieveProjectBookingRegisterData(i2, String.valueOf(this.mProjectId));
        }
    }

    private boolean getProjectFollowStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413632297")) {
            return ((Boolean) ipChange.ipc$dispatch("1413632297", new Object[]{this})).booleanValue();
        }
        DynamicExtData dynamicExtData = this.mDynamicExtData;
        if (dynamicExtData != null) {
            return "true".equals(dynamicExtData.getSubFlag());
        }
        return false;
    }

    private String getProjectPosterUrl() {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565710336")) {
            return (String) ipChange.ipc$dispatch("-1565710336", new Object[]{this});
        }
        StaticData staticData = this.mStaticData;
        if (staticData == null || staticData.getItemBase() == null || this.mStaticData.getItemBase().getItemPics() == null || this.mStaticData.getItemBase().getItemPics().getItemPicList() == null || this.mStaticData.getItemBase().getItemPics().getItemPicList().isEmpty() || (picInfo = this.mStaticData.getItemBase().getItemPics().getItemPicList().get(0)) == null) {
            return "";
        }
        return picInfo.getPicUrl();
    }

    private void initBottomViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617067892")) {
            ipChange.ipc$dispatch("-617067892", new Object[]{this});
            return;
        }
        this.mLvBottomBar = this.rootView.findViewById(R$id.project_booking_register_bottom_bar_lv);
        this.mLvCustomerService = (FrameLayout) this.rootView.findViewById(R$id.project_item_bottom_customer_service_lv);
        SeeAnimateView seeAnimateView = (SeeAnimateView) this.rootView.findViewById(R$id.project_bottom_want_to_see_view);
        this.mViewProjectFollow = seeAnimateView;
        seeAnimateView.setCancelImage();
        this.mTvProjectFollowText = (TextView) this.rootView.findViewById(R$id.project_item_bottom_follow_text_tv);
        this.mFlPurchaseStatusBarContainer = (FrameLayout) this.rootView.findViewById(R$id.trade_project_detail_purchase_status_bar_container_fl);
    }

    private void initBuyBtnListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865487334")) {
            ipChange.ipc$dispatch("865487334", new Object[]{this});
            return;
        }
        this.mBuyButtonStatusHelper.h(new k());
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981843755")) {
            ipChange.ipc$dispatch("-981843755", new Object[]{this});
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
                    this.mProjectDetailActivity = (ProjectDetailActivity) getActivity();
                    return;
                }
            }
            getActivity().finish();
            return;
        }
        getActivity().finish();
    }

    private void initHeadBarView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045359593")) {
            ipChange.ipc$dispatch("-2045359593", new Object[]{this});
            return;
        }
        ProjectTitleBarPanel projectTitleBarPanel = new ProjectTitleBarPanel(getActivity(), this.rootView.findViewById(R$id.project_book_title), new e());
        this.mTitleBarPanel = projectTitleBarPanel;
        projectTitleBarPanel.k("商品详情");
    }

    private void initHeadViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939266111")) {
            ipChange.ipc$dispatch("-939266111", new Object[]{this});
            return;
        }
        this.mIvProjectPosterMask = (ImageView) this.rootView.findViewById(R$id.project_poster_mask_iv);
        initHeadBarView();
        initProjectInfoView();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902264752")) {
            ipChange.ipc$dispatch("-902264752", new Object[]{this});
            return;
        }
        this.mOnRefreshListener = new f();
        this.mOnCustomerServiceClickListener = new g();
        this.mOnProjectFollowClickListener = new h();
        this.mOnExtendInfoImageItemClickListener = new i();
    }

    private void initProjectDataHolderManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548213443")) {
            ipChange.ipc$dispatch("-548213443", new Object[]{this});
            return;
        }
        this.mProjectBookingRegisterDataManager = new jt1(this.mProjectDetailActivity);
    }

    private void initProjectInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1780788925")) {
            ipChange.ipc$dispatch("-1780788925", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mProjectDetailActivity).inflate(R$layout.project_book_header_wrap, (ViewGroup) this.mRecyclerView.getHeaderContainer(), false);
        this.mLvProjectDetailHeader = linearLayout;
        this.mHeadPanel = new it1(this.mProjectDetailActivity, this.mProjectId, linearLayout.findViewById(R$id.project_book_header), this.headClickListener);
        this.mRecyclerView.addHeaderView(this.mLvProjectDetailHeader);
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001824449")) {
            ipChange.ipc$dispatch("2001824449", new Object[]{this});
            return;
        }
        this.mPullToRefreshView = (PullToRefreshView) this.rootView.findViewById(R$id.project_booking_register_pull_to_refresh_view);
        this.mRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.project_booking_register_recycler_view);
        this.mProjectBookingRegisterAdapter = new ProjectBookingRegisterAdapter(this.mProjectDetailActivity, this.mProjectId);
        WrapLinearLayoutManager wrapLinearLayoutManager = new WrapLinearLayoutManager(this.mProjectDetailActivity);
        this.mLinearLayoutManager = wrapLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(wrapLinearLayoutManager);
        this.mRecyclerView.setAdapter(this.mProjectBookingRegisterAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        initHeadViews();
        initBottomViews();
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R$id.project_booking_register_error_page_container);
        this.mFlProjectContentContainer = frameLayout;
        frameLayout.setVisibility(8);
    }

    private boolean isLogin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1089366148")) {
            return LoginManager.k().q();
        }
        return ((Boolean) ipChange.ipc$dispatch("1089366148", new Object[]{this})).booleanValue();
    }

    private boolean isShowErrorPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1707831277")) {
            return this.mStaticData == null && this.mDynamicExtData == null && this.mItemData == null;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1707831277", new Object[]{this})).booleanValue();
    }

    public static ProjectBookingRegisterFragment newInstance(ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627451797")) {
            return (ProjectBookingRegisterFragment) ipChange.ipc$dispatch("1627451797", new Object[]{projectDetailExtrasData});
        }
        ProjectBookingRegisterFragment projectBookingRegisterFragment = new ProjectBookingRegisterFragment();
        if (projectDetailExtrasData != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("projectExtraData", projectDetailExtrasData);
            projectBookingRegisterFragment.setArguments(bundle);
        }
        return projectBookingRegisterFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollToPosition(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830964666")) {
            ipChange.ipc$dispatch("1830964666", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.mRecyclerView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        this.mLinearLayoutManager.scrollToPositionWithOffset(i2, i3);
    }

    private void setExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573392723")) {
            ipChange.ipc$dispatch("573392723", new Object[]{this});
            return;
        }
        ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData = this.mProjectExtraData;
        if (projectDetailExtrasData != null) {
            String str = projectDetailExtrasData.projectImage;
            String str2 = projectDetailExtrasData.projectName;
            it1 it1 = this.mHeadPanel;
            if (it1 != null) {
                it1.e(str, str2);
            }
        }
        this.mProjectBookingRegisterAdapter.a(this.mProjectBookingRegisterDataManager.c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProjectDetailMaskLayerImage(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808741911")) {
            ipChange.ipc$dispatch("808741911", new Object[]{this, str, bitmap});
            return;
        }
        try {
            DMRGBUtil.g(1.0f, bitmap, str, new j());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setProjectFollowStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245211587")) {
            ipChange.ipc$dispatch("1245211587", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DynamicExtData dynamicExtData = this.mDynamicExtData;
        if (dynamicExtData != null) {
            dynamicExtData.setSubFlag(z ? "true" : "false");
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "684685033")) {
            ipChange.ipc$dispatch("684685033", new Object[]{this});
            return;
        }
        this.mPullToRefreshView.setOnRefreshListener(this.mOnRefreshListener);
        this.mLvCustomerService.setOnClickListener(this.mOnCustomerServiceClickListener);
        this.mViewProjectFollow.setOnClickListener(this.mOnProjectFollowClickListener);
        this.mProjectBookingRegisterAdapter.c(this.mOnExtendInfoImageItemClickListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void shareProjectInfo() {
        String str;
        String str2;
        StaticData.ItemBase itemBase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914567651")) {
            ipChange.ipc$dispatch("914567651", new Object[]{this});
        } else if (this.mStaticData != null) {
            cn.damai.common.user.c.e().x(kt1.h().i(String.valueOf(this.mProjectId), "top", "share", false));
            String projectPosterUrl = getProjectPosterUrl();
            StaticData staticData = this.mStaticData;
            if (staticData == null || (itemBase = staticData.getItemBase()) == null) {
                str2 = "";
                str = str2;
            } else {
                String itemName = itemBase.getItemName();
                str = itemBase.getCityName();
                str2 = itemName;
            }
            Bundle a2 = wt1.a(this.mProjectId, "https://m.damai.cn/damai/project/item.html?id=", str2, "", str, "", projectPosterUrl, "", "", "projectBooking", "chat_h5", false);
            if (a2 != null) {
                ShareManager.E().T(this.mProjectDetailActivity, a2, LayoutInflater.from(getContext()).inflate(R$layout.project_booking_register_fragment_layout, (ViewGroup) null));
                ShareManager E = ShareManager.E();
                ShareManager E2 = ShareManager.E();
                Context context = getContext();
                E.e0(E2.F(context, 1, this.mProjectId + "", 1));
                ShareManager.E().l0();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startBrowseImageWithTextActivity(ArrayList<PicInfo> arrayList, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818123309")) {
            ipChange.ipc$dispatch("-818123309", new Object[]{this, arrayList, Integer.valueOf(i2)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", i2);
        DMNav.from(this.mProjectDetailActivity).withExtras(bundle).toUri(gr.e());
    }

    private void startLoginActivityForResult(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930587956")) {
            ipChange.ipc$dispatch("930587956", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        DMNav.from(this.mProjectDetailActivity).forResult(i2).toUri(gr.f());
    }

    private void updateItemData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453543067")) {
            ipChange.ipc$dispatch("-453543067", new Object[]{this});
            return;
        }
        ItemData itemData = this.mItemData;
        if (itemData == null) {
            return;
        }
        if (this.mBuyButtonStatusHelper == null) {
            BuyButtonStatusHelper buyButtonStatusHelper = new BuyButtonStatusHelper(this.mProjectDetailActivity, itemData, this.mProjectId, this.mFlPurchaseStatusBarContainer);
            this.mBuyButtonStatusHelper = buyButtonStatusHelper;
            View d2 = buyButtonStatusHelper.d();
            this.mViewPurchaseStatusContent = d2;
            this.mFlPurchaseStatusBarContainer.addView(d2);
            initBuyBtnListeners();
            this.mFlPurchaseStatusBarContainer.setVisibility(0);
            return;
        }
        this.mFlPurchaseStatusBarContainer.setVisibility(0);
        this.mBuyButtonStatusHelper.i(this.mItemData);
    }

    private void updateProjectDataHolders() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019387202")) {
            ipChange.ipc$dispatch("-1019387202", new Object[]{this});
            return;
        }
        List<ProjectDataHolder> d2 = this.mProjectBookingRegisterDataManager.d(this.mStaticData);
        if (xf2.e(d2) > 0) {
            this.mProjectBookingRegisterAdapter.b(d2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateProjectFollowRelation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505009698")) {
            ipChange.ipc$dispatch("1505009698", new Object[]{this});
        } else if (!isLogin()) {
            startLoginActivityForResult(4097);
            cn.damai.common.user.c.e().x(kt1.h().g(String.valueOf(this.mProjectId), "top", "favorite", "0"));
        } else if (getProjectFollowStatus()) {
            cn.damai.common.user.c.e().x(kt1.h().g(String.valueOf(this.mProjectId), "top", "favorite", "0"));
            executeProjectFollowRequest(0);
        } else {
            executeProjectFollowRequest(1);
            cn.damai.common.user.c.e().x(kt1.h().g(String.valueOf(this.mProjectId), "top", "favorite", "1"));
        }
    }

    private void updateProjectFollowStatus(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687063825")) {
            ipChange.ipc$dispatch("-1687063825", new Object[]{this, followDataBean});
        } else if (followDataBean.getStatus() >= 1) {
            ToastUtil.a().j(this.mProjectDetailActivity, "已添加想看");
            setProjectFollowStatus(true);
            this.mViewProjectFollow.clickAnimate();
            this.mTvProjectFollowText.setText(R$string.i_want_to_see);
        } else {
            setProjectFollowStatus(false);
            this.mViewProjectFollow.cancelAnimate();
            this.mTvProjectFollowText.setText(R$string.want_to_see);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateRefreshable() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970427667")) {
            ipChange.ipc$dispatch("1970427667", new Object[]{this});
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
                this.mPullToRefreshView.setPullToRefreshEnabled(true);
            } else {
                this.mPullToRefreshView.setPullToRefreshEnabled(false);
            }
        } else {
            this.mPullToRefreshView.setPullToRefreshEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTitleStyle() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797871671")) {
            ipChange.ipc$dispatch("-797871671", new Object[]{this});
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

    private void updateWantToSeeStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169393774")) {
            ipChange.ipc$dispatch("1169393774", new Object[]{this});
            return;
        }
        DynamicExtData dynamicExtData = this.mDynamicExtData;
        if (dynamicExtData == null) {
            return;
        }
        if ("true".equals(dynamicExtData.getSubFlag())) {
            this.mViewProjectFollow.setFollowImage();
            this.mTvProjectFollowText.setText(R$string.i_want_to_see);
            return;
        }
        this.mViewProjectFollow.setCancelImage();
        this.mTvProjectFollowText.setText(R$string.want_to_see);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1210757028")) {
            return R$layout.project_booking_register_fragment_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1210757028", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967624548")) {
            ipChange.ipc$dispatch("967624548", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        getProjectBookingRegisterData(1);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302451015")) {
            ipChange.ipc$dispatch("1302451015", new Object[]{this});
            return;
        }
        ((ProjectBookingRegisterPresenter) this.mPresenter).setVM(this, (ProjectBookingRegisterContract.Model) this.mModel);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727070966")) {
            ipChange.ipc$dispatch("1727070966", new Object[]{this});
            return;
        }
        initExtraData();
        initProjectDataHolderManager();
        initViews();
        initListeners();
        setupListeners();
        setExtraData();
        getProjectBookingRegisterData(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728221999")) {
            ipChange.ipc$dispatch("1728221999", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setDamaiUTKeyBuilder(ln2.r().f0(this.mProjectId));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032364707")) {
            ipChange.ipc$dispatch("-1032364707", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        ShareManager.E().r0(i2, i3, intent);
        if (i2 == 2000 && i3 == 1000) {
            this.mProjectDetailActivity.finish();
        } else if (i2 == 4097 && i3 == -1) {
            updateProjectFollowRelation();
        } else if (i2 == 4115 && i3 == -1) {
            getAliMeTokenAndEnter();
        } else if (i2 == 4116 && i3 == -1) {
            executeBookingRegisterReq();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onBookingRegisterError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295815636")) {
            ipChange.ipc$dispatch("1295815636", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.a().j(this.mProjectDetailActivity, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onBookingRegisterSuccess(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109143528")) {
            ipChange.ipc$dispatch("109143528", new Object[]{this, followDataBean});
            return;
        }
        stopProgressDialog();
        if (followDataBean.getStatus() != 1) {
            ToastUtil.a().e(this.mProjectDetailActivity, getString(R$string.booking_register_failure));
        } else if (PermissionsHelper.a(this.mProjectDetailActivity)) {
            DMDialog dMDialog = new DMDialog(getActivity());
            dMDialog.v("提交成功");
            dMDialog.q("开售前，将通过APP通知");
            dMDialog.n("知道了", null);
            dMDialog.show();
        } else {
            ProjectDetailActivity projectDetailActivity = this.mProjectDetailActivity;
            if (projectDetailActivity != null && !projectDetailActivity.isFinishing()) {
                PermissionsHelper.c(this.mProjectDetailActivity, "未开启推送通知", false, "「设置」-「状态栏与通知」-「通知管理」", "立即开启", new a(), "取消", new b(this));
            }
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37329756")) {
            ipChange.ipc$dispatch("37329756", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079980932")) {
            ipChange.ipc$dispatch("2079980932", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mIsFirstEnter = true;
    }

    public void onExtendInfoItemClick(View view, String str, String str2) {
        LinkedHashMap<String, Integer> g2;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-711096171")) {
            ipChange.ipc$dispatch("-711096171", new Object[]{this, view, str, str2});
        } else if (!TextUtils.isEmpty(str2) && (g2 = this.mProjectBookingRegisterDataManager.e().g()) != null) {
            try {
                Integer num = g2.get(str2);
                if (num != null) {
                    i2 = num.intValue();
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                DMNav.from(this.mActivity).toUri(str);
                cn.damai.common.user.c.e().x(ln2.r().u0(this.mProjectId, i2));
                return;
            }
            ArrayList<PicInfo> arrayList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : g2.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(key);
                    arrayList.add(picInfo);
                }
            }
            cn.damai.common.user.c.e().x(ln2.r().u0(this.mProjectId, i2));
            startBrowseImageWithTextActivity(arrayList, i2);
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649718049")) {
            ipChange.ipc$dispatch("-649718049", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686197990")) {
            ipChange.ipc$dispatch("1686197990", new Object[]{this});
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onProjectFollowError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140224162")) {
            ipChange.ipc$dispatch("2140224162", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.a().j(this.mProjectDetailActivity, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onProjectFollowSuccess(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967625418")) {
            ipChange.ipc$dispatch("-967625418", new Object[]{this, followDataBean});
            return;
        }
        stopProgressDialog();
        if (followDataBean != null) {
            updateProjectFollowStatus(followDataBean);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897069441")) {
            ipChange.ipc$dispatch("-1897069441", new Object[]{this});
            return;
        }
        super.onResume();
        if (!this.mIsFirstEnter) {
            getProjectBookingRegisterData(2);
        } else {
            this.mIsFirstEnter = true;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onReturnBookingRegisterDataError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607739608")) {
            ipChange.ipc$dispatch("1607739608", new Object[]{this, str, str2, str3});
            return;
        }
        this.mPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        if (isShowErrorPage()) {
            displayErrorPage(str, str2, str3);
        } else {
            ToastUtil.a().j(this.mProjectDetailActivity, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onReturnBookingRegisterDataSuccess(int i2, ProjectBookingRegisterData projectBookingRegisterData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950976386")) {
            ipChange.ipc$dispatch("-1950976386", new Object[]{this, Integer.valueOf(i2), projectBookingRegisterData});
            return;
        }
        this.mPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        if (projectBookingRegisterData != null) {
            updateRefreshable();
            if (i2 == 1 || i2 == 0) {
                this.mTitleBarPanel.l(true);
            }
            this.mFlProjectContentContainer.setVisibility(8);
            this.mLvBottomBar.setVisibility(0);
            StaticData staticData = projectBookingRegisterData.getStaticData();
            this.mStaticData = staticData;
            this.mHeadPanel.d(staticData);
            updateProjectDataHolders();
            if (this.mStaticData != null) {
                this.mTitleBarPanel.m("");
            }
            this.mDynamicExtData = projectBookingRegisterData.getDynamicExtData();
            updateWantToSeeStatus();
            this.mItemData = projectBookingRegisterData.getItem();
            updateItemData();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248485962")) {
            ipChange.ipc$dispatch("1248485962", new Object[]{this});
            return;
        }
        super.onStop();
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75328138")) {
            ipChange.ipc$dispatch("75328138", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051312838")) {
            ipChange.ipc$dispatch("1051312838", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548277290")) {
            ipChange.ipc$dispatch("1548277290", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114228443")) {
            ipChange.ipc$dispatch("-2114228443", new Object[]{this});
        }
    }
}

package cn.damai.homepage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.comment.bean.CommentOptrBean;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.commonbusiness.home.bean.HomeContentFloatBean;
import cn.damai.commonbusiness.home.bean.HomeFloatResBean;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.home.request.HomeFloatLayerRequest;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.tab.BottomSheetBean;
import cn.damai.commonbusiness.tab.DamaiTabViewHelper;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarDataManager;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.commonbusiness.tab.download.ImageDownLoader;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.evaluate.request.CommentListOptrRequest;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.bean.HomeZhibotiaoBean;
import cn.damai.homepage.bean.SetPrivacyPermissionBean;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.homepage.request.BottomSheetRequest;
import cn.damai.homepage.request.PopUpAdvertCallBackRequest;
import cn.damai.homepage.request.PopUpAdvertRequest;
import cn.damai.homepage.request.SetupPermissionListRequest;
import cn.damai.homepage.ui.fragment.HomeCmsFragment;
import cn.damai.homepage.ui.fragment.HomeFragmentAgent;
import cn.damai.homepage.ui.fragment.HomeTabFragment;
import cn.damai.homepage.ui.view.ContentPopTipPanel;
import cn.damai.homepage.ui.view.HomeLottieView;
import cn.damai.homepage.ui.view.HomepageEvaluateDialog;
import cn.damai.homepage.ui.view.ZhiboView;
import cn.damai.homepage.util.LoginLogoutBroadcastReceiver;
import cn.damai.homepage.util.MemberGuideDialogManger;
import cn.damai.homepage.util.TickletBusinessUtil;
import cn.damai.homepage.util.window.PopupCallback;
import cn.damai.homepage.v2.HomePageFragment;
import cn.damai.launcher.splash.SplashMainActivity;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.util.TDialog;
import cn.damai.uikit.view.DMProtocolDialog;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.wantsee.GuideUtProvider;
import cn.damai.wantsee.StartConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.component.home.notice.HomeNoticeView;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import tb.a03;
import tb.aa0;
import tb.ax0;
import tb.bk2;
import tb.br;
import tb.cy2;
import tb.d20;
import tb.f92;
import tb.fp1;
import tb.fw0;
import tb.g91;
import tb.hp1;
import tb.ht0;
import tb.i3;
import tb.jp1;
import tb.jq2;
import tb.jx0;
import tb.l3;
import tb.lk1;
import tb.lp1;
import tb.lw0;
import tb.ne2;
import tb.np2;
import tb.nr1;
import tb.ol1;
import tb.p81;
import tb.pn;
import tb.pp2;
import tb.rs1;
import tb.rx0;
import tb.s41;
import tb.tf0;
import tb.tj;
import tb.u02;
import tb.v50;
import tb.vw0;
import tb.xf2;
import tb.xs0;
import tb.xx2;
import tb.yr;
import tb.z91;

@PopLayer.PopupAllowedFromFragment
/* compiled from: Taobao */
public class MainActivity extends DamaiBaseActivity implements DamaiConstants, PageUtExecutor.FragmentPropertiesProvider, DamaiTabViewHelper.OnHomeIconTabStateChangedListener, TabbarLayout.TabBarListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HOMEPAGE_EVALUATE_RESULT = 1010;
    public static final String KEY_G_ID = "groupId";
    public static final String KEY_ID = "id";
    public static final String KEY_TYPE = "type";
    public static final int REQUEST_CODE_CITY = 78;
    public static final String SHOW_SPLASH_AD = "show_splash_ad";
    public static final String SP_KEY_LOCATION_DIALOG_SHOWED = "locationExaKey";
    private final int LOGIN_RESULT = 1008;
    private final int SETTING_RESULT = 1009;
    private boolean canShowLottie;
    boolean checkedSuccess;
    Map<String, Map> fragmentPropertiesMap = new HashMap();
    private boolean homeIsOnPause;
    int index = 0;
    private String lottieFilePath;
    private boolean lottieIsShowed;
    private boolean lottieLoadSuccess;
    private Dialog mAdView;
    private HomeLottieView mAnimationView;
    private CityLocationUtil mCityLocationUtil;
    private String mCurrentCity;
    long mExitTime = -1;
    private HomeData mHomeData;
    private HomeFragmentAgent mHomeTabFragment;
    private boolean mIsUseNewHome;
    private CityLocationUtil.LocaltionListener mLocaltionListener = new o();
    private LoginLogoutBroadcastReceiver mLoginReceiver;
    public MainAlertEntity mMainAlertEntity = null;
    private MemberGuideDialogManger mMemberDialogManger;
    private ContentPopTipPanel mPopTipPanel;
    private TabExtra mTabExtra;
    private TabbarLayout mTabbarLayout;
    private DamaiTabbarManager mTabbarManager;
    private FrameLayout mTickletContainer;
    private ZhiboView mZhiboView;
    private HomeZhibotiaoBean mZhibotiaoBean;
    boolean reCheckSuccess = true;
    private u02 responsiveActivityStateManager;
    private TickletBusinessUtil tickletBusinessUtil = new TickletBusinessUtil(this);
    private DMDialog timeZoneDialog;
    boolean uncheckSuccess;
    private WantSeePosterTips wantSeeProjectTips;
    private WantSeeTips wantSeeTips;

    /* compiled from: Taobao */
    public class a implements Action<HomePageRecentBean.Labels.HomePageRecentItems> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1415139276")) {
                ipChange.ipc$dispatch("1415139276", new Object[]{this, homePageRecentItems});
                return;
            }
            MainActivity.this.wantActionShow(homePageRecentItems.projectId);
        }
    }

    /* compiled from: Taobao */
    public class b implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(MainActivity mainActivity, String str) {
            this.a = str;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "686163768")) {
                return getGuideExposeArgMap();
            }
            return (Map) ipChange.ipc$dispatch("686163768", new Object[]{this});
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-643944776")) {
                return (Map) ipChange.ipc$dispatch("-643944776", new Object[]{this});
            }
            HashMap<String, String> f = a03.f();
            f.put("item_id", this.a);
            return f;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1650928299")) {
                return getGuideExposeArgMap();
            }
            return (Map) ipChange.ipc$dispatch("1650928299", new Object[]{this});
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1714953361")) {
                return "home";
            }
            return (String) ipChange.ipc$dispatch("1714953361", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public class c implements ImageDownLoader.AsyncImageLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomSheetBean a;
        final /* synthetic */ ImageDownLoader b;

        c(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
            this.a = bottomSheetBean;
            this.b = imageDownLoader;
        }

        @Override // cn.damai.commonbusiness.tab.download.ImageDownLoader.AsyncImageLoaderListener
        public void onImageLoader(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "85832587")) {
                ipChange.ipc$dispatch("85832587", new Object[]{this, bitmap});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.reCheckSuccess = true;
            if (mainActivity.checkedSuccess && mainActivity.uncheckSuccess) {
                mainActivity.loadImage(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements ImageDownLoader.AsyncImageLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomSheetBean a;
        final /* synthetic */ ImageDownLoader b;

        d(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
            this.a = bottomSheetBean;
            this.b = imageDownLoader;
        }

        @Override // cn.damai.commonbusiness.tab.download.ImageDownLoader.AsyncImageLoaderListener
        public void onImageLoader(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614907892")) {
                ipChange.ipc$dispatch("-1614907892", new Object[]{this, bitmap});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.checkedSuccess = true;
            if (mainActivity.uncheckSuccess && mainActivity.reCheckSuccess) {
                mainActivity.loadImage(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements ImageDownLoader.AsyncImageLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomSheetBean a;
        final /* synthetic */ ImageDownLoader b;

        e(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
            this.a = bottomSheetBean;
            this.b = imageDownLoader;
        }

        @Override // cn.damai.commonbusiness.tab.download.ImageDownLoader.AsyncImageLoaderListener
        public void onImageLoader(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "979318925")) {
                ipChange.ipc$dispatch("979318925", new Object[]{this, bitmap});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.uncheckSuccess = true;
            if (mainActivity.checkedSuccess && mainActivity.reCheckSuccess) {
                mainActivity.loadImage(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        f(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "481500995")) {
                ipChange.ipc$dispatch("481500995", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            yr.b(MainActivity.this, this.a);
            if (this.b) {
                MainActivity.this.checkRecentTicket();
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements IResponsivePage {
        private static transient /* synthetic */ IpChange $ipChange;

        g(MainActivity mainActivity) {
        }

        @Override // com.alibaba.pictures.responsive.page.IResponsivePage
        public void onResponsiveLayout(@Nullable Configuration configuration, int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2140388562")) {
                ipChange.ipc$dispatch("-2140388562", new Object[]{this, configuration, Integer.valueOf(i), Boolean.valueOf(z)});
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1256839143")) {
                ipChange.ipc$dispatch("-1256839143", new Object[]{this, dialogInterface});
                return;
            }
            MainActivity.this.checkUpdate();
        }
    }

    /* compiled from: Taobao */
    public class i implements HomepageEvaluateDialog.OnUserRejectListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.homepage.ui.view.HomepageEvaluateDialog.OnUserRejectListener
        public void onUserReject(CouponListResponse.ContentList contentList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-978577835")) {
                ipChange.ipc$dispatch("-978577835", new Object[]{this, contentList});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.showEvaluateTips(mainActivity.getString(R$string.damai_homepage_comment_await_comment_tips));
            MainActivity.this.reportUserOperation(contentList.targetId, 1);
        }
    }

    /* compiled from: Taobao */
    public class j implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "404006009")) {
                ipChange.ipc$dispatch("404006009", new Object[]{this, dVar});
                return;
            }
            MainActivity.this.checkUpdate();
        }
    }

    /* compiled from: Taobao */
    public class k implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MainAlertEntity.MainAlertModel a;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-175421290")) {
                    ipChange.ipc$dispatch("-175421290", new Object[]{this, view});
                } else if (MainActivity.this.mAdView != null && MainAlertEntity.PICK_TYPE_CALLBACK.equals(MainActivity.this.mMainAlertEntity.item.pkType)) {
                    cn.damai.common.user.c.e().x(ax0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "0", 1, k.this.a.imageUrl));
                }
            }
        }

        /* compiled from: Taobao */
        public class b implements TDialog.OnDialogShowTimeListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1922647442")) {
                    ipChange.ipc$dispatch("1922647442", new Object[]{this, Long.valueOf(j)});
                } else if (MainAlertEntity.PICK_TYPE_CALLBACK.equals(MainActivity.this.mMainAlertEntity.item.pkType)) {
                    MainAlertEntity.MainAlertModel mainAlertModel = MainActivity.this.mMainAlertEntity.item;
                    ax0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "0", k.this.a.imageUrl);
                } else {
                    k kVar = k.this;
                    MainAlertEntity.MainAlertModel mainAlertModel2 = MainActivity.this.mMainAlertEntity.item;
                    ax0.o(j, mainAlertModel2.schema, mainAlertModel2.scm, kVar.a.imageUrl);
                }
            }
        }

        /* compiled from: Taobao */
        public class c implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;

            c() {
            }

            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "927401710")) {
                    ipChange.ipc$dispatch("927401710", new Object[]{this, dialogInterface});
                    return;
                }
                MainActivity.this.checkUpdate();
            }
        }

        k(MainAlertEntity.MainAlertModel mainAlertModel) {
            this.a = mainAlertModel;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "599855887")) {
                ipChange.ipc$dispatch("599855887", new Object[]{this, eVar});
            } else if (MainActivity.this.isActivityFinsihed() || !MainActivity.this.isActivityForeground() || (bitmap = eVar.b) == null) {
                MainActivity.this.checkUpdate();
            } else {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.mAdView = DialogUtil.a(mainActivity, bitmap, new z(), new a(), new b());
                MainActivity.this.mAdView.setOnDismissListener(new c());
                MainActivity.this.mAdView.show();
            }
        }
    }

    /* compiled from: Taobao */
    public class l implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1198884348")) {
                ipChange.ipc$dispatch("1198884348", new Object[]{this, dVar});
                return;
            }
            MainActivity.this.checkUpdate();
        }
    }

    /* compiled from: Taobao */
    public class m implements HomeTabFragment.OnTabClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // cn.damai.homepage.ui.fragment.HomeTabFragment.OnTabClickListener
        public void onTabSelect(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "841777020")) {
                ipChange.ipc$dispatch("841777020", new Object[]{this, Integer.valueOf(i)});
            } else if (i != 0) {
                MainActivity.this.mZhiboView.f(8);
            } else if (MainActivity.this.mZhiboView.e()) {
                MainActivity.this.mZhiboView.f(0);
            }
        }
    }

    /* compiled from: Taobao */
    public class n implements PopupCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void cityChangeRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1879341370")) {
                ipChange.ipc$dispatch("1879341370", new Object[]{this});
            } else if (MainActivity.this.mHomeTabFragment != null) {
                MainActivity.this.mHomeTabFragment.refreshAllFragment();
            }
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void evaluateOnUserReject(@NonNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "208496504")) {
                ipChange.ipc$dispatch("208496504", new Object[]{this, str});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.showEvaluateTips(mainActivity.getString(R$string.damai_homepage_comment_await_comment_tips));
            MainActivity.this.reportUserOperation(str, 1);
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public boolean isHomePageTab() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1274867425")) {
                return MainActivity.this.isHomePage();
            }
            return ((Boolean) ipChange.ipc$dispatch("1274867425", new Object[]{this})).booleanValue();
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void loadFloat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1253526212")) {
                ipChange.ipc$dispatch("1253526212", new Object[]{this});
                return;
            }
            MainActivity.this.loadFloatInfo();
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void showLottie() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2072702324")) {
                ipChange.ipc$dispatch("2072702324", new Object[]{this});
                return;
            }
            MainActivity.this.showLottieBeforeAlertDialog();
        }
    }

    /* compiled from: Taobao */
    public class o implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ boolean a;
            final /* synthetic */ SitesBean b;

            a(boolean z, SitesBean sitesBean) {
                this.a = z;
                this.b = sitesBean;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-792085819")) {
                    ipChange.ipc$dispatch("-792085819", new Object[]{this, dialogInterface});
                } else if (this.a) {
                    MainActivity.this.showCityChange(this.b.getCityName());
                } else {
                    MainActivity.this.checkRecentTicket();
                }
            }
        }

        o() {
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1645139882")) {
                ipChange.ipc$dispatch("-1645139882", new Object[]{this});
                return;
            }
            MainActivity.this.checkRecentTicket();
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-6295458")) {
                ipChange.ipc$dispatch("-6295458", new Object[]{this, sitesBean});
                return;
            }
            if ((sitesBean == null || TextUtils.getTrimmedLength(sitesBean.getCityId()) <= 0 || String.valueOf(xs0.b).equals(sitesBean.getCityId())) && MainActivity.this.mCurrentCity.equals(sitesBean.getCityName())) {
                z = false;
            }
            if (MainActivity.this.timeZoneDialog != null && MainActivity.this.timeZoneDialog.isShowing()) {
                MainActivity.this.timeZoneDialog.setOnDismissListener(new a(z, sitesBean));
            } else if (z) {
                MainActivity.this.showCityChange(sitesBean.getCityName());
            } else {
                MainActivity.this.checkRecentTicket();
            }
        }
    }

    /* compiled from: Taobao */
    public class p implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        p() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "470226915")) {
                ipChange.ipc$dispatch("470226915", new Object[]{this, view});
                return;
            }
            MainActivity.this.checkRecentTicket();
        }
    }

    /* compiled from: Taobao */
    public class q implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        q() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1056536565")) {
                ipChange.ipc$dispatch("-1056536565", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            if (MainActivity.this.mCityLocationUtil != null) {
                MainActivity.this.mCityLocationUtil.q();
            }
            dialogInterface.dismiss();
            br.c(DamaiConstants.CITY_CHANGED, "");
            if (MainActivity.this.mHomeTabFragment != null) {
                MainActivity.this.mHomeTabFragment.refreshAllFragment();
            }
            MainActivity.this.checkRecentTicket();
        }
    }

    /* compiled from: Taobao */
    public class r implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1985873021")) {
                    ipChange.ipc$dispatch("1985873021", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                jp1.f(MainActivity.this);
                MainActivity.this.checkTimeZone(true);
            }
        }

        /* compiled from: Taobao */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1339513252")) {
                    ipChange.ipc$dispatch("-1339513252", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                MainActivity.this.checkTimeZone(true);
            }
        }

        r() {
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "340330804")) {
                ipChange.ipc$dispatch("340330804", new Object[]{this, strArr});
                return;
            }
            MainActivity.this.checkTimeZone(true);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "804580585")) {
                ipChange.ipc$dispatch("804580585", new Object[]{this});
                return;
            }
            MainActivity.this.checkTimeZone(false);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.mCityLocationUtil = new CityLocationUtil(mainActivity, mainActivity.mLocaltionListener);
            MainActivity.this.mCityLocationUtil.p(true);
            MainActivity.this.mCityLocationUtil.n();
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1795699620")) {
                ipChange.ipc$dispatch("1795699620", new Object[]{this, strArr});
                return;
            }
            fp1.a(MainActivity.this, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new a(), new b());
        }
    }

    /* compiled from: Taobao */
    public class s implements LoginLogoutBroadcastReceiver.LoginCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        s() {
        }

        @Override // cn.damai.homepage.util.LoginLogoutBroadcastReceiver.LoginCallback
        public void loginLogout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "138660833")) {
                ipChange.ipc$dispatch("138660833", new Object[]{this});
                return;
            }
            tb.d.f().doNotifyUserLogout();
            MainActivity.this.mHomeTabFragment.logoutRefreshUI();
        }

        @Override // cn.damai.homepage.util.LoginLogoutBroadcastReceiver.LoginCallback
        public void loginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-230075108")) {
                ipChange.ipc$dispatch("-230075108", new Object[]{this});
                return;
            }
            tb.d.f().doNotifyUserLogin(Login.getUserId());
        }
    }

    /* compiled from: Taobao */
    public class t implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        t() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1949252308")) {
                ipChange.ipc$dispatch("-1949252308", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            MainActivity.this.exitApp();
        }
    }

    /* compiled from: Taobao */
    public class u implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        u() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1853793952")) {
                ipChange.ipc$dispatch("-1853793952", new Object[]{this, str});
            } else if (!TextUtils.isEmpty(str)) {
                MainActivity.this.lottieFilePath = str;
                MainActivity.this.lottieLoadSuccess = true;
                if (MainActivity.this.canShowLottie && !MainActivity.this.homeIsOnPause) {
                    MainActivity.this.showLottie();
                }
            } else {
                MainActivity.this.lottieLoadSuccess = false;
                g91.b("LottieDownLoad", "营销动画下载失败！");
            }
        }
    }

    /* compiled from: Taobao */
    public class v implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        v() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "854406972")) {
                ipChange.ipc$dispatch("854406972", new Object[]{this, dialogInterface});
                return;
            }
            MainActivity.this.checkUpdate();
        }
    }

    /* compiled from: Taobao */
    public class w implements TickletBusinessUtil.PopNoShow {
        private static transient /* synthetic */ IpChange $ipChange;

        w() {
        }

        @Override // cn.damai.homepage.util.TickletBusinessUtil.PopNoShow
        public void popNoShow() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "177154405")) {
                ipChange.ipc$dispatch("177154405", new Object[]{this});
                return;
            }
            MainActivity.this.checkAlertDialog();
        }
    }

    /* compiled from: Taobao */
    public class x implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        x() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-412695320")) {
                ipChange.ipc$dispatch("-412695320", new Object[]{this, view});
            } else if (!MainActivity.this.isFinishing() && MainActivity.this.mTabbarManager != null) {
                MainActivity.this.mTabbarManager.m(DamaiConstants.TAB_FIND);
            }
        }
    }

    /* compiled from: Taobao */
    public class y implements MemberGuideDialogManger.IMemberDialogDispatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-773698548")) {
                    ipChange.ipc$dispatch("-773698548", new Object[]{this, dialogInterface});
                    return;
                }
                MainActivity.this.checkUpdate();
            }
        }

        y() {
        }

        @Override // cn.damai.homepage.util.MemberGuideDialogManger.IMemberDialogDispatcher
        public void dialogToShow(Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "979954033")) {
                ipChange.ipc$dispatch("979954033", new Object[]{this, dialog});
                return;
            }
            dialog.setOnDismissListener(new a());
            dialog.show();
        }
    }

    /* compiled from: Taobao */
    public class z implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        z() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-49825495")) {
                ipChange.ipc$dispatch("-49825495", new Object[]{this, view});
                return;
            }
            MainAlertEntity mainAlertEntity = MainActivity.this.mMainAlertEntity;
            if (!(mainAlertEntity == null || mainAlertEntity.item == null)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(MonitorType.SKIP, true);
                bundle.putString("from_page", "homepage");
                DMNav.from(MainActivity.this).withExtras(bundle).toUri(MainActivity.this.mMainAlertEntity.item.schema);
                if (MainAlertEntity.PICK_TYPE_CALLBACK.equals(MainActivity.this.mMainAlertEntity.item.pkType)) {
                    cn.damai.common.user.c.e().x(ax0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "0", 0, MainActivity.this.mMainAlertEntity.item.imageUrl));
                } else {
                    cn.damai.common.user.c e = cn.damai.common.user.c.e();
                    ax0 I = ax0.I();
                    MainAlertEntity mainAlertEntity2 = MainActivity.this.mMainAlertEntity;
                    MainAlertEntity.MainAlertModel mainAlertModel = mainAlertEntity2.item;
                    e.x(I.y(mainAlertModel.schema, mainAlertModel.scm, mainAlertEntity2.id, String.valueOf(mainAlertModel.circleId), MainActivity.this.mMainAlertEntity.item.imageUrl));
                }
            }
            MainActivity.this.mAdView.dismiss();
        }
    }

    private void addFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397994226")) {
            ipChange.ipc$dispatch("-1397994226", new Object[]{this, fragment});
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.homepage_fragment_container, fragment);
        beginTransaction.commitAllowingStateLoss();
        showPoplayer("HomeMainFragment", "");
    }

    private boolean checkKeyStore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-573763551")) {
            return ((Boolean) ipChange.ipc$dispatch("-573763551", new Object[]{this})).booleanValue();
        }
        String keyStoreInfo = getKeyStoreInfo(this);
        String keyFromInner = getKeyFromInner(this);
        if (keyFromInner == null) {
            keyFromInner = "";
        }
        if (TextUtils.isEmpty(keyStoreInfo)) {
            return true;
        }
        return keyStoreInfo.equals(keyFromInner);
    }

    private void checkLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-476326582")) {
            ipChange.ipc$dispatch("-476326582", new Object[]{this});
            return;
        }
        String[] strArr = lp1.LOCATION;
        if (hp1.i(strArr)) {
            checkTimeZone(false);
            CityLocationUtil cityLocationUtil = new CityLocationUtil(this, this.mLocaltionListener);
            this.mCityLocationUtil = cityLocationUtil;
            cityLocationUtil.p(true);
            this.mCityLocationUtil.n();
        } else if (!TextUtils.isEmpty(d20.B(SP_KEY_LOCATION_DIALOG_SHOWED))) {
            checkTimeZone(true);
        } else {
            d20.T(SP_KEY_LOCATION_DIALOG_SHOWED, "locationExaDes");
            new Permission(xs0.a(), new PermissionModel(strArr, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new r()).b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkRecentTicket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1125932680")) {
            ipChange.ipc$dispatch("-1125932680", new Object[]{this});
        } else if (LoginManager.k().q()) {
            TickletBusinessUtil tickletBusinessUtil2 = this.tickletBusinessUtil;
            if (tickletBusinessUtil2 != null) {
                tickletBusinessUtil2.g(this.mTickletContainer, true);
            }
        } else {
            checkAlertDialog();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkUpdate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "646321718")) {
            ipChange.ipc$dispatch("646321718", new Object[]{this});
            return;
        }
        UpdateUtil.e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    private void eventShowAlterTimer(MainAlertEntity.MainAlertModel mainAlertModel) {
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642292678")) {
            ipChange.ipc$dispatch("1642292678", new Object[]{this, mainAlertModel});
            return;
        }
        String str = null;
        try {
            String J = d20.J();
            if (!TextUtils.isEmpty(J)) {
                String[] split = J.split(",");
                if (split.length == 2) {
                    str = split[0];
                    j2 = lk1.k(split[1], -1);
                    if (TextUtils.equals(mainAlertModel.pkid, str)) {
                        d20.D0(mainAlertModel.pkid + "," + System.currentTimeMillis());
                        showADOrNewFunctionDialog(mainAlertModel);
                        return;
                    } else if (mainAlertModel.nextAlert == 0) {
                        checkUpdate();
                        return;
                    } else if ((System.currentTimeMillis() - j2) / 1000 > mainAlertModel.nextAlert) {
                        d20.D0(mainAlertModel.pkid + "," + System.currentTimeMillis());
                        showADOrNewFunctionDialog(mainAlertModel);
                        return;
                    } else {
                        return;
                    }
                }
            }
            j2 = 0;
            if (TextUtils.equals(mainAlertModel.pkid, str)) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void exitApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539468228")) {
            ipChange.ipc$dispatch("539468228", new Object[]{this});
            return;
        }
        d20.l0(false);
        ol1.d();
        onDestroy();
        finish();
        tf0.a();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317346319")) {
            ipChange.ipc$dispatch("-317346319", new Object[]{this});
        } else if (getIntent() != null) {
            this.mTabExtra = TabExtra.fromIntent(getIntent());
            if (AppConfig.v()) {
                g91.c("IntentTest", "onCreate-initBundle tabExtra :" + s41.e(this.mTabExtra));
            }
        }
    }

    private void initLater() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780274027")) {
            ipChange.ipc$dispatch("1780274027", new Object[]{this});
            return;
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.homepage.MainActivity.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-499327156")) {
                    ipChange.ipc$dispatch("-499327156", new Object[]{this});
                    return;
                }
                try {
                    pn.d().startCheckAndUpdateCacheableKV();
                } catch (Exception e) {
                    g91.a(e.getMessage());
                }
            }
        }, 2000);
    }

    private void initLottieView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91522383")) {
            ipChange.ipc$dispatch("91522383", new Object[]{this});
            return;
        }
        this.mAnimationView = (HomeLottieView) findViewById(R$id.homepage_lottie_animation);
        this.mDMMessage.b("LottieDownLoadSuccess", new u());
    }

    private void initPopUpLine() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594564713")) {
            ipChange.ipc$dispatch("-594564713", new Object[]{this});
        } else if (isNewPopupAble()) {
            newPopup();
        } else {
            checkLocation();
        }
    }

    private void initTabBarLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026750251")) {
            ipChange.ipc$dispatch("2026750251", new Object[]{this});
            return;
        }
        this.mTabbarLayout = (TabbarLayout) findViewById(R$id.homemain_tabbar);
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, this.mTabbarLayout, this);
        this.mTabbarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_HOME);
        this.mTabbarManager.h().d(this);
    }

    private void initTicklet(DialogInterface.OnDismissListener onDismissListener, TickletBusinessUtil.PopNoShow popNoShow) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655333053")) {
            ipChange.ipc$dispatch("1655333053", new Object[]{this, onDismissListener, popNoShow});
            return;
        }
        if (this.tickletBusinessUtil == null) {
            this.tickletBusinessUtil = new TickletBusinessUtil(this);
        }
        this.tickletBusinessUtil.i();
        this.tickletBusinessUtil.d(onDismissListener, popNoShow);
    }

    private void initWantSee() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310976500")) {
            ipChange.ipc$dispatch("1310976500", new Object[]{this});
            return;
        }
        WantSeePosterTips wantSeePosterTips = (WantSeePosterTips) findViewById(R$id.want_see_project_tips);
        this.wantSeeProjectTips = wantSeePosterTips;
        wantSeePosterTips.setPageSource(WantSeePosterTips.b.C0037b.INSTANCE);
        registerWantSee();
    }

    private void initZhibotiao() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870566228")) {
            ipChange.ipc$dispatch("-870566228", new Object[]{this});
            return;
        }
        this.mZhiboView = new ZhiboView(this, findViewById(R$id.layout_zhibotiao));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303350927")) {
            return ((Boolean) ipChange.ipc$dispatch("1303350927", new Object[]{this})).booleanValue();
        }
        HomeFragmentAgent homeFragmentAgent = this.mHomeTabFragment;
        return homeFragmentAgent != null && homeFragmentAgent.getCurIndex() == 0;
    }

    private boolean isNewPopupAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "645165879")) {
            return StartConfig.isPopupOpenAble() && this.mIsUseNewHome;
        }
        return ((Boolean) ipChange.ipc$dispatch("645165879", new Object[]{this})).booleanValue();
    }

    private void loadConfigInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655065715")) {
            ipChange.ipc$dispatch("-655065715", new Object[]{this});
            return;
        }
        BottomSheetRequest bottomSheetRequest = new BottomSheetRequest();
        bottomSheetRequest.cityId = d20.c();
        bottomSheetRequest.request(new DMMtopRequestListener<BottomSheetBean>(BottomSheetBean.class) {
            /* class cn.damai.homepage.MainActivity.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "265266699")) {
                    ipChange.ipc$dispatch("265266699", new Object[]{this, str, str2});
                    return;
                }
                d20.T(DamaiTabbarManager.TabBar_SERVER_DATA, null);
                MainActivity.this.returnBottomSheetError();
            }

            public void onSuccess(BottomSheetBean bottomSheetBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1862930034")) {
                    ipChange.ipc$dispatch("-1862930034", new Object[]{this, bottomSheetBean});
                    return;
                }
                d20.T(DamaiTabbarManager.TabBar_SERVER_DATA, JSON.toJSONString(bottomSheetBean));
                MainActivity.this.returnBottomSheet(bottomSheetBean);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadFloatInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532858397")) {
            ipChange.ipc$dispatch("-532858397", new Object[]{this});
            return;
        }
        this.mZhibotiaoBean = null;
        new HomeFloatLayerRequest().request(new DMMtopRequestListener<HomeFloatResBean>(HomeFloatResBean.class) {
            /* class cn.damai.homepage.MainActivity.AnonymousClass13 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "257507340")) {
                    ipChange.ipc$dispatch("257507340", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(HomeFloatResBean homeFloatResBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "713374037")) {
                    ipChange.ipc$dispatch("713374037", new Object[]{this, homeFloatResBean});
                } else if (homeFloatResBean != null && homeFloatResBean.isValid()) {
                    MainActivity.this.updateFloatUi(homeFloatResBean);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadImage(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114753937")) {
            ipChange.ipc$dispatch("2114753937", new Object[]{this, bottomSheetBean, imageDownLoader});
            return;
        }
        List<BottomSheetBean.Result> list = bottomSheetBean.content;
        if (xf2.e(list) > 0) {
            this.checkedSuccess = false;
            this.uncheckSuccess = false;
            this.reCheckSuccess = true;
            if (this.index >= xf2.e(list)) {
                d20.T(DamaiTabbarManager.TabBar, JSON.toJSONString(bottomSheetBean));
                refreshTabBarLayout();
                return;
            }
            BottomSheetBean.Result result = list.get(this.index);
            if (result != null) {
                if (TextUtils.equals(result.type, "1")) {
                    this.reCheckSuccess = false;
                    this.checkedSuccess = true;
                    imageDownLoader.j(result.reCheckedPic, 135, 135, new c(bottomSheetBean, imageDownLoader));
                }
                imageDownLoader.j(result.checkedPic, 135, 135, new d(bottomSheetBean, imageDownLoader));
                imageDownLoader.j(result.defaultPic, 135, 135, new e(bottomSheetBean, imageDownLoader));
            }
            this.index++;
        }
    }

    private void newPopup() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "20777463")) {
            ipChange.ipc$dispatch("20777463", new Object[]{this});
            return;
        }
        nr1 nr1 = new nr1(this);
        nr1.b(this.tickletBusinessUtil, this.mTickletContainer, this.wantSeeProjectTips, new n());
        nr1.a();
    }

    private void refreshTabBarLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690046620")) {
            ipChange.ipc$dispatch("-1690046620", new Object[]{this});
        } else if (this.mTabbarLayout != null) {
            DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, this.mTabbarLayout, this);
            this.mTabbarManager = damaiTabbarManager;
            damaiTabbarManager.j(DamaiConstants.TAB_HOME);
            this.mTabbarManager.h().d(this);
        }
    }

    private void registerLoginLogoutBroadcastReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699523741")) {
            ipChange.ipc$dispatch("-1699523741", new Object[]{this});
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(z91.BROADCAST_LOGIN_SUCCESS);
        intentFilter.addAction(z91.BROADCAST_LOGOUT_SUCCESS);
        LoginLogoutBroadcastReceiver loginLogoutBroadcastReceiver = new LoginLogoutBroadcastReceiver(new Runnable() {
            /* class cn.damai.homepage.MainActivity.AnonymousClass35 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1993629046")) {
                    ipChange.ipc$dispatch("-1993629046", new Object[]{this});
                } else if (MainActivity.this.mHomeTabFragment != null) {
                    g91.c("HomeUI", "do refreshFragment");
                    MainActivity.this.mHomeTabFragment.refreshHomeFragment(false);
                }
            }
        }, new s());
        this.mLoginReceiver = loginLogoutBroadcastReceiver;
        registerReceiver(loginLogoutBroadcastReceiver, intentFilter);
    }

    private void registerWantSee() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167403833")) {
            ipChange.ipc$dispatch("-167403833", new Object[]{this});
            return;
        }
        WantSeeTips wantSeeTips2 = (WantSeeTips) findViewById(R$id.want_see_tips);
        this.wantSeeTips = wantSeeTips2;
        wantSeeTips2.setPageSource(WantSeeTips.a.c.INSTANCE);
        new br().b("showFollowTips", new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportUserOperation(String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1768522842")) {
            ipChange.ipc$dispatch("1768522842", new Object[]{this, str, Integer.valueOf(i2)});
            return;
        }
        CommentListOptrRequest commentListOptrRequest = new CommentListOptrRequest();
        commentListOptrRequest.mecPerformId = str;
        commentListOptrRequest.operType = i2;
        commentListOptrRequest.request(new DMMtopRequestListener<CommentOptrBean>(CommentOptrBean.class) {
            /* class cn.damai.homepage.MainActivity.AnonymousClass23 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "16967211")) {
                    ipChange.ipc$dispatch("16967211", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CommentOptrBean commentOptrBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-228183371")) {
                    ipChange.ipc$dispatch("-228183371", new Object[]{this, commentOptrBean});
                    return;
                }
                Boolean.valueOf(commentOptrBean.model);
            }
        });
    }

    private void setPushUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718674444")) {
            ipChange.ipc$dispatch("1718674444", new Object[]{this});
        } else if (PermissionsHelper.a(this)) {
            cn.damai.common.user.c.e().A(ax0.I().J("1", "", ""), ax0.CUSTOM_PUSH, ax0.PUSH_PAGE);
        } else {
            cn.damai.common.user.c.e().A(ax0.I().J("0", "", ""), ax0.CUSTOM_PUSH, ax0.PUSH_PAGE);
        }
    }

    private void showADOrNewFunctionDialog(MainAlertEntity.MainAlertModel mainAlertModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565532625")) {
            ipChange.ipc$dispatch("-565532625", new Object[]{this, mainAlertModel});
            return;
        }
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new l()).n(new k(mainAlertModel)).f();
        if (MainAlertEntity.PICK_TYPE_CALLBACK.equals(this.mMainAlertEntity.item.pkType)) {
            PopUpAdvertCallBackRequest popUpAdvertCallBackRequest = new PopUpAdvertCallBackRequest();
            MainAlertEntity.MainAlertModel mainAlertModel2 = this.mMainAlertEntity.item;
            popUpAdvertCallBackRequest.pkId = mainAlertModel2.pkid;
            popUpAdvertCallBackRequest.pkType = mainAlertModel2.pkType;
            popUpAdvertCallBackRequest.request(new DMMtopRequestListener(Object.class) {
                /* class cn.damai.homepage.MainActivity.AnonymousClass29 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-29588943")) {
                        ipChange.ipc$dispatch("-29588943", new Object[]{this, str, str2});
                        return;
                    }
                    Log.d("debug", "log onFail");
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "984725416")) {
                        ipChange.ipc$dispatch("984725416", new Object[]{this, obj});
                        return;
                    }
                    Log.d("debug", "log onSuccess");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showCityChange(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513580011")) {
            ipChange.ipc$dispatch("-513580011", new Object[]{this, str});
        } else if (TextUtils.getTrimmedLength(str) <= 0) {
            checkRecentTicket();
        } else {
            DMThemeDialog dMThemeDialog = new DMThemeDialog(this);
            dMThemeDialog.o("地理位置变更").r(DMThemeDialog.DMDialogTheme.THEME_LOCATION).k(getString(R$string.change_city_tip, new Object[]{str})).i(getString(R$string.change_city, new Object[]{str}), new q()).g(true, new p());
            if (!isFinishing()) {
                dMThemeDialog.show();
            }
        }
    }

    private void showDnaProtocolDialog(final MainAlertEntity.MainAlertModel mainAlertModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709700814")) {
            ipChange.ipc$dispatch("-1709700814", new Object[]{this, mainAlertModel});
            return;
        }
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new j()).n(new DMImageCreator.DMImageSuccListener() {
            /* class cn.damai.homepage.MainActivity.AnonymousClass24 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.homepage.MainActivity$24$a */
            /* compiled from: Taobao */
            public class a implements DMProtocolDialog.OnDialogShowTimeListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.uikit.view.DMProtocolDialog.OnDialogShowTimeListener
                public void exposureTime(long j) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-553118283")) {
                        ipChange.ipc$dispatch("-553118283", new Object[]{this, Long.valueOf(j)});
                        return;
                    }
                    MainAlertEntity.MainAlertModel mainAlertModel = MainActivity.this.mMainAlertEntity.item;
                    ax0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "1", null);
                }
            }

            /* renamed from: cn.damai.homepage.MainActivity$24$b */
            /* compiled from: Taobao */
            public class b implements DialogInterface.OnDismissListener {
                private static transient /* synthetic */ IpChange $ipChange;

                b() {
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1822797227")) {
                        ipChange.ipc$dispatch("1822797227", new Object[]{this, dialogInterface});
                        return;
                    }
                    MainActivity.this.checkUpdate();
                }
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1870880820")) {
                    ipChange.ipc$dispatch("-1870880820", new Object[]{this, eVar});
                } else if (MainActivity.this.isActivityFinsihed() || !MainActivity.this.isActivityForeground() || eVar.b == null) {
                    MainActivity.this.checkUpdate();
                } else {
                    List<MainAlertEntity.MainAlertContentListItem> list = mainAlertModel.contentList;
                    if (list == null || list.size() <= 0) {
                        MainActivity.this.checkUpdate();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < mainAlertModel.contentList.size(); i++) {
                        aa0 aa0 = new aa0();
                        aa0.h(tj.b(mainAlertModel.titleColor));
                        aa0.g(mainAlertModel.contentList.get(i).content);
                        if ("1".equals(mainAlertModel.contentList.get(i).contentType)) {
                            aa0.i(true);
                            aa0.l(mainAlertModel.protocolName);
                            aa0.j(tj.b(mainAlertModel.protocolColor));
                            aa0.k(mainAlertModel.protocolLink);
                        }
                        arrayList.add(aa0);
                    }
                    DMProtocolDialog n = new DMProtocolDialog(MainActivity.this).r(DMProtocolDialog.DMDialogTheme.THEME_DNA).o(arrayList).m(eVar.b).p(new DMProtocolDialog.OnClickListener() {
                        /* class cn.damai.homepage.MainActivity.AnonymousClass24.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                        public void onClickNegative() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "404647594")) {
                                ipChange.ipc$dispatch("404647594", new Object[]{this});
                                return;
                            }
                            cn.damai.common.user.c.e().x(ax0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "1", 1, null));
                        }

                        @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                        public void onClickPositive(final DialogInterface dialogInterface, boolean z) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1110010388")) {
                                ipChange.ipc$dispatch("1110010388", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
                            } else if (z) {
                                cn.damai.common.user.c.e().x(ax0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "1", 0, null));
                                SetupPermissionListRequest setupPermissionListRequest = new SetupPermissionListRequest();
                                HashMap hashMap = new HashMap();
                                hashMap.put("2", "1");
                                setupPermissionListRequest.setupPermissionMap = hashMap;
                                setupPermissionListRequest.request(new DMMtopRequestListener<SetPrivacyPermissionBean>(SetPrivacyPermissionBean.class) {
                                    /* class cn.damai.homepage.MainActivity.AnonymousClass24.AnonymousClass1.AnonymousClass1 */
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                                    public void onFail(String str, String str2) {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "2054739974")) {
                                            ipChange.ipc$dispatch("2054739974", new Object[]{this, str, str2});
                                            return;
                                        }
                                        dialogInterface.dismiss();
                                        ToastUtil.f("竟然失败了…请前往“设置-隐私设置”开启～");
                                    }

                                    public void onSuccess(SetPrivacyPermissionBean setPrivacyPermissionBean) {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "-1227722132")) {
                                            ipChange.ipc$dispatch("-1227722132", new Object[]{this, setPrivacyPermissionBean});
                                            return;
                                        }
                                        MainAlertEntity mainAlertEntity = MainActivity.this.mMainAlertEntity;
                                        if (!(mainAlertEntity == null || mainAlertEntity.item == null)) {
                                            Bundle bundle = new Bundle();
                                            bundle.putBoolean(MonitorType.SKIP, true);
                                            bundle.putString("from_page", "homepage");
                                            DMNav.from(MainActivity.this).withExtras(bundle).toUri(MainActivity.this.mMainAlertEntity.item.schema);
                                        }
                                        dialogInterface.dismiss();
                                    }
                                });
                            } else {
                                ToastUtil.i(MainActivity.this.getString(R$string.homepage_dna_dialog_tip));
                            }
                        }

                        @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                        public void onProtocolClick(String str) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1270542367")) {
                                ipChange.ipc$dispatch("-1270542367", new Object[]{this, str});
                                return;
                            }
                            DMNav.from(MainActivity.this).toUri(str);
                        }
                    }).n(false);
                    n.q(new a());
                    n.setOnDismissListener(new b());
                    n.show();
                }
            }
        }).f();
        if (MainAlertEntity.PICK_HID_TYPE_CALLBACK.equals(this.mMainAlertEntity.item.pkType)) {
            PopUpAdvertCallBackRequest popUpAdvertCallBackRequest = new PopUpAdvertCallBackRequest();
            MainAlertEntity.MainAlertModel mainAlertModel2 = this.mMainAlertEntity.item;
            popUpAdvertCallBackRequest.pkId = mainAlertModel2.pkid;
            popUpAdvertCallBackRequest.pkType = mainAlertModel2.pkType;
            popUpAdvertCallBackRequest.request(new DMMtopRequestListener(Object.class) {
                /* class cn.damai.homepage.MainActivity.AnonymousClass26 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-6310866")) {
                        ipChange.ipc$dispatch("-6310866", new Object[]{this, str, str2});
                        return;
                    }
                    Log.d("debug", "log onFail");
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2091750581")) {
                        ipChange.ipc$dispatch("-2091750581", new Object[]{this, obj});
                        return;
                    }
                    Log.d("debug", "log onSuccess");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showEvaluateDialog(CouponListResponse.ContentList contentList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1490210138")) {
            ipChange.ipc$dispatch("1490210138", new Object[]{this, contentList});
            return;
        }
        HomepageEvaluateDialog homepageEvaluateDialog = new HomepageEvaluateDialog(this, contentList, 1010, new h());
        homepageEvaluateDialog.s(new i());
        homepageEvaluateDialog.show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r0 = findViewById(cn.damai.homepage.R$id.layout_homepage_evaluate_tips);
     */
    private void showEvaluateTips(String str) {
        final View findViewById;
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094038815")) {
            ipChange.ipc$dispatch("2094038815", new Object[]{this, str});
        } else if (this.mZhiboView == null || this.mZhibotiaoBean == null) {
            ContentPopTipPanel contentPopTipPanel = this.mPopTipPanel;
            if ((contentPopTipPanel == null || !contentPopTipPanel.c()) && findViewById != null && (textView = (TextView) findViewById.findViewById(R$id.tv_homepage_evaluate_tips)) != null) {
                textView.setText(str);
                findViewById.setVisibility(0);
                findViewById.postDelayed(new Runnable() {
                    /* class cn.damai.homepage.MainActivity.AnonymousClass15 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1600273672")) {
                            ipChange.ipc$dispatch("1600273672", new Object[]{this});
                            return;
                        }
                        findViewById.setVisibility(8);
                    }
                }, DanmakuFactory.MIN_DANMAKU_DURATION_V);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void showLottie() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506495591")) {
            ipChange.ipc$dispatch("506495591", new Object[]{this});
            return;
        }
        this.lottieIsShowed = true;
        HomeData homeData = this.mHomeData;
        if (homeData != null && !TextUtils.isEmpty(homeData.lottieType)) {
            int i2 = DisplayMetrics.getwidthPixels(v50.b(this));
            int i3 = (i2 * 1624) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
            int i4 = i3 - DisplayMetrics.getheightPixels(v50.b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
            String str = this.mHomeData.lottieType;
            if (!"1".equals(str)) {
                if ("2".equals(str)) {
                    if (i4 > 0) {
                        this.mAnimationView.setTranslationY((float) (i4 / 2));
                    } else {
                        layoutParams.gravity = 17;
                    }
                } else if ("3".equals(str)) {
                    if (i4 > 0) {
                        this.mAnimationView.setTranslationY((float) i4);
                    } else {
                        layoutParams.gravity = 80;
                    }
                }
            }
            this.mAnimationView.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.lottieFilePath)) {
                vw0.d().j(this.mAnimationView, this.lottieFilePath);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showLottieBeforeAlertDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551032834")) {
            ipChange.ipc$dispatch("-551032834", new Object[]{this});
            return;
        }
        this.canShowLottie = true;
        if (this.mAnimationView != null && this.lottieLoadSuccess && !this.homeIsOnPause) {
            showLottie();
        }
    }

    private void showPoplayer(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779597158")) {
            ipChange.ipc$dispatch("-779597158", new Object[]{this, str, str2});
            return;
        }
        Intent intent = new Intent(PopLayer.ACTION_FRAGMENT_SWITCH);
        intent.putExtra(PopLayer.EXTRA_KEY_FRAGMENT_NAME, str);
        intent.putExtra(PopLayer.EXTRA_KEY_FRAGMENT_PARAM, str2);
        intent.putExtra(PopLayer.EXTRA_KEY_FRAGMENT_NEED_ACTIVITY_PARAM, true);
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateFloatUi(HomeFloatResBean homeFloatResBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615865052")) {
            ipChange.ipc$dispatch("-1615865052", new Object[]{this, homeFloatResBean});
        } else if (!isFinishing()) {
            if (homeFloatResBean.isPopContent()) {
                TabExtraBean validBean = HomeContentFloatBean.getValidBean(homeFloatResBean.item);
                if (validBean != null) {
                    this.mPopTipPanel.d(validBean);
                    TabbarDataManager.e().i(DamaiConstants.TAB_FIND, validBean);
                }
                this.mZhiboView.i(null, this.mHomeTabFragment);
            } else if (homeFloatResBean.isZhiBo()) {
                final HomeZhibotiaoBean validBean2 = HomeZhibotiaoBean.getValidBean(homeFloatResBean.item);
                this.mZhibotiaoBean = validBean2;
                new Handler().postDelayed(new Runnable() {
                    /* class cn.damai.homepage.MainActivity.AnonymousClass14 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1796787177")) {
                            ipChange.ipc$dispatch("1796787177", new Object[]{this});
                            return;
                        }
                        MainActivity.this.mZhiboView.i(validBean2, MainActivity.this.mHomeTabFragment);
                    }
                }, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void wantActionShow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148810826")) {
            ipChange.ipc$dispatch("148810826", new Object[]{this, str});
        } else if ((!isNewPopupAble() || !new xx2().c(this, str, this.wantSeeTips, this.wantSeeProjectTips)) && !cy2.INSTANCE.e(this, new b(this, str)) && this.wantSeeTips != null && this.wantSeeProjectTips.getVisibility() == 8) {
            this.wantSeeTips.setPageSource(WantSeeTips.a.c.INSTANCE);
            this.wantSeeTips.showAnim();
        }
    }

    public void checkAlertDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896631623")) {
            ipChange.ipc$dispatch("1896631623", new Object[]{this});
            return;
        }
        showLottieBeforeAlertDialog();
        PopUpAdvertRequest popUpAdvertRequest = new PopUpAdvertRequest();
        if (AppConfig.g().equals(AppConfig.EnvMode.prepare) && d20.j()) {
            popUpAdvertRequest.viewDate = d20.k();
        }
        popUpAdvertRequest.request(new DMMtopRequestListener<MainAlertEntity>(MainAlertEntity.class) {
            /* class cn.damai.homepage.MainActivity.AnonymousClass20 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.homepage.MainActivity$20$a */
            /* compiled from: Taobao */
            public class a implements DialogInterface.OnDismissListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1600520869")) {
                        ipChange.ipc$dispatch("1600520869", new Object[]{this, dialogInterface});
                        return;
                    }
                    MainActivity.this.checkUpdate();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "40245288")) {
                    ipChange.ipc$dispatch("40245288", new Object[]{this, str, str2});
                    return;
                }
                MainActivity.this.checkUpdate();
            }

            public void onSuccess(MainAlertEntity mainAlertEntity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "797426220")) {
                    ipChange.ipc$dispatch("797426220", new Object[]{this, mainAlertEntity});
                } else if (mainAlertEntity == null) {
                    MainActivity.this.checkUpdate();
                } else if (!MainActivity.this.isHomePage()) {
                    MainActivity.this.checkUpdate();
                } else if ("3".equals(mainAlertEntity.type)) {
                    MainActivity.this.showEvaluateDialog(mainAlertEntity.content);
                } else if (MainActivity.this.mMemberDialogManger == null || !MainActivity.this.mMemberDialogManger.k(mainAlertEntity)) {
                    MainActivity.this.showCycleDisplayRequiredDialog(mainAlertEntity);
                } else {
                    MainActivity.this.mMemberDialogManger.h(mainAlertEntity, new a());
                }
            }
        });
    }

    public void checkTimeZone(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632041170")) {
            ipChange.ipc$dispatch("-632041170", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        try {
            List asList = Arrays.asList("Asia/Chongqing", "Asia/Harbin", "Asia/Hong_Kong", "Asia/Macau", "Asia/Shanghai", "Asia/Taipei", "Asia/Urumqi");
            String id = TimeZone.getDefault().getID();
            if (!asList.contains(id)) {
                String b2 = OrangeConfigCenter.c().b(ol1.HOME_OTHER_TIME_ZONE_IN_CHINA, "otherzone", "");
                if (TextUtils.isEmpty(b2) || !b2.contains(id)) {
                    if (!yr.a(this).equals(id)) {
                        DMDialog dMDialog = new DMDialog(this);
                        this.timeZoneDialog = dMDialog;
                        dMDialog.o(false);
                        this.timeZoneDialog.q("未特殊提示的，抢票和演出时间均为北京时间为准");
                        this.timeZoneDialog.n("知道了", new f(id, z2));
                        this.timeZoneDialog.show();
                    } else if (z2) {
                        checkRecentTicket();
                    }
                } else if (z2) {
                    checkRecentTicket();
                }
            } else if (z2) {
                checkRecentTicket();
            }
        } catch (Exception e2) {
            if (z2) {
                checkRecentTicket();
            }
            g91.b("checkTimeZone", e2.getMessage());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844896629")) {
            ipChange.ipc$dispatch("-1844896629", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.FragmentPropertiesProvider
    public Map get(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129234640")) {
            return (Map) ipChange.ipc$dispatch("-2129234640", new Object[]{this, str});
        }
        Log.e("abtest", " ==================== acvitivty get : " + str);
        if (TextUtils.isEmpty(str)) {
            return new HashMap();
        }
        return this.fragmentPropertiesMap.get(str);
    }

    public HomeData getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-842551284")) {
            return this.mHomeData;
        }
        return (HomeData) ipChange.ipc$dispatch("-842551284", new Object[]{this});
    }

    public String getKeyFromInner(Context context) {
        IStaticDataStoreComponent staticDataStoreComp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630236900")) {
            return (String) ipChange.ipc$dispatch("-630236900", new Object[]{this, context});
        }
        SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
        if (instance == null || (staticDataStoreComp = instance.getStaticDataStoreComp()) == null) {
            return null;
        }
        return staticDataStoreComp.getExtraData("KEYSTORE_MD5_KEY");
    }

    public String getKeyStoreInfo(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656759705")) {
            return (String) ipChange.ipc$dispatch("1656759705", new Object[]{this, context});
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.substring(0, stringBuffer2.length() - 1);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2106092159")) {
            return R$layout.homepage_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("2106092159", new Object[]{this})).intValue();
    }

    public DamaiTabbarManager getTabbarManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-686764831")) {
            return this.mTabbarManager;
        }
        return (DamaiTabbarManager) ipChange.ipc$dispatch("-686764831", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997651236")) {
            ipChange.ipc$dispatch("-997651236", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508443855")) {
            ipChange.ipc$dispatch("508443855", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-134560658")) {
            ipChange.ipc$dispatch("-134560658", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTickletContainer = (FrameLayout) findViewById(R$id.homepage_ticklet_container);
        this.mCurrentCity = d20.d();
        initTicklet(new v(), new w());
        boolean isShowHomeDependOnOrange = StartConfig.isShowHomeDependOnOrange();
        if (isShowHomeDependOnOrange) {
            this.mIsUseNewHome = !StartConfig.isUseOldHomeCMSFragment();
        } else {
            this.mIsUseNewHome = fw0.INSTANCE.e();
        }
        String str = isShowHomeDependOnOrange ? "by orange" : "by ab helper";
        String str2 = this.mIsUseNewHome ? "New home" : "Old home";
        g91.c("ShowHome", "show home " + str + " ; final use " + str2);
        initZhibotiao();
        initWantSee();
        initPopUpLine();
        this.mPopTipPanel = new ContentPopTipPanel(this, new x());
        this.mMemberDialogManger = new MemberGuideDialogManger(this, new y());
        l3.b();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869267157")) {
            ipChange.ipc$dispatch("1869267157", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1008) {
            if (i3 == -1) {
                if (LoginManager.k().q()) {
                    onResume();
                    pp2.b().q((Activity) this.mContext, pp2.SCHEME_MINEPAGE);
                }
                sendBroadcast(new Intent(DamaiConstants.NOTIFY_REFRESH_MESSAGE));
            }
        } else if (i2 == 1009) {
            if (i3 == -1) {
                if (LoginManager.k().q()) {
                    pp2.b().q((Activity) this.mContext, pp2.SCHEME_MINEPAGE);
                } else {
                    pp2.b().q((Activity) this.mContext, pp2.SCHEME_HOMEPAGE);
                }
            }
        } else if (i2 == 100 && i3 == 101) {
            pp2.b().q((Activity) this.mContext, "damai://V1/CategoryPage?id=100");
        } else if (i2 == 78 && i3 == -1) {
            g91.c("CityChanged", "CityChanged  onAc");
            this.mHomeTabFragment.refreshAllFragment();
        } else if (i2 == 1010 && i3 == -1 && intent != null && !xf2.j(intent.getStringExtra("tip"))) {
            showEvaluateTips(intent.getStringExtra("tip"));
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865983467")) {
            ipChange.ipc$dispatch("865983467", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.mExitTime;
        if (currentTimeMillis - j2 > 2000 || j2 < 0) {
            ToastUtil.a().e(this, bk2.b(this, R$string.damai_main_quit_damai_toast));
            this.mExitTime = System.currentTimeMillis();
            return;
        }
        super.onBackPressed();
        i3.b().a();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058626762")) {
            ipChange.ipc$dispatch("2058626762", new Object[]{this, configuration});
            return;
        }
        u02 u02 = this.responsiveActivityStateManager;
        if (u02 != null) {
            u02.c(configuration);
        }
        super.onConfigurationChanged(configuration);
        u02 u022 = this.responsiveActivityStateManager;
        if (u022 != null) {
            u022.e(configuration);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791695116")) {
            ipChange.ipc$dispatch("1791695116", new Object[]{this, bundle});
            return;
        }
        ht0.b();
        super.onCreate(bundle);
        cn.damai.commonbusiness.pageut.a.i(this);
        this.mHomeData = new HomeData();
        ScreenShotDetector.k().A(this);
        cn.damai.common.user.c.e().K(this);
        p81.c();
        initLottieView();
        initTabBarLayout();
        loadConfigInfo();
        initBundle();
        if (this.mIsUseNewHome) {
            HomeNoticeView.Companion.a();
            this.mHomeTabFragment = new lw0(HomePageFragment.Companion.a());
            this.responsiveActivityStateManager = new u02(this, new g(this));
        } else {
            this.mHomeTabFragment = new HomeTabFragment();
        }
        Bundle bundle2 = new Bundle();
        TabExtra tabExtra = this.mTabExtra;
        if (tabExtra != null && tabExtra.isValidExtra()) {
            bundle2.putParcelable("extra_key", this.mTabExtra);
        }
        this.mHomeTabFragment.setArguments(bundle2);
        addFragment(this.mHomeTabFragment.self());
        this.mHomeTabFragment.setOnTabClickListener(new m());
        this.isFromHome = true;
        setPushUt();
        if (!checkKeyStore() && !AppConfig.v()) {
            DMDialog dMDialog = new DMDialog(this);
            dMDialog.o(false).q("应用签名冲突,为了保证您的使用安全,请使用官方渠道下载的APP").setCancelable(false);
            dMDialog.n("我知道了", new t()).show();
        }
        registerLoginLogoutBroadcastReceiver();
        initLater();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462861132")) {
            ipChange.ipc$dispatch("1462861132", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.tickletBusinessUtil.e();
        this.tickletBusinessUtil = null;
        ScreenShotDetector.k().B();
        d20.l0(false);
        cn.damai.commonbusiness.pageut.a.j(this);
        d20.T(DamaiTabbarManager.TabBar_SERVER_DATA, null);
        unregisterReceiver(this.mLoginReceiver);
        u02 u02 = this.responsiveActivityStateManager;
        if (u02 != null) {
            u02.d();
        }
        try {
            pn.d().stopCheckAndUpdateCacheableKV();
        } catch (Exception e2) {
            g91.a(e2.getMessage());
        }
    }

    @Override // cn.damai.commonbusiness.tab.DamaiTabViewHelper.OnHomeIconTabStateChangedListener
    public void onHomeIconTabStateChanged(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789921731")) {
            ipChange.ipc$dispatch("-1789921731", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        HomeFragmentAgent homeFragmentAgent = this.mHomeTabFragment;
        if (homeFragmentAgent == null) {
            return;
        }
        if (i2 == 1) {
            homeFragmentAgent.scrollToTop();
        } else if (i2 == 2) {
            homeFragmentAgent.scrollToRecommend();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244899339")) {
            ipChange.ipc$dispatch("244899339", new Object[]{this});
            return;
        }
        hideLoadingTip((ViewGroup) findViewById(R$id.layout_main));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028473514")) {
            ipChange.ipc$dispatch("1028473514", new Object[]{this});
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (Build.VERSION.SDK_INT >= 23) {
            layoutParams.topMargin = ((int) getResources().getDimension(R$dimen.main_title_height)) + ne2.a(this);
        } else {
            layoutParams.topMargin = (int) getResources().getDimension(R$dimen.main_title_height);
        }
        showLoadingTip((ViewGroup) findViewById(R$id.layout_main), layoutParams);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118172455")) {
            ipChange.ipc$dispatch("2118172455", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            TabExtra fromIntent = TabExtra.fromIntent(intent);
            this.mTabExtra = fromIntent;
            if (fromIntent.isValidExtra()) {
                this.mHomeTabFragment.setSelectTab(this.mTabExtra);
            }
            if (AppConfig.v()) {
                g91.c("IntentTest", "onNewIntent tabExtra :" + s41.e(this.mTabExtra));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656881168")) {
            ipChange.ipc$dispatch("656881168", new Object[]{this});
            return;
        }
        super.onPause();
        this.homeIsOnPause = true;
        if (this.mAnimationView.isAnimating()) {
            this.mAnimationView.cancelAnimation();
        }
        cn.damai.commonbusiness.pageut.a.a(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "536266231")) {
            ipChange.ipc$dispatch("536266231", new Object[]{this});
            return;
        }
        super.onResume();
        jq2.a().c();
        this.homeIsOnPause = false;
        if (getIntent().getBooleanExtra("home_preview", false)) {
            checkAlertDialog();
        }
        if (!this.lottieIsShowed && this.lottieLoadSuccess) {
            showLottie();
        }
        cn.damai.commonbusiness.pageut.a.b(this);
        DamaiTabbarManager damaiTabbarManager = this.mTabbarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.l();
        }
        if (np2.c) {
            UpdateUtil.d();
            np2.c = false;
        }
        if (getIntent() != null && getIntent().getData() != null) {
            try {
                if (!TextUtils.isEmpty(getIntent().getStringExtra(SplashMainActivity.HOMEPAGE_OUTER_URL))) {
                    str = getIntent().getStringExtra(SplashMainActivity.HOMEPAGE_OUTER_URL);
                } else {
                    str = getIntent().getData().toString();
                }
                if (!rs1.d()) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.putExtra(SplashMainActivity.HOMEPAGE_OUTER_URL, str);
                    intent.setData(Uri.parse("damai://launcher"));
                    startActivity(intent);
                    finish();
                } else if (!str.startsWith(pp2.SCHEME)) {
                    if ("damai://home".equals(str) && (this.mHomeTabFragment.getCurFragment() instanceof HomeCmsFragment) && "openExhibition".equals(getIntent().getStringExtra("action"))) {
                        ((HomeCmsFragment) this.mHomeTabFragment.getCurFragment()).showExhibitionTab();
                        getIntent().setData(null);
                    }
                } else if (str.contains(pp2.SCHEME_HOMEPAGE)) {
                    setUt(str);
                    Log.d("applink", "same as homepage ");
                } else {
                    Log.d("applink", " uri : " + getIntent().getData());
                    Bundle extras = getIntent().getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    extras.putBoolean("backtohome", true);
                    extras.putString("from_page", "homepage");
                    DMNav.from(this).withExtras(extras).toUri(Uri.parse(str));
                    getIntent().setData(null);
                    setUt(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374838771")) {
            ipChange.ipc$dispatch("-374838771", new Object[]{this, bundle});
            return;
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabClicked(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514721654")) {
            ipChange.ipc$dispatch("-1514721654", new Object[]{this, tabItem});
            return;
        }
        ContentPopTipPanel contentPopTipPanel = this.mPopTipPanel;
        if (contentPopTipPanel != null) {
            contentPopTipPanel.b();
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabLongClicked(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119141998")) {
            ipChange.ipc$dispatch("2119141998", new Object[]{this, tabItem});
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabReselected(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852381127")) {
            ipChange.ipc$dispatch("-852381127", new Object[]{this, tabItem});
        } else if (tabItem.tab.equals(DamaiConstants.TAB_HOME)) {
            this.mTabbarManager.h().g();
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabSelected(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894768902")) {
            ipChange.ipc$dispatch("894768902", new Object[]{this, tabItem});
        }
    }

    @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.FragmentPropertiesProvider
    public void put(String str, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079225565")) {
            ipChange.ipc$dispatch("-1079225565", new Object[]{this, str, map});
            return;
        }
        Log.e("abtest", " ==================== acvitivty putttt : " + str + " , map : " + map);
        if (!TextUtils.isEmpty(str)) {
            this.fragmentPropertiesMap.put(str, map);
        }
    }

    public void returnBottomSheet(BottomSheetBean bottomSheetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400043453")) {
            ipChange.ipc$dispatch("1400043453", new Object[]{this, bottomSheetBean});
            return;
        }
        BottomSheetBean bottomSheetBean2 = new BottomSheetBean();
        if (bottomSheetBean != null && !f92.d(bottomSheetBean.content)) {
            bottomSheetBean2.content = new ArrayList(bottomSheetBean.content);
        }
        boolean d2 = cn.damai.commonbusiness.tab.a.d(bottomSheetBean);
        if (!d2 && !jx0.g(bottomSheetBean)) {
            String b2 = cn.damai.commonbusiness.tab.a.b(bottomSheetBean2);
            if (!TextUtils.isEmpty(b2)) {
                rx0.c(b2);
            }
        }
        if (bottomSheetBean == null || xf2.e(bottomSheetBean.content) <= 0) {
            d20.T(DamaiTabbarManager.TabBar, JSON.toJSONString(bottomSheetBean));
            refreshTabBarLayout();
        } else if (d2) {
            ImageDownLoader imageDownLoader = new ImageDownLoader(this);
            this.index = 0;
            loadImage(bottomSheetBean, imageDownLoader);
        }
    }

    public void returnBottomSheetError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281652639")) {
            ipChange.ipc$dispatch("1281652639", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void setDamaiUTKeyBuilder(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780297163")) {
            ipChange.ipc$dispatch("-780297163", new Object[]{this, bVar});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-837646669")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-837646669", new Object[]{this});
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728128489")) {
            ipChange.ipc$dispatch("-1728128489", new Object[]{this, str});
            return;
        }
        getSupportActionBar().setTitle(str);
    }

    public void setUt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847484592")) {
            ipChange.ipc$dispatch("-1847484592", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter("utm");
            if (!TextUtils.isEmpty(queryParameter)) {
                cn.damai.common.user.c.e().H("utm", queryParameter);
            }
            cn.damai.common.user.c.e().D("home", "applink", str, "homepage", null, 1013);
        }
    }

    public void showCycleDisplayRequiredDialog(MainAlertEntity mainAlertEntity) {
        MainAlertEntity.MainAlertModel mainAlertModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064833474")) {
            ipChange.ipc$dispatch("-1064833474", new Object[]{this, mainAlertEntity});
            return;
        }
        this.mMainAlertEntity = mainAlertEntity;
        if (mainAlertEntity == null || (mainAlertModel = mainAlertEntity.item) == null) {
            checkUpdate();
        } else if ("7".equals(mainAlertEntity.type)) {
            showDnaProtocolDialog(mainAlertModel);
        } else {
            eventShowAlterTimer(mainAlertModel);
        }
    }

    public void showWantSee(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468680491")) {
            ipChange.ipc$dispatch("468680491", new Object[]{this, str});
            return;
        }
        WantSeeTips wantSeeTips2 = (WantSeeTips) findViewById(R$id.want_see_tips);
        this.wantSeeTips = wantSeeTips2;
        wantSeeTips2.setPageSource(WantSeeTips.a.c.INSTANCE);
        wantActionShow(str);
    }
}

package cn.damai.category.ranking.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.category.category.request.FollowRequest;
import cn.damai.category.discountticket.ui.OnErrorClickListener;
import cn.damai.category.ranking.bean.RankListHeader;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.rank.RankListItemHolder;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import cn.damai.wantsee.GuideUtProvider;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.aj0;
import tb.cy2;
import tb.d20;
import tb.n42;
import tb.ne2;
import tb.rv1;
import tb.tz0;
import tb.za;

/* compiled from: Taobao */
public class RankListFragment extends AbsFragmentV2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_RANK_ID = "rankId";
    private RankListActivity baseActivity;
    DMMtopRequestListener<BaseResponse> dmlistener;
    private int followStatus;
    RankListHeader headerBean = null;
    private long lastClickTime;
    private AppBarLayout mAppBar;
    private TextView mBackBtn;
    private ImageView mBgImg;
    private String mCityId;
    private View mCollectTipIcon;
    private TextView mDescTv;
    private View mEmptyFoot;
    private View mHeader;
    private String mId;
    private ViewGroup mMainView;
    private TextView mMoreRank;
    private PtrFrameLayout mPtr;
    private String mShareBitmapUrl;
    private TextView mShareBtn;
    private String mShareImageUrl;
    private String mShareUrl;
    private View mStatusBarSpace;
    private CountDownTimer mTimeCountDown;
    private View mTitleBgLayout;
    private TextView mTitleTv;
    private TextView mTopTitleTv;
    private TextView mWannaSee;
    ViewGroup rootView;
    String spmB = "ranklist";
    private WantSeeTips wantSeeTips;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1124723081")) {
                ipChange.ipc$dispatch("1124723081", new Object[]{this, eVar});
            } else if (eVar != null && eVar.b != null) {
                try {
                    RankListFragment rankListFragment = RankListFragment.this;
                    rankListFragment.mShareBitmapUrl = tz0.d(rankListFragment.mShareImageUrl, eVar.b, RankListFragment.this.baseActivity);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankItemBean a;

        b(RankItemBean rankItemBean) {
            this.a = rankItemBean;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-703816616")) {
                return getGuideExposeArgMap();
            }
            return (Map) ipChange.ipc$dispatch("-703816616", new Object[]{this});
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-475558952")) {
                return (Map) ipChange.ipc$dispatch("-475558952", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            if (this.a != null) {
                hashMap.put("item_id", this.a.id + "");
                hashMap.put("titlelabel", this.a.rankName);
                hashMap.put(za.CNT_CONTENT_ID, this.a.rankId);
            }
            return hashMap;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1511209355")) {
                return getGuideExposeArgMap();
            }
            return (Map) ipChange.ipc$dispatch("1511209355", new Object[]{this});
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "297623985")) {
                return RankListFragment.this.spmB;
            }
            return (String) ipChange.ipc$dispatch("297623985", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public class c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        c(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "757641795")) {
                ipChange.ipc$dispatch("757641795", new Object[]{this});
                return;
            }
            RankListFragment.this.mCollectTipIcon.setVisibility(8);
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1799903061")) {
                ipChange.ipc$dispatch("-1799903061", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1000603585")) {
                ipChange.ipc$dispatch("1000603585", new Object[]{this, view});
            } else if (!RankListFragment.this.isFastDoubleClick()) {
                RankListFragment.this.jumpRankSquare();
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1183073342")) {
                ipChange.ipc$dispatch("-1183073342", new Object[]{this, view});
                return;
            }
            RankListFragment.this.requestFollow(view);
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "928217027")) {
                ipChange.ipc$dispatch("928217027", new Object[]{this, view});
            } else if (RankListFragment.this.baseActivity != null) {
                RankListFragment.this.baseActivity.finish();
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
            if (AndroidInstantRuntime.support(ipChange, "-1255459900")) {
                ipChange.ipc$dispatch("-1255459900", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.b instance = cn.damai.common.user.b.getInstance();
            RankListFragment rankListFragment = RankListFragment.this;
            cn.damai.common.user.c.e().x(instance.e(rankListFragment.spmB, "top", "share", rankListFragment.getUtMap(), Boolean.FALSE));
            Bundle bundle = new Bundle();
            bundle.putString("title", ((Object) RankListFragment.this.mTopTitleTv.getText()) + "");
            bundle.putString("projectName", ((Object) RankListFragment.this.mTopTitleTv.getText()) + "");
            bundle.putString("message", ((Object) RankListFragment.this.mDescTv.getText()) + "");
            if (!TextUtils.isEmpty(RankListFragment.this.mShareImageUrl)) {
                bundle.putString("imageurl", RankListFragment.this.mShareImageUrl);
                bundle.putString("projectImage", RankListFragment.this.mShareImageUrl);
            }
            if (!TextUtils.isEmpty(RankListFragment.this.mShareBitmapUrl)) {
                bundle.putString("sinaSharePath", RankListFragment.this.mShareBitmapUrl);
            }
            if (!TextUtils.isEmpty(RankListFragment.this.mShareUrl)) {
                bundle.putString("producturl", RankListFragment.this.mShareUrl);
            }
            bundle.putBoolean("showGenerateImage", true);
            bundle.putString("shareType", "chat_h5");
            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_RANKING_IMAGE);
            ShareManager.E().O(RankListFragment.this.baseActivity, bundle, R$layout.rank_activity);
        }
    }

    /* compiled from: Taobao */
    public class h implements PtrHandler {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1327366478")) {
                return RankListFragment.this.mAppBar.getTop() >= 0;
            }
            return ((Boolean) ipChange.ipc$dispatch("1327366478", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "14715395")) {
                ipChange.ipc$dispatch("14715395", new Object[]{this, ptrFrameLayout});
                return;
            }
            RankListFragment.this.loadData();
        }
    }

    /* compiled from: Taobao */
    public class i implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "383957965")) {
                ipChange.ipc$dispatch("383957965", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = ((float) Math.abs(i)) / ((float) appBarLayout.getHeight());
            if (abs > 0.5f) {
                ne2.f(RankListFragment.this.baseActivity, true, R$color.black);
                ne2.d(true, RankListFragment.this.baseActivity);
                RankListFragment.this.mBackBtn.setTextColor(-16777216);
                RankListFragment.this.mShareBtn.setTextColor(Color.parseColor("#5F6672"));
                TextView textView = RankListFragment.this.mMoreRank;
                int i2 = R$drawable.bg_share_pink;
                textView.setBackgroundResource(i2);
                RankListFragment.this.mWannaSee.setBackgroundResource(i2);
                RankListFragment.this.mMoreRank.setTextColor(Color.parseColor("#FF79BD"));
                RankListFragment.this.mWannaSee.setTextColor(Color.parseColor("#FF79BD"));
            } else {
                ne2.e(RankListFragment.this.baseActivity);
                RankListFragment.this.mBackBtn.setTextColor(-1);
                RankListFragment.this.mShareBtn.setTextColor(-1);
                TextView textView2 = RankListFragment.this.mMoreRank;
                int i3 = R$drawable.bg_btn_33white;
                textView2.setBackgroundResource(i3);
                RankListFragment.this.mMoreRank.setTextColor(-1);
                RankListFragment.this.mWannaSee.setBackgroundResource(i3);
                RankListFragment.this.mWannaSee.setTextColor(-1);
            }
            if (abs > 1.0f) {
                abs = 1.0f;
            }
            RankListFragment.this.mTitleBgLayout.setAlpha(abs);
            RankListFragment.this.mStatusBarSpace.setAlpha(abs);
            RankListFragment.this.mTitleTv.setAlpha(abs);
            RankListFragment.this.mHeader.scrollTo(0, -i);
            if (appBarLayout.getHeight() == Math.abs(i)) {
                z = true;
            }
            if (((AbsFragment) RankListFragment.this).mRecyclerView != null) {
                ((AbsFragment) RankListFragment.this).mRecyclerView.setBackgroundResource(z ? R$drawable.bg_white : R$drawable.discount_lv_bg);
            }
        }
    }

    /* compiled from: Taobao */
    public class j implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j(RankListFragment rankListFragment) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "414434683")) {
                ipChange.ipc$dispatch("414434683", new Object[]{this, dVar});
            }
        }
    }

    private void getShareData(RankListHeader rankListHeader) {
        RankItemBean rankItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959745802")) {
            ipChange.ipc$dispatch("1959745802", new Object[]{this, rankListHeader});
            return;
        }
        if (TextUtils.isEmpty(rankListHeader.shareUrl)) {
            this.mShareBtn.setVisibility(8);
        } else {
            this.mShareBtn.setVisibility(0);
            cn.damai.common.user.c.e().G(this.mShareBtn, "share", "top", this.spmB, getUtMap());
        }
        this.mShareUrl = rankListHeader.shareUrl;
        List<RankItemBean> list = rankListHeader.list;
        if (list != null && (rankItemBean = list.get(0)) != null) {
            cn.damai.common.image.a.b().f(rankItemBean.headPic, n42.a(this.baseActivity, 111.0f), n42.a(this.baseActivity, 148.0f)).n(new a()).e(new j(this)).f();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private Map<String, String> getUtMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668107119")) {
            return (Map) ipChange.ipc$dispatch("-668107119", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put(za.CNT_CONTENT_ID, this.mId);
        String str = this.mCityId;
        if (str != null) {
            hashMap.put("city", str);
        } else {
            hashMap.put("city", d20.c());
        }
        RankListHeader rankListHeader = this.headerBean;
        if (rankListHeader != null) {
            hashMap.put("titlelabel", rankListHeader.name);
        }
        hashMap.put(za.CNT_CONTENT_TYPE, "ranklist");
        return hashMap;
    }

    private void initList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415573173")) {
            ipChange.ipc$dispatch("1415573173", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.baseActivity).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot = inflate;
        this.mRecyclerView.setLoadMoreFooterView(inflate);
        this.mRecyclerView.setRefreshEnabled(false);
    }

    private void initTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1388454306")) {
            ipChange.ipc$dispatch("1388454306", new Object[]{this});
            return;
        }
        this.mStatusBarSpace = findViewById(R$id.title_bar_space);
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mAppBar = (AppBarLayout) findViewById(R$id.appbar);
        this.mHeader = findViewById(R$id.header);
        this.mTitleBgLayout = findViewById(R$id.title_bg_layout);
        this.mPtr = (PtrFrameLayout) findViewById(R$id.discount_ticket_ptr);
        this.mBgImg = (ImageView) findViewById(R$id.header_image);
        this.mTitleTv = (TextView) findViewById(R$id.title_tv);
        this.mTopTitleTv = (TextView) findViewById(R$id.tv_title);
        this.mDescTv = (TextView) findViewById(R$id.tv_desc);
        this.mBackBtn = (TextView) findViewById(R$id.title_back_btn);
        this.mShareBtn = (TextView) findViewById(R$id.title_share_btn);
        this.mWannaSee = (TextView) findViewById(R$id.title_wannasee_btn);
        this.mMoreRank = (TextView) findViewById(R$id.title_more_rank_btn);
        View findViewById = findViewById(R$id.tv_collect_tip);
        this.mCollectTipIcon = findViewById;
        findViewById.setVisibility(8);
        this.mMoreRank.setOnClickListener(new d());
        this.mWannaSee.setOnClickListener(new e());
        this.mBackBtn.setOnClickListener(new f());
        this.mShareBtn.setOnClickListener(new g());
        PtrUiHeader ptrUiHeader = new PtrUiHeader(this.baseActivity);
        this.mPtr.setHeaderView(ptrUiHeader);
        this.mPtr.addPtrUIHandler(ptrUiHeader);
        this.mPtr.setPtrIndicator(new aj0(100, this.baseActivity));
        this.mPtr.setResistance(1.7f);
        this.mPtr.setPtrHandler(new h());
        this.mPtr.addPtrUIHandler(new PtrClassicDefaultHeader(this.baseActivity) {
            /* class cn.damai.category.ranking.ui.RankListFragment.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // in.srain.cube.views.ptr.PtrClassicDefaultHeader, in.srain.cube.views.ptr.PtrUIHandler
            public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rv1 rv1) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1665701679")) {
                    ipChange.ipc$dispatch("-1665701679", new Object[]{this, ptrFrameLayout, Boolean.valueOf(z), Byte.valueOf(b), rv1});
                    return;
                }
                super.onUIPositionChange(ptrFrameLayout, z, b, rv1);
                int d = rv1.d();
                ViewGroup.LayoutParams layoutParams = RankListFragment.this.mBgImg.getLayoutParams();
                int a = n42.a(getContext(), 215.0f);
                int abs = Math.abs(d) + a;
                layoutParams.height = abs;
                RankListFragment.this.mBgImg.setPivotX(((float) RankListFragment.this.mBgImg.getWidth()) / 2.0f);
                RankListFragment.this.mBgImg.setScaleX(((float) abs) / ((float) a));
                RankListFragment.this.mBgImg.setLayoutParams(layoutParams);
            }
        });
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new i());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isFastDoubleClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790343654")) {
            return ((Boolean) ipChange.ipc$dispatch("-1790343654", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.e("lastClickTime", "long = " + (currentTimeMillis - this.lastClickTime));
        if (currentTimeMillis - this.lastClickTime < 500) {
            this.lastClickTime = currentTimeMillis;
            return true;
        }
        this.lastClickTime = currentTimeMillis;
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void jumpRankSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734186028")) {
            ipChange.ipc$dispatch("734186028", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(this.spmB, "top", "more", getUtMap(), Boolean.FALSE));
        RankListHeader rankListHeader = this.headerBean;
        if (rankListHeader == null || TextUtils.isEmpty(rankListHeader.categoryId)) {
            DMNav.from(getActivity()).toUri("damai://V1/RankSquareCmsPage");
            return;
        }
        DMNav from = DMNav.from(getActivity());
        from.toUri("damai://V1/RankSquareCmsPage?categoryId=" + this.headerBean.categoryId);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843974547")) {
            ipChange.ipc$dispatch("843974547", new Object[]{this});
            return;
        }
        startProgressDialog();
        final TetrisRequest tetrisRequest = new TetrisRequest(new RankListRequest(this.mId));
        AnonymousClass8 r1 = new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.category.ranking.ui.RankListFragment.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.category.ranking.ui.RankListFragment$8$a */
            /* compiled from: Taobao */
            public class a implements OnErrorClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
                public void handleError(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1871424669")) {
                        ipChange.ipc$dispatch("1871424669", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    AnonymousClass8 r5 = AnonymousClass8.this;
                    tetrisRequest.request(RankListFragment.this.dmlistener);
                }
            }

            /* renamed from: cn.damai.category.ranking.ui.RankListFragment$8$b */
            /* compiled from: Taobao */
            public class b implements OnErrorClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                b() {
                }

                @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
                public void handleError(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1026952798")) {
                        ipChange.ipc$dispatch("1026952798", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    AnonymousClass8 r5 = AnonymousClass8.this;
                    tetrisRequest.request(RankListFragment.this.dmlistener);
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-200667602")) {
                    ipChange.ipc$dispatch("-200667602", new Object[]{this, str, str2});
                    return;
                }
                RankListFragment.this.stopProgressDialog();
                RankListFragment.this.mPtr.refreshComplete();
                ((AbsFragment) RankListFragment.this).mRecyclerView.setRefreshing(false);
                RankListFragment.this.showErrorView(str, str2, null, new b());
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                ArrayList<BaseLayer> arrayList;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-846304176")) {
                    ipChange.ipc$dispatch("-846304176", new Object[]{this, baseResponse});
                    return;
                }
                RankListFragment.this.stopProgressDialog();
                RankListFragment.this.mPtr.refreshComplete();
                ((AbsFragment) RankListFragment.this).mRecyclerView.setRefreshing(false);
                if (baseResponse == null || (arrayList = baseResponse.layers) == null || arrayList.size() == 0) {
                    RankListFragment.this.showErrorView(null, null, null, new a());
                    return;
                }
                RankListFragment.this.updateTop(baseResponse);
                GlobalConfig globalConfig = baseResponse.globalConfig;
                if (globalConfig != null) {
                    RankListFragment rankListFragment = RankListFragment.this;
                    String str = globalConfig.pageName;
                    rankListFragment.spmB = str;
                    rankListFragment.updateSpmB(str, globalConfig.abBuckets);
                    baseResponse.globalConfig.putBuzUTMap(RankListFragment.this.getUtMap());
                }
                RankListItemHolder.Companion.b(new HashMap<>());
                RankListFragment.this.setData(baseResponse);
            }
        };
        this.dmlistener = r1;
        tetrisRequest.request(r1);
    }

    public static RankListFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647199847")) {
            return (RankListFragment) ipChange.ipc$dispatch("647199847", new Object[]{str});
        }
        RankListFragment rankListFragment = new RankListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RANK_ID, str);
        rankListFragment.setArguments(bundle);
        return rankListFragment;
    }

    private void parseJson(BaseLayer baseLayer) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551956048")) {
            ipChange.ipc$dispatch("-551956048", new Object[]{this, baseLayer});
            return;
        }
        for (BaseSection baseSection : baseLayer.getSections()) {
            if (baseSection != null && "dm_list_header_ranking".equals(baseSection.getComponentId())) {
                try {
                    this.headerBean = (RankListHeader) JSON.parseObject(baseSection.getItem().toJSONString(), RankListHeader.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (baseSection != null && "dm_list_card_ranking".equals(baseSection.getComponentId())) {
                try {
                    JSONObject parseObject = JSON.parseObject(baseSection.getItem().toJSONString());
                    if (!(parseObject.getJSONArray("result") == null || (jSONArray = parseObject.getJSONArray("result")) == null || jSONArray.get(0) == null)) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                        if (jSONObject != null) {
                            this.mShareImageUrl = jSONObject.getString("headPic");
                        }
                        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            if (jSONObject2 != null) {
                                jSONObject2.put(KEY_RANK_ID, (Object) this.mId);
                                jSONObject2.put("rankName", (Object) this.headerBean.name);
                            }
                        }
                        baseSection.setItem(parseObject);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void startTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168486072")) {
            ipChange.ipc$dispatch("168486072", new Object[]{this});
            return;
        }
        cancelCountDown();
        if (this.mTimeCountDown == null) {
            this.mTimeCountDown = new c(3000, 3000);
        }
        this.mTimeCountDown.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateSpmB(String str, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644495322")) {
            ipChange.ipc$dispatch("1644495322", new Object[]{this, str, jSONArray});
        } else if (getActivity() != null && (getActivity() instanceof DamaiBaseActivity)) {
            HashMap hashMap = new HashMap();
            if (jSONArray != null) {
                hashMap.put("current_ab", jSONArray.toJSONString());
            }
            if (getUserVisibleHint()) {
                cn.damai.common.user.c.e().L(getActivity(), str);
                cn.damai.common.user.c.e().l(getActivity(), new a.b().i(str).j(hashMap));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTop(BaseResponse baseResponse) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880895622")) {
            ipChange.ipc$dispatch("880895622", new Object[]{this, baseResponse});
            return;
        }
        if (baseResponse.layers.size() > 0) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                if (next.getSections() != null && next.getSections().size() > 0) {
                    parseJson(next);
                }
            }
        }
        RankListHeader rankListHeader = this.headerBean;
        if (rankListHeader != null) {
            int i2 = rankListHeader.type;
            if (i2 == 99) {
                this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_repro);
            } else if (i2 == 2) {
                this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_new);
            } else if (i2 == 3) {
                this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_hiscore);
            } else {
                this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_top);
            }
            this.mTitleTv.setText(this.headerBean.name);
            this.mTopTitleTv.setText(this.headerBean.name);
            if (!TextUtils.isEmpty(this.headerBean.desc) && !TextUtils.isEmpty(this.headerBean.updateDesc)) {
                str = this.headerBean.desc + " | " + this.headerBean.updateDesc;
            } else if (!TextUtils.isEmpty(this.headerBean.desc)) {
                str = this.headerBean.desc;
            } else {
                str = !TextUtils.isEmpty(this.headerBean.updateDesc) ? this.headerBean.updateDesc : "";
            }
            this.mDescTv.setText(str);
            int i3 = this.headerBean.followStatus;
            this.followStatus = i3;
            if (i3 == 1) {
                this.mWannaSee.setText("已想看");
            } else {
                this.mWannaSee.setText("想看");
                visCollectTip(TextUtils.isEmpty(this.headerBean.shareUrl));
            }
            cn.damai.common.user.c.e().G(this.mWannaSee, "favorite", "top", this.spmB, getUtMap());
            cn.damai.common.user.c.e().G(this.mMainView, "more", "top", this.spmB, getUtMap());
            getShareData(this.headerBean);
        }
    }

    private void visCollectTip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173076962")) {
            ipChange.ipc$dispatch("-173076962", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("rankListFragment_sp", 0);
        if (!sharedPreferences.getBoolean("rankListFragment_sp_favorite", false)) {
            sharedPreferences.edit().putBoolean("rankListFragment_sp_favorite", true).commit();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCollectTipIcon.getLayoutParams();
            layoutParams.rightMargin = n42.a(getActivity(), z ? 10.0f : 50.0f);
            this.mCollectTipIcon.setLayoutParams(layoutParams);
            this.mCollectTipIcon.setVisibility(0);
            startTime();
        }
    }

    /* access modifiers changed from: protected */
    public void adjustStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513680715")) {
            ipChange.ipc$dispatch("-513680715", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            ne2.f(this.baseActivity, true, R$color.black);
        } else {
            ne2.f(this.baseActivity, false, R$color.black);
        }
        if (findViewById == null) {
            return;
        }
        if (i2 >= 23) {
            findViewById.getLayoutParams().height = ne2.a(this.baseActivity);
            this.mAppBar.getLayoutParams().height = (n42.a(this.baseActivity, 180.0f) - n42.a(this.baseActivity, 44.0f)) - ne2.a(this.baseActivity);
            findViewById.setVisibility(0);
            return;
        }
        findViewById.setVisibility(8);
    }

    public void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200712592")) {
            ipChange.ipc$dispatch("1200712592", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.mTimeCountDown;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimeCountDown = null;
        }
    }

    public <T extends View> T findViewById(@IdRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453284270")) {
            return (T) ((View) ipChange.ipc$dispatch("-1453284270", new Object[]{this, Integer.valueOf(i2)}));
        }
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            return null;
        }
        return (T) viewGroup.findViewById(i2);
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public int getRecycleViewId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1655253831")) {
            return R$id.discount_ticket_recycler;
        }
        return ((Integer) ipChange.ipc$dispatch("-1655253831", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051715364")) {
            ipChange.ipc$dispatch("-2051715364", new Object[]{this});
            return;
        }
        RankListActivity rankListActivity = this.baseActivity;
        if (rankListActivity != null) {
            rankListActivity.hideErrorView(this.mMainView);
        }
    }

    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687835470")) {
            ipChange.ipc$dispatch("1687835470", new Object[]{this});
            return;
        }
        initTop();
        adjustStatusBar();
        this.wantSeeTips = (WantSeeTips) findViewById(R$id.want_see_tips_rank_list);
        initList();
        loadData();
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put(za.CNT_CONTENT_ID, this.mId);
        String str = this.mCityId;
        if (str != null) {
            hashMap.put("city", str);
        } else {
            hashMap.put("city", d20.c());
        }
        hashMap.put(za.CNT_CONTENT_TYPE, "ranklist");
        this.baseActivity.setDamaiUTKeyBuilder(new a.b().j(hashMap).i("ranklist"));
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743348149")) {
            ipChange.ipc$dispatch("743348149", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        ShareManager.E().r0(i2, i3, intent);
        if (i2 == 4097 && i3 == -1 && getActivity() != null) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_RANK_ID, this.mId);
            bundle.putString("cityId", this.mCityId);
            DMNav.from(getActivity()).withExtras(bundle).toUri(NavUri.b("ranking"));
            getActivity().finish();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042489896")) {
            return (View) ipChange.ipc$dispatch("-1042489896", new Object[]{this, layoutInflater, viewGroup, bundle});
        } else if (getArguments() == null) {
            return null;
        } else {
            try {
                this.mId = getArguments().getString(KEY_RANK_ID);
                this.mCityId = getArguments().getString("cityId");
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return layoutInflater.inflate(R$layout.rank_activity, viewGroup, false);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122566252")) {
            ipChange.ipc$dispatch("2122566252", new Object[]{this});
            return;
        }
        super.onDestroy();
        cancelCountDown();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038841591")) {
            ipChange.ipc$dispatch("-1038841591", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i2, Object obj) {
        WantSeeTips wantSeeTips2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118183552")) {
            ipChange.ipc$dispatch("118183552", new Object[]{this, Integer.valueOf(i2), obj});
        } else if (i2 == 24 && (obj instanceof FollowDataBean)) {
            this.wantSeeTips.setPageSource(WantSeeTips.a.f.INSTANCE);
            if (!cy2.INSTANCE.e(this.baseActivity, new b(((FollowDataBean) obj).tempRank)) && (wantSeeTips2 = this.wantSeeTips) != null) {
                wantSeeTips2.showAnim();
            }
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340647915")) {
            ipChange.ipc$dispatch("340647915", new Object[]{this});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "779093317")) {
            ipChange.ipc$dispatch("779093317", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.rootView = (ViewGroup) view;
        this.baseActivity = (RankListActivity) getActivity();
        initView();
    }

    public void requestFollow(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803917355")) {
            ipChange.ipc$dispatch("1803917355", new Object[]{this, view});
            return;
        }
        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(this.spmB, "top", "favorite", getUtMap(), Boolean.FALSE));
        view.setClickable(false);
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = this.followStatus == 1 ? "0" : "1";
        followRequest.targetId = this.mId;
        followRequest.targetType = "13";
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.category.ranking.ui.RankListFragment.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.category.ranking.ui.RankListFragment$12$a */
            /* compiled from: Taobao */
            public class a implements GuideUtProvider {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public Map<String, String> getGuideCloseBtnArgMap() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-1792284506")) {
                        return getGuideExposeArgMap();
                    }
                    return (Map) ipChange.ipc$dispatch("-1792284506", new Object[]{this});
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public Map<String, String> getGuideExposeArgMap() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2066322342")) {
                        return (Map) ipChange.ipc$dispatch("2066322342", new Object[]{this});
                    }
                    HashMap hashMap = new HashMap();
                    RankListHeader rankListHeader = RankListFragment.this.headerBean;
                    if (rankListHeader != null && !TextUtils.isEmpty(rankListHeader.name)) {
                        hashMap.put("titlelabel", RankListFragment.this.headerBean.name);
                    }
                    if (!TextUtils.isEmpty(RankListFragment.this.mId)) {
                        hashMap.put(za.CNT_CONTENT_ID, RankListFragment.this.mId);
                    }
                    return hashMap;
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public Map<String, String> getGuideGoMineBtnArgMap() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "2128443133")) {
                        return getGuideExposeArgMap();
                    }
                    return (Map) ipChange.ipc$dispatch("2128443133", new Object[]{this});
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public String getSpmB() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "1654797055")) {
                        return RankListFragment.this.spmB;
                    }
                    return (String) ipChange.ipc$dispatch("1654797055", new Object[]{this});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1706681131")) {
                    ipChange.ipc$dispatch("1706681131", new Object[]{this, str, str2});
                    return;
                }
                view.setClickable(true);
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1962183125")) {
                    ipChange.ipc$dispatch("1962183125", new Object[]{this, followDataBean});
                    return;
                }
                view.setClickable(true);
                if (followDataBean != null) {
                    RankListFragment.this.followStatus = followDataBean.getStatus();
                    if (followDataBean.getStatus() == 1) {
                        ((TextView) view).setText("已想看");
                        RankListFragment.this.wantSeeTips.setPageSource(WantSeeTips.a.g.INSTANCE);
                        if (!cy2.INSTANCE.e(RankListFragment.this.baseActivity, new a()) && RankListFragment.this.wantSeeTips != null) {
                            RankListFragment.this.wantSeeTips.showAnim();
                            return;
                        }
                        return;
                    }
                    ((TextView) view).setText("想看");
                }
            }
        });
    }

    public void showErrorView(String str, String str2, String str3, OnErrorClickListener onErrorClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022258110")) {
            ipChange.ipc$dispatch("-2022258110", new Object[]{this, str, str2, str3, onErrorClickListener});
            return;
        }
        RankListActivity rankListActivity = this.baseActivity;
        if (rankListActivity != null) {
            rankListActivity.showErrorView(this.mMainView, str, str2, str3, onErrorClickListener);
        }
    }
}

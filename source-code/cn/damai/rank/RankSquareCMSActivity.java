package cn.damai.rank;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.city.CitySelectActivity;
import cn.damai.commonbusiness.city.bean.CityParam;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.livehouse.ComponentFragment;
import cn.damai.rank.listener.TitleModeChangeListener;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.component.rank.bean.PresetBean;
import cn.damai.tetris.component.rank.bean.RankCityValue;
import cn.damai.tetris.component.rank.bean.RankFilterTarget;
import cn.damai.tetris.component.rank.bean.RankFilterValue;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.component.rank.bean.RankProjectParams;
import cn.damai.tetris.request.TetrisParams;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.container.ValueKey;
import cn.damai.uikit.view.SimpleTitleLayout;
import cn.damai.wantsee.GuideUtProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import tb.a03;
import tb.c71;
import tb.cy2;
import tb.d20;
import tb.ex1;
import tb.gr;
import tb.za;

/* compiled from: Taobao */
public class RankSquareCMSActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CITY_OBTAIN_REQUEST_CODE = 33426;
    public static final String PAGE_NAME = "ranklist_square";
    public static final String PRESET_CATEGORY_ID = "categoryId";
    public static final String PRESET_CITY_ID = "cityId";
    public static final String PRESET_CITY_NAME = "cityName";
    private String mCityId;
    private String mCityName;
    private String mDefaultSelectCategoryId;
    private SimpleTitleLayout mStlLayout;
    private WantSeeTips wantSeeTips;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1682236194")) {
                ipChange.ipc$dispatch("1682236194", new Object[]{this, view});
                return;
            }
            ex1.Instance.b(RankSquareCMSActivity.this.mCityName);
            Bundle bundle = new Bundle();
            bundle.putParcelable(CitySelectActivity.OBTAIN_CITY_PARAM, CityParam.onlyObtainCity(RankSquareCMSActivity.this.mCityName));
            DMNav.from(RankSquareCMSActivity.this).withExtras(bundle).forResult(RankSquareCMSActivity.CITY_OBTAIN_REQUEST_CODE).toHost("home_cityselect");
        }
    }

    /* compiled from: Taobao */
    public class b implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1008520618")) {
                ipChange.ipc$dispatch("-1008520618", new Object[]{this});
                return;
            }
            RankSquareCMSActivity.this.finish();
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1129782")) {
                ipChange.ipc$dispatch("-1129782", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ComponentFragment.OnCompFragmentListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.livehouse.ComponentFragment.OnCompFragmentListener
        public TetrisParams obtainPreferParams() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "280813362")) {
                return (TetrisParams) ipChange.ipc$dispatch("280813362", new Object[]{this});
            }
            RankProjectParams rankProjectParams = new RankProjectParams(RankProjectParams.RANK_SQUARE_PATTERN_NAME, "1.0");
            rankProjectParams.comboDamaiCityId = RankSquareCMSActivity.this.mCityId;
            rankProjectParams.cityId = RankSquareCMSActivity.this.mCityId;
            rankProjectParams.currentCityId = d20.c();
            rankProjectParams.categoryId = RankSquareCMSActivity.this.mDefaultSelectCategoryId;
            return rankProjectParams;
        }

        @Override // cn.damai.livehouse.ComponentFragment.OnCompFragmentListener
        public void onViewCreatedFinish(ComponentFragment componentFragment) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1323091703")) {
                ipChange.ipc$dispatch("1323091703", new Object[]{this, componentFragment});
                return;
            }
            IContainer pageContainer = componentFragment.getPageContainer();
            if (pageContainer != null) {
                pageContainer.saveContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, RankCityValue.class, new RankCityValue(RankSquareCMSActivity.this.mCityId, RankSquareCMSActivity.this.mCityName, RankSquareCMSActivity.this.mDefaultSelectCategoryId));
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements ComponentFragment.OnWantSeeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ComponentFragment a;

        /* compiled from: Taobao */
        public class a implements GuideUtProvider {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ FollowDataBean a;

            a(FollowDataBean followDataBean) {
                this.a = followDataBean;
            }

            @Override // cn.damai.wantsee.GuideUtProvider
            @NonNull
            public Map<String, String> getGuideCloseBtnArgMap() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-504617593")) {
                    return getGuideExposeArgMap();
                }
                return (Map) ipChange.ipc$dispatch("-504617593", new Object[]{this});
            }

            @Override // cn.damai.wantsee.GuideUtProvider
            @NonNull
            public Map<String, String> getGuideExposeArgMap() {
                RankFilterValue rankFilterValue;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-958032697")) {
                    return (Map) ipChange.ipc$dispatch("-958032697", new Object[]{this});
                }
                HashMap hashMap = new HashMap();
                try {
                    RankItemBean rankItemBean = this.a.tempRank;
                    if (rankItemBean != null) {
                        String str = null;
                        IContainer pageContainer = d.this.a.getPageContainer();
                        if (!(pageContainer == null || (rankFilterValue = (RankFilterValue) pageContainer.getContainerValue(ValueKey.KEY_RANK_SQUARE_FILTER_INFO, new RankFilterTarget())) == null)) {
                            str = rankFilterValue.weiDuTabName;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            hashMap.put("titlelabel", str);
                        }
                        hashMap.put("item_id", rankItemBean.id + "");
                        hashMap.put(za.CNT_CONTENT_ID, rankItemBean.rankId);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return hashMap;
            }

            @Override // cn.damai.wantsee.GuideUtProvider
            @NonNull
            public Map<String, String> getGuideGoMineBtnArgMap() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-903555524")) {
                    return getGuideExposeArgMap();
                }
                return (Map) ipChange.ipc$dispatch("-903555524", new Object[]{this});
            }

            @Override // cn.damai.wantsee.GuideUtProvider
            @NonNull
            public String getSpmB() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1026947424")) {
                    return "ranklist_square";
                }
                return (String) ipChange.ipc$dispatch("1026947424", new Object[]{this});
            }
        }

        d(ComponentFragment componentFragment) {
            this.a = componentFragment;
        }

        @Override // cn.damai.livehouse.ComponentFragment.OnWantSeeListener
        public void onWantSeeClick(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1562856916")) {
                ipChange.ipc$dispatch("1562856916", new Object[]{this, followDataBean});
            } else if (!cy2.INSTANCE.e(RankSquareCMSActivity.this, new a(followDataBean)) && RankSquareCMSActivity.this.wantSeeTips != null) {
                RankSquareCMSActivity.this.wantSeeTips.showAnim();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-629802932")) {
            ipChange.ipc$dispatch("-629802932", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2139060766")) {
            return R$layout.activity_rank_square_cmsactivity;
        }
        return ((Integer) ipChange.ipc$dispatch("2139060766", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24375581")) {
            ipChange.ipc$dispatch("24375581", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126504110")) {
            ipChange.ipc$dispatch("2126504110", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112980271")) {
            ipChange.ipc$dispatch("112980271", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        PresetBean obtainPresetBean = PresetBean.obtainPresetBean(intent);
        this.mCityId = obtainPresetBean.cityId;
        this.mCityName = obtainPresetBean.cityName;
        this.mDefaultSelectCategoryId = obtainPresetBean.categoryId;
        intent.putExtra("patternName", RankProjectParams.RANK_SQUARE_PATTERN_NAME);
        intent.putExtra("patternVersion", "1.0");
        intent.removeExtra("cityId");
        intent.removeExtra(PRESET_CITY_NAME);
        intent.removeExtra("categoryId");
        cn.damai.common.user.c.e().K(this);
        HashMap hashMap = new HashMap();
        a03.a(hashMap);
        setDamaiUTKeyBuilder(new a.b().i("ranklist_square").j(hashMap));
        removeHeadTitleView();
        c71 c71 = new c71(this, new a());
        c71.a(this.mCityName);
        ex1.Instance.a(c71.getLeftView(), this.mCityName);
        this.mStlLayout = (SimpleTitleLayout) findViewById(R$id.id_rank_square_stl);
        WantSeeTips wantSeeTips2 = (WantSeeTips) findViewById(R$id.want_see_tips_rank_square);
        this.wantSeeTips = wantSeeTips2;
        wantSeeTips2.setPageSource(WantSeeTips.a.h.INSTANCE);
        this.mStlLayout.addLeftActionView(c71);
        this.mStlLayout.setTitle("大麦演出榜");
        this.mStlLayout.switchMode(true);
        this.mStlLayout.setAlpha(0.0f);
        this.mStlLayout.showShareBtn(false);
        this.mStlLayout.enableDivider(false);
        this.mStlLayout.enableImmersiveMode(this);
        this.mStlLayout.setListener(new b());
        ComponentFragment componentFragment = new ComponentFragment();
        componentFragment.setScrollListener(new TitleModeChangeListener() {
            /* class cn.damai.rank.RankSquareCMSActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.rank.listener.TitleModeChangeListener
            public void b(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1816638600")) {
                    ipChange.ipc$dispatch("-1816638600", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    RankSquareCMSActivity.this.mStlLayout.setAlpha(0.0f);
                } else {
                    RankSquareCMSActivity.this.mStlLayout.setAlpha(1.0f);
                }
            }
        });
        componentFragment.setLifeListener(new c());
        componentFragment.setWantSeeListener(new d(componentFragment));
        getSupportFragmentManager().beginTransaction().add(R$id.id_rank_square_container, componentFragment).commitAllowingStateLoss();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481211222")) {
            ipChange.ipc$dispatch("1481211222", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 33426 && i2 == -1) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(CitySelectActivity.CITY_ID);
                String string2 = extras.getString(CitySelectActivity.CITY_NAME);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.equals(string, this.mCityId)) {
                    finish();
                    Bundle bundle = new Bundle();
                    bundle.putString("cityId", string);
                    bundle.putString(PRESET_CITY_NAME, string2);
                    DMNav.from(this).withExtras(bundle).toHost(gr.RANK_SQUARE_CMS_HOST);
                    overridePendingTransition(-1, -1);
                }
            }
        } else if (i == 4097 && i2 == -1) {
            finish();
            Bundle bundle2 = new Bundle();
            bundle2.putString("cityId", this.mCityId);
            bundle2.putString(PRESET_CITY_NAME, this.mCityName);
            DMNav.from(this).withExtras(bundle2).toHost(gr.RANK_SQUARE_CMS_HOST);
            overridePendingTransition(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1045058578")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1045058578", new Object[]{this});
    }
}

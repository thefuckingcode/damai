package cn.damai.user.brand;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.message.observer.Action;
import cn.damai.player.DMVideoPlayer;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import cn.damai.tetris.component.brand.bean.BrandHeaderInfoBean;
import cn.damai.tetris.component.brand.bean.BrandHeaderRootBean;
import cn.damai.tetris.component.brand.bean.DrawReward;
import cn.damai.tetris.component.common.CommonErrorContract;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.user.star.second.StarSecondActivity;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cr;
import tb.kw2;

/* compiled from: Taobao */
public class BrandFragment extends AbsFragmentV2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String Default_PAGE = "brand";
    public static final String TAG = "BrandFragment";
    private int REQ_CDOE_PUGLISH = 1001;
    Action action;
    Action actionAttenChanged;
    ActivityInfo activityInfo;
    BrandScrollListener brandScrollListener;
    public long id;
    ViewGroup navBar;
    private String pageB = "brand";
    ViewGroup parent;
    int refreshType = 0;
    ScrollAlphaListener scrollAlphaListener;
    private int showType = 0;
    public String type = "4";
    DMVideoPlayer videoPlayer;
    boolean visiableRefreshed = false;

    /* compiled from: Taobao */
    public interface OnInfoUpdate {
        void onBindFollowView(AttentionView attentionView);

        void onInfoUpdate(BrandHeaderInfoBean brandHeaderInfoBean, ActivityInfo activityInfo);
    }

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1511325650")) {
                ipChange.ipc$dispatch("-1511325650", new Object[]{this, obj});
                return;
            }
            BrandFragment.this.refreshByType(0);
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Bundle> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void call(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1158351457")) {
                ipChange.ipc$dispatch("1158351457", new Object[]{this, bundle});
                return;
            }
            BrandFragment.this.refreshByType(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private BrandHeaderRootBean getHeaderDat(BaseResponse baseResponse) {
        NodeData item;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956140561")) {
            return (BrandHeaderRootBean) ipChange.ipc$dispatch("-956140561", new Object[]{this, baseResponse});
        }
        BrandHeaderRootBean brandHeaderRootBean = null;
        if (baseResponse != null && !kw2.a(baseResponse.layers)) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            for (int i = 0; i < arrayList.size(); i++) {
                List<BaseSection> sections = arrayList.get(i).getSections();
                if (!kw2.a(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection.getComponentId().startsWith("dm_brand_head_video") && (item = baseSection.getItem()) != null) {
                            try {
                                brandHeaderRootBean = (BrandHeaderRootBean) JSON.parseObject(item.toJSONString(), BrandHeaderRootBean.class);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return brandHeaderRootBean == null ? new BrandHeaderRootBean() : brandHeaderRootBean;
    }

    private boolean getParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-238154512")) {
            return ((Boolean) ipChange.ipc$dispatch("-238154512", new Object[]{this})).booleanValue();
        } else if (getArguments() == null) {
            return true;
        } else {
            try {
                this.id = Long.parseLong(getArguments().getString("id"));
                this.type = getArguments().getString("type", "4");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static BrandFragment newInstance(String str, String str2, int i, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640383822")) {
            return (BrandFragment) ipChange.ipc$dispatch("-640383822", new Object[]{str, str2, Integer.valueOf(i), str3});
        }
        BrandFragment brandFragment = new BrandFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("type", str2);
        brandFragment.setArguments(bundle);
        brandFragment.showType = i;
        return brandFragment;
    }

    public RecyclerView getR() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1184832946")) {
            return this.mRecyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("-1184832946", new Object[]{this});
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064928364")) {
            ipChange.ipc$dispatch("-2064928364", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317652040")) {
            return (View) ipChange.ipc$dispatch("-1317652040", new Object[]{this, layoutInflater, viewGroup, bundle});
        } else if (getParam()) {
            return null;
        } else {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.user_brand_fragment, viewGroup, false);
            viewGroup2.addView(super.onCreateView(layoutInflater, viewGroup2, bundle), 0);
            this.action = new a();
            cr.c().e(StarSecondActivity.FORCE_TAG, this.action);
            this.actionAttenChanged = new b();
            cr.c().e("brand_state_changed", this.actionAttenChanged);
            return viewGroup2;
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AttentionView attentionView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230169972")) {
            ipChange.ipc$dispatch("-230169972", new Object[]{this});
            return;
        }
        this.scrollAlphaListener = null;
        this.videoPlayer = null;
        this.parent = null;
        this.mBottomView = null;
        this.visiableRefreshed = false;
        this.mRecyclerView.removeOnScrollListener(this.brandScrollListener);
        BrandScrollListener brandScrollListener2 = this.brandScrollListener;
        if (brandScrollListener2 != null) {
            brandScrollListener2.b();
            this.brandScrollListener = null;
        }
        if (!(getActivity() == null || (attentionView = (AttentionView) getActivity().findViewById(R$id.brand_navbar_attention)) == null)) {
            attentionView.cleanAttenList();
        }
        cr.c().a(StarSecondActivity.FORCE_TAG, this.action);
        cr.c().a("brand_state_changed", this.actionAttenChanged);
        super.onDestroy();
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onFragmentResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493042356")) {
            ipChange.ipc$dispatch("1493042356", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onFragmentResult(i, i2, intent);
        if (i == this.REQ_CDOE_PUGLISH) {
            refreshByType(0);
        } else if ((i == 1000 || i == 100) && i2 == -1) {
            refreshByType(1);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778691799")) {
            ipChange.ipc$dispatch("-1778691799", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182777248")) {
            ipChange.ipc$dispatch("-182777248", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i != 10242 || obj == null || !(obj instanceof AttentionView)) {
            if (i == 7001) {
                ScrollAlphaListener scrollAlphaListener2 = this.scrollAlphaListener;
                if (scrollAlphaListener2 != null) {
                    scrollAlphaListener2.onAlphaChanged(0.0f);
                    BrandScrollListener brandScrollListener2 = this.brandScrollListener;
                    if (brandScrollListener2 != null) {
                        brandScrollListener2.e();
                    }
                }
            } else if (i == 10240) {
                if (getActivity() != null && (getActivity() instanceof BrandActivity)) {
                    ((BrandActivity) getActivity()).autoFollow();
                }
            } else if (i == 10243 && getActivity() != null && (getActivity() instanceof BrandActivity) && (obj instanceof DrawReward)) {
                DrawReward drawReward = (DrawReward) obj;
                String str2 = "";
                if (!TextUtils.isEmpty(drawReward.costPrice)) {
                    try {
                        int parseInt = Integer.parseInt(drawReward.costPrice);
                        if (parseInt < 100) {
                            str = (Double.parseDouble(drawReward.costPrice) * 0.01d) + str2;
                        } else {
                            str = (parseInt / 100) + str2;
                        }
                        str2 = str;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ((BrandActivity) getActivity()).requestProject(str2, drawReward.rewardId);
            }
        } else if ((getActivity() instanceof OnInfoUpdate) && getActivity() != null) {
            ((OnInfoUpdate) getActivity()).onBindFollowView((AttentionView) obj);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51768144")) {
            ipChange.ipc$dispatch("51768144", new Object[]{this});
            return;
        }
        super.onPause();
        Log.d("onHiddenChanged", getId() + " : onPause: ");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012088309")) {
            ipChange.ipc$dispatch("-2012088309", new Object[]{this});
        } else if (getUserVisibleHint()) {
            startProgressDialog();
            enableLoadMore();
            requestTetris();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042368329")) {
            ipChange.ipc$dispatch("-1042368329", new Object[]{this});
            return;
        }
        super.onResume();
        Log.d("onHiddenChanged", getId() + " : onResume: ");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009331045")) {
            ipChange.ipc$dispatch("2009331045", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        ((DamaiRootRecyclerView) getRecycler()).setRefreshEnabled(false);
        this.parent = (ViewGroup) view;
        this.navBar = (ViewGroup) getActivity().findViewById(R$id.nav_bar);
        BrandRequest brandRequest = new BrandRequest();
        String patternName = brandRequest.getPatternName();
        String version = brandRequest.getVersion();
        ContainerArg containerArg = new ContainerArg(patternName, version, "{\"brandId\":\"" + this.id + "\"}");
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(containerArg);
        }
        if (!this.visiableRefreshed) {
            refreshByType(0);
        }
    }

    public void refreshByType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594732104")) {
            ipChange.ipc$dispatch("594732104", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.refreshType = i;
        onRefresh();
    }

    public void requestTetris() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1622892031")) {
            ipChange.ipc$dispatch("1622892031", new Object[]{this});
            return;
        }
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.brandId = this.id + "";
        if (this.showType == 0) {
            z = true;
        }
        brandRequest.needCoupon = z;
        TetrisRequest tetrisRequest = new TetrisRequest(brandRequest);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.user.brand.BrandFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.user.brand.BrandFragment$3$a */
            /* compiled from: Taobao */
            public class a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "135045617")) {
                        ipChange.ipc$dispatch("135045617", new Object[]{this, view});
                        return;
                    }
                    BrandFragment.this.sendMsg(new Message(AbsFragment.TETRIS_BIZ_CODE_SHARE, null));
                }
            }

            private void addEmptyView(BaseResponse baseResponse) {
                BaseLayer baseLayer;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1489259340")) {
                    ipChange.ipc$dispatch("1489259340", new Object[]{this, baseResponse});
                    return;
                }
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (arrayList != null && arrayList.size() > 0 && (baseLayer = baseResponse.layers.get(0)) != null && baseLayer.getSections() != null && baseLayer.getSections().size() == 1) {
                    BaseSection baseSection = new BaseSection();
                    baseSection.setComponentId(CommonErrorContract.CID);
                    baseSection.setSectionId(CommonErrorContract.CID);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errorMsg", (Object) "暂时还没有演出哦");
                    baseSection.setItem(jSONObject);
                    baseLayer.getSections().add(baseSection);
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1972761971")) {
                    ipChange.ipc$dispatch("1972761971", new Object[]{this, str, str2});
                    return;
                }
                BrandFragment.this.stopProgressDialog();
                BrandFragment.this.refreshFinish();
                BrandFragment.this.onResponseError(str, str2, "");
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1194214037")) {
                    ipChange.ipc$dispatch("-1194214037", new Object[]{this, baseResponse});
                    return;
                }
                BrandFragment.this.stopProgressDialog();
                BrandFragment.this.refreshFinish();
                BrandFragment brandFragment = BrandFragment.this;
                ScrollAlphaListener scrollAlphaListener = brandFragment.scrollAlphaListener;
                if (scrollAlphaListener != null) {
                    if (brandFragment.refreshType == 0) {
                        scrollAlphaListener.onAlphaChanged(0.0f);
                    }
                    BrandScrollListener brandScrollListener = BrandFragment.this.brandScrollListener;
                    if (brandScrollListener != null) {
                        brandScrollListener.e();
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("biz_id", BrandFragment.this.id + "");
                hashMap.put("brand_id", BrandFragment.this.id + "");
                hashMap.put("biz_type", BrandFragment.this.type + "");
                baseResponse.globalConfig.putBuzUTMap(hashMap);
                if (baseResponse.globalConfig != null) {
                    BrandFragment brandFragment2 = BrandFragment.this;
                    brandFragment2.updateB((BrandFragment) brandFragment2.pageB, (String) baseResponse.globalConfig);
                    GlobalConfig globalConfig = baseResponse.globalConfig;
                    if (globalConfig.extraInfo == null) {
                        globalConfig.extraInfo = new JSONObject();
                    }
                }
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (arrayList == null || arrayList.size() == 0) {
                    BrandFragment.this.onResponseError("", "", "");
                    return;
                }
                BrandFragment.this.onResponseSuccess();
                addEmptyView(baseResponse);
                BrandFragment.this.setData(baseResponse);
                ((AbsFragment) BrandFragment.this).mRecyclerView.postDelayed(new Runnable() {
                    /* class cn.damai.user.brand.BrandFragment.AnonymousClass3.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "2090011584")) {
                            ipChange.ipc$dispatch("2090011584", new Object[]{this});
                            return;
                        }
                        BrandFragment.this.sendMsg(new Message(2000, ((AbsFragment) BrandFragment.this).mRecyclerView));
                    }
                }, 1000);
                BrandHeaderRootBean headerDat = BrandFragment.this.getHeaderDat(baseResponse);
                BrandFragment.this.activityInfo = headerDat.getActivityDO();
                BrandFragment brandFragment3 = BrandFragment.this;
                brandFragment3.brandScrollListener = new BrandScrollListener(brandFragment3, brandFragment3.parent, brandFragment3.scrollAlphaListener, headerDat.getAccountPageResult(), headerDat.getActivityDO());
                ((AbsFragment) BrandFragment.this).mRecyclerView.addOnScrollListener(BrandFragment.this.brandScrollListener);
                if (BrandFragment.this.getActivity() instanceof OnInfoUpdate) {
                    ((OnInfoUpdate) BrandFragment.this.getActivity()).onInfoUpdate(headerDat.getAccountPageResult(), headerDat.getActivityDO());
                }
                ViewGroup viewGroup = BrandFragment.this.navBar;
                if (viewGroup != null) {
                    viewGroup.findViewById(R$id.ll_share).setOnClickListener(new a());
                }
            }
        });
    }

    public void setScrollAlphaListener(ScrollAlphaListener scrollAlphaListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1304538574")) {
            ipChange.ipc$dispatch("-1304538574", new Object[]{this, scrollAlphaListener2});
            return;
        }
        this.scrollAlphaListener = scrollAlphaListener2;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-134227939")) {
            ipChange.ipc$dispatch("-134227939", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        Log.d("onHiddenChanged", getId() + " : setUserVisibleHint: " + z);
        if (z) {
            this.visiableRefreshed = true;
            getParam();
        }
        refreshByType(0);
    }
}

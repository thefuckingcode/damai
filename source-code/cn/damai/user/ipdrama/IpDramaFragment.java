package cn.damai.user.ipdrama;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.user.bean.ShareBean;
import cn.damai.user.ipdrama.mtop.IpDramaRequest;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb.d20;
import tb.jl1;
import tb.s50;
import tb.wj2;

/* compiled from: Taobao */
public class IpDramaFragment extends AbsFragmentV2 {
    private static transient /* synthetic */ IpChange $ipChange;
    DrObj drObj;
    String ipId;
    a.b mUTBuilder;
    OnAlphaChangeListener onAlphaChangeListener;
    int pageIndex = 1;
    ViewGroup rootView;
    int topBarH;

    /* compiled from: Taobao */
    interface OnAlphaChangeListener {
        void onAlphaChaged(float f);
    }

    /* compiled from: Taobao */
    public class a implements AbsFragmentV2.SectionDataPreDealListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(IpDramaFragment ipDramaFragment) {
        }

        @Override // cn.damai.tetris.page.AbsFragmentV2.SectionDataPreDealListener
        public void doSectionData(BaseSection baseSection) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1631067148")) {
                ipChange.ipc$dispatch("-1631067148", new Object[]{this, baseSection});
                return;
            }
            if (baseSection.getStyle() == null) {
                baseSection.setStyle(new JSONObject());
            }
            if (baseSection.getStyle().get("bgColor") == null) {
                baseSection.getStyle().put("bgColor", "#1d1d2f");
            }
        }
    }

    private void moveToAnchor(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235036929")) {
            ipChange.ipc$dispatch("-1235036929", new Object[]{this, baseResponse});
            return;
        }
        Iterator<BaseLayer> it = baseResponse.layers.iterator();
        int i = 0;
        while (it.hasNext()) {
            for (BaseSection baseSection : it.next().getSections()) {
                if (!wj2.DISCOVER_FEED_COMPONENT_ID.equals(baseSection.getComponentId())) {
                    i++;
                }
            }
        }
        this.mRecyclerView.scrollToPosition(i);
        ((VirtualLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
    }

    public static IpDramaFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762143229")) {
            return (IpDramaFragment) ipChange.ipc$dispatch("-762143229", new Object[]{str});
        }
        IpDramaFragment ipDramaFragment = new IpDramaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        ipDramaFragment.setArguments(bundle);
        return ipDramaFragment;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156834890")) {
            return (View) ipChange.ipc$dispatch("156834890", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.fragment_layout_ipdrama, viewGroup, false);
        this.rootView = viewGroup2;
        this.rootView.addView(super.onCreateView(layoutInflater, viewGroup2, bundle), 0);
        this.mUTBuilder = new a.b().i("repertoire_ip");
        return this.rootView;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1296149929")) {
            ipChange.ipc$dispatch("-1296149929", new Object[]{this, view});
            return;
        }
        DrObj drObj2 = this.drObj;
        if (drObj2 != null && drObj2.targetLayerId != null) {
            request();
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998495374")) {
            ipChange.ipc$dispatch("-998495374", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593363710")) {
            ipChange.ipc$dispatch("593363710", new Object[]{this});
            return;
        }
        super.onPause();
        c.e().q(getActivity());
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229792199")) {
            ipChange.ipc$dispatch("-1229792199", new Object[]{this});
            return;
        }
        this.pageIndex = 1;
        this.drObj = null;
        removeBottomBarView();
        request();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432774967")) {
            ipChange.ipc$dispatch("-1432774967", new Object[]{this});
            return;
        }
        super.onResume();
        c.e().o(this, this.mUTBuilder);
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691421165")) {
            ipChange.ipc$dispatch("-691421165", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        enableDividerLine(false);
        if (getArguments() == null || TextUtils.isEmpty(getArguments().getString("id"))) {
            showErrorView();
            return;
        }
        this.ipId = getArguments().getString("id");
        addPreDealListener(wj2.DM_COMMON_LOOP_BANNER_CID, new a(this));
        request();
        this.topBarH = s50.a(getActivity(), 100.0f);
        this.mRecyclerView.scrollToPosition(0);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.user.ipdrama.IpDramaFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-379273633")) {
                    ipChange.ipc$dispatch("-379273633", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                Log.d("dyxxii", "firstVisibleItemPosition: " + findFirstCompletelyVisibleItemPosition);
                if (findFirstCompletelyVisibleItemPosition == 0) {
                    IpDramaFragment.this.onAlphaChangeListener.onAlphaChaged(0.0f);
                } else if (findFirstCompletelyVisibleItemPosition > 2) {
                    IpDramaFragment.this.onAlphaChangeListener.onAlphaChaged(1.0f);
                }
            }
        });
    }

    public void request() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881795270")) {
            ipChange.ipc$dispatch("881795270", new Object[]{this});
            return;
        }
        IpDramaRequest ipDramaRequest = new IpDramaRequest();
        ipDramaRequest.pageNo = this.pageIndex + "";
        ipDramaRequest.ipId = this.ipId;
        ipDramaRequest.funcVersion = "1.2";
        ipDramaRequest.comboDamaiCityId = d20.c();
        TetrisRequest tetrisRequest = new TetrisRequest(ipDramaRequest);
        DrObj drObj2 = this.drObj;
        if (drObj2 != null) {
            drObj2.targetArgs = tetrisRequest.args;
            tetrisRequest.dr = jl1.ARRAY_START_STR + JSON.toJSONString(this.drObj) + jl1.ARRAY_END_STR;
        }
        AnonymousClass3 r0 = new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.user.ipdrama.IpDramaFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-231032543")) {
                    ipChange.ipc$dispatch("-231032543", new Object[]{this, str, str2});
                    return;
                }
                IpDramaFragment.this.stopProgressDialog();
                IpDramaFragment.this.refreshFinish();
                IpDramaFragment.this.onResponseError(str, str2, "");
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                BaseLayer baseLayer;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1679287811")) {
                    ipChange.ipc$dispatch("-1679287811", new Object[]{this, baseResponse});
                    return;
                }
                IpDramaFragment.this.stopProgressDialog();
                IpDramaFragment.this.refreshFinish();
                HashMap hashMap = new HashMap();
                hashMap.put("repertoire_id", IpDramaFragment.this.ipId);
                baseResponse.globalConfig.putBuzUTMap(hashMap);
                if (baseResponse.globalConfig != null) {
                    IpDramaFragment.this.mUTBuilder = new a.b().i(baseResponse.globalConfig.pageName);
                }
                IpDramaFragment.this.updateB(baseResponse);
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (arrayList == null || arrayList.size() == 0) {
                    IpDramaFragment.this.onResponseError("", "", "");
                    return;
                }
                IpDramaFragment.this.onResponseSuccess();
                IpDramaFragment ipDramaFragment = IpDramaFragment.this;
                ipDramaFragment.drObj = ipDramaFragment.getTetrisDr(baseResponse, wj2.DISCOVER_FEED_COMPONENT_ID);
                IpDramaFragment ipDramaFragment2 = IpDramaFragment.this;
                int i = ipDramaFragment2.pageIndex;
                if (i == 1) {
                    ShareBean obtainIpDramaShareBean = ShareBean.obtainIpDramaShareBean(baseResponse);
                    FragmentActivity activity = IpDramaFragment.this.getActivity();
                    IpDramaActivity ipDramaActivity = null;
                    if (activity instanceof IpDramaActivity) {
                        ipDramaActivity = (IpDramaActivity) activity;
                    }
                    if (ipDramaActivity != null) {
                        ipDramaActivity.setShareBean(obtainIpDramaShareBean);
                    }
                    ArrayList<BaseLayer> arrayList2 = baseResponse.layers;
                    if (arrayList2 != null && arrayList2.size() > 0 && (baseLayer = baseResponse.layers.get(0)) != null && baseLayer.getSections() != null && baseLayer.getSections().size() > 0) {
                        if (baseLayer.getSections().get(0) != null && !"dm_banner_videoheader_ip".equals(baseLayer.getSections().get(0).getComponentId())) {
                            BaseSection baseSection = new BaseSection();
                            baseSection.setComponentId("dm_banner_videoheader_ip");
                            baseSection.setSectionId("dm_banner_videoheader_ip");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("holder", (Object) "holder");
                            baseSection.setItem(jSONObject);
                            baseLayer.getSections().add(0, baseSection);
                        }
                        Iterator<BaseSection> it = baseLayer.getSections().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BaseSection next = it.next();
                            if (next != null && "dm_card_ip_info".equals(next.getComponentId()) && next.getItem() != null) {
                                String string = next.getItem().getString("ipName");
                                if (ipDramaActivity != null) {
                                    ipDramaActivity.setTitle(string);
                                }
                            }
                        }
                    }
                    IpDramaFragment.this.setData(baseResponse);
                    ((AbsFragment) IpDramaFragment.this).mRecyclerView.postDelayed(new Runnable() {
                        /* class cn.damai.user.ipdrama.IpDramaFragment.AnonymousClass3.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1663360146")) {
                                ipChange.ipc$dispatch("-1663360146", new Object[]{this});
                                return;
                            }
                            IpDramaFragment.this.sendMsg(new Message(2000, ((AbsFragment) IpDramaFragment.this).mRecyclerView));
                        }
                    }, 1000);
                } else {
                    ipDramaFragment2.addData(baseResponse, wj2.DISCOVER_FEED_COMPONENT_ID, i);
                }
                IpDramaFragment.this.pageIndex++;
            }
        };
        startProgressDialog();
        tetrisRequest.request(r0);
    }

    public void setOnAlphaChangeListener(OnAlphaChangeListener onAlphaChangeListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573464086")) {
            ipChange.ipc$dispatch("573464086", new Object[]{this, onAlphaChangeListener2});
            return;
        }
        this.onAlphaChangeListener = onAlphaChangeListener2;
    }
}

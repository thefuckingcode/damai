package cn.damai.tetris.page;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.adapter.AbsAdapter;
import cn.damai.tetris.core.adapter.VerticalAdapter;
import cn.damai.tetris.core.holder.BaseViewHolder;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.listener.IsRefreshListener;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.LoadMoreView;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.aj0;
import tb.cs0;
import tb.es0;
import tb.kv2;
import tb.py2;
import tb.qa;
import tb.qv1;
import tb.rv1;
import tb.s41;
import tb.w9;
import tb.wj2;
import tb.xj2;
import tb.xs0;

/* compiled from: Taobao */
public abstract class AbsFragmentV3 extends AbsFragment implements ComponentPageUi {
    private static transient /* synthetic */ IpChange $ipChange;
    private DelegateAdapter mAdapter;
    protected Handler mHandler = new b();
    public HomeTopBgListener mHomeTopBgListener;
    protected boolean mIsRefreshDown;
    public IsRefreshListener mIsRefreshListener;
    protected WrappedVirtualLayoutManager mLayoutManager;
    protected LoadMoreView mLoadMoreView;
    protected cn.damai.tetris.v2.componentplugin.a mManager;
    protected IContainer mPageContainer;
    protected PtrFrameLayout mRefreshLayout;
    protected int mScrollY;
    private HashMap<String, SectionDataPreDealListener> preDealListenerHashMap = new HashMap<>();

    /* compiled from: Taobao */
    public interface SectionDataPreDealListener {
        void doSectionData(BaseSection baseSection);
    }

    /* compiled from: Taobao */
    public class a extends qv1 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.qv1, in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1830224422")) {
                return ((Boolean) ipChange.ipc$dispatch("1830224422", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
            }
            RecyclerView.LayoutManager layoutManager = AbsFragmentV3.this.mRecyclerView.getLayoutManager();
            if (!(layoutManager instanceof WrappedVirtualLayoutManager)) {
                return false;
            }
            int findFirstVisibleItemPosition = ((WrappedVirtualLayoutManager) layoutManager).findFirstVisibleItemPosition();
            View childAt = AbsFragmentV3.this.mRecyclerView.getChildAt(0);
            View childAt2 = AbsFragmentV3.this.mRecyclerView.getChildAt(1);
            if (!(childAt2 == null || childAt == null || childAt2.getTop() >= childAt.getTop())) {
                childAt = childAt2;
            }
            if (findFirstVisibleItemPosition != -1 && (childAt == null || childAt.getTop() < AbsFragmentV3.this.mRecyclerView.getPaddingTop())) {
                z = false;
            }
            return z;
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2104666581")) {
                ipChange.ipc$dispatch("-2104666581", new Object[]{this, ptrFrameLayout});
                return;
            }
            IsRefreshListener isRefreshListener = AbsFragmentV3.this.mIsRefreshListener;
            if (isRefreshListener != null) {
                isRefreshListener.isRrefresh(true);
            }
            DamaiRootRecyclerView damaiRootRecyclerView = AbsFragmentV3.this.mRecyclerView;
            if (damaiRootRecyclerView != null) {
                damaiRootRecyclerView.scrollToPosition(0);
            }
            AbsFragmentV3.this.onRefresh();
        }
    }

    /* compiled from: Taobao */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void handleMessage(Message message) {
            IsRefreshListener isRefreshListener;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "205241856")) {
                ipChange.ipc$dispatch("205241856", new Object[]{this, message});
            } else if (message.what == 1 && AbsFragmentV3.this.isVisible() && (isRefreshListener = AbsFragmentV3.this.mIsRefreshListener) != null) {
                isRefreshListener.isRrefresh(false);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements IImageLoader {
        private static transient /* synthetic */ IpChange $ipChange;

        c(AbsFragmentV3 absFragmentV3) {
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket load(String str, int i, int i2, int i3, int i4, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-45230660")) {
                return null;
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-45230660", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iImageSuccListener, iImageFailListener});
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public void load(String str, int i, int i2, int i3, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1621829748")) {
                ipChange.ipc$dispatch("-1621829748", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iImageSuccListener, iImageFailListener});
                return;
            }
            cn.damai.common.image.a.b().load(str, i, i2, i3, iImageSuccListener, iImageFailListener);
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket loadinto(String str, ImageView imageView) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-963021846")) {
                return cn.damai.common.image.a.b().loadinto(str, imageView);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-963021846", new Object[]{this, str, imageView});
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public void load(String str, int i, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "775767852")) {
                ipChange.ipc$dispatch("775767852", new Object[]{this, str, Integer.valueOf(i), iImageSuccListener, iImageFailListener});
                return;
            }
            cn.damai.common.image.a.b().load(str, i, iImageSuccListener, iImageFailListener);
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1930449162")) {
                return cn.damai.common.image.a.b().loadinto(str, imageView, i, i2);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("1930449162", new Object[]{this, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket load(String str, int i, int i2, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1547350556")) {
                return cn.damai.common.image.a.b().load(str, i, i2, iImageSuccListener, iImageFailListener);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("1547350556", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), iImageSuccListener, iImageFailListener});
        }
    }

    /* compiled from: Taobao */
    public class d implements TrackProxy.ITrack {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.tetris.core.ut.TrackProxy.ITrack
        public void userTrack(TrackType trackType, View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-296814542")) {
                ipChange.ipc$dispatch("-296814542", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
                return;
            }
            switch (e.a[trackType.ordinal()]) {
                case 1:
                    cn.damai.common.user.c.e().x(AbsFragmentV3.this.getUTKeyBuilder(str, str2, str3, map, Boolean.valueOf(z)));
                    return;
                case 2:
                    cn.damai.common.user.c.e().x(AbsFragmentV3.this.getUTKeyBuilder(str, str2, str3, map, Boolean.valueOf(z)));
                    return;
                case 3:
                    cn.damai.common.user.c.e().G(view, str3, str2, str, map);
                    return;
                case 4:
                    String str4 = map.get("arg1");
                    String str5 = map.get("arg2");
                    if (map.get("eventId") != null) {
                        i = Integer.parseInt(map.get("eventId"));
                    }
                    cn.damai.common.user.c.e().D(str, str2, str4, str5, map, i);
                    return;
                case 5:
                    cn.damai.common.user.c.e().A(map, str2, str);
                    return;
                case 6:
                    try {
                        py2.c(str2, str3, str2, str3, s41.e(map));
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TrackType.values().length];
            a = iArr;
            iArr[TrackType.page.ordinal()] = 1;
            a[TrackType.click.ordinal()] = 2;
            a[TrackType.expose.ordinal()] = 3;
            a[TrackType.custom.ordinal()] = 4;
            a[TrackType.custom_1999.ordinal()] = 5;
            try {
                a[TrackType.warning.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void addBottomBarView(ArrayList<BaseLayer> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590876455")) {
            ipChange.ipc$dispatch("590876455", new Object[]{this, arrayList});
            return;
        }
        VerticalAdapter verticalAdapter = new VerticalAdapter(this.baseContext, new kv2());
        verticalAdapter.b(arrayList);
        w9 w9Var = this.baseContext;
        if (!(w9Var == null || w9Var.getActivity() == null)) {
            for (int i = 0; i < verticalAdapter.getItemCount(); i++) {
                BaseViewHolder f = verticalAdapter.onCreateViewHolder(this.bottomBarParent, verticalAdapter.getItemViewType(i));
                verticalAdapter.onBindViewHolder(f, i);
                this.bottomBarParent.addView(f.itemView);
            }
        }
    }

    private void initRefreshLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350264806")) {
            ipChange.ipc$dispatch("1350264806", new Object[]{this});
            return;
        }
        PtrUiHeader ptrUiHeader = new PtrUiHeader(getActivity());
        this.mRefreshLayout.setHeaderView(ptrUiHeader);
        this.mRefreshLayout.addPtrUIHandler(ptrUiHeader);
        this.mRefreshLayout.setPtrIndicator(new aj0(100, getActivity()));
        this.mRefreshLayout.setResistance(1.7f);
        this.mRefreshLayout.setPtrHandler(new a());
        this.mRefreshLayout.disableWhenHorizontalMove(true);
        this.mRefreshLayout.addPtrUIHandler(new PtrClassicDefaultHeader(xs0.a()) {
            /* class cn.damai.tetris.page.AbsFragmentV3.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // in.srain.cube.views.ptr.PtrClassicDefaultHeader, in.srain.cube.views.ptr.PtrUIHandler
            public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rv1 rv1) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1317046009")) {
                    ipChange.ipc$dispatch("1317046009", new Object[]{this, ptrFrameLayout, Boolean.valueOf(z), Byte.valueOf(b), rv1});
                    return;
                }
                super.onUIPositionChange(ptrFrameLayout, z, b, rv1);
                int d = rv1.d();
                if (d > 0) {
                    AbsFragmentV3 absFragmentV3 = AbsFragmentV3.this;
                    absFragmentV3.mScrollY = 0;
                    absFragmentV3.mIsRefreshDown = true;
                } else {
                    AbsFragmentV3.this.mIsRefreshDown = false;
                }
                HomeTopBgListener homeTopBgListener = AbsFragmentV3.this.mHomeTopBgListener;
                if (homeTopBgListener != null) {
                    homeTopBgListener.scrollY(-d);
                }
                AbsFragmentV3 absFragmentV32 = AbsFragmentV3.this;
                IsRefreshListener isRefreshListener = absFragmentV32.mIsRefreshListener;
                if (isRefreshListener != null) {
                    isRefreshListener.isRrefresh(absFragmentV32.mIsRefreshDown);
                }
            }

            @Override // in.srain.cube.views.ptr.PtrClassicDefaultHeader, in.srain.cube.views.ptr.PtrUIHandler
            public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-948954072")) {
                    ipChange.ipc$dispatch("-948954072", new Object[]{this, ptrFrameLayout});
                    return;
                }
                AbsFragmentV3 absFragmentV3 = AbsFragmentV3.this;
                absFragmentV3.mScrollY = 0;
                absFragmentV3.mIsRefreshDown = false;
                super.onUIRefreshComplete(ptrFrameLayout);
                Handler handler = AbsFragmentV3.this.mHandler;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1, 2000);
                }
            }
        });
    }

    private void initTetrisProxy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-294170250")) {
            ipChange.ipc$dispatch("-294170250", new Object[]{this});
            return;
        }
        xj2.b(new c(this), new d());
    }

    public void addData(BaseResponse baseResponse, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1639797570")) {
            ipChange.ipc$dispatch("-1639797570", new Object[]{this, baseResponse, str, Integer.valueOf(i)});
            return;
        }
        List<IModule> moduleList = this.mPageContainer.getModuleList();
        if (moduleList != null) {
            for (IModule iModule : moduleList) {
                List<ILayer> layerList = iModule.getLayerList();
                if (layerList != null) {
                    for (ILayer iLayer : layerList) {
                        if (iLayer instanceof es0) {
                            es0 es0 = (es0) iLayer;
                            if (str.equals(es0.c())) {
                                es0.createSectionList(new qa().g(baseResponse, i), false);
                                this.mPageContainer.updateContentAdapter();
                            }
                        }
                    }
                }
            }
        }
    }

    public void addPreDealListener(String str, SectionDataPreDealListener sectionDataPreDealListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796622924")) {
            ipChange.ipc$dispatch("796622924", new Object[]{this, str, sectionDataPreDealListener});
            return;
        }
        this.preDealListenerHashMap.put(str, sectionDataPreDealListener);
    }

    public void addSectionList(List<Node> list, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583926494")) {
            ipChange.ipc$dispatch("583926494", new Object[]{this, list, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.mPageContainer.addSectionList(list, z, z2);
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public AbsAdapter getAdapter(w9 w9Var) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-828920837")) {
            return null;
        }
        return (AbsAdapter) ipChange.ipc$dispatch("-828920837", new Object[]{this, w9Var});
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public IContainer getPageContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-697599894")) {
            return this.mPageContainer;
        }
        return (IContainer) ipChange.ipc$dispatch("-697599894", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public RecyclerView getRecycler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "941901837")) {
            return this.mRecyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("941901837", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public View getRootView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1885056320")) {
            return getView();
        }
        return (View) ipChange.ipc$dispatch("-1885056320", new Object[]{this});
    }

    public DrObj getTetrisDr(BaseResponse baseResponse, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684979894")) {
            return (DrObj) ipChange.ipc$dispatch("1684979894", new Object[]{this, baseResponse, str});
        }
        DrObj drObj = new DrObj();
        if (baseResponse != null) {
            for (BaseLayer baseLayer : baseResponse.layers) {
                List<BaseSection> sections = baseLayer.getSections();
                if (sections != null) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection != null && str.equals(baseSection.getComponentId())) {
                            drObj.targetLayerId = baseLayer.getLayerId();
                            drObj.targetSectionId = baseSection.getSectionId();
                        }
                    }
                }
            }
        }
        return drObj;
    }

    public a.b getUTKeyBuilder(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1860135687")) {
            return new a.b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
        }
        return (a.b) ipChange.ipc$dispatch("1860135687", new Object[]{this, str, str2, str3, map, bool});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.page.AbsFragment
    public void hookOnLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "158507168")) {
            ipChange.ipc$dispatch("158507168", new Object[]{this, view});
            return;
        }
        super.hookOnLoadMore(view);
        cn.damai.tetris.v2.componentplugin.a aVar = this.mManager;
        if (aVar != null) {
            aVar.b(view);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.page.AbsFragment
    public void hookOnMessage(cn.damai.tetris.core.msg.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458576161")) {
            ipChange.ipc$dispatch("1458576161", new Object[]{this, message});
            return;
        }
        super.hookOnMessage(message);
        cn.damai.tetris.v2.componentplugin.a aVar = this.mManager;
        if (aVar != null) {
            aVar.c(message.what, message.value);
        }
    }

    public void initRecyclerViewSetting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075254719")) {
            ipChange.ipc$dispatch("1075254719", new Object[]{this});
            return;
        }
        this.mRecyclerView.setRefreshEnabled(false);
        LoadMoreView loadMoreView = new LoadMoreView(getActivity());
        this.mLoadMoreView = loadMoreView;
        this.mRecyclerView.setLoadMoreFooterView(loadMoreView);
        WrappedVirtualLayoutManager wrappedVirtualLayoutManager = new WrappedVirtualLayoutManager(getContext());
        this.mLayoutManager = wrappedVirtualLayoutManager;
        this.mRecyclerView.setLayoutManager(wrappedVirtualLayoutManager);
        WrappedDelegateAdapter wrappedDelegateAdapter = new WrappedDelegateAdapter(this.mLayoutManager, true);
        this.mAdapter = wrappedDelegateAdapter;
        this.mRecyclerView.setAdapter(wrappedDelegateAdapter);
        this.mPageContainer.setContentAdapter(this.mAdapter);
        showLoadInit(null);
    }

    public ArrayList<BaseLayer> iteratorSections(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413662328")) {
            return (ArrayList) ipChange.ipc$dispatch("1413662328", new Object[]{this, baseResponse});
        }
        ArrayList<BaseLayer> arrayList = new ArrayList<>();
        BaseLayer baseLayer = new BaseLayer();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<BaseLayer> arrayList3 = baseResponse.layers;
        if (arrayList3 != null && arrayList3.size() > 0) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                if (next.getSections() != null && next.getSections().size() > 0) {
                    Iterator<BaseSection> it2 = next.getSections().iterator();
                    while (it2.hasNext()) {
                        BaseSection next2 = it2.next();
                        if (next2 != null) {
                            if (this.preDealListenerHashMap.get(next2.getComponentId()) != null) {
                                this.preDealListenerHashMap.get(next2.getComponentId()).doSectionData(next2);
                            }
                            if (next2.getStyle() != null && "1".equals(next2.getStyle().getString("type"))) {
                                if (next2.getTrackInfo() == null) {
                                    next2.setTrackInfo(new TrackInfo());
                                }
                                GlobalConfig globalConfig = baseResponse.globalConfig;
                                if (globalConfig != null && !TextUtils.isEmpty(globalConfig.pageName)) {
                                    next2.getTrackInfo().trackB = baseResponse.globalConfig.pageName;
                                }
                                GlobalConfig globalConfig2 = baseResponse.globalConfig;
                                if (!(globalConfig2 == null || globalConfig2.getBuzUTMap() == null)) {
                                    next2.getTrackInfo().getInnerMap().putAll(baseResponse.globalConfig.getBuzUTMap());
                                }
                                if (!TextUtils.isEmpty(next2.getTrackInfo().getString("spmc"))) {
                                    next2.getTrackInfo().trackC = next2.getTrackInfo().getString("spmc");
                                }
                                arrayList2.add(next2);
                                it2.remove();
                                if (next.getSections().size() == 0) {
                                    it.remove();
                                }
                            }
                        }
                    }
                }
            }
        }
        baseLayer.setSections(arrayList2);
        arrayList.add(baseLayer);
        return arrayList;
    }

    public void loadMore4Sections(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333660479")) {
            ipChange.ipc$dispatch("333660479", new Object[]{this, baseResponse});
            return;
        }
        this.mPageContainer.addSectionList(new qa().f(baseResponse), true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943422117")) {
            ipChange.ipc$dispatch("-1943422117", new Object[]{this});
            return;
        }
        super.onDestroyView();
        IsRefreshListener isRefreshListener = this.mIsRefreshListener;
        if (isRefreshListener != null) {
            isRefreshListener.isRrefresh(false);
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576563815")) {
            ipChange.ipc$dispatch("-1576563815", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) view.findViewById(R$id.refreshLayout);
        this.mRefreshLayout = ptrFrameLayout;
        ptrFrameLayout.setDescendantFocusability(393216);
        cn.damai.tetris.v2.componentplugin.a aVar = new cn.damai.tetris.v2.componentplugin.a(this);
        this.mManager = aVar;
        cs0 cs0 = new cs0(this.baseContext, aVar);
        this.mPageContainer = cs0;
        this.baseContext.b(cs0);
        if (!new qa().i(wj2.DM_COMMON_LOOP_BANNER_CID)) {
            initTetrisProxy();
        }
        initRefreshLayout();
        initRecyclerViewSetting();
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void refreshFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377172397")) {
            ipChange.ipc$dispatch("1377172397", new Object[]{this});
            return;
        }
        super.refreshFinish();
        PtrFrameLayout ptrFrameLayout = this.mRefreshLayout;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.refreshComplete();
        }
    }

    public void removeBottomBarView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1204126190")) {
            ipChange.ipc$dispatch("-1204126190", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = this.bottomBarParent;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void setData(BaseResponse baseResponse) {
        GlobalConfig globalConfig;
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443823622")) {
            ipChange.ipc$dispatch("-1443823622", new Object[]{this, baseResponse});
            return;
        }
        ArrayList<BaseLayer> iteratorSections = iteratorSections(baseResponse);
        if (iteratorSections.size() > 0 && (linearLayout = this.bottomBarParent) != null) {
            linearLayout.removeAllViews();
            addBottomBarView(iteratorSections);
        }
        setData(new qa().e(baseResponse));
        if (baseResponse != null && (globalConfig = baseResponse.globalConfig) != null) {
            updateAB(globalConfig);
        }
    }

    /* access modifiers changed from: protected */
    public void showLoadEnd(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520263917")) {
            ipChange.ipc$dispatch("1520263917", new Object[]{this, str});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreView.Status.THE_END, str);
    }

    /* access modifiers changed from: protected */
    public void showLoadError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061136288")) {
            ipChange.ipc$dispatch("2061136288", new Object[]{this, str});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreView.Status.ERROR, str);
    }

    /* access modifiers changed from: protected */
    public void showLoadInit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821499686")) {
            ipChange.ipc$dispatch("1821499686", new Object[]{this, str});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreView.Status.INIT, str);
    }

    /* access modifiers changed from: protected */
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583786534")) {
            ipChange.ipc$dispatch("1583786534", new Object[]{this, str});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreView.Status.LOADING, str);
    }

    public void setData(Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397122256")) {
            ipChange.ipc$dispatch("397122256", new Object[]{this, node});
            return;
        }
        this.mPageContainer.init(node);
    }

    public void addData(BaseResponse baseResponse, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576918299")) {
            ipChange.ipc$dispatch("-1576918299", new Object[]{this, baseResponse, str});
            return;
        }
        addData(baseResponse, str, 0);
    }
}

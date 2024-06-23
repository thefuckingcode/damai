package cn.damai.tetris.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.adapter.AbsAdapter;
import cn.damai.tetris.core.adapter.VerticalAdapter;
import cn.damai.tetris.core.holder.BaseViewHolder;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import cn.damai.tetris.v2.structure.section.ISection;
import cn.damai.uikit.image.IImageLoader;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.cs0;
import tb.es0;
import tb.f92;
import tb.kv2;
import tb.py2;
import tb.qa;
import tb.s41;
import tb.w9;
import tb.wj2;
import tb.xj2;

/* compiled from: Taobao */
public abstract class AbsFragmentV2 extends AbsFragment implements ComponentPageUi {
    private static transient /* synthetic */ IpChange $ipChange;
    private DelegateAdapter mAdapter;
    protected cn.damai.tetris.v2.componentplugin.a mManager;
    private IContainer mPageContainer;
    private HashMap<String, SectionDataPreDealListener> preDealListenerHashMap = new HashMap<>();
    private String requestArgs;

    /* compiled from: Taobao */
    public interface SectionDataPreDealListener {
        void doSectionData(BaseSection baseSection);
    }

    /* compiled from: Taobao */
    public class a implements IImageLoader {
        private static transient /* synthetic */ IpChange $ipChange;

        a(AbsFragmentV2 absFragmentV2) {
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public void load(String str, int i, int i2, int i3, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1967530544")) {
                ipChange.ipc$dispatch("-1967530544", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iImageSuccListener, iImageFailListener});
                return;
            }
            cn.damai.common.image.a.b().load(str, i, i2, i3, iImageSuccListener, iImageFailListener);
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket loadinto(String str, ImageView imageView) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2077729830")) {
                return cn.damai.common.image.a.b().loadinto(str, imageView);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("2077729830", new Object[]{this, str, imageView});
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public void load(String str, int i, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-520679824")) {
                ipChange.ipc$dispatch("-520679824", new Object[]{this, str, Integer.valueOf(i), iImageSuccListener, iImageFailListener});
                return;
            }
            cn.damai.common.image.a.b().load(str, i, iImageSuccListener, iImageFailListener);
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-779918778")) {
                return cn.damai.common.image.a.b().loadinto(str, imageView, i, i2);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-779918778", new Object[]{this, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket load(String str, int i, int i2, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1107888728")) {
                return cn.damai.common.image.a.b().load(str, i, i2, iImageSuccListener, iImageFailListener);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("1107888728", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), iImageSuccListener, iImageFailListener});
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket load(String str, int i, int i2, int i3, int i4, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1461252360")) {
                return cn.damai.common.image.a.b().load(str, i, i2, i3, i4, iImageSuccListener, iImageFailListener);
            }
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-1461252360", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iImageSuccListener, iImageFailListener});
        }
    }

    /* compiled from: Taobao */
    public class b implements TrackProxy.ITrack {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.tetris.core.ut.TrackProxy.ITrack
        public void userTrack(TrackType trackType, View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-642515338")) {
                ipChange.ipc$dispatch("-642515338", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
                return;
            }
            switch (c.a[trackType.ordinal()]) {
                case 1:
                    cn.damai.common.user.c.e().x(AbsFragmentV2.this.getUTKeyBuilder(str, str2, str3, map, Boolean.valueOf(z)));
                    return;
                case 2:
                    cn.damai.common.user.c.e().x(AbsFragmentV2.this.getUTKeyBuilder(str, str2, str3, map, Boolean.valueOf(z)));
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
    static /* synthetic */ class c {
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
        if (AndroidInstantRuntime.support(ipChange, "1615570376")) {
            ipChange.ipc$dispatch("1615570376", new Object[]{this, arrayList});
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

    private void initTetrisProxy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743886039")) {
            ipChange.ipc$dispatch("1743886039", new Object[]{this});
            return;
        }
        xj2.b(new a(this), new b());
    }

    private boolean totalSectionMoreThan1(List<Node> list) {
        List<Node> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424602295")) {
            return ((Boolean) ipChange.ipc$dispatch("1424602295", new Object[]{this, list})).booleanValue();
        }
        if (list == null) {
            return false;
        }
        if (list.size() > 1) {
            return true;
        }
        int i = 0;
        for (Node node : list) {
            if (!(node == null || (list2 = node.children) == null || (i = i + list2.size()) <= 1)) {
                return true;
            }
        }
        return false;
    }

    public void addData(BaseResponse baseResponse, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684276291")) {
            ipChange.ipc$dispatch("-684276291", new Object[]{this, baseResponse, str, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1390019860")) {
            ipChange.ipc$dispatch("-1390019860", new Object[]{this, str, sectionDataPreDealListener});
            return;
        }
        this.preDealListenerHashMap.put(str, sectionDataPreDealListener);
    }

    public void addSectionList(List<Node> list, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506610077")) {
            ipChange.ipc$dispatch("1506610077", new Object[]{this, list, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.mPageContainer.addSectionList(list, z, z2);
    }

    public void appendData(BaseResponse baseResponse, String str, int i, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637230836")) {
            ipChange.ipc$dispatch("-637230836", new Object[]{this, baseResponse, str, Integer.valueOf(i), jSONObject});
            return;
        }
        List<IModule> moduleList = this.mPageContainer.getModuleList();
        if (moduleList != null) {
            for (IModule iModule : moduleList) {
                List<ILayer> layerList = iModule.getLayerList();
                if (layerList != null) {
                    for (ILayer iLayer : layerList) {
                        if (iLayer instanceof es0) {
                            for (ISection iSection : ((es0) iLayer).getSectionList()) {
                                if (TextUtils.equals(iSection.getComponentId(), str)) {
                                    iSection.addItem(jSONObject);
                                }
                            }
                            this.mPageContainer.updateContentAdapter();
                        }
                    }
                }
            }
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public AbsAdapter getAdapter(w9 w9Var) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "141370170")) {
            return null;
        }
        return (AbsAdapter) ipChange.ipc$dispatch("141370170", new Object[]{this, w9Var});
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public IContainer getPageContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "257921385")) {
            return this.mPageContainer;
        }
        return (IContainer) ipChange.ipc$dispatch("257921385", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public RecyclerView getRecycler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "840989870")) {
            return this.mRecyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("840989870", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public View getRootView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "459610721")) {
            return getView();
        }
        return (View) ipChange.ipc$dispatch("459610721", new Object[]{this});
    }

    public DrObj getTetrisDr(BaseResponse baseResponse, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150862953")) {
            return (DrObj) ipChange.ipc$dispatch("-150862953", new Object[]{this, baseResponse, str});
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
        if (!AndroidInstantRuntime.support(ipChange, "174235752")) {
            return new a.b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
        }
        return (a.b) ipChange.ipc$dispatch("174235752", new Object[]{this, str, str2, str3, map, bool});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.page.AbsFragment
    public void hookOnLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303072831")) {
            ipChange.ipc$dispatch("-1303072831", new Object[]{this, view});
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
    public void hookOnMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020566658")) {
            ipChange.ipc$dispatch("1020566658", new Object[]{this, message});
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
        if (AndroidInstantRuntime.support(ipChange, "1063938592")) {
            ipChange.ipc$dispatch("1063938592", new Object[]{this});
            return;
        }
        WrappedVirtualLayoutManager wrappedVirtualLayoutManager = new WrappedVirtualLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(wrappedVirtualLayoutManager);
        WrappedDelegateAdapter wrappedDelegateAdapter = new WrappedDelegateAdapter(wrappedVirtualLayoutManager, true);
        this.mAdapter = wrappedDelegateAdapter;
        this.mRecyclerView.setAdapter(wrappedDelegateAdapter);
        this.mPageContainer.setContentAdapter(this.mAdapter);
    }

    public ArrayList<BaseLayer> iteratorSections(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396249417")) {
            return (ArrayList) ipChange.ipc$dispatch("-1396249417", new Object[]{this, baseResponse});
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
        baseLayer.setSections(arrayList2);
        arrayList.add(baseLayer);
        return arrayList;
    }

    public void loadMore4Sections(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786626720")) {
            ipChange.ipc$dispatch("-1786626720", new Object[]{this, baseResponse});
            return;
        }
        this.mPageContainer.addSectionList(new qa().f(baseResponse), true, false);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354055290")) {
            ipChange.ipc$dispatch("354055290", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        cn.damai.tetris.v2.componentplugin.a aVar = new cn.damai.tetris.v2.componentplugin.a(this);
        this.mManager = aVar;
        cs0 cs0 = new cs0(this.baseContext, aVar);
        this.mPageContainer = cs0;
        this.baseContext.b(cs0);
        if (!new qa().i(wj2.DM_COMMON_LOOP_BANNER_CID)) {
            initTetrisProxy();
        }
        initRecyclerViewSetting();
    }

    public void removeBottomBarView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235145997")) {
            ipChange.ipc$dispatch("-1235145997", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = this.bottomBarParent;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void setData(BaseResponse baseResponse) {
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881833125")) {
            ipChange.ipc$dispatch("-1881833125", new Object[]{this, baseResponse});
            return;
        }
        ArrayList<BaseLayer> iteratorSections = iteratorSections(baseResponse);
        if (iteratorSections.size() > 0 && (linearLayout = this.bottomBarParent) != null) {
            linearLayout.removeAllViews();
            addBottomBarView(iteratorSections);
        }
        this.requestArgs = baseResponse.args;
        setData(new qa().e(baseResponse));
        GlobalConfig globalConfig = baseResponse.globalConfig;
        if (globalConfig != null) {
            updateAB(globalConfig);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5248206")) {
            ipChange.ipc$dispatch("-5248206", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (this.properties != null) {
            cn.damai.common.user.c.e().O(getActivity(), this.properties);
            Log.e("abtest", "v2 setUserVisibleHint updatePageProperties : " + this.properties.size());
        }
    }

    public void setData(Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580469553")) {
            ipChange.ipc$dispatch("1580469553", new Object[]{this, node});
            return;
        }
        this.mPageContainer.init(node);
        if (node == null || f92.d(node.children) || node.children.get(0) == null || f92.d(node.children.get(0).children)) {
            py2.d(py2.TETRIS_CORE_ERROR_NOSECTION_CODE, py2.TETRIS_CORE_ERROR_NOSECTION_MSG, "NODATA_NOSECTION", "数据转换解析后组件为空", this.requestArgs);
        } else if (!totalSectionMoreThan1(node.children.get(0).children)) {
            py2.c(py2.TETRIS_CORE_ERROR_DATA_LESSTHAN_2_CODE, py2.TETRIS_CORE_ERROR_DATA_LESSTHAN_2_MSG, "DATA_LESSTHAN_1", "组件个数小于等于1", this.requestArgs);
        }
    }

    public void addData(BaseResponse baseResponse, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532114950")) {
            ipChange.ipc$dispatch("532114950", new Object[]{this, baseResponse, str});
            return;
        }
        addData(baseResponse, str, 0);
    }
}

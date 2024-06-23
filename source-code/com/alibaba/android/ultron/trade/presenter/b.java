package com.alibaba.android.ultron.trade.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.R$drawable;
import com.alibaba.android.ultron.trade.event.model.OpenPopupWindowEventModel;
import com.alibaba.android.ultron.trade.monitor.IMonitor;
import com.alibaba.android.ultron.vfw.adapter.RecyclerViewAdapter;
import com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.imp.c;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.am2;
import tb.hn2;
import tb.jk2;
import tb.jn2;
import tb.kn2;
import tb.l20;
import tb.lo2;
import tb.pf1;
import tb.qb2;
import tb.tr2;
import tb.v0;
import tb.wv2;

/* compiled from: Taobao */
public class b {
    private static final String KEY_EXPOSURE_ITEM = "exposureItem";
    private static final String TAG = "BaseViewManager";
    private String mBizName = "";
    protected Activity mContext;
    private ViewGroup mFooterView;
    private ViewGroup mHeaderView;
    protected PopupWindowManager mPopupWindowManager;
    protected Pair<IDMComponent, IDMEvent> mPopupWindowTrigger;
    protected IPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private String mStickyTagInHeader = "";
    private String mTriggerTagForHeader = "";
    protected wv2 mViewEngine;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ComponentLifecycleCallback {
        a() {
        }

        @Override // com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback
        public void onBindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent, Map<String, Object> map) {
            Map<String, List<IDMEvent>> eventMap;
            List<IDMEvent> list;
            if (!(iDMComponent == null || (eventMap = iDMComponent.getEventMap()) == null || (list = eventMap.get(b.KEY_EXPOSURE_ITEM)) == null)) {
                kn2 tradeEventHandler = b.this.mPresenter.getTradeEventHandler();
                for (int i = 0; i < list.size(); i++) {
                    IDMEvent iDMEvent = list.get(i);
                    if (iDMEvent != null) {
                        String type = iDMEvent.getType();
                        if (!TextUtils.isEmpty(type)) {
                            jn2 l = tradeEventHandler.d().l(type);
                            l.i(iDMComponent);
                            l.p(b.KEY_EXPOSURE_ITEM);
                            l.k(iDMEvent);
                            tradeEventHandler.h(l);
                        }
                    }
                }
            }
        }

        @Override // com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback
        public void onCreateViewHolder(ViewGroup viewGroup, int i, Map<String, Object> map) {
        }
    }

    public b(IPresenter iPresenter) {
        if (iPresenter != null) {
            this.mPresenter = iPresenter;
            Activity context = iPresenter.getContext();
            this.mContext = context;
            this.mViewEngine = new wv2(context, iPresenter.getModuleName());
            setDinamicContext();
            init();
            return;
        }
        throw new IllegalArgumentException("param presenter can not be null");
    }

    private void init() {
        this.mViewEngine.F(new a());
    }

    private void logComponents(List<IDMComponent> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                IDMComponent iDMComponent = list.get(i);
                if (iDMComponent != null) {
                    sb.append("type: ");
                    sb.append(iDMComponent.getType());
                    sb.append("tag: ");
                    sb.append(iDMComponent.getTag());
                    sb.append("containerType: ");
                    sb.append(iDMComponent.getContainerType());
                    sb.append(StringUtils.LF);
                }
            }
            tr2.b(TAG, "logComponents", sb.toString());
        }
    }

    private void setDinamicContext() {
        this.mViewEngine.g(a.DINAMIC_CONTEXT_KEY_PRESENTER, this.mPresenter);
    }

    public void bindViewTree(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        this.mHeaderView = linearLayout;
        this.mRecyclerView = recyclerView;
        this.mFooterView = linearLayout2;
        this.mViewEngine.h(linearLayout, recyclerView, linearLayout2);
    }

    public void closePopupWindow(boolean z) {
        PopupWindowManager popupWindowManager = this.mPopupWindowManager;
        if (popupWindowManager != null && popupWindowManager.j()) {
            this.mPopupWindowManager.g(z);
        }
    }

    public void destroy() {
        this.mViewEngine.i();
    }

    public int findFirstVisibleItemPosition() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
    }

    public ViewGroup getBodyLayout() {
        return this.mRecyclerView;
    }

    public ViewGroup getFooterLayout() {
        return this.mFooterView;
    }

    public ViewGroup getHeaderLayout() {
        return this.mHeaderView;
    }

    public Pair<IDMComponent, IDMEvent> getPopupWindowTrigger() {
        return this.mPopupWindowTrigger;
    }

    public wv2 getViewEngine() {
        return this.mViewEngine;
    }

    public void initView(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        throw null;
    }

    public boolean isPopupShowing() {
        PopupWindowManager popupWindowManager = this.mPopupWindowManager;
        return popupWindowManager != null && popupWindowManager.j();
    }

    public void rebuild(hn2 hn2) {
        am2.c(am2.KEY_ULTRON_PROFILE, "viewmanager rebuild start");
        tr2.b(TAG, "rebuild");
        if (hn2 != null) {
            IDMComponent iDMComponent = null;
            List<IDMComponent> c = hn2.c();
            int i = 0;
            if (c != null) {
                tr2.b(TAG, "log component header");
                logComponents(c);
                int i2 = 0;
                while (true) {
                    if (i2 >= c.size()) {
                        break;
                    }
                    IDMComponent iDMComponent2 = hn2.c().get(i2);
                    if (this.mStickyTagInHeader.equals(iDMComponent2.getTag())) {
                        iDMComponent = iDMComponent2;
                        break;
                    }
                    i2++;
                }
            }
            List<IDMComponent> a2 = hn2.a();
            if (a2 != null) {
                tr2.b(TAG, "log component body");
                logComponents(a2);
                while (true) {
                    if (i < a2.size()) {
                        if (this.mTriggerTagForHeader.equals(hn2.a().get(i).getTag()) && iDMComponent != null) {
                            this.mViewEngine.I(i, iDMComponent);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            List<IDMComponent> b = hn2.b();
            if (b != null) {
                tr2.b(TAG, "log component footer");
                logComponents(b);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(hn2.c());
            arrayList.addAll(hn2.a());
            arrayList.addAll(hn2.b());
            l20 l20 = new l20();
            l20.e(hn2.a());
            l20.h(hn2.c());
            l20.g(hn2.b());
            this.mViewEngine.G(l20);
            l20.f(this.mPresenter.getDataContext().getDynamicTemplateList());
            this.mViewEngine.r(7);
            if (pf1.a(this.mContext)) {
                ((IMonitor) this.mContext).setMonitorStart(true);
            }
        }
        am2.c(am2.KEY_ULTRON_PROFILE, "viewmanager rebuild end");
    }

    public void refresh() {
        refresh(7);
    }

    public void refreshCurrentContainer() {
        PopupWindowManager popupWindowManager = this.mPopupWindowManager;
        if (popupWindowManager == null || !popupWindowManager.j()) {
            refresh();
        } else {
            this.mPopupWindowManager.n();
        }
    }

    public void registerDynamicEventListener(OnDynamicEventListener onDynamicEventListener) {
        this.mViewEngine.z(onDynamicEventListener);
    }

    public void registerViewHolderCreator(String str, IViewHolderCreator iViewHolderCreator) {
        wv2 wv2 = this.mViewEngine;
        if (wv2 != null) {
            wv2.A(str, iViewHolderCreator);
            return;
        }
        throw new IllegalArgumentException("initView method did not invoked");
    }

    public void registerWebEventListener(String str, IWebEventBridge iWebEventBridge) {
        this.mViewEngine.B(str, iWebEventBridge);
    }

    public void scrollToPosition(int i) {
        this.mViewEngine.C(i);
    }

    public void setAdapter(RecyclerViewAdapter recyclerViewAdapter) {
        this.mViewEngine.D(recyclerViewAdapter);
    }

    public void setBizName(String str) {
        this.mBizName = str;
        this.mViewEngine.E(str);
    }

    public void setFooterStickyInfo(int i, IDMComponent iDMComponent) {
        this.mViewEngine.H(i, iDMComponent);
    }

    public void setHeaderStickyInfo(int i, IDMComponent iDMComponent) {
        this.mViewEngine.I(i, iDMComponent);
    }

    public void setMarkType(int i) {
        this.mViewEngine.J(i);
    }

    public void setPopupWindowTrigger(Pair<IDMComponent, IDMEvent> pair) {
        this.mPopupWindowTrigger = pair;
    }

    public void setRelatedStickyTags(@NonNull String str, @NonNull String str2) {
        this.mStickyTagInHeader = str;
        this.mTriggerTagForHeader = str2;
    }

    public void showPopup(List<IDMComponent> list, OpenPopupWindowEventModel openPopupWindowEventModel, PopupWindowManager.OnCancelListener onCancelListener) {
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (IDMComponent iDMComponent : list) {
                String e = c.e(iDMComponent);
                if (WXBasicComponentType.FOOTER.equals(e)) {
                    arrayList.add(iDMComponent);
                } else if ("header".equals(e)) {
                    arrayList3.add(iDMComponent);
                } else {
                    arrayList2.add(iDMComponent);
                }
            }
            l20 l20 = new l20();
            l20.e(arrayList2);
            l20.h(arrayList3);
            l20.g(arrayList);
            showPopup(l20, openPopupWindowEventModel, onCancelListener);
        }
    }

    public void v2RegisterDinamicXParser(String str, @NonNull v0 v0Var) {
        try {
            this.mViewEngine.n().d().t(str, v0Var);
        } catch (DinamicException e) {
            tr2.b("dinamicX", "" + e.getMessage());
        }
    }

    public void v2registerDinamicXView(String str, @NonNull DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) {
        try {
            this.mViewEngine.n().d().u(str, dinamicViewAdvancedConstructor);
        } catch (DinamicException e) {
            tr2.b("dinamicX", "" + e.getMessage());
        }
    }

    public void v3RegisterDinamicXParser(long j, @NonNull IDXDataParser iDXDataParser) {
        this.mViewEngine.n().d().j(j, iDXDataParser);
    }

    public void v3RegisterDinamicXView(long j, @NonNull IDXBuilderWidgetNode iDXBuilderWidgetNode) {
        this.mViewEngine.n().d().m(j, iDXBuilderWidgetNode);
    }

    public void refresh(int i) {
        this.mViewEngine.v(i);
    }

    public void showPopup(l20 l20, OpenPopupWindowEventModel openPopupWindowEventModel, PopupWindowManager.OnCancelListener onCancelListener) {
        if (l20 != null) {
            if (openPopupWindowEventModel == null) {
                openPopupWindowEventModel = new OpenPopupWindowEventModel();
            }
            PopupWindowManager popupWindowManager = new PopupWindowManager(this.mViewEngine);
            this.mPopupWindowManager = popupWindowManager;
            popupWindowManager.o(l20);
            PopupWindowManager.e eVar = new PopupWindowManager.e();
            eVar.j(-1);
            OpenPopupWindowEventModel.Css css = openPopupWindowEventModel.getCss();
            if (css != null) {
                try {
                    eVar.l(Float.parseFloat(css.getHeight()));
                } catch (Exception unused) {
                }
            } else {
                eVar.l(0.6f);
            }
            OpenPopupWindowEventModel.Options options = openPopupWindowEventModel.getOptions();
            if (options == null) {
                eVar.h(this.mContext.getResources().getDrawable(R$drawable.popup_close_btn));
            } else if ("true".equals(options.getNeedCloseButton())) {
                eVar.h(this.mContext.getResources().getDrawable(R$drawable.popup_close_btn));
            }
            eVar.i(80);
            jk2 themeManager = this.mPresenter.getThemeManager();
            List<String> c = themeManager.c(PopupWindowManager.e.KEY_TOP_RADIUS);
            int i = 0;
            int a2 = (c == null || c.size() <= 0) ? 0 : lo2.a(c.get(0));
            List<String> c2 = themeManager.c(PopupWindowManager.e.KEY_BOTTOM_RADIUS);
            if (c2 != null && c2.size() > 0) {
                i = lo2.a(c2.get(0));
            }
            eVar.k((float) qb2.a(this.mContext, (float) a2), (float) qb2.a(this.mContext, (float) i));
            this.mPopupWindowManager.q(eVar);
            this.mPopupWindowManager.p(onCancelListener);
        }
    }
}

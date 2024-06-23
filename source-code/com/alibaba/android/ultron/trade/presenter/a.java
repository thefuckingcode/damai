package com.alibaba.android.ultron.trade.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradePriceViewConstructor;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradeRichTextViewConstructor;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradeTextInputConstructor;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.extplugin.ExtPlugInfo;
import com.alibaba.android.ultron.trade.theme.IConfiguration;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.alibaba.fastjson.JSON;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.List;
import java.util.Map;
import tb.am2;
import tb.at0;
import tb.bi2;
import tb.bj;
import tb.ci2;
import tb.df0;
import tb.di2;
import tb.ei2;
import tb.fg0;
import tb.fi2;
import tb.hn2;
import tb.ik2;
import tb.jk2;
import tb.jn2;
import tb.js0;
import tb.kn2;
import tb.my;
import tb.pq1;
import tb.tr2;
import tb.uh0;

/* compiled from: Taobao */
public abstract class a implements IPresenter {
    public static final String DINAMIC_CONTEXT_KEY_PRESENTER = "dianmicContextKeyPresenter";
    private String mBizName = "default";
    protected Activity mContext;
    protected BaseDataManager mDataManager;
    protected jk2 mThemeManager;
    protected kn2 mTradeEventHandler;
    protected b mViewManager;

    public a(Activity activity) {
        this.mContext = activity;
        am2.c(am2.KEY_ULTRON_PROFILE, "BasePresenter start");
    }

    public jn2 buildTradeEvent() {
        return this.mTradeEventHandler.d();
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public Activity getContext() {
        return this.mContext;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public IDMContext getDataContext() {
        return this.mDataManager.getDataContext();
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public BaseDataManager getDataManager() {
        return this.mDataManager;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public jk2 getThemeManager() {
        return this.mThemeManager;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public kn2 getTradeEventHandler() {
        return this.mTradeEventHandler;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public b getViewManager() {
        return this.mViewManager;
    }

    public boolean hasRenderContent() {
        List<IDMComponent> components;
        IDMContext dataContext = this.mDataManager.getDataContext();
        if (dataContext == null || (components = dataContext.getComponents()) == null || components.size() <= 0) {
            return false;
        }
        return true;
    }

    public void init(BaseDataManager baseDataManager, b bVar) {
        this.mDataManager = baseDataManager;
        this.mViewManager = bVar;
        this.mThemeManager = new jk2(this.mContext);
        kn2 kn2 = new kn2(this);
        this.mTradeEventHandler = kn2;
        this.mViewManager.registerDynamicEventListener(kn2);
        registerDinamicXView();
        registerDinamicXParser();
        initEventSubscriber();
        registerBridge();
    }

    /* access modifiers changed from: protected */
    public void initEventSubscriber() {
        Map<String, Class<? extends ISubscriber>> a = df0.a();
        if (a != null && !a.isEmpty()) {
            try {
                for (Map.Entry<String, Class<? extends ISubscriber>> entry : a.entrySet()) {
                    this.mTradeEventHandler.a(entry.getKey(), (ISubscriber) entry.getValue().newInstance());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void initExtPlugin(Context context, String str) {
        List<ExtPlugInfo> list;
        try {
            list = JSON.parseArray(new String(uh0.a(context, str)), ExtPlugInfo.class);
        } catch (Exception unused) {
            list = null;
        }
        initExtPlugin(list);
    }

    public void initView(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        this.mViewManager.initView(linearLayout, recyclerView, linearLayout2);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mTradeEventHandler.k(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
        kn2 kn2 = this.mTradeEventHandler;
        if (kn2 != null) {
            kn2.f();
        }
        b bVar = this.mViewManager;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public void onPause() {
    }

    public void onResume() {
        tr2.f(this.mBizName);
    }

    public void rebuild(hn2 hn2) {
        this.mTradeEventHandler.e(hn2);
        this.mViewManager.rebuild(hn2);
    }

    /* access modifiers changed from: protected */
    public void registerBridge() {
        registerWebEventListener(bj.BRIDGE_TAG, new bj(this));
        registerWebEventListener(js0.BRIDGE_TAG, new js0(this));
    }

    /* access modifiers changed from: protected */
    public void registerDinamicXParser() {
        this.mViewManager.v2RegisterDinamicXParser("gradient", new at0());
        this.mViewManager.v2RegisterDinamicXParser("theme", new ik2());
        this.mViewManager.v2RegisterDinamicXParser("platform", new pq1());
        this.mViewManager.v3RegisterDinamicXParser(my.a(ci2.PARSER_TAG), new ci2());
        this.mViewManager.v3RegisterDinamicXParser(my.a(bi2.PARSER_TAG), new bi2());
        this.mViewManager.v3RegisterDinamicXParser(my.a("theme"), new ei2());
    }

    /* access modifiers changed from: protected */
    public void registerDinamicXView() {
        this.mViewManager.v2registerDinamicXView(TradePriceViewConstructor.VIEW_TAG, new TradePriceViewConstructor());
        this.mViewManager.v2registerDinamicXView(TradeRichTextViewConstructor.VIEW_TAG, new TradeRichTextViewConstructor());
        this.mViewManager.v2registerDinamicXView(TradeTextInputConstructor.VIEW_TAG, new TradeTextInputConstructor());
        this.mViewManager.v3RegisterDinamicXView(di2.DX_WIDGET_ID, new di2.a());
        this.mViewManager.v3RegisterDinamicXView(fi2.DX_WIDGET_ID, new fi2.a());
    }

    public void registerViewHolderCreator(String str, IViewHolderCreator iViewHolderCreator) {
        this.mViewManager.registerViewHolderCreator(str, iViewHolderCreator);
    }

    public void registerWebEventListener(String str, IWebEventBridge iWebEventBridge) {
        this.mViewManager.registerWebEventListener(str, iWebEventBridge);
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public void respondToLinkage(IDMComponent iDMComponent) {
        this.mDataManager.respondToLinkage(iDMComponent);
    }

    public void setBizName(String str) {
        this.mBizName = str;
    }

    public void setCurrentAutoJump(IDMComponent iDMComponent, String str) {
        this.mTradeEventHandler.m(iDMComponent, str);
    }

    public void setMarkType(int i) {
        this.mViewManager.setMarkType(i);
    }

    public void setThemeConfig(IConfiguration iConfiguration) {
        this.mThemeManager.g(iConfiguration);
    }

    public void initExtPlugin(List<ExtPlugInfo> list) {
        if (list != null) {
            fg0 fg0 = new fg0();
            fg0.a(list, this);
            this.mTradeEventHandler.b(fg0.getSubscribers());
        }
    }
}

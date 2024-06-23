package com.alibaba.pictures.bricks.component.scriptmurder;

import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.util.DMRGBUtil;
import com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.AbsPresenter;
import com.youku.arch.v3.view.IContract;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.as0;
import tb.bs0;
import tb.k21;
import tb.m40;
import tb.zr0;

/* compiled from: Taobao */
public final class GenericBannerPresenterExt extends BaseBannerPresenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String MSG_BANNER_ATTACHED = "EventBus://business/notification/msg_banner_attached";
    @NotNull
    public static final String MSG_BANNER_BG_UPDATE = "EventBus://business/notification/msg_banner_bg_update";
    @NotNull
    public static final String MSG_BANNER_DETACHED = "EventBus://business/notification/msg_banner_detached";
    @NotNull
    public static final String PRE_STICKY_HEADER = "EventBus://business/";
    @Nullable
    private GenericItem<ItemValue> lastItem;
    @NotNull
    private String totalSize = "";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericBannerPresenterExt(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-10$lambda-9$lambda-8$lambda-7$lambda-5  reason: not valid java name */
    public static final void m143init$lambda10$lambda9$lambda8$lambda7$lambda5(Object obj, GenericBannerPresenterExt genericBannerPresenterExt, GenericItem genericItem, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1387316362")) {
            ipChange.ipc$dispatch("-1387316362", new Object[]{obj, genericBannerPresenterExt, genericItem, successEvent});
            return;
        }
        k21.i(obj, "$it1");
        k21.i(genericBannerPresenterExt, "this$0");
        k21.i(genericItem, "$item");
        if ((successEvent != null ? successEvent.bitmap : null) != null) {
            DMRGBUtil.f(1.0f, successEvent.bitmap, (String) obj, new zr0(genericBannerPresenterExt, genericItem));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-10$lambda-9$lambda-8$lambda-7$lambda-5$lambda-4  reason: not valid java name */
    public static final void m144init$lambda10$lambda9$lambda8$lambda7$lambda5$lambda4(GenericBannerPresenterExt genericBannerPresenterExt, GenericItem genericItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458624073")) {
            ipChange.ipc$dispatch("458624073", new Object[]{genericBannerPresenterExt, genericItem, Integer.valueOf(i)});
            return;
        }
        k21.i(genericBannerPresenterExt, "this$0");
        k21.i(genericItem, "$item");
        IContract.View view = genericBannerPresenterExt.getView();
        k21.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
        ((GenericBannerViewExt) view).setBgColor(i);
        HashMap hashMap = new HashMap();
        hashMap.put("color", Integer.valueOf(i));
        EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(MSG_BANNER_BG_UPDATE, hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-10$lambda-9$lambda-8$lambda-7$lambda-6  reason: not valid java name */
    public static final void m145init$lambda10$lambda9$lambda8$lambda7$lambda6(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416222902")) {
            ipChange.ipc$dispatch("-1416222902", new Object[]{failEvent});
            return;
        }
        Log.e(AbsPresenter.TAG, "DMImageCreator.FailEvent: " + failEvent.resultCode);
    }

    public final void disPatch(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773303994")) {
            ipChange.ipc$dispatch("1773303994", new Object[]{this, str});
            return;
        }
        k21.i(str, "msg");
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, null);
        }
    }

    @Nullable
    public final GenericItem<ItemValue> getLastItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-404385567")) {
            return this.lastItem;
        }
        return (GenericItem) ipChange.ipc$dispatch("-404385567", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.Presenter
    public void onPageChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372699465")) {
            ipChange.ipc$dispatch("1372699465", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onPageChanged(i);
        IContract.View view = getView();
        k21.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
        ((GenericBannerViewExt) view).updateImgLength(this.totalSize, String.valueOf(i + 1));
    }

    public final void setLastItem(@Nullable GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146429541")) {
            ipChange.ipc$dispatch("-146429541", new Object[]{this, genericItem});
            return;
        }
        this.lastItem = genericItem;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Node node;
        List<Node> children;
        Node node2;
        List<Node> children2;
        Node node3;
        JSONObject data;
        Node node4;
        List<Node> children3;
        List<Node> children4;
        Node node5;
        JSONObject data2;
        Object obj;
        ImageLoaderProvider proxy;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2075690582")) {
            ipChange.ipc$dispatch("2075690582", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init(genericItem);
        if (this.lastItem != genericItem) {
            this.lastItem = genericItem;
            IContainer<ModelValue> container = genericItem.getContainer();
            List<Node> list = null;
            ModelValue property = container != null ? container.getProperty() : null;
            k21.g(property, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
            List<Node> children5 = property.getChildren();
            if (children5 != null) {
                if (children5.isEmpty()) {
                    children5 = null;
                }
                if (!(children5 == null || (node4 = children5.get(0)) == null || (children3 = node4.getChildren()) == null)) {
                    for (T t : children3) {
                        if (t.getType() == 9994 && (children4 = t.getChildren()) != null) {
                            if (children4.isEmpty()) {
                                children4 = null;
                            }
                            if (children4 != null) {
                                String valueOf = String.valueOf(children4.size());
                                this.totalSize = valueOf;
                                IContract.View view = getView();
                                k21.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
                                ((GenericBannerViewExt) view).updateImgLength(valueOf, "1");
                                if (children4.isEmpty()) {
                                    children4 = null;
                                }
                                if (!(children4 == null || (node5 = children4.get(0)) == null || (data2 = node5.getData()) == null || (obj = data2.get("url")) == null || (proxy = ImageLoaderProviderProxy.getProxy()) == null)) {
                                    k21.g(obj, "null cannot be cast to non-null type kotlin.String");
                                    proxy.load((String) obj, new bs0(obj, this, genericItem), as0.a);
                                }
                            }
                        }
                    }
                }
            }
            IContainer<ModelValue> container2 = genericItem.getContainer();
            ModelValue property2 = container2 != null ? container2.getProperty() : null;
            k21.g(property2, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
            List<Node> children6 = property2.getChildren();
            if (children6 != null) {
                if (!(!children6.isEmpty() && children6.size() >= 2)) {
                    children6 = null;
                }
                if (!(children6 == null || (node = children6.get(1)) == null || (children = node.getChildren()) == null)) {
                    if (children.isEmpty()) {
                        children = null;
                    }
                    if (!(children == null || (node2 = children.get(0)) == null || (children2 = node2.getChildren()) == null)) {
                        if (!children2.isEmpty()) {
                            list = children2;
                        }
                        if (!(list == null || (node3 = list.get(0)) == null || (data = node3.getData()) == null)) {
                            Object parseObject = JSON.parseObject(data.toJSONString(), ShopInfoBean.class);
                            IContract.View view2 = getView();
                            k21.g(view2, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
                            k21.h(parseObject, "shopInfoBean");
                            ((GenericBannerViewExt) view2).showOrderTitle((ShopInfoBean) parseObject);
                        }
                    }
                }
            }
        }
    }
}

package com.alient.onearch.adapter.component.tab.base;

import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u0014\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u00020\tB\u000f\u0012\u0006\u0010\u001e\u001a\u00020(¢\u0006\u0004\bK\u0010LJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010/R*\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00108\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R*\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u00103\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\"\u0010?\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0003\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/base/BaseTabView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$Presenter;", "P", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Ltb/ur2;", "onTabSelected", "onTabUnselected", "onTabReselected", "", "selectedPosition", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "tabLayout", "", "isScroll", "updateSelectedTab", "resetComponentRightBtns", "", "selectedTabTextSize", "Lcom/alibaba/fastjson/JSONArray;", "btns", "setComponentBtns", "Landroid/widget/TextView;", "view", "Lcom/alient/oneservice/nav/Action;", "action", "rightBtnClick", "btnOne", "Landroid/widget/TextView;", "getBtnOne", "()Landroid/widget/TextView;", "btnTwo", "getBtnTwo", "Landroid/view/View;", "rightArrow", "Landroid/view/View;", "getRightArrow", "()Landroid/view/View;", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "getTabLayout", "()Lcom/alient/onearch/adapter/widget/OneTabLayout;", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Ljava/util/List;", "getChildComponentTitles", "()Ljava/util/List;", "setChildComponentTitles", "(Ljava/util/List;)V", "childComponentBtns", "getChildComponentBtns", "setChildComponentBtns", "Lcom/youku/arch/v3/core/Node;", "childComponentNodes", "getChildComponentNodes", "setChildComponentNodes", "currentSelectedTabPosition", "getCurrentSelectedTabPosition", "()I", "setCurrentSelectedTabPosition", "(I)V", "Lcom/youku/arch/v3/IItem;", "containerItem", "Lcom/youku/arch/v3/IItem;", "getContainerItem", "()Lcom/youku/arch/v3/IItem;", "setContainerItem", "(Lcom/youku/arch/v3/IItem;)V", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class BaseTabView<I extends GenericItem<ItemValue>, M extends IContract.Model<I>, P extends IContract.Presenter<I, M>> extends AbsView<I, M, P> implements TabLayout.OnTabSelectedListener {
    @Nullable
    private final TextView btnOne;
    @Nullable
    private final TextView btnTwo;
    @Nullable
    private List<? extends JSONArray> childComponentBtns;
    @Nullable
    private List<? extends Node> childComponentNodes;
    @Nullable
    private List<RichTitle> childComponentTitles;
    public IItem<ItemValue> containerItem;
    private int currentSelectedTabPosition;
    @Nullable
    private final View rightArrow;
    @NotNull
    private final OneTabLayout tabLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseTabView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        this.btnOne = (TextView) view.findViewById(R.id.action_one);
        this.btnTwo = (TextView) view.findViewById(R.id.action_two);
        this.rightArrow = view.findViewById(R.id.right_arrow);
        View findViewById = view.findViewById(R.id.component_tab_layout);
        k21.h(findViewById, "view.findViewById(R.id.component_tab_layout)");
        this.tabLayout = (OneTabLayout) findViewById;
    }

    @Nullable
    public final TextView getBtnOne() {
        return this.btnOne;
    }

    @Nullable
    public final TextView getBtnTwo() {
        return this.btnTwo;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.alibaba.fastjson.JSONArray>, java.util.List<com.alibaba.fastjson.JSONArray> */
    @Nullable
    public final List<JSONArray> getChildComponentBtns() {
        return this.childComponentBtns;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.youku.arch.v3.core.Node>, java.util.List<com.youku.arch.v3.core.Node> */
    @Nullable
    public final List<Node> getChildComponentNodes() {
        return this.childComponentNodes;
    }

    @Nullable
    public final List<RichTitle> getChildComponentTitles() {
        return this.childComponentTitles;
    }

    @NotNull
    public final IItem<ItemValue> getContainerItem() {
        IItem<ItemValue> iItem = this.containerItem;
        if (iItem == null) {
            k21.A("containerItem");
        }
        return iItem;
    }

    public final int getCurrentSelectedTabPosition() {
        return this.currentSelectedTabPosition;
    }

    @Nullable
    public final View getRightArrow() {
        return this.rightArrow;
    }

    @NotNull
    public final OneTabLayout getTabLayout() {
        return this.tabLayout;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        this.currentSelectedTabPosition = tab.getPosition();
        OneTabLayout oneTabLayout = this.tabLayout;
        int tabCount = oneTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            if (i == this.currentSelectedTabPosition) {
                TabLayout.Tab tabAt = oneTabLayout.getTabAt(i);
                if (tabAt != null) {
                    k21.h(tabAt, "this");
                    oneTabLayout.setSelectedTab(tabAt, false);
                }
            } else {
                TabLayout.Tab tabAt2 = oneTabLayout.getTabAt(i);
                if (tabAt2 != null) {
                    k21.h(tabAt2, "this");
                    oneTabLayout.setUnSelectedTab(tabAt2, false);
                }
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        this.tabLayout.setUnSelectedTab(tab, false);
    }

    public void resetComponentRightBtns(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        List<? extends JSONArray> list = this.childComponentBtns;
        if (list != null && tab.getPosition() < list.size()) {
            try {
                setComponentBtns((JSONArray) list.get(tab.getPosition()));
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void rightBtnClick(@NotNull TextView textView, @NotNull Action action) {
        k21.i(textView, "view");
        k21.i(action, "action");
        NavProviderProxy.toUri(textView.getContext(), action);
        UserTrackProviderProxy.click(textView, action.getTrackInfo(), true);
    }

    public float selectedTabTextSize() {
        return 18.0f;
    }

    public final void setChildComponentBtns(@Nullable List<? extends JSONArray> list) {
        this.childComponentBtns = list;
    }

    public final void setChildComponentNodes(@Nullable List<? extends Node> list) {
        this.childComponentNodes = list;
    }

    public final void setChildComponentTitles(@Nullable List<RichTitle> list) {
        this.childComponentTitles = list;
    }

    public void setComponentBtns(@NotNull JSONArray jSONArray) {
        Action action;
        Action action2;
        Action action3;
        k21.i(jSONArray, "btns");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Boolean bool = null;
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        IItem<ItemValue> iItem = this.containerItem;
        if (iItem == null) {
            k21.A("containerItem");
        }
        JSONObject data = iItem.getComponent().getModule().getContainer().getProperty().getData();
        String string = data != null ? data.getString(GenericPagerLoader.UT_SPM_AB) : null;
        int i = 0;
        if (!(string == null || string.length() == 0)) {
            List list = StringsKt__StringsKt.z0(string, new String[]{"."}, false, 0, 6, null);
            if (!(list == null || list.isEmpty()) && list.size() > 1) {
                ref$ObjectRef.element = (T) ((String) list.get(0));
                ref$ObjectRef2.element = (T) ((String) list.get(1));
            }
        }
        if (jSONArray.size() == 0) {
            TextView textView = this.btnOne;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.btnTwo;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            View view = this.rightArrow;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (jSONArray.size() == 1) {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            String string2 = jSONObject.getString("text");
            TextView textView3 = this.btnOne;
            if (textView3 != null) {
                textView3.setText(string2);
            }
            TextView textView4 = this.btnOne;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("action");
            if (!(jSONObject2 == null || (action3 = (Action) jSONObject2.toJavaObject(Action.class)) == null)) {
                TrackInfo trackInfo = action3.getTrackInfo();
                k21.h(trackInfo, "trackInfo");
                trackInfo.setSpma(ref$ObjectRef.element);
                TrackInfo trackInfo2 = action3.getTrackInfo();
                k21.h(trackInfo2, "trackInfo");
                trackInfo2.setSpmb(ref$ObjectRef2.element);
                UserTrackProviderProxy.expose(this.btnOne, action3.getTrackInfo());
                TextView textView5 = this.btnOne;
                if (textView5 != null) {
                    textView5.setOnClickListener(new BaseTabView$setComponentBtns$$inlined$apply$lambda$1(action3, this, ref$ObjectRef, ref$ObjectRef2));
                }
            }
            TextView textView6 = this.btnTwo;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            String string3 = jSONObject.getString(OneArchConstants.LayoutKey.SHOW_INDICATOR);
            if (string3 != null) {
                bool = Boolean.valueOf(string3.equals("true"));
            }
            if (bool == null) {
                View view2 = this.rightArrow;
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            View view3 = this.rightArrow;
            if (view3 != null) {
                if (!bool.booleanValue()) {
                    i = 8;
                }
                view3.setVisibility(i);
            }
        } else if (jSONArray.size() >= 2) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(0);
            String string4 = jSONObject3.getString("text");
            TextView textView7 = this.btnOne;
            if (textView7 != null) {
                textView7.setText(string4);
            }
            TextView textView8 = this.btnOne;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            JSONObject jSONObject4 = jSONObject3.getJSONObject("action");
            if (!(jSONObject4 == null || (action2 = (Action) jSONObject4.toJavaObject(Action.class)) == null)) {
                TrackInfo trackInfo3 = action2.getTrackInfo();
                k21.h(trackInfo3, "trackInfo");
                trackInfo3.setSpma(ref$ObjectRef.element);
                TrackInfo trackInfo4 = action2.getTrackInfo();
                k21.h(trackInfo4, "trackInfo");
                trackInfo4.setSpmb(ref$ObjectRef2.element);
                UserTrackProviderProxy.expose(this.btnOne, action2.getTrackInfo());
                TextView textView9 = this.btnOne;
                if (textView9 != null) {
                    textView9.setOnClickListener(new BaseTabView$setComponentBtns$$inlined$apply$lambda$2(action2, this, ref$ObjectRef, ref$ObjectRef2));
                }
            }
            JSONObject jSONObject5 = jSONArray.getJSONObject(1);
            String string5 = jSONObject5.getString("text");
            TextView textView10 = this.btnTwo;
            if (textView10 != null) {
                textView10.setText(string5);
            }
            TextView textView11 = this.btnTwo;
            if (textView11 != null) {
                textView11.setVisibility(0);
            }
            JSONObject jSONObject6 = jSONObject5.getJSONObject("action");
            if (jSONObject6 != null && (action = (Action) jSONObject6.toJavaObject(Action.class)) != null) {
                TrackInfo trackInfo5 = action.getTrackInfo();
                k21.h(trackInfo5, "trackInfo");
                trackInfo5.setSpma(ref$ObjectRef.element);
                TrackInfo trackInfo6 = action.getTrackInfo();
                k21.h(trackInfo6, "trackInfo");
                trackInfo6.setSpmb(ref$ObjectRef2.element);
                UserTrackProviderProxy.expose(this.btnTwo, action.getTrackInfo());
                TextView textView12 = this.btnTwo;
                if (textView12 != null) {
                    textView12.setOnClickListener(new BaseTabView$setComponentBtns$$inlined$apply$lambda$3(action, this, ref$ObjectRef, ref$ObjectRef2));
                }
            }
        }
    }

    public final void setContainerItem(@NotNull IItem<ItemValue> iItem) {
        k21.i(iItem, "<set-?>");
        this.containerItem = iItem;
    }

    public final void setCurrentSelectedTabPosition(int i) {
        this.currentSelectedTabPosition = i;
    }

    public final void updateSelectedTab(int i, @NotNull OneTabLayout oneTabLayout, boolean z) {
        k21.i(oneTabLayout, "tabLayout");
        this.currentSelectedTabPosition = i;
        int tabCount = oneTabLayout.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.Tab tabAt = oneTabLayout.getTabAt(i2);
            if (i2 == i) {
                if (tabAt != null) {
                    oneTabLayout.setSelectedTab(tabAt, z);
                }
            } else if (tabAt != null) {
                oneTabLayout.setUnSelectedTab(tabAt, z);
            }
        }
    }
}

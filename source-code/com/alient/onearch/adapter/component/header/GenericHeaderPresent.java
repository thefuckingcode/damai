package com.alient.onearch.adapter.component.header;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.header.GenericHeaderContract;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.style.StyleUtil;
import com.youku.arch.v3.util.ColorUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderPresent;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderModel;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderView;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$Presenter;", "item", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericHeaderPresent extends AbsPresenter<GenericItem<ItemValue>, GenericHeaderModel, GenericHeaderView> implements GenericHeaderContract.Presenter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericHeaderPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0289  */
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String str;
        String str2;
        TrackInfo trackInfo;
        TrackInfo trackInfo2;
        TrackInfo trackInfo3;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        ((GenericHeaderView) getView()).renderBackground(ColorUtil.parseColorSafely("#FFFFFF"), ColorUtil.parseColorSafely("#FFFFFF"));
        Integer headerHeight = ((GenericHeaderModel) getModel()).getHeaderHeight();
        if (headerHeight != null) {
            ((GenericHeaderView) getView()).renderHeight(headerHeight.intValue());
            ur2 ur2 = ur2.INSTANCE;
        }
        JSONObject data = genericItem.getProperty().getData();
        if (data != null) {
            StyleUtil styleUtil = StyleUtil.INSTANCE;
            if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_BG_COLOR)) {
                Activity activity = genericItem.getPageContext().getActivity();
                if (activity != null) {
                    String hexString = Integer.toHexString(styleUtil.getColor(activity, genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_BG_COLOR, R.color.white));
                    ((GenericHeaderView) getView()).renderBackground(ColorUtil.parseColorSafely(hexString), ColorUtil.parseColorSafely(hexString));
                    ur2 ur22 = ur2.INSTANCE;
                }
            } else if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_BG_START_COLOR)) {
                Activity activity2 = genericItem.getPageContext().getActivity();
                if (activity2 != null) {
                    Style style = genericItem.getComponent().getProperty().getStyle();
                    int i = R.color.white;
                    ((GenericHeaderView) getView()).renderBackground(ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity2, style, StyleConstant.HEADER_BG_START_COLOR, i))), ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity2, genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_BG_END_COLOR, i))));
                    ur2 ur23 = ur2.INSTANCE;
                }
            } else {
                String string = data.getString(StyleConstant.HEADER_BG_START_COLOR);
                String string2 = data.getString(StyleConstant.HEADER_BG_END_COLOR);
                if (!(string == null || string.length() == 0)) {
                    if (!(string2 == null || string2.length() == 0)) {
                        ((GenericHeaderView) getView()).renderBackground(ColorUtil.parseColorSafely(string), ColorUtil.parseColorSafely(string2));
                    }
                }
            }
            String string3 = data.getString("title");
            if (string3 != null) {
                ((GenericHeaderView) getView()).renderTitle(string3);
                ur2 ur24 = ur2.INSTANCE;
            }
            Action action = null;
            Boolean bool = null;
            if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_TEXT_COLOR)) {
                Activity activity3 = genericItem.getPageContext().getActivity();
                if (activity3 != null) {
                    ((GenericHeaderView) getView()).renderTitleTextColor(ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity3, genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_TEXT_COLOR, R.color.black))));
                    ur2 ur25 = ur2.INSTANCE;
                }
            } else {
                String string4 = data.getString(StyleConstant.HEADER_TEXT_COLOR);
                if (!(!(string4 == null || string4.length() == 0))) {
                    string4 = null;
                }
                if (string4 != null) {
                    ((GenericHeaderView) getView()).renderTitleTextColor(ColorUtil.parseColorSafely(string4));
                    ur2 ur26 = ur2.INSTANCE;
                }
            }
            if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_RIGHT_TEXT_COLOR)) {
                Activity activity4 = genericItem.getPageContext().getActivity();
                if (activity4 != null) {
                    ((GenericHeaderView) getView()).renderTitleTextColor(ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity4, genericItem.getComponent().getProperty().getStyle(), StyleConstant.HEADER_RIGHT_TEXT_COLOR, R.color.black))));
                    ur2 ur27 = ur2.INSTANCE;
                }
            } else {
                String string5 = data.getString(StyleConstant.HEADER_RIGHT_TEXT_COLOR);
                if (!(!(string5 == null || string5.length() == 0))) {
                    string5 = null;
                }
                if (string5 != null) {
                    ((GenericHeaderView) getView()).renderTitleRightTextColor(ColorUtil.parseColorSafely(string5));
                    ur2 ur28 = ur2.INSTANCE;
                }
            }
            ((GenericHeaderView) getView()).renderTitleRightImage(data.getString(OneArchConstants.LayoutKey.TITLE_RIGHT_IMAGE));
            JSONArray jSONArray = data.getJSONArray(OneArchConstants.LayoutKey.KEY_WORDS);
            if (jSONArray != null) {
                JSONObject data2 = genericItem.getComponent().getModule().getContainer().getProperty().getData();
                String string6 = data2 != null ? data2.getString(GenericPagerLoader.UT_SPM_AB) : null;
                if (!(string6 == null || string6.length() == 0)) {
                    List list = StringsKt__StringsKt.z0(string6, new String[]{"."}, false, 0, 6, null);
                    if (!(list == null || list.isEmpty()) && list.size() > 1) {
                        str2 = (String) list.get(0);
                        str = (String) list.get(1);
                        if (jSONArray.size() != 1) {
                            JSONObject jSONObject = jSONArray.getJSONObject(0);
                            JSONObject jSONObject2 = jSONObject.getJSONObject("action");
                            Action action2 = jSONObject2 != null ? (Action) jSONObject2.toJavaObject(Action.class) : null;
                            String string7 = jSONObject.getString("text");
                            if (!(action2 == null || (trackInfo3 = action2.getTrackInfo()) == null)) {
                                trackInfo3.setSpma(str2);
                                trackInfo3.setSpmb(str);
                                ur2 ur29 = ur2.INSTANCE;
                            }
                            ((GenericHeaderView) getView()).renderBtnOne(string7, action2);
                            ((GenericHeaderView) getView()).hideBtnTwo();
                            String string8 = jSONObject.getString(OneArchConstants.LayoutKey.SHOW_INDICATOR);
                            if (string8 != null) {
                                bool = Boolean.valueOf(string8.equals("true"));
                            }
                            if (bool == null) {
                                ((GenericHeaderView) getView()).hideRightArrow();
                            } else if (bool.booleanValue()) {
                                ((GenericHeaderView) getView()).showRightArrow();
                            } else {
                                ((GenericHeaderView) getView()).hideRightArrow();
                            }
                        } else if (jSONArray.size() == 2) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("action");
                            Action action3 = jSONObject4 != null ? (Action) jSONObject4.toJavaObject(Action.class) : null;
                            String string9 = jSONObject3.getString("text");
                            if (!(action3 == null || (trackInfo2 = action3.getTrackInfo()) == null)) {
                                trackInfo2.setSpma(str2);
                                trackInfo2.setSpmb(str);
                                ur2 ur210 = ur2.INSTANCE;
                            }
                            ((GenericHeaderView) getView()).renderBtnOne(string9, action3);
                            JSONObject jSONObject5 = jSONArray.getJSONObject(1);
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("action");
                            if (jSONObject6 != null) {
                                action = (Action) jSONObject6.toJavaObject(Action.class);
                            }
                            String string10 = jSONObject5.getString("text");
                            if (!(action == null || (trackInfo = action.getTrackInfo()) == null)) {
                                trackInfo.setSpma(str2);
                                trackInfo.setSpmb(str);
                                ur2 ur211 = ur2.INSTANCE;
                            }
                            ((GenericHeaderView) getView()).renderBtnTwo(string10, action);
                        }
                        ur2 ur212 = ur2.INSTANCE;
                    }
                }
                str = null;
                str2 = null;
                if (jSONArray.size() != 1) {
                }
                ur2 ur2122 = ur2.INSTANCE;
            } else {
                ((GenericHeaderView) getView()).hideBtnOne();
                ((GenericHeaderView) getView()).hideBtnTwo();
                ((GenericHeaderView) getView()).hideRightArrow();
                ur2 ur213 = ur2.INSTANCE;
            }
            String string11 = data.getString(OneArchConstants.LayoutKey.HIDDEN_TITLE_RIGHT_BTN);
            if (string11 != null && string11.equals("true")) {
                ((GenericHeaderView) getView()).hideBtnOne();
                ((GenericHeaderView) getView()).hideBtnTwo();
                ((GenericHeaderView) getView()).hideRightArrow();
            }
            ur2 ur214 = ur2.INSTANCE;
        }
    }
}

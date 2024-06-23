package com.alient.onearch.adapter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b:\u0010;B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b:\u0010<B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010=\u001a\u00020\u0018¢\u0006\u0004\b:\u0010>J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u001a\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\b\u0010\u001d\u001a\u00020\u0018H\u0016R\u0016\u0010\u001e\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010&\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010'\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001fR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001fR\u0016\u00100\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010#R\u0016\u00101\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010#R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006@"}, d2 = {"Lcom/alient/onearch/adapter/widget/OneTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "loadAttribute", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", "isScroll", "setSelectedTab", "setUnSelectedTab", "Landroid/widget/ImageView;", "imageView", "Landroid/graphics/drawable/Drawable;", "drawable", "onLoadIndicatorBackgroundSuccess", "onLoadIndicatorBackgroundFail", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "titles", "", "selectPosition", "setTitles", OneArchConstants.LayoutKey.SHOW_INDICATOR, "hideIndicator", "getItemLayoutId", "selectedTabTextColor", "I", "normalTabTextColor", "", "selectedTabTextSize", UTConstant.Args.UT_SUCCESS_F, "normalTabTextSize", "selectedTextBackground", "normalTextBackground", "selectedIndicatorBackground", "", "selectedIndicatorBackgroundUrl", "Ljava/lang/String;", "getSelectedIndicatorBackgroundUrl", "()Ljava/lang/String;", "setSelectedIndicatorBackgroundUrl", "(Ljava/lang/String;)V", "indicatorType", "indicatorWidth", "indicatorHeight", "Z", "Lcom/alient/onearch/adapter/widget/OnSetTabSelectedCallback;", "onTabSelectedCallback", "Lcom/alient/onearch/adapter/widget/OnSetTabSelectedCallback;", "getOnTabSelectedCallback", "()Lcom/alient/onearch/adapter/widget/OnSetTabSelectedCallback;", "setOnTabSelectedCallback", "(Lcom/alient/onearch/adapter/widget/OnSetTabSelectedCallback;)V", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class OneTabLayout extends TabLayout {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int INDICATOR_TYPE_IMAGE = 1;
    public static final int INDICATOR_TYPE_LOTTIE = 2;
    public static final int INDICATOR_TYPE_NONE = 0;
    private float indicatorHeight;
    private int indicatorType = 1;
    private float indicatorWidth;
    private int normalTabTextColor;
    private float normalTabTextSize;
    private int normalTextBackground;
    @Nullable
    private OnSetTabSelectedCallback onTabSelectedCallback;
    private int selectedIndicatorBackground;
    @Nullable
    private String selectedIndicatorBackgroundUrl;
    private int selectedTabTextColor;
    private float selectedTabTextSize;
    private int selectedTextBackground;
    private boolean showIndicator = true;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/widget/OneTabLayout$Companion;", "", "", "INDICATOR_TYPE_IMAGE", "I", "INDICATOR_TYPE_LOTTIE", "INDICATOR_TYPE_NONE", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneTabLayout(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        init(context, null);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        loadAttribute(context, attributeSet);
        addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new OneTabLayout$init$1(this));
    }

    private final void loadAttribute(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.OneTabLayout);
            this.selectedTabTextColor = typedArray.getColor(R.styleable.OneTabLayout_selectedTextColor, -16777216);
            this.normalTabTextColor = typedArray.getColor(R.styleable.OneTabLayout_normalTextColor, -7829368);
            this.normalTabTextSize = (float) typedArray.getInteger(R.styleable.OneTabLayout_normalTextSize, 15);
            this.selectedTabTextSize = (float) typedArray.getInteger(R.styleable.OneTabLayout_selectedTextSize, 18);
            this.selectedTextBackground = typedArray.getResourceId(R.styleable.OneTabLayout_selectedTextBackground, 0);
            this.normalTextBackground = typedArray.getResourceId(R.styleable.OneTabLayout_normalTextBackground, 0);
            this.indicatorType = typedArray.getInteger(R.styleable.OneTabLayout_indicatorType, 1);
            this.selectedIndicatorBackground = typedArray.getResourceId(R.styleable.OneTabLayout_selectedIndicatorBackground, 0);
            this.indicatorWidth = typedArray.getDimension(R.styleable.OneTabLayout_indicatorWidth, -1.0f);
            this.indicatorHeight = typedArray.getDimension(R.styleable.OneTabLayout_indicatorHeight, -1.0f);
        } catch (Exception e) {
            e.printStackTrace();
            if (typedArray == null) {
                return;
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
        typedArray.recycle();
    }

    public int getItemLayoutId() {
        return R.layout.onearch_tab_layout_item;
    }

    @Nullable
    public final OnSetTabSelectedCallback getOnTabSelectedCallback() {
        return this.onTabSelectedCallback;
    }

    @Nullable
    public final String getSelectedIndicatorBackgroundUrl() {
        return this.selectedIndicatorBackgroundUrl;
    }

    public final void hideIndicator() {
        this.showIndicator = false;
    }

    public void onLoadIndicatorBackgroundFail(@NotNull ImageView imageView) {
        k21.i(imageView, "imageView");
        imageView.setVisibility(8);
    }

    public void onLoadIndicatorBackgroundSuccess(@NotNull ImageView imageView, @NotNull Drawable drawable) {
        k21.i(imageView, "imageView");
        k21.i(drawable, "drawable");
        imageView.setImageDrawable(drawable);
    }

    public final void setOnTabSelectedCallback(@Nullable OnSetTabSelectedCallback onSetTabSelectedCallback) {
        this.onTabSelectedCallback = onSetTabSelectedCallback;
    }

    public final void setSelectedIndicatorBackgroundUrl(@Nullable String str) {
        this.selectedIndicatorBackgroundUrl = str;
    }

    public void setSelectedTab(@NotNull TabLayout.Tab tab, boolean z) {
        k21.i(tab, "tab");
        View customView = tab.getCustomView();
        if (customView != null) {
            TextView textView = (TextView) customView.findViewById(R.id.tab_text);
            k21.h(textView, "tabText");
            TextPaint paint = textView.getPaint();
            k21.h(paint, "paint");
            boolean z2 = true;
            paint.setFakeBoldText(true);
            textView.setTextColor(this.selectedTabTextColor);
            textView.setTextSize(1, this.selectedTabTextSize);
            textView.setBackgroundResource(this.selectedTextBackground);
            TextView textView2 = (TextView) customView.findViewById(R.id.bubble);
            if (textView2 != null) {
                textView2.setTextColor(this.selectedTabTextColor);
            }
            if (this.showIndicator) {
                int i = this.indicatorType;
                if (i == 1) {
                    ImageView imageView = (ImageView) customView.findViewById(R.id.tab_indicator);
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        String str = this.selectedIndicatorBackgroundUrl;
                        if (!(str == null || str.length() == 0)) {
                            z2 = false;
                        }
                        if (z2) {
                            imageView.setBackgroundResource(this.selectedIndicatorBackground);
                        } else {
                            ImageLoaderProviderProxy.getProxy().load(this.selectedIndicatorBackgroundUrl, new OneTabLayout$setSelectedTab$$inlined$apply$lambda$1(imageView, this), new OneTabLayout$setSelectedTab$$inlined$apply$lambda$2(imageView, this));
                        }
                    }
                } else if (i != 2) {
                    View findViewById = customView.findViewById(R.id.tab_indicator);
                    if (findViewById != null) {
                        findViewById.setVisibility(4);
                    }
                    View findViewById2 = customView.findViewById(R.id.tab_indicator_lottie);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(4);
                    }
                } else {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) customView.findViewById(R.id.tab_indicator_lottie);
                    if (!(lottieAnimationView == null || this.selectedIndicatorBackground == -1)) {
                        lottieAnimationView.setVisibility(0);
                        lottieAnimationView.setAnimation(this.selectedIndicatorBackground);
                        lottieAnimationView.setRepeatCount(1);
                        lottieAnimationView.playAnimation();
                    }
                }
            }
        }
        OnSetTabSelectedCallback onSetTabSelectedCallback = this.onTabSelectedCallback;
        if (onSetTabSelectedCallback != null) {
            onSetTabSelectedCallback.onSetTabSelected(this, tab, z);
        }
    }

    public final void setTitles(@NotNull List<RichTitle> list, int i) {
        ImageView imageView;
        k21.i(list, "titles");
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                m.p();
            }
            T t2 = t;
            TabLayout.Tab newTab = newTab();
            k21.h(newTab, "newTab()");
            newTab.setCustomView(getItemLayoutId());
            View customView = newTab.getCustomView();
            if (customView != null) {
                TextView textView = (TextView) customView.findViewById(R.id.tab_text);
                if (textView != null) {
                    textView.setText(t2.getText());
                }
                TextView textView2 = (TextView) customView.findViewById(R.id.bubble);
                TextView textView3 = (TextView) customView.findViewById(R.id.rich_bubble);
                if (t2.getBubbleBgResId() <= 0) {
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    if (textView2 != null) {
                        textView2.setText(t2.getBubble());
                    }
                } else {
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    if (textView3 != null) {
                        textView3.setText(t2.getBubble());
                    }
                    if (textView3 != null) {
                        textView3.setBackgroundResource(t2.getBubbleBgResId());
                    }
                }
                float f = (float) 0;
                if (this.indicatorWidth > f && this.indicatorHeight > f && (imageView = (ImageView) customView.findViewById(R.id.tab_indicator)) != null) {
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = (int) this.indicatorWidth;
                    layoutParams.height = (int) this.indicatorHeight;
                    imageView.setLayoutParams(layoutParams);
                }
                LottieAnimationView lottieAnimationView = (LottieAnimationView) customView.findViewById(R.id.tab_icon_lottie);
                String iconUrl = t2.getIconUrl();
                if (!(iconUrl == null || iconUrl.length() == 0)) {
                    if (lottieAnimationView != null) {
                        lottieAnimationView.setVisibility(0);
                    }
                    Integer iconType = t2.getIconType();
                    if (iconType != null && iconType.intValue() == 1) {
                        if (lottieAnimationView != null) {
                            lottieAnimationView.setAnimationFromUrl(t2.getIconUrl());
                        }
                        if (lottieAnimationView != null) {
                            lottieAnimationView.setRepeatCount(-1);
                        }
                        if (lottieAnimationView != null) {
                            lottieAnimationView.playAnimation();
                        }
                    } else {
                        ImageLoaderProviderProxy.getProxy().load(t2.getIconUrl(), new OneTabLayout$setTitles$1$1$2(lottieAnimationView), new OneTabLayout$setTitles$1$1$3(lottieAnimationView));
                    }
                } else if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(8);
                }
            }
            addTab(newTab, false);
            if (i2 == i) {
                setSelectedTab(newTab, false);
            } else {
                setUnSelectedTab(newTab, false);
            }
            i2 = i3;
        }
    }

    public void setUnSelectedTab(@NotNull TabLayout.Tab tab, boolean z) {
        k21.i(tab, "tab");
        View customView = tab.getCustomView();
        if (customView != null) {
            TextView textView = (TextView) customView.findViewById(R.id.tab_text);
            textView.setTextColor(this.normalTabTextColor);
            textView.setTextSize(1, this.normalTabTextSize);
            k21.h(textView, "tabText");
            TextPaint paint = textView.getPaint();
            k21.h(paint, "paint");
            paint.setFakeBoldText(false);
            textView.setBackgroundResource(this.normalTextBackground);
            TextView textView2 = (TextView) customView.findViewById(R.id.bubble);
            if (textView2 != null) {
                textView2.setTextColor(this.normalTabTextColor);
            }
            View findViewById = customView.findViewById(R.id.tab_indicator);
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            View findViewById2 = customView.findViewById(R.id.tab_indicator_lottie);
            if (findViewById2 != null) {
                findViewById2.setVisibility(4);
            }
        }
    }

    public final void showIndicator() {
        this.showIndicator = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        init(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        init(context, attributeSet);
    }
}

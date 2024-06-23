package com.youku.arch.v3.style;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.token.TokenManager;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.DimenUtil;
import com.youku.arch.v3.util.DisplayUtils;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bJ*\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u000b¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/style/StyleUtil;", "", "Lcom/youku/arch/v3/style/Style;", "style", "", "tokenKey", "", "hasStyle", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "styleKey", "", "defaultColorRes", "getColor", "defaultDimenRes", "getDimen", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class StyleUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final StyleUtil INSTANCE = new StyleUtil();

    private StyleUtil() {
    }

    public final int getColor(@NotNull Context context, @Nullable Style style, @NotNull String str, @ColorRes int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1073491905")) {
            return ((Integer) ipChange.ipc$dispatch("1073491905", new Object[]{this, context, style, str, Integer.valueOf(i)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "styleKey");
        Integer num = null;
        Object styleValue = style == null ? null : style.getStyleValue(str);
        if (!(styleValue instanceof String)) {
            Integer colorToken = TokenManager.Companion.getInstance().getColorToken(context, str);
            if (colorToken != null) {
                i2 = colorToken.intValue();
                num = colorToken;
            }
            if (num == null) {
                return context.getResources().getColor(i);
            }
        } else if (o.L(str, "$", false, 2, null)) {
            return ColorUtil.parseColorSafely((String) styleValue);
        } else {
            String str2 = (String) styleValue;
            if (!(o.L(str2, "$", false, 2, null))) {
                return ColorUtil.parseColorSafely(str2);
            }
            Integer colorToken2 = TokenManager.Companion.getInstance().getColorToken(context, str2);
            if (colorToken2 != null) {
                i2 = colorToken2.intValue();
                num = colorToken2;
            }
            if (num == null) {
                return context.getResources().getColor(i);
            }
        }
        return i2;
    }

    public final int getDimen(@NotNull Context context, @Nullable Style style, @NotNull String str, @DimenRes int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-408723697")) {
            return ((Integer) ipChange.ipc$dispatch("-408723697", new Object[]{this, context, style, str, Integer.valueOf(i)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "styleKey");
        Integer num = null;
        Object styleValue = style == null ? null : style.getStyleValue(str);
        if (!(styleValue instanceof String)) {
            Integer dimenToken = TokenManager.Companion.getInstance().getDimenToken(context, str);
            if (dimenToken != null) {
                i2 = dimenToken.intValue();
                num = dimenToken;
            }
            if (num == null) {
                return DimenUtil.getDimensionPixelSize(context, i);
            }
        } else if (o.L(str, "$", false, 2, null)) {
            return DisplayUtils.dp2px(Integer.parseInt((String) styleValue));
        } else {
            String str2 = (String) styleValue;
            if (!(o.L(str2, "$", false, 2, null))) {
                return DisplayUtils.dp2px(Integer.parseInt(str2));
            }
            Integer dimenToken2 = TokenManager.Companion.getInstance().getDimenToken(context, str2);
            if (dimenToken2 != null) {
                i2 = dimenToken2.intValue();
                num = dimenToken2;
            }
            if (num == null) {
                return DimenUtil.getDimensionPixelSize(context, i);
            }
        }
        return i2;
    }

    public final boolean hasStyle(@Nullable Style style, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671275461")) {
            return ((Boolean) ipChange.ipc$dispatch("-1671275461", new Object[]{this, style, str})).booleanValue();
        }
        k21.i(str, "tokenKey");
        return (style == null ? null : style.getStyleValue(str)) instanceof String;
    }
}

package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a;\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"", "T", "Landroid/content/Context;", "getSystemService", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/util/AttributeSet;", "set", "", TemplateDom.KEY_ATTRS, "", "defStyleAttr", "defStyleRes", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Ltb/ur2;", "Lkotlin/ExtensionFunctionType;", "block", "withStyledAttributes", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        k21.i(context, "$this$getSystemService");
        k21.o(4, "T");
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull int[] iArr, @AttrRes int i, @StyleRes int i2, @NotNull Function1<? super TypedArray, ur2> function1) {
        k21.i(context, "$this$withStyledAttributes");
        k21.i(iArr, TemplateDom.KEY_ATTRS);
        k21.i(function1, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        k21.h(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        k21.i(context, "$this$withStyledAttributes");
        k21.i(iArr, TemplateDom.KEY_ATTRS);
        k21.i(function1, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        k21.h(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@NotNull Context context, @StyleRes int i, @NotNull int[] iArr, @NotNull Function1<? super TypedArray, ur2> function1) {
        k21.i(context, "$this$withStyledAttributes");
        k21.i(iArr, TemplateDom.KEY_ATTRS);
        k21.i(function1, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        k21.h(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}

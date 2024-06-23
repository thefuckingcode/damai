package org.jetbrains.anko;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\"\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014H\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014H\b\u001a\u001a\u0010\u0015\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017\u001a+\u0010\u0015\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u001b\"\u00020\u0017¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\b\u001a.\u0010\u001d\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u001b\"\u00020\u0017H\b¢\u0006\u0002\u0010\u001c\u001a\u0015\u0010\u001e\u001a\u00020\u001f*\u00020\u00022\u0006\u0010 \u001a\u00020!H\b\u001a#\u0010\"\u001a\u00020#*\u00020\u00022\u0014\b\u0004\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130\u0012H\b\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00022\u0006\u0010 \u001a\u00020!H\b\u001a\u0015\u0010(\u001a\u00020)*\u00020\u00022\u0006\u0010*\u001a\u00020+H\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0016\u0010\u0007\u001a\u00020\b*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\f*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006,"}, d2 = {"Bold", "Landroid/text/style/StyleSpan;", "Landroid/text/SpannableStringBuilder;", "getBold", "(Landroid/text/SpannableStringBuilder;)Landroid/text/style/StyleSpan;", "Italic", "getItalic", "Strikethrough", "Landroid/text/style/StrikethroughSpan;", "getStrikethrough", "(Landroid/text/SpannableStringBuilder;)Landroid/text/style/StrikethroughSpan;", "Underline", "Landroid/text/style/UnderlineSpan;", "getUnderline", "(Landroid/text/SpannableStringBuilder;)Landroid/text/style/UnderlineSpan;", "buildSpanned", "Landroid/text/Spanned;", "f", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "append", "span", "", "text", "", "spans", "", "(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;[Ljava/lang/Object;)V", "appendln", "backgroundColor", "Landroid/text/style/BackgroundColorSpan;", "color", "", "clickable", "Landroid/text/style/ClickableSpan;", "onClick", "Landroid/view/View;", "foregroundColor", "Landroid/text/style/ForegroundColorSpan;", "link", "Landroid/text/style/URLSpan;", "url", "", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: buildSpanned.kt */
public final class BuildSpannedKt {
    public static final Spanned buildSpanned(Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        function1.invoke(spannableStringBuilder);
        return spannableStringBuilder;
    }

    public static final StyleSpan getBold(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        return new StyleSpan(1);
    }

    public static final StyleSpan getItalic(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        return new StyleSpan(2);
    }

    public static final UnderlineSpan getUnderline(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        return new UnderlineSpan();
    }

    public static final StrikethroughSpan getStrikethrough(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        return new StrikethroughSpan();
    }

    public static final ForegroundColorSpan foregroundColor(SpannableStringBuilder spannableStringBuilder, int i) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        return new ForegroundColorSpan(i);
    }

    public static final BackgroundColorSpan backgroundColor(SpannableStringBuilder spannableStringBuilder, int i) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        return new BackgroundColorSpan(i);
    }

    public static final ClickableSpan clickable(SpannableStringBuilder spannableStringBuilder, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onClick");
        return new BuildSpannedKt$clickable$1(function1);
    }

    public static final URLSpan link(SpannableStringBuilder spannableStringBuilder, String str) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return new URLSpan(str);
    }

    public static final void append(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(objArr, "spans");
        int length = charSequence.length();
        spannableStringBuilder.append(charSequence);
        for (Object obj : objArr) {
            spannableStringBuilder.setSpan(obj, spannableStringBuilder.length() - length, spannableStringBuilder.length(), 17);
        }
    }

    public static final void append(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        int length = charSequence.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, spannableStringBuilder.length() - length, spannableStringBuilder.length(), 17);
    }

    public static final SpannableStringBuilder append(SpannableStringBuilder spannableStringBuilder, Object obj, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final void appendln(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(objArr, "spans");
        append(spannableStringBuilder, charSequence, Arrays.copyOf(objArr, objArr.length));
        StringsKt.appendln(spannableStringBuilder);
    }

    public static final void appendln(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        append(spannableStringBuilder, charSequence, obj);
        StringsKt.appendln(spannableStringBuilder);
    }
}

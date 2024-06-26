package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\b\u001a\u0017\u0010\n\u001a\u00020\u0000*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0001H\b¨\u0006\u000b"}, d2 = {"", "", Constants.KEY_FLAGS, "Landroid/text/Html$ImageGetter;", "imageGetter", "Landroid/text/Html$TagHandler;", "tagHandler", "Landroid/text/Spanned;", "parseAsHtml", "option", "toHtml", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class HtmlKt {
    @NotNull
    public static final Spanned parseAsHtml(@NotNull String str, int i, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        k21.i(str, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        k21.h(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        k21.i(str, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        k21.h(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned spanned, int i) {
        k21.i(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i);
        k21.h(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        k21.i(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i);
        k21.h(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}

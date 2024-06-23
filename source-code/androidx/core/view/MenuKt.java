package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.gl1;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\n\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0000H\b\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\b\u001a3\u0010\u0010\u001a\u00020\b*\u00020\u00002!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\fH\bø\u0001\u0000\u001aH\u0010\u0012\u001a\u00020\b*\u00020\u000026\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u0011H\bø\u0001\u0000\u001a\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013*\u00020\u0000H\u0002\"\u0018\u0010\u0017\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001c"}, d2 = {"Landroid/view/Menu;", "", "index", "Landroid/view/MenuItem;", gl1.TYPE_OPEN_URL_METHOD_GET, "item", "", "contains", "Ltb/ur2;", "minusAssign", "isEmpty", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/Function2;", "forEachIndexed", "", "iterator", "getSize", "(Landroid/view/Menu;)I", "size", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", RichTextNode.CHILDREN, "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class MenuKt {
    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        k21.i(menu, "$this$contains");
        k21.i(menuItem, "item");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (k21.d(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull Function1<? super MenuItem, ur2> function1) {
        k21.i(menu, "$this$forEach");
        k21.i(function1, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            k21.h(item, "getItem(index)");
            function1.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull Function2<? super Integer, ? super MenuItem, ur2> function2) {
        k21.i(menu, "$this$forEachIndexed");
        k21.i(function2, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            k21.h(item, "getItem(index)");
            function2.invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i) {
        k21.i(menu, "$this$get");
        MenuItem item = menu.getItem(i);
        k21.h(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final Sequence<MenuItem> getChildren(@NotNull Menu menu) {
        k21.i(menu, "$this$children");
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(@NotNull Menu menu) {
        k21.i(menu, "$this$size");
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        k21.i(menu, "$this$isEmpty");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        k21.i(menu, "$this$isNotEmpty");
        return menu.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu menu) {
        k21.i(menu, "$this$iterator");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        k21.i(menu, "$this$minusAssign");
        k21.i(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}

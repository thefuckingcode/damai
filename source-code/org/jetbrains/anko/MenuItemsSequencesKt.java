package org.jetbrains.anko;

import android.view.Menu;
import android.view.MenuItem;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"itemsSequence", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: menuItemsSequences.kt */
public final class MenuItemsSequencesKt {
    @Deprecated(message = "Use the Android KTX version", replaceWith = @ReplaceWith(expression = "children", imports = {"androidx.core.view.children"}))
    public static final Sequence<MenuItem> itemsSequence(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$receiver");
        return new MenuItemsSequence(menu);
    }
}

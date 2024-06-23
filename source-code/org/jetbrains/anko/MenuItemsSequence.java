package org.jetbrains.anko;

import android.view.Menu;
import android.view.MenuItem;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lorg/jetbrains/anko/MenuItemsSequence;", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "menu", "Landroid/view/Menu;", "(Landroid/view/Menu;)V", "iterator", "", "MenuItemIterator", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: menuItemsSequences.kt */
final class MenuItemsSequence implements Sequence<MenuItem> {
    private final Menu menu;

    public MenuItemsSequence(Menu menu2) {
        Intrinsics.checkParameterIsNotNull(menu2, "menu");
        this.menu = menu2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<MenuItem> iterator() {
        return new MenuItemIterator(this.menu);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lorg/jetbrains/anko/MenuItemsSequence$MenuItemIterator;", "", "Landroid/view/MenuItem;", "menu", "Landroid/view/Menu;", "(Landroid/view/Menu;)V", "count", "", "index", "hasNext", "", "next", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: menuItemsSequences.kt */
    private static final class MenuItemIterator implements Iterator<MenuItem>, KMappedMarker {
        private final int count;
        private int index;
        private final Menu menu;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public MenuItemIterator(Menu menu2) {
            Intrinsics.checkParameterIsNotNull(menu2, "menu");
            this.menu = menu2;
            this.count = menu2.size();
        }

        @Override // java.util.Iterator
        public MenuItem next() {
            if (hasNext()) {
                Menu menu2 = this.menu;
                int i = this.index;
                this.index = i + 1;
                MenuItem item = menu2.getItem(i);
                Intrinsics.checkExpressionValueIsNotNull(item, "menu.getItem(index++)");
                return item;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.count == this.menu.size()) {
                return this.index < this.count;
            }
            throw new ConcurrentModificationException();
        }
    }
}

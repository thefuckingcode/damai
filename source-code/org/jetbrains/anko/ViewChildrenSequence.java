package org.jetbrains.anko;

import android.view.View;
import android.view.ViewGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lorg/jetbrains/anko/ViewChildrenSequence;", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "iterator", "", "ViewIterator", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: viewChildrenSequences.kt */
public final class ViewChildrenSequence implements Sequence<View> {
    private final View view;

    public ViewChildrenSequence(View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<View> iterator() {
        View view2 = this.view;
        if (!(view2 instanceof ViewGroup)) {
            return CollectionsKt.emptyList().iterator();
        }
        return new ViewIterator((ViewGroup) view2);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lorg/jetbrains/anko/ViewChildrenSequence$ViewIterator;", "", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "count", "", "index", "checkCount", "", "hasNext", "", "next", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: viewChildrenSequences.kt */
    private static final class ViewIterator implements Iterator<View>, KMappedMarker {
        private final int count;
        private int index;
        private final ViewGroup view;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public ViewIterator(ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "view");
            this.view = viewGroup;
            this.count = viewGroup.getChildCount();
        }

        @Override // java.util.Iterator
        public View next() {
            if (hasNext()) {
                ViewGroup viewGroup = this.view;
                int i = this.index;
                this.index = i + 1;
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "view.getChildAt(index++)");
                return childAt;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            checkCount();
            return this.index < this.count;
        }

        private final void checkCount() {
            if (this.count != this.view.getChildCount()) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

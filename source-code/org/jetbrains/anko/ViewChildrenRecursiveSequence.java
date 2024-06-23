package org.jetbrains.anko;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lorg/jetbrains/anko/ViewChildrenRecursiveSequence;", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "iterator", "", "RecursiveViewIterator", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: viewChildrenSequences.kt */
final class ViewChildrenRecursiveSequence implements Sequence<View> {
    private final View view;

    public ViewChildrenRecursiveSequence(View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<View> iterator() {
        View view2 = this.view;
        if (!(view2 instanceof ViewGroup)) {
            return CollectionsKt.emptyList().iterator();
        }
        return new RecursiveViewIterator(view2);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u000bH\u0002J\t\u0010\f\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u0010H\b¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lorg/jetbrains/anko/ViewChildrenRecursiveSequence$RecursiveViewIterator;", "", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "current", "sequences", "Ljava/util/ArrayList;", "Lkotlin/sequences/Sequence;", "Lkotlin/collections/ArrayList;", "hasNext", "", "next", "removeLast", "T", "", "", "(Ljava/util/List;)Ljava/lang/Object;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: viewChildrenSequences.kt */
    private static final class RecursiveViewIterator implements Iterator<View>, KMappedMarker {
        private Iterator<? extends View> current;
        private final ArrayList<Sequence<View>> sequences;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public RecursiveViewIterator(View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            ArrayList<Sequence<View>> arrayListOf = CollectionsKt.arrayListOf(ViewChildrenSequencesKt.childrenSequence(view));
            this.sequences = arrayListOf;
            ArrayList<Sequence<View>> arrayList = arrayListOf;
            if (!arrayList.isEmpty()) {
                this.current = arrayList.remove(arrayList.size() - 1).iterator();
                return;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public View next() {
            if (hasNext()) {
                View view = (View) this.current.next();
                if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                    this.sequences.add(ViewChildrenSequencesKt.childrenSequence(view));
                }
                return view;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (!this.current.hasNext() && (!this.sequences.isEmpty())) {
                ArrayList<Sequence<View>> arrayList = this.sequences;
                if (!arrayList.isEmpty()) {
                    this.current = arrayList.remove(arrayList.size() - 1).iterator();
                } else {
                    throw new NoSuchElementException();
                }
            }
            return this.current.hasNext();
        }

        private final <T> T removeLast(List<T> list) {
            if (!list.isEmpty()) {
                return list.remove(list.size() - 1);
            }
            throw new NoSuchElementException();
        }
    }
}

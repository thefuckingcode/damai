package io.reactivex.rxkotlin;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"io/reactivex/rxkotlin/FlowableKt$toIterable$1", "", "iterator", "", "rxkotlin"}, k = 1, mv = {1, 1, 11})
/* compiled from: flowable.kt */
public final class FlowableKt$toIterable$1 implements Iterable<T>, KMappedMarker {
    final /* synthetic */ Iterator receiver$0;

    FlowableKt$toIterable$1(Iterator<? extends T> it) {
        this.receiver$0 = it;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.receiver$0;
    }
}

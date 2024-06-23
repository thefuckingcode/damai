package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.b;
import io.reactivex.d;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* compiled from: Taobao */
public final class SingleInternalHelper {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum ToFlowable implements Function<SingleSource, Publisher> {
        INSTANCE;

        public Publisher apply(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    /* compiled from: Taobao */
    static final class ToFlowableIterable<T> implements Iterable<b<T>> {
        private final Iterable<? extends SingleSource<? extends T>> sources;

        ToFlowableIterable(Iterable<? extends SingleSource<? extends T>> iterable) {
            this.sources = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<b<T>> iterator() {
            return new ToFlowableIterator(this.sources.iterator());
        }
    }

    /* compiled from: Taobao */
    static final class ToFlowableIterator<T> implements Iterator<b<T>> {
        private final Iterator<? extends SingleSource<? extends T>> sit;

        ToFlowableIterator(Iterator<? extends SingleSource<? extends T>> it) {
            this.sit = it;
        }

        public boolean hasNext() {
            return this.sit.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public b<T> next() {
            return new SingleToFlowable((SingleSource) this.sit.next());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum ToObservable implements Function<SingleSource, d> {
        INSTANCE;

        public d apply(SingleSource singleSource) {
            return new SingleToObservable(singleSource);
        }
    }

    private SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> emptyThrower() {
        return NoSuchElementCallable.INSTANCE;
    }

    public static <T> Iterable<? extends b<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> iterable) {
        return new ToFlowableIterable(iterable);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable() {
        return ToFlowable.INSTANCE;
    }

    public static <T> Function<SingleSource<? extends T>, d<? extends T>> toObservable() {
        return ToObservable.INSTANCE;
    }
}

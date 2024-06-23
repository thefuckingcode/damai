package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    /* compiled from: Taobao */
    abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
        final /* synthetic */ CollectionFuture this$0;
        private List<Optional<V>> values;

        CollectionFutureRunningState(CollectionFuture collectionFuture, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z, true);
            List<Optional<V>> list;
            if (immutableCollection.isEmpty()) {
                list = ImmutableList.of();
            } else {
                list = Lists.l(immutableCollection.size());
            }
            this.values = list;
            for (int i = 0; i < immutableCollection.size(); i++) {
                this.values.add(null);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void collectOneValue(boolean z, int i, @NullableDecl V v) {
            List<Optional<V>> list = this.values;
            if (list != null) {
                list.set(i, Optional.fromNullable(v));
            } else if (z) {
                ds1.x(true, "Future was done before all dependencies completed");
            } else {
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract C combine(List<Optional<V>> list);

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void handleAllCompleted() {
            List<Optional<V>> list = this.values;
            Objects.requireNonNull(list);
            combine(list);
            throw null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.values = null;
        }
    }

    /* compiled from: Taobao */
    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {

        /* compiled from: Taobao */
        private final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
            final /* synthetic */ ListFuture this$0;

            ListFutureRunningState(ListFuture listFuture, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
                super(listFuture, immutableCollection, z);
            }

            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            public List<V> combine(List<Optional<V>> list) {
                ArrayList l = Lists.l(list.size());
                Iterator<Optional<V>> it = list.iterator();
                while (it.hasNext()) {
                    Optional<V> next = it.next();
                    l.add(next != null ? next.orNull() : null);
                }
                return Collections.unmodifiableList(l);
            }
        }
    }
}

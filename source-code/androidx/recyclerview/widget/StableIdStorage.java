package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface StableIdStorage {

    /* compiled from: Taobao */
    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        /* compiled from: Taobao */
        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                Long l = this.mLocalToGlobalLookup.get(j);
                if (l == null) {
                    l = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j, l);
                }
                return l.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        /* access modifiers changed from: package-private */
        public long obtainId() {
            long j = this.mNextStableId;
            this.mNextStableId = 1 + j;
            return j;
        }
    }

    /* compiled from: Taobao */
    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new StableIdLookup() {
            /* class androidx.recyclerview.widget.StableIdStorage.NoStableIdStorage.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return -1;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    /* compiled from: Taobao */
    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new StableIdLookup() {
            /* class androidx.recyclerview.widget.StableIdStorage.SharedPoolStableIdStorage.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return j;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    /* compiled from: Taobao */
    public interface StableIdLookup {
        long localToGlobal(long j);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}

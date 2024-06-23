package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
@Beta
@GwtCompatible
/* compiled from: Taobao */
public final class SortedLists {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum KeyAbsentBehavior {
        NEXT_LOWER {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i) {
                return i - 1;
            }
        },
        NEXT_HIGHER {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i) {
                return i;
            }
        },
        INVERTED_INSERTION_INDEX {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i) {
                return ~i;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int resultIndex(int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum KeyPresentBehavior {
        ANY_PRESENT {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return i;
            }
        },
        LAST_PRESENT {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare((Object) list.get(i2), e) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        },
        FIRST_PRESENT {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare((Object) list.get(i3), e) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_AFTER {
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e, list, i) + 1;
            }
        },
        LAST_BEFORE {
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e, list, i) - 1;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i);
    }

    public static <E, K extends Comparable> int a(List<E> list, Function<? super E, K> function, @NullableDecl K k, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return b(list, function, k, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, Function<? super E, K> function, @NullableDecl K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.o(list, function), k, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int c(List<? extends E> list, @NullableDecl E e, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        ds1.p(comparator);
        ds1.p(list);
        ds1.p(keyPresentBehavior);
        ds1.p(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.j(list);
        }
        int i = 0;
        int size = list.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e, (Object) list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare <= 0) {
                return i + keyPresentBehavior.resultIndex(comparator, e, list.subList(i, size + 1), i2 - i);
            } else {
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i);
    }
}

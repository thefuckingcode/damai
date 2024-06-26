package com.youku.arch.v3.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Taobao */
public final class ListUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static final class FiveItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;
        private final E mItem4;

        public FiveItemImmutableList(E e, E e2, E e3, E e4, E e5) {
            this.mItem0 = e;
            this.mItem1 = e2;
            this.mItem2 = e3;
            this.mItem3 = e4;
            this.mItem4 = e5;
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1672944337")) {
                return (E) ipChange.ipc$dispatch("-1672944337", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return this.mItem0;
            } else {
                if (i == 1) {
                    return this.mItem1;
                }
                if (i == 2) {
                    return this.mItem2;
                }
                if (i == 3) {
                    return this.mItem3;
                }
                if (i == 4) {
                    return this.mItem4;
                }
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-820831834")) {
                return 5;
            }
            return ((Integer) ipChange.ipc$dispatch("-820831834", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static final class FourItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;

        public FourItemImmutableList(E e, E e2, E e3, E e4) {
            this.mItem0 = e;
            this.mItem1 = e2;
            this.mItem2 = e3;
            this.mItem3 = e4;
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2111315363")) {
                return (E) ipChange.ipc$dispatch("2111315363", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return this.mItem0;
            } else {
                if (i == 1) {
                    return this.mItem1;
                }
                if (i == 2) {
                    return this.mItem2;
                }
                if (i == 3) {
                    return this.mItem3;
                }
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-462644558")) {
                return 4;
            }
            return ((Integer) ipChange.ipc$dispatch("-462644558", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static final class ImmutableArrayList<E> extends AbstractList<E> implements ImmutableList<E> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final Object[] mArray;

        public ImmutableArrayList(Object[] objArr) {
            this.mArray = objArr;
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-990974987")) {
                return (E) this.mArray[i];
            }
            return (E) ipChange.ipc$dispatch("-990974987", new Object[]{this, Integer.valueOf(i)});
        }

        public int size() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1697491424")) {
                return this.mArray.length;
            }
            return ((Integer) ipChange.ipc$dispatch("-1697491424", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    private interface ImmutableList<E> extends List<E>, RandomAccess {
    }

    /* compiled from: Taobao */
    public static final class OneItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final E mItem;

        public OneItemImmutableList(E e) {
            this.mItem = e;
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1307049789")) {
                return (E) ipChange.ipc$dispatch("-1307049789", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return this.mItem;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "157389714")) {
                return 1;
            }
            return ((Integer) ipChange.ipc$dispatch("157389714", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static final class ThreeItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;

        public ThreeItemImmutableList(E e, E e2, E e3) {
            this.mItem0 = e;
            this.mItem1 = e2;
            this.mItem2 = e3;
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-459683845")) {
                return (E) ipChange.ipc$dispatch("-459683845", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return this.mItem0;
            } else {
                if (i == 1) {
                    return this.mItem1;
                }
                if (i == 2) {
                    return this.mItem2;
                }
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "467309914")) {
                return 3;
            }
            return ((Integer) ipChange.ipc$dispatch("467309914", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static final class TwoItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final E mItem0;
        private final E mItem1;

        public TwoItemImmutableList(E e, E e2) {
            this.mItem0 = e;
            this.mItem1 = e2;
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1930013783")) {
                return (E) ipChange.ipc$dispatch("-1930013783", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return this.mItem0;
            } else {
                if (i == 1) {
                    return this.mItem1;
                }
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-390447124")) {
                return 2;
            }
            return ((Integer) ipChange.ipc$dispatch("-390447124", new Object[]{this})).intValue();
        }
    }

    private ListUtil() {
    }

    public static <T> List<T> copyToImmutableList(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555525753")) {
            return (List) ipChange.ipc$dispatch("555525753", new Object[]{list});
        } else if (list instanceof ImmutableList) {
            return list;
        } else {
            int size = list.size();
            if (size == 0) {
                return Collections.emptyList();
            }
            if (size == 1) {
                return new OneItemImmutableList(list.get(0));
            }
            if (size == 2) {
                return new TwoItemImmutableList(list.get(0), list.get(1));
            }
            if (size == 3) {
                return new ThreeItemImmutableList(list.get(0), list.get(1), list.get(2));
            }
            if (size == 4) {
                return new FourItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3));
            }
            if (size != 5) {
                return new ImmutableArrayList(list.toArray());
            }
            return new FiveItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        }
    }

    public static <T> boolean identityEquals(List<? extends T> list, List<? extends T> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891471654")) {
            return ((Boolean) ipChange.ipc$dispatch("1891471654", new Object[]{list, list2})).booleanValue();
        } else if (list == list2) {
            return true;
        } else {
            int size = list.size();
            if (size != list2.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (list.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static <T> List<T> newImmutableList(T t) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1833470862")) {
            return new OneItemImmutableList(t);
        }
        return (List) ipChange.ipc$dispatch("1833470862", new Object[]{t});
    }
}

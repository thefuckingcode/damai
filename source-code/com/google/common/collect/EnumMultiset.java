package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class EnumMultiset<E extends Enum<E>> extends d<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    /* compiled from: Taobao */
    class a extends EnumMultiset<E>.c {
        a() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public E a(int i) {
            return (E) EnumMultiset.this.enumConstants[i];
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends EnumMultiset<E>.c {

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends Multisets.b<E> {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            /* renamed from: a */
            public E getElement() {
                return (E) EnumMultiset.this.enumConstants[this.a];
            }

            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                return EnumMultiset.this.counts[this.a];
            }
        }

        b() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Multiset.Entry<E> a(int i) {
            return new a(i);
        }
    }

    /* compiled from: Taobao */
    abstract class c<T> implements Iterator<T> {
        int a = 0;
        int b = -1;

        c() {
        }

        /* access modifiers changed from: package-private */
        public abstract T a(int i);

        public boolean hasNext() {
            while (this.a < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i = this.a;
                if (iArr[i] > 0) {
                    return true;
                }
                this.a = i + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a2 = a(this.a);
                int i = this.a;
                this.b = i;
                this.a = i + 1;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            k.e(this.b >= 0);
            if (EnumMultiset.this.counts[this.b] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.this.size -= (long) EnumMultiset.this.counts[this.b];
                EnumMultiset.this.counts[this.b] = 0;
            }
            this.b = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        ds1.d(cls.isEnum());
        E[] enumConstants2 = cls.getEnumConstants();
        this.enumConstants = enumConstants2;
        this.counts = new int[enumConstants2.length];
    }

    static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i - 1;
        return i;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(@NullableDecl Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        int ordinal = r5.ordinal();
        E[] eArr = this.enumConstants;
        if (ordinal >= eArr.length || eArr[ordinal] != r5) {
            return false;
        }
        return true;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants2 = cls.getEnumConstants();
        this.enumConstants = enumConstants2;
        this.counts = new int[enumConstants2.length];
        f0.f(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        f0.k(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    public void checkIsE(@NullableDecl Object obj) {
        ds1.p(obj);
        if (!isActuallyE(obj)) {
            throw new ClassCastException("Expected an " + this.type + " but got " + obj);
        }
    }

    @Override // com.google.common.collect.d
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public int distinctElements() {
        return this.distinctElements;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r1 = (Enum) obj;
        k.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = r1.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= (long) i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.size -= (long) i;
        }
        return i2;
    }

    @Override // com.google.common.collect.Multiset
    public int size() {
        return Ints.j(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        ds1.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        a0.a(enumMultiset, iterable);
        return enumMultiset;
    }

    @CanIgnoreReturnValue
    public int add(E e, int i) {
        checkIsE(e);
        k.b(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i2 = this.counts[ordinal];
        long j = (long) i;
        long j2 = ((long) i2) + j;
        ds1.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i2 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i2;
    }

    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        checkIsE(e);
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        int ordinal = e.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        iArr[ordinal] = i;
        this.size += (long) (i - i2);
        if (i2 == 0 && i > 0) {
            this.distinctElements++;
        } else if (i2 > 0 && i == 0) {
            this.distinctElements--;
        }
        return i2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        a0.a(create, iterable);
        return create;
    }
}

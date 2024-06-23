package tb;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;

/* compiled from: Taobao */
public class xr2 extends AbstractList<String> implements RandomAccess, LazyStringList {
    private final LazyStringList a;

    /* compiled from: Taobao */
    class a implements ListIterator<String> {
        ListIterator<String> a;
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
            this.a = xr2.this.a.listIterator(i);
        }

        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: b */
        public String next() {
            return this.a.next();
        }

        /* renamed from: c */
        public String previous() {
            return this.a.previous();
        }

        /* renamed from: d */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        public int nextIndex() {
            return this.a.nextIndex();
        }

        public int previousIndex() {
            return this.a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: Taobao */
    class b implements Iterator<String> {
        Iterator<String> a;

        b() {
            this.a = xr2.this.a.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.a.next();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public xr2(LazyStringList lazyStringList) {
        this.a = lazyStringList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public String get(int i) {
        return (String) this.a.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        return this.a.getByteString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.a.getUnderlyingElements();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    public int size() {
        return this.a.size();
    }
}

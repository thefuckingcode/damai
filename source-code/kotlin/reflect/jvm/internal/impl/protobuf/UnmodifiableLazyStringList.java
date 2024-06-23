package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements RandomAccess, LazyStringList {
    private final LazyStringList list;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    @Override // java.util.List, java.util.AbstractList
    public String get(int i) {
        return (String) this.list.get(i);
    }

    public int size() {
        return this.list.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<String> listIterator(int i) {
        return new ListIterator<String>(i) {
            /* class kotlin.reflect.jvm.internal.impl.protobuf.UnmodifiableLazyStringList.AnonymousClass1 */
            ListIterator<String> iter;
            final /* synthetic */ int val$index;

            {
                this.val$index = r2;
                this.iter = UnmodifiableLazyStringList.this.list.listIterator(r2);
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public String next() {
                return this.iter.next();
            }

            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            @Override // java.util.ListIterator
            public String previous() {
                return this.iter.previous();
            }

            public int nextIndex() {
                return this.iter.nextIndex();
            }

            public int previousIndex() {
                return this.iter.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            /* class kotlin.reflect.jvm.internal.impl.protobuf.UnmodifiableLazyStringList.AnonymousClass2 */
            Iterator<String> iter;

            {
                this.iter = UnmodifiableLazyStringList.this.list.iterator();
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return this.iter.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }
}

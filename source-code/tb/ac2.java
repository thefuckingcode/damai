package tb;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class ac2<E> extends AbstractList<E> implements RandomAccess {
    private int a;
    private Object b;

    /* compiled from: Taobao */
    private static class b<T> implements Iterator<T> {
        private static final b a = new b();

        private b() {
        }

        public static <T> b<T> a() {
            return a;
        }

        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* compiled from: Taobao */
    private class c extends d<E> {
        private final int b;

        public c() {
            super();
            this.b = ((AbstractList) ac2.this).modCount;
        }

        /* access modifiers changed from: protected */
        @Override // tb.ac2.d
        public void a() {
            if (((AbstractList) ac2.this).modCount != this.b) {
                throw new ConcurrentModificationException("ModCount: " + ((AbstractList) ac2.this).modCount + "; expected: " + this.b);
            }
        }

        /* access modifiers changed from: protected */
        @Override // tb.ac2.d
        public E b() {
            return (E) ac2.this.b;
        }

        public void remove() {
            a();
            ac2.this.clear();
        }
    }

    /* compiled from: Taobao */
    private static abstract class d<T> implements Iterator<T> {
        private boolean a;

        private d() {
        }

        /* access modifiers changed from: protected */
        public abstract void a();

        /* access modifiers changed from: protected */
        public abstract T b();

        public final boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.a) {
                this.a = true;
                a();
                return b();
            }
            throw new NoSuchElementException();
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        int i = this.a;
        if (i == 0) {
            this.b = e;
        } else if (i == 1) {
            this.b = new Object[]{this.b, e};
        } else {
            Object[] objArr = (Object[]) this.b;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.a] = e;
        }
        this.a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void clear() {
        this.b = null;
        this.a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.a)) {
            return i2 == 1 ? (E) this.b : (E) ((Object[]) this.b)[i];
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        int i = this.a;
        if (i == 0) {
            b a2 = b.a();
            if (a2 == null) {
                a(2);
            }
            return a2;
        } else if (i == 1) {
            return new c();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                a(3);
            }
            return it;
        }
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
        }
        if (i2 == 1) {
            e = (E) this.b;
            this.b = null;
        } else {
            Object[] objArr = (Object[]) this.b;
            Object obj = objArr[i];
            if (i2 == 2) {
                this.b = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.a - 1] = null;
            }
            e = (E) obj;
        }
        this.a--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
        } else if (i2 == 1) {
            E e2 = (E) this.b;
            this.b = e;
            return e2;
        } else {
            Object[] objArr = (Object[]) this.b;
            E e3 = (E) objArr[i];
            objArr[i] = e;
            return e3;
        }
    }

    public int size() {
        return this.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr == 0) {
            a(4);
        }
        int length = tArr.length;
        int i = this.a;
        if (i == 1) {
            if (length != 0) {
                tArr[0] = this.b;
            } else {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.b;
                return tArr2;
            }
        } else if (length < i) {
            T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.b, i, tArr.getClass());
            if (tArr3 == null) {
                a(6);
            }
            return tArr3;
        } else if (i != 0) {
            System.arraycopy(this.b, 0, tArr, 0, i);
        }
        int i2 = this.a;
        if (length > i2) {
            tArr[i2] = 0;
        }
        return tArr;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        int i2;
        if (i < 0 || i > (i2 = this.a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
        }
        if (i2 == 0) {
            this.b = e;
        } else if (i2 == 1 && i == 0) {
            this.b = new Object[]{e, this.b};
        } else {
            Object[] objArr = new Object[(i2 + 1)];
            if (i2 == 1) {
                objArr[0] = this.b;
            } else {
                Object[] objArr2 = (Object[]) this.b;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.a - i);
            }
            objArr[i] = e;
            this.b = objArr;
        }
        this.a++;
        ((AbstractList) this).modCount++;
    }
}

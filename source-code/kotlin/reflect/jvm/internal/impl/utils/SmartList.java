package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
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

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.mySize)) {
            return i2 == 1 ? (E) this.myElem : (E) ((Object[]) this.myElem)[i];
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        int i = this.mySize;
        if (i == 0) {
            this.myElem = e;
        } else if (i == 1) {
            this.myElem = new Object[]{this.myElem, e};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e;
        }
        this.mySize++;
        this.modCount++;
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        int i2;
        if (i < 0 || i > (i2 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        }
        if (i2 == 0) {
            this.myElem = e;
        } else if (i2 == 1 && i == 0) {
            this.myElem = new Object[]{e, this.myElem};
        } else {
            Object[] objArr = new Object[(i2 + 1)];
            if (i2 == 1) {
                objArr[0] = this.myElem;
            } else {
                Object[] objArr2 = (Object[]) this.myElem;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.mySize - i);
            }
            objArr[i] = e;
            this.myElem = objArr;
        }
        this.mySize++;
        this.modCount++;
    }

    public int size() {
        return this.mySize;
    }

    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        } else if (i2 == 1) {
            E e2 = (E) this.myElem;
            this.myElem = e;
            return e2;
        } else {
            Object[] objArr = (Object[]) this.myElem;
            E e3 = (E) objArr[i];
            objArr[i] = e;
            return e3;
        }
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        }
        if (i2 == 1) {
            e = (E) this.myElem;
            this.myElem = null;
        } else {
            Object[] objArr = (Object[]) this.myElem;
            Object obj = objArr[i];
            if (i2 == 2) {
                this.myElem = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.mySize - 1] = null;
            }
            e = (E) obj;
        }
        this.mySize--;
        this.modCount++;
        return e;
    }

    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<E> iterator() {
        int i = this.mySize;
        if (i == 0) {
            EmptyIterator instance = EmptyIterator.getInstance();
            if (instance == null) {
                $$$reportNull$$$0(2);
            }
            return instance;
        } else if (i == 1) {
            return new SingletonIterator();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                $$$reportNull$$$0(3);
            }
            return it;
        }
    }

    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        /* access modifiers changed from: protected */
        public abstract void checkCoModification();

        /* access modifiers changed from: protected */
        public abstract T getElement();

        private SingletonIteratorBase() {
        }

        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.myVisited) {
                this.myVisited = true;
                checkCoModification();
                return getElement();
            }
            throw new NoSuchElementException();
        }
    }

    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = SmartList.this.modCount;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public E getElement() {
            return (E) SmartList.this.myElem;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public void checkCoModification() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                throw new ConcurrentModificationException("ModCount: " + SmartList.this.modCount + "; expected: " + this.myInitialModCount);
            }
        }

        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v8, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            $$$reportNull$$$0(4);
        }
        int length = tArr.length;
        int i = this.mySize;
        if (i == 1) {
            if (length != 0) {
                tArr[0] = this.myElem;
            } else {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.myElem;
                if (tArr2 == 0) {
                    $$$reportNull$$$0(5);
                }
                return tArr2;
            }
        } else if (length < i) {
            T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.myElem, i, tArr.getClass());
            if (tArr3 == null) {
                $$$reportNull$$$0(6);
            }
            return tArr3;
        } else if (i != 0) {
            System.arraycopy(this.myElem, 0, tArr, 0, i);
        }
        int i2 = this.mySize;
        if (length > i2) {
            tArr[i2] = 0;
        }
        if (tArr == 0) {
            $$$reportNull$$$0(7);
        }
        return tArr;
    }
}

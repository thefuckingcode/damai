package kotlin.reflect.jvm.internal.pcollections;

/* access modifiers changed from: package-private */
public final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = new IntTreePMap<>(IntTree.EMPTYNODE);
    private final IntTree<V> root;

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) EMPTY;
    }

    private IntTreePMap(IntTree<V> intTree) {
        this.root = intTree;
    }

    private IntTreePMap<V> withRoot(IntTree<V> intTree) {
        if (intTree == this.root) {
            return this;
        }
        return new IntTreePMap<>(intTree);
    }

    public V get(int i) {
        return this.root.get((long) i);
    }

    public IntTreePMap<V> plus(int i, V v) {
        return withRoot(this.root.plus((long) i, v));
    }

    public IntTreePMap<V> minus(int i) {
        return withRoot(this.root.minus((long) i));
    }
}

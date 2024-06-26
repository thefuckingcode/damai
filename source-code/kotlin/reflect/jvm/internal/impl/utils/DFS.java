package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class DFS {

    /* compiled from: Taobao */
    public interface Neighbors<N> {
        @NotNull
        Iterable<? extends N> getNeighbors(N n);
    }

    /* compiled from: Taobao */
    public interface NodeHandler<N, R> {
        void afterChildren(N n);

        boolean beforeChildren(N n);

        R result();
    }

    /* compiled from: Taobao */
    public interface Visited<N> {
        boolean checkAndMarkVisited(N n);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends b<N, Boolean> {
        final /* synthetic */ Function1 a;
        final /* synthetic */ boolean[] b;

        a(Function1 function1, boolean[] zArr) {
            this.a = function1;
            this.b = zArr;
        }

        /* renamed from: a */
        public Boolean result() {
            return Boolean.valueOf(this.b[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public boolean beforeChildren(N n) {
            if (((Boolean) this.a.invoke(n)).booleanValue()) {
                this.b[0] = true;
            }
            return !this.b[0];
        }
    }

    /* compiled from: Taobao */
    public static abstract class b<N, R> implements NodeHandler<N, R> {
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public void afterChildren(N n) {
        }
    }

    /* compiled from: Taobao */
    public static class c<N> implements Visited<N> {
        private final Set<N> a;

        public c() {
            this(new HashSet());
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Visited
        public boolean checkAndMarkVisited(N n) {
            return this.a.add(n);
        }

        public c(@NotNull Set<N> set) {
            if (set == null) {
                a(0);
            }
            this.a = set;
        }
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R b(@NotNull Collection<N> collection, @NotNull Neighbors<N> neighbors, @NotNull NodeHandler<N, R> nodeHandler) {
        if (collection == null) {
            a(4);
        }
        if (neighbors == null) {
            a(5);
        }
        if (nodeHandler == null) {
            a(6);
        }
        return (R) c(collection, neighbors, new c(), nodeHandler);
    }

    public static <N, R> R c(@NotNull Collection<N> collection, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, R> nodeHandler) {
        if (collection == null) {
            a(0);
        }
        if (neighbors == null) {
            a(1);
        }
        if (visited == null) {
            a(2);
        }
        if (nodeHandler == null) {
            a(3);
        }
        for (N n : collection) {
            d(n, neighbors, visited, nodeHandler);
        }
        return nodeHandler.result();
    }

    public static <N> void d(@NotNull N n, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, ?> nodeHandler) {
        if (n == null) {
            a(22);
        }
        if (neighbors == null) {
            a(23);
        }
        if (visited == null) {
            a(24);
        }
        if (nodeHandler == null) {
            a(25);
        }
        if (visited.checkAndMarkVisited(n) && nodeHandler.beforeChildren(n)) {
            Iterator<? extends N> it = neighbors.getNeighbors(n).iterator();
            while (it.hasNext()) {
                d(it.next(), neighbors, visited, nodeHandler);
            }
            nodeHandler.afterChildren(n);
        }
    }

    public static <N> Boolean e(@NotNull Collection<N> collection, @NotNull Neighbors<N> neighbors, @NotNull Function1<N, Boolean> function1) {
        if (collection == null) {
            a(7);
        }
        if (neighbors == null) {
            a(8);
        }
        if (function1 == null) {
            a(9);
        }
        return (Boolean) b(collection, neighbors, new a(function1, new boolean[1]));
    }
}

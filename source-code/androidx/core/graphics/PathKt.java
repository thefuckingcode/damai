package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.o70;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\f\u001a\u0015\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\f\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\f¨\u0006\f"}, d2 = {"Landroid/graphics/Path;", "", "error", "", "Landroidx/core/graphics/PathSegment;", "flatten", "p", "plus", "minus", o70.OR_PREFIX, o70.AND_PREFIX, "xor", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PathKt {
    @RequiresApi(19)
    @NotNull
    public static final Path and(@NotNull Path path, @NotNull Path path2) {
        k21.i(path, "$this$and");
        k21.i(path2, "p");
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> flatten(@NotNull Path path, float f) {
        k21.i(path, "$this$flatten");
        Collection<PathSegment> flatten = PathUtils.flatten(path, f);
        k21.h(flatten, "PathUtils.flatten(this, error)");
        return flatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(19)
    @NotNull
    public static final Path minus(@NotNull Path path, @NotNull Path path2) {
        k21.i(path, "$this$minus");
        k21.i(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path or(@NotNull Path path, @NotNull Path path2) {
        k21.i(path, "$this$or");
        k21.i(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path plus(@NotNull Path path, @NotNull Path path2) {
        k21.i(path, "$this$plus");
        k21.i(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path xor(@NotNull Path path, @NotNull Path path2) {
        k21.i(path, "$this$xor");
        k21.i(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}

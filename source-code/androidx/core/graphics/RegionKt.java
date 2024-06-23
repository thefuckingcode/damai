package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.o70;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\n\u001a\r\u0010\n\u001a\u00020\u0000*\u00020\u0000H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\f\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\f\u001a3\u0010\u0014\u001a\u00020\u0012*\u00020\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\bø\u0001\u0000\u001a\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015*\u00020\u0000H\u0002\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"Landroid/graphics/Region;", "Landroid/graphics/Point;", "p", "", "contains", "Landroid/graphics/Rect;", UploadQueueMgr.MSGTYPE_REALTIME, "plus", "minus", "unaryMinus", o70.NOT_PREFIX, o70.OR_PREFIX, o70.AND_PREFIX, "xor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "Ltb/ur2;", "action", "forEach", "", "iterator", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RegionKt {
    @NotNull
    public static final Region and(@NotNull Region region, @NotNull Rect rect) {
        k21.i(region, "$this$and");
        k21.i(rect, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(@NotNull Region region, @NotNull Point point) {
        k21.i(region, "$this$contains");
        k21.i(point, "p");
        return region.contains(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
    }

    public static final void forEach(@NotNull Region region, @NotNull Function1<? super Rect, ur2> function1) {
        k21.i(region, "$this$forEach");
        k21.i(function1, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (regionIterator.next(rect)) {
                function1.invoke(rect);
            } else {
                return;
            }
        }
    }

    @NotNull
    public static final Iterator<Rect> iterator(@NotNull Region region) {
        k21.i(region, "$this$iterator");
        return new RegionKt$iterator$1(region);
    }

    @NotNull
    public static final Region minus(@NotNull Region region, @NotNull Rect rect) {
        k21.i(region, "$this$minus");
        k21.i(rect, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region not(@NotNull Region region) {
        k21.i(region, "$this$not");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region or(@NotNull Region region, @NotNull Rect rect) {
        k21.i(region, "$this$or");
        k21.i(rect, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @NotNull
    public static final Region plus(@NotNull Region region, @NotNull Rect rect) {
        k21.i(region, "$this$plus");
        k21.i(rect, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @NotNull
    public static final Region unaryMinus(@NotNull Region region) {
        k21.i(region, "$this$unaryMinus");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region xor(@NotNull Region region, @NotNull Rect rect) {
        k21.i(region, "$this$xor");
        k21.i(rect, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    @NotNull
    public static final Region and(@NotNull Region region, @NotNull Region region2) {
        k21.i(region, "$this$and");
        k21.i(region2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    @NotNull
    public static final Region minus(@NotNull Region region, @NotNull Region region2) {
        k21.i(region, "$this$minus");
        k21.i(region2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @NotNull
    public static final Region or(@NotNull Region region, @NotNull Region region2) {
        k21.i(region, "$this$or");
        k21.i(region2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @NotNull
    public static final Region plus(@NotNull Region region, @NotNull Region region2) {
        k21.i(region, "$this$plus");
        k21.i(region2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @NotNull
    public static final Region xor(@NotNull Region region, @NotNull Region region2) {
        k21.i(region, "$this$xor");
        k21.i(region2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}

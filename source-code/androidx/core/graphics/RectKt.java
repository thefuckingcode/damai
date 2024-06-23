package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.taobao.accs.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.o70;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0002\u001a\u00020\u0007*\u00020\u0006H\n\u001a\r\u0010\u0003\u001a\u00020\u0007*\u00020\u0006H\n\u001a\r\u0010\u0004\u001a\u00020\u0007*\u00020\u0006H\n\u001a\r\u0010\u0005\u001a\u00020\u0007*\u00020\u0006H\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\n\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0001H\n\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0007H\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\n\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\n\u001a\u0015\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\n\u001a\u0015\u0010\u000e\u001a\u00020\r*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0001H\n\u001a\u0015\u0010\u000e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0007H\n\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\n\u001a\u0015\u0010\u000e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\n\u001a\u0015\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\n\u001a\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\f\u001a\u0015\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\f\u001a\u0015\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\f\u001a\u0015\u0010\u0012\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\f\u001a\u0015\u0010\u0013\u001a\u00020\r*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\f\u001a\u0015\u0010\u0013\u001a\u00020\r*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\f\u001a\u0015\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bH\n\u001a\u0015\u0010\u0016\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\n\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0000H\b\u001a\r\u0010\u0018\u001a\u00020\u0000*\u00020\u0006H\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u0000H\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u0006H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\b¨\u0006\u001d"}, d2 = {"Landroid/graphics/Rect;", "", "component1", "component2", "component3", "component4", "Landroid/graphics/RectF;", "", UploadQueueMgr.MSGTYPE_REALTIME, "plus", "xy", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "Landroid/graphics/Region;", "minus", "factor", Constants.KEY_TIMES, o70.OR_PREFIX, o70.AND_PREFIX, "xor", "p", "", "contains", "toRectF", "toRect", "toRegion", "Landroid/graphics/Matrix;", WXComponent.PROP_FS_MATCH_PARENT, "transform", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final Rect and(@NotNull Rect rect, @NotNull Rect rect2) {
        k21.i(rect, "$this$and");
        k21.i(rect2, UploadQueueMgr.MSGTYPE_REALTIME);
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@NotNull Rect rect) {
        k21.i(rect, "$this$component1");
        return rect.left;
    }

    public static final int component2(@NotNull Rect rect) {
        k21.i(rect, "$this$component2");
        return rect.top;
    }

    public static final int component3(@NotNull Rect rect) {
        k21.i(rect, "$this$component3");
        return rect.right;
    }

    public static final int component4(@NotNull Rect rect) {
        k21.i(rect, "$this$component4");
        return rect.bottom;
    }

    public static final boolean contains(@NotNull Rect rect, @NotNull Point point) {
        k21.i(rect, "$this$contains");
        k21.i(point, "p");
        return rect.contains(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
    }

    @NotNull
    public static final Region minus(@NotNull Rect rect, @NotNull Rect rect2) {
        k21.i(rect, "$this$minus");
        k21.i(rect2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Rect or(@NotNull Rect rect, @NotNull Rect rect2) {
        k21.i(rect, "$this$or");
        k21.i(rect2, UploadQueueMgr.MSGTYPE_REALTIME);
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, @NotNull Rect rect2) {
        k21.i(rect, "$this$plus");
        k21.i(rect2, UploadQueueMgr.MSGTYPE_REALTIME);
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @NotNull
    public static final Rect times(@NotNull Rect rect, int i) {
        k21.i(rect, "$this$times");
        Rect rect2 = new Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    @NotNull
    public static final Rect toRect(@NotNull RectF rectF) {
        k21.i(rectF, "$this$toRect");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF toRectF(@NotNull Rect rect) {
        k21.i(rect, "$this$toRectF");
        return new RectF(rect);
    }

    @NotNull
    public static final Region toRegion(@NotNull Rect rect) {
        k21.i(rect, "$this$toRegion");
        return new Region(rect);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF rectF, @NotNull Matrix matrix) {
        k21.i(rectF, "$this$transform");
        k21.i(matrix, WXComponent.PROP_FS_MATCH_PARENT);
        matrix.mapRect(rectF);
        return rectF;
    }

    @NotNull
    public static final Region xor(@NotNull Rect rect, @NotNull Rect rect2) {
        k21.i(rect, "$this$xor");
        k21.i(rect2, UploadQueueMgr.MSGTYPE_REALTIME);
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@NotNull RectF rectF) {
        k21.i(rectF, "$this$component1");
        return rectF.left;
    }

    public static final float component2(@NotNull RectF rectF) {
        k21.i(rectF, "$this$component2");
        return rectF.top;
    }

    public static final float component3(@NotNull RectF rectF) {
        k21.i(rectF, "$this$component3");
        return rectF.right;
    }

    public static final float component4(@NotNull RectF rectF) {
        k21.i(rectF, "$this$component4");
        return rectF.bottom;
    }

    public static final boolean contains(@NotNull RectF rectF, @NotNull PointF pointF) {
        k21.i(rectF, "$this$contains");
        k21.i(pointF, "p");
        return rectF.contains(pointF.x, pointF.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF rectF) {
        k21.i(rectF, "$this$toRegion");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final RectF and(@NotNull RectF rectF, @NotNull RectF rectF2) {
        k21.i(rectF, "$this$and");
        k21.i(rectF2, UploadQueueMgr.MSGTYPE_REALTIME);
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @NotNull
    public static final Region minus(@NotNull RectF rectF, @NotNull RectF rectF2) {
        k21.i(rectF, "$this$minus");
        k21.i(rectF2, UploadQueueMgr.MSGTYPE_REALTIME);
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final RectF or(@NotNull RectF rectF, @NotNull RectF rectF2) {
        k21.i(rectF, "$this$or");
        k21.i(rectF2, UploadQueueMgr.MSGTYPE_REALTIME);
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, @NotNull RectF rectF2) {
        k21.i(rectF, "$this$plus");
        k21.i(rectF2, UploadQueueMgr.MSGTYPE_REALTIME);
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @NotNull
    public static final Region xor(@NotNull RectF rectF, @NotNull RectF rectF2) {
        k21.i(rectF, "$this$xor");
        k21.i(rectF2, UploadQueueMgr.MSGTYPE_REALTIME);
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, int i) {
        k21.i(rect, "$this$plus");
        Rect rect2 = new Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    @NotNull
    public static final RectF times(@NotNull RectF rectF, float f) {
        k21.i(rectF, "$this$times");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, float f) {
        k21.i(rectF, "$this$plus");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, @NotNull Point point) {
        k21.i(rect, "$this$plus");
        k21.i(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        return rect2;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect rect, int i) {
        k21.i(rect, "$this$minus");
        Rect rect2 = new Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, @NotNull PointF pointF) {
        k21.i(rectF, "$this$plus");
        k21.i(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @NotNull
    public static final RectF times(@NotNull RectF rectF, int i) {
        k21.i(rectF, "$this$times");
        float f = (float) i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF rectF, float f) {
        k21.i(rectF, "$this$minus");
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect rect, @NotNull Point point) {
        k21.i(rect, "$this$minus");
        k21.i(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), -com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        return rect2;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF rectF, @NotNull PointF pointF) {
        k21.i(rectF, "$this$minus");
        k21.i(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}

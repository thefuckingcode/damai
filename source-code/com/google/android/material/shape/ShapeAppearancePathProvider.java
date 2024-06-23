package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* compiled from: Taobao */
public class ShapeAppearancePathProvider {
    private final Path boundsPath = new Path();
    private final Path cornerPath = new Path();
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private boolean edgeIntersectionCheckEnabled = true;
    private final Path edgePath = new Path();
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final Path overlappedEdgePath = new Path();
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class Lazy {
        static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* compiled from: Taobao */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ShapeAppearancePathSpec {
        @NonNull
        public final RectF bounds;
        public final float interpolation;
        @NonNull
        public final Path path;
        @Nullable
        public final PathListener pathListener;
        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel2, float f, RectF rectF, @Nullable PathListener pathListener2, Path path2) {
            this.pathListener = pathListener2;
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.interpolation = f;
            this.bounds = rectF;
            this.path = path2;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    private float angleOfEdge(int i) {
        return (float) ((i + 1) * 90);
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        this.scratch[0] = this.cornerPaths[i].getStartX();
        this.scratch[1] = this.cornerPaths[i].getStartY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        if (i == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i], this.cornerTransforms[i], i);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        int i2 = (i + 1) % 4;
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i2].getStartX();
        this.scratch2[1] = this.cornerPaths[i2].getStartY();
        this.cornerTransforms[i2].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot((double) (f - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i], this.edgePath);
        if (!this.edgeIntersectionCheckEnabled || Build.VERSION.SDK_INT < 19 || (!edgeTreatmentForIndex.forceIntersection() && !pathOverlapsCorner(this.edgePath, i) && !pathOverlapsCorner(this.edgePath, i2))) {
            this.shapePath.applyToPath(this.edgeTransforms[i], shapeAppearancePathSpec.path);
        } else {
            Path path = this.edgePath;
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr3 = this.scratch;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i], this.overlappedEdgePath);
        }
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i], i);
        }
    }

    private void getCoordinatesOfCorner(int i, @NonNull RectF rectF, @NonNull PointF pointF2) {
        if (i == 1) {
            pointF2.set(rectF.right, rectF.bottom);
        } else if (i == 2) {
            pointF2.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF2.set(rectF.right, rectF.top);
        } else {
            pointF2.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i) {
        float[] fArr = this.scratch;
        ShapePath[] shapePathArr = this.cornerPaths;
        fArr[0] = shapePathArr[i].endX;
        fArr[1] = shapePathArr[i].endY;
        this.cornerTransforms[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path path, int i) {
        this.cornerPath.reset();
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        getCornerTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i);
        this.cornerTransforms[i].reset();
        getCoordinatesOfCorner(i, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i];
        PointF pointF2 = this.pointF;
        matrix.setTranslate(pointF2.x, pointF2.y);
        this.cornerTransforms[i].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i) {
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i);
        this.edgeTransforms[i].reset();
        Matrix matrix = this.edgeTransforms[i];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f, rectF, null, path);
    }

    /* access modifiers changed from: package-private */
    public void setEdgeIntersectionCheckEnable(boolean z) {
        this.edgeIntersectionCheckEnabled = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f, rectF, pathListener, path);
        for (int i = 0; i < 4; i++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i);
            setEdgePathAndTransform(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            appendCornerPath(shapeAppearancePathSpec, i2);
            appendEdgePath(shapeAppearancePathSpec, i2);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.overlappedEdgePath.isEmpty()) {
            path.op(this.overlappedEdgePath, Path.Op.UNION);
        }
    }
}

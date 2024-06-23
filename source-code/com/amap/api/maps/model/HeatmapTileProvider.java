package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.LongSparseArray;
import com.amap.api.mapcore.util.du;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: Taobao */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private du mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    /* compiled from: Taobao */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;
        private int radius = 12;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection == null || collection.size() == 0) {
                try {
                    throw new AMapException("No input points.");
                } catch (AMapException e) {
                    Log.e("amap", e.getErrorMessage());
                    e.printStackTrace();
                    return null;
                }
            } else {
                try {
                    return new HeatmapTileProvider(this);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.d(collection));
        }

        public Builder gradient(Gradient gradient2) {
            this.gradient = gradient2;
            return this;
        }

        public Builder radius(int i) {
            this.radius = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder transparency(double d) {
            this.opacity = Math.max(0.0d, Math.min(d, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private void c(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                double d = weightedLatLng.latLng.latitude;
                if (d < 85.0d && d > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            du a = a(arrayList);
            this.mBounds = a;
            this.mTree = new a(a);
            for (WeightedLatLng weightedLatLng2 : this.mData) {
                this.mTree.a(weightedLatLng2);
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static Collection<WeightedLatLng> d(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00ae  */
    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) {
        double d;
        du duVar;
        du duVar2;
        double d2;
        double pow = 1.0d / Math.pow(2.0d, (double) i3);
        int i4 = this.mRadius;
        double d3 = (((double) i4) * pow) / 256.0d;
        double d4 = ((2.0d * d3) + pow) / ((double) ((i4 * 2) + 256));
        double d5 = (((double) i) * pow) - d3;
        double d6 = (((double) (i + 1)) * pow) + d3;
        double d7 = (((double) i2) * pow) - d3;
        double d8 = (((double) (i2 + 1)) * pow) + d3;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d5 < 0.0d) {
            d2 = -1.0d;
            arrayList = this.mTree.a(new du(d5 + 1.0d, 1.0d, d7, d8));
        } else {
            d2 = 1.0d;
            if (d6 > 1.0d) {
                arrayList = this.mTree.a(new du(0.0d, d6 - 1.0d, d7, d8));
            } else {
                d = 0.0d;
                duVar = new du(d5, d6, d7, d8);
                duVar2 = this.mBounds;
                if (duVar.a(new du(duVar2.a - d3, duVar2.c + d3, duVar2.b - d3, duVar2.d + d3))) {
                    return TileProvider.NO_TILE;
                }
                Collection<WeightedLatLng> a = this.mTree.a(duVar);
                if (a.isEmpty()) {
                    return TileProvider.NO_TILE;
                }
                int i5 = this.mRadius;
                int[] iArr = new int[2];
                iArr[1] = (i5 * 2) + 256;
                iArr[0] = (i5 * 2) + 256;
                double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
                for (WeightedLatLng weightedLatLng : a) {
                    DPoint point = weightedLatLng.getPoint();
                    int i6 = (int) ((point.y - d7) / d4);
                    double[] dArr2 = dArr[(int) ((point.x - d5) / d4)];
                    dArr2[i6] = dArr2[i6] + weightedLatLng.intensity;
                }
                for (WeightedLatLng weightedLatLng2 : arrayList) {
                    DPoint point2 = weightedLatLng2.getPoint();
                    int i7 = (int) ((point2.y - d7) / d4);
                    double[] dArr3 = dArr[(int) (((point2.x + d) - d5) / d4)];
                    dArr3[i7] = dArr3[i7] + weightedLatLng2.intensity;
                }
                return a(a(a(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i3]));
            }
        }
        d = d2;
        duVar = new du(d5, d6, d7, d8);
        duVar2 = this.mBounds;
        if (duVar.a(new du(duVar2.a - d3, duVar2.c + d3, duVar2.b - d3, duVar2.d + d3))) {
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i = this.mRadius;
        this.mKernel = a(i, ((double) i) / 3.0d);
        a(this.mGradient);
        c(this.mData);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[21];
        int i3 = 5;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.mData, this.mBounds, i, (int) (Math.pow(2.0d, (double) i3) * 1280.0d));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 21; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    static du a(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().x;
        double d2 = next.getPoint().x;
        double d3 = d;
        double d4 = d2;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new du(d3, d4, d5, d6);
    }

    static double[] a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = 1;
        int i3 = (floor + i) - 1;
        int[] iArr = new int[2];
        iArr[1] = length;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, iArr);
        int i4 = 0;
        while (true) {
            double d = 0.0d;
            if (i4 >= length) {
                break;
            }
            int i5 = 0;
            while (i5 < length) {
                double d2 = dArr[i4][i5];
                if (d2 != d) {
                    int i6 = i4 + floor;
                    if (i3 < i6) {
                        i6 = i3;
                    }
                    int i7 = i6 + 1;
                    int i8 = i4 - floor;
                    for (int i9 = floor > i8 ? floor : i8; i9 < i7; i9++) {
                        double[] dArr4 = dArr3[i9];
                        dArr4[i5] = dArr4[i5] + (dArr2[i9 - i8] * d2);
                    }
                }
                i5++;
                d = 0.0d;
            }
            i4++;
        }
        int[] iArr2 = new int[2];
        iArr2[1] = i;
        iArr2[0] = i;
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, iArr2);
        int i10 = floor;
        while (i10 < i3 + 1) {
            int i11 = 0;
            while (i11 < length) {
                double d3 = dArr3[i10][i11];
                if (d3 != 0.0d) {
                    int i12 = i11 + floor;
                    if (i3 < i12) {
                        i12 = i3;
                    }
                    int i13 = i12 + i2;
                    int i14 = i11 - floor;
                    for (int i15 = floor > i14 ? floor : i14; i15 < i13; i15++) {
                        double[] dArr6 = dArr5[i10 - floor];
                        int i16 = i15 - floor;
                        dArr6[i16] = dArr6[i16] + (dArr2[i15 - i14] * d3);
                    }
                }
                i11++;
                i2 = 1;
            }
            i10++;
            i2 = 1;
        }
        return dArr5;
    }

    static Bitmap a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    static double a(Collection<WeightedLatLng> collection, du duVar, int i, int i2) {
        double d = duVar.a;
        double d2 = duVar.c;
        double d3 = duVar.b;
        double d4 = d2 - d;
        double d5 = duVar.d - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d7 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d8 = weightedLatLng.getPoint().x;
            int i3 = (int) ((weightedLatLng.getPoint().y - d3) * d6);
            long j = (long) ((int) ((d8 - d) * d6));
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = (long) i3;
            Double d9 = (Double) longSparseArray2.get(j2);
            if (d9 == null) {
                d9 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(d9.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j2, valueOf);
            if (valueOf.doubleValue() > d7) {
                d7 = valueOf.doubleValue();
            }
            longSparseArray = longSparseArray;
            d = d;
        }
        return d7;
    }
}

package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.weex.common.Constants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pe1;

/* compiled from: Taobao */
public final class te1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final te1 INSTANCE = new te1();
    public static final int PAINT_FLAGS = 6;
    private static final Paint a = new Paint(6);
    private static Paint b;
    private static final Set<String> c;
    @NotNull
    private static final Lock d;

    /* compiled from: Taobao */
    public static final class a implements Lock {
        private static transient /* synthetic */ IpChange $ipChange;

        public void lock() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-492727302")) {
                ipChange.ipc$dispatch("-492727302", new Object[]{this});
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1504954041")) {
                ipChange.ipc$dispatch("-1504954041", new Object[]{this});
            }
        }

        @NotNull
        public Condition newCondition() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-904488513")) {
                return (Condition) ipChange.ipc$dispatch("-904488513", new Object[]{this});
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1309129565")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1309129565", new Object[]{this})).booleanValue();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NotNull TimeUnit timeUnit) throws InterruptedException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "687150487")) {
                return ((Boolean) ipChange.ipc$dispatch("687150487", new Object[]{this, Long.valueOf(j), timeUnit})).booleanValue();
            }
            k21.i(timeUnit, "unit");
            return true;
        }

        public void unlock() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1968927553")) {
                ipChange.ipc$dispatch("1968927553", new Object[]{this});
            }
        }
    }

    static {
        new Paint(7);
        HashSet hashSet = new HashSet(m.j("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        c = hashSet;
        d = hashSet.contains(Build.getMODEL()) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        b = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private te1() {
    }

    private final void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719260930")) {
            ipChange.ipc$dispatch("-719260930", new Object[]{this, bitmap, bitmap2, matrix});
            return;
        }
        Lock lock = d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            d.unlock();
            throw th;
        }
    }

    private final void e(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918063419")) {
            ipChange.ipc$dispatch("-1918063419", new Object[]{this, canvas});
            return;
        }
        canvas.setBitmap(null);
    }

    private final Bitmap.Config i(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119658303")) {
            return (Bitmap.Config) ipChange.ipc$dispatch("-119658303", new Object[]{this, bitmap});
        } else if (bitmap.getConfig() == null) {
            return Bitmap.Config.ARGB_8888;
        } else {
            Bitmap.Config config = bitmap.getConfig();
            k21.h(config, "bitmap.config");
            return config;
        }
    }

    @Nullable
    public final Bitmap b(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @Nullable Bitmap bitmap, @Nullable pe1.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898148273")) {
            return (Bitmap) ipChange.ipc$dispatch("-1898148273", new Object[]{this, bitmapSupplier, bitmap, aVar});
        }
        k21.i(bitmapSupplier, "bitmapSupplier");
        if (bitmap == null || aVar == null) {
            return null;
        }
        float[] d2 = aVar.d();
        float c2 = aVar.c();
        int a2 = aVar.a();
        int b2 = aVar.b();
        Bitmap bitmap2 = bitmapSupplier.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            me1 me1 = me1.INSTANCE;
            me1.a("borderCrop: creat new Bitmap + w=" + bitmap.getWidth() + ",h=" + bitmap.getHeight() + "this=" + toString());
        } else {
            me1 me12 = me1.INSTANCE;
            me12.a("borderCrop: use recycle Bitmap + w=" + bitmap.getWidth() + ",h=" + bitmap.getHeight() + "this=" + toString());
        }
        k21.f(bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        if (c2 > ((float) 0)) {
            Paint paint = new Paint();
            if (b2 == 0) {
                b2 = -12303292;
            }
            paint.setColor(b2);
            paint.setStrokeWidth(c2);
            paint.setStyle(Paint.Style.STROKE);
            if (a2 == 1) {
                paint.setPathEffect(new DashPathEffect(new float[]{8.0f, 5.0f}, 0.0f));
            }
            paint.setAntiAlias(true);
            Path path = new Path();
            if (aVar.f()) {
                path.addCircle(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f, (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) - c2) / ((float) 2), Path.Direction.CCW);
            } else {
                float f = c2 / ((float) 2);
                path.addRoundRect(new RectF(f, f, ((float) bitmap.getWidth()) - f, ((float) bitmap.getHeight()) - f), d2, Path.Direction.CCW);
            }
            canvas.drawPath(path, paint);
        }
        Paint paint2 = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint2.setAntiAlias(true);
        Path path2 = new Path();
        if (aVar.f()) {
            path2.addCircle(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f, (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) / ((float) 2)) - c2, Path.Direction.CCW);
        } else {
            path2.addRoundRect(new RectF(c2, c2, ((float) bitmap.getWidth()) - c2, ((float) bitmap.getHeight()) - c2), d2, Path.Direction.CCW);
        }
        canvas.drawPath(path2, paint2);
        canvas.setBitmap(null);
        return bitmap2;
    }

    @NotNull
    public final Bitmap c(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044375789")) {
            return (Bitmap) ipChange.ipc$dispatch("-1044375789", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        k21.i(bitmapSupplier, "pool");
        k21.i(bitmap, "inBitmap");
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || (bitmap.getWidth() == i && bitmap.getHeight() == i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            f2 = ((float) i2) / ((float) bitmap.getHeight());
            f3 = (((float) i) - (((float) bitmap.getWidth()) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = ((float) i) / ((float) bitmap.getWidth());
            f = (((float) i2) - (((float) bitmap.getHeight()) * f2)) * 0.5f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float) ((int) (f3 + 0.5f)), (float) ((int) (f + 0.5f)));
        Bitmap bitmap2 = bitmapSupplier.get(i, i2, i(bitmap));
        k21.h(bitmap2, "pool.get(width, height, …tNonNullConfig(inBitmap))");
        j(bitmap, bitmap2);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    @NotNull
    public final Bitmap d(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624616295")) {
            return (Bitmap) ipChange.ipc$dispatch("624616295", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        k21.i(bitmapSupplier, "pool");
        k21.i(bitmap, "inBitmap");
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            me1.INSTANCE.b("TransformationUtils", "requested target size too big for input, fit centering instead");
            return f(bitmapSupplier, bitmap, i, i2);
        }
        me1.INSTANCE.b("TransformationUtils", "requested target size larger or equal to input, returning input");
        return bitmap;
    }

    @NotNull
    public final Bitmap f(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769151006")) {
            return (Bitmap) ipChange.ipc$dispatch("-769151006", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        k21.i(bitmapSupplier, "pool");
        k21.i(bitmap, "inBitmap");
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || (bitmap.getWidth() == i && bitmap.getHeight() == i2)) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmap2 = bitmapSupplier.get((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), i(bitmap));
        k21.h(bitmap2, "pool.get(targetWidth, targetHeight, config)");
        j(bitmap, bitmap2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + Constants.Name.X + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + Constants.Name.X + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + Constants.Name.X + bitmap2.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    @Nullable
    public final Bitmap g(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @Nullable Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878990880")) {
            return (Bitmap) ipChange.ipc$dispatch("1878990880", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        k21.i(bitmapSupplier, "pool");
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float height = ((float) i2) / ((float) bitmap.getHeight());
        Bitmap bitmap2 = bitmapSupplier.get((int) (((float) bitmap.getWidth()) * height), i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        k21.h(bitmap2, "pool.get((toCrop.width*s… Bitmap.Config.ARGB_8888)");
        matrix.setScale(height, height);
        float f = (float) ((int) 0.5f);
        matrix.postTranslate(f, f);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), (int) (((float) bitmap.getHeight()) * height), ke1.INSTANCE.e(bitmap));
        }
        k21.h(bitmap2, "result");
        j(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        e(canvas);
        return bitmap2;
    }

    @Nullable
    public final Bitmap h(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @Nullable Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402631885")) {
            return (Bitmap) ipChange.ipc$dispatch("-1402631885", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        k21.i(bitmapSupplier, "pool");
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width = ((float) i) / ((float) bitmap.getWidth());
        Bitmap bitmap2 = bitmapSupplier.get(i, (int) (((float) bitmap.getHeight()) * width), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        k21.h(bitmap2, "pool.get(width, (toCrop.… Bitmap.Config.ARGB_8888)");
        matrix.setScale(width, width);
        float f = (float) ((int) 0.5f);
        matrix.postTranslate(f, f);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i, (int) (((float) bitmap.getHeight()) * width), ke1.INSTANCE.e(bitmap));
        }
        k21.h(bitmap2, "result");
        j(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        e(canvas);
        return bitmap2;
    }

    public final void j(@NotNull Bitmap bitmap, @NotNull Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423695809")) {
            ipChange.ipc$dispatch("1423695809", new Object[]{this, bitmap, bitmap2});
            return;
        }
        k21.i(bitmap, "inBitmap");
        k21.i(bitmap2, "outBitmap");
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}

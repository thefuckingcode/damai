package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.SVGAVideoShapeEntity;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.n22;

/* compiled from: Taobao */
public final class t22 extends n22 {
    private int c;
    private int d;
    private final Paint e = new Paint();
    private final Path f = new Path();
    private final Path g = new Path();
    private final Matrix h = new Matrix();
    private final Matrix i = new Matrix();
    private final HashMap<String, Bitmap> j = new HashMap<>();
    private final HashMap<SVGAVideoShapeEntity, Path> k = new HashMap<>();
    private final float[] l = new float[16];
    @NotNull
    private final v22 m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t22(@NotNull SVGAVideoEntity sVGAVideoEntity, @NotNull v22 v22) {
        super(sVGAVideoEntity);
        k21.j(sVGAVideoEntity, "videoItem");
        k21.j(v22, "dynamicItem");
        this.m = v22;
    }

    private final void f(n22.a aVar, Canvas canvas, int i2) {
        Function2<Canvas, Integer, Boolean> function2;
        String b = aVar.b();
        if (b != null && (function2 = this.m.a().get(b)) != null) {
            o(aVar.a().e());
            canvas.save();
            canvas.concat(this.i);
            function2.invoke(canvas, Integer.valueOf(i2));
            canvas.restore();
        }
    }

    private final void g(n22.a aVar, Canvas canvas) {
        String b = aVar.b();
        if (b != null) {
            Boolean bool = this.m.b().get(b);
            if (bool != null) {
                k21.e(bool, AdvanceSetting.NETWORK_TYPE);
                if (!bool.booleanValue()) {
                    bool = null;
                }
                if (bool != null) {
                    return;
                }
            }
            Bitmap bitmap = this.m.c().get(b);
            if (bitmap == null) {
                bitmap = c().e().get(b);
            }
            if (bitmap != null) {
                o(aVar.a().e());
                this.e.reset();
                this.e.setAntiAlias(c().a());
                this.e.setFilterBitmap(c().a());
                this.e.setAlpha((int) (aVar.a().a() * ((double) 255)));
                if (aVar.a().c() != null) {
                    x22 c2 = aVar.a().c();
                    if (c2 != null) {
                        canvas.save();
                        this.f.reset();
                        c2.a(this.f);
                        this.f.transform(this.i);
                        canvas.clipPath(this.f);
                        this.i.preScale((float) (aVar.a().b().b() / ((double) bitmap.getWidth())), (float) (aVar.a().b().b() / ((double) bitmap.getWidth())));
                        canvas.drawBitmap(bitmap, this.i, this.e);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    this.i.preScale((float) (aVar.a().b().b() / ((double) bitmap.getWidth())), (float) (aVar.a().b().b() / ((double) bitmap.getWidth())));
                    canvas.drawBitmap(bitmap, this.i, this.e);
                }
                j(canvas, bitmap, aVar);
            }
        }
    }

    private final void h(n22.a aVar, Canvas canvas) {
        int a;
        o(aVar.a().e());
        for (T t : aVar.a().d()) {
            t.a();
            if (t.b() != null) {
                this.e.reset();
                this.e.setAntiAlias(c().a());
                double d2 = (double) 255;
                this.e.setAlpha((int) (aVar.a().a() * d2));
                if (!this.k.containsKey(t)) {
                    Path path = new Path();
                    path.set(t.b());
                    this.k.put(t, path);
                }
                this.f.reset();
                this.f.addPath(new Path(this.k.get(t)));
                this.h.reset();
                Matrix d3 = t.d();
                if (d3 != null) {
                    this.h.postConcat(d3);
                }
                this.h.postConcat(this.i);
                this.f.transform(this.h);
                SVGAVideoShapeEntity.a c2 = t.c();
                if (!(c2 == null || (a = c2.a()) == 0)) {
                    this.e.setColor(a);
                    this.e.setAlpha(Math.min(255, Math.max(0, (int) (aVar.a().a() * d2))));
                    if (aVar.a().c() != null) {
                        canvas.save();
                    }
                    x22 c3 = aVar.a().c();
                    if (c3 != null) {
                        this.g.reset();
                        c3.a(this.g);
                        this.g.transform(this.i);
                        canvas.clipPath(this.g);
                    }
                    canvas.drawPath(this.f, this.e);
                    if (aVar.a().c() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a c4 = t.c();
                if (c4 != null && c4.g() > ((float) 0)) {
                    n(t);
                    if (aVar.a().c() != null) {
                        canvas.save();
                    }
                    x22 c5 = aVar.a().c();
                    if (c5 != null) {
                        this.g.reset();
                        c5.a(this.g);
                        this.g.transform(this.i);
                        canvas.clipPath(this.g);
                    }
                    canvas.drawPath(this.f, this.e);
                    if (aVar.a().c() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final void i(n22.a aVar, Canvas canvas, int i2) {
        g(aVar, canvas);
        h(aVar, canvas);
        f(aVar, canvas, i2);
    }

    private final void j(Canvas canvas, Bitmap bitmap, n22.a aVar) {
        TextPaint textPaint;
        if (this.m.g()) {
            this.j.clear();
            this.m.i(false);
        }
        String b = aVar.b();
        if (b != null) {
            Bitmap bitmap2 = null;
            String str = this.m.e().get(b);
            if (!(str == null || (textPaint = this.m.f().get(b)) == null || (bitmap2 = this.j.get(b)) != null)) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap2);
                textPaint.setAntiAlias(true);
                Rect rect = new Rect();
                textPaint.getTextBounds(str, 0, str.length(), rect);
                canvas2.drawText(str, (float) (((double) (bitmap.getWidth() - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect))) / 2.0d), ((((float) (bitmap.getHeight() + 0)) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / ((float) 2), textPaint);
                HashMap<String, Bitmap> hashMap = this.j;
                if (bitmap2 != null) {
                    hashMap.put(b, bitmap2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
            }
            StaticLayout staticLayout = this.m.d().get(b);
            if (staticLayout != null && (bitmap2 = this.j.get(b)) == null) {
                staticLayout.getPaint().setAntiAlias(true);
                StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(createBitmap);
                canvas3.translate(0.0f, (float) ((bitmap.getHeight() - staticLayout2.getHeight()) / 2));
                staticLayout2.draw(canvas3);
                HashMap<String, Bitmap> hashMap2 = this.j;
                if (createBitmap != null) {
                    hashMap2.put(b, createBitmap);
                    bitmap2 = createBitmap;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
            }
            if (bitmap2 != null) {
                this.e.reset();
                this.e.setAntiAlias(c().a());
                if (aVar.a().c() != null) {
                    x22 c2 = aVar.a().c();
                    if (c2 != null) {
                        canvas.save();
                        canvas.concat(this.i);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        this.e.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                        this.f.reset();
                        c2.a(this.f);
                        canvas.drawPath(this.f, this.e);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                this.e.setFilterBitmap(c().a());
                canvas.drawBitmap(bitmap2, this.i, this.e);
            }
        }
    }

    private final void k(int i2) {
        SoundPool f2;
        Integer c2;
        for (T t : c().b()) {
            if (!(t.d() != i2 || (f2 = c().f()) == null || (c2 = t.c()) == null)) {
                t.e(Integer.valueOf(f2.play(c2.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (t.a() <= i2) {
                Integer b = t.b();
                if (b != null) {
                    int intValue = b.intValue();
                    SoundPool f3 = c().f();
                    if (f3 != null) {
                        f3.stop(intValue);
                    }
                }
                t.e(null);
            }
        }
    }

    private final float l() {
        float f2;
        float f3;
        this.i.getValues(this.l);
        float[] fArr = this.l;
        if (fArr[0] == 0.0f) {
            return 0.0f;
        }
        double d2 = (double) fArr[0];
        double d3 = (double) fArr[3];
        double d4 = (double) fArr[1];
        double d5 = (double) fArr[4];
        if (d2 * d5 == d3 * d4) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        double d6 = d2 / sqrt;
        double d7 = d3 / sqrt;
        double d8 = (d6 * d4) + (d7 * d5);
        double d9 = d4 - (d6 * d8);
        double d10 = d5 - (d8 * d7);
        double sqrt2 = Math.sqrt((d9 * d9) + (d10 * d10));
        if (d6 * (d10 / sqrt2) < d7 * (d9 / sqrt2)) {
            sqrt = -sqrt;
        }
        if (b().b()) {
            f3 = b().a();
            f2 = (float) sqrt;
        } else {
            f3 = b().a();
            f2 = (float) sqrt2;
        }
        return f3 / Math.abs(f2);
    }

    private final void m(Canvas canvas) {
        if (!(this.c == canvas.getWidth() && this.d == canvas.getHeight())) {
            this.k.clear();
        }
        this.c = canvas.getWidth();
        this.d = canvas.getHeight();
    }

    private final void n(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
        float[] c2;
        String d2;
        String b;
        this.e.reset();
        this.e.setAntiAlias(c().a());
        this.e.setStyle(Paint.Style.STROKE);
        SVGAVideoShapeEntity.a c3 = sVGAVideoShapeEntity.c();
        if (c3 != null) {
            this.e.setColor(c3.f());
        }
        float l2 = l();
        SVGAVideoShapeEntity.a c4 = sVGAVideoShapeEntity.c();
        if (c4 != null) {
            this.e.setStrokeWidth(c4.g() * l2);
        }
        SVGAVideoShapeEntity.a c5 = sVGAVideoShapeEntity.c();
        if (!(c5 == null || (b = c5.b()) == null)) {
            if (o.w(b, "butt", true)) {
                this.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (o.w(b, "round", true)) {
                this.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (o.w(b, "square", true)) {
                this.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        SVGAVideoShapeEntity.a c6 = sVGAVideoShapeEntity.c();
        if (!(c6 == null || (d2 = c6.d()) == null)) {
            if (o.w(d2, "miter", true)) {
                this.e.setStrokeJoin(Paint.Join.MITER);
            } else if (o.w(d2, "round", true)) {
                this.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (o.w(d2, "bevel", true)) {
                this.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        SVGAVideoShapeEntity.a c7 = sVGAVideoShapeEntity.c();
        if (c7 != null) {
            this.e.setStrokeMiter(((float) c7.e()) * l2);
        }
        SVGAVideoShapeEntity.a c8 = sVGAVideoShapeEntity.c();
        if (c8 != null && (c2 = c8.c()) != null && c2.length == 3) {
            float f2 = (float) 0;
            if (c2[0] > f2 || c2[1] > f2) {
                Paint paint = this.e;
                float[] fArr = new float[2];
                float f3 = 1.0f;
                if (c2[0] >= 1.0f) {
                    f3 = c2[0];
                }
                fArr[0] = f3 * l2;
                float f4 = 0.1f;
                if (c2[1] >= 0.1f) {
                    f4 = c2[1];
                }
                fArr[1] = f4 * l2;
                paint.setPathEffect(new DashPathEffect(fArr, c2[2] * l2));
            }
        }
    }

    private final void o(Matrix matrix) {
        this.i.reset();
        this.i.postScale(b().c(), b().d());
        this.i.postTranslate(b().e(), b().f());
        this.i.preConcat(matrix);
    }

    @Override // tb.n22
    public void a(@NotNull Canvas canvas, int i2, @NotNull ImageView.ScaleType scaleType) {
        k21.j(canvas, "canvas");
        k21.j(scaleType, "scaleType");
        super.a(canvas, i2, scaleType);
        m(canvas);
        Iterator<T> it = e(i2).iterator();
        while (it.hasNext()) {
            i(it.next(), canvas, i2);
        }
        k(i2);
    }
}

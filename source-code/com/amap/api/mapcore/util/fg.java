package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.File;
import java.io.InputStream;

/* compiled from: Taobao */
public class fg extends View {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Paint h = new Paint();
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 10;
    private int n = 0;
    private int o = 0;
    private int p = 10;
    private int q = 8;
    private boolean r = false;
    private boolean s = false;
    private Context t;
    private boolean u = true;
    private float v = 0.0f;
    private float w = 0.0f;
    private boolean x = true;
    private boolean y = false;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00eb A[SYNTHETIC, Splitter:B:21:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    public fg(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            this.t = context.getApplicationContext();
            InputStream open = ek.a(context).open("ap.data");
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                this.f = decodeStream;
                this.a = eq.a(decodeStream, m.a);
                open.close();
                inputStream2 = ek.a(context).open("ap1.data");
                Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
                this.g = decodeStream2;
                this.b = eq.a(decodeStream2, m.a);
                inputStream2.close();
                this.k = this.b.getWidth();
                this.j = this.b.getHeight();
                this.h.setAntiAlias(true);
                this.h.setColor(-16777216);
                this.h.setStyle(Paint.Style.STROKE);
                AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
                AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
                ep.a().a(new Runnable() {
                    /* class com.amap.api.mapcore.util.fg.AnonymousClass1 */

                    public void run() {
                        fg.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
                        fg.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
                        if (!"".equals(eg.a(fg.this.t, "amap_web_logo", "md5_day", ""))) {
                            return;
                        }
                        if (fg.this.c == null || fg.this.d == null) {
                            eg.a(fg.this.t, "amap_web_logo", "md5_day", (Object) "f3a1627fe912c49ecdcd4ab92a5d6bc8");
                            eg.a(fg.this.t, "amap_web_logo", "md5_night", (Object) "61733cf36c9727db08c2ef727490c036");
                            return;
                        }
                        eg.a(fg.this.t, "amap_web_logo", "md5_day", (Object) gk.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                        String a2 = gk.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                        if (!"".equals(a2)) {
                            eg.a(fg.this.t, "amap_web_logo", "md5_night", (Object) a2);
                        }
                        fg.this.d(true);
                    }
                });
                try {
                    open.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    inputStream2.close();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = inputStream2;
                inputStream2 = open;
                try {
                    hd.c(th, "WaterMarkerView", "create");
                    if (inputStream2 != null) {
                    }
                    if (inputStream == null) {
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            hd.c(th, "WaterMarkerView", "create");
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable th7) {
                    th7.printStackTrace();
                }
            }
            if (inputStream == null) {
                inputStream.close();
                return;
            }
            return;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        throw th;
        throw th;
    }

    private void f() {
        int i2 = this.o;
        if (i2 == 0) {
            h();
        } else if (i2 == 2) {
            g();
        }
        this.m = this.p;
        int height = (getHeight() - this.q) - this.j;
        this.n = height;
        if (this.m < 0) {
            this.m = 0;
        }
        if (height < 0) {
            this.n = 0;
        }
    }

    private void g() {
        if (this.x) {
            this.p = (int) (((float) getWidth()) * this.v);
        } else {
            this.p = (int) ((((float) getWidth()) * this.v) - ((float) this.k));
        }
        this.q = (int) (((float) getHeight()) * this.w);
    }

    private void h() {
        int i2 = this.l;
        if (i2 == 1) {
            this.p = (getWidth() - this.k) / 2;
        } else if (i2 == 2) {
            this.p = (getWidth() - this.k) - 10;
        } else {
            this.p = 10;
        }
        this.q = 8;
    }

    public float d(int i2) {
        float f2;
        if (!this.u) {
            return 0.0f;
        }
        if (i2 == 0) {
            return this.v;
        }
        if (i2 == 1) {
            f2 = this.v;
        } else if (i2 != 2) {
            return 0.0f;
        } else {
            f2 = this.w;
        }
        return 1.0f - f2;
    }

    public boolean e() {
        return this.i;
    }

    public void onDraw(Canvas canvas) {
        try {
            if (!this.u || getWidth() == 0) {
                return;
            }
            if (getHeight() != 0) {
                if (this.b != null) {
                    if (!this.r) {
                        f();
                        this.r = true;
                    }
                    canvas.drawBitmap(b(), (float) this.m, (float) this.n, this.h);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                eq.b(bitmap);
                this.a = null;
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                eq.b(bitmap2);
                this.b = null;
            }
            this.a = null;
            this.b = null;
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null) {
                eq.b(bitmap3);
                this.f = null;
            }
            Bitmap bitmap4 = this.g;
            if (bitmap4 != null) {
                eq.b(bitmap4);
                this.g = null;
            }
            Bitmap bitmap5 = this.c;
            if (bitmap5 != null) {
                eq.b(bitmap5);
            }
            this.c = null;
            Bitmap bitmap6 = this.d;
            if (bitmap6 != null) {
                eq.b(bitmap6);
            }
            this.d = null;
            Bitmap bitmap7 = this.e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.h = null;
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public Bitmap b() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (this.y && (bitmap3 = this.e) != null) {
            return bitmap3;
        }
        if (this.i) {
            if (!this.s || (bitmap2 = this.d) == null) {
                return this.b;
            }
            return bitmap2;
        } else if (!this.s || (bitmap = this.c) == null) {
            return this.a;
        } else {
            return bitmap;
        }
    }

    public Point c() {
        return new Point(this.m, this.n - 2);
    }

    public void c(int i2) {
        this.o = 1;
        this.p = i2;
        d();
    }

    public void d() {
        if (getWidth() != 0 && getHeight() != 0) {
            f();
            postInvalidate();
        }
    }

    public void c(boolean z) {
        this.u = z;
    }

    public void d(boolean z) {
        if (this.u && this.s != z) {
            this.s = z;
            if (!z) {
                this.k = this.a.getWidth();
                this.j = this.a.getHeight();
            } else if (this.i) {
                Bitmap bitmap = this.d;
                if (bitmap != null) {
                    this.k = bitmap.getWidth();
                    this.j = this.d.getHeight();
                }
            } else {
                Bitmap bitmap2 = this.c;
                if (bitmap2 != null) {
                    this.k = bitmap2.getWidth();
                    this.j = this.c.getHeight();
                }
            }
        }
    }

    public void b(int i2) {
        this.o = 1;
        this.q = i2;
        d();
    }

    public void b(boolean z) {
        if (this.u) {
            this.y = z;
            if (z) {
                Bitmap bitmap = this.e;
                if (bitmap != null) {
                    this.k = bitmap.getWidth();
                    this.j = this.e.getHeight();
                    return;
                }
                return;
            }
            this.k = this.a.getWidth();
            this.j = this.a.getHeight();
        }
    }

    public void a(boolean z) {
        if (this.u) {
            try {
                this.i = z;
                if (z) {
                    this.h.setColor(-1);
                } else {
                    this.h.setColor(-16777216);
                }
            } catch (Throwable th) {
                hd.c(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public void a(int i2) {
        this.o = 0;
        this.l = i2;
        d();
    }

    public void a(int i2, float f2) {
        if (this.u) {
            this.o = 2;
            float max = Math.max(0.0f, Math.min(f2, 1.0f));
            if (i2 == 0) {
                this.v = max;
                this.x = true;
            } else if (i2 == 1) {
                this.v = 1.0f - max;
                this.x = false;
            } else if (i2 == 2) {
                this.w = 1.0f - max;
            }
            d();
        }
    }

    public void a(String str, int i2) {
        try {
            if (!this.u || !new File(str).exists()) {
                return;
            }
            if (i2 == 0) {
                Bitmap bitmap = this.c;
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                this.f = decodeFile;
                this.c = eq.a(decodeFile, m.a);
                if (bitmap != null && !bitmap.isRecycled()) {
                    eq.b(bitmap);
                }
            } else if (i2 == 1) {
                Bitmap bitmap2 = this.d;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                this.f = decodeFile2;
                this.d = eq.a(decodeFile2, m.a);
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    eq.b(bitmap2);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }
}

package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import tb.v;

/* compiled from: Taobao */
public class fb extends ScrollView {
    public static final String a = fb.class.getSimpleName();
    int b = 1;
    private Context c;
    private LinearLayout d;
    private int e = 0;
    private List<String> f;
    private int g = -1;
    private int h;
    private Bitmap i = null;
    private int j = Color.parseColor("#eeffffff");
    private int k = Color.parseColor("#44383838");
    private int l = 4;
    private int m = 1;
    private int n;
    private int o;
    private Runnable p;
    private int q = 50;
    private a r;

    /* compiled from: Taobao */
    public interface a {
        void a(int i);
    }

    public fb(Context context) {
        super(context);
        a(context);
    }

    public void fling(int i2) {
        super.fling(i2 / 3);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a(i3);
        if (i3 > i5) {
            this.g = 1;
        } else {
            this.g = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.h = i2;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i2) {
        this.j = i2;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.h == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.c.getSystemService(v.ATTACH_MODE_WINDOW);
                if (windowManager != null) {
                    this.h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() {
            /* class com.amap.api.mapcore.util.fb.AnonymousClass2 */

            private void a(Canvas canvas) {
                canvas.drawColor(fb.this.j);
            }

            private void b(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = fb.this.i.getWidth() + 0;
                rect.bottom = fb.this.i.getHeight() + 0;
                rect2.left = 0;
                rect2.top = fb.this.f()[0];
                rect2.right = fb.this.h + 0;
                rect2.bottom = fb.this.f()[1];
                canvas.drawBitmap(fb.this.i, rect, rect2, paint);
            }

            private void c(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(fb.this.k);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth((float) fb.this.l);
                canvas.drawRect(clipBounds, paint);
            }

            public void draw(Canvas canvas) {
                try {
                    a(canvas);
                    b(canvas);
                    c(canvas);
                } catch (Throwable unused) {
                }
            }

            public int getOpacity() {
                return 0;
            }

            public void setAlpha(int i) {
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }

    private TextView b(String str) {
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a2 = a(this.c, 8.0f);
        int a3 = a(this.c, 6.0f);
        textView.setPadding(a2, a3, a2, a3);
        if (this.e == 0) {
            this.e = a(textView);
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.e * this.n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.e * this.n));
        }
        return textView;
    }

    private void e() {
        List<String> list = this.f;
        if (!(list == null || list.size() == 0)) {
            this.d.removeAllViews();
            this.n = (this.m * 2) + 1;
            for (int size = this.f.size() - 1; size >= 0; size--) {
                this.d.addView(b(this.f.get(size)));
            }
            a(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int[] f() {
        int i2 = this.e;
        int i3 = this.m;
        return new int[]{i2 * i3, i2 * (i3 + 1)};
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        a aVar = this.r;
        if (aVar != null) {
            try {
                aVar.a(c());
            } catch (Throwable unused) {
            }
        }
    }

    public int c() {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f.size() - (this.m * 2), Math.max(0, ((this.f.size() - 1) - this.b) - this.m));
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    private void a(Context context) {
        this.c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.i == null) {
                InputStream open = ek.a(context).open("map_indoor_select.png");
                this.i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.d);
        this.p = new Runnable() {
            /* class com.amap.api.mapcore.util.fb.AnonymousClass1 */

            public void run() {
                if (fb.this.o - fb.this.getScrollY() != 0) {
                    fb fbVar = fb.this;
                    fbVar.o = fbVar.getScrollY();
                    fb fbVar2 = fb.this;
                    fbVar2.postDelayed(fbVar2.p, (long) fb.this.q);
                } else if (fb.this.e != 0) {
                    final int i = fb.this.o % fb.this.e;
                    final int i2 = fb.this.o / fb.this.e;
                    if (i == 0) {
                        fb fbVar3 = fb.this;
                        fbVar3.b = i2 + fbVar3.m;
                        fb.this.g();
                    } else if (i > fb.this.e / 2) {
                        fb.this.post(new Runnable() {
                            /* class com.amap.api.mapcore.util.fb.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                fb fbVar = fb.this;
                                fbVar.smoothScrollTo(0, (fbVar.o - i) + fb.this.e);
                                fb fbVar2 = fb.this;
                                fbVar2.b = i2 + fbVar2.m + 1;
                                fb.this.g();
                            }
                        });
                    } else {
                        fb.this.post(new Runnable() {
                            /* class com.amap.api.mapcore.util.fb.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                fb fbVar = fb.this;
                                fbVar.smoothScrollTo(0, fbVar.o - i);
                                fb fbVar2 = fb.this;
                                fbVar2.b = i2 + fbVar2.m;
                                fb.this.g();
                            }
                        });
                    }
                }
            }
        };
    }

    public void a() {
        this.o = getScrollY();
        postDelayed(this.p, (long) this.q);
    }

    private void a(int i2) {
        int i3 = this.e;
        if (i3 != 0) {
            int i4 = this.m;
            int i5 = (i2 / i3) + i4;
            int i6 = i2 % i3;
            int i7 = i2 / i3;
            if (i6 == 0) {
                i5 = i7 + i4;
            } else if (i6 > i3 / 2) {
                i5 = i7 + i4 + 1;
            }
            int childCount = this.d.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                TextView textView = (TextView) this.d.getChildAt(i8);
                if (textView != null) {
                    if (i5 == i8) {
                        textView.setTextColor(Color.parseColor("#0288ce"));
                    } else {
                        textView.setTextColor(Color.parseColor("#bbbbbb"));
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void b() {
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            eq.b(this.i);
            this.i = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    public static void b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void a(String[] strArr) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.clear();
        for (String str : strArr) {
            this.f.add(str);
        }
        for (int i2 = 0; i2 < this.m; i2++) {
            this.f.add(0, "");
            this.f.add("");
        }
        e();
    }

    public void a(String str) {
        List<String> list = this.f;
        if (list != null && list.size() != 0) {
            int indexOf = this.f.indexOf(str);
            int size = this.f.size();
            int i2 = this.m;
            final int i3 = ((size - i2) - 1) - indexOf;
            this.b = i2 + i3;
            post(new Runnable() {
                /* class com.amap.api.mapcore.util.fb.AnonymousClass3 */

                public void run() {
                    fb fbVar = fb.this;
                    fbVar.smoothScrollTo(0, i3 * fbVar.e);
                }
            });
        }
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(View view) {
        b(view);
        return view.getMeasuredHeight();
    }

    public void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}

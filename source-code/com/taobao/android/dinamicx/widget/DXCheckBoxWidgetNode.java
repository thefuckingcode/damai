package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.taobao.android.dinamic.R$drawable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.ref.WeakReference;
import tb.c00;
import tb.ix;
import tb.vs;

/* compiled from: Taobao */
public class DXCheckBoxWidgetNode extends DXWidgetNode {
    public static final int ALREADY_INT_CHECK_IMG = R$id.already_int_check_img;
    public static final int ALREADY_INT_DIS_CHECK_IMG = R$id.already_int_dis_check_img;
    public static final int ALREADY_INT_DIS_UNCHECK_IMG = R$id.already_int_dis_uncheck_img;
    public static final int ALREADY_INT_UNCHECK_IMG = R$id.already_int_uncheck_img;
    public static final int NEED_INT_CHECK_IMG = R$id.need_int_check_img;
    public static final int NEED_INT_DIS_CHECK_IMG = R$id.need_int_dis_check_img;
    public static final int NEED_INT_DIS_UNCHECK_IMG = R$id.need_int_dis_uncheck_img;
    public static final int NEED_INT_UNCHECK_IMG = R$id.need_int_uncheck_img;
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g = false;
    private boolean h = false;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXCheckBoxWidgetNode();
        }
    }

    /* compiled from: Taobao */
    public static class b extends AsyncTask<Void, Void, Drawable[]> {
        String a = null;
        String b = null;
        String c = null;
        String d = null;
        private Context e;
        int f;
        int g;
        private WeakReference<AppCompatCheckBox> h;
        private boolean i;

        public b(AppCompatCheckBox appCompatCheckBox, String str, String str2, String str3, String str4, int i2, int i3, boolean z) {
            this.e = appCompatCheckBox.getContext().getApplicationContext();
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f = i2;
            this.g = i3;
            this.h = new WeakReference<>(appCompatCheckBox);
            this.i = z;
        }

        private Drawable c(Context context, int i2) {
            return context.getResources().getDrawable(i2);
        }

        private Drawable d(Context context, String str) {
            try {
                return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
            } catch (Throwable unused) {
                return null;
            }
        }

        private StateListDrawable e(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            return ix.a(drawable, drawable2, drawable3, drawable4);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NonNull
        private Drawable[] f() {
            Drawable d2 = d(this.e, this.a);
            if (d2 == null) {
                if (this.i) {
                    d2 = c(this.e, R$drawable.dark_dinamicx_checked);
                } else {
                    d2 = c(this.e, R$drawable.dinamicx_checked);
                }
            }
            Drawable h2 = h(d2, this.e, this.f, this.g);
            Drawable d3 = d(this.e, this.b);
            if (d3 == null) {
                if (this.i) {
                    d3 = c(this.e, R$drawable.dark_dinamicx_uncheck);
                } else {
                    d3 = c(this.e, R$drawable.dinamicx_uncheck);
                }
            }
            Drawable h3 = h(d3, this.e, this.f, this.g);
            Drawable d4 = d(this.e, this.c);
            if (d4 == null) {
                if (this.i) {
                    d4 = c(this.e, R$drawable.dark_dinamicx_discheck);
                } else {
                    d4 = c(this.e, R$drawable.dinamicx_discheck);
                }
            }
            Drawable h4 = h(d4, this.e, this.f, this.g);
            Drawable d5 = d(this.e, this.d);
            if (d5 == null) {
                if (this.i) {
                    d5 = c(this.e, R$drawable.dark_dinamicx_disunchk);
                } else {
                    d5 = c(this.e, R$drawable.dinamicx_disunchk);
                }
            }
            return new Drawable[]{h2, h3, h4, h(d5, this.e, this.f, this.g)};
        }

        private Drawable h(Drawable drawable, Context context, int i2, int i3) {
            if (!(drawable instanceof BitmapDrawable)) {
                return null;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, i2, i3, true));
            bitmapDrawable.setTargetDensity(bitmap.getDensity());
            return bitmapDrawable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Drawable[] doInBackground(Void... voidArr) {
            return f();
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void onPostExecute(Drawable[] drawableArr) {
            AppCompatCheckBox appCompatCheckBox = this.h.get();
            if (appCompatCheckBox != null) {
                String str = (String) appCompatCheckBox.getTag(DXCheckBoxWidgetNode.NEED_INT_CHECK_IMG);
                String str2 = (String) appCompatCheckBox.getTag(DXCheckBoxWidgetNode.NEED_INT_UNCHECK_IMG);
                String str3 = (String) appCompatCheckBox.getTag(DXCheckBoxWidgetNode.NEED_INT_DIS_CHECK_IMG);
                String str4 = (String) appCompatCheckBox.getTag(DXCheckBoxWidgetNode.NEED_INT_DIS_UNCHECK_IMG);
                if (str.equals(this.a) && str2.equals(this.b) && str3.equals(this.c) && str4.equals(this.d)) {
                    i(appCompatCheckBox, drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
                    appCompatCheckBox.setTag(DXCheckBoxWidgetNode.ALREADY_INT_CHECK_IMG, str);
                    appCompatCheckBox.setTag(DXCheckBoxWidgetNode.ALREADY_INT_UNCHECK_IMG, str2);
                    appCompatCheckBox.setTag(DXCheckBoxWidgetNode.ALREADY_INT_DIS_CHECK_IMG, str3);
                    appCompatCheckBox.setTag(DXCheckBoxWidgetNode.ALREADY_INT_DIS_UNCHECK_IMG, str4);
                }
            }
        }

        public void i(AppCompatCheckBox appCompatCheckBox, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            if (appCompatCheckBox != null) {
                appCompatCheckBox.setButtonDrawable(e(drawable, drawable2, drawable3, drawable4));
            }
        }
    }

    public DXCheckBoxWidgetNode() {
        this.accessibility = 1;
    }

    private void b(AppCompatCheckBox appCompatCheckBox) {
        String str = this.b;
        int i = ALREADY_INT_CHECK_IMG;
        String str2 = (String) appCompatCheckBox.getTag(i);
        if (str == null) {
            str = "dinamicx_checked";
        }
        String str3 = this.c;
        int i2 = ALREADY_INT_UNCHECK_IMG;
        String str4 = (String) appCompatCheckBox.getTag(i2);
        if (str3 == null) {
            str3 = "dinamicx_uncheck";
        }
        String str5 = this.d;
        int i3 = ALREADY_INT_DIS_CHECK_IMG;
        String str6 = (String) appCompatCheckBox.getTag(i3);
        if (str5 == null) {
            str5 = "dinamicx_discheck";
        }
        String str7 = this.e;
        int i4 = ALREADY_INT_DIS_UNCHECK_IMG;
        String str8 = (String) appCompatCheckBox.getTag(i4);
        if (str7 == null) {
            str7 = "dinamicx_disunchk";
        }
        if (needHandleDark()) {
            str = "dark_" + str;
            str3 = "dark_" + str3;
            str5 = "dark_" + str5;
            str7 = "dark_" + str7;
        }
        if (str2 == null && str4 == null && str6 == null && str8 == null) {
            appCompatCheckBox.setButtonDrawable((Drawable) null);
        }
        if (!str.equals(str2) || !str3.equals(str4) || !str5.equals(str6) || !str7.equals(str8)) {
            b bVar = new b(appCompatCheckBox, str, str3, str5, str7, getMeasuredWidth(), getMeasuredHeight(), needHandleDark());
            if (this.f) {
                appCompatCheckBox.setTag(NEED_INT_CHECK_IMG, str);
                appCompatCheckBox.setTag(NEED_INT_UNCHECK_IMG, str3);
                appCompatCheckBox.setTag(NEED_INT_DIS_CHECK_IMG, str5);
                appCompatCheckBox.setTag(NEED_INT_DIS_UNCHECK_IMG, str7);
                c00.q(bVar, new Void[0]);
                return;
            }
            Drawable[] f2 = bVar.f();
            bVar.i(appCompatCheckBox, f2[0], f2[1], f2[2], f2[3]);
            appCompatCheckBox.setTag(i, str);
            appCompatCheckBox.setTag(i2, str3);
            appCompatCheckBox.setTag(i3, str5);
            appCompatCheckBox.setTag(i4, str7);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXCheckBoxWidgetNode();
    }

    /* access modifiers changed from: protected */
    public void c(AppCompatCheckBox appCompatCheckBox, boolean z) {
        if (appCompatCheckBox != null) {
            this.g = true;
            appCompatCheckBox.setChecked(z);
            this.g = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean extraHandleDark() {
        return true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (-273786109416499313L == j) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (view != null && (view instanceof AppCompatCheckBox) && j == 5288679823228297259L) {
            ((AppCompatCheckBox) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.taobao.android.dinamicx.widget.DXCheckBoxWidgetNode.AnonymousClass1 */

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (!DXCheckBoxWidgetNode.this.g) {
                        vs vsVar = new vs(5288679823228297259L);
                        vsVar.g(z);
                        DXCheckBoxWidgetNode.this.postEvent(vsVar);
                    }
                }
            });
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXCheckBoxWidgetNode) {
            DXCheckBoxWidgetNode dXCheckBoxWidgetNode = (DXCheckBoxWidgetNode) dXWidgetNode;
            this.a = dXCheckBoxWidgetNode.a;
            this.enabled = dXCheckBoxWidgetNode.enabled;
            this.b = dXCheckBoxWidgetNode.b;
            this.c = dXCheckBoxWidgetNode.c;
            this.d = dXCheckBoxWidgetNode.d;
            this.e = dXCheckBoxWidgetNode.e;
            this.g = dXCheckBoxWidgetNode.g;
            this.f = dXCheckBoxWidgetNode.f;
            this.h = dXCheckBoxWidgetNode.h;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return this.h ? new AppCompatCheckBox(context, null, -1) : new AppCompatCheckBox(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int a2 = DXWidgetNode.DXMeasureSpec.a(i);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i2);
        boolean z = true;
        int i3 = 0;
        boolean z2 = a2 == 1073741824;
        if (a3 != 1073741824) {
            z = false;
        }
        int b2 = z2 ? DXWidgetNode.DXMeasureSpec.b(i) : 0;
        if (z) {
            i3 = DXWidgetNode.DXMeasureSpec.b(i2);
        }
        setMeasuredDimension(b2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null && (view instanceof AppCompatCheckBox)) {
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) view;
            boolean z = true;
            appCompatCheckBox.setClickable(true);
            if (getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
                appCompatCheckBox.setButtonDrawable((Drawable) null);
            } else {
                b(appCompatCheckBox);
            }
            if (this.a != 1) {
                z = false;
            }
            c(appCompatCheckBox, z);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (4729585112602995918L == j) {
            this.a = i;
        }
        boolean z = true;
        if (-273786109416499313L == j) {
            if (i == 0) {
                z = false;
            }
            this.f = z;
        } else if (j == 841016511269201341L) {
            if (i == 0) {
                z = false;
            }
            this.h = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (1748192772052832291L == j) {
            this.b = str;
        } else if (-2878833559981654264L == j) {
            this.c = str;
        } else if (-6932240350857271226L == j) {
            this.d = str;
        } else if (1972862905129200737L == j) {
            this.e = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}

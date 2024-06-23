package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.taobao.android.dinamic.R$drawable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import tb.c80;
import tb.dc0;
import tb.kk1;
import tb.q42;
import tb.s70;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class DCheckBoxConstructor extends DinamicViewAdvancedConstructor {
    private static final String D_CHECKED = "dChecked";
    private static final String D_CHECK_IMG = "dCheckImg";
    private static final String D_DISCHECK_IMG = "dDisCheckImg";
    private static final String D_DISUNCHECK_IMG = "dDisUnCheckImg";
    private static final String D_HEIGHT = "dHeight";
    private static final String D_UNCHECK_IMG = "dUncheckImg";
    private static final String D_WIDTH = "dWidth";
    private static final String VIEW_EVENT_ON_CHANGE = "onChange";
    public static final String VIEW_TAG = "DCheckBox";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class OnChangeListener implements CompoundButton.OnCheckedChangeListener {
        private x70 mDinamicParams;
        private b mHandler;
        private String mOnChangeExpression;
        private z70 mProperty;
        private View mView;

        public OnChangeListener(b bVar, x70 x70, z70 z70, View view) {
            this.mHandler = bVar;
            this.mDinamicParams = x70;
            this.mProperty = z70;
            this.mView = view;
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                this.mOnChangeExpression = map.get("onChange");
            }
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Object tag = compoundButton.getTag(R$id.change_with_attribute);
            if (!TextUtils.isEmpty(this.mOnChangeExpression) && !"true".equals(tag)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add(Boolean.valueOf(compoundButton.isChecked()));
                this.mView.setTag(c80.VIEW_PARAMS, arrayList);
                s70.d(this.mView, this.mDinamicParams, this.mProperty, this.mOnChangeExpression);
            }
        }
    }

    /* compiled from: Taobao */
    private static class b extends s70 {
        private b() {
        }

        @Override // tb.s70
        public void b(View view, x70 x70) {
            e(view, x70);
        }

        public void e(View view, x70 x70) {
            z70 z70 = (z70) view.getTag(c80.PROPERTY_KEY);
            if (z70 != null) {
                Map<String, String> map = z70.d;
                if (!map.isEmpty() && map.containsKey("onChange") && (view instanceof AppCompatCheckBox)) {
                    ((AppCompatCheckBox) view).setOnCheckedChangeListener(new OnChangeListener(this, x70, z70, view));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class c extends AsyncTask<Void, Void, Drawable[]> {
        String a = null;
        String b = null;
        String c = null;
        String d = null;
        private Context e;
        int f;
        int g;
        private WeakReference<AppCompatCheckBox> h;

        public c(AppCompatCheckBox appCompatCheckBox, String str, String str2, String str3, String str4, int i, int i2) {
            this.e = appCompatCheckBox.getContext().getApplicationContext();
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f = i;
            this.g = i2;
            this.h = new WeakReference<>(appCompatCheckBox);
        }

        private Drawable b(Context context, int i) {
            return context.getResources().getDrawable(i);
        }

        private Drawable c(Context context, String str) {
            try {
                return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
            } catch (Throwable unused) {
                return null;
            }
        }

        private StateListDrawable d(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            return dc0.a(drawable, drawable2, drawable3, drawable4);
        }

        private Drawable f(Drawable drawable, Context context, int i, int i2) {
            if (!(drawable instanceof BitmapDrawable)) {
                return null;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, i, i2, true));
            bitmapDrawable.setTargetDensity(bitmap.getDensity());
            return bitmapDrawable;
        }

        private void g(AppCompatCheckBox appCompatCheckBox, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            if (appCompatCheckBox != null) {
                appCompatCheckBox.setButtonDrawable(d(drawable, drawable2, drawable3, drawable4));
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable[] doInBackground(Void... voidArr) {
            Drawable c2 = c(this.e, this.a);
            if (c2 == null) {
                c2 = b(this.e, R$drawable.dinamicx_checked);
            }
            Drawable f2 = f(c2, this.e, this.f, this.g);
            Drawable c3 = c(this.e, this.b);
            if (c3 == null) {
                c3 = b(this.e, R$drawable.dinamicx_uncheck);
            }
            Drawable f3 = f(c3, this.e, this.f, this.g);
            Drawable c4 = c(this.e, this.c);
            if (c4 == null) {
                c4 = b(this.e, R$drawable.dinamicx_discheck);
            }
            Drawable f4 = f(c4, this.e, this.f, this.g);
            Drawable c5 = c(this.e, this.d);
            if (c5 == null) {
                c5 = b(this.e, R$drawable.dinamicx_disunchk);
            }
            return new Drawable[]{f2, f3, f4, f(c5, this.e, this.f, this.g)};
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void onPostExecute(Drawable[] drawableArr) {
            AppCompatCheckBox appCompatCheckBox = this.h.get();
            if (appCompatCheckBox != null) {
                String str = (String) appCompatCheckBox.getTag(c80.NEED_INT_CHECK_IMG);
                String str2 = (String) appCompatCheckBox.getTag(c80.NEED_INT_UNCHECK_IMG);
                String str3 = (String) appCompatCheckBox.getTag(c80.NEED_INT_DIS_CHECK_IMG);
                String str4 = (String) appCompatCheckBox.getTag(c80.NEED_INT_DIS_UNCHECK_IMG);
                if (str.equals(this.a) && str2.equals(this.b) && str3.equals(this.c) && str4.equals(this.d)) {
                    g(appCompatCheckBox, drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
                    appCompatCheckBox.setTag(c80.ALREADY_INT_CHECK_IMG, str);
                    appCompatCheckBox.setTag(c80.ALREADY_INT_UNCHECK_IMG, str2);
                    appCompatCheckBox.setTag(c80.ALREADY_INT_DIS_CHECK_IMG, str3);
                    appCompatCheckBox.setTag(c80.ALREADY_INT_DIS_UNCHECK_IMG, str4);
                }
            }
        }
    }

    private int getDefaultSize(Context context) {
        return (int) TypedValue.applyDimension(1, 17.0f, context.getResources().getDisplayMetrics());
    }

    private void setEnable(View view, boolean z) {
        view.setEnabled(z);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        getDefaultSize(context);
        AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(context, attributeSet);
        appCompatCheckBox.setClickable(true);
        return appCompatCheckBox;
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        int i;
        int i2;
        super.setAttributes(view, map, arrayList, x70);
        AppCompatCheckBox appCompatCheckBox = view instanceof AppCompatCheckBox ? (AppCompatCheckBox) view : null;
        if (arrayList.contains("dWidth") || arrayList.contains("dHeight") || arrayList.contains(D_CHECK_IMG) || arrayList.contains(D_UNCHECK_IMG) || arrayList.contains(D_DISCHECK_IMG) || arrayList.contains(D_DISUNCHECK_IMG)) {
            int defaultSize = getDefaultSize(view.getContext());
            int defaultSize2 = getDefaultSize(view.getContext());
            Object obj = map.get("dWidth");
            Object obj2 = map.get("dHeight");
            int b2 = q42.b(view.getContext(), obj, -1);
            int b3 = q42.b(view.getContext(), obj2, -1);
            if (b2 == -1 || b3 == -1) {
                i2 = defaultSize2;
                i = defaultSize;
            } else {
                i = b3;
                i2 = b2;
            }
            String str = (String) map.get(D_CHECK_IMG);
            String str2 = (String) view.getTag(c80.ALREADY_INT_CHECK_IMG);
            if (str == null) {
                str = "dinamicx_checked";
            }
            String str3 = (String) map.get(D_UNCHECK_IMG);
            String str4 = (String) view.getTag(c80.ALREADY_INT_UNCHECK_IMG);
            if (str3 == null) {
                str3 = "dinamicx_uncheck";
            }
            String str5 = (String) map.get(D_DISCHECK_IMG);
            String str6 = (String) view.getTag(c80.ALREADY_INT_DIS_CHECK_IMG);
            if (str5 == null) {
                str5 = "dinamicx_discheck";
            }
            String str7 = (String) map.get(D_DISUNCHECK_IMG);
            String str8 = (String) view.getTag(c80.ALREADY_INT_DIS_UNCHECK_IMG);
            if (str7 == null) {
                str7 = "dinamicx_disunchk";
            }
            if (str2 == null && str4 == null && str6 == null && str8 == null) {
                appCompatCheckBox.setButtonDrawable((Drawable) null);
            }
            if (!str.equals(str2) || !str3.equals(str4) || !str5.equals(str6) || !str7.equals(str8)) {
                view.setTag(c80.NEED_INT_CHECK_IMG, str);
                view.setTag(c80.NEED_INT_UNCHECK_IMG, str3);
                view.setTag(c80.NEED_INT_DIS_CHECK_IMG, str5);
                view.setTag(c80.NEED_INT_DIS_UNCHECK_IMG, str7);
                new c(appCompatCheckBox, str, str3, str5, str7, i2, i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
        if (arrayList.contains(D_CHECKED)) {
            setChecked(appCompatCheckBox, kk1.b((String) map.get(D_CHECKED)));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ENABLED)) {
            String str9 = (String) map.get(DAttrConstant.VIEW_ENABLED);
            if (!TextUtils.isEmpty(str9)) {
                setEnable(view, kk1.b(str9));
            } else {
                setEnable(view, true);
            }
        }
    }

    public void setChecked(AppCompatCheckBox appCompatCheckBox, boolean z) {
        if (appCompatCheckBox != null) {
            int i = R$id.change_with_attribute;
            appCompatCheckBox.setTag(i, "true");
            appCompatCheckBox.setChecked(z);
            appCompatCheckBox.setTag(i, "false");
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, x70 x70) {
        new b().b(view, x70);
    }
}

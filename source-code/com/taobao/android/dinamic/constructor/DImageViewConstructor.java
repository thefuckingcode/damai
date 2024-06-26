package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import tb.c80;
import tb.sp;
import tb.x70;

/* compiled from: Taobao */
public class DImageViewConstructor extends DinamicViewAdvancedConstructor {
    public static final String HEIGHT_LIMIT = "heightLimit";
    private static final String IMAGEVIEW_ASPECT_RATIO = "dAspectRatio";
    private static final String IMAGEVIEW_IMAGE_URL = "dImageUrl";
    private static final String IMAGEVIEW_LOCAL_IMAGE = "dImage";
    private static final String IMAGEVIEW_LOCAL_IMAGE_NAME = "dImageName";
    private static final String IMAGEVIEW_SCALE_TYPE = "dScaleType";
    private static final String IMAGEVIEW_SCALE_TYPE_CENTER_CROP = "centerCrop";
    private static final String IMAGEVIEW_SCALE_TYPE_FIT_CENTER = "fitCenter";
    private static final String IMAGEVIEW_SCALE_TYPE_FIT_XY = "fitXY";
    public static final String TAG = "DImageViewConstructor";
    public static final String WIDTH_LIMIT = "widthLimit";
    private DXWebImageInterface dxWebImageInterface;

    /* compiled from: Taobao */
    public interface DXWebImageInterface {
        ImageView buildView(Context context);

        void setImage(ImageView imageView, String str, a aVar);
    }

    /* compiled from: Taobao */
    public static class a {
        public float a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;

        public boolean g() {
            return this.e;
        }
    }

    /* compiled from: Taobao */
    public static class b extends AsyncTask<Void, Void, Drawable> {
        private String a;
        private WeakReference<ImageView> b;
        private Context c;

        public b(ImageView imageView, String str) {
            this.b = new WeakReference<>(imageView);
            this.a = str;
            this.c = imageView.getContext().getApplicationContext();
        }

        private int b(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            } catch (Exception e) {
                Log.e(DImageViewConstructor.TAG, "getDrawableId exception", e);
                return 0;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            Drawable drawable;
            int b2 = b(this.c, this.a);
            if (b2 == 0) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.c.getDrawable(b2);
                } else {
                    drawable = this.c.getResources().getDrawable(b2);
                }
                return drawable;
            } catch (Exception e) {
                Log.e(DImageViewConstructor.TAG, "Get layout parser exception", e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Drawable drawable) {
            ImageView imageView = this.b.get();
            if (imageView != null) {
                if (this.a.equals((String) imageView.getTag(c80.TAG_CURRENT_IMAGE_NAME))) {
                    imageView.setImageDrawable(drawable);
                    imageView.setTag(c80.TAG_IMAGE_NAME, this.a);
                }
            }
        }
    }

    private void setImage(ImageView imageView, String str, a aVar) {
        DXWebImageInterface dXWebImageInterface = this.dxWebImageInterface;
        if (dXWebImageInterface != null) {
            dXWebImageInterface.setImage(imageView, str, aVar);
        }
    }

    private void setLocalImage(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        DXWebImageInterface dXWebImageInterface = this.dxWebImageInterface;
        if (dXWebImageInterface == null) {
            return new ImageView(context);
        }
        return dXWebImageInterface.buildView(context);
    }

    /* access modifiers changed from: protected */
    public void setAspectRatio(ImageView imageView, String str, String str2, String str3, a aVar) {
        boolean z = !TextUtils.equals(str, DAttrConstant.MATCH_CONTENT) && TextUtils.equals(str2, DAttrConstant.MATCH_CONTENT);
        if (z || (TextUtils.equals(str, DAttrConstant.MATCH_CONTENT) && !TextUtils.equals(str2, DAttrConstant.MATCH_CONTENT))) {
            double d = -1.0d;
            try {
                if (!TextUtils.isEmpty(str3)) {
                    d = Double.valueOf(str3).doubleValue();
                }
            } catch (Throwable unused) {
            }
            if (z) {
                if (d > 0.0d) {
                    aVar.a = (float) (1.0d / d);
                    aVar.g = true;
                } else if (imageView.getLayoutParams() != null) {
                    imageView.getLayoutParams().height = 0;
                }
            } else if (d > 0.0d) {
                aVar.a = (float) d;
                aVar.g = true;
            } else if (imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().width = 0;
            }
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
        ImageView imageView = (ImageView) view;
        if (arrayList.contains("dImage")) {
            setLocalImage(imageView, (Drawable) map.get("dImage"));
        }
        if (arrayList.contains(IMAGEVIEW_LOCAL_IMAGE_NAME)) {
            setLocalRes(imageView, (String) map.get(IMAGEVIEW_LOCAL_IMAGE_NAME));
        }
        if (arrayList.contains("dScaleType")) {
            setImageScaleType(imageView, (String) map.get("dScaleType"));
        }
        String str = (String) map.get(DAttrConstant.VIEW_WIDTH);
        String str2 = (String) map.get(DAttrConstant.VIEW_HEIGHT);
        a aVar = new a();
        x70.c();
        if (TextUtils.equals(str, DAttrConstant.MATCH_CONTENT) && !TextUtils.equals(str2, DAttrConstant.MATCH_CONTENT)) {
            aVar.e = true;
            imageView.setAdjustViewBounds(true);
        } else if (!TextUtils.equals(str, DAttrConstant.MATCH_CONTENT) && TextUtils.equals(str2, DAttrConstant.MATCH_CONTENT)) {
            aVar.e = true;
            imageView.setAdjustViewBounds(true);
        }
        if (arrayList.contains(IMAGEVIEW_ASPECT_RATIO)) {
            setAspectRatio(imageView, str, str2, (String) map.get(IMAGEVIEW_ASPECT_RATIO), aVar);
            if (aVar.g()) {
                setImageScaleType(imageView, (String) map.get("dScaleType"));
            }
        }
        if (arrayList.contains(DAttrConstant.VIEW_CORNER_RADIUS)) {
            String str3 = (String) map.get(DAttrConstant.VIEW_CORNER_RADIUS);
            aVar.d = true;
        }
        if (arrayList.contains(DAttrConstant.VIEW_BORDER_COLOR)) {
            String str4 = (String) map.get(DAttrConstant.VIEW_BORDER_COLOR);
            aVar.b = true;
        }
        if (arrayList.contains(DAttrConstant.VIEW_BORDER_WIDTH)) {
            String str5 = (String) map.get(DAttrConstant.VIEW_BORDER_WIDTH);
            aVar.c = true;
        }
        if (arrayList.contains("dImageUrl")) {
            aVar.f = true;
        }
        setImage(imageView, (String) map.get("dImageUrl"), aVar);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setBackground(View view, String str, String str2, String str3, String str4) {
        view.setBackgroundColor(sp.d(str4, 0));
    }

    public void setDxWebImageInterface(DXWebImageInterface dXWebImageInterface) {
        this.dxWebImageInterface = dXWebImageInterface;
    }

    /* access modifiers changed from: protected */
    public void setImageScaleType(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (IMAGEVIEW_SCALE_TYPE_FIT_XY.equals(str)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (IMAGEVIEW_SCALE_TYPE_FIT_CENTER.equals(str)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (IMAGEVIEW_SCALE_TYPE_CENTER_CROP.equals(str)) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    /* access modifiers changed from: protected */
    public void setLocalRes(ImageView imageView, String str) {
        imageView.setTag(c80.TAG_CURRENT_IMAGE_NAME, str);
        if (str == null) {
            imageView.setImageDrawable(null);
            imageView.setTag(c80.TAG_IMAGE_NAME, null);
        } else if (!str.equals((String) imageView.getTag(c80.TAG_IMAGE_NAME))) {
            new b(imageView, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}

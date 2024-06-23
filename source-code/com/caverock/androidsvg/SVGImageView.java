package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.real.androidsvg.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class SVGImageView extends AppCompatImageView {
    private static Method setLayerTypeMethod;
    private d renderOptions = new d();
    private SVG svg = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b extends AsyncTask<Integer, Integer, SVG> {
        private Context a;
        private int b;

        b(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.i(this.a, this.b);
            } catch (SVGParseException e) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.b), e.getMessage()));
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c extends AsyncTask<InputStream, Integer, SVG> {
        private c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public SVG doInBackground(InputStream... inputStreamArr) {
            try {
                SVG h = SVG.h(inputStreamArr[0]);
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused) {
                }
                return h;
            } catch (SVGParseException e) {
                Log.e("SVGImageView", "Parse error loading URI: " + e.getMessage());
                try {
                    inputStreamArr[0].close();
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    static {
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doRender() {
        SVG svg2 = this.svg;
        if (svg2 != null) {
            Picture o = svg2.o(this.renderOptions);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(o));
        }
    }

    private void init(AttributeSet attributeSet, int i) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i, 0);
            try {
                String string = obtainStyledAttributes.getString(R.styleable.SVGImageView_css);
                if (string != null) {
                    this.renderOptions.a(string);
                }
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SVGImageView_svg, -1);
                if (resourceId != -1) {
                    setImageResource(resourceId);
                    return;
                }
                String string2 = obtainStyledAttributes.getString(R.styleable.SVGImageView_svg);
                if (string2 != null) {
                    if (internalSetImageURI(Uri.parse(string2))) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else if (internalSetImageAsset(string2)) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else {
                        setFromString(string2);
                    }
                }
                obtainStyledAttributes.recycle();
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private boolean internalSetImageAsset(String str) {
        try {
            InputStream open = getContext().getAssets().open(str);
            new c().execute(open);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean internalSetImageURI(Uri uri) {
        try {
            InputStream openInputStream = getContext().getContentResolver().openInputStream(uri);
            new c().execute(openInputStream);
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private void setFromString(String str) {
        try {
            this.svg = SVG.k(str);
            doRender();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod != null) {
            try {
                int i = View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()));
                setLayerTypeMethod.invoke(this, Integer.valueOf(i), null);
            } catch (Exception e) {
                Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
            }
        }
    }

    public void setCSS(String str) {
        this.renderOptions.a(str);
        doRender();
    }

    public void setImageAsset(String str) {
        if (!internalSetImageAsset(str)) {
            Log.e("SVGImageView", "File not found: " + str);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int i) {
        new b(getContext(), i).execute(new Integer[0]);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageURI(Uri uri) {
        if (!internalSetImageURI(uri)) {
            Log.e("SVGImageView", "File not found: " + uri);
        }
    }

    public void setSVG(SVG svg2) {
        if (svg2 != null) {
            this.svg = svg2;
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        init(attributeSet, 0);
    }

    public void setSVG(SVG svg2, String str) {
        if (svg2 != null) {
            this.svg = svg2;
            this.renderOptions.a(str);
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }
}

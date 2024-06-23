package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;
import com.youku.style.IStyle;
import com.youku.style.StyleVisitor;
import java.util.Map;
import tb.i42;
import tb.qg0;
import tb.ug2;

/* compiled from: Taobao */
public class YKAtmosphereImageView extends TUrlImageView implements IStyle {
    protected boolean colorOnly = false;
    protected int defaultColor;
    protected int defaultImage = R.drawable.yk_top_bg_layer;
    private ViewTreeObserver.OnGlobalLayoutListener listener;
    private ColorDrawable mColorDrawable;
    protected boolean mForceLoadUrl = false;
    private int mHeight;
    private int mStyleBgColor = 0;
    private int mWidth;

    public YKAtmosphereImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet, i);
    }

    public void destoryView() {
        this.mColorDrawable = null;
    }

    /* access modifiers changed from: protected */
    public void display(String str) {
        if (!TextUtils.equals(getImageUrl(), str) || this.mForceLoadUrl) {
            int i = this.mStyleBgColor;
            if (i != 0) {
                setAtmosphereColor(i);
            } else {
                setImageUrl(null);
            }
            setImageUrl(str);
            succListener(new IPhenixListener<ug2>() {
                /* class com.youku.resource.widget.YKAtmosphereImageView.AnonymousClass2 */

                public boolean onHappen(ug2 ug2) {
                    if (ug2 != null) {
                        if (ug2.f() != null && !ug2.i()) {
                            YKAtmosphereImageView.this.reScale(ug2.f());
                            YKAtmosphereImageView.this.mForceLoadUrl = false;
                        } else if (ug2.f() != null) {
                            YKAtmosphereImageView.this.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    }
                    return false;
                }
            });
            failListener(new IPhenixListener<qg0>() {
                /* class com.youku.resource.widget.YKAtmosphereImageView.AnonymousClass3 */

                public boolean onHappen(qg0 qg0) {
                    if (YKAtmosphereImageView.this.mStyleBgColor != 0) {
                        YKAtmosphereImageView yKAtmosphereImageView = YKAtmosphereImageView.this;
                        yKAtmosphereImageView.setAtmosphereColor(yKAtmosphereImageView.mStyleBgColor);
                        return false;
                    }
                    YKAtmosphereImageView yKAtmosphereImageView2 = YKAtmosphereImageView.this;
                    if (yKAtmosphereImageView2.defaultImage == 0 || yKAtmosphereImageView2.getResources() == null) {
                        YKAtmosphereImageView.this.mColorDrawable.setColor(YKAtmosphereImageView.this.defaultColor);
                        YKAtmosphereImageView yKAtmosphereImageView3 = YKAtmosphereImageView.this;
                        yKAtmosphereImageView3.setPlaceHoldForeground(yKAtmosphereImageView3.mColorDrawable);
                        YKAtmosphereImageView.this.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        YKAtmosphereImageView yKAtmosphereImageView4 = YKAtmosphereImageView.this;
                        yKAtmosphereImageView4.setPlaceHoldForeground(yKAtmosphereImageView4.getResources().getDrawable(YKAtmosphereImageView.this.defaultImage));
                        YKAtmosphereImageView.this.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    YKAtmosphereImageView.this.setImageUrl(null);
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initView(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YKAtmosphereImageView, i, 0);
            try {
                this.defaultColor = obtainStyledAttributes.getColor(R.styleable.YKAtmosphereImageView_default_color, context.getResources().getColor(R.color.ykn_deep_black_gradient_top_point));
                boolean z = obtainStyledAttributes.getBoolean(R.styleable.YKAtmosphereImageView_color_only, false);
                this.colorOnly = z;
                if (z) {
                    this.defaultImage = 0;
                } else {
                    this.defaultImage = obtainStyledAttributes.getResourceId(R.styleable.YKAtmosphereImageView_default_image, R.drawable.yk_top_bg_layer);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mColorDrawable = new ColorDrawable();
        initViewSize(context);
        setAutoRelease(false);
        restoreToDefault();
    }

    /* access modifiers changed from: protected */
    public void initViewSize(Context context) {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.youku.resource.widget.YKAtmosphereImageView.AnonymousClass1 */

            public void onGlobalLayout() {
                YKAtmosphereImageView yKAtmosphereImageView = YKAtmosphereImageView.this;
                yKAtmosphereImageView.mWidth = yKAtmosphereImageView.getWidth();
                YKAtmosphereImageView yKAtmosphereImageView2 = YKAtmosphereImageView.this;
                yKAtmosphereImageView2.mHeight = yKAtmosphereImageView2.getHeight();
                if (Build.VERSION.SDK_INT >= 16) {
                    YKAtmosphereImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    YKAtmosphereImageView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void reScale(BitmapDrawable bitmapDrawable) {
        Matrix matrix = new Matrix();
        int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
        int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
        int height = getHeight() == 0 ? this.mHeight : getHeight();
        float width = ((float) (getWidth() == 0 ? this.mWidth : getWidth())) / ((float) intrinsicWidth);
        matrix.setScale(width, width);
        float f = ((float) intrinsicHeight) * width;
        float f2 = (float) height;
        if (f >= f2) {
            matrix.postTranslate(0.0f, f2 - f);
            setScaleType(ImageView.ScaleType.MATRIX);
            setImageMatrix(matrix);
            return;
        }
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.youku.style.IStyle
    public void resetStyle() {
        setAtmosphereUrl(null);
    }

    public void restoreToDefault() {
        if (this.defaultImage == 0 || getResources() == null) {
            setAtmosphereColor(this.defaultColor);
        } else if (!TextUtils.equals(getImageUrl(), i42.r(this.defaultImage))) {
            setPlaceHoldForeground(getResources().getDrawable(this.defaultImage));
            setImageUrl(null);
            setScaleType(ImageView.ScaleType.FIT_XY);
            succListener(null);
            failListener(null);
        }
    }

    public void setAtmosphereColor(int i) {
        ColorDrawable colorDrawable = this.mColorDrawable;
        if (colorDrawable != null) {
            if (colorDrawable.getColor() != i) {
                this.mColorDrawable.setColor(i);
            }
            setPlaceHoldForeground(this.mColorDrawable);
            setImageUrl(null);
            setScaleType(ImageView.ScaleType.CENTER_CROP);
            succListener(null);
            failListener(null);
        }
    }

    public void setAtmosphereLocalFile(String str) {
        display(i42.q(str));
    }

    public void setAtmosphereUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            restoreToDefault();
        } else {
            display(str);
        }
    }

    public void setColorOnly(boolean z) {
        this.colorOnly = z;
    }

    public void setDefaultColor(int i) {
        this.defaultColor = i;
    }

    public void setDefaultImage(int i) {
        this.defaultImage = i;
    }

    public void setForceLoadUrl(boolean z) {
        this.mForceLoadUrl = z;
    }

    @Override // com.youku.style.IStyle
    public void setStyle(Map map) {
        StyleVisitor styleVisitor = new StyleVisitor(map);
        if (map == null) {
            return;
        }
        if (!styleVisitor.isSkin()) {
            if (styleVisitor.hasStyleStringValue("navBgColor")) {
                this.mStyleBgColor = styleVisitor.getStyleColor("navBgColor");
            } else {
                this.mStyleBgColor = 0;
            }
            if (styleVisitor.hasStyleStringValue(IStyle.NAV_BG_URL_IMG)) {
                setAtmosphereUrl(styleVisitor.getStyleStringValue(IStyle.NAV_BG_URL_IMG));
            } else if (styleVisitor.hasStyleStringValue("navBgColor")) {
                setAtmosphereColor(styleVisitor.getStyleColor("navBgColor"));
            } else {
                setAtmosphereUrl(null);
            }
        } else if (styleVisitor.hasStyleStringValue("home_nav_bg_l.png")) {
            setAtmosphereLocalFile(styleVisitor.getStyleStringValue("home_nav_bg_l.png"));
        } else if (styleVisitor.hasStyleStringValue("navBgColor")) {
            setAtmosphereColor(styleVisitor.getStyleColor("navBgColor"));
        } else {
            setAtmosphereUrl(null);
        }
    }

    public YKAtmosphereImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet, 0);
    }

    public YKAtmosphereImageView(Context context) {
        super(context);
        initView(context, null, 0);
    }
}

package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.u50;

/* compiled from: Taobao */
public class DMRatingBar extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DMRatingBar";
    float descent;
    int downX;
    boolean eventAction;
    private Paint highLightTextPaint;
    private boolean integerMark;
    private boolean isDrag;
    private boolean isIndicator;
    private boolean isShow;
    private int[] location;
    private Context mContext;
    private a mHandler;
    private List<String> mStarContent;
    private float minMarks;
    private OnStarChangeListener onStarChangeListener;
    private Paint paint;
    private View popWindowView;
    private PopupWindow popupWindow;
    private int starCount;
    private int starDistance;
    private Drawable starEmptyDrawable;
    private Bitmap starFillBitmap;
    private float starMark;
    private int starSize;
    private Paint textPaint;
    private boolean tipMark;
    private TextView tvTipGrade;

    /* compiled from: Taobao */
    public interface OnStarChangeListener {
        void onEventActionUp();

        void onStarChange(float f);
    }

    /* compiled from: Taobao */
    public class a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1573817050")) {
                ipChange.ipc$dispatch("1573817050", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            if (message.what == 1000) {
                DMRatingBar.this.dismissPop();
            }
        }
    }

    public DMRatingBar(Context context) {
        super(context);
        this.starDistance = 0;
        this.starCount = 5;
        this.starMark = 0.0f;
        this.integerMark = false;
        this.minMarks = 0.0f;
        this.tipMark = false;
        this.mStarContent = new ArrayList();
        this.isDrag = false;
        this.location = new int[2];
        this.eventAction = false;
        this.downX = 0;
        init(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissPop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926444555")) {
            ipChange.ipc$dispatch("-1926444555", new Object[]{this});
        } else if (!this.eventAction) {
            this.popupWindow.dismiss();
        }
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036144694")) {
            return (Bitmap) ipChange.ipc$dispatch("2036144694", new Object[]{this, drawable});
        }
        if (drawable == null || (i = this.starSize) == 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i2 = this.starSize;
        drawable.setBounds(0, 0, i2, i2);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565055438")) {
            ipChange.ipc$dispatch("-1565055438", new Object[]{this, context, attributeSet});
            return;
        }
        this.mContext = context;
        this.mStarContent.add("极差");
        this.mStarContent.add("较差");
        this.mStarContent.add("一般");
        this.mStarContent.add("不错");
        this.mStarContent.add("很棒");
        setClickable(true);
        u50 u50 = u50.INSTANCE;
        this.starSize = u50.b(context, 20);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DMBRatingBar);
            this.starDistance = (int) obtainStyledAttributes.getDimension(R$styleable.DMBRatingBar_starDistance, 10.0f);
            this.starSize = (int) obtainStyledAttributes.getDimension(R$styleable.DMBRatingBar_starSize, 20.0f);
            this.starCount = obtainStyledAttributes.getInteger(R$styleable.DMBRatingBar_starCount, 5);
            this.starEmptyDrawable = obtainStyledAttributes.getDrawable(R$styleable.DMBRatingBar_starEmpty);
            this.starFillBitmap = drawableToBitmap(obtainStyledAttributes.getDrawable(R$styleable.DMBRatingBar_starFill));
            this.isShow = obtainStyledAttributes.getBoolean(R$styleable.DMBRatingBar_showText, false);
            this.isIndicator = obtainStyledAttributes.getBoolean(R$styleable.DMBRatingBar_isIndicator, false);
            this.integerMark = obtainStyledAttributes.getBoolean(R$styleable.DMBRatingBar_integerMark, false);
            this.tipMark = obtainStyledAttributes.getBoolean(R$styleable.DMBRatingBar_tipMark, false);
            obtainStyledAttributes.recycle();
        }
        if (this.starFillBitmap == null) {
            this.starFillBitmap = drawableToBitmap(getContext().getResources().getDrawable(R$drawable.bricks_rating_fill));
        }
        if (this.starEmptyDrawable == null) {
            this.starEmptyDrawable = getContext().getResources().getDrawable(R$drawable.bricks_rating_empty);
        }
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = this.paint;
        Bitmap bitmap = this.starFillBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint3.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Paint paint4 = new Paint();
        this.textPaint = paint4;
        paint4.setAntiAlias(true);
        this.textPaint.setColor(Color.parseColor("#888888"));
        this.textPaint.setTextSize((float) u50.b(getContext(), 13));
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint5 = new Paint();
        this.highLightTextPaint = paint5;
        paint5.setAntiAlias(true);
        this.highLightTextPaint.setColor(Color.parseColor("#000000"));
        this.highLightTextPaint.setTextSize((float) u50.b(getContext(), 13));
        this.highLightTextPaint.setTextAlign(Paint.Align.CENTER);
        this.descent = this.textPaint.getFontMetrics().descent;
        popWindowInit();
    }

    private void popWindowInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1631388963")) {
            ipChange.ipc$dispatch("-1631388963", new Object[]{this});
            return;
        }
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R$layout.bricks_uikit_star_pop_layout, (ViewGroup) null, false);
        this.popWindowView = inflate;
        this.tvTipGrade = (TextView) inflate.findViewById(R$id.tip_grade);
        ((ImageView) this.popWindowView.findViewById(R$id.uikit_first)).setImageBitmap(this.starFillBitmap);
        this.popupWindow = new PopupWindow(this.popWindowView, -2, -2, true);
        this.mHandler = new a();
    }

    private void showPop(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501258236")) {
            ipChange.ipc$dispatch("1501258236", new Object[]{this, str, Float.valueOf(f)});
            return;
        }
        TextView textView = this.tvTipGrade;
        textView.setText(str + "星");
        this.popWindowView.measure(0, 0);
        int measuredWidth = this.popWindowView.getMeasuredWidth();
        this.popWindowView.getMeasuredHeight();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        float f2 = ((float) (iArr[1] - this.starSize)) - this.descent;
        int i = 20;
        Context context = this.mContext;
        if (context != null) {
            i = u50.INSTANCE.b(context, 8);
        }
        if (this.popupWindow.isShowing()) {
            this.popupWindow.update(((int) f) - i, (int) f2, measuredWidth, -2);
        } else {
            this.popupWindow.showAtLocation(this, 0, ((int) f) - i, (int) f2);
        }
    }

    public float getStarMark() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-527685847")) {
            return this.starMark;
        }
        return ((Float) ipChange.ipc$dispatch("-527685847", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "2053870572")) {
            ipChange.ipc$dispatch("2053870572", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        int i2 = 0;
        while (i2 < this.starCount) {
            Drawable drawable = this.starEmptyDrawable;
            int i3 = this.starDistance;
            int i4 = this.starSize;
            drawable.setBounds((i3 + i4) * i2, 0, ((i3 + i4) * i2) + i4, i4);
            this.starEmptyDrawable.draw(canvas);
            float f = (float) (this.starSize / 2);
            float f2 = this.starMark;
            boolean z = f2 > 0.0f && i2 == ((int) Math.ceil((double) f2)) - 1;
            if (this.isShow) {
                if (z) {
                    canvas.drawText(String.valueOf(this.starMark * 2.0f), ((float) ((this.starDistance + this.starSize) * i2)) + f, ((float) getMeasuredHeight()) - this.descent, this.highLightTextPaint);
                } else {
                    canvas.drawText(this.mStarContent.get(i2), ((float) ((this.starDistance + this.starSize) * i2)) + f, ((float) getMeasuredHeight()) - this.descent, this.textPaint);
                }
            }
            if (this.tipMark) {
                int left = getLeft();
                int[] iArr = this.location;
                if (iArr[0] != 0) {
                    left = iArr[0];
                }
                if (z && this.eventAction) {
                    showPop(String.valueOf(this.starMark), ((float) (left + ((this.starDistance + this.starSize) * i2))) + f);
                }
            }
            i2++;
        }
        float f3 = this.starMark;
        if (f3 > 1.0f) {
            int i5 = this.starSize;
            canvas.drawRect(0.0f, 0.0f, (float) i5, (float) i5, this.paint);
            float f4 = this.starMark;
            if (f4 - ((float) ((int) f4)) == 0.0f) {
                while (((float) i) < this.starMark) {
                    canvas.translate((float) (this.starDistance + this.starSize), 0.0f);
                    int i6 = this.starSize;
                    canvas.drawRect(0.0f, 0.0f, (float) i6, (float) i6, this.paint);
                    i++;
                }
                return;
            }
            while (((float) i) < this.starMark - 1.0f) {
                canvas.translate((float) (this.starDistance + this.starSize), 0.0f);
                int i7 = this.starSize;
                canvas.drawRect(0.0f, 0.0f, (float) i7, (float) i7, this.paint);
                i++;
            }
            canvas.translate((float) (this.starDistance + this.starSize), 0.0f);
            float f5 = this.starMark;
            canvas.drawRect(0.0f, 0.0f, ((((float) Math.round((f5 - ((float) ((int) f5))) * 10.0f)) * 1.0f) / 10.0f) * ((float) this.starSize), (float) this.starSize, this.paint);
            return;
        }
        int i8 = this.starSize;
        canvas.drawRect(0.0f, 0.0f, ((float) i8) * f3, (float) i8, this.paint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921555697")) {
            ipChange.ipc$dispatch("-921555697", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int i3 = this.starSize;
        int i4 = this.starCount;
        int i5 = (i3 * i4) + (this.starDistance * (i4 - 1));
        if (!this.isIndicator && this.isShow) {
            i3 = i3 + ((int) this.textPaint.getTextSize()) + u50.INSTANCE.b(getContext(), 15);
        }
        setMeasuredDimension(i5, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367158907")) {
            return ((Boolean) ipChange.ipc$dispatch("1367158907", new Object[]{this, motionEvent})).booleanValue();
        } else if (this.isIndicator) {
            return true;
        } else {
            int x = (int) motionEvent.getX();
            if (x < 0) {
                x = 0;
            }
            if (x > getMeasuredWidth()) {
                x = getMeasuredWidth();
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.downX = x;
                setStarMark((((float) x) * 1.0f) / ((((float) getMeasuredWidth()) * 1.0f) / ((float) this.starCount)));
            } else if (action == 1) {
                this.eventAction = false;
                this.mHandler.sendEmptyMessageDelayed(1000, 100);
                OnStarChangeListener onStarChangeListener2 = this.onStarChangeListener;
                if (onStarChangeListener2 != null) {
                    onStarChangeListener2.onEventActionUp();
                }
            } else if (action == 2) {
                if (this.downX != x) {
                    this.eventAction = true;
                    this.isDrag = true;
                }
                setStarMark((((float) x) * 1.0f) / ((((float) getMeasuredWidth()) * 1.0f) / ((float) this.starCount)));
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            invalidate();
            return super.onTouchEvent(motionEvent);
        }
    }

    public void setIntegerMark(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525234175")) {
            ipChange.ipc$dispatch("-1525234175", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.integerMark = z;
    }

    public void setIsIndicator(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408263205")) {
            ipChange.ipc$dispatch("-1408263205", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isIndicator = z;
        invalidate();
    }

    public void setLocation(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29468183")) {
            ipChange.ipc$dispatch("29468183", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int[] iArr = this.location;
        iArr[0] = i;
        iArr[1] = i2;
    }

    public void setMarkDrawable(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "896100737")) {
            ipChange.ipc$dispatch("896100737", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i != 0) {
            this.starFillBitmap = drawableToBitmap(getContext().getResources().getDrawable(i));
            Paint paint2 = this.paint;
            Bitmap bitmap = this.starFillBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        }
        if (i2 != 0) {
            this.starEmptyDrawable = getContext().getResources().getDrawable(i2);
        }
        if (!this.isIndicator) {
            popWindowInit();
        }
    }

    public void setMinMark(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020923777")) {
            ipChange.ipc$dispatch("1020923777", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.minMarks = f;
        invalidate();
    }

    public void setOnStarChangeListener(OnStarChangeListener onStarChangeListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648277448")) {
            ipChange.ipc$dispatch("-648277448", new Object[]{this, onStarChangeListener2});
            return;
        }
        this.onStarChangeListener = onStarChangeListener2;
    }

    public void setShowText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667331538")) {
            ipChange.ipc$dispatch("1667331538", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShow = z;
        invalidate();
    }

    public void setShowTipMark(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510495521")) {
            ipChange.ipc$dispatch("1510495521", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.tipMark = z;
        invalidate();
    }

    public void setStarCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211376034")) {
            ipChange.ipc$dispatch("211376034", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.starCount = i;
        requestLayout();
        invalidate();
    }

    public void setStarDistance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886024606")) {
            ipChange.ipc$dispatch("886024606", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.starDistance = i;
    }

    public void setStarMark(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732387507")) {
            ipChange.ipc$dispatch("1732387507", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (this.isDrag) {
            f = Math.max(this.minMarks, f);
        }
        if (this.integerMark) {
            this.starMark = (float) ((int) Math.ceil((double) f));
        } else {
            float floor = (float) Math.floor((double) f);
            this.starMark = floor;
            float f2 = f - floor;
            if (f2 > 0.0f && ((double) f2) <= 0.5d) {
                this.starMark = (float) (((double) floor) + 0.5d);
            } else if (((double) f2) > 0.5d) {
                this.starMark = floor + 1.0f;
            }
        }
        OnStarChangeListener onStarChangeListener2 = this.onStarChangeListener;
        if (onStarChangeListener2 != null) {
            onStarChangeListener2.onStarChange(this.starMark);
        }
        requestLayout();
        invalidate();
    }

    public void setStarSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962062550")) {
            ipChange.ipc$dispatch("-1962062550", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.starSize = i;
    }

    public void setMarkDrawable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444547522")) {
            ipChange.ipc$dispatch("444547522", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            this.starFillBitmap = drawableToBitmap(getContext().getResources().getDrawable(i));
            Paint paint2 = this.paint;
            Bitmap bitmap = this.starFillBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        }
    }

    public DMRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.starDistance = 0;
        this.starCount = 5;
        this.starMark = 0.0f;
        this.integerMark = false;
        this.minMarks = 0.0f;
        this.tipMark = false;
        this.mStarContent = new ArrayList();
        this.isDrag = false;
        this.location = new int[2];
        this.eventAction = false;
        this.downX = 0;
        init(context, attributeSet);
    }

    public DMRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.starDistance = 0;
        this.starCount = 5;
        this.starMark = 0.0f;
        this.integerMark = false;
        this.minMarks = 0.0f;
        this.tipMark = false;
        this.mStarContent = new ArrayList();
        this.isDrag = false;
        this.location = new int[2];
        this.eventAction = false;
        this.downX = 0;
        init(context, attributeSet);
    }
}

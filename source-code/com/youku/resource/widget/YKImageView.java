package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.LongSparseArray;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.youku.arch.util.LogUtil;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import com.youku.css.setter.CssSetter;
import com.youku.css.setter.ICssSetter2;
import com.youku.css.util.ColorUtil;
import com.youku.resource.R;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.utils.ColorConfigureManager;
import com.youku.resource.utils.DebugSwitchUtils;
import com.youku.resource.utils.DimenUtils;
import com.youku.resource.utils.DynamicColorDefine;
import com.youku.resource.utils.IconFontUtils;
import com.youku.resource.utils.ImageViewUtils;
import com.youku.resource.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import tb.qg0;
import tb.tp1;
import tb.ug2;

/* compiled from: Taobao */
public class YKImageView extends YKRatioImageView implements ICssSetter2 {
    private static final String ELLIPSIZE_TEXT = "…";
    private static final String TAG = "YKImageView";
    public static final int TYPE_AD = 4;
    public static final int TYPE_INFO = 1000;
    public static final int TYPE_MEMBER = 3;
    public static final int TYPE_OPERATE = 1;
    public static final int TYPE_PROPERTY = 2;
    public static final int TYPE_SCORE = 1001;
    private static int dp1;
    private static int dp10;
    private static int dp11;
    private static int dp12;
    private static int dp13;
    private static int dp16;
    private static int dp17;
    private static int dp26;
    private static int dp3;
    private static int dp4;
    private static int dp5;
    private static int dp50;
    private static int dp6;
    private static int dp7;
    private static int dp8;
    private static int dp9;
    private static GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{0, 0});
    private static Rect gdBounds = new Rect(0, 0, 0, 0);
    private static int[] gdColors = {0, 0};
    private static Paint mAdFillPaint;
    private static Paint mBgPaint;
    private static boolean mLBIconFont;
    private static Paint mLBPaint;
    private static Paint mLTPaint;
    private static Paint mRBPaint;
    private static Paint mRTPaint;
    private static Paint mScorePaint;
    private static int radius;
    private static SparseArray<Paint.FontMetrics> sFontMetricsCache = new SparseArray<>(4);
    private static HashMap<String, LongSparseArray<Bitmap>> sTopRightCache = new HashMap<>(12);
    private static HashMap<String, float[]> sTopRightLocCache = new HashMap<>(12);
    private static Typeface typeface_rank;
    private static Typeface typeface_reputation;
    private Drawable bottomBg;
    private String bottom_center_text;
    private int bottom_center_type;
    float bottom_center_x;
    float bottom_center_y;
    private String bottom_left_text;
    float bottom_left_x;
    float bottom_left_y;
    private String bottom_right_text;
    private int bottom_right_type;
    float bottom_right_x;
    float bottom_right_y;
    private Rect debugInfoRect;
    private int extendSettedConernColorEnd;
    private int extendSettedConernColorStart;
    private boolean forceDrawBg;
    private boolean forceImgBg;
    private int mAdFillColor;
    private boolean mArithmeticDebug;
    private int mArithmeticSize;
    private int mBgColor;
    private float mBottomCenterEllipsizeWidth;
    private ShapeDrawable mColorBgDr;
    private Drawable mCoverBackground;
    private int mCoverCountDown;
    private String mCurrentImageUrl;
    private Paint mDebugPaint;
    private int mDefaultBgColor;
    private Set<Drawable> mDrawables;
    private int mRank;
    private boolean mServerDebug;
    private boolean mShowCoverForDynamicImage;
    private boolean mStartCoverCountDown;
    private Drawable mStripeMiddleDrawable;
    private int mTopRightEndColor;
    private int mTopRightStartColor;
    private float[] measureCenterWidth;
    int needWidth;
    private OnDebugClickListener onDebugClickListener;
    private Path path;
    private int sScoreColor;
    private String top_left_text;
    private int top_left_y;
    private String top_right_text;
    private int top_right_type;
    float top_right_x;
    float top_right_y;
    private float[] values;

    /* compiled from: Taobao */
    public interface OnDebugClickListener {
        void onClick(View view);
    }

    public YKImageView(Context context) {
        super(context);
        this.mColorBgDr = null;
        this.mRank = -1;
        this.extendSettedConernColorStart = -1;
        this.extendSettedConernColorEnd = -1;
        this.mDefaultBgColor = 0;
        this.values = new float[9];
        this.mShowCoverForDynamicImage = false;
        this.mStartCoverCountDown = false;
        this.mCurrentImageUrl = null;
        this.measureCenterWidth = new float[1];
        this.mBottomCenterEllipsizeWidth = -1.0f;
        this.mDrawables = new HashSet(3);
        init(context, null);
    }

    private void addMask(Drawable drawable) {
        if (drawable != null) {
            this.mDrawables.add(drawable);
        }
    }

    private boolean asyncSetCoverImageUrl(final String str, final String str2) {
        if (!this.mShowCoverForDynamicImage) {
            return false;
        }
        setCoverBackground(null);
        if (!TextUtils.isEmpty(str)) {
            String staticImageUrl = ImageViewUtils.getStaticImageUrl(str);
            if (staticImageUrl.length() != str.length()) {
                this.mStartCoverCountDown = false;
                tp1.o().s(staticImageUrl).Q(new IPhenixListener<ug2>() {
                    /* class com.youku.resource.widget.YKImageView.AnonymousClass4 */

                    public boolean onHappen(ug2 ug2) {
                        if (!str.equals(YKImageView.this.mCurrentImageUrl)) {
                            LogUtil.e(YKImageView.TAG, new Object[]{"asyncSetCoverImageUrl.succ: url changed."});
                            return false;
                        }
                        YKImageView.this.setCoverBackground(ug2.f());
                        YKImageView.super.asyncSetImageUrl(str, str2);
                        return false;
                    }
                }).m(new IPhenixListener<qg0>() {
                    /* class com.youku.resource.widget.YKImageView.AnonymousClass3 */

                    public boolean onHappen(qg0 qg0) {
                        if (!str.equals(YKImageView.this.mCurrentImageUrl)) {
                            LogUtil.e(YKImageView.TAG, new Object[]{"asyncSetCoverImageUrl.fail: url changed."});
                            return false;
                        }
                        YKImageView.super.asyncSetImageUrl(str, str2);
                        return false;
                    }
                }).n();
                return true;
            }
        }
        return false;
    }

    private void drawBottom(Canvas canvas) {
        if (!isOnlyGrey() || (this.mShowCoverForDynamicImage && this.mCoverBackground != null)) {
            if (!TextUtils.isEmpty(this.bottom_left_text) || !TextUtils.isEmpty(this.bottom_right_text) || !TextUtils.isEmpty(this.bottom_center_text) || this.forceDrawBg) {
                drawBottomBg(canvas);
            }
            drawBottomLeft(canvas);
            drawBottomRight(canvas);
            drawBottomCenter(canvas);
        }
    }

    private void drawBottomBg(Canvas canvas) {
        if (this.bottomBg == null) {
            this.bottomBg = getResources().getDrawable(R.drawable.item_bottom_bg);
        }
        Drawable drawable = this.bottomBg;
        if (drawable != null) {
            int i = this.height;
            drawable.setBounds(0, i - dp50, this.width, i);
            this.bottomBg.draw(canvas);
        }
    }

    private void drawBottomCenter(Canvas canvas) {
        if (!TextUtils.isEmpty(this.bottom_center_text) && this.bottom_center_x > 0.0f && this.bottom_center_type == 1000) {
            drawBottomCenterInfo(canvas);
        }
    }

    private void drawBottomCenterInfo(Canvas canvas) {
        canvas.drawText(this.bottom_center_text, this.bottom_center_x, this.bottom_center_y, getRBPaint());
    }

    private void drawBottomLeft(Canvas canvas) {
        if (!TextUtils.isEmpty(this.bottom_left_text) && this.bottom_left_x > 0.0f) {
            drawBottomLeftInfo(canvas);
        }
    }

    private void drawBottomLeftInfo(Canvas canvas) {
        Paint lBPaint = getLBPaint();
        float measureText = lBPaint.measureText(this.bottom_left_text);
        String str = this.bottom_right_text;
        float measureText2 = str != null ? lBPaint.measureText(str) : 0.0f;
        int i = this.width;
        int i2 = dp6;
        if (measureText >= ((float) (i - (-i2)))) {
            canvas.drawText(this.bottom_left_text.substring(0, ((int) (((((float) i) - measureText2) - ((float) i2)) / lBPaint.measureText("单"))) - 2) + "...", this.bottom_left_x, this.bottom_left_y, lBPaint);
            return;
        }
        canvas.drawText(this.bottom_left_text, this.bottom_left_x, this.bottom_left_y, lBPaint);
    }

    private void drawBottomRight(Canvas canvas) {
        if (!TextUtils.isEmpty(this.bottom_right_text) && this.bottom_right_x > 0.0f) {
            int i = this.bottom_right_type;
            if (i == 1000) {
                drawBottomRightInfo(canvas);
            } else if (i == 1001) {
                drawBottomScore(canvas);
            }
        }
    }

    private void drawBottomRightInfo(Canvas canvas) {
        canvas.drawText(this.bottom_right_text, this.bottom_right_x, this.bottom_right_y, getRBPaint());
    }

    private void drawBottomScore(Canvas canvas) {
        canvas.drawText(this.bottom_right_text, this.bottom_right_x, this.bottom_right_y, getScorePaint());
    }

    private void drawCoverAsBackground(Canvas canvas) {
        this.mCoverBackground.setBounds(0, 0, this.width, this.height);
        this.mCoverBackground.draw(canvas);
        if (this.mStartCoverCountDown) {
            this.mCoverCountDown--;
        }
        if (this.mCoverCountDown <= 0) {
            setCoverBackground(null);
            this.mStartCoverCountDown = false;
        }
    }

    private void drawLeftTop(Canvas canvas) {
        if (!TextUtils.isEmpty(this.top_left_text)) {
            if ((!isOnlyGrey() || (this.mShowCoverForDynamicImage && this.mCoverBackground != null)) && this.top_left_y > 0) {
                Paint lTPaint = getLTPaint();
                String str = this.top_left_text;
                char c = 65535;
                switch (str.hashCode()) {
                    case 49:
                        if (str.equals("1")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 52:
                        if (str.equals("4")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    canvas.drawBitmap(((BitmapDrawable) getResources().getDrawable(R.drawable.yk_item_label_no1)).getBitmap(), 0.0f, 0.0f, lTPaint);
                } else if (c == 1) {
                    canvas.drawBitmap(((BitmapDrawable) getResources().getDrawable(R.drawable.yk_item_label_no2)).getBitmap(), 0.0f, 0.0f, lTPaint);
                } else if (c != 2) {
                    canvas.drawBitmap(((BitmapDrawable) getResources().getDrawable(R.drawable.yk_item_label_no4)).getBitmap(), 0.0f, 0.0f, lTPaint);
                } else {
                    canvas.drawBitmap(((BitmapDrawable) getResources().getDrawable(R.drawable.yk_item_label_no3)).getBitmap(), 0.0f, 0.0f, lTPaint);
                }
                String str2 = this.top_left_text;
                canvas.drawText(str2, (float) (str2.length() == 1 ? dp6 : dp1), (float) this.top_left_y, lTPaint);
            }
        }
    }

    private void drawTopRight(Canvas canvas) {
        if (!TextUtils.isEmpty(this.top_right_text)) {
            if (isOnlyGrey() && (!this.mShowCoverForDynamicImage || this.mCoverBackground == null)) {
                return;
            }
            if (AppPerfABUtils.isOpenPerf()) {
                long updateTopRightColors = updateTopRightColors();
                LongSparseArray<Bitmap> longSparseArray = sTopRightCache.get(this.top_right_text);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray<>();
                    sTopRightCache.put(this.top_right_text, longSparseArray);
                }
                Bitmap bitmap = longSparseArray.get(updateTopRightColors);
                if (bitmap == null) {
                    bitmap = makeTopRightBitmap(this.mTopRightStartColor, this.mTopRightEndColor);
                    if (bitmap != null) {
                        longSparseArray.put(updateTopRightColors, bitmap);
                    } else {
                        return;
                    }
                }
                canvas.drawBitmap(bitmap, (((float) this.width) - sTopRightLocCache.get(this.top_right_text)[2]) - ((float) (dp1 * 2)), (float) (getPaddingTop() / 2), getRTPaint());
            } else if (this.top_right_x > 0.0f) {
                drawTopRightBg(canvas);
                drawTopRightInfo(canvas);
            }
        }
    }

    private void drawTopRightBg(Canvas canvas) {
        int i;
        int i2 = this.extendSettedConernColorStart;
        if (i2 != -1) {
            i = this.extendSettedConernColorEnd;
        } else {
            i2 = Utils.getStartColor(getContext(), this.top_right_type);
            i = Utils.getEndColor(getContext(), this.top_right_type);
        }
        gd.setColors(new int[]{i2, i});
        gd.setShape(0);
        GradientDrawable gradientDrawable = gd;
        int i3 = radius;
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, (float) i3, (float) i3, 0.0f, 0.0f, (float) i3, (float) i3});
        gd.setBounds(((this.width - this.needWidth) - (dp1 * 2)) - dp6, getPaddingTop() / 2, this.width - dp6, ((getPaddingTop() / 2) + dp16) - dp1);
        gd.draw(canvas);
    }

    private void drawTopRightInfo(Canvas canvas) {
        canvas.drawText(this.top_right_text, this.top_right_x, this.top_right_y, getRTPaint());
    }

    private Paint getAdFillPaint() {
        if (mAdFillPaint == null) {
            mAdFillPaint = new Paint();
        }
        int color = mAdFillPaint.getColor();
        int i = this.mAdFillColor;
        if (color != i) {
            mAdFillPaint.setColor(i);
        }
        return mAdFillPaint;
    }

    private Paint getBgPaint() {
        if (mBgPaint == null) {
            mBgPaint = new Paint();
        }
        int color = mBgPaint.getColor();
        int i = this.mBgColor;
        if (color != i) {
            mBgPaint.setColor(i);
        }
        return mBgPaint;
    }

    private float getBottomCenterEllipsizeWidth() {
        if (this.mBottomCenterEllipsizeWidth <= 0.0f) {
            this.mBottomCenterEllipsizeWidth = getRBPaint().measureText(ELLIPSIZE_TEXT);
        }
        return this.mBottomCenterEllipsizeWidth;
    }

    private Paint getDebugPaint() {
        if (this.mDebugPaint == null) {
            Paint paint = new Paint();
            this.mDebugPaint = paint;
            paint.setAntiAlias(true);
            this.mDebugPaint.setColor(-16776961);
        }
        return this.mDebugPaint;
    }

    private Paint.FontMetrics getFontMetricsFromCache(int i, Paint paint) {
        Paint.FontMetrics fontMetrics = sFontMetricsCache.get(i);
        if (fontMetrics != null) {
            return fontMetrics;
        }
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        sFontMetricsCache.put(i, fontMetrics2);
        return fontMetrics2;
    }

    private Paint getLBPaint() {
        if (mLBPaint == null) {
            Paint paint = new Paint();
            mLBPaint = paint;
            paint.setAntiAlias(true);
            mLBPaint.setColor(-1);
            mLBPaint.setTextSize((float) dp11);
            mLBPaint.setFakeBoldText(false);
            if (mLBIconFont) {
                mLBPaint.setTypeface(IconFontUtils.getIconFont());
            }
        }
        return mLBPaint;
    }

    private Paint getLTPaint() {
        if (mLTPaint == null) {
            Paint paint = new Paint();
            mLTPaint = paint;
            paint.setAntiAlias(true);
            mLTPaint.setColor(-1);
            mLTPaint.setFakeBoldText(true);
            mLTPaint.setTextSize((float) dp13);
            if (typeface_rank == null) {
                typeface_rank = Typeface.createFromAsset(getResources().getAssets(), "Trebuchet_MS_Italic.ttf");
            }
            mLTPaint.setTypeface(typeface_rank);
        }
        return mLTPaint;
    }

    private Paint getRBPaint() {
        if (mRBPaint == null) {
            Paint paint = new Paint();
            mRBPaint = paint;
            paint.setAntiAlias(true);
            mRBPaint.setColor(-1);
            mRBPaint.setTextSize((float) dp10);
            mRBPaint.setFakeBoldText(false);
        }
        return mRBPaint;
    }

    private Paint getRTPaint() {
        if (mRTPaint == null) {
            Paint paint = new Paint();
            mRTPaint = paint;
            paint.setAntiAlias(true);
            mRTPaint.setColor(-1);
            mRTPaint.setTextSize((float) dp10);
            mRTPaint.setFakeBoldText(false);
        }
        return mRTPaint;
    }

    private Paint getScorePaint() {
        if (mScorePaint == null) {
            Paint paint = new Paint();
            mScorePaint = paint;
            paint.setAntiAlias(true);
            mScorePaint.setTextSize((float) dp17);
            mScorePaint.setFakeBoldText(false);
            if (typeface_reputation == null) {
                typeface_reputation = Typeface.createFromAsset(getResources().getAssets(), "Akrobat-Bold.ttf");
            }
            mScorePaint.setTypeface(typeface_reputation);
        }
        int color = mScorePaint.getColor();
        int i = this.sScoreColor;
        if (color != i) {
            mScorePaint.setColor(i);
        }
        return mScorePaint;
    }

    private void init(Context context, AttributeSet attributeSet) {
        initDps(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKImageView, 0, 0);
            this.mShowCoverForDynamicImage = obtainStyledAttributes.getBoolean(R.styleable.YKImageView_showCoverForDynamicImage, false);
            obtainStyledAttributes.recycle();
        }
        if (AppPerfABUtils.isForbidShowCoverForGif()) {
            this.mShowCoverForDynamicImage = false;
        }
    }

    private void initBottomCenter() {
        if (!TextUtils.isEmpty(this.bottom_center_text) && this.width > 0) {
            Paint paint = null;
            if (this.bottom_center_type == 1000) {
                paint = getRBPaint();
            }
            if (paint != null) {
                Rect rect = new Rect();
                int i = this.width - (dp6 << 1);
                String str = this.bottom_center_text;
                float f = (float) i;
                int breakText = paint.breakText(str, 0, str.length(), true, f, this.measureCenterWidth);
                if (this.measureCenterWidth[0] + getBottomCenterEllipsizeWidth() <= f) {
                    this.bottom_center_text = this.bottom_center_text.substring(0, breakText);
                } else {
                    this.bottom_center_text = this.bottom_center_text.substring(0, breakText - 1) + ELLIPSIZE_TEXT;
                }
                String str2 = this.bottom_center_text;
                paint.getTextBounds(str2, 0, str2.length(), rect);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                int height = this.height - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) >> 1);
                this.bottom_center_x = (float) ((this.width - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) >> 1);
                float f2 = fontMetrics.bottom;
                this.bottom_center_y = ((((float) height) + ((f2 - fontMetrics.top) / 2.0f)) - f2) - ((float) dp7);
                invalidate();
            }
        }
    }

    private void initBottomCenter2() {
        if (!TextUtils.isEmpty(this.bottom_center_text) && this.width > 0) {
            Paint paint = null;
            if (this.bottom_center_type == 1000) {
                paint = getRBPaint();
            }
            if (paint != null) {
                Rect rect = new Rect();
                int i = this.width - (dp6 << 1);
                String str = this.bottom_center_text;
                float f = (float) i;
                int breakText = paint.breakText(str, 0, str.length(), true, f, this.measureCenterWidth);
                if (this.measureCenterWidth[0] + getBottomCenterEllipsizeWidth() <= f) {
                    this.bottom_center_text = this.bottom_center_text.substring(0, breakText);
                } else {
                    this.bottom_center_text = this.bottom_center_text.substring(0, breakText - 1) + ELLIPSIZE_TEXT;
                }
                String str2 = this.bottom_center_text;
                paint.getTextBounds(str2, 0, str2.length(), rect);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                int height = this.height - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) >> 1);
                this.bottom_center_x = (float) ((this.width - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) >> 1);
                float f2 = fontMetrics.bottom;
                this.bottom_center_y = ((((float) height) + ((f2 - fontMetrics.top) / 2.0f)) - f2) - ((float) dp7);
            }
        }
    }

    private void initBottomLeft() {
        if (!TextUtils.isEmpty(this.bottom_left_text) && this.width > 0 && this.bottom_left_x == 0.0f) {
            Paint lBPaint = getLBPaint();
            Rect rect = new Rect();
            String str = this.bottom_left_text;
            lBPaint.getTextBounds(str, 0, str.length(), rect);
            Paint.FontMetrics fontMetrics = lBPaint.getFontMetrics();
            int height = this.height - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) / 2);
            this.bottom_left_x = (float) dp6;
            float f = (float) height;
            float f2 = fontMetrics.bottom;
            this.bottom_left_y = ((f + ((f2 - fontMetrics.top) / 2.0f)) - f2) - ((float) dp7);
            invalidate();
        }
    }

    private boolean initBottomLeft2() {
        if (TextUtils.isEmpty(this.bottom_left_text) || this.width <= 0 || this.bottom_left_x != 0.0f) {
            return false;
        }
        Paint lBPaint = getLBPaint();
        Rect rect = new Rect();
        String str = this.bottom_left_text;
        lBPaint.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetrics fontMetricsFromCache = getFontMetricsFromCache(dp11, lBPaint);
        int height = this.height - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) / 2);
        this.bottom_left_x = (float) dp6;
        float f = fontMetricsFromCache.bottom;
        this.bottom_left_y = ((((float) height) + ((f - fontMetricsFromCache.top) / 2.0f)) - f) - ((float) dp7);
        return true;
    }

    private void initBottomRight() {
        Paint paint;
        if (!TextUtils.isEmpty(this.bottom_right_text) && this.width > 0 && this.bottom_right_x == 0.0f) {
            if (this.bottom_right_type == 1000) {
                paint = getRBPaint();
            } else {
                paint = getScorePaint();
            }
            Rect rect = new Rect();
            if (paint.measureText(this.bottom_right_text) > ((float) (this.width - dp6))) {
                StringBuilder sb = new StringBuilder();
                String str = this.bottom_right_text;
                sb.append(str.substring(0, str.length() < 7 ? this.bottom_right_text.length() - 1 : 6));
                sb.append("...");
                this.bottom_right_text = sb.toString();
            }
            String str2 = this.bottom_right_text;
            paint.getTextBounds(str2, 0, str2.length(), rect);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int height = this.height - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) / 2);
            this.bottom_right_x = (float) ((this.width - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) - dp9);
            float f = (float) height;
            float f2 = fontMetrics.bottom;
            this.bottom_right_y = ((f + ((f2 - fontMetrics.top) / 2.0f)) - f2) - ((float) dp7);
            invalidate();
        }
    }

    private boolean initBottomRight2() {
        Paint paint;
        int i;
        if (TextUtils.isEmpty(this.bottom_right_text) || this.width <= 0 || this.bottom_right_x != 0.0f) {
            return false;
        }
        if (this.bottom_right_type == 1000) {
            i = dp11;
            paint = getRBPaint();
        } else {
            i = dp13;
            paint = getScorePaint();
        }
        Rect rect = new Rect();
        if (paint.measureText(this.bottom_right_text) > ((float) (this.width - dp6))) {
            StringBuilder sb = new StringBuilder();
            String str = this.bottom_right_text;
            sb.append(str.substring(0, str.length() < 7 ? this.bottom_right_text.length() - 1 : 6));
            sb.append("...");
            this.bottom_right_text = sb.toString();
        }
        String str2 = this.bottom_right_text;
        paint.getTextBounds(str2, 0, str2.length(), rect);
        Paint.FontMetrics fontMetricsFromCache = getFontMetricsFromCache(i, paint);
        int height = this.height - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) / 2);
        this.bottom_right_x = (float) ((this.width - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) - dp9);
        float f = fontMetricsFromCache.bottom;
        this.bottom_right_y = ((((float) height) + ((f - fontMetricsFromCache.top) / 2.0f)) - f) - ((float) dp7);
        return true;
    }

    private void initDps(Context context) {
        this.mBgColor = ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_FILL_COLOR) != null ? ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_FILL_COLOR).intValue() : Color.parseColor("#E4E4E4");
        this.mAdFillColor = ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_FILL_COLOR) != null ? ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_FILL_COLOR).intValue() : Color.parseColor("#E4E4E4");
        this.mDefaultBgColor = this.mBgColor;
        this.sScoreColor = getResources().getColor(R.color.cy_3);
        this.mArithmeticSize = getResources().getDimensionPixelSize(R.dimen.resource_size_30);
        if (!AppPerfABUtils.isOpenPerf() || dp1 == 0) {
            dp1 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_1);
            radius = DimenUtils.getDimensionPixelSize(context, R.dimen.radius_secondary_medium);
            dp3 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_3);
            dp4 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_4);
            dp6 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_6);
            dp7 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_7);
            dp8 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_8);
            dp9 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_9);
            dp5 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_5);
            dp10 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_10);
            dp11 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_11);
            dp12 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_12);
            dp13 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_14);
            dp16 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_16);
            dp17 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_17);
            dp26 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_26);
            dp50 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_50);
            if (AppPerfABUtils.isOpenPerf()) {
                gd.setShape(0);
                if (AppPerfABUtils.isForbidRoundCorner()) {
                    gd.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                GradientDrawable gradientDrawable = gd;
                int i = radius;
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (float) i, (float) i});
            }
        }
    }

    private void initLeftTop() {
        if (!TextUtils.isEmpty(this.top_left_text) && this.width > 0 && this.top_left_y == 0) {
            if (this.path == null) {
                this.path = new Path();
            }
            this.top_left_y = dp6 + dp13;
            invalidate();
        }
    }

    private boolean initLeftTop2() {
        if (TextUtils.isEmpty(this.top_left_text) || this.width <= 0 || this.top_left_y != 0) {
            return false;
        }
        this.top_left_y = dp6 + dp13;
        return true;
    }

    private void initTopRight() {
        int i;
        if (!TextUtils.isEmpty(this.top_right_text) && this.width > 0 && this.top_right_x == 0.0f) {
            Paint rTPaint = getRTPaint();
            int measureText = (int) rTPaint.measureText(this.top_right_text);
            this.needWidth = measureText;
            int i2 = dp26;
            if (measureText < i2) {
                i = i2 - measureText;
                this.needWidth = i2;
            } else {
                i = 0;
            }
            Rect rect = new Rect(0, 0, this.needWidth, dp16);
            Paint.FontMetricsInt fontMetricsInt = rTPaint.getFontMetricsInt();
            this.top_right_x = (float) ((((this.width - this.needWidth) - dp1) - dp6) + (i / 2));
            this.top_right_y = (float) ((((((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2) + (getPaddingTop() / 2)) - dp1);
            invalidate();
        }
    }

    private boolean initTopRight2() {
        return sTopRightLocCache.get(this.top_right_text) != updateTopRight();
    }

    private Bitmap makeTopRightBitmap(int i, int i2) {
        float[] fArr = sTopRightLocCache.get(this.top_right_text);
        if (fArr == null && (fArr = updateTopRight()) == null) {
            return null;
        }
        int i3 = ((int) fArr[2]) + (dp1 << 1);
        int i4 = dp16;
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int[] iArr = gdColors;
        if (!(i == iArr[0] && i2 == iArr[1])) {
            iArr[0] = i;
            iArr[1] = i2;
            gd.setColors(iArr);
        }
        Rect rect = gdBounds;
        if (!(rect.right == i3 && rect.bottom == i4 && rect.left == 0 && rect.top == 0)) {
            rect.left = 0;
            rect.top = 0;
            rect.right = i3;
            rect.bottom = i4;
            gd.setBounds(0, 0, i3, i4);
        }
        gd.draw(canvas);
        Paint rTPaint = getRTPaint();
        if (this.top_right_type == 3) {
            rTPaint.setColor(-11653885);
        } else {
            rTPaint.setColor(-1);
        }
        canvas.drawText(this.top_right_text, fArr[0], fArr[1], rTPaint);
        return createBitmap;
    }

    private void removeMask(Drawable drawable) {
        this.mDrawables.remove(drawable);
    }

    private void reset() {
        this.top_left_y = 0;
        this.top_right_x = 0.0f;
        this.bottom_left_x = 0.0f;
        this.bottom_right_x = 0.0f;
        this.bottom_center_x = 0.0f;
        this.bottom_center_y = 0.0f;
    }

    private void setBottomCenter(int i) {
        this.bottom_center_type = i;
        initBottomCenter();
    }

    private void setBottomRight(int i) {
        this.bottom_right_type = i;
        if (AppPerfABUtils.isOpenPerf()) {
            initBottomRight2();
        } else {
            initBottomRight();
        }
    }

    private boolean setCoverImageUrl(final String str, final String str2, final PhenixOptions phenixOptions) {
        if (!this.mShowCoverForDynamicImage) {
            return false;
        }
        setCoverBackground(null);
        if (!TextUtils.isEmpty(str)) {
            String staticImageUrl = ImageViewUtils.getStaticImageUrl(str);
            if (staticImageUrl.length() != str.length()) {
                this.mStartCoverCountDown = false;
                tp1.o().s(staticImageUrl).Q(new IPhenixListener<ug2>() {
                    /* class com.youku.resource.widget.YKImageView.AnonymousClass2 */

                    public boolean onHappen(ug2 ug2) {
                        if (!str.equals(YKImageView.this.mCurrentImageUrl)) {
                            LogUtil.e(YKImageView.TAG, new Object[]{"setCoverImageUrl.succ: url changed."});
                            return false;
                        }
                        YKImageView.this.setCoverBackground(ug2.f());
                        YKImageView.super.setImageUrl(str, str2, phenixOptions);
                        return false;
                    }
                }).m(new IPhenixListener<qg0>() {
                    /* class com.youku.resource.widget.YKImageView.AnonymousClass1 */

                    public boolean onHappen(qg0 qg0) {
                        if (!str.equals(YKImageView.this.mCurrentImageUrl)) {
                            LogUtil.e(YKImageView.TAG, new Object[]{"setCoverImageUrl.fail: url changed."});
                            return false;
                        }
                        YKImageView.super.setImageUrl(str, str2, phenixOptions);
                        return false;
                    }
                }).n();
                return true;
            }
        }
        return false;
    }

    private float[] updateTopRight() {
        float f;
        if (TextUtils.isEmpty(this.top_right_text) || this.width <= 0) {
            return null;
        }
        Paint rTPaint = getRTPaint();
        float[] fArr = sTopRightLocCache.get(this.top_right_text);
        if (fArr == null) {
            fArr = new float[3];
            fArr[2] = rTPaint.measureText(this.top_right_text);
            float f2 = fArr[2];
            int i = dp26;
            if (f2 < ((float) (i - dp6))) {
                f = ((float) i) - fArr[2];
                fArr[2] = (float) i;
            } else {
                f = (float) dp8;
                fArr[2] = fArr[2] + f;
            }
            Paint.FontMetrics fontMetricsFromCache = getFontMetricsFromCache(dp11, rTPaint);
            int i2 = dp1;
            fArr[0] = ((float) i2) + (f / 2.0f);
            fArr[1] = (((((float) dp16) - fontMetricsFromCache.bottom) - fontMetricsFromCache.top) / 2.0f) - ((float) (i2 / 2));
            sTopRightLocCache.put(this.top_right_text, fArr);
        }
        return fArr;
    }

    private long updateTopRightColors() {
        int i = this.extendSettedConernColorStart;
        if (i != -1) {
            this.mTopRightStartColor = i;
            this.mTopRightEndColor = this.extendSettedConernColorEnd;
        } else {
            this.mTopRightStartColor = Utils.getStartColor(getContext(), this.top_right_type);
            this.mTopRightEndColor = Utils.getEndColor(getContext(), this.top_right_type);
        }
        return (((long) this.mTopRightStartColor) << 32) | ((long) this.mTopRightEndColor);
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void asyncSetImageUrl(String str) {
        this.mCurrentImageUrl = str;
        if (!asyncSetCoverImageUrl(str, null)) {
            super.asyncSetImageUrl(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKRatioImageView
    public void drawBackgroud(Canvas canvas) {
        Drawable drawable;
        Matrix imageMatrix;
        if (this.mShowCoverForDynamicImage && this.mCoverBackground != null && this.mCoverCountDown > 0) {
            drawCoverAsBackground(canvas);
        } else if (isOnlyGrey()) {
            canvas.drawRect(0.0f, 0.0f, (float) this.width, (float) this.height, getBgPaint());
        } else if (this.forceImgBg && getScaleType() == ImageView.ScaleType.FIT_CENTER && (drawable = getDrawable()) != null) {
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (intrinsicHeight > 0.0f && (imageMatrix = getImageMatrix()) != null) {
                imageMatrix.getValues(this.values);
                float f = intrinsicHeight * this.values[4];
                int i = this.height;
                if (f < ((float) i)) {
                    float f2 = (((float) i) - f) / 2.0f;
                    canvas.drawRect(0.0f, 0.0f, (float) this.width, f2, getAdFillPaint());
                    canvas.drawRect(0.0f, f + f2, (float) this.width, (float) this.height, getAdFillPaint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKRatioImageView
    public void drawDebugInfo(Canvas canvas) {
        if (this.mArithmeticDebug || this.mServerDebug) {
            int width = getWidth() - this.mArithmeticSize;
            int height = getHeight() - this.mArithmeticSize;
            if (this.debugInfoRect == null) {
                this.debugInfoRect = new Rect();
            }
            this.debugInfoRect.set(width, height, getWidth(), getHeight());
            canvas.drawRect(this.debugInfoRect, getDebugPaint());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKRatioImageView
    public void drawImageAfter(Canvas canvas) {
        super.drawImageAfter(canvas);
        if (!this.mDrawables.isEmpty()) {
            for (Drawable drawable : this.mDrawables) {
                if (drawable != null) {
                    canvas.save();
                    canvas.clipRect(drawable.getBounds());
                    drawable.draw(canvas);
                    canvas.restore();
                }
            }
        }
        drawLeftTop(canvas);
        drawTopRight(canvas);
        drawBottom(canvas);
    }

    public Drawable getBackground() {
        Drawable drawable = this.mCoverBackground;
        if (drawable != null) {
            return drawable;
        }
        if (!isOnlyGrey()) {
            return super.getBackground();
        }
        if (this.mColorBgDr == null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            this.mColorBgDr = shapeDrawable;
            shapeDrawable.setColorFilter(new PorterDuffColorFilter(this.mBgColor, PorterDuff.Mode.SRC));
        }
        return this.mColorBgDr;
    }

    public boolean getShowCoverForDynamicImage() {
        return this.mShowCoverForDynamicImage;
    }

    public void hideAll() {
        this.top_left_text = null;
        this.top_right_text = null;
        this.bottom_left_text = null;
        this.bottom_right_text = null;
        this.bottom_center_text = null;
        this.mCoverBackground = null;
        this.forceDrawBg = false;
        this.extendSettedConernColorStart = -1;
        this.extendSettedConernColorEnd = -1;
        reset();
    }

    public boolean isOnlyGrey() {
        return isDrawableSameWith(null);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void onDetachedFromWindow() {
        this.mStartCoverCountDown = false;
        setCoverBackground(null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.feature.view.TImageView
    public void onMeasure(int i, int i2) {
        int i3 = this.width;
        int i4 = this.height;
        super.onMeasure(i, i2);
        if (AppPerfABUtils.isOpenPerf()) {
            if (!(i3 == this.width && i4 == this.height)) {
                reset();
            }
            initLeftTop2();
            initTopRight2();
            initBottomLeft2();
            initBottomRight2();
            initBottomCenter2();
            return;
        }
        reset();
        initLeftTop();
        initTopRight();
        initBottomLeft();
        initBottomRight();
        initBottomCenter();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r2 != 1) goto L_0x0036;
     */
    @Override // com.taobao.uikit.feature.view.TImageView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mArithmeticDebug || this.mServerDebug) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.debugInfoRect.contains(x, y)) {
                    return true;
                }
            }
            if (this.onDebugClickListener != null && this.debugInfoRect.contains(x, y)) {
                this.onDebugClickListener.onClick(this);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void removeStripeMiddleMask() {
        removeMask(this.mStripeMiddleDrawable);
    }

    public void resetArithmeticDebug() {
        this.mArithmeticDebug = false;
    }

    @Override // com.youku.css.setter.ICssSetter2
    public void resetCss(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            if (str.equals(CssConst.CssScenes.IMG)) {
                setBgColor(this.mDefaultBgColor);
            } else if (!str.equals(CssConst.CssScenes.SCORE)) {
                clearColorFilter();
            } else {
                int resetColor = CssSetter.resetColor(this, R.id.tag_css_color);
                if (resetColor != 0) {
                    setScoreColor(resetColor);
                }
            }
        }
    }

    public void resetServerDebug() {
        this.mServerDebug = false;
    }

    public void setArithmeticDebug() {
        this.mArithmeticDebug = DebugSwitchUtils.isOpenArithmeticDebug();
    }

    public void setBgColor(int i) {
        if (i != this.mBgColor) {
            this.mColorBgDr = null;
        }
        this.mBgColor = i;
        if (i != this.mDefaultBgColor) {
            setErrorImageResId(0);
            setPlaceHoldImageResId(0);
            setPlaceHoldForeground(null);
        }
    }

    public void setBottomCenterText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bottom_center_text = str;
            setBottomCenter(1000);
        }
    }

    public void setBottomLeftText(String str) {
        this.bottom_left_text = str;
        if (AppPerfABUtils.isOpenPerf()) {
            initBottomLeft2();
        } else {
            initBottomLeft();
        }
    }

    public void setBottomRightText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bottom_right_text = str;
            setBottomRight(1000);
        }
    }

    public void setCoverBackground(Drawable drawable) {
        this.mCoverBackground = drawable;
        if (this.mShowCoverForDynamicImage && drawable != null) {
            this.mCoverCountDown = 1;
        }
    }

    @Override // com.youku.css.setter.ICssSetter
    public void setCss(String str, Css css) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            if (str.equals(CssConst.CssScenes.IMG)) {
                setBgColor(ColorUtil.parseColorSafely(css.backgroundColor, this.mBgColor));
            } else if (!str.equals(CssConst.CssScenes.SCORE)) {
                setColorFilter(ColorUtil.parseColorSafely(css.color), PorterDuff.Mode.SRC_IN);
            } else {
                CssSetter.saveColor(this, R.id.tag_css_color, this.sScoreColor);
                setScoreColor(ColorUtil.parseColorSafely(css.color, this.sScoreColor));
            }
        }
    }

    public void setExtendSettedConernColor(int i, int i2) {
        this.extendSettedConernColorStart = i;
        this.extendSettedConernColorEnd = i2;
    }

    public void setForceDrawBg(boolean z) {
        this.forceDrawBg = z;
    }

    public void setForceImgBg(boolean z) {
        this.forceImgBg = z;
    }

    @Override // com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.extend.feature.view.TUrlImageView, com.taobao.uikit.feature.view.TImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.mShowCoverForDynamicImage && this.mCoverBackground != null) {
            if (drawable instanceof AnimatedImageDrawable) {
                this.mCoverCountDown = 10;
                this.mStartCoverCountDown = true;
            } else if (drawable != null) {
                setCoverBackground(null);
            }
        }
    }

    @Override // com.taobao.uikit.feature.view.TImageView
    public void setImageResource(int i) {
        this.mCurrentImageUrl = null;
        super.setImageResource(i);
    }

    @Override // com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.extend.feature.view.TUrlImageView
    public void setImageUrl(String str) {
        this.mCurrentImageUrl = str;
        if (!setCoverImageUrl(str, null, null)) {
            super.setImageUrl(str);
        }
    }

    public void setLBIconFont(boolean z) {
        mLBIconFont = z;
        Paint paint = mLBPaint;
        if (paint != null) {
            paint.setTypeface(IconFontUtils.getIconFont());
        }
    }

    public void setOnDebugClickListener(OnDebugClickListener onDebugClickListener2) {
        this.onDebugClickListener = onDebugClickListener2;
    }

    public void setRank(int i) {
        this.mRank = i;
        if (i > 0) {
            this.top_left_text = String.valueOf(i);
            if (AppPerfABUtils.isOpenPerf()) {
                initLeftTop2();
            } else {
                initLeftTop();
            }
        }
    }

    public void setReputation(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bottom_right_text = str;
            setBottomRight(1001);
        }
    }

    public void setScoreColor(int i) {
        this.sScoreColor = i;
    }

    public void setServerDebug() {
        this.mServerDebug = DebugSwitchUtils.isOpenServerDebug();
    }

    public void setShowCoverForDynamicImage(boolean z) {
        this.mShowCoverForDynamicImage = z;
    }

    public final void setStripeMiddleMask(Drawable drawable) {
        removeMask(this.mStripeMiddleDrawable);
        this.mStripeMiddleDrawable = drawable;
        addMask(drawable);
    }

    public void setTopRight(String str, int i) {
        this.top_right_text = str;
        this.top_right_type = i;
        if (AppPerfABUtils.isOpenPerf()) {
            initTopRight2();
        } else {
            initTopRight();
        }
    }

    public void setExtendSettedConernColor(int i) {
        this.extendSettedConernColorStart = i;
        this.extendSettedConernColorEnd = i;
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void asyncSetImageUrl(String str, String str2) {
        this.mCurrentImageUrl = str;
        if (!asyncSetCoverImageUrl(str, str2)) {
            super.asyncSetImageUrl(str, str2);
        }
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void setImageUrl(String str, PhenixOptions phenixOptions) {
        this.mCurrentImageUrl = str;
        if (!setCoverImageUrl(str, null, phenixOptions)) {
            super.setImageUrl(str, phenixOptions);
        }
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void setImageUrl(String str, String str2) {
        this.mCurrentImageUrl = str;
        if (!setCoverImageUrl(str, str2, null)) {
            super.setImageUrl(str, str2);
        }
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void setImageUrl(String str, String str2, PhenixOptions phenixOptions) {
        this.mCurrentImageUrl = str;
        if (!setCoverImageUrl(str, str2, phenixOptions)) {
            super.setImageUrl(str, str2, phenixOptions);
        }
    }

    public YKImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColorBgDr = null;
        this.mRank = -1;
        this.extendSettedConernColorStart = -1;
        this.extendSettedConernColorEnd = -1;
        this.mDefaultBgColor = 0;
        this.values = new float[9];
        this.mShowCoverForDynamicImage = false;
        this.mStartCoverCountDown = false;
        this.mCurrentImageUrl = null;
        this.measureCenterWidth = new float[1];
        this.mBottomCenterEllipsizeWidth = -1.0f;
        this.mDrawables = new HashSet(3);
        init(context, attributeSet);
    }
}

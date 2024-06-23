package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    static final int FLAG_SUPPORT_SCROLL_UP = 4;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt;
    private int mAutoCompleteMode;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    boolean mIsRotateMode;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    float mRotateCenterX;
    float mRotateCenterY;
    private int mRotationCenterId;
    private int mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private int[] mTempLoc;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;

    TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i2 = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i2;
                float[][] fArr = TOUCH_SIDES;
                this.mTouchAnchorX = fArr[i2][0];
                this.mTouchAnchorY = fArr[i2][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i3 = typedArray.getInt(index, this.mTouchSide);
                this.mTouchSide = i3;
                float[][] fArr2 = TOUCH_DIRECTION;
                if (i3 < fArr2.length) {
                    this.mTouchDirectionX = fArr2[i3][0];
                    this.mTouchDirectionY = fArr2[i3][1];
                } else {
                    this.mTouchDirectionY = Float.NaN;
                    this.mTouchDirectionX = Float.NaN;
                    this.mIsRotateMode = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.mRotationCenterId = typedArray.getResourceId(index, this.mRotationCenterId);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.mSpringDamping = typedArray.getFloat(index, this.mSpringDamping);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.mSpringMass = typedArray.getFloat(index, this.mSpringMass);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.mSpringStiffness = typedArray.getFloat(index, this.mSpringStiffness);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.mSpringStopThreshold = typedArray.getFloat(index, this.mSpringStopThreshold);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.mSpringBoundary = typedArray.getInt(index, this.mSpringBoundary);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.mAutoCompleteMode = typedArray.getInt(index, this.mAutoCompleteMode);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public float dot(float f, float f2) {
        return (f * this.mTouchDirectionX) + (f2 * this.mTouchDirectionY);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public int getFlags() {
        return this.mFlags;
    }

    /* access modifiers changed from: package-private */
    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.mLimitBoundsTo;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    /* access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    /* access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    /* access modifiers changed from: package-private */
    public float getProgressDirection(float f, float f2) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f3 = this.mTouchDirectionX;
        if (f3 != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f * f3) / fArr[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f2 * this.mTouchDirectionY) / fArr2[1];
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    /* access modifiers changed from: package-private */
    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.mTouchRegionId;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    /* access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        float f;
        int i2;
        float f2;
        if (this.mIsRotateMode) {
            processTouchRotateEvent(motionEvent, motionTracker, i, motionScene);
            return;
        }
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
        } else if (action == 1) {
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            int i3 = this.mTouchAnchorId;
            if (i3 != -1) {
                this.mMotionLayout.getAnchorDpDt(i3, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min = (float) Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr = this.mAnchorDpDt;
                fArr[1] = this.mTouchDirectionY * min;
                fArr[0] = min * this.mTouchDirectionX;
            }
            float f3 = this.mTouchDirectionX;
            float[] fArr2 = this.mAnchorDpDt;
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            if (f3 != 0.0f) {
                f = xVelocity / fArr2[0];
            } else {
                f = yVelocity / fArr2[1];
            }
            float f6 = !Float.isNaN(f) ? (f / 3.0f) + progress : progress;
            if (f6 != 0.0f && f6 != 1.0f && (i2 = this.mOnTouchUp) != 3) {
                float f7 = ((double) f6) < 0.5d ? 0.0f : 1.0f;
                if (i2 == 6) {
                    if (progress + f < 0.0f) {
                        f = Math.abs(f);
                    }
                    f7 = 1.0f;
                }
                if (this.mOnTouchUp == 7) {
                    if (progress + f > 1.0f) {
                        f = -Math.abs(f);
                    }
                    f7 = 0.0f;
                }
                this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, f7, f);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                }
            } else if (0.0f >= f6 || 1.0f <= f6) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.mLastTouchY;
            float rawX = motionEvent.getRawX() - this.mLastTouchX;
            if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                float progress2 = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(progress2);
                }
                int i4 = this.mTouchAnchorId;
                if (i4 != -1) {
                    this.mMotionLayout.getAnchorDpDt(i4, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    float min2 = (float) Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    float[] fArr3 = this.mAnchorDpDt;
                    fArr3[1] = this.mTouchDirectionY * min2;
                    fArr3[0] = min2 * this.mTouchDirectionX;
                }
                float f8 = this.mTouchDirectionX;
                float[] fArr4 = this.mAnchorDpDt;
                if (((double) Math.abs(((f8 * fArr4[0]) + (this.mTouchDirectionY * fArr4[1])) * this.mDragScale)) < 0.01d) {
                    float[] fArr5 = this.mAnchorDpDt;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                if (this.mTouchDirectionX != 0.0f) {
                    f2 = rawX / this.mAnchorDpDt[0];
                } else {
                    f2 = rawY / this.mAnchorDpDt[1];
                }
                float max = Math.max(Math.min(progress2 + f2, 1.0f), 0.0f);
                if (this.mOnTouchUp == 6) {
                    max = Math.max(max, 0.01f);
                }
                if (this.mOnTouchUp == 7) {
                    max = Math.min(max, 0.99f);
                }
                float progress3 = this.mMotionLayout.getProgress();
                if (max != progress3) {
                    int i5 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i5 == 0 || progress3 == 1.0f) {
                        this.mMotionLayout.endTrigger(i5 == 0);
                    }
                    this.mMotionLayout.setProgress(max);
                    motionTracker.computeCurrentVelocity(1000);
                    this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? motionTracker.getXVelocity() / this.mAnchorDpDt[0] : motionTracker.getYVelocity() / this.mAnchorDpDt[1];
                } else {
                    this.mMotionLayout.mLastVelocity = 0.0f;
                }
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02c2  */
    public void processTouchRotateEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        int i2;
        float f;
        int i3;
        float left;
        float f2;
        int top;
        int bottom;
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
        } else if (action == 1) {
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(16);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            float width = ((float) this.mMotionLayout.getWidth()) / 2.0f;
            float height = ((float) this.mMotionLayout.getHeight()) / 2.0f;
            int i4 = this.mRotationCenterId;
            if (i4 != -1) {
                View findViewById = this.mMotionLayout.findViewById(i4);
                this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
                left = ((float) this.mTempLoc[0]) + (((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f);
                f2 = (float) this.mTempLoc[1];
                top = findViewById.getTop();
                bottom = findViewById.getBottom();
            } else {
                int i5 = this.mTouchAnchorId;
                if (i5 != -1) {
                    View findViewById2 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(i5).getAnimateRelativeTo());
                    this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
                    left = ((float) this.mTempLoc[0]) + (((float) (findViewById2.getLeft() + findViewById2.getRight())) / 2.0f);
                    f2 = (float) this.mTempLoc[1];
                    top = findViewById2.getTop();
                    bottom = findViewById2.getBottom();
                }
                float rawX = motionEvent.getRawX() - width;
                float rawY = motionEvent.getRawY() - height;
                double degrees = Math.toDegrees(Math.atan2((double) rawY, (double) rawX));
                i2 = this.mTouchAnchorId;
                if (i2 == -1) {
                    this.mMotionLayout.getAnchorDpDt(i2, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    float[] fArr = this.mAnchorDpDt;
                    fArr[1] = (float) Math.toDegrees((double) fArr[1]);
                } else {
                    this.mAnchorDpDt[1] = 360.0f;
                }
                float degrees2 = ((float) (Math.toDegrees(Math.atan2((double) (yVelocity + rawY), (double) (xVelocity + rawX))) - degrees)) * 62.5f;
                f = Float.isNaN(degrees2) ? (((degrees2 * 3.0f) * this.mDragScale) / this.mAnchorDpDt[1]) + progress : progress;
                if (f == 0.0f && f != 1.0f && (i3 = this.mOnTouchUp) != 3) {
                    float f3 = (degrees2 * this.mDragScale) / this.mAnchorDpDt[1];
                    float f4 = ((double) f) < 0.5d ? 0.0f : 1.0f;
                    if (i3 == 6) {
                        if (progress + f3 < 0.0f) {
                            f3 = Math.abs(f3);
                        }
                        f4 = 1.0f;
                    }
                    if (this.mOnTouchUp == 7) {
                        if (progress + f3 > 1.0f) {
                            f3 = -Math.abs(f3);
                        }
                        f4 = 0.0f;
                    }
                    this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, f4, f3 * 3.0f);
                    if (0.0f >= progress || 1.0f <= progress) {
                        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        return;
                    }
                    return;
                } else if (0.0f < f || 1.0f <= f) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                } else {
                    return;
                }
            }
            height = f2 + (((float) (top + bottom)) / 2.0f);
            width = left;
            float rawX2 = motionEvent.getRawX() - width;
            float rawY2 = motionEvent.getRawY() - height;
            double degrees3 = Math.toDegrees(Math.atan2((double) rawY2, (double) rawX2));
            i2 = this.mTouchAnchorId;
            if (i2 == -1) {
            }
            float degrees22 = ((float) (Math.toDegrees(Math.atan2((double) (yVelocity + rawY2), (double) (xVelocity + rawX2))) - degrees3)) * 62.5f;
            if (Float.isNaN(degrees22)) {
            }
            if (f == 0.0f) {
            }
            if (0.0f < f) {
            }
            this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        } else if (action == 2) {
            motionEvent.getRawY();
            motionEvent.getRawX();
            float width2 = ((float) this.mMotionLayout.getWidth()) / 2.0f;
            float height2 = ((float) this.mMotionLayout.getHeight()) / 2.0f;
            int i6 = this.mRotationCenterId;
            if (i6 != -1) {
                View findViewById3 = this.mMotionLayout.findViewById(i6);
                this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
                float left2 = ((float) this.mTempLoc[0]) + (((float) (findViewById3.getLeft() + findViewById3.getRight())) / 2.0f);
                height2 = (((float) (findViewById3.getTop() + findViewById3.getBottom())) / 2.0f) + ((float) this.mTempLoc[1]);
                width2 = left2;
            } else {
                int i7 = this.mTouchAnchorId;
                if (i7 != -1) {
                    View findViewById4 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(i7).getAnimateRelativeTo());
                    if (findViewById4 == null) {
                        Log.e(TAG, "could not find view to animate to");
                    } else {
                        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
                        width2 = ((float) this.mTempLoc[0]) + (((float) (findViewById4.getLeft() + findViewById4.getRight())) / 2.0f);
                        height2 = ((float) this.mTempLoc[1]) + (((float) (findViewById4.getTop() + findViewById4.getBottom())) / 2.0f);
                    }
                }
            }
            float rawX3 = motionEvent.getRawX() - width2;
            float rawY3 = motionEvent.getRawY() - height2;
            double atan2 = Math.atan2((double) (motionEvent.getRawY() - height2), (double) (motionEvent.getRawX() - width2));
            float atan22 = (float) (((atan2 - Math.atan2((double) (this.mLastTouchY - height2), (double) (this.mLastTouchX - width2))) * 180.0d) / 3.141592653589793d);
            if (atan22 > 330.0f) {
                atan22 -= 360.0f;
            } else if (atan22 < -330.0f) {
                atan22 += 360.0f;
            }
            if (((double) Math.abs(atan22)) > 0.01d || this.mDragStarted) {
                float progress2 = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(progress2);
                }
                int i8 = this.mTouchAnchorId;
                if (i8 != -1) {
                    this.mMotionLayout.getAnchorDpDt(i8, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    float[] fArr2 = this.mAnchorDpDt;
                    fArr2[1] = (float) Math.toDegrees((double) fArr2[1]);
                } else {
                    this.mAnchorDpDt[1] = 360.0f;
                }
                float max = Math.max(Math.min(progress2 + ((atan22 * this.mDragScale) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
                float progress3 = this.mMotionLayout.getProgress();
                if (max != progress3) {
                    int i9 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i9 == 0 || progress3 == 1.0f) {
                        MotionLayout motionLayout = this.mMotionLayout;
                        if (i9 == 0) {
                            z = true;
                        }
                        motionLayout.endTrigger(z);
                    }
                    this.mMotionLayout.setProgress(max);
                    motionTracker.computeCurrentVelocity(1000);
                    float xVelocity2 = motionTracker.getXVelocity();
                    double yVelocity2 = (double) motionTracker.getYVelocity();
                    double d = (double) xVelocity2;
                    this.mMotionLayout.mLastVelocity = (float) Math.toDegrees((double) ((float) ((Math.hypot(yVelocity2, d) * Math.sin(Math.atan2(yVelocity2, d) - atan2)) / Math.hypot((double) rawX3, (double) rawY3))));
                } else {
                    this.mMotionLayout.mLastVelocity = 0.0f;
                }
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void scrollMove(float f, float f2) {
        float f3;
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (((double) Math.abs((f4 * fArr[0]) + (this.mTouchDirectionY * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f5 = this.mTouchDirectionX;
        if (f5 != 0.0f) {
            f3 = (f * f5) / this.mAnchorDpDt[0];
        } else {
            f3 = (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        float max = Math.max(Math.min(progress + f3, 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    /* access modifiers changed from: package-private */
    public void scrollUp(float f, float f2) {
        float f3;
        boolean z = false;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f5 = fArr[0];
        float f6 = this.mTouchDirectionY;
        float f7 = fArr[1];
        float f8 = 0.0f;
        if (f4 != 0.0f) {
            f3 = (f * f4) / fArr[0];
        } else {
            f3 = (f2 * f6) / fArr[1];
        }
        if (!Float.isNaN(f3)) {
            progress += f3 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z2 = progress != 1.0f;
            int i = this.mOnTouchUp;
            if (i != 3) {
                z = true;
            }
            if (z && z2) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (((double) progress) >= 0.5d) {
                    f8 = 1.0f;
                }
                motionLayout.touchAnimateTo(i, f8, f3);
            }
        }
    }

    public void setAnchorId(int i) {
        this.mTouchAnchorId = i;
    }

    /* access modifiers changed from: package-private */
    public void setAutoCompleteMode(int i) {
        this.mAutoCompleteMode = i;
    }

    /* access modifiers changed from: package-private */
    public void setDown(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
    }

    public void setMaxAcceleration(float f) {
        this.mMaxAcceleration = f;
    }

    public void setMaxVelocity(float f) {
        this.mMaxVelocity = f;
    }

    public void setRTL(boolean z) {
        if (z) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = TOUCH_SIDES;
        int i = this.mTouchAnchorSide;
        this.mTouchAnchorX = fArr5[i][0];
        this.mTouchAnchorY = fArr5[i][1];
        int i2 = this.mTouchSide;
        float[][] fArr6 = TOUCH_DIRECTION;
        if (i2 < fArr6.length) {
            this.mTouchDirectionX = fArr6[i2][0];
            this.mTouchDirectionY = fArr6[i2][1];
        }
    }

    public void setTouchAnchorLocation(float f, float f2) {
        this.mTouchAnchorX = f;
        this.mTouchAnchorY = f2;
    }

    public void setTouchUpMode(int i) {
        this.mOnTouchUp = i;
    }

    /* access modifiers changed from: package-private */
    public void setUpTouchEvent(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
        this.mDragStarted = false;
    }

    /* access modifiers changed from: package-private */
    public void setupTouch() {
        View view;
        int i = this.mTouchAnchorId;
        if (i != -1) {
            view = this.mMotionLayout.findViewById(i);
            if (view == null) {
                Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                /* class androidx.constraintlayout.motion.widget.TouchResponse.AnonymousClass1 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                /* class androidx.constraintlayout.motion.widget.TouchResponse.AnonymousClass2 */

                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                }
            });
        }
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX)) {
            return "rotation";
        }
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }

    public TouchResponse(MotionLayout motionLayout, OnSwipe onSwipe) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = motionLayout;
        this.mTouchAnchorId = onSwipe.getTouchAnchorId();
        int touchAnchorSide = onSwipe.getTouchAnchorSide();
        this.mTouchAnchorSide = touchAnchorSide;
        if (touchAnchorSide != -1) {
            float[][] fArr = TOUCH_SIDES;
            this.mTouchAnchorX = fArr[touchAnchorSide][0];
            this.mTouchAnchorY = fArr[touchAnchorSide][1];
        }
        int dragDirection = onSwipe.getDragDirection();
        this.mTouchSide = dragDirection;
        float[][] fArr2 = TOUCH_DIRECTION;
        if (dragDirection < fArr2.length) {
            this.mTouchDirectionX = fArr2[dragDirection][0];
            this.mTouchDirectionY = fArr2[dragDirection][1];
        } else {
            this.mTouchDirectionY = Float.NaN;
            this.mTouchDirectionX = Float.NaN;
            this.mIsRotateMode = true;
        }
        this.mMaxVelocity = onSwipe.getMaxVelocity();
        this.mMaxAcceleration = onSwipe.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = onSwipe.getMoveWhenScrollAtTop();
        this.mDragScale = onSwipe.getDragScale();
        this.mDragThreshold = onSwipe.getDragThreshold();
        this.mTouchRegionId = onSwipe.getTouchRegionId();
        this.mOnTouchUp = onSwipe.getOnTouchUp();
        this.mFlags = onSwipe.getNestedScrollFlags();
        this.mLimitBoundsTo = onSwipe.getLimitBoundsTo();
        this.mRotationCenterId = onSwipe.getRotationCenterId();
        this.mSpringBoundary = onSwipe.getSpringBoundary();
        this.mSpringDamping = onSwipe.getSpringDamping();
        this.mSpringMass = onSwipe.getSpringMass();
        this.mSpringStiffness = onSwipe.getSpringStiffness();
        this.mSpringStopThreshold = onSwipe.getSpringStopThreshold();
        this.mAutoCompleteMode = onSwipe.getAutoCompleteMode();
    }
}

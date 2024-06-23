package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* compiled from: Taobao */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int fadeMove = -1;
    private float motionEffectAlpha = 0.1f;
    private int motionEffectEnd = 50;
    private int motionEffectStart = 49;
    private boolean motionEffectStrictMove = true;
    private int motionEffectTranslationX = 0;
    private int motionEffectTranslationY = 0;
    private int viewTransitionId = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.motionEffectStart);
                    this.motionEffectStart = i2;
                    this.motionEffectStart = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.motionEffectEnd);
                    this.motionEffectEnd = i3;
                    this.motionEffectEnd = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.motionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.motionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.motionEffectAlpha = obtainStyledAttributes.getFloat(index, this.motionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.fadeMove = obtainStyledAttributes.getInt(index, this.fadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.motionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.motionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.viewTransitionId = obtainStyledAttributes.getResourceId(index, this.viewTransitionId);
                }
            }
            int i4 = this.motionEffectStart;
            int i5 = this.motionEffectEnd;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.motionEffectStart = i4 - 1;
                } else {
                    this.motionEffectEnd = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018d, code lost:
        if (r14 == 0.0f) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01a1, code lost:
        if (r14 == 0.0f) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b1, code lost:
        if (r15 == 0.0f) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01c1, code lost:
        if (r15 == 0.0f) goto L_0x0190;
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c7  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
        KeyAttributes keyAttributes;
        KeyAttributes keyAttributes2;
        KeyAttributes keyAttributes3;
        boolean z;
        HashMap<View, MotionController> hashMap2 = hashMap;
        View[] views = getViews((ConstraintLayout) getParent());
        if (views == null) {
            Log.v(TAG, Debug.getLoc() + " views = null");
            return;
        }
        KeyAttributes keyAttributes4 = new KeyAttributes();
        KeyAttributes keyAttributes5 = new KeyAttributes();
        keyAttributes4.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        keyAttributes5.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        keyAttributes4.setFramePosition(this.motionEffectStart);
        keyAttributes5.setFramePosition(this.motionEffectEnd);
        KeyPosition keyPosition = new KeyPosition();
        keyPosition.setFramePosition(this.motionEffectStart);
        keyPosition.setType(0);
        keyPosition.setValue("percentX", 0);
        keyPosition.setValue("percentY", 0);
        KeyPosition keyPosition2 = new KeyPosition();
        keyPosition2.setFramePosition(this.motionEffectEnd);
        keyPosition2.setType(0);
        keyPosition2.setValue("percentX", 1);
        keyPosition2.setValue("percentY", 1);
        KeyAttributes keyAttributes6 = null;
        if (this.motionEffectTranslationX > 0) {
            keyAttributes2 = new KeyAttributes();
            keyAttributes = new KeyAttributes();
            keyAttributes2.setValue("translationX", Integer.valueOf(this.motionEffectTranslationX));
            keyAttributes2.setFramePosition(this.motionEffectEnd);
            keyAttributes.setValue("translationX", 0);
            keyAttributes.setFramePosition(this.motionEffectEnd - 1);
        } else {
            keyAttributes2 = null;
            keyAttributes = null;
        }
        if (this.motionEffectTranslationY > 0) {
            keyAttributes6 = new KeyAttributes();
            keyAttributes3 = new KeyAttributes();
            keyAttributes6.setValue("translationY", Integer.valueOf(this.motionEffectTranslationY));
            keyAttributes6.setFramePosition(this.motionEffectEnd);
            keyAttributes3.setValue("translationY", 0);
            keyAttributes3.setFramePosition(this.motionEffectEnd - 1);
        } else {
            keyAttributes3 = null;
        }
        int i = this.fadeMove;
        if (i == -1) {
            int[] iArr = new int[4];
            for (View view : views) {
                MotionController motionController = hashMap2.get(view);
                if (motionController != null) {
                    float finalX = motionController.getFinalX() - motionController.getStartX();
                    float finalY = motionController.getFinalY() - motionController.getStartY();
                    if (finalY < 0.0f) {
                        iArr[1] = iArr[1] + 1;
                    }
                    if (finalY > 0.0f) {
                        iArr[0] = iArr[0] + 1;
                    }
                    if (finalX > 0.0f) {
                        iArr[3] = iArr[3] + 1;
                    }
                    if (finalX < 0.0f) {
                        iArr[2] = iArr[2] + 1;
                    }
                }
            }
            int i2 = iArr[0];
            int i3 = 1;
            i = 0;
            for (int i4 = 4; i3 < i4; i4 = 4) {
                if (i2 < iArr[i3]) {
                    i = i3;
                    i2 = iArr[i3];
                }
                i3++;
            }
        }
        int i5 = 0;
        while (i5 < views.length) {
            MotionController motionController2 = hashMap2.get(views[i5]);
            if (motionController2 != null) {
                float finalX2 = motionController2.getFinalX() - motionController2.getStartX();
                float finalY2 = motionController2.getFinalY() - motionController2.getStartY();
                if (i == 0) {
                    if (finalY2 > 0.0f) {
                        if (this.motionEffectStrictMove) {
                        }
                    }
                    z = true;
                    if (z) {
                        int i6 = this.viewTransitionId;
                        if (i6 == -1) {
                            motionController2.addKey(keyAttributes4);
                            motionController2.addKey(keyAttributes5);
                            motionController2.addKey(keyPosition);
                            motionController2.addKey(keyPosition2);
                            if (this.motionEffectTranslationX > 0) {
                                motionController2.addKey(keyAttributes2);
                                motionController2.addKey(keyAttributes);
                            }
                            if (this.motionEffectTranslationY > 0) {
                                motionController2.addKey(keyAttributes6);
                                motionController2.addKey(keyAttributes3);
                            }
                        } else {
                            motionLayout.applyViewTransition(i6, motionController2);
                        }
                        i5++;
                        hashMap2 = hashMap;
                    }
                } else if (i == 1) {
                    if (finalY2 < 0.0f) {
                        if (this.motionEffectStrictMove) {
                        }
                    }
                    z = true;
                    if (z) {
                    }
                } else if (i == 2) {
                    if (finalX2 < 0.0f) {
                        if (this.motionEffectStrictMove) {
                        }
                    }
                    z = true;
                    if (z) {
                    }
                } else {
                    if (i == 3) {
                        if (finalX2 > 0.0f) {
                            if (this.motionEffectStrictMove) {
                            }
                            z = false;
                            if (z) {
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                z = false;
                if (z) {
                }
            }
            i5++;
            hashMap2 = hashMap;
        }
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}

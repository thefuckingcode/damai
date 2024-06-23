package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.CharUtils;
import tb.dp2;

/* compiled from: Taobao */
public class MotionKeyAttributes extends MotionKey {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    private float mAlpha = Float.NaN;
    private int mCurveFit = -1;
    private float mElevation = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mProgress = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private String mTransitionEasing;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private int mVisibility = 0;

    public MotionKeyAttributes() {
        this.mType = 1;
        this.mCustom = new HashMap<>();
    }

    private float getFloatValue(int i) {
        if (i == 100) {
            return (float) this.mFramePosition;
        }
        switch (i) {
            case 303:
                return this.mAlpha;
            case 304:
                return this.mTranslationX;
            case 305:
                return this.mTranslationY;
            case 306:
                return this.mTranslationZ;
            case 307:
                return this.mElevation;
            case 308:
                return this.mRotationX;
            case 309:
                return this.mRotationY;
            case 310:
                return this.mRotation;
            case 311:
                return this.mScaleX;
            case 312:
                return this.mScaleY;
            case 313:
                return this.mPivotX;
            case 314:
                return this.mPivotY;
            case 315:
                return this.mProgress;
            case TypedValues.Attributes.TYPE_PATH_ROTATE /*{ENCODED_INT: 316}*/:
                return this.mTransitionPathRotate;
            default:
                return Float.NaN;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
        if (r1.equals("pivotX") == false) goto L_0x0044;
     */
    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            SplineSet splineSet = hashMap.get(next);
            if (splineSet != null) {
                char c = 7;
                if (next.startsWith("CUSTOM")) {
                    CustomVariable customVariable = this.mCustom.get(next.substring(7));
                    if (customVariable != null) {
                        ((SplineSet.CustomSpline) splineSet).setPoint(this.mFramePosition, customVariable);
                    }
                } else {
                    switch (next.hashCode()) {
                        case -1249320806:
                            if (next.equals("rotationX")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1249320805:
                            if (next.equals("rotationY")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1249320804:
                            if (next.equals("rotationZ")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497657:
                            if (next.equals("translationX")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497656:
                            if (next.equals("translationY")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497655:
                            if (next.equals("translationZ")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1001078227:
                            if (next.equals("progress")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -987906986:
                            break;
                        case -987906985:
                            if (next.equals("pivotY")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189618:
                            if (next.equals("scaleX")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189617:
                            if (next.equals("scaleY")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -4379043:
                            if (next.equals("elevation")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 92909918:
                            if (next.equals("alpha")) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case 803192288:
                            if (next.equals("pathRotate")) {
                                c = CharUtils.CR;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (!Float.isNaN(this.mRotationX)) {
                                splineSet.setPoint(this.mFramePosition, this.mRotationX);
                                break;
                            } else {
                                continue;
                            }
                        case 1:
                            if (!Float.isNaN(this.mRotationY)) {
                                splineSet.setPoint(this.mFramePosition, this.mRotationY);
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if (!Float.isNaN(this.mRotation)) {
                                splineSet.setPoint(this.mFramePosition, this.mRotation);
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if (!Float.isNaN(this.mTranslationX)) {
                                splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if (!Float.isNaN(this.mTranslationY)) {
                                splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if (!Float.isNaN(this.mTranslationZ)) {
                                splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if (!Float.isNaN(this.mProgress)) {
                                splineSet.setPoint(this.mFramePosition, this.mProgress);
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if (!Float.isNaN(this.mRotationX)) {
                                splineSet.setPoint(this.mFramePosition, this.mPivotX);
                                break;
                            } else {
                                continue;
                            }
                        case '\b':
                            if (!Float.isNaN(this.mRotationY)) {
                                splineSet.setPoint(this.mFramePosition, this.mPivotY);
                                break;
                            } else {
                                continue;
                            }
                        case '\t':
                            if (!Float.isNaN(this.mScaleX)) {
                                splineSet.setPoint(this.mFramePosition, this.mScaleX);
                                break;
                            } else {
                                continue;
                            }
                        case '\n':
                            if (!Float.isNaN(this.mScaleY)) {
                                splineSet.setPoint(this.mFramePosition, this.mScaleY);
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if (!Float.isNaN(this.mElevation)) {
                                splineSet.setPoint(this.mFramePosition, this.mElevation);
                                break;
                            } else {
                                continue;
                            }
                        case '\f':
                            if (!Float.isNaN(this.mAlpha)) {
                                splineSet.setPoint(this.mFramePosition, this.mAlpha);
                                break;
                            } else {
                                continue;
                            }
                        case '\r':
                            if (!Float.isNaN(this.mTransitionPathRotate)) {
                                splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                                break;
                            } else {
                                continue;
                            }
                        default:
                            PrintStream printStream = System.err;
                            printStream.println("not supported by KeyAttributes " + next);
                            continue;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add("pivotY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return dp2.a(str);
    }

    public void printAttributes() {
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        PrintStream printStream = System.out;
        printStream.println(" ------------- " + this.mFramePosition + " -------------");
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            int a = dp2.a(strArr[i]);
            PrintStream printStream2 = System.out;
            printStream2.println(strArr[i] + ":" + getFloatValue(a));
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (!Float.isNaN(this.mAlpha)) {
            hashMap.put("alpha", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            hashMap.put("elevation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            hashMap.put("rotationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashMap.put("rotationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashMap.put("rotationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashMap.put("pivotX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashMap.put("pivotY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashMap.put("translationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashMap.put("translationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put("pathRotate", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put("scaleX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashMap.put("scaleY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            hashMap.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues, androidx.constraintlayout.core.motion.key.MotionKey
    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        } else if (i == 301) {
            this.mCurveFit = i2;
            return true;
        } else if (i == 302) {
            this.mVisibility = i2;
            return true;
        } else if (!setValue(i, i2)) {
            return super.setValue(i, i2);
        } else {
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues, androidx.constraintlayout.core.motion.key.MotionKey
    public boolean setValue(int i, float f) {
        if (i != 100) {
            switch (i) {
                case 303:
                    this.mAlpha = f;
                    return true;
                case 304:
                    this.mTranslationX = f;
                    return true;
                case 305:
                    this.mTranslationY = f;
                    return true;
                case 306:
                    this.mTranslationZ = f;
                    return true;
                case 307:
                    this.mElevation = f;
                    return true;
                case 308:
                    this.mRotationX = f;
                    return true;
                case 309:
                    this.mRotationY = f;
                    return true;
                case 310:
                    this.mRotation = f;
                    return true;
                case 311:
                    this.mScaleX = f;
                    return true;
                case 312:
                    this.mScaleY = f;
                    return true;
                case 313:
                    this.mPivotX = f;
                    return true;
                case 314:
                    this.mPivotY = f;
                    return true;
                case 315:
                    this.mProgress = f;
                    return true;
                case TypedValues.Attributes.TYPE_PATH_ROTATE /*{ENCODED_INT: 316}*/:
                    this.mTransitionPathRotate = f;
                    return true;
                default:
                    return super.setValue(i, f);
            }
        } else {
            this.mTransitionPathRotate = f;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues, androidx.constraintlayout.core.motion.key.MotionKey
    public boolean setValue(int i, String str) {
        if (i == 101) {
            this.mTargetString = str;
            return true;
        } else if (i != 317) {
            return super.setValue(i, str);
        } else {
            this.mTransitionEasing = str;
            return true;
        }
    }
}

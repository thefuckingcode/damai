package com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.SoftReference;

/* compiled from: Taobao */
public class FramesSequenceAnimation {
    private static transient /* synthetic */ IpChange $ipChange;
    private int NONE_INDEX = -1;
    private int NONE_RES = -1;
    private boolean isLoop = false;
    private Bitmap mBitmap = null;
    private BitmapFactory.Options mBitmapOptions;
    private int mDelayMillis;
    private int[] mFrames;
    private Handler mHandler;
    private int mIndex;
    private boolean mIsRunning;
    private OnAnimationListener mOnAnimationListener;
    private boolean mShouldRun;
    private SoftReference<ImageView> mSoftReferenceImageView;

    /* compiled from: Taobao */
    public interface OnAnimationListener {
        void onAnimationEnd();

        void onAnimationStart();

        void onAnimationStop();
    }

    public FramesSequenceAnimation(ImageView imageView, int[] iArr, int i) {
        if (imageView != null && iArr != null && iArr.length != 0) {
            this.mHandler = new Handler();
            this.mFrames = iArr;
            this.mIndex = this.NONE_INDEX;
            this.mSoftReferenceImageView = new SoftReference<>(imageView);
            this.mShouldRun = false;
            this.mIsRunning = false;
            this.mDelayMillis = 1000 / (i == 0 ? 12 : i);
            imageView.setImageResource(this.mFrames[0]);
            if (Build.VERSION.SDK_INT >= 11) {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                BitmapFactory.Options options = new BitmapFactory.Options();
                this.mBitmapOptions = options;
                options.inBitmap = this.mBitmap;
                options.inMutable = true;
                options.inSampleSize = 1;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getNext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411132537")) {
            return ((Integer) ipChange.ipc$dispatch("1411132537", new Object[]{this})).intValue();
        }
        int[] iArr = this.mFrames;
        if (iArr == null) {
            return this.NONE_RES;
        }
        int i = this.mIndex + 1;
        this.mIndex = i;
        if (i >= iArr.length) {
            this.mIndex = 0;
            if (!this.isLoop) {
                stop();
            }
        } else if (i == iArr.length - 1 && !this.isLoop) {
            stop();
            return this.NONE_RES;
        }
        return this.mFrames[this.mIndex];
    }

    public void setOnAnimStopListener(OnAnimationListener onAnimationListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297524261")) {
            ipChange.ipc$dispatch("-1297524261", new Object[]{this, onAnimationListener});
            return;
        }
        this.mOnAnimationListener = onAnimationListener;
    }

    public synchronized void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099311763")) {
            ipChange.ipc$dispatch("-2099311763", new Object[]{this});
            return;
        }
        int[] iArr = this.mFrames;
        if (iArr != null && iArr.length != 0) {
            this.mShouldRun = true;
            if (!this.mIsRunning) {
                AnonymousClass1 r0 = new Runnable() {
                    /* class com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        int next;
                        Bitmap bitmap;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1011704393")) {
                            ipChange.ipc$dispatch("-1011704393", new Object[]{this});
                        } else if (FramesSequenceAnimation.this.mSoftReferenceImageView != null) {
                            ImageView imageView = (ImageView) FramesSequenceAnimation.this.mSoftReferenceImageView.get();
                            if (!FramesSequenceAnimation.this.mShouldRun || imageView == null) {
                                FramesSequenceAnimation.this.mIsRunning = false;
                                return;
                            }
                            FramesSequenceAnimation.this.mIsRunning = true;
                            if (FramesSequenceAnimation.this.mHandler != null) {
                                FramesSequenceAnimation.this.mHandler.postDelayed(this, (long) FramesSequenceAnimation.this.mDelayMillis);
                            }
                            if (imageView.isShown() && (next = FramesSequenceAnimation.this.getNext()) != FramesSequenceAnimation.this.NONE_RES) {
                                if (FramesSequenceAnimation.this.mBitmap != null) {
                                    try {
                                        bitmap = BitmapFactory.decodeResource(imageView.getResources(), next, FramesSequenceAnimation.this.mBitmapOptions);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        bitmap = null;
                                    }
                                    if (!FramesSequenceAnimation.this.mShouldRun) {
                                        return;
                                    }
                                    if (bitmap != null) {
                                        imageView.setImageBitmap(bitmap);
                                        return;
                                    }
                                    imageView.setImageResource(next);
                                    FramesSequenceAnimation.this.mBitmap.recycle();
                                    FramesSequenceAnimation.this.mBitmap = null;
                                } else if (FramesSequenceAnimation.this.mShouldRun) {
                                    imageView.setImageResource(next);
                                }
                            }
                        }
                    }
                };
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.post(r0);
                }
            }
        }
    }

    public synchronized void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133132967")) {
            ipChange.ipc$dispatch("-2133132967", new Object[]{this});
            return;
        }
        OnAnimationListener onAnimationListener = this.mOnAnimationListener;
        if (onAnimationListener != null) {
            onAnimationListener.onAnimationStop();
        }
        this.mShouldRun = false;
    }
}

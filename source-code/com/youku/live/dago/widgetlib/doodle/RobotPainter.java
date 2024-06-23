package com.youku.live.dago.widgetlib.doodle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
public class RobotPainter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_DRAW_INTERVAL = 100;
    private static final int MSG_DRAW = 1;
    private float mBoardRatio = -1.0f;
    private int mCanvasHeight = -1;
    private float mCanvasRatio = -1.0f;
    private int mCanvasWidth = -1;
    private long mDrawInterval = DEFAULT_DRAW_INTERVAL;
    private Handler mHandler;
    private OnPaintListener mOnPaintListener;
    private ScaleType mScaleType = ScaleType.FIX_XY;
    private SketchBoard mSketchBoard;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.live.dago.widgetlib.doodle.RobotPainter$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[ScaleType.values().length];
            $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType = iArr;
            iArr[ScaleType.FIX_XY.ordinal()] = 1;
            $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType[ScaleType.CENTER_CROP.ordinal()] = 2;
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType[ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public static class DrawHandler extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private WeakReference<RobotPainter> mRobotPainterRef;

        public DrawHandler(Looper looper, RobotPainter robotPainter) {
            super(looper);
            this.mRobotPainterRef = new WeakReference<>(robotPainter);
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1928990065")) {
                ipChange.ipc$dispatch("1928990065", new Object[]{this, message});
                return;
            }
            RobotPainter robotPainter = this.mRobotPainterRef.get();
            if (robotPainter != null && message.what == 1) {
                SplashScheduler.SplashItem splashItem = (SplashScheduler.SplashItem) message.obj;
                robotPainter.updateSplashItem(splashItem);
                SketchBoard sketchBoard = robotPainter.mSketchBoard;
                SplashScheduler.IconItem iconItem = splashItem.iconItem;
                sketchBoard.draw(iconItem.icon, iconItem.iconIdentity, (int) splashItem.x, (int) splashItem.y);
                if (robotPainter.mOnPaintListener != null) {
                    if (message.arg1 == 0) {
                        robotPainter.mOnPaintListener.onPaintingStart();
                    }
                    if (message.arg1 == message.arg2 - 1) {
                        robotPainter.mOnPaintListener.onPaintingEnd();
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public interface OnPaintListener {
        void onPaintingEnd();

        void onPaintingStart();
    }

    /* compiled from: Taobao */
    public enum ScaleType {
        NONE("NULL"),
        FIX_XY("fix_xy"),
        CENTER_CROP("center_crop"),
        CENTER_INSIDE("center_inside");
        
        String typeName;

        private ScaleType(String str) {
            this.typeName = str;
        }

        public static ScaleType toScaleType(String str) {
            ScaleType[] values = values();
            for (ScaleType scaleType : values) {
                if (scaleType.typeName.equals(str)) {
                    return scaleType;
                }
            }
            return NONE;
        }
    }

    public RobotPainter(SketchBoard sketchBoard) {
        this.mSketchBoard = sketchBoard;
        if (sketchBoard != null) {
            this.mHandler = new DrawHandler(Looper.getMainLooper(), this);
            return;
        }
        throw new IllegalArgumentException("SplashBoard must not be null!");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateSplashItem(SplashScheduler.SplashItem splashItem) {
        int i;
        float f;
        int i2;
        float f2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747218210")) {
            ipChange.ipc$dispatch("747218210", new Object[]{this, splashItem});
            return;
        }
        int boardWidth = this.mSketchBoard.getBoardWidth();
        int boardHeight = this.mSketchBoard.getBoardHeight();
        if (!(this.mBoardRatio > 0.0f || boardWidth == 0 || boardHeight == 0)) {
            this.mBoardRatio = ((float) boardWidth) / ((float) boardHeight);
        }
        if (!(this.mCanvasRatio > 0.0f || (i3 = this.mCanvasWidth) == 0 || (i4 = this.mCanvasHeight) == 0)) {
            this.mCanvasRatio = ((float) i3) / ((float) i4);
        }
        int i5 = AnonymousClass1.$SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType[this.mScaleType.ordinal()];
        if (i5 == 1) {
            splashItem.x *= ((float) boardWidth) / ((float) this.mCanvasWidth);
            splashItem.y *= ((float) boardHeight) / ((float) this.mCanvasHeight);
        } else if (i5 == 2) {
            if (this.mBoardRatio > this.mCanvasRatio) {
                f = (float) boardWidth;
                i = this.mCanvasWidth;
            } else {
                f = (float) boardHeight;
                i = this.mCanvasHeight;
            }
            float f3 = f / ((float) i);
            splashItem.x *= f3;
            splashItem.y *= f3;
        } else if (i5 == 3) {
            if (this.mBoardRatio < this.mCanvasRatio) {
                f2 = (float) boardWidth;
                i2 = this.mCanvasWidth;
            } else {
                f2 = (float) boardHeight;
                i2 = this.mCanvasHeight;
            }
            float f4 = f2 / ((float) i2);
            splashItem.x *= f4;
            splashItem.y *= f4;
        }
    }

    public void paint(List<SplashScheduler.SplashItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628851442")) {
            ipChange.ipc$dispatch("628851442", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Message obtain = Message.obtain(this.mHandler, 1, list.get(i));
                obtain.arg1 = i;
                obtain.arg2 = size;
                this.mHandler.sendMessageAtTime(obtain, (((long) i) * this.mDrawInterval) + uptimeMillis);
            }
        }
    }

    public void setDrawInterval(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1678609360")) {
            ipChange.ipc$dispatch("-1678609360", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mDrawInterval = j;
    }

    public void setOnPaintListener(OnPaintListener onPaintListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267033770")) {
            ipChange.ipc$dispatch("1267033770", new Object[]{this, onPaintListener});
            return;
        }
        this.mOnPaintListener = onPaintListener;
    }

    public void setScaleType(ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471291190")) {
            ipChange.ipc$dispatch("-471291190", new Object[]{this, scaleType});
            return;
        }
        this.mScaleType = scaleType;
    }

    public void updateCanvasSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391669943")) {
            ipChange.ipc$dispatch("-391669943", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mCanvasWidth = i;
        this.mCanvasHeight = i2;
    }
}

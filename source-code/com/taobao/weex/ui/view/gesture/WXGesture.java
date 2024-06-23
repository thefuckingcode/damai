package com.taobao.weex.ui.view.gesture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class WXGesture extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    private static final int CUR_EVENT = -1;
    public static final String DOWN = "down";
    public static final String END = "end";
    public static final String LEFT = "left";
    public static final String MOVE = "move";
    public static final String RIGHT = "right";
    public static final String START = "start";
    private static final String TAG = "Gesture";
    public static final String UNKNOWN = "unknown";
    public static final String UP = "up";
    private WXComponent component;
    private Point globalEventOffset;
    private Point globalOffset;
    private Rect globalRect;
    private PointF locEventOffset;
    private PointF locLeftTop;
    private GestureDetector mGestureDetector;
    private boolean mIsPreventMoveEvent = false;
    private boolean mIsTouchEventConsumed = false;
    private int mParentOrientation = -1;
    private WXGestureType mPendingPan = null;
    private final List<View.OnTouchListener> mTouchListeners = new LinkedList();
    private long panDownTime = -1;
    private boolean requestDisallowInterceptTouchEvent = false;
    private int shouldBubbleCallRemainTimes = 0;
    private int shouldBubbleInterval = 0;
    private boolean shouldBubbleResult = true;
    private long swipeDownTime = -1;

    /* compiled from: Taobao */
    private static class GestureHandler extends Handler {
        public GestureHandler() {
            super(Looper.getMainLooper());
        }
    }

    public WXGesture(WXComponent wXComponent, Context context) {
        this.component = wXComponent;
        this.globalRect = new Rect();
        this.globalOffset = new Point();
        this.globalEventOffset = new Point();
        this.locEventOffset = new PointF();
        this.locLeftTop = new PointF();
        this.mGestureDetector = new GestureDetector(context, this, new GestureHandler());
        Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller != null) {
            this.mParentOrientation = parentScroller.getOrientation();
        }
        this.shouldBubbleResult = WXUtils.getBoolean(wXComponent.getAttrs().get(Constants.Name.SHOULD_STOP_PROPAGATION_INIT_RESULT), Boolean.TRUE).booleanValue();
        this.shouldBubbleInterval = WXUtils.getNumberInt(wXComponent.getAttrs().get(Constants.Name.SHOULD_STOP_PROPAGATION_INTERVAL), 0);
    }

    private boolean containsSimplePan() {
        return this.component.containsGesture(WXGestureType.HighLevelGesture.PAN_START) || this.component.containsGesture(WXGestureType.HighLevelGesture.PAN_MOVE) || this.component.containsGesture(WXGestureType.HighLevelGesture.PAN_END);
    }

    private Map<String, Object> createFireEventParam(MotionEvent motionEvent, int i, String str) {
        JSONArray jSONArray = new JSONArray(motionEvent.getPointerCount());
        if (motionEvent.getActionMasked() == 2) {
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                jSONArray.add(createJSONObject(motionEvent, i, i2));
            }
        } else if (isPointerNumChanged(motionEvent)) {
            jSONArray.add(createJSONObject(motionEvent, -1, motionEvent.getActionIndex()));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WXGestureType.GestureInfo.HISTORICAL_XY, jSONArray);
        if (str != null) {
            hashMap.put("state", str);
        }
        return hashMap;
    }

    private JSONObject createJSONObject(MotionEvent motionEvent, int i, int i2) {
        PointF pointF;
        PointF pointF2;
        if (i == -1) {
            pointF = getEventLocInPageCoordinate(motionEvent, i2);
            pointF2 = getEventLocInScreenCoordinate(motionEvent, i2);
        } else {
            PointF eventLocInPageCoordinate = getEventLocInPageCoordinate(motionEvent, i2, i);
            pointF2 = getEventLocInScreenCoordinate(motionEvent, i2, i);
            pointF = eventLocInPageCoordinate;
        }
        JSONObject createJSONObject = createJSONObject(pointF2, pointF, (float) motionEvent.getPointerId(i2));
        float pressure = motionEvent.getPressure();
        if (pressure > 0.0f && pressure < 1.0f) {
            createJSONObject.put("force", (Object) Float.valueOf(motionEvent.getPressure()));
        }
        return createJSONObject;
    }

    private List<Map<String, Object>> createMultipleFireEventParam(MotionEvent motionEvent, String str) {
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize() + 1);
        arrayList.add(createFireEventParam(motionEvent, -1, str));
        return arrayList;
    }

    private void finishDisallowInterceptTouchEvent(View view) {
        if (view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private PointF getEventLocInPageCoordinate(MotionEvent motionEvent, int i) {
        return getEventLocInPageCoordinate(motionEvent, i, -1);
    }

    private PointF getEventLocInScreenCoordinate(MotionEvent motionEvent, int i) {
        return getEventLocInScreenCoordinate(motionEvent, i, -1);
    }

    private List<Map<String, Object>> getHistoricalEvents(MotionEvent motionEvent) {
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
        if (motionEvent.getActionMasked() == 2) {
            for (int i = 0; i < motionEvent.getHistorySize(); i++) {
                arrayList.add(createFireEventParam(motionEvent, i, null));
            }
        }
        return arrayList;
    }

    private String getPanEventAction(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return "start";
        }
        if (action == 1) {
            return "end";
        }
        if (action != 2) {
            return action != 3 ? "unknown" : "end";
        }
        return MOVE;
    }

    private boolean handleMotionEvent(WXGestureType wXGestureType, MotionEvent motionEvent) {
        if (!this.component.containsGesture(wXGestureType)) {
            return false;
        }
        for (Map<String, Object> map : createMultipleFireEventParam(motionEvent, null)) {
            this.component.fireEvent(wXGestureType.toString(), map);
        }
        return true;
    }

    private boolean handlePanMotionEvent(MotionEvent motionEvent) {
        WXGestureType wXGestureType = this.mPendingPan;
        if (wXGestureType == null) {
            return false;
        }
        String panEventAction = (wXGestureType == WXGestureType.HighLevelGesture.HORIZONTALPAN || wXGestureType == WXGestureType.HighLevelGesture.VERTICALPAN) ? getPanEventAction(motionEvent) : null;
        if (!this.component.containsGesture(this.mPendingPan)) {
            return false;
        }
        if (this.mIsPreventMoveEvent && MOVE.equals(panEventAction)) {
            return true;
        }
        for (Map<String, Object> map : createMultipleFireEventParam(motionEvent, panEventAction)) {
            this.component.fireEvent(this.mPendingPan.toString(), map);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mPendingPan = null;
        }
        return true;
    }

    private boolean hasSameOrientationWithParent() {
        if (this.mParentOrientation == 0 && this.component.containsGesture(WXGestureType.HighLevelGesture.HORIZONTALPAN)) {
            return true;
        }
        if (this.mParentOrientation != 1 || !this.component.containsGesture(WXGestureType.HighLevelGesture.VERTICALPAN)) {
            return false;
        }
        return true;
    }

    public static boolean hasStopPropagation(WXComponent wXComponent) {
        WXEvent events = wXComponent.getEvents();
        if (events == null) {
            return false;
        }
        int size = events.size();
        int i = 0;
        while (i < size && i < events.size()) {
            if (isStopPropagation((String) events.get(i))) {
                return true;
            }
            i++;
        }
        return false;
    }

    private boolean isParentScrollable() {
        Scrollable parentScroller;
        WXComponent wXComponent = this.component;
        if (wXComponent == null || (parentScroller = wXComponent.getParentScroller()) == null || parentScroller.isScrollable()) {
            return true;
        }
        return false;
    }

    private boolean isPointerNumChanged(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5 || motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 3) {
            return true;
        }
        return false;
    }

    public static boolean isStopPropagation(String str) {
        return Constants.Event.STOP_PROPAGATION.equals(str) || Constants.Event.STOP_PROPAGATION_RAX.equals(str);
    }

    private boolean shouldBubbleTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!hasStopPropagation(this.component)) {
            return true;
        }
        if (this.shouldBubbleInterval <= 0 || (i = this.shouldBubbleCallRemainTimes) <= 0) {
            Map<String, Object> createFireEventParam = createFireEventParam(motionEvent, -1, null);
            createFireEventParam.put("type", "touch");
            if (motionEvent.getAction() == 0) {
                createFireEventParam.put("action", "start");
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                createFireEventParam.put("action", "end");
            } else {
                createFireEventParam.put("action", MOVE);
            }
            WXEvent events = this.component.getEvents();
            String str = Constants.Event.STOP_PROPAGATION;
            if (!events.contains(str)) {
                str = Constants.Event.STOP_PROPAGATION_RAX;
            }
            EventResult fireEventWait = this.component.fireEventWait(str, createFireEventParam);
            if (fireEventWait.isSuccess() && fireEventWait.getResult() != null) {
                this.shouldBubbleResult = !WXUtils.getBoolean(fireEventWait.getResult(), Boolean.valueOf(!this.shouldBubbleResult)).booleanValue();
            }
            this.shouldBubbleCallRemainTimes = this.shouldBubbleInterval;
            return this.shouldBubbleResult;
        }
        this.shouldBubbleCallRemainTimes = i - 1;
        return this.shouldBubbleResult;
    }

    public void addOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.mTouchListeners.add(onTouchListener);
        }
    }

    public boolean isRequestDisallowInterceptTouchEvent() {
        return this.requestDisallowInterceptTouchEvent;
    }

    public boolean isTouchEventConsumedByAdvancedGesture() {
        return this.mIsTouchEventConsumed;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        WXComponent wXComponent = this.component;
        WXGestureType.HighLevelGesture highLevelGesture = WXGestureType.HighLevelGesture.LONG_PRESS;
        if (wXComponent.containsGesture(highLevelGesture)) {
            List<Map<String, Object>> createMultipleFireEventParam = createMultipleFireEventParam(motionEvent, null);
            this.component.getInstance().fireEvent(this.component.getRef(), highLevelGesture.toString(), createMultipleFireEventParam.get(createMultipleFireEventParam.size() - 1));
            this.mIsTouchEventConsumed = true;
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        WXGestureType.HighLevelGesture highLevelGesture;
        boolean z;
        boolean z2 = false;
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (Math.abs(motionEvent2.getX() - motionEvent.getX()) > Math.abs(motionEvent2.getY() - motionEvent.getY())) {
            highLevelGesture = WXGestureType.HighLevelGesture.HORIZONTALPAN;
        } else {
            highLevelGesture = WXGestureType.HighLevelGesture.VERTICALPAN;
        }
        WXGestureType wXGestureType = this.mPendingPan;
        if (wXGestureType == WXGestureType.HighLevelGesture.HORIZONTALPAN || wXGestureType == WXGestureType.HighLevelGesture.VERTICALPAN) {
            z = handlePanMotionEvent(motionEvent2);
        } else {
            if (this.component.containsGesture(highLevelGesture)) {
                ViewParent parent = this.component.getRealView().getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                WXGestureType wXGestureType2 = this.mPendingPan;
                if (wXGestureType2 != null) {
                    handleMotionEvent(wXGestureType2, motionEvent2);
                }
                this.mPendingPan = highLevelGesture;
                this.component.fireEvent(highLevelGesture.toString(), createFireEventParam(motionEvent2, -1, "start"));
            } else if (!containsSimplePan()) {
                WXComponent wXComponent = this.component;
                WXGestureType.HighLevelGesture highLevelGesture2 = WXGestureType.HighLevelGesture.SWIPE;
                if (!wXComponent.containsGesture(highLevelGesture2) || this.swipeDownTime == motionEvent.getEventTime()) {
                    z = false;
                } else {
                    this.swipeDownTime = motionEvent.getEventTime();
                    List<Map<String, Object>> createMultipleFireEventParam = createMultipleFireEventParam(motionEvent2, null);
                    Map<String, Object> map = createMultipleFireEventParam.get(createMultipleFireEventParam.size() - 1);
                    if (Math.abs(f) > Math.abs(f2)) {
                        map.put("direction", f > 0.0f ? "left" : "right");
                    } else {
                        map.put("direction", f2 > 0.0f ? "up" : "down");
                    }
                    this.component.getInstance().fireEvent(this.component.getRef(), highLevelGesture2.toString(), map);
                }
            } else if (this.panDownTime != motionEvent.getEventTime()) {
                this.panDownTime = motionEvent.getEventTime();
                this.mPendingPan = WXGestureType.HighLevelGesture.PAN_END;
                this.component.fireEvent(WXGestureType.HighLevelGesture.PAN_START.toString(), createFireEventParam(motionEvent, -1, null));
            } else {
                this.component.fireEvent(WXGestureType.HighLevelGesture.PAN_MOVE.toString(), createFireEventParam(motionEvent2, -1, null));
            }
            z = true;
        }
        if (this.mIsTouchEventConsumed || z) {
            z2 = true;
        }
        this.mIsTouchEventConsumed = z2;
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098 A[Catch:{ Exception -> 0x00db }] */
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean handleMotionEvent;
        ViewParent parent;
        if (this.requestDisallowInterceptTouchEvent) {
            this.requestDisallowInterceptTouchEvent = false;
            return false;
        }
        try {
            boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
            List<View.OnTouchListener> list = this.mTouchListeners;
            if (list != null && !list.isEmpty()) {
                for (View.OnTouchListener onTouchListener : this.mTouchListeners) {
                    onTouchEvent |= onTouchListener.onTouch(view, motionEvent);
                }
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        handleMotionEvent = handleMotionEvent(WXGestureType.LowLevelGesture.ACTION_MOVE, motionEvent);
                    } else if (actionMasked == 3) {
                        finishDisallowInterceptTouchEvent(view);
                        onTouchEvent |= handleMotionEvent(WXGestureType.LowLevelGesture.ACTION_CANCEL, motionEvent);
                        handleMotionEvent = handlePanMotionEvent(motionEvent);
                    } else if (actionMasked != 5) {
                        if (actionMasked != 6) {
                            if (hasStopPropagation(this.component)) {
                                ViewGroup viewGroup = (ViewGroup) view.getParent();
                                if (viewGroup != null) {
                                    z = !shouldBubbleTouchEvent(motionEvent);
                                    viewGroup.requestDisallowInterceptTouchEvent(z);
                                } else {
                                    z = false;
                                }
                                if (this.component.getParent() != null) {
                                    this.component.getParent().requestDisallowInterceptTouchEvent(z);
                                }
                                if (this.mIsTouchEventConsumed && WXUtils.getBoolean(this.component.getAttrs().get("cancelTouchOnConsume"), Boolean.FALSE).booleanValue()) {
                                    motionEvent.setAction(3);
                                }
                            }
                            return onTouchEvent;
                        }
                    }
                    onTouchEvent |= handleMotionEvent;
                    if (hasStopPropagation(this.component)) {
                    }
                    return onTouchEvent;
                }
                finishDisallowInterceptTouchEvent(view);
                onTouchEvent |= handleMotionEvent(WXGestureType.LowLevelGesture.ACTION_UP, motionEvent);
                handleMotionEvent = handlePanMotionEvent(motionEvent);
                onTouchEvent |= handleMotionEvent;
                if (hasStopPropagation(this.component)) {
                }
                return onTouchEvent;
            }
            this.mIsTouchEventConsumed = false;
            if (hasSameOrientationWithParent() && !isParentScrollable() && (parent = this.component.getRealView().getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            handleMotionEvent = handleMotionEvent(WXGestureType.LowLevelGesture.ACTION_DOWN, motionEvent);
            onTouchEvent |= handleMotionEvent;
            if (hasStopPropagation(this.component)) {
            }
            return onTouchEvent;
        } catch (Exception e) {
            WXLogUtils.e("Gesture RunTime Error ", e);
            return false;
        }
    }

    public boolean removeTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            return this.mTouchListeners.remove(onTouchListener);
        }
        return false;
    }

    public void setPreventMoveEvent(boolean z) {
        this.mIsPreventMoveEvent = z;
    }

    public void setRequestDisallowInterceptTouchEvent(boolean z) {
        this.requestDisallowInterceptTouchEvent = z;
    }

    private PointF getEventLocInPageCoordinate(MotionEvent motionEvent, int i, int i2) {
        float f;
        float f2;
        if (i2 == -1) {
            f = motionEvent.getX(i);
            f2 = motionEvent.getY(i);
        } else {
            float historicalX = motionEvent.getHistoricalX(i, i2);
            f2 = motionEvent.getHistoricalY(i, i2);
            f = historicalX;
        }
        return getEventLocInPageCoordinate(f, f2);
    }

    private PointF getEventLocInScreenCoordinate(MotionEvent motionEvent, int i, int i2) {
        float f;
        float f2;
        if (i2 == -1) {
            f = motionEvent.getX(i);
            f2 = motionEvent.getY(i);
        } else {
            float historicalX = motionEvent.getHistoricalX(i, i2);
            f2 = motionEvent.getHistoricalY(i, i2);
            f = historicalX;
        }
        return getEventLocInScreenCoordinate(f, f2);
    }

    @NonNull
    private PointF getEventLocInPageCoordinate(float f, float f2) {
        this.locEventOffset.set(f, f2);
        this.locLeftTop.set(0.0f, 0.0f);
        this.component.computeVisiblePointInViewCoordinate(this.locLeftTop);
        PointF pointF = this.locEventOffset;
        PointF pointF2 = this.locLeftTop;
        pointF.offset(pointF2.x, pointF2.y);
        return new PointF(WXViewUtils.getWebPxByWidth(this.locEventOffset.x, this.component.getInstance().getInstanceViewPortWidth()), WXViewUtils.getWebPxByWidth(this.locEventOffset.y, this.component.getInstance().getInstanceViewPortWidth()));
    }

    @NonNull
    private PointF getEventLocInScreenCoordinate(float f, float f2) {
        this.globalRect.set(0, 0, 0, 0);
        this.globalOffset.set(0, 0);
        this.globalEventOffset.set((int) f, (int) f2);
        this.component.getRealView().getGlobalVisibleRect(this.globalRect, this.globalOffset);
        Point point = this.globalEventOffset;
        Point point2 = this.globalOffset;
        point.offset(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        return new PointF(WXViewUtils.getWebPxByWidth((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.globalEventOffset), this.component.getInstance().getInstanceViewPortWidth()), WXViewUtils.getWebPxByWidth((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.globalEventOffset), this.component.getInstance().getInstanceViewPortWidth()));
    }

    @NonNull
    private JSONObject createJSONObject(PointF pointF, PointF pointF2, float f) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WXGestureType.GestureInfo.PAGE_X, (Object) Float.valueOf(pointF2.x));
        jSONObject.put(WXGestureType.GestureInfo.PAGE_Y, (Object) Float.valueOf(pointF2.y));
        jSONObject.put(WXGestureType.GestureInfo.SCREEN_X, (Object) Float.valueOf(pointF.x));
        jSONObject.put(WXGestureType.GestureInfo.SCREEN_Y, (Object) Float.valueOf(pointF.y));
        jSONObject.put(WXGestureType.GestureInfo.POINTER_ID, (Object) Float.valueOf(f));
        return jSONObject;
    }
}

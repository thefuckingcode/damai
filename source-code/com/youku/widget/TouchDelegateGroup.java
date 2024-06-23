package com.youku.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public class TouchDelegateGroup extends TouchDelegate {
    private static final Rect USELESS_HACKY_RECT = new Rect();
    private TouchDelegate mCurrentTouchDelegate;
    private ArrayList<TouchDelegate> mTouchDelegates;

    public TouchDelegateGroup(View view) {
        super(USELESS_HACKY_RECT, view);
    }

    public void addTouchDelegate(TouchDelegate touchDelegate) {
        if (this.mTouchDelegates == null) {
            this.mTouchDelegates = new ArrayList<>();
        }
        this.mTouchDelegates.add(touchDelegate);
    }

    public void clearTouchDelegates() {
        ArrayList<TouchDelegate> arrayList = this.mTouchDelegates;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mCurrentTouchDelegate = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L_0x0039;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        TouchDelegate touchDelegate = null;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    touchDelegate = this.mCurrentTouchDelegate;
                }
            }
            TouchDelegate touchDelegate2 = this.mCurrentTouchDelegate;
            this.mCurrentTouchDelegate = null;
            touchDelegate = touchDelegate2;
        } else {
            ArrayList<TouchDelegate> arrayList = this.mTouchDelegates;
            if (arrayList != null) {
                Iterator<TouchDelegate> it = arrayList.iterator();
                while (it.hasNext()) {
                    TouchDelegate next = it.next();
                    if (next != null && next.onTouchEvent(motionEvent)) {
                        this.mCurrentTouchDelegate = next;
                        return true;
                    }
                }
            }
        }
        if (touchDelegate == null) {
            return false;
        }
        return touchDelegate.onTouchEvent(motionEvent);
    }

    public void removeTouchDelegate(TouchDelegate touchDelegate) {
        ArrayList<TouchDelegate> arrayList = this.mTouchDelegates;
        if (arrayList != null) {
            arrayList.remove(touchDelegate);
            if (this.mTouchDelegates.isEmpty()) {
                this.mTouchDelegates = null;
            }
        }
    }
}

package com.taobao.android.dinamicx.view.richtext;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.taobao.android.dinamicx.view.richtext.span.CloneableLongClickSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableNoStyleClickSpan;
import tb.s12;

/* compiled from: Taobao */
public class DXNativeRichText extends View {
    private CheckForLongPressList mCheckForLongPressList;
    private boolean mHasPerformedLongPress = false;
    private s12 mRichTextRender;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class CheckForLongPressList implements Runnable {
        private CloneableLongClickSpan[] mLongClickSpans;
        private boolean mOriginalPressedState;
        private int mOriginalWindowAttachCount;

        public void rememberPressedState() {
            this.mOriginalPressedState = DXNativeRichText.this.isPressed();
        }

        public void rememberWindowAttachCount() {
            this.mOriginalWindowAttachCount = DXNativeRichText.this.getWindowAttachCount();
        }

        public void run() {
            if (this.mOriginalPressedState == DXNativeRichText.this.isPressed() && DXNativeRichText.this.getParent() != null && this.mOriginalWindowAttachCount == DXNativeRichText.this.getWindowAttachCount()) {
                boolean z = false;
                for (CloneableLongClickSpan cloneableLongClickSpan : this.mLongClickSpans) {
                    z = z || cloneableLongClickSpan.onLongClick(DXNativeRichText.this);
                }
                DXNativeRichText.this.mHasPerformedLongPress = z;
            }
        }

        private CheckForLongPressList(CloneableLongClickSpan[] cloneableLongClickSpanArr) {
            this.mLongClickSpans = cloneableLongClickSpanArr;
        }
    }

    public DXNativeRichText(Context context) {
        super(context);
    }

    private void checkForLongClicks(long j, CloneableLongClickSpan[] cloneableLongClickSpanArr) {
        this.mHasPerformedLongPress = false;
        CheckForLongPressList checkForLongPressList = new CheckForLongPressList(cloneableLongClickSpanArr);
        this.mCheckForLongPressList = checkForLongPressList;
        checkForLongPressList.rememberPressedState();
        this.mCheckForLongPressList.rememberWindowAttachCount();
        postDelayed(this.mCheckForLongPressList, j);
    }

    private void removeLongPressCallbacks() {
        CheckForLongPressList checkForLongPressList = this.mCheckForLongPressList;
        if (checkForLongPressList != null) {
            removeCallbacks(checkForLongPressList);
        }
    }

    public s12 getRichTextRender() {
        return this.mRichTextRender;
    }

    public boolean handleSpanTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        s12 s12 = this.mRichTextRender;
        if (s12 == null) {
            return false;
        }
        int n = s12.n(motionEvent.getX(), motionEvent.getY());
        CloneableNoStyleClickSpan[] cloneableNoStyleClickSpanArr = (CloneableNoStyleClickSpan[]) this.mRichTextRender.m(n, n, CloneableNoStyleClickSpan.class);
        if (cloneableNoStyleClickSpanArr != null) {
            z = false;
            for (CloneableNoStyleClickSpan cloneableNoStyleClickSpan : cloneableNoStyleClickSpanArr) {
                z = z || cloneableNoStyleClickSpan.getClickDelegate() != null;
            }
        } else {
            z = false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    setPressed(false);
                }
            } else if (this.mHasPerformedLongPress) {
                return true;
            } else {
                removeLongPressCallbacks();
                if (z) {
                    for (CloneableNoStyleClickSpan cloneableNoStyleClickSpan2 : cloneableNoStyleClickSpanArr) {
                        if (cloneableNoStyleClickSpan2.getClickDelegate() != null) {
                            cloneableNoStyleClickSpan2.onClick(this);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        CloneableLongClickSpan[] cloneableLongClickSpanArr = (CloneableLongClickSpan[]) this.mRichTextRender.m(n, n, CloneableLongClickSpan.class);
        if (cloneableLongClickSpanArr == null || cloneableLongClickSpanArr.length == 0) {
            z2 = false;
        } else {
            z2 = false;
            for (CloneableLongClickSpan cloneableLongClickSpan : cloneableLongClickSpanArr) {
                z2 = z2 || cloneableLongClickSpan.getLongClickSpanDelegate() != null;
            }
            if (z2) {
                setPressed(true);
                checkForLongClicks((long) ViewConfiguration.getLongPressTimeout(), cloneableLongClickSpanArr);
            }
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        s12 s12 = this.mRichTextRender;
        if (s12 != null) {
            s12.d(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (handleSpanTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRichTextRender(s12 s12) {
        this.mRichTextRender = s12;
    }

    public DXNativeRichText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DXNativeRichText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public DXNativeRichText(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}

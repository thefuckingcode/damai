package com.alibaba.verificationsdk.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ImageView;
import tb.v81;

/* compiled from: Taobao */
public class BallImageView extends ImageView {
    public static int mScreenHeight;
    public static int mScreenWidth;
    public float currentX = 40.0f;
    public float currentY = 50.0f;
    public float radius = 0.0f;

    public BallImageView(Context context) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        v81.b("TEST", "displayMetrics.widthPixels: " + mScreenWidth + " displayMetrics.heightPixels: " + mScreenHeight);
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
        v81.b("TEST", "getWindowVisibleDisplayFrame.width: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) + " getWindowVisibleDisplayFrame.height: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
        if (r0 != 3) goto L_0x0092;
     */
    public boolean autoMouse(MotionEvent motionEvent) {
        this.radius = (float) getHeight();
        v81.b("TEST", "x: " + motionEvent.getX() + " y: " + motionEvent.getY());
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                if (motionEvent.getX() <= 0.0f || motionEvent.getX() >= ((float) (mScreenWidth - getWidth())) || motionEvent.getY() <= 0.0f || motionEvent.getY() >= ((float) (mScreenHeight - (getHeight() * 2)))) {
                    return true;
                }
                setLocation((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            }
        }
        float f = this.radius;
        this.currentX = f;
        float f2 = ((float) mScreenHeight) - (2.0f * f);
        this.currentY = f2;
        setLocation((int) f, (int) f2);
        return false;
    }

    public void setLocation(int i, int i2) {
        setFrame(i, i2 - (getHeight() / 2), getWidth() + i, i2 + (getHeight() / 2));
    }
}

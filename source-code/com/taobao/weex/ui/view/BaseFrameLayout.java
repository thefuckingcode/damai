package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.taobao.weex.ui.flat.widget.Widget;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.List;

/* compiled from: Taobao */
public class BaseFrameLayout extends FrameLayout {
    private List<Widget> mWidgets;

    public BaseFrameLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchDrawInterval(canvas);
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDrawInterval(Canvas canvas) {
        if (this.mWidgets != null) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            for (Widget widget : this.mWidgets) {
                widget.draw(canvas);
            }
            canvas.restore();
            return;
        }
        WXViewUtils.clipCanvasWithinBorderBox(this, canvas);
        super.dispatchDraw(canvas);
    }

    public void mountFlatGUI(List<Widget> list) {
        this.mWidgets = list;
        if (list != null) {
            setWillNotDraw(true);
        }
        invalidate();
    }

    public void unmountFlatGUI() {
        this.mWidgets = null;
        setWillNotDraw(false);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return this.mWidgets != null || super.verifyDrawable(drawable);
    }
}

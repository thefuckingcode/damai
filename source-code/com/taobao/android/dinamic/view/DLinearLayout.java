package com.taobao.android.dinamic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;
import tb.h80;
import tb.o70;
import tb.sp;

/* compiled from: Taobao */
public class DLinearLayout extends LinearLayout {
    public DLinearLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        h80.a(this, canvas);
        super.dispatchDraw(canvas);
    }

    public void draw(Canvas canvas) {
        h80.a(this, canvas);
        super.draw(canvas);
    }

    public DLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LinearLayout.LayoutParams layoutParams;
        Map<String, Object> map = b.d(o70.D_LINEAR_LAYOUT).handleAttributeSet(attributeSet).b;
        int[] b = sp.b(getContext(), map);
        if (map.containsKey(DAttrConstant.LL_WEIGHT)) {
            try {
                float parseFloat = Float.parseFloat((String) map.get(DAttrConstant.LL_WEIGHT));
                if (parseFloat <= 0.0f) {
                    parseFloat = 0.0f;
                }
                if (getOrientation() == 0) {
                    layoutParams = new LinearLayout.LayoutParams(0, b[1], parseFloat);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(b[0], 0, parseFloat);
                }
            } catch (NumberFormatException unused) {
                layoutParams = new LinearLayout.LayoutParams(b[0], b[1]);
            }
        } else {
            layoutParams = new LinearLayout.LayoutParams(b[0], b[1]);
        }
        layoutParams.setMargins(b[2], b[3], b[4], b[5]);
        layoutParams.gravity = sp.a(map);
        return layoutParams;
    }

    public DLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

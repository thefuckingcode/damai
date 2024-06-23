package com.taobao.android.dinamic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;
import tb.f80;
import tb.h80;
import tb.o70;
import tb.sp;

/* compiled from: Taobao */
public class DFrameLayout extends FrameLayout {
    public DFrameLayout(Context context) {
        super(context);
    }

    private int calculateSize(String str, String str2, int i) {
        return i;
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

    public DFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Map<String, Object> map = b.d(o70.D_FRAME_LAYOUT).handleAttributeSet(attributeSet).b;
        int a = sp.a(map);
        String str = (String) map.get(DAttrConstant.VIEW_WIDTH);
        String str2 = (String) map.get(DAttrConstant.VIEW_HEIGHT);
        int[] b = sp.b(getContext(), map);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b[0], b[1]);
        layoutParams.gravity = a;
        layoutParams.setMargins(b[2], b[3], b[4], b[5]);
        if (a == -1) {
            a = 51;
        }
        if ((a & 3) != 0 && b[0] > 0) {
            String str3 = (String) map.get(DAttrConstant.VIEW_MARGIN_LEFT);
            if (!TextUtils.isEmpty(str3) && !str.toLowerCase().contains(f80.DIMEN_SUFFIX_NP) && !str3.toLowerCase().contains(f80.DIMEN_SUFFIX_NP)) {
                layoutParams.width = calculateSize(str, str3, b[0]);
            }
        }
        if ((a & 5) != 0 && b[0] > 0) {
            String str4 = (String) map.get(DAttrConstant.VIEW_MARGIN_RIGHT);
            if (!TextUtils.isEmpty(str4) && !str.toLowerCase().contains(f80.DIMEN_SUFFIX_NP) && !str4.toLowerCase().contains(f80.DIMEN_SUFFIX_NP)) {
                layoutParams.width = calculateSize(str, str4, b[0]);
            }
        }
        if ((a & 48) != 0 && b[1] > 0) {
            String str5 = (String) map.get(DAttrConstant.VIEW_MARGIN_TOP);
            if (!TextUtils.isEmpty(str5) && !str2.toLowerCase().contains(f80.DIMEN_SUFFIX_NP) && !str5.toLowerCase().contains(f80.DIMEN_SUFFIX_NP)) {
                layoutParams.height = calculateSize(str2, str5, b[1]);
            }
        }
        if ((a & 80) != 0 && b[1] > 0) {
            String str6 = (String) map.get(DAttrConstant.VIEW_MARGIN_BOTTOM);
            if (!TextUtils.isEmpty(str6) && !str2.toLowerCase().contains(f80.DIMEN_SUFFIX_NP) && !str6.toLowerCase().contains(f80.DIMEN_SUFFIX_NP)) {
                layoutParams.height = calculateSize(str2, str6, b[1]);
            }
        }
        return layoutParams;
    }

    public DFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

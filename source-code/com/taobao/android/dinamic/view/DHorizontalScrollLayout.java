package com.taobao.android.dinamic.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;
import tb.g80;
import tb.o70;
import tb.x70;

/* compiled from: Taobao */
public class DHorizontalScrollLayout extends DFrameLayout {
    String SL_LAYOUT_TYPE_FRAME = TypedValues.Attributes.S_FRAME;
    String SL_LAYOUT_TYPE_LINEAR = "linear";
    String SL_SCROLLBAR_INVISIBLE = DAttrConstant.VISIBILITY_INVISIBLE;
    String SL_SCROLLBAR_VISIBLE = "visible";
    ViewGroup containerView;
    FrameLayout scrollView;

    public DHorizontalScrollLayout(Context context) {
        super(context);
    }

    private void generateChildView(AttributeSet attributeSet, x70 x70) {
        Map<String, Object> map = b.d(o70.D_HORIZONTAL_SCROLL_LAYOUT).handleAttributeSet(attributeSet).b;
        String str = (String) map.get(DAttrConstant.SL_LAYOUT_TYPE);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        this.scrollView = horizontalScrollView;
        horizontalScrollView.setOverScrollMode(2);
        this.scrollView.setVerticalScrollBarEnabled(false);
        if (!TextUtils.equals((String) map.get(DAttrConstant.SL_SCOLLBAR), this.SL_SCROLLBAR_VISIBLE)) {
            this.scrollView.setHorizontalScrollBarEnabled(false);
        }
        if (TextUtils.equals(str, this.SL_LAYOUT_TYPE_FRAME)) {
            DFrameLayout dFrameLayout = (DFrameLayout) g80.b(o70.D_FRAME_LAYOUT, getContext(), attributeSet, x70);
            this.containerView = dFrameLayout;
            this.scrollView.addView(dFrameLayout);
        } else {
            DLinearLayout dLinearLayout = (DLinearLayout) g80.b(o70.D_LINEAR_LAYOUT, getContext(), attributeSet, x70);
            this.containerView = dLinearLayout;
            this.scrollView.addView(dLinearLayout);
        }
        super.addView(this.scrollView, -1, generateLayoutParams(attributeSet));
        map.remove(DAttrConstant.SL_LAYOUT_TYPE);
        map.remove(DAttrConstant.SL_SCOLLBAR);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null) {
            viewGroup.addView(view, i, layoutParams);
        }
    }

    public DHorizontalScrollLayout(Context context, AttributeSet attributeSet, x70 x70) {
        super(context, attributeSet);
        generateChildView(attributeSet, x70);
    }
}

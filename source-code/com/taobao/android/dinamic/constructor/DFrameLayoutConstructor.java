package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamic.view.DFrameLayout;
import java.util.ArrayList;
import java.util.Map;
import tb.c80;
import tb.q42;
import tb.x70;

/* compiled from: Taobao */
public class DFrameLayoutConstructor extends DinamicViewAdvancedConstructor {
    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new DFrameLayout(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
        if (arrayList.contains(DAttrConstant.VIEW_CLIP_TOP_LEFT_RADIUS) || arrayList.contains(DAttrConstant.VIEW_CLIP_TOP_RIGHT_RADIUS) || arrayList.contains(DAttrConstant.VIEW_CLIP_BOTTOM_LEFT_RADIUS) || arrayList.contains(DAttrConstant.VIEW_CLIP_BOTTOM_RIGHT_RADIUS)) {
            int b = q42.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_TOP_LEFT_RADIUS), 0);
            int b2 = q42.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_TOP_RIGHT_RADIUS), 0);
            int b3 = q42.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_BOTTOM_LEFT_RADIUS), 0);
            float f = (float) b;
            float f2 = (float) b2;
            float b4 = (float) q42.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_BOTTOM_RIGHT_RADIUS), 0);
            float f3 = (float) b3;
            view.setTag(c80.LAYOUT_RADII, new float[]{f, f, f2, f2, b4, b4, f3, f3});
        }
    }
}

package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamic.view.DLoopLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.c80;
import tb.x70;

/* compiled from: Taobao */
public class DLoopLinearLayoutConstructor extends DinamicViewAdvancedConstructor {
    public static final String TAG = "DLoopLinearLayoutConstructor";

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, x70 x70) {
        super.applyDefaultProperty(view, map, x70);
        DLoopLinearLayout dLoopLinearLayout = (DLoopLinearLayout) view;
        dLoopLinearLayout.setBaselineAligned(false);
        if (!map.containsKey(DAttrConstant.LL_ORIENTATION)) {
            dLoopLinearLayout.setOrientation(1);
        }
        dLoopLinearLayout.setTag(c80.TAG_DINAMIC_BIND_DATA_LIST, x70.e().a());
    }

    public void bindListData(DLoopLinearLayout dLoopLinearLayout, x70 x70, List list) {
        dLoopLinearLayout.bindListData(x70, list);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new DLoopLinearLayout(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
        DLoopLinearLayout dLoopLinearLayout = (DLoopLinearLayout) view;
        if (arrayList.contains(DAttrConstant.LL_ORIENTATION)) {
            setOrientation(dLoopLinearLayout, (String) map.get(DAttrConstant.LL_ORIENTATION));
        }
        if (arrayList.contains(DAttrConstant.VIEW_LIST_DATA)) {
            bindListData(dLoopLinearLayout, x70, (List) map.get(DAttrConstant.VIEW_LIST_DATA));
        }
    }

    public void setOrientation(DLoopLinearLayout dLoopLinearLayout, String str) {
        if (!TextUtils.isEmpty(str)) {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue == 0) {
                dLoopLinearLayout.setOrientation(1);
            } else if (intValue == 1) {
                dLoopLinearLayout.setOrientation(0);
            }
        } else {
            dLoopLinearLayout.setOrientation(0);
        }
    }
}

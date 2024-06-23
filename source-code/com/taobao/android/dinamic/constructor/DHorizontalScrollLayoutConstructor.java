package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.view.DHorizontalScrollLayout;
import java.util.ArrayList;
import java.util.Map;
import tb.x70;

/* compiled from: Taobao */
public class DHorizontalScrollLayoutConstructor extends DinamicViewAdvancedConstructor {
    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeViewWithModule(String str, Context context, AttributeSet attributeSet, x70 x70) {
        return new DHorizontalScrollLayout(context, attributeSet, x70);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
    }
}

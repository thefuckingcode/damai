package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.youku.resource.R;

/* compiled from: Taobao */
public class YKCheckBox extends AppCompatCheckBox implements YKCustomizedView {
    public YKCheckBox(Context context) {
        super(context);
        init(context, null);
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        setButtonDrawable(R.drawable.checkbox_style);
    }

    public YKCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}

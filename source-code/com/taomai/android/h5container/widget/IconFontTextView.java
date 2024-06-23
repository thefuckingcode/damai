package com.taomai.android.h5container.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.taomai.android.h5container.R$styleable;
import tb.lz0;

/* compiled from: Taobao */
public class IconFontTextView extends AppCompatTextView {
    private static final String TAG = "IconFontTextView";
    private Context context;
    private String iconFontAssetTypeface;

    public IconFontTextView(Context context2) {
        super(context2);
        init(context2);
    }

    private void init(Context context2) {
        this.context = context2;
        setTypeface(lz0.a(context2, this.iconFontAssetTypeface));
    }

    private void initAttrs(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.IconFont, i, 0);
        this.iconFontAssetTypeface = obtainStyledAttributes.getString(R$styleable.IconFont_iconFont_assetTypeface);
        obtainStyledAttributes.recycle();
    }

    public IconFontTextView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        initAttrs(attributeSet, 0);
        init(context2);
    }

    public IconFontTextView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        initAttrs(attributeSet, i);
        init(context2);
    }
}

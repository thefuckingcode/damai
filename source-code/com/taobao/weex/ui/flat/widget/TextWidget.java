package com.taobao.weex.ui.flat.widget;

import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.view.border.BorderDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public class TextWidget extends BaseWidget {
    private Layout mLayout;

    public TextWidget(@NonNull FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(@NonNull Canvas canvas) {
        Layout layout = this.mLayout;
        if (layout != null) {
            layout.draw(canvas);
        }
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget, com.taobao.weex.ui.flat.widget.BaseWidget
    public /* bridge */ /* synthetic */ void setBackgroundAndBorder(@NonNull BorderDrawable borderDrawable) {
        super.setBackgroundAndBorder(borderDrawable);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget, com.taobao.weex.ui.flat.widget.BaseWidget
    public /* bridge */ /* synthetic */ void setContentBox(int i, int i2, int i3, int i4) {
        super.setContentBox(i, i2, i3, i4);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget, com.taobao.weex.ui.flat.widget.BaseWidget
    public /* bridge */ /* synthetic */ void setLayout(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        super.setLayout(i, i2, i3, i4, i5, i6, point);
    }

    public void updateTextDrawable(Layout layout) {
        this.mLayout = layout;
        invalidate();
    }
}

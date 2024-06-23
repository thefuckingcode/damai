package android.taobao.windvane.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
public abstract class AbstractNaviBar extends RelativeLayout {
    public static final int NAVI_BAR_ID = 110;

    public AbstractNaviBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void resetState();

    public abstract void startLoading();

    public abstract void stopLoading();

    public AbstractNaviBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractNaviBar(Context context) {
        super(context);
    }
}

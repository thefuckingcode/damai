package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
public class a extends RelativeLayout {
    private static final String a = a.class.getName();
    private Rect b;
    private boolean c;
    private AbstractC0239a d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0239a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new Rect();
    }

    public void a(AbstractC0239a aVar) {
        this.d = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        AbstractC0239a aVar = this.d;
        if (!(aVar == null || size == 0)) {
            if (height > 100) {
                aVar.a((Math.abs(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.b)) - getPaddingBottom()) - getPaddingTop());
            } else {
                aVar.a();
            }
        }
        super.onMeasure(i, i2);
    }
}

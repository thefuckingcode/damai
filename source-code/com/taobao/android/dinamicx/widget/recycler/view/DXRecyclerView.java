package com.taobao.android.dinamicx.widget.recycler.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.recycler.expose.b;
import java.util.ArrayList;
import java.util.Iterator;
import tb.ry;
import tb.vx;

/* compiled from: Taobao */
public class DXRecyclerView extends RecyclerView {
    b exposeHelper;
    ArrayList<RecyclerView.OnScrollListener> mExtraScrollerListeners;

    public DXRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        super.addOnScrollListener(onScrollListener);
        if (this.mExtraScrollerListeners == null) {
            this.mExtraScrollerListeners = new ArrayList<>();
        }
        this.mExtraScrollerListeners.add(onScrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void clearOnScrollListeners() {
        super.clearOnScrollListeners();
        ArrayList<RecyclerView.OnScrollListener> arrayList = this.mExtraScrollerListeners;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public b getExposeHelper() {
        return this.exposeHelper;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.exposeHelper != null) {
            ry.b("DXRecyclerView", "exposeHelper.attach();");
            this.exposeHelper.b();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.exposeHelper != null) {
            ry.b("DXRecyclerView", "exposeHelper.detach();");
            this.exposeHelper.c();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        DXRecyclerLayout j;
        try {
            super.onLayout(z, i, i2, i3, i4);
            b bVar = this.exposeHelper;
            if (bVar != null) {
                bVar.d();
            }
        } catch (Throwable unused) {
            vx.b(th);
        }
    }

    public void onScrollStateChangedExtra(int i) {
        ArrayList<RecyclerView.OnScrollListener> arrayList = this.mExtraScrollerListeners;
        if (arrayList != null) {
            Iterator<RecyclerView.OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScrollStateChanged(this, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        super.removeOnScrollListener(onScrollListener);
        ArrayList<RecyclerView.OnScrollListener> arrayList = this.mExtraScrollerListeners;
        if (arrayList != null) {
            arrayList.remove(onScrollListener);
        }
    }

    public void setExposeHelper(b bVar) {
        this.exposeHelper = bVar;
    }

    public DXRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DXRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

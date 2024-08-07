package com.taobao.android.dinamicx.videoc.expose.impl;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZone;
import tb.o1;

/* compiled from: Taobao */
public class RecyclerViewZone<ExposeKey, ExposeData> extends o1<ExposeKey, ExposeData> {
    private final RecyclerView c;
    private final RecyclerView.OnScrollListener d;
    private final RecyclerView.OnChildAttachStateChangeListener e;
    private final IExposure<ExposeKey, ExposeData> f;
    private boolean g;

    /* compiled from: Taobao */
    public interface OnRecyclerViewExposeCallback<ExposeKey, ExposeData> {
        void onChildAttachExpose(IExposure<ExposeKey, ExposeData> iExposure, String str, RecyclerView recyclerView, View view);

        void onChildDetachExpose(IExposure<ExposeKey, ExposeData> iExposure, String str, RecyclerView recyclerView, View view);

        void onScrollExpose(IExposure<ExposeKey, ExposeData> iExposure, String str, RecyclerView recyclerView, int i, int i2);

        void onScrollStateChangeExpose(IExposure<ExposeKey, ExposeData> iExposure, String str, RecyclerView recyclerView, int i);
    }

    /* compiled from: Taobao */
    public static class RecyclerViewZoneChildStateListener<ExposeKey, ExposeData> implements RecyclerView.OnChildAttachStateChangeListener {
        private final RecyclerView a;
        private final OnRecyclerViewExposeCallback<ExposeKey, ExposeData> b;
        private final IExposure<ExposeKey, ExposeData> c;
        private final String d;

        public RecyclerViewZoneChildStateListener(RecyclerView recyclerView, OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback, IExposure<ExposeKey, ExposeData> iExposure, String str) {
            this.a = recyclerView;
            this.b = onRecyclerViewExposeCallback;
            this.c = iExposure;
            this.d = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback = this.b;
            if (onRecyclerViewExposeCallback != null) {
                onRecyclerViewExposeCallback.onChildAttachExpose(this.c, this.d, this.a, view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback = this.b;
            if (onRecyclerViewExposeCallback != null) {
                onRecyclerViewExposeCallback.onChildDetachExpose(this.c, this.d, this.a, view);
            }
        }
    }

    /* compiled from: Taobao */
    public static class RecyclerViewZoneScrollListener<ExposeKey, ExposeData> extends RecyclerView.OnScrollListener {
        private final OnRecyclerViewExposeCallback<ExposeKey, ExposeData> a;
        private final IExposure<ExposeKey, ExposeData> b;
        private final String c;

        public RecyclerViewZoneScrollListener(OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback, IExposure<ExposeKey, ExposeData> iExposure, String str) {
            this.a = onRecyclerViewExposeCallback;
            this.b = iExposure;
            this.c = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback = this.a;
            if (onRecyclerViewExposeCallback != null) {
                onRecyclerViewExposeCallback.onScrollStateChangeExpose(this.b, this.c, recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback = this.a;
            if (onRecyclerViewExposeCallback != null) {
                onRecyclerViewExposeCallback.onScrollExpose(this.b, this.c, recyclerView, i, i2);
            }
        }
    }

    /* compiled from: Taobao */
    public static class a<ExposeKey, ExposeData> implements IExposureZone.Builder<ExposeKey, ExposeData> {
        private final RecyclerView a;
        private OnRecyclerViewExposeCallback<ExposeKey, ExposeData> b;

        public a(@NonNull RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        /* renamed from: a */
        public RecyclerViewZone<ExposeKey, ExposeData> build(@NonNull IExposure<ExposeKey, ExposeData> iExposure) {
            return new RecyclerViewZone<>(this.a, this.b, iExposure);
        }

        /* renamed from: b */
        public RecyclerViewZone<ExposeKey, ExposeData> build(@NonNull IExposure<ExposeKey, ExposeData> iExposure, @NonNull String str) {
            return new RecyclerViewZone<>(this.a, this.b, iExposure, str);
        }

        public a<ExposeKey, ExposeData> c(OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback) {
            this.b = onRecyclerViewExposeCallback;
            return this;
        }
    }

    public RecyclerViewZone(RecyclerView recyclerView, OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback, IExposure<ExposeKey, ExposeData> iExposure) {
        this(recyclerView, onRecyclerViewExposeCallback, iExposure, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone, tb.o1
    public void attach() {
        if (!isAttached()) {
            super.attach();
            this.c.addOnScrollListener(this.d);
            this.c.addOnChildAttachStateChangeListener(this.e);
            this.g = true;
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone, tb.o1
    public void detach() {
        if (isAttached()) {
            super.detach();
            this.c.removeOnScrollListener(this.d);
            this.c.removeOnChildAttachStateChangeListener(this.e);
            this.g = false;
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone
    @NonNull
    public IExposure<ExposeKey, ExposeData> exposure() {
        return this.f;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone
    public boolean isAttached() {
        return this.g;
    }

    public RecyclerViewZone(RecyclerView recyclerView, OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback, IExposure<ExposeKey, ExposeData> iExposure, String str) {
        super(str);
        this.g = false;
        this.c = recyclerView;
        this.f = iExposure;
        this.d = new RecyclerViewZoneScrollListener(onRecyclerViewExposeCallback, iExposure, str);
        this.e = new RecyclerViewZoneChildStateListener(recyclerView, onRecyclerViewExposeCallback, iExposure, str);
    }
}

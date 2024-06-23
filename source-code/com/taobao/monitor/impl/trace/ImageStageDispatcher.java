package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
public class ImageStageDispatcher extends AbsDispatcher<IImageStageListener> {

    /* compiled from: Taobao */
    public interface IImageStageListener {
        void onImageStage(int i);
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<IImageStageListener> {
        final /* synthetic */ int a;

        a(ImageStageDispatcher imageStageDispatcher, int i) {
            this.a = i;
        }

        /* renamed from: a */
        public void callListener(IImageStageListener iImageStageListener) {
            iImageStageListener.onImageStage(this.a);
        }
    }

    public void f(int i) {
        c(new a(this, i));
    }
}

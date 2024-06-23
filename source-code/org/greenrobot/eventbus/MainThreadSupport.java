package org.greenrobot.eventbus;

import android.os.Looper;

public interface MainThreadSupport {
    Poster createPoster(EventBus eventBus);

    boolean isMainThread();

    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {
        private final Looper looper;

        public AndroidHandlerMainThreadSupport(Looper looper2) {
            this.looper = looper2;
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public boolean isMainThread() {
            return this.looper == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public Poster createPoster(EventBus eventBus) {
            return new HandlerPoster(eventBus, this.looper, 10);
        }
    }
}

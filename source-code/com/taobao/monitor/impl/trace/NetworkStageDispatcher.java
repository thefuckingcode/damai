package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
public class NetworkStageDispatcher extends AbsDispatcher<INetworkStageListener> {

    /* compiled from: Taobao */
    public interface INetworkStageListener {
        void onNetworkStage(int i);
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<INetworkStageListener> {
        final /* synthetic */ int a;

        a(NetworkStageDispatcher networkStageDispatcher, int i) {
            this.a = i;
        }

        /* renamed from: a */
        public void callListener(INetworkStageListener iNetworkStageListener) {
            iNetworkStageListener.onNetworkStage(this.a);
        }
    }

    public void f(int i) {
        c(new a(this, i));
    }
}

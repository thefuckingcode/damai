package android.taobao.windvane.service;

/* compiled from: Taobao */
public abstract class WVCoreEventFilter implements WVEventListener {
    /* access modifiers changed from: protected */
    public void onCoreSwitch() {
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        WVEventResult wVEventResult = new WVEventResult(false);
        if (i == 3016) {
            onUCCorePrepared();
        } else if (i == 3017) {
            onCoreSwitch();
        }
        return wVEventResult;
    }

    /* access modifiers changed from: protected */
    public void onUCCorePrepared() {
    }
}

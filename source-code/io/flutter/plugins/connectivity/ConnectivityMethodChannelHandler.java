package io.flutter.plugins.connectivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ConnectivityMethodChannelHandler implements MethodChannel.MethodCallHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Connectivity connectivity;

    ConnectivityMethodChannelHandler(Connectivity connectivity2) {
        this.connectivity = connectivity2;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("check")) {
            result.notImplemented();
        } else {
            result.success(this.connectivity.getNetworkType());
        }
    }
}

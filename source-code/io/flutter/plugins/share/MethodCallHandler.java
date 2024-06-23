package io.flutter.plugins.share;

import com.youku.passport.family.Relation;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class MethodCallHandler implements MethodChannel.MethodCallHandler {
    private Share share;

    MethodCallHandler(Share share2) {
        this.share = share2;
    }

    private void expectMapArguments(MethodCall methodCall) throws IllegalArgumentException {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map argument expected");
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("shareFiles")) {
            expectMapArguments(methodCall);
            try {
                this.share.shareFiles((List) methodCall.argument("paths"), (List) methodCall.argument("mimeTypes"), (String) methodCall.argument("text"), (String) methodCall.argument(Relation.RelationType.SUBJECT));
                result.success(null);
            } catch (IOException e) {
                result.error(e.getMessage(), null, null);
            }
        } else if (!str.equals("share")) {
            result.notImplemented();
        } else {
            expectMapArguments(methodCall);
            this.share.share((String) methodCall.argument("text"), (String) methodCall.argument(Relation.RelationType.SUBJECT));
            result.success(null);
        }
    }
}

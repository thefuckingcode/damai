package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.util.Trace;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import tb.o70;

/* compiled from: Taobao */
public class MethodChannel {
    private static final String TAG = "MethodChannel#";
    private final MethodCodec codec;
    private final BinaryMessenger messenger;
    private final String name;

    /* compiled from: Taobao */
    private final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        IncomingMethodCallHandler(MethodCallHandler methodCallHandler) {
            this.handler = methodCallHandler;
        }

        private String getStackTrace(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        @UiThread
        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.decodeMethodCall(byteBuffer), new Result() {
                    /* class io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler.AnonymousClass1 */

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void error(String str, String str2, Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void notImplemented() {
                        binaryReply.reply(null);
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void success(Object obj) {
                        binaryReply.reply(MethodChannel.this.encodeSuccessEnvelope(obj));
                    }
                });
            } catch (RuntimeException e) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call", e);
                binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelopeWithStacktrace("error", e.getMessage(), null, getStackTrace(e)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        IncomingResultHandler(Result result) {
            this.callback = result;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        @UiThread
        public void reply(ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                try {
                    this.callback.notImplemented();
                } catch (RuntimeException e) {
                    Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call result", e);
                }
            } else {
                try {
                    this.callback.success(MethodChannel.this.decodeEnvelope(byteBuffer));
                } catch (FlutterException e2) {
                    this.callback.error(e2.code, e2.getMessage(), e2.details);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public interface MethodCallHandler {
        @UiThread
        void onMethodCall(@NonNull MethodCall methodCall, @NonNull Result result);
    }

    /* compiled from: Taobao */
    public interface Result {
        @UiThread
        void error(String str, @Nullable String str2, @Nullable Object obj);

        @UiThread
        void notImplemented();

        @UiThread
        void success(@Nullable Object obj);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Object decodeEnvelope(ByteBuffer byteBuffer) {
        Trace.beginSection("decodeEnvelope @" + this.name);
        Object decodeEnvelope = this.codec.decodeEnvelope(byteBuffer);
        Trace.endSection();
        return decodeEnvelope;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MethodCall decodeMethodCall(ByteBuffer byteBuffer) {
        Trace.beginSection("decodeMethodCall @" + this.name);
        MethodCall decodeMethodCall = this.codec.decodeMethodCall(byteBuffer);
        Trace.endSection();
        return decodeMethodCall;
    }

    private ByteBuffer encodeMethodCall(MethodCall methodCall) {
        Trace.beginSection("encodeMethodCall " + methodCall.method + o70.DINAMIC_PREFIX_AT + this.name);
        ByteBuffer encodeMethodCall = this.codec.encodeMethodCall(methodCall);
        Trace.endSection();
        return encodeMethodCall;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ByteBuffer encodeSuccessEnvelope(Object obj) {
        Trace.beginSection("encodeSuccessEnvelope @" + this.name);
        ByteBuffer encodeSuccessEnvelope = this.codec.encodeSuccessEnvelope(obj);
        Trace.endSection();
        return encodeSuccessEnvelope;
    }

    @UiThread
    public void invokeMethod(@NonNull String str, @Nullable Object obj) {
        invokeMethod(str, obj, null);
    }

    public void resizeChannelBuffer(int i) {
        BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, i);
    }

    @UiThread
    public void setMethodCallHandler(@Nullable MethodCallHandler methodCallHandler) {
        this.messenger.setMessageHandler(this.name, methodCallHandler == null ? null : new IncomingMethodCallHandler(methodCallHandler));
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
    }

    @UiThread
    public void invokeMethod(String str, @Nullable Object obj, @Nullable Result result) {
        this.messenger.send(this.name, encodeMethodCall(new MethodCall(str, obj)), result == null ? null : new IncomingResultHandler(result));
    }
}

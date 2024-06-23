package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.common.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    /* compiled from: Taobao */
    public static class PlatformViewBufferSize {
        public final int height;
        public final int width;

        public PlatformViewBufferSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    /* compiled from: Taobao */
    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalLeft;
        public final double logicalTop;
        public final double logicalWidth;
        @Nullable
        public final ByteBuffer params;
        public final PlatformViewRenderType renderType;
        public final int viewId;
        @NonNull
        public final String viewType;

        public PlatformViewCreationRequest(int i, @NonNull String str, double d, double d2, double d3, double d4, int i2, @Nullable ByteBuffer byteBuffer, PlatformViewRenderType platformViewRenderType) {
            this.viewId = i;
            this.viewType = str;
            this.logicalTop = d;
            this.logicalLeft = d2;
            this.logicalWidth = d3;
            this.logicalHeight = d4;
            this.direction = i2;
            this.params = byteBuffer;
            this.renderType = platformViewRenderType;
        }
    }

    /* compiled from: Taobao */
    public enum PlatformViewRenderType {
        penetratedDisplay,
        virturlDisplayPresentation,
        hybridComposition
    }

    /* compiled from: Taobao */
    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i, double d, double d2) {
            this.viewId = i;
            this.newLogicalWidth = d;
            this.newLogicalHeight = d2;
        }
    }

    /* compiled from: Taobao */
    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        @NonNull
        public final Number downTime;
        public final int edgeFlags;
        @NonNull
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        @NonNull
        public final Object rawPointerCoords;
        @NonNull
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i, @NonNull Number number, @NonNull Number number2, int i2, int i3, @NonNull Object obj, @NonNull Object obj2, int i4, int i5, float f, float f2, int i6, int i7, int i8, int i9, long j) {
            this.viewId = i;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i2;
            this.pointerCount = i3;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i4;
            this.buttonState = i5;
            this.xPrecision = f;
            this.yPrecision = f2;
            this.deviceId = i6;
            this.edgeFlags = i7;
            this.source = i8;
            this.flags = i9;
            this.motionEventId = j;
        }
    }

    /* compiled from: Taobao */
    public interface PlatformViewsHandler {
        void clearFocus(int i);

        void createForPlatformViewLayer(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        long createForTextureLayer(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i);

        void offset(int i, double d, double d2);

        void onTouch(@NonNull PlatformViewTouch platformViewTouch);

        PlatformViewBufferSize resize(@NonNull PlatformViewResizeRequest platformViewResizeRequest);

        void setDirection(int i, int i2);

        void synchronizeToNativeViewHierarchy(boolean z);
    }

    public PlatformViewsChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            /* class io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.AnonymousClass1 */

            private void clearFocus(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                    result.success(null);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0061 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v3 */
            /* JADX WARN: Type inference failed for: r5v6 */
            /* JADX WARN: Type inference failed for: r5v9 */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v14 */
            /* JADX WARNING: Unknown variable types count: 1 */
            private void create(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Object obj;
                IllegalStateException e;
                Map map = (Map) methodCall.arguments();
                PlatformViewRenderType platformViewRenderType = PlatformViewRenderType.penetratedDisplay;
                if (map.get("renderType") != null) {
                    platformViewRenderType = PlatformViewRenderType.values()[((Integer) map.get("renderType")).intValue()];
                }
                ?? r5 = (!map.containsKey("hybrid") || !((Boolean) map.get("hybrid")).booleanValue()) ? 0 : 1;
                ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
                if (r5 != 0) {
                    try {
                        r5 = 0;
                        try {
                            PlatformViewsChannel.this.handler.createForPlatformViewLayer(new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), wrap, platformViewRenderType));
                            result.success(null);
                        } catch (IllegalStateException e2) {
                            e = e2;
                            obj = r5;
                            result.error("error", PlatformViewsChannel.detailedExceptionString(e), obj);
                        }
                    } catch (IllegalStateException e3) {
                        e = e3;
                        obj = null;
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e), obj);
                    }
                } else {
                    int intValue = ((Integer) map.get("id")).intValue();
                    String str = (String) map.get("viewType");
                    double d = 0.0d;
                    double doubleValue = map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d;
                    if (map.containsKey("left")) {
                        d = ((Double) map.get("left")).doubleValue();
                    }
                    result.success(Long.valueOf(PlatformViewsChannel.this.handler.createForTextureLayer(new PlatformViewCreationRequest(intValue, str, doubleValue, d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), wrap, platformViewRenderType))));
                }
            }

            private void dispose(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get("id")).intValue());
                    result.success(null);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            private void offset(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.offset(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                    result.success(null);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            private void resize(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewBufferSize resize = PlatformViewsChannel.this.handler.resize(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()));
                    if (resize == null) {
                        result.error("error", "Failed to resize the platform view", null);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("width", Double.valueOf((double) resize.width));
                    hashMap.put("height", Double.valueOf((double) resize.height));
                    result.success(hashMap);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            private void setDirection(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                    result.success(null);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            private void synchronizeToNativeViewHierarchy(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                    result.success(null);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            private void touch(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                MethodChannel.Result result2;
                IllegalStateException e;
                List list = (List) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                    result2 = result;
                    try {
                        result2.success(null);
                    } catch (IllegalStateException e2) {
                        e = e2;
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    result2 = result;
                    result2.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                if (PlatformViewsChannel.this.handler != null) {
                    Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
                    String str = methodCall.method;
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1352294148:
                            if (str.equals("create")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1019779949:
                            if (str.equals("offset")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -934437708:
                            if (str.equals(Constants.Name.RESIZE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case -756050293:
                            if (str.equals("clearFocus")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -308988850:
                            if (str.equals("synchronizeToNativeViewHierarchy")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 110550847:
                            if (str.equals("touch")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 576796989:
                            if (str.equals("setDirection")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1671767583:
                            if (str.equals("dispose")) {
                                c = 7;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            create(methodCall, result);
                            return;
                        case 1:
                            offset(methodCall, result);
                            return;
                        case 2:
                            resize(methodCall, result);
                            return;
                        case 3:
                            clearFocus(methodCall, result);
                            return;
                        case 4:
                            synchronizeToNativeViewHierarchy(methodCall, result);
                            return;
                        case 5:
                            touch(methodCall, result);
                            return;
                        case 6:
                            setDirection(methodCall, result);
                            return;
                        case 7:
                            dispose(methodCall, result);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    /* access modifiers changed from: private */
    public static String detailedExceptionString(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void invokeViewFocused(int i) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("viewFocused", Integer.valueOf(i));
        }
    }

    public void setPlatformViewsHandler(@Nullable PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}

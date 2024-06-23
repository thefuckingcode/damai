package com.taobao.weex.devtools.debug;

import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.weex.devtools.common.LogRedirector;
import com.taobao.weex.devtools.common.ReflectionUtil;
import com.taobao.weex.devtools.debug.SocketClient;
import com.taobao.weex.utils.WXLogUtils;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class OkHttpSocketClient extends SocketClient {
    private static final String CLASS_BUFFER = "okio.Buffer";
    private static final String CLASS_BUFFER_SOURCE = "okio.BufferedSource";
    private static final String CLASS_MEDIA_TYPE_NEW = "com.squareup.okhttp.MediaType";
    private static final String CLASS_OKHTTP_CLIENT = "com.squareup.okhttp.OkHttpClient";
    private static final String CLASS_REQUEST = "com.squareup.okhttp.Request";
    private static final String CLASS_REQUEST_BODY = "com.squareup.okhttp.RequestBody";
    private static final String CLASS_REQUEST_BUILDER = "com.squareup.okhttp.Request$Builder";
    private static final String CLASS_RESPONSE = "com.squareup.okhttp.Response";
    private static final String CLASS_RESPONSE_BODY = "com.squareup.okhttp.ResponseBody";
    private static final String CLASS_WEBSOCKET = "com.squareup.okhttp.ws.WebSocket";
    private static final String CLASS_WEBSOCKET_CALL = "com.squareup.okhttp.ws.WebSocketCall";
    private static final String CLASS_WEBSOCKET_LISTENER = "com.squareup.okhttp.ws.WebSocketListener";
    private static final String CLASS_WEBSOCKET_PAYLOADTYPE = "com.squareup.okhttp.ws.WebSocket$PayloadType";
    private static final String TAG = "OkHttpSocketClient";
    private static HashMap<String, Class> sClazzMap = new HashMap<>();
    private Class mBufferClazz = sClazzMap.get(CLASS_BUFFER);
    private Class mBufferedSourceClazz = sClazzMap.get(CLASS_BUFFER_SOURCE);
    private Class mMediaTypeClazz = sClazzMap.get(CLASS_WEBSOCKET_PAYLOADTYPE);
    private Class mMediaTypeNewClazz = sClazzMap.get(CLASS_MEDIA_TYPE_NEW);
    private Class mOkHttpClientClazz = sClazzMap.get(CLASS_OKHTTP_CLIENT);
    private Class mRequestBodyClazz = sClazzMap.get(CLASS_REQUEST_BODY);
    private Class mRequestBuilderClazz = sClazzMap.get(CLASS_REQUEST_BUILDER);
    private Class mRequestClazz = sClazzMap.get(CLASS_REQUEST);
    private Class mResponseBodyClazz = sClazzMap.get(CLASS_RESPONSE_BODY);
    private Class mWebSocketCallClazz = sClazzMap.get(CLASS_WEBSOCKET_CALL);
    private Class mWebSocketClazz = sClazzMap.get(CLASS_WEBSOCKET);
    private Class mWebSocketListenerClazz = sClazzMap.get(CLASS_WEBSOCKET_LISTENER);

    /* compiled from: Taobao */
    class WebSocketInvocationHandler implements InvocationHandler {
        WebSocketInvocationHandler() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            HandlerThread handlerThread;
            boolean z;
            Object obj2;
            if ("onOpen".equals(method.getName())) {
                OkHttpSocketClient okHttpSocketClient = OkHttpSocketClient.this;
                okHttpSocketClient.mWebSocket = okHttpSocketClient.mWebSocketClazz.cast(objArr[0]);
                SocketClient.Callback callback = OkHttpSocketClient.this.mConnectCallback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            } else if ("onFailure".equals(method.getName())) {
                OkHttpSocketClient.this.abort("Websocket onFailure", (IOException) objArr[0]);
            } else if ("onMessage".equals(method.getName())) {
                try {
                    obj2 = OkHttpSocketClient.this.mBufferedSourceClazz.cast(objArr[0]);
                    z = false;
                } catch (Throwable unused) {
                    z = true;
                    obj2 = null;
                }
                if (z) {
                    OkHttpSocketClient.this.mProxy.handleMessage(ReflectionUtil.tryInvokeMethod(OkHttpSocketClient.this.mResponseBodyClazz.cast(objArr[0]), ReflectionUtil.tryGetMethod(OkHttpSocketClient.this.mResponseBodyClazz, "string", new Class[0]), new Object[0]).toString());
                } else {
                    try {
                        OkHttpSocketClient.this.mProxy.handleMessage((String) ReflectionUtil.tryInvokeMethod(obj2, ReflectionUtil.tryGetMethod(OkHttpSocketClient.this.mBufferedSourceClazz, "readUtf8", new Class[0]), new Object[0]));
                        ReflectionUtil.tryInvokeMethod(obj2, ReflectionUtil.tryGetMethod(OkHttpSocketClient.this.mBufferedSourceClazz, "close", new Class[0]), new Object[0]);
                    } catch (Exception e) {
                        if (LogRedirector.isLoggable(OkHttpSocketClient.TAG, 2)) {
                            LogRedirector.w(OkHttpSocketClient.TAG, "Unexpected I/O exception processing message: " + e);
                        }
                        ReflectionUtil.tryInvokeMethod(obj2, ReflectionUtil.tryGetMethod(OkHttpSocketClient.this.mBufferedSourceClazz, "close", new Class[0]), new Object[0]);
                    } catch (Throwable th) {
                        ReflectionUtil.tryInvokeMethod(obj2, ReflectionUtil.tryGetMethod(OkHttpSocketClient.this.mBufferedSourceClazz, "close", new Class[0]), new Object[0]);
                        throw th;
                    }
                }
            } else if (!"onPong".equals(method.getName()) && "onClose".equals(method.getName()) && (handlerThread = OkHttpSocketClient.this.mHandlerThread) != null && handlerThread.isAlive()) {
                OkHttpSocketClient.this.mHandler.sendEmptyMessage(3);
            }
            return null;
        }
    }

    static {
        String[] strArr = {CLASS_WEBSOCKET, CLASS_WEBSOCKET_LISTENER, CLASS_WEBSOCKET_CALL, CLASS_WEBSOCKET_PAYLOADTYPE, CLASS_OKHTTP_CLIENT, CLASS_RESPONSE, CLASS_REQUEST, CLASS_REQUEST_BUILDER, CLASS_BUFFER, CLASS_BUFFER_SOURCE, CLASS_REQUEST_BODY, CLASS_MEDIA_TYPE_NEW, CLASS_RESPONSE_BODY};
        for (int i = 0; i < 13; i++) {
            String str = strArr[i];
            sClazzMap.put(str, ReflectionUtil.tryGetClassForName(str));
        }
    }

    public OkHttpSocketClient(DebugServerProxy debugServerProxy) {
        super(debugServerProxy);
        this.mInvocationHandler = new WebSocketInvocationHandler();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void abort(String str, Throwable th) {
        Log.w(TAG, "Error occurred, shutting down websocket connection: " + str);
        close();
        SocketClient.Callback callback = this.mConnectCallback;
        if (callback != null) {
            callback.onFailure(th);
            this.mConnectCallback = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.debug.SocketClient
    public void close() {
        if (this.mWebSocket != null) {
            Method tryGetMethod = ReflectionUtil.tryGetMethod(this.mWebSocketClazz, "close", Integer.TYPE, String.class);
            ReflectionUtil.tryInvokeMethod(this.mWebSocket, tryGetMethod, 1000, "End of session");
            this.mWebSocket = null;
            WXLogUtils.w(TAG, "Close websocket connection");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.debug.SocketClient
    public void connect(String str) {
        if (this.mSocketClient == null) {
            try {
                this.mSocketClient = this.mOkHttpClientClazz.newInstance();
                Class cls = this.mOkHttpClientClazz;
                Class cls2 = Long.TYPE;
                Method tryGetMethod = ReflectionUtil.tryGetMethod(cls, "setConnectTimeout", cls2, TimeUnit.class);
                Method tryGetMethod2 = ReflectionUtil.tryGetMethod(this.mOkHttpClientClazz, "setWriteTimeout", cls2, TimeUnit.class);
                Method tryGetMethod3 = ReflectionUtil.tryGetMethod(this.mOkHttpClientClazz, "setReadTimeout", cls2, TimeUnit.class);
                Object obj = this.mSocketClient;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                ReflectionUtil.tryInvokeMethod(obj, tryGetMethod, 0, timeUnit);
                ReflectionUtil.tryInvokeMethod(this.mSocketClient, tryGetMethod2, 0, timeUnit);
                ReflectionUtil.tryInvokeMethod(this.mSocketClient, tryGetMethod3, 0, timeUnit);
                if (!TextUtils.isEmpty(str)) {
                    Object newInstance = this.mRequestBuilderClazz.newInstance();
                    Method tryGetMethod4 = ReflectionUtil.tryGetMethod(this.mRequestBuilderClazz, "url", String.class);
                    Object tryInvokeMethod = ReflectionUtil.tryInvokeMethod(ReflectionUtil.tryInvokeMethod(newInstance, tryGetMethod4, str), ReflectionUtil.tryGetMethod(this.mRequestBuilderClazz, "build", new Class[0]), new Object[0]);
                    Method tryGetMethod5 = ReflectionUtil.tryGetMethod(this.mWebSocketCallClazz, "enqueue", this.mWebSocketListenerClazz);
                    Method tryGetMethod6 = ReflectionUtil.tryGetMethod(this.mWebSocketCallClazz, "create", this.mOkHttpClientClazz, this.mRequestClazz);
                    Object tryInvokeMethod2 = ReflectionUtil.tryInvokeMethod(this.mWebSocketCallClazz, tryGetMethod6, this.mSocketClient, tryInvokeMethod);
                    Object newProxyInstance = Proxy.newProxyInstance(this.mWebSocketListenerClazz.getClassLoader(), new Class[]{this.mWebSocketListenerClazz}, this.mInvocationHandler);
                    this.mWebSocketListener = newProxyInstance;
                    ReflectionUtil.tryInvokeMethod(tryInvokeMethod2, tryGetMethod5, newProxyInstance);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        } else {
            throw new IllegalStateException("OkHttpSocketClient is already initialized.");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x000c */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0017 */
    @Override // com.taobao.weex.devtools.debug.SocketClient
    public void sendProtocolMessage(int i, String str) {
        String str2 = "TEXT";
        if (this.mWebSocket != null) {
            str2 = ReflectionUtil.getFieldValue(ReflectionUtil.tryGetDeclaredField(this.mMediaTypeClazz, str2), null);
            Object obj = str2;
            try {
                obj = ReflectionUtil.getFieldValue(ReflectionUtil.tryGetDeclaredField(this.mWebSocketClazz, str2), null);
                Method tryGetMethod = ReflectionUtil.tryGetMethod(this.mWebSocketClazz, "sendMessage", this.mMediaTypeClazz, this.mBufferClazz);
                if (tryGetMethod != null) {
                    Object newInstance = this.mBufferClazz.newInstance();
                    Method tryGetMethod2 = ReflectionUtil.tryGetMethod(this.mBufferClazz, "writeUtf8", String.class);
                    ReflectionUtil.tryInvokeMethod(this.mWebSocket, tryGetMethod, obj, ReflectionUtil.tryInvokeMethod(newInstance, tryGetMethod2, str));
                    return;
                }
                Method tryGetMethod3 = ReflectionUtil.tryGetMethod(this.mWebSocketClazz, "sendMessage", this.mRequestBodyClazz);
                Method tryGetMethod4 = ReflectionUtil.tryGetMethod(this.mRequestBodyClazz, "create", this.mMediaTypeNewClazz, String.class);
                Object tryInvokeMethod = ReflectionUtil.tryInvokeMethod(this.mRequestBodyClazz, tryGetMethod4, obj, str);
                ReflectionUtil.tryInvokeMethod(this.mWebSocket, tryGetMethod3, tryInvokeMethod);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }
}

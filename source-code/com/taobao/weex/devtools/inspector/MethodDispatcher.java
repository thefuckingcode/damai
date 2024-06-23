package com.taobao.weex.devtools.inspector;

import com.taobao.weex.devtools.common.ExceptionUtil;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcException;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.EmptyResult;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcError;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.json.ObjectMapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONException;
import org.json.JSONObject;

@ThreadSafe
/* compiled from: Taobao */
public class MethodDispatcher {
    private final Iterable<ChromeDevtoolsDomain> mDomainHandlers;
    @GuardedBy("this")
    private Map<String, MethodDispatchHelper> mMethods;
    private final ObjectMapper mObjectMapper;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class MethodDispatchHelper {
        private final ChromeDevtoolsDomain mInstance;
        private final Method mMethod;
        private final ObjectMapper mObjectMapper;

        public MethodDispatchHelper(ObjectMapper objectMapper, ChromeDevtoolsDomain chromeDevtoolsDomain, Method method) {
            this.mObjectMapper = objectMapper;
            this.mInstance = chromeDevtoolsDomain;
            this.mMethod = method;
        }

        public JSONObject invoke(JsonRpcPeer jsonRpcPeer, @Nullable JSONObject jSONObject) throws InvocationTargetException, IllegalAccessException, JSONException, JsonRpcException {
            Object invoke = this.mMethod.invoke(this.mInstance, jsonRpcPeer, jSONObject);
            if (invoke == null || (invoke instanceof EmptyResult)) {
                return new JSONObject();
            }
            return (JSONObject) this.mObjectMapper.convertValue((JsonRpcResult) invoke, JSONObject.class);
        }
    }

    public MethodDispatcher(ObjectMapper objectMapper, Iterable<ChromeDevtoolsDomain> iterable) {
        this.mObjectMapper = objectMapper;
        this.mDomainHandlers = iterable;
    }

    private static Map<String, MethodDispatchHelper> buildDispatchTable(ObjectMapper objectMapper, Iterable<ChromeDevtoolsDomain> iterable) {
        Util.throwIfNull(objectMapper);
        HashMap hashMap = new HashMap();
        for (ChromeDevtoolsDomain chromeDevtoolsDomain : (Iterable) Util.throwIfNull(iterable)) {
            Class<?> cls = chromeDevtoolsDomain.getClass();
            String simpleName = cls.getSimpleName();
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (isDevtoolsMethod(method)) {
                    hashMap.put(simpleName + "." + method.getName(), new MethodDispatchHelper(objectMapper, chromeDevtoolsDomain, method));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private synchronized MethodDispatchHelper findMethodDispatcher(String str) {
        if (this.mMethods == null) {
            this.mMethods = buildDispatchTable(this.mObjectMapper, this.mDomainHandlers);
        }
        return this.mMethods.get(str);
    }

    private static boolean isDevtoolsMethod(Method method) throws IllegalArgumentException {
        if (!method.isAnnotationPresent(ChromeDevtoolsMethod.class)) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        String str = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        Util.throwIfNot(parameterTypes.length == 2, "%s: expected 2 args, got %s", str, Integer.valueOf(parameterTypes.length));
        Util.throwIfNot(parameterTypes[0].equals(JsonRpcPeer.class), "%s: expected 1st arg of JsonRpcPeer, got %s", str, parameterTypes[0].getName());
        Util.throwIfNot(parameterTypes[1].equals(JSONObject.class), "%s: expected 2nd arg of JSONObject, got %s", str, parameterTypes[1].getName());
        Class<?> returnType = method.getReturnType();
        if (!returnType.equals(Void.TYPE)) {
            Util.throwIfNot(JsonRpcResult.class.isAssignableFrom(returnType), "%s: expected JsonRpcResult return type, got %s", str, returnType.getName());
        }
        return true;
    }

    public JSONObject dispatch(JsonRpcPeer jsonRpcPeer, String str, @Nullable JSONObject jSONObject) throws JsonRpcException {
        MethodDispatchHelper findMethodDispatcher = findMethodDispatcher(str);
        if (findMethodDispatcher != null) {
            try {
                return findMethodDispatcher.invoke(jsonRpcPeer, jSONObject);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                ExceptionUtil.propagateIfInstanceOf(cause, JsonRpcException.class);
                throw ExceptionUtil.propagate(cause);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (JSONException e3) {
                throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e3.toString(), null));
            }
        } else {
            JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.METHOD_NOT_FOUND;
            throw new JsonRpcException(new JsonRpcError(errorCode, "Not implemented: " + str, null));
        }
    }
}

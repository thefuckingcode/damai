package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.nio.ByteBuffer;

public class JsValue {
    private final JsContext a;
    private final IX5JsValue b;

    private static class a implements IX5JsValue.JsValueFactory {
        private a() {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public String getJsValueClassName() {
            return JsValue.class.getName();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public IX5JsValue unwrap(Object obj) {
            if (obj == null || !(obj instanceof JsValue)) {
                return null;
            }
            return ((JsValue) obj).b;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public Object wrap(IX5JsValue iX5JsValue) {
            JsContext current;
            if (iX5JsValue == null || (current = JsContext.current()) == null) {
                return null;
            }
            return new JsValue(current, iX5JsValue);
        }
    }

    protected static IX5JsValue.JsValueFactory a() {
        return new a();
    }

    protected JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.a = jsContext;
        this.b = iX5JsValue;
    }

    public boolean isUndefined() {
        return this.b.isUndefined();
    }

    public boolean isNull() {
        return this.b.isNull();
    }

    public boolean isArray() {
        return this.b.isArray();
    }

    public boolean isBoolean() {
        return this.b.isBoolean();
    }

    public boolean toBoolean() {
        return this.b.toBoolean();
    }

    public boolean isInteger() {
        return this.b.isInteger();
    }

    public int toInteger() {
        return this.b.toInteger();
    }

    public boolean isNumber() {
        return this.b.isNumber();
    }

    public Number toNumber() {
        return this.b.toNumber();
    }

    public boolean isString() {
        return this.b.isString();
    }

    public String toString() {
        return this.b.toString();
    }

    public boolean isObject() {
        return this.b.isObject();
    }

    public <T> T toObject(Class<T> cls) {
        return (T) this.b.toObject(cls);
    }

    public boolean isJavascriptInterface() {
        return this.b.isJavascriptInterface();
    }

    public Object toJavascriptInterface() {
        return this.b.toJavascriptInterface();
    }

    public boolean isArrayBufferOrArrayBufferView() {
        return this.b.isArrayBufferOrArrayBufferView();
    }

    public ByteBuffer toByteBuffer() {
        return this.b.toByteBuffer();
    }

    public boolean isFunction() {
        return this.b.isFunction();
    }

    public JsValue call(Object... objArr) {
        return a(this.b.call(objArr));
    }

    public JsValue construct(Object... objArr) {
        return a(this.b.construct(objArr));
    }

    public boolean isPromise() {
        return this.b.isPromise();
    }

    public void resolve(Object obj) {
        this.b.resolveOrReject(obj, true);
    }

    public void reject(Object obj) {
        this.b.resolveOrReject(obj, false);
    }

    public JsContext context() {
        return this.a;
    }

    private JsValue a(IX5JsValue iX5JsValue) {
        if (iX5JsValue == null) {
            return null;
        }
        return new JsValue(this.a, iX5JsValue);
    }
}

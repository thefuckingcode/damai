package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;
import java.util.Objects;

/* compiled from: Taobao */
public class JSValueAdapter {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() {
        /* class com.youku.gaiax.quickjs.adapter.JSValueAdapter.AnonymousClass1 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == JSValue.class) {
                return JSValueAdapter.JS_VALUE_TYPE_ADAPTER;
            }
            return null;
        }
    };
    private static final TypeAdapter<JSValue> JS_VALUE_TYPE_ADAPTER = new TypeAdapter<JSValue>() {
        /* class com.youku.gaiax.quickjs.adapter.JSValueAdapter.AnonymousClass2 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return jSValue;
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            Objects.requireNonNull(jSValue, "value == null");
            return jSValue;
        }
    };
}

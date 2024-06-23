package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;
import java.util.Objects;

/* compiled from: Taobao */
public class JSFunctionAdapter {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() {
        /* class com.youku.gaiax.quickjs.adapter.JSFunctionAdapter.AnonymousClass1 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == JSFunction.class) {
                return JSFunctionAdapter.JS_FUNCTION_TYPE_ADAPTER;
            }
            return null;
        }
    };
    private static final TypeAdapter<JSFunction> JS_FUNCTION_TYPE_ADAPTER = new TypeAdapter<JSFunction>() {
        /* class com.youku.gaiax.quickjs.adapter.JSFunctionAdapter.AnonymousClass2 */

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSFunction fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return (JSFunction) jSValue.cast(JSFunction.class);
        }

        public JSFunction toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSFunction jSFunction) {
            Objects.requireNonNull(jSFunction, "value == null");
            return jSFunction;
        }
    };
}

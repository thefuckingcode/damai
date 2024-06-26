package com.taobao.weex.devtools.inspector.runtime;

import android.content.Context;
import androidx.annotation.Nullable;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.inspector.console.RuntimeRepl;
import com.taobao.weex.devtools.inspector.console.RuntimeReplFactory;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class RhinoDetectingRuntimeReplFactory implements RuntimeReplFactory {
    private final Context mContext;
    private RuntimeException mRhinoJsUnexpectedError;
    private RuntimeReplFactory mRhinoReplFactory;
    private boolean mSearchedForRhinoJs;

    public RhinoDetectingRuntimeReplFactory(Context context) {
        this.mContext = context;
    }

    @Nullable
    private static RuntimeReplFactory findRhinoReplFactory(Context context) throws RuntimeException {
        try {
            return (RuntimeReplFactory) Class.forName("com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder").getDeclaredMethod("defaultFactory", Context.class).invoke(null, context);
        } catch (ClassNotFoundException unused) {
            LogUtil.i("Error finding stetho-js-rhino, cannot enable console evaluation!");
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // com.taobao.weex.devtools.inspector.console.RuntimeReplFactory
    public RuntimeRepl newInstance() {
        if (!this.mSearchedForRhinoJs) {
            this.mSearchedForRhinoJs = true;
            try {
                this.mRhinoReplFactory = findRhinoReplFactory(this.mContext);
            } catch (RuntimeException e) {
                this.mRhinoJsUnexpectedError = e;
            }
        }
        RuntimeReplFactory runtimeReplFactory = this.mRhinoReplFactory;
        if (runtimeReplFactory != null) {
            return runtimeReplFactory.newInstance();
        }
        return new RuntimeRepl() {
            /* class com.taobao.weex.devtools.inspector.runtime.RhinoDetectingRuntimeReplFactory.AnonymousClass1 */

            @Override // com.taobao.weex.devtools.inspector.console.RuntimeRepl
            public Object evaluate(String str) throws Exception {
                if (RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError == null) {
                    return "Not supported without stetho-js-rhino dependency";
                }
                return "stetho-js-rhino threw: " + RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError.toString();
            }
        };
    }
}

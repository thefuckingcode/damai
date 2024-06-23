package com.taobao.android.preview;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Keep;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.n;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import tb.lx;
import tb.my;
import tb.vs;

@Keep
/* compiled from: Taobao */
public class DXPreviewInterfaceImpl implements DXTemplatePreviewActivity.DXPreviewInterface {

    /* compiled from: Taobao */
    class a extends com.taobao.android.dinamicx.a {
        final /* synthetic */ n a;

        a(DXPreviewInterfaceImpl dXPreviewInterfaceImpl, n nVar) {
            this.a = nVar;
        }

        @Override // com.taobao.android.dinamicx.IDXEventHandler
        public void handleEvent(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
            if (lxVar instanceof vs) {
                Log.i("lx", "checked=" + ((vs) lxVar).f());
            }
            String str = null;
            if (objArr != null) {
                str = objArr.toString();
            }
            Context f = n.f();
            Toast.makeText(f, "收到点击 参数为: " + str, 0).show();
        }
    }

    @Override // com.taobao.android.preview.DXTemplatePreviewActivity.DXPreviewInterface
    public void previewEngineDidInitialized(n nVar) {
        Log.e("shandian", "反射调用previewEngineDidInitialized");
        nVar.k(my.a("test"), new a(this, nVar));
    }
}

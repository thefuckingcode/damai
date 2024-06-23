package tb;

import android.os.Build;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class uv extends a {
    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && DinamicXEngine.i().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return Boolean.valueOf(a());
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "isRTL";
    }
}

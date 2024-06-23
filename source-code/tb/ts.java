package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class ts extends ay {
    public ts() {
        this.d = "branch";
    }

    @Override // tb.ay
    public Object b(@Nullable lx lxVar, DXRuntimeContext dXRuntimeContext) {
        int size = this.a.size();
        if (size <= 1) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            Object b = this.a.get(i).b(lxVar, dXRuntimeContext);
            if (b != null) {
                return b;
            }
        }
        return null;
    }
}

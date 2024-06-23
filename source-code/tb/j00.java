package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class j00 extends ay {
    public j00() {
        this.d = "branch";
    }

    @Override // tb.ay
    public Object b(@Nullable lx lxVar, DXRuntimeContext dXRuntimeContext) {
        List<ay> list = this.a;
        if (list == null) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            Object b = this.a.get(i).b(lxVar, dXRuntimeContext);
            if (b != null) {
                arrayList.add(b.toString());
            }
        }
        return arrayList;
    }
}

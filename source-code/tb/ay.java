package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class ay {
    public static final byte BranchBlock = 5;
    public static final byte Const = 3;
    public static final byte Event = 6;
    public static final byte Method = 1;
    public static final byte None = 0;
    public static final byte Script = 7;
    public static final byte SerialBlock = 4;
    public static final byte Var = 2;
    public List<ay> a;
    public long b;
    private short c;
    public String d;

    public void a(ay ayVar) {
        if (ayVar != null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(ayVar);
        }
    }

    public Object b(@Nullable lx lxVar, DXRuntimeContext dXRuntimeContext) {
        return this.d;
    }

    public short c() {
        return this.c;
    }

    public void d(short s) {
        this.c = s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(this.d) ? Long.valueOf(this.b) : this.d);
        sb.append(":");
        String sb2 = sb.toString();
        List<ay> list = this.a;
        if (list != null) {
            Iterator<ay> it = list.iterator();
            while (it.hasNext()) {
                sb2 = sb2 + it.next().toString();
            }
        }
        return sb2;
    }
}

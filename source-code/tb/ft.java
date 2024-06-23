package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.widget.event.IDXControlEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class ft implements DXSignalProduce.SignalReceiver {
    public static final int PERIOD_COUNT = 2;
    Map<String, List<IDXControlEventListener>> a = new HashMap();
    CopyOnWriteArrayList<et> b = new CopyOnWriteArrayList<>();
    int c;

    public ft() {
        DXSignalProduce.e().f(this);
    }

    public void a(et etVar) {
        List<IDXControlEventListener> list;
        if (!(etVar == null || TextUtils.isEmpty(etVar.b) || (list = this.a.get(etVar.b)) == null)) {
            for (IDXControlEventListener iDXControlEventListener : list) {
                iDXControlEventListener.receivedControlEvent(etVar);
            }
        }
    }

    public void b(et etVar) {
        boolean z = false;
        int i = 0;
        while (true) {
            try {
                if (i >= this.b.size()) {
                    z = true;
                    break;
                } else if (this.b.get(i).a(etVar)) {
                    break;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                vx.b(th);
                e eVar = new e(v00.DB_NAME);
                e.a aVar = new e.a("ControlEventCenter", "ControlEventCenter_Exception", e.DX_ERROR_CODE_CONTROL_EVENT_CENTER_EXCEPTION_CRASH);
                aVar.e = vx.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
                return;
            }
        }
        if (z) {
            this.b.add(etVar);
        }
    }

    public void c(IDXControlEventListener iDXControlEventListener, String str) {
        if (!TextUtils.isEmpty(str) && iDXControlEventListener != null) {
            List<IDXControlEventListener> list = this.a.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDXControlEventListener);
                this.a.put(str, arrayList);
                return;
            }
            list.add(iDXControlEventListener);
        }
    }

    @Override // com.taobao.android.dinamicx.notification.DXSignalProduce.SignalReceiver
    public void onReceiver() {
        int i = this.c;
        if (i == 2) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                a(this.b.get(i2));
            }
            this.b.clear();
            this.c = 0;
            return;
        }
        this.c = i + 1;
    }
}

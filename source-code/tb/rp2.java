package tb;

import android.widget.Toast;
import com.taobao.update.adapter.UIToast;
import com.taobao.update.framework.UpdateRuntime;

/* compiled from: Taobao */
public class rp2 implements UIToast {
    @Override // com.taobao.update.adapter.UIToast
    public void toast(String str) {
        Toast.makeText(UpdateRuntime.getContext(), str, 1).show();
    }
}

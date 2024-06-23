package tb;

import android.os.Process;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.UpdateListener;
import java.util.Iterator;

/* compiled from: Taobao */
public class lj extends ks2 implements UpdateListener {
    private boolean a = false;

    public lj() {
        UpdateDataSource.getInstance().registerListener("cmd", this);
    }

    private void a() {
        if (this.a) {
            this.a = false;
            Process.killProcess(Process.myPid());
        }
    }

    @Override // tb.ks2
    public boolean doUpdate(JSONObject jSONObject, boolean z, String str) {
        return false;
    }

    @Override // tb.ks2
    public void onBackground() {
        a();
    }

    @Override // tb.ks2
    public void onExit() {
        a();
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        UpdateDataSource.getInstance().invalidUpdateInfo("cmd");
        try {
            Iterator<Object> it = jSONObject.getJSONArray("cmds").iterator();
            while (it.hasNext()) {
                if (((JSONObject) it.next()).containsValue("reset")) {
                    this.a = true;
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
    }
}

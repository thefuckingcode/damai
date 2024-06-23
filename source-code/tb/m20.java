package tb;

import com.taobao.update.datasource.UpdateDataSource;

/* compiled from: Taobao */
public class m20 extends ks2 {
    private ul a;

    public m20(ul ulVar) {
        this.a = ulVar;
    }

    @Override // tb.ks2
    public void onForeground() {
        if (this.a.foregroundRequest) {
            UpdateDataSource.getInstance().startUpdate(true, true);
        }
    }
}

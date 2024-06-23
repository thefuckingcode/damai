package tb;

import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.update.adapter.UserAction;
import com.taobao.update.framework.UpdateRuntime;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public class m11 implements UserAction {
    private boolean a = false;
    private CountDownLatch b = new CountDownLatch(1);

    public static boolean waitForConfirmAction(String str) {
        m11 m11 = new m11();
        UpdateRuntime.doUIAlertForConfirm(str, m11);
        try {
            m11.b.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return m11.a;
    }

    @Override // com.taobao.update.adapter.UserAction
    public String getCancelText() {
        return "取消";
    }

    @Override // com.taobao.update.adapter.UserAction
    public String getConfirmText() {
        return "确定";
    }

    @Override // com.taobao.update.adapter.UserAction
    public String getTitleText() {
        return PurchaseConstants.NORMAL_WARNING_TITLE;
    }

    @Override // com.taobao.update.adapter.UserAction
    public void onCancel() {
        this.a = false;
        this.b.countDown();
    }

    @Override // com.taobao.update.adapter.UserAction
    public void onConfirm() {
        this.a = true;
        this.b.countDown();
    }
}

package tb;

import android.os.Handler;
import android.os.Message;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.OrderListFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class yn extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;
    private boolean b;
    private WeakReference<OrderListFragment> c;
    private long d = 1000;

    public yn(OrderListFragment orderListFragment) {
        this.c = new WeakReference<>(orderListFragment);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414789701")) {
            ipChange.ipc$dispatch("-1414789701", new Object[]{this});
            return;
        }
        this.a = true;
        this.b = false;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-628673431")) {
            return this.b;
        }
        return ((Boolean) ipChange.ipc$dispatch("-628673431", new Object[]{this})).booleanValue();
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745096401")) {
            ipChange.ipc$dispatch("-1745096401", new Object[]{this});
            return;
        }
        WeakReference<OrderListFragment> weakReference = this.c;
        if (weakReference != null) {
            this.a = false;
            this.b = true;
            Message obtainMessage = obtainMessage();
            obtainMessage.obj = Integer.valueOf(weakReference.get().mQueryType);
            obtainMessage.what = 0;
            sendMessageDelayed(obtainMessage, this.d);
        }
    }

    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746034426")) {
            ipChange.ipc$dispatch("746034426", new Object[]{this, message});
            return;
        }
        super.handleMessage(message);
        WeakReference<OrderListFragment> weakReference = this.c;
        if (weakReference != null && !this.a) {
            OrderListFragment orderListFragment = weakReference.get();
            if (orderListFragment.mQueryType == ((Integer) message.obj).intValue()) {
                orderListFragment.mAdapter.notifyDataSetChanged();
                Message obtainMessage = obtainMessage();
                obtainMessage.obj = Integer.valueOf(orderListFragment.mQueryType);
                obtainMessage.what = 0;
                sendMessageDelayed(obtainMessage, this.d);
            }
        }
    }
}

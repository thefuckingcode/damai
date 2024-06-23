package cn.damai.pay.alipay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class MobileSecurePayer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static String TAG = "MobileSecurePayer";
    Integer lock = 0;
    Activity mActivity = null;
    IAlixPay mAlixPay = null;
    private ServiceConnection mAlixPayConnection = new ServiceConnection() {
        /* class cn.damai.pay.alipay.MobileSecurePayer.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1870114394")) {
                ipChange.ipc$dispatch("-1870114394", new Object[]{this, componentName, iBinder});
                return;
            }
            synchronized (MobileSecurePayer.this.lock) {
                MobileSecurePayer.this.mAlixPay = IAlixPay.Stub.asInterface(iBinder);
                MobileSecurePayer.this.lock.notify();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1357244089")) {
                ipChange.ipc$dispatch("1357244089", new Object[]{this, componentName});
                return;
            }
            MobileSecurePayer.this.mAlixPay = null;
        }
    };
    private IRemoteServiceCallback mCallback = new IRemoteServiceCallback.Stub() {
        /* class cn.damai.pay.alipay.MobileSecurePayer.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1896490378")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-1896490378", new Object[]{this})).intValue();
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "886150765")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("886150765", new Object[]{this})).booleanValue();
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1545831444")) {
                ipChange.ipc$dispatch("-1545831444", new Object[]{this, Boolean.valueOf(z), str});
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "948060545")) {
                ipChange.ipc$dispatch("948060545", new Object[]{this, str, str2, map});
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2043633831")) {
                ipChange.ipc$dispatch("-2043633831", new Object[]{this, str, str2, Integer.valueOf(i), bundle});
                return;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent.setClassName(str, str2);
            MobileSecurePayer.this.mActivity.startActivity(intent);
        }
    };
    boolean mbPaying = false;

    public boolean pay(String str, final String str2, final Handler handler, final int i, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113322871")) {
            return ((Boolean) ipChange.ipc$dispatch("-113322871", new Object[]{this, str, str2, handler, Integer.valueOf(i), activity})).booleanValue();
        } else if (this.mbPaying) {
            return false;
        } else {
            this.mbPaying = true;
            this.mActivity = activity;
            if (this.mAlixPay == null) {
                activity.bindService(new Intent(str), this.mAlixPayConnection, 1);
            }
            new Thread(new Runnable() {
                /* class cn.damai.pay.alipay.MobileSecurePayer.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "557308667")) {
                        ipChange.ipc$dispatch("557308667", new Object[]{this});
                        return;
                    }
                    try {
                        synchronized (MobileSecurePayer.this.lock) {
                            MobileSecurePayer mobileSecurePayer = MobileSecurePayer.this;
                            if (mobileSecurePayer.mAlixPay == null) {
                                mobileSecurePayer.lock.wait();
                            }
                        }
                        MobileSecurePayer mobileSecurePayer2 = MobileSecurePayer.this;
                        mobileSecurePayer2.mAlixPay.registerCallback(mobileSecurePayer2.mCallback);
                        String Pay = MobileSecurePayer.this.mAlixPay.Pay(str2);
                        String str = MobileSecurePayer.TAG;
                        BaseHelper.log(str, "After Pay: " + Pay);
                        MobileSecurePayer mobileSecurePayer3 = MobileSecurePayer.this;
                        mobileSecurePayer3.mbPaying = false;
                        mobileSecurePayer3.mAlixPay.unregisterCallback(mobileSecurePayer3.mCallback);
                        MobileSecurePayer mobileSecurePayer4 = MobileSecurePayer.this;
                        mobileSecurePayer4.mActivity.unbindService(mobileSecurePayer4.mAlixPayConnection);
                        Message message = new Message();
                        message.what = i;
                        message.obj = Pay;
                        handler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Message message2 = new Message();
                        message2.what = i;
                        message2.obj = e.toString();
                        handler.sendMessage(message2);
                    }
                }
            }).start();
            return true;
        }
    }
}

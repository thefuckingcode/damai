package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.pay.alipay.Result2;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.m.u.l;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ActionAlipay extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int SDK_PAY_FLAG = 1;
    private WVCallBackContext callback;
    private Handler mHandler = new Handler() {
        /* class cn.damai.h5container.action.ActionAlipay.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-224699432")) {
                ipChange.ipc$dispatch("-224699432", new Object[]{this, message});
            } else if (message.what == 1) {
                Result2 result2 = new Result2((String) message.obj);
                try {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(l.a, result2.resultStatus);
                    wVResult.addData("result", result2.result);
                    wVResult.addData(l.b, result2.memo);
                    ActionAlipay.this.onAlipay(wVResult);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public ActionAlipay(Context context) {
        super(context);
    }

    private void doAliPay(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444239213")) {
            ipChange.ipc$dispatch("444239213", new Object[]{this, str});
            return;
        }
        new Thread(new Runnable() {
            /* class cn.damai.h5container.action.ActionAlipay.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2048097114")) {
                    ipChange.ipc$dispatch("2048097114", new Object[]{this});
                    return;
                }
                String pay = ActionAlipay.this.contextReference instanceof Activity ? new PayTask((Activity) ActionAlipay.this.contextReference).pay(str, true) : "";
                Message message = new Message();
                message.what = 1;
                message.obj = pay;
                ActionAlipay.this.mHandler.sendMessage(message);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onAlipay(WVResult wVResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035419549")) {
            ipChange.ipc$dispatch("2035419549", new Object[]{this, wVResult});
            return;
        }
        this.callback.success(wVResult);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1137513428")) {
            return ((Boolean) ipChange.ipc$dispatch("-1137513428", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        this.callback = wVCallBackContext;
        doAliPay(this.jsonObject.getString("payParam"));
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-469501990")) {
            return "alipay";
        }
        return (String) ipChange.ipc$dispatch("-469501990", new Object[]{this});
    }
}

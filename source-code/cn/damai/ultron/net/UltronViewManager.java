package cn.damai.ultron.net;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.utils.DmUltronProgressDialog;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.android.ultron.trade.presenter.b;
import com.alibaba.android.ultron.vfw.adapter.RecyclerViewAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.IDXEventHandler;

/* compiled from: Taobao */
public class UltronViewManager extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    protected DmUltronProgressDialog progressDialog;

    public UltronViewManager(IPresenter iPresenter) {
        super(iPresenter);
    }

    public void dismissLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956385459")) {
            ipChange.ipc$dispatch("-1956385459", new Object[]{this});
            return;
        }
        DmUltronProgressDialog dmUltronProgressDialog = this.progressDialog;
        if (dmUltronProgressDialog != null) {
            dmUltronProgressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    @Override // com.alibaba.android.ultron.trade.presenter.b
    public void initView(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450840717")) {
            ipChange.ipc$dispatch("1450840717", new Object[]{this, linearLayout, recyclerView, linearLayout2});
            return;
        }
        bindViewTree(linearLayout, recyclerView, linearLayout2);
        setAdapter(new RecyclerViewAdapter(this.mViewEngine));
    }

    public void showLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133165204")) {
            ipChange.ipc$dispatch("-1133165204", new Object[]{this});
            return;
        }
        Activity activity = this.mContext;
        if (activity != null && !activity.isDestroyed() && !this.mContext.isFinishing()) {
            if (this.progressDialog == null) {
                DmUltronProgressDialog a = new DmUltronProgressDialog(this.mContext).a();
                this.progressDialog = a;
                a.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class cn.damai.ultron.net.UltronViewManager.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onDismiss(DialogInterface dialogInterface) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1893670861")) {
                            ipChange.ipc$dispatch("-1893670861", new Object[]{this, dialogInterface});
                        }
                    }
                });
            }
            this.progressDialog.show();
        }
    }

    public void v3RegisterDinamicXEvent(long j, @NonNull IDXEventHandler iDXEventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196365635")) {
            ipChange.ipc$dispatch("-196365635", new Object[]{this, Long.valueOf(j), iDXEventHandler});
            return;
        }
        this.mViewEngine.n().d().k(j, iDXEventHandler);
    }
}

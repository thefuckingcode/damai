package cn.damai.launcher.splash.model.listener;

import android.os.Handler;
import android.os.Looper;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.downloader.request.a;
import tb.io1;

/* compiled from: Taobao */
public class OnAdMainThreadFileListener extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnBizListener<String> mListener;

    public OnAdMainThreadFileListener(OnBizListener<String> onBizListener) {
        this.mListener = onBizListener;
    }

    private boolean isMainThread() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1480394558")) {
            return Thread.currentThread() == Looper.getMainLooper().getThread();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1480394558", new Object[]{this})).booleanValue();
    }

    @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
    public void onDownloadError(String str, final int i, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042876475")) {
            ipChange.ipc$dispatch("-1042876475", new Object[]{this, str, Integer.valueOf(i), str2});
        } else if (isMainThread()) {
            OnBizListener<String> onBizListener = this.mListener;
            onBizListener.onBizFail(i + "", str2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2080275591")) {
                        ipChange.ipc$dispatch("2080275591", new Object[]{this});
                        return;
                    }
                    OnBizListener onBizListener = OnAdMainThreadFileListener.this.mListener;
                    onBizListener.onBizFail(i + "", str2);
                }
            });
        }
    }

    @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
    public void onDownloadFinish(String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085550043")) {
            ipChange.ipc$dispatch("-1085550043", new Object[]{this, str, str2});
        } else if (isMainThread()) {
            this.mListener.onBizSuccess(str2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1883762086")) {
                        ipChange.ipc$dispatch("1883762086", new Object[]{this});
                        return;
                    }
                    OnAdMainThreadFileListener.this.mListener.onBizSuccess(str2);
                }
            });
        }
    }

    @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
    public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019682537")) {
            ipChange.ipc$dispatch("-1019682537", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
        } else if (isMainThread()) {
            this.mListener.onBizFail("-1", "network_limit");
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1687248581")) {
                        ipChange.ipc$dispatch("1687248581", new Object[]{this});
                        return;
                    }
                    OnAdMainThreadFileListener.this.mListener.onBizFail("-1", "network_limit");
                }
            });
        }
    }
}

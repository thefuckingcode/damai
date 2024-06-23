package cn.damai.commonbusiness.seatbiz.seat.qilin.support.download;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$ProgressListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.NetworkEvent$ProgressEvent;
import anetwork.channel.Response;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import tb.cp1;
import tb.e02;
import tb.uy0;

/* compiled from: Taobao */
public class NetApi {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class NetCallback<T> implements NetworkCallBack$FinishListener, NetworkCallBack$ResponseCodeListener, NetworkCallBack$ProgressListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private final List<cp1> a = new ArrayList();
        private final Handler b = new Handler(Looper.getMainLooper());
        private final OnDownLoadListener<T> c;

        NetCallback(OnDownLoadListener<T> onDownLoadListener) {
            this.c = onDownLoadListener;
        }

        private void b(final int i, final String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "897093380")) {
                ipChange.ipc$dispatch("897093380", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            this.b.post(new Runnable() {
                /* class cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi.NetCallback.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "655502864")) {
                        ipChange.ipc$dispatch("655502864", new Object[]{this});
                        return;
                    }
                    NetCallback.this.c.onFail(i, str);
                }
            });
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1059703992")) {
                ipChange.ipc$dispatch("-1059703992", new Object[]{this});
                return;
            }
            this.b.post(new Runnable() {
                /* class cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi.NetCallback.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "458989359")) {
                        ipChange.ipc$dispatch("458989359", new Object[]{this});
                        return;
                    }
                    NetCallback.this.c.onLimit();
                }
            });
        }

        private void d(final T t) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "347154012")) {
                ipChange.ipc$dispatch("347154012", new Object[]{this, t});
                return;
            }
            this.b.post(new Runnable() {
                /* class cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi.NetCallback.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener */
                /* JADX WARN: Multi-variable type inference failed */
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "852016369")) {
                        ipChange.ipc$dispatch("852016369", new Object[]{this});
                        return;
                    }
                    NetCallback.this.c.onSuccess(t);
                }
            });
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        private void e(int i) {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1441337911")) {
                ipChange.ipc$dispatch("-1441337911", new Object[]{this, Integer.valueOf(i)});
            } else if (this.a.size() == 0) {
                b(i, "数据返回为空");
            } else {
                try {
                    Collections.sort(this.a);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        for (cp1 cp1 : this.a) {
                            byteArrayOutputStream.write(cp1.b);
                        }
                        d(this.c.callSubThread(byteArrayOutputStream.toByteArray()));
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            b(i, th.getMessage());
                            if (byteArrayOutputStream == null) {
                            }
                        } catch (Throwable th3) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream = null;
                    th = th4;
                    th.printStackTrace();
                    b(i, th.getMessage());
                    if (byteArrayOutputStream == null) {
                        byteArrayOutputStream.close();
                    }
                }
            }
        }

        @Override // anetwork.channel.NetworkCallBack$ProgressListener
        public void onDataReceived(NetworkEvent$ProgressEvent networkEvent$ProgressEvent, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389257949")) {
                ipChange.ipc$dispatch("-1389257949", new Object[]{this, networkEvent$ProgressEvent, obj});
                return;
            }
            int size = networkEvent$ProgressEvent.getSize();
            if (size > 0) {
                byte[] bytedata = networkEvent$ProgressEvent.getBytedata();
                this.a.add(new cp1(networkEvent$ProgressEvent.getIndex(), Arrays.copyOf(bytedata, size)));
            }
        }

        @Override // anetwork.channel.NetworkCallBack$FinishListener
        public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1020136272")) {
                ipChange.ipc$dispatch("1020136272", new Object[]{this, networkEvent$FinishEvent, obj});
                return;
            }
            int httpCode = networkEvent$FinishEvent.getHttpCode();
            if (httpCode == 200) {
                e(httpCode);
            } else if (httpCode == 202 || httpCode == 540) {
                c();
            } else {
                b(httpCode, networkEvent$FinishEvent.getDesc());
            }
        }

        @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
        public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1870646070")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("1870646070", new Object[]{this, Integer.valueOf(i), map, obj})).booleanValue();
        }
    }

    public static <T> Future<Response> a(Context context, String str, @NonNull OnDownLoadListener<T> onDownLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999620880")) {
            return (Future) ipChange.ipc$dispatch("1999620880", new Object[]{context, str, onDownLoadListener});
        }
        uy0 uy0 = new uy0(context);
        e02 e02 = new e02(str);
        e02.setConnectTimeout(10000);
        e02.setReadTimeout(15000);
        return uy0.asyncSend(e02, null, null, new NetCallback(onDownLoadListener));
    }
}

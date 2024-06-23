package mtopsdk.network.impl;

import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.ParcelableInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.Call;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;
import mtopsdk.network.util.ANetworkConverter;
import mtopsdk.network.util.NetworkUtils;

/* compiled from: Taobao */
public class NetworkListenerAdapter implements NetworkCallBack$FinishListener, NetworkCallBack$InputStreamListener, NetworkCallBack$ResponseCodeListener {
    private static final String TAG = "mtopsdk.NetworkListenerAdapter";
    ByteArrayOutputStream bos = null;
    Call call;
    NetworkEvent$FinishEvent finishEvent = null;
    Map<String, List<String>> headers;
    boolean isNeedCallFinish = false;
    private volatile boolean isStreamReceived = false;
    NetworkCallback networkCallback;
    int resLength = 0;
    final String seqNo;
    int statusCode;

    public NetworkListenerAdapter(Call call2, NetworkCallback networkCallback2, String str) {
        this.call = call2;
        this.networkCallback = networkCallback2;
        this.seqNo = str;
    }

    /* access modifiers changed from: package-private */
    public void callFinish(final NetworkEvent$FinishEvent networkEvent$FinishEvent, final Object obj) {
        String str = this.seqNo;
        MtopSDKThreadPoolExecutorFactory.submitCallbackTask(str != null ? str.hashCode() : hashCode(), new Runnable() {
            /* class mtopsdk.network.impl.NetworkListenerAdapter.AnonymousClass2 */

            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    NetworkListenerAdapter.this.onFinishTask(networkEvent$FinishEvent, obj);
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        String str = NetworkListenerAdapter.this.seqNo;
                        TBSdkLog.d(NetworkListenerAdapter.TAG, str, "[callFinish] execute onFinishTask time[ms] " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (Exception e) {
                    TBSdkLog.e(NetworkListenerAdapter.TAG, NetworkListenerAdapter.this.seqNo, "[callFinish]execute onFinishTask error.", e);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onFinishTask(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        if (this.networkCallback == null) {
            TBSdkLog.e(TAG, this.seqNo, "[onFinishTask]networkCallback is null");
            return;
        }
        final byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = this.bos;
        if (byteArrayOutputStream != null) {
            bArr = byteArrayOutputStream.toByteArray();
        }
        AnonymousClass3 r0 = new ResponseBody() {
            /* class mtopsdk.network.impl.NetworkListenerAdapter.AnonymousClass3 */

            @Override // mtopsdk.network.domain.ResponseBody
            public InputStream byteStream() {
                return null;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public long contentLength() throws IOException {
                byte[] bArr = bArr;
                if (bArr != null) {
                    return (long) bArr.length;
                }
                return 0;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public String contentType() {
                return HeaderHandlerUtil.getSingleHeaderFieldByKey(NetworkListenerAdapter.this.headers, "Content-Type");
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public byte[] getBytes() throws IOException {
                return bArr;
            }
        };
        this.networkCallback.onResponse(this.call, new Response.Builder().request(this.call.request()).code(networkEvent$FinishEvent.getHttpCode()).message(networkEvent$FinishEvent.getDesc()).headers(this.headers).body(r0).stat(ANetworkConverter.convertNetworkStats(networkEvent$FinishEvent.getStatisticData())).build());
    }

    @Override // anetwork.channel.NetworkCallBack$FinishListener
    public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        synchronized (this) {
            this.finishEvent = networkEvent$FinishEvent;
            if (this.isNeedCallFinish || !this.isStreamReceived) {
                callFinish(networkEvent$FinishEvent, obj);
            }
        }
    }

    @Override // anetwork.channel.NetworkCallBack$InputStreamListener
    public void onInputStreamGet(final ParcelableInputStream parcelableInputStream, final Object obj) {
        this.isStreamReceived = true;
        MtopSDKThreadPoolExecutorFactory.submitRequestTask(new Runnable() {
            /* class mtopsdk.network.impl.NetworkListenerAdapter.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
                if (r0 != null) goto L_0x0088;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
                if (r0 == null) goto L_0x008b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
                r0.close();
             */
            public void run() {
                ParcelableInputStream parcelableInputStream;
                try {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d(NetworkListenerAdapter.TAG, NetworkListenerAdapter.this.seqNo, "[onInputStreamGet]start to read input stream");
                    }
                    NetworkListenerAdapter.this.bos = new ByteArrayOutputStream(parcelableInputStream.length() > 0 ? parcelableInputStream.length() : NetworkListenerAdapter.this.resLength);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = parcelableInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                            String str = NetworkListenerAdapter.this.seqNo;
                            TBSdkLog.d(NetworkListenerAdapter.TAG, str, "[onInputStreamGet]data chunk content: " + new String(bArr, 0, read));
                        }
                        NetworkListenerAdapter.this.bos.write(bArr, 0, read);
                    }
                    parcelableInputStream = parcelableInputStream;
                } catch (Exception e) {
                    TBSdkLog.e(NetworkListenerAdapter.TAG, NetworkListenerAdapter.this.seqNo, "[onInputStreamGet]Read data from inputstream failed.", e);
                    NetworkListenerAdapter.this.bos = null;
                    parcelableInputStream = parcelableInputStream;
                } catch (Throwable th) {
                    ParcelableInputStream parcelableInputStream2 = parcelableInputStream;
                    if (parcelableInputStream2 != null) {
                        try {
                            parcelableInputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    NetworkUtils.closeQuietly(NetworkListenerAdapter.this.bos);
                    throw th;
                }
                NetworkUtils.closeQuietly(NetworkListenerAdapter.this.bos);
                synchronized (NetworkListenerAdapter.this) {
                    NetworkListenerAdapter networkListenerAdapter = NetworkListenerAdapter.this;
                    NetworkEvent$FinishEvent networkEvent$FinishEvent = networkListenerAdapter.finishEvent;
                    if (networkEvent$FinishEvent != null) {
                        networkListenerAdapter.callFinish(networkEvent$FinishEvent, obj);
                    } else {
                        networkListenerAdapter.isNeedCallFinish = true;
                    }
                }
            }
        });
    }

    @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
    public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
        this.statusCode = i;
        this.headers = map;
        try {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "content-length");
            if (StringUtils.isBlank(singleHeaderFieldByKey)) {
                singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(this.headers, HttpHeaderConstant.X_BIN_LENGTH);
            }
            if (!StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                return false;
            }
            this.resLength = Integer.parseInt(singleHeaderFieldByKey);
            return false;
        } catch (Exception unused) {
            TBSdkLog.e(TAG, this.seqNo, "[onResponseCode]parse Response HeaderField ContentLength error ");
            return false;
        }
    }
}

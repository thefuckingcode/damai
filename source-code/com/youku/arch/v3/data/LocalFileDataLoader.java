package com.youku.arch.v3.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.data.local.LocalDataSource;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ph;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/data/LocalFileDataLoader;", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "Lcom/youku/arch/v3/data/Chain;", "chain", "Ltb/ur2;", "process", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class LocalFileDataLoader implements DataLoader<RequestContext> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Can't wrap try/catch for region: R(16:8|9|10|(1:12)(1:13)|14|15|16|17|18|(2:19|(1:21)(1:91))|22|23|24|25|26|(8:65|(1:67)|69|(1:71)|72|(1:74)|75|(1:77))) */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (r9 == null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e4, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011b, code lost:
        if (r9 == null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0167, code lost:
        if (r2 > r4.getTimestamp()) goto L_0x0169;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8 A[Catch:{ all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dd A[SYNTHETIC, Splitter:B:49:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0116 A[SYNTHETIC, Splitter:B:60:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019d A[SYNTHETIC, Splitter:B:81:0x019d] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a4 A[SYNTHETIC, Splitter:B:85:0x01a4] */
    @Override // com.youku.arch.v3.data.DataLoader
    public void process(@NotNull Chain<RequestContext> chain) {
        Uri uri;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        FileNotFoundException e;
        InputStream inputStream2;
        IOException e2;
        InputStream inputStream3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626984704")) {
            ipChange.ipc$dispatch("1626984704", new Object[]{this, chain});
            return;
        }
        k21.i(chain, "chain");
        RequestContext param = chain.getParam();
        IRequest request = param.getRequest();
        Bundle bundle = request.getBundle();
        if (!(bundle == null || (uri = (Uri) bundle.getParcelable("uri")) == null)) {
            ContentResolver contentResolver = AppInfoProviderProxy.getAppContext().getContentResolver();
            byte[] bArr = null;
            InputStream inputStream4 = null;
            bArr = null;
            bArr = null;
            try {
                if (o.w("assets", uri.getScheme(), true)) {
                    inputStream3 = AppInfoProviderProxy.getAppContext().getAssets().open(uri.getAuthority());
                } else {
                    inputStream3 = contentResolver.openInputStream(uri);
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(inputStream3.available());
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream3.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                        bArr = byteArrayOutputStream2.toByteArray();
                        inputStream3.close();
                        byteArrayOutputStream2.close();
                    } catch (FileNotFoundException e3) {
                        inputStream = inputStream3;
                        e = e3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (AppInfoProviderProxy.isDebuggable()) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (IOException e4) {
                        inputStream2 = inputStream3;
                        e2 = e4;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            if (AppInfoProviderProxy.isDebuggable()) {
                            }
                            if (inputStream2 != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream4 = inputStream2;
                            if (inputStream4 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream4 = inputStream3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (inputStream4 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    byteArrayOutputStream = null;
                    inputStream = inputStream3;
                    e = e5;
                    if (AppInfoProviderProxy.isDebuggable()) {
                    }
                    if (inputStream != null) {
                    }
                } catch (IOException e6) {
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream3;
                    e2 = e6;
                    if (AppInfoProviderProxy.isDebuggable()) {
                    }
                    if (inputStream2 != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream4 = inputStream3;
                    if (inputStream4 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                inputStream = null;
                byteArrayOutputStream = null;
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.e("LocalFileDataLoader", uri.toString() + " FileNotFoundException :" + ((Object) e.getMessage()));
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException e8) {
                e2 = e8;
                inputStream2 = null;
                byteArrayOutputStream = null;
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.e("LocalFileDataLoader", uri.toString() + " IOException :" + ((Object) e2.getMessage()));
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                if (inputStream4 != null) {
                    try {
                        inputStream4.close();
                    } catch (IOException unused3) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
            if (bArr != null) {
                Response build = new Response.Builder().setId(request.getId()).setSource(Constants.ResponseSource.LOCAL_FILE).setTimestamp(System.currentTimeMillis()).setRetCode("SUCCESS").setRawData(new String(bArr, ph.UTF_8)).build();
                if (param.getResponse() != null) {
                    long timestamp = build.getTimestamp();
                    IResponse response = param.getResponse();
                    k21.f(response);
                }
                if (param.getRequest().isNeedCache()) {
                    LocalDataSource.put$default(LocalDataSource.Companion.getInstance(), build, 0, 2, null);
                }
                param.setResponse(build);
                DataLoadCallback callback = param.getCallback();
                if (callback != null) {
                    callback.onFilter(build);
                }
                DataLoadCallback callback2 = param.getCallback();
                if (callback2 != null) {
                    callback2.onResponse(build);
                }
            }
        }
        chain.proceed();
    }
}

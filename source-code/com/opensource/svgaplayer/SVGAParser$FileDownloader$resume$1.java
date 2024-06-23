package com.opensource.svgaplayer;

import android.net.http.HttpResponseCache;
import android.util.Log;
import com.opensource.svgaplayer.SVGAParser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGAParser$FileDownloader$resume$1 implements Runnable {
    final /* synthetic */ Function1 $complete;
    final /* synthetic */ Function1 $failure;
    final /* synthetic */ URL $url;
    final /* synthetic */ SVGAParser.FileDownloader this$0;

    SVGAParser$FileDownloader$resume$1(SVGAParser.FileDownloader fileDownloader, URL url, Function1 function1, Function1 function12) {
        this.this$0 = fileDownloader;
        this.$url = url;
        this.$complete = function1;
        this.$failure = function12;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:53|(2:55|56)|59|60) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:29|30|31|34|35) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:42|43|44|47|48) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x009d */
    public final void run() {
        InputStream inputStream;
        boolean z;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z2;
        Throwable th2;
        ByteArrayInputStream byteArrayInputStream;
        boolean z3;
        Throwable th3;
        try {
            if (HttpResponseCache.getInstalled() == null && !this.this$0.a()) {
                Log.e("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                Log.e("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
            }
            URLConnection openConnection = this.$url.openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                openConnection = null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            if (httpURLConnection != null) {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                z = false;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            this.$complete.invoke(byteArrayInputStream);
                            ur2 ur2 = ur2.INSTANCE;
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            byteArrayInputStream.close();
                            throw e;
                        } catch (Throwable th4) {
                            th3 = th4;
                            z3 = true;
                        }
                    } catch (Exception e2) {
                        byteArrayOutputStream.close();
                        throw e2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        z2 = true;
                    }
                } catch (Exception e3) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw e3;
                } catch (Throwable th6) {
                    th = th6;
                    z = true;
                }
            } else {
                return;
            }
            if (!z3) {
                byteArrayInputStream.close();
            }
            throw th3;
            if (!z2) {
                byteArrayOutputStream.close();
            }
            throw th2;
            if (!z && inputStream != null) {
                inputStream.close();
            }
            throw th;
        } catch (Exception e4) {
            e4.printStackTrace();
            this.$failure.invoke(e4);
        }
    }
}

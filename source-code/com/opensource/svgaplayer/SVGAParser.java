package com.opensource.svgaplayer;

import android.content.Context;
import android.os.Handler;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.weex.bridge.WXBridgeManager;
import com.uc.webview.export.media.MessageID;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tb.ef2;
import tb.k21;
import tb.ur2;
import tb.w22;

/* compiled from: Taobao */
public final class SVGAParser {
    @NotNull
    private FileDownloader a = new FileDownloader();
    private final Context b;

    /* compiled from: Taobao */
    public static class FileDownloader {
        private boolean a;

        public final boolean a() {
            return this.a;
        }

        public void b(@NotNull URL url, @NotNull Function1<? super InputStream, ur2> function1, @NotNull Function1<? super Exception, ur2> function12) {
            k21.j(url, "url");
            k21.j(function1, "complete");
            k21.j(function12, AKBaseAbility.CALLBACK_FAILURE);
            new Thread(new SVGAParser$FileDownloader$resume$1(this, url, function1, function12)).start();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "Ltb/ur2;", "onComplete", MessageID.onError, "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Taobao */
    public interface ParseCompletion {
        void onComplete(@NotNull SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    public SVGAParser(@NotNull Context context) {
        k21.j(context, WPKFactory.INIT_KEY_CONTEXT);
        this.b = context;
    }

    private final File d(String str) {
        return new File(this.b.getCacheDir().getAbsolutePath() + "/" + str + "/");
    }

    private final String e(String str) {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        Charset forName = Charset.forName("UTF-8");
        k21.e(forName, "Charset.forName(charsetName)");
        if (str != null) {
            byte[] bytes = str.getBytes(forName);
            k21.e(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            String str2 = "";
            for (byte b2 : digest) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                ef2 ef2 = ef2.INSTANCE;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
                k21.e(format, "java.lang.String.format(format, *args)");
                sb.append(format);
                str2 = sb.toString();
            }
            return str2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: private */
    public final String f(URL url) {
        String url2 = url.toString();
        k21.e(url2, "url.toString()");
        return e(url2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002f */
    private final byte[] g(byte[] bArr) {
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int inflate = inflater.inflate(bArr2, 0, 2048);
                    if (inflate <= 0) {
                        inflater.end();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, inflate);
                } catch (Exception e) {
                    byteArrayOutputStream.close();
                    throw e;
                } catch (Throwable th) {
                    if (1 == 0) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:24|25|26|29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:49|50|51|54|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:82|83|84|87|88) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:93|94|95|98|99) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00ba */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0114 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x0126 */
    public final SVGAVideoEntity h(InputStream inputStream, String str) {
        boolean z;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z2;
        Throwable th2;
        FileInputStream fileInputStream2;
        Throwable th3;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th4;
        boolean z3;
        byte[] m = m(inputStream);
        if (m != null) {
            if (m.length > 4) {
                z = false;
                if (m[0] == 80 && m[1] == 75 && m[2] == 3 && m[3] == 4) {
                    synchronized (Integer.valueOf(w22.a())) {
                        if (!d(str).exists()) {
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(m);
                                try {
                                    n(byteArrayInputStream, str);
                                    ur2 ur2 = ur2.INSTANCE;
                                    byteArrayInputStream.close();
                                } catch (Exception e) {
                                    byteArrayInputStream.close();
                                    throw e;
                                } catch (Throwable th5) {
                                    th4 = th5;
                                    z3 = true;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            File file = new File(this.b.getCacheDir().getAbsolutePath() + "/" + str + "/");
                            File file2 = new File(file, "movie.binary");
                            if (!file2.isFile()) {
                                file2 = null;
                            }
                            if (file2 != null) {
                                try {
                                    fileInputStream2 = new FileInputStream(file2);
                                    try {
                                        MovieEntity decode = MovieEntity.ADAPTER.decode(fileInputStream2);
                                        k21.e(decode, "MovieEntity.ADAPTER.decode(it)");
                                        SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, file);
                                        fileInputStream2.close();
                                        return sVGAVideoEntity;
                                    } catch (Exception e3) {
                                        fileInputStream2.close();
                                        throw e3;
                                    } catch (Throwable th6) {
                                        th3 = th6;
                                        z = true;
                                    }
                                } catch (Exception e4) {
                                    file.delete();
                                    file2.delete();
                                    throw e4;
                                }
                            } else {
                                File file3 = new File(file, "movie.spec");
                                if (!file3.isFile()) {
                                    file3 = null;
                                }
                                if (file3 != null) {
                                    try {
                                        fileInputStream = new FileInputStream(file3);
                                        try {
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                byte[] bArr = new byte[2048];
                                                while (true) {
                                                    int read = fileInputStream.read(bArr, 0, 2048);
                                                    if (read == -1) {
                                                        SVGAVideoEntity sVGAVideoEntity2 = new SVGAVideoEntity(new JSONObject(byteArrayOutputStream.toString()), file);
                                                        byteArrayOutputStream.close();
                                                        fileInputStream.close();
                                                        return sVGAVideoEntity2;
                                                    }
                                                    byteArrayOutputStream.write(bArr, 0, read);
                                                }
                                            } catch (Exception e5) {
                                                byteArrayOutputStream.close();
                                                throw e5;
                                            } catch (Throwable th7) {
                                                th2 = th7;
                                                z2 = true;
                                            }
                                        } catch (Exception e6) {
                                            fileInputStream.close();
                                            throw e6;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            z = true;
                                        }
                                    } catch (Exception e7) {
                                        file.delete();
                                        file3.delete();
                                        throw e7;
                                    }
                                }
                            }
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            ur2 ur22 = ur2.INSTANCE;
                        }
                    }
                }
            }
            try {
                byte[] g = g(m);
                if (g != null) {
                    MovieEntity decode2 = MovieEntity.ADAPTER.decode(g);
                    k21.e(decode2, "MovieEntity.ADAPTER.decode(it)");
                    return new SVGAVideoEntity(decode2, new File(str));
                }
            } catch (Exception e9) {
                e9.printStackTrace();
                ur2 ur23 = ur2.INSTANCE;
            }
        }
        return null;
        if (!z3) {
            byteArrayInputStream.close();
        }
        throw th4;
        if (!z2) {
            byteArrayOutputStream.close();
        }
        throw th2;
        if (!z) {
            fileInputStream.close();
        }
        throw th;
        return null;
        if (!z) {
            fileInputStream2.close();
        }
        throw th3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|19|22|23) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:50|51|52|55|56) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:61|62|63|66|67) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00c6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x00d8 */
    private final SVGAVideoEntity l(String str) {
        boolean z;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z2;
        Throwable th2;
        FileInputStream fileInputStream2;
        Throwable th3;
        synchronized (Integer.valueOf(w22.a())) {
            try {
                File file = new File(this.b.getCacheDir().getAbsolutePath() + "/" + str + "/");
                File file2 = new File(file, "movie.binary");
                if (!file2.isFile()) {
                    file2 = null;
                }
                z = false;
                if (file2 != null) {
                    fileInputStream2 = new FileInputStream(file2);
                    try {
                        MovieEntity decode = MovieEntity.ADAPTER.decode(fileInputStream2);
                        k21.e(decode, "MovieEntity.ADAPTER.decode(it)");
                        SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, file);
                        fileInputStream2.close();
                        try {
                            return sVGAVideoEntity;
                        } catch (Exception e) {
                            file.delete();
                            file2.delete();
                            throw e;
                        }
                    } catch (Exception e2) {
                        fileInputStream2.close();
                        throw e2;
                    } catch (Throwable th4) {
                        th3 = th4;
                        z = true;
                    }
                } else {
                    File file3 = new File(file, "movie.spec");
                    if (!file3.isFile()) {
                        file3 = null;
                    }
                    if (file3 != null) {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, 2048);
                                    if (read == -1) {
                                        SVGAVideoEntity sVGAVideoEntity2 = new SVGAVideoEntity(new JSONObject(byteArrayOutputStream.toString()), file);
                                        byteArrayOutputStream.close();
                                        fileInputStream.close();
                                        try {
                                            return sVGAVideoEntity2;
                                        } catch (Exception e3) {
                                            file.delete();
                                            file3.delete();
                                            throw e3;
                                        }
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                }
                            } catch (Exception e4) {
                                byteArrayOutputStream.close();
                                throw e4;
                            } catch (Throwable th5) {
                                th2 = th5;
                                z2 = true;
                            }
                        } catch (Exception e5) {
                            fileInputStream.close();
                            throw e5;
                        } catch (Throwable th6) {
                            th = th6;
                            z = true;
                        }
                    }
                    return null;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                ur2 ur2 = ur2.INSTANCE;
            }
        }
        if (!z2) {
            byteArrayOutputStream.close();
        }
        throw th2;
        if (!z) {
            fileInputStream.close();
        }
        throw th;
        if (!z) {
            fileInputStream2.close();
        }
        throw th3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0023 */
    private final byte[] m(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr, 0, 2048);
                    if (read <= 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e) {
                byteArrayOutputStream.close();
                throw e;
            } catch (Throwable th) {
                if (1 == 0) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|25|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:36|37|38|41|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:47|48|49|52|53) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0085 */
    private final void n(InputStream inputStream, String str) {
        Throwable th;
        boolean z;
        Throwable th2;
        FileOutputStream fileOutputStream;
        boolean z2;
        Throwable th3;
        File d = d(str);
        d.mkdirs();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            boolean z3 = false;
            try {
                ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            ur2 ur2 = ur2.INSTANCE;
                            zipInputStream.close();
                            bufferedInputStream.close();
                            return;
                        } else if (!(StringsKt__StringsKt.Q(nextEntry.getName(), "/", false, 2, null))) {
                            fileOutputStream = new FileOutputStream(new File(d, nextEntry.getName()));
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                ur2 ur22 = ur2.INSTANCE;
                                fileOutputStream.close();
                                zipInputStream.closeEntry();
                            } catch (Exception e) {
                                fileOutputStream.close();
                                throw e;
                            } catch (Throwable th4) {
                                th3 = th4;
                                z2 = true;
                            }
                        }
                    } catch (Exception e2) {
                        zipInputStream.close();
                        throw e2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        z = true;
                    }
                }
                if (!z) {
                    zipInputStream.close();
                }
                throw th2;
                if (!z3) {
                    bufferedInputStream.close();
                }
                throw th;
                if (!z2) {
                    fileOutputStream.close();
                }
                throw th3;
            } catch (Exception e3) {
                bufferedInputStream.close();
                throw e3;
            } catch (Throwable th6) {
                th = th6;
                z3 = true;
            }
        } catch (Exception unused) {
            d.delete();
        }
    }

    public final void i(@NotNull InputStream inputStream, @NotNull String str, @NotNull ParseCompletion parseCompletion, boolean z) {
        k21.j(inputStream, "inputStream");
        k21.j(str, "cacheKey");
        k21.j(parseCompletion, WXBridgeManager.METHOD_CALLBACK);
        new Thread(new SVGAParser$parse$5(this, inputStream, str, z, parseCompletion)).start();
    }

    public final void j(@NotNull String str, @NotNull ParseCompletion parseCompletion) {
        k21.j(str, "assetsName");
        k21.j(parseCompletion, WXBridgeManager.METHOD_CALLBACK);
        try {
            InputStream open = this.b.getAssets().open(str);
            if (open != null) {
                i(open, e("file:///assets/" + str), parseCompletion, true);
            }
        } catch (Exception unused) {
        }
    }

    public final void k(@NotNull URL url, @NotNull ParseCompletion parseCompletion) {
        SVGAVideoEntity l;
        k21.j(url, "url");
        k21.j(parseCompletion, WXBridgeManager.METHOD_CALLBACK);
        if (!d(f(url)).exists() || (l = l(f(url))) == null) {
            this.a.b(url, new SVGAParser$parse$3(this, url, parseCompletion), new SVGAParser$parse$4(this, parseCompletion));
        } else {
            new Handler(this.b.getMainLooper()).post(new SVGAParser$parse$$inlined$let$lambda$1(l, this, parseCompletion));
        }
    }
}

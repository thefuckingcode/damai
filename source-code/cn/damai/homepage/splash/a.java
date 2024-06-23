package cn.damai.homepage.splash;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import tb.d20;
import tb.xf2;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WELCOME_LOCAL_CHILE_PATH = "damai/welcome";

    public static File a(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-645393311")) {
            return (File) ipChange.ipc$dispatch("-645393311", new Object[]{str});
        }
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile().exists()) {
                cn.damai.common.util.a.e(file.getParentFile());
            }
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    private static String b(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895380090")) {
            return (String) ipChange.ipc$dispatch("1895380090", new Object[]{context, str});
        }
        return String.format("%s/%s/%s.dm", context.getCacheDir().getPath(), WELCOME_LOCAL_CHILE_PATH, xf2.f(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b3 A[SYNTHETIC, Splitter:B:60:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bb A[Catch:{ IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    public static void c(Context context, String str, String str2) {
        Throwable th;
        InputStream inputStream;
        Exception e;
        OutOfMemoryError e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1882641768")) {
            ipChange.ipc$dispatch("1882641768", new Object[]{context, str, str2});
        } else if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                URLConnection openConnection = new URL(str).openConnection();
                openConnection.setReadTimeout(6000);
                inputStream = openConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        File a = a(b(context, str));
                        if (!a.exists()) {
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        } else {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                                d20.A0(str2);
                                d20.B0(str);
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e4) {
                                e = e4;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                            } catch (OutOfMemoryError e5) {
                                e2 = e5;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    e2.printStackTrace();
                                    if (fileOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (OutOfMemoryError e8) {
                        e2 = e8;
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e10) {
                e = e10;
                inputStream = null;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (OutOfMemoryError e11) {
                e2 = e11;
                inputStream = null;
                e2.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        }
    }
}

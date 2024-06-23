package com.taobao.monitor.network;

import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import tb.i20;
import tb.t91;
import tb.wh1;
import tb.xs1;

/* compiled from: Taobao */
public class UploadStorage {
    private static volatile UploadStorage c;
    private String a;
    private UploadLifecycle b;

    /* compiled from: Taobao */
    public interface UploadLifecycle {
        String onDataLoaded(File file, String str);

        void onEnd();

        void onSend(String str, String str2);

        void onStart(boolean z);
    }

    private UploadStorage() {
    }

    public static UploadStorage a() {
        if (c == null) {
            synchronized (UploadStorage.class) {
                if (c == null) {
                    c = new UploadStorage();
                }
            }
        }
        return c;
    }

    private String b(File file) {
        String name = file.getName();
        if (TextUtils.isEmpty(name)) {
            return this.a + "/error";
        }
        return this.a + "/" + name.split(JSMethod.NOT_SET)[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046 A[SYNTHETIC, Splitter:B:28:0x0046] */
    private String c(File file) throws Exception {
        Throwable th;
        IOException e;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (sb.length() > 0) {
                            sb.append(StringUtils.LF);
                        }
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(UploadLifecycle uploadLifecycle) {
        this.b = uploadLifecycle;
    }

    public void f(boolean z) {
        UploadLifecycle uploadLifecycle = this.b;
        if (uploadLifecycle != null) {
            uploadLifecycle.onStart(z);
        }
        File d = xs1.d();
        if (!d.exists() || !d.isDirectory()) {
            UploadLifecycle uploadLifecycle2 = this.b;
            if (uploadLifecycle2 != null) {
                uploadLifecycle2.onEnd();
                return;
            }
            return;
        }
        File[] listFiles = d.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            UploadLifecycle uploadLifecycle3 = this.b;
            if (uploadLifecycle3 != null) {
                uploadLifecycle3.onEnd();
                return;
            }
            return;
        }
        for (File file : listFiles) {
            t91.a("UploadStorage", "开始上传文件：", file.getName());
            try {
                String c2 = c(file);
                file.delete();
                UploadLifecycle uploadLifecycle4 = this.b;
                if (uploadLifecycle4 != null) {
                    c2 = uploadLifecycle4.onDataLoaded(file, c2);
                }
                String b2 = b(file);
                wh1.b().send(b2, c2);
                UploadLifecycle uploadLifecycle5 = this.b;
                if (uploadLifecycle5 != null) {
                    uploadLifecycle5.onSend(b2, c2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (z) {
                    file.delete();
                    i20.a("UploadStorage", "上传文件失败：", file.getName());
                }
            }
        }
        UploadLifecycle uploadLifecycle6 = this.b;
        if (uploadLifecycle6 != null) {
            uploadLifecycle6.onEnd();
        }
    }
}

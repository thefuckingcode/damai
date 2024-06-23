package tb;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class vh0 {
    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[SYNTHETIC, Splitter:B:21:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046 A[SYNTHETIC, Splitter:B:28:0x0046] */
    public static String c(String str) {
        Throwable th;
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(str));
            try {
                char[] cArr = new char[100];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = inputStreamReader2.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
                String sb2 = sb.toString();
                try {
                    inputStreamReader2.close();
                } catch (Exception e) {
                    Logger.h("", e, new Object[0]);
                }
                return sb2;
            } catch (Exception unused) {
                inputStreamReader = inputStreamReader2;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e2) {
                        Logger.h("", e2, new Object[0]);
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = inputStreamReader2;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e3) {
                        Logger.h("", e3, new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            if (inputStreamReader != null) {
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (inputStreamReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043 A[SYNTHETIC, Splitter:B:29:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004f A[SYNTHETIC, Splitter:B:34:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005d A[SYNTHETIC, Splitter:B:41:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0069 A[SYNTHETIC, Splitter:B:46:0x0069] */
    public static boolean d(String str, String str2) {
        Throwable th;
        FileWriter fileWriter;
        Exception e;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            fileWriter = new FileWriter(new File(str));
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (Exception e2) {
                e = e2;
                try {
                    Logger.h("", e, new Object[0]);
                    if (bufferedWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    throw th;
                }
            }
            try {
                bufferedWriter.write(str2);
                bufferedWriter.flush();
                try {
                    bufferedWriter.close();
                } catch (Exception e3) {
                    Logger.h("", e3, new Object[0]);
                }
                try {
                    fileWriter.close();
                } catch (Exception e4) {
                    Logger.h("", e4, new Object[0]);
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                bufferedWriter2 = bufferedWriter;
                Logger.h("", e, new Object[0]);
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileWriter = null;
            Logger.h("", e, new Object[0]);
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e7) {
                    Logger.h("", e7, new Object[0]);
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e8) {
                    Logger.h("", e8, new Object[0]);
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileWriter = null;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e9) {
                    Logger.h("", e9, new Object[0]);
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e10) {
                    Logger.h("", e10, new Object[0]);
                }
            }
            throw th;
        }
    }
}

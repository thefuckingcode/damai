package com.ta.audid.utils;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean checkFileExistOnly(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new File(str).exists();
            }
            return false;
        } catch (Exception e) {
            UtdidLogger.se(TAG, e, new Object[0]);
            return false;
        }
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return deleteFile(str);
        }
        return deleteDirectory(str);
    }

    private static boolean deleteDirectory(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].isFile()) {
                if (listFiles[i].isDirectory() && !(z = deleteDirectory(listFiles[i].getAbsolutePath()))) {
                    break;
                }
            } else {
                z = deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        if (!z) {
            return false;
        }
        return file.delete();
    }

    private static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return file.delete();
    }

    public static void isDirExist(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (!file.exists()) {
                    UtdidLogger.sd(TAG, "mkdirs path", str, "created", Boolean.valueOf(file.mkdirs()));
                    return;
                }
                UtdidLogger.sd(TAG, "path exists", str);
            }
        } catch (Exception e) {
            UtdidLogger.se(TAG, e, new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043 A[SYNTHETIC, Splitter:B:24:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    public static String readFile(String str) {
        Throwable th;
        Exception e;
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(str));
            try {
                char[] cArr = new char[100];
                StringBuilder sb = new StringBuilder("");
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
                } catch (Exception e2) {
                    UtdidLogger.se(TAG, e2, new Object[0]);
                }
                return sb2;
            } catch (Exception e3) {
                e = e3;
                inputStreamReader = inputStreamReader2;
                try {
                    UtdidLogger.se(TAG, e, new Object[0]);
                    if (inputStreamReader != null) {
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = inputStreamReader2;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e4) {
                        UtdidLogger.se(TAG, e4, new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            UtdidLogger.se(TAG, e, new Object[0]);
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e6) {
                    UtdidLogger.se(TAG, e6, new Object[0]);
                }
            }
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043 A[SYNTHETIC, Splitter:B:29:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004f A[SYNTHETIC, Splitter:B:34:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005d A[SYNTHETIC, Splitter:B:41:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0069 A[SYNTHETIC, Splitter:B:46:0x0069] */
    public static boolean saveFile(String str, String str2) {
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
                    UtdidLogger.se(TAG, e, new Object[0]);
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
                    UtdidLogger.se(TAG, e3, new Object[0]);
                }
                try {
                    fileWriter.close();
                } catch (Exception e4) {
                    UtdidLogger.se(TAG, e4, new Object[0]);
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                bufferedWriter2 = bufferedWriter;
                UtdidLogger.se(TAG, e, new Object[0]);
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
            UtdidLogger.se(TAG, e, new Object[0]);
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e7) {
                    UtdidLogger.se(TAG, e7, new Object[0]);
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e8) {
                    UtdidLogger.se(TAG, e8, new Object[0]);
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
                    UtdidLogger.se(TAG, e9, new Object[0]);
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e10) {
                    UtdidLogger.se(TAG, e10, new Object[0]);
                }
            }
            throw th;
        }
    }
}

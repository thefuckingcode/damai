package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class FileUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void closeQuietly(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289699557")) {
            ipChange.ipc$dispatch("289699557", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c A[SYNTHETIC, Splitter:B:47:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094 A[Catch:{ IOException -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00af A[SYNTHETIC, Splitter:B:63:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b7 A[Catch:{ IOException -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    public static int copyFile(File file, File file2) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        FileNotFoundException e;
        IOException e2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1731755137")) {
            return ((Integer) ipChange.ipc$dispatch("-1731755137", new Object[]{file, file2})).intValue();
        } else if (!file.isFile() || !file2.exists()) {
            return -1;
        } else {
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream == null) {
                        return -1;
                    }
                    bufferedOutputStream.close();
                    return -1;
                } catch (IOException e4) {
                    e2 = e4;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        e2.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return -1;
                            }
                        }
                        if (bufferedOutputStream == null) {
                            return -1;
                        }
                        bufferedOutputStream.close();
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    if (file.length() != file2.length()) {
                        deleteFile(file2);
                        i = -1;
                    }
                    try {
                        bufferedInputStream2.close();
                        bufferedOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    return i;
                } catch (FileNotFoundException e8) {
                    e = e8;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream == null) {
                    }
                } catch (IOException e9) {
                    e2 = e9;
                    bufferedInputStream = bufferedInputStream2;
                    e2.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream == null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                bufferedOutputStream = null;
                e.printStackTrace();
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream == null) {
                }
            } catch (IOException e11) {
                e2 = e11;
                bufferedOutputStream = null;
                e2.printStackTrace();
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream == null) {
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        }
    }

    public static File creatDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995913256")) {
            return (File) ipChange.ipc$dispatch("-995913256", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        }
    }

    public static File creatFile(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930566765")) {
            return (File) ipChange.ipc$dispatch("1930566765", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            File file = new File(str);
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
    }

    public static void delete(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105662085")) {
            ipChange.ipc$dispatch("-105662085", new Object[]{file});
        } else if (file != null) {
            if (!file.isFile()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            delete(file2);
                        } else {
                            file2.delete();
                        }
                    }
                    if (!file.delete()) {
                        ((ILog) Dsl.getService(ILog.class)).i(FileUtils.class.getSimpleName(), "文件删除失败");
                    }
                }
            } else if (!file.delete()) {
                ((ILog) Dsl.getService(ILog.class)).i(FileUtils.class.getSimpleName(), "文件删除失败");
            }
        }
    }

    public static boolean deleteDirectory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-876287769")) {
            return ((Boolean) ipChange.ipc$dispatch("-876287769", new Object[]{str})).booleanValue();
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            Boolean bool = Boolean.TRUE;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (!listFiles[i].isFile()) {
                        bool = Boolean.valueOf(deleteDirectory(listFiles[i].getAbsolutePath()));
                        if (!bool.booleanValue()) {
                            break;
                        }
                    } else {
                        bool = Boolean.valueOf(deleteFile(listFiles[i].getAbsolutePath()));
                        if (!bool.booleanValue()) {
                            break;
                        }
                    }
                }
            }
            if (bool.booleanValue() && file.delete()) {
                return true;
            }
        }
        return false;
    }

    public static boolean deleteFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885434422")) {
            return ((Boolean) ipChange.ipc$dispatch("885434422", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static boolean isFileExist(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-28899464")) {
            return new File(str).exists();
        }
        return ((Boolean) ipChange.ipc$dispatch("-28899464", new Object[]{str})).booleanValue();
    }

    public static boolean isFileExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870178971")) {
            return ((Boolean) ipChange.ipc$dispatch("870178971", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        return file.exists() && file.isFile() && file.length() != 0;
    }

    public static boolean isFolderExist(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866654230")) {
            return ((Boolean) ipChange.ipc$dispatch("-866654230", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[SYNTHETIC, Splitter:B:28:0x0063] */
    public static String readFile(Context context, String str) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1287624085")) {
            return (String) ipChange.ipc$dispatch("-1287624085", new Object[]{context, str});
        }
        StringBuffer stringBuffer = new StringBuffer("");
        File file = new File(str);
        if (file.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                            }
                            throw th;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Exception e4) {
                bufferedReader = null;
                e = e4;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                return stringBuffer.toString();
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b A[SYNTHETIC, Splitter:B:28:0x005b] */
    public static String readFromFile(File file) {
        Throwable th;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530593302")) {
            return (String) ipChange.ipc$dispatch("530593302", new Object[]{file});
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                            }
                            return stringBuffer.toString();
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
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return stringBuffer.toString();
            }
        }
        return stringBuffer.toString();
    }

    public static boolean renameFile(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296753677")) {
            return ((Boolean) ipChange.ipc$dispatch("296753677", new Object[]{str, str2})).booleanValue();
        } else if (str == null || str2 == null) {
            return false;
        } else {
            return new File(str).renameTo(new File(str2));
        }
    }

    public static boolean write2File(File file, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506649189")) {
            return ((Boolean) ipChange.ipc$dispatch("1506649189", new Object[]{file, str})).booleanValue();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[SYNTHETIC, Splitter:B:30:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083 A[Catch:{ Exception -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008f A[SYNTHETIC, Splitter:B:40:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[Catch:{ Exception -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    public static File writeFromInput(String str, String str2, InputStream inputStream, int i) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150486757")) {
            return (File) ipChange.ipc$dispatch("-150486757", new Object[]{str, str2, inputStream, Integer.valueOf(i)});
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            creatDir(str);
            File creatFile = creatFile(str + str2);
            fileOutputStream = new FileOutputStream(creatFile);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (creatFile.length() == ((long) i)) {
                    try {
                        inputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return creatFile;
                }
                deleteFile(creatFile);
                throw new Exception();
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    if (fileOutputStream != null) {
                        return null;
                    }
                    fileOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    throw th;
                }
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean deleteFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111882723")) {
            return ((Boolean) ipChange.ipc$dispatch("1111882723", new Object[]{file})).booleanValue();
        }
        Boolean bool = Boolean.FALSE;
        if (file.isFile() && file.exists()) {
            bool = Boolean.valueOf(file.delete());
        }
        return bool.booleanValue();
    }
}

package cn.damai.commonbusiness.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
public class b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CALENDAR_CACHE_FILE_NAME = "dm_calender_cache";
    private static b a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0066 A[SYNTHETIC, Splitter:B:38:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0070 A[SYNTHETIC, Splitter:B:43:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007a A[SYNTHETIC, Splitter:B:48:0x007a] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static void a(InputStream inputStream, File file) throws IOException {
        Throwable th;
        ?? r1;
        IOException e;
        FileChannel fileChannel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009658130")) {
            ipChange.ipc$dispatch("1009658130", new Object[]{inputStream, file});
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            ?? fileOutputStream = new FileOutputStream(file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        channel.write(ByteBuffer.wrap(bArr, 0, read));
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                inputStream.close();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                e = e5;
                fileChannel = null;
                fileChannel2 = fileOutputStream;
                try {
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    r1 = fileChannel2;
                    fileChannel2 = fileChannel;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r1 = fileOutputStream;
                if (inputStream != null) {
                }
                if (fileChannel2 != null) {
                }
                if (r1 != 0) {
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            fileChannel = null;
            throw new IOException(e);
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            if (inputStream != null) {
            }
            if (fileChannel2 != null) {
            }
            if (r1 != 0) {
            }
            throw th;
        }
    }

    public static b b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794002299")) {
            return (b) ipChange.ipc$dispatch("1794002299", new Object[0]);
        }
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static void e(File file, String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042713471")) {
            ipChange.ipc$dispatch("-2042713471", new Object[]{file, str});
            return;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            File file3 = new File(str + File.separator + zipEntry.getName());
            if (!zipEntry.isDirectory()) {
                if (!file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                }
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
            } else if (!file3.exists()) {
                file3.mkdirs();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084 A[SYNTHETIC, Splitter:B:42:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c A[Catch:{ IOException -> 0x0088 }] */
    public String c(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255340366")) {
            return (String) ipChange.ipc$dispatch("1255340366", new Object[]{this, context, str});
        }
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            BufferedReader bufferedReader2 = null;
            try {
                if (!new File(context.getFilesDir(), str).exists()) {
                    return null;
                }
                fileInputStream = context.openFileInput(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    try {
                        new String();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        bufferedReader.close();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return sb.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = null;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return sb.toString();
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e6) {
                bufferedReader = null;
                e = e6;
                fileInputStream = null;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                if (fileInputStream != null) {
                }
                return sb.toString();
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                if (bufferedReader2 != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0066 A[SYNTHETIC, Splitter:B:37:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006e A[Catch:{ IOException -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    public void d(Context context, String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94404749")) {
            ipChange.ipc$dispatch("-94404749", new Object[]{this, context, str, str2});
        } else if (!TextUtils.isEmpty(str2) && context != null) {
            BufferedWriter bufferedWriter = null;
            try {
                fileOutputStream = context.openFileOutput(str, 0);
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    try {
                        bufferedWriter2.write(str2);
                        try {
                            bufferedWriter2.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        try {
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream = null;
                e.printStackTrace();
                if (bufferedWriter != null) {
                }
                if (fileOutputStream != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                if (bufferedWriter != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
    }
}

package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;

/* compiled from: Taobao */
public abstract class s {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.w("StreamUtil", "close IOException");
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
                HMSLog.w("StreamUtil", "close HttpURLConnection Exception");
            }
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = inputStream.read();
        while (-1 != read) {
            byteArrayOutputStream.write(read);
            read = inputStream.read();
        }
        String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
        a((Closeable) inputStream);
        IOUtil.closeSecure((OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream2;
    }

    public static void a(File file) throws IOException {
        if (!file.exists()) {
            if (file.getParentFile() == null) {
                HMSLog.e("StreamUtil", "parent file is null.");
                throw new IOException("parent file is null");
            } else if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                HMSLog.e("StreamUtil", "make parent dirs failed.");
                throw new IOException("make parent dirs failed");
            } else if (!file.createNewFile()) {
                HMSLog.e("StreamUtil", "create file failed.");
                throw new IOException("create file failed");
            }
        }
    }

    public static String a(String str) {
        Throwable th;
        InputStreamReader inputStreamReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        HMSLog.e("StreamUtil", "file not exist.");
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        return sb.toString();
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        try {
                            HMSLog.e("StreamUtil", "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        throw th;
                    }
                }
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader2);
            } catch (FileNotFoundException unused3) {
                HMSLog.e("StreamUtil", "file not exist.");
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader);
                return sb.toString();
            } catch (IOException unused4) {
                HMSLog.e("StreamUtil", "read value IOException.");
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader);
                return sb.toString();
            }
        } catch (FileNotFoundException unused5) {
            inputStreamReader = null;
            HMSLog.e("StreamUtil", "file not exist.");
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            return sb.toString();
        } catch (IOException unused6) {
            inputStreamReader = null;
            HMSLog.e("StreamUtil", "read value IOException.");
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            return sb.toString();
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            throw th;
        }
        return sb.toString();
    }
}

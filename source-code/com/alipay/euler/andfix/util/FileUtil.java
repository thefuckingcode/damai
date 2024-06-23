package com.alipay.euler.andfix.util;

import com.alipay.euler.andfix.log.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import tb.jl1;

/* compiled from: Taobao */
public class FileUtil {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3  */
    public static void copyFile(File file, File file2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        IOException e;
        FileChannel fileChannel2;
        Throwable th2;
        FileChannel fileChannel3 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel3 = new FileOutputStream(file2).getChannel();
                channel.transferTo(0, channel.size(), fileChannel3);
                Log.i("FileUtil", "copyFile(src=" + file + ", dest=" + file2 + jl1.BRACKET_END_STR);
                channel.close();
                if (fileChannel3 != null) {
                    fileChannel3.close();
                }
            } catch (IOException e2) {
                e = e2;
                fileChannel2 = fileChannel3;
                fileChannel3 = channel;
                try {
                    file2.delete();
                    Log.e("FileUtil", e);
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = fileChannel2;
                    if (fileChannel3 != null) {
                        fileChannel3.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th2 = th4;
                fileChannel = fileChannel3;
                fileChannel3 = channel;
                try {
                    file2.delete();
                    Log.e("FileUtil", th2);
                    throw new IOException("Failed to copy file[src=" + file.getAbsolutePath() + ", dest=" + file2.getAbsolutePath() + jl1.ARRAY_END_STR, th2);
                } catch (Throwable th5) {
                    th = th5;
                    if (fileChannel3 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileChannel2 = null;
            file2.delete();
            Log.e("FileUtil", e);
            throw e;
        } catch (Throwable th6) {
            th2 = th6;
            fileChannel = null;
            file2.delete();
            Log.e("FileUtil", th2);
            throw new IOException("Failed to copy file[src=" + file.getAbsolutePath() + ", dest=" + file2.getAbsolutePath() + jl1.ARRAY_END_STR, th2);
        }
    }

    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }
}

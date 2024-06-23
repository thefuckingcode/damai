package com.taobao.android.tlog.uploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* compiled from: Taobao */
public class TLogFileUtils {
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0070  */
    public static File copyFile(File file, File file2) throws Exception {
        Throwable th;
        FileChannel fileChannel;
        Exception e;
        int i = 0;
        while (true) {
            FileChannel fileChannel2 = null;
            if (i >= 3) {
                return null;
            }
            try {
                if (!file2.exists()) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file2.createNewFile();
                }
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    channel.transferTo(0, channel.size(), fileChannel2);
                    channel.close();
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    return file2;
                } catch (Exception e2) {
                    fileChannel2 = channel;
                    e = e2;
                    fileChannel = fileChannel2;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = fileChannel2;
                    fileChannel2 = channel;
                    if (fileChannel2 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileChannel = null;
                try {
                    file2.delete();
                    if (i != 2) {
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        i++;
                    } else {
                        throw e;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileChannel2 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
            i++;
        }
    }
}

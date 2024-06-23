package android.taobao.windvane.file;

import android.taobao.windvane.util.TaoLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: Taobao */
public class FileAccesser {
    public static boolean deleteFile(String str) {
        if (str == null) {
            return false;
        }
        return deleteFile(new File(str), true);
    }

    public static boolean exists(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|11|12|13|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0040 A[SYNTHETIC, Splitter:B:29:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0047 A[SYNTHETIC, Splitter:B:33:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x004e A[SYNTHETIC, Splitter:B:39:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0055 A[SYNTHETIC, Splitter:B:43:0x0055] */
    public static byte[] read(File file) {
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        Throwable th;
        try {
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Exception unused) {
                fileChannel = null;
                try {
                    TaoLog.w("FileAccesser", "read loacl file failed");
                    if (fileInputStream != null) {
                    }
                    if (fileChannel != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                if (fileInputStream != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
            try {
                ByteBuffer allocate = ByteBuffer.allocate((int) fileChannel.size());
                fileChannel.read(allocate);
                byte[] array = allocate.array();
                fileInputStream.close();
                fileChannel.close();
                return array;
            } catch (Exception unused2) {
                TaoLog.w("FileAccesser", "read loacl file failed");
                if (fileInputStream != null) {
                }
                if (fileChannel != null) {
                }
                return null;
            }
        } catch (Exception unused3) {
            fileChannel = null;
            fileInputStream = null;
            TaoLog.w("FileAccesser", "read loacl file failed");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused5) {
                }
            }
            return null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            fileChannel = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused6) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused7) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x004e A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0061 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0069 A[SYNTHETIC, Splitter:B:40:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0073 A[SYNTHETIC, Splitter:B:45:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007f A[SYNTHETIC, Splitter:B:52:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0089 A[SYNTHETIC, Splitter:B:57:0x0089] */
    public static boolean write(File file, ByteBuffer byteBuffer) throws NotEnoughSpace {
        Throwable th;
        FileChannel fileChannel;
        Exception e;
        String message;
        FileOutputStream fileOutputStream = null;
        r0 = null;
        FileChannel fileChannel2 = null;
        fileOutputStream = null;
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    return false;
                }
                parentFile.mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileChannel2 = fileOutputStream2.getChannel();
                byteBuffer.position(0);
                fileChannel2.write(byteBuffer);
                fileChannel2.force(true);
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    fileChannel2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                fileChannel = fileChannel2;
                fileOutputStream = fileOutputStream2;
                try {
                    message = e.getMessage();
                    if (message != null) {
                        if (message.contains("ENOSPC")) {
                            throw new NotEnoughSpace("not enouth space in flash");
                        }
                    }
                    if (file != null) {
                        file.delete();
                    }
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = fileChannel2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            fileChannel = null;
            message = e.getMessage();
            if (message != null) {
            }
            if (file != null) {
            }
            e.printStackTrace();
            if (fileOutputStream != null) {
            }
            if (fileChannel != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            if (fileOutputStream != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }

    public static boolean deleteFile(File file) {
        return deleteFile(file, true);
    }

    public static boolean deleteFile(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles();
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            deleteFile(file2, true);
                        } else {
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
            }
            if (z) {
                try {
                    return file.delete();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return false;
    }

    public static byte[] read(String str) {
        if (str == null) {
            return null;
        }
        return read(new File(str));
    }

    public static boolean write(String str, ByteBuffer byteBuffer) throws NotEnoughSpace {
        if (str == null) {
            return false;
        }
        return write(new File(str), byteBuffer);
    }
}

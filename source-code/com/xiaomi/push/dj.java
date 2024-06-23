package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class dj implements LoggerInterface {
    private static volatile dj a;

    /* renamed from: a  reason: collision with other field name */
    public static String f212a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private static final SimpleDateFormat f213a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private static List<Pair<String, Throwable>> f214a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private Context f215a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f216a;
    private String b;
    private String c = "";

    private dj(Context context) {
        this.f215a = context;
        if (context.getApplicationContext() != null) {
            this.f215a = context.getApplicationContext();
        }
        this.b = this.f215a.getPackageName() + "-" + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f216a = new Handler(handlerThread.getLooper());
    }

    public static dj a(Context context) {
        if (a == null) {
            synchronized (dj.class) {
                if (a == null) {
                    a = new dj(context);
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014b A[SYNTHETIC, Splitter:B:66:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0177 A[SYNTHETIC, Splitter:B:83:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0195 A[SYNTHETIC, Splitter:B:95:0x0195] */
    private void a() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        Throwable th;
        Exception e;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            if (TextUtils.isEmpty(this.c) && (externalFilesDir = this.f215a.getExternalFilesDir(null)) != null) {
                this.c = externalFilesDir.getAbsolutePath() + "";
            }
            File file = new File(this.c + f212a);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.b, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e2) {
                e = e2;
                fileLock = null;
                try {
                    Log.e(this.b, "", e);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            Log.e(this.b, "", e3);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            Log.e(this.b, "", e4);
                        }
                    }
                    if (randomAccessFile == null) {
                        randomAccessFile.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e5) {
                            Log.e(this.b, "", e5);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            Log.e(this.b, "", e6);
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e7) {
                            Log.e(this.b, "", e7);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                if (bufferedWriter != null) {
                }
                fileLock.release();
                if (randomAccessFile != null) {
                }
                throw th;
            }
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                while (!f214a.isEmpty()) {
                    try {
                        Pair<String, Throwable> remove = f214a.remove(0);
                        String str = (String) remove.first;
                        if (remove.second != null) {
                            str = (str + StringUtils.LF) + Log.getStackTraceString((Throwable) remove.second);
                        }
                        bufferedWriter2.write(str + StringUtils.LF);
                    } catch (Exception e8) {
                        e = e8;
                        bufferedWriter = bufferedWriter2;
                        Log.e(this.b, "", e);
                        if (bufferedWriter != null) {
                        }
                        fileLock.release();
                        if (randomAccessFile == null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                        }
                        fileLock.release();
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                }
                bufferedWriter2.flush();
                bufferedWriter2.close();
                File file3 = new File(file, "log1.txt");
                if (file3.length() >= 1048576) {
                    File file4 = new File(file, "log0.txt");
                    if (file4.exists() && file4.isFile()) {
                        file4.delete();
                    }
                    file3.renameTo(file4);
                }
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e9) {
                        Log.e(this.b, "", e9);
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e10) {
                    Log.e(this.b, "", e10);
                }
            } catch (Exception e11) {
                e = e11;
                Log.e(this.b, "", e);
                if (bufferedWriter != null) {
                }
                fileLock.release();
                if (randomAccessFile == null) {
                }
            }
        } catch (Exception e12) {
            e = e12;
            fileLock = null;
            randomAccessFile = null;
            Log.e(this.b, "", e);
            if (bufferedWriter != null) {
            }
            fileLock.release();
            if (randomAccessFile == null) {
            }
        } catch (Throwable th5) {
            th = th5;
            fileLock = null;
            randomAccessFile = null;
            if (bufferedWriter != null) {
            }
            fileLock.release();
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        this.f216a.post(new dk(this, str, th));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.b = str;
    }
}

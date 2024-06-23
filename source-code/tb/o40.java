package tb;

import android.os.Environment;
import com.taobao.downloader.download.IDownloader;
import com.taobao.downloader.download.IListener;
import com.taobao.downloader.download.protocol.DLConnection;
import com.taobao.downloader.download.protocol.DLInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.fn1;

/* compiled from: Taobao */
public class o40 implements IDownloader {
    public static final int ST_CANCELED = 2;
    public static final int ST_PAUSED = 1;
    private f11 a;
    private fn1 b;
    private int c;

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b0 A[SYNTHETIC, Splitter:B:123:0x01b0] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01d1 A[SYNTHETIC, Splitter:B:137:0x01d1] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01de A[SYNTHETIC, Splitter:B:142:0x01de] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01eb A[SYNTHETIC, Splitter:B:147:0x01eb] */
    private boolean a() {
        DLConnection dLConnection;
        DLInputStream dLInputStream;
        Throwable th;
        IOException e;
        RandomAccessFile randomAccessFile = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            dLConnection = b();
            try {
                this.b.f.e += System.currentTimeMillis() - currentTimeMillis;
                if (dLConnection == null) {
                    if (dLConnection != null) {
                        try {
                            dLConnection.disConnect();
                        } catch (Throwable th2) {
                            m90.d("Downloader", "on exception", th2, new Object[0]);
                        }
                    }
                    return false;
                }
                try {
                    dLInputStream = dLConnection.getInputStream();
                    if (dLInputStream != null) {
                        try {
                            randomAccessFile = this.a.c();
                            if (randomAccessFile != null) {
                                try {
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    boolean f = f(dLInputStream, randomAccessFile);
                                    this.b.f.f += System.currentTimeMillis() - currentTimeMillis2;
                                    if (!f) {
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException e2) {
                                                m90.d("Downloader", "on exception", e2, new Object[0]);
                                            }
                                        }
                                        if (dLInputStream != null) {
                                            try {
                                                dLInputStream.close();
                                            } catch (Throwable th3) {
                                                m90.d("Downloader", "on exception", th3, new Object[0]);
                                            }
                                        }
                                        try {
                                            dLConnection.disConnect();
                                        } catch (Throwable th4) {
                                            m90.d("Downloader", "on exception", th4, new Object[0]);
                                        }
                                        return false;
                                    } else if (this.a.e()) {
                                        f11 f11 = this.a;
                                        if (xh0.e(f11.d, f11.e)) {
                                            this.b.a = 10;
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e3) {
                                                    m90.d("Downloader", "on exception", e3, new Object[0]);
                                                }
                                            }
                                            if (dLInputStream != null) {
                                                try {
                                                    dLInputStream.close();
                                                } catch (Throwable th5) {
                                                    m90.d("Downloader", "on exception", th5, new Object[0]);
                                                }
                                            }
                                            try {
                                                dLConnection.disConnect();
                                            } catch (Throwable th6) {
                                                m90.d("Downloader", "on exception", th6, new Object[0]);
                                            }
                                            return true;
                                        }
                                        this.b.e.a(-11, this.a.e.getParentFile().canWrite() ? 104 : 105, "rename tmp file error").e = true;
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException e4) {
                                                m90.d("Downloader", "on exception", e4, new Object[0]);
                                            }
                                        }
                                        if (dLInputStream != null) {
                                            try {
                                                dLInputStream.close();
                                            } catch (Throwable th7) {
                                                m90.d("Downloader", "on exception", th7, new Object[0]);
                                            }
                                        }
                                        try {
                                            dLConnection.disConnect();
                                        } catch (Throwable th8) {
                                            m90.d("Downloader", "on exception", th8, new Object[0]);
                                        }
                                        return false;
                                    } else {
                                        this.a.d.delete();
                                        this.b.e.a(this.a.a(), 106, "download invalid");
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException e5) {
                                                m90.d("Downloader", "on exception", e5, new Object[0]);
                                            }
                                        }
                                        if (dLInputStream != null) {
                                            try {
                                                dLInputStream.close();
                                            } catch (Throwable th9) {
                                                m90.d("Downloader", "on exception", th9, new Object[0]);
                                            }
                                        }
                                        try {
                                            dLConnection.disConnect();
                                        } catch (Throwable th10) {
                                            m90.d("Downloader", "on exception", th10, new Object[0]);
                                        }
                                        return false;
                                    }
                                } catch (Throwable th11) {
                                    th = th11;
                                    if (randomAccessFile != null) {
                                    }
                                    if (dLInputStream != null) {
                                    }
                                    if (dLConnection != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                throw new FileNotFoundException("outputStream is null");
                            }
                        } catch (FileNotFoundException e6) {
                            m90.d("Downloader", "getRandomAccessFile", e6, new Object[0]);
                            this.b.e.a(-11, 103, dLConnection.getErrorMsg()).e = true;
                            if (0 != 0) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e7) {
                                    m90.d("Downloader", "on exception", e7, new Object[0]);
                                }
                            }
                            if (dLInputStream != null) {
                                dLInputStream.close();
                            }
                        } catch (Throwable th12) {
                            m90.d("Downloader", "on exception", th12, new Object[0]);
                        }
                    } else {
                        try {
                            throw new IOException("inputstream is null");
                        } catch (IOException e8) {
                            e = e8;
                            m90.d("Downloader", "conn.getinputstream exception", e, new Object[0]);
                            this.b.e.a(-12, 205, dLConnection.getErrorMsg()).c = true;
                            if (dLInputStream != null) {
                            }
                            try {
                                dLConnection.disConnect();
                            } catch (Throwable th13) {
                                m90.d("Downloader", "on exception", th13, new Object[0]);
                            }
                            return false;
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                    dLInputStream = null;
                    m90.d("Downloader", "conn.getinputstream exception", e, new Object[0]);
                    this.b.e.a(-12, 205, dLConnection.getErrorMsg()).c = true;
                    if (dLInputStream != null) {
                        try {
                            dLInputStream.close();
                        } catch (Throwable th14) {
                            m90.d("Downloader", "on exception", th14, new Object[0]);
                        }
                    }
                    dLConnection.disConnect();
                    return false;
                }
                return false;
                dLConnection.disConnect();
                return false;
            } catch (Throwable th15) {
                th = th15;
                dLInputStream = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e10) {
                        m90.d("Downloader", "on exception", e10, new Object[0]);
                    }
                }
                if (dLInputStream != null) {
                    try {
                        dLInputStream.close();
                    } catch (Throwable th16) {
                        m90.d("Downloader", "on exception", th16, new Object[0]);
                    }
                }
                if (dLConnection != null) {
                    try {
                        dLConnection.disConnect();
                    } catch (Throwable th17) {
                        m90.d("Downloader", "on exception", th17, new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Throwable th18) {
            th = th18;
            dLInputStream = null;
            dLConnection = null;
            if (randomAccessFile != null) {
            }
            if (dLInputStream != null) {
            }
            if (dLConnection != null) {
            }
            throw th;
        }
    }

    private DLConnection b() {
        f11 f11 = this.a;
        DLConnection b2 = hh2.b(f11.b.e, f11.a);
        try {
            f11 f112 = this.a;
            b2.openConnection(f112.c, f112.a);
            b2.addRequestProperty(HttpHeaderConstant.F_REFER, "download_" + this.a.b.f.a);
            long b3 = this.a.b();
            if (0 != b3) {
                String str = "bytes=" + b3 + "-";
                m90.g("Downloader", "getConnection", "add request property range", str);
                b2.addRequestProperty("Range", str);
                this.b.f.d = true;
            } else {
                this.b.f.d = false;
            }
            try {
                b2.connect();
                try {
                    int statusCode = b2.getStatusCode();
                    if (this.a.f(b2.getDownloadLength(), statusCode)) {
                        return b2;
                    }
                    this.b.e.a(-12, statusCode, b2.getErrorMsg()).c = true;
                    return null;
                } catch (Exception e) {
                    m90.d("Downloader", "conn.getstatuscode exception", e, new Object[0]);
                    this.b.e.a(-12, 204, b2.getErrorMsg()).c = true;
                    return null;
                }
            } catch (IOException e2) {
                m90.d("Downloader", "conn.conn exception", e2, new Object[0]);
                this.b.e.a(-12, 203, b2.getErrorMsg()).c = true;
                return null;
            }
        } catch (IOException e3) {
            m90.d("Downloader", "conn.open exception", e3, new Object[0]);
            this.b.e.a(-12, 202, b2.getErrorMsg()).c = true;
            return null;
        }
    }

    private String c(Throwable th) {
        if (!(th instanceof RuntimeException) || th.getMessage() == null || th.getMessage().length() >= 20) {
            return th.getClass().getSimpleName();
        }
        return th.getClass().getSimpleName() + ":" + th.getMessage();
    }

    private int d() {
        int i = this.c;
        if (i <= 0) {
            return 0;
        }
        if ((i & 1) == 1) {
            return 1;
        }
        if ((i & 2) != 2) {
            return 0;
        }
        if (this.a.d.exists()) {
            this.a.d.delete();
        }
        return 2;
    }

    private boolean e(long j) {
        return Environment.getExternalStorageDirectory().getFreeSpace() >= j;
    }

    private boolean f(DLInputStream dLInputStream, RandomAccessFile randomAccessFile) {
        boolean z = true;
        if (dLInputStream == null || randomAccessFile == null) {
            fn1.a aVar = this.b.e;
            StringBuilder sb = new StringBuilder();
            sb.append("savedataParam:");
            sb.append(dLInputStream == null);
            sb.append("|");
            if (randomAccessFile != null) {
                z = false;
            }
            sb.append(z);
            aVar.a(-19, 0, sb.toString());
            return false;
        }
        this.b.c = this.a.d.length();
        FileChannel channel = randomAccessFile.getChannel();
        try {
            channel.position(randomAccessFile.length());
            byte[] bArr = new byte[hh2.c()];
            while (true) {
                int d = d();
                if (d > 0) {
                    this.b.e.a(-20, d, "");
                    return false;
                }
                try {
                    int read = dLInputStream.read(bArr);
                    if (-1 == read) {
                        return true;
                    }
                    this.b.d = true;
                    try {
                        channel.write(ByteBuffer.wrap(bArr, 0, read));
                        fn1 fn1 = this.b;
                        long j = (long) read;
                        fn1.c += j;
                        fn1.f.i += j;
                        fn1.b();
                    } catch (IOException e) {
                        m90.d("Downloader", "fc.write exception", e, new Object[0]);
                        this.b.e.a(-11, 102, c(e)).e = true;
                        return false;
                    }
                } catch (Exception e2) {
                    m90.d("Downloader", "input.read exception", e2, new Object[0]);
                    this.b.e.a(-12, 201, c(e2)).d = true;
                    return false;
                }
            }
        } catch (IOException e3) {
            m90.d("Downloader", "fc.position exception", e3, new Object[0]);
            this.b.e.a(-11, 101, c(e3)).e = true;
            return false;
        }
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void cancel() {
        this.c |= 2;
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void download(lb2 lb2, IListener iListener) {
        fn1 fn1;
        this.a = new f11(lb2);
        this.b = new fn1(iListener);
        try {
            int d = d();
            if (d > 0) {
                this.b.e.a(-20, d, "");
            } else {
                try {
                    this.a.g();
                    if (this.a.d()) {
                        fn1 = this.b;
                        fn1.a = 11;
                        fn1.a(this.a);
                    } else if (this.a.e()) {
                        f11 f11 = this.a;
                        if (xh0.e(f11.d, f11.e)) {
                            this.b.a = 11;
                        } else {
                            this.b.e.a(-11, this.a.e.getParentFile().canWrite() ? 104 : 105, "rename tmp file error").e = true;
                        }
                    } else if (!e(lb2.e.b)) {
                        fn1 fn12 = this.b;
                        fn1.a aVar = fn12.e;
                        aVar.a = false;
                        aVar.f = -21;
                        f11 f112 = this.a;
                        io1 io1 = f112.b.f;
                        io1.l = 0;
                        io1.d = 0;
                        fn12.a(f112);
                        return;
                    } else {
                        a();
                        this.b.a(this.a);
                        return;
                    }
                } catch (Throwable th) {
                    this.b.e.a(-10, 0, lb2.e.a).b = true;
                    m90.d("Downloader", "prepare download exception", th, new Object[0]);
                }
            }
            fn1 = this.b;
            fn1.a(this.a);
        } catch (Throwable th2) {
            this.b.a(this.a);
            throw th2;
        }
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void pause() {
        this.c |= 1;
    }
}

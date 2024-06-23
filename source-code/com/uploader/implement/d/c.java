package com.uploader.implement.d;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.uploader.implement.a.e;
import com.uploader.implement.a.f;
import com.uploader.implement.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.message.MessageService;
import tb.f63;
import tb.h13;
import tb.m53;

/* compiled from: Taobao */
public class c implements com.uploader.implement.b.b, d, b {
    private static final AtomicInteger i = new AtomicInteger(0);
    private a a;
    private ArrayList<e> b = new ArrayList<>();
    private ArrayList<b> c = new ArrayList<>();
    private ArrayList<a> d = new ArrayList<>();
    private com.uploader.implement.b.c e;
    private Handler f;
    private final int g;
    private final com.uploader.implement.c h;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Runnable {
        final int a;
        final c b;
        final Object[] c;

        a(int i, @NonNull c cVar, Object... objArr) {
            this.a = i;
            this.b = cVar;
            this.c = objArr;
        }

        public void run() {
            switch (this.a) {
                case 1:
                    this.b.n((com.uploader.implement.b.e) this.c[0]);
                    return;
                case 2:
                    this.b.p((com.uploader.implement.b.e) this.c[0]);
                    return;
                case 3:
                    c cVar = this.b;
                    Object[] objArr = this.c;
                    cVar.k((com.uploader.implement.b.e) objArr[0], (h13) objArr[1]);
                    return;
                case 4:
                    c cVar2 = this.b;
                    Object[] objArr2 = this.c;
                    cVar2.l((com.uploader.implement.b.e) objArr2[0], (m53) objArr2[1]);
                    return;
                case 5:
                    c cVar3 = this.b;
                    Object[] objArr3 = this.c;
                    cVar3.f((com.uploader.implement.b.e) objArr3[0], ((Integer) objArr3[1]).intValue(), false);
                    return;
                case 6:
                    c cVar4 = this.b;
                    Object[] objArr4 = this.c;
                    cVar4.f((com.uploader.implement.b.e) objArr4[0], ((Integer) objArr4[1]).intValue(), true);
                    return;
                case 7:
                    c cVar5 = this.b;
                    Object[] objArr5 = this.c;
                    cVar5.m((b) objArr5[0], (e) objArr5[1], (com.uploader.implement.b.e) objArr5[2]);
                    return;
                case 8:
                    this.b.j((com.uploader.implement.b.e) this.c[0]);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b {
        final e a;
        final f63 b;
        final com.uploader.implement.b.e c;
        boolean d;
        boolean e;
        int f;
        int g;
        int h;
        int i;
        ByteBuffer j;
        Map<String, String> k;
        m53 l;
        ByteBuffer m;

        b(@NonNull e eVar, @NonNull com.uploader.implement.b.e eVar2) {
            this.a = eVar;
            f63 b2 = eVar.b();
            this.b = b2;
            this.c = eVar2;
            Map<String, String> map = b2.e;
            boolean z = false;
            this.d = map == null || map.size() == 0;
            byte[] bArr = b2.g;
            this.e = (bArr == null || bArr.length == 0) ? true : z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Map<String, String> map = this.b.e;
            boolean z = true;
            this.d = map == null || map.size() == 0;
            byte[] bArr = this.b.g;
            if (!(bArr == null || bArr.length == 0)) {
                z = false;
            }
            this.e = z;
            this.g = 0;
            this.f = 0;
            this.h = 0;
            this.j = null;
            this.k = null;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            f63 f63 = this.b;
            byte[] bArr = f63.f;
            boolean z = bArr == null || this.f == bArr.length;
            boolean z2 = f63.a == null || ((long) this.g) == f63.d;
            if (!this.e || !this.d || !z || !z2) {
                return false;
            }
            return true;
        }
    }

    public c(com.uploader.implement.c cVar, com.uploader.implement.b.c cVar2, Looper looper) {
        this.h = cVar;
        this.e = cVar2;
        this.f = new Handler(looper);
        this.g = hashCode();
    }

    private static int b(com.uploader.implement.b.e eVar, ArrayList<b> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).c.equals(eVar)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0159 A[SYNTHETIC, Splitter:B:65:0x0159] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x017b A[SYNTHETIC, Splitter:B:73:0x017b] */
    private h13 c(b bVar, ByteBuffer byteBuffer) {
        Throwable th;
        Exception e2;
        f63 f63 = bVar.b;
        FileInputStream fileInputStream = null;
        if (f63.h != null) {
            long j = f63.c;
            int i2 = bVar.g;
            int i3 = (int) (j + ((long) i2));
            int min = (int) Math.min(f63.d - ((long) i2), (long) byteBuffer.remaining());
            if (min >= 0) {
                f63 f632 = bVar.b;
                long j2 = f632.d;
                byte[] bArr = f632.h;
                if (j2 <= ((long) bArr.length)) {
                    byteBuffer.put(bArr, i3, min);
                    bVar.g += min;
                    if (com.uploader.implement.a.d(4)) {
                        com.uploader.implement.a.a(4, "UploaderSession", this.g + " readFromEntity, from copy:" + min);
                    }
                    return null;
                }
            }
            return new h13("200", "11", "readFromBytes", false);
        }
        File file = f63.a;
        if (file == null || !file.exists()) {
            return new h13("200", "3", "file == null || !file.exists()", false);
        }
        long lastModified = file.lastModified();
        if (lastModified != bVar.b.b) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " readFromEntity, file has been modified, origin:" + bVar.b.b + " current:" + lastModified);
            }
            if (0 == lastModified) {
                return new h13("200", "10", "file.lastModified()==0", false);
            }
            return new h13("200", "6", "file has been modified", false);
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                int read = fileInputStream2.getChannel().read(byteBuffer, bVar.b.c + ((long) bVar.g));
                if (read < 0) {
                    h13 h13 = new h13("200", "3", "file read failed", false);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                        if (com.uploader.implement.a.d(8)) {
                            com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e3);
                        }
                    }
                    return h13;
                }
                int i4 = (int) (((long) (bVar.g + read)) - bVar.b.d);
                if (i4 > 0) {
                    byteBuffer.position(byteBuffer.position() - i4);
                    read -= i4;
                }
                if (read > 0) {
                    bVar.g += read;
                }
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    if (com.uploader.implement.a.d(8)) {
                        com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e4);
                    }
                }
                return null;
            } catch (Exception e5) {
                e2 = e5;
                fileInputStream = fileInputStream2;
                try {
                    h13 h132 = new h13("200", "3", e2.toString(), false);
                    if (fileInputStream != null) {
                    }
                    return h132;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        if (com.uploader.implement.a.d(8)) {
                            com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e6);
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            e2 = e7;
            h13 h1322 = new h13("200", "3", e2.toString(), false);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    if (com.uploader.implement.a.d(8)) {
                        com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e8);
                    }
                }
            }
            return h1322;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r3 > 0) goto L_0x0032;
     */
    private void d(int i2) {
        int i3;
        h13 h13;
        b bVar = this.c.get(i2);
        if (!bVar.a.a().e) {
            f63 f63 = bVar.b;
            byte[] bArr = f63.f;
            i3 = bArr != null ? bArr.length + 0 : 0;
            if (f63.a != null) {
                i3 = (int) (((long) i3) + f63.d);
            }
            byte[] bArr2 = f63.g;
            if (bArr2 != null) {
                i3 += bArr2.length;
            }
        }
        i3 = 307200;
        ByteBuffer byteBuffer = bVar.m;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        byte[] bArr3 = bVar.b.f;
        if (bArr3 == null || bVar.f >= bArr3.length) {
            h13 = null;
        } else {
            if (byteBuffer == null) {
                try {
                    byteBuffer = ByteBuffer.allocate(i3);
                } catch (OutOfMemoryError unused) {
                    i3 >>= 1;
                    byteBuffer = ByteBuffer.allocate(i3);
                }
                bVar.m = byteBuffer;
            }
            h13 = i(bVar, byteBuffer);
        }
        if (h13 == null && ((long) bVar.g) < bVar.b.d) {
            if (byteBuffer == null) {
                try {
                    byteBuffer = ByteBuffer.allocate(i3);
                } catch (OutOfMemoryError unused2) {
                    byteBuffer = ByteBuffer.allocate(i3 >> 1);
                }
                bVar.m = byteBuffer;
            }
            h13 = c(bVar, byteBuffer);
        }
        if (h13 != null) {
            e(i2, h13);
            return;
        }
        bVar.h = i.getAndIncrement();
        if (!bVar.e) {
            long j = (long) bVar.g;
            f63 f632 = bVar.b;
            if (j == f632.d) {
                byte[] bArr4 = f632.g;
                if (byteBuffer == null) {
                    byteBuffer = ByteBuffer.allocate(bArr4.length);
                }
                if (byteBuffer.remaining() >= bArr4.length) {
                    byteBuffer.put(bArr4, 0, bArr4.length);
                    bVar.e = true;
                }
            }
        }
        m53 m53 = bVar.l;
        if (m53 == null) {
            m53 = new m53();
            bVar.l = m53;
        }
        m53.c = 0;
        m53.d = 0;
        m53.a = null;
        m53.b = null;
        if (!bVar.d) {
            m53.a = bVar.b.e;
            bVar.d = true;
        }
        if (byteBuffer != null) {
            bVar.i = byteBuffer.position();
            m53.b = byteBuffer.array();
            m53.c = byteBuffer.arrayOffset();
            m53.d = byteBuffer.position();
        }
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "UploaderSession", this.g + " sendRequest, request:" + bVar.a.hashCode() + " connection:" + bVar.c.hashCode() + " requestData:" + m53.toString() + " currentSendSequence:" + bVar.h + " tailFinish:" + bVar.e + " headerFinish:" + bVar.d + " entitySizeSent:" + bVar.g + " bytesSizeSent:" + bVar.f + " offset:" + bVar.b.c + " length:" + bVar.b.d + " requestData length:" + m53.d);
        }
        bVar.c.a(m53, bVar.h);
        o(bVar.c, bVar.i);
    }

    private void e(int i2, h13 h13) {
        b remove = this.c.remove(i2);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " notifyError, request:" + remove.a.hashCode());
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(this, remove.a, h13);
        }
    }

    private static void g(b bVar, m53 m53) {
        if (bVar.j == null) {
            bVar.j = ByteBuffer.allocate(128);
            bVar.k = m53.a;
        }
        int position = bVar.j.position() + m53.b.length;
        if (bVar.j.capacity() < position) {
            bVar.j.flip();
            bVar.j = ByteBuffer.allocate(position).put(bVar.j);
        }
        bVar.j.put(m53.b);
    }

    private static int h(com.uploader.implement.b.e eVar, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).c[0].equals(eVar)) {
                return i2;
            }
        }
        return -1;
    }

    private h13 i(b bVar, ByteBuffer byteBuffer) {
        byte[] bArr = bVar.b.f;
        int min = Math.min(bArr.length - bVar.f, byteBuffer.remaining());
        if (min < 0) {
            return new h13("200", "1", "readFromBytes", false);
        }
        byteBuffer.put(bArr, bVar.f, min);
        bVar.f += min;
        return null;
    }

    private void o(com.uploader.implement.b.e eVar, int i2) {
        a aVar;
        int h2 = h(eVar, this.d);
        if (h2 == -1) {
            aVar = new a(8, this, eVar);
            this.d.add(aVar);
        } else {
            aVar = this.d.get(h2);
            this.f.removeCallbacks(aVar);
        }
        this.f.postDelayed(aVar, (long) ((i2 / 102400) + 30000));
    }

    private void q(com.uploader.implement.b.e eVar) {
        int h2 = h(eVar, this.d);
        if (h2 != -1) {
            this.f.removeCallbacks(this.d.remove(h2));
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " clearTimeout, connection:" + eVar.hashCode());
            }
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " clearTimeout, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    @Override // com.uploader.implement.d.b
    public void a(@NonNull e eVar, boolean z) {
        if (!this.b.remove(eVar)) {
            int a2 = a(eVar, this.c);
            if (a2 != -1) {
                boolean a3 = this.e.a(this, eVar, z);
                int h2 = h(this.c.remove(a2).c, this.d);
                if (h2 != -1) {
                    this.f.removeCallbacks(this.d.remove(h2));
                }
                if (com.uploader.implement.a.d(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.g);
                    sb.append(" cancel, sendingList request");
                    sb.append(eVar.hashCode());
                    sb.append(" remove timeout:");
                    sb.append(h2 != -1);
                    sb.append(" unregister:");
                    sb.append(a3);
                    com.uploader.implement.a.a(2, "UploaderSession", sb.toString());
                }
            } else if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " cancel, no sending request:" + eVar.hashCode());
            }
        } else if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " cancel, waiting request:" + eVar.hashCode());
        }
    }

    /* access modifiers changed from: package-private */
    public void f(com.uploader.implement.b.e eVar, int i2, boolean z) {
        int b2 = b(eVar, this.c);
        if (b2 != -1) {
            b bVar = this.c.get(b2);
            boolean b3 = bVar.b();
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " doSend, begin:" + z + " connection:" + eVar.hashCode() + " sendSequence:" + i2 + " isFinished:" + b3);
            }
            if (z) {
                a aVar = this.a;
                if (aVar != null) {
                    aVar.a(this, bVar.a, bVar.g);
                }
            } else if (!b3) {
                d(b2);
                return;
            } else {
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.b(this, bVar.a);
                }
            }
            o(bVar.c, bVar.i);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " doSend, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    /* access modifiers changed from: package-private */
    public void j(com.uploader.implement.b.e eVar) {
        this.d.remove(this);
        int b2 = b(eVar, this.c);
        if (b2 != -1) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " timeout, connection:" + eVar.hashCode());
            }
            e(b2, new h13(MessageService.MSG_DB_COMPLETE, "2", "data send or receive timeout", true));
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " timeout, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    /* access modifiers changed from: package-private */
    public void k(com.uploader.implement.b.e eVar, h13 h13) {
        int b2 = b(eVar, this.c);
        if (b2 != -1) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " doError, connection:" + eVar.hashCode() + " error:" + h13.toString() + " sendingList.size:" + this.c.size());
            }
            b bVar = this.c.get(b2);
            bVar.a();
            q(bVar.c);
            e(b2, h13);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " doError, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    /* access modifiers changed from: package-private */
    public void l(com.uploader.implement.b.e eVar, m53 m53) {
        int b2 = b(eVar, this.c);
        if (b2 != -1) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " doReceive, sendingList.size:" + this.c.size() + " index:" + b2 + " connection:" + eVar.hashCode() + " data:" + m53.toString());
            }
            b bVar = this.c.get(b2);
            o(bVar.c, bVar.i);
            g(bVar, m53);
            ArrayList arrayList = null;
            do {
                Pair<f, Integer> a2 = bVar.a.a(bVar.k, bVar.j.array(), bVar.j.arrayOffset(), bVar.j.position());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
                if (a2.first == null) {
                    break;
                }
                bVar.j.flip();
                bVar.j.get(new byte[((Integer) a2.second).intValue()], 0, ((Integer) a2.second).intValue());
                bVar.j.compact();
            } while (bVar.j.position() >= 4);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object obj = pair.first;
                if (obj != null) {
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(this, bVar.a, (f) obj);
                    }
                } else if (((Integer) pair.second).intValue() < 0) {
                    e(b2, new h13("400", "2", "response == null && divide < 0", true));
                    return;
                } else {
                    return;
                }
            }
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " doReceive, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    /* access modifiers changed from: package-private */
    public void m(b bVar, e eVar, com.uploader.implement.b.e eVar2) {
        boolean z = !this.b.remove(eVar);
        boolean d2 = eVar2.d();
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "UploaderSession", this.g + " onAvailable.session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " noWaitingRequest:" + z + " connection:" + eVar2.hashCode() + " needConnect:" + d2 + " target:" + eVar.a());
        }
        if (!z) {
            eVar2.a(this);
            b bVar2 = new b(eVar, eVar2);
            this.c.add(bVar2);
            if (d2) {
                a aVar = this.a;
                if (aVar != null) {
                    aVar.c(this, bVar2.a);
                }
                eVar2.b();
                return;
            }
            a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.e(this, bVar2.a);
            }
            d(this.c.size() - 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(com.uploader.implement.b.e eVar) {
        int b2 = b(eVar, this.c);
        if (b2 != -1) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " doConnect, connection:" + eVar.hashCode());
            }
            a aVar = this.a;
            if (aVar != null) {
                aVar.d(this, this.c.get(b2).a);
            }
            a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.e(this, this.c.get(b2).a);
            }
            d(b2);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " doConnect, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    /* access modifiers changed from: package-private */
    public void p(com.uploader.implement.b.e eVar) {
        int b2 = b(eVar, this.c);
        if (b2 != -1) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " doClose, connection:" + eVar.hashCode());
            }
            eVar.a(null);
            b bVar = this.c.get(b2);
            bVar.a();
            q(bVar.c);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderSession", this.g + " doClose, NO_POSITION, connection:" + eVar.hashCode());
        }
    }

    @Override // com.uploader.implement.b.b
    public void b(com.uploader.implement.b.e eVar, int i2) {
        this.f.post(new a(5, this, eVar, Integer.valueOf(i2)));
    }

    @Override // com.uploader.implement.d.b
    public void a(@NonNull e eVar) {
        this.b.add(eVar);
        boolean a2 = this.e.a(this, eVar, this);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " send, request:" + eVar.hashCode() + " register:" + a2);
        }
    }

    @Override // com.uploader.implement.d.b
    public void a(@NonNull e eVar, @NonNull e eVar2, boolean z) {
        int indexOf = this.b.indexOf(eVar);
        if (indexOf != -1) {
            this.b.set(indexOf, eVar2);
            boolean a2 = this.e.a(this, eVar, eVar2, this, z);
            if (!a2) {
                this.e.a(this, eVar, z);
                this.e.a(this, eVar2, this);
            }
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " replace:" + a2 + " waiting request:" + eVar.hashCode());
                return;
            }
            return;
        }
        int a3 = a(eVar, this.c);
        if (a3 == -1) {
            this.b.add(eVar2);
            boolean a4 = this.e.a(this, eVar, eVar2, this, z);
            if (!a4) {
                this.e.a(this, eVar, z);
                this.e.a(this, eVar2, this);
            }
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " replace:" + a4 + " request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode());
                return;
            }
            return;
        }
        b remove = this.c.remove(a3);
        this.b.add(eVar2);
        boolean a5 = this.e.a(this, eVar, eVar2, this, z);
        if (!a5) {
            this.e.a(this, eVar, z);
            this.e.a(this, eVar2, this);
        }
        int h2 = h(remove.c, this.d);
        if (h2 != -1) {
            this.f.removeCallbacks(this.d.remove(h2));
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " replace:" + a5 + " sending request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode());
        }
    }

    @Override // com.uploader.implement.d.b
    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // com.uploader.implement.d.b
    public void a() {
        this.b.clear();
        this.c.clear();
        for (int size = this.d.size() - 1; size >= 0; size--) {
            this.f.removeCallbacks(this.d.remove(size));
        }
        this.e.a(this);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " release");
        }
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar) {
        this.f.post(new a(1, this, eVar));
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar, h13 h13) {
        this.f.post(new a(3, this, eVar, h13));
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar, m53 m53) {
        this.f.post(new a(4, this, eVar, m53));
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar, int i2) {
        this.f.postDelayed(new a(6, this, eVar, Integer.valueOf(i2)), this.h.b.enableFlowControl() ? 100 : 0);
    }

    private static int a(e eVar, ArrayList<b> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).a.equals(eVar)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.uploader.implement.b.d
    public void a(b bVar, e eVar, com.uploader.implement.b.e eVar2) {
        this.f.post(new a(7, this, bVar, eVar, eVar2));
    }
}

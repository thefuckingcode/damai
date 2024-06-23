package com.alibaba.android.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/* compiled from: Taobao */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    private final LinkedHashMap<String, Object> a;
    private final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> b;
    private e c;
    private boolean d;
    private File e;
    private String f;
    private int g;
    private FileChannel h;
    private MappedByteBuffer i;
    private HandlerThread j;
    private Handler k;
    private final Object l;
    private final Object m;
    private int n;
    private Vector<SharedPreferences.Editor> o;
    private OnSharedPreferenceErrorListener p;
    private long q;
    private final Runnable r;
    private RunnableEx s;
    private int t;

    /* compiled from: Taobao */
    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i, long j);
    }

    /* compiled from: Taobao */
    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public Object getArg() {
            return this.mArg;
        }

        public void setArg(Object obj) {
            this.mArg = obj;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        public static float a(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] b(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        public static int a(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] b(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        public static long a(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] b(long j) {
            return ByteBuffer.allocate(8).putLong(j).array();
        }
    }

    /* compiled from: Taobao */
    public final class d implements SharedPreferences.Editor {
        private HashMap<String, Object> a = new HashMap<>();
        private boolean b;

        public d() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            boolean z;
            synchronized (this) {
                z = this.b;
                this.b = false;
            }
            return z;
        }

        public void apply() {
            SharedPreferencesNewImpl.this.M(this, false, false, true);
        }

        /* access modifiers changed from: package-private */
        public HashMap<String, Object> b() {
            HashMap<String, Object> hashMap;
            synchronized (this) {
                hashMap = this.a;
            }
            return hashMap;
        }

        public SharedPreferences.Editor clear() {
            synchronized (this) {
                this.b = true;
            }
            return this;
        }

        public boolean commit() {
            SharedPreferencesNewImpl.this.M(this, false, true, false);
            return true;
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.a.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this) {
                this.a.put(str, Float.valueOf(f));
            }
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this) {
                this.a.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this) {
                this.a.put(str, Long.valueOf(j));
            }
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.a.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        public SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.a.put(str, null);
            }
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class e extends FileObserver {
        public e(String str, int i) {
            super(str, i);
        }

        public void onEvent(int i, String str) {
            if (SharedPreferencesNewImpl.this.b.size() > 0) {
                SharedPreferencesNewImpl.this.Q();
            } else {
                stopWatching();
            }
        }
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    private boolean A() {
        Throwable th;
        byte[] bArr;
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        String str;
        long j2;
        Closeable closeable = null;
        int i2 = 0;
        boolean z = true;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f, UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                byte[] bArr2 = new byte[4];
                randomAccessFile.read(bArr2, 0, 4);
                int a2 = b.a(bArr2);
                if (a2 <= 10) {
                    L(randomAccessFile);
                    try {
                        H(null, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return false;
                }
                if (a2 > Integer.MAX_VALUE) {
                    a2 = Integer.MAX_VALUE;
                }
                if (((long) a2) > randomAccessFile.length()) {
                    a2 = (int) randomAccessFile.length();
                }
                int i3 = a2 - 10;
                byte[] bArr3 = new byte[i3];
                randomAccessFile.seek(10);
                randomAccessFile.read(bArr3);
                L(randomAccessFile);
                try {
                    z = H(bArr3, false);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    str = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + ((Object) "") + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + z;
                    j2 = (long) i3;
                    onSharedPreferenceErrorListener.onError(str, 12, j2);
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                bArr = null;
                closeable = randomAccessFile;
                try {
                    th.printStackTrace();
                    L(closeable);
                    try {
                        z = H(bArr, false);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                    }
                    return z;
                } catch (Throwable th3) {
                    L(closeable);
                    try {
                        z = H(bArr, false);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.p;
                    if (onSharedPreferenceErrorListener2 != null) {
                        String str2 = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + th.getCause() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + z;
                        if (bArr != null) {
                            i2 = bArr.length;
                        }
                        onSharedPreferenceErrorListener2.onError(str2, 12, (long) i2);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bArr = null;
            th.printStackTrace();
            L(closeable);
            z = H(bArr, false);
            onSharedPreferenceErrorListener = this.p;
            if (onSharedPreferenceErrorListener != null) {
                str = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + th.getCause() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + z;
                if (bArr != null) {
                    i2 = bArr.length;
                }
                j2 = (long) i2;
                onSharedPreferenceErrorListener.onError(str, 12, j2);
            }
            return z;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void B() {
        if (!this.d) {
            z(false);
            this.d = true;
            notifyAll();
        }
    }

    private FileLock C(boolean z) {
        FileChannel fileChannel = this.h;
        FileLock fileLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (z) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            while (fileLock == null) {
                try {
                    fileLock = this.h.tryLock();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (fileLock == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (SystemClock.elapsedRealtime() - elapsedRealtime > 10000) {
                    return fileLock;
                }
            }
            return fileLock;
        }
        try {
            return fileChannel.tryLock();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private boolean D(SharedPreferences.Editor editor, Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        d dVar = (d) editor;
        boolean a2 = dVar.a();
        if (a2) {
            map.clear();
        }
        HashMap<String, Object> b2 = dVar.b();
        if (b2.size() != 0) {
            synchronized (editor) {
                for (Map.Entry<String, Object> entry : b2.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        map.remove(key);
                    } else {
                        if (map.containsKey(key)) {
                            map.remove(key);
                        }
                        map.put(key, value);
                    }
                    if (!z) {
                        F(key);
                    }
                }
            }
            return true;
        } else if (a2) {
            return true;
        } else {
            return false;
        }
    }

    private void E() {
        synchronized (this.a) {
            if (this.o.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.o.iterator();
                while (it.hasNext()) {
                    D(it.next(), this.a, true);
                }
            }
        }
    }

    private void F(String str) {
        if (this.b.size() > 0) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.b.get(i2);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    private byte[] G() {
        Pair<Integer, byte[][]> q2 = q();
        int intValue = ((Integer) q2.first).intValue() + 10 + (((byte[][]) q2.second).length * 1);
        if (intValue > Integer.MAX_VALUE) {
            intValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[intValue];
        byte[] b2 = b.b(intValue);
        System.arraycopy(b2, 0, bArr, 0, b2.length);
        int length = b2.length + 0;
        bArr[length] = r(b2);
        int i2 = length + 1;
        byte[] b3 = b.b(w());
        System.arraycopy(b3, 0, bArr, i2, b3.length);
        int length2 = i2 + b3.length;
        bArr[length2] = r(b3);
        int i3 = length2 + 1;
        byte[][] bArr2 = (byte[][]) q2.second;
        int length3 = bArr2.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i4];
            if (bArr3 != null) {
                if (bArr3.length + i3 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i3, bArr3.length);
                    int length4 = i3 + bArr3.length;
                    bArr[length4] = r(bArr3);
                    i3 = length4 + 1;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Write too much data in ");
                    File file = this.e;
                    String str = null;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    Log.e("SharedPreferencesNew", sb.toString());
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.e;
                        if (file2 != null) {
                            str = file2.getAbsolutePath();
                        }
                        onSharedPreferenceErrorListener.onError(str, 7, -1);
                    }
                }
            }
            i4++;
        }
        return bArr;
    }

    private boolean H(byte[] bArr, boolean z) {
        String str = null;
        LinkedHashMap linkedHashMap = z ? new LinkedHashMap(this.a) : null;
        synchronized (this.a) {
            if (z) {
                try {
                    if (this.g > 0) {
                        this.a.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bArr != null) {
                if (bArr.length != 0) {
                    boolean z2 = false;
                    int i2 = 0;
                    boolean z3 = true;
                    while (true) {
                        if (i2 >= bArr.length) {
                            z2 = z3;
                            break;
                        }
                        try {
                            Pair<byte[], Integer> v = v(bArr, i2);
                            Pair<byte[], Integer> v2 = v(bArr, ((Integer) v.second).intValue());
                            int intValue = ((Integer) v2.second).intValue();
                            byte b2 = bArr[intValue];
                            int i3 = intValue + 1;
                            byte b3 = bArr[i3];
                            int i4 = i3 + 1;
                            if (b3 != 18) {
                                if (b3 != r(new byte[]{b2})) {
                                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                                    if (onSharedPreferenceErrorListener != null) {
                                        File file = this.e;
                                        onSharedPreferenceErrorListener.onError(file != null ? file.getAbsolutePath() : null, 8, (long) bArr.length);
                                    }
                                }
                            }
                            if (!m(b2)) {
                                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.p;
                                if (onSharedPreferenceErrorListener2 != null) {
                                    File file2 = this.e;
                                    onSharedPreferenceErrorListener2.onError(file2 != null ? file2.getAbsolutePath() : null, 9, (long) bArr.length);
                                }
                                i2 = i4;
                                z3 = false;
                            } else {
                                Object t2 = t((byte[]) v2.first, b2);
                                Object obj = v.first;
                                if (!(obj == null || ((byte[]) obj).length <= 0 || t2 == null)) {
                                    String str2 = new String((byte[]) obj);
                                    if (z || !this.a.containsKey(str2)) {
                                        this.a.put(str2, t2);
                                    }
                                }
                                i2 = i4;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener3 = this.p;
                            if (onSharedPreferenceErrorListener3 != null) {
                                StringBuilder sb = new StringBuilder();
                                File file3 = this.e;
                                if (file3 != null) {
                                    str = file3.getAbsolutePath();
                                }
                                sb.append(str);
                                sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                                sb.append(e2.getCause());
                                onSharedPreferenceErrorListener3.onError(sb.toString(), 3, (long) bArr.length);
                            }
                        }
                    }
                    if (!z2 && z) {
                        this.a.putAll(linkedHashMap);
                    }
                    return z2;
                }
            }
            return true;
        }
    }

    private void I() {
        if (this.i != null) {
            synchronized (this.l) {
                try {
                    int p2 = p();
                    if (p2 > this.i.capacity()) {
                        j(p2 + 1024);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean J(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int position = mappedByteBuffer.position();
        if (position + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void K(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer != null && bArr != null && bArr.length != 0) {
            if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
                mappedByteBuffer = j(mappedByteBuffer.position() + bArr.length + 1024);
            }
            mappedByteBuffer.put(bArr);
        }
    }

    private void L(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r6 == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        N(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r7 == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        r6 = 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        r3.s.setArg(java.lang.Boolean.valueOf(r5));
        r4 = android.os.Message.obtain(r3.k, r3.s);
        r4.what = 21310;
        r3.k.sendMessageDelayed(r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    private void M(SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor != null) {
            synchronized (this.a) {
                this.n = 0;
                if (D(editor, this.a, false)) {
                    this.o.add(editor);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        O(G(), r7);
        l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        r7 = e;
     */
    private void N(final boolean z) {
        synchronized (this.m) {
            FileLock C = C(false);
            if (C != null) {
                try {
                    if (R()) {
                        E();
                        F(null);
                    }
                    synchronized (this.a) {
                        if (this.o.size() <= 0) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        C.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } else {
                int i2 = this.n;
                this.n = i2 + 1;
                if (i2 < 6) {
                    this.k.postDelayed(new Runnable() {
                        /* class com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass3 */

                        public void run() {
                            SharedPreferencesNewImpl.this.N(z);
                        }
                    }, 2000);
                }
            }
        }
        return;
        e.printStackTrace();
    }

    private void O(byte[] bArr, boolean z) {
        synchronized (this.l) {
            this.i.position(0);
            K(this.i, bArr);
            if (z) {
                this.i.force();
            }
        }
    }

    private void P() {
        synchronized (this) {
            this.d = false;
        }
        this.k.post(new Runnable() {
            /* class com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass5 */

            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.B();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Q() {
        if (SystemClock.elapsedRealtime() - this.q > 60) {
            this.q = SystemClock.elapsedRealtime();
            this.k.removeCallbacks(this.r);
            this.k.post(this.r);
        }
    }

    private boolean R() {
        int s2 = s();
        if (s2 <= 0 || s2 == this.g) {
            return false;
        }
        z(true);
        return true;
    }

    private MappedByteBuffer j(int i2) {
        MappedByteBuffer mappedByteBuffer = this.i;
        int position = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.i = this.h.map(FileChannel.MapMode.READ_WRITE, 0, (long) i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.i;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(position);
        }
        return this.i;
    }

    private void k() {
        synchronized (this) {
            while (!this.d) {
                try {
                    wait();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        Q();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    private void l() {
        Throwable th;
        Closeable closeable;
        FileChannel fileChannel = null;
        try {
            File file = new File(this.f);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileChannel = fileOutputStream.getChannel();
                this.h.transferTo(0, (long) this.i.capacity(), fileChannel);
                L(fileOutputStream);
                L(fileChannel);
            } catch (Throwable th2) {
                closeable = fileChannel;
                fileChannel = fileOutputStream;
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    L(fileChannel);
                    L(closeable);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = fileChannel;
            th.printStackTrace();
        }
    }

    private byte n(byte[] bArr) {
        byte b2 = 0;
        for (byte b3 : bArr) {
            b2 = (byte) (b2 ^ b3);
        }
        return b2;
    }

    private byte[] o(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                return ((String) obj).getBytes();
            }
            if (obj instanceof Boolean) {
                int i2 = 1;
                byte[] bArr = new byte[1];
                if (!((Boolean) obj).booleanValue()) {
                    i2 = 0;
                }
                bArr[0] = (byte) i2;
                return bArr;
            } else if (obj instanceof Float) {
                return a.b(((Float) obj).floatValue());
            } else {
                if (obj instanceof Integer) {
                    return b.b(((Integer) obj).intValue());
                }
                if (obj instanceof Long) {
                    return c.b(((Long) obj).longValue());
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int p() {
        if (this.i == null || this.h == null) {
            return -1;
        }
        synchronized (this.l) {
            this.i.position(0);
            byte[] bArr = new byte[4];
            J(this.i, bArr);
            int a2 = b.a(bArr);
            this.i.position(4);
            byte b2 = this.i.get();
            if ((b2 == 18 || b2 == r(bArr)) && a2 >= 0) {
                if (a2 > Integer.MAX_VALUE) {
                    a2 = Integer.MAX_VALUE;
                }
                return a2;
            }
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
            if (onSharedPreferenceErrorListener != null) {
                File file = this.e;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.e;
                onSharedPreferenceErrorListener.onError(absolutePath, 1, file2 != null ? file2.length() : 0);
            }
            return -1;
        }
    }

    private Pair<Integer, byte[][]> q() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.a) {
            bArr = new byte[(this.a.size() * 5)][];
            arrayList = new ArrayList(this.a.entrySet());
            this.o.clear();
        }
        int i2 = 0;
        int i3 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (!(str == null || str.trim().length() <= 0 || value == null)) {
                byte[] bytes = str.getBytes();
                byte[] b2 = b.b(bytes.length);
                bArr[i3] = b2;
                bArr[i3 + 1] = bytes;
                int length = i2 + b2.length + bytes.length;
                byte[] o2 = o(value);
                byte[] b3 = b.b(o2.length);
                bArr[i3 + 2] = b3;
                bArr[i3 + 3] = o2;
                bArr[i3 + 4] = new byte[]{(byte) u(value)};
                i2 = length + b3.length + o2.length + 1;
                i3 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i2), bArr);
    }

    private byte r(byte[] bArr) {
        return n(bArr);
    }

    private Object t(byte[] bArr, int i2) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        if (i2 == 5) {
            try {
                return new String(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            boolean z = true;
            if (i2 == 4) {
                if (bArr[0] != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i2 == 2) {
                return Float.valueOf(a.a(bArr));
            } else {
                if (i2 == 1) {
                    return Integer.valueOf(b.a(bArr));
                }
                if (i2 == 3) {
                    return Long.valueOf(c.a(bArr));
                }
                return null;
            }
        }
    }

    private int u(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        return obj instanceof Long ? 3 : 0;
    }

    private Pair<byte[], Integer> v(byte[] bArr, int i2) throws Exception {
        int i3;
        int i4;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i2, bArr2, 0, 4);
        int i5 = i2 + 4;
        if (bArr[i5] == 18 || bArr[i5] == r(bArr2)) {
            int i6 = i5 + 1;
            int a2 = b.a(bArr2);
            if (a2 < 0 || (i3 = i6 + a2) >= bArr.length || a2 > Integer.MAX_VALUE) {
                throw new Exception("length string is invalid");
            }
            byte[] bArr3 = null;
            if (a2 == 0) {
                i4 = i6 + 1;
            } else {
                bArr3 = new byte[a2];
                System.arraycopy(bArr, i6, bArr3, 0, a2);
                if (bArr[i3] == 18 || bArr[i3] == r(bArr3)) {
                    i4 = i3 + 1;
                } else {
                    throw new Exception("Stored bytes' finish mark missing");
                }
            }
            return new Pair<>(bArr3, Integer.valueOf(i4));
        }
        throw new Exception("length string's finish mark missing");
    }

    private int w() {
        int i2 = (this.g + 1) % Integer.MAX_VALUE;
        this.g = i2;
        return i2;
    }

    private boolean x() {
        boolean z = true;
        if (this.i != null) {
            return true;
        }
        try {
            if (!this.e.exists()) {
                this.e.getParentFile().mkdirs();
                this.e.createNewFile();
                z = new File(this.f).exists();
            } else if (this.e.length() == 0) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.e.getAbsolutePath(), 4, this.e.length());
                }
                z = false;
            }
            this.h = new RandomAccessFile(this.e, "rw").getChannel();
            j(10);
            if (!z) {
                y();
            }
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.p;
            if (onSharedPreferenceErrorListener2 == null) {
                return false;
            }
            onSharedPreferenceErrorListener2.onError(this.e.getAbsolutePath() + " " + e2.getCause(), 10, -1);
            return false;
        }
    }

    private void y() {
        if (this.i != null) {
            byte[] bArr = new byte[10];
            byte[] b2 = b.b(0);
            System.arraycopy(b2, 0, bArr, 0, 4);
            bArr[4] = r(b2);
            byte[] b3 = b.b(0);
            System.arraycopy(b3, 0, bArr, 5, 4);
            bArr[9] = r(b3);
            this.i.position(0);
            this.i.put(bArr);
        }
    }

    private void z(boolean z) {
        byte[] bArr = null;
        FileLock C = z ? bArr : C(true);
        if (C != null || z) {
            boolean z2 = false;
            try {
                I();
                MappedByteBuffer mappedByteBuffer = this.i;
                if (mappedByteBuffer != null) {
                    if (mappedByteBuffer.capacity() != 0) {
                        long p2 = (long) p();
                        if (p2 <= 10) {
                            try {
                                z2 = H(bArr, true);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (!z2 || this.g < 0) {
                                A();
                            }
                            if (C != null) {
                                try {
                                    C.release();
                                    return;
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            int s2 = s();
                            this.g = s2;
                            if (s2 > 0) {
                                synchronized (this.l) {
                                    this.i.position(10);
                                    bArr = new byte[(((int) p2) - 10)];
                                    J(this.i, bArr);
                                }
                            }
                            if (C != null) {
                                try {
                                    return;
                                } catch (Exception e4) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                try {
                    z2 = H(bArr, true);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                if (!z2 || this.g < 0) {
                    A();
                }
                if (C != null) {
                    try {
                        C.release();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            } finally {
                try {
                    z2 = H(bArr, true);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                if (!z2 || (bArr == null && this.g < 0)) {
                    A();
                }
                if (C != null) {
                    try {
                        C.release();
                    } catch (Exception e42) {
                        e42.printStackTrace();
                    }
                }
            }
        } else if (!z) {
            A();
        }
    }

    public boolean contains(String str) {
        boolean containsKey;
        k();
        synchronized (this.a) {
            containsKey = this.a.containsKey(str);
        }
        return containsKey;
    }

    public SharedPreferences.Editor edit() {
        k();
        return new d();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        k();
        synchronized (this.a) {
            hashMap = new HashMap(this.a);
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        k();
        synchronized (this.a) {
            try {
                Boolean bool = (Boolean) this.a.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            } catch (ClassCastException e2) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.e;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append(e2);
                    String sb2 = sb.toString();
                    File file2 = this.e;
                    onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0);
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public float getFloat(String str, float f2) {
        k();
        synchronized (this.a) {
            try {
                Float f3 = (Float) this.a.get(str);
                if (f3 != null) {
                    f2 = f3.floatValue();
                }
            } catch (ClassCastException e2) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.e;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append(e2);
                    String sb2 = sb.toString();
                    File file2 = this.e;
                    onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0);
                }
                return f2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2;
    }

    public int getInt(String str, int i2) {
        k();
        synchronized (this.a) {
            try {
                Integer num = (Integer) this.a.get(str);
                if (num != null) {
                    i2 = num.intValue();
                }
            } catch (ClassCastException e2) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.e;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append(e2);
                    String sb2 = sb.toString();
                    File file2 = this.e;
                    onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0);
                }
                return i2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public long getLong(String str, long j2) {
        k();
        synchronized (this.a) {
            try {
                Long l2 = (Long) this.a.get(str);
                if (l2 != null) {
                    j2 = l2.longValue();
                }
            } catch (ClassCastException e2) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.e;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append(e2);
                    String sb2 = sb.toString();
                    File file2 = this.e;
                    onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0);
                }
                return j2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public String getString(String str, String str2) {
        k();
        synchronized (this.a) {
            try {
                String str3 = (String) this.a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } catch (ClassCastException e2) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.e;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append(e2);
                    String sb2 = sb.toString();
                    File file2 = this.e;
                    onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0);
                }
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    /* access modifiers changed from: package-private */
    public boolean m(byte b2) {
        return b2 == 4 || b2 == 2 || b2 == 1 || b2 == 3 || b2 == 5;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            this.b.add(onSharedPreferenceChangeListener);
            e eVar = this.c;
            if (eVar != null) {
                eVar.startWatching();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int s() {
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        if (this.i == null) {
            return -1;
        }
        synchronized (this.l) {
            this.i.position(5);
            byte[] bArr = new byte[4];
            J(this.i, bArr);
            int a2 = b.a(bArr);
            this.i.position(9);
            byte b2 = this.i.get();
            if ((b2 == 18 || b2 == r(bArr)) && a2 >= 0) {
                return a2;
            }
            int i2 = this.t + 1;
            this.t = i2;
            if (i2 < 3 && (onSharedPreferenceErrorListener = this.p) != null) {
                File file = this.e;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.e;
                onSharedPreferenceErrorListener.onError(absolutePath, 2, file2 != null ? file2.length() : 0);
            }
            return -1;
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            this.b.remove(onSharedPreferenceChangeListener);
            if (this.c != null && this.b.size() <= 0) {
                this.c.stopWatching();
            }
        }
    }

    public SharedPreferencesNewImpl(File file, int i2, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.a = new LinkedHashMap<>();
        this.b = new ArrayList<>();
        this.d = true;
        this.l = new Object();
        this.m = new Object();
        this.o = new Vector<>();
        this.r = new Runnable() {
            /* class com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass2 */

            public void run() {
                int s = SharedPreferencesNewImpl.this.s();
                if (s > 0 && s != SharedPreferencesNewImpl.this.g) {
                    SharedPreferencesNewImpl.this.N(false);
                }
            }
        };
        this.s = new RunnableEx() {
            /* class com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass4 */

            public void run() {
                SharedPreferencesNewImpl.this.N(((Boolean) getArg()).booleanValue());
            }
        };
        this.p = onSharedPreferenceErrorListener;
        HandlerThread handlerThread = new HandlerThread(file.getName());
        this.j = handlerThread;
        handlerThread.start();
        this.k = new Handler(this.j.getLooper());
        this.e = file;
        this.f = file.getAbsolutePath() + ".bak";
        if (x()) {
            P();
        }
        this.k.post(new Runnable() {
            /* class com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass1 */

            public void run() {
                try {
                    File file = new File(SharedPreferencesNewImpl.this.f);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SharedPreferencesNewImpl sharedPreferencesNewImpl = SharedPreferencesNewImpl.this;
                SharedPreferencesNewImpl sharedPreferencesNewImpl2 = SharedPreferencesNewImpl.this;
                sharedPreferencesNewImpl.c = new e(sharedPreferencesNewImpl2.f, 2);
                if (SharedPreferencesNewImpl.this.b.size() > 0) {
                    SharedPreferencesNewImpl.this.c.startWatching();
                }
            }
        });
    }
}

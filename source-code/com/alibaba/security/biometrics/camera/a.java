package com.alibaba.security.biometrics.camera;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.camera.c;
import com.alibaba.security.biometrics.camera.size.AspectRatio;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.d.h;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: Taobao */
public abstract class a implements c {
    protected static final String a = "CameraAdapter";
    protected static final int b = 540;
    protected static final int c = 300;
    protected Point d;
    protected Point e;
    protected final Context f;
    final Comparator<Point> g;
    protected c.a h;
    protected int i;
    protected int j;
    protected volatile boolean k = false;
    protected ALBiometricsParams l;
    protected int m;
    private final c n;
    private byte[] o;
    private int p;

    /* renamed from: com.alibaba.security.biometrics.camera.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0100a implements Comparator<Point> {
        protected float a;

        public C0100a() {
            this.a = -1.0f;
            this.a = 0.0f;
        }

        private int a(Point point, Point point2) {
            int yVar;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (xVar == 0 || (yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) == 0) {
                return -100000;
            }
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) == 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) == 0) {
                return 100000;
            }
            return (int) ((Math.min(Math.abs(((((float) xVar) * 1.0f) / ((float) yVar)) - this.a), Math.abs(((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point))) - this.a)) * 1000.0f) - (Math.min(Math.abs(((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2)) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2))) - this.a), Math.abs(((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2)) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2))) - this.a)) * 1000.0f));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Point point, Point point2) {
            int yVar;
            Point point3 = point;
            Point point4 = point2;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
            if (xVar == 0 || (yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3)) == 0) {
                return -100000;
            }
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4) == 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4) == 0) {
                return 100000;
            }
            return (int) ((Math.min(Math.abs(((((float) xVar) * 1.0f) / ((float) yVar)) - this.a), Math.abs(((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3)) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3))) - this.a)) * 1000.0f) - (Math.min(Math.abs(((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4)) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4))) - this.a), Math.abs(((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4)) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4))) - this.a)) * 1000.0f));
        }
    }

    /* compiled from: Taobao */
    class b implements Comparator<Point> {
        protected int a;
        protected int b;

        public b() {
            this.a = -1;
            this.b = -1;
            this.a = 640;
            this.b = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
        }

        private int a(Point point, Point point2) {
            int i;
            int i2 = this.a;
            int i3 = 0;
            if (i2 > 0) {
                i3 = Math.abs(i2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) + 0;
                i = 0 + Math.abs(this.a - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2));
            } else {
                i = 0;
            }
            int i4 = this.b;
            if (i4 > 0) {
                i3 += Math.abs(i4 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                i += Math.abs(this.b - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
            }
            return i3 - i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Point point, Point point2) {
            int i;
            Point point3 = point;
            Point point4 = point2;
            int i2 = this.a;
            int i3 = 0;
            if (i2 > 0) {
                i3 = Math.abs(i2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3)) + 0;
                i = 0 + Math.abs(this.a - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4));
            } else {
                i = 0;
            }
            int i4 = this.b;
            if (i4 > 0) {
                i3 += Math.abs(i4 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3));
                i += Math.abs(this.b - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4));
            }
            return i3 - i;
        }
    }

    /* compiled from: Taobao */
    static class c extends Handler {
        private final a a;

        public c(a aVar) {
            super(Looper.getMainLooper());
            this.a = aVar;
        }

        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public a(Context context, ALBiometricsParams aLBiometricsParams) {
        this.f = context;
        this.m = 0;
        this.l = aLBiometricsParams;
        this.n = new c(this);
        this.g = new b();
    }

    private Point b(List<Point> list) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a(list, 300));
        if (linkedList.size() == 0) {
            linkedList.addAll(a(list, 0));
        }
        if (linkedList.size() == 0) {
            linkedList.addAll(list);
        }
        Collections.sort(linkedList, new C0100a());
        return (Point) linkedList.get(0);
    }

    private static Point c(List<Point> list) {
        boolean z;
        com.alibaba.security.biometrics.camera.size.b bVar = new com.alibaba.security.biometrics.camera.size.b();
        for (Point point : list) {
            com.alibaba.security.biometrics.camera.size.a aVar = new com.alibaba.security.biometrics.camera.size.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            Iterator<AspectRatio> it = bVar.a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    TreeSet treeSet = new TreeSet();
                    treeSet.add(aVar);
                    bVar.a.put(AspectRatio.a(aVar.a, aVar.b), treeSet);
                    break;
                }
                AspectRatio next = it.next();
                int b2 = AspectRatio.b(aVar.a, aVar.b);
                int i2 = aVar.a / b2;
                int i3 = aVar.b / b2;
                if (next.b == i2 && next.c == i3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    SortedSet<com.alibaba.security.biometrics.camera.size.a> sortedSet = bVar.a.get(next);
                    if (!sortedSet.contains(aVar)) {
                        sortedSet.add(aVar);
                    }
                }
            }
        }
        SortedSet<com.alibaba.security.biometrics.camera.size.a> a2 = bVar.a(AspectRatio.a);
        if (a2 == null) {
            a2 = bVar.a(a(bVar));
        }
        com.alibaba.security.biometrics.camera.size.a a3 = a(a2, 300);
        if (a3 == null) {
            a3 = a(a2, 0);
        }
        return new Point(a3.a, a3.b);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    @Override // com.alibaba.security.biometrics.camera.c
    public final void a(c.a aVar) {
        if (!this.k) {
            this.m = 0;
            this.h = aVar;
            a();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract void c();

    @Override // com.alibaba.security.biometrics.camera.c
    public final void d() {
        if (this.k) {
            b();
            this.h = null;
            this.k = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        this.n.post(new Runnable() {
            /* class com.alibaba.security.biometrics.camera.a.AnonymousClass2 */

            public final void run() {
                c.a aVar = a.this.h;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final String f() {
        HashMap hashMap = new HashMap();
        PreviewSize previewSize = new PreviewSize();
        previewSize.setWidth(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.e));
        previewSize.setHeight(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.e));
        hashMap.put("previewSize", previewSize);
        return h.a((Object) hashMap);
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final Point g() {
        return this.e;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final byte[] h() {
        return this.o;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final int i() {
        return this.p;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public abstract boolean j();

    private Point d(List<Point> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, this.g);
        int i2 = 0;
        int i3 = 0;
        for (Point point : list) {
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (xVar >= 600) {
                if (((double) Math.abs((((float) xVar) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) - 0.0f)) <= 0.05d) {
                    break;
                }
            }
            i3++;
        }
        if (i3 != list.size()) {
            i2 = i3;
        }
        return list.get(i2);
    }

    /* access modifiers changed from: protected */
    public final void a(final int i2, final String str) {
        this.n.post(new Runnable() {
            /* class com.alibaba.security.biometrics.camera.a.AnonymousClass1 */

            public final void run() {
                c.a aVar = a.this.h;
                if (aVar != null) {
                    aVar.a(i2, str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a(byte[] bArr, int i2) {
        if (this.h != null && this.k) {
            this.m++;
            this.p = i2;
            this.o = bArr;
            c.a aVar = this.h;
            Point point = this.e;
            aVar.a(bArr, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), i2);
        }
    }

    /* access modifiers changed from: protected */
    public final Point a(List<Point> list) {
        boolean z;
        if (this.l.cameraPreviewSizeSwitch) {
            com.alibaba.security.biometrics.camera.size.b bVar = new com.alibaba.security.biometrics.camera.size.b();
            for (Point point : list) {
                com.alibaba.security.biometrics.camera.size.a aVar = new com.alibaba.security.biometrics.camera.size.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                Iterator<AspectRatio> it = bVar.a.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        TreeSet treeSet = new TreeSet();
                        treeSet.add(aVar);
                        bVar.a.put(AspectRatio.a(aVar.a, aVar.b), treeSet);
                        break;
                    }
                    AspectRatio next = it.next();
                    int b2 = AspectRatio.b(aVar.a, aVar.b);
                    int i2 = aVar.a / b2;
                    int i3 = aVar.b / b2;
                    if (next.b == i2 && next.c == i3) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        SortedSet<com.alibaba.security.biometrics.camera.size.a> sortedSet = bVar.a.get(next);
                        if (!sortedSet.contains(aVar)) {
                            sortedSet.add(aVar);
                        }
                    }
                }
            }
            SortedSet<com.alibaba.security.biometrics.camera.size.a> a2 = bVar.a(AspectRatio.a);
            if (a2 == null) {
                a2 = bVar.a(a(bVar));
            }
            com.alibaba.security.biometrics.camera.size.a a3 = a(a2, 300);
            if (a3 == null) {
                a3 = a(a2, 0);
            }
            return new Point(a3.a, a3.b);
        } else if (list == null) {
            return null;
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(a(list, 300));
            if (linkedList.size() == 0) {
                linkedList.addAll(a(list, 0));
            }
            if (linkedList.size() == 0) {
                linkedList.addAll(list);
            }
            Collections.sort(linkedList, new C0100a());
            return (Point) linkedList.get(0);
        }
    }

    private static com.alibaba.security.biometrics.camera.size.a a(SortedSet<com.alibaba.security.biometrics.camera.size.a> sortedSet, int i2) {
        Iterator<com.alibaba.security.biometrics.camera.size.a> it = sortedSet.iterator();
        com.alibaba.security.biometrics.camera.size.a aVar = null;
        while (it.hasNext()) {
            aVar = it.next();
            if (Math.min(aVar.a, aVar.b) <= 540 && Math.min(aVar.a, aVar.b) >= i2) {
                break;
            }
        }
        return aVar;
    }

    private static List<Point> a(List<Point> list, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Point point : list) {
                if (Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) <= 540 && Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) >= i2) {
                    arrayList.add(point);
                }
            }
        }
        return arrayList;
    }

    private static boolean a(Point point, float f2) {
        return ((double) Math.abs((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) - f2)) <= 0.05d;
    }

    private static AspectRatio a(com.alibaba.security.biometrics.camera.size.b bVar) {
        Iterator<AspectRatio> it = bVar.a.keySet().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (AspectRatio.a.equals(aspectRatio)) {
                break;
            }
        }
        return aspectRatio;
    }
}

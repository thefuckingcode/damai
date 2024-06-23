package tb;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.Chair;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class a40 {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArrayList<Long> A = new ArrayList<>();
    public ArrayList<Long> B = new ArrayList<>();
    public ArrayList<Long> C = new ArrayList<>();
    public ArrayList<Long> D = new ArrayList<>();
    public ArrayList<Long> E = new ArrayList<>();
    public ArrayList<a> F = new ArrayList<>();
    private kb a;
    private ArrayList<Chair> b = new ArrayList<>();
    private ByteBuffer c = null;
    private String d = null;
    private int e = 0;
    private byte f = 0;
    private byte g;
    private byte h;
    private byte i;
    private byte j;
    private byte k;
    private byte l;
    private byte m;
    private byte n;
    private byte o;
    private byte p;
    private byte q;
    private Chair r = new Chair();
    private List<Long> s = new ArrayList();
    private String t = null;
    public ArrayList<Long> u = new ArrayList<>();
    public ArrayList<Long> v = new ArrayList<>();
    public ArrayList<Long> w = new ArrayList<>();
    public ArrayList<Long> x = new ArrayList<>();
    public ArrayList<Long> y = new ArrayList<>();
    public ArrayList<Long> z = new ArrayList<>();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a {
        long a;
        long b;
        long c;
        long d;
        long e;
        long f;
        long g;
        long h;
        long i;
        long j;
        long k;

        a(a40 a40) {
        }
    }

    public a40(kb kbVar) {
        h();
        this.a = kbVar;
    }

    private int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910858865")) {
            return ((Integer) ipChange.ipc$dispatch("1910858865", new Object[]{this})).intValue();
        } else if (this.e == 1) {
            return 0;
        } else {
            long j2 = (long) this.g;
            long j3 = (long) this.h;
            long j4 = (long) this.i;
            long j5 = (long) this.j;
            long j6 = (long) this.k;
            long j7 = (long) this.l;
            long j8 = (long) this.m;
            long j9 = (long) this.n;
            long j10 = (long) this.o;
            long j11 = (long) this.p;
            long j12 = (long) this.q;
            nn.a("binary", "decode mask bits=" + j2 + "|" + j3 + "|" + j4 + "|" + j5 + "|" + j6 + "|" + j7 + "|" + j8 + "|" + j9 + "|" + j10 + "|" + j11 + "|" + j12);
            long j13 = j2 + j3 + j4 + j5 + j6 + j7 + j8 + j9 + j10 + j11 + j12;
            if (j13 <= 0 || j13 > ((long) (this.f * 8))) {
                nn.b("binrary", "decode: compute δ_bits error...!");
                return -1;
            }
            long j14 = j13 - j2;
            long j15 = j14 - j3;
            long j16 = j15 - j4;
            long j17 = j16 - j5;
            long j18 = j17 - j6;
            long j19 = j18 - j7;
            long j20 = j19 - j8;
            long j21 = j20 - j9;
            long j22 = j21 - j10;
            long j23 = j22 - j11;
            long j24 = j23 - j12;
            nn.a("binary", "decode: δChairBits=" + j13 + " ,last offset=" + j24);
            if (j24 != 0) {
                nn.b("binary", "decode: compute δ_offset error...!");
                return -1;
            }
            for (Long l2 : this.s) {
                long longValue = l2.longValue();
                a aVar = new a(this);
                aVar.a = (longValue << ((int) ((64 - j14) - j2))) >>> ((int) (64 - j2));
                aVar.b = (longValue << ((int) ((64 - j15) - j3))) >>> ((int) (64 - j3));
                aVar.c = (longValue << ((int) ((64 - j16) - j4))) >>> ((int) (64 - j4));
                aVar.d = (longValue << ((int) ((64 - j17) - j5))) >>> ((int) (64 - j5));
                aVar.e = (longValue << ((int) ((64 - j18) - j6))) >>> ((int) (64 - j6));
                aVar.f = (longValue << ((int) ((64 - j19) - j7))) >>> ((int) (64 - j7));
                aVar.g = (longValue << ((int) ((64 - j20) - j8))) >>> ((int) (64 - j8));
                aVar.h = (longValue << ((int) ((64 - j21) - j9))) >>> ((int) (64 - j9));
                aVar.i = (longValue << ((int) ((64 - j22) - j10))) >>> ((int) (64 - j10));
                aVar.j = (longValue << ((int) ((64 - j23) - j11))) >>> ((int) (64 - j11));
                aVar.k = (longValue << ((int) ((64 - j24) - j12))) >>> ((int) (64 - j12));
                this.F.add(aVar);
                j24 = j24;
                j14 = j14;
            }
            g();
            nn.a("binary", "δList size=" + this.u.size() + "|" + this.v.size() + "|" + this.w.size() + "|" + this.x.size() + "|" + this.y.size() + "|" + this.z.size() + "|" + this.A.size() + "|" + this.B.size() + "|" + this.C.size() + "|" + this.D.size() + "|" + this.E.size());
            Chair chair = this.r;
            nn.a("binary", "------- base seat ： sid = " + this.r.sid + " x = " + this.r.x + " y = " + this.r.y + " fn = " + this.r.floorOrigin + " rhint = " + this.r.rowOrigin + " chint = " + this.r.chairOrigin + " plid = " + this.r.priceId + " groupId = " + this.r.groupId + " groupPriceId = " + this.r.groupPriceId + " angle = " + this.r.angle + " i = " + this.r.secondIndex);
            StringBuilder sb = new StringBuilder();
            sb.append("δChairList size=");
            sb.append(this.s.size());
            nn.a("binary", sb.toString());
            int i2 = 0;
            while (i2 < this.s.size()) {
                Chair chair2 = new Chair();
                a aVar2 = this.F.get(i2);
                chair2.sid = chair.sid + this.u.get((int) aVar2.a).longValue();
                chair2.decodeFloor(chair.floorCode + this.v.get((int) aVar2.b).intValue(), this.a.b().b());
                chair2.decodeRow(chair.rowCode + this.w.get((int) aVar2.c).intValue(), this.a.b().e());
                chair2.decodeChair(chair.chairCode + this.x.get((int) aVar2.d).intValue(), this.a.b().a());
                chair2.x = (int) (((long) chair.x) + this.y.get((int) aVar2.e).longValue());
                chair2.y = (int) (((long) chair.y) + this.z.get((int) aVar2.f).longValue());
                chair2.priceId = chair.priceId + this.A.get((int) aVar2.g).longValue();
                chair2.groupId = chair.groupId + this.B.get((int) aVar2.h).longValue();
                chair2.groupPriceId = chair.groupPriceId + this.C.get((int) aVar2.i).longValue();
                chair2.angle = (int) (((long) chair.angle) + this.D.get((int) aVar2.j).longValue());
                chair2.secondIndex = (int) (((long) chair.secondIndex) + this.E.get((int) aVar2.k).longValue());
                this.b.add(chair2);
                i2++;
                chair = chair2;
            }
            return 0;
        }
    }

    private int f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452395445")) {
            return ((Integer) ipChange.ipc$dispatch("-1452395445", new Object[]{this})).intValue();
        }
        String str = this.d;
        if (str == null || str.length() == 0) {
            return -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(this.d.length() / 2);
        this.c = allocate;
        cv0.b(allocate, this.d);
        this.c.rewind();
        if (nn.c()) {
            nn.a("binary", "decode: dest binary=" + tf2.d(this.c));
        }
        this.c.getLong();
        this.c.getShort();
        this.e = this.c.getInt();
        this.f = this.c.get();
        this.c.get();
        this.g = this.c.get();
        this.h = this.c.get();
        this.i = this.c.get();
        this.j = this.c.get();
        this.k = this.c.get();
        this.l = this.c.get();
        this.m = this.c.get();
        this.n = this.c.get();
        this.o = this.c.get();
        this.p = this.c.get();
        this.q = this.c.get();
        Chair chair = new Chair();
        this.r = chair;
        chair.sid = this.c.getLong();
        this.r.decodeFloor(this.c.getInt(), this.a.b().b());
        this.r.decodeRow(this.c.getInt(), this.a.b().e());
        this.r.decodeChair(this.c.getInt(), this.a.b().a());
        this.r.x = this.c.getInt();
        this.r.y = this.c.getInt();
        this.r.priceId = this.c.getLong();
        this.r.groupId = this.c.getLong();
        this.r.groupPriceId = this.c.getLong();
        this.r.angle = this.c.getInt();
        this.r.secondIndex = this.c.getInt();
        this.b.add(this.r);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.e - 1; i2++) {
            ByteBuffer allocate2 = ByteBuffer.allocate(this.f);
            for (int i3 = 0; i3 < this.f; i3++) {
                allocate2.put(this.c.get());
            }
            allocate2.rewind();
            arrayList.add(allocate2);
            this.s.add(Long.valueOf(ub1.a(allocate2.array())));
        }
        s30.a(arrayList, "decode: δChair(ByteBuffer)");
        s30.b(this.s, "decode: δChair(long)");
        nn.a("binary", "parserBin() done---------------------------------");
        return 0;
    }

    private void g() {
        a40 a40 = this;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "322304723")) {
            ipChange.ipc$dispatch("322304723", new Object[]{a40});
        } else if (nn.c()) {
            String str = "binary";
            nn.a(str, "decoder | δ list--------------->>>");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            Iterator<a> it = a40.F.iterator();
            while (it.hasNext()) {
                a next = it.next();
                arrayList.add(Long.valueOf(next.a));
                arrayList2.add(Long.valueOf(next.b));
                arrayList3.add(Long.valueOf(next.c));
                arrayList4.add(Long.valueOf(next.d));
                arrayList5.add(Long.valueOf(next.e));
                arrayList6.add(Long.valueOf(next.f));
                arrayList7.add(Long.valueOf(next.g));
                arrayList8.add(Long.valueOf(next.h));
                arrayList9.add(Long.valueOf(next.i));
                arrayList10.add(Long.valueOf(next.j));
                arrayList11.add(Long.valueOf(next.k));
                a40 = this;
                str = str;
            }
            s30.c(a40.u, "δSid.key");
            s30.c(arrayList, "δSid.index");
            s30.c(a40.v, "δFloor.key");
            s30.c(arrayList2, "δFloor.index");
            s30.c(a40.w, "δRow.key");
            s30.c(arrayList3, "δRow.index");
            s30.c(a40.x, "δChairId.key");
            s30.c(arrayList4, "δChairId.index");
            s30.c(a40.y, "δX.key");
            s30.c(arrayList5, "δX.index");
            s30.c(a40.z, "δY.key");
            s30.c(arrayList6, "δY.index");
            s30.c(a40.A, "δPrice.key");
            s30.c(arrayList7, "δPrice.index");
            s30.c(a40.B, "δGroupId.key");
            s30.c(arrayList8, "δGroupId.index");
            s30.c(a40.C, "δGroupPriceId.key");
            s30.c(arrayList9, "δGroupPriceId.index");
            s30.c(a40.D, "δAngle.key");
            s30.c(arrayList10, "δAngle.index");
            s30.c(a40.E, "δI.key");
            s30.c(arrayList11, "δI.index");
            nn.a(str, "decoder | δ list--------------- <<<");
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216623315")) {
            ipChange.ipc$dispatch("216623315", new Object[]{this});
        }
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867256015")) {
            return ((Integer) ipChange.ipc$dispatch("-1867256015", new Object[]{this})).intValue();
        }
        f();
        k();
        b();
        return 0;
    }

    public ArrayList<Chair> c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1033238196")) {
            return this.b;
        }
        return (ArrayList) ipChange.ipc$dispatch("1033238196", new Object[]{this});
    }

    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1426745423")) {
            return this.t;
        }
        return (String) ipChange.ipc$dispatch("1426745423", new Object[]{this});
    }

    public int e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577885017")) {
            return ((Integer) ipChange.ipc$dispatch("1577885017", new Object[]{this, str})).intValue();
        }
        this.t = str;
        return 0;
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674180497")) {
            ipChange.ipc$dispatch("-1674180497", new Object[]{this});
            return;
        }
        this.b.clear();
        this.c = null;
        this.t = null;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = new Chair();
        this.f = 0;
        this.F.clear();
        this.u.clear();
        this.v.clear();
        this.w.clear();
        this.x.clear();
        this.y.clear();
        this.z.clear();
        this.A.clear();
        this.B.clear();
        this.C.clear();
        this.D.clear();
        this.E.clear();
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068195685")) {
            ipChange.ipc$dispatch("-2068195685", new Object[]{this, str});
            return;
        }
        this.d = str;
    }

    public void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250162325")) {
            ipChange.ipc$dispatch("-1250162325", new Object[]{this, str});
            return;
        }
        this.t = str;
    }
}

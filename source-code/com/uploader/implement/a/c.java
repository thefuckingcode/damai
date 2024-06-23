package com.uploader.implement.a;

import android.text.TextUtils;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alipay.sdk.m.k.b;
import com.uploader.implement.a;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class c {
    private static volatile boolean v;
    private static volatile boolean w;
    private static final byte[] x = new byte[0];
    final boolean a;
    long b;
    long c;
    String d;
    String e;
    int f;
    int g;
    String h;
    String i;
    String j;
    long k;
    long l;
    long m;
    long n;
    long o;
    String p;
    String q;
    int r;
    long s;
    int t;
    private c u;

    c(boolean z, c cVar) {
        this.a = z;
        this.u = cVar;
    }

    private Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add(b.l);
        hashSet.add("token");
        hashSet.add(YKUpsConvert.FILEID);
        hashSet.add(TbAuthConstants.IP);
        hashSet.add("port");
        hashSet.add("ret");
        hashSet.add("errorcode");
        hashSet.add("subcode");
        hashSet.add("errormsg");
        hashSet.add("retrytimes");
        if (!this.a) {
            hashSet.add(AgooConstants.MESSAGE_ENCRYPTED);
        }
        return hashSet;
    }

    private Set<String> c() {
        HashSet hashSet = new HashSet();
        hashSet.add("connecttime");
        hashSet.add("costtime");
        hashSet.add("size");
        hashSet.add("speed");
        hashSet.add("totaltime");
        hashSet.add("md5time");
        hashSet.add("upstream");
        hashSet.add("downstream");
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x025e  */
    public String a() {
        c cVar;
        HashMap hashMap;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        HashMap hashMap2;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        HashMap hashMap3 = new HashMap();
        c cVar2 = this.u;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        int i2 = 0;
        while (cVar2 != null && !cVar2.a) {
            long j16 = cVar2.o;
            if (j16 > 0) {
                j11 = j15;
                long j17 = cVar2.n;
                if (j17 > 0) {
                    j12 += j16 - j17;
                    i2++;
                }
            } else {
                j11 = j15;
            }
            long j18 = cVar2.m;
            if (j18 > 0) {
                long j19 = cVar2.l;
                if (j19 > 0) {
                    j13 += j18 - j19;
                }
            }
            j14 += cVar2.b;
            j15 = j11 + cVar2.c;
            cVar2 = cVar2.u;
            hashMap3 = hashMap3;
        }
        if (a.d(4)) {
            StringBuilder sb = new StringBuilder();
            sb.append(hashCode());
            sb.append(" result:");
            cVar = this;
            sb.append(cVar.g);
            sb.append(" connectCountPrevious:");
            sb.append(i2);
            sb.append(" connectTimePrevious:");
            sb.append(j12);
            sb.append(" connectedTimeCurrent:");
            hashMap = hashMap3;
            sb.append(cVar.o - cVar.n);
            sb.append(" costTimePrevious:");
            sb.append(j13);
            sb.append(" costTimeCurrent:");
            sb.append(cVar.m - cVar.l);
            sb.append(" upstreamPrevious:");
            sb.append(j14);
            sb.append(" downstreamPrevious:");
            j2 = j15;
            sb.append(j2);
            a.a(4, "ActionStatistics", sb.toString());
        } else {
            cVar = this;
            hashMap = hashMap3;
            j2 = j15;
        }
        long j20 = cVar.o;
        if (j20 > 0) {
            long j21 = cVar.n;
            if (j21 > 0) {
                long j22 = j20 - j21;
                if (j12 > 0) {
                    j22 += j12;
                }
                j3 = 0 + j22;
                j4 = j22 / ((long) (i2 + 1));
                j5 = cVar.m;
                if (j5 > 0) {
                    long j23 = cVar.l;
                    if (j23 > 0) {
                        j6 = j5 - j23;
                        if (j13 > 0) {
                            j6 += j13;
                        }
                        j3 += j6;
                        if (j4 > 0) {
                            hashMap2 = hashMap;
                            hashMap2.put("connecttime", Double.valueOf((double) j4));
                        } else {
                            hashMap2 = hashMap;
                        }
                        if (j6 > 0) {
                            hashMap2.put("costtime", Double.valueOf((double) j6));
                        }
                        j7 = cVar.k;
                        if (j7 > 0) {
                            hashMap2.put("size", Double.valueOf((double) j7));
                        }
                        j8 = cVar.s;
                        if (j8 > 0) {
                            hashMap2.put("md5time", Double.valueOf((double) j8));
                        }
                        if (j3 > 0) {
                            hashMap2.put("totaltime", Double.valueOf((double) j3));
                            long j24 = cVar.k;
                            if (j24 > 0) {
                                hashMap2.put("speed", Double.valueOf((double) ((j24 * 125) / (j3 * 128))));
                            }
                        }
                        j9 = cVar.c;
                        if (j9 + j2 > 0) {
                            hashMap2.put("downstream", Double.valueOf((double) (j9 + j2)));
                        }
                        j10 = cVar.b;
                        if (j10 + j14 > 0) {
                            hashMap2.put("upstream", Double.valueOf((double) (j10 + j14)));
                        }
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put(b.l, cVar.d);
                        hashMap4.put("port", String.valueOf(cVar.f));
                        hashMap4.put(TbAuthConstants.IP, cVar.e);
                        hashMap4.put("ret", String.valueOf(cVar.g));
                        if (!TextUtils.isEmpty(cVar.h)) {
                            hashMap4.put("errorcode", cVar.h);
                        }
                        if (!TextUtils.isEmpty(cVar.i)) {
                            hashMap4.put("subcode", cVar.i);
                        }
                        if (!TextUtils.isEmpty(cVar.j)) {
                            hashMap4.put("errormsg", cVar.j);
                        }
                        if (!TextUtils.isEmpty(cVar.p)) {
                            hashMap4.put(YKUpsConvert.FILEID, cVar.p);
                        }
                        if (!TextUtils.isEmpty(cVar.q)) {
                            hashMap4.put("token", cVar.q);
                        }
                        hashMap4.put("retrytimes", String.valueOf(cVar.r));
                        if (!cVar.a) {
                            hashMap4.put(AgooConstants.MESSAGE_ENCRYPTED, String.valueOf(cVar.t));
                        }
                        if (a.d(2)) {
                            a.a(2, "ActionStatistics", "commit statistic,isDeclarationStatistics=" + cVar.a + ", dimensions:" + hashMap4 + ", measures:" + hashMap2 + " upStreamTotal:" + (cVar.b + j14) + " downstream:" + (cVar.c + j2));
                        }
                        if (cVar.a) {
                            if (!v) {
                                synchronized (x) {
                                    if (!v) {
                                        com.uploader.implement.b.c("ARUP", "RequestUpload", c(), b(), false);
                                        v = true;
                                    }
                                }
                            }
                            com.uploader.implement.b.b("ARUP", "RequestUpload", hashMap2, hashMap4);
                            return hashMap2.toString();
                        }
                        if (!w) {
                            synchronized (x) {
                                if (!w) {
                                    com.uploader.implement.b.c("ARUP", "FileUpload", c(), b(), false);
                                    w = true;
                                }
                            }
                        }
                        com.uploader.implement.b.b("ARUP", "FileUpload", hashMap2, hashMap4);
                        return hashMap2.toString();
                    }
                }
                j6 = 0;
                if (j4 > 0) {
                }
                if (j6 > 0) {
                }
                j7 = cVar.k;
                if (j7 > 0) {
                }
                j8 = cVar.s;
                if (j8 > 0) {
                }
                if (j3 > 0) {
                }
                j9 = cVar.c;
                if (j9 + j2 > 0) {
                }
                j10 = cVar.b;
                if (j10 + j14 > 0) {
                }
                HashMap hashMap42 = new HashMap();
                hashMap42.put(b.l, cVar.d);
                hashMap42.put("port", String.valueOf(cVar.f));
                hashMap42.put(TbAuthConstants.IP, cVar.e);
                hashMap42.put("ret", String.valueOf(cVar.g));
                if (!TextUtils.isEmpty(cVar.h)) {
                }
                if (!TextUtils.isEmpty(cVar.i)) {
                }
                if (!TextUtils.isEmpty(cVar.j)) {
                }
                if (!TextUtils.isEmpty(cVar.p)) {
                }
                if (!TextUtils.isEmpty(cVar.q)) {
                }
                hashMap42.put("retrytimes", String.valueOf(cVar.r));
                if (!cVar.a) {
                }
                if (a.d(2)) {
                }
                if (cVar.a) {
                }
            }
        }
        j4 = 0;
        j3 = 0;
        j5 = cVar.m;
        if (j5 > 0) {
        }
        j6 = 0;
        if (j4 > 0) {
        }
        if (j6 > 0) {
        }
        j7 = cVar.k;
        if (j7 > 0) {
        }
        j8 = cVar.s;
        if (j8 > 0) {
        }
        if (j3 > 0) {
        }
        j9 = cVar.c;
        if (j9 + j2 > 0) {
        }
        j10 = cVar.b;
        if (j10 + j14 > 0) {
        }
        HashMap hashMap422 = new HashMap();
        hashMap422.put(b.l, cVar.d);
        hashMap422.put("port", String.valueOf(cVar.f));
        hashMap422.put(TbAuthConstants.IP, cVar.e);
        hashMap422.put("ret", String.valueOf(cVar.g));
        if (!TextUtils.isEmpty(cVar.h)) {
        }
        if (!TextUtils.isEmpty(cVar.i)) {
        }
        if (!TextUtils.isEmpty(cVar.j)) {
        }
        if (!TextUtils.isEmpty(cVar.p)) {
        }
        if (!TextUtils.isEmpty(cVar.q)) {
        }
        hashMap422.put("retrytimes", String.valueOf(cVar.r));
        if (!cVar.a) {
        }
        if (a.d(2)) {
        }
        if (cVar.a) {
        }
    }
}

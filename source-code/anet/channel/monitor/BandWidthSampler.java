package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import tb.s9;

/* compiled from: Taobao */
public class BandWidthSampler {
    private static volatile boolean d = false;
    static int e = 0;
    static long f = 0;
    static long g = 0;
    static long h = 0;
    static long i = 0;
    static long j = 0;
    static double k = 0.0d;
    static double l = 0.0d;
    static double m = 0.0d;
    static double n = 40.0d;
    private int a;
    private int b;
    private a c;

    /* compiled from: Taobao */
    class a implements NetworkStatusHelper.INetworkStatusChangeListener {
        a() {
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            BandWidthSampler.this.c.a();
            BandWidthSampler.j = 0;
            BandWidthSampler.this.j();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b {
        static BandWidthSampler a = new BandWidthSampler(null);
    }

    /* synthetic */ BandWidthSampler(a aVar) {
        this();
    }

    static /* synthetic */ int d(BandWidthSampler bandWidthSampler) {
        int i2 = bandWidthSampler.b;
        bandWidthSampler.b = i2 + 1;
        return i2;
    }

    public static BandWidthSampler f() {
        return b.a;
    }

    public double g() {
        return m;
    }

    public int h() {
        if (NetworkStatusHelper.i() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.a;
    }

    public void i(final long j2, final long j3, final long j4) {
        if (d) {
            if (ALog.g(1)) {
                ALog.c("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 > 3000 && j2 < j3) {
                ThreadPoolExecutorFactory.i(new Runnable() {
                    /* class anet.channel.monitor.BandWidthSampler.AnonymousClass2 */

                    public void run() {
                        BandWidthSampler.e++;
                        BandWidthSampler.i += j4;
                        if (BandWidthSampler.e == 1) {
                            BandWidthSampler.h = j3 - j2;
                        }
                        int i = BandWidthSampler.e;
                        if (i >= 2 && i <= 3) {
                            long j = j2;
                            long j2 = BandWidthSampler.g;
                            if (j >= j2) {
                                BandWidthSampler.h += j3 - j;
                            } else if (j < j2) {
                                long j3 = j3;
                                if (j3 >= j2) {
                                    long j4 = BandWidthSampler.h + (j3 - j);
                                    BandWidthSampler.h = j4;
                                    BandWidthSampler.h = j4 - (BandWidthSampler.g - j);
                                }
                            }
                        }
                        BandWidthSampler.f = j2;
                        BandWidthSampler.g = j3;
                        if (BandWidthSampler.e == 3) {
                            BandWidthSampler.m = (double) ((long) BandWidthSampler.this.c.b((double) BandWidthSampler.i, (double) BandWidthSampler.h));
                            BandWidthSampler.j++;
                            BandWidthSampler.d(BandWidthSampler.this);
                            if (BandWidthSampler.j > 30) {
                                BandWidthSampler.this.c.a();
                                BandWidthSampler.j = 3;
                            }
                            double d = (BandWidthSampler.m * 0.68d) + (BandWidthSampler.l * 0.27d) + (BandWidthSampler.k * 0.05d);
                            BandWidthSampler.k = BandWidthSampler.l;
                            BandWidthSampler.l = BandWidthSampler.m;
                            if (BandWidthSampler.m < BandWidthSampler.k * 0.65d || BandWidthSampler.m > BandWidthSampler.k * 2.0d) {
                                BandWidthSampler.m = d;
                            }
                            int i2 = 5;
                            if (ALog.g(1)) {
                                ALog.c("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(BandWidthSampler.i), "mKalmanTimeUsed", Long.valueOf(BandWidthSampler.h), "speed", Double.valueOf(BandWidthSampler.m), "mSpeedKalmanCount", Long.valueOf(BandWidthSampler.j));
                            }
                            if (BandWidthSampler.this.b > 5 || BandWidthSampler.j == 2) {
                                s9.b().c(BandWidthSampler.m);
                                BandWidthSampler.this.b = 0;
                                BandWidthSampler bandWidthSampler = BandWidthSampler.this;
                                if (BandWidthSampler.m < BandWidthSampler.n) {
                                    i2 = 1;
                                }
                                bandWidthSampler.a = i2;
                                ALog.f("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
                            }
                            BandWidthSampler.h = 0;
                            BandWidthSampler.i = 0;
                            BandWidthSampler.e = 0;
                        }
                    }
                });
            }
        }
    }

    public synchronized void j() {
        try {
            ALog.f("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.i());
            if (NetworkStatusHelper.i() == NetworkStatusHelper.NetworkStatus.G2) {
                d = false;
                return;
            } else {
                d = true;
                return;
            }
        } catch (Exception e2) {
            ALog.j("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
    }

    public void k() {
        d = false;
    }

    private BandWidthSampler() {
        this.a = 5;
        this.b = 0;
        this.c = new a();
        NetworkStatusHelper.a(new a());
    }
}

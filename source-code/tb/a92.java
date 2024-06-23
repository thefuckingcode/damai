package tb;

import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;

/* compiled from: Taobao */
public class a92 {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final IAuth d;
    public final IHeartbeat e;
    public final DataFrameCb f;

    private a92(String str, boolean z, boolean z2, IAuth iAuth, IHeartbeat iHeartbeat, DataFrameCb dataFrameCb) {
        this.a = str;
        this.c = z2;
        this.d = iAuth;
        this.b = z;
        this.e = iHeartbeat;
        this.f = dataFrameCb;
    }

    public static a92 a(String str, boolean z, boolean z2, IAuth iAuth, IHeartbeat iHeartbeat, DataFrameCb dataFrameCb) {
        return new a92(str, z, z2, iAuth, iHeartbeat, dataFrameCb);
    }
}

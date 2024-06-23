package tb;

import anetwork.channel.Param;

/* compiled from: Taobao */
public class nf2 implements Param {
    private String a;
    private String b;

    public nf2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // anetwork.channel.Param
    public String getKey() {
        return this.a;
    }

    @Override // anetwork.channel.Param
    public String getValue() {
        return this.b;
    }
}

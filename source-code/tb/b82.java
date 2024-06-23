package tb;

import anet.channel.security.ISecurity;
import anet.channel.security.ISecurityFactory;

/* compiled from: Taobao */
public class b82 {
    private static volatile ISecurityFactory a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ISecurityFactory {
        a() {
        }

        @Override // anet.channel.security.ISecurityFactory
        public ISecurity createNonSecurity(String str) {
            return new ui1(str);
        }

        @Override // anet.channel.security.ISecurityFactory
        public ISecurity createSecurity(String str) {
            return new a82(str);
        }
    }

    public static ISecurityFactory a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }
}

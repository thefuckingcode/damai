package tb;

import com.taobao.phenix.intf.IPhenixTicket;

/* compiled from: Taobao */
public class cq1 implements IPhenixTicket {
    private c02 a;
    protected String b = "";
    boolean c = false;

    public cq1(c02 c02) {
        this.a = c02;
    }

    public boolean a() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
        if (z) {
            this.a = null;
        }
    }

    public void c(String str) {
        this.b = str;
    }

    @Override // com.taobao.phenix.intf.IPhenixTicket
    public boolean cancel() {
        c02 c02;
        synchronized (this) {
            c02 = this.a;
            this.a = null;
        }
        if (c02 == null) {
            return false;
        }
        c02.b();
        return false;
    }

    @Override // com.taobao.phenix.intf.IPhenixTicket
    public boolean theSame(String str) {
        String str2 = this.b;
        return str2 != null && str2.compareToIgnoreCase(str) == 0;
    }
}

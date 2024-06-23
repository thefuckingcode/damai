package tb;

import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
public class f11 {
    public up a;
    public lb2 b;
    public URL c;
    public File d;
    public File e;

    public f11(lb2 lb2) {
        this.b = lb2;
        this.a = new up(lb2);
    }

    public int a() {
        long j = this.b.e.b;
        if (0 == j || j == this.d.length()) {
            return !wb1.c(this.b.e.c, this.d.getAbsolutePath()) ? -15 : -14;
        }
        return -18;
    }

    public long b() {
        if (!this.d.exists()) {
            return 0;
        }
        long length = this.d.length();
        long j = this.b.e.b;
        if (0 == j || length < j) {
            return length;
        }
        this.d.delete();
        return 0;
    }

    public RandomAccessFile c() throws FileNotFoundException {
        return new RandomAccessFile(this.d, "rw");
    }

    public boolean d() {
        if (this.e.exists()) {
            long j = this.b.e.b;
            if ((0 == j || j == this.e.length()) && wb1.c(this.b.e.c, this.e.getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        u21 u21 = this.b.e;
        if ((0 == u21.b && TextUtils.isEmpty(u21.c)) || !this.d.exists()) {
            return false;
        }
        long j = this.b.e.b;
        if ((0 == j || j == this.d.length()) && wb1.c(this.b.e.c, this.d.getAbsolutePath())) {
            return true;
        }
        return false;
    }

    public boolean f(long j, int i) {
        if (200 != i && 206 != i) {
            return false;
        }
        if (j <= 0) {
            return true;
        }
        if (206 == i) {
            j += this.d.length();
        } else if (200 != i) {
            j = 0;
        }
        if (j != 0) {
            long j2 = this.b.e.b;
            if (!(j2 == 0 || j == j2)) {
                return false;
            }
        }
        u21 u21 = this.b.e;
        if (0 != u21.b) {
            return true;
        }
        u21.b = j;
        return true;
    }

    public void g() throws MalformedURLException {
        if (this.c == null) {
            this.c = new URL(this.b.e.a);
            this.e = new File(this.b.g, TextUtils.isEmpty(this.b.e.d) ? new File(this.c.getFile()).getName() : this.b.e.d);
            lb2 lb2 = this.b;
            File file = new File(lb2.g, wb1.b(lb2.e.a));
            this.d = file;
            if (!file.getParentFile().exists()) {
                this.d.getParentFile().mkdirs();
            }
            if (!this.d.getParentFile().canWrite()) {
                this.d.getParentFile().setWritable(true);
            }
            lb2 lb22 = this.b;
            if (!lb22.f.m && TextUtils.isEmpty(lb22.e.c)) {
                this.e.delete();
                this.d.delete();
            }
        }
    }
}

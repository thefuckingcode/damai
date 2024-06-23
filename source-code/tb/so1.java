package tb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;

/* compiled from: Taobao */
public class so1 extends BitmapDrawable {
    private Rect a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;

    public so1(Resources resources, Bitmap bitmap, Rect rect, String str, String str2, int i, int i2) {
        super(resources, bitmap);
        this.a = rect;
        this.f = (bitmap == null || bitmap.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk())) ? false : true;
        f(str, str2, i, i2);
    }

    private void f(String str, String str2, int i, int i2) {
        this.b = str;
    }

    public NinePatchDrawable a() {
        if (!this.f) {
            return null;
        }
        Bitmap bitmap = getBitmap();
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        Rect rect = this.a;
        if (rect == null) {
            rect = new Rect();
        }
        return new NinePatchDrawable(bitmap, ninePatchChunk, rect, null);
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public String e() {
        return this.b;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.c;
    }

    public String toString() {
        return getClass().getSimpleName() + jl1.BRACKET_START_STR + Integer.toHexString(hashCode()) + ", key@" + this.b + jl1.BRACKET_END_STR;
    }

    public so1(String str, String str2, int i, int i2) {
        f(str, str2, i, i2);
    }
}

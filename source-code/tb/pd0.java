package tb;

import android.content.res.AssetManager;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.taobao.tcommon.core.BytesPool;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class pd0 extends r02 {
    public final boolean g;
    protected boolean h;

    private pd0(int i, boolean z, byte[] bArr, int i2, InputStream inputStream, int i3, TypedValue typedValue) {
        super(i, bArr, i2, inputStream, i3, typedValue);
        boolean z2 = true;
        if (i == 1) {
            this.g = (!z || bArr == null || bArr.length - i2 < i3) ? false : z2;
        } else {
            this.g = z;
        }
    }

    public static pd0 c(@NonNull r02 r02, ye2 ye2) throws Exception {
        int i = r02.a;
        if (i == 3) {
            InputStream inputStream = r02.e;
            if ((inputStream instanceof FileInputStream) || (inputStream instanceof AssetManager.AssetInputStream)) {
                return new pd0(inputStream, r02.b, r02.f);
            }
            BytesPool a = tp1.o().c().build();
            if (ye2 == null) {
                return ze2.a(inputStream, a, new int[]{r02.b});
            }
            ze2.b(inputStream, a, ye2);
            return ye2.a();
        } else if (i == 1) {
            return new pd0(r02.c, r02.d, r02.b);
        } else {
            throw new RuntimeException("unrecognized response type: " + r02.a);
        }
    }

    public boolean a() {
        int i;
        int i2;
        if (this.h || (i = this.b) <= 0) {
            return false;
        }
        if (this.a == 1) {
            if (this.c == null || (i2 = this.d) < 0 || i2 >= i) {
                return false;
            }
            return true;
        } else if (this.e != null) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void b(boolean z) {
        InputStream inputStream;
        if (this.h) {
            if (z) {
                vr2.i("EncodedData", "has been released when trying to release it[type: %d]", Integer.valueOf(this.a));
            }
            return;
        }
        if (!z) {
            vr2.i("EncodedData", "final release called from finalize[type: %d]", Integer.valueOf(this.a));
        }
        int i = this.a;
        if (i == 1) {
            BytesPool a = tp1.o().c().build();
            if (a != null) {
                a.release(this.c);
            }
        } else if (i == 3 && (inputStream = this.e) != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        this.h = true;
    }

    @Override // com.taobao.rxm.common.Releasable, tb.r02
    public synchronized void release() {
        b(true);
    }

    protected pd0(pd0 pd0) {
        this(pd0.a, pd0.g, pd0.c, pd0.d, pd0.e, pd0.b, pd0.f);
    }

    public pd0(InputStream inputStream, int i, TypedValue typedValue) {
        this(3, true, null, 0, inputStream, i, typedValue);
    }

    public pd0(boolean z, byte[] bArr, int i, int i2) {
        this(1, z, bArr, i, null, i2, null);
    }

    public pd0(byte[] bArr, int i, int i2) {
        this(1, true, bArr, i, null, i2, null);
    }
}

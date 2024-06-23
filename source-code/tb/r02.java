package tb;

import android.util.TypedValue;
import com.taobao.rxm.common.Releasable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class r02 implements Releasable {
    public static final int TYPE_BYTE_ARRAY = 1;
    public static final int TYPE_INPUT_STREAM = 3;
    public final int a;
    public final int b;
    public final byte[] c;
    public final int d;
    public final InputStream e;
    public TypedValue f;

    public r02(byte[] bArr, int i, int i2) {
        this(1, bArr, i, null, i2, null);
    }

    @Override // com.taobao.rxm.common.Releasable
    public void release() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public r02(InputStream inputStream, int i) {
        this(3, null, 0, inputStream, i, null);
    }

    public r02(InputStream inputStream, int i, TypedValue typedValue) {
        this(3, null, 0, inputStream, i, typedValue);
    }

    protected r02(int i, byte[] bArr, int i2, InputStream inputStream, int i3, TypedValue typedValue) {
        this.a = i;
        this.c = bArr;
        this.d = i2;
        this.e = inputStream;
        this.b = i3;
        this.f = typedValue;
    }
}

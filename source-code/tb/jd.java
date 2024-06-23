package tb;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class jd extends nb {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final jd INSTANCE = new jd(1, 0, 7);
    @JvmField
    @NotNull
    public static final jd INVALID_VERSION = new jd(new int[0]);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final jd a(@NotNull InputStream inputStream) {
            k21.i(inputStream, lf1.RESOURCE_STREAM);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            w11 w11 = new w11(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(n.q(w11, 10));
            Iterator it = w11.iterator();
            while (it.hasNext()) {
                ((r11) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArr = CollectionsKt___CollectionsKt.x0(arrayList);
            int[] iArr2 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return new jd(iArr2);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public jd(@NotNull int... iArr) {
        super(r0);
        k21.i(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
    }

    public boolean h() {
        return f(INSTANCE);
    }
}

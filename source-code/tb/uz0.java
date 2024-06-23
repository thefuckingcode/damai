package tb;

import com.alibaba.pictures.bricks.util.htmlparser.b;
import java.io.File;
import java.util.Comparator;

/* compiled from: Taobao */
public final /* synthetic */ class uz0 implements Comparator {
    public static final /* synthetic */ uz0 a = new uz0();

    private /* synthetic */ uz0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return b.d((File) obj, (File) obj2);
    }
}

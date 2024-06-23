package tb;

import android.graphics.Path;
import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.ui.component.WXComponent;
import java.util.StringTokenizer;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class x22 {
    private final String a;
    private Path b;

    public x22(@NotNull String str) {
        k21.j(str, "originValue");
        this.a = StringsKt__StringsKt.Q(str, ",", false, 2, null) ? o.F(str, ",", " ", false, 4, null) : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0119  */
    private final void b(Path path, String str, StringTokenizer stringTokenizer) {
        z22 z22;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                String nextToken = stringTokenizer.nextToken();
                if (!(nextToken.length() == 0)) {
                    if (i == 0) {
                        f = Float.parseFloat(nextToken);
                    }
                    if (i == 1) {
                        f2 = Float.parseFloat(nextToken);
                    }
                    if (i == 2) {
                        f3 = Float.parseFloat(nextToken);
                    }
                    if (i == 3) {
                        f4 = Float.parseFloat(nextToken);
                    }
                    if (i == 4) {
                        f5 = Float.parseFloat(nextToken);
                    }
                    if (i == 5) {
                        f6 = Float.parseFloat(nextToken);
                    }
                    i++;
                }
            } catch (Exception unused) {
            }
        }
        z22 z222 = new z22(0.0f, 0.0f, 0.0f);
        if (k21.d(str, "M")) {
            path.moveTo(f, f2);
            z222 = new z22(f, f2, 0.0f);
        } else if (k21.d(str, WXComponent.PROP_FS_MATCH_PARENT)) {
            path.rMoveTo(f, f2);
            z22 = new z22(z222.a() + f, z222.b() + f2, 0.0f);
            if (!k21.d(str, "L")) {
                path.lineTo(f, f2);
            } else if (k21.d(str, NotifyType.LIGHTS)) {
                path.rLineTo(f, f2);
            }
            if (!k21.d(str, "C")) {
                path.cubicTo(f, f2, f3, f4, f5, f6);
            } else if (k21.d(str, c.a)) {
                path.rCubicTo(f, f2, f3, f4, f5, f6);
            }
            if (!k21.d(str, "Q")) {
                path.quadTo(f, f2, f3, f4);
            } else if (k21.d(str, "q")) {
                path.rQuadTo(f, f2, f3, f4);
            }
            if (!k21.d(str, "H")) {
                path.lineTo(f, z22.b());
            } else if (k21.d(str, "h")) {
                path.rLineTo(f, 0.0f);
            }
            if (!k21.d(str, "V")) {
                path.lineTo(z22.a(), f);
            } else if (k21.d(str, "v")) {
                path.rLineTo(0.0f, f);
            }
            if (!k21.d(str, "Z")) {
                path.close();
                return;
            } else if (k21.d(str, "z")) {
                path.close();
                return;
            } else {
                return;
            }
        }
        z22 = z222;
        if (!k21.d(str, "L")) {
        }
        if (!k21.d(str, "C")) {
        }
        if (!k21.d(str, "Q")) {
        }
        if (!k21.d(str, "H")) {
        }
        if (!k21.d(str, "V")) {
        }
        if (!k21.d(str, "Z")) {
        }
    }

    public final void a(@NotNull Path path) {
        k21.j(path, "toPath");
        Path path2 = this.b;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!(nextToken.length() == 0)) {
                if (y22.a().contains(nextToken)) {
                    k21.e(nextToken, "segment");
                    if (k21.d(nextToken, "Z") || k21.d(nextToken, "z")) {
                        b(path3, nextToken, new StringTokenizer("", ""));
                    }
                    str = nextToken;
                } else {
                    b(path3, str, new StringTokenizer(nextToken, " "));
                }
            }
        }
        this.b = path3;
        path.set(path3);
    }
}

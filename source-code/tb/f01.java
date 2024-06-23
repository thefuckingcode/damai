package tb;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.alibaba.pictures.bricks.coupon.view.ImageConfig;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class f01 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final f01 INSTANCE = new f01();

    private f01() {
    }

    private final String a(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625499111")) {
            return (String) ipChange.ipc$dispatch("625499111", new Object[]{this, str, Integer.valueOf(i)});
        }
        h01 h01 = h01.INSTANCE;
        ImageConfig b = h01.b(str, -1, -1);
        b.m(false);
        b.o(true);
        b.l(ImageConfig.DMImageCropType.cy500);
        b.k(i);
        return h01.c(str, b);
    }

    private final boolean b(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-56233250")) {
            return i > 0 && i2 > 0 && ((long) (i2 * i)) > 640000;
        }
        return ((Boolean) ipChange.ipc$dispatch("-56233250", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
    }

    private final List<HtmlParserManager.b> d(HtmlParserManager.b bVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881265819")) {
            return (List) ipChange.ipc$dispatch("1881265819", new Object[]{this, bVar, Integer.valueOf(i)});
        }
        ArrayList arrayList = new ArrayList();
        if (!b(bVar.c(), bVar.b()) || !h01.INSTANCE.d(String.valueOf(bVar.a()))) {
            arrayList.add(bVar);
        } else {
            int b = bVar.b() / 500;
            if (bVar.b() % 500 > 0) {
                b++;
            }
            for (int i2 = 0; i2 < b; i2++) {
                String a = a(String.valueOf(bVar.a()), i2);
                if (!a.equals(String.valueOf(bVar.a()))) {
                    HtmlParserManager.b bVar2 = new HtmlParserManager.b();
                    bVar2.m(bVar.f());
                    bVar2.l(i);
                    bVar2.h(new SpannableStringBuilder().append((CharSequence) new SpannableString(a)));
                    arrayList.add(bVar2);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<HtmlParserManager.b> c(@Nullable List<HtmlParserManager.b> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1991370257")) {
            return (List) ipChange.ipc$dispatch("-1991370257", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (HtmlParserManager.b bVar : list) {
                if (bVar.f() == 2) {
                    arrayList.addAll(INSTANCE.d(bVar, i));
                } else {
                    arrayList.add(bVar);
                }
                i++;
            }
        }
        return arrayList;
    }
}

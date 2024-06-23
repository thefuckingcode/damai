package tb;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Random;

/* compiled from: Taobao */
public class ft0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;

    public ft0(int i) {
        f(i);
    }

    private int[] b() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931994084")) {
            return (int[]) ipChange.ipc$dispatch("1931994084", new Object[]{this});
        }
        int i = this.a;
        String str2 = "#FF7CA7";
        if (i == 0) {
            str2 = "#FF8C50";
            str = "#FFCC6E";
        } else if (i == 1) {
            str = str2;
        } else if (i == 2) {
            str2 = "#61C4FF";
            str = "#5BE0E2";
        } else if (i == 3) {
            str2 = "#BA80FF";
            str = "#B7ACFF";
        } else if (i != 4) {
            str2 = "#8F8FFF";
            str = "#AAC4FF";
        } else {
            str2 = "#26D9D5";
            str = "#5CE7C3";
        }
        return new int[]{Color.parseColor(str2), Color.parseColor(str)};
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1604023980")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-1604023980", new Object[]{this})).intValue();
    }

    public GradientDrawable c(GradientDrawable.Orientation orientation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "224468177")) {
            return d(orientation, 0.0f);
        }
        return (GradientDrawable) ipChange.ipc$dispatch("224468177", new Object[]{this, orientation});
    }

    public GradientDrawable d(GradientDrawable.Orientation orientation, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156055773")) {
            return (GradientDrawable) ipChange.ipc$dispatch("-156055773", new Object[]{this, orientation, Float.valueOf(f)});
        }
        return e(orientation, new float[]{f, f, f, f, f, f, f, f}, b());
    }

    public GradientDrawable e(GradientDrawable.Orientation orientation, float[] fArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868009368")) {
            return (GradientDrawable) ipChange.ipc$dispatch("1868009368", new Object[]{this, orientation, fArr, iArr});
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874741198")) {
            ipChange.ipc$dispatch("874741198", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > 5) {
            i = 5;
        }
        this.a = i;
    }

    public ft0() {
        f(new Random().nextInt(6));
    }
}

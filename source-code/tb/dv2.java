package tb;

/* compiled from: Taobao */
public class dv2 extends f40 {
    private static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        int i2 = 0;
        while (i < min) {
            i2 = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
            if (i2 != 0) {
                break;
            }
            i++;
        }
        if (i2 == 0) {
            for (int i3 = i; i3 < split.length; i3++) {
                if (Integer.parseInt(split[i3]) > 0) {
                    return 1;
                }
            }
            while (i < split2.length) {
                if (Integer.parseInt(split2[i]) > 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        } else if (i2 > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean equals(String str, String str2) {
        return str.equals(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean equalsNot(String str, String str2) {
        return !str.equals(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean fuzzy(String str, String str2) {
        return str.startsWith(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean fuzzyNot(String str, String str2) {
        return !str.startsWith(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean greater(String str, String str2) {
        return a(str, str2) == 1;
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean greaterEquals(String str, String str2) {
        return a(str, str2) != -1;
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean less(String str, String str2) {
        return a(str, str2) == -1;
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean lessEquals(String str, String str2) {
        return a(str, str2) != 1;
    }
}

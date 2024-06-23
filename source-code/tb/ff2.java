package tb;

/* compiled from: Taobao */
public class ff2 extends f40 {
    @Override // com.taobao.slide.compare.ICompare
    public boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean equalsNot(String str, String str2) {
        if (str == null) {
            return str2 != null;
        }
        return !str.equals(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean fuzzy(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    @Override // com.taobao.slide.compare.ICompare, tb.f40
    public boolean fuzzyNot(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return !str.startsWith(str2);
    }
}

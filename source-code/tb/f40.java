package tb;

import android.text.TextUtils;
import com.taobao.slide.compare.ICompare;

/* compiled from: Taobao */
public class f40 implements ICompare {
    @Override // com.taobao.slide.compare.ICompare
    public boolean equalsNot(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean fuzzy(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean fuzzyNot(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean greater(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean greaterEquals(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean in(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            o22.e("DefCompare", "IN extention null", "clientVal", str, "serverVal", str2);
            return false;
        }
        String[] split = str2.split(",");
        if (split == null && split.length == 0) {
            o22.e("DefCompare", "IN extention invalid", new Object[0]);
            return false;
        }
        for (String str3 : split) {
            if (str.equals(str3)) {
                o22.g("DefCompare", "IN matched", new Object[0]);
                return true;
            }
        }
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean less(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean lessEquals(String str, String str2) {
        return false;
    }

    @Override // com.taobao.slide.compare.ICompare
    public boolean notIn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            o22.e("DefCompare", "notIN extention null", "clientVal", str, "serverVal", str2);
            return false;
        }
        String[] split = str2.split(",");
        if (split == null && split.length == 0) {
            o22.e("DefCompare", "notIN extention invalid", new Object[0]);
            return false;
        }
        for (String str3 : split) {
            if (str.equals(str3)) {
                o22.e("DefCompare", "IN matched", new Object[0]);
                return false;
            }
        }
        return true;
    }
}

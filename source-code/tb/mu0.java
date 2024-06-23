package tb;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class mu0 extends f40 {
    private static Pattern a = Pattern.compile("\\d+");

    @Override // com.taobao.slide.compare.ICompare
    public boolean equals(String str, String str2) {
        Matcher matcher = a.matcher(str2);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(matcher.group())));
        }
        if (arrayList.size() == 3) {
            long g = uk.g(str) % ((long) ((Integer) arrayList.get(0)).intValue());
            if (g < ((long) ((Integer) arrayList.get(1)).intValue()) || g > ((long) ((Integer) arrayList.get(2)).intValue())) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("did_hash exp format is illegal");
    }
}

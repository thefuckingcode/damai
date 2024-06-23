package com.taobao.orange.candidate;

import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class HashCompare extends DefCandidateCompare {
    private static final String TAG = "HashCompare";
    private static Pattern p = Pattern.compile("\\d+");

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean equals(String str, String str2) {
        Matcher matcher = p.matcher(str2);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(matcher.group())));
        }
        if (arrayList.size() == 3) {
            long hash = OrangeUtils.hash(str) % ((long) ((Integer) arrayList.get(0)).intValue());
            if (OLog.isPrintLog(0)) {
                OLog.v(TAG, "equals", "mod", Long.valueOf(hash));
            }
            if (hash < ((long) ((Integer) arrayList.get(1)).intValue()) || hash > ((long) ((Integer) arrayList.get(2)).intValue())) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("did_hash candidate format is illegal");
    }
}

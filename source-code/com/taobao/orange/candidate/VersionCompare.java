package com.taobao.orange.candidate;

/* compiled from: Taobao */
public class VersionCompare extends DefCandidateCompare {
    private static int compareVersion(String str, String str2) {
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

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean equals(String str, String str2) {
        return str.equals(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean equalsNot(String str, String str2) {
        return !str.equals(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean fuzzy(String str, String str2) {
        return str.startsWith(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean fuzzyNot(String str, String str2) {
        return !str.startsWith(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean greater(String str, String str2) {
        return compareVersion(str, str2) == 1;
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean greaterEquals(String str, String str2) {
        return compareVersion(str, str2) != -1;
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean less(String str, String str2) {
        return compareVersion(str, str2) == -1;
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean lessEquals(String str, String str2) {
        return compareVersion(str, str2) != 1;
    }
}

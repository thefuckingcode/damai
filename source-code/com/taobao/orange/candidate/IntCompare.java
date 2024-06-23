package com.taobao.orange.candidate;

/* compiled from: Taobao */
public class IntCompare extends DefCandidateCompare {
    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean equals(String str, String str2) {
        return Integer.parseInt(str) == Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean equalsNot(String str, String str2) {
        return Integer.parseInt(str) != Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean greater(String str, String str2) {
        return Integer.parseInt(str) > Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean greaterEquals(String str, String str2) {
        return Integer.parseInt(str) >= Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean less(String str, String str2) {
        return Integer.parseInt(str) < Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.ICandidateCompare, com.taobao.orange.candidate.DefCandidateCompare
    public boolean lessEquals(String str, String str2) {
        return Integer.parseInt(str) <= Integer.parseInt(str2);
    }
}

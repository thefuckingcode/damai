package com.taobao.orange.candidate;

/* compiled from: Taobao */
public class StringCompare extends DefCandidateCompare {
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
}

package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import tb.jl1;

@Beta
@GwtCompatible
/* compiled from: Taobao */
public enum PublicSuffixType {
    PRIVATE(jl1.CONDITION_IF_MIDDLE, ','),
    REGISTRY('!', jl1.CONDITION_IF);
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    private PublicSuffixType(char c, char c2) {
        this.innerNodeCode = c;
        this.leafNodeCode = c2;
    }

    static PublicSuffixType fromCode(char c) {
        PublicSuffixType[] values = values();
        for (PublicSuffixType publicSuffixType : values) {
            if (publicSuffixType.getInnerNodeCode() == c || publicSuffixType.getLeafNodeCode() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c);
    }

    static PublicSuffixType fromIsPrivate(boolean z) {
        return z ? PRIVATE : REGISTRY;
    }

    /* access modifiers changed from: package-private */
    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    /* access modifiers changed from: package-private */
    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}

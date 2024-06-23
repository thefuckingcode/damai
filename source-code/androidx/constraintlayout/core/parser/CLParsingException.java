package androidx.constraintlayout.core.parser;

import tb.jl1;

/* compiled from: Taobao */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String str, CLElement cLElement) {
        this.mReason = str;
        if (cLElement != null) {
            this.mElementClass = cLElement.getStrClass();
            this.mLineNumber = cLElement.getLine();
            return;
        }
        this.mElementClass = "unknown";
        this.mLineNumber = 0;
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + jl1.BRACKET_END_STR;
    }

    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}

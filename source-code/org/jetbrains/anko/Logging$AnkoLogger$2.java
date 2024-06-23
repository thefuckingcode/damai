package org.jetbrains.anko;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"org/jetbrains/anko/Logging$AnkoLogger$2", "Lorg/jetbrains/anko/AnkoLogger;", "loggerTag", "", "getLoggerTag", "()Ljava/lang/String;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Logging.kt */
public final class Logging$AnkoLogger$2 implements AnkoLogger {
    final /* synthetic */ String $tag;
    private final String loggerTag;

    Logging$AnkoLogger$2(String str) {
        this.$tag = str;
        str.length();
        this.loggerTag = str;
    }

    @Override // org.jetbrains.anko.AnkoLogger
    public String getLoggerTag() {
        return this.loggerTag;
    }
}

package org.jetbrains.anko;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lorg/jetbrains/anko/AnkoLogger;", "", "loggerTag", "", "getLoggerTag", "()Ljava/lang/String;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Logging.kt */
public interface AnkoLogger {
    String getLoggerTag();

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
    /* compiled from: Logging.kt */
    public static final class DefaultImpls {
        public static String getLoggerTag(AnkoLogger ankoLogger) {
            return Logging.getTag(ankoLogger.getClass());
        }
    }
}

package mtopsdk.framework.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface FilterResult {
    public static final String CONTINUE = "CONTINUE";
    public static final String STOP = "STOP";

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Definition {
    }
}

package mtopsdk.mtop.cache;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface CacheHitType {
    public static final int HIT_CACHE_THEN_GO_ON = 3;
    public static final int HIT_EXPIRED_CACHE_THEN_RETURN = 2;
    public static final int HIT_FRESH_CACHE_THEN_RETURN = 1;
    public static final int HIT_NOTHING = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Definition {
    }
}

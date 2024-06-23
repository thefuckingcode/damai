package mtopsdk.mtop.intf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface MtopParamType {
    public static final String ABTEST = "ABTEST";
    public static final String HEADER = "HEADER";
    public static final String QUERY = "QUERY";

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Definition {
    }
}

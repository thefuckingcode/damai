package mtopsdk.mtop.cache.domain;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Objects;
import mtopsdk.common.util.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public class ApiCacheDo implements Serializable {
    private static final long serialVersionUID = -6169477447314447135L;
    public String api;
    public String blockName;
    public String cacheControlHeader;
    public List<String> cacheKeyItems;
    public String cacheKeyType = "ALL";
    public boolean offline = false;
    public boolean privateScope = true;
    public String v;

    /* compiled from: Taobao */
    public interface CacheKeyType {
        public static final String ALL = "ALL";
        public static final String EXC = "EXC";
        public static final String INC = "INC";
        public static final String NONE = "NONE";

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: Taobao */
        public @interface Definition {
        }
    }

    public ApiCacheDo(String str, String str2, String str3) {
        this.api = str;
        this.v = str2;
        this.blockName = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiCacheDo)) {
            return false;
        }
        ApiCacheDo apiCacheDo = (ApiCacheDo) obj;
        if (this.privateScope != apiCacheDo.privateScope || this.offline != apiCacheDo.offline || !Objects.equals(this.api, apiCacheDo.api) || !Objects.equals(this.v, apiCacheDo.v) || !Objects.equals(this.blockName, apiCacheDo.blockName) || !Objects.equals(this.cacheControlHeader, apiCacheDo.cacheControlHeader) || !Objects.equals(this.cacheKeyType, apiCacheDo.cacheKeyType) || !Objects.equals(this.cacheKeyItems, apiCacheDo.cacheKeyItems)) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return StringUtils.concatStr2LowerCase(this.api, this.v);
    }

    public int hashCode() {
        return Objects.hash(this.api, this.v, this.blockName, this.cacheControlHeader, Boolean.valueOf(this.privateScope), Boolean.valueOf(this.offline), this.cacheKeyType, this.cacheKeyItems);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("ApiCacheDo [ api=");
        sb.append(this.api);
        sb.append(", v=");
        sb.append(this.v);
        sb.append(", blockName=");
        sb.append(this.blockName);
        sb.append(", cacheControlHeader=");
        sb.append(this.cacheControlHeader);
        sb.append(", privateScope=");
        sb.append(this.privateScope);
        sb.append(", offline=");
        sb.append(this.offline);
        sb.append(", cacheKeyType=");
        sb.append(this.cacheKeyType);
        sb.append(", cacheKeyItems=");
        sb.append(this.cacheKeyItems);
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }
}

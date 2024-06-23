package mtopsdk.mtop.domain;

/* compiled from: Taobao */
public enum ApiTypeEnum {
    ISV_OPEN_API("isv_open_api");
    
    private String apiType;

    private ApiTypeEnum(String str) {
        this.apiType = str;
    }

    public String getApiType() {
        return this.apiType;
    }
}

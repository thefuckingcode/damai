package mtopsdk.mtop.domain;

/* compiled from: Taobao */
public enum ProtocolEnum {
    HTTP("http://"),
    HTTPSECURE("https://");
    
    private String protocol;

    private ProtocolEnum(String str) {
        this.protocol = str;
    }

    public String getProtocol() {
        return this.protocol;
    }
}

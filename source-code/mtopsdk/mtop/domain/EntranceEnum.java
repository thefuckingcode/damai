package mtopsdk.mtop.domain;

/* compiled from: Taobao */
public enum EntranceEnum {
    GW_INNER("gw"),
    GW_OPEN("gw-open");
    
    private String entrance;

    private EntranceEnum(String str) {
        this.entrance = str;
    }

    public String getEntrance() {
        return this.entrance;
    }
}

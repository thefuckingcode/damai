package cn.damai.seatdecoder;

/* compiled from: Taobao */
public enum DataCotentType {
    SEAT_STATIC_DATA("seat_static_data"),
    SEAT_VR_DATA("seat_vr_data");
    
    private String name;

    private DataCotentType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}

package cn.damai.seatdecoder.common.decoder;

/* compiled from: Taobao */
public enum DecoderType {
    PB_GZIP(2, "pb_gzip"),
    QUANTUM_GZIP(3, "quantum_gzip");
    
    private String name;
    private int value;

    private DecoderType(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}

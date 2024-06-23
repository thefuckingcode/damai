package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
public enum Codec {
    H264(0),
    H265(1),
    AV1(2);
    
    private final int mValue;

    private Codec(int i) {
        this.mValue = i;
    }

    public static Codec getCodecByValue(int i) {
        Codec[] values = values();
        for (Codec codec : values) {
            if (codec.getValue() == i) {
                return codec;
            }
        }
        return H264;
    }

    public int getValue() {
        return this.mValue;
    }
}

package com.alipay.ma;

/* compiled from: Taobao */
public enum EngineType {
    ALL(0),
    BAR(1),
    QRCODE(2),
    DEFAULT(3),
    LOTTERY(4);
    
    public int type;

    private EngineType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public static EngineType getType(int i) {
        EngineType[] values = values();
        for (EngineType engineType : values) {
            if (engineType.type == i) {
                return engineType;
            }
        }
        return DEFAULT;
    }
}

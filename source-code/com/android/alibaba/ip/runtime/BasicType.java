package com.android.alibaba.ip.runtime;

/* compiled from: Taobao */
public enum BasicType {
    I(Integer.TYPE),
    J(Long.TYPE),
    C(Character.TYPE),
    Z(Boolean.TYPE),
    F(Float.TYPE),
    D(Double.TYPE),
    V(Void.TYPE);
    
    private final Class<?> primitiveJavaType;

    private BasicType(Class cls) {
        this.primitiveJavaType = cls;
    }

    public static BasicType parse(String str) {
        BasicType[] values = values();
        for (BasicType basicType : values) {
            if (basicType.getJavaType().getName().equals(str)) {
                return basicType;
            }
        }
        return null;
    }

    public Class getJavaType() {
        return this.primitiveJavaType;
    }
}

package cn.damai.projectfiltercopy.bean;

/* compiled from: Taobao */
public enum Type {
    DATE_HOR_CALENDAR(1.0f),
    DATE(1.0f),
    CITY(1.0f),
    SORT(1.0f),
    FILTER(0.8f),
    NEW_CATEGORY(1.3f);
    
    public final float widthWeight;

    private Type(float f) {
        this.widthWeight = f;
    }
}

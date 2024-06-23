package cn.damai.solid.bean;

/* compiled from: Taobao */
public enum SoGroupEnum {
    VR("damaivrso"),
    FLUTTER("damaiflutterso"),
    WEEX("damaiweex");
    
    public final String soGroupName;

    private SoGroupEnum(String str) {
        this.soGroupName = str;
    }
}

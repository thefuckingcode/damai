package cn.damai.onearch.component.scripttag;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class ScriptTagBean implements Serializable {
    public String componentType;
    public List<Tag> lineItem;
    public String name;
    public String option;

    /* compiled from: Taobao */
    public static class Tag implements Serializable {
        public String name;
        public String value;
    }
}

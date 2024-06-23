package cn.damai.commonbusiness.calendarcopy.bean;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: Taobao */
public class DispatchDesc implements Serializable {
    public String color;
    public String desc;

    /* compiled from: Taobao */
    public enum TYPE {
        YELLOW("YELLOW", 0),
        PINK("PINK", 1),
        PURPLE("PURPLE", 2),
        BLUE("BLUE", 3);
        
        private int index = 0;
        private String typeName;

        private TYPE(String str, int i) {
            this.typeName = str;
            this.index = i;
        }

        public static TYPE fromTypeName(String str) {
            TYPE[] values = values();
            for (TYPE type : values) {
                if (type.getTypeName().equals(str)) {
                    return type;
                }
            }
            return PINK;
        }

        public boolean equals(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.typeName.equals(str);
        }

        public String getTypeName() {
            return this.typeName;
        }

        public int toIndex() {
            return this.index;
        }
    }
}

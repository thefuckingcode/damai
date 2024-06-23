package cn.damai.common.db.db.sqlite;

/* compiled from: Taobao */
public enum ColumnDbType {
    INTEGER("INTEGER"),
    REAL("REAL"),
    TEXT("TEXT"),
    BLOB("BLOB");
    
    private String value;

    private ColumnDbType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}

package android.taobao.windvane.packageapp.zipapp.data;

/* compiled from: Taobao */
public enum ZipUpdateInfoEnum {
    ZIP_UPDATE_INFO_DELETE(4096),
    ZIP_APP_TYPE_NORMAL(0);
    
    private long value;

    private ZipUpdateInfoEnum(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}

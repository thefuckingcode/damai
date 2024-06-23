package anet.channel.entity;

/* compiled from: Taobao */
public enum ENV {
    ONLINE(0),
    PREPARE(1),
    TEST(2);
    
    private int envMode;

    private ENV(int i) {
        this.envMode = i;
    }

    public int getEnvMode() {
        return this.envMode;
    }

    public void setEnvMode(int i) {
        this.envMode = i;
    }

    public static ENV valueOf(int i) {
        if (i == 1) {
            return PREPARE;
        }
        if (i != 2) {
            return ONLINE;
        }
        return TEST;
    }
}

package com.taobao.update.datasource.mtop;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class UpdateRequest implements Serializable {
    public String API_NAME = "mtop.client.mudp.update";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = true;
    public String VERSION = "1.0";
    public long apiLevel = 0;
    public String appVersion = null;
    public String betaSource;
    public String brand = null;
    public String city = null;
    public int cpuArch = -1;
    public String dexcode;
    public long dexpatchVersion = 0;
    public String identifier = null;
    public boolean isYunos;
    public String locale = null;
    public String md5Sum = null;
    public String model = null;
    public long patchVersion = 0;
    public List<String> updateTypes;

    public UpdateRequest(boolean z) {
        if (z) {
            this.API_NAME = "mtop.client.mudp.update.outer";
        }
    }
}

package cn.damai.mine.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class AcquireScoreDto implements Serializable {
    public List<AcquireScoreModel> acquireScoreDtos;
    public int total;
    public int us;
    public long usercode;

    /* compiled from: Taobao */
    public static class AcquireScoreModel {
        public long PKID;
        public String acquireTime;
        public String businessAcquireId;
        public String businessId;
        public String businessName;
        public int businessType;
        public String enableTime;
        public String matureTime;
        public String score;
        public int scoreStatus;
        public int scoreType;
    }
}

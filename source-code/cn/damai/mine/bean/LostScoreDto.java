package cn.damai.mine.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class LostScoreDto implements Serializable {
    public List<LostScoreModel> lostScoreDtos;
    public int total;
    public int us;
    public long usercode;

    /* compiled from: Taobao */
    public static class LostScoreModel {
        public long PKID;
        public String businessAbatementId;
        public String businessId;
        public String businessName;
        public int businessType;
        public int lostStatus;
        public String lostTime;
        public int lostType;
        public String score;
        public int scoreType;
    }
}

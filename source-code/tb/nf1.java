package tb;

import com.taobao.slide.stat.BizStatData;
import com.taobao.slide.stat.IBizStat;

/* compiled from: Taobao */
public class nf1 {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements IBizStat {
        IBizStat a = null;

        public a(IBizStat iBizStat) {
            this.a = iBizStat;
        }

        @Override // com.taobao.slide.stat.IBizStat
        public void commitDownload(BizStatData bizStatData) {
            IBizStat iBizStat = this.a;
            if (iBizStat != null) {
                iBizStat.commitDownload(bizStatData);
            }
        }

        @Override // com.taobao.slide.stat.IBizStat
        public void commitUse(BizStatData bizStatData) {
            IBizStat iBizStat = this.a;
            if (iBizStat != null) {
                iBizStat.commitUse(bizStatData);
            }
        }
    }

    public static void a(IBizStat iBizStat) {
        new a(iBizStat);
    }
}

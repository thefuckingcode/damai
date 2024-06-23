package anet.channel.statist;

import tb.jl1;
import tb.ss0;

@Monitor(module = "networkPrefer", monitorPoint = "strategy_stat")
/* compiled from: Taobao */
public class StrategyStatObject extends StatObject {
    @Dimension
    public StringBuilder errorTrace;
    @Dimension
    public int isFileExists;
    @Dimension
    public int isReadObjectSucceed;
    @Dimension
    public int isRenameSucceed;
    @Dimension
    public int isSucceed;
    @Dimension
    public int isTempWriteSucceed;
    @Measure
    public long readCostTime;
    @Dimension
    public String readStrategyFileId;
    @Dimension
    public String readStrategyFilePath;
    @Dimension
    public int type = -1;
    @Measure
    public long writeCostTime;
    @Dimension
    public String writeStrategyFileId;
    @Dimension
    public String writeStrategyFilePath;
    @Dimension
    public String writeTempFilePath;

    public StrategyStatObject(int i) {
        this.type = i;
    }

    public void appendErrorTrace(String str, Throwable th) {
        String message = th.getMessage();
        if (this.errorTrace == null) {
            this.errorTrace = new StringBuilder();
        }
        StringBuilder sb = this.errorTrace;
        sb.append(jl1.ARRAY_START);
        sb.append(str);
        sb.append(jl1.ARRAY_END);
        sb.append(str);
        sb.append(' ');
        sb.append(message);
        sb.append('\n');
    }

    @Override // anet.channel.statist.StatObject
    public boolean beforeCommit() {
        return ss0.j();
    }
}

package cn.damai.category.ranksquare.bean;

/* compiled from: Taobao */
public class RankSquareResponse {
    public String errorCode;
    public String errorMsg;
    public RankSquareBean mRankSquareBean;
    public RankSquareMoreBean mRankSquareMoreBean;
    public boolean requestSuccess;

    public RankSquareResponse(boolean z) {
        this.requestSuccess = z;
    }
}

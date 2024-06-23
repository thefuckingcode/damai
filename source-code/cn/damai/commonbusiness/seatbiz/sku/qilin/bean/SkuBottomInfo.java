package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class SkuBottomInfo implements Serializable {
    private static final long serialVersionUID = 5291493204882023687L;
    public double allPrice = 0.0d;
    public String btn = "确定";
    public int buyStatus = 1;
    public int followRelationTargetType;
    public boolean isShowBtn = true;
    public boolean isShowMengceng = true;
    public boolean isShowOneLine = false;
    public boolean isShowOnlyBtn = false;
    public String maxByNumTip = "每笔订单限购--张";
    public int maxTicketNum = 1;
    public double originalPrice;
    public double price = 0.0d;
    public String priceTip = "优惠以订单确认页为准";
    public long promotionAmount;
    public String selectPerformTip;
    public String selectTip;
}

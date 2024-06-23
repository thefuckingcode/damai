package cn.damai.ticklet.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class TickletForgetCardResult implements Serializable {
    private static final long serialVersionUID = 1;
    public String eCertState;
    public TicketAlipayCardBean ecertTipsInfo;
    public ArrayList<TickletForgetCardData> forgotCardInfos;

    /* compiled from: Taobao */
    public static class TickletForgetCardData implements Serializable {
        private static final long serialVersionUID = 1;
        public String code;
        public String seatInfo;
        public String state = "1";
        public String voucherUniqueKey;
    }
}

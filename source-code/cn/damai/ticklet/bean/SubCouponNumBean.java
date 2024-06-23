package cn.damai.ticklet.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class SubCouponNumBean implements Serializable {
    private static final long serialVersionUID = 1;
    public ExtAttr extAttr;
    public String subTicketNo;
    public String subTicketState;
    public String subTicketStateDesc;

    /* compiled from: Taobao */
    public static class ExtAttr implements Serializable {
        private static final long serialVersionUID = 1;
        public String subTicketUserPoint;
    }
}

package cn.damai.ultron.view.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class DmTicketDetailBean implements Serializable {
    public List<DetailInfoVO> detailInfos;
    public String payDetailTitle;
    public List<DmUltronTicketPayDetailBean> ticketPayDetailList;
    public List<DmTicketPriceHasSeatBean> ticketPriceHasSeatList;
    public List<DmTicketPriceNoSeatBean> ticketPriceNoSeatList;
    public String ticketTitle;
    public String topTitle;
}

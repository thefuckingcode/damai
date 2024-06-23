package cn.damai.ticklet.inteface;

import cn.damai.ticklet.bean.TicketExtMapBean;
import cn.damai.ticklet.bean.TickletForgetCardResult;
import com.amap.api.maps.TextureMapView;

/* compiled from: Taobao */
public interface TickletDetailCallback {
    void closeTickletForgetCard();

    void initVenueMap(TextureMapView textureMapView, TicketExtMapBean ticketExtMapBean);

    void showTickletForgetCard(TickletForgetCardResult tickletForgetCardResult, String str, String str2);
}

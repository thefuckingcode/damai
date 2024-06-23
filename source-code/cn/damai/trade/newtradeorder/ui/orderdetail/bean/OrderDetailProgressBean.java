package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.content.Context;
import androidx.core.content.ContextCompat;
import cn.damai.trade.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class OrderDetailProgressBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String nodeName;
    public int nodeStatus;
    public List<OrderDetailProgressChild> orderProgressItems;

    public int getColor(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599959638")) {
            return ((Integer) ipChange.ipc$dispatch("599959638", new Object[]{this, context})).intValue();
        }
        int i = this.nodeStatus;
        if (i == 1) {
            return ContextCompat.getColor(context, R$color.color_999999);
        }
        if (i == 2) {
            return ContextCompat.getColor(context, R$color.color_FF2D79);
        }
        if (i != 3) {
            return ContextCompat.getColor(context, R$color.color_999999);
        }
        return ContextCompat.getColor(context, R$color.color_FF2D79);
    }

    public boolean noStartNode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1976758695")) {
            return this.nodeStatus == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1976758695", new Object[]{this})).booleanValue();
    }
}

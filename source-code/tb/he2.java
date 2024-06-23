package tb;

import android.content.Context;
import android.content.Intent;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.heytap.mcssdk.c;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
public class he2 {
    private static boolean a(Context context) {
        String o = c.m().o(context);
        return hu2.f(context, o) && hu2.c(context, o) >= 1017;
    }

    public static void b(Context context, MessageStat messageStat) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(messageStat);
        c(context, linkedList);
    }

    public static boolean c(Context context, List<MessageStat> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        w33.a("isSupportStatisticByMcs:" + a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !a(context)) {
            return false;
        }
        return d(context, linkedList);
    }

    private static boolean d(Context context, List<MessageStat> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(c.m().y(context));
            intent.setPackage(c.m().o(context));
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("type", MessageConstant$CommandId.COMMAND_STATISTIC);
            intent.putExtra(AdUtConstants.XAD_UT_ARG_COUNT, list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            for (MessageStat messageStat : list) {
                arrayList.add(messageStat.toJsonObject());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
            return true;
        } catch (Exception e) {
            w33.b("statisticMessage--Exception" + e.getMessage());
            return false;
        }
    }
}

package tb;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;

/* compiled from: Taobao */
public class x03 {
    public static boolean a(Context context, String str, DataMessage dataMessage) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        arrayList.add(dataMessage == null ? new MessageStat(packageName, str) : new MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
        return he2.c(context, arrayList);
    }
}

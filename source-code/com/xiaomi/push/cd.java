package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cj;

/* compiled from: Taobao */
public class cd extends cf {
    public cd(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static cd a(Context context, String str, int i) {
        b.b("delete  messages when db size is too bigger");
        String a = cj.a(context).m324a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new cd(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        String[] strArr = ((cj.d) this).f167a;
        if (strArr != null && strArr.length > 0) {
            strArr[0] = String.valueOf(j);
        }
    }

    @Override // com.xiaomi.push.cj.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = cp.a(m326a());
            long j = cb.f150a;
            if (a > j) {
                long j2 = (long) (((((double) (a - j)) * 1.2d) / ((double) j)) * ((double) longValue));
                a(j2);
                bx a2 = bx.a(context);
                a2.a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
                super.a(context, obj);
                return;
            }
            b.b("db size is suitable");
        }
    }
}

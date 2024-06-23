package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
public final class l23 extends e1 {
    private String c;
    private String d;
    private String e;
    private String f;

    public l23(String str, String str2, String str3) {
        super(Constants.LOG_TYPE_WA);
        this.c = str;
        this.d = str2;
        this.f = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        r03.c();
        this.e = simpleDateFormat.format(new Date(r03.e()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        String generateString = generateString();
        if (a.a().h) {
            t43.a(Constants.TAG, generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lt=event`");
        sb.append("ev_ct=");
        sb.append(this.c);
        sb.append("`");
        sb.append("ev_ac=");
        sb.append(this.d);
        sb.append("`");
        sb.append("tm=");
        sb.append(this.e);
        sb.append("`");
        sb.append("dn=");
        sb.append(this.f);
        sb.append("`");
        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("`");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(f23 f23) {
        this.b.putAll(f23.a());
        this.b.putAll(a.a().b());
    }
}

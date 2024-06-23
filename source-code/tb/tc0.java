package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.d.a;
import org.json.JSONObject;

/* compiled from: Taobao */
public class tc0 extends e1 {
    public tc0(String str) {
        super(str);
        a("type", str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String generateString = generateString();
        if (a.a().h) {
            t43.a(Constants.TAG, generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return new JSONObject(this.b).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        if (this.b.containsKey(Constants.LOG_KEY_LINK_ID)) {
            return String.valueOf(this.b.get(Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        if (this.b.containsKey(Constants.LOG_KEY_LINK_KEY)) {
            return String.valueOf(this.b.get(Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(f23 f23) {
        this.b.putAll(f23.a());
        this.b.putAll(a.a().b());
    }
}

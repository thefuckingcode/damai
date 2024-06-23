package mtopsdk.mtop.domain;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class MockResponse {
    public String api;
    public byte[] byteData;
    public Map<String, List<String>> headers;
    public int statusCode;

    public String toString() {
        return "MockResponse{api='" + this.api + '\'' + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", byteData=" + new String(this.byteData) + '}';
    }
}

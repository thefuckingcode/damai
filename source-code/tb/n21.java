package tb;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class n21 {
    public static BufferedReader a(String str) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }
}

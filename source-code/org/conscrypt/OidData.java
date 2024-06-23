package org.conscrypt;

import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class OidData {
    private static final Map<String, String> OID_TO_NAME_MAP;

    private OidData() {
    }

    static {
        HashMap hashMap = new HashMap();
        OID_TO_NAME_MAP = hashMap;
        hashMap.put("1.2.840.113549.1.1.2", "MD2withRSA");
        hashMap.put("1.2.840.113549.1.1.4", "MD5withRSA");
        hashMap.put("1.2.840.113549.1.1.5", "SHA1withRSA");
        hashMap.put("1.2.840.10040.4.3", "SHA1withDSA");
        hashMap.put("1.2.840.10045.4.1", "SHA1withECDSA");
        hashMap.put("1.2.840.113549.1.1.14", "SHA224withRSA");
        hashMap.put("1.2.840.113549.1.1.11", "SHA256withRSA");
        hashMap.put("1.2.840.113549.1.1.12", "SHA384withRSA");
        hashMap.put("1.2.840.113549.1.1.13", "SHA512withRSA");
        hashMap.put("2.16.840.1.101.3.4.3.1", "SHA224withDSA");
        hashMap.put("2.16.840.1.101.3.4.3.2", "SHA256withDSA");
        hashMap.put("1.2.840.10045.4.3.1", "SHA224withECDSA");
        hashMap.put("1.2.840.10045.4.3.2", "SHA256withECDSA");
        hashMap.put("1.2.840.10045.4.3.3", "SHA384withECDSA");
        hashMap.put("1.2.840.10045.4.3.4", "SHA512withECDSA");
    }

    public static String oidToAlgorithmName(String str) {
        return OID_TO_NAME_MAP.get(str);
    }
}

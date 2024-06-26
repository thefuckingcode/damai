package com.ali.user.mobile.verify.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class CloseBiometricApiRequest implements Serializable {
    public String appKey;
    public String biometricType = "fingerprint";
    public List<BiometricCloseUsers> closeUsers;
    public String requestScene;
    public int site;
}

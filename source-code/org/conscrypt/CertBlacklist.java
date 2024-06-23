package org.conscrypt;

import java.math.BigInteger;
import java.security.PublicKey;

public interface CertBlacklist {
    boolean isPublicKeyBlackListed(PublicKey publicKey);

    boolean isSerialNumberBlackListed(BigInteger bigInteger);
}

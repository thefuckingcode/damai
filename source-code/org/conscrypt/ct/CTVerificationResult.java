package org.conscrypt.ct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.conscrypt.ct.VerifiedSCT;

public class CTVerificationResult {
    private final ArrayList<VerifiedSCT> invalidSCTs = new ArrayList<>();
    private final ArrayList<VerifiedSCT> validSCTs = new ArrayList<>();

    public void add(VerifiedSCT verifiedSCT) {
        if (verifiedSCT.status == VerifiedSCT.Status.VALID) {
            this.validSCTs.add(verifiedSCT);
        } else {
            this.invalidSCTs.add(verifiedSCT);
        }
    }

    public List<VerifiedSCT> getValidSCTs() {
        return Collections.unmodifiableList(this.validSCTs);
    }

    public List<VerifiedSCT> getInvalidSCTs() {
        return Collections.unmodifiableList(this.invalidSCTs);
    }
}

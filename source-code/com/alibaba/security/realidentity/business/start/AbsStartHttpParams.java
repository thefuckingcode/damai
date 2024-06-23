package com.alibaba.security.realidentity.business.start;

import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.util.Map;

/* compiled from: Taobao */
public abstract class AbsStartHttpParams extends HttpBucketParams {
    public int mActionCount = 0;
    public String mBizConf;
    public ExtrasBean mExtrasBean;
    public String mLivenessConfig;
    public boolean mNeedActionImage = true;
    public boolean mNeedGaze = false;
    public boolean mNeedOriginalImage = false;
    public boolean mOnlyGaze = false;
    public boolean mShowNav;
    public boolean mShowPrivacy;
    public boolean mShowResult;
    public UploadToken mUploadToken = new UploadToken();
    public Map<String, String> mVerifyDowngradConfig;

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        return null;
    }
}

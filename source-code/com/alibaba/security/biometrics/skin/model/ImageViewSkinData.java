package com.alibaba.security.biometrics.skin.model;

import android.graphics.Bitmap;
import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;
import com.alibaba.security.common.b.a.a;

/* compiled from: Taobao */
public class ImageViewSkinData extends BaseSkinData {
    private String src;
    @a(d = false)
    private Bitmap srcImageBitmap;

    public String getSrc() {
        return this.src;
    }

    public Bitmap getSrcImageBitmap() {
        return this.srcImageBitmap;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
        this.srcImageBitmap = iSkinParse.parseBitmap(this.src);
    }

    public void setSrc(String str) {
        this.src = str;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
        this.src = iSkinParse.convertWebPath(this.src);
    }
}

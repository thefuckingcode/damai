package com.taobao.ma.bar.parser;

import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.parser.MaParSer;

/* compiled from: Taobao */
public class MaBarParSer extends MaParSer {
    @Override // com.taobao.ma.parser.MaParSer
    public MaResult decode(MaWapperResult maWapperResult) {
        if (!MaAnalyzeHelper.isBarCode(maWapperResult.type, maWapperResult.subType)) {
            return null;
        }
        return new MaResult(MaAnalyzeHelper.getMaType(maWapperResult), maWapperResult.strCode);
    }
}

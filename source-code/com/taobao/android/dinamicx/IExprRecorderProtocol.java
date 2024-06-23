package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import tb.ay;

/* compiled from: Taobao */
public interface IExprRecorderProtocol {
    void doAfterEvaluateMethodWithResult(ay ayVar, Object obj, DXRuntimeContext dXRuntimeContext);

    void doAfterExecuteASTWithEventAndContext(ay ayVar, Object obj, DXRuntimeContext dXRuntimeContext);

    void doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(ay ayVar, IDXDataParser iDXDataParser, Object[] objArr, DXRuntimeContext dXRuntimeContext);

    void doBeforeExecuteASTWithEventAndContext(ay ayVar, Object obj, DXRuntimeContext dXRuntimeContext);
}

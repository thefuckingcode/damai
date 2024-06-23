package com.taobao.android.dinamic.expression.parser;

import java.util.List;
import tb.x70;

/* compiled from: Taobao */
public interface DinamicDataParser {
    Object evalWithArgs(List list, x70 x70);

    Object parser(String str, Object obj);

    Object parser(String str, String str2, Object obj, Object obj2);

    Object parser(String str, x70 x70);
}

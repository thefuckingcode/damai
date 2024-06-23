package com.taobao.android.dinamic.parser;

import com.taobao.android.dinamic.tempate.DinamicTemplate;
import org.xmlpull.v1.XmlPullParser;
import tb.ew2;

/* compiled from: Taobao */
public interface Parser {
    XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, ew2 ew2);
}

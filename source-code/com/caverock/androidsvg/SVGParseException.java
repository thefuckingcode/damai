package com.caverock.androidsvg;

import org.xml.sax.SAXException;

/* compiled from: Taobao */
public class SVGParseException extends SAXException {
    SVGParseException(String str) {
        super(str);
    }

    SVGParseException(String str, Exception exc) {
        super(str, exc);
    }
}

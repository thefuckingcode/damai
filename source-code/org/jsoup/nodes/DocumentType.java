package org.jsoup.nodes;

import java.io.IOException;
import kotlin.text.Typography;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

public class DocumentType extends Node {
    private static final String NAME = "name";
    private static final String PUBLIC_ID = "publicId";
    private static final String SYSTEM_ID = "systemId";

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    public DocumentType(String str, String str2, String str3, String str4) {
        super(str4);
        attr("name", str);
        attr(PUBLIC_ID, str2);
        attr(SYSTEM_ID, str3);
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.syntax() != Document.OutputSettings.Syntax.html || has(PUBLIC_ID) || has(SYSTEM_ID)) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (has("name")) {
            appendable.append(" ").append(attr("name"));
        }
        if (has(PUBLIC_ID)) {
            appendable.append(" PUBLIC \"").append(attr(PUBLIC_ID)).append(Typography.quote);
        }
        if (has(SYSTEM_ID)) {
            appendable.append(" \"").append(attr(SYSTEM_ID)).append(Typography.quote);
        }
        appendable.append(Typography.greater);
    }

    private boolean has(String str) {
        return !StringUtil.isBlank(attr(str));
    }
}

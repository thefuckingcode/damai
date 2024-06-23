package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class XmlDeclaration extends Node {
    private final boolean isProcessingInstruction;
    private final String name;

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#declaration";
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        Validate.notNull(str);
        this.name = str;
        this.isProcessingInstruction = z;
    }

    public String name() {
        return this.name;
    }

    public String getWholeDeclaration() {
        return this.attributes.html().trim();
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        String str = "!";
        appendable.append("<").append(this.isProcessingInstruction ? str : "?").append(this.name);
        this.attributes.html(appendable, outputSettings);
        if (!this.isProcessingInstruction) {
            str = "?";
        }
        appendable.append(str).append(">");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }
}

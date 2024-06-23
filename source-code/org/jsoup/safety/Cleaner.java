package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class Cleaner {
    private Whitelist whitelist;

    public Cleaner(Whitelist whitelist2) {
        Validate.notNull(whitelist2);
        this.whitelist = whitelist2;
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document createShell = Document.createShell(document.baseUri());
        if (document.body() != null) {
            copySafeNodes(document.body(), createShell.body());
        }
        return createShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return copySafeNodes(document.body(), Document.createShell(document.baseUri()).body()) == 0;
    }

    /* access modifiers changed from: private */
    public final class CleaningVisitor implements NodeVisitor {
        private Element destination;
        private int numDiscarded;
        private final Element root;

        private CleaningVisitor(Element element, Element element2) {
            this.numDiscarded = 0;
            this.root = element;
            this.destination = element2;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (Cleaner.this.whitelist.isSafeTag(element.tagName())) {
                    ElementMeta createSafeElement = Cleaner.this.createSafeElement(element);
                    Element element2 = createSafeElement.el;
                    this.destination.appendChild(element2);
                    this.numDiscarded += createSafeElement.numAttribsDiscarded;
                    this.destination = element2;
                } else if (node != this.root) {
                    this.numDiscarded++;
                }
            } else if (node instanceof TextNode) {
                this.destination.appendChild(new TextNode(((TextNode) node).getWholeText(), node.baseUri()));
            } else if (!(node instanceof DataNode) || !Cleaner.this.whitelist.isSafeTag(node.parent().nodeName())) {
                this.numDiscarded++;
            } else {
                this.destination.appendChild(new DataNode(((DataNode) node).getWholeData(), node.baseUri()));
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof Element) && Cleaner.this.whitelist.isSafeTag(node.nodeName())) {
                this.destination = this.destination.parent();
            }
        }
    }

    private int copySafeNodes(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        new NodeTraversor(cleaningVisitor).traverse(element);
        return cleaningVisitor.numDiscarded;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ElementMeta createSafeElement(Element element) {
        String tagName = element.tagName();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.valueOf(tagName), element.baseUri(), attributes);
        Iterator<Attribute> it = element.attributes().iterator();
        int i = 0;
        while (it.hasNext()) {
            Attribute next = it.next();
            if (this.whitelist.isSafeAttribute(tagName, element, next)) {
                attributes.put(next);
            } else {
                i++;
            }
        }
        attributes.addAll(this.whitelist.getEnforcedAttributes(tagName));
        return new ElementMeta(element2, i);
    }

    /* access modifiers changed from: private */
    public static class ElementMeta {
        Element el;
        int numAttribsDiscarded;

        ElementMeta(Element element, int i) {
            this.el = element;
            this.numAttribsDiscarded = i;
        }
    }
}

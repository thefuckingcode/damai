package org.jsoup.helper;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class W3CDom {
    protected DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            this.factory.setNamespaceAware(true);
            Document newDocument = this.factory.newDocumentBuilder().newDocument();
            convert(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        new NodeTraversor(new W3CBuilder(document2)).traverse(document.child(0));
    }

    /* access modifiers changed from: protected */
    public static class W3CBuilder implements NodeVisitor {
        private static final String xmlnsKey = "xmlns";
        private static final String xmlnsPrefix = "xmlns:";
        private Element dest;
        private final Document doc;
        private final HashMap<String, String> namespaces = new HashMap<>();

        public W3CBuilder(Document document) {
            this.doc = document;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof org.jsoup.nodes.Element) {
                org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) node;
                String updateNamespaces = updateNamespaces(element);
                Element createElementNS = this.doc.createElementNS(this.namespaces.get(updateNamespaces), element.tagName());
                copyAttributes(element, createElementNS);
                Element element2 = this.dest;
                if (element2 == null) {
                    this.doc.appendChild(createElementNS);
                } else {
                    element2.appendChild(createElementNS);
                }
                this.dest = createElementNS;
            } else if (node instanceof TextNode) {
                this.dest.appendChild(this.doc.createTextNode(((TextNode) node).getWholeText()));
            } else if (node instanceof Comment) {
                this.dest.appendChild(this.doc.createComment(((Comment) node).getData()));
            } else if (node instanceof DataNode) {
                this.dest.appendChild(this.doc.createTextNode(((DataNode) node).getWholeData()));
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.dest.getParentNode() instanceof Element)) {
                this.dest = (Element) this.dest.getParentNode();
            }
        }

        private void copyAttributes(Node node, Element element) {
            Iterator<Attribute> it = node.attributes().iterator();
            while (it.hasNext()) {
                Attribute next = it.next();
                element.setAttribute(next.getKey(), next.getValue());
            }
        }

        private String updateNamespaces(org.jsoup.nodes.Element element) {
            String str;
            Iterator<Attribute> it = element.attributes().iterator();
            while (true) {
                str = "";
                if (!it.hasNext()) {
                    break;
                }
                Attribute next = it.next();
                String key = next.getKey();
                if (!key.equals(xmlnsKey)) {
                    if (key.startsWith(xmlnsPrefix)) {
                        str = key.substring(6);
                    }
                }
                this.namespaces.put(str, next.getValue());
            }
            int indexOf = element.tagName().indexOf(":");
            return indexOf > 0 ? element.tagName().substring(0, indexOf) : str;
        }
    }

    public String asString(Document document) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }
}

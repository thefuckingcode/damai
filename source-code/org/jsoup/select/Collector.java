package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Collector {
    private Collector() {
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        new NodeTraversor(new Accumulator(element, elements, evaluator)).traverse(element);
        return elements;
    }

    /* access modifiers changed from: private */
    public static class Accumulator implements NodeVisitor {
        private final Elements elements;
        private final Evaluator eval;
        private final Element root;

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
        }

        Accumulator(Element element, Elements elements2, Evaluator evaluator) {
            this.root = element;
            this.elements = elements2;
            this.eval = evaluator;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.eval.matches(this.root, element)) {
                    this.elements.add(element);
                }
            }
        }
    }
}

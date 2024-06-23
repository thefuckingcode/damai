package org.jsoup.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Parser {
    private static final int DEFAULT_MAX_ERRORS = 0;
    private ParseErrorList errors;
    private int maxErrors = 0;
    private TreeBuilder treeBuilder;

    public Parser(TreeBuilder treeBuilder2) {
        this.treeBuilder = treeBuilder2;
    }

    public Document parseInput(String str, String str2) {
        ParseErrorList tracking = isTrackErrors() ? ParseErrorList.tracking(this.maxErrors) : ParseErrorList.noTracking();
        this.errors = tracking;
        return this.treeBuilder.parse(str, str2, tracking);
    }

    public TreeBuilder getTreeBuilder() {
        return this.treeBuilder;
    }

    public Parser setTreeBuilder(TreeBuilder treeBuilder2) {
        this.treeBuilder = treeBuilder2;
        return this;
    }

    public boolean isTrackErrors() {
        return this.maxErrors > 0;
    }

    public Parser setTrackErrors(int i) {
        this.maxErrors = i;
        return this;
    }

    public List<ParseError> getErrors() {
        return this.errors;
    }

    public static Document parse(String str, String str2) {
        return new HtmlTreeBuilder().parse(str, str2, ParseErrorList.noTracking());
    }

    public static List<Node> parseFragment(String str, Element element, String str2) {
        return new HtmlTreeBuilder().parseFragment(str, element, str2, ParseErrorList.noTracking());
    }

    public static List<Node> parseXmlFragment(String str, String str2) {
        return new XmlTreeBuilder().parseFragment(str, str2, ParseErrorList.noTracking());
    }

    public static Document parseBodyFragment(String str, String str2) {
        Document createShell = Document.createShell(str2);
        Element body = createShell.body();
        List<Node> parseFragment = parseFragment(str, body, str2);
        Node[] nodeArr = (Node[]) parseFragment.toArray(new Node[parseFragment.size()]);
        for (int length = nodeArr.length - 1; length > 0; length--) {
            nodeArr[length].remove();
        }
        for (Node node : nodeArr) {
            body.appendChild(node);
        }
        return createShell;
    }

    public static String unescapeEntities(String str, boolean z) {
        return new Tokeniser(new CharacterReader(str), ParseErrorList.noTracking()).unescapeEntities(z);
    }

    public static Document parseBodyFragmentRelaxed(String str, String str2) {
        return parse(str, str2);
    }

    public static Parser htmlParser() {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Parser xmlParser() {
        return new Parser(new XmlTreeBuilder());
    }
}

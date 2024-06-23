package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

/* access modifiers changed from: package-private */
public abstract class TreeBuilder {
    protected String baseUri;
    protected Token currentToken;
    protected Document doc;
    private Token.EndTag end = new Token.EndTag();
    protected ParseErrorList errors;
    CharacterReader reader;
    protected ArrayList<Element> stack;
    private Token.StartTag start = new Token.StartTag();
    Tokeniser tokeniser;

    /* access modifiers changed from: protected */
    public abstract boolean process(Token token);

    TreeBuilder() {
    }

    /* access modifiers changed from: protected */
    public void initialiseParse(String str, String str2, ParseErrorList parseErrorList) {
        Validate.notNull(str, "String input must not be null");
        Validate.notNull(str2, "BaseURI must not be null");
        this.doc = new Document(str2);
        this.reader = new CharacterReader(str);
        this.errors = parseErrorList;
        this.tokeniser = new Tokeniser(this.reader, parseErrorList);
        this.stack = new ArrayList<>(32);
        this.baseUri = str2;
    }

    /* access modifiers changed from: package-private */
    public Document parse(String str, String str2) {
        return parse(str, str2, ParseErrorList.noTracking());
    }

    /* access modifiers changed from: package-private */
    public Document parse(String str, String str2, ParseErrorList parseErrorList) {
        initialiseParse(str, str2, parseErrorList);
        runParser();
        return this.doc;
    }

    /* access modifiers changed from: protected */
    public void runParser() {
        Token read;
        do {
            read = this.tokeniser.read();
            process(read);
            read.reset();
        } while (read.type != Token.TokenType.EOF);
    }

    /* access modifiers changed from: protected */
    public boolean processStartTag(String str) {
        Token token = this.currentToken;
        Token.StartTag startTag = this.start;
        if (token == startTag) {
            return process(new Token.StartTag().name(str));
        }
        return process(startTag.reset().name(str));
    }

    public boolean processStartTag(String str, Attributes attributes) {
        Token token = this.currentToken;
        Token.StartTag startTag = this.start;
        if (token == startTag) {
            return process(new Token.StartTag().nameAttr(str, attributes));
        }
        startTag.reset();
        this.start.nameAttr(str, attributes);
        return process(this.start);
    }

    /* access modifiers changed from: protected */
    public boolean processEndTag(String str) {
        Token token = this.currentToken;
        Token.EndTag endTag = this.end;
        if (token == endTag) {
            return process(new Token.EndTag().name(str));
        }
        return process(endTag.reset().name(str));
    }

    /* access modifiers changed from: protected */
    public Element currentElement() {
        int size = this.stack.size();
        if (size > 0) {
            return this.stack.get(size - 1);
        }
        return null;
    }
}

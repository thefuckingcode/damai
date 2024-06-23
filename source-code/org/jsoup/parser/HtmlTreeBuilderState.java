package org.jsoup.parser;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cookie.SerializableCookie;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

/* access modifiers changed from: package-private */
public enum HtmlTreeBuilderState {
    Initial {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype asDoctype = token.asDoctype();
                htmlTreeBuilder.getDocument().appendChild(new DocumentType(asDoctype.getName(), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier(), htmlTreeBuilder.getBaseUri()));
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(BeforeHtml);
            } else {
                htmlTreeBuilder.transition(BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            } else {
                if (!token.isStartTag() || !token.asStartTag().name().equals("html")) {
                    if (token.isEndTag()) {
                        if (StringUtil.in(token.asEndTag().name(), CacheEntity.HEAD, "body", "html", "br")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                    }
                    if (!token.isEndTag()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.insert(token.asStartTag());
                htmlTreeBuilder.transition(BeforeHead);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return InBody.process(token, htmlTreeBuilder);
            } else {
                if (!token.isStartTag() || !token.asStartTag().name().equals(CacheEntity.HEAD)) {
                    if (token.isEndTag()) {
                        if (StringUtil.in(token.asEndTag().name(), CacheEntity.HEAD, "body", "html", "br")) {
                            htmlTreeBuilder.processStartTag(CacheEntity.HEAD);
                            return htmlTreeBuilder.process(token);
                        }
                    }
                    if (token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.processStartTag(CacheEntity.HEAD);
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                htmlTreeBuilder.transition(InHead);
            }
            return true;
        }
    },
    InHead {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return InBody.process(token, htmlTreeBuilder);
                }
                if (StringUtil.in(name, "base", "basefont", "bgsound", "command", "link")) {
                    Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                    if (name.equals("base") && insertEmpty.hasAttr("href")) {
                        htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                    }
                } else if (name.equals("meta")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (name.equals("title")) {
                    HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                } else {
                    if (StringUtil.in(name, "noframes", "style")) {
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    } else if (name.equals("noscript")) {
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.transition(InHeadNoscript);
                    } else if (name.equals("script")) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.transition(Text);
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (!name.equals(CacheEntity.HEAD)) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
            } else if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String name2 = token.asEndTag().name();
                if (name2.equals(CacheEntity.HEAD)) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(AfterHead);
                } else {
                    if (StringUtil.in(name2, "body", "html", "br")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag(CacheEntity.HEAD);
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript {
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
            if (org.jsoup.helper.StringUtil.in(r9.asStartTag().name(), "basefont", "bgsound", "link", "meta", "noframes", "style") != false) goto L_0x00ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
            if (org.jsoup.helper.StringUtil.in(r9.asStartTag().name(), com.lzy.okgo.cache.CacheEntity.HEAD, "noscript") == false) goto L_0x00bf;
         */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().name().equals("noscript")) {
                    if (!HtmlTreeBuilderState.isWhitespace(token) && !token.isComment()) {
                        if (token.isStartTag()) {
                        }
                        if (token.isEndTag() && token.asEndTag().name().equals("br")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        if (token.isStartTag()) {
                        }
                        if (!token.isEndTag()) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return htmlTreeBuilder.process(token, InHead);
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(InHead);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }
    },
    AfterHead {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (name.equals("body")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InBody);
                } else if (name.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                } else {
                    if (StringUtil.in(name, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                        htmlTreeBuilder.error(this);
                        Element headElement = htmlTreeBuilder.getHeadElement();
                        htmlTreeBuilder.push(headElement);
                        htmlTreeBuilder.process(token, InHead);
                        htmlTreeBuilder.removeFromStack(headElement);
                    } else if (name.equals(CacheEntity.HEAD)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        anythingElse(token, htmlTreeBuilder);
                    }
                }
            } else if (token.isEndTag()) {
                if (StringUtil.in(token.asEndTag().name(), "body", "html")) {
                    anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else {
                anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element element;
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            boolean z = true;
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("a")) {
                    if (htmlTreeBuilder.getActiveFormattingElement("a") != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("a");
                        Element fromStack = htmlTreeBuilder.getFromStack("a");
                        if (fromStack != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                } else if (StringUtil.inSorted(name, Constants.InBodyStartEmptyFormatters)) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insertEmpty(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                } else if (StringUtil.inSorted(name, Constants.InBodyStartPClosers)) {
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(asStartTag);
                } else if (name.equals("span")) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                } else if (name.equals("li")) {
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    int size = stack.size() - 1;
                    while (true) {
                        if (size <= 0) {
                            break;
                        }
                        Element element2 = stack.get(size);
                        if (element2.nodeName().equals("li")) {
                            htmlTreeBuilder.processEndTag("li");
                            break;
                        }
                        if (htmlTreeBuilder.isSpecial(element2) && !StringUtil.inSorted(element2.nodeName(), Constants.InBodyStartLiBreakers)) {
                            break;
                        }
                        size--;
                    }
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(asStartTag);
                } else if (name.equals("html")) {
                    htmlTreeBuilder.error(this);
                    Element element3 = htmlTreeBuilder.getStack().get(0);
                    Iterator<Attribute> it = asStartTag.getAttributes().iterator();
                    while (it.hasNext()) {
                        Attribute next = it.next();
                        if (!element3.hasAttr(next.getKey())) {
                            element3.attributes().put(next);
                        }
                    }
                } else if (StringUtil.inSorted(name, Constants.InBodyStartToHead)) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (name.equals("body")) {
                        htmlTreeBuilder.error(this);
                        ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                        if (stack2.size() == 1 || (stack2.size() > 2 && !stack2.get(1).nodeName().equals("body"))) {
                            return false;
                        }
                        htmlTreeBuilder.framesetOk(false);
                        Element element4 = stack2.get(1);
                        Iterator<Attribute> it2 = asStartTag.getAttributes().iterator();
                        while (it2.hasNext()) {
                            Attribute next2 = it2.next();
                            if (!element4.hasAttr(next2.getKey())) {
                                element4.attributes().put(next2);
                            }
                        }
                    } else if (name.equals("frameset")) {
                        htmlTreeBuilder.error(this);
                        ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                        if (stack3.size() == 1 || ((stack3.size() > 2 && !stack3.get(1).nodeName().equals("body")) || !htmlTreeBuilder.framesetOk())) {
                            return false;
                        }
                        Element element5 = stack3.get(1);
                        if (element5.parent() != null) {
                            element5.remove();
                        }
                        for (int i2 = 1; stack3.size() > i2; i2 = 1) {
                            stack3.remove(stack3.size() - i2);
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.transition(InFrameset);
                    } else if (StringUtil.inSorted(name, Constants.Headings)) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().nodeName(), Constants.Headings)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.pop();
                        }
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartPreListing)) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                    } else if (name.equals("form")) {
                        if (htmlTreeBuilder.getFormElement() != null) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insertForm(asStartTag, true);
                        return true;
                    } else if (StringUtil.inSorted(name, Constants.DdDt)) {
                        htmlTreeBuilder.framesetOk(false);
                        ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                        int size2 = stack4.size() - 1;
                        while (true) {
                            if (size2 <= 0) {
                                break;
                            }
                            Element element6 = stack4.get(size2);
                            if (StringUtil.inSorted(element6.nodeName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element6.nodeName());
                                break;
                            }
                            if (htmlTreeBuilder.isSpecial(element6) && !StringUtil.inSorted(element6.nodeName(), Constants.InBodyStartLiBreakers)) {
                                break;
                            }
                            size2--;
                        }
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (name.equals("plaintext")) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    } else if (name.equals("button")) {
                        if (htmlTreeBuilder.inButtonScope("button")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processEndTag("button");
                            htmlTreeBuilder.process(asStartTag);
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.framesetOk(false);
                        }
                    } else if (StringUtil.inSorted(name, Constants.Formatters)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    } else if (name.equals("nobr")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        if (htmlTreeBuilder.inScope("nobr")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processEndTag("nobr");
                            htmlTreeBuilder.reconstructFormattingElements();
                        }
                        htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartApplets)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.insertMarkerToFormattingElements();
                        htmlTreeBuilder.framesetOk(false);
                    } else if (name.equals("table")) {
                        if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(InTable);
                    } else if (name.equals("input")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        if (!htmlTreeBuilder.insertEmpty(asStartTag).attr("type").equalsIgnoreCase("hidden")) {
                            htmlTreeBuilder.framesetOk(false);
                        }
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartMedia)) {
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else if (name.equals("hr")) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                    } else if (name.equals("image")) {
                        if (htmlTreeBuilder.getFromStack("svg") == null) {
                            return htmlTreeBuilder.process(asStartTag.name("img"));
                        }
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (name.equals("isindex")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                        htmlTreeBuilder.processStartTag("form");
                        if (asStartTag.attributes.hasKey("action")) {
                            htmlTreeBuilder.getFormElement().attr("action", asStartTag.attributes.get("action"));
                        }
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processStartTag("label");
                        htmlTreeBuilder.process(new Token.Character().data(asStartTag.attributes.hasKey("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                        Attributes attributes = new Attributes();
                        Iterator<Attribute> it3 = asStartTag.attributes.iterator();
                        while (it3.hasNext()) {
                            Attribute next3 = it3.next();
                            if (!StringUtil.inSorted(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                                attributes.put(next3);
                            }
                        }
                        attributes.put(SerializableCookie.NAME, "isindex");
                        htmlTreeBuilder.processStartTag("input", attributes);
                        htmlTreeBuilder.processEndTag("label");
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processEndTag("form");
                    } else if (name.equals("textarea")) {
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(Text);
                    } else if (name.equals("xmp")) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    } else if (name.equals("iframe")) {
                        htmlTreeBuilder.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    } else if (name.equals("noembed")) {
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    } else if (name.equals("select")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                        HtmlTreeBuilderState state = htmlTreeBuilder.state();
                        if (state.equals(InTable) || state.equals(InCaption) || state.equals(InTableBody) || state.equals(InRow) || state.equals(InCell)) {
                            htmlTreeBuilder.transition(InSelectInTable);
                        } else {
                            htmlTreeBuilder.transition(InSelect);
                        }
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartOptions)) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartRuby)) {
                        if (htmlTreeBuilder.inScope("ruby")) {
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElement().nodeName().equals("ruby")) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.popStackToBefore("ruby");
                            }
                            htmlTreeBuilder.insert(asStartTag);
                        }
                    } else if (name.equals("math")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                    } else if (name.equals("svg")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartDrop)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asStartTag);
                    }
                }
            } else if (i == 4) {
                Token.EndTag asEndTag = token.asEndTag();
                String name2 = asEndTag.name();
                if (StringUtil.inSorted(name2, Constants.InBodyEndAdoptionFormatters)) {
                    int i3 = 0;
                    while (i3 < 8) {
                        Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(name2);
                        if (activeFormattingElement == null) {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        }
                        if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                            return z;
                        } else if (!htmlTreeBuilder.inScope(activeFormattingElement.nodeName())) {
                            htmlTreeBuilder.error(this);
                            return false;
                        } else {
                            if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                                htmlTreeBuilder.error(this);
                            }
                            ArrayList<Element> stack5 = htmlTreeBuilder.getStack();
                            int size3 = stack5.size();
                            Element element7 = null;
                            int i4 = 0;
                            boolean z2 = false;
                            while (true) {
                                if (i4 >= size3 || i4 >= 64) {
                                    element = null;
                                } else {
                                    element = stack5.get(i4);
                                    if (element != activeFormattingElement) {
                                        if (z2 && htmlTreeBuilder.isSpecial(element)) {
                                            break;
                                        }
                                    } else {
                                        element7 = stack5.get(i4 - 1);
                                        z2 = true;
                                    }
                                    i4++;
                                }
                            }
                            element = null;
                            if (element == null) {
                                htmlTreeBuilder.popStackToClose(activeFormattingElement.nodeName());
                                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                return z;
                            }
                            Element element8 = element;
                            Element element9 = element8;
                            for (int i5 = 0; i5 < 3; i5++) {
                                if (htmlTreeBuilder.onStack(element8)) {
                                    element8 = htmlTreeBuilder.aboveOnStack(element8);
                                }
                                if (!htmlTreeBuilder.isInActiveFormattingElements(element8)) {
                                    htmlTreeBuilder.removeFromStack(element8);
                                } else if (element8 == activeFormattingElement) {
                                    break;
                                } else {
                                    Element element10 = new Element(Tag.valueOf(element8.nodeName()), htmlTreeBuilder.getBaseUri());
                                    htmlTreeBuilder.replaceActiveFormattingElement(element8, element10);
                                    htmlTreeBuilder.replaceOnStack(element8, element10);
                                    if (element9.parent() != null) {
                                        element9.remove();
                                    }
                                    element10.appendChild(element9);
                                    element8 = element10;
                                    element9 = element8;
                                }
                            }
                            if (StringUtil.inSorted(element7.nodeName(), Constants.InBodyEndTableFosters)) {
                                if (element9.parent() != null) {
                                    element9.remove();
                                }
                                htmlTreeBuilder.insertInFosterParent(element9);
                            } else {
                                if (element9.parent() != null) {
                                    element9.remove();
                                }
                                element7.appendChild(element9);
                            }
                            Element element11 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                            element11.attributes().addAll(activeFormattingElement.attributes());
                            for (Node node : (Node[]) element.childNodes().toArray(new Node[element.childNodeSize()])) {
                                element11.appendChild(node);
                            }
                            element.appendChild(element11);
                            htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                            htmlTreeBuilder.removeFromStack(activeFormattingElement);
                            htmlTreeBuilder.insertOnStackAfter(element, element11);
                            i3++;
                            z = true;
                        }
                    }
                } else if (StringUtil.inSorted(name2, Constants.InBodyEndClosers)) {
                    if (!htmlTreeBuilder.inScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name2);
                } else if (name2.equals("span")) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                } else {
                    if (name2.equals("li")) {
                        if (!htmlTreeBuilder.inListItemScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                    } else if (name2.equals("body")) {
                        if (!htmlTreeBuilder.inScope("body")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.transition(AfterBody);
                    } else if (name2.equals("html")) {
                        if (htmlTreeBuilder.processEndTag("body")) {
                            return htmlTreeBuilder.process(asEndTag);
                        }
                    } else if (name2.equals("form")) {
                        FormElement formElement = htmlTreeBuilder.getFormElement();
                        htmlTreeBuilder.setFormElement(null);
                        if (formElement == null || !htmlTreeBuilder.inScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                    } else if (name2.equals("p")) {
                        if (!htmlTreeBuilder.inButtonScope(name2)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processStartTag(name2);
                            return htmlTreeBuilder.process(asEndTag);
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                    } else if (StringUtil.inSorted(name2, Constants.DdDt)) {
                        if (!htmlTreeBuilder.inScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                    } else if (StringUtil.inSorted(name2, Constants.Headings)) {
                        if (!htmlTreeBuilder.inScope(Constants.Headings)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(Constants.Headings);
                    } else if (name2.equals("sarcasm")) {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    } else {
                        if (StringUtil.inSorted(name2, Constants.InBodyStartApplets)) {
                            if (!htmlTreeBuilder.inScope(SerializableCookie.NAME)) {
                                if (!htmlTreeBuilder.inScope(name2)) {
                                    htmlTreeBuilder.error(this);
                                    return false;
                                }
                                htmlTreeBuilder.generateImpliedEndTags();
                                if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                                    htmlTreeBuilder.error(this);
                                }
                                htmlTreeBuilder.popStackToClose(name2);
                                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                            }
                        } else if (!name2.equals("br")) {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processStartTag("br");
                            return false;
                        }
                    }
                }
            } else if (i == 5) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.framesetOk() || !HtmlTreeBuilderState.isWhitespace(asCharacter)) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asCharacter);
                    htmlTreeBuilder.framesetOk(false);
                } else {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asCharacter);
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String name = token.asEndTag().name();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = stack.get(size);
                if (element.nodeName().equals(name)) {
                    htmlTreeBuilder.generateImpliedEndTags(name);
                    if (!name.equals(htmlTreeBuilder.currentElement().nodeName())) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                } else if (htmlTreeBuilder.isSpecial(element)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag()) {
                return true;
            } else {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return true;
            }
        }
    },
    InTable {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(InTableText);
                return htmlTreeBuilder.process(token);
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCaption);
                    return true;
                } else if (name.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InColumnGroup);
                    return true;
                } else if (name.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                } else {
                    if (StringUtil.in(name, "tbody", "tfoot", "thead")) {
                        htmlTreeBuilder.clearStackToTableContext();
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.transition(InTableBody);
                        return true;
                    }
                    if (StringUtil.in(name, "td", "th", "tr")) {
                        htmlTreeBuilder.processStartTag("tbody");
                        return htmlTreeBuilder.process(token);
                    } else if (name.equals("table")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.processEndTag("table")) {
                            return htmlTreeBuilder.process(token);
                        }
                        return true;
                    } else {
                        if (StringUtil.in(name, "style", "script")) {
                            return htmlTreeBuilder.process(token, InHead);
                        }
                        if (name.equals("input")) {
                            if (!asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.insertEmpty(asStartTag);
                            return true;
                        } else if (!name.equals("form")) {
                            return anythingElse(token, htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.getFormElement() != null) {
                                return false;
                            }
                            htmlTreeBuilder.insertForm(asStartTag, false);
                            return true;
                        }
                    }
                }
            } else if (token.isEndTag()) {
                String name2 = token.asEndTag().name();
                if (!name2.equals("table")) {
                    if (!StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.inTableScope(name2)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                }
            } else if (!token.isEOF()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    return true;
                }
                htmlTreeBuilder.error(this);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (!StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                return htmlTreeBuilder.process(token, InBody);
            }
            htmlTreeBuilder.setFosterInserts(true);
            boolean process = htmlTreeBuilder.process(token, InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return process;
        }
    },
    InTableText {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()] != 5) {
                if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                    for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                        if (!HtmlTreeBuilderState.isWhitespace(str)) {
                            htmlTreeBuilder.error(this);
                            if (StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                                htmlTreeBuilder.setFosterInserts(true);
                                htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                                htmlTreeBuilder.setFosterInserts(false);
                            } else {
                                htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                            }
                        } else {
                            htmlTreeBuilder.insert(new Token.Character().data(str));
                        }
                    }
                    htmlTreeBuilder.newPendingTableCharacters();
                }
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            }
            Token.Character asCharacter = token.asCharacter();
            if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
            return true;
        }
    },
    InCaption {
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0094, code lost:
            if (org.jsoup.helper.StringUtil.in(r25.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr") == false) goto L_0x0096;
         */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.isEndTag() || !token.asEndTag().name().equals("caption")) {
                if (token.isStartTag()) {
                }
                if (!token.isEndTag() || !token.asEndTag().name().equals("table")) {
                    if (token.isEndTag()) {
                        if (StringUtil.in(token.asEndTag().name(), "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                    }
                    return htmlTreeBuilder.process(token, InBody);
                }
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag("caption")) {
                    return htmlTreeBuilder.process(token);
                }
            } else if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().nodeName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(InTable);
            }
            return true;
        }
    },
    InColumnGroup {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (!name.equals("col")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.insertEmpty(asStartTag);
            } else if (i != 4) {
                if (i != 6) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    return true;
                }
                return anythingElse(token, htmlTreeBuilder);
            } else if (!token.asEndTag().name().equals("colgroup")) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(InTable);
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }
    },
    InTableBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("tr")) {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InRow);
                } else {
                    if (StringUtil.in(name, "th", "td")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag("tr");
                        return htmlTreeBuilder.process(asStartTag);
                    }
                    if (StringUtil.in(name, "caption", "col", "colgroup", "tbody", "tfoot", "thead")) {
                        return exitTableBody(token, htmlTreeBuilder);
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String name2 = token.asEndTag().name();
                if (StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                    if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTable);
                } else if (name2.equals("table")) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("tbody") || htmlTreeBuilder.inTableScope("thead") || htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().nodeName());
                return htmlTreeBuilder.process(token);
            }
            htmlTreeBuilder.error(this);
            return false;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }
    },
    InRow {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (StringUtil.in(name, "th", "td")) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                } else {
                    if (StringUtil.in(name, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr")) {
                        return handleMissingTr(token, htmlTreeBuilder);
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (!token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String name2 = token.asEndTag().name();
                if (name2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                } else if (name2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                        if (!StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "td", "th")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.processEndTag("tr");
                        return htmlTreeBuilder.process(token);
                    }
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String name = token.asEndTag().name();
                if (!StringUtil.in(name, "td", "th")) {
                    if (StringUtil.in(name, "body", "caption", "col", "colgroup", "html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (!StringUtil.in(name, "table", "tbody", "tfoot", "thead", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (!htmlTreeBuilder.inTableScope(name)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                } else if (!htmlTreeBuilder.inTableScope(name)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InRow);
                    return false;
                } else {
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(name)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(InRow);
                    return true;
                }
            } else {
                if (token.isStartTag()) {
                    if (StringUtil.in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        if (htmlTreeBuilder.inTableScope("td") || htmlTreeBuilder.inTableScope("th")) {
                            closeCell(htmlTreeBuilder);
                            return htmlTreeBuilder.process(token);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.processEndTag("td");
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }
    },
    InSelect {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    break;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        return htmlTreeBuilder.process(asStartTag, InBody);
                    }
                    if (name.equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (name.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        } else if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (name.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag("select");
                    } else {
                        if (StringUtil.in(name, "input", "keygen", "textarea")) {
                            htmlTreeBuilder.error(this);
                            if (!htmlTreeBuilder.inSelectScope("select")) {
                                return false;
                            }
                            htmlTreeBuilder.processEndTag("select");
                            return htmlTreeBuilder.process(asStartTag);
                        } else if (name.equals("script")) {
                            return htmlTreeBuilder.process(token, InHead);
                        } else {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                    }
                case 4:
                    String name2 = token.asEndTag().name();
                    if (name2.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).nodeName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (!htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.error(this);
                            break;
                        } else {
                            htmlTreeBuilder.pop();
                            break;
                        }
                    } else if (name2.equals("option")) {
                        if (!htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.error(this);
                            break;
                        } else {
                            htmlTreeBuilder.pop();
                            break;
                        }
                    } else if (name2.equals("select")) {
                        if (htmlTreeBuilder.inSelectScope(name2)) {
                            htmlTreeBuilder.popStackToClose(name2);
                            htmlTreeBuilder.resetInsertionMode();
                            break;
                        } else {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (!asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.insert(asCharacter);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 6:
                    if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        break;
                    }
                    break;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                if (StringUtil.in(token.asStartTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processEndTag("select");
                    return htmlTreeBuilder.process(token);
                }
            }
            if (token.isEndTag()) {
                if (StringUtil.in(token.asEndTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                    htmlTreeBuilder.error(this);
                    if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                        return false;
                    }
                    htmlTreeBuilder.processEndTag("select");
                    return htmlTreeBuilder.process(token);
                }
            }
            return htmlTreeBuilder.process(token, InSelect);
        }
    },
    AfterBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().name().equals("html")) {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                } else if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.transition(AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(asStartTag, InBody);
                }
                if (name.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                } else if (name.equals("frame")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (name.equals("noframes")) {
                    return htmlTreeBuilder.process(asStartTag, InHead);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (!token.isEndTag() || !token.asEndTag().name().equals("frameset")) {
                if (!token.isEOF()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                }
            } else if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().nodeName().equals("frameset")) {
                    htmlTreeBuilder.transition(AfterFrameset);
                }
            }
            return true;
        }
    },
    AfterFrameset {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                    htmlTreeBuilder.transition(AfterAfterFrameset);
                    return true;
                } else if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.transition(InBody);
                return htmlTreeBuilder.process(token);
            }
        }
    },
    AfterAfterFrameset {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }
    },
    ForeignContent {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    private static String nullString = String.valueOf((char) 0);

    /* access modifiers changed from: package-private */
    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            iArr[Token.TokenType.Comment.ordinal()] = 1;
            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return isWhitespace(token.asCharacter().getData());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!StringUtil.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    /* access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    private static final class Constants {
        private static final String[] DdDt = {"dd", "dt"};
        private static final String[] Formatters = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        private static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        private static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        private static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        private static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};
        private static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        private static final String[] InBodyStartDrop = {"caption", "col", "colgroup", "frame", CacheEntity.HEAD, "tbody", "td", "tfoot", "th", "thead", "tr"};
        private static final String[] InBodyStartEmptyFormatters = {"area", "br", "embed", "img", "keygen", "wbr"};
        private static final String[] InBodyStartInputAttribs = {SerializableCookie.NAME, "action", "prompt"};
        private static final String[] InBodyStartLiBreakers = {"address", "div", "p"};
        private static final String[] InBodyStartMedia = {"param", "source", "track"};
        private static final String[] InBodyStartOptions = {"optgroup", "option"};
        private static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        private static final String[] InBodyStartPreListing = {"pre", "listing"};
        private static final String[] InBodyStartRuby = {"rp", "rt"};
        private static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};

        private Constants() {
        }
    }
}

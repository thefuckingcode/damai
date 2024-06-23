package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

/* access modifiers changed from: package-private */
public abstract class Token {
    TokenType type;

    /* access modifiers changed from: package-private */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    /* access modifiers changed from: package-private */
    public abstract Token reset();

    private Token() {
    }

    /* access modifiers changed from: package-private */
    public String tokenType() {
        return getClass().getSimpleName();
    }

    static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Doctype extends Token {
        boolean forceQuirks = false;
        final StringBuilder name = new StringBuilder();
        final StringBuilder publicIdentifier = new StringBuilder();
        final StringBuilder systemIdentifier = new StringBuilder();

        Doctype() {
            super();
            this.type = TokenType.Doctype;
        }

        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            reset(this.name);
            reset(this.publicIdentifier);
            reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String getName() {
            return this.name.toString();
        }

        /* access modifiers changed from: package-private */
        public String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class Tag extends Token {
        Attributes attributes;
        private boolean hasEmptyAttributeValue = false;
        private boolean hasPendingAttributeValue = false;
        private String pendingAttributeName;
        private StringBuilder pendingAttributeValue = new StringBuilder();
        private String pendingAttributeValueS;
        boolean selfClosing = false;
        protected String tagName;

        Tag() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Tag reset() {
            this.tagName = null;
            this.pendingAttributeName = null;
            reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void newAttribute() {
            Attribute attribute;
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            if (this.pendingAttributeName != null) {
                if (this.hasPendingAttributeValue) {
                    attribute = new Attribute(this.pendingAttributeName, this.pendingAttributeValue.length() > 0 ? this.pendingAttributeValue.toString() : this.pendingAttributeValueS);
                } else if (this.hasEmptyAttributeValue) {
                    attribute = new Attribute(this.pendingAttributeName, "");
                } else {
                    attribute = new BooleanAttribute(this.pendingAttributeName);
                }
                this.attributes.put(attribute);
            }
            this.pendingAttributeName = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
        }

        /* access modifiers changed from: package-private */
        public final void finaliseTag() {
            if (this.pendingAttributeName != null) {
                newAttribute();
            }
        }

        /* access modifiers changed from: package-private */
        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        /* access modifiers changed from: package-private */
        public final Tag name(String str) {
            this.tagName = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final boolean isSelfClosing() {
            return this.selfClosing;
        }

        /* access modifiers changed from: package-private */
        public final Attributes getAttributes() {
            return this.attributes;
        }

        /* access modifiers changed from: package-private */
        public final void appendTagName(String str) {
            String str2 = this.tagName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.tagName = str;
        }

        /* access modifiers changed from: package-private */
        public final void appendTagName(char c) {
            appendTagName(String.valueOf(c));
        }

        /* access modifiers changed from: package-private */
        public final void appendAttributeName(String str) {
            String str2 = this.pendingAttributeName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.pendingAttributeName = str;
        }

        /* access modifiers changed from: package-private */
        public final void appendAttributeName(char c) {
            appendAttributeName(String.valueOf(c));
        }

        /* access modifiers changed from: package-private */
        public final void appendAttributeValue(String str) {
            ensureAttributeValue();
            if (this.pendingAttributeValue.length() == 0) {
                this.pendingAttributeValueS = str;
            } else {
                this.pendingAttributeValue.append(str);
            }
        }

        /* access modifiers changed from: package-private */
        public final void appendAttributeValue(char c) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(c);
        }

        /* access modifiers changed from: package-private */
        public final void appendAttributeValue(char[] cArr) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(cArr);
        }

        /* access modifiers changed from: package-private */
        public final void setEmptyAttributeValue() {
            this.hasEmptyAttributeValue = true;
        }

        private void ensureAttributeValue() {
            this.hasPendingAttributeValue = true;
            String str = this.pendingAttributeValueS;
            if (str != null) {
                this.pendingAttributeValue.append(str);
                this.pendingAttributeValueS = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class StartTag extends Tag {
        StartTag() {
            this.attributes = new Attributes();
            this.type = TokenType.StartTag;
        }

        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token, org.jsoup.parser.Token.Tag, org.jsoup.parser.Token.Tag
        public Tag reset() {
            super.reset();
            this.attributes = new Attributes();
            return this;
        }

        /* access modifiers changed from: package-private */
        public StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            return this;
        }

        public String toString() {
            if (this.attributes == null || this.attributes.size() <= 0) {
                return "<" + name() + ">";
            }
            return "<" + name() + " " + this.attributes.toString() + ">";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class EndTag extends Tag {
        EndTag() {
            this.type = TokenType.EndTag;
        }

        public String toString() {
            return "</" + name() + ">";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Comment extends Token {
        boolean bogus = false;
        final StringBuilder data = new StringBuilder();

        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            reset(this.data);
            this.bogus = false;
            return this;
        }

        Comment() {
            super();
            this.type = TokenType.Comment;
        }

        /* access modifiers changed from: package-private */
        public String getData() {
            return this.data.toString();
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Character extends Token {
        private String data;

        Character() {
            super();
            this.type = TokenType.Character;
        }

        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            this.data = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Character data(String str) {
            this.data = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String getData() {
            return this.data;
        }

        public String toString() {
            return getData();
        }
    }

    static final class EOF extends Token {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            return this;
        }

        EOF() {
            super();
            this.type = TokenType.EOF;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isDoctype() {
        return this.type == TokenType.Doctype;
    }

    /* access modifiers changed from: package-private */
    public final Doctype asDoctype() {
        return (Doctype) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isStartTag() {
        return this.type == TokenType.StartTag;
    }

    /* access modifiers changed from: package-private */
    public final StartTag asStartTag() {
        return (StartTag) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isEndTag() {
        return this.type == TokenType.EndTag;
    }

    /* access modifiers changed from: package-private */
    public final EndTag asEndTag() {
        return (EndTag) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isComment() {
        return this.type == TokenType.Comment;
    }

    /* access modifiers changed from: package-private */
    public final Comment asComment() {
        return (Comment) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isCharacter() {
        return this.type == TokenType.Character;
    }

    /* access modifiers changed from: package-private */
    public final Character asCharacter() {
        return (Character) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isEOF() {
        return this.type == TokenType.EOF;
    }
}

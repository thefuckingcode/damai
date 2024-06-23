package org.jsoup.parser;

import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* access modifiers changed from: package-private */
public final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    static final char replacementChar = 65533;
    Token.Character charPending = new Token.Character();
    private final char[] charRefHolder = new char[1];
    private StringBuilder charsBuilder = new StringBuilder(1024);
    private String charsString = null;
    Token.Comment commentPending = new Token.Comment();
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.Doctype doctypePending = new Token.Doctype();
    private Token emitPending;
    Token.EndTag endPending = new Token.EndTag();
    private ParseErrorList errors;
    private boolean isEmitPending = false;
    private String lastStartTag;
    private CharacterReader reader;
    private boolean selfClosingFlagAcknowledged = true;
    Token.StartTag startPending = new Token.StartTag();
    private TokeniserState state = TokeniserState.Data;
    Token.Tag tagPending;

    /* access modifiers changed from: package-private */
    public boolean currentNodeInHtmlNS() {
        return true;
    }

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        notCharRefCharsSorted = cArr;
        Arrays.sort(cArr);
    }

    Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    /* access modifiers changed from: package-private */
    public Token read() {
        if (!this.selfClosingFlagAcknowledged) {
            error("Self closing flag not acknowledged");
            this.selfClosingFlagAcknowledged = true;
        }
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        if (this.charsBuilder.length() > 0) {
            String sb = this.charsBuilder.toString();
            StringBuilder sb2 = this.charsBuilder;
            sb2.delete(0, sb2.length());
            this.charsString = null;
            return this.charPending.data(sb);
        }
        String str = this.charsString;
        if (str != null) {
            Token.Character data = this.charPending.data(str);
            this.charsString = null;
            return data;
        }
        this.isEmitPending = false;
        return this.emitPending;
    }

    /* access modifiers changed from: package-private */
    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
        this.emitPending = token;
        this.isEmitPending = true;
        if (token.type == Token.TokenType.StartTag) {
            Token.StartTag startTag = (Token.StartTag) token;
            this.lastStartTag = startTag.tagName;
            if (startTag.selfClosing) {
                this.selfClosingFlagAcknowledged = false;
            }
        } else if (token.type == Token.TokenType.EndTag && ((Token.EndTag) token).attributes != null) {
            error("Attributes incorrectly present on end tag");
        }
    }

    /* access modifiers changed from: package-private */
    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    /* access modifiers changed from: package-private */
    public void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    /* access modifiers changed from: package-private */
    public void emit(char c) {
        emit(String.valueOf(c));
    }

    /* access modifiers changed from: package-private */
    public TokeniserState getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public void acknowledgeSelfClosingFlag() {
        this.selfClosingFlagAcknowledged = true;
    }

    /* access modifiers changed from: package-private */
    public char[] consumeCharacterReference(Character ch, boolean z) {
        int i;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        char[] cArr = this.charRefHolder;
        this.reader.mark();
        if (this.reader.matchConsume("#")) {
            boolean matchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
            CharacterReader characterReader = this.reader;
            String consumeHexSequence = matchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
            if (consumeHexSequence.length() == 0) {
                characterReferenceError("numeric reference with no numerals");
                this.reader.rewindToMark();
                return null;
            }
            if (!this.reader.matchConsume(";")) {
                characterReferenceError("missing semicolon");
            }
            try {
                i = Integer.valueOf(consumeHexSequence, matchConsumeIgnoreCase ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                characterReferenceError("character outside of valid range");
                cArr[0] = 65533;
                return cArr;
            } else if (i >= 65536) {
                return Character.toChars(i);
            } else {
                cArr[0] = (char) i;
                return cArr;
            }
        } else {
            String consumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
            boolean matches = this.reader.matches(';');
            if (!(Entities.isBaseNamedEntity(consumeLetterThenDigitSequence) || (Entities.isNamedEntity(consumeLetterThenDigitSequence) && matches))) {
                this.reader.rewindToMark();
                if (matches) {
                    characterReferenceError(String.format("invalid named referenece '%s'", consumeLetterThenDigitSequence));
                }
                return null;
            } else if (!z || (!this.reader.matchesLetter() && !this.reader.matchesDigit() && !this.reader.matchesAny('=', '-', '_'))) {
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                cArr[0] = Entities.getCharacterByName(consumeLetterThenDigitSequence).charValue();
                return cArr;
            } else {
                this.reader.rewindToMark();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Token.Tag createTagPending(boolean z) {
        Token.Tag reset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = reset;
        return reset;
    }

    /* access modifiers changed from: package-private */
    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    /* access modifiers changed from: package-private */
    public void createCommentPending() {
        this.commentPending.reset();
    }

    /* access modifiers changed from: package-private */
    public void emitCommentPending() {
        emit(this.commentPending);
    }

    /* access modifiers changed from: package-private */
    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    /* access modifiers changed from: package-private */
    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    /* access modifiers changed from: package-private */
    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    /* access modifiers changed from: package-private */
    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.tagName.equals(this.lastStartTag);
    }

    /* access modifiers changed from: package-private */
    public String appropriateEndTagName() {
        String str = this.lastStartTag;
        if (str == null) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    private void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    /* access modifiers changed from: package-private */
    public String unescapeEntities(boolean z) {
        StringBuilder sb = new StringBuilder();
        while (!this.reader.isEmpty()) {
            sb.append(this.reader.consumeTo(Typography.amp));
            if (this.reader.matches(Typography.amp)) {
                this.reader.consume();
                char[] consumeCharacterReference = consumeCharacterReference(null, z);
                if (consumeCharacterReference == null || consumeCharacterReference.length == 0) {
                    sb.append(Typography.amp);
                } else {
                    sb.append(consumeCharacterReference);
                }
            }
        }
        return sb.toString();
    }
}

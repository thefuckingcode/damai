package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    /* compiled from: Taobao */
    private static class CharacterIterator implements Iterator<Character> {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext() {
            if (this.range.negated) {
                char c = this.current;
                if (c == 65535) {
                    this.hasNext = false;
                } else if (c + 1 != this.range.start) {
                    this.current = (char) (this.current + 1);
                } else if (this.range.end == 65535) {
                    this.hasNext = false;
                } else {
                    this.current = (char) (this.range.end + 1);
                }
            } else if (this.current < this.range.end) {
                this.current = (char) (this.current + 1);
            } else {
                this.hasNext = false;
            }
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private CharacterIterator(CharRange charRange) {
            this.range = charRange;
            this.hasNext = true;
            if (!charRange.negated) {
                this.current = charRange.start;
            } else if (charRange.start != 0) {
                this.current = 0;
            } else if (charRange.end == 65535) {
                this.hasNext = false;
            } else {
                this.current = (char) (charRange.end + 1);
            }
        }

        @Override // java.util.Iterator
        public Character next() {
            if (this.hasNext) {
                char c = this.current;
                prepareNext();
                return Character.valueOf(c);
            }
            throw new NoSuchElementException();
        }
    }

    private CharRange(char c, char c2, boolean z) {
        if (c > c2) {
            c2 = c;
            c = c2;
        }
        this.start = c;
        this.end = c2;
        this.negated = z;
    }

    public static CharRange is(char c) {
        return new CharRange(c, c, false);
    }

    public static CharRange isIn(char c, char c2) {
        return new CharRange(c, c2, false);
    }

    public static CharRange isNot(char c) {
        return new CharRange(c, c, true);
    }

    public static CharRange isNotIn(char c, char c2) {
        return new CharRange(c, c2, true);
    }

    public boolean contains(char c) {
        return (c >= this.start && c <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        if (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated) {
            return true;
        }
        return false;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb = new StringBuilder(4);
            if (isNegated()) {
                sb.append('^');
            }
            sb.append(this.start);
            if (this.start != this.end) {
                sb.append('-');
                sb.append(this.end);
            }
            this.iToString = sb.toString();
        }
        return this.iToString;
    }

    public boolean contains(CharRange charRange) {
        Validate.isTrue(charRange != null, "The Range must not be null", new Object[0]);
        if (this.negated) {
            if (charRange.negated) {
                if (this.start < charRange.start || this.end > charRange.end) {
                    return false;
                }
                return true;
            } else if (charRange.end < this.start || charRange.start > this.end) {
                return true;
            } else {
                return false;
            }
        } else if (charRange.negated) {
            if (this.start == 0 && this.end == 65535) {
                return true;
            }
            return false;
        } else if (this.start > charRange.start || this.end < charRange.end) {
            return false;
        } else {
            return true;
        }
    }
}

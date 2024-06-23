package org.apache.commons.text;

/* compiled from: Taobao */
public enum CharacterPredicates implements CharacterPredicate {
    LETTERS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return Character.isLetter(i);
        }
    },
    DIGITS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return Character.isDigit(i);
        }
    },
    ARABIC_NUMERALS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return i >= 48 && i <= 57;
        }
    },
    ASCII_LOWERCASE_LETTERS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return i >= 97 && i <= 122;
        }
    },
    ASCII_UPPERCASE_LETTERS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return i >= 65 && i <= 90;
        }
    },
    ASCII_LETTERS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return CharacterPredicates.ASCII_LOWERCASE_LETTERS.test(i) || CharacterPredicates.ASCII_UPPERCASE_LETTERS.test(i);
        }
    },
    ASCII_ALPHA_NUMERALS {
        @Override // org.apache.commons.text.CharacterPredicate
        public boolean test(int i) {
            return CharacterPredicates.ASCII_LOWERCASE_LETTERS.test(i) || CharacterPredicates.ASCII_UPPERCASE_LETTERS.test(i) || CharacterPredicates.ARABIC_NUMERALS.test(i);
        }
    }
}

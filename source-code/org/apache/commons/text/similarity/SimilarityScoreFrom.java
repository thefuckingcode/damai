package org.apache.commons.text.similarity;

import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public class SimilarityScoreFrom<R> {
    private final CharSequence left;
    private final SimilarityScore<R> similarityScore;

    public SimilarityScoreFrom(SimilarityScore<R> similarityScore2, CharSequence charSequence) {
        Validate.isTrue(similarityScore2 != null, "The edit distance may not be null.", new Object[0]);
        this.similarityScore = similarityScore2;
        this.left = charSequence;
    }

    public R apply(CharSequence charSequence) {
        return this.similarityScore.apply(this.left, charSequence);
    }

    public CharSequence getLeft() {
        return this.left;
    }

    public SimilarityScore<R> getSimilarityScore() {
        return this.similarityScore;
    }
}

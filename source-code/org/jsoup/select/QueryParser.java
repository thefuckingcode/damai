package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;

/* access modifiers changed from: package-private */
public class QueryParser {
    private static final String[] AttributeEvals = {"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern NTH_AB = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
    private static final Pattern NTH_B = Pattern.compile("(\\+|-)?(\\d+)");
    private static final String[] combinators = {",", ">", "+", "~", " "};
    private List<Evaluator> evals = new ArrayList();
    private String query;
    private TokenQueue tq;

    private QueryParser(String str) {
        this.query = str;
        this.tq = new TokenQueue(str);
    }

    public static Evaluator parse(String str) {
        return new QueryParser(str).parse();
    }

    /* access modifiers changed from: package-private */
    public Evaluator parse() {
        this.tq.consumeWhitespace();
        if (this.tq.matchesAny(combinators)) {
            this.evals.add(new StructuralEvaluator.Root());
            combinator(this.tq.consume());
        } else {
            findElements();
        }
        while (!this.tq.isEmpty()) {
            boolean consumeWhitespace = this.tq.consumeWhitespace();
            if (this.tq.matchesAny(combinators)) {
                combinator(this.tq.consume());
            } else if (consumeWhitespace) {
                combinator(' ');
            } else {
                findElements();
            }
        }
        if (this.evals.size() == 1) {
            return this.evals.get(0);
        }
        return new CombiningEvaluator.And(this.evals);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    private void combinator(char c) {
        boolean z;
        CombiningEvaluator.Or or;
        Evaluator evaluator;
        CombiningEvaluator.And and;
        this.tq.consumeWhitespace();
        Evaluator parse = parse(consumeSubQuery());
        if (this.evals.size() == 1) {
            evaluator = this.evals.get(0);
            if ((evaluator instanceof CombiningEvaluator.Or) && c != ',') {
                z = true;
                or = evaluator;
                evaluator = ((CombiningEvaluator.Or) evaluator).rightMostEvaluator();
                this.evals.clear();
                if (c != '>') {
                    and = new CombiningEvaluator.And(parse, new StructuralEvaluator.ImmediateParent(evaluator));
                } else if (c == ' ') {
                    and = new CombiningEvaluator.And(parse, new StructuralEvaluator.Parent(evaluator));
                } else if (c == '+') {
                    and = new CombiningEvaluator.And(parse, new StructuralEvaluator.ImmediatePreviousSibling(evaluator));
                } else if (c == '~') {
                    and = new CombiningEvaluator.And(parse, new StructuralEvaluator.PreviousSibling(evaluator));
                } else if (c != ',') {
                    throw new Selector.SelectorParseException("Unknown combinator: " + c, new Object[0]);
                } else if (evaluator instanceof CombiningEvaluator.Or) {
                    CombiningEvaluator.Or or2 = (CombiningEvaluator.Or) evaluator;
                    or2.add(parse);
                    and = or2;
                } else {
                    CombiningEvaluator.Or or3 = new CombiningEvaluator.Or();
                    or3.add(evaluator);
                    or3.add(parse);
                    and = or3;
                }
                if (!z) {
                    ((CombiningEvaluator.Or) or).replaceRightMostEvaluator(and);
                } else {
                    or = and;
                }
                this.evals.add(or);
            }
        } else {
            evaluator = new CombiningEvaluator.And(this.evals);
        }
        or = evaluator;
        z = false;
        this.evals.clear();
        if (c != '>') {
        }
        if (!z) {
        }
        this.evals.add(or);
    }

    private String consumeSubQuery() {
        StringBuilder sb = new StringBuilder();
        while (!this.tq.isEmpty()) {
            if (this.tq.matches("(")) {
                sb.append("(");
                sb.append(this.tq.chompBalanced('(', ')'));
                sb.append(")");
            } else if (this.tq.matches("[")) {
                sb.append("[");
                sb.append(this.tq.chompBalanced('[', ']'));
                sb.append("]");
            } else if (this.tq.matchesAny(combinators)) {
                break;
            } else {
                sb.append(this.tq.consume());
            }
        }
        return sb.toString();
    }

    private void findElements() {
        if (this.tq.matchChomp("#")) {
            byId();
        } else if (this.tq.matchChomp(".")) {
            byClass();
        } else if (this.tq.matchesWord()) {
            byTag();
        } else if (this.tq.matches("[")) {
            byAttribute();
        } else if (this.tq.matchChomp("*")) {
            allElements();
        } else if (this.tq.matchChomp(":lt(")) {
            indexLessThan();
        } else if (this.tq.matchChomp(":gt(")) {
            indexGreaterThan();
        } else if (this.tq.matchChomp(":eq(")) {
            indexEquals();
        } else if (this.tq.matches(":has(")) {
            has();
        } else if (this.tq.matches(":contains(")) {
            contains(false);
        } else if (this.tq.matches(":containsOwn(")) {
            contains(true);
        } else if (this.tq.matches(":matches(")) {
            matches(false);
        } else if (this.tq.matches(":matchesOwn(")) {
            matches(true);
        } else if (this.tq.matches(":not(")) {
            not();
        } else if (this.tq.matchChomp(":nth-child(")) {
            cssNthChild(false, false);
        } else if (this.tq.matchChomp(":nth-last-child(")) {
            cssNthChild(true, false);
        } else if (this.tq.matchChomp(":nth-of-type(")) {
            cssNthChild(false, true);
        } else if (this.tq.matchChomp(":nth-last-of-type(")) {
            cssNthChild(true, true);
        } else if (this.tq.matchChomp(":first-child")) {
            this.evals.add(new Evaluator.IsFirstChild());
        } else if (this.tq.matchChomp(":last-child")) {
            this.evals.add(new Evaluator.IsLastChild());
        } else if (this.tq.matchChomp(":first-of-type")) {
            this.evals.add(new Evaluator.IsFirstOfType());
        } else if (this.tq.matchChomp(":last-of-type")) {
            this.evals.add(new Evaluator.IsLastOfType());
        } else if (this.tq.matchChomp(":only-child")) {
            this.evals.add(new Evaluator.IsOnlyChild());
        } else if (this.tq.matchChomp(":only-of-type")) {
            this.evals.add(new Evaluator.IsOnlyOfType());
        } else if (this.tq.matchChomp(":empty")) {
            this.evals.add(new Evaluator.IsEmpty());
        } else if (this.tq.matchChomp(":root")) {
            this.evals.add(new Evaluator.IsRoot());
        } else {
            throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.tq.remainder());
        }
    }

    private void byId() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Id(consumeCssIdentifier));
    }

    private void byClass() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Class(consumeCssIdentifier.trim().toLowerCase()));
    }

    private void byTag() {
        String consumeElementSelector = this.tq.consumeElementSelector();
        Validate.notEmpty(consumeElementSelector);
        if (consumeElementSelector.contains("|")) {
            consumeElementSelector = consumeElementSelector.replace("|", ":");
        }
        this.evals.add(new Evaluator.Tag(consumeElementSelector.trim().toLowerCase()));
    }

    private void byAttribute() {
        TokenQueue tokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'));
        String consumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(consumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (consumeToAny.startsWith("^")) {
                this.evals.add(new Evaluator.AttributeStarting(consumeToAny.substring(1)));
            } else {
                this.evals.add(new Evaluator.Attribute(consumeToAny));
            }
        } else if (tokenQueue.matchChomp("=")) {
            this.evals.add(new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("!=")) {
            this.evals.add(new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("^=")) {
            this.evals.add(new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("$=")) {
            this.evals.add(new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("*=")) {
            this.evals.add(new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("~=")) {
            this.evals.add(new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder())));
        } else {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
        }
    }

    private void allElements() {
        this.evals.add(new Evaluator.AllElements());
    }

    private void indexLessThan() {
        this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
    }

    private void indexGreaterThan() {
        this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
    }

    private void indexEquals() {
        this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
    }

    private void cssNthChild(boolean z, boolean z2) {
        String lowerCase = this.tq.chompTo(")").trim().toLowerCase();
        Matcher matcher = NTH_AB.matcher(lowerCase);
        Matcher matcher2 = NTH_B.matcher(lowerCase);
        int i = 2;
        int i2 = 0;
        if ("odd".equals(lowerCase)) {
            i2 = 1;
        } else if (!"even".equals(lowerCase)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    i2 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
                i = parseInt;
            } else if (matcher2.matches()) {
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", lowerCase);
            }
        }
        if (z2) {
            if (z) {
                this.evals.add(new Evaluator.IsNthLastOfType(i, i2));
            } else {
                this.evals.add(new Evaluator.IsNthOfType(i, i2));
            }
        } else if (z) {
            this.evals.add(new Evaluator.IsNthLastChild(i, i2));
        } else {
            this.evals.add(new Evaluator.IsNthChild(i, i2));
        }
    }

    private int consumeIndex() {
        String trim = this.tq.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private void has() {
        this.tq.consume(":has");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":has(el) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Has(parse(chompBalanced)));
    }

    private void contains(boolean z) {
        this.tq.consume(z ? ":containsOwn" : ":contains");
        String unescape = TokenQueue.unescape(this.tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":contains(text) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.ContainsOwnText(unescape));
        } else {
            this.evals.add(new Evaluator.ContainsText(unescape));
        }
    }

    private void matches(boolean z) {
        this.tq.consume(z ? ":matchesOwn" : ":matches");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.MatchesOwn(Pattern.compile(chompBalanced)));
        } else {
            this.evals.add(new Evaluator.Matches(Pattern.compile(chompBalanced)));
        }
    }

    private void not() {
        this.tq.consume(":not");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":not(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Not(parse(chompBalanced)));
    }
}

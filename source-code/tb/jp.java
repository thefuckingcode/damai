package tb;

import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.css.CssUnit;
import java.io.PrintStream;
import java.net.URI;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public class jp {
    public static final int DPI = 96;
    public static final float FONT_WEIGHT_BOLD = 700.0f;
    public static final float FONT_WEIGHT_NORMAL = 400.0f;
    private static final int[] h = new int[0];
    private static final jp i = new jp();
    private static final CssUnit[] j = CssUnit.values();
    private static final CssProperty[] k;
    private static final CssEnum[] l = CssEnum.values();
    private static final LinkedHashMap<String, CssProperty> m = new LinkedHashMap<>();
    private static final LinkedHashMap<String, CssEnum> n = new LinkedHashMap<>();
    private static final LinkedHashMap<String, CssUnit> o = new LinkedHashMap<>();
    private float[] a;
    private byte[] b;
    String c;
    String d;
    int e;
    int f;
    int[] g = h;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(160:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(161:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(162:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(163:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(164:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(165:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(166:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(167:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(168:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(169:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(170:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(171:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(172:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(173:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(174:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(176:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(178:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(179:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|(2:175|176)|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|(3:201|202|204)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(183:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|204) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x015b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x0165 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x016f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0179 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x0183 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x018d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x0199 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x01a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x01ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x01b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x01c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x01cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x01d9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x01e5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x01f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x01fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x0209 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x0215 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x0221 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x022d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x0239 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:143:0x0245 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x0251 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x025d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x0269 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x0275 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:153:0x0281 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:155:0x028d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x0299 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x02a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x02b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:163:0x02bd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x02c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:167:0x02d5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x02e1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:171:0x02ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:173:0x02f9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:175:0x0305 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:181:0x0322 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:183:0x032c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:185:0x0336 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:187:0x0340 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:189:0x034a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:191:0x0354 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:193:0x035e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:195:0x0368 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:197:0x0372 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:199:0x037c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:201:0x0386 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x010b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0115 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x011f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0129 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0133 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x013d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0147 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x0151 */
        static {
            int[] iArr = new int[CssEnum.values().length];
            c = iArr;
            try {
                iArr[CssEnum.WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[CssEnum.SILVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[CssEnum.GRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[CssEnum.RED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[CssEnum.MAROON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[CssEnum.YELLOW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[CssEnum.OLIVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[CssEnum.LIME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[CssEnum.GREEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[CssEnum.AQUA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[CssEnum.TEAL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                c[CssEnum.BLUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                c[CssEnum.NAVY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                c[CssEnum.FUCHSIA.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                c[CssEnum.PURPLE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                c[CssEnum.TOP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                c[CssEnum.LEFT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                c[CssEnum.CENTER.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                c[CssEnum.RIGHT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                c[CssEnum.BOTTOM.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr2 = new int[CssProperty.values().length];
            b = iArr2;
            iArr2[CssProperty.BORDER_TOP_WIDTH.ordinal()] = 1;
            b[CssProperty.BORDER_BOTTOM_WIDTH.ordinal()] = 2;
            b[CssProperty.BORDER_LEFT_WIDTH.ordinal()] = 3;
            b[CssProperty.BORDER_RIGHT_WIDTH.ordinal()] = 4;
            b[CssProperty.BOTTOM.ordinal()] = 5;
            b[CssProperty.HEIGHT.ordinal()] = 6;
            b[CssProperty.LEFT.ordinal()] = 7;
            b[CssProperty.RIGHT.ordinal()] = 8;
            b[CssProperty.TABLE_LAYOUT.ordinal()] = 9;
            b[CssProperty.TOP.ordinal()] = 10;
            b[CssProperty.WIDTH.ordinal()] = 11;
            b[CssProperty.BACKGROUND_COLOR.ordinal()] = 12;
            b[CssProperty.DISPLAY.ordinal()] = 13;
            b[CssProperty.FONT_SIZE.ordinal()] = 14;
            b[CssProperty.FONT_WEIGHT.ordinal()] = 15;
            b[CssProperty.LINE_HEIGHT.ordinal()] = 16;
            b[CssProperty.LIST_STYLE_TYPE.ordinal()] = 17;
            b[CssProperty.USER_SELECT.ordinal()] = 18;
            b[CssProperty.POSITION.ordinal()] = 19;
            b[CssProperty.BACKGROUND_REPEAT.ordinal()] = 20;
            b[CssProperty.OVERFLOW.ordinal()] = 21;
            b[CssProperty.WHITE_SPACE.ordinal()] = 22;
            b[CssProperty.TEXT_OVERFLOW.ordinal()] = 23;
            b[CssProperty.BACKGROUND_POSITION_X.ordinal()] = 24;
            b[CssProperty.BACKGROUND_POSITION_Y.ordinal()] = 25;
            b[CssProperty.COLOR.ordinal()] = 26;
            b[CssProperty.BORDER_TOP_COLOR.ordinal()] = 27;
            b[CssProperty.BORDER_RIGHT_COLOR.ordinal()] = 28;
            b[CssProperty.BORDER_BOTTOM_COLOR.ordinal()] = 29;
            b[CssProperty.BORDER_LEFT_COLOR.ordinal()] = 30;
            b[CssProperty.MARGIN_TOP.ordinal()] = 31;
            b[CssProperty.MARGIN_RIGHT.ordinal()] = 32;
            b[CssProperty.MARGIN_BOTTOM.ordinal()] = 33;
            b[CssProperty.MARGIN_LEFT.ordinal()] = 34;
            b[CssProperty.PADDING_TOP.ordinal()] = 35;
            b[CssProperty.PADDING_RIGHT.ordinal()] = 36;
            b[CssProperty.PADDING_BOTTOM.ordinal()] = 37;
            b[CssProperty.PADDING_LEFT.ordinal()] = 38;
            b[CssProperty.BORDER.ordinal()] = 39;
            b[CssProperty.BACKGROUND.ordinal()] = 40;
            b[CssProperty.BACKGROUND_POSITION.ordinal()] = 41;
            b[CssProperty.LIST_STYLE.ordinal()] = 42;
            b[CssProperty.FONT.ordinal()] = 43;
            b[CssProperty.BORDER_COLOR.ordinal()] = 44;
            b[CssProperty.BORDER_STYLE.ordinal()] = 45;
            b[CssProperty.BORDER_WIDTH.ordinal()] = 46;
            b[CssProperty.PADDING.ordinal()] = 47;
            try {
                b[CssProperty.MARGIN.ordinal()] = 48;
            } catch (NoSuchFieldError unused21) {
            }
            int[] iArr3 = new int[CssUnit.values().length];
            a = iArr3;
            iArr3[CssUnit.ENUM.ordinal()] = 1;
            a[CssUnit.ARGB.ordinal()] = 2;
            a[CssUnit.PERCENT.ordinal()] = 3;
            a[CssUnit.PX.ordinal()] = 4;
            a[CssUnit.NUMBER.ordinal()] = 5;
            a[CssUnit.EM.ordinal()] = 6;
            a[CssUnit.EX.ordinal()] = 7;
            a[CssUnit.IN.ordinal()] = 8;
            a[CssUnit.CM.ordinal()] = 9;
            a[CssUnit.MM.ordinal()] = 10;
            a[CssUnit.PT.ordinal()] = 11;
            try {
                a[CssUnit.PC.ordinal()] = 12;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        CssProperty[] values = CssProperty.values();
        k = values;
        for (CssProperty cssProperty : values) {
            m.put(ip.a(cssProperty.name()), cssProperty);
        }
        CssEnum[] cssEnumArr = l;
        for (CssEnum cssEnum : cssEnumArr) {
            n.put(ip.a(cssEnum.name()), cssEnum);
        }
        CssUnit[] cssUnitArr = j;
        int length = cssUnitArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            CssUnit cssUnit = cssUnitArr[i2];
            o.put(cssUnit == CssUnit.PERCENT ? "%" : ip.a(cssUnit.name()), cssUnit);
        }
    }

    public static jp b(String str) {
        jp jpVar = new jp();
        jpVar.l(null, str);
        return jpVar;
    }

    public int a(jp jpVar) {
        int i2 = this.e;
        int i3 = jpVar.e;
        if (i2 > i3) {
            return 1;
        }
        if (i2 < i3) {
            return -1;
        }
        int min = Math.min(this.g.length, jpVar.g.length);
        for (int i4 = 0; i4 < min; i4++) {
            int[] iArr = this.g;
            int i5 = iArr[i4];
            int[] iArr2 = jpVar.g;
            if (i5 > iArr2[i4]) {
                return 1;
            }
            if (iArr[i4] < iArr2[i4]) {
                return -1;
            }
        }
        int i6 = min + 1;
        int[] iArr3 = this.g;
        int i7 = i6 < iArr3.length ? iArr3[i6] : this.f;
        int[] iArr4 = jpVar.g;
        return i7 - (i6 < iArr4.length ? iArr4[i6] : jpVar.f);
    }

    public float c(CssProperty cssProperty, CssUnit cssUnit) {
        return d(cssProperty, cssUnit, 0.0f);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public float d(CssProperty cssProperty, CssUnit cssUnit, float f2) {
        float f3;
        float c2;
        int i2;
        int ordinal = cssProperty.ordinal();
        float[] fArr = this.a;
        float f4 = 0.0f;
        if (fArr == null || ordinal >= fArr.length || this.b[ordinal] == 0) {
            switch (a.b[cssProperty.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = CssEnum.MEDIUM.ordinal();
                    f3 = (float) i2;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    i2 = CssEnum.AUTO.ordinal();
                    f3 = (float) i2;
                    break;
                case 12:
                    f3 = 1.6777215E7f;
                    break;
                case 13:
                    i2 = CssEnum.INLINE.ordinal();
                    f3 = (float) i2;
                    break;
                case 14:
                    f3 = 12.0f;
                    break;
                case 15:
                    f3 = 400.0f;
                    break;
                case 16:
                    f3 = 100.0f;
                    break;
                case 17:
                    i2 = CssEnum.DISC.ordinal();
                    f3 = (float) i2;
                    break;
                case 18:
                    i2 = CssEnum.TEXT.ordinal();
                    f3 = (float) i2;
                    break;
                case 19:
                    i2 = CssEnum.STATIC.ordinal();
                    f3 = (float) i2;
                    break;
                case 20:
                    i2 = CssEnum.REPEAT.ordinal();
                    f3 = (float) i2;
                    break;
                case 21:
                case 22:
                case 23:
                    i2 = CssEnum.TEXT.ordinal();
                    f3 = (float) i2;
                    break;
                default:
                    int i3 = a.a[i(cssProperty).ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            f3 = -1.6777216E7f;
                            break;
                        } else {
                            f3 = 0.0f;
                            break;
                        }
                    } else {
                        i2 = CssEnum.NONE.ordinal();
                        f3 = (float) i2;
                        break;
                    }
            }
        } else {
            f3 = fArr[ordinal];
        }
        CssUnit i4 = i(cssProperty);
        if (i4 == cssUnit) {
            return f3;
        }
        if (i4 == CssUnit.ENUM && cssUnit == CssUnit.ARGB) {
            switch (a.c[l[(int) f3].ordinal()]) {
                case 1:
                    return -1.0f;
                case 2:
                    return -4144960.0f;
                case 3:
                    return -8355712.0f;
                case 4:
                    return -65536.0f;
                case 5:
                    return -8388608.0f;
                case 6:
                    return -256.0f;
                case 7:
                    return -8355840.0f;
                case 8:
                    return -1.6711936E7f;
                case 9:
                    return -1.6744448E7f;
                case 10:
                    return -1.6711681E7f;
                case 11:
                    return -1.674432E7f;
                case 12:
                    return -1.6776961E7f;
                case 13:
                    return -1.6777088E7f;
                case 14:
                    return -65281.0f;
                case 15:
                    return -8388480.0f;
                default:
                    return -1.6777216E7f;
            }
        } else {
            int[] iArr = a.a;
            switch (iArr[i4.ordinal()]) {
                case 1:
                    if (f3 != ((float) CssEnum.NONE.ordinal())) {
                        if (ordinal >= CssProperty.BORDER_TOP_WIDTH.ordinal() && ordinal <= CssProperty.BORDER_LEFT_WIDTH.ordinal()) {
                            if (f3 != ((float) CssEnum.THIN.ordinal())) {
                                if (f3 != ((float) CssEnum.THICK.ordinal())) {
                                    f4 = 2.0f;
                                    break;
                                } else {
                                    f4 = 3.0f;
                                    break;
                                }
                            } else {
                                f4 = 1.0f;
                                break;
                            }
                        } else {
                            PrintStream printStream = System.err;
                            printStream.println("CssStyleDeclaration: Can't convert enum " + f3 + " to " + cssUnit + " for " + cssProperty);
                            break;
                        }
                    }
                    f4 = f3;
                    break;
                case 2:
                default:
                    PrintStream printStream2 = System.err;
                    printStream2.println("CssStyleDeclaration: Can't convert enum " + 0.0f + " to " + cssUnit + " for " + cssProperty);
                    break;
                case 3:
                    if (cssProperty != CssProperty.FONT_SIZE) {
                        if (cssProperty != CssProperty.LINE_HEIGHT) {
                            f4 = (f2 * f3) / 100.0f;
                            break;
                        } else {
                            f4 = 20.0f;
                            break;
                        }
                    }
                    f4 = 16.0f;
                    break;
                case 4:
                case 5:
                    f4 = f3;
                    break;
                case 6:
                    CssProperty cssProperty2 = CssProperty.FONT_SIZE;
                    if (cssProperty != cssProperty2) {
                        c2 = c(cssProperty2, CssUnit.PX);
                        f4 = f3 * c2;
                        break;
                    }
                    f4 = 16.0f;
                    break;
                case 7:
                    CssProperty cssProperty3 = CssProperty.FONT_SIZE;
                    if (cssProperty != cssProperty3) {
                        c2 = c(cssProperty3, CssUnit.PX) / 2.0f;
                        f4 = f3 * c2;
                        break;
                    } else {
                        f4 = 8.0f;
                        break;
                    }
                case 8:
                    f4 = f3 * 96.0f;
                    break;
                case 9:
                    c2 = 37.795277f;
                    f4 = f3 * c2;
                    break;
                case 10:
                    c2 = 3.7795277f;
                    f4 = f3 * c2;
                    break;
                case 11:
                    f4 = f3 * 1.0f;
                    break;
                case 12:
                    f4 = f3 * 16.0f;
                    break;
            }
            switch (iArr[cssUnit.ordinal()]) {
                case 6:
                    return f4 / c(CssProperty.FONT_SIZE, CssUnit.PX);
                case 7:
                    return (f4 / c(CssProperty.FONT_SIZE, CssUnit.PX)) / 2.0f;
                case 8:
                    return f4 / 96.0f;
                case 9:
                    return (f4 * 2.54f) / 96.0f;
                case 10:
                    return (f4 * 25.4f) / 96.0f;
                case 11:
                    return (f4 * 72.0f) / 96.0f;
                case 12:
                    return (f4 * 6.0f) / 96.0f;
                default:
                    return f4;
            }
        }
    }

    public int e(CssProperty cssProperty) {
        return (int) c(cssProperty, CssUnit.ARGB);
    }

    public CssEnum f(CssProperty cssProperty) {
        return l[(int) c(cssProperty, CssUnit.ENUM)];
    }

    public float g(CssProperty cssProperty, float f2) {
        int i2 = a.b[cssProperty.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && f(CssProperty.BORDER_RIGHT_STYLE) == CssEnum.NONE) {
                        return 0.0f;
                    }
                } else if (f(CssProperty.BORDER_LEFT_STYLE) == CssEnum.NONE) {
                    return 0.0f;
                }
            } else if (f(CssProperty.BORDER_BOTTOM_STYLE) == CssEnum.NONE) {
                return 0.0f;
            }
        } else if (f(CssProperty.BORDER_TOP_STYLE) == CssEnum.NONE) {
            return 0.0f;
        }
        return d(cssProperty, CssUnit.PX, f2);
    }

    public String h(CssProperty cssProperty) {
        if (!k(cssProperty)) {
            return null;
        }
        if (cssProperty == CssProperty.BACKGROUND_IMAGE) {
            return this.c;
        }
        if (cssProperty == CssProperty.FONT_FAMILY) {
            return this.d;
        }
        CssUnit i2 = i(cssProperty);
        int i3 = a.a[i2.ordinal()];
        if (i3 == 1) {
            return ip.a(f(cssProperty).name());
        }
        if (i3 != 2) {
            StringBuilder sb = new StringBuilder();
            float c2 = c(cssProperty, i2);
            int i4 = (int) c2;
            if (c2 == ((float) i4)) {
                sb.append(i4);
            } else {
                sb.append(c2);
            }
            if (i2 == CssUnit.PERCENT) {
                sb.append("%");
            } else if (i2 != CssUnit.NUMBER) {
                sb.append(ip.a(i2.name()));
            }
            return sb.toString();
        }
        return '#' + Integer.toString((e(cssProperty) & 16777215) | 16777216, 16).substring(1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
    public CssUnit i(CssProperty cssProperty) {
        int ordinal = cssProperty.ordinal();
        byte[] bArr = this.b;
        if (bArr != null && ordinal < bArr.length && bArr[ordinal] != 0) {
            return j[bArr[ordinal]];
        }
        int i2 = a.b[cssProperty.ordinal()];
        if (i2 != 12) {
            switch (i2) {
                case 14:
                    return CssUnit.PT;
                case 15:
                    return CssUnit.NUMBER;
                case 16:
                    return CssUnit.PERCENT;
                default:
                    switch (i2) {
                        case 24:
                        case 25:
                            break;
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                            break;
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                            break;
                        default:
                            return CssUnit.ENUM;
                    }
            }
        }
        return CssUnit.ARGB;
    }

    public void j(jp jpVar) {
        if (jpVar == null) {
            jpVar = i;
        }
        float[] fArr = this.a;
        int length = fArr == null ? 0 : fArr.length;
        float[] fArr2 = jpVar.a;
        int max = Math.max(length, fArr2 == null ? 0 : fArr2.length);
        for (int i2 = 0; i2 < max; i2++) {
            CssProperty cssProperty = k[i2];
            if (i(cssProperty) != CssUnit.ENUM || f(cssProperty) != CssEnum.INHERIT) {
                CssUnit i3 = i(cssProperty);
                CssUnit cssUnit = CssUnit.PERCENT;
                if (i3 == cssUnit) {
                    CssProperty cssProperty2 = CssProperty.FONT_SIZE;
                    if (cssProperty == cssProperty2) {
                        CssUnit i4 = jpVar.i(cssProperty);
                        n(cssProperty, (jpVar.c(cssProperty, i4) * c(cssProperty, cssUnit)) / 100.0f, i4);
                    } else if (cssProperty == CssProperty.LINE_HEIGHT) {
                        CssUnit i5 = i(cssProperty2);
                        n(cssProperty, (c(cssProperty2, i5) * c(cssProperty, cssUnit)) / 100.0f, i5);
                    }
                } else {
                    CssUnit i6 = i(cssProperty);
                    CssUnit cssUnit2 = CssUnit.EM;
                    if (i6 == cssUnit2 && cssProperty == CssProperty.FONT_SIZE) {
                        CssUnit i7 = jpVar.i(cssProperty);
                        n(cssProperty, jpVar.c(cssProperty, i7) * c(cssProperty, cssUnit2), i7);
                    } else {
                        CssUnit i8 = i(cssProperty);
                        CssUnit cssUnit3 = CssUnit.EX;
                        if (i8 == cssUnit3 && cssProperty == CssProperty.FONT_SIZE) {
                            CssUnit i9 = jpVar.i(cssProperty);
                            n(cssProperty, (jpVar.c(cssProperty, i9) * c(cssProperty, cssUnit3)) / 2.0f, i9);
                        } else if (jpVar.k(cssProperty) && i2 < CssProperty.TEXT_PROPERTY_COUNT && cssProperty != CssProperty.BACKGROUND_COLOR && cssProperty != CssProperty.DISPLAY) {
                            if (cssProperty == CssProperty.FONT_FAMILY) {
                                this.d = jpVar.d;
                            }
                            CssUnit i10 = jpVar.i(cssProperty);
                            n(cssProperty, jpVar.c(cssProperty, i10), i10);
                        }
                    }
                }
            } else if (cssProperty == CssProperty.BACKGROUND_IMAGE) {
                this.c = jpVar.c;
            } else if (cssProperty == CssProperty.FONT_FAMILY) {
                this.d = jpVar.d;
            } else {
                CssUnit i11 = jpVar.i(cssProperty);
                n(cssProperty, jpVar.c(cssProperty, i11), i11);
            }
        }
    }

    public boolean k(CssProperty cssProperty) {
        if (cssProperty == CssProperty.BACKGROUND_IMAGE) {
            if (this.c != null) {
                return true;
            }
            return false;
        } else if (cssProperty != CssProperty.FONT_FAMILY) {
            float[] fArr = this.a;
            if (fArr == null || fArr.length <= cssProperty.ordinal() || this.b[cssProperty.ordinal()] == 0) {
                return false;
            }
            return true;
        } else if (this.d != null) {
            return true;
        } else {
            return false;
        }
    }

    public void l(URI uri, String str) {
        m(new lp(uri, str));
    }

    /* access modifiers changed from: package-private */
    public void m(lp lpVar) {
        while (true) {
            int i2 = lpVar.a;
            if (i2 != -1 && i2 != 125) {
                if (i2 == -2) {
                    String str = lpVar.b;
                    CssProperty cssProperty = m.get(str);
                    if (cssProperty == null) {
                        lpVar.b("unrecognized property");
                    }
                    lpVar.c(false);
                    if (lpVar.a == 58) {
                        lpVar.c(false);
                        int i3 = 0;
                        while (true) {
                            int i4 = lpVar.a;
                            String str2 = "";
                            if (i4 != -4) {
                                if (i4 != -2) {
                                    if (i4 != 44) {
                                        switch (i4) {
                                            case -10:
                                                if (cssProperty != CssProperty.BACKGROUND && cssProperty != CssProperty.BACKGROUND_IMAGE) {
                                                    break;
                                                } else {
                                                    this.c = lpVar.b;
                                                    break;
                                                }
                                                break;
                                            case -9:
                                                o(cssProperty, lpVar.c, o.get(lpVar.b), i3);
                                                break;
                                            case -8:
                                                o(cssProperty, lpVar.c, CssUnit.PERCENT, i3);
                                                break;
                                            case -7:
                                                o(cssProperty, lpVar.c, CssUnit.NUMBER, i3);
                                                break;
                                            case -6:
                                                p(cssProperty, '#' + lpVar.b, i3);
                                                break;
                                        }
                                    }
                                } else {
                                    CssEnum cssEnum = n.get(lpVar.b);
                                    if (cssEnum != null) {
                                        o(cssProperty, (float) cssEnum.ordinal(), CssUnit.ENUM, i3);
                                    } else if (cssProperty == CssProperty.FONT || cssProperty == CssProperty.FONT_FAMILY) {
                                        StringBuilder sb = new StringBuilder();
                                        String str3 = this.d;
                                        if (str3 != null) {
                                            str2 = str3;
                                        }
                                        sb.append(str2);
                                        sb.append(lpVar.b);
                                        this.d = sb.toString();
                                    } else {
                                        lpVar.b("Unrecognized value '" + cssEnum + "' for property " + str);
                                    }
                                }
                                i3++;
                                lpVar.c(false);
                            }
                            if (cssProperty == CssProperty.FONT || cssProperty == CssProperty.FONT_FAMILY) {
                                StringBuilder sb2 = new StringBuilder();
                                String str4 = this.d;
                                if (str4 != null) {
                                    str2 = str4;
                                }
                                sb2.append(str2);
                                sb2.append(lpVar.b);
                                this.d = sb2.toString();
                                i3++;
                                lpVar.c(false);
                            } else {
                                i3++;
                                lpVar.c(false);
                            }
                        }
                    }
                }
                if (lpVar.a == 33) {
                    lpVar.c(false);
                    if (lpVar.a == -2 && "important".equals(lpVar.b)) {
                        this.e = 1000000;
                        lpVar.c(false);
                    }
                }
                while (true) {
                    int i5 = lpVar.a;
                    if (i5 != -1 && i5 != 59 && i5 != 125) {
                        lpVar.b("skipping");
                        lpVar.c(false);
                    }
                }
                while (lpVar.a == 59) {
                    lpVar.c(false);
                }
            } else {
                return;
            }
        }
    }

    public jp n(CssProperty cssProperty, float f2, CssUnit cssUnit) {
        int ordinal = cssProperty.ordinal();
        int i2 = CssProperty.REGULAR_PROPERTY_COUNT;
        if (ordinal >= i2) {
            return o(cssProperty, f2, cssUnit, 0);
        }
        float[] fArr = this.a;
        if (fArr == null || ordinal >= fArr.length) {
            int i3 = CssProperty.TEXT_PROPERTY_COUNT;
            if (ordinal < i3) {
                i2 = i3;
            }
            float[] fArr2 = new float[i2];
            byte[] bArr = new byte[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                byte[] bArr2 = this.b;
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            }
            this.a = fArr2;
            this.b = bArr;
        }
        this.a[ordinal] = f2;
        this.b[ordinal] = (byte) cssUnit.ordinal();
        return this;
    }

    public jp o(CssProperty cssProperty, float f2, CssUnit cssUnit, int i2) {
        int i3;
        if (cssProperty == null) {
            return this;
        }
        int i4 = 0;
        switch (a.b[cssProperty.ordinal()]) {
            case 39:
                if (cssUnit == CssUnit.ARGB) {
                    o(CssProperty.BORDER_COLOR, f2, cssUnit, 0);
                } else if (i2 == 0) {
                    o(CssProperty.BORDER_WIDTH, f2, cssUnit, 0);
                } else if (i2 == 1) {
                    o(CssProperty.BORDER_STYLE, f2, cssUnit, 0);
                } else if (i2 == 3) {
                    o(CssProperty.BORDER_COLOR, f2, cssUnit, 0);
                }
                i3 = -1;
                break;
            case 40:
                CssUnit cssUnit2 = CssUnit.ENUM;
                if (cssUnit == cssUnit2) {
                    CssEnum cssEnum = CssEnum.INHERIT;
                    if (f2 == ((float) cssEnum.ordinal()) && i2 == 0) {
                        q(CssProperty.BACKGROUND_COLOR, cssEnum);
                        q(CssProperty.BACKGROUND_REPEAT, cssEnum);
                        q(CssProperty.BACKGROUND_POSITION_X, cssEnum);
                        q(CssProperty.BACKGROUND_POSITION_Y, cssEnum);
                        i3 = -1;
                        break;
                    }
                }
                if (cssUnit == CssUnit.ARGB) {
                    n(CssProperty.BACKGROUND_COLOR, f2, cssUnit);
                } else if (cssUnit == cssUnit2 && (f2 == ((float) CssEnum.NO_REPEAT.ordinal()) || f2 == ((float) CssEnum.REPEAT.ordinal()) || f2 == ((float) CssEnum.REPEAT_X.ordinal()) || f2 == ((float) CssEnum.REPEAT_Y.ordinal()))) {
                    n(CssProperty.BACKGROUND_REPEAT, f2, cssUnit2);
                } else if (!(cssUnit == cssUnit2 && (f2 == ((float) CssEnum.SCROLL.ordinal()) || f2 == ((float) CssEnum.FIXED.ordinal())))) {
                    CssProperty cssProperty2 = CssProperty.BACKGROUND_POSITION_X;
                    if (!k(cssProperty2)) {
                        n(cssProperty2, f2, cssUnit);
                    }
                    n(CssProperty.BACKGROUND_POSITION_Y, f2, cssUnit);
                }
                i3 = -1;
                break;
            case 41:
                if (i2 == 0) {
                    n(CssProperty.BACKGROUND_POSITION_X, f2, cssUnit);
                }
                if (i2 == 0 || i2 == 1) {
                    n(CssProperty.BACKGROUND_POSITION_Y, f2, cssUnit);
                }
                i3 = -1;
                break;
            case 42:
                if (i2 == 0 && cssUnit == CssUnit.ENUM) {
                    CssEnum cssEnum2 = CssEnum.INHERIT;
                    if (f2 == ((float) cssEnum2.ordinal())) {
                        q(CssProperty.LIST_STYLE_POSITION, cssEnum2);
                        q(CssProperty.LIST_STYLE_TYPE, cssEnum2);
                        i3 = -1;
                        break;
                    }
                }
                if (cssUnit == CssUnit.ENUM && (f2 == ((float) CssEnum.INSIDE.ordinal()) || f2 == ((float) CssEnum.OUTSIDE.ordinal()))) {
                    n(CssProperty.LIST_STYLE_POSITION, f2, cssUnit);
                } else {
                    n(CssProperty.LIST_STYLE_TYPE, f2, cssUnit);
                }
                i3 = -1;
                break;
            case 43:
                if (cssUnit == CssUnit.NUMBER) {
                    n(CssProperty.FONT_WEIGHT, f2, cssUnit);
                }
                i3 = -1;
                break;
            case 44:
                i3 = CssProperty.BORDER_TOP_COLOR.ordinal();
                break;
            case 45:
                i3 = CssProperty.BORDER_TOP_STYLE.ordinal();
                break;
            case 46:
                i3 = CssProperty.BORDER_TOP_WIDTH.ordinal();
                break;
            case 47:
                i3 = CssProperty.PADDING_TOP.ordinal();
                break;
            case 48:
                i3 = CssProperty.MARGIN_TOP.ordinal();
                break;
            default:
                if (cssProperty.ordinal() < CssProperty.REGULAR_PROPERTY_COUNT) {
                    n(cssProperty, f2, cssUnit);
                }
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            while (i4 < 4) {
                n(k[i3 + i4], f2, cssUnit);
                i4 += i2 == 0 ? 1 : 2;
            }
        }
        return this;
    }

    public void p(CssProperty cssProperty, String str, int i2) {
        if (str.length() <= 0 || str.charAt(0) != '#') {
            CssEnum cssEnum = n.get(ip.b(str));
            if (cssEnum != null) {
                o(cssProperty, (float) cssEnum.ordinal(), CssUnit.ENUM, i2);
                return;
            }
            return;
        }
        try {
            int parseInt = Integer.parseInt(str.substring(1), 16);
            if (str.length() == 4) {
                parseInt = ((parseInt & 3840) << 12) | (parseInt & 15) | ((parseInt & 255) << 4) | ((parseInt & 4080) << 8);
            }
            o(cssProperty, (float) (-16777216 | parseInt), CssUnit.ARGB, i2);
        } catch (NumberFormatException unused) {
        }
    }

    public jp q(CssProperty cssProperty, CssEnum cssEnum) {
        return n(cssProperty, (float) cssEnum.ordinal(), CssUnit.ENUM);
    }

    public void r(jp jpVar) {
        if (jpVar != null) {
            if (jpVar.a != null) {
                for (int i2 = 0; i2 < jpVar.a.length; i2++) {
                    CssProperty cssProperty = k[i2];
                    if (jpVar.k(cssProperty)) {
                        CssUnit i3 = jpVar.i(cssProperty);
                        n(cssProperty, jpVar.c(cssProperty, i3), i3);
                    }
                }
            }
            String str = jpVar.c;
            if (str != null) {
                this.c = str;
            }
            String str2 = jpVar.d;
            if (str2 != null) {
                this.d = str2;
            }
        }
    }

    public void s(String str, StringBuilder sb) {
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.length; i2++) {
                CssProperty cssProperty = k[i2];
                if (k(cssProperty)) {
                    if (str != null) {
                        sb.append(str);
                    }
                    sb.append(ip.a(cssProperty.name()));
                    sb.append(": ");
                    sb.append(h(cssProperty));
                    sb.append(str == null ? "; " : ";\n");
                }
            }
        }
        if (str != null) {
            sb.append("/* specifity: " + this.e + " */\n");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        s(null, sb);
        return sb.toString();
    }
}

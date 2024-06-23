package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tb.jl1;

/* compiled from: Taobao */
public class ExpressionDict {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MAX_LINE = 3;
    public static final int MAX_ROW = 8;
    private static volatile ExpressionDict dict;
    private static final Object mMutex = new Object();
    private Map<String, BeanExpression> realMap = new HashMap();
    private String reg1 = "";
    private String reg1LowLv = "";
    private String reg2 = "";
    private String reg2LowLv = "";
    private Map<String, BeanExpression> resMap = new HashMap();

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c8 A[SYNTHETIC, Splitter:B:41:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0 A[Catch:{ IOException -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    private ExpressionDict() {
        Throwable th;
        InputStream inputStream;
        Exception e;
        if (AppContextUtils.getApp() != null) {
            InputStream inputStream2 = null;
            try {
                InputStream open = AppContextUtils.getApp().getAssets().open(isNewExpression() ? "dago_emotionmap.xml" : "emotionmap.xml");
                try {
                    parseXML(open, false);
                    InputStream open2 = AppContextUtils.getApp().getAssets().open("emotionmapguizu.xml");
                    parseXML(open2, true);
                    if (this.reg1.length() > 0) {
                        String str = this.reg1;
                        this.reg1 = str.substring(0, str.length() - 1);
                        String str2 = this.reg1LowLv;
                        this.reg1LowLv = str2.substring(0, str2.length() - 1);
                    }
                    if (this.reg2.length() > 0) {
                        String str3 = this.reg2;
                        this.reg2 = str3.substring(0, str3.length() - 1);
                        String str4 = this.reg2LowLv;
                        this.reg2LowLv = str4.substring(0, str4.length() - 1);
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (open2 != null) {
                        open2.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                    inputStream2 = open;
                    try {
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (inputStream == null) {
                            inputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    inputStream2 = open;
                    if (inputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
                e.printStackTrace();
                if (inputStream2 != null) {
                }
                if (inputStream == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                if (inputStream2 != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        }
    }

    public static ExpressionDict getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263278853")) {
            return (ExpressionDict) ipChange.ipc$dispatch("-1263278853", new Object[0]);
        }
        if (dict == null) {
            synchronized (mMutex) {
                if (dict == null) {
                    dict = new ExpressionDict();
                }
            }
        }
        return dict;
    }

    public static int getMaxIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892037898")) {
            return ((Integer) ipChange.ipc$dispatch("892037898", new Object[0])).intValue();
        }
        return isNewExpression() ? 50 : 24;
    }

    public static String getPrefix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204806684")) {
            return (String) ipChange.ipc$dispatch("204806684", new Object[0]);
        }
        return isNewExpression() ? "n" : "f";
    }

    public static boolean isNewExpression() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404823106")) {
            return ((Boolean) ipChange.ipc$dispatch("1404823106", new Object[0])).booleanValue();
        }
        return true;
    }

    private void parseXML(InputStream inputStream, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049000635")) {
            ipChange.ipc$dispatch("1049000635", new Object[]{this, inputStream, Boolean.valueOf(z)});
            return;
        }
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("dict");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                BeanExpression beanExpression = new BeanExpression();
                NodeList childNodes = ((Element) elementsByTagName.item(i)).getChildNodes();
                for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                    Node item = childNodes.item(i2);
                    if (item.getNodeType() == 1) {
                        Element element = (Element) item;
                        if (element.getNodeName().equals("key")) {
                            String nodeValue = element.getFirstChild().getNodeValue();
                            beanExpression.setResName(nodeValue);
                            this.reg1 += nodeValue + "|";
                            if (!z) {
                                this.reg1LowLv += nodeValue + "|";
                            }
                        } else if (element.getNodeName().equals("string")) {
                            String nodeValue2 = element.getFirstChild().getNodeValue();
                            beanExpression.setRealName(nodeValue2);
                            if (nodeValue2.length() > 0) {
                                String str = "\\[" + nodeValue2.substring(1, nodeValue2.length() - 1) + "\\" + jl1.ARRAY_END_STR;
                                this.reg2 += str + "|";
                                if (!z) {
                                    this.reg2LowLv += str + "|";
                                }
                            }
                        }
                        this.resMap.put(beanExpression.getResName(), beanExpression);
                        this.realMap.put(beanExpression.getRealName(), beanExpression);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConvertStringWithRealName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1272928043")) {
            return ExpressionManager.getInstance().getExpressionString(str, this.reg2, 1);
        }
        return (String) ipChange.ipc$dispatch("-1272928043", new Object[]{this, str});
    }

    public String getConvertStringWithRealNameLowLv(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1513164299")) {
            return ExpressionManager.getInstance().getExpressionString(str, this.reg2LowLv, 1);
        }
        return (String) ipChange.ipc$dispatch("1513164299", new Object[]{this, str});
    }

    public String getConvertStringWithResName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-413612959")) {
            return ExpressionManager.getInstance().getExpressionString(str, this.reg1, 0);
        }
        return (String) ipChange.ipc$dispatch("-413612959", new Object[]{this, str});
    }

    public BeanExpression getExpressionByRealName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1350345178")) {
            return this.realMap.get(str);
        }
        return (BeanExpression) ipChange.ipc$dispatch("1350345178", new Object[]{this, str});
    }

    public BeanExpression getExpressionByResName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-30551104")) {
            return this.resMap.get(str);
        }
        return (BeanExpression) ipChange.ipc$dispatch("-30551104", new Object[]{this, str});
    }
}

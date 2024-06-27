https://monkeywie.cn/2023/08/16/android-hack/

参考此地址



# 监听方法执行
 frida-trace -U -j "*InnerSignImpl*!getUnifiedSign" 大麦


 # 主动执行方法

 frida -U -l .\x-header.js 大麦

修改js里面的参数构造和参数设置逻辑在执行即可


# 使用安卓版本8.8.9 
旧版本无法启动
新版本方法逻辑发生变化
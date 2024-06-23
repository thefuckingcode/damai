// __handlers__\mtopsdk.security.InnerSignImpl\getUnifiedSign.js

{
  onEnter(log, args, state) {
  // 增加了HashMap2Str函数，将HashMap类型转换为字符串
     function HashMap2Str(params_hm) {
       var HashMap=Java.use('java.util.HashMap');
       var args_map=Java.cast(params_hm,HashMap);
       return args_map.toString();
   };

 // 存储参数在 this 上下文中
 this.args=args

      // 当调用函数时，输出函数参数
    //  log(`InnerSignImpl.getUnifiedSign(111${HashMap2Str(args[0])}111,222${HashMap2Str(args[1])}222,${args[2]},${args[3]})`);
   }, onLeave(log, retval, state) {

     if (retval !== undefined) {
      // 当函数运行结束时，输出函数结果

      log(`0000000000000${this.args[0]}`)
      log(`1111111111111${this.args[1]}`)
      log(`2222222222222${this.args[2]}`)
      log(`3333333333333${this.args[3]}`)
      log(`4444444444444${this.args[4]}`)
       log(`<= ${retval}`);
     } }}
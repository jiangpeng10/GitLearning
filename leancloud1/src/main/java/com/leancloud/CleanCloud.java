package com.leancloud;

import com.avos.avoscloud.AVObject;

public class CleanCloud {
    final static String APPID="ajhR3L8LQu2P3iDdWFxRadYp-gzGzoHsz";
    final static String APPKEY="Q26ONvnNmYQwI6OIGdP3BXsf";
    final static String MASTERKEY="noydULB6Ty8v9bxu4M8MX4MN";


    public static void main(String[] args){
        // 参数依次为 AppId、AppKey、MasterKey
//          AVOSCloud.initialize("{{ajhR3L8LQu2P3iDdWFxRadYp-gzGzoHsz}}","{{Q26ONvnNmYQwI6OIGdP3BXsf}}","{{noydULB6Ty8v9bxu4M8MX4MN}}");
//        AVOSCloud.setDebugLogEnabled(true);
    	AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
//        AVObject.registerSubclass(CleanCloud.class);
        try {
            testObject.save();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

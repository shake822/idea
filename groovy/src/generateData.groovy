/**
 * Created by zhaoqunqi on 15-4-8.
 */

//other,account,passwd,sessionId,uname,birthday,sex,education,postName,orgName,resolution,os,browser,
String getSex() {
    List<String> all = ["男", "女"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String encodeStr(String str) {
    java.net.URLEncoder.encode(str, "utf-8")
}

String getBirthday() {
    List<String> all = ["2011-04-04 12:00:00", "1984-02-12 12:00:00", "1950-12-22 02:00:33", "1987-02-04 14:00:01", "1956-09-09 14:02:33"]
    encodeStr(all[new Random().nextInt(all.size())])
}

String getEducation() {
    List<String> all = ["本科", "大专", "研究生"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String getPostName() {
    List<String> all = ["开发工程师", "测试工程师", "前端"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String getOrgName() {
    List<String> all = ["资产部门", "技术研究中心", "生产部门", "南方电网"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String getResolution() {
    List<String> all = ["1600*900", "800*600", "1024*768"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String getOs() {
    List<String> all = ["Linux", "Mac", "Win7", "Win8"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String getBrowser() {
    List<String> all = ["chrome", "IE9", "IE8", "IE7"]
    encodeStr(all.get(new Random().nextInt(all.size())))
}

String getResponseTime(){
    long response = new Random().nextInt(1000).toLong()
    long stay = response+new Random().nextInt(1000).toLong()
    response+","+stay
}

File file = new File("/home/zhaoqunqi/tmp/spro_users_all.csv")
File outFile = new File("/home/zhaoqunqi/tmp/spro_users_all.out")
if (outFile.exists()) {
    outFile.delete()
}
file.eachLine {
    outFile << "1," + it + ",session_" +UUID.randomUUID().toString()+"," + it.split(",")[0] + "," + getBirthday() + "," + getSex() + "," + getEducation() + "," + getPostName() + "," + getOrgName() + "," + getResolution() + "," + getOs() + "," + getBrowser() + ",0,"+getResponseTime()+"\n"
}


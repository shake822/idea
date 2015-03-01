/**
 * Created by zhaoqunqi on 2014/12/23.
 */


CodeCheck cfc  = new CodeCheck()
File file = new File("E:\\mobileCode\\mi\\trunk\\android\\casloginclient-hybirdapp-demo\\src\\com\\google\\android\\webviewdemo\\WebViewDemo.java")
String codeF = cfc.guessFileEncoding(file)
println codeF
if(!codeF.contains("UTF-8") && codeF.contains("GB2312")){
    println "有问题"
    def fileName = file.getAbsolutePath()
    def bakFileName = fileName+".bak"
    file.renameTo(bakFileName)
    File sourceFile = new File(bakFileName)
    file.delete()
    file.createNewFile()
    sourceFile.eachLine("GBK") {
        file << it +"\n"
    }
    sourceFile.delete()
}else{
    println "end"
}
File.class.getClassLoader().getResource()
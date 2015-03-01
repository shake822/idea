/**
 * Created by zhaoqunqi on 2014/12/22.
 */
/**
 * Created by zhaoqunqi on 2014/12/22.
 */

import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;

class CodeCheck{

    def projectName = new HashSet<String>(36)

    void read(File f) {
        f.eachFile{
            File it ->
            if(it.isDirectory() && !(it.name in [".svn","Civilize_v2.5.0",".git","branches",".apt_generated","gen","target"]) ){
                 read(it)
            }else if(it.isFile() && (it.name.endsWith(".java") || it.name.endsWith(".html") || it.name.endsWith(".js")|| it.name.endsWith(".css") || it.name.endsWith(".jsp")) ){
                if(it.getAbsolutePath().indexOf("TOP_V5.0.0") != -1 || it.getAbsolutePath().indexOf("TOP_V4.1.1") != -1 ){
                    if(it.getAbsolutePath().indexOf("mobile\\") == -1 && !it.getAbsolutePath().contains("mobileauth")){
                        return
                    }
                }
                String codeF = this.guessFileEncoding(it)
                if(!codeF.contains("UTF-8") && codeF.contains("GB2312")){
                    projectName << getProjectName(it.getAbsolutePath())
//                                println it.getAbsolutePath() + " code  is " + codeF
                  changeFileEncode( it.getAbsolutePath())
                    return
                }
            }
        }
    }

    def changeFileEncode(String filePath){
        File file = new File(filePath)
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
        println filePath+"  change to UTF-8"
    }
    void readErrorProject(){
        projectName.each {
            println it
        }
    }

    String getProjectName(String path){
        String projectName=""
        if(path.contains("\\src\\")){
            projectName = path.substring(0,path.indexOf("\\src\\"))
        }else if(path.contains("\\server\\")){
            int index = path.indexOf("\\server\\")+"\\server\\".length()
            projectName = path.substring(0,path.indexOf("\\",index+1))
        }
        projectName
    }

    /**
     * 传入一个文件(File)对象，检查文件编码
     *
     * @param file
     *            File对象实例
     * @return 文件编码，若无，则返回null
     * @throws FileNotFoundException
     * @throws IOException
     */
    String guessFileEncoding(File file) throws FileNotFoundException, IOException {
        return guessFileEncoding(file, new nsDetector());
    }

    /**
     * <pre>
     * 获取文件的编码
     * @param file
     *            File对象实例
     * @param languageHint
     *            语言提示区域代码 @see #nsPSMDetector ,取值如下：
     *             1 : Japanese
     *             2 : Chinese
     *             3 : Simplified Chinese
     *             4 : Traditional Chinese
     *             5 : Korean
     *             6 : Dont know(default)
     * </pre>
     *
     * @return 文件编码，eg：UTF-8,GBK,GB2312形式(不确定的时候，返回可能的字符编码序列)；若无，则返回null
     * @throws FileNotFoundException
     * @throws IOException
     */
    String guessFileEncoding(File file, int languageHint) throws FileNotFoundException, IOException {
        return guessFileEncoding(file, new nsDetector(languageHint));
    }

    /**
     * 获取文件的编码
     *
     * @param file
     * @param det
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    String guessFileEncoding(File file, nsDetector det) throws FileNotFoundException, IOException {
        boolean found = false;
        String encoding = null;
        // Set an observer...
        // The Notify() will be called when a matching charset is found.
        det.Init(new nsICharsetDetectionObserver() {
            void Notify(String charset) {
                encoding = charset;
                found = true;
            }
        });

        BufferedInputStream imp = new BufferedInputStream(new FileInputStream(file));
        byte[] buf = new byte[1024];
        int len;
        boolean done = false;
        boolean isAscii = false;

        while ((len = imp.read(buf, 0, buf.length)) != -1) {
            // Check if the stream is only ascii.
            isAscii = det.isAscii(buf, len);
            if (isAscii) {
                break;
            }
            // DoIt if non-ascii and not done yet.
            done = det.DoIt(buf, len, false);
            if (done) {
                break;
            }
        }
        imp.close();
        det.DataEnd();

//        if (isAscii) {
//            encoding = "ASCII";
//            found = true;
//        }

        if (!found) {
            String[] prob = det.getProbableCharsets();
            //这里将可能的字符集组合起来返回
            for (int i = 0; i < prob.length; i++) {
                if (i == 0) {
                    encoding = prob[i];
                } else {
                    encoding += "," + prob[i];
                }
            }

            if (prob.length > 0) {
                // 在没有发现情况下,也可以只取第一个可能的编码,这里返回的是一个可能的序列
                return encoding;
            } else {
                return null;
            }
        }
        return encoding;
    }
}

CodeCheck cfc  = new CodeCheck()
File f = new File("E:\\mobileCode")
//\mi\trunk\server\cas-server\cas-server-core\src\main\java\org\jasig\cas\authentication\principal
cfc.read(f)
cfc.readErrorProject()
//File file = new File("E:\\mobileCode\\mi\\trunk\\server\\cas-server\\cas-server-core\\src\\main\\java\\org\\jasig\\cas\\authentication\\principal\\AbstractWebApplicationService.java")
//String codeF = cfc.guessFileEncoding(file)
//println codeF
//if(!codeF.contains("UTF-8") && codeF.contains("GB2312")){
//    println "有问题"
//}else{
//    println "end"
//}
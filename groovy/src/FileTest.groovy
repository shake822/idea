import groovy.io.FileType
import groovy.io.FileVisitResult

/**
 * Created by zhaoqunqi on 15/6/11.
 */
File dir = new File("/Users/zhaoqunqi/Desktop")
//dir.eachFile {
//    println it.name
//}
println "-------"
//dir.eachFileRecurse(FileType.FILES) {
//    println it.name+it.isDirectory()
//}

dir.traverse { file ->
    if (!file.directory) {
        FileVisitResult.TERMINATE
        println file.name
    } else {
        println file.name
        FileVisitResult.CONTINUE
    }

}
if(null){
    println '''
    111
    23
'''
}

def process = "ls -a".execute()
println "${process.text}"
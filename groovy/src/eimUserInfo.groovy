/**
 * Created by zhaoqunqi on 2014/12/23.
 */
/*
File file = new File("c:\\Market.SQL")
file.eachLine {
    String[] arr = it.split("@")
    println "insert into TEMP_EIM_USER_INFO (NAME,ACCOUNT, DEPARTMENT_NAME, PHONE) values ('${arr[0]}', '${arr[2]}', '${arr[3]}', '${arr[4]}');"
}*/
File file = new File("c:\\Market.SQL")
file.eachLine {
    println it + ";"
}
package course.javaweb.util;

public class StringUtil {
    public static Integer fileNum ;
    public static String renameFileName(String fileName) {
//        String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()); // 当前时间字符串
        String prefix = "image";
        String serialNum = String.format("%03d", fileNum);
        String extension = fileName.substring(fileName.lastIndexOf(".")); // 文件后缀

        return prefix + serialNum + extension;
    }
}

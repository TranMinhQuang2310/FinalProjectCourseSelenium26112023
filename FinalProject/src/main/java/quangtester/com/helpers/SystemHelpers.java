package quangtester.com.helpers;

import java.io.File;

public class SystemHelpers {

    // Hàm lấy đường dẫn tuyệt đối của Project
    public static String getCurrentDir() {
        //D:\HocTester-AnhTester-Course\SeleniumJava\Course_Selenium_Java_26022023 + "\"
        //File.separator => máy sẽ tự hiểu là 1 dấu "/" này hoặc "\" này
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

}

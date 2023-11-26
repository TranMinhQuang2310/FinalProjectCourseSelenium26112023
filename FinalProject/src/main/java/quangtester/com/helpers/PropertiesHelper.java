package quangtester.com.helpers;

import quangtester.com.utils.LogUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;
    private static String relPropertiesFilePathDefault = "src/test/resources/configs/configs.properties";

    //Hàm loadAllFiles() đọc nhiều file config
    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();
        // Add tất cả file Properties vào đây theo mẫu
        files.add("src/test/resources/configs/configs.properties");
        files.add("src/test/resources/configs/data.properties");

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelpers.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            LogUtils.info("Loaded all properties file. ");
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }

    //Hàm setFile() để khởi tạo giá trị cho đối tượng properties của class Properties với đường dẫn đến file configs.properties
    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hàm setDefaultFile() để khởi tạo giá trị cho đối tượng properties của class Properties với đường dẫn có sẵn trong class.
    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hàm getValue() để đọc file đã setup bên trên và lấy giá trị ra theo Key trong file đã tạo => Nếu không đọc được
// file sẽ đọc file được gán cứng ở hàm setDefaultFile
    public static String getValue(String key) {
        String keyval = null;
        try {
            //Đọc file được gán cứng ở hàm setDefaultFile trong trường hợp không đọc được file
            if (file == null) {
                properties = new Properties();
                linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Lấy giá trị từ file đã Set
            keyval = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return keyval;
    }

    //Hàm setValue() để gán ngược giá trị vói key tương ứng vào lại file properties trên.

    public static void setValue(String key, String keyValue) {
        try {
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                out = new FileOutputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
            }
            //Ghi vào cùng file Prop với file lấy ra
            out = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(out, null);
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

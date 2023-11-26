package quangtester.com.reports.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    /*
        Cách coi Report :
            B1 : sau khi đã tạo ra file html thành công
            B2 : Mở file trên trình duyệt
            B3 : Nhấn icon biểu đồ chart ở left menu
            B4 : Scroll xuống dưới cùng
    */
    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extentreport/extentreport.html");
        reporter.config().setReportName("Extent Report | Anh Tester");
        extentReports.attachReporter(reporter);
        //k là key
        //v là value
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Anh Tester");
        extentReports.setSystemInfo("Author", "Anh Tester");
        return extentReports;
    }
}

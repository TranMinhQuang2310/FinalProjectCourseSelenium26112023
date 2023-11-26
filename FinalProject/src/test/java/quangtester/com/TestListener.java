package quangtester.com;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import quangtester.com.helpers.CaptureHelper;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.utils.LogUtils;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext arg0) {
        //Gọi hàm loadAllFiles
        PropertiesHelper.loadAllFiles();

    }

    @Override
    public void onFinish(ITestContext arg0) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Running Test Case :" + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Đây là test case  " + result.getName() + " chạy thành công");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Đây là test case " + result.getName() + " thất bại");
        //Screenshot ngay lập tức khi chạy fail
        CaptureHelper.captureScreenshot(result.getName());
        //Ghi ra chi tiết lỗi
        LogUtils.error("Chi tiết lỗi :" + (result.getThrowable().toString()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là test case " + result.getName() + " bị bỏ qua");
        //Ghi ra chi tiết lỗi
        System.out.println("Chi tiết lỗi :" + (result.getThrowable().toString()));

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Đây là test case  " + result.getName() + " bị FAIL nhưng có phần SUCCESS ");
        //Ghi ra chi tiết lỗi
        System.out.println("Chi tiết lỗi :" + (result.getThrowable().toString()));

    }

}

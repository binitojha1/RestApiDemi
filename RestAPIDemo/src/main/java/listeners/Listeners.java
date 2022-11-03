package listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.LogStatus;

import extentsReports.ExtentManager;

public class Listeners extends TestListenerAdapter {


    public static ExtentManager extentManager;
    public void startExtent(){

        extentManager = new ExtentManager();
    }

        public void onTestStart(ITestResult itr){
            extentManager.test = extentManager.extent.startTest(new Throwable().getStackTrace()[0].getMethodName());
            System.out.println(itr.getTestName());
            System.out.println(itr.getMethod());
           // System.out.println(itr.getParameters());
            System.out.println(itr.getName());
            System.out.println("Test Started...");
        }


        public void onTestSuccess(ITestResult itr){
            extentManager.test.log(LogStatus.PASS, "Test Passed !!");
            System.out.println("Test Succed...");
        }


        public void onTestFailure(ITestResult itr){
            extentManager.test.log(LogStatus.FAIL,itr.getThrowable().getMessage() );
            System.out.println("Test Failed...");

            // ger.test.log(LogStatus.FAIL,"All assertions are passed");
        }


        public void onTestSkipped(ITestResult itr){
            System.out.println("Test Skipped...");
        }

        public void endExtent(){
            extentManager.extent.flush();
        }


    }

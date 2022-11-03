package extentsReports;




import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    public ExtentReports extent;
    public ExtentTest test;
    public String CurrentDate;

    public ExtentManager() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss");
        CurrentDate = sdf.format(date);
        extent = new ExtentReports(System.getProperty("user.dir") + "//target//extentreports//" + CurrentDate+".html",true);
        extent.addSystemInfo("Host Name","Testvagrant");
        extent.addSystemInfo("Environment","Test");
        extent.addSystemInfo("User Name","Binit Ojha");
        extent.loadConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));

    }

}

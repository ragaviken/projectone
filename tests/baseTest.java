package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import page.*;

import java.io.File;
import java.io.IOException;

    public class baseTest {

        static WebDriver driver;
        public HomePage homePage;
        public LoginPage loginPage;
        public SignUpPage signUpPage;
        public ShoppingCartPage shoppingCartPage;
        public DepartmentPage departmentPage;
        public BrandPage brandPage;
        public CheckoutPage checkoutPage;
//        @Parameters("browser")

        @BeforeClass
        public void setUp(){
//            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
//            } else if (browser.equalsIgnoreCase("firefox")) {
//                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments("--disable-notifications");
//                driver = new FirefoxDriver(options);
//            }
            driver.manage().window().maximize();
            driver.get("https://www.bestbuy.com/");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/a[2]/img")).click();
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            SignUpPage signUpPage = new SignUpPage(driver);
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);
            BrandPage brandPage = new BrandPage(driver);
            CheckoutPage checkoutPage = new CheckoutPage(driver);
        }

        @AfterClass
        public void tearDown(){
            driver.quit();
        }

        public static String takeScreenshots(String testCaseName)  {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            File destination = new File("Screenshots/"+ testCaseName +".png");
            try {
                FileUtils.copyFile(srcFile,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String path = "<img src= " + destination.getAbsolutePath() + "width 200px height = 200px />";
            Reporter.log(path);
            return destination.getAbsolutePath();
        }
    }

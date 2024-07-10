package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

    public class CheckoutPageTest extends baseTest {

        @Test(priority = 4)
        public void testCheckoutPage() {

            //Giving Address to place the order
            checkoutPage.setCheckout();
            checkoutPage.setContinueAsGuest();
            checkoutPage.setSwitchToPickup();
            checkoutPage.setFirstName("Ragavi");
            checkoutPage.setLastName("Ananthan");
            checkoutPage.setAddress("Thamarai nagar ");
            checkoutPage.setCity("Thiruvannamalai");
            //Dropdown
            WebElement dd = driver.findElement(By.xpath("//select[@id='state']"));
            Select select = new Select(dd);
            select.selectByIndex(1);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            checkoutPage.setZipCode("600048");
            checkoutPage.setSaveAddress();
            checkoutPage.setKeepAddressEntered();
            //Scrolling down to the Email block
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);");
            checkoutPage.setEmailAddress("raghavi123@gmail.com");
            checkoutPage.setMobileNumber("8024500000");
            checkoutPage.setCheckBox();
            checkoutPage.setPaymentInformation();
            checkoutPage.setCardNumber("6969545132341564");
            checkoutPage.setExpiryDate("07/27");
            checkoutPage.setCvvNumber("709");
            checkoutPage.setApply();
            //Scrolling down to the Place order button
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);");
            checkoutPage.setPlaceOrder();
            //Assertion
            String str = driver.getTitle();
            System.out.println("The title of the page is: " + str);
            Assert.assertEquals(str, "Checkout - Best Buy");
        }
    }

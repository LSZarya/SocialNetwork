package Autotesting_selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MarkBeforeClickListener implements WebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
                element);
        // Пауза, что бы мы успели рассмотреть
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px solid red'",
                    element);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.border='3px solid red'",
                webElement);
        // Пауза, что бы мы успели рассмотреть
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.border='0px solid red'",
                webElement);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.border='3px solid blue'",
                webElement);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.border='0px solid blue'",
                webElement);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
                element);
        // Пауза, что бы мы успели рассмотреть
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String s) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px solid red'",
                element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue'",
                element);
        // Пауза, что бы мы успели рассмотреть
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px solid blue'",
                element);
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

}


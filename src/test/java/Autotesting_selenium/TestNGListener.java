package Autotesting_selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestNGListener implements ITestListener {

    @Override //переиспользуем метод, что бы при падении теста происходил скриншот драйвера
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext(); //Что то мы подключаем
        WebDriver driver = (WebDriver)context.getAttribute("driver"); //Подключаем драйвер
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //Делаем скриншот драйвера
            FileUtils.copyFile(file, new File( System.getProperty("user.dir") + File.separator + "screenshot\\" + //Сохраняем скриншот драйвера
                    result.getName() + "_" + result.getEndMillis() + ".png")); //Называем скриншот драйвера
            System.out.println("*******Screenshot captured********"); //Надпись предупреждение
        } catch (Exception e) {
            e.printStackTrace(); //Какая то защита от исключениея
        }
    }
}
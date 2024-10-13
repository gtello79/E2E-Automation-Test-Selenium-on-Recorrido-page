package webdriver;

import org.apache.commons.io.FileUtils;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DOM {

    private static String chromeWebDriver = "webdriver/chromedriver/chromedriver";
    //private static String chromeTestWebDriver = "webdriver/chrometest/chrome";
    private static String screenShootFolder = "./demoSelenium/src/Test_Evidence/";

    public static WebDriver webDriver;

    public DOM(){
        PageFactory.initElements(getWebDriver(), this);
    }

    public static WebDriver getWebDriver() {

        if (webDriver != null) {
            return webDriver;
        }

        System.setProperty("webdriver.chrome.driver", chromeWebDriver);

        // Define las opciones de Chrome Testing
        ChromeOptions options = new ChromeOptions();
        //options.setBinary(chromeTestWebDriver);
        // options.addArguments("--headless"); // Ejecutar Chromium sin interfaz gráfica
        options.addArguments("--profile-directory=Guest");
        options.addArguments("--disable-gpu"); // Deshabilitar la aceleración por hardware

        webDriver = new ChromeDriver(options);

        return webDriver;
    }

    public static void iniciarNavegador(String url){
        WebDriver webdriver = getWebDriver();
        webdriver.get(url);
    }

    public static void makeSleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenShoot(String FileName) {

        // Genera una cadena de texto en funcion a la fecha y hora actual
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        String fileName = timeStamp + "-" + FileName + ".png";

        String path = screenShootFolder + fileName;
        try {
            File scrFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(path));
            // Utiliza logs para mostrar la ruta de la captura
            Logger.getGlobal().info("Screenshot taken and saved in: " + path);

            System.out.println("Screenshot taken");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void onclick(WebElement element) {
        element.click();
    }

    public static void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}

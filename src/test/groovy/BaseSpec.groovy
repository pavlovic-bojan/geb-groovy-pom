import geb.spock.GebSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import io.github.bonigarcia.wdm.WebDriverManager

abstract class BaseSpec extends GebSpec {

    WebDriver driver

    static int timeout = 10
    static double retryInterval = 0.5

    def setup() {
        driver = initializeDriver()
        browser.driver = driver
        timeout = BaseSpec.timeout
        retryInterval = BaseSpec.retryInterval
    }

    def cleanup() {
        driver?.quit()
    }

    private WebDriver initializeDriver() {
        def browserType = System.getProperty("browser", "chrome").toLowerCase()

        switch (browserType) {
            case "chrome":
                WebDriverManager.chromedriver().setup()
                ChromeOptions options = new ChromeOptions()
                options.addArguments("--start-maximized", "--disable-notifications")
                return new ChromeDriver(options)
            case "firefox":
                WebDriverManager.firefoxdriver().setup()
                return new FirefoxDriver()
            default:
                throw new IllegalArgumentException("Unsupported browser: $browserType")
        }
    }
}

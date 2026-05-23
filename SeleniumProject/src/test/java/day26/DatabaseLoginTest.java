package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.logs.Logger;

public class DatabaseLoginTest {

    public static void main(String[] args)
            throws Exception {


        String dbURL =
                "jdbc:mysql://localhost:3306/seleniumdb";

        String dbUser = "root";

        String dbPass = "Root@123";

        Connection con =
                DriverManager.getConnection(
                        dbURL,
                        dbUser,
                        dbPass);

        Statement st =
                con.createStatement();

        ResultSet rs =
                st.executeQuery(
                        "SELECT * FROM login_data");

        WebDriverManager.chromedriver().setup();

        while(rs.next()) {

            String username =
                    rs.getString("username");

            String password =
                    rs.getString("password");

            WebDriver driver =
                    new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts()
                    .implicitlyWait(
                            Duration.ofSeconds(10));

            driver.get(
                    "https://www.saucedemo.com/");

            driver.findElement(By.id("user-name"))
                    .sendKeys(username);

            driver.findElement(By.id("password"))
                    .sendKeys(password);

            driver.findElement(By.id("login-button"))
                    .click();

            System.out.println(
                    "Tested User: "
                    + username);

            Thread.sleep(2000);

            driver.quit();
        }

        rs.close();

        st.close();

        con.close();
    }
}
package day28;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DummyJsonUsersAPI {

    ExtentReports extent;
    ExtentTest test;

    String baseURL = "https://dummyjson.com/users";

    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("reports/DummyJsonAPIReport.html");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        System.out.println("Report Setup Done");
    }

    // ================= EXCEL DATA PROVIDER =================

    @DataProvider(name = "userData")
    public Object[][] getExcelData() throws Exception {

        FileInputStream file =
                new FileInputStream("testdata/users.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();

        Object data[][] = new Object[rows - 1][3];

        for (int i = 1; i < rows; i++) {

            Row row = sheet.getRow(i);

            data[i - 1][0] =
                    row.getCell(0).getStringCellValue();

            data[i - 1][1] =
                    row.getCell(1).getStringCellValue();

            data[i - 1][2] =
                    (int) row.getCell(2).getNumericCellValue();
        }

        workbook.close();

        file.close();

        return data;
    }

    // ================= GET ALL USERS =================

    @Test(priority = 1)
    public void getAllUsersTest() {

        test = extent.createTest("Get All Users API Test");

        given()

        .when()
            .get(baseURL)

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Get All Users API Test Passed Successfully");
    }

    // ================= GET SINGLE USER =================

    @Test(priority = 2)
    public void getSingleUserTest() {

        test = extent.createTest("Get Single User API Test");

        given()

            .pathParam("id", 1)

        .when()
            .get(baseURL + "/{id}")

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Get Single User API Test Passed Successfully");
    }

    // ================= SEARCH USER =================

    @Test(priority = 3)
    public void searchUserTest() {

        test = extent.createTest("Search User API Test");

        given()

            .queryParam("q", "John")

        .when()
            .get(baseURL + "/search")

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Search User API Test Passed Successfully");
    }

    // ================= FILTER USERS =================

    @Test(priority = 4)
    public void filterUsersTest() {

        test = extent.createTest("Filter Users API Test");

        given()

            .queryParam("limit", 5)
            .queryParam("skip", 10)

        .when()
            .get(baseURL)

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Filter Users API Test Passed Successfully");
    }

    // ================= SORT USERS =================

    @Test(priority = 5)
    public void sortUsersTest() {

        test = extent.createTest("Sort Users API Test");

        given()

            .queryParam("sortBy", "firstName")
            .queryParam("order", "asc")

        .when()
            .get(baseURL)

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Sort Users API Test Passed Successfully");
    }

    // ================= ADD USER USING EXCEL =================

    @Test(priority = 6, dataProvider = "userData")
    public void addUserTest(String firstName,
                            String lastName,
                            int age) {

        test = extent.createTest("Add User API Test");

        String requestBody =

                "{\n" +
                "\"firstName\":\"" + firstName + "\",\n" +
                "\"lastName\":\"" + lastName + "\",\n" +
                "\"age\":" + age + "\n" +
                "}";

        given()

            .header("Content-Type", "application/json")
            .body(requestBody)

        .when()
            .post(baseURL + "/add")

        .then()
            .statusCode(201)
            .log().all();

        test.pass("Add User API Test Passed Successfully");
    }

    // ================= UPDATE USER USING EXCEL =================

    @Test(priority = 7, dataProvider = "userData")
    public void updateUserTest(String firstName,
                               String lastName,
                               int age) {

        test = extent.createTest("Update User API Test");

        String requestBody =

                "{\n" +
                "\"firstName\":\"" + firstName + "\",\n" +
                "\"lastName\":\"" + lastName + "\",\n" +
                "\"age\":" + age + "\n" +
                "}";

        given()

            .header("Content-Type", "application/json")
            .body(requestBody)

        .when()
            .put(baseURL + "/1")

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Update User API Test Passed Successfully");
    }

    // ================= DELETE USER =================

    @Test(priority = 8)
    public void deleteUserTest() {

        test = extent.createTest("Delete User API Test");

        given()

        .when()
            .delete(baseURL + "/1")

        .then()
            .statusCode(200)
            .log().all();

        test.pass("Delete User API Test Passed Successfully");
    }

    // ================= FLUSH REPORT =================

    @AfterSuite
    public void flushReport() {

        extent.flush();

        System.out.println("Extent Report Generated");
    }
}
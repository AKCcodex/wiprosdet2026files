package day28;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DummyJsonUsersAPI1 
{

    ExtentReports extent;
    ExtentTest test;

    String baseURL = "https://dummyjson.com/users";

    @BeforeSuite
    public void setupReport() 
    {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("reports/DummyJsonAPIReport.html");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        System.out.println("Report Setup Done");
    }

    @Test(priority = 1)
    public void getAllUsersTest() 
    {

        test = extent.createTest("GET All Users API");

        test.info("GET All Users API Started");

        int statusCode =
        given()

        .when()
            .get(baseURL)

        .then()
            .log().all()
            .extract().statusCode();

        test.info("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        test.pass("GET All Users Passed");
    }

    @Test(priority = 2)
    public void getSingleUserTest() 
    {

        test = extent.createTest("GET Single User API");

        test.info("GET Single User API Started");

        String firstName =
        given()
            .pathParam("id", 1)

        .when()
            .get(baseURL + "/{id}")

        .then()
            .log().all()
            .statusCode(200)
            .extract().jsonPath().getString("firstName");

        test.info("First Name : " + firstName);

        Assert.assertEquals(firstName, "Emily");

        test.pass("GET Single User Passed");
    }

    @Test(priority = 3)
    public void searchUserTest() 
    {

        test = extent.createTest("Search User API");

        test.info("Search User API Started");

        int statusCode =
        given()
            .queryParam("q", "John")

        .when()
            .get(baseURL + "/search")

        .then()
            .log().all()
            .extract().statusCode();

        test.info("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        test.pass("Search User Passed");
    }

    @Test(priority = 4)
    public void filterUsersTest() 
    {

        test = extent.createTest("Filter Users API");

        test.info("Filter Users API Started");

        int statusCode =
        given()
            .queryParam("limit", 5)
            .queryParam("skip", 10)

        .when()
            .get(baseURL)

        .then()
            .log().all()
            .extract().statusCode();

        test.info("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        test.pass("Filter Users Passed");
    }

    @Test(priority = 5)
    public void sortUsersTest() 
    {

        test = extent.createTest("Sort Users API");

        test.info("Sort Users API Started");

        int statusCode =
        given()
            .queryParam("sortBy", "firstName")
            .queryParam("order", "asc")

        .when()
            .get(baseURL)

        .then()
            .log().all()
            .extract().statusCode();

        test.info("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        test.pass("Sort Users Passed");
    }

    @Test(priority = 6)
    public void addUserTest() 
    {

        test = extent.createTest("Add User API");

        test.info("Add User API Started");

        JSONObject data = new JSONObject();

        data.put("firstName", "Ashish");
        data.put("lastName", "Kumar");
        data.put("age", 25);

        int statusCode =
        given()
            .header("Content-Type", "application/json")
            .body(data.toString())

        .when()
            .post(baseURL + "/add")

        .then()
            .log().all()
            .extract().statusCode();

        test.info("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 201);

        test.pass("Add User Passed");
    }

    @Test(priority = 7)
    public void updateUserTest() 
    {

        test = extent.createTest("Update User API");

        test.info("Update User API Started");

        JSONObject data = new JSONObject();

        data.put("lastName", "Choudhary");

        int statusCode =
        given()
            .header("Content-Type", "application/json")
            .body(data.toString())

        .when()
            .put(baseURL + "/1")

        .then()
            .log().all()
            .extract().statusCode();

        test.info("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        test.pass("Update User Passed");
    }

    @Test(priority = 8)
    public void deleteUserTest() 
    {

        test = extent.createTest("Delete User API");

        test.info("Delete User API Started");

        Boolean isDeleted =
        given()

        .when()
            .delete(baseURL + "/1")

        .then()
            .log().all()
            .statusCode(200)
            .extract().jsonPath().getBoolean("isDeleted");

        test.info("Deleted Status : " + isDeleted);

        Assert.assertTrue(isDeleted);

        test.pass("Delete User Passed");
    }

    @AfterSuite
    public void flushReport() 
    {

        extent.flush();

        System.out.println("Extent Report Generated");
    }
}
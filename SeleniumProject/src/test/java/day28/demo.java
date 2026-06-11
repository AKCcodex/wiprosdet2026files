package day28;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
 
public class demo
{
	@Test
	public void getUsers()
	{
		given()
		
		.when().get("https://dummyjson.com/users/1")
		
		.then().statusCode(200)
		.log().all();
	}
	
}
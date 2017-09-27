import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredDemo {

	public String url = "https://api.trello.com/1";
	public String token = "addYourTokenHere";
	public String key="addYourKeyHere";

	@Test
	public void displayBoard() {
		Response response = given()
				.baseUri(url)
				.queryParam("key", key)
				.queryParam("token", token).when()
				.get("/members/me/boards");

		response.then().statusCode(200);
		response.prettyPrint();
	}

	@Test
	public void addBoard() {
		Response response = given()
				.baseUri(url)
				.contentType("Application/Json")
				.queryParam("key", key)
				.queryParam("token", token).when()
				.queryParam("name", "AddedByRestAssured")
				.post("/boards");

		response.then().statusCode(200);
		response.prettyPrint();

	}

}

package api;

import static io.restassured.RestAssured.*;

public class APITest {

    public void getBooks() {
        given()
        .when()
        .get("https://simple-books-api.glitch.me/books")
        .then()
        .statusCode(200);
    }
}
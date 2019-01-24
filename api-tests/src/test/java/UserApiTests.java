import com.exemple.model.UserAdressCreate;
import com.exemple.model.UserCardCreate;
import com.exemple.model.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UserApiTests {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://142.93.90.9/";
    }

    @Test()
    void testCanRegisterUser(){
        UserPayload userPayload = new UserPayload()
                .setUsername(RandomStringUtils.randomAlphanumeric(6))
                .setPassword("12345")
                .setEmail("user@gmail.com");


        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(userPayload)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }


    @Test()
    void testCanCreateNewCardUser(){
        UserCardCreate userCardCreate = new UserCardCreate()
                .setLongNum("8888888888888888")
                .setExpires("12122023")
                .setCcv("888")
                .setUserID("5c48c0cfee11cb0001fa6644");


        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(userCardCreate)
                .when()
                .post("cards")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));

    }

    @Test()
    void testCanCreateAdressUser(){
        UserAdressCreate userAdressCreate = new UserAdressCreate()
                .setStreet("Street")
                .setNumber("55")
                .setCountry("Country")
                .setCity("City")
                .setPostcode("000000")
                .setUserID("5c48c0cfee11cb0001fa6644");


        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(userAdressCreate)
                .when()
                .post("address")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }


}


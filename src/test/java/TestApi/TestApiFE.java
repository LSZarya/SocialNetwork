package TestApi;

import org.springframework.security.test.context.support.WithMockUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApiFE {

    int ok = 200;
    String api = "http://45.134.255.54:5000/";
    String logo = "static/img/logo.svg";
    String profile = "static/img/sidebar/profile.svg";
    String friends = "static/img/sidebar/friends.svg";
    String envelope = "static/img/sidebar/im.svg";
    String news = "static/img/sidebar/news.svg";
    String setting = "static/img/sidebar/settings.svg";
    String exit = "static/img/sidebar/exit.svg";
    String search = "static/img/search.svg";
    String push = "static/img/push.svg";
    String photo = "static/img/photo.svg";
    String add = "static/img/add.svg";

    @BeforeMethod
    @WithMockUser(username = "levagoli@mail.ru",password = "1234567a")

    @Test
    public void test_start(){
        given()
                .when()
                .baseUri(api)
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_logo(){
        given()
                .when()
                .baseUri(api)
                .get(logo)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_profile(){
        given()
                .when()
                .baseUri(api)
                .get(profile)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_friends(){
        given()
                .when()
                .baseUri(api)
                .get(friends)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_envelope(){
        given()
                .when()
                .baseUri(api)
                .get(envelope)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_news(){
        given()
                .when()
                .baseUri(api)
                .get(news)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_setting(){
        given()
                .when()
                .baseUri(api)
                .get(setting)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_exit(){
        given()
                .when()
                .baseUri(api)
                .get(exit)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_search(){
        given()
                .when()
                .baseUri(api)
                .get(search)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_push(){
        given()
                .when()
                .baseUri(api)
                .get(push)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_photo(){
        given()
                .when()
                .baseUri(api)
                .get(photo)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_add(){
        given()
                .when()
                .baseUri(api)
                .get(add)
                .then()
                .assertThat()
                .statusCode(200);
    }

}

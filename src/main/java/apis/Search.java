package apis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Search {

    public Response searchViaApi(String searchKeyWord){
        RequestSpecBuilder builder=new RequestSpecBuilder();
        //builder.setBaseUri("https://www.bonify.de/academy/suche?s=bonify");
        //builder.setBaseUri("https://www.bonify.de/academy/suche");
        builder.setBaseUri("https://www.bonify.de/academy");
        RequestSpecification specification=builder.build();
        specification.queryParam("s",searchKeyWord);
        Response response=given().spec(specification).get("/suche");
        response.then().log().body();
        return response;

    }
}

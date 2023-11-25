package specs;


import config.ApiConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class SpecsReqRes {

    private static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri(config.BaseUri())
            .basePath(config.BasePath())
            .log().all()
            .contentType(ContentType.JSON);
    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .expectStatusCode(200)
            .build();

}

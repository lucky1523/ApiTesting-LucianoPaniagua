package itemsCRUD;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ItemsRestAssured {


    /*
     * codigos de respuesta
     *  1XX ----> informacion
     *  2XX ----> satisfactorias
     *  3XX ----> redirecciones
     *  4XX ----> mensaje para el usuario
     *  5XX ----> error en el servidor
     *
     *  given() ----> configuracion: body / header/ parametros / authentication
     *  when() ---> method (post,get,delete,etc) / url
     *  then() ---> ya tenemos informacion de la respuesta body/codigo respuesta/ msg respuesta /header respuesta
     * */
    @Test
    public void createItem(){
        given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body("{\n" +
                        "  \"Content\":\"LucianoRestAssuredItem\",\n" +
                        "}")
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json")
                .then()
                .log().all();

    }

    @Test
    public void createItemJSONObject(){

        JSONObject body = new JSONObject();
        body.put("Content","LucianoItem");
        given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json")
                .then()
                .log().all();

    }


    @Test
    public void  createItemExternalFile(){
        String pathProject=new File("").getAbsolutePath();

        given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(new File(pathProject+"/src/test/resources/itemBody.json"))
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json")
                .then()
                .log().all();
    }
}

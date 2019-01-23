package per.wd.rx;

import io.netty.util.internal.StringUtil;
import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.ext.web.client.HttpResponse;
import io.vertx.reactivex.ext.web.client.WebClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class JdbcRxTemplate {

    public static void requset(){
        Vertx vertx=Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        WebClient webClient=WebClient.create(vertx);
        for (int i = 0; i <100 ; i++) {
            webClient.get("crm.api.duia.com","/test").send(ar -> {
                if (ar.succeeded()) {
                    // Obtain response
                    HttpResponse<Buffer> response = ar.result();
                    System.out.println(response.bodyAsString());
                } else {
                    System.out.println("Something went wrong " + ar.cause().getMessage());
                }
            });
        }

    }

    public static void main(String[] args) {
    }
}

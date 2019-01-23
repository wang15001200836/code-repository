package per.wd.rx;

import io.vertx.core.VertxOptions;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

public class Test1 {
    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        EventBus eventBus=vertx.eventBus();
        int consumerCount=0;
        MessageConsumer<Object> consumer = eventBus.consumer("wd.publish");
        new Thread(()->{
            for (int i = 0; i <1000000 ; i++) {
                eventBus.publish("wd.publish","push:"+i);
            }
        }).start();
        new Thread(()->{
            consumer.handler(message->{
                System.out.println(message.body());
            });
        }).start();
        new Thread(()->{
            consumer.handler(message->{
                System.out.println(message.body());
            });
        }).start();
        while (true){

        }
    }
}

package com.wissensalt.rnd.simplealarm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
public class SimpleAlarmApplication {

    public static void main(String[] args) {
		new SpringApplicationBuilder(SimpleAlarmApplication.class)
                .headless(false)
                .web(false)
                .run(args);
    }
}

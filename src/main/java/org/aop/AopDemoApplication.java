package org.aop;

import lombok.extern.slf4j.Slf4j;
import org.aop.config.Config;
import org.aop.model.Comment;
import org.aop.service.ProcessComment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@Slf4j
public class AopDemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProcessComment process = context.getBean("processComment", ProcessComment.class);
        process.publishComment(new Comment("this is comment", "Kot Matroskin"));
        process.deleteComment(1);

        try {
            process.methodWithCheckedException();
        } catch (IOException e) {
            log.info("Catched in main method {}", e.getMessage());
        }
        process.methodWithUncheckedException();
        context.close();
    }

}

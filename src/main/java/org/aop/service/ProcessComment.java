package org.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.aop.model.Comment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
public class ProcessComment {

    public void publishComment(Comment comment) {
        log.info("Выполняем публикацию комментария : " + comment.getComment());
    }
    public int deleteComment(int commentId) {
        log.warn("Выполняем удаление комментария : " + commentId);
        return commentId;
    }

    public void methodWithCheckedException() throws IOException {
        List<String> fileStr = fileStr = Files.readAllLines(Paths.get("123"));
    }

    public void methodWithUncheckedException() {
        int a = 1;
        int b = 0;
        System.out.println(a / b);
    }

}

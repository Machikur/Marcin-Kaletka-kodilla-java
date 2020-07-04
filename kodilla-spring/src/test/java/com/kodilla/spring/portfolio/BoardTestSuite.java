package com.kodilla.spring.portfolio;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        BoardConfig boardConfig = (BoardConfig) context.getBean(BoardConfig.class);

        List<String> doneList = boardConfig.doneList.getTasks();
        List<String> inProgressList = boardConfig.inProgressList.getTasks();
        List<String> listToDo = boardConfig.listToDo.getTasks();

        String task1 = "Task one";
        String task2 = "Task two";
        String task3 = "Task three";

        //when
        doneList.add(task1);
        inProgressList.add(task2);
        listToDo.add(task3);

        //then

        Assert.assertEquals("Task one", doneList.get(0));
        Assert.assertEquals("Task two", inProgressList.get(0));
        Assert.assertEquals("Task three", listToDo.get(0));


    }
}

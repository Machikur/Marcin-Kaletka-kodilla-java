package com.kodilla.spring.portfolio;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = (Board) context.getBean(Board.class);

        TaskList doneList = board.getDoneList();
        TaskList inProgressList = board.getInProgressList();
        TaskList listToDo = board.getToDoList();

        String task1 = "Task one";
        String task2 = "Task two";
        String task3 = "Task three";

        //when
        doneList.getTasks().add(task1);
        inProgressList.getTasks().add(task2);
        listToDo.getTasks().add(task3);

        //then
        Assert.assertEquals("Task one", board.getDoneList().getTasks().get(0));
        Assert.assertEquals("Task two", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("Task three", board.getToDoList().getTasks().get(0));


    }
}

package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //given
        String name = "List1";
        TaskList taskList = new TaskList(name, "test list");
        taskListDao.save(taskList);

        //when
        List<TaskList> testList = taskListDao.findByListName(name);

        //then
        Assert.assertFalse(testList.isEmpty());
        Assert.assertEquals(testList.get(0),taskList);

        //Clean Up
        taskListDao.deleteByListName(name);
    }
}

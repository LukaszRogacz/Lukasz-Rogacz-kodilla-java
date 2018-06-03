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
    private final String TASK_LIST_TO_DO="TO DO";
    private final String DESCRIPTION="TASK LIST DESCRIPTION-TEST";

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList=new TaskList(TASK_LIST_TO_DO,DESCRIPTION);
        String taskListName=taskList.getListName();
        taskListDao.save(taskList);
        //When
        List<TaskList> readTaskList=taskListDao.findByListName(TASK_LIST_TO_DO);
        //Then
        Assert.assertEquals(1,readTaskList.size());
        Assert.assertEquals(taskListName,readTaskList.get(0).getListName());
        //CleanUp
        int id=readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }
}

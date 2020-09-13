package com.kodilla.patterns2.observer.forum.homework;

import org.junit.Assert;
import org.junit.Test;

public class KodillaMentorTest {

    @Test
    public void mentorTest() {
        //given
        KodillaMentor jakubMentor = new KodillaMentor("Jakub");
        KodillaMentor darekMentor = new KodillaMentor("Darek");
        KodillaStudent kodillaStudent1 = new KodillaStudent("Jacek");
        KodillaStudent kodillaStudent2 = new KodillaStudent("Ada");
        KodillaStudent kodillaStudent3 = new KodillaStudent("Michal");

        kodillaStudent1.registerMentor(jakubMentor);
        kodillaStudent2.registerMentor(jakubMentor);
        kodillaStudent3.registerMentor(darekMentor);
        kodillaStudent3.registerMentor(jakubMentor);

        //when
        kodillaStudent1.addTask("task one");
        kodillaStudent1.addTask("task two");
        kodillaStudent2.addTask("task three");
        kodillaStudent3.addTask("task four");

        //then

        Assert.assertEquals(4, jakubMentor.getTaskCounter());
        Assert.assertEquals(1, darekMentor.getTaskCounter());
    }

}
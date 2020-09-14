package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SalaryAdapterTest {

    @Test
    public void testTotalSalary() {
        //given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //then
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        //then
        assertEquals(67054, totalSalary, 1);
    }

}
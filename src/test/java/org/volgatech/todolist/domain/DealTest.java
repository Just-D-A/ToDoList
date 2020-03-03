package org.volgatech.todolist.domain;

import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.DealFactory;
import org.volgatech.todolist.domain.deal.Deal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealTest {
    @Test
    public void CreateDealWithOneArgument() {

        String dealDescription = "some description";
        Deal deal = DealFactory.create(dealDescription);
        assertEquals(dealDescription, deal.getDescription());
        assertEquals('N', deal.getPriority());
        assertEquals("None", deal.getProjectName());
    }

    @Test
    public void CreateDealWithTwoArguments() {
        String dealDescription = "some description";
        String dealProjectName = "project";
        Deal deal = DealFactory.create(dealDescription, dealProjectName);
        assertEquals(dealDescription, deal.getDescription());
        assertEquals('N', deal.getPriority());
        assertEquals(dealProjectName, deal.getProjectName());
    }

    @Test
    public void CreateDealWithThreeArguments() {
        String dealDescription = "some description";
        String dealProjectName = "project";
        String dealStatus = "done";
        char priority = 'A';
        Deal deal =  DealFactory.create(dealDescription, dealStatus, dealProjectName, priority);
        assertEquals(dealDescription, deal.getDescription());
        assertEquals(priority, deal.getPriority());
        assertEquals(dealProjectName, deal.getProjectName());
    }

    @Test
    public void ChangeDeal() {
        String dealDescription = "some description";
        char newDealPriority = 'A';
        String newDealStatus = "done";
        Deal deal = DealFactory.create(dealDescription);
        deal.givePriority(newDealPriority);
        deal.changeStatus(newDealStatus);
        assertEquals(newDealPriority, deal.getPriority());
        assertEquals("done A None some description", deal.fileString());
    }
}
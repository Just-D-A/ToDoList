package org.volgatech.todolist.domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.DealFactory;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.deal.DealImpl;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.domain.list.ListImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void AddDealToList() {
        String dealDescription = "some description";
        Deal deal = DealFactory.create(dealDescription);
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        list.add(deal);
        assertEquals(1, list.getSize());
        assertEquals(deal, list.getDeal(1));
    }

    @Test
    public void RemoveDealFromList() {
        String dealDescription = "some description";
        Deal deal = DealFactory.create(dealDescription);
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        list.add(deal);
        assertEquals(1, list.getSize());
        list.remove(deal);
        assertEquals(0, list.getSize());
    }

    @Test
    public void ChangeDealInList() {
        String dealDescription = "some description";
        String newDealDescription = "new description";
        Deal deal = DealFactory.create(dealDescription);
        Deal newDeal = DealFactory.create(newDealDescription);
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        list.add(deal);
        assertEquals(deal, list.getDeal(1));
        list.change(0, newDeal);
        assertEquals(newDeal, list.getDeal(1));
    }

    @Test
    public void DoDealInList() {
        String dealDescription = "some description";
        Deal deal = DealFactory.create(dealDescription);
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        list.add(deal);
        list.doDeal(1);
        list.add(deal);
        list.cancelDeal(1);
        list.printLists();
        list.printPriList();
        assertEquals("DONE:\n"
                + "01 (N) 'some description'\n"
                + "CANCELED:\n"
                + "01 (N) 'some description'\n",
            outContent.toString());
    }

    @Test void PrintProjectList() {
        String dealDescription = "some description";
        String dealProjectName = "project";
        Deal deal = DealFactory.create(dealDescription, dealProjectName);
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        list.add(deal);
        list.printProjectList(dealProjectName);
        assertEquals("01 (N) 'some description'\n", outContent.toString());
    }


    @Test
    public void DealGetters() {
        String dealDescription = "some description\n";
        Deal deal = DealFactory.create(dealDescription);
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        list.add(deal);
        list.doDeal(1);
        list.add(deal);
        list.cancelDeal(1);
        list.add(deal);
        list.printLists();
        list.printPriList();
        ArrayList<Deal> listDone = new ArrayList<Deal>();
        listDone.add(deal);
        assertEquals(listDone, list.getList());
        assertEquals(listDone, list.getListDone());
        assertEquals(listDone, list.getListCanceled());
    }
}

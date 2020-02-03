package app.file;

import app.factory.DealFactory;
import app.factory.ListFactory;
import domain.deal.Deal;
import domain.list.List;

import java.io.*;
import java.util.ArrayList;

public class MyFileReader{
    File file;
    ArrayList<Deal> list;
    ArrayList<Deal> listDone;
    ArrayList<Deal> listCancled;

    public MyFileReader(File file) {
        this.file = file;
        list = new ArrayList<>();
        listDone = new ArrayList<>();
        listCancled = new ArrayList<>();
    }

    public List readFile() throws Exception {
        List lists = ListFactory.create(list, listDone, listCancled);

        try  {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] arguments = parseArguments(line);
                String status = arguments[0];
                char[] charArr = arguments[1].toCharArray();
                char priority = charArr[0];
                String projectName = arguments[2];
                String description = "";
                for (int i = 3; i < arguments.length; i++) {
                    if (i != arguments.length - 1) {
                        description += arguments[i] + " ";
                    } else {
                        description += arguments[i];
                    }

                }

                Deal deal = DealFactory.create(description, status, projectName, priority);

                if (status.equals("InProcess")) {
                    list.add(deal);
                } else if (status.equals("Done")) {
                    listDone.add(deal);
                } else if (status.equals("Canceled")) {
                    listCancled.add(deal);
                } else {
                    throw new Exception("Wrong file");
                    //System.out.println(status);
                }
            }
            lists = ListFactory.create(list, listDone, listCancled);
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }


    private String[] parseArguments(String line) {
        return line.split(" ");
    }

}

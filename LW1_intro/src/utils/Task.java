package utils;

import models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Ref;

public class Task<T> {

    public Task() {}

    public  static void DisplayT (List x , String header)
    {
        System.out.println("");
        System.out.println(header);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|    Name   |   Surname |  Module  |     Credit    |");
        System.out.println("-------------------------------------------------------------------");
        for (Object s:x) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");
    }
    public  static void DisplayTP (List x , String header, PrintWriter printWriter)
    {
        printWriter.println("");
        printWriter.println(header);
        printWriter.println("-------------------------------------------------------------------");
        printWriter.println("|    Name   |   Surname |  Module  |     Credit    |");
        printWriter.println("-------------------------------------------------------------------");
        for (Object s:x) {
            printWriter.println(s);
        }
        printWriter.println("-------------------------------------------------------------------");
        printWriter.println("");
    }
    public  static void DisplayS (List x , String header)
    {
        System.out.println("");
        System.out.println(header);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|    Name   |   Surname |   Module   |     Group    |");
        System.out.println("-------------------------------------------------------------------");
        for (Object s:x) {
            System.out.println(s);
        }
        System.out.println(".............................................................................");
        System.out.println("");
    }
    public  static void DisplaySP (List x , String header, PrintWriter printWriter)
    {
        printWriter.println("");
        printWriter.println(header);
        printWriter.println("-------------------------------------------------------------------");
        printWriter.println("|    Name   |   Surname |   Module   |     Group    |");
        printWriter.println("-------------------------------------------------------------------");
        for (Object s:x) {
            printWriter.println(s);
        }
        printWriter.println(".............................................................................");
        printWriter.println("");
    }

    public  static void DisplayU (LinkedList x , String header)
    {
        System.out.println("");
        System.out.println(header);
        if (x.isEmpty())
        {System.out.println("There is no instrucor responsible for given subject");
        return;}
        System.out.println("--------------");
        System.out.println("|     Module    |");
        System.out.println("--------------");
        for (Object s:x) {

            System.out.println(s);
        }
        System.out.println("--------------");
        System.out.println("");
    }
    public  static void DisplayUP (LinkedList x , String header , PrintWriter printWriter)
    {
        printWriter.println("");
        printWriter.println(header);
        if (x.isEmpty())
        {printWriter.println("There is no instrucor responsible for given subject");
            return;}
        printWriter.println("--------------");
        printWriter.println("|     Module    |");
        printWriter.println("--------------");
        for (Object s:x) {

            printWriter.println(s);
        }
        printWriter.println("--------------");
        printWriter.println("");
    }


    public static void Seperate (List <Teachers> x, List<Selctedmodule> y)
    {

        for (Teachers s : x) {
            boolean founded = false ;
            String f = s.module.toLowerCase().trim();
            for (Selctedmodule n :y) {
                String k = n.module.toLowerCase().trim();
                if(f.equals(k))
                {
                    founded=true;
                }

            }
            if (founded==false){
                x.remove(s);
            }

        }
    }
    public static Teachers teacher(List <Teachers> x, List<Selctedmodule> y,  int z ){

        int maX=0;
        Teachers max = new Teachers();
        for (Teachers s : x) {
            int higher = 0;
            for (Selctedmodule n :y) {
                if(s.module.toLowerCase().trim().equals(n.module.toLowerCase().trim()))
                {
                    higher++;

                }

            }
            if (higher > maX)
            {
                maX=higher;
                max =s;
            }
        }
        z=maX;
        return  max;

    }
    public static int teacher(List <Teachers> x, List<Selctedmodule> y ){

        int maX=0;
        Teachers max = new Teachers();
        for (Teachers s : x) {
            int higher = 0;
            for (Selctedmodule n :y) {
                if(s.module.toLowerCase().trim().equals(n.module.toLowerCase().trim()))
                {
                    higher++;

                }

            }
            if (higher > maX)
            {
                maX=higher;
                max =s;
            }
        }

        return  maX;

    }

    public static void Matching (List<Choosen> y ,List<Teachers> x, String user1,String user2)
    {

        user1 = user1.toLowerCase().trim();
        user2 = user2.toLowerCase().trim();
        for ( Teachers s: x ) {
            Choosen a=new Choosen();
            String l =s.name.toLowerCase().trim();
            String n =s.surname.toLowerCase().trim();
            if(l.equals(user1) && n.equals(user2))
            {
                a.module=s.module;
                y.add(a);
            }



        }
    }
    public static void PrintToResultFile(LinkedList<Teachers> C,LinkedList<Choosen> S, LinkedList<Selctedmodule> Q, String print , String user1 , String user2 )
    {
        LinkedList<Teachers> p= new LinkedList<Teachers>();
        LinkedList<Selctedmodule> np= new LinkedList<Selctedmodule>();
        FileWriter fw =null;
        PrintWriter pw=null;
        File file =new File("Results.txt");
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            DisplayTP(C,"Initial Data Teachers",pw);
            DisplayUP(Q,"Initial Data Selected subjects",pw);

            pw.println("\nTask1");
            if(!C.isEmpty())
            {
                C.Sort();
                DisplayTP(C,"After sorting",pw);
            }
            else {
                pw.println("Its Empty!");
            }

            //task2
            pw.println("\nTask2");
            Seperate(C,Q);
            if(!C.isEmpty())
            {
                DisplayTP(C,"After excluding",pw);

            }
            else {
                pw.println("Not found");
            }



            //task3
            int c =teacher(C,Q);
           Teachers k = teacher(C,Q,c);


            if(k !=null)
            {
                  pw.println(print);
            }
            else
            {
                pw.println
                        ("No Match");
            }


            // task 4
            Matching(S,C,user1, user2);
            DisplaySP(S,"After matching " , pw);


            pw.println("End of the program!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            pw.close();
        }
    }

}

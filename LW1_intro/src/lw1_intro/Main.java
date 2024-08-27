/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw1_intro;

import models.Student;
import org.jetbrains.annotations.NotNull;
import utils.*;
import utils.List;

import java.awt.*;
import java.io.*;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Mindaugas
 */
public class Main {

    public static <TeePrintStream> void main(String[] args) throws NoSuchFieldException, IOException {
        String filePath = "students_data.txt";
        String filepath1 = "U1a.txt";
        String filepath2 = "U1b.txt";


        Array<Student> students_arr = new Array<Student>();

        DataReader.readFromFile(filePath, students_arr);

        System.out.println("============Tests with array implementation============");
        performTests(students_arr);

        LinkedList<Student> students_llist = new LinkedList<Student>();
        DataReader.readFromFile(filePath, students_llist);
        System.out.println("-----------------------------Linked List--------------------------------");

        LinkedList<Student> x = new LinkedList<Student>();
        DataReader.readFromFile(filePath, x);
        Student zz = new Student("Tomas", "Tomaitis", 19, "IFF-9/1");
        Student oo =new Student("Adam", "Ryan", 99, "XX-XX");

        performTests(x);
        //////////////////////// Method 1 /////////////////////
        System.out.println("--------------------------Method 1----------------------------");
        x.add(zz);
        boolean vv = x.Contains(zz);
        boolean v5= x.Contains(oo);
        System.out.println("+++++Check if method is working 'Contains when object is added'+++++");
        System.out.println(vv);
        System.out.println(v5);
        System.out.println("+++++Check after removing the elemnt that we get true before'+++++");
        x.remove(zz);
        vv=x.Contains(zz);
        System.out.println(vv);
        System.out.println("--------------------------Method 1----------------------------");
        //////////////////////// Method 1 /////////////////////


        //////////////////////// Method 2 /////////////////////
        x.add(zz);
        LinkedList<Student>xx = new LinkedList<Student>();
        xx.add(zz);
        System.out.println("-------------------------Method 2---------------------------");
        System.out.println("List X before applying method retainAll");

        for(Student v : x){
            System.out.println(v);
        }
        System.out.println("----------------------------------------------------");

        boolean pv = x.retainAll(xx);


        System.out.println("Check if method retain all is working ");
        System.out.println(pv);
        System.out.println("List X after applying method retainAll");

        for(Student v : x){

            System.out.println(v);
        }
        System.out.println("XX");
        for(Student v : xx){

            System.out.println(v);
        }
        xx.remove(zz);
        xx.add(oo);
        boolean pvv=x.retainAll(xx);
        System.out.println("List X after applying method retainAll second time ");
        System.out.println(pvv);

        for(Student v : x){

            System.out.println(v);
        }

        //////////////////////////// Method 2 ///////////////////////////


        System.out.println("-----------------------------------------Array Stack-----------------------------------------------------");
        ArrayStack<Student> z = new ArrayStack<Student>();
        DataReader.readFromFile1(filePath, z);
        Student u = new Student("Tomas", "Tomaitis", 22, "IF-7/1");

        performTests1(z);
        System.out.println(" ----------------------------------------Linked List Stack------------------------------------------------------");
        LinkedListStack<Student> p = new LinkedListStack<Student>();
        DataReader.readFromFile1(filePath, p);
        performTests1(p);
        System.out.println(" ----------------------------------------Array Qeue------------------------------------------------------");
        Student v = new Student("John", "Ryan", 21, "IF-7/2");
        ArrayQueue<Student> o = new ArrayQueue<Student>();
        o.enqueue(u);
        o.enqueue(v);
        Student i = o.peak();
        System.out.println("Test");
        System.out.println(i.toString());
        Student n = o.deque();
        System.out.println("Deque is working new peak is : ");
        System.out.println(o.peak().toString());
        System.out.println(" ----------------------------------------Linked List Qeue------------------------------------------------------");
        LinkedListQueue<Student> q = new LinkedListQueue<Student>();
        q.enqueue(u);
        q.enqueue(v);
        i = q.peak();
        System.out.println("Test");
        System.out.println(i.toString());
        n = q.deque();
        i = q.peak();
        System.out.println("Deque is working new peak is : ");
        n = q.deque();
        System.out.println(i.toString());
        //System.out.println(o.peak().toString());
        System.out.println(" ----------------------------------------Lab 1 a is finished------------------------------------------------------");

        LinkedList<Selctedmodule> st = new LinkedList<Selctedmodule>();
        LinkedList<Teachers> te = new LinkedList<Teachers>();
        DataReader.readSelected(filepath1, st);
        DataReader.readTeachers(filepath2, te);
        LinkedList<Teachers> original = te;
        Task.DisplayS(st, "Initial Data of Students Choices ");
        Task.DisplayT(te, "Initial Data of available instructor ");
        te.Sort();
        Task.DisplayT(te, "After Sort ");
        Task.Seperate(te, st);
        Task.DisplayT(te, "After excluding ");
        int bb = Task.teacher(te, st);
        Teachers RR = Task.teacher(te, st, bb);
        String print = String.format(" The teacher has most modules is : %2s %1s ,number of student he has:  %1d  his module is:  %1s ", RR.getName(), RR.getSurname(), bb, RR.getModule());
        System.out.println(print);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String user1 = sc.nextLine();
        System.out.println("Enter surname");
        String user2 = sc.nextLine();
        LinkedList<Choosen> cc = new LinkedList<Choosen>();
        Task.Matching(cc, original, user1, user2);
        Task.DisplayU(cc, "Matching");
        Task.PrintToResultFile(original,cc,st, print , user1 , user2);
        String fileName = "output.txt";

//        final boolean append = true, autoflush = true;
//        PrintStream printStream = new PrintStream(new FileOutputStream(fileName, append),
//                autoflush);
//        System.setOut(printStream);
//        System.setErr(printStream);

    }






    private static void performTests(@NotNull List<Student> students)  {
        System.out.println("Initial students list:");

        for(Student student : students){
            System.out.println(student);
        }


        System.out.println(students.remove(new Student("Tomas", "Tomaitis", 22, "IF-7/1")));
        System.out.println(students.remove(new Student("Jonas", "Jonaitis", 19, "IFF-9/3")));
        System.out.println(students.remove(new Student("Vardenis", "Pavardenis", 99, "XX-XX")));

        System.out.println("\nAfter removal:");

        for(Student student : students){
            System.out.println(student);
        }

        students.add(new Student("Ona", "Onaite", 20,"IFF-8/1"));

        System.out.println("\nAfter addition at the end and insertion at the start:");

        for(Student student : students){
            System.out.println(student);
        }

        System.out.println("\nTesting get() method:");

        for(int i = 0; i < 2; i++){
            System.out.println(students.get(i));
        }

    }

    private static void performTests1(@NotNull stack<Student> students)  {
        System.out.println("Initial students list:");

        for(Student student : students){
            System.out.println(student);
        }

        Student u = new Student("Tomas", "Tomaitis", 19, "IFF-9/1");
        Student i = new Student("Jonas", "Jonaitis", 20, "IFF-8/3");
        Student o =new Student("Vardenis", "Pavardenis", 99, "XX-XX") ;

        Student j = null;
        for (Student student : students){
            if(students.peak().equals(u))
            {
                if (j != null)
                {
                    students.pop();
                    students.push(j);
                    j=null;
                }
                else students.pop();
                System.out.println(true);
            }
            else if (students.peak().equals(i)) {

                if (j != null)
                {
                    students.pop();
                    students.push(j);
                    j=null;
                }
                else students.pop();
                System.out.println(true);
            }
            else if (students.peak().equals(o)) {
                if (j != null)
                {
                    students.pop();
                    students.push(j);
                    j=null;
                }
                else students.pop();
                System.out.println(true);

            }

            else if (j==null) {j=students.peak();students.pop();System.out.println(false);}

            else {students.push(j); return;}

        }

        System.out.println("\nAfter removal:");

       for(Student student : students){
            System.out.println(student);
       }


       students.push(new Student("Ona", "Onaite", 20,"IFF-8/1"));
       System.out.println("\nAfter addition at the end and insertion at the start:");

        for(Student student : students){
           System.out.println(student);
        }

        System.out.println("\nTesting pop() method:");

        for(Student student : students){
            System.out.println(students.peak());
        }

    }




    
}

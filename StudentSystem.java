package timberman666;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        loop:while (true) {
            System.out.println("Welcome to the timberman's Student Management System");
            System.out.println("1:Add");
            System.out.println("2:Delete");
            System.out.println("3:Modify");
            System.out.println("4:Query");
            System.out.println("5:Quit");
            System.out.println("Please enter your choice");
            Scanner sc=new Scanner(System.in);
            String choose= sc.next();
            switch (choose)
            {
                case"1"-> addStudent(list);
                case"2"-> deleteStudent(list);
                case"3"-> modifyStudent(list);
                case"4"-> queryStudent(list);
                case"5"-> {
                    System.out.println("Quit");
                    break loop;
                }
                default -> System.out.println("There is no such option");
            }
        }
    }

    //add student
    public static void addStudent(ArrayList<Student> list) {
        System.out.println("Add a student");
        Student s= new Student();
        Scanner sc=new Scanner(System.in);

        String id=null;
        while (true) {
            System.out.println("Please enter the student's id");
            id=sc.next();
            boolean flag=contains(list,id);
            if(flag){
                System.out.println("The ID already exists, please re-enter it");
            }
            else{
                s.setId(id);
                break;
            }

        }

        System.out.println("Please enter the student's name");
        String name=sc.next();
        s.setName(name);

        System.out.println("Please enter the student's age");
        int age= sc.nextInt();
        s.setAge(age);

        System.out.println("Please enter the student's address");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);

        System.out.println("Student information added successfully");
    }

    //delete student
    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("Delete a student");
        Scanner sc=new Scanner(System.in);
        String id=sc.next();
        int index=getIndex(list,id);
        if(index>=0){
            list.remove(index);
        }
        else{
            System.out.println("id does not exist, deletion failed");
        }

    }

    //modify student
    public static void modifyStudent(ArrayList<Student> list) {
        System.out.println("Modify a student");
        Scanner sc=new Scanner(System.in);
        String id=sc.next();
        int index=getIndex(list,id);
        if(index==-1){
            System.out.println("The ID to be modified does not exist " +id+ " please re-enter it");
            return;
        }
        Student stu=list.get(index);
        System.out.println("Please enter the name of the student you want to modify");
        String newName= sc.next();
        stu.setName(newName);

        System.out.println("Please enter the age of the student you want to modify");
        int newAge= sc.nextInt();
        stu.setAge(newAge);

        System.out.println("Please enter the address of the student you want to modify");
        String newAddress= sc.next();
        stu.setAddress(newAddress);

        System.out.println("The student's information was modified successfully");
    }

    //query student
    public static void queryStudent(ArrayList<Student> list) {
        System.out.println("Query a student");
        if(list.size()==0)
        {
            System.out.println("There is currently no student information, please add it and inquire");
            return;
        }
        System.out.println("id\t\tname\tage\taddress");
        for (int i = 0; i < list.size() ; i++) {
            Student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());

        }

    }

    //Get the index by id
    public static int getIndex(ArrayList<Student> list,String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            String sid= stu.getId();
            if(sid.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //Determine whether the id exists in the collection
    public static boolean contains(ArrayList<Student> list,String id) {
        for (int i = 0; i < list.size(); i++) {
            Student s=list.get(i);
            String sid=s.getId();
            if(sid.equals(id)){
                return true;
            }
        }
        return false;
    }
}

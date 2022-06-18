import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Exercise6 {
    ListPhoneBook listBook = new ListPhoneBook();
    BinarySearchTreePhoneBook treeBook = new BinarySearchTreePhoneBook();
    public void insertList(){
        long start = System.nanoTime();
        String data;
        String[] dataValues;
        File file;
        Scanner scan;
        try {
            file =  new File("data.csv");
            scan = new Scanner(file);
            while(scan.hasNextLine()){
             data = scan.nextLine();
                dataValues = data.split(",");
                listBook.insert(dataValues[0], Long.parseLong(dataValues[1]));
            }
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        long end = System.nanoTime();
        System.out.println("Insert took "+((end-start)/1000000)+" milliseconds");
    }
    public void insertTree(){
        long start = System.nanoTime();
        String data;
        String[] dataValues;
        File file;
        Scanner scan;
        try {
            file =  new File("data.csv");
            scan = new Scanner(file);
            while(scan.hasNextLine()){
             data = scan.nextLine();
                dataValues = data.split(",");
                treeBook.insert(dataValues[0], Long.parseLong(dataValues[1]));
            }
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        long end = System.nanoTime();
        System.out.println("Insert took "+((end-start)/1000000)+" milliseconds");
    }
    public void findList(){
        long start = System.nanoTime();
        String data;
        String[] dataValues;
        File file;
        Scanner scan;
        int count = 0;
        try {
            file =  new File("search.txt");
            scan = new Scanner(file);
            while(scan.hasNextLine()){
            count++;
             data = scan.nextLine();
                listBook.find(data);
            }
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        long end = System.nanoTime();
        System.out.println("find() was called "+count+" times\nSearch took "+((end-start)/1000000)+" milliseconds");
    }
    public void findTree(){
        long start = System.nanoTime();
        String data;
        String[] dataValues;
        File file;
        Scanner scan;
        int count = 0;
        try {
            file =  new File("search.txt");
            scan = new Scanner(file);
            while(scan.hasNextLine()){
            count++;
             data = scan.nextLine();
                treeBook.find(data);
            }
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        long end = System.nanoTime();
        System.out.println("find() was called "+count+" times\nSearch took "+((end-start)/1000000)+" milliseconds");
    }
    public static void main(String[] args) {
        Exercise6 test = new Exercise6();
        test.insertTree();
        test.findTree();
        
    }
}

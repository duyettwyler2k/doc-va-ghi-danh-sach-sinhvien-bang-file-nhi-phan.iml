import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //ghi
    public static void writeToFile(String path, List<Student>studentList){
        try {
            FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oss=new ObjectOutputStream(fos);
            oss.writeObject(studentList);
            oss.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //doc
    public static List<Student> readToFile(String path){
        List<Student>studentList=new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            studentList=(List<Student>)ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("C:\\Users\\Pham Duyet\\Desktop\\New folder\\test.txt",students);
        List<Student>list=readToFile("C:\\Users\\Pham Duyet\\Desktop\\New folder\\test.txt");
        for (Student student:list){
            System.out.println(student);
        }
    }
}

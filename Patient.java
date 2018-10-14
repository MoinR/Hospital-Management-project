import java.util.*;

public class Patient {
    static Scanner sc = new Scanner(System.in);

    void addPatient() {
        short Id;
        String Name;
        String Disease;

        System.out.println("Enter ID for Patient : ");
        Id = sc.nextShort();

        System.out.println("Enter Name of patient : ");
        Name = sc.nextLine();

        System.out.println("Enter Disease: ");
        Disease = sc.nextLine();
        System.out.println(Id);
        System.out.println(Name);
        System.out.println(Disease);
        

    }

    public static void main(String[] args) {

    }

}

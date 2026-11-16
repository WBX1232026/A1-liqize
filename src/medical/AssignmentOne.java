package medical;

import java.util.ArrayList;

// main driver class, run all test cases
public class AssignmentOne {

    public static void main(String[] args) {
        System.out.println("========== staff list ==========");

        // I originally tried to use Scanner here to let the user type names,
        // but it kept blocking my test runs and causing issues. So I commented it out and used hardcoded data.
        // Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();

        // create custom working day list for GP
        ArrayList<String> d1 = new ArrayList<>();
        d1.add("MON");
        d1.add("WED");
        d1.add("FRI");

        // create different staff instances
        GeneralPractitioner docZhang = new GeneralPractitioner("1001", "Dr Zhang", d1, 15);
        Surgeon sur1 = new Surgeon("2001", "Dr Lee", "orthopedic");
        Nurse n1 = new Nurse("3001", "Nurse Amy", "A");
        Nutritionist nut1 = new Nutritionist("4001", "Ms Lily", "low sugar");

        // print all staff info to console
        System.out.println(docZhang);
        System.out.println(sur1);
        System.out.println(n1);
        System.out.println(nut1);

        // create manager to handle bookings
        AppointmentManager manager = new AppointmentManager();

        System.out.println("\n========== add bookings ==========");
        // create test appointment objects
        Appointment a1 = new Appointment("Tom", "0411111111", "09:00", docZhang);
        Appointment a2 = new Appointment("Jack", "0422222222", "09:30", docZhang);
        Appointment a3 = new Appointment("Rose", "0433333333", "10:00", sur1);

        // send to manager to add
        manager.addBooking(a1);
        manager.addBooking(a2);
        manager.addBooking(a3);

        // show all bookings after adding
        manager.printAllBookings();

        System.out.println("\n========== search test ==========");
        // test search by staff id
        System.out.println("Search Doctor 1001:");
        ArrayList<Appointment> searchId = manager.searchByStaffId("1001");
        // print search result
        for (int i = 0; i < searchId.size(); i++) {
            System.out.println(searchId.get(i));
        }

        // test search by patient phone
        System.out.println("Search Phone 0422222222:");
        ArrayList<Appointment> searchPhone = manager.searchByPhone("0422222222");
        for (Appointment ap : searchPhone) {
            System.out.println(ap);
        }

        System.out.println("\n========== sort test ==========");
        // add an earlier appointment for sorting test
        Appointment a4 = new Appointment("Bob", "0455555555", "08:30", docZhang);
        manager.addBooking(a4);

        // get copy then sort
        ArrayList<Appointment> listCopy = manager.getAll();
        manager.sortBookings(listCopy);
        // print sorted result
        for(Appointment ap : listCopy){
            System.out.println(ap);
        }

        System.out.println("\n========== error tests ==========");
        // test duplicate booking conflict
        manager.addBooking(new Appointment("Test1", "0400000000", "09:00", docZhang));
        // test invalid time minute
        manager.addBooking(new Appointment("Test2", "0400000000", "10:15", docZhang));

        System.out.println("\n========== remove tests ==========");
        // test cancel functions
        manager.removeBooking("9999", "14:00");
        manager.removeBooking("1001", "09:00");
        manager.removeAllByPhone("0422222222");

        System.out.println("\n========== final list ==========");
        // show remaining bookings
        manager.printAllBookings();

        // call unique methods of each staff type
        docZhang.prescribeDrug("paracetamol");
        sur1.operate("Tom");
        n1.takeBlood("Rose");
        nut1.buildDietPlan("Bob");
    }
}

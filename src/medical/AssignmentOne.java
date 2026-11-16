package medical;

import java.util.ArrayList;
import java.util.Scanner; // use scanner to read keyboard input

// main class, where we run everything
public class AssignmentOne {

    public static void main(String[] args) {
        AppointmentManager manager = new AppointmentManager();

        ArrayList<String> d1 = new ArrayList<>();
        d1.add("MON");
        d1.add("WED");
        d1.add("FRI");
        GeneralPractitioner docZhang = new GeneralPractitioner("1001", "Dr Zhang", d1, 15);
        Surgeon sur1 = new Surgeon("2001", "Dr Lee", "orthopedic");

        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Clinic Booking Program ====");
        System.out.println("1. auto test, check all functions");
        System.out.println("2. add a booking manually");
        System.out.println("3. delete a booking");
        System.out.print("type your choice (1,2,3): ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            // run the preset test cases
            doTest(manager, docZhang, sur1);
        } else if (choice.equals("2")) {
            System.out.println("\n--- Add Booking ---");

            System.out.print("Patient name: ");
            String pName = scanner.nextLine();

            System.out.print("Phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Time (like 09:00): ");
            String time = scanner.nextLine();

            System.out.println("Available staff: 1001 Dr Zhang (GP)");
            System.out.println("will book with Dr Zhang");
            Appointment newAppt = new Appointment(pName, phone, time, docZhang);

            manager.addBooking(newAppt);

            System.out.println("\n-- current bookings --");
            manager.printAllBookings();

        } else if (choice.equals("3")) {
            System.out.println("\n--- Cancel Booking ---");

            System.out.print("Doctor ID: ");
            String docId = scanner.nextLine();

            System.out.print("Booking time: ");
            String time = scanner.nextLine();

            manager.removeBooking(docId, time);

            System.out.println("\n-- current bookings --");
            manager.printAllBookings();
        } else {
            System.out.println("wrong input, exit");
        }

        scanner.close();
    }

    // my old test code moved here
    public static void doTest(AppointmentManager manager, GeneralPractitioner docZhang, Surgeon sur1) {
        System.out.println("\n========== staff list ==========");

        Nurse n1 = new Nurse("3001", "Nurse Amy", "A");
        Nutritionist nut1 = new Nutritionist("4001", "Ms Lily", "low sugar");

        System.out.println(docZhang);
        System.out.println(sur1);
        System.out.println(n1);
        System.out.println(nut1);

        System.out.println("\n========== add bookings ==========");
        Appointment a1 = new Appointment("Tom", "0411111111", "09:00", docZhang);
        Appointment a2 = new Appointment("Jack", "0422222222", "09:30", docZhang);
        Appointment a3 = new Appointment("Rose", "0433333333", "10:00", sur1);

        manager.addBooking(a1);
        manager.addBooking(a2);
        manager.addBooking(a3);

        manager.printAllBookings();

        System.out.println("\n========== search test ==========");
        System.out.println("Search Doctor 1001:");
        ArrayList<Appointment> searchId = manager.searchByStaffId("1001");
        for (int i = 0; i < searchId.size(); i++) {
            System.out.println(searchId.get(i));
        }

        System.out.println("Search Phone 0422222222:");
        ArrayList<Appointment> searchPhone = manager.searchByPhone("0422222222");
        for (Appointment ap : searchPhone) {
            System.out.println(ap);
        }

        System.out.println("\n========== sort test ==========");
        Appointment a4 = new Appointment("Bob", "0455555555", "08:30", docZhang);
        manager.addBooking(a4);

        ArrayList<Appointment> listCopy = manager.getAll();
        manager.sortBookings(listCopy);
        for(Appointment ap : listCopy){
            System.out.println(ap);
        }

        System.out.println("\n========== error tests ==========");
        manager.addBooking(new Appointment("Test1", "0400000000", "09:00", docZhang));
        manager.addBooking(new Appointment("Test2", "0400000000", "10:15", docZhang));

        System.out.println("\n========== remove tests ==========");
        manager.removeBooking("9999", "14:00");
        manager.removeBooking("1001", "09:00");
        manager.removeAllByPhone("0422222222");

        System.out.println("\n========== final list ==========");
        manager.printAllBookings();

        docZhang.prescribeDrug("paracetamol");
        sur1.operate("Tom");
        n1.takeBlood("Rose");
        nut1.buildDietPlan("Bob");
    }
}

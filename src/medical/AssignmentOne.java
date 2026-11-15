package medical;

import java.util.ArrayList;

public class AssignmentOne {

    public static void main(String[] args) {
        // 这里放人员与预约的测试，之前写过一些旧测试代码
        System.out.println("========== staff list ==========");

        // 手动拼ArrayList，不用可变参数
        ArrayList<String> d1 = new ArrayList<>();
        d1.add("MON");
        d1.add("WED");
        d1.add("FRI");
        GeneralPractitioner gp1 = new GeneralPractitioner("1001", "Dr Zhang", d1, 15);

        Surgeon surg1 = new Surgeon("2001", "Dr Zhao", "cardiac");

        ArrayList<MedicalPractitioner> team = new ArrayList<>();
        team.add(gp1);
        team.add(surg1);

        for (MedicalPractitioner p : team) {
            System.out.println(p);
        }

        // add rest later
        GeneralPractitioner gp2 = new GeneralPractitioner("1002", "Dr Li");

        ArrayList<String> d3 = new ArrayList<>();
        d3.add("TUE");
        d3.add("THU");
        GeneralPractitioner gp3 = new GeneralPractitioner("1003", "Dr Wang", d3, 8);

        Nurse n1 = new Nurse("3001", "Nurse Qian", "senior");
        Nurse n2 = new Nurse("3002", "Nurse Sun", "junior");
        Nutritionist nut1 = new Nutritionist("4001", "Zhou", "diabetes");

        team.add(gp2);
        team.add(gp3);
        team.add(n1);
        team.add(n2);
        team.add(nut1);

        System.out.println();
        for (MedicalPractitioner p : team) {
            System.out.println(p);
        }

        System.out.println();
        gp1.prescribeDrug("amoxicillin");
        surg1.operate("Zhang San");
        n1.takeBlood("Zhang San");
        nut1.buildDietPlan("Zhang San");

        System.out.println("\n========== booking section ==========");
        AppointmentManager bookingSys = new AppointmentManager();

        System.out.println("\n-- adding bookings --");
        bookingSys.addBooking(new Appointment("Zhang San", "13800000001", "09:00", gp1));
        bookingSys.addBooking(new Appointment("Li Si", "13800000002", "09:30", surg1));
        bookingSys.addBooking(new Appointment("Wang Wu", "13800000003", "10:00", n1));
        bookingSys.addBooking(new Appointment("Zhao Liu", "13800000004", "10:30", nut1));
        bookingSys.addBooking(new Appointment("Zhang San", "13800000001", "11:00", gp2));

        // old test lines, keep here
        // bookingSys.addBooking(new Appointment("test guy", "1381112222", "09:00", gp1));
        // bookingSys.removeBooking("1001", "09:30");
        // System.out.println("test skip");

        System.out.println("\n-- current list --");
        bookingSys.printAllBookings();

        System.out.println("\n-- search staff id 1001 --");
        ArrayList<Appointment> res1 = bookingSys.searchByStaffId("1001");
        for (Appointment a : res1) {
            System.out.println(a);
        }

        System.out.println("\n-- search phone 13800000001 --");
        ArrayList<Appointment> res2 = bookingSys.searchByPhone("13800000001");
        for (Appointment a : res2) {
            System.out.println(a);
        }

        System.out.println("\n-- sort all bookings manually --");
        ArrayList<Appointment> allCopy = bookingSys.getAll();
        bookingSys.sortBookings(allCopy);
        for (Appointment a : allCopy) {
            System.out.println(a);
        }

        System.out.println("\n-- sort filtered result too --");
        ArrayList<Appointment> filteredCopy = bookingSys.searchByPhone("13800000001");
        bookingSys.sortBookings(filteredCopy);
        for (Appointment a : filteredCopy) {
            System.out.println(a);
        }

        System.out.println("\n-- test duplicate slot --");
        bookingSys.addBooking(new Appointment("test", "13900000001", "09:00", gp1));

        System.out.println("\n-- test bad time --");
        bookingSys.addBooking(new Appointment("test", "13900000001", "10:15", gp1));

        System.out.println("\n-- remove non-existent --");
        bookingSys.removeBooking("9999", "14:00");

        System.out.println("\n-- remove by id+time --");
        bookingSys.removeBooking("1001", "09:00");

        System.out.println("\n-- remove all by phone --");
        bookingSys.removeAllByPhone("13800000001");

        System.out.println("\n-- final state --");
        bookingSys.printAllBookings();

        System.out.println("\n==== finished ====");
    }
}
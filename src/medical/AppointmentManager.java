package medical;

import java.util.ArrayList;

public class AppointmentManager {

    private ArrayList<Appointment> bookingList = new ArrayList<>();

    public void addBooking(Appointment appoint) {
        if (appoint == null) {
            System.out.println("empty booking object, skip");
            return;
        }

        String t = appoint.getTimeSlot();
        if (t == null || t.length() != 5 || t.charAt(2) != ':') {
            System.out.println("this time format is invalid");
            return;
        }
        if (t.compareTo("08:00") < 0 || t.compareTo("16:00") >= 0) {
            System.out.println("this time is invalid, clinic only 08:00-16:00 half-hour slots");
            return;
        }
        String mm = t.substring(3);
        if (!mm.equals("00") && !mm.equals("30")) {
            System.out.println("this time is invalid, clinic only 08:00-16:00 half-hour slots");
            return;
        }

        // check duplicate
        for (Appointment b : bookingList) {
            if (b.getStaff().getID().equals(appoint.getStaff().getID())
                    && b.getTimeSlot().equals(t)) {
                System.out.println("slot taken for this staff member, choose another");
                return;
            }
        }

        bookingList.add(appoint);
        System.out.println("booking saved -> " + appoint);
    }

    public ArrayList<Appointment> getAll() {
        ArrayList<Appointment> ev = new ArrayList<>();
        for (int i = 0; i < bookingList.size(); i++) {
            ev.add(bookingList.get(i));
        }
        return ev;
    }

    public ArrayList<Appointment> searchByStaffId(String targetId) {
        ArrayList<Appointment> t1 = new ArrayList<>();
        for (int i = 0; i < bookingList.size(); i++) {
            Appointment thing = bookingList.get(i);
            if (thing.getStaff().getID().equals(targetId)) {
                t1.add(thing);
            }
        }
        return t1;
    }

    public ArrayList<Appointment> searchByPhone(String phoneNum) {
        ArrayList<Appointment> stuff = new ArrayList<>();
        for (Appointment item : bookingList) {
            if (item.getPhone().equals(phoneNum)) {
                stuff.add(item);
            }
        }
        return stuff;
    }

    public void sortBookings(ArrayList<Appointment> listToSort) {
        for (int i = 0; i < listToSort.size() - 1; i++) {
            for (int j = 0; j < listToSort.size() - i - 1; j++) {
                if (listToSort.get(j).getTimeSlot().compareTo(listToSort.get(j + 1).getTimeSlot()) > 0) {
                    // swap if out of order
                    Appointment temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j + 1));
                    listToSort.set(j + 1, temp);
                }
            }
        }
    }

    public void removeBooking(String staffId, String timeT) {
        // forward loop messes up index, go backwards
        for (int i = bookingList.size() - 1; i >= 0; i--) {
            Appointment b = bookingList.get(i);
            if (b.getStaff().getID().equals(staffId) && b.getTimeSlot().equals(timeT)) {
                bookingList.remove(i);
                System.out.println("removed booking -> " + b);
                return;
            }
        }
        System.out.println("cannot find that booking entry");
    }

    public void removeAllByPhone(String phone) {
        int removeCount = 0;
        for (int i = bookingList.size() - 1; i >= 0; i--) {
            Appointment b = bookingList.get(i);
            if (b.getPhone().equals(phone)) {
                bookingList.remove(i);
                System.out.println("removed booking -> " + b);
                removeCount++;
            }
        }
        if (removeCount == 0) {
            System.out.println("no bookings linked to this phone");
        }
    }

    public void printAllBookings() {
        if (bookingList.size() == 0)
        {
            System.out.println("no bookings stored");
            return;
        }
        System.out.println("bookings: " + bookingList.size());
        for (Appointment entry : bookingList) {
            System.out.println(entry);
        }
    }
}
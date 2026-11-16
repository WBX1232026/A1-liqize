package medical;

import java.util.ArrayList;

// Manager class, control all booking operations
public class AppointmentManager {

    // store all booking records
    private ArrayList<Appointment> bookingList = new ArrayList<>();

    // add booking after all validation checks
    public void addBooking(Appointment appoint) {
        // check if appointment object is null
        if (appoint == null) {
            System.out.println("empty booking object, skip");
            return;
        }

        String t = appoint.getTimeSlot();
        // check time string format HH:MM
        if (t == null || t.length() != 5 || t.charAt(2) != ':') {
            System.out.println("this time format is invalid");
            return;
        }
        // check time within clinic opening hours
        if (t.compareTo("08:00") < 0 || t.compareTo("16:00") >= 0) {
            System.out.println("this time is invalid, clinic only 08:00-16:00 half-hour slots");
            return;
        }

        // only allow 00 or 30 minutes
        String mm = t.substring(3);
        if (!mm.equals("00") && !mm.equals("30")) {
            System.out.println("this time is invalid, clinic only 08:00-16:00 half-hour slots");
            return;
        }

        // check double booking conflict
        for (Appointment b : bookingList) {
            if (b.getStaff().getID().equals(appoint.getStaff().getID()) && b.getTimeSlot().equals(t)) {
                System.out.println("slot taken for this staff member, choose another");
                return;
            }
        }

        // pass all checks, add into list
        bookingList.add(appoint);
        System.out.println("booking saved -> " + appoint);
    }

    // return a copy of all bookings
    public ArrayList<Appointment> getAll() {
        ArrayList<Appointment> ev = new ArrayList<>();
        // loop to copy every item
        for (int i = 0; i < bookingList.size(); i++) {
            ev.add(bookingList.get(i));
        }
        return ev;
    }

    // search appointments by staff id
    public ArrayList<Appointment> searchByStaffId(String targetId) {
        ArrayList<Appointment> t1 = new ArrayList<>();
        // go through all bookings
        for (int i = 0; i < bookingList.size(); i++) {
            Appointment thing = bookingList.get(i);
            // match staff id
            if (thing.getStaff().getID().equals(targetId)) {
                t1.add(thing);
            }
        }
        return t1;
    }

    // search appointments by patient phone
    public ArrayList<Appointment> searchByPhone(String phoneNum) {
        ArrayList<Appointment> stuff = new ArrayList<>();
        // loop all entries
        for (Appointment item : bookingList) {
            // compare phone string
            if (item.getPhone().equals(phoneNum)) {
                stuff.add(item);
            }
        }
        return stuff;
    }

    // sort appointment list by time using bubble sort
    public void sortBookings(ArrayList<Appointment> listToSort) {
        // outer loop for passes
        for (int i = 0; i < listToSort.size() - 1; i++) {
            // inner loop for compare adjacent items
            for (int j = 0; j < listToSort.size() - i - 1; j++) {
                // swap if earlier time is after later time
                if (listToSort.get(j).getTimeSlot().compareTo(listToSort.get(j + 1).getTimeSlot()) > 0) {
                    Appointment temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j + 1));
                    listToSort.set(j + 1, temp);
                }
            }
        }
    }

    // cancel one booking: match staff id + time
    public void removeBooking(String staffId, String timeT) {
        // learned the hard way, forward loop skips items when removing
        for (int i = bookingList.size() - 1; i >= 0; i--) {
            Appointment b = bookingList.get(i);
            // match both staff id and time
            if (b.getStaff().getID().equals(staffId) && b.getTimeSlot().equals(timeT)) {
                bookingList.remove(i);
                System.out.println("removed booking -> " + b);
                return;
            }
        }
        // no matched booking found
        System.out.println("cannot find that booking entry");
    }

    // delete all bookings linked to one phone number
    public void removeAllByPhone(String phone) {
        int removeCount = 0;
        // backwards loop for safe deletion
        for (int i = bookingList.size() - 1; i >= 0; i--) {
            Appointment b = bookingList.get(i);
            // check phone match
            if (b.getPhone().equals(phone)) {
                bookingList.remove(i);
                System.out.println("removed booking -> " + b);
                removeCount++;
            }
        }
        // tell user nothing was deleted
        if (removeCount == 0) {
            System.out.println("no bookings linked to this phone");
        }
    }

    // print all current bookings
    public void printAllBookings() {
        // check empty list
        if (bookingList.size() == 0) {
            System.out.println("no bookings stored");
            return;
        }
        System.out.println("bookings: " + bookingList.size());
        // print each booking
        for (Appointment entry : bookingList) {
            System.out.println(entry);
        }
    }
}

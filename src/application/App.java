package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date check_in = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date check_out = sdf.parse(sc.next());

        if (!check_out.after(check_in)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(number, check_in, check_out);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            check_in = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            check_out = sdf.parse(sc.next());

            Date now = new Date();
            if (check_in.before(now) || check_out.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates.");
            } else if (!check_out.after(check_in)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date.");

            } else {
                reservation.updateDates(check_in, check_out);
                System.out.println("Reservation: " + reservation);
            }

        }

        sc.close();
    }
}

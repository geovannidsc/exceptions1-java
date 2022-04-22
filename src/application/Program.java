package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in Date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out Date: ");
		Date checkOut = sdf.parse(sc.next());
		
		//Verifica se a data de Check-Out � maior que a data de Check-in
		if ( !checkOut.after(checkIn)) {
			System.out.println("Erro in reservation: Check-out DATE MUST BE AFTER CHECK-IN DATE");
		}
		else {
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: "+reservation);
			
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.println("Check-in Date: ");
		checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out Date: ");
		checkOut = sdf.parse(sc.next());
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		}
			else if (!checkOut.after(checkIn)){
		
			
		} else {
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
		}
		
		
		
		
		
		}
		
		sc.close();

	}

}

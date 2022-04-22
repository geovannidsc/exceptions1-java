package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ecceptions.DomainException;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in Date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date: ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
				
			System.out.println();
			System.out.print("Enter data to update the reservation: ");
			System.out.print("Check-in Date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date: ");
			checkOut = sdf.parse(sc.next());
			
			
				
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: "+e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("Entered value is incorrect");
		}
	
	
		
		
		
		
		sc.close();

	}

}

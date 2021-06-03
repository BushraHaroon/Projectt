package projectt;
import java.util.*;
public class Username extends Exception {
	public  Username(String msg) {
		super(msg);
	}
}
class Password extends Exception{
	public Password(String msg) {
		super(msg);
	}
class Use{
private String Booking;

Use(String Booking){
	this.Booking=Booking;
}
public String getName() {
	return Booking;
}
public  void setName(String Booking) {
	this.Booking=Booking;
}
}
class Reservation{
 int availableSeats = 10;
synchronized void reserveSeat(int requestedSeats)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the name: ");
	String name = sc.nextLine();
	System.out.println("Name is: "+name);
    System.out.println(Thread.currentThread().getName() + " entered.");
    System.out.println("Availableseats : " + availableSeats + "\n Requestedseats : " + requestedSeats);
    if (availableSeats >= requestedSeats)
    {
        System.out.println("Seat Available: You can Reserve  ");
        try
        {
            Thread.sleep(100);  
        } 
        catch (InterruptedException e)
        {
            System.out.println("Thread interrupted");
        }
        System.out.println(requestedSeats + " seats reserved.");
        availableSeats = availableSeats - requestedSeats;
    }
    else
    {
        System.out.println("The seat which you request is not available");
    }
    System.out.println(Thread.currentThread().getName() + " leaving.");
    System.out.println("----------------------------------------------");
}
}
class Person extends Thread{
Reservation reserve;
int requestedSeats;

public Person(Reservation reserve, int requestedSeats)
{
    this.reserve = reserve;
    this.requestedSeats = requestedSeats;
}

@Override
public void run() 
{
    reserve.reserveSeat(requestedSeats);
}
}}


package projectt;

import java.util.Scanner;	
	 class Reservation {
		
		static int availableSeats = 10;
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
	}
	class Airline{
	final String booking;
	final int payment;
	public Airline(String booking,int payment)
	{
		this.booking=booking;
		this.payment=payment;
		
	}
	public String getBooking() {
		return booking;
	}
	public int getPayment() {
		return payment;
	}}
public class Main {
	private String Booking;

	Main(String Booking){
		this.Booking=Booking;
	}
	public String getName() {
		return Booking;
	}
	public  void setName(String Booking) {
		this.Booking=Booking;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String username,password;
		System.out.println("Enter the username:");
		 username= sc.nextLine();
		System.out.println("Enter the password");
	  password= sc.nextLine();
	int length=username.length();
	try {
		if(length<6)
			throw new Username("Username must be greater than 6");
		else  if(!password.equals("Haroon"))
			throw new Password("Incorrect password");
		else
			System.out.println("Login successful");
	}
	catch (Username u) {
		u.printStackTrace();
	}
	catch (Password p) {
		p.printStackTrace();}
	
	System.out.println("-------Your Previous booking----------");
	Main obj =new Main("Local Flight from Karachi to islamabad");
	System.out.println(""+obj.getName()+"\n");

	System.out.println("---------Your Updating Booking----- ");
	obj.setName("Domestic Flight from karachi to islamabad");
	System.out.println(""+obj.getName()+"\n");
	
    System.out.println(""+obj.getName()+"\n");
    Airline obj1=new Airline ("Domestic Flight from karachi to islamabad",50000);
    System.out.println("Flight is: "+obj1.getBooking());
    System.out.println("Payment is "+obj1.getPayment());
    System.out.println(""+obj.getName()+"\n");
	Reservation reserve = new Reservation(); 
    Person thread2 = new Person(reserve, 5); 
    thread2.start();
    Person thread0 = new Person(reserve, 4);
    thread0.start();
    Person thread1 = new Person(reserve, 2);
    thread1.start();
	}
}
	
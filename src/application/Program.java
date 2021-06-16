package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.Employee;
import entites.OutSourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault (Locale.US);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data: ");
			System.out.println("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Hours: ");
			int hours = sc.nextInt();
			System.out.println("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			if (ch == 'y') {
				System.out.println("additional charge: ");
				double additionalCharge = sc.nextDouble();
				Employee emp = new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);	
			}
			else {
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		System.out.println();
		System.out.println("PAYMENTS: ");
		for (Employee emp : list) {
			System.out.println(emp.getName()+ " - $ " + String.format("%.2f", emp.payment()));
		}
		sc.close();
	}

}

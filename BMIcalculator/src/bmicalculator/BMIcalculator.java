package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class BMIcalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		char repeat = 0;
	
		do {
		
			//All Our code
			int unitchoice = getUnitChoice(scanner);
			
			double weight = (unitchoice == 1) ? getvalidinput(scanner, "Enter your weight in kilograms :", 10, 600)
					: getvalidinput(scanner, "Enter your weight in pounds", 22, 1300);
			
			double height= (unitchoice == 1) ? getvalidinput(scanner, "Enter your height in meters :", 0.5, 2.5)
					: getvalidinput(scanner, "Enter your weight in inches", 20, 100);
			
			double bmi = calculateBMI(unitchoice, weight, height);
			System.out.println("Your BMI is" + bmi);
			//repeat = askToRepeat(scanner);
			System.out.println();
		
		}while (repeat == 'Y' || repeat == 'Y');
	}

	private static double getValidInput(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0;
	}
	//unit - Metric and Imperial
	public static int getUnitChoice(Scanner scanner) {
		int choice;
		
		while(true) {
			System.out.println("select a prefered unit:\n"
					+ "1. Metric (kg, m)\n"
					+ "2. Imperial (lbs, in)\n"
					+ " Please select either option 1 or option 2");
			
			if(scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if(choice == 1 || choice == 2) {
					break;
				} else {
					System.out.println("Invalid choice. Please enter either 1 or 2");
				}
			} else {
				System.out.println("Invalid input. Please enter a number(1 or 2");
				scanner.next();
			}
		}
				
		return choice;
	}
	
	public static double getvalidinput(Scanner scanner, String prompt, double min, double max) {
		double value;
		
		while(true) {
			System.out.println(prompt);
			
			if(scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				if(value >= min && value <= max) {
					break;
				} else {
					System.out.printf("Please enter a value between %.1f and %.1f.\n", min, max);
				}
			} else {
				System.out.println("Invalid input. Please enter a value");
				scanner.next();
			}
		}
				
		return value;
	}
		
		public static double calculateBMI(int unitChoice, double weight, double height) {
			double totalBMI;
			
			if(unitChoice == 1) {
			totalBMI = weight / (height * height);
			} else {
				totalBMI = (703 * weight) / (height / height);
			}
			
			return totalBMI;
			
				
			
		}
	}
	



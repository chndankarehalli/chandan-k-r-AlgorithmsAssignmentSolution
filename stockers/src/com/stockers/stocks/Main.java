package com.stockers.stocks;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner in = new Scanner(System.in);
		StockExchange stock = new StockExchange();
		stock.initialSetup();

		do {
			System.out.println(" -----------------------------------------------\n"
					+ "Enter the operation that you want to perform\n"
					+ "1. Display the companies stock prices in ascending order\n"
					+ "2. Display the companies stock prices in descending order\n"
					+ "3. Display the total no of companies for which stock prices rose today\n"
					+ "4. Display the total no of companies for which stock prices declined today\n"
					+ "5. Search a specific stock price\n" + "6. press 0 to exit\n"
					+ "-----------------------------------------------\n");
			System.out.println();

			choice = in.nextInt();
			switch (choice) {
			case 0:
				choice = 0;
				break;
			case 1: {
				System.out.println("Stock prices in ascending order are : ");
				stock.ascendingOrder(stock.shareprice, 0, stock.shareprice.length - 1);
				stock.printValues();
			}
			break;
			case 2: {
				System.out.println("Stock prices in descending order are : ");
				stock.ascendingOrder(stock.shareprice, 0, stock.shareprice.length - 1);
				stock.descendingOrder();
			}
			break;
			case 3: {
				System.out.println("Total no of companies whose stock price rose today : " + stock.bullish);
			}
			break;
			case 4: {
				System.out.println("Total no of companies whose stock price declined today : " + stock.bearish);
			}
			break;
			case 5: {
				stock.searchValue();
			}
			break;
			default:
				System.out.println("Invalid choice. Enter a valid choice.\n");
			}
		} while (choice != 0);
		System.out.println("Exited Successfully!!!");
		in.close();
	}
}
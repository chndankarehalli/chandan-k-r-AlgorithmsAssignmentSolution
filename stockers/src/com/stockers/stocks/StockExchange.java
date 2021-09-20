package com.stockers.stocks;

import java.util.Scanner;

class StockExchange {

	public int noOfCompanies;
	public double[] shareprice;
	boolean priceRise;
	int bullish = 0, bearish = 0;

	Scanner sc = new Scanner(System.in);

	public void initialSetup() {
		System.out.println("Enter the no of companies: ");
		noOfCompanies = sc.nextInt();
		shareprice = new double[noOfCompanies];
		insertValues();
	}

	public void insertValues() {
		for (int i = 0; i < noOfCompanies; i++) {
			System.out.print("Enter current stock price of the company " + (i + 1) + ": ");
			shareprice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			priceRise = sc.nextBoolean();
			if (priceRise == true) {
				bullish++;
			} else {
				bearish++;
			}
		}
	}

	public void ascendingOrder(double array[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			ascendingOrder(array, l, m);
			ascendingOrder(array, m + 1, r);
			conquerArray(array, l, m, r);
		}
	}

	public void conquerArray(double array[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		double L[] = new double[n1];
		double R[] = new double[n2];
		for (int i = 0; i < n1; ++i) {
			L[i] = array[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = array[m + 1 + j];
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	public void printValues() {
		for (int i = 0; i < shareprice.length; i++) {
			System.out.print(shareprice[i] + "  ");
		}
		System.out.println();
	}

	public void descendingOrder() {
		for (int i = shareprice.length - 1; i >= 0; i--) {
			System.out.print(shareprice[i] + "  ");
		}
		System.out.println();
	}

	public void searchValue() {
		boolean status = false;
		System.out.println("Enter the stock price to search : ");
		double value = sc.nextDouble();
		for (int i = 0; i < shareprice.length; i++) {
			if (shareprice[i] == value) {
				System.out.println("Stock of value " + value + " is present");
				status = true;
			}
		}
		if (status == false) {
			System.out.println("Stock Value not found!!!");
		}
	}
}
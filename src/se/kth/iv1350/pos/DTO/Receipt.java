package se.kth.iv1350.pos.DTO;
import se.kth.iv1350.pos.model.Sale;
public class Receipt {
	Sale sales;
	double totalPrice;
	double cash;
	
	public Receipt(double newTotalPrice, double newCash, Sale newSales) {
		totalPrice = newTotalPrice;
		cash = newCash;
		sales = newSales;
	}

	public Sale getSales() {
		return sales;
	}

	public double getCash() {
		return cash;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
}

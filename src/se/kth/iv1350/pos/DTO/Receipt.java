package se.kth.iv1350.pos.DTO;
import se.kth.iv1350.pos.model.Sale;
public class Receipt {
	Sale sales;
	double totalPrice;
	double cash;
	String finalReceipt = new String();
	
	public Receipt(double newTotalPrice, double newCash, Sale newSales) {
		totalPrice = newTotalPrice;
		cash = newCash;
		sales = newSales;
	}

	public void createReceipt(){
		StringBuilder sb = new StringBuilder();

		sb.append("KVITTO" + "\n");
		sb.append(sales.getStoreName() + "\n");
		sb.append(sales.getStoreAdress() + "\n");
		for (int i = 0; i < sales.getAllItems().size(); i++) {
			sb.append(sales.getAllItems().get(i).toString() + "\n");
		}
		sb.append(sales.getHour() + ":" + sales.getMinute() + "\n");
		sb.append(sales.getYear() + "-" + sales.getMonth() + "-" + sales.getDay() + "\n");
		sb.append("Total price: " + totalPrice + "\n");
		sb.append("Total VAT: " + sales.totalVAT() + "\n");
		sb.append("Cash: " + (totalPrice + cash) + "\n");
		sb.append("Change: " + cash);

		finalReceipt = sb.toString();
	}

	public String getFinalReceipt() {
		return finalReceipt;
	}
}

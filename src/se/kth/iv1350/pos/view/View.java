package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.controller.*;


public class View {

	Controller contr;

	public View(Controller newContr) {

		this.contr = newContr;
		contr.addRevenueObserver(new TotalRevenueView());
		
	}

	public void StartSale() {
		contr.startNewSales();
		try {
			System.out.println(contr.addItem(12, 3));
			System.out.println(contr.addItem(15, 4));
			System.out.println(contr.addItem(78, 4));
		} catch (Exception e) {
			System.out.println(e);
			try {
				System.out.println(contr.addItem(1, 2));
			} catch (Exception e2) {
				System.out.println(e2);
			}
			double totalPrice = contr.checksForDiscount(156, contr.getPaymentInfo());
			contr.startPayment(200, totalPrice);

			contr.startNewSales();
			try {
				System.out.println(contr.addItem(12, 2));
				System.out.println(contr.addItem(15, 1));
				System.out.println(contr.addItem(78, 4));
			} catch (Exception e3) {
				System.out.println(e3);
			}
			try {
				System.out.println(contr.addItem(1, 2));
			} catch (Exception e4) {
				System.out.println(e4);

			}
			double totalPrice2 = contr.checksForDiscount(156, contr.getPaymentInfo());
			contr.startPayment(100, totalPrice2);
		}

	}
}

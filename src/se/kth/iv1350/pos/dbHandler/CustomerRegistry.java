package se.kth.iv1350.pos.dbHandler;

public class CustomerRegistry {
	int customerID;
	double sale;

	public CustomerRegistry(int newCustomerID, double newSale){
		customerID = newCustomerID;
		sale = newSale;
	}

	public double findCustomer(int customerID){
		if(this.customerID == customerID){
			return this.sale;
		}
		return 0;
	}
}

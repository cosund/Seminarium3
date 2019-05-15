package se.kth.iv1350.pos.view;

public class TotalRevenueView implements TotalRevenue {

    private double revenue;

    public TotalRevenueView(){
        this.revenue = 0;
    }

    public void newTotal(double paymentInfo){
        this.revenue += paymentInfo;
    }

    public void printCurrentSale(){
        System.out.println("---Current total revenue---");
        System.out.println(revenue);
    }
}

public class StoreOneA extends StoreToRent {
    private boolean specialCustomer;
    private double monthlyPayment;
    private static final double DISCOUNT_RATE = 0.1;

    // 子类构造函数
    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    // 重写贷款计算方法
    @Override
    public double calculateLoanFinancing() {
        double parentPayment = super.calculateLoanFinancing();
        monthlyPayment = parentPayment;
        if (specialCustomer) {
            monthlyPayment -= monthlyPayment * DISCOUNT_RATE;
        }
        return monthlyPayment;
    }

    // 显示店铺信息
    public void showStoreInfo() {
        calculateLoanFinancing(); // 确保计算最新月供
        System.out.println(toString());
    }

    // 重写toString()
    @Override
    public String toString() {
        String parentString = super.toString();
        String loanDetails = "\n\nLOAN DETAILS (if applicable):\n" +
               "Loan Amount: " + getLoanAmount() + "\n" +
               "Loan Payment Term: " + getLoanPaymentTerm() + "\n" +
               "Interest Rate: " + getINTEREST_RATE() + "\n" +
               "Special Customer: " + specialCustomer + "\n" +
               "Monthly Loan Payment: " + monthlyPayment;
        return parentString + loanDetails;
    }
}
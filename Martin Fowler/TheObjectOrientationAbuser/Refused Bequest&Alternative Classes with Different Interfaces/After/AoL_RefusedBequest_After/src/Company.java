
public class Company {
	private double revenues;
	private double expenses;
	private personalTaxCalculator taxCalc = new personalTaxCalculator();
	
	public Company(double revenues, double expenses) {
		this.revenues = revenues;
		this.expenses = expenses;
	}
	
	public double getIncome() {
		return revenues - expenses;
	}
	
	public double calculateTax(double income, double textRate) {
       return taxCalc.calculateTax(income, textRate);
    }
	
}

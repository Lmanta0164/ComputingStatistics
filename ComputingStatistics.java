import java.util.ArrayList;

public class ComputingStatistics {
   /**
   * The ArrayList containing all of the loan data.
   */
   private ArrayList<Loan> data = new ArrayList<Loan>();
   
   /**
    * Creates a new ComputingStatistics object with an empty ArrayList 
    */
   public ComputingStatistics() {
      data = new ArrayList<Loan>();
   }
   
   /**
    * Creates a new ComputingStatistics object with the data passed in
    */
   public ComputingStatistics(ArrayList<Loan> d) {
      data = d;
   }
   
   /**
    * Calclates the total amount funded from all of the loans in the file.
    * @return the total loan amount.
    */
   public double totalAmount() {
      double amount = 0.0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         amount = amount + loan.getLoanAmount();
      }
      return amount;
   }
   public double avgLoan() {
      double amount=totalAmount();
      return amount/data.size();
   }
   public double largestLoan() {
       double max=0.0;
       Loan loan;
       for (int i = 0; i < data.size();i++){
           loan=data.get(i);
           if(loan.getLoanAmount()>max){
               max=loan.getLoanAmount();
           }
       }
       return max;
   }
   public double smallestLoan(){
       double min=largestLoan();
       Loan loan;
       for (int i = 0; i < data.size();i++){
           loan=data.get(i);
           if(loan.getLoanAmount()<min){
               min=loan.getLoanAmount();
           }
       }
       return min;
   }
   public String largestLoanCountry(){
       Loan loan;
       double max=largestLoan();
       String Country="";
       for (int i=0;  i<data.size(); i++){
           loan=data.get(i);
           if (loan.getLoanAmount()==max){
               Country=loan.getCountry();
           }
       }
       return Country;
   }
   public String smallestLoanCountry(){
       Loan loan;
       double min=smallestLoan();
       String Country="";
       for (int i=0;  i<data.size(); i++){
           loan=data.get(i);
           if (loan.getLoanAmount()==min){
               Country=loan.getCountry();
           }
       }
       return Country;
   }
   public double avgDaysToFund() {
      double amount = 0.0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         amount = amount + loan.getDaysToFund();
      }
      return (amount/data.size())/86400;
   }
   public double largestLoan(String countryNm){
       double max = 0.0;
       Loan loan;
       for (int i =0;i<data.size();i++){
           loan=data.get(i);
           if(countryNm.equals(loan.getCountry())){
               if(loan.getLoanAmount()>max){
                   max=loan.getLoanAmount();
               }
           }
       }
       return max;
   }
}

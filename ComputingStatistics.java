import java.util.ArrayList;
import java.lang.Math;
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
      return (amount/86400)/data.size();
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
   public double avgLoan(String countryNm) {
      double amount = 0.0;
      double runs=0.0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         if (loan.getCountry().equals(countryNm)){
         amount = amount + loan.getLoanAmount();
         runs++;
        }
      }
      return amount/runs;
   }
   public String longestToFundCountry(){
       int max=0;
       String Country="";
       Loan loan;
       for (int i = 0; i < data.size();i++){
           loan=data.get(i);
           if(loan.getDaysToFund()>max){
               max=loan.getDaysToFund();
           }
       }
       for (int J=0;  J<data.size(); J++){
           loan=data.get(J);
           if (loan.getDaysToFund()==max){
               Country=loan.getCountry();
           }
       }
       return Country;
   }
   public int loansFunded(String countryNm){
      int runs=0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         if (loan.getCountry().equals(countryNm)){
         runs++;
        }
      }
      return runs;
   }
   public double variance(){
       Loan loan;
       double difference;
       double total=0;
       double vari=0.0;
       for(int i=0; i<data.size(); i++){
           loan= data.get(i);
           difference= loan.getLoanAmount()-avgLoan();
           total += (difference*difference);
       }
       vari= total/data.size();
       return vari;
   }
   public double standardDeviation(){
       double standardDev = Math.sqrt(variance());
       return standardDev;
   }
   public boolean empiricalRule(){
       int yes=0;
       int no=0;
       int total=0;
       Loan loan;
       double percent = 0.68;
       for (int i=0; i<data.size(); i++){
           loan = data.get(i);
           if ((loan.getLoanAmount() >= avgLoan()-standardDeviation())&&(loan.getLoanAmount()<= avgLoan()+standardDeviation())){
               yes++;
           }
           else{
               no++;
           }
           total++;
       }
       if((yes/total)>=percent){
           return true;
       }
       else {
           return false;
       }
   }
}

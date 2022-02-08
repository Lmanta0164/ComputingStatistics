
/**
 * Write a description of class Loan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Loan
{
    private int ID;
    private double loanAmount;
    private String country;
    private int daysToFund;
    private int numLenders;
    
    public Loan(int ID, double loanAmount, String country, int daysToFund, 
            int numLenders) {
   this.ID = ID;
   this.loanAmount = loanAmount;
   this.country = country;
   this.daysToFund = daysToFund;
   this.numLenders = numLenders;
}
public int getDaysToFund(){
    return daysToFund;
}
public int getNumLenders(){
    return numLenders;
}
public String toString(){
    return "ID: "+ID+"/n"+"Loan Amount: "+loanAmount+"/n"+"Country: "+country+"/n"+"Days to Fund: "+daysToFund+"/n"+"Number of Lenders: "+numLenders;
}
public int getID(){
return ID;
}
public double getLoanAmount(){
return loanAmount;
}
public String getCountry(){
return country;
}
public void setId(int ID){
    ID = this.ID;
}
public void setLoanAmount(int loanAmonnt){
    loanAmount = this.loanAmount;
}
public void setCountry(String country){
    country = this.country;
}
public void setDaysToFund(int daysToFund){
this.daysToFund=daysToFund;
}
public void setNumLenders(int numLenders){
this.numLenders=numLenders;
}
}

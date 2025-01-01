package emailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength = 10;
    private String CompanySuffix="company.com";
    private int mailboxCapacity=500;
    private String email;
    private String alternateEmail;

// constroctor to recieve the first name and last name
public Email(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    // Call a method asking for the department then return the department
    this.department=setDepartment();
    // Call a method return a random password
    this.password=setPassword(defaultPasswordLength);
    System.out.println(this.password);
    // Combine element to generate email
    email=firstName.toLowerCase()+lastName.toLowerCase()+'@'+this.department+CompanySuffix;
    System.out.println(showinfo());
}
// ask for the department
private String setDepartment() {
    System.out.print("Enter the department number 1/Sales  2/Development 3/Accounting");
    Scanner in=new Scanner(System.in);
    int deNum=in.nextInt();
    if(deNum==1) {return "sales";}
    else if(deNum==2) {return "development";}
    else if(deNum==3) {return "accounting";}
    else {return "";}
}

private String setPassword(int length) {
    String passwordSet="ABCDEFGHIJKLMNOPKRSTUVWXYZ@%";
    char[] password=new char[length];
    for (int i = 0; i < length; i++) {
        int rand =(int)(Math.random()*passwordSet.length());
        password[i]=passwordSet.charAt(rand);
    }
    return new String(password);
}
// Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
    this.mailboxCapacity=capacity;
    }
// Set the alternative email
public void setalternateEmail(String altemail) {
    this.alternateEmail=altemail;
}
// Change the password
public void changePassword(String newPassword) {
    this.password=newPassword;
}

public int getMailboxCapacity() {
    return mailboxCapacity;
}
public String getAlternateEmail() { return alternateEmail; }

public String getPassword() {
    return password;
}
public String showinfo(){
    return firstName+" "+lastName +" "+department+" "+password+" "+alternateEmail+" "+mailboxCapacity;
}
}
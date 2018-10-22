package src;
// name provided by Travis DatBoi
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONObjectFactory {
  //this stores the parsed data from the JSON file
  JSONArray AccountsIN;
  static int UserNumber=0;

  //Constructor
  JSONObjectFactory(){
    //scanner and file name is constant across all read and write classes
    Scanner scanner = new Scanner(System.in);
    File file = new File("JSONDATA.txt");

    //reading to the file

    try {
      //this is the Scanner Object being used to create a new instance that reads the file
      //if this is implemented into another file uncomment the other code
      Scanner FileInput = new Scanner(file);

      //StringBuilder is used to parse the JSON file.
      StringBuilder FileInputConcat = new StringBuilder();

      //this while statement checks for  if anything is in the file
      while (FileInput.hasNextLine()) {
        //Concatenated all lines of the code together into one giant string
        FileInputConcat.append(FileInput.nextLine());
      }
      //Prints the Concatenated file lines
      //System.out.println(FileInputConcat.toString());

      //Creates a Object of the Parser to read the Concatenated lines of string
      JSONParser parser = new JSONParser();

      //You have to declare the right type of JSON<type> and then this code will
      //parce the string that was concatenated and will then create JSONObjects of this
      AccountsIN = (JSONArray) parser.parse(FileInputConcat.toString());
      /*
      //below the code should be implemented into the functions to get individual values
      //this code creates the JSONArray Object Accounts
      JSONArray userAccountsIN = (JSONArray) AccountsIN.get(0);

      //this code scans through the array of userAccountsIN which is labed as Accounts int the file
      for (int i = 0; i < userAccountsIN.size(); i++) {
        //This code is necessary because you need to make a JSONobject in order for us to input code
        JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(i);

        //you can parse any of the objects out as diffrent data types such as long, boolean,
        //this is just only as a string becasue this is all that is needed for now
        String UsernameIn = (String) userCredentialsIn.get("Username");
        String PasswordIn = (String) userCredentialsIn.get("Password");
        System.out.printf("Username %s;\nPassword %s\n", UsernameIn, PasswordIn);
      }
      */
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    } catch (ParseException e) {
      System.out.println(e.toString());
    }
  }
  /**
  //adds new user to JSON file
  void createNewUser(String NewUsername, String NewPassword) {
    //this stores the individual accounts
    JSONArray NewUserAccount = new JSONArray();
    //this is the object that will store the user credentials
    JSONObject userCredentials = new JSONObject();
    //puts username into the user credentials object
    userCredentials.put("Username", NewUsername);
    userCredentials.put("Password", NewPassword);
    //adds the user Credentials to the user accounts
    NewUserAccount.add(userCredentials);
    //adds the account to the JSON array
    AccountsIN.add(NewUserAccount);
    //sets the account number so that the createUserInformation function appends to the correct array value
    UserNumber = AccountsIN.toArray().length-1;
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }
 */
  //checks the username and password of all accounts to check if the combination is correct.
  Boolean LoginValidation(String enteredUsername,String enteredPassword){
    Boolean LoginCredentials = Boolean.FALSE;
    //this parses the users account from the constructor
    JSONArray userAccountsIN;
    for(int i=0;i<=AccountsIN.toArray().length-1;i++){
      userAccountsIN = (JSONArray) AccountsIN.get(i);
      //zero is the code for the user credential storage
      JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
      String UsernameIn = (String) userCredentialsIn.get("Username");
      String PasswordIn = (String) userCredentialsIn.get("Password");
      if(enteredUsername.equals(UsernameIn) && enteredPassword.equals(PasswordIn) ){
        LoginCredentials = Boolean.TRUE;
        UserNumber=i;
        break;
      }
    }
    return LoginCredentials;
  }

  //this appends the User's Information to the UserAccount
  void createUserInformation(String NewUsername,String NewPassword,String FirstName,String LastName,String Email, String AccountType){
    //this stores the individual accounts
    JSONArray NewUserAccount = new JSONArray();
    //this is the object that will store the user credentials
    JSONObject UserInformation = new JSONObject();
    //puts username into the user credentials object
    UserInformation.put("Username", NewUsername);
    UserInformation.put("Password", NewPassword);
    UserInformation.put("FirstName", FirstName);
    UserInformation.put("LastName", LastName);
    UserInformation.put("Email", Email);
    UserInformation.put("AccountType", AccountType);

    //adds the user Credentials to the user accounts
    NewUserAccount.add(UserInformation);
    //creates and adds assignmentsArray, appointmentArray, and reviewsLinkArray
    JSONArray assignmentsArray = new JSONArray();
    NewUserAccount.add(assignmentsArray);
    JSONArray appointmentArray = new JSONArray();
    NewUserAccount.add(appointmentArray);
    JSONArray reviewsLinkArray = new JSONArray();
    NewUserAccount.add(reviewsLinkArray);

    //adds the account to the JSON array
    AccountsIN.add(NewUserAccount);


    //sets the account number so that the createUserInformation function appends to the correct array value
    UserNumber = AccountsIN.toArray().length-1;
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  //adds new user to JSON file
  void deleteUser(String Username, String Password) {
    //this is too check if the login credentials are valid
    // so that it is the user deleting the account

    //this parses the users account from the constructor
    JSONArray userAccountIN;
    //
    //System.out.println(userAccountIN.size());

    for(int usernumber=0;usernumber<=AccountsIN.toArray().length-1;usernumber++){
      userAccountIN = (JSONArray) AccountsIN.get(usernumber);
      //zero is the code for the user credential storage
      JSONObject userCredentialsIn = (JSONObject) userAccountIN.get(0);
      String UsernameIn = (String) userCredentialsIn.get("Username");
      String PasswordIn = (String) userCredentialsIn.get("Password");

      if(Username.equals(UsernameIn) && Password.equals(PasswordIn) ){
        AccountsIN.remove(usernumber);
        break;
      }
      System.out.println(usernumber);
    }

    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  //returns the Username of user given their account number
  String returnUsername(int UserNumber){
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String UsernameIn = (String) userCredentialsIn.get("Username");
    return UsernameIn;
  }

  //returns the Password of user given their account number
  String returnPassword(int UserNumber){
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String PasswordIn = (String) userCredentialsIn.get("Password");
    return PasswordIn;
  }

  String returnFirstName(int UserNumber){
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String FirstName = (String) userCredentialsIn.get("FirstName");
    return FirstName;
  }

  String returnLastName(int UserNumber){
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String LastName = (String) userCredentialsIn.get("LastName");
    return LastName;
  }

  String returnEmail(int UserNumber){
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String Email = (String) userCredentialsIn.get("Email");
    return Email;
  }

  String returnRole(int UserNumber){
    //this parses the users account from the constructor
    JSONArray userAccountsIN = (JSONArray) AccountsIN.get(UserNumber);

    JSONObject userCredentialsIn = (JSONObject) userAccountsIN.get(0);
    String Role = (String) userCredentialsIn.get("Role");
    return Role;
  }

  void createAssignment(String AssignmentName, String AssigmentType, int MaxPoints, int PointsRecived,String Comments){
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(1);
    //this is the new object that will be added to the array
    JSONObject AssignmentData = new JSONObject();
    AssignmentData.put("AssignmentName", AssignmentName);
    AssignmentData.put("AssigmentType", AssigmentType);
    AssignmentData.put("MaxPoints", MaxPoints);
    AssignmentData.put("PointsRecived", PointsRecived);
    AssignmentData.put("Comments", Comments);
    AssignmentArrayInstance.add(AssignmentData);


    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  void createAppointment(String Subject, String TutorName, String AppointmentTime,String Location){
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AppointmentArrayInstance = (JSONArray) UserAccountsIN.get(2);
    //this is the new object that will be added to the array
    JSONObject AppointmentData = new JSONObject();
    AppointmentData.put("Subject", Subject);
    AppointmentData.put("TutorName", TutorName);
    AppointmentData.put("AppointmentTime", AppointmentTime);
    AppointmentData.put("Location", Location);
    AppointmentArrayInstance.add(AppointmentData);


    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }

  /**
  void createReviewLink(String ReviewNumber){
    //this parses the users account from the constructor
    JSONArray UserAccountsIN = (JSONArray) AccountsIN.get(UserNumber);
    //zero is the code for the user credential storage
    JSONArray AssignmentArrayInstance = (JSONArray) UserAccountsIN.get(3);
    //this is the new object that will be added to the array
    JSONObject AssignmentData = new JSONObject();
    AssignmentArrayInstance.add();

    //hey this is the part where you need to figure out how to store multiple review numbers such as an array
    //if thats the case then you need to figure out if you want them as separate objects or as

    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }
  */

  //this appends the AssignmentArray to the UserAccount
  /*void createAssignmentsArray(){
    //this stores the individual accounts
    JSONArray NewUserAccount = new JSONArray();
    //this is the object that will store the user credentials
    JSONObject UserInformation = new JSONObject();
    //puts username into the user credentials object
    UserInformation.put("FirstName", FirstName);
    UserInformation.put("LastName", LastName);
    UserInformation.put("Email", Email);
    UserInformation.put("AccountType", AccountType);
    //adds the user Credentials to the user accounts
    NewUserAccount.add(UserInformation);
    //adds the account to the JSON array
    AccountsIN.add(NewUserAccount);
    //print the JSON Structure
    System.out.println(AccountsIN.toJSONString());

    //now we will create a file and write the json structure to it.
    //makes a file object and passes it as a parameter as a printer
    File file = new File("JSONDATA.txt");
    try (PrintWriter writer = new PrintWriter(file);) {
      writer.print(AccountsIN.toJSONString());
    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
    }
    System.out.println("File updated successfully");
  }*/
}

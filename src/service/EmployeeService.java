package service;

import models.Director;
import models.Manager;
import models.Programmer;
import models.Workers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
public class EmployeeService {
    private String Code;
    public EmployeeService(String code) throws IOException {
        this.Code = code;
        final String filePath = code;
        ArrayList<Workers> workersList = new ArrayList<Workers>();

    //Read from file, //var//
        BufferedReader bufReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
        Integer personalCode = null;
        String firstLastName = null;
        Integer positionCode = null;
        String atribute = null;
        Double salary = null;
        String line;
        Double monthlySalary = 0.00;
        String firstName;
        int idnp;
    //distribution of functions-----------------------------------------------------------------------------------------
        System.out.println("\n-----------------Distribution of functions----------------------");
        while ((line = bufReader.readLine()) != null) {
            String[] parts = line.split("[|]");
            if (parts.length >= 0) {
                personalCode = Integer.valueOf(parts[0].trim());
                firstLastName = parts[1].trim();
                positionCode = Integer.valueOf(parts[2].trim());
                atribute = parts[3].trim();
                salary = Double.valueOf(parts[4].trim());
                workersList.add(new Workers(personalCode, firstLastName, positionCode, salary));
                Collections.sort(workersList, Comparator.comparing(Workers::getFirstLastName));
            }
            if (positionCode == 1) {
                Director directorList = new Director(personalCode, firstLastName, positionCode, salary, atribute);
                System.out.println("Director\n" +"-> "+ directorList.toString());
            } else if (positionCode == 2) {
                Manager managerList = new Manager(personalCode, firstLastName, positionCode, salary, Integer.valueOf(atribute));
               System.out.println("Manager\n" +"-> "+ managerList.toString());
            } else if (positionCode == 3) {
                Programmer programmerList = new Programmer(personalCode, firstLastName, positionCode, salary, atribute);
                System.out.println("Programmer\n" +"-> "+ programmerList.toString());
            }
        }
        System.out.println("\n----------------Order by FirstLastName------------------------");
    //Order the list in alphabetical order by FirstLastName----------------------------
        workersList.forEach(System.out::println);
    //Determine the total sum of money necessary for company in order to pay one month salary for all employees---------
        System.out.println("\n------------Total salary---------------");
        DecimalFormat df = new DecimalFormat("### . 00");
        for (Workers worker : workersList){
            System.out.println(worker.getFirstLastName() + ", "+ df.format(worker.getSalary() ));
        }
        for (Workers worker : workersList){
            monthlySalary += worker.getSalary();
        }
        System.out.println("\n->Total salary: "+monthlySalary);
        System.out.println("\n--------------------Change employee’s salary by its PersonalCode----------------------------");
    //Change employee’s salary by its PersonalCode----------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter personal code: ");
        idnp = scanner.nextInt();
        int count = 0;
        for (Workers worker : workersList){
            if (worker.getPersonalCode().equals(idnp)){
                System.out.println("Enter new salary: ");
                worker.setSalary(scanner.nextDouble());
                System.out.println("-> "+worker.toString());
                count++;
            }
        }
        if (count == 0){
            System.out.println("Error -> There is no person with such first and last name");
        }
        System.out.println("\n------------Enter the first name of the employees to see all the details of the employees---------------");
    //Enter employees FirstLastName and to see all employee details in the terminal-------------------------------------
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter First and Last name: ");
        firstName = scanner1.nextLine();
        count = 0;
        for (Workers worker : workersList){
            if (worker.getFirstLastName().equalsIgnoreCase(firstName.trim())){
                System.out.println("-> "+worker.toString());
                count++;
            }
        }
        if (count == 0){
            System.out.println("There is no person with such first and last name");
        }
    }

}

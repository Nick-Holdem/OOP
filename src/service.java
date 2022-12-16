import Model.Salary;
import Model.work.Director;
import Model.work.Manager;
import Model.work.Programmer;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
    final static String filePath = "employee-input.txt";
        public static void main(String[] args) throws IOException {


        String line;
        String linee;
        Integer key = null;
        String name = null;
        Integer Code = null;
        String Atriute = null;
        Double Salary = null;
        List<String> y = Arrays.asList(name);
        //-----------------------------------------
        Scanner myObj = new Scanner(System.in);
        String nameObj = myObj.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
        System.out.println("-----------Object-----------");
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split("[ ]");
            if (parts.length >= 0)
            {
                 key = Integer.valueOf(parts[0]);
                 name = parts[1];
                 Code = Integer.valueOf(parts[2]);
                 Atriute = parts[3];
                 Salary = Double.valueOf(parts[4]);


            }
            if (Code==1) {
                Director list = new Director(key, name, Code, Atriute, Salary);
                System.out.println("Diresctor\n");
            } else if (Code==2) {
                Manager list = new Manager(key, name, Code, Atriute, Salary);
                System.out.println("Manager\n");
            }else if (Code==3){
                Programmer list = new Programmer(key, name, Code, Atriute, Salary);
                System.out.println("Programmer\n");
            }

        }
 //---------------------------------------------------------------------------------------------------------------------
        BufferedReader readeri = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
        System.out.println("-----------Initial List-----------");
        while ((linee = readeri.readLine()) != null)
        {
            String[] parts = linee.split("[ ]");
            if (parts.length >= 1)
            {
                key = Integer.valueOf(parts[0]);
                name = parts[1];
                Code = Integer.valueOf(parts[2]);
                Atriute = parts[3];
                Salary = Double.valueOf(parts[4]);
                System.out.println( key + " | "+ name+" | "+Code+" | "+Atriute+" | "+Salary);

            }
        }
//---------------------------------------------------------------------------------------------------------------------
        System.out.println("-------------------TEST-----------------------");
        Model.Salary num = new Salary(55);
        
        System.out.println("---------------------------------------------");

//----------------------------------Sort-------------------------------------------------------------------

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String inputLine;
        List<String> lineList = new ArrayList<String>();
        while ((inputLine = bufferedReader.readLine()) != null){
            lineList.add(inputLine+"\n");
        }
        fileReader.close();

        Collections.sort(lineList);
        System.out.println(lineList);;
        //------------------------------

    }
}
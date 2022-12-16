package Model;

import Model.work.director;
import Model.work.manager;
import Model.work.programmer;
import Model.work.manager;
import Model.work.programmer;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
public class service {
    private String Code;
    public service(String code) throws IOException {
        this.Code = code;
        final String filePath = code;

        String line;
        String linee;
        Integer key = null;
        String name = null;
        Integer Code = null;
        String Atriute = null;
        Double Salary = null;
        List<String> y = Arrays.asList(name);
        //-----------------------------------------
//        Scanner myObj = new Scanner(System.in);
//        String nameObj = myObj.nextLine();

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
                director list = new director(key, name, Code, Atriute, Salary);
                System.out.println("Diresctor\n");
            } else if (Code==2) {
                manager list = new manager(key, name, Code, Atriute, Salary);
                System.out.println("Manager\n");
            }else if (Code==3){
                programmer list = new programmer(key, name, Code, Atriute, Salary);
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
        }//-----------------------------------------------------------------------
        BufferedReader bufReader = new BufferedReader(new FileReader("employee-input.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        Double ListSalary;
        String qline = bufReader.readLine();
        while (qline != null) {
            listOfLines.add(qline);
            qline = bufReader.readLine();
        }
        BufferedWriter bf = null;
        System.out.println("--------------------salary-----------------------------------");
        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter("employee-final.txt"));

            for (int k = 0; k < listOfLines.size(); k++){
                ListSalary = Double.valueOf(listOfLines.get(k).substring(listOfLines.get(k).lastIndexOf(" ") +1, listOfLines.get(k).length()));
                System.out.println(ListSalary);
            }

            bf.flush();


        }
        catch (IOException e) {
            e.printStackTrace();
            bf.close();
        }
//----------------------------------Sort- fastname-----------------------------------------------------------------
        System.out.println("----------ort FirsName----------------");
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
    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        Code = code;
    }
}

import service.EmployeeService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("-----------Initial List--------------");
        BufferedReader bufReader = new BufferedReader(new FileReader(Paths.get("employee-input.txt").toFile()));
        String line;
        while ((line = bufReader.readLine()) != null)
        {
            String[] parts = line.split("[|]");
            if (parts.length >= 1)
            {
                Integer  personalCode = Integer.valueOf(parts[0].trim());
                String firstLastName = parts[1].trim();
                Integer positionCode = Integer.valueOf(parts[2].trim());
                String atribute = parts[3].trim();
                Double salary = Double.valueOf(parts[4].trim());
                System.out.println(personalCode+" | "+ firstLastName+" | "+positionCode+" | "+atribute+" | "+salary+" | ");
            }
        }
// -------File .txt--
        EmployeeService file = new EmployeeService("employee-input.txt");
    }
}
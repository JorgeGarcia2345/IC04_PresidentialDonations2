import java.io.FileNotFoundException;
import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.HashMap;

public class Main
{
    public static final String PRES_DONATIONS = "PresidentialDonations2020.csv";
    public static final String [] canidatesWeWantToCheck = {"Trump Donald J.", "Delaney John K.", "Booker Cory A.", "Yang Andrew"};
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    public static void main(String[] args)
    {
        HashMap<String, Canidate> canidatesHashMap = new HashMap<String, Canidate>();

        try {
            Scanner file = new Scanner(new File(PRES_DONATIONS));
            String line, name = "";
            double donation;
            String[] sections;

            file.nextLine(); // clears out buffer//asdfasdfasdf
            while (file.hasNextLine()) {
                line = file.nextLine();//start the next line process, reading file
                sections = line.split(",");
                name = sections[1];
                donation = Double.parseDouble(sections[8]);
                if (!canidatesHashMap.containsKey(name))
                { //if(name.equalsIgnoreCase(canidatesWeWantToCheck[i]))
                    canidatesHashMap.put(name, new Canidate(name));
                }
                Canidate canidate = canidatesHashMap.get(name);// .updateTotalContributions(donation);
                canidate.updateContributionInfo(donation);
            }
            file.close();
            for (String canidateName : canidatesHashMap.keySet()) {
                //canidates.get(canidateName);
                Canidate canidate = canidatesHashMap.get(canidateName);
                String toStringCanidate= canidate.toString();
                System.out.println(toStringCanidate);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening" + e.getMessage());
        }
    }
}


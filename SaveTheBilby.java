/**
 * This class is main controller of save the bilby.
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveTheBilby
{
    public static final String FINAL_DATA = "./populationFinal.txt";
    public static final String START_DATA = "./population.txt";
    private Location[] locationArray;

    public SaveTheBilby()
    {
        locationArray = new Location[10];
    }

    public SaveTheBilby(Location[] locationArray)
    {
        this.locationArray = locationArray;
    }

    /**
    * This method shows bilby's face
    */
    public void bilbyFace()
    {
        System.out.print("\n __    __\n" +
            "/ \\\\..// \\\n" +
            "  ( oo ) \n" +  
            "   \\__/\n\n");
    }

    /**
    * This method excutes breeding process
    * @param index - index of location array
    * @param symbol - represent a specific species
    * @return a integer for the how many specific species were born
    */
    public int breeding(int index, char symbol)
    {
        int count = 0;
        ArrayList<Animal> animalList = locationArray[index].findSpeciesData(symbol);
        for(int j = 0; j < animalList.size(); j++) 
        {
            if (animalList.get(j).getIsAlive())
            {
                switch (symbol)
                {
                    case 'B':
                        if (naturalSelection(Bilby.BIRTH_RATE))
                        {
                            locationArray[index].setAnimalData(new Bilby());  
                            count++;                           
                        }
                        break;  
                    case 'C':
                        if (naturalSelection(Cat.BIRTH_RATE))
                        {
                            locationArray[index].setAnimalData(new Cat());
                            count++;  
                        }
                        break;
                    case 'F':
                        if (naturalSelection(Fox.BIRTH_RATE))
                        {
                            locationArray[index].setAnimalData(new Fox());
                            count++;  
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return count;
    }

    /**
    * This method lett user confirm current information
    */
    public void confirm(String greeting)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n>> " + greeting);
        scan.nextLine();
    }

    /**
    * This method shows current report of population in each location spot
    */
    public void display()
    {
        System.out.print("\n>> Saveing Bilby Project: current survial record report\n");
        System.out.print("+------+--------------------+------------------+------------------+\n");
        System.out.print("| Spot | Bilby (alive,dead) | Cat (alive,dead) | Fox (alive,dead) |\n");
        System.out.print("+------+--------------------+------------------+------------------+\n");
        for (int i = 0; i < locationArray.length; i++) 
        {
            int aliveBilby = locationArray[i].countAnimalIsAlive('B');
            int aliveCat = locationArray[i].countAnimalIsAlive('C');
            int aliveFox = locationArray[i].countAnimalIsAlive('F');
            int deadBilby = locationArray[i].findSpeciesData('B').size() - aliveBilby;
            int deadCat = locationArray[i].findSpeciesData('C').size() - aliveCat;
            int deadFox = locationArray[i].findSpeciesData('F').size() - aliveFox;

            System.out.println("| " + String.format("%4d", i+1) + " | " +
             "Bilby ( " + String.format("%3d", aliveBilby) + ", " + String.format("%3d", deadBilby) + " )" +  " | " +
             "Cat ( " + String.format("%3d", aliveCat) + ", " + String.format("%3d", deadCat) + " )" +  " | " +
             "Fox ( " + String.format("%3d", aliveFox) + ", " + String.format("%3d", deadFox) + " )"  +  " |");

        }
        System.out.print("+------+--------------------+------------------+------------------+\n");
    }

    /**
    * This method displays record of montly hunting and breeding process
    * @param month - currenr month
    * @param breedingData - int array of array about breeding information of all species in each location spot
    * @param huntingData - int array about predator's hunting in each location Spot
    * @param place - user inputed simulation place
    */
    public void displayBreedingHunting(int month, int[][] breedingData, int[][] huntingData, String place)
    {
        System.out.print("\n>> Saveing Bilby Project in " + place + ": " + month + " month later...\n");
        System.out.print("+------+--------------------+------------------+------------------+\n");
        System.out.print("| Spot | Bilby (born,eaten) | Cat (born, hunt) | Fox (born, hunt) |\n");
        System.out.print("+------+--------------------+------------------+------------------+\n");
        for (int i = 0; i < locationArray.length; i++) 
        {
            int bornBilby = breedingData[i][0];
            int bornCat = breedingData[i][1];
            int bornFox = breedingData[i][2];
            int feedCat = huntingData[i][0];
            int feedFox = huntingData[i][1];
            int killedBilby = feedCat + feedFox;

            System.out.println("| " + String.format("%4d", i+1) + " | " +
             "Bilby ( " + String.format("%3d", bornBilby) + ", " + String.format("%3d", killedBilby) + " )" +  " | " +
             "Cat ( " + String.format("%3d", bornCat) + ", " + String.format("%3d", feedCat) + " )" +  " | " +
             "Fox ( " + String.format("%3d", bornFox) + ", " + String.format("%3d", feedFox) + " )"  +  " |");
        }
        System.out.print("+------+--------------------+------------------+------------------+\n");        
    }
    /**
    * This method displays fninal record of population details in each location spot
    * @param originalDistribution - int array of original distribution of all species in each location
    * @param originalAnimal - int array of original population of all species in each location
    */
    public void displayFinal(ArrayList<int[]> originalDistribution, int[] originalAnimal)
    {
        System.out.print("\n>> Saveing Bilby Project: survial report\n");
        System.out.print("+------+-------------------------+-----------------------+-----------------------+\n");
        System.out.print("| Spot | Bilby (alive,born,dead) | Cat (alive,born,dead) | Fox (alive,born,dead) |\n");
        System.out.print("+------+-------------------------+-----------------------+-----------------------+\n");
        for (int i = 0; i < locationArray.length; i++) 
        {
            int aliveBilby = locationArray[i].countAnimalIsAlive('B');
            int aliveCat = locationArray[i].countAnimalIsAlive('C');
            int aliveFox = locationArray[i].countAnimalIsAlive('F');
            int deadBilby = locationArray[i].findSpeciesData('B').size() - aliveBilby;
            int deadCat = locationArray[i].findSpeciesData('C').size() - aliveCat;
            int deadFox = locationArray[i].findSpeciesData('F').size() - aliveFox;
            int bornBilby = locationArray[i].findSpeciesData('B').size() - originalDistribution.get(i)[0];
            int bornCat = locationArray[i].findSpeciesData('C').size() - originalDistribution.get(i)[2];
            int bornFox = locationArray[i].findSpeciesData('F').size() - originalDistribution.get(i)[1];

            System.out.println("| " + String.format("%4d", i+1) + " | " +
             "Bilby ( " + String.format("%3d", aliveBilby) + ", " + String.format("%3d", bornBilby) + ", " + String.format("%3d", deadBilby) + " )" +  " | " +
             "Cat ( " + String.format("%3d", aliveCat) + ", " + String.format("%3d", bornCat) + ", " + String.format("%3d", deadCat) + " )" +  " | " +
             "Fox ( " + String.format("%3d", aliveFox) + ", " + String.format("%3d", bornFox) + ", " + String.format("%3d", deadFox) + " )"  +  " |");

        }
        System.out.print("+------+-------------------------+-----------------------+-----------------------+\n");
        System.out.println("<< Bilby population change: " + String.format("%.2f",(((float)Bilby.numberOfBilby - originalAnimal[0]) * 100 / originalAnimal[0])) + " >>"); 
        System.out.println("<< Cat population change: " + String.format("%.2f",(((float)Cat.numberOfCat - originalAnimal[1]) * 100 / originalAnimal[1])) + " >>"); 
        System.out.println("<< Fox population change: " + String.format("%.2f",(((float)Fox.numberOfFox - originalAnimal[2]) * 100 / originalAnimal[2])) + " >>"); 
    }

    public Location[] getLocationArray()
    {
        return locationArray;
    }

    /**
    * This method executes hunting bilby process
    * @param predatorList - array list of predator object
    * @param index - index of location array
    * @param huntRate - successful hunting rate of a specific speciies
    * @return a integer for how many bilbies are hunted
    */
    public int huntBilby(ArrayList<Animal> predatorList, int index, float huntRate)
    {
        int count = 0;
        for(int j = 0; j < predatorList.size(); j++)
        {
            Predator predator = (Predator) (predatorList.get(j));
            if (predator.getIsAlive())
            { 
                if (locationArray[index].countAnimalIsAlive('B') == 0)
                {
                    predator.setHealth(1);                    
                    if (predator.getHealth() == 0)
                    {
                        predator.setIsAlive(false);
                    }
                }
                else if(naturalSelection(huntRate))
                {
                    slaughterBilby(index);
                    count++;
                }
                else
                {
                    predator.setHealth(1);
                    if (predator.getHealth() == 0)
                    {
                        predator.setIsAlive(false);
                    }
                }
            }
        }
        return count;
    }

    /**
    * This method recieve and return user input
    * @param str - a string of greeting for the purpose of asking user to input
    * @return a string of user's input
    */
    public String inputString(String str)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(str);
        String result = scan.nextLine();
        return result;
    } 

    /**
    * This method initialize distribution of species in each location spot
    * @param animalDistribution - an arraylist of array based on readData() 
    * @return a int array for the original population of all specific species in each location spot
    */
    public int[] initializeDistribution(ArrayList<int[]> animalDistribution)
    {
        int originalBilby = 0;
        int originalCat = 0;
        int originalFox = 0;
        for(int i = 0; i < locationArray.length; i++)
        {
            locationArray[i] = new Location();
            for(int j = 0; j < animalDistribution.get(i)[0]; j++)
            {
                locationArray[i].setAnimalData(new Bilby());
                originalBilby++;
            }
            for(int j = 0; j < animalDistribution.get(i)[2]; j++)
            {
                locationArray[i].setAnimalData(new Cat());
                originalCat++;
            }
            for(int j = 0; j < animalDistribution.get(i)[1]; j++)
            {
                locationArray[i].setAnimalData(new Fox());
                originalFox++;
            }
        }
        int[] newArray = {originalBilby, originalCat, originalFox};
        return newArray;
    }

    /**
    * This method radomly return boolean value base on argument
    * @param mechanism - mechanism for specific random choice
    * @return a boolean
    */
    public boolean naturalSelection(float mechanism)
    {
        int randomNumber = (int)Math.ceil(Math.random() * 100);
        return randomNumber <= mechanism * 100;
    }

    public static void main(String args[])
    {
        SaveTheBilby saveTheBilby = new SaveTheBilby();
        saveTheBilby.simulator();
    }

    /**
    * This method ask user to kill predator in specific locatin spot
    */
    public void massacrePredator()
    {
        Validation validator = new Validation();
        String userInput;
        int userInputPlace;
        int countCat = 0;
        int countFox = 0;
        System.out.println("<< One location can be only execute massacre once. >>");
        System.out.println("\n<< Where do you want to excute massacre? >>");
        do
        {
            userInput = inputString(">> Please choose between spot 1~10: ");
        }
        while(!validator.indexValid(userInput, locationArray.length));
        userInputPlace = Integer.parseInt(userInput) - 1;

        if (locationArray[userInputPlace].getMassacreMark() == true)
        {
            System.out.println("<< This location has already executed massacre.");
        }
        else
        {
            ArrayList<Animal> animalList = locationArray[userInputPlace].animalData;
            for (int i = 0; i < animalList.size(); i++)
            {
                char filter = animalList.get(i).getId().charAt(0);
                if (filter == 'F' || filter == 'C')
                {
                    if (animalList.get(i).getIsAlive())
                    {
                        if (naturalSelection(0.5f) == false)
                        {
                            animalList.get(i).setIsAlive(false);
                            if(filter == 'C')
                                countCat++;
                            else
                                countFox++;
                        }
                    }
                }
            }
            System.out.println("<< " + countCat + " cats were massacred in spot " + (userInputPlace + 1) + " >>");
            System.out.println("<< " + countFox + " foxes were massacred in spot " + (userInputPlace + 1) + " >>");
            locationArray[userInputPlace].setMassacreMark(true);
        }
        confirm("Please press any key to confrim...");
    }

    /**
    * This method offers user options monthlyBreeding
    * @param month - current month
    */
    public void monthlyMenu(int month)
    {
        boolean menuFlag = true;
        String userInput;
        Validation validator = new Validation();

        while (menuFlag)
        {
            System.out.println("\n<< Saving Bilby Movement - Round " + month + " >>");
            System.out.println("   [1] Relocate bilby.");
            System.out.println("   [2] Massacre predator.");
            System.out.println("   [3] Show distribution.");
            System.out.println("   [0] Do nothing.\n");
            do
            {
                userInput = inputString(">> choose your action to save the bilby: ");
            }
            while(!validator.choiceInvalid(userInput));
            
            switch(userInput)
            {
                case "1":
                    relocateBilby();
                    break;
                case "2":
                    massacrePredator();
                    break;
                case "3":
                    display();
                    break;
                case "0":
                    menuFlag = false;
                    break;
                default:
                    System.out.println("<< Please select 1, 2, 3 or 0. >>");
                    break;
            }
        }
    }

    /**
    * This method execute breeding process
    * @return an array of integer array about how many babies were born of all species in each location spot
    */
    public int[][] monthlyBreeding()
    {
        int[][] breedingData = new int[locationArray.length][3];

        for(int i = 0; i < locationArray.length; i++)
        {
            int bornBilby = 0;
            int bornCat = 0;
            int bornFox = 0;     

            bornBilby = breeding(i, 'B');
            bornCat = breeding(i, 'C');
            bornFox = breeding(i, 'F');
            int[] newArray = {bornBilby, bornCat, bornFox};
            breedingData[i] = newArray;
        }
        return breedingData;
    }

    /**
    * This method executes hunting process monthly
    * @return an array of integer array about how many bilbies predators killes in each location spot
    */
    public int[][] monthlyHunting()
    {
        int[][] huntingData = new int[locationArray.length][2];

        for(int i = 0; i < locationArray.length ; i++)
        {
            int catHuntBilby = 0;
            int foxHuntBilby = 0;
            ArrayList<Animal> catList = locationArray[i].findSpeciesData('C');
            ArrayList<Animal> foxList = locationArray[i].findSpeciesData('F');

            catHuntBilby = huntBilby(catList, i, Cat.HUNT_RATE);
            foxHuntBilby = huntBilby(foxList, i, Fox.HUNT_RATE);
            int[] newArray = {catHuntBilby, foxHuntBilby};
            huntingData[i] = newArray;
        }
        return huntingData;
    }

    /**
    * This method generate random number
    * @param volum - maximum + 1 number
    * @return a random number
    */
    public int randomChoice(int volume)
    {
         int number = (int)Math.floor(Math.random() * volume);
         return number;
    }

    /**
    * This method read initial data file
    * @return an array list of integer aray for the population of a specific species in each location
    */
    public ArrayList<int[]> readData()
    {
        ArrayList<int[]> animalGroup = new ArrayList<>();
        try
        {
            FileReader reader = new FileReader(START_DATA);
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine())
            {
                String[] dataLine = scan.nextLine().split(",");
                int[] distribution = new int[3];
                for(int i=0; i < distribution.length; i++) 
                {
                    distribution[i] = Integer.parseInt(dataLine[i]);
                }
                animalGroup.add(distribution);
            }
            try
            {  
                reader.close();
            }
            catch(Exception e)
            {
                System.out.println("Can't finish reading file.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Can't read file.");
        }  
        return animalGroup; 
    }

    /**
    * This method relocate bilby from one location spot to another location spot
    */
    public void relocateBilby()
    {
        Validation valider = new Validation();
        String userInput1;
        String userInput2;
        String userInput3;
        int userInputPlace;
        int userInputNumber;
        int userInputTarget;

        bilbyFace();
        System.out.println("<< Which location do you want to relocate bilby from? >>"); 
        do   
        {
            userInput1 = inputString(">> Please choose between spot 1~10: ");
        }
        while(!valider.indexValid(userInput1, locationArray.length));
        userInputPlace = (Integer.parseInt(userInput1) - 1);

        System.out.println("\n<< How many bilbies you want to move? >>");   
        do
        {
            userInput2 = inputString(">> Please input number of bilby: ");
        } 
        while(!valider.numberValid(userInput2, locationArray[userInputPlace].countAnimalIsAlive('B'))) ;
        userInputNumber = Integer.parseInt(userInput2);

        System.out.println("\n<< Which location do you want to relocate bilby to? >>");
        do
        {
            userInput3 = inputString(">> Please choose between spot 1~10: ");
        }
        while(!valider.indexValid(userInput3, locationArray.length));
        userInputTarget = (Integer.parseInt(userInput3) - 1);

        for(int i = 0; i < userInputNumber; i++)
        {
            boolean moveFlag = true;
            int choice = randomChoice(locationArray[userInputPlace].animalData.size());
            do
            {
                char filter = locationArray[userInputPlace].animalData.get(choice).getId().charAt(0);
                if (filter == 'B' && locationArray[userInputPlace].animalData.get(choice).getIsAlive())
                {
                    locationArray[userInputTarget].animalData.add(locationArray[userInputPlace].animalData.remove(choice));
                    moveFlag = false;
                }
                else
                {
                    choice = randomChoice(locationArray[userInputPlace].animalData.size());
                }
            }
            while(moveFlag == true);
        }
        System.out.println("\n<< " + userInputNumber + " bilbies are relocated from spot " + (userInputPlace + 1) + " to spot " + (userInputTarget + 1) + ". >>");
        confirm("Please press any key to confrim...");
    }

    public void setLocationArray(Location[] locationArray)
    {
        this.locationArray = locationArray;
    }

    /**
    * This method controll workflow of save the bilby
    */
    public void simulator()
    {
        welcome();
        String userInput;
        Validation valider = new Validation();
        do
        {
            userInput = inputString("Input the area you want to save bilby: ");
        }
        while(!valider.placeNameValid(userInput)); 

        ArrayList<int[]> originalDistribution = readData();
        int[] originalNumber = initializeDistribution(originalDistribution);
        System.out.println("<< Finished initialization. >>");
        display();
        System.out.println("<< Only 20 bilbies can survive in one location >>");
        System.out.println("<< One location can be only execute massacre once. >>");
        confirm("Enter any key to start monthly simulation...");

        for (int i = 0; i < 12; i++ )
        {
            int[][] breedingData = monthlyBreeding();
            int[][] huntingData = monthlyHunting();
            displayBreedingHunting(i+1, breedingData, huntingData, userInput);
            monthlyMenu(i+1);
            struggleExistence();
            confirm("Enter any key go to next month simulator");
        }
        displayFinal(originalDistribution, originalNumber);
        writeData();
    }

    /**
    * This method find alive bilby and kill him
    * @param index - index of location array
    */
    public void slaughterBilby(int index)
    {
        boolean digestFlag = true;
        ArrayList<Animal> bilbyList = locationArray[index].findSpeciesData('B');
        int choice = randomChoice(bilbyList.size());
        do
        {
            if (bilbyList.get(choice).getIsAlive())
            {
                bilbyList.get(choice).setIsAlive(false);
                digestFlag = false;
            }
            else
            {
                choice = randomChoice(bilbyList.size());
            }
        }
        while(digestFlag == true);
    }

    /**
    * This method kill bilby if they excess 20 in one location spot
    */
    public void struggleExistence()
    {
        boolean flag = false;
        for(int i = 0; i < locationArray.length ; i++)
        {
            if (locationArray[i].countAnimalIsAlive('B') > 20)
            {
                flag = true;
                break;
            }
        }
        if(flag)
        {
            bilbyFace();
            System.out.println("<< Only 20 bilbies can survive in one location >>");
        }
        for(int i = 0; i < locationArray.length ; i++)
        {
            int count = 0;
            while (locationArray[i].countAnimalIsAlive('B') > 20)
            {
                count++;
                slaughterBilby(i);
            }
            if (count > 0)
            {
                System.out.println("<< " + count + " bilbies can't survive in spot " + (i+1) + ". >>"); 
            }
        }            
    }

    /**
    * This is the title of save the bilby simulation game
    */
    public void welcome()
    {
        System.out.println("   _____             _                ____  _ ____\n" +       
                           "  / ___/____ __   __(_)___  ____ _   / __ )(_) / /_  __  __\n" +
                           "  \\__ \\/ __ `/ | / / / __ \\/ __ `/  / __  / / / __ \\/ / / /\n" +
                           " ___/ / /_/ /| |/ / / / / / /_/ /  / /_/ / / / /_/ / /_/ /\n" +
                           "/____/\\__,_/ |___/_/_/ /_/\\__, /  /_____/_/_/_.___/\\__, /\n" + 
                           "                         /____/                   /____/");
    }

    /**
    * This method write final population details of all species in each location spot
    */
    public void writeData()
    {
        int[][] animalDistribution = new int[locationArray.length][6];
        try
        {
            PrintWriter writer = new PrintWriter(FINAL_DATA);
            try
            {
                for(int i=0; i < locationArray.length; i++)
                {
                    int aliveBilby = locationArray[i].countAnimalIsAlive('B');
                    int aliveCat = locationArray[i].countAnimalIsAlive('C');
                    int aliveFox = locationArray[i].countAnimalIsAlive('F');
                    int deadBilby = locationArray[i].findSpeciesData('B').size() - aliveBilby;
                    int deadCat = locationArray[i].findSpeciesData('C').size() - aliveCat;
                    int deadFox = locationArray[i].findSpeciesData('F').size() - aliveFox;

                    int[] newArray = {aliveBilby, deadBilby, aliveCat, deadCat, aliveFox, deadFox};
                    animalDistribution[i] = newArray;
                }
                for(int[] intTmp : animalDistribution)
                {
                    String[] strTmp = new String[intTmp.length];
                    for(int i=0; i<intTmp.length; i++)
                    {
                        strTmp[i] = String.valueOf(intTmp[i]);
                    }
                    String line = String.join(",", strTmp);
                    writer.println(line);
                }
            }
            finally
            {
                writer.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Can't write file.");
        }
    }
}

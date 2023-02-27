/**
 * This class define animal
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
abstract public class Animal
{
    protected String id;
    protected boolean isAlive;
    public static int numberOfAnimal = 0;

    public Animal()
    {
        id = generateId('A', numberOfAnimal);
        isAlive = true;
        numberOfAnimal++;
    }

    public Animal(String id, boolean isAlive)
    {
        this.id = id;
        this.isAlive = isAlive;
        numberOfAnimal++;
    }

    public void display()
    {
        System.out.println("id: " + id + "\n"
                         + "is alive: " + isAlive + "\n");
    }

    /**
    * This method generate id
    * @param symbol - symbol represents on {@link SpeciesData}
    * @param number - current total specfic species population
    * @return a string of automatically generated sequence number based on symbol and number
    */
    public String generateId(char symbol, int number)
    {
        String sequence = String.format("%03d", number);
        return (symbol + sequence);
    }

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public String getId()
    {
        return id;
    }

    public static int getNumberOfAnimal()
    {
        return numberOfAnimal;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    public static void setNumberOfAnimal(int newNumberOfAnimal)
    {
        numberOfAnimal = newNumberOfAnimal;
    }
}

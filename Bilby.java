/**
 * This class define bilby
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
public class Bilby extends Animal
{
    public static final float BIRTH_RATE = 0.15f;
    public static int numberOfBilby = 0;

    public Bilby()
    {
        super(); 
        id = generateId('B', numberOfBilby);
        numberOfBilby++;
    }

    public Bilby(String id, boolean isAlive)
    {
        super();
        this.id = id;
        this.isAlive = isAlive;
        numberOfBilby++;
    }

    public static int getNumberOfBilby()
    {
        return numberOfBilby;
    }

    public static void setNumberOfBilby(int newNumberOfBilby)
    {
        numberOfBilby = newNumberOfBilby;
    }
}

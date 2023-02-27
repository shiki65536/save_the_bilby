/**
 * This class define fox
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
public class Fox extends Predator
{
    public static final float BIRTH_RATE = 0.1f;
    public static final float HUNT_RATE = 0.4f;
    public static int numberOfFox = 0;

    public Fox()
    {
        super();
        id = generateId('F', numberOfFox);
        numberOfFox++;
    }

    public Fox(String id)
    {
        super();
        this.id = id;
        numberOfFox++;
    }

    public static int getNumberOfFox()
    {
        return numberOfFox;
    }

    public static void setnumberOfFox(int newNumberOfFox)
    {
        numberOfFox = newNumberOfFox;
    }

}

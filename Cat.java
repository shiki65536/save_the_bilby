/**
 * This class define cat
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
public class Cat extends Predator
{
    public static final float BIRTH_RATE = 0.2f;
    public static final float HUNT_RATE = 0.6f;
    public static int numberOfCat = 0;

    public Cat()
    {
        super();
        id = generateId('C', numberOfCat);
        numberOfCat++;
    }

    public Cat(String id)
    {
        super();
        this.id = id;
        numberOfCat++;
    }

    public static int getNumberOfCat()
    {
        return numberOfCat;
    }

    public static void setnumberOfCat(int newNumberOfCat)
    {
        numberOfCat = newNumberOfCat;
    }
}

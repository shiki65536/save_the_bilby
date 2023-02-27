/**
 * This class define predator
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
public class Predator extends Animal
{
    protected int health;

    public Predator()
    {
        super();
        health = 3;
    }

    public Predator(int health)
    {
        super();
        this.health = health;
    }

    public void display()
    {
        System.out.println("Health: " + health);
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int number)
    {
        health -= number;
    }
}

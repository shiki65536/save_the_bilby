/**
 * This class represent animal distribution in location
 * @author Shih-Chi Wen
 * @student_id 32977271
 */

import java.util.ArrayList;

public class Location
{
    protected ArrayList<Animal> animalData;
    protected boolean massacreMark;

    public Location()
    {
        animalData = new ArrayList<Animal>();
        massacreMark = false;
    }

    public Location(ArrayList<Animal> animalData, boolean massacreMark)
    {
        this.animalData = animalData;
        this.massacreMark = massacreMark;
    }

    /**
    * This method count how many animal is alive
    * @param symbol - represent a specific species
    * @return a integer for the population of a specific species
    */
    public int countAnimalIsAlive(char symbol)
    {
        int count = 0;
        ArrayList<Animal> sepeciesData = findSpeciesData(symbol);
        for (int i = 0; i < sepeciesData.size(); i++)
        {
            if (sepeciesData.get(i).isAlive == true)
            {
                count += 1;
            }
        }
        return count;
    }

    public ArrayList getAnimalData()
    {
        return animalData;
    }

    public boolean getMassacreMark()
    {
        return massacreMark;
    }

    /**
    * This method find specific species in location
    * @param symbol - represent a specific species
    * @return an array list of animal of a specific species
    */
    public ArrayList<Animal> findSpeciesData(char symbol)
    {
        ArrayList<Animal> speciesData = new ArrayList<Animal>();
        for (int i = 0; i < animalData.size(); i++)
        {
            // or .substring(0,1)
            if (animalData.get(i).getId().charAt(0) == symbol)
            {
                speciesData.add(animalData.get(i));
            }
        }
        return speciesData;
    }

    public void setAnimalData(Animal animalObject)
    {
        animalData.add(animalObject);
    }

    public void setMassacreMark(boolean mark)
    {
        massacreMark = mark;
    }   
}

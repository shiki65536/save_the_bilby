/**
 * This class validates user input
 * @author Shih-Chi Wen
 * @student_id 32977271
 */
public class Validation
{

    /**
    * This method check if inputed choice is valid
    * @param choice - user inputed choice, must be 1, 2, 3 or 0
    * @return a boolean shows whether the param is valid
    */
    public boolean choiceInvalid(String choice)
    {
        if (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !choice.equalsIgnoreCase("3") && !choice.equalsIgnoreCase("0"))
        {
            System.out.println("<< Please input 1, 2, 3 or 0. >>\n");
            return false;
        }
        else
           return true;
    }

    /**
    * This method check if inputed index is valid
    * @param index - user inputed index, must between 1~length
    * @param length - length in specific array
    * @return a boolean shows whether the param is valid
    */
    public boolean indexValid(String index, int length)
    {
        try
        {
            int convertInt = Integer.parseInt(index);
            if(0 < convertInt && convertInt < length + 1)
                return true;
            else
            {
                System.out.println("<< Please input number between 1~" + length + ". >>\n");
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println("<< Please input number. >>\n");
            return false;
        }
    }
    /**
    * This method check if inputed number is valid
    * @param number - user inputed bilby number in specific location
    * @param size - how many bilby exists in specific location
    * @return a boolean shows whether the param number is valid
    */
    public boolean numberValid(String number, int size)
    {
        try
        {
            int convertInt = Integer.parseInt(number);
            if(convertInt <= size)
                return true;
            else
            {
                System.out.println("<< There's not such many alive bilby in this place. >>\n");
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println("<< Please input number. >>\n");
            return false;
        }
    }

    /**
    * This method check if inputed name is invalid
    * @param  place  user inputed place, must be less than 16 letters
    * @return a boolean shows whether the param is valid
    */
    public boolean placeNameValid(String placeName)
    {
        // prevent more than 16 letters input
        if (placeName.length() > 16)
        {
            System.out.println("<< Maximum characters are 16. >>\n");
            return false;
        }
        // prevent no/blank input
        else if(placeName.strip().length() == 0)
        {
            System.out.println("<< Please input letters. >>\n");
            return false;
        }       
        else
            return true;
    }
}

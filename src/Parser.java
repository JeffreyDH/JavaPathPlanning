import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Parser
{
    /** Parses the input file of the flight routes, and their costs
     * 
     * @param filename: String, name of the file that will be parsed
     */
    public static void parseFile(String filename)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String currLine = null;
            while((currLine = br.readLine()) != null)
            {
                
            }
        }
        catch(IOException io)
        {

        }
    }
};
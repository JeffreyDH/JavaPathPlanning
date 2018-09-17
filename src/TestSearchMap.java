import org.junit.Assert;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import org.junit.Before;
import java.io.File;
import java.io.FileNotFoundException;
public class TestSearchMap
{
	private static final String EXPECTED_OUTPUT_FILE = "ExpectedOutput.txt";
	private static final String SOLUTION_OUTPUT_FILE = "output.txt";
	private static final String INPUT_FILE ="input.txt";
	private static final String[] MAIN_ARGS = {INPUT_FILE, SOLUTION_OUTPUT_FILE};

	@Before
	public void setup()
	{
		// run the program
		SearchMap.main(MAIN_ARGS);
	}
		
	@Test
	public void TestProgram()
	{
		try
		{
			FileReader expected = new FileReader(new File(TestSearchMap.EXPECTED_OUTPUT_FILE));
			FileReader solution = new FileReader(new File(TestSearchMap.SOLUTION_OUTPUT_FILE));
			
			int expectedChar;
			int solutionChar;
			while( (solutionChar = solution.read()) != -1  && ((expectedChar = expected.read()) != -1))
			{
				Assert.assertEquals((char)(solutionChar),(char)(expectedChar));
			}
			expected.close();
			solution.close();

		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
	}
};
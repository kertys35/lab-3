import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class sickness 
{
	private int id=0;
	private String diagnosis = "";
	private String explanation = "";
	public sickness(int new_id, String new_diagnosis, String new_explanation)
	{
		id = new_id;
		diagnosis= new_diagnosis;
		explanation= new_explanation;
	}

	public sickness()
	{
		int id = 0;
		final String diagnosis = "";
		final String explanation = "";
	}
	public final void close()
	{

	}
	
	public final void ill_del(int line, sickness[] ill)
	{
 	   int i = 0, checks= 0;
       	    while (ill[i].id > 0)
        	{
           	   if (ill[i].id == line)
               	    {
                       checks= 1;
              	     }
                
           	    if (checks==1)
           	    {
                	ill[i].diagnosis=ill[i+1].diagnosis;
                	ill[i].explanation=ill[i+1].explanation;
                	if(ill[i].id!=0)
                   	   ill[i].id = i + 1;
          	     }
           	     i++;
       		 }

    	  ill[i-1].id=0;
	}		
	
	public final void ill_in(int total_lines, sickness[] ill, String illnessname) throws IOException
	{
	    Scanner in = new Scanner(System.in,"ibm-866");
		int check = 0;
		int ill_end = 0;
			int i = 0;
			int ch=ill[i].diagnosis.length();
			while (ill[i]!=null&&ill[i].id > 0)
			{
				if (illnessname.compareToIgnoreCase (ill[i].diagnosis) == 0)
				{
					check = 1;
				}
				i++;
			}
			if(ill[total_lines - 1]!=null)
			   { 
			     ill[total_lines - 1].diagnosis= illnessname;
		             ill[total_lines - 1].id=total_lines;
			   }
			if (check == 0)
			{
				System.out.printf("Был введен новый диагноз, введите его описание:\n");
				do
				{
					    ill[total_lines - 1].explanation=in.nextLine();
					    ch=ill[total_lines - 1].explanation.length();
				} while (ch < 1);

			}
	}
	public final void out_illness(int line, sickness[] ill)
	{
		for (int i = 0; i < 30; i++)
		{
			if (ill[i]!=null&&ill[i].id == line)
			{
				System.out.printf("%s - %s\n", ill[i].diagnosis, ill[i].explanation);
			}
		}
	}
}
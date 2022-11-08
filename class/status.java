import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
class status 
{
	private int id=0;
	private   String patient_status="";
	private   String status_description="";
	
	public status()
	{
		 int id=0;
		  String patient_status = "";
		   String status_description = "";
	}
	
	public status(int new_id, String new_patient_status, String new_status_description)
	{
		id = new_id;
		patient_status= new_patient_status;
		status_description= new_status_description;
	}

	
	public final void out_state(int line, status[] state)
	{
		  System.out.printf("%s - %s \n", state[line-1].patient_status, state[line-1].status_description);
	}
	public final void new_line(int total_lines, String statusname, status[] state)
	{
		int i;
		i=4;
		if (statusname.compareToIgnoreCase("Здоров") == 0)
		{
			i = 0;
		}
		 if (statusname.compareToIgnoreCase("Умеренное") == 0)
		 {
			 i = 1;
		 }
		 if (statusname.compareToIgnoreCase("Серьёзное") == 0)
		 {
			 i = 2;
		 }
		 switch (i)
		 {
		 case 0:
			 state[total_lines - 1] = state[30];
			 state[total_lines - 1].id = total_lines - 1;
			 break;
		 case 1:
			 state[total_lines - 1] = state[31];
			 state[total_lines - 1].id = total_lines - 1;
			 break;
		 case 2:
			 state[total_lines - 1] = state[32];
			 state[total_lines - 1].id = total_lines - 1;
			 break;
		 default:
			 break;
		 }

	}
	public final void del_line(int line, status[] state)
	{
		int i = 0;
		int check = 0;
		while (state[i].id > 0 && state[i].id < 30)
		{
			if (state[i].id == line)
			{
				check = 1;
			}
			if (check != 0)
			{
				state[i]=state[i + 1];
				if(state[i].id!=0)
    				state[i].id =i+1;
			}
			i++;
		}
		state[i-1].id=0;
	}

	public final void close()
	{

	}
}
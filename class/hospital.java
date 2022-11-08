import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class hospital 
{
	private int id=0;
	private String doctor_name ="";
	private String hospital_name = "";
	public hospital()
	{
		int id = 0;
		final String doctor_name = "";
		final String hospital_name = "";
	}
	public final void get_doctor_name(String new_doc_name)
	{
		doctor_name= new_doc_name;
	}
	public hospital(int new_id, String new_doctor_name, String new_hospital_name)
	{
		id = new_id;
		doctor_name= new_doctor_name;
		hospital_name= new_hospital_name;
	}
	public final void input_hosp(int total_lines, hospital[] hosp, String doctorname, String hospitalname)
	{
		hosp[total_lines - 1].id = total_lines - 1;
		hosp[total_lines - 1].doctor_name= doctorname;
		hosp[total_lines - 1].hospital_name= hospitalname;
	}
	public final void write_hosp(int i, hospital[] hosp)
	{
	    Path filePath=Paths.get("", "", "staff.txt");
		 i = 0;
		try{
		FileWriter writer = new FileWriter("staff.txt", true);
		while (hosp[i].id > 0)
		{
			Files.writeString(filePath,String.format("|%24s|%24s |\n", hosp[i].doctor_name,hosp[i].hospital_name),StandardOpenOption.APPEND);
			i++;
		}
		}
		catch (IOException e) {
            e.printStackTrace();
        }

	}

	public final void close()
	{

	}
	public final void hosp_del(int line, hospital[] hosp)
	{
		int i = 0;
		int check = 0;
		while (hosp[i+1]!=null&&hosp[i]!=null&&hosp[i].id > 0)
		{
			if (hosp[i].id == line)
			{
				check = 1;
			}
			if (check != 0)
			{

				hosp[i]=hosp[i + 1];
				if(hosp[i].id!=0)
    				hosp[i].id =i+1;
			}
			i++;
		}
		hosp[i -1].id=0;
	}
	//Вывод данных о больнице//
public final void out_hospital(int line, hospital[] hosp)
{
	System.out.printf("|Доктор                  |Больница                 |\n");
	System.out.printf("|%24s|%24s|\n", hosp[line - 1].doctor_name, hosp[line - 1].hospital_name);
	System.out.printf("----------------------------------------------------\n");
}
}
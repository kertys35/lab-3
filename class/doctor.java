import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class doctor 
{
	private int id=0;
	private String patient_name = "";
	private String doctor_name = "";
	
	public doctor()
	{
		int id = 0;
		final String patient_name = "";
		final String doctor_name = "";
	}


	public doctor(int new_id, String new_patient_name, String new_doctor_name)
	{
		id = new_id;
		patient_name= new_patient_name;
		doctor_name= new_doctor_name;
	}

	public final void doc_del(int line, doctor[] doc)
	{
		int i = 0;
		int check = 0;
	while (doc[i+1]!=null&&doc[i]!=null&&doc[i].id > 0)
	{
		if (doc[i].id == line)
		{
			check = 1;
		}
		if (check != 0)
		{
			doc[i]=doc[i + 1];
			 if(doc[i].id!=0)
    			doc[i].id =i+1;
		}
		i++;
	}
	doc[i -1].id=0;
	}

	public final void close()
	{

	}
	public final void write_doc(int i, doctor[] doc)
	{
	    Path filePath=Paths.get("", "", "staff.txt");
		 i = 0;
		try{
		FileWriter writer = new FileWriter("staff.txt", true);
		while (doc[i].id > 0)
		{
			Files.writeString(filePath,String.format("|%24s ", doc[i].patient_name),StandardOpenOption.APPEND);
			i++;
		}
		}
		catch (IOException e) {
            e.printStackTrace();
        }

	}
	public final void input_doc(int total_lines, doctor[] doc, String doctorname, String patientname)
	{
		doc[total_lines - 1].id = total_lines - 1;
		doc[total_lines - 1].doctor_name=doctorname;
		doc[total_lines - 1].patient_name= patientname;
	}
	////Вывод данных о докторе//
public final void out_doc(int line, doctor[] doc)
{
	System.out.printf("|Пациент                  |Доктор                  |\n");
	System.out.printf("|%24s |%24s|\n",doc[line-1].patient_name,doc[line - 1].doctor_name);
	System.out.printf("----------------------------------------------------\n");
}
}
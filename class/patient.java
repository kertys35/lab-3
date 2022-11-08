import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class patient 
{
	private int id=0;
	private String name = "";
	private String diagnosis ="";
	private String state = "";
	public patient(int new_id, String new_patient_name, String new_diagnosis, String new_state)
	{
		id = new_id;
		name= new_patient_name;
		diagnosis=new_diagnosis;
		state=new_state;
	}

	public patient()
	{
		int id = 0;
		final String name = "";
		final String diagnosis = "";
		final String state = "";
	}
	public final void close()
	{

	}
	public final void out(patient[] patients)
	{
		int i = 0;
		System.out.printf("|id |ФИО пациета             |Диагноз пациента|Состояние пациента|\n");
		while (patients[i]!=null&&patients[i].id > 0)
		{
			System.out.printf("|%3d|%24s|%16s|%18s|\n", patients[i].id, patients[i].name, patients[i].diagnosis, patients[i].state);
			i++;
		}
		System.out.printf("------------------------------------------------------------------\n");
	}

	public final void input_patient(int total_lines, patient[] patients, String patientname, String illnessname, String statusname)
	{
		patients[total_lines - 1].id = total_lines;
		patients[total_lines - 1].name= patientname;
		patients[total_lines - 1].diagnosis= illnessname;
		patients[total_lines - 1].state= statusname;
	}

	//Вывод результатов в файл//
	public final void write_results(patient[] patients)
	{
		Path filePath=Paths.get("", "", "patients.txt");
		int i = 0;
		try{
		FileWriter writer = new FileWriter("patients.txt", true);
		Files.writeString(filePath,String.format("|id |ФИО пациета             |Диагноз пациента|Состояние пациента|\n"),StandardOpenOption.APPEND);
		while (patients[i].id > 0)
		{
			Files.writeString(filePath,String.format("|%3d|%24s|%16s|%18s|\n", patients[i].id, patients[i].name, patients[i].diagnosis, patients[i].state),StandardOpenOption.APPEND);
			i++;
		}
		Files.writeString(filePath,String.format("------------------------------------------------------------------\n"),StandardOpenOption.APPEND);
	}
	 catch (IOException e) {
            e.printStackTrace();
        }
	}

	public final void patient_del(int line, patient[] patients)
	{
        int i = 0, checks= 0;
        while (patients[i].id > 0)
        {
            if (patients[i].id == line)
                {
                    checks= 1;
                }
                
            if (checks==1)
            {
                patients[i].name=patients[i+1].name;
                patients[i].diagnosis=patients[i+1].diagnosis;
                patients[i].state=patients[i+1].state;
                if(patients[i].id!=0)
                    patients[i].id = i + 1;
            }
            i++;
        }
    patients[i-1].id=0;
	}
}
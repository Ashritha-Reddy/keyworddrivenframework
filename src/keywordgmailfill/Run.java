package keywordgmailfill;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Run {

	public static void main(String[] args) throws BiffException, IOException, InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File f=new File("fillgmail1.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet sh1=rwb.getSheet(0);
		int nour=sh1.getRows();
		Registrationmethods rm=new Registrationmethods();
		Method m[]=rm.getClass().getMethods();
		for(int i=1;i<nour;i++)
		{
		String l=sh1.getCell(2,i).getContents();
		String d=sh1.getCell(3,i).getContents();
		String keyword=sh1.getCell(1,i).getContents();
		for(int k=0;k<m.length;k++)
		{
			if(m[k].getName().equals(keyword))
					{
				Thread.sleep(5000);
				m[k].invoke(rm,l,d);
				
					}
		}
		}
		
		
		rwb.close();
		

	}
}




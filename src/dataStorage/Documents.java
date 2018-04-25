package dataStorage;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Documents {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String FileName;

    public static void storedinExcel(ArrayList<int[]> combinations) throws IOException {
        //�����ļ���ArrayList
        FileName=sdf.format(new Date())+".xlsx";
        FileName=FileName.replaceAll(":","-");
        FileName="F:/"+FileName;
        //�½�excel�ļ�
        XSSFWorkbook excel=new XSSFWorkbook();
        XSSFSheet sheet=excel.createSheet();
        FileOutputStream FOS=new FileOutputStream(FileName);
        excel.write(FOS);
        //��ȡExcel�ļ�
        FileInputStream FIS = new FileInputStream(FileName);
        XSSFWorkbook Excel=new XSSFWorkbook(FIS);
        XSSFSheet Sheet=Excel.getSheetAt(0);
        XSSFRow	row;
        //д������
        for(int i=0;i<combinations.size();i++){
            row=Sheet.createRow(Sheet.getLastRowNum()+1);
            for(int j=0;j<combinations.get(1).length;j++){
                XSSFCell cell=row.createCell(j);
                cell.setCellValue(combinations.get(i)[j]);
            }
        }
        //�����ļ�
        FOS=new FileOutputStream(FileName);
        Excel.write(FOS);
        FOS.close();
    }

    public static void storedinText(ArrayList<int[]> combinations) throws IOException {
        //�����ļ���
        FileName=sdf.format(new Date())+".txt";
        FileName=FileName.replaceAll(":","-");
        FileName="F:/"+FileName;
        //�����ļ�
        File file=new File(FileName);
        if(!file.exists()){
            file.createNewFile();
        }
        //���ݴ���
        FileWriter FW=new FileWriter(file);
        for(int i=0;i<combinations.size();i++){
            for(int j=0; j<combinations.get(0).length;j++){
                FW.write(Integer.toString(combinations.get(i)[j])+";");
            }
            FW.write("\r\n");
        }
        FW.close();
    }

}

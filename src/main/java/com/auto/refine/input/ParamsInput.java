package com.auto.refine.input;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.TreeMap;

public class ParamsInput {
    public TreeMap<String,String> Param(String excelPath)  {

        //excel文件路径
        //String excelPath = "res\\refundParams.xlsx";
        TreeMap<String,String> map=new TreeMap();
        Workbook wb=null;
        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在


                FileInputStream is=new FileInputStream(excelPath);
                if (excel.getName().endsWith("xls")){
                    wb = new HSSFWorkbook(is);
                }else if (excel.getName().endsWith("xlsx")){
                    wb = new XSSFWorkbook(is);
                }else {
                    System.out.println("文件类型错误!");

                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                //遍历行
                Row firstrow = sheet.getRow(0);
                Row row = sheet.getRow(1);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    for (int i = firstCellIndex; i < lastCellIndex; i++) {   //遍历列
                        Cell firstRowCell=firstrow.getCell(i);
                        Cell cell = row.getCell(i);

                        map.put(firstRowCell.getStringCellValue(),cell.getStringCellValue());
                    }
                }

            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
        return map;

    }

}

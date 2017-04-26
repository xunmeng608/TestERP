package com.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class Excel{
    public Workbook workbook;
    public Sheet sheet;
    public Cell cell;
    int rows;
    int columns;
    public String fileName;
    public String caseName;
    public ArrayList<String> arrkey = new ArrayList<String>();
    String sourceFile;

    /**
     * @param fileName   excel�ļ���
     * @param caseName   sheet��
     */
    public Excel(String fileName, String caseName) {
        super();
        this.fileName = fileName;
        this.caseName = caseName;
    }

    /**
     * ���excel���е�����
     */
    public Object[][] getExcelData() throws BiffException, IOException {

        workbook = Workbook.getWorkbook(new File(getPath()));
        sheet = workbook.getSheet(caseName);
        rows = sheet.getRows();
        columns = sheet.getColumns();
        // Ϊ�˷���ֵ��Object[][],����һ�����е��еĶ�ά����
        HashMap<String, String>[][] arrmap = new HashMap[rows - 1][1];
        // ������������Ԫ��hashmap���г�ʼ��
        if (rows > 1) {
            for (int i = 0; i < rows - 1; i++) {
                arrmap[i][0] = new HashMap<>();
            }
        } else {
            System.out.println("excel��û������");
        }

        // ������е���������Ϊhashmap��keyֵ
        for (int c = 0; c < columns; c++) {
            String cellvalue = sheet.getCell(c, 0).getContents();
            arrkey.add(cellvalue);
        }
        // �������еĵ�Ԫ���ֵ��ӵ�hashmap��
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                String cellvalue = sheet.getCell(c, r).getContents();
                arrmap[r - 1][0].put(arrkey.get(c), cellvalue);
            }
        }
        return arrmap;
    }

    /**
     * ���excel�ļ���·��
     * @return
     * @throws IOException
     */
    public String getPath() throws IOException {
        File directory = new File(".");
        sourceFile = directory.getCanonicalPath() + "\\libs\\"
                + fileName + ".xls";
        return sourceFile;
    }

}

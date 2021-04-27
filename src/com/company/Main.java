package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        readFile("C:\\Users\\ADMIN\\Documents\\Codegym\\MD2\\md2-w2\\IO-TextInFile\\abc.txt");
        searchMax();
        newFile(searchMax());
    }





    public static List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
              numbers.add(Integer.parseInt(line));
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }

        return numbers;
    }
    public static int searchMax(){
       List<Integer> maxArrays = readFile("C:\\Users\\ADMIN\\Documents\\Codegym\\MD2\\md2-w2\\IO-TextInFile\\abc.txt");
        int max = maxArrays.get(0);
        for (int i = 0;  i < maxArrays.size() ; i++) {
            if(maxArrays.get(i) > max){
                max = maxArrays.get(i);
            }
        }
        System.out.println("Max la " + max);
        return max;
    }
    public static void newFile(int max){
        try {
            FileOutputStream fileMax = new FileOutputStream("C:\\Users\\ADMIN\\Documents\\Codegym\\MD2\\md2-w2\\IO-TextInFile\\abc.txt");
            OutputStreamWriter our = new OutputStreamWriter(fileMax);
            BufferedWriter br = new BufferedWriter(our);
            String ghi= "max la "+max;
            br.write(ghi);
            br.close();
            fileMax.close();
            our.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

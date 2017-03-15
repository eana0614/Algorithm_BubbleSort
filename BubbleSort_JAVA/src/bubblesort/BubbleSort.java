package bubblesort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BubbleSort {

	private static int arrayLength = 1000;
	
	public static void main(String[] args) {
		
		String filePath = "random.txt";
		String fileName = "java bubble sort.txt";
		
		int[] readArray;
		
		try {
			
			readArray = readInputFile(filePath);
			int[] sortedArray = bubblesort(readArray);
			writeSortedFile(fileName, sortedArray);
			
			System.out.println("DONE");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static int[] bubblesort(int[] readArray) {
		for(int i=1; i<readArray.length; i++){
			for(int j=0; j < readArray.length-1; j++){
				if(readArray[j] > readArray[j+1]){
					int temp = readArray[j];
					readArray[j] = readArray[j+1];
					readArray[j+1] = temp;
				}
			}
		}
		return readArray;
	}

	private static void writeSortedFile(String fn, int[] array) throws IOException{
		File ouputFile = new File(fn);
		FileOutputStream fos = new FileOutputStream(ouputFile);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		for(int i=0; i<array.length; i++){
			bw.write(String.valueOf(array[i]));
			bw.newLine();
		}
		
		bw.close();
		osw.close();
		fos.close();
	}

	private static int[] readInputFile(String filePath) throws IOException   {
		File inputFile = new File(filePath);
		FileInputStream fis = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		int[] tempArray = new int[arrayLength];
		
		String s;
		int i=0;
		
		while((s = br.readLine())!=null){
			tempArray[i]= Integer.parseInt(s);
			i++;
		}
		
		br.close();
		isr.close();
		fis.close();
		
		return tempArray;
	}

}

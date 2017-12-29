package com.kun.deploy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class DeployResult {

	public static void saveResult(int result) {
		String data = (new Date()).toLocaleString() + " " +result;
		File file = new File("result.txt");
		FileWriter fWriter =null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fWriter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fWriter);
			bufferWritter.newLine();
            bufferWritter.write(data);
            bufferWritter.flush();
            bufferWritter.close();
            System.out.println("保存结果成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("保存结果失败！");
			e.printStackTrace();
		}finally{
			if(fWriter !=null){
				try {
					fWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

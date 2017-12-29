package com.kun.deploy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class DeployTest {
	
	@Test
	public void TestDoDeploy() throws InterruptedException {
		Deploy dp = new Deploy();
		dp.dodeploy("test");
	}
	
	@Test
	public void cmd() {
		try {
			//String aString = "cmd /c start cmd.exe /k pwd ";
			String pathCmd = "cmd /k  cd  F:/webapp/webapp/test";
			String aString = "cmd /k  git log ";
			Runtime runtime = Runtime.getRuntime();
			Process p =runtime.exec( "cmd /k  f:");
			//Process p1 =runtime.exec("cmd /k  dir ");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));   
            String readLine = br.readLine();   
            while (readLine != null) { 
                readLine = br.readLine(); 
                System.out.println(readLine); 
            } 
            if(br!=null){ 
                br.close(); 
            } 
            p.destroy(); 
            p=null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

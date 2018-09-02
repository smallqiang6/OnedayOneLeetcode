package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BCompare {

	public static void main(String[] args) throws InterruptedException {  
        Runtime runtime = Runtime.getRuntime();  
        String cmdfindid = "whoami /user";  
        try {  
            BufferedReader input = new BufferedReader(new InputStreamReader(runtime.exec(cmdfindid).getInputStream()));  
            String line = null;  
            String b = "";  
            while ((line = input.readLine()) != null) {  
                b = line;  
            }  
            String[] SID = b.split(" ");  
            String break_cmd = "reg delete \"HKEY_USERS\\" + SID[1]  
                    + "\\Software\\Scooter Software\\Beyond Compare 4\" /v CacheId /f";  
            System.out.println(break_cmd);  
            runtime.exec(break_cmd);  
        }  
        catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
    }  

}

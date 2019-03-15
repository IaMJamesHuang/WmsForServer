package com.kt.james.wmsforserver.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class RuntimeCore {

    public static String execAutoSalePython() {
        Process process = null;
        FileInputStream in = null;
        StringBuilder result = new StringBuilder();
        try {
            Properties pro = new Properties();
            in = new FileInputStream(RuntimeCore.class.getResource("/").getPath()+"python.properties");
            pro.load(in);
            in.close();
            String command = pro.getProperty("auto_sale_script_path");
            process = Runtime.getRuntime()
                    .exec(command);
            BufferedReader stdOut=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s=stdOut.readLine())!=null){
                result.append(s);
                System.out.println(s);
            }
            int re = process.waitFor();
            System.out.println(re);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }

}

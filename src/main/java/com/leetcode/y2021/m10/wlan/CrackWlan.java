package com.leetcode.y2021.m10.wlan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author duwenlei
 **/
public class CrackWlan {


    public static void main(String[] args) throws IOException {
        try {
            Process exec = Runtime.getRuntime().exec("netsh wlan show networks mode=bssid");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "GBK"));

            List<String> result = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }

            result.stream().forEach(System.out::println);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要破解的 WIFI 名称：");
        String wifiName = sc.next();
        System.out.println("开始尝试破解 wifi 名称为【" + wifiName + "】的热点。");


        // ------------ 开始破解 --------------

        String wifiPwd = "12345678";

        // 1. 生成 wifi xml 文件

        String ssidHex = str2HexStr(wifiName);

        String wifiXml = genWifiXml(wifiName, ssidHex, wifiPwd);

        // 2. 写入本地项目中

        try {
            FileOutputStream outputStream = new FileOutputStream("temp.xml");
            outputStream.write(wifiXml.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 增加配置文件
        Process process = Runtime.getRuntime().exec("netsh wlan add profile filename=temp.xml", null, new File("./"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // 4. 连接 "netsh wlan connect name=\""+ssid+"\"","./"
        Process process1 = Runtime.getRuntime().exec("netsh wlan connect name=\"" + wifiName + "\"", null, new File("./"));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream(), "GBK"));
        String line1;
        while ((line1 = reader1.readLine()) != null) {
            System.out.println(line1);
        }
        reader1.close();
    }


    /**
     * 获得wifi配置文件字符串
     *
     * @param wifiName
     * @param hex
     * @param wifiPwd
     * @return
     */
    public static String genWifiXml(String wifiName, String hex, String wifiPwd) {
        return "<?xml version=\"1.0\"?>" +
                "<WLANProfile xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v1\">" +
                "<name>" + wifiName + "</name>" +
                "<SSIDConfig>" +
                "<SSID>" +
                "<hex>" + hex + "</hex>" +
                "<name>" + wifiName + "</name>" +
                "</SSID>" +
                "</SSIDConfig>" +
                "<connectionType>ESS</connectionType>" +
                "<connectionMode>auto</connectionMode>" +
                "<MSM>" +
                "<security>" +
                "<authEncryption>" +
                "<authentication>WPA2PSK</authentication>" +
                "<encryption>AES</encryption>" +
                "<useOneX>false</useOneX>" +
                "</authEncryption>" +
                "<sharedKey>" +
                "<keyType>passPhrase</keyType>" +
                "<protected>false</protected>" +
                "<keyMaterial>" + wifiPwd + "</keyMaterial>" +
                "</sharedKey>" +
                "</security>" +
                "</MSM>" +
                "<MacRandomization xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v3\">" +
                "<enableRandomization>false</enableRandomization>" +
                "</MacRandomization>" +
                "</WLANProfile>";
    }

    /**
     * 字符串转换成为16进制(无需Unicode编码)
     *
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }
}

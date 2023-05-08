package com.onething.dc;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassPath: com.onething.dc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2022/12/8
 */
public class HttpUtils {
    public static int num = 0;
    public static String split_str = " : ";

    public static String requestK8sApi(String ip, int iplenth) {
        HttpClient client = HttpClients.createDefault();

        String urlWithIp = String.format("http://127.0.0.1:8887/schedule/node/list?ip=%s", ip);
        // 要调用的接口方法
        HttpGet httpGet = new HttpGet(urlWithIp);

        try {
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtils.toString(response.getEntity());
//                    System.out.println(i + result);
                num++;
                if (num == iplenth) {
                    Thread.sleep(100);
                }
                return num + split_str + ip + split_str + result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

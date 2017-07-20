package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zuoxiao
 * on 2017/6/23.
 */
public class Spider {
    private static String getInformation(String url){
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            URL newUrl = new URL(url);
            URLConnection urlConnection = newUrl.openConnection();
            urlConnection.connect();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String lineStr;
            while ((lineStr = bufferedReader.readLine())!=null){
                result.append(lineStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
    //获取知乎类
    private static ArrayList<Zhihu> regexString(String src){
        ArrayList<Zhihu> resultList= new ArrayList<>();
        Pattern questionPattern = Pattern.compile("question_link.+?>(.+?)<");
        Matcher questionMatcher = questionPattern.matcher(src);

        Pattern urlPattern = Pattern.compile("question_link.+?href=\"(.+?)\"");
        Matcher urlMatcher = urlPattern.matcher(src);
        Boolean isFind = questionMatcher.find()&&urlMatcher.find();
        while (isFind){
            Zhihu zhihuTemp = new Zhihu();
            zhihuTemp.setQuestion(questionMatcher.group(1));
            zhihuTemp.setUrl("http://www.zhihu.com"+urlMatcher.group(1));
            resultList.add(zhihuTemp);
            isFind = questionMatcher.find() && urlMatcher.find();
        }
        return resultList;
    }

    public static void main(String[] args){
// 定义即将访问的链接
        String url = "https://www.Zhihu.com/explore/recommendations";
        // 访问链接并获取页面内容
        String result = getInformation(url);
        ArrayList<Zhihu> pictureURL = regexString(result);
        for (Zhihu question : pictureURL) {
            System.out.println(question.toString());
        }
    }
}

package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> courseName= new ArrayList<>();
        courseName.add("Selenium");
        courseName.add("RestAssured");
        courseName.add("Appium");
        List<String> date=new ArrayList<>();
        date.add("12-23-1990");
        date.add("23-12-1990");
        date.add("12-12-1990");
        List<Integer> amount= new ArrayList<>();
        amount.add(120);
        amount.add(49);
        amount.add(110);
        List<String> location= new ArrayList<>();
        location.add("US");
        location.add("UK");
        location.add("India");

        List<CustomerInfo> customerInfo = new ArrayList<>();

        try {
          for (int i=0; i<courseName.size(); i++){
              CustomerInfo customerInfo1 = new CustomerInfo();
                customerInfo1.setCourseName(courseName.get(i));
                customerInfo1.setPurchaseDate(date.get(i));
                customerInfo1.setAmount(amount.get(i));
                customerInfo1.setLocation(location.get(i));

              customerInfo.add(customerInfo1);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JSONArray jsonArray = new JSONArray();
          for (int j=0; j<customerInfo.size(); j++) {
              objectMapper.writeValue(
                      new File("C:\\Users\\Sourabh\\IdeaProjects\\Maven Project\\jsonResult" + j + ".json"),
                      customerInfo.get(j)
              );
              Gson gson = new Gson();
              String jsonResquest= gson.toJson(customerInfo.get(j));
              jsonArray.add(jsonResquest);
          }



          JSONObject jsonObject = new JSONObject();
          jsonObject.put("data",jsonArray);
          System.out.println(jsonObject.toJSONString());
            String unescapedResult= StringEscapeUtils.unescapeJava(jsonObject.toJSONString());
            System.out.println(unescapedResult);
            String Result= unescapedResult.replace("\"{","{");
            Result= Result.replace("}\"","}");
            System.out.println(Result);

            JSONParser parser = new JSONParser();
            JSONObject jsonWrite = (JSONObject) parser.parse(Result);
            objectMapper.writeValue(
                    new File("C:\\Users\\Sourabh\\IdeaProjects\\Maven Project\\jsonResults.json"),
                    jsonWrite);

            ObjectMapper jsonRead = new ObjectMapper();
            CustomerInfo customerInfo1 = jsonRead.readValue(
                    new File("C:\\Users\\Sourabh\\IdeaProjects\\Maven Project\\jsonResult1.json"),
                    CustomerInfo.class
            );

            System.out.println(customerInfo1.getCourseName());
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
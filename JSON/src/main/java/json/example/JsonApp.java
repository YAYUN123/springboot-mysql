/*
package json.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import json.example.entity.A_objects;
import json.example.entity.Image;
import json.example.entity.Q_objects;
import json.example.entity.Qas;


public class JsonApp {

    public static void main(String[] args) {
        for (int i = 0; i < 201; i++) {
            String path = "C:\\Users\\戴尔\\Desktop\\question_answers\\after_deal\\" + i + ".json";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(path));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    //处理第一条json
                    if(i==0){
                        String newline = line.substring(0, line.length()-1)+"]";
                        handle(newline);
                    }
                    //处理最后一条json
                    else if(i==200){
                        String newline = "["+line;
                        handle(newline);
                    }
                    //处理中间的json
                    else{
                        String newline = "["+line.substring(0, line.length()-2)+"]";
                        handle(newline);
                        }
                }
                bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (JSONException j1){
                j1.printStackTrace();
            }
        }
    }

    public static void handle(String line){
        //处理最外层的array（字符串转成json数组）
        JSONArray jsonArray = JSONArray.parseArray(line);
        for(int i=0; i<jsonArray.size(); i++){
            //处理每一个数组的元素
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String id = jsonObject.getString("id");
            Image image = new Image();
            image.setId(id);
            List<Qas> qasList = new ArrayList<>();
            Qas qas = new Qas();

            //处理内部qas数据
           JSONArray jsonArray1 = jsonObject.getJSONArray("qas");
           for(int j=0; j<jsonArray1.size(); j++) {
               JSONObject jsonObject1 = jsonArray1.getJSONObject(j);

               String question = jsonObject1.getString("question");
               String image_id = jsonObject1.getString("image_id");
               String qa_id = jsonObject1.getString("qa_id");
               String answer = jsonObject1.getString("answer");
               qas.setAnswer(answer);
               qas.setImage_id(image_id);
               qas.setQa_id(qa_id);
               qas.setQuestion(question);

               //处理a_objects and p_objects
               JSONArray jsonArray2 = jsonObject1.getJSONArray("a_objects");
               JSONArray jsonArray3 = jsonObject1.getJSONArray("q_objects");
               if(jsonArray2.isEmpty()){
                   List<A_objects> a_objectsList = JSONObject.parseArray(jsonArray2.toJSONString(),A_objects.class);
                   a_objectsList = null;
                   qas.setA_objectsList(a_objectsList);
               }
               if(jsonArray3.isEmpty()){
                   List<Q_objects> q_objectsList = JSONObject.parseArray(jsonArray3.toJSONString(),Q_objects.class);
                   q_objectsList = null;
                   qas.setQ_objectsList(q_objectsList);
               }
           }
           qasList.add(qas);
        }
    }
}
*/

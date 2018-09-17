package json.example;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import json.example.config.JpaConfiguration;
import json.example.entity.Qas;
import json.example.repository.QasRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class JsonTest {
    private static Logger logger = LoggerFactory.getLogger(JsonTest.class);

   @Autowired
   QasRepository qasRepository;

    @Test
    public void initData(){
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

    public void handle(String line){
        //处理最外层的array（字符串转成json数组）
        JSONArray jsonArray = JSONArray.parseArray(line);
        for(int i=0; i<jsonArray.size(); i++){
            //处理每一个数组的元素
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            //处理内部qas数据
            JSONArray jsonArray1 = jsonObject.getJSONArray("qas");
            for(int j=0; j<jsonArray1.size(); j++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                Qas qas = new Qas();
                String question = jsonObject1.getString("question");
                String image_id = jsonObject1.getString("image_id");
                Long image_id2 = Long.parseLong(image_id);
                String qa_id = jsonObject1.getString("qa_id");
                Long qa_id2 = Long.parseLong(qa_id);
                String answer = jsonObject1.getString("answer");
                qas.setAnswer(answer);
                qas.setImage_id(image_id2);
                qas.setQa_id(qa_id2);
                qas.setQuestion(question);

                //处理a_objects and p_objects
                JSONArray jsonArray2 = jsonObject1.getJSONArray("a_objects");
                JSONArray jsonArray3 = jsonObject1.getJSONArray("q_objects");
                String aobjects = jsonArray2.toString();
                String qobjects = jsonArray3.toString();
                if(jsonArray2.isEmpty()){
                    aobjects = null;
                }
                qas.setA_objects(aobjects);
                if(jsonArray3.isEmpty()){
                    qobjects = null;
                }
                qas.setQ_objects(qobjects);
                qasRepository.save(qas);
            }
        }
    }

}

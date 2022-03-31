import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class JsonTest {

    // 读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");

            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeJsonFile(Object jsonData, String fileName) {
        //String content = JSON.toJSONString(jsonData, SerializerFeature.PrettyFormat,
                //SerializerFeature.WriteMapNullValue,
                //SerializerFeature.WriteDateUseDateFormat);
        try {
            File jsonFile = new File(fileName);
            Writer write = new OutputStreamWriter(new FileOutputStream(jsonFile), StandardCharsets.UTF_8);

            write.write(jsonData.toString());
            write.flush();
            write.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String path = JsonTest.class.getClassLoader().getResource("database.json").getPath();
        String s = readJsonFile(path);
        JSONObject jobj = JSON.parseObject(s);
        JSONArray user = jobj.getJSONArray("DATABASES");// 构建JSONArray数组

        //? ADDING OR Wtite to json
        JSONObject js_new = new JSONObject();
        js_new.put("Id", "4");
        js_new.put("password", "12345678");
        js_new.put("tags", "Customer");
        //System.out.println("js_new:" + js_new);
        //user.add(js_new);


        for (int index = 0; index < user.size(); index++) {
            JSONObject key = (JSONObject) user.get(index);

            String Id = (String) key.get("Id");
            String password = (String) key.get("password");
            String tags = (String) key.get("tags");

            System.out.println(Id);
            System.out.println(password);
            System.out.println(tags);
            System.out.println();
        }
        
        //System.out.println(writeJsonFile(user, path));

    }
}
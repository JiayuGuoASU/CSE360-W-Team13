import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.io.FileOutputStream;

public class JsonTest {

    // Read json file
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

    // Write json file
    public static boolean writeJsonFile(Object jsonData, String fileName) {

        try {
            File jsonFile = new File(fileName);
            Writer write = new OutputStreamWriter(new FileOutputStream(jsonFile), "utf-8");
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
        JSONArray user = jobj.getJSONArray("DATABASES");
        JSONObject jobj_new = new JSONObject();

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
        // Adding more to json
        JSONObject js_new = new JSONObject();
        js_new.put("Id", "4");
        js_new.put("password", "12345678");
        js_new.put("tags", "Customer");
        // System.out.println("js_new:" + js_new);
        user.add(js_new);

        
        // populate the array
        jobj_new.put("DATABASES", user);
        System.out.println(writeJsonFile(jobj_new, "src/data1.json"));

        // print
        String formatStr = JSON.toJSONString(jobj_new, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        // System.out.println(formatStr);
    }
}
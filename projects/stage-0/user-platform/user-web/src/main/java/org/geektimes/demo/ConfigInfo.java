package org.geektimes.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class ConfigInfo implements ConfigInfoMBean {


    public static void main(String[] args) {
        Set<String> set = new HashSet();
        set.add("智能驾驶事业群组_车联网_车内图像识别#91#;GPU;v100-32g");
        set.add("智能驾驶事业群组_自动驾驶技术_自动驾驶技术（国内）#99#;GPU;v100-32g");
        set.add("智能驾驶事业群组_自动驾驶技术_自动驾驶技术（国内）#99#;GPU;k40-12g");
        set.add("智能驾驶事业群组_自动驾驶技术_探路者#1420#;GPU;v100-16g");
        set.add("智能驾驶事业群组_自动驾驶技术_探路者#1420#;GPU;p40-24g");
        List<String> tmp = new ArrayList<>(set);
        set.clear();
        for (String s : tmp) {
            String[] split = s.split(";");
            String s1 = split[0];
            int i = s1.indexOf("#");
            String substring = s.substring(0, i);
            for (int i1 = 1; i1 < split.length; i1++) {
                substring += ";" + split[i1];
            }
            set.add(substring);
        }

        System.out.println(JSONObject.toJSONString(set));

    }
}

import java.util.*;

public class LC49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        // 确定什么作为key
        for(String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String strTemp = new String(temp);
            System.out.println(strTemp);
            if (!map.containsKey(strTemp)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(strTemp, list);
            } else {
                List<String> strings = map.get(strTemp);
                strings.add(str);
            }
        }
        List<List<String>> values = new ArrayList<>();
        for(String key : map.keySet()) {
            values.add(map.get(key));
        }
        return values;
    }
}

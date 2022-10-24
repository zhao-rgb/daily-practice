package com.zxl.dailypractice.project.util;

import com.google.gson.*;
import com.zxl.dailypractice.project.exception.WformException;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author: zhaoxl
 * @date: 2022/10/21
 * @desc: Infomation: 对象比较工具 避免程序中重复写冗长的比较代码
 **/
public class ObjectUtil {
    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isNullObject(Object obj) {
        return obj == null;
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection collection) {
        return isNullObject(collection) || collection.size() == 0;
    }

    /**
     * 判断map对象是否为空
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map map) {
        return isNullObject(map) || map.isEmpty();
    }

    /**
     * 判断对象为空或等于空字符串
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return isNullObject(obj) || obj.equals("");
    }

    /**
     * 判断对象为空或等于空字符串或等于0
     *
     * @param obj
     * @return
     */
    public static boolean isEmptyOrEqualsZero(Object obj) {
        return isEmpty(obj) || obj.equals("0");
    }

    /*
     * 如果对象为空就返还null''，否者返回数值 @gv obj @return
     */

    public static Integer toInt(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Integer.valueOf(toStr(obj));
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * 如果对象为空就返还字符串''，否者返回对象值 @gv obj @return
     */

    public static String toStr(Object obj) {
        if (obj == null) {
            return "";
        }
        return String.valueOf(obj);
    }

    /*
     * 对象转换成JSON字符串 @gv obj @return
     */

    public static String toJsonStr(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static JsonObject toJsonObject(File f) throws WformException {
        JsonObject jsonObject = null;
        try {
            InputStream is = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            JsonStreamParser parser = new JsonStreamParser(br);
            while (parser.hasNext()) {
                JsonElement element = parser.next();
                if (element.isJsonArray()) {
                    jsonObject = element.getAsJsonObject();
                }
            }
        } catch (FileNotFoundException e) {

            throw new WformException("JSON没找到文件!");

        }
        return jsonObject;
    }

    /**
     * 字符串转换成json object
     *
     * @param str
     * @return
     * @throws WformException
     */
    public static JsonObject toJsonObject(String str)
            throws WformException {
        JsonObject jsonObject = null;
        try {
            JsonStreamParser parser = new JsonStreamParser(str);
            while (parser.hasNext()) {
                JsonElement element = parser.next();
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                }
            }
        } catch (Exception e) {
            throw new WformException("字符串：" + str + " 转换成JsonObject出错");
        }
        return jsonObject;
    }

    public static JsonArray toJsonArray(File f) throws WformException {
        JsonArray jsonArray = null;
        try {
            InputStream is = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            JsonStreamParser parser = new JsonStreamParser(br);
            while (parser.hasNext()) {
                JsonElement element = parser.next();
                if (element.isJsonArray()) {
                    jsonArray = element.getAsJsonArray();
                }
            }
        } catch (FileNotFoundException e) {

            throw new WformException("JSON没找到文件!");

        }
        return jsonArray;
    }

    /**
     * 字符串转换成json array
     *
     * @param str
     * @return
     * @throws WformException
     */
    public static JsonArray toJsonArray(String str) throws WformException {
        JsonArray jsonArray = null;
        try {
            JsonStreamParser parser = new JsonStreamParser(str);
            while (parser.hasNext()) {
                JsonElement element = parser.next();
                if (element.isJsonArray()) {
                    jsonArray = element.getAsJsonArray();
                }
            }
        } catch (WformException e) {
            throw new WformException("字符串：" + str + " 转换成JsonArray出错");
        }
        return jsonArray;
    }

    /*
     * request的值转换为Map @gv obj @return
     */

    public static Map<String, Object> requestToMap(
            final HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> map = new HashMap<String, Object>();
        for (String key : parameterMap.keySet()) {
            String[] value = parameterMap.get(key);
            if (value != null && value.length == 1) {
                map.put(key, value[0]);
            } else {
                map.put(key, value);
            }
        }
        return map;
    }


    // 把数组字符串转换为 “，”隔开的字符串并且有"'" 引号引起来的 查询使用

    public static String arrToStr(String[] idArr) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (String id : idArr) {
            if (isEmpty(id)) {
                continue;
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append("'").append(id).append("'");
            i++;
        }
        return sb.toString();
    }

    // 在后台翻译 有对象数据的列表

    public static void parseListObject(String titles, List<Map> data)
            throws WformException {
        String[] fieldStr = titles.split(",");
        String objectKey;
        String fieldKey;
        int idx;
        Map<String, Set> objectMap = new HashMap();
        Map<String, StringBuffer> childValMapSb = new HashMap();
        Map childObjectMap = new HashMap();
        int isAdd = 0;
        for (String str : fieldStr) {
            idx = str.indexOf(".");
            if (idx > -1) {
                objectKey = str.substring(0, idx);
                fieldKey = str.substring(idx + 1);
                if (ObjectUtil.isEmpty(objectMap.get(objectKey))) {
                    Set<String> fieldSet = new HashSet();
                    fieldSet.add(fieldKey);
                    objectMap.put(objectKey, fieldSet);
                } else {
                    objectMap.get(objectKey).add(fieldKey);
                }

            }
        }
        if (objectMap.keySet().size() == 0) {
            return;
        }

        // 对象级的数据 转换成
        for (Map resultMap : data) {
            childValMapSb = new HashMap();
            for (String objectKey1 : objectMap.keySet()) {
                Object f_val = resultMap.get(objectKey1);
                Set<String> childFieldSet = objectMap.get(objectKey1);
                if (f_val instanceof Map) {

                } else if (f_val instanceof List) {

                    for (Object o_map : (List) f_val) {
                        // 初始化
                        childObjectMap = (Map) o_map;
                        isAdd = 0;
                        for (String childFName : childFieldSet) {
                            String realFieldVal = objectKey1 + "." + childFName;
                            if (ObjectUtil.isEmpty(childValMapSb
                                    .get(realFieldVal))) {
                                childValMapSb.put(realFieldVal,
                                        new StringBuffer());
                            }
                            if (isAdd > 0
                                    && !ObjectUtil.isEmpty(childObjectMap
                                    .get(realFieldVal))) {
                                childValMapSb.get(realFieldVal).append(",");
                                isAdd++;
                            }
                            // 这里可能还要支持数据字典
                            if (ObjectUtil.isEmpty(childObjectMap
                                    .get(childFName))) {
                                continue;
                            } else {
                                childValMapSb.get(realFieldVal).append(
                                        childObjectMap.get(childFName));

                            }
                        }

                    }
                }
            }
            // 重新回写 按照规则 ddd.aaa
            for (String keyChildName : childValMapSb.keySet()) {
                resultMap.put(keyChildName, childValMapSb.get(keyChildName)
                        .toString());
            }
        }

    }
    /**
     * 数据合并
     * @param al
     * @param bl
     * @return
     */
    public static String[] getMergeArray(String[] al, String[] bl) {
        String[] a = al;
        String[] b = bl;
        String[] c = new String[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    /**
     * 分组函数
     *
     * @param groupFields
     *	分组字段
     * @param sumFields
     *  合计字段
     * @param avgFields
     *	平均值字段
     * @return
     */
    public static List<Map<String, Object>> group(List<Map<String, Object>> datas,
                                                  String[] groupFields, String[] sumFields, String[][] avgFields) {
        return group(datas, groupFields, sumFields, avgFields, null);
    }
    /**
     * 分组函数
     *
     * @param groupFields
     *	分组字段
     * @param sumFields
     *  合计字段
     * @param avgFields
     *	平均值字段
     * @return
     */
    public static Map<String, Object> groupMap(List<Map<String, Object>> datas,
                                               String[] groupFields, String[] sumFields, String[][] avgFields) {
        return groupMap(datas, groupFields, sumFields, avgFields, null);
    }
    /**
     * 分组函数
     *
     * @param groupFields
     *            分组字段
     * @param sumFields
     *            　 合计字段
     * @param avgFields
     *            平均值字段
     * @param countField
     *            分组后的count新字段
     * @return
     */
    public static List<Map<String, Object>> group(List<Map<String, Object>> datas,
                                                  String[] groupFields, String[] sumFields, String[][] avgFields,
                                                  String countField) {
        Map<String, Object> temp = new HashMap<String, Object>();
        for (Map<String, Object> data : datas) {
            String groupFieldKey = "";
            for (String groupField : groupFields) {
                // code@name_ 即 code@001|name@test| code@003|name@test1|
                groupFieldKey += groupField + "@" + data.get(groupField) + "|";
            }
            // 算分组合计
            groupSum(sumFields, temp, data, groupFieldKey);
            // 统计分组行数
            countField = groupCount(countField, temp, groupFieldKey);
            // 计算平均
            if(avgFields!=null) {
                groupAvg(avgFields, countField, temp, groupFieldKey);
            }
        }
        // 转换结果
        List<Map<String, Object>> results = covertResult(temp);
        return results;
    }

    /**
     * 分组函数
     *
     * @param groupFields
     *            分组字段
     * @param sumFields
     *            　 合计字段
     * @param avgFields
     *            平均值字段
     * @param countField
     *            分组后的count新字段
     * @return
     */
    public static Map<String, Object> groupMap(List<Map<String, Object>> datas,
                                               String[] groupFields, String[] sumFields, String[][] avgFields,
                                               String countField) {
        Map<String, Object> temp = new HashMap<String, Object>();
        String groupFieldMapKey = "";
        for (Map<String, Object> data : datas) {
            String groupFieldKey = "";
            for (String groupField : groupFields) {
                // code@name_ 即 code@001|name@test| code@003|name@test1|
                groupFieldKey += groupField + "@" + data.get(groupField) + "|";
                groupFieldMapKey+=data.get(groupField);
            }
            // 算分组合计
            groupSum(sumFields, temp, data, groupFieldKey);
            // 统计分组行数
            countField = groupCount(countField, temp, groupFieldKey);
            // 计算平均
            if(avgFields!=null)
                groupAvg(avgFields, countField, temp, groupFieldKey);
        }
        // 转换结果
        Map<String, Object> results = covertResult(temp, groupFields);
        return results;
    }

    private static void groupAvg(String[][] avgFields, String countField,
                                 Map<String, Object> temp, String groupFieldKey) {
        for (int i = 0; i < avgFields.length; i++) {
            for (int j = 0; j < avgFields.length; j++) {
                double value = (Double) temp.get(groupFieldKey
                        + avgFields[i][0]);
                int count = (Integer) temp.get(groupFieldKey + countField);
                temp.put(groupFieldKey + avgFields[i][1], value / count);
            }
        }
    }

    /**
     * 统计分组后的条数
     *
     * @param countField
     * @param temp
     * @param groupFieldKey
     */
    private static String groupCount(String countField, Map<String, Object> temp,
                                     String groupFieldKey) {
        if (countField == null || countField.trim().equals("")) {
            countField = "&count";
        }
        String countFieldKey = groupFieldKey + countField;
        if (temp.containsKey(countFieldKey)) {
            temp.put(countFieldKey,
                    Integer.parseInt(temp.get(countFieldKey).toString()) + 1);
        } else {
            temp.put(countFieldKey, 1);
        }
        return countField;
    }

    /**
     * 将temp中的key value 转换为List<Map<String,Object>>对像
     *
     * @param temp
     * @return
     */
    private static List<Map<String, Object>> covertResult(Map<String, Object> temp) {
        Map<String, Object> values = new HashMap<String, Object>();
        for (String key : temp.keySet()) {
            if (!values.containsKey(key.substring(0, key.lastIndexOf("|")))) {
                // code@001|name@test|quantity@10
                values.put(key.substring(0, key.lastIndexOf("|")), key + "@"
                        + temp.get(key));
                continue;
            }
            for (String rk : values.keySet()) {
                if (key.startsWith(rk)) {
                    // code@001|name@test|quantity@10|amount@20
                    values.put(
                            rk,
                            values.get(rk)
                                    + key.substring(key.lastIndexOf("|")) + "@"
                                    + temp.get(key));
                    break;
                }
            }
        }
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        Map<String, Object> result;
        for (Object key : values.values()) {
            result = new HashMap<String, Object>();
            String ss[] = key.toString().split("\\|");
            for (String t : ss) {
                String[] ts = t.split("@");
                result.put(ts[0], ts[1]);
            }
            results.add(result);
        }
        return results;
    }
    /**
     * 将temp中的key value 转换为Map<String,Object>对像
     *
     * @param temp
     * @return
     */
    private static Map<String, Object> covertResult(Map<String, Object> temp,String[] groupFields) {
        Map<String, Object> values = new HashMap<String, Object>();
        for (String key : temp.keySet()) {
            if (!values.containsKey(key.substring(0, key.lastIndexOf("|")))) {
                // code@001|name@test|quantity@10
                values.put(key.substring(0, key.lastIndexOf("|")), key + "@"
                        + temp.get(key));
                continue;
            }
            for (String rk : values.keySet()) {
                if (key.startsWith(rk)) {
                    // code@001|name@test|quantity@10|amount@20
                    values.put(
                            rk,
                            values.get(rk)
                                    + key.substring(key.lastIndexOf("|")) + "@"
                                    + temp.get(key));
                    break;
                }
            }
        }
        Map<String, Object> results = new HashMap<String, Object>();
        Map<String, Object> result;
        for (Object key : values.values()) {
            result = new HashMap<String, Object>();
            String ss[] = key.toString().split("\\|");
            for (String t : ss) {
                String[] ts = t.split("@");
                result.put(ts[0], ts[1]);
            }
            String groupFieldMapKey="";
            for (String groupField : groupFields) {
                groupFieldMapKey+=result.get(groupField);
            }
            results.put(groupFieldMapKey, result);
//			results.add(result);
        }
        return results;
    }
    /**
     * 计算合计
     *
     * @param sumFields
     * @param temp
     * @param data
     * @param groupFieldKey
     */
    private static void groupSum(String[] sumFields, Map<String, Object> temp,
                                 Map<String, Object> data, String groupFieldKey) {
        for (String sumField : sumFields) {
            String groupFieldKey_sumField = groupFieldKey + sumField;
            // code_name_quantity code_name_amount
            // 即code_001|name_test|quantity code_001|name_test|amount
            // code_003|name_test1|amount
            if (temp.containsKey(groupFieldKey_sumField)) {
				/*temp.put(
						groupFieldKey_sumField,
						Double.parseDouble(data.get(sumField).toString())
								+ Double.parseDouble(temp.get(
										groupFieldKey_sumField).toString()));
				*/

                temp.put(
                        groupFieldKey_sumField,
                        new BigDecimal(data.get(sumField).toString()).doubleValue()
                                + new BigDecimal(temp.get(
                                groupFieldKey_sumField).toString()).doubleValue());
            } else {
                temp.put(groupFieldKey_sumField,
                        new BigDecimal(data.get(sumField).toString()).doubleValue());
            }
        }
    }
}

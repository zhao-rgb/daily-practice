package com.zxl.dailypractice.project.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class EsDSLUtil {

    public static JSONObject createDateRange(String field,String from,String to){
        JSONObject result = new JSONObject();
        JSONObject range = new JSONObject();
        JSONObject obj = new JSONObject();
        if(StringUtils.isNotBlank(from)){
            obj.put("gte",from);
        }
        if(StringUtils.isNotBlank(to)){
            obj.put("lte",to);
        }
        obj.put("format","yyyy-MM-dd HH:mm:ss");
        range.put(field,obj);
        result.put("range",range);
        return result;
    }

    public static JSONObject createDateRange(String field,String from,String gt,String to,String lt){
        JSONObject result = new JSONObject();
        JSONObject range = new JSONObject();
        JSONObject obj = new JSONObject();
        obj.put(gt,from);
        obj.put(lt,to);
        obj.put("format","yyyy-MM-dd HH:mm:ss");
        range.put(field,obj);
        result.put("range",range);
        return result;
    }


    public static JSONObject createTerms(String field, List<String> value){
        JSONObject result = new JSONObject();
        JSONObject terms = new JSONObject();
        terms.put(field,value);
        result.put("terms",terms);
        return result;
    }

    public static JSONObject createTerms(String field, String value){
        JSONObject result = new JSONObject();
        JSONObject terms = new JSONObject();
        terms.put(field,value.split(","));
        result.put("terms",terms);
        return result;
    }

    public static JSONObject createTerm(String field, String value){
        JSONObject result = new JSONObject();
        JSONObject terms = new JSONObject();
        JSONObject valueObj = new JSONObject();
        valueObj.put("value",value);
        terms.put(field,valueObj);
        result.put("term",terms);
        return result;
    }
    public static JSONObject createMatch(String field, String value){
        JSONObject result = new JSONObject();
        JSONObject match = new JSONObject();
        match.put(field,value);
        result.put("match",match);
        return result;
    }
    public static JSONObject createRegexp(String field, String value){
        JSONObject result = new JSONObject();
        result.put("regexp", new JSONObject());
        result.getJSONObject("regexp").put(field, ".*"+value+".*");
        return result;
    }

    //and (a or b)
    public static JSONObject appendTermAndContainOr(String aField,String aValue,String bField,String bValue){
        JSONObject bool = new JSONObject();
        JSONArray should = new JSONArray();
        should.add(createTerm(aField,aValue));
        should.add(createTerm(bField,bValue));
        bool.put("should",should);
        JSONObject result = new JSONObject();
        result.put("bool",bool);
        return result;
    }
    //and (a or b)
    public static JSONObject appendMatchAndContainOr(String aField,String aValue,String bField,String bValue){
        JSONObject bool = new JSONObject();
        JSONArray should = new JSONArray();
        should.add(createMatch(aField,aValue));
        should.add(createMatch(bField,bValue));
        bool.put("should",should);
        JSONObject result = new JSONObject();
        result.put("bool",bool);
        return result;
    }

    public static JSONObject createSort(String field,String type){
        JSONObject sort = new JSONObject();
        sort.put(field,type);
        return sort;
    }

    public static JSONObject createGroupByJson(JSONArray groupList,JSONObject aggs){
        JSONObject aggregations = new JSONObject();
        JSONObject groupby = new JSONObject();
        JSONObject composite = new JSONObject();
        composite.put("size",10000);
        composite.put("sources",groupList);
        groupby.put("composite",composite);
        groupby.put("aggregations",aggs);
        aggregations.put("groupby",groupby);
        return aggregations;
    }


    /**
     * {
     *     bool:{
     *         must:@param
     *     }
     * }
     * @param must
     * @return
     */
    public static JSONObject appendQuery(JSONArray must){
        JSONObject query = new JSONObject();
        JSONObject bool = new JSONObject();
        bool.put("must",must);
        query.put("bool",bool);
        return query;
    }

    /**
     * {
     *     bool:{
     *         should:@param
     *     }
     * }
     * @param should
     * @return
     */
    public static JSONObject appendShoulds(JSONArray should){
        JSONObject query = new JSONObject();
        JSONObject bool = new JSONObject();
        bool.put("should",should);
        query.put("bool",bool);
        return query;
    }

    public static JSONObject getMaxTime(String field,String alias){
        JSONObject as = new JSONObject();
        JSONObject max = new JSONObject();
        max.put("field",field);
        JSONObject terms = new JSONObject();
        terms.put("max",max);
        as.put(alias,terms);
        return as;
    }

    public static JSONObject createScriptFields(String sql){
        JSONObject result = new JSONObject();
        String[] ss = sql.split(",");
        for (String s:ss) {
            if(s.contains(" as ")) {
                String field = s.split(" as ")[0];
                String alias = s.split(" as ")[1];
                JSONObject script = new JSONObject();
                script.put("inline","doc['"+field+"'].value");
                JSONObject obj = new JSONObject();
                obj.put("script",script);
                result.put(alias,obj);
            }
        }
        return result;
    }

    public static JSONObject createGroupByAggsFunction(String sql){
        JSONObject result = new JSONObject();
        String[] ss = sql.split(",");
        String type = "max,min,avg,sum";
        for (String s:ss) {
            String sub = s.substring(0,3);
            if(type.contains(sub)){
                String field = s.split(" as ")[0];
                field = field.substring(sub.length()+1,field.length()-1);

                String alias = s.split(" as ")[1];

                JSONObject fun = new JSONObject();
                JSONObject fieldObj = new JSONObject();
                fieldObj.put("field",field);
                fun.put(sub,fieldObj);
                result.put(alias,fun);
            }
        }
        return result;
    }

    /**
     * 处理group by 返回的数据
     * */
    public static List<Map<String,Object>> dealGroupData(String result){
        List<Map<String,Object>> resList = new ArrayList<Map<String,Object>>();
        if(StringUtils.isBlank(result)){
            return resList;
        }
        JSONObject resJson = JSONObject.parseObject(result);
        JSONObject aggregations = resJson.getJSONObject("aggregations");
        if(aggregations==null){
            return resList;
        }
        JSONObject groupby = aggregations.getJSONObject("groupby");
        JSONArray buckets = groupby.getJSONArray("buckets");
        for(int i=0;i<buckets.size();i++){

            Map<String,Object> map = new HashMap<String, Object>();
            JSONObject j = buckets.getJSONObject(i);
            Set<String> keys = j.keySet();

            for(String key: keys){
                if("key".equals(key)){
                    JSONObject keyJson = j.getJSONObject(key);
                    Set<String> keys2 = keyJson.keySet();
                    for(String key2:keys2){
                        map.put(key2, keyJson.get(key2));
                    }
                }else if("doc_count".equals(key)){
                    map.put("num", j.get(key));
                }else{
                    JSONObject value = j.getJSONObject(key);
                    if(value.containsKey("value_as_string")){
                        map.put(key, value.get("value_as_string"));
                    }else{
                        map.put(key, value.get("value"));
                    }
                }
            }
            resList.add(map);
        }
        return resList;
    }

    public static JSONObject createDateHistogram(String field,String value){
        return JSONObject.parseObject("{\n" +
                "                        \n" +
                "                        \"date_histogram(field="+field+",interval="+value+")\":{\n" +
                "                            \"date_histogram\":{\n" +
                "                                \"field\":\""+field+"\",\n" +
                "                                \"format\":\"yyyy-MM-dd HH:mm:ss\",\n" +
                "                                \"interval\":\""+value+"\"\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }");
    }

    public static JSONObject createGroupObj(String field){
        JSONObject obj = new JSONObject();
        JSONObject fieldObj = new JSONObject();
        JSONObject f = new JSONObject();
        f.put("field",field);
        fieldObj.put("terms",f);
        obj.put(field,fieldObj);
        return obj;
    }

    public static void main(String[] args) {
        JSONObject query = new JSONObject();
        query.put("size", 1000);
        JSONArray must = new JSONArray();
        must.add(EsDSLUtil.createTerms("k_circuitid", "hello"));
        query.put("query", EsDSLUtil.appendQuery(must));
        JSONObject aggs = EsDSLUtil.createGroupByAggsFunction(
                "avg(d_influx) as avgInflux,avg(d_outflux) as avgOutflux,max(d_influxratio) as inmaxratio,max(d_outfluxratio) as outmaxratio");
        query.put("aggregations", aggs);
        System.out.println(query.toString());
    }

}

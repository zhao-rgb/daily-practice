package com.zxl.dailypractice.card.three.february.february27;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2023/2/27
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String data = "{\n" +
                "\t\"took\": 12,\n" +
                "\t\"timed_out\": false,\n" +
                "\t\"_shards\": {\n" +
                "\t\t\"total\": 2,\n" +
                "\t\t\"successful\": 2,\n" +
                "\t\t\"skipped\": 0,\n" +
                "\t\t\"failed\": 0\n" +
                "\t},\n" +
                "\t\"hits\": {\n" +
                "\t\t\"total\": 94,\n" +
                "\t\t\"max_score\": 0.0,\n" +
                "\t\t\"hits\": [{\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"H0F4joYBSGy_8rwqVAG3\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 00:00:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 00:01:45\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807362\",\n" +
                "\t\t\t\t\"d_usernum\": \"807362\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"IkSLjoYBSGy_8rwqjnR6\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 00:20:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 00:22:43\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807196\",\n" +
                "\t\t\t\t\"d_usernum\": \"807196\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"3UWTjoYBSGy_8rwqex5u\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 00:30:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 00:31:31\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807137\",\n" +
                "\t\t\t\t\"d_usernum\": \"807137\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"Aku4joYBSGy_8rwqJ2Qh\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 01:10:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 01:11:36\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807732\",\n" +
                "\t\t\t\t\"d_usernum\": \"807732\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"ik7KjoYBSGy_8rwqimc5\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 01:30:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 01:31:37\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"809008\",\n" +
                "\t\t\t\t\"d_usernum\": \"809008\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"V03CjoYBSGy_8rwqVkZU\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 01:20:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 01:22:31\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"808388\",\n" +
                "\t\t\t\t\"d_usernum\": \"808388\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"DFXujoYBSGy_8rwq3v0a\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 02:10:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 02:11:31\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"810146\",\n" +
                "\t\t\t\t\"d_usernum\": \"810146\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"EFf3joYBSGy_8rwq8XTk\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 02:20:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 02:21:27\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"810008\",\n" +
                "\t\t\t\t\"d_usernum\": \"810008\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"OVgBj4YBSGy_8rwqa_0F\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 02:30:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 02:31:48\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"810198\",\n" +
                "\t\t\t\t\"d_usernum\": \"810198\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
        List<GetVBASUserDataResp> resp = new ArrayList<>();
        JSONObject object = JSONObject.parseObject(data);
        JSONObject hits = (JSONObject) object.get("hits");
        JSONArray array = hits.getJSONArray("hits");
        if (array != null && array.size() > 0){
            Map<Object, Integer> timeMap = new HashMap<>();
            for (int i = 0;i < array.size();i++){
                JSONObject source = ((JSONObject) array.get(i)).getJSONObject("_source");
                GetVBASUserDataResp getVBASUserDataResp = new GetVBASUserDataResp();
                if (!source.isEmpty()){
                    String t_ctime = source.getString("t_ctime");
                    String userNum = source.getString("s_usernum");
                    if("user".equals("user")){
                        if (timeMap.containsKey(t_ctime)){
                            timeMap.put(t_ctime,timeMap.get(t_ctime) + Integer.parseInt(userNum));
                        }else {
                            timeMap.put(t_ctime,Integer.parseInt(userNum));
                        }
                    } else {
                        getVBASUserDataResp.setColTime(t_ctime);
                        getVBASUserDataResp.setUserNum(userNum);
                        resp.add(getVBASUserDataResp);
                    }

                }
            }
            if (timeMap.size() != 0){
                for (Object key : timeMap.keySet()) {
                    GetVBASUserDataResp getVBASUserDataResp = new GetVBASUserDataResp();
                    getVBASUserDataResp.setColTime(key.toString());
                    getVBASUserDataResp.setUserNum(String.valueOf(timeMap.get(key)));
                    resp.add(getVBASUserDataResp);
                }
            }
        }

        System.out.println(resp);
    }
}

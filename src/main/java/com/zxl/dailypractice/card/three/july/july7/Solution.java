package com.zxl.dailypractice.card.three.july.july7;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: zhaoxl
 * @date: 2023/7/7
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        List<ThirdUserPO> all = new ArrayList<>();
        ThirdUserPO thirdUserPO = new ThirdUserPO();
        thirdUserPO.setPhoneNumber("1");
        thirdUserPO.setCreateBy("1");
        ThirdUserPO thirdUserPO1 = new ThirdUserPO();
        thirdUserPO1.setPhoneNumber("1");
        all.add(thirdUserPO);
        all.add(thirdUserPO1);
        List<String> mobileList;
        mobileList = all.stream().filter(u -> StringUtils.isNotBlank(u.getPhoneNumber()))
                .map(ThirdUserPO::getPhoneNumber).distinct().collect(Collectors.toList());
        System.out.println(mobileList);

        Map<String, ThirdUserPO> merchantMap = null;
        //Function.identity()是值映射器。
        //它表明应该使用ThirdUserPO对象本身作为映射中的值。
        // C. (v1, v2) -> v1是一个合并函数。它解决了当两个
        // ThirdUserPO对象具有相同的电话号码时可能发生的冲突。在这种情况下，
        // 它选择遇到的第一个对象(v1)并丢弃第二个对象(v2)
        merchantMap = all.stream()
                .collect(Collectors.toMap(ThirdUserPO::getPhoneNumber,
                        Function.identity(), (v1, v2) -> v1));
        System.out.println(merchantMap);

    }
}

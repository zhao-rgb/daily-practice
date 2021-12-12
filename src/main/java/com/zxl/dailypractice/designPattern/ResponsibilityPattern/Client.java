package com.zxl.dailypractice.designPattern.ResponsibilityPattern;

/**
 * @author zhao
 * @className Client
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
//责任链模式     https://www.lanqiao.cn/courses/1230/learning/?id=11050
public class Client {
    public static void main(String[] args) {
        Handler groupLeaderHandler = new GroupLeaderHandler();
        Handler factoryManagerHandler = new FactoryManagerHandler();
        Handler bossHandle = new BossHandler();
        groupLeaderHandler.setSuccessor(factoryManagerHandler);
        factoryManagerHandler.setSuccessor(bossHandle);
        //请假一天
        groupLeaderHandler.handlerRequest(1);
        //请假6天
        groupLeaderHandler.handlerRequest(6);
        //请假10天
        groupLeaderHandler.handlerRequest(10);
    }
}

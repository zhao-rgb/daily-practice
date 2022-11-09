package com.zxl.dailypractice.project.constant;

/**
 * @author zhuc
 * @since 2019/5/14
 */
public class ResourceConstant {
	private ResourceConstant() {
	}

	public static final Integer PAGE_SIZE_DEFAULT = 20;
	public static final Integer PAGE_NUM_DEFAULT = 1;

	public static final String EXCEL_CONFIG_XML = "config/excel-config.xml";
	public static final String USER_HOME = System.getProperty("user.home", "/slview");
	public static final String USER_DIR = System.getProperty("user.dir", "/slview");
	public static final String FILE_PATH_RES = USER_HOME + "/itep/var/tmp/res/";

	public static enum TIME_FORMAT_BUNCH { // 几个时间格式字符串
		YYYY_MM_DD("yyyy-MM-dd"), // 年-月-日
		YYYYMMDD("yyyyMMdd"), // 年月日
		YYYY_MM_DD_HH_MI_SS("yyyy-MM-dd HH:mm:ss"), // 年-月-日 时:分:秒
		YYYYMMDDHHMISS("yyyyMMddHHmmss"), // 年月日时分秒
		YYYY_MM_DD_HH_MI_SS_SSS("yyyy-MM-dd HH:mm:ss.SSS"), // 年-月-日 时:分:秒.毫秒
		YYYYMMDDHHMISSSSS("yyyyMMddHHmmssSSS"), // 年月日 时分秒毫秒
		YYYY_MM_DD_HH_MI_SS_S("yyyy-MM-dd hh:mm:ss.S");
		public String value;

		private TIME_FORMAT_BUNCH(String value) {
			this.value = value;
		}
	};

	public static enum SYSTEM_TIME_FORMAT { // 几种系统时间格式
		DATE("1"), // 日期
		DATE_CMPCT("11"), // 紧凑型日期
		TIME("2"), // 时间
		TIME_CMPCT("21"), // 紧凑型时间
		TIME_PRCS("3"), // 精确时间
		TIME_PRCS_CMPCT("31"); // 精确的紧凑型时间
		public String value;

		private SYSTEM_TIME_FORMAT(String value) {
			this.value = value;
		}
	};

	public static enum OPER_TYPE { // 几种系统时间格式
		ADD("add"),
		MOD("mod"),
		DEL("del"),
		ADD_MOD("add,mod"),
		ADD_MOD_DEL("add,mod,del"),
		MOD_DEL("mod,del");
		public String value;

		private OPER_TYPE(String value) {
			this.value = value;
		}
	}

	public static final String SEQ_CM_RES_NODE="SEQ_CM_RES_NODE";
	public static final String RES_CLASS_DEV="DEV";
	public static final String RES_CLASS_CIR="CIR";
	public static final String RES_CLASS_PTH="PTH";
	public static final String RES_CLASS_ALL="DEV,CIR,PTH";
	public static final String ITEM_GRP_ALL="_Sys,_Intf";
	public static final String ITEM_GRP_SYS="_Sys";
}

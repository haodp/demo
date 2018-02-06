package com.demo.common.constants;

/**
 * AppConstants<br>
 * <p>
 * 系统用常量类。
 * </p>
 *
 * @author LISHIJIE [HCH]
 * @version 1.0
 */
public class FwConstants {

	public static final String ENCODING = "UTF-8";

	public static final int SUCCESS = 0;

	public static final int FAILURE_INIT = 1;

	public static final int FAILURE_APP = 2;

	public static final int FAILURE_SYS = 3;

	public static final int FAILURE_SYS_APP = 31;

	public static final int FAILURE_OTH_SYS = 4;


	public static final String SESSION_KEY_LOGININFO = "loginInfo";

	public static final String SESSION_KEY_MENUINFO = "menuInfo";

	public static final String SESSION_KEY_LOGINROLE = "loginRole";

	public static final String SESSION_KEY_LOGINUSERHOSPITAL = "loginUserHospital";

	public static final String DEFAULT_ERROR_VIEW = "fw/error";

	public static final String DEFAULT_NO_PERMISSION_PATH = "/noPermission/";

	public static final String NEW_MSG_CNT = "newMsgCnt";


	public static final String RABBITMQ_DEFAULT_QUEUE_NAME = "rabbitmq.default.queue.name";
}

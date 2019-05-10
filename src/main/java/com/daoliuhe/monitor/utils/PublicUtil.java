package com.daoliuhe.monitor.utils;

import java.util.Collection;
import java.util.Map;

/**
 * The class Public util.
 *
 * @author 21829
 */
public class PublicUtil {

	/**
	 * 判断对象是否Empty(null或元素为0)
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj 待检查对象
	 *
	 * @return boolean 返回的布尔值
	 */
	public static boolean isEmpty(Object pObj) {
		if (pObj == null) {
			return true;
		}
		if (pObj == "") {
			return true;
		}
		if (pObj instanceof String) {
			return ((String) pObj).length() == 0;
		} else if (pObj instanceof Collection) {
			return ((Collection) pObj).isEmpty();
		} else if (pObj instanceof Map) {
			return ((Map) pObj).size() == 0;
		}
		return false;
	}

	/**
	 * 判断对象是否为NotEmpty(!null或元素大于0)
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj 待检查对象
	 *
	 * @return boolean 返回的布尔值
	 */
	public static boolean isNotEmpty(Object pObj) {
		if (pObj == null) {
			return false;
		}
		if (pObj == "") {
			return false;
		}
		if (pObj instanceof String) {
			return ((String) pObj).length() != 0;
		} else if (pObj instanceof Collection) {
			return !((Collection) pObj).isEmpty();
		} else if (pObj instanceof Map) {
			return ((Map) pObj).size() != 0;
		}
		return true;
	}

	/**
	 * 获取job name
	 * @param jenkinsJobUrl，url或者job name
	 * @return
	 */
	public static String getJenkinsJobName(String jenkinsJobUrl){
		String jobName = "";
		//去掉前后空格
		jenkinsJobUrl = jenkinsJobUrl.trim();
		if(!jenkinsJobUrl.contains("http://")){
			return jenkinsJobUrl;
		}
		String[] splitUrl= jenkinsJobUrl.split("/");
		if(jenkinsJobUrl.substring(jenkinsJobUrl.length()-1,jenkinsJobUrl.length()).equals("/")){
			jobName = splitUrl[splitUrl.length-1];
		}else{
			jobName = splitUrl[splitUrl.length-1];
		}
		return jobName;
	}

	/**
	 * 获取jenkins url 地址
	 * @param jenkinsJobUrl
	 * @return
	 */
	public static String getJenkinsUrl(String jenkinsJobUrl){
		String jenkinsUrl = "";
		//去掉前后空格
		jenkinsJobUrl = jenkinsJobUrl.trim();
		if(!jenkinsJobUrl.contains("http://")){
			return "";
		}

		//http://10.172.160.39:8080/job/WECI-STORAGEAUTOTEST-LOCAL/   取http://10.172.160.39:8080/
		String[] splitUrl= jenkinsJobUrl.split("/");
		if(splitUrl.length>3){
			jenkinsUrl = splitUrl[0]+"//"+splitUrl[2]+"/";
		}

		return  jenkinsUrl;
	}

}

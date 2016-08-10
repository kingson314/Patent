package com.patent.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patent.manager.service.IManagerService;
import com.patent.wipo.entity.Wipo;
import common.util.UtilGuid;
import common.util.file.UtilFile;
import common.util.json.UtilJackSon;
import common.util.log.UtilLog;
import common.util.string.UtilString;

import framework.base.controller.BaseContorller;
import framework.base.support.Result;

/**
 * @Description:
 * @date 2016-07-13
 * @author:fgq
 */
@Controller
@RequestMapping("/manager/")
public class ManagerController extends BaseContorller<Wipo> {
	@Resource
	private IManagerService managerService;

	@RequestMapping("listCommon")
	public void listCommon() {
		for (Map.Entry<String, Object> entry : this.mapParams.entrySet()) {
			UtilLog.logDebug(entry.getKey() + " = " + entry.getValue());
		}
		String sql = "select * from pcommon order by ord ";
		List<Map<String, Object>> list = this.managerService.listMap(sql, new  HashMap<String, Object>());
		try {
			System.out.println(UtilJackSon.toJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.print(new Result(list));
	}
	@RequestMapping("getCommon")
	public void getCommon() {
		for (Map.Entry<String, Object> entry : this.mapParams.entrySet()) {
			UtilLog.logDebug(entry.getKey() + " = " + entry.getValue());
		}
		String id= UtilString.isNil(this.mapParams.get("id"));
		String sql = "select * from pcommon where id='"+id+"'";
		List<Map<String, Object>> list = this.managerService.listMap(sql, new  HashMap<String, Object>());
		try {
			System.out.println(UtilJackSon.toJson(list.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.print(new Result(list.get(0)));
	}
	@RequestMapping("svaeCommon")
	public void svaeCommon() {
		for (Map.Entry<String, Object> entry : this.mapParams.entrySet()) {
			UtilLog.logDebug(entry.getKey() + " = " + entry.getValue());
		}
		String domain= UtilString.isNil(this.mapParams.get("domain"));
		String num= UtilString.isNil(this.mapParams.get("num"));
		String name= UtilString.isNil(this.mapParams.get("name"));
		String status= UtilString.isNil(this.mapParams.get("status"));
		String memo= UtilString.isNil(this.mapParams.get("memo"));
		String ord= UtilString.isNil(this.mapParams.get("ord"));
		String sql ="";
		if("".equals(UtilString.isNil(this.mapParams.get("id")))){
			String id= UtilGuid.getGuid();
			sql = "insert into pcommon(id,domain,num,name,status,memo,ord)values('"+id+"','"+domain+"','"+num+"','"+name+"','"+status+"','"+memo+"','"+ord+"')";
		}else{
			String id=this.mapParams.get("id").toString();
			sql = "update pcommon set domain='"+domain+"',num='"+num+"',name='"+name+"',status='"+status+"',memo='"+memo+"',ord='"+ord+"' where id='"+id+"'";
		}
		System.out.println(sql);
		this.managerService.executeSql(sql);
		this.print(new Result(true));
	}
	
	@RequestMapping("deleteCommon")
	public void deleteCommon() {
		for (Map.Entry<String, Object> entry : this.mapParams.entrySet()) {
			UtilLog.logDebug(entry.getKey() + " = " + entry.getValue());
		}
		String[] ids= UtilString.isNil(this.mapParams.get("ids")).split(",");
		for(String id:ids){
			String sql = "delete from pcommon where id='"+id+"'";
			this.managerService.executeSql(sql);
		}
		this.print(new Result(true));
	}
	@RequestMapping("createCommonPage")
	public void createCommonPage() {
		for (Map.Entry<String, Object> entry : this.mapParams.entrySet()) {
			UtilLog.logDebug(entry.getKey() + " = " + entry.getValue());
		}
		String basePath=this.request.getSession().getServletContext().getRealPath("");
		String content=UtilFile.readFile(basePath+"/app/CommonTpl.jsp");
		UtilFile.writeFile(basePath+"/Common.jsp", content.replace("<%-- dyn html --%>",UtilString.isNil(this.mapParams.get("html")))); 
		this.print(new Result(true,request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/Common.jsp"));
	}
}

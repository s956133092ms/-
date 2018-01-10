package com.controller;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.*;
import com.dao.*;

@RestController
public class UserController {
	@Autowired 
	private UserDao userdao;

	@Autowired
	private RepUserDao repuserdao;
	
	@Autowired 
	private ViewDao viewdao;
	
	@Autowired 
	private AreaDao areadao;
	
	@Autowired
	private User2Dao user2dao;
	
	@Autowired
	private LoginDao logindao;
	
	@RequestMapping(value = "/adduser",method = RequestMethod.POST)   
	public Object addUser(String name, String email) {        
		System.out.println("email:" + email + "name:" + name);      
		Login tempUser = logindao.findByName(name);     
		if (null == tempUser) {       
			tempUser = new Login();         
			} 
		else return "repeat";
		tempUser.setEmail(email);     
		tempUser.setName(name);     
		Login resultUser = logindao.save(tempUser);   
		if (null == resultUser) {       
			return "repeat";     
			} 
		else {       
			return "success";     
			}     
		}     // 条件查询     /**    * 获取姓名和邮箱是指定内容的用户    *    * @return    */  
	@RequestMapping(value = "/getUser"
			//,method = RequestMethod.POST
			) 
	public Object getUser1(ModelMap modelMap,String name, String email) {
		System.out.println("email:" + email + "name:" + name);   
		modelMap.addAttribute("name", name);
        modelMap.addAttribute("email", email);
        Login user = logindao.findByName(name);
        if(null == user) 
        	return "nameerror";
		List<Login> userList = logindao.findByNameAndEmail(name, email);     
		if (null != userList && userList.size() != 0) { 
			return name;     
		} 
		else {       
			return "passerror";     
			} 
		}
	
	@RequestMapping(value = "/getall")   
	public Object getAllUser() {     
		List<User> list = (List<User>) userdao.findAll();     
		if (null == list || list.size() == 0) {       
			return "nodata";     
			} 
		else {       
			return list;     
			}     
		}
	
	@RequestMapping(value="/webname")
			//,method = RequestMethod.POST)
	public Object getVideo(String webname){//������վ���õ���Ƶ�б�
		List<User> list=(List<User>) userdao.findByWebname(webname);
		if(webname==null){
			return "nameerror";
		}
		else{
			if(list == null || list.size() == 0){
				return "nodata";
			}
			else{
				return list;
			}
		}
		
	}
	
	@RequestMapping(value="/add")
	public String add(String webname,String videoname,String fromwhere){
		User list=(User) userdao.findByVideoname(videoname); 
		
		if (null == list) {       
			list = new User();         
			} 
		else{
			return "exist";
		}
		
		list.setWebname(webname);     
		list.setVideoname(videoname);  
		list.setFrom(fromwhere);
		
		User resultUser = userdao.save(list);    
		
		if (null == resultUser) {       
			return "repeat";     
			} 
		else {       
			return "success";     
			}      
	}
	
	@RequestMapping(value = "/delete")   
	public Object delete(String videoname) {   
		User video = userdao.findByVideoname(videoname);
		int id;
		if (null == video) {
			return "novideo";     
			}
		else {   
			id = video.getId(); 
			userdao.delete(id);       
			return "success" ;     
			}     
		}  
	
	@RequestMapping(value="/change")
	public Object change(String webname,String videoname,Date pagetime,Date collecttime,String fromwhere){
		User list = userdao.findByVideoname(videoname);
		
		if(list ==null) return "error";
		else{
		if(webname!=null) list.setWebname(webname);  
		if(videoname!=null) list.setVideoname(videoname);   
		if(fromwhere!=null) list.setFrom(fromwhere); 
		if(pagetime!=null) list.setPagetime(pagetime);
		if(collecttime!=null) list.setTime(collecttime);
		
        User resultUser = userdao.save(list);    
		
		if (null == resultUser) {       
			return "fail";     
			} 
		else {       
			return "success";     
			} 
		}
	}
	
	 /*@RequestMapping(value ="/video.do")  
	    public @ResponseBody void video(String videoname, HttpServletResponse response)throws Exception{  
	        File file = new File("E:/"+videoname);  
	        FileInputStream in = new FileInputStream(file);  
	        ServletOutputStream out = response.getOutputStream();  
	        byte[] b = null;  
	        while(in.available() >0) {  
	            if(in.available()>10240) {  
	                b = new byte[10240];  
	            }else {  
	                b = new byte[in.available()];  
	            }  
	            in.read(b, 0, b.length);  
	            out.write(b, 0, b.length);  
	        }  
	        in.close();  
	        out.flush();  
	        out.close();  
	    }  */
	
	@RequestMapping(value = "/sumpage")
    public Object Sumpage(){//�������Բ�ѯ
		List<View> list = viewdao.countProperty();
        return list;
    }
	
	@RequestMapping(value = "/areapage")
    public Object Areapage(){//���յ�����ѯ
		List<Area> list = areadao.countArea();
		/*String[] city = new String[]{"杭州市","湖州市","衢州市","台州市","丽水市","̨温州市","宁波市","金华市","舟山市","绍兴市","嘉兴市"};
		if(list.size()==11) return list;
		else{
		    for(int i = 0 ; i < 11; i++) {
		    	int flag = 0;
		    	for(int j = 0 ; j < list.size() ; j++) {
		    		if(list.get(j).getArea().equals(city[i])) flag =1;
				}
		    	if(flag == 0) {
		    		Area m = new Area();
		    		m.setName(city[i]);
		    		m.setValue("0");
		    		list.add(m);
		    	}
			}*/
		    return list;
		 }
    //}
	
	@RequestMapping(value = "/hotpage2")
	public List<User2> hot(int day){
		List<User2> list;
		if(day == 1){
		    //Sort sort = new Sort(Sort.Direction.DESC, "hot2");
		    //list = user2dao.findAll(sort);
			list = user2dao.user2();
			//return list;
		}
		else if(day == 2){
			list = user2dao.findweek();
			//return list; 
		}
		else{
			list = user2dao.findmonth();
			//return list;
		}
		return list;
	}
	
	/*@RequestMapping(value = "/hotpage")
	public List<User2> hot2(){
		List<User2> list;
		    Sort sort = new Sort(Sort.Direction.DESC, "hot2");
		    list = user2dao.findAll(sort);
			return list;
		}*/
	
	
	@RequestMapping(value = "/getallrep")   
	public Object getAllRep() {     
		List<RepUser> list = (List<RepUser>) repuserdao.findAll();     
		if (null == list || list.size() == 0) {       
			return "nodata";     
			} 
		else {       
			return list;     
			}     
		}
	
	@RequestMapping(value="/changerep",method = RequestMethod.POST)//修改
	@ResponseBody
	public String changerep(String videoweb,String videoweburl,String webtype,String videourl,String collrate){
		RepUser list =  (RepUser)repuserdao.findByVideoweb(videoweb);
		
		if(list==null) return "error";
		else{
		if(list.getVideoweburl()!=null) list.setVideoweburl(videoweburl);  
		list.setVideoweb(videoweb);
        list.setCollrate(collrate);
		list.setWebtype(webtype);
		
        RepUser resultUser = repuserdao.save(list);    
		
		if (null == resultUser) {       
			return "fail";     
			} 
		else {       
			return "success";     
			} 
		}
	}
	
	@RequestMapping(value="/addrep")
	public Object addrep(String videoweb,String videoweburl,String webtype,String collrate){
		System.out.println("videoweb:" + videoweb + "videowenurl:" + videoweburl);      
		RepUser rep = (RepUser) repuserdao.findByVideowebAndVideoweburl(videoweb, videoweburl);
		if (null == rep) {       
			rep = new RepUser();         
			} 
		else return "error";
		
		rep.setVideoweb(videoweb);
		rep.setVideoweburl(videoweburl);
		rep.setWebtype(webtype);
		rep.setCollrate(collrate);    
		RepUser resultUser = repuserdao.save(rep);   
		if (null == resultUser) {       
			return "repeat";     
			} 
		else {       
			return "success";     
			} 
		
	}
	
	@RequestMapping(value="/deleterep")
	public Object deleterep(int id){
		repuserdao.delete(id);
		return "success";
	}

}

package springboot.entity;

import java.util.List;
import java.util.Map;

import springboot.entity.Roleinfo;

/**
 * 
 * @author 
 */
public class Userinfo {
	/**
	 *  
	 */
	private Integer uid;
	/**
	 *  
	 */
	private String uname;
	/**
	 *  
	 */
	private String upass;
	/**
	 *  
	 */
	private String ustatus;
	/**
	 *  
	 */
	private String weixinhao;
	/**
	 * 
	 */
	private Map<String,String> userauth;
	/**
	 *  
	 */
	
	private java.util.Date createTime;
	/**
	 *  
	 */
	private java.util.Date updateTime;
	/**
	 * 
	 */
	private List<Roleinfo> rolelist;
	/**
	 * 
	 * @param uid
	 */
	public void setUid(Integer uid){
		this.uid = uid;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getUid(){
    	return uid;
    }
	/**
	 * 
	 * @param uname
	 */
	public void setUname(String uname){
		this.uname = uname;
	}
	
    /**
     * 
     * @return
     */	
    public String getUname(){
    	return uname;
    }
	/**
	 * 
	 * @param upass
	 */
	public void setUpass(String upass){
		this.upass = upass;
	}
	
    /**
     * 
     * @return
     */	
    public String getUpass(){
    	return upass;
    }
	/**
	 * 
	 * @param ustatus
	 */
	public void setUstatus(String ustatus){
		this.ustatus = ustatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getUstatus(){
    	return ustatus;
    }
	/**
	 * 
	 * @param weixinhao
	 */
	public void setWeixinhao(String weixinhao){
		this.weixinhao = weixinhao;
	}
	
    /**
     * 
     * @return
     */	
    public String getWeixinhao(){
    	return weixinhao;
    }
	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
    /**
     * 
     * @return
     */	
    public java.util.Date getCreateTime(){
    	return createTime;
    }
	/**
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	
    /**
     * 
     * @return
     */	
    public java.util.Date getUpdateTime(){
    	return updateTime;
    }

	public Map<String, String> getUserauth() {
		return userauth;
	}

	public void setUserauth(Map<String, String> userauth) {
		this.userauth = userauth;
	}

	public List<Roleinfo> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Roleinfo> rolelist) {
		this.rolelist = rolelist;
	}

	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", ustatus=" + ustatus
				+ ", weixinhao=" + weixinhao + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
    
}
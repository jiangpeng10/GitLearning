package springboot.entity;

/**
 * 
 * @author 
 */
public class Resource {
	/**
	 *  
	 */
	private Integer rid;
	/**
	 *  
	 */
	private String rname;
	/**
	 *  
	 */
	private String resurl;
	/**
	 *  
	 */
	private Integer resorderno;
	/**
	 *  
	 */
	private String redsdes;
	/**
	 *  
	 */
	private java.util.Date createTime;
	/**
	 *  
	 */
	private java.util.Date updatetime;
	/**
	 *  
	 */
	private String createMan;
	/**
	 *  
	 */
	private String updateMan;
	/**
	 *  
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private String authority;
	/**
	 * 
	 * @param rid
	 */
	public void setRid(Integer rid){
		this.rid = rid;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getRid(){
    	return rid;
    }
	/**
	 * 
	 * @param rname
	 */
	public void setRname(String rname){
		this.rname = rname;
	}
	
    /**
     * 
     * @return
     */	
    public String getRname(){
    	return rname;
    }
	/**
	 * 
	 * @param resurl
	 */
	public void setResurl(String resurl){
		this.resurl = resurl;
	}
	
    /**
     * 
     * @return
     */	
    public String getResurl(){
    	return resurl;
    }
	/**
	 * 
	 * @param resorderno
	 */
	public void setResorderno(Integer resorderno){
		this.resorderno = resorderno;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getResorderno(){
    	return resorderno;
    }
	/**
	 * 
	 * @param redsdes
	 */
	public void setRedsdes(String redsdes){
		this.redsdes = redsdes;
	}
	
    /**
     * 
     * @return
     */	
    public String getRedsdes(){
    	return redsdes;
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
	 * @param updatetime
	 */
	public void setUpdatetime(java.util.Date updatetime){
		this.updatetime = updatetime;
	}
	
    /**
     * 
     * @return
     */	
    public java.util.Date getUpdatetime(){
    	return updatetime;
    }
	/**
	 * 
	 * @param createMan
	 */
	public void setCreateMan(String createMan){
		this.createMan = createMan;
	}
	
    /**
     * 
     * @return
     */	
    public String getCreateMan(){
    	return createMan;
    }
	/**
	 * 
	 * @param updateMan
	 */
	public void setUpdateMan(String updateMan){
		this.updateMan = updateMan;
	}
	
    /**
     * 
     * @return
     */	
    public String getUpdateMan(){
    	return updateMan;
    }
	/**
	 * 
	 * @param parentId
	 */
	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getParentId(){
    	return parentId;
    }
    /**
     * 
     * @return
     */
	public String getAuthority() {
		return authority;
	}
	/**
	 * 
	 * @param authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Resource [rid=" + rid + ", rname=" + rname + ", parentId=" + parentId + ", authority=" + authority
				+ "]";
	}
    
    
}
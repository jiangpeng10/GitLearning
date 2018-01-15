package springboot.entity;

/**
 * 
 * @author 
 */
public class Roleinfo {
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
	private int flag; //标示是否存在角色
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
    
}
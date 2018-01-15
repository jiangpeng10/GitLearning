package springboot.vo;

public class ResourceVo {
	private Integer rid;
	private String rname;
	private String resurl;
	private Integer resorderno;
	private String redsdes;
	private Integer parentId;
	private String authority;
	
	private int select;
	private int update;
	private int delete;
	private int insert;
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getResurl() {
		return resurl;
	}
	public void setResurl(String resurl) {
		this.resurl = resurl;
	}
	public Integer getResorderno() {
		return resorderno;
	}
	public void setResorderno(Integer resorderno) {
		this.resorderno = resorderno;
	}
	public String getRedsdes() {
		return redsdes;
	}
	public void setRedsdes(String redsdes) {
		this.redsdes = redsdes;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public int getUpdate() {
		return update;
	}
	public void setUpdate(int update) {
		this.update = update;
	}
	public int getDelete() {
		return delete;
	}
	public void setDelete(int delete) {
		this.delete = delete;
	}
	public int getInsert() {
		return insert;
	}
	public void setInsert(int insert) {
		this.insert = insert;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "ResourceVo [rid=" + rid + ", rname=" + rname + ", authority=" + authority + "]";
	}
}

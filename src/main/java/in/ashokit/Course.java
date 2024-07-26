package in.ashokit;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COURSE_DTLS_EXCEL")
public class Course {
	
	@Id
	private Integer cid;
	private String name;
	private String HTNo;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHTNo() {
		return HTNo;
	}
	public void setHTNo(String hTNo) {
		HTNo = hTNo;
	}
	
	

}

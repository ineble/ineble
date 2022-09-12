package practice_v1;

import java.time.LocalDateTime;
import java.util.Map;

public class article {
	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String title;
	public String body;
	
	public article (int id,LocalDateTime regDate,LocalDateTime updateDate,String title,String body) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
	}

	public article(Map<String, Object> articleMap) {
		this.id = (int)articleMap.get("id");
		this.regDate = (LocalDateTime)articleMap.get("regDate");
		this.updateDate = (LocalDateTime)articleMap.get("updateDate");
		this.title = (String)articleMap.get("title");
		this.body = (String)articleMap.get("body");
		
	}
}

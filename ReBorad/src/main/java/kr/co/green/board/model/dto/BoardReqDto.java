package kr.co.green.board.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter	
public class BoardReqDto {
	
	private int no;
	private String title;
	private String authorName;
	private String content;
	
}

package com.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyVO {
	private int rno;
	private int bno;
	private String reply;
	private String writer;
	private Date replyDate;
	private Date modifyDate; 
}

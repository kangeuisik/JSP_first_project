package com.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class BoardVO {
	private int bno;
	private String bid;
	private String title;
	private String content;
	private String writer;
	private String imageFileName;
	private Date writeDate;
	private int replyCount;
}

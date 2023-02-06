package com.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private int mno;
	private String id;
	private String pwd;
	private String mrank;
	private String platoon;
	private String name;
	private String personNo;
	private String militaryNo;
	private String subject;
	private String scoreRank;
	private String addr;
	private String email;
	private String birth;
	private Date joinDate;
	private MemberGrade grade;
	
	public enum MemberGrade{
		ROLE_ADMIN, ROLE_SERGANT, ROLE_PARENTS
	}
	private Category category; 
}

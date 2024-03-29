package com.domain;

import com.domain.MemberVO.MemberGrade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor
public class AuthVO {
	private String id;
	private MemberGrade grade;
}

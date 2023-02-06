package com.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RequestVO {
	private int requestNo;
	private String platoon;
	private String mrank;
	private String name;
	private String militaryNo;
	private String requestDate;
	private String reason;
	private String resultOR;
}

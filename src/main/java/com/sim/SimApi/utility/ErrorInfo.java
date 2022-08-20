package com.sim.SimApi.utility;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	
	public String errorMessage;
	public Integer errorCode;
	public LocalDateTime timestamp;

}

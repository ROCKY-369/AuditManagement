package com.cognizant.benchmark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidatingDTO {
	/**
	 * Class To store the validity of the token
	 */
	private boolean validStatus;
	

}

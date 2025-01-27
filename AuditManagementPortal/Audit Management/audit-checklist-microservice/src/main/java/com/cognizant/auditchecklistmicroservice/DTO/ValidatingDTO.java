package com.cognizant.auditchecklistmicroservice.DTO;


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
	 * It is to validate the token
	 */

	private boolean validStatus;

}


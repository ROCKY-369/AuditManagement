package com.cognizant.auditseveritymicroservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	 * Gets the valid status.
	 *
	 * @param valid status.
	 * @return valid status.
	 */
    @JsonProperty
    private boolean validStatus;

    
}

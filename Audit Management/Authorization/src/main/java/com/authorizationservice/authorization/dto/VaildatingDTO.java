package com.authorizationservice.authorization.dto;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VaildatingDTO {
	/**
	 * @param validStatus After validating the token this variable return the status of user.
	 */
    @Id
    @JsonProperty
    private boolean validStatus;
    
}

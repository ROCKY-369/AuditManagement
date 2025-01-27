package com.cognizant.benchmark.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidatingDTOTest {

    private ValidatingDTO validatingDTO;

    @BeforeEach
    public void init(){
        validatingDTO=new ValidatingDTO();
    }
    /**
     * Test method to check the validation status.
     */
    @Test
    public void testForTrue(){
        validatingDTO.setValidStatus(true);
        assertTrue(validatingDTO.isValidStatus());
    }
    /**
     * Test method to check the validation status.
     */
    @Test
    public void testForFalse(){
        validatingDTO.setValidStatus(false);
        assertFalse(validatingDTO.isValidStatus());
    }
    /**
     * Test method to check the validation status.
     */
    @Test
    public void testConstructor(){
        validatingDTO=new ValidatingDTO(true);
        assertTrue(validatingDTO.isValidStatus());
    }

    
}

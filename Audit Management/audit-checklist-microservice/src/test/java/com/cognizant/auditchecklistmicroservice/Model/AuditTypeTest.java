package com.cognizant.auditchecklistmicroservice.Model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class AuditTypeTest {
	
	AuditType auditType = new AuditType();
	/**
	 * Test method to check the set method of audit type.
	 */
	@Test
	public void testSetAuditType() {
		auditType.setAuditType("Internal");
		assertEquals("Internal",auditType.getAuditType());
	}
	/**
	 * Test method to check the get method of audit type.
	 */
	@Test
	public void testGetAuditType() {
		auditType.setAuditType("SOX");
		assertEquals("SOX",auditType.getAuditType());
	}
	/**
	 * Test method to check the audit type constructor class.
	 */
	@Test
	public void testAuditTypeConstructor() {
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAuditType());
	}
	
	

}

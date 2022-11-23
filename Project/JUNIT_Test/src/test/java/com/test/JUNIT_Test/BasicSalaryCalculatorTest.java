package com.test.JUNIT_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicSalaryCalculatorTest {

	private BasicSalaryCalculator basicSalaryCalculator;

	@BeforeEach
	void init() {
		basicSalaryCalculator = new BasicSalaryCalculator();
	}

	@Test
	void testBasicSalaryWithValidSalary() // positive test case
	{
		double basicSalary = 4000;
		basicSalaryCalculator.setBasicSalary(basicSalary);

		// to test socialinsurance
		double exceptedSocialInsurance = basicSalary * 0.25; // 1000
		assertEquals(exceptedSocialInsurance, basicSalaryCalculator.getSocialInsurance());

		// to test additionalbonus
		double expectedAdditionalBonus = basicSalary * 0.1;
		assertEquals(expectedAdditionalBonus, basicSalaryCalculator.getAdditionalBonas());

		// to test gross
		double expectedGross = basicSalary + exceptedSocialInsurance + expectedAdditionalBonus;
		assertEquals(expectedGross, basicSalaryCalculator.getGrossSalary());
	}

	@DisplayName("Test invalid salary")
	@Test
	void testBasicSalaryWithInValidSalary() // Negative test case
	{
		double basicSalary = -100;
		assertThrows(IllegalArgumentException.class, () -> {
			basicSalaryCalculator.setBasicSalary(basicSalary);
		});

	}
}

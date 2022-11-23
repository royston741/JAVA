package com.test.JUNIT_Test;

public class BasicSalaryCalculator {
	private double basicSalary;

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		if (basicSalary < 0) {
			throw new IllegalArgumentException("Negative Sallary");
		}
		this.basicSalary = basicSalary;
	}

	public double getGrossSalary() {
		return this.basicSalary + getSocialInsurance() + getAdditionalBonas();
	}

	public double getSocialInsurance() {
		return this.basicSalary * 0.25;
	}

	public double getAdditionalBonas() {
		return this.basicSalary * 0.1;
	}
}

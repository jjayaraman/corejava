package com.jai.corejava;

import java.util.Date;

public class Equals {

	public Equals() {
	}

	public static void main(String[] args) {

		Employee jay = new Employee("jjay", 23);
		Employee reshma = new Employee("ramba", 23);
		Employee jay2 = new Employee("jjay", 23);
		Employee jay3 = jay2;

		System.out.println(jay.equals(reshma));
		System.out.println(jay == reshma);

		System.out.println(jay.equals(jay2));
		System.out.println(jay == jay2);

		System.out.println(jay2.equals(jay3));
		System.out.println(jay2 == jay3);

		System.out.println(jay.hashCode());
		System.out.println(jay2.hashCode());
		System.out.println(jay3.hashCode());

	}

}

class Employee {

	private String name;
	private int age;
	private Date dob;
	private boolean isManager;

	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + (isManager ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (isManager != other.isManager)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
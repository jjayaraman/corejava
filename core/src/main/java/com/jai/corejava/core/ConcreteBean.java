package com.jai.corejava.core;

public class ConcreteBean extends AbstractBean {

	public void init() {
		System.out.println("ConcreteBean init() called...");
	}

	public static void main(String[] args) {

		ConcreteBean concreteBean = new ConcreteBean();
		concreteBean.clear();

		AbstractBean aBean = new ConcreteBean();
		aBean.clear();

	}

}

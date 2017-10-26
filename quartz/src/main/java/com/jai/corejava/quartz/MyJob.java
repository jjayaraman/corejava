package com.jai.corejava.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Some job to run in the Scheduler
 *
 * @author jjayaraman
 *
 */
public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello.... my first Job is executing...");
	}

}

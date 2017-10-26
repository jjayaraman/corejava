package com.jai.corejava.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Reference: http://www.quartz-scheduler.org/
 *
 *
 * @author jjayaraman
 *
 */
public class QuartzHello {

	public static void main(String[] args) {

		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();

			// define the job and tie it to our HelloJob class
			JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("Job1", "group1").build();

			SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();

			// Trigger the job to run now, and then repeat every 2 seconds, as per above scheduleBuilder
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(scheduleBuilder).build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);

			// scheduler.shutdown();
			// System.out.println("Shutting down scheduler....");

		}
		catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}

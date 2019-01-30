package com.revature.krowdboot.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.revature.krowdboot.utility.KrowdUtility;

/**
 * 
 * The main aspect class that manages the logging across multiple layers of the
 * application.
 * 
 * @author Eddy Soma
 *
 */
@Aspect
@Configuration
public class LoggingAspect {

	private final Logger controllerLogger;
	private final Logger serviceLogger;

	private final String controllerLayerPointCut = "within(com.revature.krowdboot.controller.*)";
	private final String serviceLayerPointCut = "within(com.revature.krowdboot.service.*)";

	private final String beforeExecutionMsg = "Prepare to executing <{}> layer method <{}> from class <{}>...";
	private final String afterExecutionMsg = "Finished executing <{}> layer method <{}> from class <{}>.";

	private final String afterReturningMsg = "Complete returning on <{}> layer method <{}> from class <{}>, return result is: {}.";
	private final String afterThrowingMsg = "Oops! <{}> layer method <{}> from class <{}> has thrown an uncaught exception. Exception type is: {}, exception message is: {}. Full stack trace is shown below {}";

	public LoggingAspect() {
		super();
		controllerLogger = LogManager.getLogger("controllerLogger");
		serviceLogger = LogManager.getLogger("serviceLogger");
	}

	public Logger getControllerLogger() {
		return controllerLogger;
	}

	public Logger getServiceLogger() {
		return serviceLogger;
	}

	/**
	 * 
	 * The method that issues an advice to log out a message before the execution of
	 * any controller methods.
	 * 
	 * @param jp
	 */
	@Before(value = controllerLayerPointCut)
	public void beforeLoggingAdviceToControllerLayer(JoinPoint jp) {

		controllerLogger.info(beforeExecutionMsg, BusinessLayerType.CONTROLLER, jp.getSignature(), jp.getTarget());

	}

	/**
	 * 
	 * The method that issues an advice to log out a message after any controller
	 * method has finished execution successfully and returned a value.
	 * 
	 * @param jp
	 * @param returnVal
	 */
	@AfterReturning(pointcut = controllerLayerPointCut, returning = "returnVal")
	public void afterReturningLoggingAdviceToControllerLayer(JoinPoint jp, Object returnVal) {

		String returnStr = null;
		if (returnVal != null) {
			returnStr = returnVal.toString();
		}

		controllerLogger.info(afterReturningMsg, BusinessLayerType.CONTROLLER, jp.getSignature(), jp.getTarget(),
				returnStr);

	}

	/**
	 * 
	 * The method that issues an advice to log out a message after any controller
	 * method throws an unhandled exception.
	 * 
	 * @param jp
	 * @param throwObj
	 */
	@AfterThrowing(pointcut = controllerLayerPointCut, throwing = "throwObj")
	public void afterthrowingLoggingAdviceToControllerLayer(JoinPoint jp, Throwable throwObj) {

		controllerLogger.error(afterThrowingMsg, BusinessLayerType.CONTROLLER, jp.getSignature(), jp.getTarget(),
				throwObj.getClass().getName(), throwObj.getMessage(), KrowdUtility.formatStackTrace(throwObj));

	}

	/**
	 * 
	 * The method that issues an advice to log out a message after the execution of
	 * any controller methods.
	 * 
	 * @param jp
	 */
	@After(value = controllerLayerPointCut)
	public void afterLoggingAdviceToControllerLayer(JoinPoint jp) {

		controllerLogger.info(afterExecutionMsg, BusinessLayerType.CONTROLLER, jp.getSignature(), jp.getTarget());

	}

	/**
	 * 
	 * The method that issues an advice to log out a message before the execution of
	 * any service methods.
	 * 
	 * @param jp
	 */
	@Before(value = serviceLayerPointCut)
	public void beforeLoggingAdviceToServiceLayer(JoinPoint jp) {

		serviceLogger.info(beforeExecutionMsg, BusinessLayerType.SERVICE, jp.getSignature(), jp.getTarget());

	}

	/**
	 * 
	 * The method that issues an advice to log out a message after any service
	 * method has finished execution successfully and returned a value.
	 * 
	 * @param jp
	 * @param returnVal
	 */
	@AfterReturning(pointcut = serviceLayerPointCut, returning = "returnVal")
	public void afterReturningLoggingAdviceToServiceLayer(JoinPoint jp, Object returnVal) {

		String returnStr = null;
		if (returnVal != null) {
			returnStr = returnVal.toString();
		}

		serviceLogger.info(afterReturningMsg, BusinessLayerType.SERVICE, jp.getSignature(), jp.getTarget(), returnStr);

	}

	/**
	 * 
	 * The method that issues an advice to log out a message after any service
	 * method throws an unhandled exception.
	 * 
	 * @param jp
	 * @param throwObj
	 */
	@AfterThrowing(pointcut = serviceLayerPointCut, throwing = "throwObj")
	public void afterthrowingLoggingAdviceToServiceLayer(JoinPoint jp, Throwable throwObj) {

		serviceLogger.fatal(afterThrowingMsg, BusinessLayerType.SERVICE, jp.getSignature(), jp.getTarget(),
				throwObj.getClass().getName(), throwObj.getMessage(), KrowdUtility.formatStackTrace(throwObj));

	}

	/**
	 * 
	 * The method that issues an advice to log out a message after the execution of
	 * any service methods.
	 * 
	 * @param jp
	 */
	@After(value = serviceLayerPointCut)
	public void afterLoggingAdviceToServiceLayer(JoinPoint jp) {

		serviceLogger.info(afterExecutionMsg, BusinessLayerType.SERVICE, jp.getSignature(), jp.getTarget());

	}

}

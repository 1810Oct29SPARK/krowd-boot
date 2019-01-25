package com.revature.krowdboot.model;

public class SessionInfo {

	public SessionInfo(String session, String accessToken, String challengeResult) {
		this.session = session;
		this.accessToken = accessToken;
		this.challengeResult = challengeResult;
	}

	final private String session;
	final private String accessToken;
	final private String challengeResult;

	public String getSession() {
		return session;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getChallengeResult() {
		return challengeResult;
	}

}

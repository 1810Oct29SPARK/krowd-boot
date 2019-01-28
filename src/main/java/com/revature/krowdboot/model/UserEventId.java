package com.revature.krowdboot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserEventId implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserEventId() {
		super();
	}

	public UserEventId(int userId, int eventId) {
		super();
		this.userId = userId;
		this.eventId = eventId;
	}

	@Column(name = "user_id")
	private int userId;

	@Column(name = "event_id")
	private int eventId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "UserEventId [userId=" + userId + ", eventId=" + eventId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEventId other = (UserEventId) obj;
		return eventId == other.eventId && userId == other.userId;
	}

}

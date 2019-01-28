package com.revature.krowdboot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	public Comment(int id, @NotNull String comment, @NotNull int flag, User userId, Event eventId) {
		super();
		this.id = id;
		this.comment = comment;
		this.flag = flag;
		this.userId = userId;
		this.eventId = eventId;
	}

	public Comment(int id, @NotNull String comment, @NotNull int flag, User userId, Event eventId, String timestamp) {
		super();
		this.id = id;
		this.comment = comment;
		this.flag = flag;
		this.userId = userId;
		this.eventId = eventId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@NotNull
	private String comment;

	@Column
	@NotNull
	private int flag;

	@Column
	private String timestamp;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "event_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Event eventId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Event getEventId() {
		return eventId;
	}

	public void setEventId(Event eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", flag=" + flag + ", userId=" + userId + ", eventId="
				+ eventId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, eventId, flag, id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(eventId, other.eventId) && flag == other.flag
				&& id == other.id && Objects.equals(userId, other.userId);
	}

	@JsonProperty("userId")
	private void unpackNestedUser(int user_id) {
		this.userId = new User();
		userId.setId(user_id);
	}

	@JsonProperty("eventId")
	private void unpackNestedEvent(int event_id) {
		this.eventId = new Event();
		eventId.setId(event_id);
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}

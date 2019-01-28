package com.revature.krowdboot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_event")
public class UserEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserEvent() {
		super();
	}

	public UserEvent(User u, Event e) {
		super();
		this.user = u;
		this.event = e;
	}

	public UserEvent(UserEventId id, User user, Event event, int rating) {
		super();
		this.id = id;
		this.user = user;
		this.event = event;
		this.rating = rating;
	}

	@EmbeddedId
	private UserEventId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventId")
	private Event event;

	@Column(name = "rating", columnDefinition = "int default 0")
	private int rating;

	public UserEventId getId() {
		return id;
	}

	public void setId(UserEventId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "UserEvent [id=" + id + ", user=" + user + ", event=" + event + ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(event, id, rating, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEvent other = (UserEvent) obj;
		return Objects.equals(event, other.event) && Objects.equals(id, other.id) && rating == other.rating
				&& Objects.equals(user, other.user);
	}

}

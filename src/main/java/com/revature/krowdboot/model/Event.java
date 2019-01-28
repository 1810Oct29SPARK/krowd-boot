package com.revature.krowdboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "event")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}

	public Event(int id, @NotNull String name, String picture, String description, @NotNull String date,
			@NotNull Address address, @NotNull Integer score, @NotNull Integer flag, @NotNull EventCategory categoryId,
			@NotNull User userId) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.description = description;
		this.date = date;
		this.address = address;
		this.score = score;
		this.flag = flag;
		this.categoryId = categoryId;
		this.userId = userId;

	}

	public Event(@NotNull String name, String picture, String description, @NotNull String date,
			@NotNull Address address, @NotNull Integer score, @NotNull Integer flag, @NotNull EventCategory categoryId,
			@NotNull User userId) {
		super();
		this.name = name;
		this.picture = picture;
		this.description = description;
		this.date = date;
		this.address = address;
		this.score = score;
		this.flag = flag;
		this.categoryId = categoryId;
		this.userId = userId;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private String description;

	@Column
	private String picture;

	@Column
	@NotNull
	private String date;

	@Transient
	private Integer score;

	@Column
	@NotNull
	private Integer flag;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "event_category_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EventCategory categoryId;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserEvent> users = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "address_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Address address;

	// weird
//	public List<UserEvent> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserEvent> users) {
//		this.users = users;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public EventCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(EventCategory categoryId) {
		this.categoryId = categoryId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", picture=" + picture + ", date=" + date + ", address=" + address
				+ ", score=" + score + ", flag=" + flag + ", categoryId=" + categoryId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, categoryId, date, flag, id, name, picture, score, flag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(address, other.address) && Objects.equals(categoryId, other.categoryId)
				&& Objects.equals(date, other.date) && flag == other.flag && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(picture, other.picture) && score == other.score;
	}

}

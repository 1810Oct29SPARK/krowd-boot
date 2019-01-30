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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "KROWD_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public User(@NotNull String email, @NotNull String firstname, @NotNull String lastname, @NotNull String username,
			String picture, @NotNull int reputation, @NotNull int accountStatus, @NotNull UserRole roleId) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.picture = picture;
		this.reputation = reputation;
		this.accountStatus = accountStatus;
		this.roleId = roleId;
	}

	public User(int id, @NotNull String email, @NotNull String firstname, @NotNull String lastname,
			@NotNull String username, String picture, @NotNull int reputation, @NotNull int accountStatus,
			@NotNull UserRole roleId) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.picture = picture;
		this.reputation = reputation;
		this.accountStatus = accountStatus;
		this.roleId = roleId;
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotNull
	private String email;

	@Column
	@NotNull
	private String firstname;

	@Column
	@NotNull
	private String lastname;

	@Column
	@NotNull
	private String username;

	@Column
	private String cognito;

	@Column
	private String picture;

	@Column
	@NotNull
	private int reputation;

	@Column
	@NotNull
	private int accountStatus;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ROLE_ID")
	private UserRole roleId;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserEvent> events = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getCognito() {
		return cognito;
	}

	public void setCognito(String cognito) {
		this.cognito = cognito;
	}

	public UserRole getRoleId() {
		return roleId;
	}

	public void setRoleId(UserRole roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", picture=" + picture + ", reputation=" + reputation + ", accountStatus="
				+ accountStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountStatus, email, firstname, id, lastname, picture, reputation, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return accountStatus == other.accountStatus && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(picture, other.picture)
				&& reputation == other.reputation && Objects.equals(username, other.username);
	}

	@JsonProperty("roleId")
	private void unpackNestedRole(int role_id) {
		this.roleId = new UserRole();
		roleId.setId(role_id);
	}

}

package com.ude.sdp.dto;

public class RoleDTO extends DTO {

	private String id;
	private String desc;
	private Role role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleDTO(String id, String desc, Role role) {
		super();
		this.id = id;
		this.desc = desc;
		this.role = role;
	}

	public RoleDTO() {
		super();
	}

}

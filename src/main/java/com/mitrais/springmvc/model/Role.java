package com.mitrais.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id", columnDefinition = "TINYINT")
    protected int id;

    @Column(name = "role_name")
    protected String roleName;

    @Column(name = "alias")
    protected String alias;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "role")
    protected User user;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

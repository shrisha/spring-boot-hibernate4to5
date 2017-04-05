package com.shrisha.repository;

import javax.persistence.*;

/**
 * Created by sradhakrishna on 4/4/17.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "UK_User_username", columnNames = "username"),
        @UniqueConstraint(name = "UK_User_col1_col2", columnNames = {"col1","col2"})},
        indexes = {
                @Index(name = "IDX_col3", columnList = "col3")})
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String col1;

    @Column
    private String col2;

    @Column(nullable = false)
    private String col3 = "default";

    @Column
    private String camelCaseCol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3;
    }

    public String getCamelCaseCol() {
        return camelCaseCol;
    }

    public void setCamelCaseCol(String camelCaseCol) {
        this.camelCaseCol = camelCaseCol;
    }
}

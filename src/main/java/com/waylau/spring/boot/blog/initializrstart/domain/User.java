package com.waylau.spring.boot.blog.initializrstart.domain;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User. 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017年2月24日
 */
@XmlRootElement // mediatype 转为xml
@Data
@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 用户的唯一标识
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;

	protected User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
 	public String toString(){
		return String.format("User[id=%f, name ='%s',age ='%d']",id,name,age);
	}

}

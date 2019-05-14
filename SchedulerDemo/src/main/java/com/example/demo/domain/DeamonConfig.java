package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeamonConfig {

	@Id
	@GeneratedValue
	private int id;

	private String refreshInterval;

	@Override
	public String toString() {
		return "DeamonConfig [id=" + id + ", refreshInterval=" + refreshInterval + "]";
	}

}

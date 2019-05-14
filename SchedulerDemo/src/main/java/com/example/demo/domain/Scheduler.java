package com.example.demo.domain;

import java.sql.Timestamp;

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
public class Scheduler {
	@Id
	@GeneratedValue
	private int id;
	private String status;
	private Timestamp start_date;

	@Override
	public String toString() {
		return "Scheduler [id=" + id + ", status=" + status + ", start_date=" + start_date + "]";
	}
}

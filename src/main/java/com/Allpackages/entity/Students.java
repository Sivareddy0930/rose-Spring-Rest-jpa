package com.Allpackages.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class Students {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer student_id;
	@Column
	private String student_name;
	@Column
	private Integer student_marks;
}

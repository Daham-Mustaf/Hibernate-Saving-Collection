package main.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_table")
@DynamicUpdate
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(name = "stuId-generator", initialValue = 1, allocationSize
	// = 1)
	private Integer studentId;

	@Column(name = "student_name", length = 100, nullable = false)
	private String studentName;

	@Column(length = 46, name = "email", unique = true)
	private String email;

	@Column(name = "date_of_joing")
	private Date doj;

	@ElementCollection
	@JoinTable(name = "Address_table", joinColumns = @JoinColumn(name = "student_id"))
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "increment-gen", type = @Type(type="long"))private Collection<Address> listAddresses = new ArrayList<>();

}
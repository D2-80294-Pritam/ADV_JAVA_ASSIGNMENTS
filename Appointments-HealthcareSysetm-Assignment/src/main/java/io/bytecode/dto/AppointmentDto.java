package io.bytecode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppointmentDto {
	private Integer id;
	private String date;
	private String time;
	private Integer patientId;
	private Integer doctorId;
}

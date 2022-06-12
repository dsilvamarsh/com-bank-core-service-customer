package com.bank.core.service.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer  implements Serializable{

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String name;
}

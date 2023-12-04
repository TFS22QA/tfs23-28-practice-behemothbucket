package ru.tinkoff.fintech.qa.modelsAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseUser{

	@JsonProperty("value")
	private String value;

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
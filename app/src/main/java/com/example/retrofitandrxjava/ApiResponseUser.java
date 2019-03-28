package com.example.retrofitandrxjava;

import com.google.gson.annotations.SerializedName;

public class ApiResponseUser{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ApiResponseUser{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}
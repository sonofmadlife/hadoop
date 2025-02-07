package com.jike.shop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class ShopBean implements Writable{

	private int month;
	private String name;
	private int price;
	public ShopBean(){}
	public ShopBean(int month,String name,int price){
		this.month=month;
		this.name=name;
		this.price=price;
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShopBean [month=" + month + ", name=" + name + ", price=" + price + "]";
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		this.month=in.readInt();
		this.name=in.readUTF();
		this.price=in.readInt();
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(month);
		out.writeUTF(name);
		out.writeInt(price);
	}
	
}

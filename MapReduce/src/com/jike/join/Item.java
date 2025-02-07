package com.jike.join;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Item implements Writable,Cloneable{

	private String orderId;
	private  int date;
	private String goodId;
	private int num;
	private String kind;
	private int price;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [订单Id=" + orderId + ", 订单日期=" + date + ", 物品Id=" + goodId + ", 出货量=" + num + ", 品牌=" + kind
				+ ", 商品单价=" + price + "]";
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.orderId=in.readUTF();
		this.date=in.readInt();
		this.goodId=in.readUTF();
		this.num=in.readInt();
		this.kind=in.readUTF();
		this.price=in.readInt();
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(orderId);
		out.writeInt(date);
		out.writeUTF(goodId);
		out.writeInt(num);
		out.writeUTF(kind);
		out.writeInt(price);
	}
	public Item clone(){
		Item o=null;
		try {
			o=(Item)super.clone();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	
}

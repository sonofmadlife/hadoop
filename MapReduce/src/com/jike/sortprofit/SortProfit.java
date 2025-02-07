package com.jike.sortprofit;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class SortProfit implements WritableComparable<SortProfit>{

	private int month;
	private int profit;
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "SortProfit [month=" + month + ", profit=" + profit + "]";
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.month=in.readInt();
		this.profit=in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(month);
		out.writeInt(profit);
	}

	@Override
	public int compareTo(SortProfit o) {
		// TODO Auto-generated method stub
		return o.profit-this.profit;
	}

}

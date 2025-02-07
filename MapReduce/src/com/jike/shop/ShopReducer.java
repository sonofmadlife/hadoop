package com.jike.shop;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ShopReducer extends Reducer<Text, ShopBean, Text, ShopBean>{

	@Override
	protected void reduce(Text key, Iterable<ShopBean> value, Reducer<Text, ShopBean, Text, ShopBean>.Context context)
			throws IOException, InterruptedException {
		ShopBean fb = new ShopBean();
		
		for(ShopBean shop:value){
			fb.setMonth(shop.getMonth());
			fb.setName(shop.getName());
			fb.setPrice(shop.getPrice()+fb.getPrice());
		}
//		Iterator<ShopBean> it = value.iterator();
//		while(it.hasNext()){
//			ShopBean next = it.next();
//			fb.setMonth(next.getMonth());
//			fb.setName(next.getName());
//			fb.setPrice(fb.getPrice()+next.getPrice());
//		}
		context.write(key, fb);
	}
}

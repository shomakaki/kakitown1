package com.example.demo.domain;

import java.util.List;



public class Item {
	

		private Integer id;
		private String name;
		private String description;
		private Integer priceM;
		private Integer priceL;
		private String imagePath;
//		private String imagePath2;
//		private String imagePath3;
//		private List<Review> reviewList;
		private List<Item> itemList;
		// private List<Ranking> rankingList;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getPriceM() {
			return priceM;
		}
		public void setPriceM(Integer priceM) {
			this.priceM = priceM;
		}
		public Integer getPriceL() {
			return priceL;
		}
		public void setPriceL(Integer priceL) {
			this.priceL = priceL;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
//		public String getImagePath2() {
//			return imagePath2;
//		}
//		public void setImagePath2(String imagePath2) {
//			this.imagePath2 = imagePath2;
//		}
//		public String getImagePath3() {
//			return imagePath3;
//		}
//		public void setImagePath3(String imagePath3) {
//			this.imagePath3 = imagePath3;
//		}
		public List<Item> getItemList() {
			return itemList;
		}
		public void setItemList(List<Item> itemList) {
			this.itemList = itemList;
		}
		
		
		

}

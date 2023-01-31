package com.marangoz.hepsiburada.model

data class CategorySub(var categorySub_id:Int,var categorySubName:String,var categoryElamansList:ArrayList<CategorySubElemans>,var categoryMain:Int,var isExpandable : Boolean) {
}
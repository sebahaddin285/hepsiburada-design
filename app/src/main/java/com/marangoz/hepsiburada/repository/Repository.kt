package com.marangoz.hepsiburada.repository

import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.model.CategoryMain
import com.marangoz.hepsiburada.model.CategorySub
import com.marangoz.hepsiburada.model.CategorySubElemans
import com.marangoz.hepsiburada.model.Products

class Repository {

    fun allData(): List<Products> {
        val u1 = Products(
            1,
            "Asus V222FAK Intel Core I3\n10110U 8 GB 256 GB SSD...",
            "10.489,00 TL",
            R.drawable.laptop
        )
        val u2 = Products(
            1,
            "Anker SoundCore Life\nKablosuz Bluetooth 5.0 Kula...",
            "899,00 TL",
            R.drawable.kulaklik
        )
        val u3 = Products(
            1,
            "Oral B D100 Vitality Cross Action\nŞarjlı Diş Fırça...",
            "289,50 TL",
            R.drawable.oralb
        )
        val u4 = Products(
            1,
            "Samsung Galaxy Z Flip4\n128 GB 8 GB Ram...",
            "14.489,00 TL",
            R.drawable.samsung
        )
        val u5 = Products(
            1,
            "Bioderma Sebium Hydra\nCream Nemlendirici Krem...",
            "249,50 TL",
            R.drawable.bioderma
        )
        val proList = ArrayList<Products>()
        proList.add(u1)
        proList.add(u2)
        proList.add(u3)
        proList.add(u4)
        proList.add(u5)

        return proList
    }
    fun categoryMainAllData(): List<CategoryMain> {
        val u1 = CategoryMain(1,"Telefon Tablet\nve Aksesuar",R.drawable.cate1,true)
        val u2 = CategoryMain(2,"Bilgisayar\nTeknoloji\nElektronik",R.drawable.cate2,false)
        val u3 = CategoryMain(3,"Moda,Giyim\nAksesuar",R.drawable.cate3,false)
        val u4 = CategoryMain(4,"Tv Görüntü ve \nSes Sistemleri",R.drawable.cate4,false)
        val u5 = CategoryMain(5,"Ev ve Yaşam",R.drawable.cate5,false)
        val u6 = CategoryMain(6,"Elektrikli ev\nAletleri",R.drawable.cate6,false)
        val u7 = CategoryMain(7,"Ev ve Yaşam",R.drawable.cate8,false)
        val u8 = CategoryMain(8,"Telefon Tablet\nve Aksesuar",R.drawable.cate7,false)
        val categoryMainList = ArrayList<CategoryMain>()
        categoryMainList.add(u1)
        categoryMainList.add(u2)
        categoryMainList.add(u3)
        categoryMainList.add(u4)
        categoryMainList.add(u5)
        categoryMainList.add(u6)
        categoryMainList.add(u7)
        categoryMainList.add(u8)

        return categoryMainList
    }

    fun categorySubAllData(mainId : Int) : List<CategorySub>{
        var subEleman = CategorySubElemans(1,"Android\nTelefonlar",R.drawable.sub1)
        var subEleman1 = CategorySubElemans(2,"İOS Telefonlar",R.drawable.sub2)
        var subEleman2 = CategorySubElemans(3,"Tablet",R.drawable.sub4)
        var subEleman3 = CategorySubElemans(4,"Akıllı\nCihaz",R.drawable.sub6)
        var subEleman4 = CategorySubElemans(5,"Giyim",R.drawable.sub5)
        var subEleman5 = CategorySubElemans(6,"Telefon",R.drawable.sub1)
        var subEleman6 = CategorySubElemans(7,"Saatler",R.drawable.sub3)
        var subList = ArrayList<CategorySubElemans>()
        subList.add(subEleman)
        subList.add(subEleman1)
        subList.add(subEleman2)
        subList.add(subEleman3)
        subList.add(subEleman3)
        var subList1 = ArrayList<CategorySubElemans>()
        subList1.add(subEleman4)
        subList1.add(subEleman1)
        subList1.add(subEleman2)
        subList1.add(subEleman5)
        subList1.add(subEleman6)
        var categorySub1 = CategorySub(1,"Cep Telefonları",subList,1,true)
        var categorySub2 = CategorySub(2,"Tablet",subList1,1,false)
        var categorySub3 = CategorySub(2,"Telsiz / Masaüstü Telefonlar",subList,1,false)

        var categorySub4 = CategorySub(1,"Telefonlar",subList1,2,true)
        var categorySub5 = CategorySub(2,"Tablet",subList,2,false)
        var categorySub6 = CategorySub(2,"Masaüstü\nBilgisayar",subList1,2,false)
        var categorySub7 = CategorySub(2,"Telefon\nKılıf",subList,2,false)

        var categorySub8 = CategorySub(1,"Moda",subList1,3,true)
        var categorySub9 = CategorySub(2,"Elbise",subList,3,false)
        var categorySub10 = CategorySub(2,"Takılar",subList1,3,false)
        var categorySub11 = CategorySub(2,"Pantolonlar",subList,3,false)

        var categorySub12 = CategorySub(1,"Tv Aksesuar",subList1,3,false)
        var categorySub13 = CategorySub(2,"Elbise",subList,4,true)
        var categorySub14 = CategorySub(2,"Takılar",subList1,4,false)
        var categorySub15 = CategorySub(2,"Pantolonlar",subList,3,false)

        var categorySub16 = CategorySub(1,"Tv Aksesuar",subList1,4,false)
        var categorySub17 = CategorySub(2,"Elbise",subList,4,false)

        var categorySub18 = CategorySub(1,"Tv Aksesuar",subList1,5,true)
        var categorySub19 = CategorySub(2,"Elbise",subList,6,true)
        var categorySub20 = CategorySub(1,"Tv Aksesuar",subList1,7,true)
        var categorySub21 = CategorySub(2,"Elbise",subList,8,true)



        var categoryList = ArrayList<CategorySub>()
        categoryList.add(categorySub1)
        categoryList.add(categorySub2)
        categoryList.add(categorySub3)
        categoryList.add(categorySub4)
        categoryList.add(categorySub5)
        categoryList.add(categorySub6)
        categoryList.add(categorySub7)
        categoryList.add(categorySub8)
        categoryList.add(categorySub9)
        categoryList.add(categorySub10)
        categoryList.add(categorySub11)
        categoryList.add(categorySub12)
        categoryList.add(categorySub13)
        categoryList.add(categorySub14)
        categoryList.add(categorySub15)
        categoryList.add(categorySub16)
        categoryList.add(categorySub17)
        categoryList.add(categorySub18)
        categoryList.add(categorySub19)
        categoryList.add(categorySub20)
        categoryList.add(categorySub21)

        var categoryMainList = ArrayList<CategorySub>()
        categoryList.forEach(){
            if (it.categoryMain == mainId ){
                categoryMainList.add(it)
            }
        }


        return categoryMainList
    }
}
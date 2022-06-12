package com.example.truecallerappokeh.data.mapper

import com.example.truecallerappokeh.common.CONTENT_CLASS
import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.WebData
import org.jsoup.nodes.Element

fun WebData.toDisplayData(): DisplayData {
    val listOfWebCharCat = mutableListOf<String>()
    val webElement = this.doc!!.select(CONTENT_CLASS).first()
    val webItem = webElement.children()

    for (i in webItem) {
        listOfWebCharCat.addAll(getStringElement(i))
    }

    return DisplayData(
        getFirstTask(listOfWebCharCat),
        getSecTask(listOfWebCharCat),
        getThirdTask(listOfWebCharCat)
    )

}

fun getFirstTask(doc: MutableList<String>): String {
    return doc[9]
}

fun getSecTask(doc: MutableList<String>): ArrayList<String> {
    val arrayList = arrayListOf<String>()
    for (i in 0..doc.lastIndex step 10) {
        if (i != 0) arrayList.add(doc[i - 1])
    }
    return arrayList
}

fun getThirdTask(doc: MutableList<String>): Map<String, Int> {
    return doc.groupingBy { it }.eachCount()
}

fun getStringElement(element: Element): List<String> {
    val list = element.text().split(" ").toMutableList()
    list.add(0, "<${element.tagName()}>")
    list.add(list.size, "</${element.tagName()}>")
    return list
}
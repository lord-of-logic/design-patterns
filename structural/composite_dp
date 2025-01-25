package com.ranjith.digitalitems

interface DigitalItem {
    fun printItems()
}

package com.ranjith.digitalitems

class File(private val fileName: String): DigitalItem{
    override fun printItems() {
        println("File Name: $fileName")
    }
}

package com.ranjith.digitalitems

class Folder(private val folderName: String): DigitalItem {
    private val itemList = mutableListOf<DigitalItem> ()

    fun addItem(digitalItem: DigitalItem) {
        itemList.add(digitalItem)
    }

    fun removeItem(digitalItem: DigitalItem) {
        itemList.remove(digitalItem)
    }

    override fun printItems() {
        println("Folder Name: $folderName")
        if(itemList.isEmpty()) {
            println("$folderName is empty")
            return
        }
        itemList.forEach {
            it.printItems()
        }
    }
}

package com.ranjith.service

import com.ranjith.digitalitems.File
import com.ranjith.digitalitems.Folder
import org.springframework.stereotype.Service

@Service
class DigitalItemService {

    fun manageDigitalItems() {
        val folder1 = Folder("Folder 1")
        val file1 = File("File 1")
        folder1.addItem(file1)
        val folder2 = Folder("Folder 2")
        val file2 = File("File 2")
        folder2.addItem(file2)
        folder1.addItem(folder2)
        folder1.printItems()
    }
}

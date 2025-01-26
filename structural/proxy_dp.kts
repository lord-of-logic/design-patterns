package com.ranjith.classes

class Image(
    val imageId: Int = 0,
    val imageFilePath: String = "default_image.jpg",
    val imageData: ByteArray = byteArrayOf()
)

package com.ranjith.imageprocessor

interface ImageProcessor {
    fun processImage()
}

package com.ranjith.imageprocessor

import com.ranjith.classes.Image

class ImageProcessorConcrete(private val imageFilePath: String): ImageProcessor {
    private var image: Image? = null
    init {
        image = loadImage()
    }

    private fun loadImage(): Image {
        println("Loading image from file path: $imageFilePath")
        return Image()
    }

    override fun processImage() {
        println("Processing image using High pass filter")
    }
}

package com.ranjith.imageprocessor

class ImageProcessorProxy(private val imageFilePath: String): ImageProcessor {
    private var imageProcessorConcrete: ImageProcessorConcrete? = null

    override fun processImage() {
        if(imageProcessorConcrete == null)
            imageProcessorConcrete = ImageProcessorConcrete(imageFilePath)
        imageProcessorConcrete!!.processImage()
    }
}

package com.ranjith.service

import com.ranjith.imageprocessor.ImageProcessorProxy
import org.springframework.stereotype.Service

@Service
class ImageProcessorService {
    fun processImageManager() {
        val imageProcessor = ImageProcessorProxy("/home/images/image1.png") // No heavy lifting
        // Do other stuff
        imageProcessor.processImage() // Lazy loading when actually needed
    }
}

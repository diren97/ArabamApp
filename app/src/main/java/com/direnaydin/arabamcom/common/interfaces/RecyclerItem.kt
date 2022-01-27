package com.direnaydin.arabamcom.common.interfaces

import androidx.annotation.LayoutRes
import java.io.Serializable

interface RecyclerItem : Serializable {
    @get:LayoutRes
    val layoutId: Int

    val id: Int?
}

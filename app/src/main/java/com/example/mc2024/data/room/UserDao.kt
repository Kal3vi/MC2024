package com.example.mc2024.data.room

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.TypeConverter
import kotlinx.coroutines.flow.Flow
import com.example.mc2024.data.entity.Users
import java.nio.ByteBuffer

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE username LIKE :username")
    abstract suspend fun findByName(username: String): Users?

    @Query("SELECT * FROM users ORDER BY uid DESC")
    abstract fun getUserDetails() : Flow<List<Users>>

    @Insert
    abstract suspend fun insertUser(users: Users): Long

}

/*
class Converters{
    @TypeConverter
    fun bitmapToBase64(bitmap: Bitmap) : String{
        // create a ByteBuffer and allocate size equal to bytes in   the bitmap
        val byteBuffer = ByteBuffer.allocate(bitmap.height * bitmap.rowBytes)
        //copy all the pixels from bitmap to byteBuffer
        bitmap.copyPixelsToBuffer(byteBuffer)
        //convert byte buffer into byteArray
        val byteArray = byteBuffer.array()
        //convert byteArray to Base64 String with default flags
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    @TypeConverter
    fun base64ToBitmap(base64String: String): Bitmap {
        //convert Base64 String into byteArray
        val byteArray = Base64.decode(base64String, Base64.DEFAULT)
        //byteArray to Bitmap
        return BitmapFactory.decodeByteArray(byteArray,
            0, byteArray.size)
    }
}*/
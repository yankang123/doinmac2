import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.doinmac2.mpdel.Item
import com.example.doinmac2.mpdel.ItemDao
import com.example.doinmac2.mpdel.User
import com.example.doinmac2.mpdel.UserDao

@Database(version = 2, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            return instance?.let { it }
                ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                    .allowMainThreadQueries()
                    .build()
                    .apply { instance = this }
        }
    }
}

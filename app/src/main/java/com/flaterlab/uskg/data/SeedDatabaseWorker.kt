package com.flaterlab.uskg.data

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.flaterlab.uskg.models.University
import com.flaterlab.uskg.util.AppConstants.UNIVERSITIES_FILE_NAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(
        context: Context,
        workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(UNIVERSITIES_FILE_NAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val universityType = object : TypeToken<List<University>>() {}.type
                    val universities: List<University> = Gson().fromJson(jsonReader, universityType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.universitiesDao.insertAll(universities)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}
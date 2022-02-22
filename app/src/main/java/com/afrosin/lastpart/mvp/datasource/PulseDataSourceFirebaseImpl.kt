package com.afrosin.lastpart.mvp.datasource

import android.util.Log
import com.afrosin.lastpart.mvp.model.Pulse
import com.afrosin.lastpart.mvp.presenter.PulseFragmentPresenter
import com.afrosin.lastpart.utils.PulseMapping
import com.github.terrakok.cicerone.Router
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PulseDataSourceFirebaseImpl : PulseDataSource {

    private val store = Firebase.firestore
    private val pulseCollection = store.collection(PULSE_COLLECTION_NAME)

    companion object {
        private const val PULSE_COLLECTION_NAME = "pulses"
        private const val TAG = "[PULSE_COLLECTION_NAME]"
    }

    override fun getPulseData(router: Router) {
        pulseCollection.orderBy(PulseMapping.Fields.DATE_CREATED, Query.Direction.DESCENDING)
            .get()
            .addOnCompleteListener { task: Task<QuerySnapshot> ->
                if (task.isSuccessful) {
                    val pulseList = mutableListOf<Pulse>()
                    for (document in task.result!!) {
                        pulseList.add(PulseMapping.toPulse(document.data))
                    }
                    router.sendResult(
                        PulseFragmentPresenter.GET_ALL_PULSE_DATA_RESULT, pulseList
                    )
                    Log.d(TAG, "success " + pulseList.size + " count")
                } else {
                    Log.d(TAG, "error: get failed with: ", task.exception)
                }
            }
            .addOnFailureListener { e: Exception? ->
                Log.d(TAG, "error: get failed with: ", e)
            }
    }

    override fun setPulseData(pulse: Pulse) {
        pulseCollection.add(PulseMapping.toDocument(pulse))
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Pulse item added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding pulse", e)
            }
    }

}

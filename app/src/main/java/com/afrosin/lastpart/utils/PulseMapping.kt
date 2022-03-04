package com.afrosin.lastpart.utils

import com.afrosin.lastpart.mvp.model.Pulse
import com.google.firebase.Timestamp

object PulseMapping {
    fun toPulse(doc: Map<String?, Any?>): Pulse {
        val dateCreated = doc[Fields.DATE_CREATED] as Timestamp
        val topPressure = (doc[Fields.TOP_PRESSURE] as Long).toInt()
        val bottomPressure = (doc[Fields.BOTTOM_PRESSURE] as Long).toInt()
        val pulseVar = (doc[Fields.PULSE_VAR] as Long).toInt()


        return Pulse(dateCreated.toDate(), topPressure, bottomPressure, pulseVar)
    }

    fun toDocument(pulse: Pulse): Map<String, Any> {
        val document: MutableMap<String, Any> = HashMap()
        document[Fields.DATE_CREATED] = pulse.dateCreated
        document[Fields.TOP_PRESSURE] = pulse.topPressure
        document[Fields.BOTTOM_PRESSURE] = pulse.bottomPressure
        document[Fields.PULSE_VAR] = pulse.pulse

        return document
    }

    object Fields {
        const val DATE_CREATED = "dateCreated"
        const val TOP_PRESSURE = "topPressure"
        const val BOTTOM_PRESSURE = "bottomPressure"
        const val PULSE_VAR = "pulse"

    }
}

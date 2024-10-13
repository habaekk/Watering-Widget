package com.bada.widgetprac

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import java.util.Date


/**
 * Implementation of App Widget functionality.
 */
class PracWidget : AppWidgetProvider() {

    companion object {
        const val RESET_CLICK = "RESET_CLICK"
        const val WIDGET_CLICK = "WIDGET_CLICK"
        const val WIDGET_ID = "WIDGET_ID"
        const val WIDGET_VIEW_ID = "WIDGET_VIEW_ID"
    }


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        println("onUpdate")
        println("cup_filled: ${R.drawable.cup_filled}")
        println("cup_empty: ${R.drawable.cup_empty}")

        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        println("updateAppWidget")

        val views = RemoteViews(context.packageName, R.layout.prac_widget)
        val widgetIds = intArrayOf(R.id.cupButton1, R.id.cupButton2, R.id.cupButton3, R.id.cupButton4, R.id.cupButton5, R.id.cupButton6, R.id.cupButton7, R.id.cupButton8, R.id.cupButton9, R.id.cupButton10)

        for (viewId in widgetIds) {
            val intent = Intent(context, PracWidget::class.java).apply {
                action = WIDGET_CLICK
                putExtra(WIDGET_ID, appWidgetId)
                putExtra(WIDGET_VIEW_ID, viewId)
            }
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                viewId,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(viewId, pendingIntent)
        }

        val resetIntent = Intent(context, PracWidget::class.java).apply {
            action = RESET_CLICK
            putExtra(WIDGET_ID, appWidgetId)
            putExtra(WIDGET_VIEW_ID, R.id.resetButton)
        }
        val resetPendingIntent = PendingIntent.getBroadcast(
            context,
            R.id.resetButton,
            resetIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        views.setOnClickPendingIntent(R.id.resetButton, resetPendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        println("onReceive")
        println(intent.action)
        if (WIDGET_CLICK == intent.action) {

            val viewId = intent.getIntExtra(WIDGET_VIEW_ID, 0)

            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context!!, PracWidget::class.java)
            )
            val views = RemoteViews(context.packageName, R.layout.prac_widget)

            // Toggle image between "on" and "off"
            val newState = someLogicToCheckCurrentState(context, viewId)
            val nextImage = if (newState) R.drawable.cup_filled else R.drawable.cup_empty
            println("nextImage: $nextImage")
            println("viewId: $viewId")
            views.setImageViewResource(viewId, nextImage)

            var counter = MyApplication.preferences.getStringCups(Date(), "0").toInt()

            if (nextImage == R.drawable.cup_filled) {
                if (counter < 10)
                    counter++
            } else {
                if (counter > 0)
                    counter--
            }

            MyApplication.preferences.setStringCups(Date(), counter.toString())

            appWidgetManager.updateAppWidget(appWidgetIds, views)
        }

        if (RESET_CLICK == intent.action) {
            val viewId = intent.getIntExtra(WIDGET_VIEW_ID, 0) // xxxxxxxxx

            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context!!, PracWidget::class.java)
            )
            val views = RemoteViews(context.packageName, R.layout.prac_widget)

            MyApplication.preferences.setStringCups(Date(), "0")

            views.setImageViewResource(R.id.cupButton1, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton2, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton3, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton4, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton5, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton6, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton7, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton8, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton9, R.drawable.cup_empty)
            views.setImageViewResource(R.id.cupButton10, R.drawable.cup_empty)



            val sharedPreferences = context.getSharedPreferences("CupsOnOff", Context.MODE_PRIVATE)
            with (sharedPreferences.edit()) {
                putBoolean(R.id.cupButton1.toString(), false)
                putBoolean(R.id.cupButton2.toString(), false)
                putBoolean(R.id.cupButton3.toString(), false)
                putBoolean(R.id.cupButton4.toString(), false)
                putBoolean(R.id.cupButton5.toString(), false)
                putBoolean(R.id.cupButton6.toString(), false)
                putBoolean(R.id.cupButton7.toString(), false)
                putBoolean(R.id.cupButton8.toString(), false)
                putBoolean(R.id.cupButton9.toString(), false)
                putBoolean(R.id.cupButton10.toString(), false)

                apply()
            }

            appWidgetManager.updateAppWidget(appWidgetIds, views)
        }
    }

    private fun someLogicToCheckCurrentState(context: Context, viewId: Int): Boolean {
        val sharedPreferences = context.getSharedPreferences("CupsOnOff", Context.MODE_PRIVATE)
        val currentState = sharedPreferences.getBoolean(viewId.toString(), false)
        // Toggle the state
        val newState = !currentState
        with (sharedPreferences.edit()) {
            putBoolean(viewId.toString(), newState)
            apply()
        }
        return newState
    }
}
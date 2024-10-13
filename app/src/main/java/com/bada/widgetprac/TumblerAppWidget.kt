package com.bada.widgetprac

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.util.Date

/**
 * Implementation of App Widget functionality.
 */
class TumblerAppWidget : AppWidgetProvider() {
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
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.tumbler_app_widget)
        val widgetIds = intArrayOf(
            R.id.tumblerButton1,
            R.id.tumblerButton2,
            R.id.tumblerButton3,
            R.id.tumblerButton4,
        )

        // Click Image View
        for (viewId in widgetIds) {
            val intent = Intent(context, TumblerAppWidget::class.java).apply {
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

        // Click Reset Button
        val resetIntent = Intent(context, TumblerAppWidget::class.java).apply {
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

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (WIDGET_CLICK == intent.action) {

            val viewId = intent.getIntExtra(WIDGET_VIEW_ID, 0)

            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context!!, TumblerAppWidget::class.java)
            )
            val views = RemoteViews(context.packageName, R.layout.tumbler_app_widget)

            // Toggle image between "on" and "off"
            val newState = someLogicToCheckCurrentState(context, viewId)
            val nextImage = if (newState) R.drawable.tumbler_filled else R.drawable.tumbler_empty

            views.setImageViewResource(viewId, nextImage)

            var counter = MyApplication.preferences.getStringTums(Date(), "0").toInt()

            if (nextImage == R.drawable.tumbler_filled) {
                if (counter < 4)
                    counter++
            } else {
                if (counter > 0)
                    counter--
            }

            MyApplication.preferences.setStringTums(Date(), counter.toString())

            appWidgetManager.updateAppWidget(appWidgetIds, views)
        }

        if (RESET_CLICK == intent.action) {
            val viewId = intent.getIntExtra(WIDGET_VIEW_ID, 0)

            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context!!, TumblerAppWidget::class.java)
            )
            val views = RemoteViews(context.packageName, R.layout.tumbler_app_widget)

            MyApplication.preferences.setStringTums(Date(), "0")

            views.setImageViewResource(R.id.tumblerButton1, R.drawable.tumbler_empty)
            views.setImageViewResource(R.id.tumblerButton2, R.drawable.tumbler_empty)
            views.setImageViewResource(R.id.tumblerButton3, R.drawable.tumbler_empty)
            views.setImageViewResource(R.id.tumblerButton4, R.drawable.tumbler_empty)


            val sharedPreferences =
                context.getSharedPreferences("TumsOnOff", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putBoolean(R.id.tumblerButton1.toString(), false)
                putBoolean(R.id.tumblerButton2.toString(), false)
                putBoolean(R.id.tumblerButton3.toString(), false)
                putBoolean(R.id.tumblerButton4.toString(), false)

                apply()
            }

            appWidgetManager.updateAppWidget(appWidgetIds, views)

        }
    }

    private fun someLogicToCheckCurrentState(context: Context, viewId: Int): Boolean {
        val sharedPreferences =
            context.getSharedPreferences("TumsOnOff", Context.MODE_PRIVATE)
        val currentState = sharedPreferences.getBoolean(viewId.toString(), false)
        // Toggle the state
        val newState = !currentState
        with(sharedPreferences.edit()) {
            putBoolean(viewId.toString(), newState)
            apply()
        }
        return newState
    }
}



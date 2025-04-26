package com.example.countdownwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class CountdownWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (widgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_countdown)

            val daysRemaining = CountdownUtils.getRemainingDays()
            views.setTextViewText(R.id.textBig, String.format(Constants.BIG_TEXT_TEMPLATE, daysRemaining))
            views.setTextViewText(R.id.textSmall, Constants.SMALL_TEXT_TEMPLATE)

            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.textBig, pendingIntent)
            views.setOnClickPendingIntent(R.id.textSmall, pendingIntent)

            appWidgetManager.updateAppWidget(widgetId, views)
        }
    }
}

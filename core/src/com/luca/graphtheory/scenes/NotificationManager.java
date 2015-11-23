package com.luca.graphtheory.scenes;

/**
 * Created by Sas on 11/23/2015.
 */

import com.luca.graphtheory.forms.AddEdgeNotification;
import com.luca.graphtheory.forms.ErrorNotification;
import com.luca.graphtheory.forms.Notification;
import com.luca.graphtheory.assets.Scene;
import com.luca.graphtheory.forms.SimpleNotification;

import java.util.ArrayList;

public class NotificationManager extends Scene
{

    private     ArrayList<Notification>     notifications;

    private     int                         numberOfNotifications;

    public NotificationManager()
    {

        notifications                       = new ArrayList<Notification>();

    }

    @Override
    public void render()
    {

        for(Notification notification : notifications)
        {

            notification.                   render();

        }

        boolean         update              = false;
        Notification    notification;
        for(int i = 0; i < notifications.size(); i++)
        {

            notification                    = notifications.get(i);

            if(update)
            {

                notification.               setPositionInStack(notification.getPositionInStack() - 1);
                notification.               setPositionInStackChanged(true);

            }

            if(notification.getDestroy())
            {

                notifications.              remove(notification.getPositionInStack());

                i--;

                update                      = true;

            }

        }

    }

    @Override
    public void update()
    {

        for(Notification notification : notifications)
        {

            notification.inputEvents();

        }

    }

    @Override
    public void inputEvents()
    {



    }

    //region Notification Builders

    //region Simple Notification
    public void addSimpleNotification(String message)
    {

        notifications.                      add(new SimpleNotification(notifications.size(), message));

    }

    public void addSimpleNotification(String message, float timer)
    {

        notifications.                      add(new SimpleNotification(notifications.size(), message));

        notifications.                      get(notifications.size() - 1).setTimer(timer);

    }

    public void addSimpleNotification(String message, boolean onHold)
    {

        notifications.                      add(new SimpleNotification(notifications.size(), message));

        notifications.                      get(notifications.size() - 1).setOnHold(onHold);

    }
    //endregion

    //region Error Notification
    public void addErrorNotification(String message)
    {

        notifications.                      add(new ErrorNotification(notifications.size(), message));

    }

    public void addErrorNotification(String message, float timer)
    {

        notifications.                      add(new ErrorNotification(notifications.size(), message));

        notifications.                      get(notifications.size() - 1).setTimer(timer);

    }

    public void addErrorNotification(String message, boolean onHold)
    {

        notifications.                      add(new ErrorNotification(notifications.size(), message));

        notifications.                      get(notifications.size() - 1).setOnHold(onHold);

    }
    //endregion

    //region Simple Notification
    public void addAddEdgeNotification()
    {

        notifications.                      add(new AddEdgeNotification(notifications.size()));

    }
    //endregion

    //endregion

    public ArrayList<Notification> getNotifications() { return notifications; }

}

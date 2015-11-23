package com.luca.graphtheory.scenes;

/**
 * Created by Sas on 11/23/2015.
 */

import com.luca.graphtheory.forms.Notification;
import com.luca.graphtheory.assets.Scene;
import com.luca.graphtheory.forms.TestNotification;

import java.util.ArrayList;

public class NotificationManager extends Scene
{

    private     ArrayList<Notification>     notifications;

    private     int                         numberOfNotifications;

    public NotificationManager()
    {

        notifications                       = new ArrayList<Notification>();

        addTestNotification("Test Notification 1");
        addTestNotification("Test Notification 2");

        //notifications.get(1).setOnHold(true);
        notifications.get(0).               setTimer(1f);

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



    }

    @Override
    public void inputEvents()
    {



    }

    public void addTestNotification(String message)
    {

        notifications.                      add(new TestNotification(notifications.size(), message));

    }

}

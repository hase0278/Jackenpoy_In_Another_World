package com.decastrofinalproject.jackenpoyinanotherworld;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AlertDiag {
    public static void show(Context context, int imageFromResource, String title, String neutralBtnMessage, DialogInterface.OnClickListener listener){
        AlertDialog.Builder alertadd = new AlertDialog.Builder(context);
        LayoutInflater factory = LayoutInflater.from(context);
        final View view = factory.inflate(R.layout.custom_alert_dialog, null);
        ImageView image = view.findViewById(R.id.dialog_imageview);
        image.setImageResource(imageFromResource);
        alertadd.setView(view);
        alertadd.setTitle(title);
        alertadd.setPositiveButton(neutralBtnMessage, listener);
        alertadd.show();
    }
    public static void show(Context context, String side, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener){
        String side1 = side.equals("human")?"demon":"human";
        AlertDialog.Builder alertadd = new AlertDialog.Builder(context);
        alertadd.setTitle("Change allegiance?");
        alertadd.setMessage("Change allegiance from " + side + " to " + side1 + "?");
        alertadd.setPositiveButton("Yes", positiveListener);
        alertadd.setNegativeButton("No", negativeListener);
        alertadd.show();
    }
}

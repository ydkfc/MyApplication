//package com.example.android.notepad;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.graphics.Color;
//import android.view.View;
//import android.widget.SimpleCursorAdapter;
//
//public class MyCursorAdapter extends SimpleCursorAdapter {
//
//
//    public MyCursorAdapter(Context context, int layout, Cursor c,
//                           String[] from, int[] to) {
//        super(context, layout, c, from, to);
//    }
//
//
//    @Override
//    public void bindView(View view, Context context, Cursor cursor){
//        super.bindView(view, context, cursor);
//        //从数据库中读取的cursor中获取笔记列表对应的颜色数据，并设置笔记颜色
//        int x = cursor.getInt(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_BACK_COLOR));
//
//        switch (x){
//            case NotePad.Notes.DEFAULT_COLOR:
//                view.setBackgroundColor(Color.rgb(255, 255, 255));
//                break;
//            case NotePad.Notes.YELLOW_COLOR:
//                view.setBackgroundColor(Color.rgb(247, 216, 133));
//                break;
//            case NotePad.Notes.BLUE_COLOR:
//                view.setBackgroundColor(Color.rgb(165, 202, 237));
//                break;
//            case NotePad.Notes.GREEN_COLOR:
//                view.setBackgroundColor(Color.rgb(161, 214, 174));
//                break;
//            case NotePad.Notes.RED_COLOR:
//                view.setBackgroundColor(Color.rgb(244, 149, 133));
//                break;
//            default:
//                view.setBackgroundColor(Color.rgb(255, 255, 255));
//                break;
//        }
//    }
//}
//
package com.example.android.notepad;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.View;
import android.widget.SimpleCursorAdapter;

public class MyCursorAdapter extends SimpleCursorAdapter {
    public MyCursorAdapter(Context context, int layout, Cursor c,
                           String[] from, int[] to) {
        super(context, layout, c, from, to);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor){
        super.bindView(view, context, cursor);
        //Get the color data corresponding to the note list from the cursor read from the database, and set the note color

        int x = cursor.getInt(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_BACK_COLOR));
        /**
         * white 255 255 255
         * yellow 247 216 133
         * blue 165 202 237
         * green 161 214 174
         * red 244 149 133
         */
        switch (x){
            case NotePad.Notes.DEFAULT_COLOR:
                view.setBackgroundColor(Color.rgb(255, 255, 255));
                break;
            case NotePad.Notes.YELLOW_COLOR:
                view.setBackgroundColor(Color.rgb(247, 216, 133));
                break;
            case NotePad.Notes.BLUE_COLOR:
                view.setBackgroundColor(Color.rgb(165, 202, 237));
                break;
            case NotePad.Notes.GREEN_COLOR:
                view.setBackgroundColor(Color.rgb(161, 214, 174));
                break;
            case NotePad.Notes.RED_COLOR:
                view.setBackgroundColor(Color.rgb(244, 149, 133));
                break;
            default:
                view.setBackgroundColor(Color.rgb(255, 255, 255));
                break;
        }
    }
}
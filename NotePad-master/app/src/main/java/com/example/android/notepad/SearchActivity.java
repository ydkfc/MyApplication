package com.example.android.notepad;

import android.app.ListActivity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;

public class SearchActivity extends ListActivity implements SearchView.OnQueryTextListener {
    SearchView searchView;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_search);
        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
        Intent intent = getIntent();
        if (intent.getData() == null) {
            intent.setData(NotePad.Notes.CONTENT_URI);
        }
        getListView().setOnCreateContextMenuListener(this);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
    }
    @Override
    public boolean onQueryTextSubmit(String query){
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        String selection = NotePad.Notes.COLUMN_NAME_TITLE + " Like ? ";//查询条件
        String[] selectionArgs = { "%"+newText+"%" };//查询条件参数，配合selection参数使用,%通配多个字符
        String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE, NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE} ;
        int[] viewIDs = { android.R.id.text1,android.R.id.text2};
        cursor = managedQuery(
                getIntent().getData(),            // Use the default content URI for the provider.
                PROJECTION,                       // Return the note ID and title for each note.
//                null,
//                null,
                selection,                             // No where clause, return all records.
                selectionArgs,                             // No where clause, therefore no where column values.
                NotePad.Notes.DEFAULT_SORT_ORDER  // Use the default sort order.
        );
        adapter = new SimpleCursorAdapter(
                this,                             // The Context for the ListView
                R.layout.noteslist_item,          // Points to the XML for a list item
                cursor,                           // The cursor to get items from
                dataColumns,
                viewIDs
        );
        setListAdapter(adapter);
        return true;
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Uri uri = ContentUris.withAppendedId(getIntent().getData(), id);
        String action = getIntent().getAction();
        if (Intent.ACTION_PICK.equals(action) || Intent.ACTION_GET_CONTENT.equals(action)) {
            setResult(RESULT_OK, new Intent().setData(uri));
        } else {
            startActivity(new Intent(Intent.ACTION_EDIT, uri));
        }
    }
}
